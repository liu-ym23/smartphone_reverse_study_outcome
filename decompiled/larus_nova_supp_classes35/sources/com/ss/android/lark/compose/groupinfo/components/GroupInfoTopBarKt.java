package com.ss.android.lark.compose.groupinfo.components;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.b;
import com.ss.android.lark.flow.chat.resources.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupInfoTopBarKt {
    public static final void a(final boolean r49, final boolean r50, final Function0<Unit> r51, final Function0<Unit> r52, Modifier r53, Composer r54, final int r55, final int r56) {
        Intrinsics.checkNotNullParameter(r51, "onCancelClick");
        Intrinsics.checkNotNullParameter(r52, "onConfirmClick");
        Composer r15 = r54.startRestartGroup(145520283);
        if ((r56 & 1) == 0) goto L6;
        int r3 = r55 | 6;
    L14:
        if ((r56 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r56 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L34:
        if ((r56 & 8) == 0) goto L37;
        r3 = r3 | 3072;
    L43:
        int r5 = r56 & 16;
        if (r5 == 0) goto L47;
        r3 = r3 | 24576;
    L53:
        Modifier r8 = r53;
    L55:
        if ((r3 & 9363) == 9362) goto L57;
    L60:
        if (r5 == 0) goto L62;
        Modifier r11 = Modifier.Companion;
    L64:
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventStart(145520283, r3, -1, "com.ss.android.lark.compose.groupinfo.components.TopNavigationBar (GroupInfoTopBar.kt:30)");
    L66:
        Modifier r0 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r11, 0.0f, 1, null), Dp.constructor-impl(62)), Dp.constructor-impl(16), 0.0f, 2, null);
        Alignment.Companion r41 = Alignment.Companion;
        MeasurePolicy r4 = BoxKt.maybeCachedBoxMeasurePolicy(r41.getTopStart(), false);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r7 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r9 = r15.getCurrentCompositionLocalMap();
        Modifier r1 = ComposedModifierKt.materializeModifier(r15, r0);
        ComposeUiNode.Companion r10 = ComposeUiNode.Companion;
        Function0 r12 = r10.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L69;
        ComposablesKt.invalidApplier();
    L69:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L72;
        r15.createNode(r12);
    L73:
        Composer r13 = Updater.constructor-impl(r15);
        Updater.set-impl(r13, r4, r10.getSetMeasurePolicy());
        Updater.set-impl(r13, r9, r10.getSetResolvedCompositionLocals());
        Function2 r14 = r10.getSetCompositeKeyHash();
        if (r13.getInserting() == false) goto L76;
    L77:
        r13.updateRememberedValue(Integer.valueOf(r7));
        r13.apply(Integer.valueOf(r7), r14);
    L78:
        Updater.set-impl(r13, r1, r10.getSetModifier());
        BoxScopeInstance r2 = BoxScopeInstance.INSTANCE;
        b r16 = b.a;
        String r17 = b0.a(c.a(), r15);
        long r20 = TextUnitKt.getSp(17);
        long r18 = n.a(r15, 0).d.a;
        Modifier.Companion r19 = Modifier.Companion;
        Modifier r21 = r2.align(r19, r41.getCenterStart());
        r15.startReplaceGroup(1849434622);
        Object r22 = r15.rememberedValue();
        Composer.Companion r43 = Composer.Companion;
        if (r22 != r43.getEmpty()) goto L81;
        r22 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r22);
    L81:
        r15.endReplaceGroup();
        Modifier r48 = r11;
        TextKt.Text-Nvy7gAk(r17, ClickableKt.clickable-O2vRcR0$default(r21, (MutableInteractionSource) r22, null, false, null, null, r51, 28, null), r18, null, r20, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r15, 24576, 0, 262120);
        Intrinsics.checkNotNullParameter(r16, "<this>");
        String r110 = b0.a((z) CommonMainString0.o0.getValue(), r15);
        TextStyle r23 = n.b(r15).a;
        TextKt.Text-Nvy7gAk(r110, r2.align(r19, r41.getCenter()), n.a(r15, 0).d.a, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r23, r15, 0, 0, 131064);
        r15.startReplaceGroup(518544437);
        if (r50 == false) goto L91;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        String r111 = b0.a((z) CommonMainString0.p2.getValue(), r15);
        long r24 = TextUnitKt.getSp(17);
        FontWeight r25 = FontWeight.Companion.getMedium();
        if (r49 == false) goto L86;
        r15.startReplaceGroup(518551851);
        long r26 = n.a(r15, 0).a.a;
    L87:
        long r112 = r26;
        r15.endReplaceGroup();
        Modifier r27 = r2.align(r19, r41.getCenterEnd());
        r15.startReplaceGroup(1849434622);
        Object r28 = r15.rememberedValue();
        if (r28 != r43.getEmpty()) goto L90;
        r28 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r28);
    L90:
        r15.endReplaceGroup();
        Composer r42 = r15;
        TextKt.Text-Nvy7gAk(r111, ClickableKt.clickable-O2vRcR0$default(r27, (MutableInteractionSource) r28, null, false, null, null, r52, 28, null), r112, null, r24, null, r25, null, 0, null, null, 0, 0, false, 0, 0, null, null, r42, 1597440, 0, 262056);
    L92:
        r42.endReplaceGroup();
        r42.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventEnd();
    L95:
        final Modifier r29 = r48;
    L96:
        ScopeUpdateScope r30 = r42.endRestartGroup();
        if (r30 == null) goto L100;
        r30.updateScope(new GroupInfoTopBarKt$TopNavigationBar$2(r49, r50, r51, r52, r29, r55, r56));
        return;
    L100:
        return;
    L86:
        r15.startReplaceGroup(518553334);
        r26 = n.a(r15, 0).a.d;
        goto L87
    L91:
        r42 = r15;
        goto L92
    L76:
        if (Intrinsics.areEqual(r13.rememberedValue(), Integer.valueOf(r7)) == true) goto L78;
    L72:
        r15.useNode();
        goto L73
    L62:
        r11 = r8;
        goto L64
    L57:
        if (r15.getSkipping() == false) goto L60;
        r15.skipToGroupEnd();
        r29 = r8;
        r42 = r15;
        goto L96
    L47:
        if ((r55 & 24576) != 0) goto L53;
        r8 = r53;
        if (r15.changed(r8) == false) goto L51;
        int r31 = 16384;
    L52:
        r3 = r3 | r31;
        goto L55
    L51:
        r31 = 8192;
        goto L52
    L37:
        if ((r55 & 3072) != 0) goto L43;
        if (r15.changedInstance(r52) == false) goto L41;
        int r32 = 2048;
    L42:
        r3 = r3 | r32;
        goto L43
    L41:
        r32 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r55 & 384) != 0) goto L34;
        if (r15.changedInstance(r51) == false) goto L31;
        int r33 = 256;
    L32:
        r3 = r3 | r33;
        goto L34
    L31:
        r33 = 128;
        goto L32
    L17:
        if ((r55 & 48) != 0) goto L24;
        if (r15.changed(r50) == false) goto L21;
        int r34 = 32;
    L22:
        r3 = r3 | r34;
        goto L24
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r55 & 6) == 0) goto L8;
        r3 = r55;
        goto L14
    L8:
        if (r15.changed(r49) == false) goto L10;
        int r35 = 4;
    L11:
        r3 = r35 | r55;
        goto L14
    L10:
        r35 = 2;
        goto L11
    }
}
