package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IKtvComponentFeedViewManager;
import com.bytedance.android.livesdkapi.feed.ILivePreviewMultiLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 implements IKtvComponentFeedViewManager {
    public IKtvComponentFeedView a;
    public boolean b;
    public boolean c;
    public IRoom d;
    public IPreviewMultiLinkOuterConfigProvider e;
    public ILivePreviewMultiLinkCommonWidget f;
    public ParseSeiData g;

    public static final class a {
    }

    static {
    }

    public f0() {
    }

    public final void b() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        View r2 = null;
        if (r0.getRoom().getLinkMicScene() == 9) goto L33;
        IRoom r1 = this.d;
        if (r1 == null) goto L33;
        z5 r3 = r1.getLinkerDetail();
        if (r3 == null) goto L33;
        List r4 = r3.getPlayModes();
        if (r4 == null) goto L33;
        if (r4.contains(21L) != true) goto L33;
        ParseSeiData r5 = this.g;
        if (r5 != null) goto L18;
    L20:
        IKtvComponentFeedView r6 = this.a;
        if ((r6 instanceof View) == true) goto L23;
        r6 = null;
    L23:
        View r7 = (View) r6;
        if (r7 == null) goto L26;
        r7.setAlpha(1.0f);
    L26:
        View r8 = this.a;
        if ((r8 instanceof View) == false) goto L30;
        r2 = r8;
    L30:
        View r9 = r2;
        if (r9 == null) goto L41;
        r9.bringToFront();
        return;
    L41:
        return;
    L18:
        if (r5.getSeiSubScene() != 9) goto L20;
    L33:
        View r10 = this.a;
        if ((r10 instanceof View) == false) goto L37;
        r2 = r10;
    L37:
        View r11 = r2;
        if (r11 == null) goto L43;
        r11.setAlpha(0.0f);
        return;
    }

    public final FrameLayout.LayoutParams c() {
        ILivePreviewMultiLinkCommonWidget r0 = this.f;
        if (r0 == null) goto L7;
        FrameLayout.LayoutParams r1 = r0.getKtvComponentLayoutParams();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public final String getCurrentSingUserIdString() {
        IKtvComponentFeedView r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentSingUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final boolean getKtvComponentLyricsViewShowStatus() {
        IKtvComponentFeedView r0 = this.a;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.getKtvComponentLyricsViewShowStatus();
    }

    public final HashMap<String, Object> getKtvEnterRoomExtraParam() {
        IKtvComponentFeedView r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvEnterRoomExtraParam();
    }

    public final Object getKtvSeiModelObject() {
        IKtvComponentFeedView r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvSeiModelObject();
    }

    public final void notifyComponentUpdateLp() {
        IKtvComponentFeedView r0 = this.a;
        if (r0 == null) goto L6;
        r0.updateKsongLayout(c());
        return;
    }

    public final void unBind() {
        IKtvComponentFeedView r0 = this.a;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        this.a = null;
        this.b = false;
        this.c = false;
    }

    public final IKtvComponentFeedView getKtvComponentFeedPreview() {
        return this.a;
    }

    public final void onBind(IRoom r12) {
        Intrinsics.checkNotNullParameter(r12, PbRequest.SwitchType.ROOM);
        boolean r0 = ((Boolean) vm2.d.O5.getValue(null, vm2.d.a[350(0x15e, float:4.9E-43)])).booleanValue();
        String r1 = r12.getAnchorAbValue("merge_ktv_optimize_enable");
        if (r0 == false) goto L5;
    L10:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        IPreviewMultiLinkOuterConfigProvider r4 = this.e;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L16:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r4, "MultiLinkKtvComponentFeedViewManager", hashCode(), "onBind.NoExp." + this.a, false, 8, null);
        return;
    L18:
        IKtvComponentFeedView r3 = this.a;
        if (r3 == null) goto L21;
        r3.reset();
    L21:
        this.d = r12;
        z5 r5 = r12.getLinkerDetail();
        if (r5 == null) goto L34;
        List r6 = r5.getPlayModes();
        if (r6 != null) goto L26;
        return;
    L26:
        if (r6.contains(21L) != true) goto L36;
        a(r12, "opt");
        IPreviewMultiLinkOuterConfigProvider r13 = this.e;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L30:
        FrameLayout r14 = r13.getContainerView();
        if (r14 == null) goto L37;
        r14.setVisibility(0);
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    L5:
        if (Intrinsics.areEqual(r1, "1") == true) goto L10;
        if (Intrinsics.areEqual(r1, "2") == true) goto L10;
        r2 = false;
        goto L12
    }

    public final void onKtvVideoStateChange(ld0.a r9) {
        Intrinsics.checkNotNullParameter(r9, "videoSei");
        if (this.b == false) goto L9;
        IPreviewMultiLinkOuterConfigProvider r1 = this.e;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L7:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r1, "MultiLinkKtvComponentFeedViewManager", hashCode(), "onKtvVideoStateChange.MvKtv.hide KtvComponent." + this.a, false, 8, null);
        return;
    L9:
        IKtvComponentFeedView r0 = this.a;
        if (r0 == null) goto L12;
        r0.onKtvVideoStateChange(r9);
    L12:
        b();
    }

    public final void onSeiUpdateRaw(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sei");
        if (this.b == false) goto L10;
        IPreviewMultiLinkOuterConfigProvider r2 = this.e;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L7:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r2, "MultiLinkKtvComponentFeedViewManager", hashCode(), "onSeiUpdateRaw.MvKtv.hide KtvComponent." + this.a, false, 8, null);
        return;
    L10:
        if (this.c == true) goto L14;
        IRoom r1 = this.d;
        if (r1 == null) goto L14;
        a(r1, "sei");
    L14:
        IKtvComponentFeedView r0 = this.a;
        if (r0 == null) goto L17;
        r0.onSeiUpdatedRaw(r10);
    L17:
        b();
    }

    public final void updateKtvComponentLyricsViewShowStatus(boolean r2) {
        IKtvComponentFeedView r0 = this.a;
        if (r0 == null) goto L6;
        r0.updateKtvComponentLyricsViewShowStatus(r2);
        return;
    }

    public final void updateMultiLinkCommonWidget(ILivePreviewMultiLinkCommonWidget r1) {
        this.f = r1;
    }

    public final void updateSceneByVer(ParseSeiData r10) {
        Intrinsics.checkNotNullParameter(r10, "seiAppData");
        IPreviewMultiLinkOuterConfigProvider r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r1, "MultiLinkKtvComponentFeedViewManager", hashCode(), "updateSceneByVer seiVersion " + r10.getSeiVersion(), false, 8, null);
        if (r10.getSeiVersion() == 3) goto L8;
    L19:
        this.b = false;
    L20:
        this.g = r10;
        IKtvComponentFeedView r11 = this.a;
        if (r11 == null) goto L23;
        r11.updateKsongLayout(c());
    L23:
        b();
        return;
    L8:
        if (r10.getSeiSubScene() != 9) goto L19;
        IKtvComponentFeedView r2 = this.a;
        if ((r2 instanceof View) == true) goto L12;
        r2 = null;
    L12:
        View r3 = (View) r2;
        if (r3 == null) goto L15;
        r3.setAlpha(0.0f);
    L15:
        this.b = true;
        IPreviewMultiLinkOuterConfigProvider r4 = this.e;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L18:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r4, "MultiLinkKtvComponentFeedViewManager", hashCode(), "updateSceneByVer.MvKtv.hide KtvComponent." + this.a, false, 8, null);
        goto L20
    }

    public final void a(IRoom r11, String r12) {
        IPreviewMultiLinkOuterConfigProvider r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (r0.getShowFrom() != 5) goto L8;
        return;
    L8:
        IPreviewMultiLinkOuterConfigProvider r3 = this.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        int r5 = hashCode();
        StringBuilder r1 = new StringBuilder("bindKtvComponentFeedView, source: ");
        r1.append(r12);
        r1.append(" seiVersion ");
        ParseSeiData r13 = this.g;
        IKtvComponentFeedView r2 = null;
        if (r13 == null) goto L14;
        Integer r14 = Integer.valueOf(r13.getSeiVersion());
    L15:
        r1.append(r14);
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r3, "MultiLinkKtvComponentFeedViewManager", r5, r1.toString(), false, 8, null);
        this.c = true;
        IKtvService r15 = jc1.k.f(IKtvService.class);
        if (r15 == null) goto L21;
        IPreviewMultiLinkOuterConfigProvider r4 = this.e;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L20:
        r2 = r15.getKtvComponentFeedView(r4.getContext(), false);
    L21:
        this.a = r2;
        if (r2 == null) goto L24;
        r2.updateRoom(r11);
    L24:
        IKtvComponentFeedView r16 = this.a;
        if (r16 == null) goto L31;
        IPreviewMultiLinkOuterConfigProvider r17 = this.e;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L29:
        r16.setAttachParent(r17.getContainerView(), c());
        return;
    L31:
        return;
    L14:
        r14 = null;
        goto L15
    }

    public final void init(IPreviewMultiLinkOuterConfigProvider r2, ILivePreviewMultiLinkCommonWidget r3) {
        Intrinsics.checkNotNullParameter(r2, "configOuterProvider");
        this.e = r2;
        this.f = r3;
    }
}
