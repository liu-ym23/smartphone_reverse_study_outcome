package com.larus.bmhome.chat.component.bottom.voice.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.voice.d0;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class VoiceMixInputService {
    public final CoroutineScope a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public static int d() {
        return z2.a.getVoiceMixInputScene();
    }

    public final z0<g> c() {
        return (z0) this.d.getValue();
    }

    public final VoiceMixInputManager.TextStreamWrapper e() {
        return (VoiceMixInputManager.TextStreamWrapper) this.e.getValue();
    }

    public final VoiceMixInputManager.Timer f() {
        return (VoiceMixInputManager.Timer) this.f.getValue();
    }

    public final h b() {
        VoiceMixInputManager.TextStreamWrapper r0 = e();
        r0.getClass();
        return new h(r0.f + r0.e, r0.h, false);
    }

    public final boolean g() {
        g r0 = (g) c().getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a;
    }

    public final Job i(Function1<? super byte[], Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1((z0) this.c.getValue(), new VoiceMixInputService$observeAudioData$1(r3)), new VoiceMixInputService$observeAudioData$2(null)), this.a);
    }

    public final Job j(Function1<? super h, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        VoiceMixInputManager.TextStreamWrapper r1 = e();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "callback");
        return kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1.c, new VoiceMixInputManager$TextStreamWrapper$observeTextStream$1(r4)), new VoiceMixInputManager$TextStreamWrapper$observeTextStream$2(null)), r1.b);
    }

    public final Job k(Function1<? super g, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(c(), new VoiceMixInputService$observeVoiceMixInputStatus$1(r3)), new VoiceMixInputService$observeVoiceMixInputStatus$2(null)), this.a);
    }

    public final void l(Function1<? super Continuation<? super Unit>, ? extends Object> r8) {
        int r0 = d0.d;
        d0.a.a("stopVoiceMixInput");
        BuildersKt.launch$default(this.a, null, null, new VoiceMixInputService$stopVoiceMixInput$1(this, r8, null), 3, null);
    }

    public VoiceMixInputService(final Context r2, CoroutineScope r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a = r3;
        this.b = LazyKt.lazy(new t());
        this.c = LazyKt.lazy(new u());
        this.d = LazyKt.lazy(new v());
        this.e = LazyKt.lazy(new w(r2, this));
        this.f = LazyKt.lazy(new x(this));
    }

    public final void h(boolean r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onBeforeStop");
        if (r3 == true) goto L5;
        ((VoiceMixInputManager) this.b.getValue()).c = false;
    L5:
        l(new VoiceMixInputService$interruptVoiceMixInput$1(r4, r3, this, null));
    }

    public static final Object a(VoiceMixInputService r10, String r11, boolean r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof VoiceMixInputService$configTextStream$1) == false) goto L7;
        VoiceMixInputService$configTextStream$1 r0 = (VoiceMixInputService$configTextStream$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        VoiceMixInputManager.TextStreamWrapper r15 = r10.e();
        if (r11.length() != 0) goto L20;
        boolean r16 = true;
    L21:
        if (r16 == false) goto L23;
        String r17 = AppHost.a.getApplication().getString(2131910711);
    L24:
        Intrinsics.checkNotNull(r17);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r11, "textContext");
        Intrinsics.checkNotNullParameter(r17, "hintContent");
        int r18 = d0.d;
        d0.a.a("configTextStream: textContext=" + r11 + " hintContent=" + r17);
        r15.f = r11;
        r15.g = r17;
        r15.h = true;
        BuildersKt.launch$default(r15.b, null, null, new VoiceMixInputManager$TextStreamWrapper$tryUpdateHintTextStream$1(r15, null), 3, null);
        r15.c();
        return Unit.INSTANCE;
    L23:
        r17 = "";
        goto L24
    L20:
        r16 = false;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r10.e().j = r12;
        VoiceMixInputManager.TextStreamWrapper r19 = r10.e();
        r0.L$0 = r11;
        r0.label = 1;
        if (r19.b(r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new VoiceMixInputService$configTextStream$1(r10, r13);
        goto L8
    }

    public final void m(f r16, String r17, FragmentActivity r18, Function0<Unit> r19, Function0<Unit> r20, Function0<Unit> r21, Function0<Unit> r22) {
        Intrinsics.checkNotNullParameter(r16, "param");
        Intrinsics.checkNotNullParameter(r17, "textContext");
        Intrinsics.checkNotNullParameter(r18, "activity");
        Intrinsics.checkNotNullParameter(r19, "onBeforeStart");
        Intrinsics.checkNotNullParameter(r20, "onBeforeStop");
        Intrinsics.checkNotNullParameter(r21, "onTimeout");
        Intrinsics.checkNotNullParameter(r22, "onError");
        int r0 = d0.d;
        d0.a.a("switchVoiceInputStatus");
        if (g() == false) goto L5;
        l(new VoiceMixInputService$switchVoiceInputStatus$1(r20));
        return;
    L5:
        d0.a.a("startVoiceMixInput");
        BuildersKt.launch$default(this.a, null, null, new VoiceMixInputService$startVoiceMixInput$1(this, r19, r17, r16, r18, r21, r22, r20, null), 3, null);
    }
}
