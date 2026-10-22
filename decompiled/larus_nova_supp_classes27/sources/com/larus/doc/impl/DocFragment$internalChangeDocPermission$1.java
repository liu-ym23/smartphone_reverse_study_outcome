package com.larus.doc.impl;

import android.content.Context;
import com.larus.doc.impl.operation.DocOpManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$internalChangeDocPermission$1", f = "DocFragment.kt", i = {}, l = {2948, 2949}, m = "invokeSuspend", n = {}, s = {})
final class DocFragment$internalChangeDocPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPublic;
    int label;
    final /* synthetic */ DocFragment this$0;

    /* JADX INFO: renamed from: com.larus.doc.impl.DocFragment$internalChangeDocPermission$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.DocFragment$internalChangeDocPermission$1$1", f = "DocFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isPublic;
        final /* synthetic */ dm9.a<Object> $result;
        int label;
        final /* synthetic */ DocFragment this$0;

        public AnonymousClass1(dm9.a<? extends Object> r1, DocFragment r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.$result = r1;
            this.this$0 = r2;
            this.$isPublic = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$result, this.this$0, this.$isPublic, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r7);
            dm9.a.b r8 = this.$result;
            if ((r8 instanceof dm9.a.b) == true) goto L7;
        L13:
            t19.s r9 = t19.s.a;
            Context r0 = this.this$0.getContext();
            r9.getClass();
            t19.s.s(r0, 2131899587);
            DocFragment.V90(this.this$0, false, this.$isPublic);
        L15:
            return Unit.INSTANCE;
        L7:
            if (r8.a.getCode() != 0) goto L13;
            t19.s r10 = t19.s.a;
            Context r1 = this.this$0.getContext();
            if (this.$isPublic == false) goto L11;
            int r2 = 2131899589;
        L12:
            r10.getClass();
            t19.s.o(r1, r2, false);
            DocFragment.V90(this.this$0, true, this.$isPublic);
            goto L15
        L11:
            r2 = 2131899591;
            goto L12
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DocFragment$internalChangeDocPermission$1(DocFragment r1, boolean r2, Continuation<? super DocFragment$internalChangeDocPermission$1> r3) {
        this.this$0 = r1;
        this.$isPublic = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocFragment$internalChangeDocPermission$1(this.this$0, this.$isPublic, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1((dm9.a) r8, this.this$0, this.$isPublic, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        DocOpManager r9 = DocOpManager.a;
        DocFragment r4 = this.this$0;
        String r5 = r4.f;
        boolean r6 = this.$isPublic;
        Map<String, ? extends Object> r7 = MapsKt.mapOf(TuplesKt.to("resource_type", Boxing.boxInt(r4.m)));
        this.label = 1;
        r8 = r9.i(r5, r6, r7, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
