package com.obric.sva.sdk.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.controller.BreathUtils;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.data.ISmModel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J0\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u0018\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0007J \u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0007J \u0010'\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0007J \u0010+\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0015H\u0007J\u0018\u0010.\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020*2\u0006\u0010/\u001a\u00020*H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/sva/sdk/utils/FileKt;", "", "<init>", "()V", "TAG", "", "WAV_HEADER_LENGTH", "", "saveByteToFile", "", "buffer", "", "bufferSize", "filePath", "pcm", "", "writeBufferToWavFile", "inBuff", "isAppendToFile", "getWavHeader", "audioDataLength", "", "audioDataAndHeaderLength", "readWavFileToByte", "readBinaryFile", "fileName", "readWavFile", "Ljava/nio/ShortBuffer;", "isSameMD5", "source", "Ljava/io/InputStream;", "target", "recordBreathToWaveFromStream", "outputStream", "Ljava/io/ByteArrayOutputStream;", "sessionId", "saveIntToFile", "", "size", "saveStereoToFile", "deleteContents", "dir", "Ljava/io/File;", "deleteOlderFiles", "minCount", "minAgeMs", "copyFile", "destination", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class FileKt {
    public static final FileKt INSTANCE = null;
    private static final String TAG = null;
    public static final int WAV_HEADER_LENGTH = 44;

    private FileKt() {
    }

    public static /* synthetic */ int a(File r0, File r1) {
        return deleteOlderFiles$lambda$5(r0, r1);
    }

    public static /* synthetic */ int b(Function2 r0, Object r1, Object r2) {
        return deleteOlderFiles$lambda$6(r0, r1, r2);
    }

    @JvmStatic
    public static final byte[] getWavHeader(long r16, long r18) {
        return new byte[]{82, 73, 70, 70, (byte) (r18 & 255), (byte) ((r18 >> 8) & 255), (byte) ((r18 >> 16) & 255), (byte) ((r18 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, 1, 0, (byte) 128, (byte) 62, (byte) 0, (byte) 0, (byte) 0, (byte) 125, (byte) 0, (byte) 0, 2, 0, 16, 0, 100, 97, 116, 97, (byte) (r16 & 255), (byte) ((r16 >> 8) & 255), (byte) ((r16 >> 16) & 255), (byte) ((r16 >> 24) & 255)};
    }

    static {
        INSTANCE = new FileKt();
        TAG = "FileKt";
    }

    @JvmStatic
    public static final boolean deleteContents(File r4) {
        Intrinsics.checkNotNullParameter(r4, "dir");
        File[] r5 = r4.listFiles();
        boolean r0 = true;
        if (r5 == null) goto L13;
        Iterator r6 = ArrayIteratorKt.iterator(r5);
    L6:
        if (r6.hasNext() == false) goto L13;
        File r1 = (File) r6.next();
        if (r1.isDirectory() == false) goto L11;
        Intrinsics.checkNotNull(r1);
        r0 = r0 & deleteContents(r1);
    L11:
        if (r1.delete() == true) goto L6;
        LogUtils.v(TAG, "Failed to delete " + r1, new Object[0]);
        r0 = false;
    L13:
        return r0;
    }

    @JvmStatic
    public static final byte[] readBinaryFile(String r6) {
        byte[] r0 = null;
        BufferedInputStream r1 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r6));     // Catch: IOException -> L8
        r0 = new byte[r1.available()];     // Catch: IOException -> L8
        byte[] r7 = new byte[ISmModel.VERSION_0400];     // Catch: IOException -> L8
        int r3 = 0;
    L4:
        int r4 = r1.read(r7);     // Catch: IOException -> L8
        if (r4 == (-1)) goto L10;
        System.arraycopy(r7, 0, r0, r3, r4);     // Catch: IOException -> L8
        r3 = r3 + r4;
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @JvmStatic
    public static final ShortBuffer readWavFile(String r7) throws IOException {
        int r0 = 0;
        if (r7 == null) goto L5;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r7);
        if (r1.exists() == false) goto L29;
        RandomAccessFile r8 = new RandomAccessFile(r1, "r");
        r8.skipBytes(44);     // Catch: Throwable -> L23
        long r2 = r8.length();     // Catch: Throwable -> L23
        if (((int) r2) != r2) goto L22;
        int r3 = (((int) (r2 - ((long) 44))) + 1) / 2;     // Catch: Throwable -> L23
        short[] r4 = new short[r3];     // Catch: Throwable -> L23
    L12:
        if (r0 >= r3) goto L18;
        if (Intrinsics.areEqual(ByteOrder.LITTLE_ENDIAN, ByteOrder.nativeOrder()) == false) goto L16;
        short r5 = r8.readShort();     // Catch: Throwable -> L23
        short r6 = (short) ((r5 & 255) << 8);     // Catch: Throwable -> L23
        r4[r0] = r6;     // Catch: Throwable -> L23
        r4[r0] = (short) (r6 + ((r5 & 65280) >> 8));     // Catch: Throwable -> L23
    L17:
        r0 = r0 + 1;     // Catch: Throwable -> L23
        goto L12
    L16:
        r4[r0] = r8.readShort();     // Catch: Throwable -> L23
        goto L17
    L18:
        ShortBuffer r9 = ShortBuffer.allocate(r3);     // Catch: Throwable -> L23
        r9.put(r4);     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r8, null);
        return r9;
    L22:
        throw new IOException("File size >= 2 GB");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L29:
        throw new FileNotFoundException();
    L5:
        return ShortBuffer.allocate(0);
    }

    @JvmStatic
    public static final byte[] readWavFileToByte(String r6) throws IOException {
        RandomAccessFile r7 = new RandomAccessFile(new PolarisFileWrapper(r6), "r");
        r7.skipBytes(44);     // Catch: Throwable -> L10
        long r1 = r7.length();     // Catch: Throwable -> L10
        if (((int) r1) != r1) goto L9;
        byte[] r0 = new byte[(int) (r1 - ((long) 44))];     // Catch: Throwable -> L10
        r7.read(r0);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r7, null);
        return r0;
    L9:
        throw new IOException("File size >= 2 GB");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    @JvmStatic
    public static final void copyFile(File r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "destination");
        if (r3.exists() == true) goto L6;
        return;
    L6:
        if (r3.isDirectory() == false) goto L9;
        return;
    L9:
        if (r4.exists() == false) goto L11;
        r4.delete();
    L11:
        PolarisFileInputStreamWrapper r0 = new PolarisFileInputStreamWrapper(r3);
        PolarisFileOutputStreamWrapper r5 = new PolarisFileOutputStreamWrapper(r4);     // Catch: Throwable -> L28
        byte[] r6 = new byte[ISmModel.VERSION_0400];     // Catch: Throwable -> L23
    L15:
        int r1 = r0.read(r6);     // Catch: Throwable -> L23
        if (r1 <= 0) goto L18;
        r5.write(r6, 0, r1);     // Catch: Throwable -> L23
        goto L15
    L18:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L20:
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r0, null);
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    private static final int deleteOlderFiles$lambda$5(File r2, File r3) {
        return Long.compare(r3.lastModified(), r2.lastModified());
    }

    @JvmStatic
    public static final boolean isSameMD5(InputStream r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "target");
        if (new PolarisFileWrapper(r7).exists() == false) goto L6;
        String r0 = KtUtils.md5(r6);
        String r2 = KtUtils.md5(r7);
        LogUtils.d(TAG, "isSameMD5 : source " + r6 + " [" + r0 + "] vs target " + r7 + " [" + r2 + ']', new Object[0]);
        return StringsKt.equals(r0, r2, true);
    L6:
        return false;
    }

    @JvmStatic
    public static final void recordBreathToWaveFromStream(ByteArrayOutputStream r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "outputStream");
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        BreathUtils r0 = BreathUtils.INSTANCE;
        if (rna.c.c(r0.getBREATH_LOCAL_DIR()) == true) goto L6;
        rna.c.a(r0.getBREATH_LOCAL_DIR());
    L6:
        if (r8.size() <= 0) goto L21;
        String r4 = r0.getBREATH_LOCAL_DIR() + File.separator + KtUtils.INSTANCE.getNow() + '_' + r9 + Global.SUFFIX_WAV_FILE;
        if (r4 == null) goto L17;
        PolarisFileWrapper r10 = new PolarisFileWrapper(r4);
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L12:
        if (r10.exists() == true) goto L17;
        r10.createNewFile();     // Catch: IOException -> L15
    L17:
        saveByteToFile$default(r8.toByteArray(), r8.size(), r4, false, 8, null);
        return;
    }

    @JvmStatic
    public static final boolean deleteOlderFiles(File r9, int r10, long r11) {
        Intrinsics.checkNotNullParameter(r9, "dir");
        if (r10 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L22;
        File[] r12 = r9.listFiles();
        if (r12 != null) goto L12;
        return false;
    L12:
        Arrays.sort(r12, new b(new a()));
        int r3 = r12.length;
        boolean r4 = false;
    L13:
        if (r10 >= r3) goto L20;
        File r5 = r12[r10];
        if ((System.currentTimeMillis() - r5.lastModified()) <= r11) goto L19;
        if (r5.delete() == false) goto L19;
        LogUtils.v(TAG, "Deleted old file " + r5, new Object[0]);
        r4 = true;
    L19:
        r10 = r10 + 1;
        goto L13
    L20:
        return r4;
    L22:
        throw new IllegalArgumentException("Constraints must be positive or 0".toString());
    L5:
        if (r11 < 0) goto L7;
        r2 = true;
        goto L8
    }

    private static final int deleteOlderFiles$lambda$6(Function2 r0, Object r1, Object r2) {
        return ((Number) r0.invoke(r1, r2)).intValue();
    }

    @JvmStatic
    public static final void saveIntToFile(int[] r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "buffer");
        Intrinsics.checkNotNullParameter(r8, "filePath");
        boolean r1 = false;
        LogUtils.v(TAG, "saveIntToFile size " + r7 + " to path " + r8, new Object[0]);
        StringBuilder r9 = new StringBuilder();
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r9.append(String.valueOf(r6[r2]));
        r9.append(",");
        r2 = r2 + 1;
        goto L3
    L6:
        if (r9.length() <= 0) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        r9.setLength(r9.length() - 1);
    L10:
        byte[] r3 = r9.toString().getBytes(Charsets.UTF_8);
        INSTANCE.writeBufferToWavFile(r3, r3.length, r8, false, true);
    }

    @JvmStatic
    public static final void saveStereoToFile(byte[] r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "buffer");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        LogUtils.v(TAG, "saveStereoToFile size " + r10 + " to path " + r11, new Object[0]);
        INSTANCE.writeBufferToWavFile(r9, r10, r11, false, true);
    }

    @JvmStatic
    public static final void saveByteToFile(byte[] r9, int r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "buffer");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        LogUtils.v(TAG, "saveHotWordRecording filePath = " + r11 + " with bufferSize " + r10, new Object[0]);
        INSTANCE.writeBufferToWavFile(r9, r10, r11, false, r12);
    }

    private final void writeBufferToWavFile(byte[] r11, int r12, String r13, boolean r14, boolean r15) {
        DataOutputStream r6 = null;
        String r7 = TAG;     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L27
        LogUtils.v(r7, "writeBufferToWavFile: stream created bufferSize " + r12 + " pcm ? " + r15, new Object[0]);     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L27
        DataOutputStream r4 = new DataOutputStream(new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r13, r14)));     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L27
    L48:
        if (r15 == false) goto L7;
        LogUtils.v(r7, "writeBufferToWavFile: write pcm " + r12 + " bytes", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r4.write(r11, 0, r12);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        LogUtils.v(r7, "writeBufferToWavFile: pcm complete", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
    L8:
        r4.flush();     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r4.close();     // Catch: IOException -> L11
        LogUtils.v(r7, "writeBufferToWavFile: stream close", new Object[0]);     // Catch: IOException -> L11
    L43:
        return;
    L7:
        byte[] r16 = getWavHeader(r12, r12 + 44);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        LogUtils.v(r7, "writeBufferToWavFile: write header", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r4.write(r16);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        LogUtils.v(r7, "writeBufferToWavFile: write " + r12 + " bytes", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r4.write(r11, 0, r12);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        LogUtils.v(r7, "writeBufferToWavFile: complete", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
    L17:
        e = e;
        r6 = r4;
    L28:
        String r17 = TAG;     // Catch: Throwable -> L19
        LogUtils.e(r17, "writeShortBufferToWavFile: FileNotFound: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L19
        if (r6 == null) goto L31;
        r6.close();     // Catch: IOException -> L11
    L31:
        LogUtils.v(r17, "writeBufferToWavFile: stream close", new Object[0]);     // Catch: IOException -> L11
    L15:
        e = e;
        r6 = r4;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r6 == null) goto L25;
        r6.close();     // Catch: IOException -> L11
    L25:
        LogUtils.v(TAG, "writeBufferToWavFile: stream close", new Object[0]);     // Catch: IOException -> L11
    L13:
        th = th;
        r6 = r4;
    L33:
        if (r6 != null) goto L41;
    L37:
        LogUtils.v(TAG, "writeBufferToWavFile: stream close", new Object[0]);     // Catch: IOException -> L35
    L40:
        throw th;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L41:
        r6.close();     // Catch: IOException -> L35
    L19:
        th = th;
    L27:
        e = e;
    L21:
        e = e;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L43
    }

    public static /* synthetic */ void saveByteToFile$default(byte[] r0, int r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L5;
        r3 = false;
    L5:
        saveByteToFile(r0, r1, r2, r3);
    }
}
