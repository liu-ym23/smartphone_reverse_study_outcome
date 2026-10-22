package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B1\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/NotificationEvent;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "parcel", "readFromParcel", "", "toString", "", "Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "notifications", "[Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "getNotifications", "()[Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "setNotifications", "([Lcom/obric/eventkit/eventstaskmanager/AppNotification;)V", "id", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/eventkit/eventstaskmanager/AppNotification;)V", "CREATOR", "a", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class NotificationEvent extends AppEvent {
    public static final a CREATOR = null;
    private static final int VERSION = 0;
    private AppNotification[] notifications;

    static {
        CREATOR = new a();
    }

    public NotificationEvent() {
        this(null, null, null, 7, null);
    }

    public NotificationEvent(String r2, String r3, AppNotification[] r4) {
        super(r2, r3, null);
        this.notifications = r4;
    }

    public /* synthetic */ NotificationEvent(String r2, String r3, AppNotification[] r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final AppNotification[] getNotifications() {
        return this.notifications;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public void readFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        super.readFromParcel(r5);
        int r0 = r5.readInt();
        if (r0 <= 0) goto L10;
        AppNotification[] r1 = new AppNotification[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        Parcelable r3 = r5.readParcelable(AppNotification.class.getClassLoader());
        Intrinsics.checkNotNull(r3);
        r1[r2] = (AppNotification) r3;
        r2 = r2 + 1;
        goto L5
    L7:
        this.notifications = r1;
        return;
    }

    public final void setNotifications(AppNotification[] r1) {
        this.notifications = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public String toString() {
        return "NotificationEvent(id=" + getId() + ", content=" + getContent() + ", extra=" + getExtra() + ", createTime=" + getCreateTime() + ", lastModifiedTime=" + getLastModifiedTime() + ", source='" + getSource() + "', eventType='" + getEventType() + "', notifications='" + this.notifications + "')";
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent, android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        super.writeToParcel(r5, r6);
        AppNotification[] r0 = this.notifications;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.length;
    L6:
        r5.writeInt(r2);
        AppNotification[] r3 = this.notifications;
        if (r3 == null) goto L11;
        int r4 = r3.length;
    L9:
        if (r1 >= r4) goto L13;
        r5.writeParcelable(r3[r1], r6);
        r1 = r1 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
