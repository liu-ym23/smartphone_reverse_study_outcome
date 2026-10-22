package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.domain.streammix.NormalStreamMixStrategy;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.n5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiForegroundComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a c;
    public final MultiRTCBizComponent d;
    public final h e;
    public final com.bytedance.android.live.revlink.link.streaminteract.biz.c f;
    public final yz0.f g;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiForegroundComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(MultiForegroundComponent r8) {
            super(0, r8, MultiForegroundComponent.class, "onResume", "onResume()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m888invoke() {
            MultiForegroundComponent r0 = (MultiForegroundComponent) ((CallableReference) this).receiver;
            MultiRTCBizComponent r1 = r0.d;
            if (r1.k.isEngineOn() == false) goto L5;
            r1.k.onResume();
        L5:
            AnchorLinkUserCenterV2 r2 = com.bytedance.android.live.revlink.link.biz.service.i.t(r0);
            r2.getClass();
            StringBuilder r3 = new StringBuilder("onEnterForeground channelId=");
            LinkCrossRoomDataHolder r4 = r2.G();
            r31.a r5 = null;
            if (r4 == null) goto L8;
            Long r6 = Long.valueOf(r4.c());
        L9:
            r3.append(r6);
            r3.append(' ');
            r3.append(r2.o);
            jy0.b.c("ttlive_anchor_link_users_v2", r3.toString(), null, 4);
            ff2.a r7 = new ff2.a();
            LinkCrossRoomDataHolder r8 = r2.G();
            long r9 = 0;
            if (r8 != null) goto L12;
        L14:
            r7.h(100102);
            cy0.e.a.getClass();
            cy0.j r10 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r12 = com.bytedance.android.scope.m.b(r10).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            Intrinsics.checkNotNull(r12);
            IBaseUser r13 = ((com.bytedance.live.kmp.core.c) r12).b();
            if (r13 == null) goto L18;
            String r14 = r13.getIdString();
            if (r14 == null) goto L18;
        L19:
            r7.d(r14);
            if (r8 == null) goto L22;
            String r15 = r8.e();
        L23:
            r7.c(r15);
            r7.g();
            r7.e();
            r7.f();
            r2.F();
            com.bytedance.android.live.revlink.impl.global.c r16 = r2.s;
            if (r16 == null) goto L26;
            r5 = r16.getLinkNetwork();
        L26:
            if (r5 == null) goto L39;
            if (r8 == null) goto L29;
            r9 = r8.c();
        L29:
            Observable r17 = r5.I(r9, GsonProtectorUtils.toJson(l97.a.a, r7));
            if (r17 == null) goto L39;
            int r18 = com.bytedance.revenue.platform.api.core.rx.p.a;
            Observable r19 = r17.subscribeOn(Schedulers.io());
            if (r19 == null) goto L39;
            Observable r20 = r19.observeOn(AndroidSchedulers.mainThread());
            if (r20 == null) goto L39;
            Disposable r22 = r20.subscribe(com.bytedance.android.live.revlink.impl.plantform.c.a, com.bytedance.android.live.revlink.impl.plantform.d.a);
            if (r22 == null) goto L39;
            r2.g.add(r22);
        L39:
            if (IRoomKt_androidKt.isVirtualLiveKt(r0.getContext().getRoom()) == true) goto L42;
            r0.d.k.muteLocalVideo(false);
            return;
        L42:
            return;
        L22:
            r15 = null;
        L18:
            r14 = "";
            goto L19
        L12:
            if (r8.c() != 0) goto L14;
        L8:
            r6 = null;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m888invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiForegroundComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(MultiForegroundComponent r8) {
            super(0, r8, MultiForegroundComponent.class, "onPause", "onPause()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m889invoke() {
            MultiForegroundComponent r0 = (MultiForegroundComponent) ((CallableReference) this).receiver;
            if (r0.getContext().getCommonService().l() == false) goto L6;
            return;
        L6:
            if (r0.e.j == true) goto L48;
            LiveMode r1 = IRoomKtKt.getStreamType(r0.getContext().getRoom());
            LiveMode r2 = LiveMode.SCREEN_RECORD;
            if (r1 == r2) goto L42;
            r0.d.k.onPause();
            AnchorLinkUserCenterV2 r3 = com.bytedance.android.live.revlink.link.biz.service.i.t(r0);
            r3.getClass();
            StringBuilder r4 = new StringBuilder("onEnterBackground channelId=");
            LinkCrossRoomDataHolder r5 = r3.G();
            r31.a r6 = null;
            if (r5 == null) goto L12;
            Long r7 = Long.valueOf(r5.c());
        L13:
            r4.append(r7);
            r4.append(' ');
            r4.append(r3.o);
            jy0.b.c("ttlive_anchor_link_users_v2", r4.toString(), null, 4);
            ff2.a r8 = new ff2.a();
            LinkCrossRoomDataHolder r9 = r3.G();
            long r10 = 0;
            if (r9 != null) goto L16;
        L18:
            r8.h(100101);
            cy0.e.a.getClass();
            cy0.j r12 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r13 = com.bytedance.android.scope.m.b(r12).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            Intrinsics.checkNotNull(r13);
            IBaseUser r14 = ((com.bytedance.live.kmp.core.c) r13).b();
            if (r14 == null) goto L22;
            String r15 = r14.getIdString();
            if (r15 == null) goto L22;
        L23:
            r8.d(r15);
            if (r9 == null) goto L26;
            String r16 = r9.e();
        L27:
            r8.c(r16);
            r8.g();
            r8.e();
            r8.f();
            r3.F();
            com.bytedance.android.live.revlink.impl.global.c r17 = r3.s;
            if (r17 == null) goto L30;
            r6 = r17.getLinkNetwork();
        L30:
            if (r6 == null) goto L42;
            if (r9 == null) goto L33;
            r10 = r9.c();
        L33:
            Observable r18 = r6.I(r10, GsonProtectorUtils.toJson(l97.a.a, r8));
            if (r18 == null) goto L42;
            int r19 = com.bytedance.revenue.platform.api.core.rx.p.a;
            Observable r20 = r18.subscribeOn(Schedulers.io());
            if (r20 == null) goto L42;
            Observable r22 = r20.observeOn(AndroidSchedulers.mainThread());
            if (r22 == null) goto L42;
            Disposable r23 = r22.subscribe(com.bytedance.android.live.revlink.impl.plantform.a.a, com.bytedance.android.live.revlink.impl.plantform.b.a);
            if (r23 == null) goto L42;
            r3.g.add(r23);
            goto L42
        L26:
            r16 = null;
        L22:
            r15 = "";
            goto L23
        L16:
            if (r9.c() != 0) goto L18;
        L12:
            r7 = null;
        L42:
            MultiRTCBizComponent r24 = r0.d;
            if (IRoomKtKt.getStreamType(r0.getContext().getRoom()) == r2) goto L45;
            boolean r25 = true;
        L46:
            r24.k.muteLocalVideo(r25);
            return;
        L45:
            r25 = false;
            goto L46
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m889invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiForegroundComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/n5;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/n5;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<n5, Unit> {
        public AnonymousClass3(MultiForegroundComponent r8) {
            super(1, r8, MultiForegroundComponent.class, "onLinkSignalMsg", "onLinkSignalMsg(Lcom/bytedance/android/livesdk/link/model/ILinkMicSignalMessage;)V", 0);
        }

        public final void invoke(n5 r5) {
            MultiForegroundComponent r0 = (MultiForegroundComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r5 == null) goto L37;
            Intrinsics.checkNotNullParameter(r5, "$this$linkMicSignal");
            String r6 = r5.getSignal();
            if (r6 == null) goto L13;
            String r7 = new Regex("\\\\").replace(r6, "");
            if (r7 == null) goto L13;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
            ff2.a r8 = (ff2.a) l97.a.a.fromJson(r7, TypesJVMKt.getJavaType(Reflection.typeOf(ff2.a.class)));     // Catch: Throwable -> L11
        L14:
            if (r8 == null) goto L40;
        L31:
            e = move-exception;
            jy0.b.c("MultiOtherComponent", e.toString(), null, 4);
            return;
        L17:
            if (r8.getType() != 100102) goto L24;
            if (r8.b() == null) goto L21;
            String r9 = r8.b();     // Catch: NumberFormatException -> L31
        L22:
            r0.a(r9, true);     // Catch: NumberFormatException -> L31
            return;
        L21:
            r9 = r8.a();     // Catch: NumberFormatException -> L31
            goto L22
        L24:
            if (r8.getType() == 100101) goto L26;
            return;
        L26:
            if (r8.b() == null) goto L28;
            String r10 = r8.b();     // Catch: NumberFormatException -> L31
        L29:
            r0.a(r10, false);     // Catch: NumberFormatException -> L31
            return;
        L28:
            r10 = r8.a();     // Catch: NumberFormatException -> L31
            goto L29
        L40:
            return;
        L11:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L13:
            r8 = null;
            goto L14
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((n5) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(getContext().x7(new AnonymousClass1(this), new AnonymousClass2(this)), this.b);
        yz0.f r0 = this.g;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_SIGNAL");
        Observable r3 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.d.getValue(), false, 6);
        final AnonymousClass3 r4 = new AnonymousClass3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new a(r4)), this.b);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.c;
    }

    public final void a(String r5, boolean r6) {
        StringBuilder r0 = new StringBuilder("onAnchorStateChanged ");
        r0.append(r5);
        r0.append(' ');
        if (r6 == false) goto L5;
        String r1 = "foreground";
    L6:
        r0.append(r1);
        jy0.b.f("ttlive_anchor_link", r0.toString(), null, 4);
        if (this.d.k.isEngineOn() == false) goto L14;
        if (r5 == null) goto L14;
        com.bytedance.android.live.revlink.link.streaminteract.biz.c r2 = this.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "interactId");
        NormalStreamMixStrategy r3 = r2.b;
        if (r3 == null) goto L12;
        Intrinsics.checkNotNullParameter(r5, "interactId");
        r3.e.put(r5, Boolean.valueOf(!r6));
    L12:
        this.f.f.f();
    L14:
        if (r5 == com.bytedance.android.live.revlink.link.biz.service.i.A(this).c()) goto L16;
        h r4 = this.e;
        r4.e = !r6 ? 1 : 0;
    L16:
        com.bytedance.android.live.revlink.link.domain.anchorimpl.m r7 = getContext().im();
        if (r5 != null) goto L19;
        String r8 = "";
    L20:
        r7.a(r8, r6);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r9 = getContext().Ig();
        if (r9 != null) goto L23;
        return;
    L23:
        if (r9.getCloudCollaboratePanelType() != IBattleConfigSetting.BattleCloudCollaboratePanelType.BattleCloudCollaboratePanelType_ThroneFight.ordinal()) goto L41;
        JSONObject r10 = new JSONObject();
        if (r5 != null) goto L27;
        r5 = "";
    L27:
        r10.put("rtc_uid", r5);
        if (r6 == false) goto L30;
        String r12 = "enter_room";
    L31:
        r10.put("status", r12);
        JSONObject r13 = new JSONObject();
        r13.put("action", "user_status_update");
        r13.put(Constants.Keys.DATA, r10);
        IRoom r14 = getContext().getRoom();
        if (r14 == null) goto L37;
        IBaseUser r15 = r14.getOwnerKt();
        if (r15 == null) goto L37;
        String r16 = r15.getIdString();
        if (r16 == null) goto L37;
    L38:
        MultiRTCBizComponent r17 = this.d;
        String r18 = "director_view_stream_x_".concat(r16);
        String r19 = r13.toString();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "linkmicId");
        Intrinsics.checkNotNullParameter(r19, Constants.OperatorKey.MSG);
        r17.k.A(r18, r19);
        return;
    L37:
        r16 = DataType.FALSE;
        goto L38
    L30:
        r12 = "exit_room";
        goto L31
    L41:
        return;
    L19:
        r8 = r5;
        goto L20
    L5:
        r1 = "background";
        goto L6
    }

    public MultiForegroundComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, MultiRTCBizComponent r3, h r4, com.bytedance.android.live.revlink.link.streaminteract.biz.c r5, yz0.f r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rtcBizComponent");
        Intrinsics.checkNotNullParameter(r4, "bizDataContext");
        Intrinsics.checkNotNullParameter(r5, "streamMixManagerService");
        Intrinsics.checkNotNullParameter(r6, "messageService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = "MultiForegroundComponent";
        this.b = new CompositeDisposable();
    }
}
