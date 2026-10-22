package com.larus.uaigc.createpage.component.instruction;

import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.trace.DigitalAvatarProcessType;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {}, l = {486}, m = "invokeSuspend", n = {}, s = {})
public final class DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {}, l = {491}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1$1$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $conversationId;
            int label;
            final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

            public C00421(DigitalAvatarInstructionBizAdapter r1, String r2, Continuation<? super C00421> r3) {
                this.this$0 = r1;
                this.$conversationId = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00421(this.this$0, this.$conversationId, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r6);
                com.bytedance.router.i r7 = SmartRouter.buildRoute(DigitalAvatarInstructionBizAdapter.C(this.this$0), "//flow/create_digital_avatar");
                DigitalAvatarInstructionBizAdapter r0 = this.this$0;
                r0.getClass();
                int r1 = CreationHostUiPolicy.f;
                boolean r2 = CreationHostUiPolicy.a.a(((vp8.g) r0).g.getArguments()).a;
                r7.c.putExtra("from_ai_creation_applet", r2);
                int r3 = DigitalAvatarProcessType.BOTH_IMAGE_AND_VIDEO.getId();
                r7.c.putExtra("digital_avatar_process_type", r3);
                r7.c.putExtra("skip_digital_avatar_onboarding", true);
                String r4 = this.$conversationId;
                r7.c.putExtra("argConversationId", r4);
                Bundle r5 = new Bundle();
                DigitalAvatarInstructionBizAdapter r8 = this.this$0;
                r5.putString("previous_page", "chat");
                r5.putString("replica_create_id", r8.m);
                r5.putBoolean("need_router_to_chat", true);
                r5.putString("enter_method", "create_button_panel");
                r7.c.putExtras(r5);
                r7.d = 2130772400;
                r7.e = 2130772399;
                r7.d();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(DigitalAvatarInstructionBizAdapter r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((wc9.e) r1, (Continuation) r2);
        }

        public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            wc9.e r8 = (wc9.e) this.L$0;
            if (r8 == null) goto L11;
            String r9 = r8.a;
        L12:
            if (r9 != null) goto L14;
        L17:
            boolean r3 = true;
        L18:
            if (r3 == true) goto L20;
            MainCoroutineDispatcher r4 = Dispatchers.getMain();
            C00421 r5 = new C00421(this.this$0, r9, null);
            this.label = 1;
            if (BuildersKt.withContext(r4, r5, this) != r0) goto L25;
            return r0;
        L20:
            return Unit.INSTANCE;
        L14:
            if (r9.length() == 0) goto L17;
            r3 = false;
            goto L18
        L11:
            r9 = null;
            goto L12
        }
    }

    public DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1(DigitalAvatarInstructionBizAdapter r1, Continuation<? super DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DigitalAvatarInstructionBizAdapter r6 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(r6, null);
        this.label = 1;
        if (DigitalAvatarInstructionBizAdapter.D(r6, r2, this) != r0) goto L12;
        return r0;
    }
}
