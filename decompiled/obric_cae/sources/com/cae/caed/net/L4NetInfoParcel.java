package com.cae.caed.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class L4NetInfoParcel implements Parcelable {
    public static final Parcelable.Creator<L4NetInfoParcel> CREATOR = null;
    public long cookie;
    public String dstIP;
    public int dstPort;
    public int family;
    public String ifName;
    public String srcIP;
    public int srcPort;
    public int state;
    public long tcpRecvBytes;
    public int tcpRecvOoopack;
    public int tcpRtt;
    public long tcpSendBytes;
    public int tcpSndCwnd;
    public int tcpSndSsthresh;
    public int tcpTotalDataSegsIn;
    public int tcpTotalDataSegsOut;
    public int tcpTotalRetrans;
    public int tcpTotalSegsIn;
    public int tcpTotalSegsOut;
    public int tcpiUnacked;
    public int uid;

    public class a implements Parcelable.Creator<L4NetInfoParcel> {
        @Override // android.os.Parcelable.Creator
        public final L4NetInfoParcel createFromParcel(Parcel r8) {
            L4NetInfoParcel r10 = new L4NetInfoParcel();
            r10.readFromParcel(r8);
            return r10;
        }

        @Override // android.os.Parcelable.Creator
        public final L4NetInfoParcel[] newArray(int r8) {
            return new L4NetInfoParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public L4NetInfoParcel() {
        this.family = 0;
        this.state = 0;
        this.srcPort = 0;
        this.dstPort = 0;
        this.uid = 0;
        this.tcpSendBytes = 0;
        this.tcpRecvBytes = 0;
        this.tcpRtt = 0;
        this.tcpTotalRetrans = 0;
        this.tcpTotalDataSegsOut = 0;
        this.tcpTotalDataSegsIn = 0;
        this.tcpiUnacked = 0;
        this.tcpRecvOoopack = 0;
        this.tcpTotalSegsOut = 0;
        this.tcpTotalSegsIn = 0;
        this.tcpSndSsthresh = 0;
        this.tcpSndCwnd = 0;
        this.cookie = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 < 4) goto L183;
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.ifName = r8.readString();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L17;
        this.family = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L25;
        this.state = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L33;
        this.srcIP = r8.readString();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L41;
        this.dstIP = r8.readString();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L49;
        this.srcPort = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L57;
        this.dstPort = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L65;
        this.uid = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L73;
        this.tcpSendBytes = r8.readLong();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L81;
        this.tcpRecvBytes = r8.readLong();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L89;
        this.tcpRtt = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L97;
        this.tcpTotalRetrans = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L105;
        this.tcpTotalDataSegsOut = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L113;
        this.tcpTotalDataSegsIn = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L121;
        this.tcpiUnacked = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L129;
        this.tcpRecvOoopack = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L137;
        this.tcpTotalSegsOut = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L145;
        this.tcpTotalSegsIn = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L153;
        this.tcpSndSsthresh = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L161;
        this.tcpSndCwnd = r8.readInt();     // Catch: Throwable -> L180
        if ((r8.dataPosition() - r10) >= r11) goto L169;
        this.cookie = r8.readLong();     // Catch: Throwable -> L180
        if (r10 > (Integer.MAX_VALUE - r11)) goto L179;
        r8.setDataPosition(r10 + r11);
        return;
    L179:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L169:
        if (r10 > (Integer.MAX_VALUE - r11)) goto L172;
    L9:
        r8.setDataPosition(r10 + r11);
        return;
    L172:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L161:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L153:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L145:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L137:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L129:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L121:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L113:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L105:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L97:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L89:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L81:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L73:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L65:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L57:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L49:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L41:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L25:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L183:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L180
    L180:
        th = move-exception;
        if (r10 > (Integer.MAX_VALUE - r11)) goto L187;
        r8.setDataPosition(r10 + r11);
        throw th;
    L187:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeString(this.ifName);
        r8.writeInt(this.family);
        r8.writeInt(this.state);
        r8.writeString(this.srcIP);
        r8.writeString(this.dstIP);
        r8.writeInt(this.srcPort);
        r8.writeInt(this.dstPort);
        r8.writeInt(this.uid);
        r8.writeLong(this.tcpSendBytes);
        r8.writeLong(this.tcpRecvBytes);
        r8.writeInt(this.tcpRtt);
        r8.writeInt(this.tcpTotalRetrans);
        r8.writeInt(this.tcpTotalDataSegsOut);
        r8.writeInt(this.tcpTotalDataSegsIn);
        r8.writeInt(this.tcpiUnacked);
        r8.writeInt(this.tcpRecvOoopack);
        r8.writeInt(this.tcpTotalSegsOut);
        r8.writeInt(this.tcpTotalSegsIn);
        r8.writeInt(this.tcpSndSsthresh);
        r8.writeInt(this.tcpSndCwnd);
        r8.writeLong(this.cookie);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
