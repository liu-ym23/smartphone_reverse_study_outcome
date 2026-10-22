package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rob.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\rR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPanelInnerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "mController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "mFeature", "Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;)V", "mHintTv", "Landroidx/appcompat/widget/AppCompatTextView;", "getMHintTv", "()Landroidx/appcompat/widget/AppCompatTextView;", "mHintTv$delegate", "Lkotlin/Lazy;", "mMainBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "getMMainBtn", "()Lcom/larksuite/component/universe_design/button/UDButton;", "mMainBtn$delegate", "mSwitchLanguageTv", "getMSwitchLanguageTv", "mSwitchLanguageTv$delegate", "mOnLongPressedRunnable", "Ljava/lang/Runnable;", "isSingleClick", "", "mDownX", "", "mDownY", "getOnTouchListener", "Landroid/view/View$OnTouchListener;", "onActionDown", "event", "Landroid/view/MotionEvent;", "getMainButtonTopRawY", "", "getMainBtnBottomMargin", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioPanelInnerView extends ConstraintLayout {
    public static final /* synthetic */ int h = 0;
    public final h a;
    public final AudioPluginFeature b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public g f;
    public boolean g;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelInnerView$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/larksuite/component/universe_design/button/ButtonDrawableParams;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class AnonymousClass2 extends Lambda implements Function1<com.larksuite.component.universe_design.button.a, Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        public final void invoke(com.larksuite.component.universe_design.button.a r2) {
            Intrinsics.checkNotNullParameter(r2, "$this$showDrawable");
            r2.c = 2;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.larksuite.component.universe_design.button.a) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements AudioAsrLanguageSwitcher.b {
        public final /* synthetic */ AppCompatTextView a;

        public a(AppCompatTextView r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
        public final void a(j r2) {
            Intrinsics.checkNotNullParameter(r2, "itemData");
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
        public final void b(rob.e r2) {
            Intrinsics.checkNotNullParameter(r2, "itemData");
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
        public final void d(SendType r2) {
            Intrinsics.checkNotNullParameter(r2, "sendType");
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
        public final void c(String r1, String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "languageName");
            Intrinsics.checkNotNullParameter(r2, "<unused var>");
            this.a.setText(r1);
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioPluginFeature.values().length];
            r0[AudioPluginFeature.RECOGNIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class d implements View.OnTouchListener {
        public final /* synthetic */ AudioPanelInnerView a;

        public d(AudioPanelInnerView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r6v17, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelInnerView] */
        /* JADX WARN: Type inference failed for: r6v2, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelInnerView, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelInnerView] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r6, MotionEvent r7) {
            int r8 = r7.getAction();
            if (r8 == 0) goto L15;
            if (r8 != 1) goto L6;
            Log.i("AudioPanelInnerView", "onActionUp");
            this.a.getParent().requestDisallowInterceptTouchEvent(false);
            ?? r9 = this.a;
            r9.removeCallbacks(r9.f);
            AudioPanelInnerView r10 = this.a;
            if (r10.g == true) goto L13;
        L11:
            h r11 = this.a.a;
            Intrinsics.checkNotNull(r7);
            r11.j(r7);
            return true;
        L13:
            h r12 = r10.a;
            AudioPanelInnerView.S5(r10);
            AudioPanelInnerView.R5(this.a);
            r12.getClass();
            throw null;
        L6:
            if (r8 != 3) goto L11;
            Log.i("AudioPanelInnerView", "onActionCancel");
            this.a.getParent().requestDisallowInterceptTouchEvent(false);
            ?? r13 = this.a;
            r13.removeCallbacks(r13.f);
            goto L11
        L15:
            ?? r14 = this.a;
            Intrinsics.checkNotNull(r7);
            int r4 = AudioPanelInnerView.h;
            r14.getClass();
            Log.i("AudioPanelInnerView", "onActionDown");
            r7.getX();
            r7.getY();
            int r5 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
            if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.g(r14.getContext()) == true) goto L19;
            com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.j(ContextsKt.requireActivity(r14.getContext()), AudioPanelInnerView$onActionDown$1.INSTANCE);
            return false;
        L19:
            if (r14.b == AudioPluginFeature.RECOGNIZE) goto L21;
        L25:
            r14.g = true;
            g r0 = new g(r14, r7);
            r14.f = r0;
            AudioPluginFeature r15 = r14.b;
            if (c.a[r15.ordinal()] != 1) goto L28;
            long r1 = 300;
        L29:
            r14.postDelayed(r0, r1);
            return true;
        L28:
            r1 = 100;
            goto L29
        L21:
            if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.h() == false) goto L25;
            Log.i("AudioPanelInnerView", "onActionDown / Network unavailable");
            r14.a.getClass();
            throw null;
        }
    }

    static {
    }

    private final int getMainButtonTopRawY() {
        int[] r0 = new int[2];
        getMMainBtn().getLocationOnScreen(r0);
        return r0[1];
    }

    private final AppCompatTextView getMHintTv() {
        return (AppCompatTextView) this.c.getValue();
    }

    private final UDButton getMMainBtn() {
        return (UDButton) this.d.getValue();
    }

    private final AppCompatTextView getMSwitchLanguageTv() {
        return (AppCompatTextView) this.e.getValue();
    }

    private final View.OnTouchListener getOnTouchListener() {
        return new d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getMainBtnBottomMargin() {
        return getMeasuredHeight() - getMMainBtn().getBottom();
    }

    public static final /* synthetic */ int R5(AudioPanelInnerView r0) {
        return r0.getMainBtnBottomMargin();
    }

    public static final /* synthetic */ int S5(AudioPanelInnerView r0) {
        return r0.getMainButtonTopRawY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioPanelInnerView(Context r4, h r5, AudioPluginFeature r6) {
        super(r4);
        this.a = r5;
        this.b = r6;
        this.c = LazyKt.lazy(new AudioPanelInnerView$mHintTv$2(this));
        this.d = LazyKt.lazy(new AudioPanelInnerView$mMainBtn$2(this));
        this.e = LazyKt.lazy(new AudioPanelInnerView$mSwitchLanguageTv$2(this));
        LayoutInflater.from(r4).inflate(2131563274, this);
        getMMainBtn().setOnTouchListener(getOnTouchListener());
        AppCompatTextView r7 = getMSwitchLanguageTv();
        int r8 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        Drawable r9 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.d(r7, 2131254256);
        r9.setBounds(0, 0, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.m(r7, 10), com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.m(r7, 10));
        r7.setCompoundDrawables(null, null, r9, null);
        a r10 = new a(r7);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "onLanguageSwitchListener");
        throw null;
    }
}
