package com.larus.avlink.plugins;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.AuthScene;
import com.larus.platform.api.j5;
import com.larus.voicecall.api.bean.ChatParam;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraFirstPartyAuthPlugin$showAuthDialog$1$1$1", f = "DoraFirstPartyAuthPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFirstPartyAuthPlugin$showAuthDialog$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pluginId;
    final /* synthetic */ ChatParam $this_apply;
    int label;
    final /* synthetic */ DoraFirstPartyAuthPlugin this$0;

    public static final class a implements IAiChatOpenDouyinAuthService.c {
        public final /* synthetic */ DoraFirstPartyAuthPlugin a;
        public final /* synthetic */ ChatParam b;
        public final /* synthetic */ com.larus.platform.api.f c;

        @Override // com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService.c
        public final void onResult(boolean r5) {
            DoraFirstPartyAuthPlugin r0 = this.a;
            int r1 = DoraFirstPartyAuthPlugin.q;
            IAiChatOpenDouyinAuthService r2 = r0.o3();
            if (r2 == null) goto L5;
            r2.g();
        L5:
            com.larus.avlink.n1.d(this.a.f, "Pre asking result: " + r5);
            if (r5 == true) goto L8;
            DoraFirstPartyAuthPlugin r6 = this.a;
            v0 r3 = r6.i;
            if (r3 == null) goto L20;
            IAiChatOpenDouyinAuthService r7 = r6.o3();
            if (r7 == null) goto L18;
            Message r8 = r7.i();
        L19:
            r3.a(false, r8);
            goto L20
        L18:
            r8 = null;
        L20:
            this.a.h = null;
            return;
        L8:
            if (this.a.i3() == false) goto L10;
            this.a.q3().O();
        L10:
            IAiChatOpenDouyinAuthService r9 = this.a.o3();
            if (r9 == null) goto L22;
            IAiChatOpenDouyinAuthService.a.a(r9, UriProtector.parse(this.b.getJumpUrl()), this.c.a, false, 4);
            return;
        }

        public a(DoraFirstPartyAuthPlugin r1, ChatParam r2, com.larus.platform.api.f r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public DoraFirstPartyAuthPlugin$showAuthDialog$1$1$1(ChatParam r1, String r2, DoraFirstPartyAuthPlugin r3, Continuation<? super DoraFirstPartyAuthPlugin$showAuthDialog$1$1$1> r4) {
        this.$this_apply = r1;
        this.$pluginId = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraFirstPartyAuthPlugin$showAuthDialog$1$1$1(this.$this_apply, this.$pluginId, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.avlink.plugins.x0] */
    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r19);
        String r3 = this.$this_apply.getAnswerId();
        String r4 = this.$this_apply.getPopupText();
        String r7 = this.$this_apply.getJumpUrl();
        String r6 = this.$this_apply.getBotId();
        com.larus.platform.api.g r1 = new com.larus.platform.api.g(r3, r4, this.$pluginId, r6, r7);
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        Message r5 = null;
        if (r2 == null) goto L7;
        r2.K0();
        com.larus.platform.api.f r8 = com.larus.music.i.a.g(r1);
    L9:
        if (r8.e != AuthScene.LocalLife) goto L13;
        IAiChatOpenDouyinAuthService r9 = (IAiChatOpenDouyinAuthService) ServiceManager.get().getService(IAiChatOpenDouyinAuthService.class);
        if (r9 == null) goto L28;
        Boxing.boxBoolean(r9.n(r8.a, r8.b, r8.c, r8.d, new a(this.this$0, this.$this_apply, r8)));
    L28:
        return Unit.INSTANCE;
    L13:
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L28;
        r10.K0();
        com.larus.music.i r11 = com.larus.music.i.a;
        String r12 = r1.d;
        if (r12 != null) goto L18;
        String r13 = "";
    L19:
        String r14 = r1.e;
        if (r14 != null) goto L22;
        String r15 = "";
    L23:
        AuthScene r16 = r8.e;
        DoraFirstPartyAuthPlugin r17 = this.this$0;
        int r18 = DoraFirstPartyAuthPlugin.q;
        IAiChatOpenDouyinAuthService r20 = r17.o3();
        if (r20 == null) goto L26;
        r5 = r20.i();
    L26:
        final DoraFirstPartyAuthPlugin r21 = this.this$0;
        r11.j(new j5(r13, false, true, "", r15, r5, r16, null, new x0(r21), 128));
        goto L28
    L22:
        r15 = r14;
        goto L23
    L18:
        r13 = r12;
        goto L19
    L7:
        r8 = new com.larus.platform.api.f(null, null, 31);
        goto L9
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
