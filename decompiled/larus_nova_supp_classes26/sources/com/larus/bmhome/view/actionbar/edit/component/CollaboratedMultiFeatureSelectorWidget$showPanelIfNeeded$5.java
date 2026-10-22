package com.larus.bmhome.view.actionbar.edit.component;

import com.larus.bmhome.chat.ChatParam;
import java.util.Set;
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
public /* synthetic */ class CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$5 extends FunctionReferenceImpl implements Function3<com.larus.bmhome.actionbar.model.j, Integer, Set<String>, Unit> {
    public CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$5(Object r8) {
        super(3, r8, CollaboratedMultiFeatureSelectorWidget.class, "reportDurationOptionShow", "reportDurationOptionShow(Lcom/larus/bmhome/actionbar/model/ActionBarDurationSeekBarSelector;Ljava/lang/Integer;Ljava/util/Set;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final void invoke(com.larus.bmhome.actionbar.model.j r34, Integer r35, Set<String> r36) {
        Intrinsics.checkNotNullParameter(r34, "p0");
        Intrinsics.checkNotNullParameter(r36, "p2");
        CollaboratedMultiFeatureSelectorWidget r4 = (CollaboratedMultiFeatureSelectorWidget) ((CallableReference) this).receiver;
        t1 r5 = CollaboratedMultiFeatureSelectorWidget.o;
        String r6 = r4.V6();
        int r7 = c.a;
        Intrinsics.checkNotNullParameter(r34, "duration");
        String r8 = r34.c;
        if (r8 != null) goto L5;
    L7:
        r8 = null;
    L8:
        if (r35 == null) goto L10;
        String r9 = r35.toString();
    L11:
        Integer r15 = c.b(r34, r35);
        if (r36.add(r6 + '|' + r8 + '|' + r9 + '|' + r15) == false) goto L60;
        com.larus.bmhome.view.actionbar.edit.c r2 = r4.getViewModel();
        if (r2 == null) goto L19;
        ChatParam r3 = r2.getChatParam();
        if (r3 == null) goto L19;
        String r10 = r3.b;
    L20:
        com.larus.bmhome.view.actionbar.edit.c r11 = r4.getViewModel();
        if (r11 == null) goto L25;
        ChatParam r12 = r11.getChatParam();
        if (r12 == null) goto L25;
        String r13 = r12.e;
    L26:
        com.larus.bmhome.view.actionbar.edit.c r14 = r4.getViewModel();
        if (r14 == null) goto L29;
        String r16 = r14.getTemplateType();
    L30:
        com.larus.bmhome.view.actionbar.edit.c r17 = r4.getViewModel();
        if (r17 == null) goto L33;
        String r18 = r17.getActionBarType();
    L34:
        com.larus.bmhome.view.actionbar.edit.c r19 = r4.getViewModel();
        if (r19 == null) goto L39;
        com.larus.bmhome.actionbar.model.z0 r20 = r19.getCurrentCustomActionBarItem();
        if (r20 == null) goto L39;
        String r110 = r20.b;
    L40:
        com.larus.bmhome.actionbar.model.u r21 = r4.getInstructionItem();
        if (r21 == null) goto L43;
        String r22 = r21.c;
    L44:
        Intrinsics.checkNotNullParameter(r34, "duration");
        String r111 = r34.a(r35);
        Intrinsics.checkNotNullParameter(r34, "duration");
        Boolean r23 = r34.j;
        Boolean r24 = Boolean.TRUE;
        if (Intrinsics.areEqual(r23, r24) == false) goto L47;
        ?? r1 = 0;
    L48:
        int r0 = !Intrinsics.areEqual(r34.j, r24) ? 1 : 0;
        JSONObject r25 = c.f(r6);
        com.larus.bmhome.view.actionbar.edit.c r26 = r4.getViewModel();
        if (r26 == null) goto L53;
        ChatParam r27 = r26.getChatParam();
        if (r27 == null) goto L53;
        String r30 = r27.c;
    L54:
        com.larus.bmhome.view.actionbar.edit.c r28 = r4.getViewModel();
        if (r28 == null) goto L57;
        Boolean r31 = r28.isCreationActionBar();
    L58:
        tx9.b.f(r10, r13, r16, r18, r110, r22, r8, r111, r9, Integer.valueOf(r1), Integer.valueOf(r0), r15, null, null, r25, "chat", null, null, null, "chat", r30, r31, 962560);
        return;
    L57:
        r31 = null;
    L53:
        r30 = null;
        goto L54
    L47:
        r1 = Intrinsics.areEqual(r34.h, r35);
        goto L48
    L43:
        r22 = null;
    L39:
        r110 = null;
        goto L40
    L33:
        r18 = null;
        goto L34
    L29:
        r16 = null;
    L25:
        r13 = null;
    L19:
        r10 = null;
        goto L20
    L60:
        return;
    L10:
        r9 = null;
        goto L11
    L5:
        if ((!StringsKt.isBlank(r8)) == false) goto L7;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((com.larus.bmhome.actionbar.model.j) r1, (Integer) r2, (Set) r3);
        return Unit.INSTANCE;
    }
}
