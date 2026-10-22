package com.larus.uaigc.spring.component;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.router.SmartRouter;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.spring.component.SpringMainVenueLynxComponent$jumpToCreateDigitalAvatar$1", f = "SpringMainVenueLynxComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SpringMainVenueLynxComponent$jumpToCreateDigitalAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpringMainVenueLynxComponent this$0;

    public SpringMainVenueLynxComponent$jumpToCreateDigitalAvatar$1(SpringMainVenueLynxComponent r1, Continuation<? super SpringMainVenueLynxComponent$jumpToCreateDigitalAvatar$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SpringMainVenueLynxComponent$jumpToCreateDigitalAvatar$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r5);
        com.larus.bmhome.chat.component.cvs.y r6 = (com.larus.bmhome.chat.component.cvs.y) this.this$0.v.getValue();
        Context r0 = null;
        if (r6 == null) goto L9;
        wc9.e r7 = r6.h();
        if (r7 == null) goto L9;
        String r8 = r7.a;
    L10:
        Fragment r1 = s1a.a.c(this.this$0);
        if (r1 == null) goto L13;
        r0 = r1.getContext();
    L13:
        com.bytedance.router.i r2 = SmartRouter.buildRoute(r0, "//flow/create_digital_avatar");
        r2.c.putExtra("argConversationId", r8);
        r2.c.putExtra("need_router_to_chat", true);
        r2.c.putExtra("is_from_template", "0");
        r2.c.putExtra("enter_create_from", "spring_main_venue");
        r2.c.putExtra("enter_method", "spring_guide_2026");
        r2.c.putExtra("current_page", "spring_guide_2026");
        r2.c.putExtra("click_create_replica_current_page", "spring_guide_2026");
        r2.c.addFlags(268435456);
        r2.e(200);
        FLogger.a.i("SpringMainVenueComponent", "noAvatar so goto create avatar, conversation id: " + r8 + ' ');
        return Unit.INSTANCE;
    L9:
        r8 = null;
        goto L10
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
