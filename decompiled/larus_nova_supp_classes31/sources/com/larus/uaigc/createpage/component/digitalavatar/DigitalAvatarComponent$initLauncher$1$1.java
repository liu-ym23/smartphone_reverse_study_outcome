package com.larus.uaigc.createpage.component.digitalavatar;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.ChatParam;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initLauncher$1$1", f = "DigitalAvatarComponent.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
final class DigitalAvatarComponent$initLauncher$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Uri> $uriList;
    int label;
    final /* synthetic */ DigitalAvatarComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initLauncher$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initLauncher$1$1$1", f = "DigitalAvatarComponent.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Uri> $uriList;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DigitalAvatarComponent this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initLauncher$1$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initLauncher$1$1$1$1", f = "DigitalAvatarComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $conversationId;
            final /* synthetic */ List<Uri> $uriList;
            int label;
            final /* synthetic */ DigitalAvatarComponent this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C00391(DigitalAvatarComponent r1, String r2, List<? extends Uri> r3, Continuation<? super C00391> r4) {
                this.this$0 = r1;
                this.$conversationId = r2;
                this.$uriList = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00391(this.this$0, this.$conversationId, this.$uriList, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L20;
                ResultKt.throwOnFailure(r6);
                com.bytedance.router.i r7 = SmartRouter.buildRoute(s1a.a.c(this.this$0).getContext(), "//flow/upload_digital_avatar");
                String r0 = this.$conversationId;
                r7.c.putExtra("argConversationId", r0);
                Bundle r1 = new Bundle();
                List<Uri> r2 = this.$uriList;
                DigitalAvatarComponent r3 = this.this$0;
                r1.putParcelableArrayList("image_uris", new ArrayList(r2));
                r1.putString("previous_page", "chat");
                r1.putString("replica_create_id", r3.y);
                ny9.s r4 = r3.B3();
                boolean r5 = false;
                if (r4 != null) goto L7;
            L9:
                r1.putBoolean("need_router_to_chat", r5);
                ny9.s r8 = r3.B3();
                if (r8 == null) goto L12;
                String r9 = r8.i();
            L13:
                r1.putString("enter_method", r9);
                if (ICreationAvatarService.a.v() == false) goto L16;
                String r10 = "reset";
            L17:
                r1.putString("scene", r10);
                r7.c.putExtras(r1);
                r7.d = 2130772400;
                r7.e = 2130772399;
                r7.d();
                return Unit.INSTANCE;
            L16:
                r10 = "create";
                goto L17
            L12:
                r9 = null;
                goto L13
            L7:
                if (r4.j() != true) goto L9;
                r5 = true;
                goto L9
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(DigitalAvatarComponent r1, List<? extends Uri> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$uriList = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$uriList, r5);
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
        L46:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            wc9.e r9 = (wc9.e) this.L$0;
            DigitalAvatarComponent r2 = this.this$0;
            int r3 = DigitalAvatarComponent.C;
            ny9.s r4 = r2.B3();
            boolean r5 = false;
            if (r4 != null) goto L11;
        L13:
            boolean r6 = false;
        L15:
            if (r6 == false) goto L19;
            if (r9 == null) goto L18;
            String r10 = r9.a;
        L35:
            if (r10 != null) goto L37;
        L38:
            r5 = true;
        L39:
            if (r5 == true) goto L41;
            MainCoroutineDispatcher r7 = Dispatchers.getMain();
            C00391 r11 = new C00391(this.this$0, r10, this.$uriList, null);
            this.label = 1;
            if (BuildersKt.withContext(r7, r11, this) != r0) goto L46;
            return r0;
        L41:
            return Unit.INSTANCE;
        L37:
            if (r10.length() != 0) goto L39;
        L18:
            r10 = null;
            goto L35
        L19:
            ny9.s r12 = this.this$0.B3();
            if (r12 == null) goto L24;
            ChatParam r13 = r12.c();
            if (r13 == null) goto L24;
            String r14 = r13.a;
        L25:
            if (r14 != null) goto L28;
            r14 = "";
        L28:
            if (r14.length() != 0) goto L30;
            boolean r15 = true;
        L31:
            if (r15 == false) goto L34;
            if (r9 == null) goto L18;
            r10 = r9.a;
            goto L35
        L34:
            r10 = r14;
            goto L35
        L30:
            r15 = false;
        L24:
            r14 = null;
            goto L25
        L11:
            if (r4.j() != true) goto L13;
            r6 = true;
            goto L15
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DigitalAvatarComponent$initLauncher$1$1(DigitalAvatarComponent r1, List<? extends Uri> r2, Continuation<? super DigitalAvatarComponent$initLauncher$1$1> r3) {
        this.this$0 = r1;
        this.$uriList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DigitalAvatarComponent$initLauncher$1$1(this.this$0, this.$uriList, r4);
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
        DigitalAvatarComponent r7 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(r7, this.$uriList, null);
        this.label = 1;
        if (DigitalAvatarComponent.h3(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
