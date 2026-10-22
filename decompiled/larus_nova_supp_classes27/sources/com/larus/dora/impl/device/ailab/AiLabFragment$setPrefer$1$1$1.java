package com.larus.dora.impl.device.ailab;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraPageAiLabBinding;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabFragment$setPrefer$1$1$1", f = "AiLabFragment.kt", i = {}, l = {413, 419}, m = "invokeSuspend", n = {}, s = {})
final class AiLabFragment$setPrefer$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ LarusDoraPageAiLabBinding $this_run;
    int label;
    final /* synthetic */ AiLabFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabFragment$setPrefer$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabFragment$setPrefer$1$1$1$1", f = "AiLabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        final /* synthetic */ int $ret;
        final /* synthetic */ LarusDoraPageAiLabBinding $this_run;
        int label;
        final /* synthetic */ AiLabFragment this$0;

        public AnonymousClass1(int r1, AiLabFragment r2, LarusDoraPageAiLabBinding r3, boolean r4, Continuation<? super AnonymousClass1> r5) {
            this.$ret = r1;
            this.this$0 = r2;
            this.$this_run = r3;
            this.$isChecked = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$ret, this.this$0, this.$this_run, this.$isChecked, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r4);
            boolean r0 = false;
            if (this.$ret == 0) goto L7;
            t19.s r5 = t19.s.a;
            Application r2 = AppHost.a.getApplication();
            r5.getClass();
            t19.s.b(r2, 2131904037, false);
            this.this$0.h = true;
            this.$this_run.t.getToggleView().setChecked(true ^ this.$isChecked);
            this.this$0.h = false;
        L20:
            return Unit.INSTANCE;
        L7:
            AiLabFragment r6 = this.this$0;
            int r3 = AiLabFragment.m;
            a r7 = (a) r6.Y90().getAbilityStateFlow().getValue();
            if (r7 != null) goto L10;
        L12:
            if (r0 == false) goto L15;
            this.this$0.X90();
            AiLabFragment r8 = this.this$0;
            AiLabFragment.W90(r8, (List) r8.Y90().getKeywordsStateFlow().getValue());
        L15:
            if (this.$isChecked == false) goto L17;
            String r9 = "1";
        L18:
            DoraSystemInfoManager r1 = DoraSystemInfoManager.a;
            DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("doubao_voice_wakeup", r9)));
            goto L20
        L17:
            r9 = "0";
            goto L18
        L10:
            if (r7.a != true) goto L12;
            r0 = true;
            goto L12
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AiLabFragment$setPrefer$1$1$1(AiLabFragment r1, boolean r2, LarusDoraPageAiLabBinding r3, Continuation<? super AiLabFragment$setPrefer$1$1$1> r4) {
        this.this$0 = r1;
        this.$isChecked = r2;
        this.$this_run = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AiLabFragment$setPrefer$1$1$1(this.this$0, this.$isChecked, this.$this_run, r5);
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
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        int r4 = ((Number) r10).intValue();
        t39.c r11 = j49.b.a;
        boolean r12 = this.$isChecked;
        Intrinsics.checkNotNullParameter("voice_wakeup", "action");
        j49.b.i("voice_wakeup", r12, j49.b.k(r4));
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(r4, this.this$0, this.$this_run, this.$isChecked, null);
        this.label = 2;
        if (BuildersKt.withContext(r13, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r10);
        AiLabFragment r14 = this.this$0;
        int r3 = AiLabFragment.m;
        AiLabViewModel r15 = r14.Y90();
        boolean r5 = this.$isChecked;
        this.label = 1;
        r10 = r15.setVoiceWakeEnable(r5, this);
        if (r10 != r0) goto L13;
        return r0;
    }
}
