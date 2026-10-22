package com.obric.memorydata.markdown.custom;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.markdown.custom.PhoneActions$showMenu$1", f = "CustomActions.kt", i = {}, l = {165, 177}, m = "invokeSuspend", n = {}, s = {})
final class PhoneActions$showMenu$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $decodedNumber;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.markdown.custom.PhoneActions$showMenu$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.markdown.custom.PhoneActions$showMenu$1$1", f = "CustomActions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $decodedNumber;
        final /* synthetic */ boolean $hasContacts;
        final /* synthetic */ List<fx> $rawContacts;
        int label;

        AnonymousClass1(Context r3, boolean r4, String r5, List<fx> r6, Continuation<? super AnonymousClass1> r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            List<fx> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$context = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
            this.$hasContacts = r4;
            this.$decodedNumber = r5;
            this.$rawContacts = r9;
            super(2, r10);
        }

        private static final void invokeSuspend$lambda$0(Context r1, String r2, Ref.ObjectRef r3, View r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
            j.f9994a.a(r5, r2);
            h r6 = (h) ZeusTransformUtils.preCheckCast(r3.element, h.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L6;
            r6.b();
            return;
        }

        private static final void invokeSuspend$lambda$1(Context r2, String r3, Ref.ObjectRef r4, View r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            j.f9994a.a(r6, r3, null);
            h r7 = (h) ZeusTransformUtils.preCheckCast(r4.element, h.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L6;
            r7.b();
            return;
        }

        private static final void invokeSuspend$lambda$2(Context r2, List r3, String r4, Ref.ObjectRef r5, View r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            j.a(j.f9994a, r7, r8, r4, (h) ZeusTransformUtils.preCheckCast(r5.element, h.class, "com.obric.memorydata.plugin"));
        }

        private static final void invokeSuspend$lambda$3(Context r1, String r2, Ref.ObjectRef r3, View r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
            j.f9994a.b(r5, r2);
            h r6 = (h) ZeusTransformUtils.preCheckCast(r3.element, h.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L6;
            r6.b();
            return;
        }

        private static final void invokeSuspend$lambda$4(Context r1, String r2, Ref.ObjectRef r3, View r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
            j.f9994a.c(r5, r2);
            h r6 = (h) ZeusTransformUtils.preCheckCast(r3.element, h.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L6;
            r6.b();
            return;
        }

        public static /* synthetic */ void lambda$1ii3SEZAU_OUdVvH50JKZuDUPkQ(Context r0, String r1, Ref.ObjectRef r2, View r3) {
            invokeSuspend$lambda$3(r0, r1, r2, r3);
        }

        public static /* synthetic */ void lambda$2quZB2kGET9pIdLavIaVl9KnmEA(Context r0, String r1, Ref.ObjectRef r2, View r3) {
            invokeSuspend$lambda$1(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: lambda$9Q2jAq5_MHQz-2R-xF4pLJ-SbQo, reason: not valid java name */
        public static /* synthetic */ void m677lambda$9Q2jAq5_MHQz2RxF4pLJSbQo(Context r0, String r1, Ref.ObjectRef r2, View r3) {
            invokeSuspend$lambda$4(r0, r1, r2, r3);
        }

        public static /* synthetic */ void lambda$DjRhCwSYmXSU4STUPUDk5We8r5M(Context r0, List r1, String r2, Ref.ObjectRef r3, View r4) {
            invokeSuspend$lambda$2(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ void lambda$jsnjx3xeMIfmZelhaVCXeaK88Co(Context r0, String r1, Ref.ObjectRef r2, View r3) {
            invokeSuspend$lambda$0(r0, r1, r2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$context, this.$hasContacts, this.$decodedNumber, this.$rawContacts, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [T, com.obric.memorydata.markdown.custom.h] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r9);
            List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            final Ref.ObjectRef r1 = new Ref.ObjectRef();
            String r2 = this.$context.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_dial, TypedValues.Custom.S_STRING, "markdown_action_dial"));
            Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
            r10.add(r2);
            final Context r3 = this.$context;
            final String r5 = this.$decodedNumber;
            r0.add(new $$Lambda$PhoneActions$showMenu$1$1$jsnjx3xeMIfmZelhaVCXeaK88Co(r3, r5, r1));
            String r4 = this.$context.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_send_sms, TypedValues.Custom.S_STRING, "markdown_action_send_sms"));
            Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
            r10.add(r4);
            final Context r6 = this.$context;
            final String r7 = this.$decodedNumber;
            r0.add(new $$Lambda$PhoneActions$showMenu$1$1$2quZB2kGET9pIdLavIaVl9KnmEA(r6, r7, r1));
            if (this.$hasContacts == false) goto L7;
            String r8 = this.$context.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_view_contact, TypedValues.Custom.S_STRING, "markdown_action_view_contact"));
            Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
            r10.add(r8);
            final Context r11 = this.$context;
            final List<fx> r12 = this.$rawContacts;
            final String r13 = this.$decodedNumber;
            r0.add(new $$Lambda$PhoneActions$showMenu$1$1$DjRhCwSYmXSU4STUPUDk5We8r5M(r11, r12, r13, r1));
        L8:
            String r14 = this.$context.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_copy, TypedValues.Custom.S_STRING, "markdown_action_copy"));
            Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
            r10.add(r14);
            final Context r15 = this.$context;
            final String r16 = this.$decodedNumber;
            r0.add(new $$Lambda$PhoneActions$showMenu$1$1$9Q2jAq5_MHQz2RxF4pLJSbQo(r15, r16, r1));
            ?? r17 = new h(this.$context);
            r17.a(this.$decodedNumber);
            r17.a(r10, r0);
            r17.a();
            r1.element = r17;
            return Unit.INSTANCE;
        L7:
            String r18 = this.$context.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_add_contact, TypedValues.Custom.S_STRING, "markdown_action_add_contact"));
            Intrinsics.checkNotNullExpressionValue(r18, "getString(...)");
            r10.add(r18);
            final Context r19 = this.$context;
            final String r20 = this.$decodedNumber;
            r0.add(new $$Lambda$PhoneActions$showMenu$1$1$1ii3SEZAU_OUdVvH50JKZuDUPkQ(r19, r20, r1));
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    PhoneActions$showMenu$1(String r3, Context r4, Continuation<? super PhoneActions$showMenu$1> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$decodedNumber = r3;
        this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PhoneActions$showMenu$1(this.$decodedNumber, this.$context, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PhoneActions$showMenu$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PhoneActions$showMenu$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L13:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        boolean r7 = !((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        CoroutineContext r13 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$context, r7, this.$decodedNumber, r9, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (kotlinx.coroutines.i.a(r13, r2, r3) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        CoroutineContext r14 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new PhoneActions$showMenu$1$rawContacts$1(this.$decodedNumber, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r12 = kotlinx.coroutines.i.a(r14, r4, r5);
        if (r12 != r0) goto L13;
        return r0;
    }
}
