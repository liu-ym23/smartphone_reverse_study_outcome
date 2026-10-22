package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$setCreationPrivacy$2", f = "MusicPlayerDetailFragment.kt", i = {}, l = {471, 473}, m = "invokeSuspend", n = {}, s = {})
public final class MusicPlayerDetailFragment$setCreationPrivacy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $buttonStatus;
    final /* synthetic */ int $previousStatus;
    final /* synthetic */ int $privateStatus;
    int label;
    final /* synthetic */ MusicPlayerDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.music.widget.MusicPlayerDetailFragment$setCreationPrivacy$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$setCreationPrivacy$2$1", f = "MusicPlayerDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $previousStatus;
        int label;
        final /* synthetic */ MusicPlayerDetailFragment this$0;

        public AnonymousClass1(MusicPlayerDetailFragment r1, int r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$previousStatus = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$previousStatus, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            MusicPlayerDetailFragment r4 = this.this$0;
            int r0 = this.$previousStatus;
            int r1 = MusicPlayerDetailFragment.O;
            r4.fa0(r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MusicPlayerDetailFragment$setCreationPrivacy$2(MusicPlayerDetailFragment r1, int r2, int r3, int r4, Continuation<? super MusicPlayerDetailFragment$setCreationPrivacy$2> r5) {
        this.this$0 = r1;
        this.$privateStatus = r2;
        this.$buttonStatus = r3;
        this.$previousStatus = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MusicPlayerDetailFragment$setCreationPrivacy$2(this.this$0, this.$privateStatus, this.$buttonStatus, this.$previousStatus, r8);
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
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L58:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        Pair r8 = (Pair) r7;
        MusicDetailPagerFragment r2 = null;
        if (r8 == null) goto L16;
        Boolean r9 = (Boolean) r8.getFirst();
    L18:
        if (Intrinsics.areEqual(r9, Boxing.boxBoolean(true)) == true) goto L23;
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, this.$previousStatus, null);
        this.label = 2;
        if (BuildersKt.withContext(r10, r4, this) != r0) goto L58;
        return r0;
    L23:
        if (this.$privateStatus != 2) goto L29;
        Context r11 = this.this$0.getContext();
        if (r11 == null) goto L35;
        Resources r12 = r11.getResources();
        if (r12 == null) goto L35;
        int r5 = 2131900633;
    L34:
        String r13 = r12.getString(r5);
    L37:
        if (this.$privateStatus != 2) goto L39;
        com.larus.platform.service.e0.a.X0(this.this$0.E);
    L39:
        t19.s r6 = t19.s.a;
        Context r14 = this.this$0.getContext();
        if (r13 != null) goto L42;
        r13 = "";
    L42:
        r6.getClass();
        t19.s.p(r14, r13);
        MusicPlayerDetailFragment r15 = this.this$0;
        r15.J = this.$buttonStatus;
        Fragment r16 = r15.getParentFragment();
        if ((r16 instanceof MusicDetailPagerFragment) == false) goto L45;
        r2 = (MusicDetailPagerFragment) r16;
    L45:
        if (r2 == null) goto L58;
        MusicPlayerDetailFragment r17 = this.this$0;
        String r18 = r17.E;
        String r19 = r17.aa0();
        int r20 = this.$privateStatus;
        Intrinsics.checkNotNullParameter(r18, "creationId");
        Intrinsics.checkNotNullParameter(r19, "taskId");
        Map<String, Pair<String, Integer>> r21 = r2.l;
        if (r21 != null) goto L49;
    L51:
        r3 = false;
    L52:
        if (r3 == false) goto L58;
        Map<String, Pair<String, Integer>> r22 = r2.l;
        if (r22 == null) goto L58;
        Pair<String, Integer> r23 = r22.put(r19, TuplesKt.to(r18, Integer.valueOf(r20)));
        goto L58
    L49:
        if (r21.containsKey(r19) != true) goto L51;
    L35:
        r13 = null;
        goto L37
    L29:
        Context r24 = this.this$0.getContext();
        if (r24 == null) goto L35;
        r12 = r24.getResources();
        if (r12 == null) goto L35;
        r5 = 2131900634;
        goto L34
    L16:
        r9 = null;
        goto L18
    L10:
        ResultKt.throwOnFailure(r7);
        com.larus.platform.service.e0 r25 = com.larus.platform.service.e0.a;
        String r26 = this.this$0.E;
        int r27 = this.$privateStatus;
        this.label = 1;
        r7 = r25.h(r26, r27, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
