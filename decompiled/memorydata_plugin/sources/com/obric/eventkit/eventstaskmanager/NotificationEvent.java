package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/NotificationEvent;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", OaidModel.KEY_ID, "", Params.CONTENT, "notifications", "", "Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/eventkit/eventstaskmanager/AppNotification;)V", "getNotifications", "()[Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "setNotifications", "([Lcom/obric/eventkit/eventstaskmanager/AppNotification;)V", "[Lcom/obric/eventkit/eventstaskmanager/AppNotification;", "readFromParcel", "", "parcel", "Landroid/os/Parcel;", "toString", "writeToParcel", "dest", "flags", "", "CREATOR", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotificationEvent extends AppEvent {
    public static final a CREATOR = null;
    private static final int VERSION = 0;
    private AppNotification[] notifications;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/NotificationEvent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/NotificationEvent;", "()V", "VERSION", "", "createFromParcel", AILabCheckPermissionTask.KEY_SOURCE, "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/eventkit/eventstaskmanager/NotificationEvent;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<NotificationEvent> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public NotificationEvent a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
            return (NotificationEvent) ZeusTransformUtils.preCheckCast(AppEvent.CREATOR.createAppEventFromParcel$eventstaskkit_release(r2), NotificationEvent.class, "com.obric.memorydata.plugin");
        }

        public NotificationEvent[] a(int r1) {
            return new NotificationEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ NotificationEvent createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ NotificationEvent[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
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
    public void readFromParcel(Parcel r7) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        super.readFromParcel(r7);
        int r0 = r7.readInt();
        if (r0 <= 0) goto L10;
        int r1 = 0;
        AppNotification[] r2 = new AppNotification[r0];
    L5:
        if (r1 >= r0) goto L7;
        Parcelable r3 = r7.readParcelable(AppNotification.class.getClassLoader());
        Intrinsics.checkNotNull(r3);
        r2[r1] = (AppNotification) ZeusTransformUtils.preCheckCast(r3, AppNotification.class, "com.obric.memorydata.plugin");
        r1 = r1 + 1;
        goto L5
    L7:
        this.notifications = r2;
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
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        super.writeToParcel(r4, r5);
        AppNotification[] r0 = this.notifications;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.length;
    L6:
        r4.writeInt(r2);
        AppNotification[] r3 = this.notifications;
        if (r3 == null) goto L11;
        int r6 = r3.length;
    L9:
        if (r1 >= r6) goto L13;
        r4.writeParcelable(r3[r1], r5);
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
