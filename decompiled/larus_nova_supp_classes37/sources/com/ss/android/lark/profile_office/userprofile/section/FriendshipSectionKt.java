package com.ss.android.lark.profile_office.userprofile.section;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.profile_office.userprofile.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FriendshipSectionKt {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GetDoubaoProfileResponse.ContactStatus.values().length];
            r0[GetDoubaoProfileResponse.ContactStatus.CONTACT_DUAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[GetDoubaoProfileResponse.ContactStatus.CONTACT_FORWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[GetDoubaoProfileResponse.ContactStatus.CONTACT_REVERSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[GetDoubaoProfileResponse.ContactStatus.CONTACT_NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final void a(final boolean r31, final GetDoubaoProfileResponse.ContactStatus r32, final boolean r33, final Function1<? super k, Unit> r34, Composer r35, final int r36) {
        Intrinsics.checkNotNullParameter(r34, "onIntent");
        Composer r2 = r35.startRestartGroup(1352785974);
        if ((r36 & 6) == 0) goto L5;
        int r6 = r36;
    L10:
        int r10 = -1;
        if ((r36 & 48) != 0) goto L21;
        if (r32 != null) goto L14;
        int r8 = -1;
    L16:
        if (r2.changed(r8) == false) goto L18;
        int r9 = 32;
    L19:
        r6 = r6 | r9;
        goto L21
    L18:
        r9 = 16;
        goto L19
    L14:
        r8 = r32.ordinal();
    L21:
        if ((r36 & 384) != 0) goto L28;
        if (r2.changed(r33) == false) goto L25;
        int r11 = 256;
    L26:
        r6 = r6 | r11;
        goto L28
    L25:
        r11 = 128;
    L28:
        if ((r36 & 3072) == 0) goto L30;
    L34:
        int r14 = r6;
        if ((r14 & 1171) != 1170) goto L41;
        if (r2.getSkipping() == false) goto L41;
        r2.skipToGroupEnd();
    L142:
        ScopeUpdateScope r7 = r2.endRestartGroup();
        if (r7 == null) goto L146;
        r7.updateScope(new FriendshipSectionKt$FriendshipSection$4(r31, r32, r33, r34, r36));
        return;
    L146:
        return;
    L41:
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventStart(1352785974, r14, -1, "com.ss.android.lark.profile_office.userprofile.section.FriendshipSection (FriendshipSection.kt:33)");
    L43:
        if (r32 == null) goto L47;
        r10 = a.a[r32.ordinal()];
    L47:
        if (r10 != 1) goto L49;
        r2.startReplaceGroup(1169044545);
        r2.endReplaceGroup();
        Unit r0 = Unit.INSTANCE;
    L140:
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventEnd();
        goto L142
    L49:
        if (r10 != 2) goto L51;
        r2.startReplaceGroup(1169131872);
        Modifier.Companion r12 = Modifier.Companion;
        float r13 = 16;
        Modifier r15 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(r12, 0.0f, 1, null), Dp.constructor-impl(r13), Dp.constructor-impl(24), Dp.constructor-impl(r13), 0.0f, 8, null);
        MeasurePolicy r16 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r2, 0);
        long r17 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r18 = (int) (r17 ^ (r17 >>> 32));
        CompositionLocalMap r19 = r2.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r2, r15);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L125;
        ComposablesKt.invalidApplier();
    L125:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L128;
        r2.createNode(r111);
    L129:
        Composer r112 = Updater.constructor-impl(r2);
        Updater.set-impl(r112, r16, r110.getSetMeasurePolicy());
        Updater.set-impl(r112, r19, r110.getSetResolvedCompositionLocals());
        Function2 r21 = r110.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L132;
    L133:
        r112.updateRememberedValue(Integer.valueOf(r18));
        r112.apply(Integer.valueOf(r18), r21);
    L134:
        Updater.set-impl(r112, r20, r110.getSetModifier());
        ColumnScopeInstance r22 = ColumnScopeInstance.INSTANCE;
        r2.startReplaceGroup(1849434622);
        Object r23 = r2.rememberedValue();
        if (r23 != Composer.Companion.getEmpty()) goto L137;
        r23 = FriendshipSectionKt$FriendshipSection$1$1$1.INSTANCE;
        r2.updateRememberedValue(r23);
    L137:
        r2.endReplaceGroup();
        ButtonKt.Button((Function0) r23, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r12, 0.0f, 1, null), Dp.constructor-impl(56)), false, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r13)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(n.a(r2, 0).d.e, 0, n.a(r2, 0).d.e, 0, r2, ButtonDefaults.$stable << 12, 10), null, null, null, null, ComposableSingletons$FriendshipSectionKt.a, r2, 805306806, 480);
        r2.endNode();
        r2.endReplaceGroup();
        Unit r1 = Unit.INSTANCE;
        goto L140
    L132:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r18)) == true) goto L134;
    L128:
        r2.useNode();
        goto L129
    L51:
        if (r10 == 3) goto L84;
        if (r10 == 4) goto L54;
        r2.startReplaceGroup(1174062081);
        r2.endReplaceGroup();
        Unit r3 = Unit.INSTANCE;
        goto L140
    L54:
        r2.startReplaceGroup(1172724431);
        Modifier.Companion r24 = Modifier.Companion;
        float r25 = 16;
        Modifier r113 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(r24, 0.0f, 1, null), Dp.constructor-impl(r25), Dp.constructor-impl(24), Dp.constructor-impl(r25), 0.0f, 8, null);
        MeasurePolicy r114 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r2, 0);
        long r26 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r27 = (int) (r26 ^ (r26 >>> 32));
        CompositionLocalMap r28 = r2.getCurrentCompositionLocalMap();
        Modifier r115 = ComposedModifierKt.materializeModifier(r2, r113);
        ComposeUiNode.Companion r116 = ComposeUiNode.Companion;
        Function0 r4 = r116.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L57;
        ComposablesKt.invalidApplier();
    L57:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L60;
        r2.createNode(r4);
    L61:
        Composer r5 = Updater.constructor-impl(r2);
        Updater.set-impl(r5, r114, r116.getSetMeasurePolicy());
        Updater.set-impl(r5, r28, r116.getSetResolvedCompositionLocals());
        Function2 r29 = r116.getSetCompositeKeyHash();
        if (r5.getInserting() == false) goto L64;
    L65:
        r5.updateRememberedValue(Integer.valueOf(r27));
        r5.apply(Integer.valueOf(r27), r29);
    L66:
        Updater.set-impl(r5, r115, r116.getSetModifier());
        ColumnScopeInstance r30 = ColumnScopeInstance.INSTANCE;
        r2.startReplaceGroup(-1633490746);
        if ((r14 & 14) != 4) goto L69;
        boolean r37 = true;
    L71:
        if ((r14 & 7168) != 2048) goto L73;
        boolean r38 = true;
    L74:
        boolean r39 = r37 | r38;
        Object r40 = r2.rememberedValue();
        if (r39 == false) goto L77;
    L78:
        r40 = new FriendshipSectionKt$FriendshipSection$3$1$1(r31, r34);
        r2.updateRememberedValue(r40);
    L79:
        Function0 r41 = (Function0) r40;
        r2.endReplaceGroup();
        Modifier r210 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r24, 0.0f, 1, null), Dp.constructor-impl(56));
        RoundedCornerShape r211 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r25));
        ButtonDefaults r42 = ButtonDefaults.INSTANCE;
        if (r31 == false) goto L82;
        r2.startReplaceGroup(-438974752);
        long r43 = n.a(r2, 0).d.e;
    L83:
        r2.endReplaceGroup();
        ButtonKt.Button(r41, r210, false, r211, r42.buttonColors-ro_MJ88(r43, 0, 0, 0, r2, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1820503557, true, new FriendshipSectionKt$FriendshipSection$3$2(r31), r2, 54), r2, 805306416, 484);
        r2.endNode();
        r2.endReplaceGroup();
        Unit r44 = Unit.INSTANCE;
        goto L140
    L82:
        r2.startReplaceGroup(-438972939);
        r43 = n.a(r2, 0).a.a;
        goto L83
    L77:
        if (r40 != Composer.Companion.getEmpty()) goto L79;
    L73:
        r38 = false;
        goto L74
    L69:
        r37 = false;
        goto L71
    L64:
        if (Intrinsics.areEqual(r5.rememberedValue(), Integer.valueOf(r27)) == true) goto L66;
    L60:
        r2.useNode();
        goto L61
    L84:
        r2.startReplaceGroup(1170306958);
        Modifier.Companion r45 = Modifier.Companion;
        float r46 = 16;
        Modifier r117 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(r45, 0.0f, 1, null), Dp.constructor-impl(r46), Dp.constructor-impl(24), Dp.constructor-impl(r46), 0.0f, 8, null);
        MeasurePolicy r118 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r2, 0);
        long r212 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r47 = (int) (r212 ^ (r212 >>> 32));
        CompositionLocalMap r48 = r2.getCurrentCompositionLocalMap();
        Modifier r119 = ComposedModifierKt.materializeModifier(r2, r117);
        ComposeUiNode.Companion r120 = ComposeUiNode.Companion;
        Function0 r49 = r120.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L87;
        ComposablesKt.invalidApplier();
    L87:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L90;
        r2.createNode(r49);
    L91:
        Composer r50 = Updater.constructor-impl(r2);
        Updater.set-impl(r50, r118, r120.getSetMeasurePolicy());
        Updater.set-impl(r50, r48, r120.getSetResolvedCompositionLocals());
        Function2 r51 = r120.getSetCompositeKeyHash();
        if (r50.getInserting() == false) goto L94;
    L95:
        r50.updateRememberedValue(Integer.valueOf(r47));
        r50.apply(Integer.valueOf(r47), r51);
    L96:
        Updater.set-impl(r50, r119, r120.getSetModifier());
        ColumnScopeInstance r52 = ColumnScopeInstance.INSTANCE;
        boolean r213 = !r33;
        Modifier r53 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r45, 0.0f, 1, null), Dp.constructor-impl(56));
        if (r33 == false) goto L99;
        float r54 = 0.3f;
    L100:
        Modifier r214 = AlphaKt.alpha(r53, r54);
        RoundedCornerShape r55 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r46));
        ButtonDefaults r56 = ButtonDefaults.INSTANCE;
        if (r31 == false) goto L103;
        r2.startReplaceGroup(-45972479);
        int r57 = 0;
        long r58 = n.a(r2, 0).d.e;
    L104:
        r2.endReplaceGroup();
        if (r31 == false) goto L107;
        r2.startReplaceGroup(-45967263);
        long r121 = n.a(r2, r57).d.e;
    L108:
        r2.endReplaceGroup();
        ButtonColors r122 = r56.buttonColors-ro_MJ88(r58, 0, r121, 0, r2, ButtonDefaults.$stable << 12, 10);
        r2.startReplaceGroup(-1633490746);
        if ((r14 & 14) != 4) goto L111;
        boolean r59 = true;
    L113:
        if ((r14 & 7168) != 2048) goto L115;
        boolean r60 = true;
    L116:
        boolean r61 = r60 | r59;
        Object r62 = r2.rememberedValue();
        if (r61 == false) goto L119;
    L120:
        r62 = new FriendshipSectionKt$FriendshipSection$2$1$1(r31, r34);
        r2.updateRememberedValue(r62);
    L121:
        r2.endReplaceGroup();
        ButtonKt.Button((Function0) r62, r214, r213, r55, r122, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1424594524, true, new FriendshipSectionKt$FriendshipSection$2$2(r33, r31), r2, 54), r2, 805306368, 480);
        r2.endNode();
        r2.endReplaceGroup();
        Unit r63 = Unit.INSTANCE;
        goto L140
    L119:
        if (r62 != Composer.Companion.getEmpty()) goto L121;
    L115:
        r60 = false;
        goto L116
    L111:
        r59 = false;
        goto L113
    L107:
        r2.startReplaceGroup(-45965450);
        r121 = n.a(r2, r57).a.a;
        goto L108
    L103:
        r57 = 0;
        r2.startReplaceGroup(-45970666);
        r58 = n.a(r2, 0).a.a;
        goto L104
    L99:
        r54 = 1.0f;
        goto L100
    L94:
        if (Intrinsics.areEqual(r50.rememberedValue(), Integer.valueOf(r47)) == true) goto L96;
    L90:
        r2.useNode();
        goto L91
    L30:
        if (r2.changedInstance(r34) == false) goto L32;
        int r64 = 2048;
    L33:
        r6 = r6 | r64;
        goto L34
    L32:
        r64 = 1024;
        goto L33
    L5:
        if (r2.changed(r31) == false) goto L7;
        int r65 = 4;
    L8:
        r6 = r65 | r36;
        goto L10
    L7:
        r65 = 2;
        goto L8
    }
}
