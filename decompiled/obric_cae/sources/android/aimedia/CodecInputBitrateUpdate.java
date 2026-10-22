package android.aimedia;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class CodecInputBitrateUpdate implements Parcelable {
    public static final Parcelable.Creator<CodecInputBitrateUpdate> CREATOR = null;
    public long codecInputBitrateBps;
    public long codecInputBitrateBps5s;
    public String codecName;
    public boolean encoder;
    public long eventTimeMs;
    public int frameRate;
    public int height;
    public boolean lowLatency;
    public String mimeType;
    public int renderFrameRate;
    public boolean secure;
    public String sessionId;
    public long sourceBitrateBps;
    public long sourceDurationUs;
    public boolean surfaceToScreen;
    public int width;

    static {
        CREATOR = new AnonymousClass1();
    }

    public CodecInputBitrateUpdate() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 >= 0) goto L73;
        return;
    L73:
        this.codecName = r8.readString();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) < r11) goto L10;
    L8:
        r8.setDataPosition(r10 + r11);
        return;
    L10:
        this.mimeType = r8.readString();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.sessionId = r8.readString();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        boolean r12 = true;
        if (r8.readInt() == 0) goto L19;
        boolean r13 = true;
    L20:
        this.encoder = r13;     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() == 0) goto L26;
        boolean r14 = true;
    L27:
        this.secure = r14;     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() == 0) goto L33;
        boolean r15 = true;
    L34:
        this.lowLatency = r15;     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() != 0) goto L41;
        r12 = false;
    L41:
        this.surfaceToScreen = r12;     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.width = r8.readInt();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.height = r8.readInt();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.frameRate = r8.readInt();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.sourceBitrateBps = r8.readLong();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.sourceDurationUs = r8.readLong();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.renderFrameRate = r8.readInt();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.codecInputBitrateBps = r8.readLong();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.codecInputBitrateBps5s = r8.readLong();     // Catch: Throwable -> L70
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.eventTimeMs = r8.readLong();     // Catch: Throwable -> L70
        int r16 = r8.dataPosition() - r10;
        goto L8
    L33:
        r15 = false;
        goto L34
    L26:
        r14 = false;
        goto L27
    L19:
        r13 = false;
    L70:
        th = move-exception;
        r8.setDataPosition(r10 + r11);
        throw th;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeString(this.codecName);
        r8.writeString(this.mimeType);
        r8.writeString(this.sessionId);
        r8.writeInt(this.encoder ? 1 : 0);
        r8.writeInt(this.secure ? 1 : 0);
        r8.writeInt(this.lowLatency ? 1 : 0);
        r8.writeInt(this.surfaceToScreen ? 1 : 0);
        r8.writeInt(this.width);
        r8.writeInt(this.height);
        r8.writeInt(this.frameRate);
        r8.writeLong(this.sourceBitrateBps);
        r8.writeLong(this.sourceDurationUs);
        r8.writeInt(this.renderFrameRate);
        r8.writeLong(this.codecInputBitrateBps);
        r8.writeLong(this.codecInputBitrateBps5s);
        r8.writeLong(this.eventTimeMs);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        a.n(r12, r11, r8, r12);
    }
}
