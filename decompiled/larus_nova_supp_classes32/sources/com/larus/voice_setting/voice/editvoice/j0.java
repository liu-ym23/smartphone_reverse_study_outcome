package com.larus.voice_setting.voice.editvoice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusLayoutVoiceEditAreaBinding;
import com.larus.voice_setting.impl.databinding.LarusLayoutVoiceEditAreaNewBinding;
import com.larus.voice_setting.impl.databinding.LarusTtsSpeakerContentNewStyleBinding;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.mix.SingleVoiceBar;
import com.larus.voice_setting.voice.mix.VoiceEditArea;
import com.larus.voice_setting.voice.mix.VoiceEditArea$initPitchAndRate$1$pitchAccessibilityDelegate$1;
import com.larus.voice_setting.voice.mix.VoiceEditArea$initPitchAndRate$1$rateAccessibilityDelegate$1;
import com.larus.voice_setting.voice.mix.VoiceMixBar;
import com.larus.voice_setting.voice.mix.VoiceMixedView;
import com.larus.voice_setting.voice.mix.VoiceSingleView;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j0 {
    public final Context a;
    public final LifecycleOwner b;
    public final LarusTtsSpeakerContentNewStyleBinding c;
    public final SpeakerVoiceEditModel d;
    public by7.e e;
    public boolean f;
    public b g;

    public static final class a {
    }

    public static final class b extends AppBarLayoutStateListener {
        public final /* synthetic */ LarusTtsSpeakerContentNewStyleBinding b;

        public b(LarusTtsSpeakerContentNewStyleBinding r1) {
            this.b = r1;
        }

        @Override // com.larus.voice_setting.voice.base.AppBarLayoutStateListener
        public final void a(AppBarLayout r4, AppBarLayoutStateListener.State r5, AppBarLayoutStateListener.State r6) {
            Intrinsics.checkNotNullParameter(r4, "appBarLayout");
            Intrinsics.checkNotNullParameter(r5, "lastState");
            Intrinsics.checkNotNullParameter(r6, "state");
            FLogger r0 = FLogger.a;
            r0.i("EditVoiceUIBinder", "[onStateChange] last:" + r5 + ", state=" + r6);
            VoiceMixedView r7 = this.b.k.getVoiceMixView();
            if (r7 == null) goto L11;
            Intrinsics.checkNotNullParameter(r6, "state");
            r0.i(r7.d, "[viewState] to:" + r6);
            r7.j = r6;
            if (r6 == AppBarLayoutStateListener.State.COLLAPSED) goto L8;
            r7.c();
            return;
        L8:
            if (r7.getChildCount() != 1) goto L13;
            r7.p.invoke(Integer.valueOf(r7.getChildCount()), Boolean.TRUE);
            return;
        L13:
            return;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, android.view.ViewGroup, com.larus.voice_setting.voice.mix.VoiceEditArea, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, android.view.ViewGroup, com.larus.voice_setting.voice.mix.VoiceEditArea] */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.larus.voice_setting.voice.editvoice.i, java.lang.Object, kotlin.jvm.functions.Function0<kotlin.Unit>] */
    public final void a(by7.e r29) {
        this.e = r29;
        LarusTtsSpeakerContentNewStyleBinding r2 = this.c;
        if (r2 != null) goto L5;
        return;
    L5:
        ?? r15 = r2.k;
        SpeakerVoiceEditModel r0 = this.d;
        int r14 = r0.g;
        boolean r1 = r0.M;
        Function1<? super Float, Unit> r3 = new com.larus.voice_setting.voice.editvoice.c(this);
        Function1<? super Float, Unit> r4 = new d(this);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r3, "pitchChangeAction");
        Intrinsics.checkNotNullParameter(r4, "speechRateChangeAction");
        r15.d = Integer.valueOf(r14);
        r15.f = r1;
        r15.b = r3;
        r15.c = r4;
        int r5 = 2131362280;
        if (r14 == 1) goto L59;
        if (r14 == 2) goto L59;
        LayoutInflater.from(r15.getContext()).inflate(2131562930, r15);
        ConstraintLayout r12 = ViewBindings.findChildViewById(r15, 2131362280);
        if (r12 == null) goto L58;
        SeekBar r6 = (SeekBar) ViewBindings.findChildViewById(r15, 2131382335);
        if (r6 == null) goto L55;
        AppCompatTextView r13 = ViewBindings.findChildViewById(r15, 2131382336);
        if (r13 == null) goto L54;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r15, 2131382337);
        if (r17 != null) goto L17;
        r5 = 2131382337;
        goto L58
    L17:
        if (((LinearLayout) ViewBindings.findChildViewById(r15, 2131382419)) == null) goto L52;
        FrameLayout r18 = (FrameLayout) ViewBindings.findChildViewById(r15, 2131382425);
        if (r18 == null) goto L51;
        AppCompatImageView r19 = ViewBindings.findChildViewById(r15, 2131382433);
        if (r19 == null) goto L50;
        LottieAdapterView r20 = ViewBindings.findChildViewById(r15, 2131382437);
        if (r20 == null) goto L49;
        SeekBar r21 = (SeekBar) ViewBindings.findChildViewById(r15, 2131383695);
        if (r21 == null) goto L48;
        AppCompatTextView r22 = ViewBindings.findChildViewById(r15, 2131383696);
        if (r22 == null) goto L47;
        TextView r23 = (TextView) ViewBindings.findChildViewById(r15, 2131383699);
        if (r23 == null) goto L46;
        View r24 = ViewBindings.findChildViewById(r15, 2131386673);
        if (r24 != null) goto L33;
        r5 = 2131386673;
        goto L58
    L33:
        if (((LinearLayout) ViewBindings.findChildViewById(r15, 2131392711)) == null) goto L44;
        LinearLayout r25 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131392713);
        if (r25 != null) goto L37;
        r5 = 2131392713;
        goto L58
    L37:
        if (((TextView) ViewBindings.findChildViewById(r15, 2131392715)) == null) goto L42;
        VoiceMixedView r26 = (VoiceMixedView) ViewBindings.findChildViewById(r15, 2131392731);
        if (r26 == null) goto L41;
        VoiceEditArea r7 = r15;
        r7.a = new v2a.o(new LarusLayoutVoiceEditAreaBinding(r15, r12, r6, r13, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26));
        final VoiceEditArea r8 = r7;
    L80:
        v2a.a r9 = r8.a;
        if (r9 == null) goto L85;
        VoiceMixedView r10 = r9.d();
        if (r10 == null) goto L85;
        r10.setRenderCountChange(new v2a.i(r8));
    L85:
        v2a.a r11 = r8.a;
        if (r11 == null) goto L113;
        View r16 = r11.f();
        if (r16 == null) goto L113;
        Context r27 = r16.getContext();
        if (r27 == null) goto L113;
        boolean r28 = r8.f;
        String r30 = NameKeys.UnloadStrategy_No_Strategy;
        if (r28 == true) goto L276;
        boolean r31 = true;
        String r32 = r30;
    L109:
        if (com.larus.utils.o0.d(r32) == false) goto L114;
        TextView r33 = (TextView) r16.findViewById(2131392715);
        if (r33 == null) goto L114;
        r33.setText(r32);
    L114:
        v2a.a r34 = r8.a;
        if (r34 == null) goto L126;
        View r35 = r34.getRoot();
        if (r35 == null) goto L126;
        v2a.a r36 = r8.a;
        if (r36 == null) goto L123;
        View r37 = r36.getRoot();
        if (r37 == null) goto L123;
        Context r38 = r37.getContext();
    L124:
        r35.setBackgroundResource(v19.c.b(2130970879, r38, 2131239883));
    L123:
        r38 = null;
    L126:
        if (r14 == 2) goto L131;
        if (r14 == 3) goto L131;
        v2a.a r39 = r8.a;
        if (r39 == null) goto L136;
        e1.o(r39.b());
        e1.o(r39.g());
        e1.o(r39.j());
        e1.o(r39.l());
        e1.o(r39.i());
        e1.o(r39.c());
    L136:
        b r40 = new b(r2);
        this.g = r40;
        r2.b.addOnOffsetChangedListener(r40);
        this.d.G.observe(this.b, new c(new e(this)));
        this.d.w.observe(this.b, new c(new f(this)));
        if (this.d.e == false) goto L204;
        LarusTtsSpeakerContentNewStyleBinding r41 = this.c;
        if (r41 == null) goto L160;
        final VoiceEditArea r42 = r41.k;
        if (r42 == null) goto L160;
        VoiceMixedView r43 = r42.getVoiceMixView();
        if (r43 == null) goto L145;
        r43.setVoiceProportionCallback(new v(this));
    L145:
        VoiceMixedView r44 = r42.getVoiceMixView();
        if (r44 == null) goto L148;
        r44.setRemoveCallback(new x(this));
    L148:
        VoiceMixedView r45 = r42.getVoiceMixView();
        if (r45 == null) goto L151;
        r45.setVoiceAuditionCallback(new y(this));
    L151:
        VoiceMixedView r46 = r42.getVoiceMixView();
        if (r46 == null) goto L154;
        r46.setVoiceAuditionEndCallback(new z(this));
    L154:
        VoiceMixedView r47 = r42.getVoiceMixView();
        if (r47 == null) goto L157;
        r47.setCollapseCallback(new a0(this, r42));
    L157:
        VoiceMixedView r48 = r42.getVoiceMixView();
        if (r48 == null) goto L160;
        r48.setAudioObserverExtraParamsGetter(new b0(this));
    L160:
        LarusTtsSpeakerContentNewStyleBinding r49 = this.c;
        if (r49 == null) goto L194;
        VoiceEditArea r50 = r49.k;
        if (r50 == null) goto L194;
        List r51 = this.d.n;
        FLogger.a.i("VoiceEditArea", "[initMixView] list:" + r51);
        v2a.a r52 = r50.a;
        if (r52 == null) goto L194;
        if (r51 != null) goto L169;
        r51 = CollectionsKt.emptyList();
    L169:
        if (r51.isEmpty() == false) goto L171;
        r52.f().setVisibility(0);
        r52.a().setVisibility(8);
    L172:
        VoiceMixedView r53 = r52.d();
        if (r53 == null) goto L194;
        Integer r54 = r50.d;
        boolean r55 = r50.f;
        Intrinsics.checkNotNullParameter(r51, "list");
        if (r54 == null) goto L177;
        r54.intValue();
    L177:
        r53.n = r55;
        r53.removeAllViews();
        if (r51.isEmpty() == true) goto L194;
        if (r51.size() != r31) goto L183;
        r53.b((MixVoice) ListProtector.get(r51, 0));
    L187:
        if (r55 == false) goto L190;
    L192:
        r31 = false;
    L193:
        r53.p.invoke(Integer.valueOf(r53.getChildCount()), Boolean.valueOf(r31));
        goto L194
    L190:
        if (r53.getChildCount() != r31) goto L192;
    L183:
        Iterator r56 = r51.iterator();
    L185:
        if (r56.hasNext() == false) goto L187;
        r53.a((MixVoice) r56.next());
        goto L185
    L171:
        r52.f().setVisibility(8);
        r52.a().setVisibility(0);
    L194:
        LarusTtsSpeakerContentNewStyleBinding r57 = this.c;
        if (r57 == null) goto L203;
        VoiceMixBar r58 = r57.e;
        if (r58 == null) goto L203;
        ArrayList<MixVoice> r59 = this.d.n;
        Intrinsics.checkNotNullParameter(r59, "mixVoiceList");
        Iterator<MixVoice> r60 = r59.iterator();
    L200:
        if (r60.hasNext() == false) goto L202;
        r58.R5(r60.next(), false);
        goto L200
    L202:
        r58.applyState();
    L203:
        this.d.p.observe(this.b, new c(new n(this)));
        this.d.p.observe(this.b, new c(new o()));
        this.d.u.observe(this.b, new c(new p(this)));
        this.d.s.observe(this.b, new c(new q(this)));
        this.d.m.observe(this.b, new c(new r(this)));
        this.d.E.observe(this.b, new c(new s()));
    L222:
        LarusTtsSpeakerContentNewStyleBinding r61 = this.c;
        if (r61 == null) goto L246;
        VoiceEditArea r62 = r61.k;
        if (r62 == null) goto L246;
        final ?? r63 = new i(this);
        Intrinsics.checkNotNullParameter(r63, "callback");
        Integer r64 = r62.d;
        if (r64 != null) goto L230;
    L241:
        v2a.a r65 = r62.a;
        if (r65 == null) goto L246;
        ConstraintLayout r66 = r65.k();
        if (r66 == null) goto L246;
        e1.d(r66, new v2a.k(r63));
        goto L246
    L230:
        if (r64.intValue() != 3) goto L241;
        v2a.a r67 = r62.a;
        if (r67 == null) goto L236;
        View r68 = r67.e();
        if (r68 == null) goto L236;
        e1.d(r68, new v2a.j(r63));
    L236:
        v2a.a r69 = r62.a;
        if (r69 == null) goto L246;
        VoiceMixedView r70 = r69.d();
        if (r70 == null) goto L246;
        Intrinsics.checkNotNullParameter(r63, "callback");
        r70.m = r63;
    L246:
        SpeakerVoiceEditModel r71 = this.d;
        if (r71.e == false) goto L254;
        LarusTtsSpeakerContentNewStyleBinding r72 = this.c;
        if (r72 == null) goto L260;
        VoiceMixBar r73 = r72.e;
        if (r73 == null) goto L260;
        Function0 r74 = new j(this);
        Intrinsics.checkNotNullParameter(r74, "callback");
        e1.d(r73.e.d, new v2a.t(r73, r74));
    L260:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), null, null, new EditVoiceContentUIBinder$initPlayStatusObserver$1(this, null), 3, null);
        this.d.y.observe(this.b, new c(new h(this)));
        this.d.C.observe(this.b, new c(new m(this)));
        return;
    L254:
        if (r71.g != 2) goto L260;
        LarusTtsSpeakerContentNewStyleBinding r75 = this.c;
        if (r75 == null) goto L260;
        SingleVoiceBar r76 = r75.h;
        if (r76 == null) goto L260;
        Function0 r77 = new k(this);
        Intrinsics.checkNotNullParameter(r77, "callback");
        e1.d(r76.a.b, new v2a.h(r77));
        goto L260
    L204:
        k0 r78 = new k0(this);
        LarusTtsSpeakerContentNewStyleBinding r79 = this.c;
        if (r79 == null) goto L211;
        SingleVoiceBar r80 = r79.h;
        if (r80 == null) goto L211;
        VoiceSingleView r81 = r80.getVoiceSingleView();
        if (r81 == null) goto L211;
        r81.setListener(r78);
    L211:
        LarusTtsSpeakerContentNewStyleBinding r82 = this.c;
        if (r82 == null) goto L218;
        VoiceEditArea r83 = r82.k;
        if (r83 == null) goto L218;
        VoiceSingleView r84 = r83.getVoiceSingleView();
        if (r84 == null) goto L218;
        r84.setListener(r78);
    L218:
        final Context r85 = this.a;
        if (r85 == null) goto L222;
        this.d.j.observe(this.b, new c(new t(this)));
        this.d.E.observe(this.b, new c(new u(this, r85)));
    L131:
        v2a.a r86 = r8.a;
        if (r86 == null) goto L136;
        r86.g().setOnSeekBarChangeListener(new v2a.l(r86, r8));
        r86.i().setOnSeekBarChangeListener(new v2a.m(r86, r8));
        if (z2.a.enableVoiceSettingTalkback() == false) goto L136;
        ViewCompat.setAccessibilityDelegate(r86.g(), new VoiceEditArea$initPitchAndRate$1$pitchAccessibilityDelegate$1(r8));
        ViewCompat.setAccessibilityDelegate(r86.i(), new VoiceEditArea$initPitchAndRate$1$rateAccessibilityDelegate$1(r8));
        goto L136
    L276:
        Result.Companion r87 = Result.Companion;     // Catch: Throwable -> L99
        StringCompanionObject r88 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L99
        r31 = true;
        Object r89 = Result.constructor-impl(String.format(r27.getString(2131907476), Arrays.copyOf(new Object[]{RiskPreferenceSettings.AUTONOMY_FIRST}, 1)));     // Catch: Throwable -> L97
    L102:
        Object r90 = r30;
        if (Result.isFailure-impl(r89) == true) goto L106;
        r90 = r89;
    L106:
        r32 = (String) r90;
    L97:
        th = th;
    L101:
        Result.Companion r91 = Result.Companion;
        r89 = Result.constructor-impl(ResultKt.createFailure(th));
    L99:
        th = th;
        r31 = true;
    L113:
        r31 = true;
        goto L114
    L41:
        r5 = 2131392731;
        goto L58
    L42:
        r5 = 2131392715;
        goto L58
    L44:
        r5 = 2131392711;
        goto L58
    L46:
        r5 = 2131383699;
        goto L58
    L47:
        r5 = 2131383696;
        goto L58
    L48:
        r5 = 2131383695;
        goto L58
    L49:
        r5 = 2131382437;
        goto L58
    L50:
        r5 = 2131382433;
        goto L58
    L51:
        r5 = 2131382425;
        goto L58
    L52:
        r5 = 2131382419;
        goto L58
    L54:
        r5 = 2131382336;
        goto L58
    L55:
        r5 = 2131382335;
    L58:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r5)));
    L59:
        ?? r92 = r15;
        LayoutInflater.from(r92.getContext()).inflate(2131562931, r92);
        ConstraintLayout r110 = ViewBindings.findChildViewById(r92, 2131362280);
        if (r110 == null) goto L273;
        SeekBar r93 = (SeekBar) ViewBindings.findChildViewById(r92, 2131382335);
        if (r93 == null) goto L270;
        AppCompatTextView r111 = ViewBindings.findChildViewById(r92, 2131382336);
        if (r111 == null) goto L269;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r92, 2131382337);
        if (r112 == null) goto L268;
        SeekBar r113 = (SeekBar) ViewBindings.findChildViewById(r92, 2131383695);
        if (r113 == null) goto L267;
        AppCompatTextView r114 = ViewBindings.findChildViewById(r92, 2131383696);
        if (r114 == null) goto L266;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r92, 2131383699);
        if (r115 == null) goto L265;
        LinearLayout r116 = (LinearLayout) ViewBindings.findChildViewById(r92, 2131392713);
        if (r116 != null) goto L76;
        r5 = 2131392713;
        goto L273
    L76:
        if (((TextView) ViewBindings.findChildViewById(r92, 2131392715)) == null) goto L263;
        VoiceSingleView r117 = (VoiceSingleView) ViewBindings.findChildViewById(r92, 2131392764);
        if (r117 == null) goto L262;
        r92.a = new v2a.n(new LarusLayoutVoiceEditAreaNewBinding(r92, r110, r93, r111, r112, r113, r114, r115, r116, r117));
        r8 = r92;
        goto L80
    L262:
        r5 = 2131392764;
        goto L273
    L263:
        r5 = 2131392715;
        goto L273
    L265:
        r5 = 2131383699;
        goto L273
    L266:
        r5 = 2131383696;
        goto L273
    L267:
        r5 = 2131383695;
        goto L273
    L268:
        r5 = 2131382337;
        goto L273
    L269:
        r5 = 2131382336;
        goto L273
    L270:
        r5 = 2131382335;
    L273:
        throw new NullPointerException("Missing required view with ID: ".concat(r92.getResources().getResourceName(r5)));
    }

    public final void b(final String r8) {
        Intrinsics.checkNotNullParameter(r8, "from");
        final MixVoice r0 = (MixVoice) CollectionsKt.firstOrNull(this.d.f());
        if (r0 == null) goto L5;
        f2a.c r2 = com.larus.voice_setting.voice.utils.k.a.b("click play button");
        r2.e(new g(r0, r8));
        r2.c.b = CollectionsKt.listOf("VoicePlay");
        f2a.c.c(r2, null, 15);
    L5:
        FLogger.a.i("EditVoiceUIBinder", "onPlayButtonClick: from(" + r8 + ')');
        SpeakerVoiceEditModel r9 = this.d;
        r9.getClass();
        p2a.q.a().stopAudio();
        Integer r1 = (Integer) r9.y.getValue();
        if (r1 != null) goto L9;
    L10:
        r9.x.setValue(3);
    L12:
        c("audition", this.d.j());
        v2a.g r10 = v2a.g.a;
        v2a.g.b(this.d.g(), "voice_mix_bar", this.d.j(), this.e);
        return;
    L9:
        if (r1.intValue() != 3) goto L10;
        BuildersKt.launch$default(r9.a, Dispatchers.getIO(), null, new SpeakerVoiceEditModel$requestPreviewAndPlayVoice$1(r9, null), 2, null);
        goto L12
    }

    public final void c(String r9, SpeakerVoice r10) {
        v2a.g r0 = v2a.g.a;
        boolean r2 = Intrinsics.areEqual(this.d.E.getValue(), Boolean.TRUE);
        by7.e r7 = this.e;
        if (r10 == null) goto L5;
        String r3 = r10.getId();
    L6:
        if (r10 == null) goto L8;
        String r6 = r10.getName();
    L9:
        if (r10 == null) goto L11;
        String r5 = r10.getStyleId();
    L12:
        v2a.g.d(r2, r3, r9, r5, r6, r7);
        return;
    L11:
        r5 = null;
        goto L12
    L8:
        r6 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public j0(Context r2, LifecycleOwner r3, LarusTtsSpeakerContentNewStyleBinding r4, SpeakerVoiceEditModel r5) {
        Intrinsics.checkNotNullParameter(r3, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "model");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
