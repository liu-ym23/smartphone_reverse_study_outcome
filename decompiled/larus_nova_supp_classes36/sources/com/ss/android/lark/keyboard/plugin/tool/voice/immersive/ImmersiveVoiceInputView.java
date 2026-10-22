package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.AudioPopupWindowImpl;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImmersiveVoiceInputView {
    public final Context a;
    public final x b;
    public final w c;
    public final IVoiceFaceDependency d;
    public AudioPopupWindowImpl e;
    public b0 f;
    public GradientDrawable g;
    public Function0<Unit> h;
    public Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> i;
    public boolean j;
    public final int[] k;
    public final int[] l;
    public final Lazy m;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ ImmersiveVoiceInputView a;

        public a(ImmersiveVoiceInputView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            if (r2 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == false) goto L10;
            KeyboardUtils.hideKeyboard(this.a.a);
        L10:
            return false;
        L5:
            if (r2.getAction() != 0) goto L7;
            r3 = true;
            goto L8
        }
    }

    public static final class b implements com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ ImmersiveVoiceInputView b;

        public b(Fragment r1, ImmersiveVoiceInputView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d
        public final ViewGroup a() {
            Fragment r0 = this.a;
            if (r0 == null) goto L7;
            View r1 = r0.getView();
            if (r1 == null) goto L7;
            return gac.a.a(r1, ContextsKt.findActivity(this.b.a));
        L7:
            return null;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ImmersiveVoiceInputView a;

        public c(ImmersiveVoiceInputView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L5;
            return;
        L5:
            if (this.a.c().isCancelingSession() == false) goto L7;
            return;
        L7:
            if (this.a.c().getImmersiveVoiceMode().b() == false) goto L9;
            this.a.c().updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.m());
            return;
        L9:
            this.a.c().updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.o());
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ImmersiveVoiceInputView a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ Function1<com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(ImmersiveVoiceInputView r1, Function0<Unit> r2, Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            ImmersiveVoiceInputView r0 = this.a;
            Intrinsics.checkNotNull(r5);
            r0.b(r5.booleanValue(), this.b, this.c);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ImmersiveVoiceInputView a;

        public e(ImmersiveVoiceInputView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L5;
            ImmersiveVoiceInputView r4 = this.a;
            ImmersiveVoiceInputView.a(r4, r4.k, r4.l);
            return;
        L5:
            ImmersiveVoiceInputView r5 = this.a;
            ImmersiveVoiceInputView.a(r5, r5.l, r5.k);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ImmersiveVoiceInputView a;

        public f(ImmersiveVoiceInputView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            x r4 = this.a.b;
            Activity r0 = r4.d;
            Fragment r5 = r4.e;
            if (r0 == null) goto L6;
            if (r5 == null) goto L6;
            return;
        L6:
            Log.e("ImmersiveVoiceKeyboardKey", "activity or fragment is null");
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ImmersiveVoiceInputView a;

        public g(ImmersiveVoiceInputView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            int r4 = ((Integer) r3).intValue();
            GradientDrawable r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.setAlpha(r4);
            return;
        }
    }

    public final ImmersiveVoiceViewModel c() {
        return (ImmersiveVoiceViewModel) this.m.getValue();
    }

    public final void e() {
        Fragment r0 = this.b.e;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d r1 = this.c.n;
        if (r1 != null) goto L5;
        this.j = false;
        r1 = new b(r0, this);
    L5:
        AudioPopupWindowImpl r2 = new AudioPopupWindowImpl(this.a, r1);
        float[] r3 = {0.0f, 0.65f, 0.75f};
        GradientDrawable r4 = new GradientDrawable();
        r4.setGradientType(0);
        r4.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r4.setColors(this.k);
        r4.setGradientCenter(r3[0], r3[1]);
        Intrinsics.checkNotNullParameter(r4, "drawable");
        r2.f = r4;
        this.g = r4;
        a r5 = new a(this);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r2.c.setOnTouchListener(r5);
        this.e = r2;
    }

    public final boolean g(Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "afterTrigger");
        int r0 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.g(this.a) == true) goto L36;
        Activity r15 = this.b.d;
        if (r15 == null) goto L7;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.j(r15, ImmersiveVoiceInputView$triggerVoiceRecordIfNeed$1$1.INSTANCE);
    L7:
        return false;
    L36:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        Map r3 = com.ss.android.lark.audio.f.e;     // Catch: Throwable -> L15
        Context r4 = this.a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r4, "context");     // Catch: Throwable -> L15
        com.ss.android.lark.audio.f r5 = (com.ss.android.lark.audio.f) ((ConcurrentHashMap) com.ss.android.lark.audio.f.e).get(r4.toString());     // Catch: Throwable -> L15
        if (r5 == null) goto L12;
        r5.d();     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L15
    L17:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L20;
        Log.e("ImmersiveVoiceKeyboardKey", "stop playing audio message failed", r8);
    L20:
        c().setBeforeVoiceEditAsrResult(null);
        ImmersiveVoiceViewModel r1 = c();
        com.ss.android.lark.audio.voiceinput.p r9 = this.c.d;
        int r10 = AudioAsrLanguageSwitcher.i;
        if (r1.startVoiceRecord(r9, AudioAsrLanguageSwitcher.a.a(), "") == true) goto L23;
        return false;
    L23:
        c().setMaxRecordTime(AudioRecordSettings.d().getAudio2TextMaxDuration());
        c().whenVoiceInputStart();
        AudioPopupWindowImpl r11 = this.e;
        if (r11 == null) goto L35;
        AudioPopupWindowImpl.b r12 = r11.c;
        r12.setClickable(true);
        if (this.f != null) goto L28;
        Context r13 = r12.getContext();
        this.b.getClass();
        x r16 = this.b;
        Fragment r17 = r16.e;
        FragmentActivity r18 = r16.d;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity r19 = r18;
        w r20 = this.c;
        b0 r110 = new b0(r13, r12, r17, r19, r20.m, this.d, new ImmersiveVoiceInputView$triggerVoiceRecordIfNeed$2$1(this), r20.s);
        this.f = r110;
        r11.b(r110);
    L28:
        r12.setAlpha(1.0f);
        r11.c();
        if (this.g == null) goto L31;
        ValueAnimator r21 = ObjectAnimator.ofInt(new int[]{0, 255});
        r21.setDuration(150);
        r21.setInterpolator(new LinearInterpolator());
        r21.addUpdateListener(new g(this));
        r21.start();
    L31:
        AudioPopupWindowImpl r22 = this.e;
        if (r22 == null) goto L34;
        r14.invoke(r22);
    L34:
        return true;
    L35:
        return false;
    L12:
        r6 = null;
    L15:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final void d(View r8, MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "motionEvent");
        int r2 = r9.getAction() & 255;
        if (r2 == 1) goto L6;
        if (r2 == 3) goto L6;
    L8:
        MediatorLiveData<Boolean> r5 = c().getShouldHandleTouchEvent();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.getValue(), Boolean.TRUE) == false) goto L13;
        b0 r3 = this.f;
        if (r3 == null) goto L18;
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "motionEvent");
        Log.i(r3.e, "handleTouchEvent:" + r9.getAction());
        r3.f.Y5(r8, r9);
        return;
    L18:
        return;
    L13:
        if (r2 == 1) goto L16;
        if (r2 == 3) goto L16;
        return;
    L16:
        c().whenReleaseOrCancelTouch();
        return;
    L6:
        if (c().isBackgroundAsrKeepSessionMode() == false) goto L8;
        c().requestHidePopupKeepSession();
        goto L8
    }

    public final void f(Function0<Unit> r5, Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "whenPopupWindowDismiss");
        Intrinsics.checkNotNullParameter(r6, "afterPopupWindowDismiss");
        this.h = r5;
        this.i = r6;
        MediatorLiveData<Boolean> r0 = c().getShouldHandleTouchEvent();
        Fragment r1 = this.b.e;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r0.observe(r1, new c(this));
        MutableLiveData<Boolean> r2 = c().getPopupWindowVisible();
        Fragment r3 = this.b.e;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r2.observe(r3, new d(this, r5, r6));
        MutableLiveData<Boolean> r7 = c().getAsrResultFocused();
        Fragment r8 = this.b.e;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r7.observe(r8, new e(this));
        MutableLiveData<String> r9 = c().getStartMention();
        Fragment r10 = this.b.e;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r9.observe(r10, new f(this));
    }

    public static final void a(ImmersiveVoiceInputView r3, int[] r4, int[] r5) {
        r3.getClass();
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(200);
        r0.setInterpolator(new LinearInterpolator());
        r0.addUpdateListener(new y(r3, r4, r5));
        r0.start();
    }

    public final void b(boolean r5, Function0<Unit> r6, final Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> r7) {
        if (r5 == true) goto L21;
        final boolean r8 = c().consumeKeepSessionOnPopupHide$keyboard_biz_voice_release();
        AudioPopupWindowImpl r0 = this.e;
        if (r0 != null) goto L6;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == false) goto L19;
        if (r8 == true) goto L24;
        c().updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.j());
        ImmersiveVoiceViewModel.resetLiveData$default(c(), false, 1, null);
        return;
    L24:
        return;
    L19:
        if (r0 == null) goto L21;
        Function0<Unit> r1 = new ImmersiveVoiceInputView$dismissPopupWindow$1(this, r8, r7);
        r0.g = true;
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r9.setDuration(150);
        r9.setInterpolator(new LinearInterpolator());
        r9.addUpdateListener(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.a(r0));
        Intrinsics.checkNotNull(r9);
        r9.addListener(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.b(r1, r0));
        r9.start();
        goto L21
    L6:
        if (r0.g == false) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 != true) goto L14;
        r3 = true;
        goto L15
    L8:
        if (r0.h == false) goto L11;
        r4 = false;
    L21:
        if (r6 == null) goto L25;
        r6.invoke();
        return;
    }

    public ImmersiveVoiceInputView(Context r6, x r7, w r8, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.c r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "voiceInputDependency");
        Intrinsics.checkNotNullParameter(r8, "voiceInputConfig");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.j = true;
        if (h18.f.a(r6) == false) goto L5;
        int[] r10 = {UIUtils.getColor(r6, 2131109365), UIUtils.getColor(r6, 2131109362), UIUtils.getColor(r6, 2131109359)};
    L6:
        this.k = r10;
        if (h18.f.a(r6) == false) goto L9;
        int[] r11 = {UIUtils.getColor(r6, 2131109359), UIUtils.getColor(r6, 2131109359), UIUtils.getColor(r6, 2131109359)};
    L10:
        this.l = r11;
        this.m = LazyKt.lazy(new ImmersiveVoiceInputView$immersiveVoiceViewModel$2(this));
        return;
    L9:
        r11 = new int[]{UIUtils.getColor(r6, 2131109358), UIUtils.getColor(r6, 2131109358), UIUtils.getColor(r6, 2131109358)};
        goto L10
    L5:
        r10 = new int[]{UIUtils.getColor(r6, 2131109364), UIUtils.getColor(r6, 2131109361), UIUtils.getColor(r6, 2131109358)};
        goto L6
    }
}
