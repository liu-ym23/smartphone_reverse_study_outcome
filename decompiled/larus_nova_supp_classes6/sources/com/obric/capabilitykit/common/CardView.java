package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/capabilitykit/common/CardView;", "Landroid/os/Parcelable;", "remoteViews", "Landroid/widget/RemoteViews;", "backBackgroundResId", "", "iconResId", "description", "", "frontPanelResId", "(Landroid/widget/RemoteViews;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getBackBackgroundResId", "()Ljava/lang/Integer;", "setBackBackgroundResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getFrontPanelResId", "setFrontPanelResId", "getIconResId", "setIconResId", "describeContents", "getContentViews", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CardView implements Parcelable {
    public static final a CREATOR = null;
    private Integer backBackgroundResId;
    private String description;
    private Integer frontPanelResId;
    private Integer iconResId;
    private RemoteViews remoteViews;

    static {
        CREATOR = new a();
    }

    public CardView() {
        this(null, null, null, null, null, 31, null);
    }

    public CardView(RemoteViews r1, Integer r2, Integer r3, String r4, Integer r5) {
        this.remoteViews = r1;
        this.backBackgroundResId = r2;
        this.iconResId = r3;
        this.description = r4;
        this.frontPanelResId = r5;
    }

    public /* synthetic */ CardView(RemoteViews r5, Integer r6, Integer r7, String r8, Integer r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        RemoteViews r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        Integer r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        Integer r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Integer r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Integer getBackBackgroundResId() {
        return this.backBackgroundResId;
    }

    public final RemoteViews getContentViews() {
        return this.remoteViews;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getFrontPanelResId() {
        return this.frontPanelResId;
    }

    public final Integer getIconResId() {
        return this.iconResId;
    }

    public final void setBackBackgroundResId(Integer r1) {
        this.backBackgroundResId = r1;
    }

    public final void setDescription(String r1) {
        this.description = r1;
    }

    public final void setFrontPanelResId(Integer r1) {
        this.frontPanelResId = r1;
    }

    public final void setIconResId(Integer r1) {
        this.iconResId = r1;
    }

    public String toString() {
        return "CardView(remoteViews=" + this.remoteViews + ", backBackground=" + this.backBackgroundResId + ", icon=" + this.iconResId + ", description=" + this.description + ", frontPanel=" + this.frontPanelResId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeParcelable(this.remoteViews, r3);
        r2.writeValue(this.backBackgroundResId);
        r2.writeValue(this.iconResId);
        r2.writeString(this.description);
        r2.writeValue(this.frontPanelResId);
    }
}
