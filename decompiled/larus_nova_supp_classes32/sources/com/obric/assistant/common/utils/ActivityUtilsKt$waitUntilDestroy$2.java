package com.obric.assistant.common.utils;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.common.utils.ActivityUtilsKt$waitUntilDestroy$2", f = "ActivityUtils.kt", i = {0}, l = {33}, m = "invokeSuspend", n = {"observers"}, s = {"L$0"})
final class ActivityUtilsKt$waitUntilDestroy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $autoFinish;
    final /* synthetic */ long $maxWaitTimeMS;
    final /* synthetic */ List<ComponentActivity> $this_waitUntilDestroy;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.common.utils.ActivityUtilsKt$waitUntilDestroy$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.common.utils.ActivityUtilsKt$waitUntilDestroy$2$1", f = "ActivityUtils.kt", i = {}, l = {LynxTouchEvent.kPseudoStateFocus}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ boolean $autoFinish;
        final /* synthetic */ Map<ComponentActivity, DefaultLifecycleObserver> $observers;
        final /* synthetic */ List<ComponentActivity> $this_waitUntilDestroy;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(List<? extends ComponentActivity> r1, boolean r2, Map<ComponentActivity, DefaultLifecycleObserver> r3, Continuation<? super AnonymousClass1> r4) {
            this.$this_waitUntilDestroy = r1;
            this.$autoFinish = r2;
            this.$observers = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$this_waitUntilDestroy, this.$autoFinish, this.$observers, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L21:
            return Boxing.boxBoolean(true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            List<ComponentActivity> r2 = this.$this_waitUntilDestroy;
            boolean r9 = this.$autoFinish;
            Map<ComponentActivity, DefaultLifecycleObserver> r10 = this.$observers;
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator<T> r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L17;
            ComponentActivity r4 = (ComponentActivity) r3.next();
            if (r9 == false) goto L16;
            if (r4.isFinishing() == true) goto L16;
            r4.finish();
        L16:
            r11.add(BuildersKt.async$default(r14, null, null, new ActivityUtilsKt$waitUntilDestroy$2$1$1$1(r4, r10, null), 3, null));
            goto L10
        L17:
            this.label = 1;
            if (AwaitKt.a(r11, this) != r0) goto L21;
            return r0;
        }
    }

    public ActivityUtilsKt$waitUntilDestroy$2(long r1, List<? extends ComponentActivity> r3, boolean r4, Continuation<? super ActivityUtilsKt$waitUntilDestroy$2> r5) {
        this.$maxWaitTimeMS = r1;
        this.$this_waitUntilDestroy = r3;
        this.$autoFinish = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ActivityUtilsKt$waitUntilDestroy$2(this.$maxWaitTimeMS, this.$this_waitUntilDestroy, this.$autoFinish, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Map r2 = (Map) this.L$0;
        ResultKt.throwOnFailure(r9);
    L12:
        Boolean r3 = (Boolean) r9;
        Iterator r4 = r2.entrySet().iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        Map.Entry r5 = (Map.Entry) r4.next();
        ComponentActivity r6 = (ComponentActivity) r5.getKey();
        DefaultLifecycleObserver r7 = (DefaultLifecycleObserver) r5.getValue();
        r6.getLifecycle().removeObserver(r7);
        goto L14
    L16:
        if (r3 != null) goto L18;
        FLogger.a.w("ActivityUtils", "waitUntilDestroy timeout");
    L18:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        LinkedHashMap r10 = new LinkedHashMap();
        long r8 = this.$maxWaitTimeMS;
        AnonymousClass1 r11 = new AnonymousClass1(this.$this_waitUntilDestroy, this.$autoFinish, r10, null);
        this.L$0 = r10;
        this.label = 1;
        Object r12 = TimeoutKt.c(r8, r11, this);
        if (r12 != r0) goto L11;
        return r0;
    L11:
        r2 = r10;
        r9 = r12;
        goto L12
    }
}
