package com.larus.voicecall.impl.component.firstPart;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.AuthScene;
import com.larus.platform.api.j5;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.firstPart.RealtimeFirstPartComponent$observePluginAuthMessage$1$1", f = "RealtimeFirstPartComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeFirstPartComponent$observePluginAuthMessage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $authInfo;
    final /* synthetic */ String $jumpUrl;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $pluginId;
    final /* synthetic */ String $popupText;
    int label;
    final /* synthetic */ RealtimeFirstPartComponent this$0;

    public static final class a implements IAiChatOpenDouyinAuthService.c {
        public final /* synthetic */ RealtimeFirstPartComponent a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.larus.platform.api.f c;
        public final /* synthetic */ Message d;

        public final void onResult(boolean r5) {
            if (r5 == false) goto L7;
            RealtimeFirstPartComponent r6 = this.a;
            int r1 = RealtimeFirstPartComponent.y;
            IAiChatOpenDouyinAuthService r7 = r6.z3();
            if (r7 == null) goto L11;
            IAiChatOpenDouyinAuthService.a.a(r7, UriProtector.parse(this.b), this.c.a, false, 4);
            return;
        L11:
            return;
        L7:
            m r8 = this.a.w;
            if (r8 == null) goto L13;
            r8.a(false, this.d);
            return;
        }

        public a(RealtimeFirstPartComponent r1, String r2, com.larus.platform.api.f r3, Message r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public RealtimeFirstPartComponent$observePluginAuthMessage$1$1(Message r1, JSONObject r2, String r3, RealtimeFirstPartComponent r4, String r5, String r6, Continuation<? super RealtimeFirstPartComponent$observePluginAuthMessage$1$1> r7) {
        this.$message = r1;
        this.$authInfo = r2;
        this.$pluginId = r3;
        this.this$0 = r4;
        this.$popupText = r5;
        this.$jumpUrl = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new RealtimeFirstPartComponent$observePluginAuthMessage$1$1(this.$message, this.$authInfo, this.$pluginId, this.this$0, this.$popupText, this.$jumpUrl, r10);
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
        String r3 = this.$message.getMessageId();
        String r7 = this.$authInfo.optString("jump_url");
        String r5 = this.$pluginId;
        Intrinsics.checkNotNull(r5);
        RealtimeFirstPartComponent r1 = this.this$0;
        int r2 = RealtimeFirstPartComponent.y;
        com.larus.platform.api.g r4 = new com.larus.platform.api.g(r3, this.$popupText, r5, ((h88.a) ((e3a.a) r1.n.getValue())).d, r7);
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        Message r8 = null;
        if (r6 == null) goto L7;
        r6.K0();
        com.larus.platform.api.f r9 = com.larus.music.i.a.g(r4);
    L9:
        if (r9.e != AuthScene.LocalLife) goto L13;
        IAiChatOpenDouyinAuthService r10 = (IAiChatOpenDouyinAuthService) ServiceManager.get().getService(IAiChatOpenDouyinAuthService.class);
        if (r10 == null) goto L37;
        Boxing.boxBoolean(r10.n(r9.a, r9.b, r9.c, r9.d, new a(this.this$0, this.$jumpUrl, r9, this.$message)));
    L37:
        return Unit.INSTANCE;
    L13:
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L37;
        r11.K0();
        com.larus.music.i r12 = com.larus.music.i.a;
        String r13 = r4.d;
        if (r13 != null) goto L18;
        String r14 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        IAiChatOpenDouyinAuthService r15 = this.this$0.z3();
        if (r15 == null) goto L24;
        Message r16 = r15.i();
        if (r16 == null) goto L24;
        String r17 = r16.getMessageId();
    L25:
        if (r17 != null) goto L27;
        String r18 = NameKeys.UnloadStrategy_No_Strategy;
    L28:
        String r20 = r4.e;
        if (r20 != null) goto L31;
        String r110 = NameKeys.UnloadStrategy_No_Strategy;
    L32:
        AuthScene r111 = r9.e;
        IAiChatOpenDouyinAuthService r21 = this.this$0.z3();
        if (r21 == null) goto L35;
        r8 = r21.i();
    L35:
        r12.j(new j5(r14, false, true, r18, r110, r8, r111, null, null, 384));
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
        r14 = r13;
        goto L19
    L7:
        r9 = new com.larus.platform.api.f(null, null, 31);
        goto L9
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
