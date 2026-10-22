package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.business.IHostLiveByteCast;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceImpl;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.config.pj1;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ScheduleCloseWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScheduleCloseWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int d = 0;
    public final c a;
    public final b b;
    public Disposable c;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.vsplayer.api.d {
        public final /* synthetic */ ScheduleCloseWidget a;

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void C5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void D5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void E5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void G5(boolean r1) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void H5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void P1() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void g5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void k2() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void l3() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void onRenderStart() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void z() {
            VSDataContext r0 = VSDataContext.a.c(VSDataContext.Companion, ((Widget) this.a).dataCenter);
            if (r0 == null) goto L27;
            com.bytedance.live.datacontext.m r1 = r0.isVSVideo();
            if (r1 == null) goto L28;
            boolean r2 = true;
            if (((Boolean) r1.getValue()).booleanValue() != true) goto L29;
            ScheduleCloseWidget r3 = this.a;
            int r4 = ScheduleCloseWidget.d;
            r3.getClass();
            if (i2.b == true) goto L16;
            n2 r5 = new n2(((Widget) r3).context);
            r5.setOnDismissListener(j2.a);
            if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L25;
            DialogLancet.handleBlockedDialogShow(r5);
        L15:
            i2.a();
        L17:
            if (r2 == false) goto L30;
            IVSPlayerService r6 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
            if (r6 == null) goto L31;
            IPlayerProgressService r7 = r6.provideVSProgressService(((Widget) this.a).dataCenter);
            if (r7 == null) goto L32;
            r7.pause();
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L25:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
        L14:
            DialogLancet.beforeDialogShow(r5);
            r5.show();
            DialogLancet.afterDialogShow(r5);
            goto L15
        L16:
            r2 = false;
            goto L17
        L29:
            return;
        L28:
            return;
        }

        public b(ScheduleCloseWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void v2(EpisodeHighLight r2) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void F5(EpisodeHighLight r2, Pair<Integer, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r3, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.a(r2, r3);
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void I5(EpisodeHighLight r2, Pair<Integer, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r3, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.b(r2, r3);
        }
    }

    public static final class c implements i2.a {
        public final /* synthetic */ ScheduleCloseWidget a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i2.a
        public final /* synthetic */ void a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i2.a
        public final /* synthetic */ void c() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i2.a
        public final void b() {
            ScheduleCloseWidget r0 = this.a;
            int r1 = ScheduleCloseWidget.d;
            DataCenter r2 = r0.getDataCenter();
            if (r2 == null) goto L31;
            IAbilityCenter r3 = com.bytedance.android.live.core.utils.a0.a(r2);
            if (r3 == null) goto L31;
            IRoomRecordService r4 = r3.getAbility(IRoomRecordService.class);
            if (r4 == null) goto L31;
            if (r4.isRecording() == true) goto L31;
            IVSPlayerService r5 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
            if (r5 == null) goto L15;
            IPlayerProgressService r6 = r5.provideVSProgressService(((Widget) r0).dataCenter);
            if (r6 == null) goto L15;
            r6.pause();
        L15:
            CastScreenViewModel.Companion.getClass();
            CastScreenViewModel r7 = CastScreenViewModel.a.a();
            if (r7 == null) goto L26;
            com.bytedance.live.datacontext.m r8 = r7.getCastOrMirrorScreenMode();
            if (r8 == null) goto L26;
            if (((Boolean) r8.getValue()).booleanValue() != true) goto L26;
            String r9 = LiveByteCastUIManager.a;
            IHostLiveByteCast r10 = LiveByteCastUIManager.k();
            if (r10 == null) goto L26;
            ILiveCastSourceImpl r11 = r10.getCastSourceImpl();
            if (r11 == null) goto L26;
            r11.pause();
        L26:
            n2 r12 = new n2(((Widget) r0).context);
            if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L34;
            DialogLancet.handleBlockedDialogShow(r12);
            goto L31
        L34:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
        L30:
            DialogLancet.beforeDialogShow(r12);
            r12.show();
            DialogLancet.afterDialogShow(r12);
        L31:
            i2.a();
        }

        public c(ScheduleCloseWidget r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        ((Widget) this).dataCenter.removeObserver(this);
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        List<i2.a> r1 = i2.a;
        c r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) i2.a).remove(r2);
        xq();
        Disposable r3 = i2.c;
        if (r3 == null) goto L8;
        r3.dispose();
    L8:
        i2.f = "not_start";
        IVSPlayerService r4 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r5 = r4.provideVSPlayerTipService(((Widget) this).dataCenter);
        if (r5 == null) goto L15;
        r5.hidePlayerTip("schedule_close");
        return;
    L15:
        return;
    }

    public final void xq() {
        IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L8;
        IPlayerProgressService r1 = r0.provideVSProgressService(((Widget) this).dataCenter);
        if (r1 == null) goto L9;
        r1.removeProgressChangeListener(this.b);
        return;
    L9:
        return;
    }

    public ScheduleCloseWidget() {
        this.a = new c(this);
        this.b = new b(this);
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        boolean r0 = com.bytedance.android.livesdk.floatview.p.a;
        if (com.bytedance.android.livesdk.floatview.p.d(((Widget) this).context) == false) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.floatview.p.f() == true) goto L12;
        Disposable r1 = i2.c;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        i2.f = "not_start";
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (i2.d <= 1) goto L8;
        long r2 = i2.e;
        if (r2 <= 0) goto L8;
        i2.b(r2);
        return;
    L8:
        if (i2.d == 1) goto L10;
        return;
    L10:
        if (i2.e != (-1)) goto L19;
        i2.d = 1;
        IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L20;
        IPlayerProgressService r1 = r0.provideVSProgressService(((Widget) this).dataCenter);
        if (r1 == null) goto L21;
        r1.addProgressChangeListener(this.b);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void onChanged(Object r11) {
        KVData r12 = (KVData) r11;
        if (r12 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r12.getKey(), "cmd_show_schedule_close_action_sheet") == false) goto L41;
        Boolean r0 = Boolean.TRUE;
        Boolean r13 = (Boolean) r12.getData(r0);
        if (r13 != null) goto L9;
        return;
    L9:
        if (((Widget) this).isViewValid == false) goto L43;
        boolean r14 = r13.booleanValue();
        BaseActionSheet r1 = new BaseActionSheet();
        r1.setVertical(r14);
        BaseActionSheet.d[] r2 = new BaseActionSheet.d[3];
        BaseActionSheet.d r3 = new BaseActionSheet.d();
        r3.a = com.bytedance.android.live.core.utils.s1.B(2131923385);
        boolean r4 = false;
        r3.b = 0;
        if (i2.d != 0) goto L13;
        boolean r5 = true;
    L14:
        r3.c = r5;
        Unit r6 = Unit.INSTANCE;
        r2[0] = r3;
        BaseActionSheet.d r7 = new BaseActionSheet.d();
        r7.a = com.bytedance.android.live.core.utils.s1.C(2131923386, new Object[]{30});
        r7.b = 2;
        if (2 != i2.d) goto L17;
        boolean r8 = true;
    L18:
        r7.c = r8;
        r2[1] = r7;
        BaseActionSheet.d r9 = new BaseActionSheet.d();
        r9.a = com.bytedance.android.live.core.utils.s1.C(2131923386, new Object[]{60});
        r9.b = 3;
        if (3 != i2.d) goto L21;
        boolean r15 = true;
    L22:
        r9.c = r15;
        r2[2] = r9;
        List<BaseActionSheet.d> r16 = CollectionsKt.mutableListOf(r2);
        if (Intrinsics.areEqual(pj1.a.getValue(), r0) == false) goto L28;
        BaseActionSheet.d r10 = new BaseActionSheet.d();
        r10.a = "1分钟(测试)";
        r10.b = 4;
        if (4 != i2.d) goto L27;
        r4 = true;
    L27:
        r10.c = r4;
        r16.add(r10);
    L28:
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r1.g = r16;
        r1.f = new k2(this);
        r1.e = new l2();
        FragmentActivity r17 = ((Widget) this).context;
        if (r17 == null) goto L36;
        FragmentManager r18 = r17.getSupportFragmentManager();
        LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "ActionSheet", r19);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r18, r1, r19) == true) goto L45;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L34:
        r1.show(r18, "ActionSheet");
        return;
    L45:
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L21:
        r15 = false;
        goto L22
    L17:
        r8 = false;
        goto L18
    L13:
        r5 = false;
        goto L14
    L43:
        return;
    }

    public final void onLoad(Object[] r3) {
        ((Widget) this).dataCenter.observe("cmd_show_schedule_close_action_sheet", this, false);
        List<i2.a> r4 = i2.a;
        c r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "listener");
        ((ArrayList) i2.a).add(r5);
    }

    public static final void wq(ScheduleCloseWidget r4, String r5) {
        r4.getClass();
        String r6 = com.bytedance.android.live.core.utils.s1.C(2131923382, new Object[]{r5});
        DataCenter r1 = ((Widget) r4).dataCenter;
        if (r1 != null) goto L5;
    L7:
        IVSPlayerService r2 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r3 = r2.provideVSPlayerTipService(((Widget) r4).dataCenter);
        if (r3 == null) goto L15;
        r3.showPlayerTip("schedule_close", r6, true);
        r4.c = Observable.timer(2500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new m2(r3));
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (com.bytedance.android.live.core.utils.z.b(r1).b != true) goto L7;
        String r0 = rm3.c.a;
        rm3.c.g(((Widget) r4).context, r6, 0, false, 28);
    }
}
