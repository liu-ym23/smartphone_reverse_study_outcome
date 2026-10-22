package com.larus.bmhome.chat.component.bottom.core;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import bc8.a;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.obric.assistant.common.spi.IObricFeatureService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i7 implements TextWatcher {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ LarusWidgetInputBinding d;
    public final /* synthetic */ Ref.ObjectRef e;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r9) {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        if (r0.k4().S(new m7(r9)) == true) goto L170;
        boolean r2 = false;
        if (this.a.F4().getCurrentInputStatus() != 4) goto L8;
        this.a.k4().v0();
    L17:
        if (this.a.s5().c == false) goto L30;
        a r3 = s1a.d.a(this.a).getAbility(a.class);
        if (r3 == null) goto L30;
        CoreInputComponent r4 = this.a;
        if (r4.s5().c == true) goto L23;
    L28:
        boolean r5 = false;
    L29:
        r3.nv(r5);
        goto L30
    L23:
        if (r4.u7().length() <= 0) goto L25;
        boolean r6 = true;
    L26:
        if (r6 == false) goto L28;
        r5 = true;
        goto L29
    L25:
        r6 = false;
    L30:
        com.larus.bmhome.instruction.g r7 = this.a.vc();
        if (r7 != null) goto L33;
    L35:
        boolean r8 = false;
    L36:
        if (r8 == false) goto L51;
        CoreInputComponent r10 = this.a;
        if (r9 != null) goto L40;
    L43:
        boolean r11 = true;
    L44:
        if (r11 == true) goto L46;
    L49:
        boolean r12 = true;
    L50:
        r10.lh(r12);
        goto L51
    L46:
        if (this.a.k4().b0() == true) goto L49;
        r12 = false;
        goto L50
    L40:
        if (r9.length() == 0) goto L43;
        r11 = false;
    L51:
        if (r9 != null) goto L53;
    L56:
        boolean r13 = true;
    L57:
        float r14 = 1.0f;
        Boolean r15 = null;
        if (r13 == false) goto L74;
        CoreInputComponent r16 = this.a;
        r16.bm(r16.F4().inputTextHint().toString());
        this.a.xP();
        CoreInputComponent r17 = this.a;
        com.larus.bmhome.instruction.g r18 = r17.vc();
        if (r18 == null) goto L62;
        boolean r19 = r18.z0();
    L65:
        Boolean r20 = Boolean.valueOf(r19);
    L68:
        if (Intrinsics.areEqual(r20, Boolean.TRUE) == true) goto L70;
    L72:
        r14 = 0.3f;
    L73:
        r17.Y4(r14);
    L78:
        int r21 = this.a.F4().getCurrentInputStatus();
        if (r21 != 4) goto L93;
        com.larus.bmhome.instruction.g r22 = this.a.vc();
        if (r22 == null) goto L83;
        int r23 = r22.Q1();
    L86:
        Integer r24 = Integer.valueOf(r23);
    L88:
        if (r24 == null) goto L93;
        if (r24.intValue() != 4) goto L93;
        boolean r25 = true;
    L95:
        if (this.b.getVisibility() != 0) goto L97;
        boolean r26 = true;
    L98:
        if (r26 == false) goto L150;
        if (r21 != 4) goto L101;
        if (r25 == false) goto L150;
    L101:
        if (r9 == null) goto L103;
        String r27 = r9.toString();
    L104:
        if (r27 != null) goto L106;
    L109:
        boolean r28 = true;
    L110:
        if (r28 == true) goto L112;
    L115:
        int r29 = 3;
    L116:
        IObricFeatureService r30 = (IObricFeatureService) ServiceManager.get().getService(IObricFeatureService.class);
        if (r30 != null) goto L119;
    L121:
        boolean r31 = false;
    L122:
        if (r31 == false) goto L133;
        maa.e r32 = (maa.e) this.a.S.getValue();
        if (r32 != null) goto L126;
    L128:
        boolean r33 = false;
    L129:
        if (r33 == false) goto L133;
        if (r29 != 1) goto L133;
        if (r21 != 1) goto L133;
        boolean r34 = true;
    L134:
        if (r34 == true) goto L136;
        this.a.k4().g2(r29, true);
    L136:
        CoreInputAbility r35 = this.a.k4();
        String r36 = StringsKt.trim(this.a.u7()).toString();
        r35.getClass();
        Intrinsics.checkNotNullParameter(r36, ChatDraftItem.TYPE_TEXT);
        r35.p.invoke(r36);
        if (String.valueOf(r9).length() != 0) goto L139;
        boolean r37 = true;
    L140:
        if (r37 == false) goto L150;
        if (r29 != 1) goto L150;
        com.larus.bmhome.utils.x1 r38 = this.a.H1;
        if (r38 != null) goto L145;
    L147:
        boolean r39 = false;
    L148:
        if (r39 == false) goto L150;
        this.a.ra();
        goto L150
    L145:
        if (r38.b() == true) goto L147;
        r39 = true;
        goto L148
    L139:
        r37 = false;
        goto L140
    L126:
        if (r32.x3() != true) goto L128;
        r33 = true;
    L133:
        r34 = false;
        goto L134
    L119:
        if (r30.a() != true) goto L121;
        r31 = true;
        goto L122
    L112:
        if (this.a.k4().k5() == true) goto L115;
        r29 = 1;
        goto L116
    L106:
        if (StringsKt.isBlank(r27) == true) goto L109;
        r28 = false;
        goto L110
    L103:
        r27 = null;
    L150:
        EditText r40 = this.b;
        if (this.a.n5() == false) goto L153;
    L157:
        View.OnTouchListener r41 = null;
    L158:
        r40.setOnTouchListener(r41);
        com.larus.bmhome.instruction.g r42 = this.a.vc();
        if (r42 == null) goto L161;
        boolean r43 = r42.z0();
    L164:
        r15 = Boolean.valueOf(r43);
    L166:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L169;
        this.b.addOnLayoutChangeListener(new o7(this.a));
        return;
    L169:
        return;
    L161:
        ys8.a r44 = this.a.DC();
        if (r44 == null) goto L166;
        r43 = r44.z0();
        goto L164
    L153:
        if (this.a.u7().length() != 0) goto L155;
        r2 = true;
    L155:
        if (r2 == false) goto L157;
        r41 = this.a.f5();
        goto L158
    L97:
        r26 = false;
        goto L98
    L83:
        ys8.a r45 = this.a.DC();
        if (r45 == null) goto L87;
        r23 = r45.Q1();
        goto L86
    L87:
        r24 = null;
    L93:
        r25 = false;
        goto L95
    L70:
        if (this.a.F4().getCurrentInputStatus() != 4) goto L72;
    L62:
        ys8.a r46 = this.a.DC();
        if (r46 == null) goto L66;
        r19 = r46.z0();
        goto L65
    L66:
        r20 = null;
        goto L68
    L74:
        EditText r47 = this.b;
        r47.post(new n7(r47, this.a));
        com.larus.bmhome.chat.component.bottom.reference.a r48 = this.a.g5();
        if (r48 == null) goto L77;
        r48.mE();
    L77:
        this.a.Y4(1.0f);
        goto L78
    L53:
        if (r9.length() == 0) goto L56;
        r13 = false;
        goto L57
    L33:
        if (r7.HM() != true) goto L35;
        r8 = true;
        goto L36
    L8:
        CoreInputAbility r49 = this.a.k4();
        if (this.a.Z3(r9) == false) goto L11;
    L14:
        boolean r50 = true;
    L15:
        r49.Dr(r50);
        goto L17
    L11:
        if (this.a.J8() == true) goto L14;
        r50 = false;
        goto L15
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CoreInputComponent r5 = this.a;
        int r6 = CoreInputComponent.d3;
        if (r5.k4().S(new j7(r1)) == true) goto L10;
        com.larus.bmhome.chat.component.bottom.reference.a r7 = this.a.g5();
        if (r7 == null) goto L9;
        r7.mE();
        return;
    L9:
        return;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        CoreInputComponent r6 = this.a;
        int r7 = CoreInputComponent.d3;
        if (r6.k4().S(new k7(r2)) == true) goto L16;
        CoreInputComponent r8 = this.a;
        EditText r9 = this.c;
        final l7 r10 = new l7(r8, r9, this.d, this.e);
        com.larus.bmhome.chat.component.bottom.voice.a r11 = r8.Zd();
        if (r11 == null) goto L10;
        boolean r12 = true;
        if (r11.q40() != true) goto L10;
    L11:
        if (r12 == false) goto L13;
        r9.post(new w6(r10));
        return;
    L13:
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "onChange");
        r9.addOnLayoutChangeListener(new v19.i7(r9, r10));
        return;
    L10:
        r12 = false;
        goto L11
    }

    public i7(CoreInputComponent r1, EditText r2, EditText r3, LarusWidgetInputBinding r4, Ref.ObjectRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
