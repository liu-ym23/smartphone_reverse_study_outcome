package android.aimedia;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaServiceCapabilities implements Parcelable {
    public static final Parcelable.Creator<MediaServiceCapabilities> CREATOR = null;
    public String fieldVisibilityPolicy;
    public int maxFieldBytes;
    public int maxFieldsPerEvent;
    public long maxQueryWindowMs;
    public int maxResults;
    public int serviceVersion;
    public List<String> supportedEventTypes;
    public List<String> supportedFilters;
    public List<String> supportedMediaTypes;
    public List<String> supportedOrigins;
    public List<String> supportedSources;
    public boolean supportsQuery;
    public boolean supportsSubmit;
    public boolean supportsSubscribe;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaServiceCapabilities() {
        this.serviceVersion = 0;
        this.supportsSubmit = false;
        this.supportsQuery = false;
        this.supportsSubscribe = false;
        this.maxFieldsPerEvent = 0;
        this.maxFieldBytes = 0;
        this.maxResults = 0;
        this.maxQueryWindowMs = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L127;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.serviceVersion = r8.readInt();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.supportedOrigins = r8.createStringArrayList();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        this.supportedSources = r8.createStringArrayList();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L33;
        this.supportedMediaTypes = r8.createStringArrayList();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L41;
        this.supportedEventTypes = r8.createStringArrayList();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L49;
        this.supportedFilters = r8.createStringArrayList();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L57;
        this.supportsSubmit = r8.readBoolean();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L65;
        this.supportsQuery = r8.readBoolean();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L73;
        this.supportsSubscribe = r8.readBoolean();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L81;
        this.maxFieldsPerEvent = r8.readInt();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L89;
        this.maxFieldBytes = r8.readInt();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L97;
        this.maxResults = r8.readInt();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L105;
        this.maxQueryWindowMs = r8.readLong();     // Catch: Throwable -> L124
        if ((r8.dataPosition() - r0) >= r1) goto L113;
        this.fieldVisibilityPolicy = r8.readString();     // Catch: Throwable -> L124
        if (r0 > (Integer.MAX_VALUE - r1)) goto L123;
        r8.setDataPosition(r0 + r1);
        return;
    L123:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L113:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L116;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L116:
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
    L127:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L124
    L124:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L131;
        r8.setDataPosition(r0 + r1);
        throw th;
    L131:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeInt(this.serviceVersion);
        r3.writeStringList(this.supportedOrigins);
        r3.writeStringList(this.supportedSources);
        r3.writeStringList(this.supportedMediaTypes);
        r3.writeStringList(this.supportedEventTypes);
        r3.writeStringList(this.supportedFilters);
        r3.writeBoolean(this.supportsSubmit);
        r3.writeBoolean(this.supportsQuery);
        r3.writeBoolean(this.supportsSubscribe);
        r3.writeInt(this.maxFieldsPerEvent);
        r3.writeInt(this.maxFieldBytes);
        r3.writeInt(this.maxResults);
        r3.writeLong(this.maxQueryWindowMs);
        r3.writeString(this.fieldVisibilityPolicy);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
