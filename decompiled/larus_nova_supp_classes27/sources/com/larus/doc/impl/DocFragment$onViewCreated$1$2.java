package com.larus.doc.impl;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$onViewCreated$1$2", f = "DocFragment.kt", i = {0}, l = {536}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
public final class DocFragment$onViewCreated$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ DocFragment this$0;

    /* JADX INFO: renamed from: com.larus.doc.impl.DocFragment$onViewCreated$1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.DocFragment$onViewCreated$1$2$1", f = "DocFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DocFragment this$0;

        public AnonymousClass1(DocFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r2);
            if (this.this$0.isAdded() == false) goto L10;
            Context r3 = this.this$0.getContext();
            if (r3 == null) goto L10;
            this.this$0.ha0(r3);
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.doc.impl.DocFragment$onViewCreated$1$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.DocFragment$onViewCreated$1$2$2", f = "DocFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DocFragment this$0;

        public AnonymousClass2(DocFragment r1, Continuation<? super AnonymousClass2> r2) {
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

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (this.this$0.isAdded() == false) goto L8;
            t19.s r3 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r3.getClass();
            t19.s.s(r0, 2131899581);
            this.this$0.requireActivity().finish();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DocFragment$onViewCreated$1$2(DocFragment r1, Continuation<? super DocFragment$onViewCreated$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DocFragment$onViewCreated$1$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r13 = false;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        long r1 = this.J$0;
        ResultKt.throwOnFailure(r21);
        long r18 = r1;
        Object r2 = r21;
    L35:
        dm9.a.b r3 = (dm9.a) r2;
        FLogger r4 = FLogger.a;
        r4.i("DocFragment", "[createDocByMessage] result:" + r3 + ", network request cost: " + (System.currentTimeMillis() - r18));
        r4.i("[DocTracer]", "DocFragment, after request doc token");
        if ((r3 instanceof dm9.a.b) == false) goto L71;
        dm9.a.b r5 = r3;
        com.larus.office.card.doc.create.b r6 = (com.larus.office.card.doc.create.b) r5.a.getData();
        if (r6 == null) goto L40;
        String r7 = r6.b();
    L41:
        if (r7 != null) goto L43;
    L44:
        r13 = true;
    L45:
        if (r13 == false) goto L48;
        r4.e("DocFragment", "[createDocByMessage] resourceId is null");
        return Unit.INSTANCE;
    L48:
        DocFragment r8 = this.this$0;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r8.f = r7;
        DocFragment r10 = this.this$0;
        com.larus.office.card.doc.create.b r11 = (com.larus.office.card.doc.create.b) r5.a.getData();
        if (r11 == null) goto L51;
        int r12 = r11.c();
    L52:
        r10.m = r12;
        DocFragment r14 = this.this$0;
        com.larus.office.card.doc.create.b r15 = (com.larus.office.card.doc.create.b) r5.a.getData();
        if (r15 == null) goto L55;
        String r16 = r15.a();
    L56:
        r14.G = r16;
        z2 r17 = z2.a;
        if (r17.getDocFusionConfig().a == false) goto L61;
        if (this.this$0.m != 3) goto L61;
    L64:
        DocActivity r20 = this.this$0.getActivity();
        if ((r20 instanceof DocActivity) == false) goto L67;
        DocActivity r22 = r20;
    L68:
        if (r22 == null) goto L70;
        DocFragment r23 = this.this$0;
        r22.y1(r23.f, r23.m);
    L70:
        String r24 = m39.a.a;
        DocFragment r25 = this.this$0;
        String r26 = r25.f;
        String r27 = r25.j;
        Integer r28 = Boxing.boxInt(r25.ga0());
        String r30 = this.this$0.l;
        m39.a.a = r26;
        m39.a.b = r27;
        m39.a.c = r28;
        m39.a.e = r30;
        Intrinsics.checkNotNullParameter(r7, "docId");
        m39.a.a = r7;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(this.this$0, null), 3, null);
    L73:
        return Unit.INSTANCE;
    L67:
        r22 = null;
    L61:
        if (r17.getDocFusionConfig().a == true) goto L70;
        if (this.this$0.m != 10) goto L70;
    L55:
        r16 = null;
        goto L56
    L51:
        r12 = 3;
        goto L52
    L43:
        if (r7.length() != 0) goto L45;
    L40:
        r7 = null;
        goto L41
    L71:
        r4.e("DocFragment", "[createDocByMessage] error:" + r3);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass2(this.this$0, null), 3, null);
        goto L73
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        FLogger.a.i("[DocTracer]", "DocFragment, before request doc token");
        long r31 = System.currentTimeMillis();
        Bundle r32 = this.this$0.getArguments();
        if (r32 == null) goto L12;
        String r33 = r32.getString("key_message_id", null);
        if (r33 == null) goto L12;
    L13:
        Bundle r34 = this.this$0.getArguments();
        if (r34 == null) goto L16;
        boolean r35 = r34.getBoolean("key_is_in_main_conversation", false);
    L17:
        if (r35 == false) goto L19;
        int r36 = 2;
    L20:
        Bundle r37 = this.this$0.getArguments();
        if (r37 == null) goto L27;
        String r38 = r37.getString("key_offline_retry_doc_real_token");
        if (r38 == null) goto L27;
        if ((!StringsKt.isBlank(r38)) == false) goto L27;
        String r40 = r38;
    L28:
        int r41 = com.larus.office.card.doc.create.c.a;
        String r42 = this.this$0.P;
        long r43 = CastLongProtector.parseLong(r33);
        if (z2.a.getDocFusionConfig().a == false) goto L31;
        int r110 = 10;
    L32:
        Boolean r111 = Boxing.boxBoolean(com.larus.utils.o0.d(r40));
        this.J$0 = r31;
        this.label = 1;
        r18 = r31;
        r2 = com.larus.office.card.doc.create.c.a(r42, r43, r110, r36, r40, r111, this);
        if (r2 != r9) goto L35;
        return r9;
    L31:
        r110 = 3;
    L27:
        r40 = null;
        goto L28
    L19:
        r36 = 1;
        goto L20
    L16:
        r35 = false;
    L12:
        r33 = "";
        goto L13
    }
}
