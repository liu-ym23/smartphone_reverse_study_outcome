package com.ss.android.lark.profile_office.userprofile.section;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.profile_office.userprofile.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CtaSectionKt {
    public static final void a(final boolean r31, final List<GetDoubaoProfileResponse.CTAInfo> r32, final Function1<? super k, Unit> r33, Composer r34, final int r35) {
        Intrinsics.checkNotNullParameter(r32, "ctas");
        Intrinsics.checkNotNullParameter(r33, "onIntent");
        Composer r15 = r34.startRestartGroup(-1425147536);
        if ((r35 & 6) == 0) goto L5;
        int r5 = r35;
    L11:
        if ((r35 & 48) == 0) goto L13;
    L17:
        int r14 = 256;
        if ((r35 & 384) == 0) goto L20;
    L24:
        int r12 = r5;
        if ((r12 & 147) != 146) goto L31;
        if (r15.getSkipping() == false) goto L31;
        r15.skipToGroupEnd();
        Composer r19 = r15;
    L69:
        ScopeUpdateScope r4 = r19.endRestartGroup();
        if (r4 == null) goto L77;
        r4.updateScope(new CtaSectionKt$CtaSection$3(r31, r32, r33, r35));
        return;
    L77:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1425147536, r12, -1, "com.ss.android.lark.profile_office.userprofile.section.CtaSection (CtaSection.kt:27)");
    L33:
        if (r31 == false) goto L35;
        float r6 = 16;
        Modifier r7 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.constructor-impl(r6), Dp.constructor-impl(24), Dp.constructor-impl(r6), 0.0f, 8, null);
        MeasurePolicy r8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Alignment.Companion.getTop(), r15, 6);
        int r10 = 0;
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r9 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r11 = r15.getCurrentCompositionLocalMap();
        Modifier r13 = ComposedModifierKt.materializeModifier(r15, r7);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r18 = r17.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L44;
        ComposablesKt.invalidApplier();
    L44:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L47;
        r15.createNode(r18);
    L48:
        Composer r110 = Updater.constructor-impl(r15);
        Updater.set-impl(r110, r8, r17.getSetMeasurePolicy());
        Updater.set-impl(r110, r11, r17.getSetResolvedCompositionLocals());
        Function2 r20 = r17.getSetCompositeKeyHash();
        if (r110.getInserting() == false) goto L51;
    L52:
        r110.updateRememberedValue(Integer.valueOf(r9));
        r110.apply(Integer.valueOf(r9), r20);
    L53:
        Updater.set-impl(r110, r13, r17.getSetModifier());
        RowScopeInstance r22 = RowScopeInstance.INSTANCE;
        r15.startReplaceGroup(1373959826);
        Iterator<T> r23 = r32.iterator();
    L55:
        if (r23.hasNext() == false) goto L66;
        final GetDoubaoProfileResponse.CTAInfo r111 = (GetDoubaoProfileResponse.CTAInfo) r23.next();
        r15.startReplaceGroup(-1633490746);
        if ((r12 & 896) != r14) goto L59;
        boolean r21 = true;
    L60:
        boolean r24 = r21 | r15.changedInstance(r111);
        Object r25 = r15.rememberedValue();
        if (r24 == false) goto L63;
    L64:
        r25 = new CtaSectionKt$CtaSection$2$1$1$1(r33, r111);
        r15.updateRememberedValue(r25);
    L65:
        r15.endReplaceGroup();
        Modifier r112 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default(r22, Modifier.Companion, 1.0f, false, 2, null), Dp.constructor-impl(56));
        RoundedCornerShape r113 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r6));
        ButtonColors r26 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(n.a(r15, r10).a.a, 0, 0, 0, r15, ButtonDefaults.$stable << 12, 14);
        r15 = r15;
        ButtonKt.Button((Function0) r25, r112, false, r113, r26, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1530805195, true, new CtaSectionKt$CtaSection$2$1$2(r111), r15, 54), r15, 805306368, 484);
        r12 = r12;
        r10 = 0;
        r14 = 256;
        goto L55
    L63:
        if (r25 != Composer.Companion.getEmpty()) goto L65;
    L59:
        r21 = false;
        goto L60
    L66:
        r19 = r15;
        r19.endReplaceGroup();
        r19.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventEnd();
        goto L69
    L51:
        if (Intrinsics.areEqual(r110.rememberedValue(), Integer.valueOf(r9)) == true) goto L53;
    L47:
        r15.useNode();
        goto L48
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        ScopeUpdateScope r27 = r15.endRestartGroup();
        if (r27 == null) goto L76;
        r27.updateScope(new CtaSectionKt$CtaSection$1(r31, r32, r33, r35));
        return;
    L76:
        return;
    L20:
        if (r15.changedInstance(r33) == false) goto L22;
        int r28 = 256;
    L23:
        r5 = r5 | r28;
        goto L24
    L22:
        r28 = 128;
        goto L23
    L13:
        if (r15.changedInstance(r32) == false) goto L15;
        int r29 = 32;
    L16:
        r5 = r5 | r29;
        goto L17
    L15:
        r29 = 16;
        goto L16
    L5:
        if (r15.changed(r31) == false) goto L7;
        int r30 = 4;
    L8:
        r5 = r30 | r35;
        goto L11
    L7:
        r30 = 2;
        goto L8
    }
}
