package com.ss.android.lark.compose.chatsetting.main.ui.sections.exit;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.platform.b;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.StandardSettingRowKt;
import com.ss.android.lark.compose.chatsetting.main.viewmodel.a;
import com.ss.android.lark.compose.foundation.dialog.FlowAlertDialogKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.c;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExitGroupRowKt {
    public static final void a(final a r27, final Function2<? super String, ? super String, Unit> r28, final Function0<Unit> r29, final b r30, Composer r31, final int r32) {
        Intrinsics.checkNotNullParameter(r27, "uiState");
        Intrinsics.checkNotNullParameter(r28, "routerToQuit");
        Intrinsics.checkNotNullParameter(r29, "exitGroup");
        Intrinsics.checkNotNullParameter(r30, "platformEffects");
        Composer r15 = r31.startRestartGroup(1209662119);
        if ((r32 & 6) == 0) goto L5;
        int r6 = r32;
    L11:
        if ((r32 & 48) != 0) goto L18;
        if (r15.changedInstance(r28) == false) goto L15;
        int r9 = 32;
    L16:
        r6 = r6 | r9;
        goto L18
    L15:
        r9 = 16;
    L18:
        if ((r32 & 384) != 0) goto L25;
        if (r15.changedInstance(r29) == false) goto L22;
        int r10 = 256;
    L23:
        r6 = r6 | r10;
        goto L25
    L22:
        r10 = 128;
    L25:
        if ((r32 & 3072) == 0) goto L27;
    L34:
        int r13 = r6;
        if ((r13 & 1171) != 1170) goto L41;
        if (r15.getSkipping() == false) goto L41;
        r15.skipToGroupEnd();
        Composer r0 = r15;
    L113:
        ScopeUpdateScope r7 = r0.endRestartGroup();
        if (r7 == null) goto L117;
        r7.updateScope(new ExitGroupRowKt$ExitGroupRow$2(r27, r28, r29, r30, r32));
        return;
    L117:
        return;
    L41:
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventStart(1209662119, r13, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.exit.ExitGroupRow (ExitGroupRow.kt:34)");
    L43:
        Modifier.Companion r1 = Modifier.Companion;
        MeasurePolicy r8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r11 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r12 = r15.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r15, r1);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r18 = r17.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L46;
        ComposablesKt.invalidApplier();
    L46:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L49;
        r15.createNode(r18);
    L50:
        Composer r19 = Updater.constructor-impl(r15);
        Updater.set-impl(r19, r8, r17.getSetMeasurePolicy());
        Updater.set-impl(r19, r12, r17.getSetResolvedCompositionLocals());
        Function2 r20 = r17.getSetCompositeKeyHash();
        if (r19.getInserting() == false) goto L53;
    L54:
        r19.updateRememberedValue(Integer.valueOf(r11));
        r19.apply(Integer.valueOf(r11), r20);
    L55:
        Updater.set-impl(r19, r14, r17.getSetModifier());
        BoxScopeInstance r21 = BoxScopeInstance.INSTANCE;
        r15.startReplaceGroup(1849434622);
        Object r22 = r15.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r22 != r110.getEmpty()) goto L58;
        r22 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r15.updateRememberedValue(r22);
    L58:
        final MutableState r111 = (MutableState) r22;
        r15.endReplaceGroup();
        r15.startReplaceGroup(-1224400529);
        boolean r25 = true;
        if ((r13 & 14) != 4) goto L61;
        boolean r23 = true;
    L63:
        if ((r13 & 112) != 32) goto L65;
        boolean r24 = true;
    L66:
        boolean r26 = r23 | r24;
        if ((r13 & 7168) != 2048) goto L69;
    L74:
        boolean r33 = true;
    L75:
        boolean r34 = r26 | r33;
        Object r35 = r15.rememberedValue();
        if (r34 == false) goto L78;
    L79:
        r35 = new ExitGroupRowKt$ExitGroupRow$1$1$1(r27, r28, r30, r111);
        r15.updateRememberedValue(r35);
    L80:
        r15.endReplaceGroup();
        Modifier r36 = ClickableKt.clickable-oSLSa3U$default(r1, false, null, null, null, (Function0) r35, 15, null);
        com.ss.android.lark.flow.chat.resources.b r2 = com.ss.android.lark.flow.chat.resources.b.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Lazy r112 = CommonMainString0.R;
        StandardSettingRowKt.a(r36, b0.a((z) r112.getValue(), r15), new com.ss.android.lark.compose.chatsetting.common.ui.widget.a((ImageVector) ChatSettingIcons.h.getValue(), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294611088L)), Color.box-impl(ColorKt.Color(4294521651L))}), 0.0f, 0.0f, 0, 14, null)), null, false, r15, 24576, 8);
        r15.startReplaceGroup(-315125129);
        if (((Boolean) r111.getValue()).booleanValue() == false) goto L109;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r37 = b0.a((z) CommonMainString0.P1.getValue(), r15);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r38 = b0.a((z) CommonMainString0.m2.getValue(), r15);
        String r39 = r27.c;
        boolean r113 = r27.f;
        r15.startReplaceGroup(-1224400529);
        boolean r40 = ((r15.changed(r39) | r15.changed(r113)) | r15.changed(r37)) | r15.changed(r38);
        Object r114 = r15.rememberedValue();
        if (r40 == true) goto L87;
        if (r114 == r110.getEmpty()) goto L87;
    L91:
        String r41 = (String) r114;
        r15.endReplaceGroup();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r42 = b0.a((z) r112.getValue(), r15);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = b0.a((z) CommonMainString0.M1.getValue(), r15);
        String r43 = b0.a(c.a(), r15);
        long r115 = n.a(r15, 0).e.a;
        r15.startReplaceGroup(-1633490746);
        if ((r13 & 896) == 256) goto L95;
        r25 = false;
    L95:
        Object r4 = r15.rememberedValue();
        if (r25 == false) goto L98;
    L101:
        final MutableState r44 = r111;
        r4 = new ExitGroupRowKt$ExitGroupRow$1$2$1(r29, r44);
        r15.updateRememberedValue(r4);
    L102:
        Function0 r5 = (Function0) r4;
        r15.endReplaceGroup();
        r15.startReplaceGroup(5004770);
        Object r116 = r15.rememberedValue();
        if (r116 != r110.getEmpty()) goto L105;
        r116 = new ExitGroupRowKt$ExitGroupRow$1$3$1(r44);
        r15.updateRememberedValue(r116);
    L105:
        Function0 r117 = (Function0) r116;
        r15.endReplaceGroup();
        r15.startReplaceGroup(5004770);
        Object r118 = r15.rememberedValue();
        if (r118 != r110.getEmpty()) goto L108;
        r118 = new ExitGroupRowKt$ExitGroupRow$1$4$1(r44);
        r15.updateRememberedValue(r118);
    L108:
        r15.endReplaceGroup();
        r0 = r15;
        FlowAlertDialogKt.a(r42, r41, r3, r43, r115, 0, r5, r117, (Function0) r118, true, true, r0, 918552576, 6, 32);
    L110:
        r0.endReplaceGroup();
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L113;
        ComposerKt.traceEventEnd();
        goto L113
    L98:
        if (r4 == r110.getEmpty()) goto L101;
        r44 = r111;
    L87:
        if (r27.f == true) goto L90;
        r37 = StringsKt.replace$default(r38, "{{chatName}}", r27.c, false, 4, null);
    L90:
        r15.updateRememberedValue(r37);
        r114 = r37;
        goto L91
    L109:
        r0 = r15;
        goto L110
    L78:
        if (r35 != r110.getEmpty()) goto L80;
    L69:
        if ((r13 & 4096) != 0) goto L71;
    L73:
        r33 = false;
        goto L75
    L71:
        if (r15.changedInstance(r30) == false) goto L73;
    L65:
        r24 = false;
        goto L66
    L61:
        r23 = false;
        goto L63
    L53:
        if (Intrinsics.areEqual(r19.rememberedValue(), Integer.valueOf(r11)) == true) goto L55;
    L49:
        r15.useNode();
        goto L50
    L27:
        if ((r32 & 4096) != 0) goto L29;
        boolean r45 = r15.changed(r30);
    L30:
        if (r45 == false) goto L32;
        int r46 = 2048;
    L33:
        r6 = r6 | r46;
        goto L34
    L32:
        r46 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L33
    L29:
        r45 = r15.changedInstance(r30);
        goto L30
    L5:
        if (r15.changed(r27) == false) goto L7;
        int r47 = 4;
    L8:
        r6 = r47 | r32;
        goto L11
    L7:
        r47 = 2;
        goto L8
    }
}
