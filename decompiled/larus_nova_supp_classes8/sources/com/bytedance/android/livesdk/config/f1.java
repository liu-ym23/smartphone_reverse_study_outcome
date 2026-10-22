package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/f1;", "", "", "linkWaitingPanelIcon", "Ljava/lang/String;", "getLinkWaitingPanelIcon", "()Ljava/lang/String;", "linkWaitingToolbarIcon", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f1 {

    @SerializedName("link_waiting_panel_icon")
    private final String linkWaitingPanelIcon;

    @SerializedName("link_waiting_toolbar_icon")
    private final String linkWaitingToolbarIcon;

    public f1() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f1) == false) goto L10;
        f1 r4 = (f1) r3;
        if (Intrinsics.areEqual(this.linkWaitingPanelIcon, r4.linkWaitingPanelIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.linkWaitingToolbarIcon, r4.linkWaitingToolbarIcon) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.linkWaitingPanelIcon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.linkWaitingToolbarIcon;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ChannelLinkWebpResConfig(linkWaitingPanelIcon=" + this.linkWaitingPanelIcon + ", linkWaitingToolbarIcon=" + this.linkWaitingToolbarIcon + ")";
    }

    public final String a() {
        return this.linkWaitingToolbarIcon;
    }

    public f1(int r3) {
        Intrinsics.checkNotNullParameter("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_room_channel_link_waiting_panel_icon.webp", "linkWaitingPanelIcon");
        Intrinsics.checkNotNullParameter("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_room_channel_link_waiting_toolbar_icon.webp", "linkWaitingToolbarIcon");
        this.linkWaitingPanelIcon = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_room_channel_link_waiting_panel_icon.webp";
        this.linkWaitingToolbarIcon = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_room_channel_link_waiting_toolbar_icon.webp";
    }
}
