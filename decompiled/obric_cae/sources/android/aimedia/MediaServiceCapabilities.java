package android.aimedia;

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
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 >= 0) goto L63;
        return;
    L63:
        this.serviceVersion = r8.readInt();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) < r11) goto L10;
    L8:
        r8.setDataPosition(r10 + r11);
        return;
    L10:
        this.supportedOrigins = r8.createStringArrayList();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.supportedSources = r8.createStringArrayList();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.supportedMediaTypes = r8.createStringArrayList();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.supportedEventTypes = r8.createStringArrayList();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.supportedFilters = r8.createStringArrayList();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        boolean r12 = true;
        if (r8.readInt() == 0) goto L28;
        boolean r13 = true;
    L29:
        this.supportsSubmit = r13;     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() == 0) goto L35;
        boolean r14 = true;
    L36:
        this.supportsQuery = r14;     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        if (r8.readInt() != 0) goto L43;
        r12 = false;
    L43:
        this.supportsSubscribe = r12;     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.maxFieldsPerEvent = r8.readInt();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.maxFieldBytes = r8.readInt();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.maxResults = r8.readInt();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.maxQueryWindowMs = r8.readLong();     // Catch: Throwable -> L60
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.fieldVisibilityPolicy = r8.readString();     // Catch: Throwable -> L60
        int r15 = r8.dataPosition() - r10;
        goto L8
    L35:
        r14 = false;
        goto L36
    L28:
        r13 = false;
    L60:
        th = move-exception;
        r8.setDataPosition(r10 + r11);
        throw th;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.serviceVersion);
        r8.writeStringList(this.supportedOrigins);
        r8.writeStringList(this.supportedSources);
        r8.writeStringList(this.supportedMediaTypes);
        r8.writeStringList(this.supportedEventTypes);
        r8.writeStringList(this.supportedFilters);
        r8.writeInt(this.supportsSubmit ? 1 : 0);
        r8.writeInt(this.supportsQuery ? 1 : 0);
        r8.writeInt(this.supportsSubscribe ? 1 : 0);
        r8.writeInt(this.maxFieldsPerEvent);
        r8.writeInt(this.maxFieldBytes);
        r8.writeInt(this.maxResults);
        r8.writeLong(this.maxQueryWindowMs);
        r8.writeString(this.fieldVisibilityPolicy);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        a.n(r12, r11, r8, r12);
    }
}
