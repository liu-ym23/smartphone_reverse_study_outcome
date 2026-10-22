package com.larus.uaigc.createpage.component.instruction;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.uaigc.service.ICreationAvatarService;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$onAttach$1$1$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
public final class DigitalAvatarInstructionBizAdapter$onAttach$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Uri> $uris;
    int label;
    final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$onAttach$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$onAttach$1$1$1$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Uri> $uris;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$onAttach$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.DigitalAvatarInstructionBizAdapter$onAttach$1$1$1$1$1", f = "DigitalAvatarInstructionBizAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $conversationId;
            final /* synthetic */ List<Uri> $uris;
            int label;
            final /* synthetic */ DigitalAvatarInstructionBizAdapter this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C00411(DigitalAvatarInstructionBizAdapter r1, String r2, List<? extends Uri> r3, Continuation<? super C00411> r4) {
                this.this$0 = r1;
                this.$conversationId = r2;
                this.$uris = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00411(this.this$0, this.$conversationId, this.$uris, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r5);
                DigitalAvatarInstructionBizAdapter r6 = this.this$0;
                int r0 = DigitalAvatarInstructionBizAdapter.s;
                com.bytedance.router.i r7 = SmartRouter.buildRoute(((vp8.g) r6).g.getContext(), "//flow/upload_digital_avatar");
                String r1 = this.$conversationId;
                r7.c.putExtra("argConversationId", r1);
                Bundle r2 = new Bundle();
                List<Uri> r3 = this.$uris;
                DigitalAvatarInstructionBizAdapter r4 = this.this$0;
                r2.putParcelableArrayList("image_uris", new ArrayList(r3));
                r2.putString("previous_page", "chat");
                r2.putString("replica_create_id", r4.m);
                r2.putBoolean("need_router_to_chat", true);
                r2.putString("enter_method", "create_button_panel");
                if (ICreationAvatarService.a.v() == false) goto L7;
                String r8 = "reset";
            L8:
                r2.putString("scene", r8);
                r7.c.putExtras(r2);
                r7.d = 2130772400;
                r7.e = 2130772399;
                r7.d();
                return Unit.INSTANCE;
            L7:
                r8 = "create";
                goto L8
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(DigitalAvatarInstructionBizAdapter r1, List<? extends Uri> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$uris = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$uris, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((wc9.e) r1, (Continuation) r2);
        }

        public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            wc9.e r9 = (wc9.e) this.L$0;
            if (r9 == null) goto L11;
            String r10 = r9.a;
        L12:
            if (r10 != null) goto L14;
        L17:
            boolean r3 = true;
        L18:
            if (r3 == true) goto L20;
            MainCoroutineDispatcher r4 = Dispatchers.getMain();
            C00411 r5 = new C00411(this.this$0, r10, this.$uris, null);
            this.label = 1;
            if (BuildersKt.withContext(r4, r5, this) != r0) goto L25;
            return r0;
        L20:
            return Unit.INSTANCE;
        L14:
            if (r10.length() == 0) goto L17;
            r3 = false;
            goto L18
        L11:
            r10 = null;
            goto L12
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DigitalAvatarInstructionBizAdapter$onAttach$1$1$1(DigitalAvatarInstructionBizAdapter r1, List<? extends Uri> r2, Continuation<? super DigitalAvatarInstructionBizAdapter$onAttach$1$1$1> r3) {
        this.this$0 = r1;
        this.$uris = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DigitalAvatarInstructionBizAdapter$onAttach$1$1$1(this.this$0, this.$uris, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DigitalAvatarInstructionBizAdapter r7 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(r7, this.$uris, null);
        this.label = 1;
        if (DigitalAvatarInstructionBizAdapter.D(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
