package com.larus.bmhome.chat.component.servicebot;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.auth.TouristModeABParam;
import com.larus.bmhome.auth.h1;
import com.larus.bmhome.auth.i1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.ServiceBotNoticeRepo;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.platform.service.c1;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import hq9.h0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00106\u001a\u00020+H\u0016J\b\u00107\u001a\u00020\"H\u0016J\u0012\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020+H\u0002J\b\u0010;\u001a\u000204H\u0016J\u0010\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020'H\u0002J\u0018\u0010>\u001a\u0002042\u0006\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u000204H\u0002J\b\u0010D\u001a\u000204H\u0002J\b\u0010E\u001a\u00020+H\u0002J\b\u0010F\u001a\u00020+H\u0002J\b\u0010G\u001a\u000204H\u0002J\b\u0010H\u001a\u00020 H\u0002J\b\u0010I\u001a\u00020 H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b*\u0010,R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/larus/bmhome/chat/component/servicebot/ServiceBotComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/component/servicebot/IServiceBotAbility;", "<init>", "()V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "chatFragmentAbility$delegate", "titleAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getTitleAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "titleAbility$delegate", "ivyPoolAbility", "Lcom/larus/bmhome/chat/lynx/IvyPoolAbility;", "getIvyPoolAbility", "()Lcom/larus/bmhome/chat/lynx/IvyPoolAbility;", "ivyPoolAbility$delegate", "titleText", "", "titleBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "getTitleBar", "()Lcom/larus/bmhome/view/NovaTitleBarEx;", "titleBar$delegate", "titleLeftIcon", "Landroid/view/View;", "navigatorConfig", "Lcom/larus/platform/model/ChatNavigatorConfig;", "isSideBar", "", "()Z", "isSideBar$delegate", "titleRedDotView", "Lcom/larus/common_ui/widget/RedDotTextView;", "titleRedDotListener", "Lcom/larus/bmhome/chat/reddot/OnRedDotCountObserver;", "currentTabName", "onCreate", "", "onParentViewCreated", "isServiceBot", "getServiceBotTitleBar", "getBackIconRes", "", "forceBack", "onFragmentViewDestroyed", "ensureTitleRedDotView", "anchor", "applyRoundBadgeStyleIfNeeded", "redDotView", "layoutParams", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "initTitleRedDot", "updateTitleRedDotStyle", "registerTitleRedDotListener", "isShowTitleRedDot", "isLastConversationPage", "addOnBotListener", "getConversationId", "getCurrentBotId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ServiceBotComponent extends ComponentFeature implements com.larus.bmhome.chat.component.servicebot.a {
    public static final /* synthetic */ int u = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public String m;
    public final Lazy n;
    public View o;
    public final h0 p;
    public final Lazy q;
    public RedDotTextView r;
    public com.larus.bmhome.chat.reddot.a s;
    public String t;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.servicebot.ServiceBotComponent$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.servicebot.ServiceBotComponent$onCreate$2", f = "ServiceBotComponent.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_12}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ServiceBotComponent this$0;

        public AnonymousClass2(ServiceBotComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L31:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            ServiceBotComponent r8 = this.this$0;
            int r2 = ServiceBotComponent.u;
            String r9 = r8.N2();
            boolean r3 = false;
            if (r9.length() != 0) goto L11;
            boolean r4 = true;
        L12:
            if (r4 == true) goto L14;
            ServiceBotNoticeRepo.a.getClass();
            Intrinsics.checkNotNullParameter(r9, "botId");
            String r5 = ServiceBotNoticeRepo.e(r9);
            if (Intrinsics.areEqual(ServiceBotNoticeRepo.c, r5) == true) goto L18;
        L20:
            String r6 = ServiceBotNoticeRepo.g().getString(r5, null);
            if (r6 != null) goto L23;
        L24:
            r3 = true;
        L25:
            boolean r10 = !r3;
        L26:
            if (r10 == true) goto L31;
            this.label = 1;
            if (ServiceBotNoticeRepo.d(r9, this) != r0) goto L31;
            return r0;
        L23:
            if (r6.length() != 0) goto L25;
        L18:
            if (ServiceBotNoticeRepo.d == null) goto L20;
            r10 = true;
            goto L26
        L14:
            return Unit.INSTANCE;
        L11:
            r4 = false;
            goto L12
        }
    }

    static {
    }

    public final void A2() {
        com.larus.bmhome.chat.reddot.a r0 = this.s;
        if (r0 == null) goto L5;
        com.larus.bmhome.chat.reddot.f r1 = com.larus.bmhome.chat.reddot.f.a;
        com.larus.bmhome.chat.reddot.f.e(r0);
    L5:
        this.s = null;
    }

    public final void B2() {
        eh8.c r0 = (eh8.c) this.l.getValue();
        if (r0 == null) goto L5;
        r0.rG();
    L5:
        ry8.b r1 = (ry8.b) this.k.getValue();
        if (r1 == null) goto L9;
        r1.hz();
    L9:
        if (this.p.a == false) goto L92;
        de8.c r2 = f1();
        boolean r3 = false;
        if (r2 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == true) goto L24;
        RedDotTextView r5 = this.r;
        if (r5 == null) goto L21;
        r5.setDotInvisible(true);
    L21:
        RedDotTextView r6 = this.r;
        if (r6 == null) goto L92;
        r6.setVisibility(4);
        goto L92
    L24:
        RepoDispatcher.a.getClass();
        Pair r7 = (Pair) RepoDispatcher.d.c.getValue();
        if (r7 == null) goto L27;
        String r8 = (String) r7.getSecond();
    L28:
        this.t = r8;
        if (z2.a.enableChatWithTab() == false) goto L31;
        int r9 = 2;
    L32:
        RedDotTextView r10 = this.r;
        if (r10 == null) goto L35;
        r10.setRedDotBG(r9);
    L35:
        com.larus.bmhome.chat.reddot.a r11 = this.s;
        if (r11 == null) goto L38;
        com.larus.bmhome.chat.reddot.f r12 = com.larus.bmhome.chat.reddot.f.a;
        com.larus.bmhome.chat.reddot.f.e(r11);
    L38:
        this.s = null;
        if (i3.a.f() == false) goto L54;
        i1 r13 = h1.a();
        if (r13 == null) goto L50;
        TouristModeABParam r14 = r13.b;
        if (r14 == null) goto L50;
        Integer r15 = r14.getType();
        if (r15 == null) goto L50;
        if (r15.intValue() != 1) goto L50;
        boolean r16 = true;
    L51:
        if (r16 == false) goto L54;
    L89:
        if (r3 == false) goto L92;
        com.larus.bmhome.chat.reddot.a r17 = new com.larus.bmhome.chat.reddot.a(new o(this));
        com.larus.bmhome.chat.reddot.f r18 = com.larus.bmhome.chat.reddot.f.a;
        com.larus.bmhome.chat.reddot.f.d(r17);
        this.s = r17;
    L50:
        r16 = false;
    L54:
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L57;
        r3 = this.p.h;
        goto L89
    L57:
        if (Intrinsics.areEqual(this.t, "CONVERSATION") == true) goto L96;
    L74:
        boolean r19 = false;
    L75:
        de8.c r20 = f1();
        if (r20 != null) goto L78;
    L80:
        boolean r21 = false;
    L81:
        if (r21 == true) goto L83;
    L85:
        boolean r22 = false;
    L86:
        if (r19 == true) goto L88;
        if (r22 == false) goto L89;
    L88:
        r3 = true;
        goto L89
    L83:
        if (z2.a.isLazyMainComponentEnable() == false) goto L85;
        r22 = true;
        goto L86
    L78:
        if (r20.w() != true) goto L80;
        r21 = true;
        goto L81
    L96:
        List r23 = AppHost.a.a().g();     // Catch: Exception -> L69
        if ((CollectionsKt.lastOrNull(r23) instanceof j4) == false) goto L62;
    L71:
        boolean r24 = true;
    L72:
        if (r24 == false) goto L74;
        r19 = true;
        goto L75
    L62:
        if (r23.size() <= 1) goto L68;
        ComponentCallbacks2 r25 = (Activity) ListProtector.get(r23, r23.size() - 2);     // Catch: Exception -> L69
        if ((r25 instanceof j4) == false) goto L68;
        if (((j4) r25).c0() == false) goto L71;
    L68:
        r24 = false;
    L69:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e, "isLastConversationPage Crash");
        goto L71
    L31:
        r9 = 1;
        goto L32
    L27:
        r8 = null;
        goto L28
    L14:
        if (r2.l != true) goto L16;
        r4 = true;
    L92:
        m r26 = new m(this);
        y r27 = (y) this.i.getValue();
        if (r27 == null) goto L98;
        r27.ll(new l(), r26);
        return;
    }

    public final NovaTitleBarEx P2() {
        return (NovaTitleBarEx) this.n.getValue();
    }

    public final de8.c f1() {
        return (de8.c) this.h.getValue();
    }

    public final void onCreate() {
        c1 r0 = c1.a;
        if (r0.d() == true) goto L5;
        r0.f();
    L5:
        de8.c r1 = f1();
        if (r1 == null) goto L38;
        Bundle r2 = r1.b;
        if (r2 == null) goto L10;
        Integer r3 = Integer.valueOf(r2.getInt("argBotConversationType"));
    L11:
        Bundle r4 = r1.b;
        if (r4 == null) goto L14;
        Integer r5 = Integer.valueOf(r4.getInt("argBotType"));
    L15:
        de8.c r6 = f1();
        if (r6 == null) goto L18;
        String r7 = r6.f();
    L19:
        de8.c r8 = f1();
        if (r8 == null) goto L26;
        Bundle r9 = r8.b;
        if (r9 == null) goto L25;
        String r10 = r9.getString("argChatTitle");
        if (r10 == null) goto L25;
    L27:
        this.m = r10;
        if (r3 != null) goto L31;
    L32:
        if (r5 != null) goto L35;
    L36:
        com.larus.platform.service.g.a.ensureNotReachHere("service bot args inconsistent");
    L37:
        FLogger.a.i("ServiceBotComponent", "init botConversationType=" + r3 + " botType=" + r5 + " botId=" + r7 + " title=" + this.m);
        goto L38
    L35:
        if (r5.intValue() == 4) goto L37;
    L31:
        if (r3.intValue() == 6) goto L37;
    L25:
        r10 = "";
        goto L27
    L26:
        r10 = null;
        goto L27
    L18:
        r7 = null;
        goto L19
    L14:
        r5 = null;
        goto L15
    L10:
        r3 = null;
    L38:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public ServiceBotComponent() {
        this.h = LazyKt.lazy(new e(this));
        this.i = LazyKt.lazy(new f(this));
        this.j = LazyKt.lazy(new g(this));
        this.k = LazyKt.lazy(new h(this));
        this.l = LazyKt.lazy(new i(this));
        this.n = LazyKt.lazy(new j(this));
        this.p = z2.a.getChatNavigatorConfig();
        this.q = LazyKt.lazy(new k(this));
    }

    @Override // com.larus.bmhome.chat.component.servicebot.a
    public final boolean E8() {
        de8.c r0 = f1();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.E() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final String L2() {
        de8.c r0 = f1();
        if (r0 == null) goto L11;
        String r1 = r0.h();
        if (r1 == null) goto L11;
        if (o0.d(r1) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L11;
        return r1;
    L11:
        y r2 = (y) this.i.getValue();
        if (r2 != null) goto L17;
        return "";
    L17:
        return r2.Y1();
    }

    public final String N2() {
        de8.c r0 = f1();
        if (r0 == null) goto L11;
        String r1 = r0.f();
        if (r1 == null) goto L11;
        if (o0.d(r1) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L11;
        return r1;
    L11:
        y r2 = (y) this.i.getValue();
        if (r2 != null) goto L17;
        return "";
    L17:
        return r2.getBotId();
    }

    @Override // com.larus.bmhome.chat.component.servicebot.a
    public final NovaTitleBarEx O10() {
        final NovaTitleBarEx r7 = P2();
        final View r0 = NovaTitleBarEx.b6(r7, F2(false), false, null, null, new b(this), 14);
        this.o = r0;
        if (this.p.a == true) goto L6;
    L16:
        de8.c r1 = f1();
        String r2 = "";
        if (r1 == null) goto L24;
        Bundle r3 = r1.b;
        if (r3 == null) goto L24;
        String r4 = r3.getString("argChatTitle");
        if (r4 == null) goto L24;
        r2 = r4;
    L24:
        NovaTitleBarEx.Y5(r7, r2, null, null, 6);
        r7.setVisibility(8);
        NovaTitleBarEx.i6(r7, v19.c.b(2130971847, r7.getContext(), 2131242049), null, null, new d(r7, this), 14);
        FLogger.a.i("ServiceBotComponent", "getServiceBotTitleBar " + r7);
        return r7;
    L6:
        if (this.r != null) goto L16;
        if (r0.getId() != (-1)) goto L11;
        r0.setId(View.generateViewId());
    L11:
        Context r5 = P2().getContext();
        Intrinsics.checkNotNull(r5);
        RedDotTextView r6 = new RedDotTextView(r5);
        r6.setId(View.generateViewId());
        r6.setIncludeFontPadding(false);
        r6.setGravity(17);
        r6.setTextColor(ContextCompat.getColor(r5, 2131103298));
        r6.setTextSize(0, r6.getResources().getDimension(v19.c.b(2130971163, null, 2131166696)));
        r6.setTypeface(r6.getTypeface(), 1);
        r6.setVisibility(8);
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(-2, -2);
        r8.startToStart = 0;
        r8.topToTop = r0.getId();
        r8.bottomToBottom = r0.getId();
        r8.setMarginStart(r5.getResources().getDimensionPixelSize(v19.c.b(2130971368, null, 2131167106)));
        if (this.p.g != 1) goto L15;
        r6.setForceCircleBadgeDiameter(Integer.valueOf(i5.v()));
        r6.setTextSize(0, i5.g());
        ((ViewGroup.MarginLayoutParams) r8).width = i5.v();
        ((ViewGroup.MarginLayoutParams) r8).height = i5.v();
        FLogger.a.i("ServiceBotComponent", "[applyRoundBadgeStyleIfNeeded] apply badgeStyle=1 for service bot red dot");
    L15:
        P2().addView(r6, r8);
        e1.d(r6, new c(r0));
        this.r = r6;
        goto L16
    }

    public final int F2(boolean r3) {
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L7;
        if (r3 == true) goto L7;
        return v19.c.b(2130971852, getContext(), 2131242079);
    L7:
        return v19.c.b(2130971749, getContext(), 2131241477);
    }
}
