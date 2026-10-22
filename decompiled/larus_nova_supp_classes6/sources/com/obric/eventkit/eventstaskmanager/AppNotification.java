package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001)BO\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b%\u0010&B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b%\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003JQ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b$\u0010\u001f¨\u0006*"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "component1", "component2", "component3", "component4", "component5", "component6", "id", "time", "content", "appName", "packageName", "title", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getTime", "getContent", "getAppName", "getPackageName", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class AppNotification implements Parcelable {
    public static final a CREATOR = null;
    private final String appName;
    private final String content;
    private final String id;
    private final String packageName;
    private final String time;
    private final String title;

    static {
        CREATOR = new a();
    }

    public AppNotification() {
        this(null, null, null, null, null, null, 63, null);
    }

    public AppNotification(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        this(r9.readString(), r9.readString(), r9.readString(), r9.readString(), r9.readString(), r9.readString());
    }

    public AppNotification(String r1, String r2, String r3, String r4, String r5, String r6) {
        this.id = r1;
        this.time = r2;
        this.content = r3;
        this.appName = r4;
        this.packageName = r5;
        this.title = r6;
    }

    public /* synthetic */ AppNotification(String r6, String r7, String r8, String r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }

    public static /* synthetic */ AppNotification copy$default(AppNotification r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.time;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.content;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.appName;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.packageName;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.title;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.appName;
    }

    public final String component5() {
        return this.packageName;
    }

    public final String component6() {
        return this.title;
    }

    public final AppNotification copy(String r9, String r10, String r11, String r12, String r13, String r14) {
        return new AppNotification(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppNotification) == true) goto L8;
        return false;
    L8:
        AppNotification r6 = (AppNotification) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.time;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.content;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.appName;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.packageName;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.title;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppNotification(id=" + this.id + ", time=" + this.time + ", content=" + this.content + ", appName=" + this.appName + ", packageName=" + this.packageName + ", title=" + this.title + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.id);
        r1.writeString(this.time);
        r1.writeString(this.content);
        r1.writeString(this.appName);
        r1.writeString(this.packageName);
        r1.writeString(this.title);
    }
}
