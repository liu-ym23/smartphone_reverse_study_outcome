package com.larus.bmhome.chat.component.bottom.voice.service;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.k0;
import com.larus.bmhome.chat.component.bottom.voice.d0;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class VoiceMixInputManager {
    public final Lazy a;
    public String b;
    public boolean c;

    public static final class TextStreamWrapper {
        public final Context a;
        public final CoroutineScope b;
        public final StateFlowImpl c;
        public ValueAnimator d;
        public String e;
        public String f;
        public String g;
        public boolean h;
        public r19.b i;
        public boolean j;

        public final void c() {
            ValueAnimator r0 = this.d;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L11;
            int r2 = d0.d;
            d0.a.a("tryUpdateFinalTextStream");
            BuildersKt.launch$default(this.b, null, null, new VoiceMixInputManager$TextStreamWrapper$tryUpdateFinalTextStream$1(this, null), 3, null);
            return;
        L11:
            return;
        L5:
            if (r0.isRunning() == true) goto L7;
            r1 = true;
            goto L8
        }

        public final Unit d() {
            SpannableString r1 = new SpannableString(this.f + this.e);
            if (this.j == true) goto L5;
            Resources r2 = this.a.getResources();
            int r3 = v19.c.b(2130972079, this.a, 2131103136);
        L6:
            r1.setSpan(new ForegroundColorSpan(r2.getColor(r3)), 0, r1.length(), 17);
            Unit r0 = a(r1, false, true);
            if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
            return r0;
        L10:
            return Unit.INSTANCE;
        L5:
            r2 = this.a.getResources();
            r3 = 2131103298;
            goto L6
        }

        public final Object b(Continuation<? super Unit> r5) {
            if ((r5 instanceof VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1) == false) goto L7;
            VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1 r0 = (VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1) r5;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r6 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r6);
        L21:
            if (this.i != null) goto L28;
            if (this.j == true) goto L25;
            int r4 = 2131240017;
        L26:
            this.i = new r19.b(r4, this.a);
            goto L28
        L25:
            r4 = 2131240674;
        L28:
            if (this.d != null) goto L30;
            ValueAnimator r7 = ValueAnimator.ofInt(new int[]{0, 255});
            r7.setDuration(400);
            r7.setRepeatCount(-1);
            r7.setRepeatMode(2);
            r7.addUpdateListener(new r(this));
            this.d = r7;
        L30:
            ValueAnimator r8 = this.d;
            if (r8 == null) goto L34;
            r8.start();
        L34:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r6);
            int r9 = d0.d;
            d0.a.a("startUpdateTextStream");
            d0.a.a("stopUpdateTextStream");
            ValueAnimator r10 = this.d;
            if (r10 == null) goto L17;
            r10.cancel();
        L17:
            this.e = "";
            this.h = false;
            r0.label = 1;
            this.c.setValue(null);
            Unit r11 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (r11 != r2) goto L21;
            return r2;
        L7:
            r0 = new VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1(this, r5);
            goto L8
        }

        public TextStreamWrapper(Context r2, CoroutineScope r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "scope");
            this.a = r2;
            this.b = r3;
            this.c = j1.a(null);
            this.e = "";
            this.f = "";
            this.g = "";
        }

        public final void e(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "textContext");
            Intrinsics.checkNotNullParameter(r4, "textContent");
            int r0 = d0.d;
            d0.a.a("updateTextStream: textContext=" + r3 + " textContent=" + r4 + " updateHint=false");
            this.f = r3;
            this.e = r4;
            this.h = false;
            c();
        }

        public final Unit a(CharSequence r3, boolean r4, boolean r5) {
            this.c.setValue(new h(r3, r4, r5));
            Unit r6 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return r6;
        }
    }

    public static final class Timer {
        public final CoroutineScope a;
        public boolean b;
        public Function1<? super Continuation<? super Unit>, ? extends Object> c;
        public final Lazy d;

        public Timer(CoroutineScope r2, final long r3) {
            Intrinsics.checkNotNullParameter(r2, "scope");
            this.a = r2;
            this.b = true;
            this.c = new VoiceMixInputManager$Timer$onTimerFinish$1(null);
            this.d = LazyKt.lazy(new s(r3, this));
        }
    }

    public static final class a {
    }

    static {
    }

    public final void b() {
        int r0 = d0.d;
        d0.a.a("stop voice mix input");
        boolean r1 = true;
        if (this.b.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L23;
        d0.a.a("real stop voice mix input");
        String r3 = this.b;
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L17;
        com.larus.home.impl.sdk.s r5 = r4.s0();
        if (r5 == null) goto L17;
        Integer r6 = r5.l();
        if (r6 == null) goto L17;
        if (r6.intValue() != 2) goto L17;
    L19:
        if (r1 == false) goto L21;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VoiceMixInputManager$stopASR$1(null), 3, null);
    L21:
        d0.a.a("stop asr");
        k0.a.a(AudioServiceDelegate.a.x(), r3, null);
        a(this.b, false);
        this.b = "";
        return;
    L17:
        r1 = false;
        goto L19
    L23:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public VoiceMixInputManager() {
        this.a = LazyKt.lazy(new i());
        this.b = "";
        this.c = true;
    }

    public static void a(String r2, boolean r3) {
        String r4 = "VoiceMixInputManager-" + r2;
        if (r3 == false) goto L5;
        fa9.e.a.a("voice_input", r4);
        return;
    L5:
        fa9.e.a.f("voice_input", r4);
    }
}
