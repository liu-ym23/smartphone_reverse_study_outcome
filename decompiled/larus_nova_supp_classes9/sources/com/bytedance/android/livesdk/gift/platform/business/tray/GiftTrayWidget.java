package com.bytedance.android.livesdk.gift.platform.business.tray;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.gift.tray.DialogStatus;
import com.bytedance.android.live.profit.player.profilepreview.ProfilePreviewEvent;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.d0;
import com.bytedance.android.live.revenue.common.ui.MeasureOptFrameLayout;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.configmodel.f2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.condition.RevConditionType;
import com.bytedance.android.livesdk.revenue.experience.RevExpBizScene;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.android.livesdk.revenue.vs.RevPlayViewControl;
import com.bytedance.android.livesdk.t5;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.HashSet;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import zg1.f0;
import zg1.o3;
import zg1.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u00020\u00052\u00020\u0006:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/tray/GiftTrayWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray/k;", "Lcom/bytedance/android/livesdk/common/i;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GiftTrayWidget extends LiveRecyclableWidget implements Observer<KVData>, k, com.bytedance.android.livesdk.common.i {
    public static final /* synthetic */ int r = 0;
    public Boolean a;
    public IRoom b;
    public BaseGiftTrayAnimationView c;
    public View d;
    public boolean e;
    public ViewPropertyAnimator f;
    public ViewPropertyAnimator g;
    public ViewPropertyAnimator h;
    public GiftTrayIdleStateMachine i;
    public final CompositeDisposable j;
    public final HashSet<String> k;
    public h02.a l;
    public final c m;
    public final b n;
    public final d o;
    public final g p;
    public Disposable q;

    public static final class a {
    }

    public static final class b implements s02.c {
        public final /* synthetic */ GiftTrayWidget a;

        @Override // s02.c
        public final void a(IBaseUser r1, String r2, long r3, o7 r5, long r6) {
        }

        public b(GiftTrayWidget r1) {
            this.a = r1;
        }

        @Override // s02.c
        public final void b(NormalGiftMessage r11) {
            GiftTrayWidget.yq(this.a, r11);
            IRoom r0 = this.a.b;
            o7 r1 = null;
            if (r0 == null) goto L5;
            IBaseUser r2 = r0.getOwner();
        L6:
            if (r11 == null) goto L8;
            r1 = r11.r();
        L8:
            o7 r3 = r1;
            long r4 = 0;
            if (r11 == null) goto L11;
            long r5 = r11.getTotalMoney();
        L12:
            if (r11 == null) goto L14;
            r4 = r11.getTotalCount();
        L14:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.I(r2, r3, "gift", r5, r4, r11);
            return;
        L11:
            r5 = 0;
            goto L12
        L5:
            r2 = null;
            goto L6
        }

        @Override // s02.c
        public final void c(o7 r3) {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L5;
            r0.put("cmd_show_special_group_gift", r3);
        L5:
            vh6.c.b(vq2.a.class).g7(RevConditionType.SHOW_GIFT_EFFECT);
        }

        @Override // s02.c
        public final void d(String r11, NormalGiftMessage r13) {
            Intrinsics.checkNotNullParameter(r11, "userId");
            GiftTrayWidget.xq(this.a, r11);
            IRoom r14 = this.a.b;
            o7 r0 = null;
            if (r14 == null) goto L5;
            IBaseUser r1 = r14.getOwner();
        L6:
            if (r13 == null) goto L8;
            r0 = r13.r();
        L8:
            o7 r2 = r0;
            long r4 = 0;
            if (r13 == null) goto L11;
            long r6 = r13.getTotalMoney();
        L12:
            if (r13 == null) goto L14;
            r4 = r13.getTotalCount();
        L14:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.I(r1, r2, "head_portrait", r6, r4, r13);
            return;
        L11:
            r6 = 0;
            goto L12
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c implements s02.c {
        public final /* synthetic */ GiftTrayWidget a;

        public c(GiftTrayWidget r1) {
            this.a = r1;
        }

        @Override // s02.c
        public final void b(NormalGiftMessage r11) {
            lr2.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
            if (r0 != null) goto L5;
        L7:
            GiftTrayWidget.yq(this.a, r11);
            IRoom r1 = this.a.b;
            o7 r2 = null;
            if (r1 == null) goto L10;
            IBaseUser r3 = r1.getOwner();
        L11:
            if (r11 == null) goto L13;
            r2 = r11.r();
        L13:
            o7 r4 = r2;
            long r5 = 0;
            if (r11 == null) goto L16;
            long r6 = r11.getTotalMoney();
        L17:
            if (r11 == null) goto L19;
            r5 = r11.getTotalCount();
        L19:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.I(r3, r4, "gift", r6, r5, r11);
            return;
        L16:
            r6 = 0;
            goto L17
        L10:
            r3 = null;
            goto L11
        L5:
            if (r0.Pe(PaidInteractEntry.CONTROL_ENTRY_GIFT) == true) goto L7;
        }

        @Override // s02.c
        public final void c(o7 r3) {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L6;
            r0.put("cmd_show_special_group_gift", r3);
            return;
        }

        @Override // s02.c
        public final void d(String r11, NormalGiftMessage r13) {
            Intrinsics.checkNotNullParameter(r11, "userId");
            GiftTrayWidget.xq(this.a, r11);
            com.bytedance.android.livesdk.gift.platform.business.normal.utils.c.a(r13);
            IRoom r14 = this.a.b;
            o7 r0 = null;
            if (r14 == null) goto L5;
            IBaseUser r1 = r14.getOwner();
        L6:
            if (r13 == null) goto L8;
            r0 = r13.r();
        L8:
            o7 r2 = r0;
            long r4 = 0;
            if (r13 == null) goto L11;
            long r6 = r13.getTotalMoney();
        L12:
            if (r13 == null) goto L14;
            r4 = r13.getTotalCount();
        L14:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.I(r1, r2, "head_portrait", r6, r4, r13);
            return;
        L11:
            r6 = 0;
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        @Override // s02.c
        public final void a(IBaseUser r3, String r4, long r5, o7 r7, long r8) {
            x1 r9 = new x1(r3, r4, r5);
            h2 r6 = null;
            if (r7 == null) goto L5;
            m0 r10 = r7.getCommonData();
        L6:
            r9.k = r10;
            boolean r11 = false;
            if (r7 == null) goto L11;
            h1 r13 = r7.getGift();
            if (r13 == null) goto L11;
            int r14 = r13.getDiamondCount();
        L12:
            r9.d = r14;
            if (r7 == null) goto L15;
            r7.getGroupCount();
        L15:
            long r15 = 0;
            if (r7 == null) goto L18;
            long r0 = r7.getRepeatCount();
        L19:
            r9.e = r0;
            if (r7 == null) goto L24;
            IPublicAreaCommon r16 = r7.getPublicAreaCommon();
            if (r16 == null) goto L24;
            py.k r17 = r16.getUserLabel();
        L25:
            r9.f = r17;
            if (r7 == null) goto L28;
            boolean r18 = r7.isBannedInChat();
        L29:
            r9.l = r18;
            if (r7 == null) goto L32;
            long r1 = r7.getGiftTimeStamp();
        L33:
            r9.g = r1;
            if (r7 == null) goto L36;
            r15 = r7.getReceiveTime();
        L36:
            r9.h = r15;
            if (r7 == null) goto L39;
            IPublicAreaCommon r19 = r7.getPublicAreaCommon();
        L40:
            r9.m = r19;
            if (r7 == null) goto L43;
            r11 = r7.getUseRoomMessage();
        L43:
            r9.i = r11;
            if (r7 == null) goto L46;
            r6 = u.f(r7);
        L46:
            if (r6 != null) goto L48;
        L49:
            r9.j = r6;
            DataCenter r20 = ((Widget) this.a).dataCenter;
            if (r20 == null) goto L54;
            r20.put("data_normal_gift_end_event", r9);
            return;
        L54:
            return;
        L48:
            if (r6.getType() != 8) goto L49;
            return;
        L39:
            r19 = null;
            goto L40
        L32:
            r1 = 0;
            goto L33
        L28:
            r18 = false;
        L24:
            r17 = null;
            goto L25
        L18:
            r0 = 0;
        L11:
            r14 = 0;
            goto L12
        L5:
            r10 = null;
            goto L6
        }
    }

    public static final class d implements s02.d {
        public final /* synthetic */ GiftTrayWidget a;

        @Override // s02.d
        public final void a() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L6;
            r0.put("cmd_top_gift_tray_busy", Boolean.FALSE);
            return;
        }

        @Override // s02.d
        public final void b() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L6;
            r0.put("cmd_bottom_gift_tray_busy", Boolean.FALSE);
            return;
        }

        @Override // s02.d
        public final void c() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L6;
            r0.put("cmd_top_gift_tray_busy", Boolean.TRUE);
            return;
        }

        @Override // s02.d
        public final void d() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L6;
            r0.put("cmd_bottom_gift_tray_busy", Boolean.TRUE);
            return;
        }

        @Override // s02.d
        public final void e() {
            GiftTrayIdleStateMachine r0 = this.a.i;
            if (r0 == null) goto L6;
            com.bytedance.android.livesdk.gift.platform.business.tray.c.a r1 = com.bytedance.android.livesdk.gift.platform.business.tray.c.a.a;
            Intrinsics.checkNotNullParameter(r1, "event");
            StateMachine<com.bytedance.android.livesdk.gift.platform.business.tray.e, com.bytedance.android.livesdk.gift.platform.business.tray.c, com.bytedance.android.livesdk.gift.platform.business.tray.d> r2 = r0.a;
            StateMachine.a r3 = StateMachine.c;
            r2.d(r1, null);
            return;
        }

        @Override // s02.d
        public final void onIdle() {
            GiftTrayIdleStateMachine r0 = this.a.i;
            if (r0 == null) goto L6;
            com.bytedance.android.livesdk.gift.platform.business.tray.c.b r1 = com.bytedance.android.livesdk.gift.platform.business.tray.c.b.a;
            Intrinsics.checkNotNullParameter(r1, "event");
            StateMachine<com.bytedance.android.livesdk.gift.platform.business.tray.e, com.bytedance.android.livesdk.gift.platform.business.tray.c, com.bytedance.android.livesdk.gift.platform.business.tray.d> r2 = r0.a;
            StateMachine.a r3 = StateMachine.c;
            r2.d(r1, null);
            return;
        }

        public d(GiftTrayWidget r1) {
            this.a = r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ GiftTrayWidget a;

        public e(GiftTrayWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ProfilePreviewEvent r2 = (ProfilePreviewEvent) r1;
            BaseGiftTrayAnimationView r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.d();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ GiftTrayWidget a;

        public f(GiftTrayWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L5;
            int r4 = 0;
        L6:
            GiftTrayWidget r0 = this.a;
            int r1 = GiftTrayWidget.r;
            r0.Cq(r4, "roomAuthGiftStatus");
            return;
        L5:
            r4 = 8;
            goto L6
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ GiftTrayWidget a;

        public g(GiftTrayWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L9;
            MeasureOptFrameLayout r4 = this.a.c;
            if (r4 == null) goto L14;
            r4.setAlpha(0.7f);
            return;
        L14:
            return;
        L9:
            MeasureOptFrameLayout r5 = this.a.c;
            if (r5 == null) goto L16;
            r5.setAlpha(1.0f);
            return;
        }
    }

    static {
    }

    public final /* synthetic */ String Lg() {
        return com.bytedance.android.livesdk.common.h.b(this);
    }

    public final /* synthetic */ String cg() {
        return com.bytedance.android.livesdk.common.h.c(this);
    }

    public final String getSpm() {
        return "a100.a100.a158";
    }

    public String nc() {
        return "GiftTrayWidget";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    public final int supportClearScene() {
        return 1431;
    }

    public final boolean Aq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.get("data_room");
    L7:
        if (isScreenPortrait() == true) goto L16;
        boolean r2 = this.e;
        if (r1 == null) goto L11;
        boolean r3 = r1.isMediaRoom();
    L13:
        if (d0.a(r2, r3) == false) goto L17;
        return true;
    L17:
        return false;
    L11:
        r3 = false;
        goto L13
    L16:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public GiftTrayWidget() {
        this.a = Boolean.FALSE;
        this.j = new CompositeDisposable();
        this.k = new HashSet();
        this.m = new c(this);
        this.n = new b(this);
        this.o = new d(this);
        this.p = new g(this);
    }

    public final View getContentView() {
        return findViewById(2131373655);
    }

    public int getLayoutId() {
        if (Aq() == false) goto L5;
        return 2131568012;
    L5:
        return 2131568014;
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        BaseGiftTrayAnimationView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setBlockingState(false);
        return;
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        BaseGiftTrayAnimationView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setBlockingState(true);
        return;
    }

    public void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (isViewValid() == false) goto L7;
        BaseGiftTrayAnimationView r0 = this.c;
        if (r0 == null) goto L7;
        r0.c();
    L7:
        this.a = Boolean.FALSE;
        int r1 = com.bytedance.android.livesdk.gift.platform.business.tray.f.a;
        GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i = null;
        GiftTrayMessageManager.a.a().l = false;
        GiftTrayMessageManager.a.a().n = false;
        GiftTrayMessageManager.a.a().m = false;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L10;
        r3.removeObserver(this);
    L10:
        Disposable r4 = this.q;
        if (r4 == null) goto L13;
        r4.dispose();
    L13:
        this.j.clear();
        h02.a r5 = this.l;
        if (r5 == null) goto L16;
        wq(r5);
    L16:
        this.k.clear();
        com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getPkService().o(this.p);
    }

    public final Boolean uk() {
        return this.a;
    }

    public static void wq(h02.a r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray.k
    public final void gm(o7 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (Aq() == true) goto L5;
        return;
    L5:
        h1 r0 = u.b(r2);
        if (r0 == null) goto L11;
        r2.setGift(r0);
        if (this.b == null) goto L12;
        GiftTrayMessageManager r1 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().h(r2);
        return;
    L12:
        return;
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10.getKey()) == true) goto L154;
        String r0 = r10.getKey();
        int r3 = 8;
        int r4 = 0;
        switch(r0.hashCode()) {
            case -2104158356: goto L108;
            case -1511579579: goto L91;
            case -1203988366: goto L81;
            case -763908145: goto L74;
            case -708170936: goto L60;
            case 294674590: goto L51;
            case 309908432: goto L35;
            case 333436001: goto L32;
            case 1666309114: goto L11;
            default: goto L155;
        };
    L155:
        return;
    L11:
        if (r0.equals("cmd_normal_gift_landscape_lock_translate") == false) goto L118;
        Integer r11 = (Integer) r10.getData();
        if (r11 == null) goto L119;
        r11.intValue();
        ViewPropertyAnimator r1 = this.h;
        if (r1 == null) goto L17;
        r1.cancel();
    L17:
        this.h = null;
        ViewPropertyAnimator r2 = ((Widget) this).contentView.animate().setDuration(200).translationY(r11.intValue());
        this.h = r2;
        if (r2 == null) goto L20;
        r2.start();
    L20:
        h02.a r5 = this.l;
        if (r5 == null) goto L120;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L121;
        View r7 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L29;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r8 = ThreadMethodProxy.currentThread();
        if (r8 == com.larus.home.impl.utils.c.a) goto L29;
        com.larus.home.impl.utils.c.a(r8, "getDecorView");
    L29:
        if (r7 == null) goto L122;
        ObjectAnimator.ofFloat(r7, "translationY", new float[]{r11.intValue()}).setDuration(200).start();
        return;
    L122:
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L118:
        return;
    L32:
        if (r0.equals("cmd_gift_dialog_switch") == false) goto L124;
        zq((f0) r10.getData());
        return;
    L124:
        return;
    L35:
        if (r0.equals("data_media_introduction_showing") == false) goto L126;
        IRoom r13 = this.b;
        if (r13 != null) goto L39;
        return;
    L39:
        if (r13.isMediaRoom() != true) goto L128;
        IRoom r14 = this.b;
        if (r14 == null) goto L129;
        IRoomAuthStatus r15 = r14.getRoomAuthStatus();
        if (r15 != null) goto L45;
        return;
    L45:
        if (r15.getEnableGift() == true) goto L47;
        return;
    L47:
        if (Intrinsics.areEqual((Boolean) r10.getData(), Boolean.TRUE) == false) goto L49;
        r4 = 4;
    L49:
        Cq(r4, r10.getKey());
        return;
    L129:
        return;
    L128:
        return;
    L126:
        return;
    L51:
        if (r0.equals("data_keyboard_status_douyin") == true) goto L53;
        return;
    L53:
        if (r10.getData() == null) goto L134;
        Object r16 = r10.getData();
        Intrinsics.checkNotNull(r16);
        if (((Boolean) r16).booleanValue() == true) goto L58;
        r3 = 0;
    L58:
        Cq(r3, r10.getKey());
        return;
    L134:
        return;
    L60:
        if (r0.equals("cmd_normal_gift_layout_height_update") == false) goto L136;
        Integer r17 = (Integer) r10.getData();
        if (r17 == null) goto L137;
        r17.intValue();
        if (isViewValid() == true) goto L66;
        return;
    L66:
        if (getContext() == null) goto L156;
        ViewGroup.LayoutParams r18 = ((Widget) this).contentView.getLayoutParams();
        if (r18 == null) goto L72;
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r18;
        r19.height = r17.intValue();
        ((Widget) this).contentView.setLayoutParams(r19);
        return;
    L72:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L156:
        return;
    L137:
        return;
    L136:
        return;
    L74:
        if (r0.equals("cmd_clear_gift_message") == true) goto L76;
        return;
    L76:
        if (isViewValid() == false) goto L141;
        BaseGiftTrayAnimationView r20 = this.c;
        if (r20 == null) goto L142;
        r20.c();
        return;
    L142:
        return;
    L141:
        return;
    L81:
        if (r0.equals("data_room_gift_status") == false) goto L144;
        IRoom r21 = this.b;
        if (r21 == null) goto L89;
        IRoomAuthStatus r23 = r21.getRoomAuthStatus();
        if (r23 == null) goto L89;
        if (r23.getEnableGift() != true) goto L89;
        r3 = 0;
    L89:
        Cq(r3, r10.getKey());
        return;
    L144:
        return;
    L91:
        if (r0.equals("cmd_resume_gift_message") == true) goto L93;
        return;
    L93:
        if (isViewValid() == false) goto L147;
        BaseGiftTrayAnimationView r24 = this.c;
        if (r24 == null) goto L97;
        r24.i();
    L97:
        BaseGiftTrayAnimationView r25 = this.c;
        if (r25 != null) goto L100;
        return;
    L100:
        if (r25.e() != true) goto L149;
        View r26 = this.d;
        if (r26 == null) goto L104;
        ViewUtilsKt.e(r26);
    L104:
        GiftTrayIdleStateMachine r27 = this.i;
        if (r27 == null) goto L150;
        com.bytedance.android.livesdk.gift.platform.business.tray.c.b r28 = com.bytedance.android.livesdk.gift.platform.business.tray.c.b.a;
        Intrinsics.checkNotNullParameter(r28, "event");
        StateMachine<com.bytedance.android.livesdk.gift.platform.business.tray.e, com.bytedance.android.livesdk.gift.platform.business.tray.c, com.bytedance.android.livesdk.gift.platform.business.tray.d> r29 = r27.a;
        StateMachine.a r30 = StateMachine.c;
        r29.d(r28, null);
        return;
    L150:
        return;
    L149:
        return;
    L147:
        return;
    L108:
        if (r0.equals("data_xt_landscape_tab_change") == false) goto L152;
        Integer r31 = (Integer) r10.getData();
        if (r31 != null) goto L113;
    L114:
        UIUtils.setViewVisibility(((Widget) this).contentView, 8);
        return;
    L113:
        if (r31.intValue() != 0) goto L114;
        UIUtils.setViewVisibility(((Widget) this).contentView, 0);
        return;
    L152:
        return;
    }

    public final void onEnterClear(int r4) {
        if (r4 == 1) goto L7;
        if (r4 == 4) goto L7;
    L16:
        if (r4 != 128) goto L19;
        GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().m = true;
    L19:
        if (r4 != 16) goto L24;
        View r0 = findViewById(2131373655);
        if (r0 == null) goto L24;
        ViewUtilsKt.e(r0);
    L24:
        if (r4 != 2) goto L33;
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.a.class).ki() == false) goto L33;
        if (isViewValid() == false) goto L33;
        ALogger.d("PauseAnim", "GiftTrayWidget pauseAnimation");
        GiftTrayMessageManager r1 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().l = true;
        BaseGiftTrayAnimationView r3 = this.c;
        if (r3 == null) goto L33;
        r3.g();
    L33:
        if (r4 != 256) goto L36;
        GiftTrayMessageManager r5 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().m = true;
        return;
    L36:
        return;
    L7:
        if (((Boolean) t5.a.getValue()).booleanValue() == false) goto L11;
        View r6 = findViewById(2131373655);
        if (r6 == null) goto L14;
        UtilityKotlinExtentionsKt.u(r6);
    L14:
        GiftTrayMessageManager r7 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().n = true;
        goto L16
    L11:
        View r8 = findViewById(2131373655);
        if (r8 == null) goto L14;
        ViewUtilsKt.e(r8);
        goto L14
    }

    public final void onExitClear(int r4) {
        if (r4 != 1) goto L5;
    L6:
        View r0 = findViewById(2131373655);
        if (r0 == null) goto L9;
        ViewUtilsKt.f(r0);
    L9:
        GiftTrayMessageManager r1 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().n = false;
    L11:
        if (r4 != 128) goto L14;
        GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().m = false;
    L14:
        if (r4 != 16) goto L19;
        View r3 = findViewById(2131373655);
        if (r3 == null) goto L19;
        ViewUtilsKt.f(r3);
    L19:
        if (r4 != 2) goto L28;
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.a.class).ki() == false) goto L28;
        if (isViewValid() == false) goto L28;
        ALogger.d("PauseAnim", "GiftTrayWidget resumeAnimation");
        GiftTrayMessageManager r5 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().l = false;
        BaseGiftTrayAnimationView r6 = this.c;
        if (r6 == null) goto L28;
        r6.h();
    L28:
        if (r4 != 256) goto L31;
        GiftTrayMessageManager r7 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().m = false;
        return;
    L31:
        return;
    L5:
        if (r4 != 4) goto L11;
        goto L6
    }

    public final void onInit(Object[] r8) {
        this.c = (BaseGiftTrayAnimationView) ((Widget) this).contentView.findViewById(2131373655);
        View r9 = ((Widget) this).contentView.findViewById(2131363818);
        this.d = r9;
        if (r9 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.tray.b r1 = new com.bytedance.android.livesdk.gift.platform.business.tray.b();
        int r2 = s1.h(2131107737);
        int r3 = s1.h(2131107738);
        r1.b.setColors(new int[]{r2, r3});
        r1.c.setColor(r2);
        r1.invalidateSelf();
        r1.a = com.bytedance.android.live.revenue.common.i.b(12);
        r1.invalidateSelf();
        r9.setBackground(r1);
    L5:
        BaseGiftTrayAnimationView r10 = this.c;
        if (r10 == null) goto L8;
        r10.setOnGiftTrayIdleStateListener(this.o);
    L8:
        MeasureOptFrameLayout r11 = this.c;
        if (r11 == null) goto L12;
        r11.setAlpha(1.0f);
    L12:
        if (((f2) com.bytedance.android.livesdk.gift.platform.business.a.p.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[14])).a() == false) goto L18;
        BaseGiftTrayAnimationView r13 = this.c;
        if (r13 == null) goto L16;
        r13.setHasFixSize(true);
    L16:
        jy0.b.d("ttlive_gift", "gift measure opt enabled");
        return;
    }

    public void onLoad(Object[] r13) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.a.class).ub() == false) goto L5;
        return;
    L5:
        GiftTrayMessageManager r14 = GiftTrayMessageManager.r;
        GiftTrayMessageManager r15 = GiftTrayMessageManager.a.a();
        com.bytedance.android.livesdk.revenue.experience.c r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.experience.c.class);
        int r2 = 0;
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.revenue.experience.f r1 = r0.Mg(((Widget) this).dataCenter, RevExpBizScene.DEGRADE_BUSINESS_REVENUE_GIFT_TRAY);
        if (r1 == null) goto L12;
        if (r1.a != true) goto L12;
        boolean r3 = true;
    L13:
        r15.o = r3;
        BaseGiftTrayAnimationView r16 = this.c;
        if (r16 == null) goto L16;
        r16.k(this.m, this.n);
    L16:
        BaseGiftTrayAnimationView r17 = this.c;
        if (r17 == null) goto L19;
        r17.b();
    L19:
        this.i = new GiftTrayIdleStateMachine(this);
        IRoom r18 = (IRoom) ((Widget) this).dataCenter.get("data_room");
        this.b = r18;
        Disposable r4 = null;
        if ((r18 instanceof Room) == true) goto L22;
        r18 = null;
    L22:
        Room r19 = (Room) r18;
        if (r19 == null) goto L35;
        Boolean r5 = (Boolean) ((Widget) this).dataCenter.get("data_is_anchor");
        if (r5 == null) goto L27;
        boolean r6 = r5.booleanValue();
    L28:
        this.e = r6;
        BaseGiftTrayAnimationView r7 = this.c;
        if (r7 == null) goto L31;
        r7.j(r19.orientation, r6, r19.isMediaRoom(), r19.getOwner());
    L31:
        BaseGiftTrayAnimationView r110 = this.c;
        if (r110 == null) goto L34;
        r110.setPortrait(((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue());
    L34:
        Cq(0, "widgetOnLoad");
        goto L35
    L27:
        r6 = false;
    L35:
        h02.a r111 = this.l;
        if (r111 == null) goto L38;
        wq(r111);
    L38:
        this.l = null;
        h02.a r112 = new h02.a(((Widget) this).context);
        this.l = r112;
        BaseGiftTrayAnimationView r8 = this.c;
        if (r8 == null) goto L41;
        r8.setAboveDialog(r112);
    L41:
        ((Widget) this).dataCenter.observe("data_xt_landscape_tab_change", this).observeForever("data_keyboard_status_douyin", this).observe("cmd_normal_gift_layout_height_update", this, true).observe("cmd_gift_dialog_switch", this).observe("data_room_gift_status", this).observe("data_media_introduction_showing", this).observe("cmd_clear_gift_message", this).observe("cmd_resume_gift_message", this).observeForever("data_keyboard_status_douyin", this).observe("cmd_normal_gift_landscape_lock_translate", this).observe("cmd_what_audience_join_self_link", this);
        zq((f0) ((Widget) this).dataCenter.get("cmd_gift_dialog_switch"));
        com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getPkService().n(this.p);
        GiftContext r113 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r113 == null) goto L46;
        n<Integer> r114 = r113.getGiftTrayTempPosition();
        if (r114 == null) goto L46;
        i80.a.b(r114, new AnonymousClass2(this));
    L46:
        n01.a r115 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r115 != null) goto L49;
    L65:
        com.bytedance.android.live.profit.player.d r116 = yt0.c.h();
        if (r116 == null) goto L72;
        PublishSubject r117 = r116.x1();
        if (r117 == null) goto L72;
        Disposable r118 = r117.subscribe(new e(this));
        if (r118 == null) goto L72;
        RxUtilKt.c(r118, this.j);
    L72:
        BaseGiftTrayAnimationView r119 = this.c;
        if (r119 == null) goto L75;
        r119.setDataCenter(((Widget) this).dataCenter);
    L75:
        Observable r120 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).q9(((Widget) this).dataCenter).a();
        if (r120 == null) goto L78;
        r4 = r120.subscribe(new f(this));
    L78:
        this.q = r4;
        com.bytedance.android.livesdk.revenue.experience.c r121 = vh6.c.b(com.bytedance.android.livesdk.revenue.experience.c.class);
        if (r121 == null) goto L83;
        Disposable r122 = r121.Vi(RevExpBizScene.DEGRADE_BUSINESS_REVENUE_GIFT_TRAY, new com.bytedance.android.livesdk.gift.platform.business.tray.g());
        if (r122 == null) goto L83;
        RxUtilKt.c(r122, this.j);
    L83:
        com.bytedance.android.livesdk.revenue.experience.c r123 = vh6.c.b(com.bytedance.android.livesdk.revenue.experience.c.class);
        if (r123 == null) goto L89;
        Disposable r124 = r123.Vi(RevExpBizScene.DEGRADE_BUSINESS_REVENUE_GIFT_TRAY_ANIMATION, new h());
        if (r124 == null) goto L90;
        RxUtilKt.c(r124, this.j);
        return;
    L90:
        return;
    L89:
        return;
    L49:
        if (r115.h9() != true) goto L65;
        if (r115.isVSVerticalStream() == false) goto L65;
        BaseGiftTrayAnimationView r9 = this.c;
        boolean r10 = r9 instanceof View;
        if (r10 == false) goto L65;
        if (r10 == true) goto L56;
        BaseGiftTrayAnimationView r11 = null;
    L57:
        if (r11 == null) goto L65;
        ViewGroup.LayoutParams r20 = ((Widget) this).contentView.getLayoutParams();
        if ((r20 instanceof FrameLayout.LayoutParams) == true) goto L61;
        r20 = null;
    L61:
        FrameLayout.LayoutParams r21 = (FrameLayout.LayoutParams) r20;
        if (r21 == null) goto L64;
        r2 = r21.bottomMargin;
    L64:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.vs.a.class).M8(RevPlayViewControl.Key.GiftTray, RevPlayViewControl.Type.BOTTOM, RevPlayViewControl.Style.ATTACH, r11, s1.G(r2) - r115.getVsVerticalProgressBarHeight(), ((Widget) this).dataCenter);
        goto L65
    L56:
        r11 = r9;
    L12:
        r3 = false;
        goto L13
    }

    public final void qo(Boolean r1) {
        this.a = r1;
    }

    public final void zq(f0 r3) {
        if (r3 == null) goto L11;
        ia0.b r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ia0.b.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3.b == false) goto L8;
        DialogStatus r1 = DialogStatus.DIALOG_OPEN;
    L9:
        r0.Gh(r1, r3.a);
        return;
    L8:
        r1 = DialogStatus.DIALOG_CLOSE;
        goto L9
    }

    public static final void xq(GiftTrayWidget r2, String r3) {
        r2.getClass();
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L18;
        IRoom r1 = r2.b;
        if (r1 != null) goto L10;
    L11:
        IRoom r4 = r2.b;
        if (r4 != null) goto L14;
    L16:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).A3(r3, vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).Kh(RevLiveFollowScene.ProfilePublicScreen));
        return;
    L14:
        if (r4.isKoiRoom() != true) goto L16;
        return;
    L10:
        if (r1.isStar() != true) goto L11;
        return;
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void yq(GiftTrayWidget r10, NormalGiftMessage r11) {
        r10.getClass();
        if (r11 == null) goto L9;
        o7 r1 = r11.r();
        if (r1 == null) goto L9;
        o0 r2 = r1.getTrayInfo();
        if (r2 == null) goto L9;
        String r3 = r2.getTraySchemaUrl();
    L10:
        if (r11 == null) goto L14;
        o7 r4 = r11.r();
        if (r4 == null) goto L14;
        o0 r5 = r4.getTrayInfo();
    L16:
        if (r5 == null) goto L18;
        long r6 = r5.getOriginGiftId();
        int r8 = (int) r5.getBuffLevel();
        Triple r7 = new Triple(Long.valueOf(r6), Integer.valueOf(r8), r5.getToolbarCardName());
    L19:
        long r9 = ((Number) r7.component1()).longValue();
        int r13 = ((Number) r7.component2()).intValue();
        String r14 = (String) r7.component3();
        if (r13 != 0) goto L52;
        boolean r15 = true;
        if (r14.length() <= 0) goto L24;
        boolean r16 = true;
    L25:
        if (r16 == true) goto L52;
        if (r3 != null) goto L29;
    L32:
        boolean r17 = true;
    L33:
        if (r17 == true) goto L51;
        if (r11 == null) goto L48;
        h2 r18 = jc1.k.n(IGiftService.class).findLiteGiftById(r11.b);
        if (r18 == null) goto L38;
        k0 r19 = r18.getGiftPreviewInfo();
    L39:
        if (r19 == null) goto L48;
        if (r18.isDisplayedOnPanel() == false) goto L49;
        k0 r20 = r18.getGiftPreviewInfo();
        if (r20 == null) goto L49;
        if (r20.getLockStatus() == k0.UNLOCKED) goto L48;
    L49:
        if (r15 == false) goto L51;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(((Widget) r10).context, r3);
        return;
    L38:
        r19 = null;
    L48:
        r15 = false;
    L51:
        Bq(r11, 0, BuildConfig.FLAVOR, BuildConfig.FLAVOR, null);
        return;
    L29:
        if (r3.length() == 0) goto L32;
        r17 = false;
        goto L33
    L24:
        r16 = false;
    L52:
        h2 r110 = jc1.k.n(IGiftService.class).findLiteGiftById(r9);
        if (r3 != null) goto L55;
        r3 = BuildConfig.FLAVOR;
    L55:
        Bq(r11, r13, r14, r3, r110);
        return;
    L18:
        r7 = new Triple(0L, 0, BuildConfig.FLAVOR);
    L14:
        r5 = null;
    L9:
        r3 = null;
        goto L10
    }

    public final void Cq(int r4, String r5) {
        Objects.toString(this.k);
        if (r4 != 0) goto L5;
        this.k.remove(r5);
    L6:
        IRoom r6 = this.b;
        FrameLayout r7 = null;
        boolean r0 = false;
        int r1 = 8;
        if (r6 == null) goto L13;
        IRoomAuthStatus r8 = r6.getRoomAuthStatus();
        if (r8 == null) goto L13;
        if (r8.getEnableGift() == true) goto L13;
    L16:
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        h02.a r9 = this.l;
        if (r9 == null) goto L19;
        r7 = r9.a;
    L19:
        UIUtils.setViewVisibility(r7, 8);
        BaseGiftTrayAnimationView r10 = this.c;
        if (r10 == null) goto L22;
        r10.setContainerVisible(false);
    L22:
        BaseGiftTrayAnimationView r11 = this.c;
        if (r11 == null) goto L43;
        r11.l(false);
        return;
    L43:
        return;
    L13:
        if (isScreenPortrait() == true) goto L26;
        if (Aq() == false) goto L16;
    L26:
        if (this.k.isEmpty() == false) goto L28;
        r1 = 0;
    L28:
        UIUtils.setViewVisibility(((Widget) this).containerView, r1);
        h02.a r13 = this.l;
        if (r13 == null) goto L31;
        r7 = r13.a;
    L31:
        UIUtils.setViewVisibility(r7, r1);
        BaseGiftTrayAnimationView r14 = this.c;
        if (r14 == null) goto L37;
        if (r1 != 0) goto L35;
        boolean r2 = true;
    L36:
        r14.setContainerVisible(r2);
        goto L37
    L35:
        r2 = false;
    L37:
        BaseGiftTrayAnimationView r15 = this.c;
        if (r15 == null) goto L45;
        if (r1 != 0) goto L41;
        r0 = true;
    L41:
        r15.l(r0);
        return;
    L45:
        return;
    L5:
        this.k.add(r5);
        goto L6
    }

    public static void Bq(NormalGiftMessage r20, int r21, String r23, String r24, h2 r25) {
        h1 r1 = null;
        if (r20 == null) goto L30;
        o7 r2 = r20.r();
        if (r2 == null) goto L30;
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> r4 = r3.getMessageDispatcher();
        if (r4 == null) goto L15;
        if (((com.bytedance.android.livesdk.gift.platform.business.tray2.k) r4.getValue()) == null) goto L15;
        int r5 = com.bytedance.android.livesdk.gift.platform.business.tray2.k.c;
        Intrinsics.checkNotNullParameter(r2, "msg");
        h1 r6 = u.b(r2);
        if (r6 != null) goto L16;
        r6 = (h1) vh7.f.c(h1.class);
    L16:
        r2.setGift(r6);
        if (r2.getGift() != null) goto L30;
        GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r7 == null) goto L27;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> r8 = r7.getMessageDispatcher();
        if (r8 == null) goto L27;
        if (((com.bytedance.android.livesdk.gift.platform.business.tray2.k) r8.getValue()) == null) goto L27;
        int r9 = com.bytedance.android.livesdk.gift.platform.business.tray2.k.c;
        Intrinsics.checkNotNullParameter(r2, "msg");
        h1 r10 = u.b(r2);
        if (r10 != null) goto L28;
        r10 = (h1) vh7.f.c(h1.class);
    L28:
        r2.setGift(r10);
    L27:
        r10 = null;
    L15:
        r6 = null;
    L30:
        if ((r20 instanceof l) == false) goto L32;
        h1 r11 = GiftManagerKt.l(r20.b);
    L37:
        if (r11 == null) goto L61;
        Bundle r13 = new Bundle();
        r13.putString("gift_show_from", "tab");
        if (r20 == null) goto L46;
        o7 r0 = r20.r();
        if (r0 == null) goto L46;
        o0 r14 = r0.getTrayInfo();
        if (r14 == null) goto L46;
        String r15 = r14.getToast();
        if (r15 == null) goto L46;
    L47:
        String r16 = r15;
        GiftContext r17 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r17 == null) goto L54;
        com.bytedance.live.datacontext.m<GiftContext.a> r18 = r17.getLastSendGiftId();
        if (r18 == null) goto L54;
        GiftContext.a r19 = (GiftContext.a) r18.getValue();
        if (r19 == null) goto L54;
        int r26 = r19.c;
    L55:
        xs2.b r27 = xs2.b.a();
        if (r25 == null) goto L58;
        long r28 = r25.getId();
    L59:
        r27.post(new o3(null, new LocateGiftInfo(r26, r28, r16, 1, true, r21, r23, r24, null, 256, null), r13, BuildConfig.FLAVOR, null));
        return;
    L58:
        r28 = r11.getId();
    L54:
        r26 = 0;
    L46:
        r15 = s1.C(2131920721, new Object[]{r11.getName()});
        goto L47
    L61:
        return;
    L32:
        if (r20 == null) goto L36;
        o7 r29 = r20.r();
        if (r29 == null) goto L36;
        r1 = r29.getGift();
    L36:
        r11 = r1;
        goto L37
    }
}
