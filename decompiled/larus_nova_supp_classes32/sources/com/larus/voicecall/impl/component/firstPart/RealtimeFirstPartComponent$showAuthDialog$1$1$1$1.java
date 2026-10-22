package com.larus.voicecall.impl.component.firstPart;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.AuthScene;
import com.larus.platform.api.j5;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.firstPart.RealtimeFirstPartComponent$showAuthDialog$1$1$1$1", f = "RealtimeFirstPartComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeFirstPartComponent$showAuthDialog$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pluginId;
    final /* synthetic */ ChatParam $this_apply;
    int label;
    final /* synthetic */ RealtimeFirstPartComponent this$0;

    public static final class a implements IAiChatOpenDouyinAuthService.c {
        public final /* synthetic */ RealtimeFirstPartComponent a;
        public final /* synthetic */ ChatParam b;
        public final /* synthetic */ com.larus.platform.api.f c;

        public final void onResult(boolean r5) {
            FLogger.a.i("RealtimeFirstPartComponent", "Douyin auth pre asking result: " + r5);
            if (r5 == false) goto L7;
            RealtimeFirstPartComponent r6 = this.a;
            int r1 = RealtimeFirstPartComponent.y;
            IAiChatOpenDouyinAuthService r7 = r6.z3();
            if (r7 == null) goto L12;
            IAiChatOpenDouyinAuthService.a.a(r7, UriProtector.parse(this.b.getJumpUrl()), this.c.a, false, 4);
            return;
        L12:
            return;
        L7:
            m r8 = this.a.w;
            if (r8 == null) goto L10;
            r8.a(false, null);
        L10:
            this.a.s = null;
        }

        public a(RealtimeFirstPartComponent r1, ChatParam r2, com.larus.platform.api.f r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public RealtimeFirstPartComponent$showAuthDialog$1$1$1$1(ChatParam r1, String r2, RealtimeFirstPartComponent r3, Continuation<? super RealtimeFirstPartComponent$showAuthDialog$1$1$1$1> r4) {
        this.$this_apply = r1;
        this.$pluginId = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimeFirstPartComponent$showAuthDialog$1$1$1$1(this.$this_apply, this.$pluginId, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r19);
        String r3 = this.$this_apply.getAnswerId();
        String r4 = this.$this_apply.getPopupText();
        String r7 = this.$this_apply.getJumpUrl();
        com.larus.platform.api.g r1 = new com.larus.platform.api.g(r3, r4, this.$pluginId, this.$this_apply.getBotId(), r7);
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        Message r5 = null;
        if (r2 == null) goto L7;
        r2.K0();
        com.larus.platform.api.f r6 = com.larus.music.i.a.g(r1);
    L9:
        if (r6.e != AuthScene.LocalLife) goto L13;
        IAiChatOpenDouyinAuthService r8 = (IAiChatOpenDouyinAuthService) ServiceManager.get().getService(IAiChatOpenDouyinAuthService.class);
        if (r8 == null) goto L37;
        Boxing.boxBoolean(r8.n(r6.a, r6.b, r6.c, r6.d, new a(this.this$0, this.$this_apply, r6)));
    L37:
        return Unit.INSTANCE;
    L13:
        IFlowSdkDepend r9 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r9 == null) goto L37;
        r9.K0();
        com.larus.music.i r10 = com.larus.music.i.a;
        String r11 = r1.d;
        if (r11 != null) goto L18;
        String r12 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        RealtimeFirstPartComponent r13 = this.this$0;
        int r14 = RealtimeFirstPartComponent.y;
        IAiChatOpenDouyinAuthService r15 = r13.z3();
        if (r15 == null) goto L24;
        Message r16 = r15.i();
        if (r16 == null) goto L24;
        String r17 = r16.getMessageId();
    L25:
        if (r17 != null) goto L27;
        String r18 = NameKeys.UnloadStrategy_No_Strategy;
    L28:
        String r20 = r1.e;
        if (r20 != null) goto L31;
        String r110 = NameKeys.UnloadStrategy_No_Strategy;
    L32:
        AuthScene r111 = r6.e;
        IAiChatOpenDouyinAuthService r21 = this.this$0.z3();
        if (r21 == null) goto L35;
        r5 = r21.i();
    L35:
        r10.j(new j5(r12, false, true, r18, r110, r5, r111, null, null, 384));
        goto L37
    L31:
        r110 = r20;
        goto L32
    L27:
        r18 = r17;
    L24:
        r17 = null;
        goto L25
    L18:
        r12 = r11;
        goto L19
    L7:
        r6 = new com.larus.platform.api.f(null, null, 31);
        goto L9
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
