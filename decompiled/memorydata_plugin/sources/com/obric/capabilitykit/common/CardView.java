package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/capabilitykit/common/CardView;", "Landroid/os/Parcelable;", "remoteViews", "Landroid/widget/RemoteViews;", "backBackgroundResId", "", "iconResId", "description", "", "frontPanelResId", "(Landroid/widget/RemoteViews;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getBackBackgroundResId", "()Ljava/lang/Integer;", "setBackBackgroundResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getFrontPanelResId", "setFrontPanelResId", "getIconResId", "setIconResId", "describeContents", "getContentViews", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardView implements Parcelable {
    public static final a CREATOR = null;
    private Integer backBackgroundResId;
    private String description;
    private Integer frontPanelResId;
    private Integer iconResId;
    private RemoteViews remoteViews;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/common/CardView$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/CardView;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/common/CardView;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<CardView> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public CardView a(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            RemoteViews r1 = (RemoteViews) ZeusTransformUtils.preCheckCast(r8.readParcelable(RemoteViews.class.getClassLoader()), RemoteViews.class, "com.obric.memorydata.plugin");
            Class r0 = Integer.TYPE;
            Object r3 = r8.readValue(r0.getClassLoader());
            Integer r5 = null;
            if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L5;
            Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin");
        L6:
            Object r6 = r8.readValue(r0.getClassLoader());
            if (ZeusTransformUtils.instanceOf(r6, Integer.class) == false) goto L9;
            Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin");
        L10:
            String r9 = r8.readString();
            Object r10 = r8.readValue(r0.getClassLoader());
            if (ZeusTransformUtils.instanceOf(r10, Integer.class) == false) goto L14;
            r5 = (Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.memorydata.plugin");
        L14:
            return new CardView(r1, r4, r7, r9, r5);
        L9:
            r7 = null;
            goto L10
        L5:
            r4 = null;
            goto L6
        }

        public CardView[] a(int r1) {
            return new CardView[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardView createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardView[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
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

    public /* synthetic */ CardView(RemoteViews r2, Integer r3, Integer r4, String r5, Integer r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
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
