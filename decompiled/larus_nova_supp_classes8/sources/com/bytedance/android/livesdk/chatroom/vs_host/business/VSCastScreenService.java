package com.bytedance.android.livesdk.chatroom.vs_host.business;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livehostapi.business.IHostLiveByteCast;
import com.bytedance.android.livehostapi.business.IHostMultiDeviceResume;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastOptionResolutionStrategyInfo;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceImpl;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastManager;
import com.bytedance.android.livesdk.castscreen.datacontext.CastScreenConnectDataContext;
import com.bytedance.android.livesdk.castscreen.datacontext.ReplayCastScreenModelFactory;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.config.hj;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSCastScreenService implements com.bytedance.android.scope.o, yr1.b {
    public VSCastScreenService() {
    }

    @Override // yr1.b
    public final void I() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.b
    public final void pause() {
    }

    @Override // yr1.b
    public final void J() {
        String r0 = LiveByteCastUIManager.a;
        IHostLiveByteCast r1 = LiveByteCastUIManager.k();
        if (r1 == null) goto L8;
        ILiveCastSourceImpl r2 = r1.getCastSourceImpl();
        if (r2 == null) goto L9;
        r2.pause();
        return;
    L9:
        return;
    }

    @Override // yr1.b
    public final CastScreenConnectDataContext a() {
        return new CastScreenConnectDataContext();
    }

    @Override // yr1.b
    public final c f() {
        return new c();
    }

    @Override // yr1.b
    public final void h() {
        String r0 = LiveByteCastUIManager.a;
        IHostLiveByteCast r1 = LiveByteCastUIManager.k();
        if (r1 == null) goto L8;
        ILiveCastSourceImpl r2 = r1.getCastSourceImpl();
        if (r2 == null) goto L9;
        r2.resume();
        return;
    L9:
        return;
    }

    @Override // yr1.b
    public final LiveCastOptionResolutionStrategyInfo liveClarityStrategy() {
        String r0 = LiveByteCastUIManager.a;
        return LiveByteCastUIManager.p();
    }

    @Override // yr1.b
    public final boolean liveIconOpt() {
        IHostMultiDeviceResume r0 = (IHostMultiDeviceResume) LazyKt.lazy(VSCastScreenService$liveIconOpt$hostAdapter$2.INSTANCE).getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.liveIconOpt();
    }

    @Override // yr1.b
    public final boolean q() {
        String r0 = LiveByteCastUIManager.a;
        return LiveByteCastUIManager.r();
    }

    @Override // yr1.b
    public final boolean j() {
        return LiveByteCastManager.a();
    }

    @Override // yr1.b
    public final Class<? extends ViewModel> g() {
        return CastScreenViewModel.class;
    }

    @Override // yr1.b
    public final com.bytedance.live.datacontext.m<Boolean> A(DataCenter r2) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r3 = CastScreenViewModel.a.b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getNeedReturnSearchView();
    }

    @Override // yr1.b
    public final com.bytedance.live.datacontext.m<Boolean> E(DataCenter r2) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r3 = CastScreenViewModel.a.b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getNeedReturnGuideView();
    }

    @Override // yr1.b
    public final Boolean F(DataCenter r3) {
        String r0 = LiveByteCastUIManager.a;
        if (hj.a.getValue().booleanValue() == false) goto L5;
        CastScreenConnectDataContext.Companion.getClass();
        CastScreenConnectDataContext r1 = CastScreenConnectDataContext.a.a(r3);
        if (r1 == null) goto L9;
        Boolean r4 = Boolean.valueOf(r1.isCastScreenLinking(r3));
    L10:
        Logger.d("LandscapeGestureWidget", "isCastScreenLinking not ByteMatchCast castScreenLinking=" + r4);
        return Boolean.valueOf(Intrinsics.areEqual(r4, Boolean.TRUE));
    L9:
        r4 = null;
        goto L10
    L5:
        return Boolean.FALSE;
    }

    @Override // yr1.b
    public final Boolean K(DataCenter r2) {
        CastScreenConnectDataContext.Companion.getClass();
        CastScreenConnectDataContext r0 = CastScreenConnectDataContext.a.a(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.isCastScreenLinking(r2));
    }

    @Override // yr1.b
    public final com.bytedance.live.datacontext.m<Boolean> c(DataCenter r2) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r3 = CastScreenViewModel.a.b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getReplayShowDanmaku();
    }

    @Override // yr1.b
    public final com.bytedance.live.datacontext.m<Boolean> castScreenMode(DataCenter r2) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r3 = CastScreenViewModel.a.b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getCastOrMirrorScreenMode();
    }

    @Override // yr1.b
    public final Boolean d(DataCenter r2) {
        CastScreenConnectDataContext.Companion.getClass();
        CastScreenConnectDataContext r0 = CastScreenConnectDataContext.a.a(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.isCastScreenPlaying(r2));
    }

    @Override // yr1.b
    public final void i(long r3) {
        String r0 = LiveByteCastUIManager.a;
        IHostLiveByteCast r1 = LiveByteCastUIManager.k();
        if (r1 == null) goto L8;
        ILiveCastSourceImpl r2 = r1.getCastSourceImpl();
        if (r2 == null) goto L9;
        r2.seekTo(r3, true);
        return;
    L9:
        return;
    }

    @Override // yr1.b
    public final boolean isByteMatchCasting(DataCenter r2) {
        String r0 = LiveByteCastUIManager.a;
        LiveByteCastUIManager.n(r2);
        return false;
    }

    @Override // yr1.b
    public final void k(boolean r2) {
        if (r2 == false) goto L5;
        String r3 = LiveByteCastUIManager.a;
        Intrinsics.checkNotNullParameter("linking", "<set-?>");
        LiveByteCastUIManager.a = "linking";
        return;
    L5:
        String r4 = LiveByteCastUIManager.a;
        Intrinsics.checkNotNullParameter("not_in_casting", "<set-?>");
        LiveByteCastUIManager.a = "not_in_casting";
    }

    @Override // yr1.b
    public final com.bytedance.live.datacontext.m<String> o(DataCenter r2) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r3 = CastScreenViewModel.a.b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getJumpSchema();
    }

    @Override // yr1.b
    public final NextLiveData<Boolean> s(DataCenter r2) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r3 = CastScreenViewModel.a.b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getReplaySwitched();
    }

    @Override // yr1.b
    public final boolean x(DataCenter r2) {
        CastScreenViewModel.Companion.getClass();
        if (CastScreenViewModel.a.b(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // yr1.b
    public final ReplayCastScreenModelFactory y(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new ReplayCastScreenModelFactory(r2);
    }

    @Override // yr1.b
    public final void n(DataCenter r3, KVData r4) {
        if (r3 == null) goto L13;
        lf1.a r0 = null;
        if (r4 == null) goto L6;
        lf1.a r5 = (lf1.a) r4.getData();
    L8:
        if ((r5 instanceof lf1.a) == false) goto L11;
        r0 = r5;
    L11:
        r3.put("action_show_device", r0);
        return;
    L6:
        r5 = null;
        goto L8
    }

    @Override // yr1.b
    public final void w(DataCenter r2, boolean r3) {
        CastScreenConnectDataContext.Companion.getClass();
        CastScreenConnectDataContext r4 = CastScreenConnectDataContext.a.a(r2);
        if (r4 == null) goto L8;
        com.bytedance.live.datacontext.m r5 = r4.getCastScreenPlaying();
        if (r5 == null) goto L9;
        r5.setValue(Boolean.valueOf(r3));
        return;
    L9:
        return;
    }
}
