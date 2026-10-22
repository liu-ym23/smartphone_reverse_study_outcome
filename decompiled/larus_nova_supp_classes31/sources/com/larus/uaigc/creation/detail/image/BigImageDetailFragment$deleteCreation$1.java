package com.larus.uaigc.creation.detail.image;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.e0;
import com.larus.uaigc.creation.ChatCreationPagerFragment;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$deleteCreation$1", f = "BigImageDetailFragment.kt", i = {}, l = {615, 624}, m = "invokeSuspend", n = {}, s = {})
final class BigImageDetailFragment$deleteCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BigImageDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.creation.detail.image.BigImageDetailFragment$deleteCreation$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$deleteCreation$1$1", f = "BigImageDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BigImageDetailFragment this$0;

        public AnonymousClass1(BigImageDetailFragment r1, Continuation<? super AnonymousClass1> r2) {
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
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            BigImageDetailFragment r3 = this.this$0;
            r3.ma0(r3.E);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BigImageDetailFragment$deleteCreation$1(BigImageDetailFragment r1, Continuation<? super BigImageDetailFragment$deleteCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BigImageDetailFragment$deleteCreation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L45:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L13:
        Pair r16 = (Pair) r15;
        ChatCreationPagerFragment r2 = null;
        if (r16 == null) goto L16;
        Boolean r17 = (Boolean) r16.getFirst();
    L18:
        if (Intrinsics.areEqual(r17, Boxing.boxBoolean(true)) == true) goto L22;
        BigImageDetailFragment r4 = this.this$0;
        e2.a.b(new tx9.u("chat", "creation_detail", "0", r4.F.C, r4.ba0(), null, null, 193), null, 3);
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        AnonymousClass1 r5 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r18, r5, this) != r0) goto L45;
        return r0;
    L22:
        BigImageDetailFragment r6 = this.this$0;
        e2.a.b(new tx9.u("chat", "creation_detail", "1", r6.F.C, r6.ba0(), null, null, 193), null, 3);
        t19.s r19 = t19.s.a;
        Context r7 = this.this$0.getContext();
        Context r8 = this.this$0.getContext();
        if (r8 == null) goto L28;
        Resources r9 = r8.getResources();
        if (r9 == null) goto L28;
        String r10 = r9.getString(2131900648);
        if (r10 == null) goto L28;
    L29:
        r19.getClass();
        t19.s.p(r7, r10);
        e0.a.X0(this.this$0.F.C);
        Fragment r110 = this.this$0.getParentFragment();
        if ((r110 instanceof ChatCreationPagerFragment) == false) goto L32;
        r2 = (ChatCreationPagerFragment) r110;
    L32:
        if (r2 == null) goto L45;
        String r111 = this.this$0.Y90();
        Intrinsics.checkNotNullParameter(r111, "creationKey");
        Map<String, UserCreationFromIM> r11 = r2.k;
        if (r11 != null) goto L36;
    L38:
        r3 = false;
    L39:
        if (r3 == false) goto L45;
        Map<String, UserCreationFromIM> r12 = r2.k;
        if (r12 == null) goto L45;
        UserCreationFromIM r112 = r12.remove(r111);
        goto L45
    L36:
        if (r11.containsKey(r111) != true) goto L38;
    L28:
        r10 = "";
        goto L29
    L16:
        r17 = null;
        goto L18
    L10:
        ResultKt.throwOnFailure(r15);
        e0 r113 = e0.a;
        String r13 = this.this$0.F.C;
        this.label = 1;
        r15 = r113.g(r13, this);
        if (r15 != r0) goto L13;
        return r0;
    }
}
