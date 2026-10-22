package com.larus.uaigc.createpage;

import android.app.Activity;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.platform.service.z2;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService$openCreationPage$2", f = "CreationPageService.kt", i = {0}, l = {206}, m = "invokeSuspend", n = {"conversationId"}, s = {"L$0"})
final class CreationPageService$openCreationPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
    final /* synthetic */ String $previousPage;
    Object L$0;
    int label;
    final /* synthetic */ CreationPageService this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.CreationPageService$openCreationPage$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService$openCreationPage$2$1", f = "CreationPageService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            return "ai_generate_feed_image";
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

    public static final class b implements zs8.a {
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

        public b(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public CreationPageService$openCreationPage$2(CreationPageService r1, com.larus.bmhome.actionbar.model.z0 r2, Activity r3, String r4, String r5, String r6, Continuation<? super CreationPageService$openCreationPage$2> r7) {
        this.this$0 = r1;
        this.$item = r2;
        this.$activity = r3;
        this.$previousPage = r4;
        this.$currentPage = r5;
        this.$enterMethod = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CreationPageService$openCreationPage$2(this.this$0, this.$item, this.$activity, this.$previousPage, this.$currentPage, this.$enterMethod, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r81) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = null;
        boolean r5 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r81);
    L12:
        com.larus.bmhome.actionbar.model.r r6 = this.$item.q;
        if (r6 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == false) goto L46;
        Activity r9 = this.$activity;
        String r8 = this.$previousPage;
        String r10 = this.$currentPage;
        com.larus.bmhome.actionbar.model.z0 r11 = this.$item;
        String r12 = this.$enterMethod;
        s0 r60 = s0.a;
        String r13 = (String) r4.element;
        com.larus.bmhome.chat.api.e0 r14 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r14 == null) goto L24;
        LaunchInfo r15 = r14.a;
        if (r15 == null) goto L24;
        r3 = r15.W();
    L24:
        String r16 = r3;
        if (r8 != null) goto L27;
        String r17 = "";
    L28:
        if (r10 != null) goto L30;
        String r18 = "";
    L31:
        ChatParam r36 = new ChatParam(r13, r16, r17, r18, "default", 224);
        com.larus.bmhome.actionbar.model.r r19 = r11.q;
        if (r19 == null) goto L39;
        Integer r20 = r19.a;
        if (r20 == null) goto L39;
        if (r20.intValue() != 18) goto L39;
        boolean r21 = true;
    L40:
        if (r21 == false) goto L42;
    L45:
        ny9.b r22 = new ny9.b(false, r9, r11, r36, true, false, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, new a(r10, r12), null, null, false, null, null, null, r5, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -270532639, 262143);
        r60.getClass();
        s0.d(r22);
    L61:
        return Unit.INSTANCE;
    L42:
        if (z2.a.f1().f() == false) goto L45;
        r5 = false;
    L39:
        r21 = false;
        goto L40
    L30:
        r18 = r10;
        goto L31
    L27:
        r17 = r8;
        goto L28
    L46:
        CreationPageService r23 = this.this$0;
        Activity r24 = this.$activity;
        com.larus.bmhome.actionbar.model.z0 r25 = this.$item;
        String r26 = (String) r4.element;
        com.larus.bmhome.chat.api.e0 r27 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r27 == null) goto L51;
        LaunchInfo r28 = r27.a;
        if (r28 == null) goto L51;
        r3 = r28.W();
    L51:
        String r29 = r3;
        String r30 = this.$previousPage;
        if (r30 != null) goto L54;
        String r110 = "";
    L55:
        String r31 = this.$currentPage;
        if (r31 != null) goto L58;
        String r111 = "";
    L59:
        ICreationPageService.b.a(r23, true, r24, r25, new ChatParam(r26, r29, r110, r111, "default", 224), true, null, null, null, null, null, false, new b(r31, this.$enterMethod), null, null, null, null, null, 67092448);
        goto L61
    L58:
        r111 = r31;
        goto L59
    L54:
        r110 = r30;
        goto L55
    L15:
        if (r6.f() != true) goto L17;
        r7 = true;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r81);
        Ref.ObjectRef r32 = new Ref.ObjectRef();
        r32.element = "";
        CreationPageService r33 = this.this$0;
        AnonymousClass1 r34 = new AnonymousClass1(r32, null);
        this.L$0 = r32;
        this.label = 1;
        if (r33.i(r34, this) != r1) goto L11;
        return r1;
    L11:
        r4 = r32;
        goto L12
    }
}
