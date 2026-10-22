package com.larus.uaigc.createpage;

import android.app.Activity;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.community.ICreationPageService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService$openCreationPage$3", f = "CreationPageService.kt", i = {0}, l = {264}, m = "invokeSuspend", n = {"conversationId"}, s = {"L$0"})
final class CreationPageService$openCreationPage$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
    final /* synthetic */ String $previousPage;
    Object L$0;
    int label;
    final /* synthetic */ CreationPageService this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.CreationPageService$openCreationPage$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService$openCreationPage$3$1", f = "CreationPageService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $conversationId;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Ref.ObjectRef<String> r1, Continuation<? super AnonymousClass1> r2) {
            this.$conversationId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$conversationId, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((wc9.e) r1, (Continuation) r2);
        }

        public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r2);
            wc9.e r3 = (wc9.e) this.L$0;
            Ref.ObjectRef<String> r0 = this.$conversationId;
            if (r3 == null) goto L8;
            String r4 = r3.a;
            if (r4 == null) goto L8;
        L9:
            r0.element = r4;
            return Unit.INSTANCE;
        L8:
            r4 = "";
            goto L9
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements zs8.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getChatType() {
            return "default";
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String b() {
            String r0 = this.a;
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public final String getBotId() {
            com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r0 == null) goto L7;
            LaunchInfo r1 = r0.a;
            if (r1 == null) goto L7;
            return r1.W();
        L7:
            return null;
        }

        public final String getEnterMethod() {
            String r0 = this.b;
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public CreationPageService$openCreationPage$3(CreationPageService r1, Activity r2, com.larus.bmhome.actionbar.model.z0 r3, String r4, String r5, String r6, Continuation<? super CreationPageService$openCreationPage$3> r7) {
        this.this$0 = r1;
        this.$activity = r2;
        this.$item = r3;
        this.$previousPage = r4;
        this.$currentPage = r5;
        this.$enterMethod = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CreationPageService$openCreationPage$3(this.this$0, this.$activity, this.$item, this.$previousPage, this.$currentPage, this.$enterMethod, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r24);
    L12:
        CreationPageService r5 = this.this$0;
        Activity r6 = this.$activity;
        com.larus.bmhome.actionbar.model.z0 r7 = this.$item;
        String r15 = (String) r4.element;
        com.larus.bmhome.chat.api.e0 r8 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r8 == null) goto L17;
        LaunchInfo r9 = r8.a;
        if (r9 == null) goto L17;
        r3 = r9.W();
    L17:
        String r10 = this.$previousPage;
        String r11 = this.$currentPage;
        ICreationPageService.b.a(r5, true, r6, r7, new ChatParam(r15, r3, r10, r11, "default", 224), true, null, null, null, null, null, false, new a(r11, this.$enterMethod), null, null, null, null, null, 67092448);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = "";
        CreationPageService r13 = this.this$0;
        AnonymousClass1 r14 = new AnonymousClass1(r12, null);
        this.L$0 = r12;
        this.label = 1;
        if (r13.i(r14, this) != r1) goto L11;
        return r1;
    L11:
        r4 = r12;
        goto L12
    }
}
