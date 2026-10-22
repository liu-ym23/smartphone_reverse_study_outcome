package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.project.ProjectPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.slash.SlashPanelController;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i1 implements TextWatcher {
    public final /* synthetic */ MultiTypeMentionPanelController a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MultiTypePanelTrigger.values().length];
            r0[MultiTypePanelTrigger.MENTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MultiTypePanelTrigger.SLASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MultiTypePanelTrigger.EXTERNAL_SKILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public i1(MultiTypeMentionPanelController r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.u0] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.t0] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.v0] */
    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r24) {
        i1 r0 = this;
        MultiTypeMentionPanelController r2 = r0.a;
        if (r2.J == false) goto L5;
        return;
    L5:
        r2.m();
        MultiTypeMentionPanelController r3 = r0.a;
        Integer r4 = r3.H;
        MultiTypePanelTrigger r5 = null;
        if (r4 == null) goto L20;
        int r6 = r4.intValue();
        if (r24 != null) goto L10;
    L19:
        r3.H = null;
        goto L20
    L10:
        if (r6 > r24.length()) goto L19;
        int r7 = r3.T.getSelectionStart();
        if (r7 >= r6) goto L15;
    L18:
        r3.H = null;
        goto L20
    L15:
        if (r7 != r3.T.getSelectionEnd()) goto L18;
        k1 r8 = new k1(r6, r7, r24.subSequence(r6, r7).toString(), MultiTypePanelTrigger.EXTERNAL_SKILL);
    L21:
        if (r8 != null) goto L23;
        r8 = r3.j(r24);
    L23:
        MultiTypeMentionPanelController.b r9 = r3.I;
        boolean r10 = false;
        if (r9 == null) goto L59;
        if (r24 == null) goto L45;
        int r11 = r24.length();
        int r12 = r9.a;
        if (r12 < 0) goto L31;
        if (r12 >= r11) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L45;
        char r1 = r24.charAt(r12);
        int r14 = j1.a[r9.b.ordinal()];
        if (r14 == 1) goto L42;
        if (r14 == 2) goto L41;
        if (r14 == 3) goto L40;
        throw new NoWhenBranchMatchedException();
    L40:
        throw new IllegalStateException("External skill query has no token".toString());
    L41:
        char r15 = '/';
    L43:
        if (r1 != r15) goto L45;
        boolean r16 = true;
    L46:
        if (r16 == true) goto L48;
        r3.I = null;
        goto L59
    L48:
        if (r8 != null) goto L50;
    L52:
        boolean r17 = false;
    L53:
        if (r17 == true) goto L55;
    L57:
        if (r8 == null) goto L59;
        r3.I = null;
        goto L59
    L55:
        if (r8.d != r9.b) goto L57;
        r8 = null;
        goto L59
    L50:
        if (r8.a != r9.a) goto L52;
        r17 = true;
        goto L53
    L42:
        r15 = '@';
    L31:
        r13 = false;
    L45:
        r16 = false;
    L59:
        MultiTypeMentionPanelController r18 = r0.a;
        r18.G = r8;
        if (r8 == null) goto L63;
        r5 = r8.d;
    L63:
        if (r5 == MultiTypePanelTrigger.EXTERNAL_SKILL) goto L65;
        r18.o(false);
    L65:
        if (r8 != null) goto L68;
        r0.a.l();
        return;
    L68:
        int r19 = a.a[r8.d.ordinal()];
        if (r19 == 1) goto L92;
        if (r19 == 2) goto L75;
        if (r19 == 3) goto L75;
        throw new NoWhenBranchMatchedException();
    L75:
        ProjectPanelController r20 = r0.a.a0;
        if (r20 == null) goto L83;
        String r21 = r8.c;
        Intrinsics.checkNotNullParameter(r21, "query");
        if (r20.j == true) goto L80;
        boolean r22 = false;
    L81:
        if (r22 != true) goto L83;
        r10 = true;
        goto L83
    L80:
        r20.i = StringsKt.trim(r21).toString();
        r20.e();
        r22 = true;
    L83:
        if (r10 == false) goto L85;
        return;
    L85:
        SlashPanelController r23 = r0.a.i();
        MentionPanelController r25 = r0.a.Y;
        if (r25 == null) goto L88;
        r25.i();
    L88:
        ProjectPanelController r26 = r0.a.a0;
        if (r26 == null) goto L91;
        r26.b();
    L91:
        r0.a.a(r8.d);
        r23.l(r8);
        return;
    L92:
        final MultiTypeMentionPanelController r27 = r0.a;
        MentionPanelController r28 = r27.Y;
        if (r28 != null) goto L99;
        final com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r110 = new com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0(r27.b, new t0(r27));
        r27.V = r110;
        ChatInputWithMentionDelegate r29 = r27.a;
        CoroutineScope r30 = r27.f;
        Fragment r111 = r27.h;
        qp8.e r112 = r27.g;
        Function1<MentionFilePickerType, Unit> r113 = r27.p;
        Function0<be8.a> r114 = r27.o;
        Function0<Boolean> r115 = r27.j;
        MultiTypeMentionPanelController$ensureMentionController$2 r31 = new MultiTypeMentionPanelController$ensureMentionController$2(r27);
        boolean r32 = r27.A;
        Set<MentionPanelContent> r33 = r27.x;
        SkillSearchIndex r34 = r27.C;
        MentionPanelController r35 = new MentionPanelController(r29, r30, r111, r110, r112, r113, r114, r115, r31, r32, r33, new u0(r110, r27), new v0(r27), new MultiTypeMentionPanelController$ensureMentionController$3(r27), r34);
        r27.Y = r35;
        List<d0> r36 = r27.P;
        Intrinsics.checkNotNullParameter(r36, "references");
        r35.o = r36;
        k1 r37 = r35.n;
        if (r37 == null) goto L98;
        r35.p(r37);
    L98:
        r0 = this;
        r28 = r35;
    L99:
        SlashPanelController r38 = r0.a.Z;
        if (r38 == null) goto L102;
        r38.d();
    L102:
        ProjectPanelController r39 = r0.a.a0;
        if (r39 == null) goto L105;
        r39.b();
    L105:
        r0.a.a(MultiTypePanelTrigger.MENTION);
        r28.t(r8);
        return;
    L20:
        r8 = null;
        goto L21
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r5, int r6, int r7, int r8) {
        MultiTypeMentionPanelController r0 = this.a;
        if (r0.J == false) goto L5;
        return;
    L5:
        MultiTypeMentionPanelController.b r1 = r0.I;
        if (r1 == null) goto L13;
        if (r7 <= 0) goto L13;
        int r2 = r1.a;
        if (r6 > r2) goto L13;
        if (r2 >= (r7 + r6)) goto L13;
        r0.I = null;
    L13:
        Integer r9 = r0.H;
        if (r9 == null) goto L42;
        int r10 = r9.intValue();
        boolean r3 = false;
        if (r8 <= 0) goto L38;
        if (r6 != r10) goto L38;
        if (r5 == null) goto L26;
        Character r4 = StringsKt.getOrNull(r5, r10);
        if (r4 == null) goto L26;
        if (r4.charValue() != '@') goto L26;
        boolean r11 = true;
    L27:
        if (r11 == true) goto L37;
        if (r5 == null) goto L35;
        Character r12 = StringsKt.getOrNull(r5, r10);
        if (r12 == null) goto L35;
        if (r12.charValue() != '/') goto L35;
        boolean r13 = true;
    L36:
        if (r13 == false) goto L38;
    L35:
        r13 = false;
    L37:
        r3 = true;
    L26:
        r11 = false;
    L38:
        if (r6 < r10) goto L40;
        if (r3 == true) goto L40;
        return;
    L40:
        this.a.H = null;
        return;
    }
}
