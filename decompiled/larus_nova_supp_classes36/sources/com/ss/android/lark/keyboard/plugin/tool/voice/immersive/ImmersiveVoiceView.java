package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink.CustomLinkStrategy;
import com.ss.android.lark.keyboard.ime.ExtensionImeKt;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.AudioPopupWindowImpl;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceActionAreaUseCase;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceAtStrategy;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceBubbleAreaUseCase;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceBubbleAreaUseCase$initUI$1$1;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceImeWrapperUseCase;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.i0;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.j0;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.k0;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceOvalBackground;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 b2\u00020\u0001:\u0001bBq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020@2\u0006\u00108\u001a\u000209H\u0002J\b\u0010B\u001a\u00020@H\u0002J\u0016\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020>2\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u00020HH\u0002J\u001c\u0010I\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010>H\u0002J\b\u0010K\u001a\u00020@H\u0014J\b\u0010L\u001a\u00020@H\u0014J\u0012\u0010M\u001a\u00020\u00142\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010N\u001a\u00020@2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\u0012\u0010Q\u001a\u00020\u00142\b\u0010E\u001a\u0004\u0018\u00010RH\u0016J\u0014\u0010S\u001a\u00020@2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020V0UJ\u0010\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020YH\u0016J \u0010Z\u001a\u00020[2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\\\u001a\u00020[H\u0002J(\u0010]\u001a\u00020^2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020@H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "mentionDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/dependency/IMentionDependency;", "decorView", "Landroid/view/ViewGroup;", "hostFragment", "Landroidx/fragment/app/Fragment;", "hostActivity", "Landroidx/fragment/app/FragmentActivity;", "customOvalHeightDp", "", "attributeSet", "Landroid/util/AttributeSet;", "faceKBPluginDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/dependency/IVoiceFaceDependency;", "isContainerRootView", "Lkotlin/Function0;", "", "keyboardMenuConfig", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceKeyboardMenuConfig;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/plugin/tool/voice/dependency/IMentionDependency;Landroid/view/ViewGroup;Landroidx/fragment/app/Fragment;Landroidx/fragment/app/FragmentActivity;Ljava/lang/Float;Landroid/util/AttributeSet;Lcom/ss/android/lark/keyboard/plugin/tool/voice/dependency/IVoiceFaceDependency;Lkotlin/jvm/functions/Function0;Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceKeyboardMenuConfig;)V", "Ljava/lang/Float;", "voiceActionAreaUseCase", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/usecase/VoiceActionAreaUseCase;", "voiceBubbleAreaUseCase", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/usecase/VoiceBubbleAreaUseCase;", "voiceImeWrapperUseCase", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/usecase/VoiceImeWrapperUseCase;", "immersiveViewFinder", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/animation/ImmersiveViewFinder;", "getImmersiveViewFinder", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/animation/ImmersiveViewFinder;", "immersiveViewFinder$delegate", "Lkotlin/Lazy;", "isLifecycleObserverAdded", "voiceOvalBackground", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceOvalBackground;", "getVoiceOvalBackground", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceOvalBackground;", "voiceOvalBackground$delegate", "isWrapperLoaded", "imeWrapperContainer", "Landroid/widget/FrameLayout;", "getImeWrapperContainer", "()Landroid/widget/FrameLayout;", "imeWrapperContainer$delegate", "immersiveVoiceViewModel", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel;", "getImmersiveVoiceViewModel", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel;", "immersiveVoiceViewModel$delegate", "isPopUpAnimatorExecuting", "imeWrapper", "Lcom/ss/android/lark/keyboard/ime/ImeWrapper;", "keyboard", "Lcom/ss/android/lark/keyboard/IKeyBoard;", "isKeyboardAttached", "mRootView", "Landroid/view/View;", "initRootView", "", "initUI", "setupSkipFocus", "handleTouchEvent", "view", "event", "Landroid/view/MotionEvent;", "getAudioAdditionalRecordTime", "", "updateVoiceState", "target", "onAttachedToWindow", "onDetachedFromWindow", "onTouchEvent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "handleMentionResult", "mentionInfoList", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/dependency/MentionResultInfo;", "canScrollHorizontally", "direction", "", "getFacePlugin", "Lcom/ss/android/lark/keyboard/keyboard2/KeyboardMenuItem;", "getAtPlugin", "buildKeyboard", "Lcom/ss/android/lark/keyboard/KeyboardBuilder;", "editText", "Landroid/widget/EditText;", "clear", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImmersiveVoiceView extends ConstraintLayout {
    public static final /* synthetic */ int r = 0;
    public final ViewGroup a;
    public final Fragment b;
    public final FragmentActivity c;
    public final Float d;
    public final Function0<Boolean> e;
    public final a0 f;
    public VoiceActionAreaUseCase g;
    public VoiceBubbleAreaUseCase h;
    public VoiceImeWrapperUseCase i;
    public final Lazy j;
    public boolean k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public boolean o;
    public ImeWrapper p;
    public final View q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ImmersiveVoiceView a;

        public b(ImmersiveVoiceView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImeWrapper r0 = this.a.p;     // Catch: Throwable -> L7
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("imeWrapper");     // Catch: Throwable -> L7
            r0 = null;
        L5:
            r0.z();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ImmersiveVoiceView a;

        public c(ImmersiveVoiceView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImmersiveVoiceView.T5(this.a).whenReleaseOrCancelTouch();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ View a;

        public d(View r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            KeyboardUtils.hideKeyboard(this.a.getContext());
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        public final /* synthetic */ ImmersiveVoiceView a;

        public e(ImmersiveVoiceView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            ConstraintSet r10 = new ConstraintSet();
            r10.clone(this.a);
            r10.setMargin(2131365131, 4, UIUtils.dp2px(this.a.getContext(), -50.0f));
            r10.setMargin(2131383922, 4, UIUtils.dp2px(this.a.getContext(), -50.0f));
            r10.applyTo(this.a);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ ImmersiveVoiceView b;

        public f(View r1, ImmersiveVoiceView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ConstraintSet r0 = new ConstraintSet();
            r0.clone(this.b);
            r0.setVisibility(2131392735, 0);
            r0.setMargin(2131365131, 4, UIUtils.dp2px(this.b.getContext(), 12.0f));
            r0.setMargin(2131383922, 4, UIUtils.dp2px(this.b.getContext(), 12.0f));
            Float r1 = this.b.d;
            if (r1 == null) goto L5;
            float r2 = r1.floatValue();
            r0.setMargin(2131365121, 4, UIUtils.dp2px(this.b.getContext(), 12.0f + r2));
            r0.constrainHeight(2131392735, UIUtils.dp2px(this.b.getContext(), r2));
        L5:
            final ChangeBounds r3 = new ChangeBounds();
            r3.setDuration(150);
            r3.setInterpolator(new LinearInterpolator());
            r3.addTarget(2131392735);
            r3.addTarget(2131365131);
            r3.addTarget(2131383922);
            final ImmersiveVoiceView r4 = this.b;
            r3.addListener(new ImmersiveVoiceView$onAttachedToWindow$lambda$13$lambda$12$$inlined$doOnEnd$1(r3, r4));
            VoiceOvalBackground r5 = ImmersiveVoiceView.U5(this.b);
            final ImmersiveVoiceView r6 = this.b;
            VoiceOvalBackground.d(r5, new ImmersiveVoiceView$onAttachedToWindow$3$2(r6), 1);
            TransitionManager.beginDelayedTransition(this.b, r3);
            r0.applyTo(this.b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.h {
        public final /* synthetic */ ImmersiveVoiceView a;

        public static final class a implements Runnable {
            public final /* synthetic */ ImmersiveVoiceView a;

            public a(ImmersiveVoiceView r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ImmersiveVoiceView r0 = this.a;     // Catch: Throwable -> L4
                int r1 = ImmersiveVoiceView.r;     // Catch: Throwable -> L4
                r0.getClass();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceView] */
        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.h
        public final void hideKeyboard() {
            ?? r0 = this.a;
            r0.postDelayed(new a(r0), 100);
        }

        public g(ImmersiveVoiceView r1) {
            this.a = r1;
        }
    }

    public static final class h implements View.OnLayoutChangeListener {
        public final /* synthetic */ Configuration a;
        public final /* synthetic */ ImmersiveVoiceView b;

        public h(Configuration r1, ImmersiveVoiceView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            Configuration r10 = this.a;
            if (r10 == null) goto L12;
            ImmersiveVoiceView r11 = this.b;
            VoiceImeWrapperUseCase r12 = r11.i;
            if (r12 == null) goto L13;
            int r13 = ImmersiveVoiceView.S5(r11).f().getHeight();
            if (r10.orientation != 2) goto L9;
            boolean r14 = true;
        L10:
            VoiceImeWrapperUseCase.f(r12, r13, r14, 4);
            return;
        L9:
            r14 = false;
            goto L10
        L13:
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.ss.android.lark.keyboard.keyboard2.m getAtPlugin() {
        return new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin.a(getImmersiveViewFinder().a(), h18.f.a(getContext()));
    }

    private final FrameLayout getImeWrapperContainer() {
        return (FrameLayout) this.m.getValue();
    }

    private final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a getImmersiveViewFinder() {
        return (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a) this.j.getValue();
    }

    private final ImmersiveVoiceViewModel getImmersiveVoiceViewModel() {
        return (ImmersiveVoiceViewModel) this.n.getValue();
    }

    private final VoiceOvalBackground getVoiceOvalBackground() {
        return (VoiceOvalBackground) this.l.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z5() {
        View r1 = this.q;
        if (KeyboardVoiceFGUtils.d() == false) goto L6;
        FragmentActivity r2 = this.c;
    L6:
        if (KeyboardVoiceFGUtils.d() == false) goto L8;
        Log.e("ImmersiveVoiceView", "loss of dependency,can't build keyboard with emoji");
    L9:
        ImeWrapper r6 = null;
        this.p = new ImeWrapper(r1.getContext(), 0 == true ? 1 : 0, 6, 0);
        StringBuilder r3 = new StringBuilder("ImeWrapper instance passed to UseCase: ");
        ImeWrapper r4 = this.p;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("imeWrapper");
        r4 = null;
    L12:
        r3.append(r4.getClass().getSimpleName());
        r3.append('@');
        ImeWrapper r5 = this.p;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("imeWrapper");
        r5 = null;
    L15:
        r3.append(System.identityHashCode(r5));
        Log.d("ImmersiveVoiceView", r3.toString());
        this.g = new VoiceActionAreaUseCase(this, this.b, getImmersiveViewFinder());
        ImeWrapper r7 = this.p;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("imeWrapper");
        r7 = null;
    L18:
        VoiceImeWrapperUseCase r8 = new VoiceImeWrapperUseCase(this, r7, getImmersiveViewFinder(), this.b);
        this.i = r8;
        this.h = new VoiceBubbleAreaUseCase(this, this.b, r8, getImmersiveViewFinder());
        ImeWrapper r9 = this.p;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("imeWrapper");
    L22:
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) getImmersiveViewFinder().a().q(com.ss.android.lark.keyboard.edittext2.edittors.a.e)).W(CollectionsKt.listOf(new VoiceAtStrategy()));
        ((eob.a) getImmersiveViewFinder().a().q(eob.a.f)).U(CustomLinkStrategy.b);
        VoiceBubbleAreaUseCase r10 = this.h;
        if (r10 == null) goto L48;
        r10.d.s().b(r10.h());
        AppCompatImageView r11 = r10.d.m();
        AudioAsrLanguageSwitcher r12 = r10.v;
        VoiceBubbleAreaUseCase$initUI$1$1 r13 = new VoiceBubbleAreaUseCase$initUI$1$1(r10, r11);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "onLanguageSwitchListener");
        ((ArrayList) r12.d).add(r13);
        r11.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.g0(r10, r11));
        r10.d.i().setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.h0(r10));
        AppCompatTextView r14 = r10.d.i();
        int r15 = -13157826;
        if (h18.f.a(r10.d.l().getContext()) == false) goto L27;
        int r16 = -15921907;
    L28:
        r14.setTextColor(r16);
        AppCompatTextView r17 = r10.d.l();
        if (h18.f.a(r10.d.l().getContext()) == false) goto L31;
        r15 = -15921907;
    L31:
        r17.setTextColor(r15);
        r10.d.l().setOnClickListener(new i0(r10));
        AppCompatTextView r18 = r10.d.l();
        if (r18.isLaidOut() == true) goto L34;
    L36:
        r18.addOnLayoutChangeListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.f0(r10));
    L37:
        r10.u = new SpannableStringUtils.a(r10.d.a());
        r10.d.a().setOnFocusChangeListener(new j0(r10));
        r10.d.o().setOnClickListener(new k0(r10));
        r10.d.a().setHighlightColor(UDColorUtils.getAlphaColor(r10.a.getContext(), 2131105548, 0.2f));
        Context r19 = r10.a.getContext();
        LifecycleOwner r20 = r10.b;
        if (r20 != null) goto L41;
        Intrinsics.checkNotNull(r19);
        Activity r21 = ContextsKt.findActivity(r19);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r20 = (LifecycleOwner) r21;
    L41:
        int r110 = UIUtils.getColor(r19, 2131102439);
        int r111 = UIUtils.getColor(r19, 2131102093);
        ArrayList r22 = CollectionsKt.arrayListOf(new View[]{r10.d.o(), r10.d.b()});
        AppCompatTextView r112 = r10.a.findViewById(2131364936);
        ImmersiveVoiceViewModel r113 = r10.f();
        ConstraintLayout r114 = r10.d.o();
        if (r114.isLaidOut() == true) goto L44;
    L46:
        ImmersiveVoiceViewModel r23 = r113;
        r114.addOnLayoutChangeListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.e0(r23, r20, r112, r10, r110, r19, r22, r111));
    L47:
        r23.getAudioRecordVolume().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.u(r10));
        r23.getAudioAsrResult().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.v(r10));
        r23.getShowOriginalButtonVisible().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.w(r10));
        r23.getAsrNeedRetry().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.x(r10));
        ImmersiveVoiceViewModel r115 = r23;
        r23.getAsrResultRichText().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.z(r10, r115));
        r115.isShowTipsResultCanEditable().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.b0(r10));
        r115.isElapseCountDown().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.c0(r10));
        r115.getVoiceDuration().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.d0(r10));
        r115.isAsrRecognizeFinish().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.q(r10));
        r115.getAsrSessionState().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.r(r10, r22, r19, r115, r110, r111));
        r10.d.a().addTextChangedListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.t(r10));
    L49:
        getImeWrapperContainer().addView(r6);
        if (this.k == true) goto L52;
        KeyboardVoiceFGUtils.d();
    L52:
        View r24 = r1;
        r24.setClickable(true);
        r24.setOnClickListener(new d(r24));
        return;
    L44:
        if (r114.isLayoutRequested() == true) goto L46;
        r23 = r113;
        r113.getImmersiveVoiceState().observe(r20, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.p(r112, r10, r110, r19, r113, r22, r111));
        goto L47
    L34:
        if (r18.isLayoutRequested() == true) goto L36;
        AppCompatTextView r25 = r10.d.l();
        int r26 = r10.j;
        com.larksuite.framework.utils.g0.a(r25, r26, r26, r26, r26);
        goto L37
    L27:
        r16 = -13157826;
        goto L28
    L48:
        r1 = r1;
        goto L49
    L21:
        r6 = r9;
        goto L22
    L8:
        Log.w("ImmersiveVoiceView", "The FG of 'im.messenger.voice_input_emoji' not enable");
        goto L9
    }

    private final long getAudioAdditionalRecordTime() {
        return Math.max(AudioRecordSettings.d().getAudioAdditionalRecordTime(), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        if (KeyboardVoiceFGUtils.d() == false) goto L14;
        VoiceImeWrapperUseCase r0 = this.i;
        if (r0 == null) goto L10;
        ImeWrapper r1 = r0.a;
        r1.l(r0.n);
        if (KeyboardVoiceFGUtils.d() == false) goto L9;
        ExtensionImeKt.a(r1, r0.p);
        goto L10
    L9:
        ExtensionImeKt.a(r1, r0.o);
    L10:
        VoiceActionAreaUseCase r2 = this.g;
        if (r2 == null) goto L13;
        r2.h(false);
    L13:
        getImmersiveVoiceViewModel().setKeyboardController(new g(this));
    L15:
        getImmersiveVoiceViewModel();
        this.o = true;
        if (isLaidOut() == true) goto L18;
    L20:
        addOnLayoutChangeListener(new e(this));
    L21:
        OneShotPreDrawListener.add(this, new f(this, this));
        return;
    L18:
        if (isLayoutRequested() == true) goto L20;
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(this);
        r3.setMargin(2131365131, 4, UIUtils.dp2px(getContext(), -50.0f));
        r3.setMargin(2131383922, 4, UIUtils.dp2px(getContext(), -50.0f));
        r3.applyTo(this);
        goto L21
    L14:
        Z5();
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        getImmersiveVoiceViewModel().updateIsKeyboardShowing(false);
        if (KeyboardVoiceFGUtils.d() == false) goto L7;
        getImmersiveVoiceViewModel().removeKeyboardController();
        VoiceImeWrapperUseCase r0 = this.i;
        if (r0 == null) goto L12;
        r0.d();
        return;
    L12:
        return;
    L7:
        VoiceImeWrapperUseCase r1 = this.i;
        if (r1 == null) goto L10;
        r1.d();
    L10:
        this.i = null;
        this.g = null;
        this.h = null;
    }

    public static final /* synthetic */ com.ss.android.lark.keyboard.keyboard2.m R5(ImmersiveVoiceView r0) {
        return r0.getAtPlugin();
    }

    public static final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a S5(ImmersiveVoiceView r0) {
        return r0.getImmersiveViewFinder();
    }

    public static final /* synthetic */ ImmersiveVoiceViewModel T5(ImmersiveVoiceView r0) {
        return r0.getImmersiveVoiceViewModel();
    }

    public static final /* synthetic */ VoiceOvalBackground U5(ImmersiveVoiceView r0) {
        return r0.getVoiceOvalBackground();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(List<? extends qob.e> r9) {
        Intrinsics.checkNotNullParameter(r9, "mentionInfoList");
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        qob.e r0 = (qob.e) r10.next();
        if ((r0 instanceof qob.d) == true) goto L7;
        if ((r0 instanceof qob.c) == false) goto L4;
        AppCompatEditText r2 = getImmersiveViewFinder().a();
        int r1 = com.ss.android.lark.keyboard.edittext2.utils.e.c(r2);
        if (r1 < 0) goto L13;
        r2.getEditableText().delete(r1, r1 + 1);
    L13:
        ((qob.c) r0).getClass();
        ExtensionEditTextCompatKt.h(r2, null, null, null, false, null);
        goto L4
    L7:
        AppCompatEditText r3 = getImmersiveViewFinder().a();
        ((qob.d) r0).getClass();
        ExtensionEditTextCompatKt.i(r3, null, null, null, false, false);
        goto L4
    L14:
        VoiceImeWrapperUseCase r11 = this.i;
        if (r11 == null) goto L18;
        VoiceImeWrapperUseCase.f(r11, getImeWrapperContainer().getHeight(), false, 6);
    L18:
        if (KeyboardVoiceFGUtils.d() == true) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(getImmersiveVoiceViewModel().isKeyboardShowing().getValue(), Boolean.FALSE) == false) goto L22;
        postDelayed(new b(this), 100);
    L22:
        getImmersiveViewFinder().a().requestFocus();
    }

    public final boolean canScrollHorizontally(int r3) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l r4 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l) getImmersiveVoiceViewModel().getImmersiveVoiceState().getValue();
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.b() != true) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        boolean r1 = false;
        if (r5 != null) goto L5;
    L7:
        if (r1 == false) goto L18;
        if (r5.getAction() != 1) goto L18;
        if (Intrinsics.areEqual(getImmersiveVoiceViewModel().isPanelShowing().getValue(), Boolean.TRUE) == false) goto L18;
        ImeWrapper r6 = this.p;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("imeWrapper");
        r6 = null;
    L16:
        return r6.z();
    L18:
        return super/*android.view.ViewGroup*/.dispatchKeyEvent(r5);
    L5:
        if (r5.getKeyCode() != 4) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r4) {
        super/*android.view.ViewGroup*/.onConfigurationChanged(r4);
        AppCompatEditText r0 = getImmersiveViewFinder().a();
        if (r0.isLaidOut() == true) goto L5;
    L14:
        r0.addOnLayoutChangeListener(new h(r4, this));
        return;
    L5:
        if (r0.isLayoutRequested() == true) goto L14;
        if (r4 == null) goto L16;
        VoiceImeWrapperUseCase r1 = this.i;
        if (r1 == null) goto L17;
        int r2 = getImmersiveViewFinder().f().getHeight();
        if (r4.orientation != 2) goto L12;
        boolean r5 = true;
    L13:
        VoiceImeWrapperUseCase.f(r1, r2, r5, 4);
        return;
    L12:
        r5 = false;
        goto L13
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r3) {
        VoiceImeWrapperUseCase r0 = this.i;
        if (r0 == null) goto L9;
        if (r0.a.B() == false) goto L9;
        r0.a.a();
    L9:
        return super/*android.view.ViewGroup*/.onTouchEvent(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5(final View r4, final MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.o == true) goto L5;
    L7:
        int r0 = r5.getAction() & 255;
        if (r0 == 1) goto L22;
        if (r0 != 2) goto L11;
        Function0<Unit> r1 = new ImmersiveVoiceView$updateVoiceState$block$1(this, r5, r4);
        if (isLaidOut() == false) goto L17;
        r1.invoke();
        return;
    L17:
        if (isLaidOut() == true) goto L19;
    L21:
        addOnLayoutChangeListener(new h0(r1));
        return;
    L19:
        if (isLayoutRequested() == true) goto L21;
        r1.invoke();
        return;
    L11:
        if (r0 == 3) goto L22;
        return;
    L22:
        long r6 = getAudioAdditionalRecordTime();
        Handler r2 = getHandler();
        if (r2 == null) goto L26;
        r2.postDelayed(new c(this), r6);
    L26:
        if (getImmersiveVoiceViewModel().isBackgroundAsrKeepSessionMode() == false) goto L32;
        Log.i("ImmersiveVoiceView", "ACTION_UP/CANCEL: hide popup keep session");
        getImmersiveVoiceViewModel().requestHidePopupKeepSession();
        return;
    L32:
        return;
    L5:
        if ((r5.getAction() & 255) != 2) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmersiveVoiceView(Context r1, AudioPopupWindowImpl.b r2, Fragment r3, FragmentActivity r4, Float r5, IVoiceFaceDependency r6, Function0 r7, a0 r8) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "decorView");
        Intrinsics.checkNotNullParameter(r7, "isContainerRootView");
        Intrinsics.checkNotNullParameter(r8, "keyboardMenuConfig");
        super(r1, null);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.j = LazyKt.lazy(new ImmersiveVoiceView$immersiveViewFinder$2(this));
        this.l = LazyKt.lazy(new ImmersiveVoiceView$voiceOvalBackground$2(this));
        this.m = LazyKt.lazy(new ImmersiveVoiceView$imeWrapperContainer$2(this));
        this.n = LazyKt.lazy(new ImmersiveVoiceView$immersiveVoiceViewModel$2(this));
        this.q = LayoutInflater.from(r1).inflate(2131563337, this, true);
        getImmersiveViewFinder().a().addTextChangedListener(new sob.g(new AnonymousClass1(this), AnonymousClass2.INSTANCE));
        if (KeyboardVoiceFGUtils.d() == false) goto L6;
        Z5();
        return;
    }
}
