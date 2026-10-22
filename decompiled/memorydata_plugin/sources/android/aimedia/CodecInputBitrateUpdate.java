package android.aimedia;

import android.os.BadParcelableException;
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
        this.encoder = false;
        this.secure = false;
        this.lowLatency = false;
        this.surfaceToScreen = false;
        this.width = 0;
        this.height = 0;
        this.frameRate = 0;
        this.sourceBitrateBps = 0;
        this.sourceDurationUs = 0;
        this.renderFrameRate = 0;
        this.codecInputBitrateBps = 0;
        this.codecInputBitrateBps5s = 0;
        this.eventTimeMs = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L143;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.codecName = r8.readString();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.mimeType = r8.readString();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        this.sessionId = r8.readString();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L33;
        this.encoder = r8.readBoolean();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L41;
        this.secure = r8.readBoolean();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L49;
        this.lowLatency = r8.readBoolean();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L57;
        this.surfaceToScreen = r8.readBoolean();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L65;
        this.width = r8.readInt();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L73;
        this.height = r8.readInt();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L81;
        this.frameRate = r8.readInt();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L89;
        this.sourceBitrateBps = r8.readLong();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L97;
        this.sourceDurationUs = r8.readLong();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L105;
        this.renderFrameRate = r8.readInt();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L113;
        this.codecInputBitrateBps = r8.readLong();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L121;
        this.codecInputBitrateBps5s = r8.readLong();     // Catch: Throwable -> L140
        if ((r8.dataPosition() - r0) >= r1) goto L129;
        this.eventTimeMs = r8.readLong();     // Catch: Throwable -> L140
        if (r0 > (Integer.MAX_VALUE - r1)) goto L139;
        r8.setDataPosition(r0 + r1);
        return;
    L139:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L129:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L132;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L132:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L121:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L113:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L105:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L97:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L89:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L81:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L73:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L65:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L57:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L49:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L41:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L25:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L143:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L140
    L140:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L147;
        r8.setDataPosition(r0 + r1);
        throw th;
    L147:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeString(this.codecName);
        r3.writeString(this.mimeType);
        r3.writeString(this.sessionId);
        r3.writeBoolean(this.encoder);
        r3.writeBoolean(this.secure);
        r3.writeBoolean(this.lowLatency);
        r3.writeBoolean(this.surfaceToScreen);
        r3.writeInt(this.width);
        r3.writeInt(this.height);
        r3.writeInt(this.frameRate);
        r3.writeLong(this.sourceBitrateBps);
        r3.writeLong(this.sourceDurationUs);
        r3.writeInt(this.renderFrameRate);
        r3.writeLong(this.codecInputBitrateBps);
        r3.writeLong(this.codecInputBitrateBps5s);
        r3.writeLong(this.eventTimeMs);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
