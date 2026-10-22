package com.ss.ttvideoengine.utils;

import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SntpClient {
    private static final int NTP_LEAP_NOSYNC = 3;
    private static final int NTP_MODE_BROADCAST = 5;
    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_MODE_SERVER = 4;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_STRATUM_DEATH = 0;
    private static final int NTP_STRATUM_MAX = 15;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 2208988800L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final String TAG = "SntpClient";
    private static final int TRANSMIT_TIME_OFFSET = 40;
    private long mNtpTime;
    private long mNtpTimeReference;
    private long mRoundTripTime;

    public static class InvalidServerReplyException extends Exception {
        public InvalidServerReplyException(String r1) {
            super(r1);
        }
    }

    public SntpClient() {
    }

    public long getNtpTime() {
        return this.mNtpTime;
    }

    public long getNtpTimeReference() {
        return this.mNtpTimeReference;
    }

    public long getRoundTripTime() {
        return this.mRoundTripTime;
    }

    private long read32(byte[] r6, int r7) {
        int r0 = r6[r7];
        int r1 = r6[r7 + 1];
        int r2 = r6[r7 + 2];
        int r8 = r6[r7 + 3];
        if ((r0 & 128) != 128) goto L6;
        r0 = (r0 & 127) + 128;
    L6:
        if ((r1 & 128) != 128) goto L9;
        r1 = (r1 & 127) + 128;
    L9:
        if ((r2 & 128) != 128) goto L12;
        r2 = (r2 & 127) + 128;
    L12:
        if ((r8 & 128) != 128) goto L15;
        r8 = (r8 & 127) + 128;
    L15:
        return (((((long) r0) << 24) + (((long) r1) << 16)) + (((long) r2) << 8)) + ((long) r8);
    }

    private long readTimeStamp(byte[] r6, int r7) {
        long r0 = read32(r6, r7);
        long r8 = read32(r6, r7 + 4);
        if (r0 != 0) goto L8;
        if (r8 != 0) goto L8;
        return 0;
    L8:
        return ((r0 - OFFSET_1900_TO_1970) * 1000) + ((r8 * 1000) / 4294967296L);
    }

    public boolean requestTime(String r2, int r3) {
        return requestTime(InetAddress.getByName(r2), NTP_PORT, r3);
    L5:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return false;
    }

    private void writeTimeStamp(byte[] r12, int r13, long r14) {
        if (r14 != 0) goto L6;
        Arrays.fill(r12, r13, r13 + 8, (byte) 0);
        return;
    L6:
        long r3 = r14 / 1000;
        long r15 = r14 - (r3 * 1000);
        long r4 = r3 + OFFSET_1900_TO_1970;
        int r5 = r13 + 1;
        r12[r13] = (byte) (r4 >> 24);
        int r16 = r5 + 1;
        r12[r5] = (byte) (r4 >> 16);
        int r6 = r16 + 1;
        r12[r16] = (byte) (r4 >> 8);
        int r17 = r6 + 1;
        r12[r6] = (byte) (r4 >> 0);
        long r18 = (r15 * 4294967296L) / 1000;
        int r0 = r17 + 1;
        r12[r17] = (byte) (r18 >> 24);
        int r19 = r0 + 1;
        r12[r0] = (byte) (r18 >> 16);
        r12[r19] = (byte) (r18 >> 8);
        r12[r19 + 1] = (byte) (Math.random() * 255.0d);
    }

    public boolean requestTime(InetAddress r23, int r24, int r25) {
        DatagramSocket r3 = null;
        DatagramSocket r4 = new DatagramSocket();     // Catch: Throwable -> L20 Exception -> L22
        r4.setSoTimeout(r25);     // Catch: Throwable -> L14 Exception -> L17
        byte[] r5 = new byte[NTP_PACKET_SIZE];     // Catch: Throwable -> L14 Exception -> L17
        DatagramPacket r6 = new DatagramPacket(r5, NTP_PACKET_SIZE, r23, r24);     // Catch: Throwable -> L14 Exception -> L17
        r5[0] = 27;     // Catch: Throwable -> L14 Exception -> L17
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L14 Exception -> L17
        long r9 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14 Exception -> L17
        writeTimeStamp(r5, TRANSMIT_TIME_OFFSET, r7);     // Catch: Throwable -> L14 Exception -> L17
        r4.send(r6);     // Catch: Throwable -> L14 Exception -> L17
        r4.receive(new DatagramPacket(r5, NTP_PACKET_SIZE));     // Catch: Throwable -> L14 Exception -> L17
        long r12 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14 Exception -> L17
        long r10 = r12 - r9;     // Catch: Throwable -> L14 Exception -> L17
        long r8 = r7 + r10;     // Catch: Throwable -> L14 Exception -> L17
        byte r11 = r5[0];     // Catch: Throwable -> L14 Exception -> L17
        byte r13 = (byte) ((r11 >> 6) & 3);     // Catch: Throwable -> L14 Exception -> L17
        byte r14 = (byte) (r11 & 7);     // Catch: Throwable -> L14 Exception -> L17
        int r15 = r5[1] & 255;     // Catch: Throwable -> L14 Exception -> L17
        long r16 = readTimeStamp(r5, ORIGINATE_TIME_OFFSET);     // Catch: Throwable -> L14 Exception -> L17
        long r18 = readTimeStamp(r5, RECEIVE_TIME_OFFSET);     // Catch: Throwable -> L14 Exception -> L17
        DatagramSocket r2 = r4;
        long r17 = readTimeStamp(r5, TRANSMIT_TIME_OFFSET);     // Catch: Throwable -> L10 Exception -> L12
        checkValidServerReply(r13, r14, r15, r17);     // Catch: Throwable -> L10 Exception -> L12
        long r19 = r10 - (r17 - r18);     // Catch: Throwable -> L10 Exception -> L12
        long r20 = ((r18 - r16) + (r17 - r8)) / 2;     // Catch: Throwable -> L10 Exception -> L12
        TTVideoEngineLog.d(TAG, "requestTime round trip: " + r19 + "ms, clock offset: " + r20 + "ms");     // Catch: Throwable -> L10 Exception -> L12
        this.mNtpTime = r8 + r20;     // Catch: Throwable -> L10 Exception -> L12
        this.mNtpTimeReference = r12;     // Catch: Throwable -> L10 Exception -> L12
        this.mRoundTripTime = r19;     // Catch: Throwable -> L10 Exception -> L12
        r2.close();
        return true;
    L12:
        e = e;
    L19:
        r3 = r2;
    L23:
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L20
        if (r3 == null) goto L39;
        r3.close();
        return false;
    L39:
        return false;
    L10:
        th = th;
    L16:
        r3 = r2;
    L28:
        if (r3 == null) goto L30;
        r3.close();
    L30:
        throw th;
    L17:
        e = e;
        r2 = r4;
    L14:
        th = th;
        r2 = r4;
    L20:
        th = th;
    L22:
        e = e;
        goto L23
    }

    private static void checkValidServerReply(byte r1, byte r2, int r3, long r4) throws InvalidServerReplyException {
        if (r1 == 3) goto L22;
        if (r2 != 4) goto L7;
    L11:
        if (r3 == 0) goto L20;
        if (r3 > 15) goto L20;
        if (r4 == 0) goto L18;
        return;
    L18:
        throw new InvalidServerReplyException("zero transmitTime");
    L20:
        throw new InvalidServerReplyException("untrusted stratum: " + r3);
    L7:
        if (r2 == 5) goto L11;
        throw new InvalidServerReplyException("untrusted mode: " + r2);
    L22:
        throw new InvalidServerReplyException("unsynchronized server");
    }
}
