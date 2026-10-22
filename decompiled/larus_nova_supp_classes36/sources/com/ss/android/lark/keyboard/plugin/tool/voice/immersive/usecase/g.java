package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceCircleButton;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ ImmersiveVoiceViewModel a;
    public final /* synthetic */ VoiceActionAreaUseCase b;

    public g(ImmersiveVoiceViewModel r1, VoiceActionAreaUseCase r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void onChanged(Object r18) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l r1 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l) r18;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l r2 = r1.c();
        StringBuilder r3 = new StringBuilder("current state:");
        r3.append(r1.getString());
        r3.append(" last state:");
        if (r2 == null) goto L5;
        int r4 = r2.getState();
    L6:
        r3.append(r1.a(r4));
        Log.i("VoiceActionAreaUseCase", r3.toString());
        KeyboardVoiceFGUtils r5 = KeyboardVoiceFGUtils.a;
        boolean r6 = KeyboardVoiceFGUtils.b();
        int r7 = r1.getState();
        int r8 = 8;
        int r9 = 4;
        if (r7 == 0) goto L93;
        if (r7 == 1) goto L68;
        if (r7 == 2) goto L53;
        if (r7 == 3) goto L42;
        if (r7 != 4) goto L14;
        this.b.b.d().c();
        if (r2 != null) goto L36;
    L38:
        boolean r10 = false;
    L39:
        if (r10 == false) goto L41;
        this.b.b.q().b(true);
    L41:
        this.b.b.p().setState(true);
        return;
    L36:
        if (r2.getState() != 3) goto L38;
        r10 = true;
        goto L39
    L14:
        if (r7 == 5) goto L17;
        return;
    L17:
        if (this.a.isSecondVoiceInput() == false) goto L20;
        VoiceActionAreaUseCase.c(this.b);
        return;
    L20:
        if (this.a.getImmersiveVoiceMode().b() == false) goto L31;
        VoiceActionAreaUseCase r11 = this.b;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r12 = r11.b;
        r12.c().setVisibility(0);
        ConstraintLayout r13 = r12.g();
        if (r11.g() == false) goto L24;
        r8 = 0;
    L24:
        r13.setVisibility(r8);
        r12.j().setVisibility(0);
        if (r11.e().isVoiceSecondInputV2() == false) goto L27;
        r12.k().setVisibility(0);
    L27:
        VoiceActionAreaUseCase r14 = this.b;
        r14.getClass();
        if (KeyboardVoiceFGUtils.b() == false) goto L32;
        ConstraintSet r15 = new ConstraintSet();
        r15.clone(r14.a);
        r15.clear(2131365121, 1);
        r15.clear(2131365121, 2);
        r15.clear(2131365121, 4);
        r15.clear(2131365131, 3);
        r15.connect(2131365121, 4, 2131385901, 3);
        r15.setMargin(2131365121, 4, UIUtils.dp2px(r14.c, 40.0f));
        r15.setHorizontalBias(2131365121, 0.5f);
        r15.createHorizontalChain(0, 1, 0, 2, new int[]{2131365121, 2131385903}, new float[]{1.0f, 1.0f}, 2);
        r15.clear(2131385903, 6);
        r15.clear(2131385903, 7);
        r15.setMargin(2131385903, 6, UIUtils.dp2px(r14.c, 75.0f));
        r15.clear(2131385901, 1);
        r15.clear(2131385901, 2);
        r15.clear(2131385901, 3);
        r15.clear(2131385901, 4);
        r15.connect(2131385901, 6, 0, 6);
        r15.connect(2131385901, 7, 0, 7);
        r15.connect(2131385901, 4, 0, 4);
        r15.setMargin(2131385901, 4, UIUtils.dp2px(r14.c, 35.0f));
        r15.applyTo(r14.a);
    L32:
        this.b.b.d().setVisibility(4);
        this.b.b.q().setVisibility(4);
        this.b.b.p().setVisibility(4);
        return;
    L31:
        this.b.h(true);
        goto L32
    L42:
        if (r2 != null) goto L44;
    L46:
        boolean r16 = false;
    L47:
        if (r16 == false) goto L49;
        this.b.b.d().b(true);
    L49:
        this.b.b.q().c();
        this.b.e().switch2VoiceAsr();
        if (this.a.getImmersiveVoiceMode().b() == false) goto L52;
        this.b.b.p().setState(false);
        return;
    L52:
        this.b.b.p().setState(true);
        return;
    L44:
        if (r2.getState() != 4) goto L46;
        r16 = true;
        goto L47
    L53:
        if (r2 == null) goto L55;
        Integer r17 = Integer.valueOf(r2.getState());
    L56:
        if (r17 != null) goto L59;
    L61:
        if (r17 != null) goto L64;
    L66:
        this.b.h(false);
        this.b.b.p().setVisibility(0);
        this.b.b.p().setState(false);
        this.b.e().switch2VoiceRecordIfNeed();
        return;
    L64:
        if (r17.intValue() != 3) goto L66;
        this.b.b.q().b(true);
        goto L66
    L59:
        if (r17.intValue() != 4) goto L61;
        this.b.b.d().b(true);
        goto L66
    L55:
        r17 = null;
        goto L56
    L68:
        if (this.a.getImmersiveVoiceMode().c() == false) goto L81;
        if (this.a.getImmersiveVoiceMode().b != VoiceInputScene.SecretChat) goto L72;
        boolean r19 = true;
    L73:
        if (r19 == false) goto L75;
        this.b.b.d().setVisibility(8);
    L79:
        this.b.b.q().setVisibility(4);
    L86:
        boolean r20 = false;
    L92:
        this.b.h(r20);
        return;
    L75:
        VoiceCircleButton r21 = this.b.b.d();
        if ((!r6) == false) goto L78;
        r8 = 0;
    L78:
        r21.setVisibility(r8);
        goto L79
    L72:
        r19 = false;
        goto L73
    L81:
        if (this.a.getImmersiveVoiceMode().b() == false) goto L87;
        VoiceCircleButton r22 = this.b.b.d();
        if ((!r6) == false) goto L85;
        r8 = 0;
    L85:
        r22.setVisibility(r8);
        this.b.b.q().setVisibility(4);
        goto L86
    L87:
        r20 = false;
        this.b.b.d().setVisibility(0);
        VoiceCircleButton r23 = this.b.b.q();
        if (r6 == true) goto L91;
        r9 = 0;
    L91:
        r23.setVisibility(r9);
        goto L92
    L93:
        Log.i("VoiceActionAreaUseCase", "STATE_IDLE");
        VoiceActionAreaUseCase r24 = this.b;
        r24.e = false;
        r24.f = false;
        r24.g = false;
        r24.h(false);
        if (this.a.getImmersiveVoiceMode().c() == false) goto L107;
        if (this.a.getImmersiveVoiceMode().b != VoiceInputScene.SecretChat) goto L98;
        boolean r25 = true;
    L99:
        if (r25 == false) goto L101;
        this.b.b.d().setVisibility(8);
    L105:
        this.b.b.q().setVisibility(4);
        ?? r26 = 0;
    L116:
        this.b.b.p().setState(r26);
        this.b.b.p().setVisibility(r26);
        return;
    L101:
        VoiceCircleButton r27 = this.b.b.d();
        if ((!r6) == false) goto L104;
        r8 = 0;
    L104:
        r27.setVisibility(r8);
        goto L105
    L98:
        r25 = false;
        goto L99
    L107:
        if (this.a.getImmersiveVoiceMode().b() == false) goto L112;
        VoiceCircleButton r28 = this.b.b.d();
        if ((!r6) == false) goto L111;
        r8 = 0;
    L111:
        r28.setVisibility(r8);
        r26 = 0;
        r28.b(false);
        this.b.b.q().setVisibility(4);
        goto L116
    L112:
        r26 = 0;
        r26 = 0;
        VoiceCircleButton r29 = this.b.b.d();
        r29.setVisibility(0);
        r29.b(false);
        VoiceCircleButton r30 = this.b.b.q();
        if (r6 == false) goto L115;
        r30.setVisibility(4);
        goto L116
    L115:
        r30.setVisibility(0);
        r30.b(false);
        goto L116
    L5:
        r4 = -1;
        goto L6
    }
}
