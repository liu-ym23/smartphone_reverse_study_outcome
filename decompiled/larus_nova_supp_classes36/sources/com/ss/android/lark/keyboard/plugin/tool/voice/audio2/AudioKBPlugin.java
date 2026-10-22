package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audio.voiceinput.AudioPluginUseType;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.audio.voiceinput.p;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenu;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.z;
import com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AudioKBPlugin extends PanelMenuItem {
    public static final /* synthetic */ int v = 0;
    public final boolean d;
    public final qob.a e;
    public final p f;
    public final IVoiceFaceDependency g;
    public final String h;
    public final Function1<com.ss.android.lark.keyboard.b, Unit> i;
    public final KeyboardMenuItemKey j;
    public final Lazy k;
    public AudioPanelContainer l;
    public AppCompatImageView m;
    public f n;
    public final Function0<Unit> o;
    public final Lazy p;
    public final Lazy q;
    public final CoroutineScope r;
    public final Lazy s;
    public final List<z> t;
    public final e u;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ AudioKBPlugin b;

        public b(Function0<Unit> r1, AudioKBPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
            this.b.getClass();
            throw null;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ AudioKBPlugin a;
        public final /* synthetic */ com.ss.android.lark.keyboard.keyboard2.i.a b;

        public c(AudioKBPlugin r1, com.ss.android.lark.keyboard.keyboard2.i.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.o.invoke();
            this.a.getClass();
            this.b.performClick();
        }
    }

    static {
    }

    public AudioKBPlugin() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return 2131256166;
    }

    public final Activity H() {
        return (Activity) this.k.getValue();
    }

    public final h J() {
        return (h) this.q.getValue();
    }

    public final boolean K() {
        AudioPluginHelper r0 = (AudioPluginHelper) this.s.getValue();
        boolean r2 = true;
        if (r0.e == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
    L16:
        Log.i("AudioSendTypeHelper", "enableUseNewAudioPlugin: " + r2);
        Log.i("AudioKBPlugin", "isImmersiveVoicePluginEnable: " + r2);
        return r2;
    L10:
        if (r0.a.f.b != VoiceInputScene.EnterpriseAnswer) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L16;
        r2 = false;
        goto L16
    L12:
        r3 = false;
        goto L13
    L5:
        if (r0.c != AudioPluginUseType.NEW) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void u() {
        ((AudioPluginHelper) this.s.getValue()).a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return 2131914265;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void v() {
        if (K() == true) goto L5;
        J().i();
    L5:
        n().v();
        this.e.getChatId();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.j;
    }

    public AudioKBPlugin(AudioKBPlugin r8) {
        Intrinsics.checkNotNullParameter(r8, "audioKBPlugin");
        r8.getClass();
        boolean r0 = r8.d;
        qob.a r1 = r8.e;
        p r2 = r8.f;
        IVoiceFaceDependency r3 = r8.g;
        String r4 = r8.h;
        Function1<com.ss.android.lark.keyboard.b, Unit> r9 = r8.i;
        Intrinsics.checkNotNullParameter(null, "chatAppDependency");
        Intrinsics.checkNotNullParameter(r1, "audioDataProcessorDependency");
        Intrinsics.checkNotNullParameter(r2, "voiceInputModeWithScene");
        Intrinsics.checkNotNullParameter(r4, "hitPointPageScene");
        this.d = r0;
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r9;
        this.j = KeyboardMenuItemKey.Voice;
        this.k = LazyKt.lazy(new AudioKBPlugin$mContext$2(this));
        this.o = AudioKBPlugin$mPluginClickListener$1.INSTANCE;
        this.p = LazyKt.lazy(new AudioKBPlugin$mViewModel$2(this));
        this.q = LazyKt.lazy(new AudioKBPlugin$mController$2(this));
        this.r = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool()).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.s = LazyKt.lazy(new AudioKBPlugin$audioPluginHelper$2(this));
        this.t = new ArrayList();
        this.u = new e(this);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r2) {
        ((AudioViewModel) this.p.getValue()).onAudioPluginSelectChange(r2);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "container");
        Object r7 = LayoutInflater.from(H()).inflate(2131563273, r6, false);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelContainer");
        AudioPanelContainer r8 = (AudioPanelContainer) r7;
        this.l = r8;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
        r8 = null;
    L5:
        h r2 = J();
        AudioViewModel r3 = (AudioViewModel) this.p.getValue();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r2, "controller");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        r8.c = r2;
        r8.d = r3;
        r8.V5(this.f.a(), this.f.a(), new AudioKBPlugin$onCreatePanel$1(this));
        ConstraintLayout r9 = this.l;
        if (r9 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
        return null;
    L9:
        return r9;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(com.ss.android.lark.keyboard.keyboard2.i r5) {
        Intrinsics.checkNotNullParameter(r5, "iconHolder");
        if (K() == true) goto L36;
        Function1<com.ss.android.lark.keyboard.b, Unit> r0 = this.i;
        if (r0 == null) goto L7;
        r0.invoke(n());
    L7:
        AppCompatImageView r1 = r5.a;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        AppCompatImageView r2 = r1;
        r2.setActivated(this.d);
        if (this.d == false) goto L10;
    L16:
        r2.setHapticFeedbackEnabled(true);
        r2.setBackground(null);
        KeyboardMenu.f r6 = r5.b.a();
        if (K() == false) goto L33;
        com.ss.android.lark.keyboard.keyboard2.content.c r7 = n().v();
        ImmersiveVoiceInputComponent.a r3 = ImmersiveVoiceInputComponent.a;
        IKeyboardContent r8 = r7.getContent();
        if ((r8 instanceof ImmersiveVoiceInputComponent) == false) goto L21;
        final ImmersiveVoiceInputComponent r9 = (ImmersiveVoiceInputComponent) r8;
    L22:
        if (r9 == null) goto L34;
        ImmersiveVoiceInputComponent.b.add(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.c(this));
        if (this.f.a() == false) goto L31;
        KeyboardVoiceFGUtils r4 = KeyboardVoiceFGUtils.a;
        if (KeyboardVoiceFGUtils.a("im.messenger.new_speech_to_text", null) == false) goto L31;
        if (KeyboardVoiceFGUtils.a("im.messenger.advance_mode_refactor", null) == false) goto L30;
        r2.setOnTouchListener(null);
    L32:
        r2.setOnClickListener(new b(new AudioKBPlugin$onIconCreated$1$hideImeWrapper$1(r9), this));
        goto L34
    L30:
        throw null;
    L31:
        r2.setOnTouchListener(ImmersiveVoiceInputComponent.f(r9, new AudioKBPlugin$onIconCreated$1$1(r9)));
    L34:
        n().e().of(this).d(InputSupportType.class, new AudioKBPlugin$onIconCreated$3(this));
        this.m = r2;
        return;
    L21:
        r9 = null;
        goto L22
    L33:
        r2.setOnTouchListener(new d(this, new c(this, r6)));
        goto L34
    L10:
        if (this.f.a() == false) goto L16;
        if (K() == false) goto L14;
        r2.setImageDrawable(UIUtils.getDrawable(H(), 2131255118));
        goto L16
    L14:
        J().getClass();
        throw null;
    L36:
        throw null;
    }
}
