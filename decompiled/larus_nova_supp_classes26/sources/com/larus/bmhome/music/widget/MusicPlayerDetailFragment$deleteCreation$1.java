package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$deleteCreation$1", f = "MusicPlayerDetailFragment.kt", i = {}, l = {423, 432}, m = "invokeSuspend", n = {}, s = {})
final class MusicPlayerDetailFragment$deleteCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MusicPlayerDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.music.widget.MusicPlayerDetailFragment$deleteCreation$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$deleteCreation$1$1", f = "MusicPlayerDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MusicPlayerDetailFragment this$0;

        public AnonymousClass1(MusicPlayerDetailFragment r1, Continuation<? super AnonymousClass1> r2) {
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
            MusicPlayerDetailFragment r3 = this.this$0;
            r3.fa0(r3.J);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MusicPlayerDetailFragment$deleteCreation$1(MusicPlayerDetailFragment r1, Continuation<? super MusicPlayerDetailFragment$deleteCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MusicPlayerDetailFragment$deleteCreation$1(this.this$0, r3);
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
    L46:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L13:
        Pair r16 = (Pair) r15;
        MusicDetailPagerFragment r2 = null;
        if (r16 == null) goto L16;
        Boolean r17 = (Boolean) r16.getFirst();
    L18:
        if (Intrinsics.areEqual(r17, Boxing.boxBoolean(true)) == true) goto L22;
        tx9.e2.a.b(new tx9.u("chat", "creation_detail", TriggerSendLoading.NO_LOADING, this.this$0.E, "music", null, null, 193), null, 3);
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r18, r4, this) != r0) goto L46;
        return r0;
    L22:
        tx9.e2.a.b(new tx9.u("chat", "creation_detail", "1", this.this$0.E, "music", null, null, 193), null, 3);
        com.larus.platform.service.e0.a.X0(this.this$0.E);
        t19.s r19 = t19.s.a;
        Context r5 = this.this$0.getContext();
        Context r6 = this.this$0.getContext();
        if (r6 == null) goto L28;
        Resources r7 = r6.getResources();
        if (r7 == null) goto L28;
        String r8 = r7.getString(2131900648);
        if (r8 == null) goto L28;
    L29:
        r19.getClass();
        t19.s.p(r5, r8);
        Fragment r110 = this.this$0.getParentFragment();
        if ((r110 instanceof MusicDetailPagerFragment) == false) goto L32;
        r2 = (MusicDetailPagerFragment) r110;
    L32:
        if (r2 == null) goto L44;
        String r111 = this.this$0.aa0();
        Intrinsics.checkNotNullParameter(r111, "taskId");
        Map<String, Pair<String, Integer>> r9 = r2.l;
        if (r9 != null) goto L36;
    L38:
        r3 = false;
    L39:
        if (r3 == false) goto L44;
        Map<String, Pair<String, Integer>> r10 = r2.l;
        if (r10 == null) goto L44;
        Pair<String, Integer> r112 = r10.remove(r111);
        goto L44
    L36:
        if (r9.containsKey(r111) != true) goto L38;
    L44:
        MusicPlayerDetailFragment r113 = this.this$0;
        r113.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r113.E = "";
    L28:
        r8 = "";
        goto L29
    L16:
        r17 = null;
        goto L18
    L10:
        ResultKt.throwOnFailure(r15);
        com.larus.platform.service.e0 r114 = com.larus.platform.service.e0.a;
        String r11 = this.this$0.E;
        this.label = 1;
        r15 = r114.g(r11, this);
        if (r15 != r0) goto L13;
        return r0;
    }
}
