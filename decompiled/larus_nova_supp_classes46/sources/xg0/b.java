package xg0;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import se0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements xg0.a {
    public xg0.a a;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder.b
    public final void S4() {
        a("handleAvatarVideoDisplay");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.S4();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.a
    public final c getAudioFeedLayerUIConfig() {
        a("getAudioFeedLayerUIConfig");
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAudioFeedLayerUIConfig();
    }

    @Override // xg0.a
    public final DataCenter getDataCenter() {
        a("getDataCenter");
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDataCenter();
    }

    @Override // xg0.a
    public final int getFeedType() {
        a("getFeedType");
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getFeedType();
    }

    @Override // hg0.a
    public final Integer getLastSubUILayout() {
        a("getLastSubUILayout");
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLastSubUILayout();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.a
    public final m getLinkWindowLayoutConfig() {
        a("getLinkWindowLayoutConfig");
        xg0.a r0 = this.a;
        if (r0 == null) goto L7;
        m r1 = r0.getLinkWindowLayoutConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new m();
    }

    @Override // xg0.a, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final RecyclerView getMicSeatRecyclerView() {
        a("getMicSeatRecyclerView");
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMicSeatRecyclerView();
    }

    @Override // xg0.a
    public final IRoom getRoom() {
        a("getRoom");
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoom();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.b
    public final void E5(ch0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "friendOnlineInviteeInfo");
        a("onFastInviteButtonClick");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.E5(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder.b, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void K1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        a("pcUpdateSingleViewLayer");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.K1(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b
    public final void N0(w8 r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiMessage");
        a("onDynamicEmojiPlayEnd");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.N0(r2);
        return;
    }

    @Override // hg0.a
    public final ig0.b P6(int r3) {
        a("getAnimLayer position=" + r3);
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.P6(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder.b
    public final void Q3(MultiLinkSpecialViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        a("onSpecialItemClicked");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.Q3(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder.b
    public final void V3(MultiLinkPreOnlineViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        a("onPreOnlineItemClicked");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.V3(r2);
        return;
    }

    public final void a(String r2) {
        int r0 = t0.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(r2);
        r1.append(", Proxy=");
        r1.append(hashCode());
        r1.append(", realAbilityProvider=");
        xg0.a r3 = this.a;
        if (r3 == null) goto L5;
        int r4 = r3.hashCode();
    L6:
        r1.append(r4);
        t0.a("LinkSeatAbilityProviderProxy", r1.toString());
        return;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.b
    public final void d2(MultiLinkNormalEmptyViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        a("onEmptyItemClicked");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.d2(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b
    public final void e4(MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        a("onGuestRankClick");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.e4(r2);
        return;
    }

    @Override // hg0.a
    public final g ph(int r3) {
        a("getBasicLayer position=" + r3);
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ph(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder.b
    public final void w0(boolean r3) {
        a("onClickFoldButton isMicSeatFold=" + r3);
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.w0(r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b
    public final void w1(MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        a("onGuestItemClicked");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.w1(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.b
    public final void K3(MultiLinkNormalEmptyViewBinder.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        a("onEmptyStubClickedWithGuideShow");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.K3(r2, r3);
        return;
    }

    @Override // hg0.a
    public final View Za(int r3, int r4) {
        a("getBasicLayerElement position=" + r3 + ", viewId=" + r4);
        xg0.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Za(r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.b, com.bytedance.android.live.liveinteract.plantform.commonwindow.l
    public final void m3(MultiLinkGuestViewBinder.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        a("onMediaTypeChanged");
        xg0.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.m3(r2, r3);
        return;
    }
}
