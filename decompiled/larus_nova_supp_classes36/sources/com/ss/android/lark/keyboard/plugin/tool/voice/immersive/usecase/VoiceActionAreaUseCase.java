package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.keyboard.edittext2.span.ClickLinkMovementMethod;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.VoiceTextSetting;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.CircleIconWithTitle;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceActionAreaUseCase {
    public final ConstraintLayout a;
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a b;
    public final Context c;
    public final Lazy d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public ImmersiveVoiceInputComponent.b i;
    public final long j;
    public final long k;

    public static final class a {
    }

    static {
    }

    public final ImmersiveVoiceViewModel e() {
        return (ImmersiveVoiceViewModel) this.d.getValue();
    }

    public final void f() {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r0 = this.b;
        r0.j().setVisibility(4);
        r0.k().setVisibility(4);
        r0.g().setVisibility(4);
        r0.c().setVisibility(4);
    }

    public final boolean g() {
        VoiceInputScene r0 = e().getImmersiveVoiceMode().b;
        if (r0 != VoiceInputScene.EnterpriseAnswer) goto L5;
    L10:
        boolean r1 = true;
    L12:
        return !r1;
    L5:
        if (r0 == VoiceInputScene.UniverseSearch) goto L10;
        if (r0 == VoiceInputScene.CcmComment) goto L10;
        r1 = false;
        goto L12
    }

    public static final void a(VoiceActionAreaUseCase r4) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r0 = r4.b;
        ConstraintLayout r1 = r0.g();
        if (r4.g() == false) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        r0.a().setEnabled(true);
        r0.n().setVisibility(4);
        r0.k().setVisibility(4);
        r0.p().setVisibility(4);
        r0.c().setVisibility(0);
        r0.j().setVisibility(0);
        r0.e().setVisibility(4);
        CircleIconWithTitle.S5(r0.j());
        r0.j().animate().scaleX(1.0f).scaleY(1.0f).setDuration(r4.k).start();
        r4.e().stopVoiceRecord();
        r4.e().whenReleaseOrCancelTouch();
        r4.h = false;
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public static final void c(VoiceActionAreaUseCase r4) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r0 = r4.b;
        ((View) r0.A.getValue()).animate().scaleX(0.9f).setDuration(150).withEndAction(new j(r0, r4)).start();
    }

    public final void h(boolean r5) {
        if (r5 == false) goto L5;
        int r6 = 0;
    L6:
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r1 = this.b;
        r1.c().setVisibility(r6);
        ConstraintLayout r2 = r1.g();
        if (g() == false) goto L9;
        int r3 = r6;
    L10:
        r2.setVisibility(r3);
        r1.j().setVisibility(r6);
        if (e().isVoiceSecondInputV2() == false) goto L18;
        Object r4 = e().isPanelShowing().getValue();
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r4, r7) == true) goto L18;
        if (Intrinsics.areEqual(e().isKeyboardShowing().getValue(), r7) == true) goto L18;
        r1.k().setVisibility(r6);
        return;
    L18:
        r1.k().setVisibility(4);
        return;
    L9:
        r3 = 8;
        goto L10
    L5:
        r6 = 4;
        goto L6
    }

    public static final void b(VoiceActionAreaUseCase r2, int r3) {
        Context r4 = r2.a.getContext();
        Intrinsics.checkNotNullParameter(r4, "context");
        FlowToast.a r0 = FlowToast.a(r4);
        r0.e(r3);
        r0.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r4, 2131256189));
        r0.c(17, 0, 0);
        r0.a().show();
    }

    public static final void d(VoiceActionAreaUseCase r1, boolean r2) {
        r1.b.j().T5(r2);
        if (r1.e().isVoiceSecondInputV2() == false) goto L10;
        if (r2 == true) goto L6;
    L8:
        r1.b.k().setVisibility(4);
        return;
    L6:
        if (Intrinsics.areEqual(r1.e().isKeyboardShowing().getValue(), Boolean.TRUE) == true) goto L8;
        r1.b.k().setVisibility(0);
        return;
    }

    public VoiceActionAreaUseCase(ConstraintLayout r8, Fragment r9, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r10) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Intrinsics.checkNotNullParameter(r10, "viewFinder");
        this.a = r8;
        this.b = r10;
        Context r0 = r8.getContext();
        this.c = r0;
        this.d = LazyKt.lazy(new VoiceActionAreaUseCase$immersiveVoiceViewModel$2(this));
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(r8);
        if (e().getImmersiveVoiceMode().c() == false) goto L5;
    L8:
        r1.clear(2131388764, 6);
        r1.clear(2131388764, 7);
        r1.connect(2131388764, 6, 0, 6);
        r1.connect(2131388764, 7, 0, 7);
        r1.setMargin(2131388764, 6, y9c.d.b(r0, 16.0f));
        r1.setMargin(2131388764, 7, y9c.d.b(r0, 16.0f));
    L9:
        r1.applyTo(r8);
        r10.d().setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.a(this));
        r10.c().setOnClickListener(new b(this, r10));
        r10.g().setOnClickListener(new c(this, r10));
        VoiceTextSetting r11 = (VoiceTextSetting) SettingManager.getInstance().get(VoiceTextSetting.class);
        r10.e().setText(r11.voicePageSecondVoiceButtonText);
        r10.k().setText(r11.voicePageSecondVoiceSendAllBtnText);
        if (e().isVoiceSecondInputV2() == false) goto L12;
        r10.j().setOnTouchListener(new VoiceActionAreaUseCase$buildSendAllResultLongPressTouchListener$1(this));
    L12:
        r10.e().setOnTouchListener(new d(this));
        r10.j().setOnClickListener(new e(r10, this));
        r10.a().addTextChangedListener(new i(this, r10));
        r10.a().setMovementMethod(new ClickLinkMovementMethod(r10.a()));
        if (r9 != null) goto L16;
        Activity r12 = ContextsKt.findActivity(r0);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r9 = (LifecycleOwner) r12;
    L16:
        ImmersiveVoiceViewModel r13 = e();
        r13.getVoiceRecordTooShort().observe(r9, new f(this));
        r13.getImmersiveVoiceState().observe(r9, new g(r13, this));
        r13.getAsrSessionState().observe(r9, new h(this, r13, r9));
        this.j = 300;
        this.k = 180;
        return;
    L5:
        if (e().getImmersiveVoiceMode().b() == true) goto L8;
        r1.clear(2131388764, 6);
        r1.clear(2131388764, 7);
        r1.connect(2131388764, 6, 2131365131, 7);
        r1.connect(2131388764, 7, 2131383922, 6);
        r1.setMargin(2131388764, 6, 0);
        r1.setMargin(2131388764, 7, 0);
        goto L9
    }
}
