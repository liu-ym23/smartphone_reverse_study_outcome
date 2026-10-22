package com.larus.bmhome.view.actionbar.edit.component;

import com.larus.bmhome.chat.ChatParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$6 extends FunctionReferenceImpl implements Function3<com.larus.bmhome.actionbar.model.j, Integer, String, Unit> {
    public CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$6(Object r8) {
        super(3, r8, CollaboratedMultiFeatureSelectorWidget.class, "reportDurationOptionClick", "reportDurationOptionClick(Lcom/larus/bmhome/actionbar/model/ActionBarDurationSeekBarSelector;Ljava/lang/Integer;Ljava/lang/String;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    public final void invoke(com.larus.bmhome.actionbar.model.j r44, Integer r45, String r46) {
        Intrinsics.checkNotNullParameter(r44, "p0");
        Intrinsics.checkNotNullParameter(r46, "p2");
        CollaboratedMultiFeatureSelectorWidget r3 = (CollaboratedMultiFeatureSelectorWidget) ((CallableReference) this).receiver;
        t1 r4 = CollaboratedMultiFeatureSelectorWidget.o;
        String r5 = r3.V6();
        com.larus.bmhome.view.actionbar.edit.c r6 = r3.getViewModel();
        if (r6 == null) goto L7;
        ChatParam r7 = r6.getChatParam();
        if (r7 == null) goto L7;
        String r8 = r7.b;
    L8:
        com.larus.bmhome.view.actionbar.edit.c r9 = r3.getViewModel();
        if (r9 == null) goto L13;
        ChatParam r10 = r9.getChatParam();
        if (r10 == null) goto L13;
        String r11 = r10.e;
    L14:
        com.larus.bmhome.view.actionbar.edit.c r12 = r3.getViewModel();
        if (r12 == null) goto L17;
        String r13 = r12.getTemplateType();
    L18:
        com.larus.bmhome.view.actionbar.edit.c r14 = r3.getViewModel();
        if (r14 == null) goto L21;
        String r15 = r14.getActionBarType();
    L22:
        com.larus.bmhome.view.actionbar.edit.c r16 = r3.getViewModel();
        if (r16 == null) goto L27;
        com.larus.bmhome.actionbar.model.z0 r17 = r16.getCurrentCustomActionBarItem();
        if (r17 == null) goto L27;
        String r18 = r17.b;
    L28:
        com.larus.bmhome.actionbar.model.u r19 = r3.getInstructionItem();
        if (r19 == null) goto L31;
        String r110 = r19.c;
    L32:
        int r111 = c.a;
        Intrinsics.checkNotNullParameter(r44, "duration");
        String r112 = r44.c;
        if (r112 != null) goto L35;
    L37:
        String r113 = null;
    L38:
        Intrinsics.checkNotNullParameter(r44, "duration");
        String r114 = r44.a(r45);
        if (r45 == null) goto L41;
        String r26 = r45.toString();
    L42:
        Intrinsics.checkNotNullParameter(r44, "duration");
        Boolean r115 = r44.j;
        Boolean r116 = Boolean.TRUE;
        if (Intrinsics.areEqual(r115, r116) == false) goto L45;
        ?? r117 = 0;
    L46:
        int r20 = !Intrinsics.areEqual(r44.j, r116) ? 1 : 0;
        Integer r0 = c.b(r44, r45);
        JSONObject r1 = c.f(r5);
        com.larus.bmhome.view.actionbar.edit.c r21 = r3.getViewModel();
        if (r21 == null) goto L51;
        ChatParam r22 = r21.getChatParam();
        if (r22 == null) goto L51;
        String r27 = r22.c;
    L52:
        com.larus.bmhome.view.actionbar.edit.c r23 = r3.getViewModel();
        if (r23 == null) goto L55;
        Boolean r42 = r23.isCreationActionBar();
    L56:
        tx9.b.e(r8, r11, r13, r15, r18, r110, r113, r114, r26, Integer.valueOf(r117), Integer.valueOf(r20), r0, r46, null, null, null, r1, "original", "chat", null, null, null, "chat", r27, r42, "slide", null, null, null, null, null, null, null, null, null, null, null, -126689280, 127);
        return;
    L55:
        r42 = null;
    L51:
        r27 = null;
        goto L52
    L45:
        r117 = Intrinsics.areEqual(r44.h, r45);
        goto L46
    L41:
        r26 = null;
        goto L42
    L35:
        if ((!StringsKt.isBlank(r112)) == false) goto L37;
        r113 = r112;
        goto L38
    L31:
        r110 = null;
    L27:
        r18 = null;
        goto L28
    L21:
        r15 = null;
        goto L22
    L17:
        r13 = null;
    L13:
        r11 = null;
    L7:
        r8 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((com.larus.bmhome.actionbar.model.j) r1, (Integer) r2, (String) r3);
        return Unit.INSTANCE;
    }
}
