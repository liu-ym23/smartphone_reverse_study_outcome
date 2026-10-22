package com.obric.assistant.cocreationreview;

import android.widget.Toast;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationReviewActivity$runCenterTask$1", f = "CocreationReviewActivity.kt", i = {1}, l = {1026, 1028}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class CocreationReviewActivity$runCenterTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $query;
    final /* synthetic */ e4 $task;
    final /* synthetic */ String $userId;
    Object L$0;
    int label;
    final /* synthetic */ CocreationReviewActivity this$0;

    /* JADX INFO: renamed from: com.obric.assistant.cocreationreview.CocreationReviewActivity$runCenterTask$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationReviewActivity$runCenterTask$1$1", f = "CocreationReviewActivity.kt", i = {}, l = {1028}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e4 $task;
        final /* synthetic */ String $userId;
        int label;
        final /* synthetic */ CocreationReviewActivity this$0;

        public AnonymousClass1(CocreationReviewActivity r1, String r2, e4 r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$userId = r2;
            this.$task = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$userId, this.$task, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CocreationTaskRunStore r8 = this.this$0.q;
            String r2 = this.$userId;
            String r3 = this.$task.a;
            this.label = 1;
            r8.getClass();
            Object r9 = BuildersKt.withContext(Dispatchers.getIO(), new CocreationTaskRunStore$recordRun$2(r2, r3, r8, null), this);
            if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r9 = Unit.INSTANCE;
        L12:
            if (r9 != r0) goto L15;
            return r0;
        }
    }

    public CocreationReviewActivity$runCenterTask$1(e4 r1, String r2, CocreationReviewActivity r3, String r4, Continuation<? super CocreationReviewActivity$runCenterTask$1> r5) {
        this.$task = r1;
        this.$query = r2;
        this.this$0 = r3;
        this.$userId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CocreationReviewActivity$runCenterTask$1(this.$task, this.$query, this.this$0, this.$userId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        CocreationTaskLauncher.a r2 = (CocreationTaskLauncher.a) this.L$0;
        ResultKt.throwOnFailure(r10);
    L19:
        s3.b("task.run", "run history saved");
        CocreationTaskLauncher.a r11 = r2;
    L20:
        q4 r3 = this.this$0.o;
        e4 r4 = this.$task;
        boolean r5 = r11.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "task");
        if (Intrinsics.areEqual(r3.g, r4.a) == false) goto L39;
        r3.g = null;
        if (r5 == false) goto L39;
        List<e4> r6 = r3.a;
        if ((r6 instanceof Collection) == true) goto L28;
    L30:
        Iterator<T> r7 = r6.iterator();
    L32:
        if (r7.hasNext() == false) goto L36;
        if (Intrinsics.areEqual(((e4) r7.next()).a, r4.a) == false) goto L32;
        boolean r8 = true;
    L37:
        if (r8 == false) goto L39;
        r3.e.add(r4.a);
    L36:
        r8 = false;
        goto L37
    L28:
        if (r6.isEmpty() == false) goto L30;
    L39:
        this.this$0.o2(false);
        String r12 = r11.b;
        if (r12 == null) goto L43;
        Toast.makeText(this.this$0, r12, 1).show();
    L43:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        r11 = (CocreationTaskLauncher.a) r10;
        if (r11.a == false) goto L20;
        kotlinx.coroutines.k1 r9 = kotlinx.coroutines.k1.a;
        AnonymousClass1 r13 = new AnonymousClass1(this.this$0, this.$userId, this.$task, null);
        this.L$0 = r11;
        this.label = 2;
        if (BuildersKt.withContext(r9, r13, this) != r0) goto L18;
        return r0;
    L18:
        r2 = r11;
        goto L19
    L10:
        ResultKt.throwOnFailure(r10);
        CocreationTaskLauncher r14 = CocreationTaskLauncher.a;
        e4 r15 = this.$task;
        String r16 = this.$query;
        this.label = 1;
        r10 = r14.a(r15, r16, this);
        if (r10 != r0) goto L13;
        return r0;
    }
}
