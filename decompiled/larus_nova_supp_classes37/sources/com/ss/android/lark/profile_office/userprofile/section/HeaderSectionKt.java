package com.ss.android.lark.profile_office.userprofile.section;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.image.compose.common.ImageFormat;
import com.ss.android.lark.image.compose.common.avatar.AvatarImageComponentKt;
import com.ss.android.lark.image.compose.common.avatar.a;
import com.ss.android.lark.profile_office.userprofile.k;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class HeaderSectionKt {
    public static final void a(final boolean r83, final boolean r84, final boolean r85, final boolean r86, final String r87, final String r88, final String r89, final String r90, final String r91, final Long r92, final RecogniseSpansResult r93, final String r94, final String r95, final boolean r96, final boolean r97, final boolean r98, final boolean r99, final String r100, final String r101, final Function1<? super k, Unit> r102, Composer r103, final int r104, final int r105) {
        Intrinsics.checkNotNullParameter(r87, "userId");
        Intrinsics.checkNotNullParameter(r88, "userAvatarKey");
        Intrinsics.checkNotNullParameter(r89, "userName");
        Intrinsics.checkNotNullParameter(r90, "aliasName");
        Intrinsics.checkNotNullParameter(r91, "descriptionText");
        Intrinsics.checkNotNullParameter(r94, "doubaoNumber");
        Intrinsics.checkNotNullParameter(r95, "tenantName");
        Intrinsics.checkNotNullParameter(r102, "onIntent");
        Composer r5 = r103.startRestartGroup(1232662702);
        int r17 = 2;
        if ((r104 & 6) == 0) goto L5;
        int r16 = r104;
    L11:
        if ((r104 & 48) == 0) goto L13;
    L17:
        int r19 = 128;
        if ((r104 & 384) == 0) goto L20;
    L24:
        int r22 = 2048;
        if ((r104 & 3072) != 0) goto L32;
        if (r5.changed(r86) == false) goto L29;
        int r7 = 2048;
    L30:
        r16 = r16 | r7;
        goto L32
    L29:
        r7 = 1024;
    L32:
        if ((r104 & 24576) != 0) goto L39;
        if (r5.changed(r87) == false) goto L36;
        int r8 = 16384;
    L37:
        r16 = r16 | r8;
        goto L39
    L36:
        r8 = 8192;
    L39:
        if ((r104 & 196608) != 0) goto L46;
        if (r5.changed(r88) == false) goto L43;
        int r24 = 131072;
    L44:
        r16 = r16 | r24;
        goto L46
    L43:
        r24 = 65536;
    L46:
        if ((r104 & 1572864) != 0) goto L53;
        if (r5.changed(r89) == false) goto L50;
        int r25 = 1048576;
    L51:
        r16 = r16 | r25;
        goto L53
    L50:
        r25 = 524288;
    L53:
        if ((r104 & 12582912) != 0) goto L60;
        if (r5.changed(r90) == false) goto L57;
        int r26 = 8388608;
    L58:
        r16 = r16 | r26;
        goto L60
    L57:
        r26 = 4194304;
    L60:
        if ((r104 & 100663296) != 0) goto L67;
        if (r5.changed(r91) == false) goto L64;
        int r27 = 67108864;
    L65:
        r16 = r16 | r27;
        goto L67
    L64:
        r27 = 33554432;
    L67:
        if ((r104 & 805306368) == 0) goto L69;
    L73:
        int r42 = r16;
        if ((r105 & 6) == 0) goto L76;
        int r18 = r105;
    L81:
        if ((r105 & 48) != 0) goto L88;
        if (r5.changed(r94) == false) goto L85;
        int r110 = 32;
    L86:
        r18 = r18 | r110;
        goto L88
    L85:
        r110 = 16;
    L88:
        if ((r105 & 384) != 0) goto L94;
        if (r5.changed(r95) == false) goto L92;
        r19 = 256;
    L92:
        r18 = r18 | r19;
    L94:
        if ((r105 & 3072) != 0) goto L102;
        if (r5.changed(r96) == true) goto L99;
        r22 = 1024;
    L99:
        r18 = r18 | r22;
    L102:
        if ((r105 & 24576) != 0) goto L110;
        if (r5.changed(r97) == false) goto L106;
        int r111 = 16384;
    L107:
        r18 = r18 | r111;
        goto L110
    L106:
        r111 = 8192;
    L110:
        if ((r105 & 196608) != 0) goto L117;
        if (r5.changed(r98) == false) goto L114;
        int r112 = 131072;
    L115:
        r18 = r18 | r112;
        goto L117
    L114:
        r112 = 65536;
    L117:
        if ((r105 & 1572864) != 0) goto L124;
        if (r5.changed(r99) == false) goto L121;
        int r113 = 1048576;
    L122:
        r18 = r18 | r113;
        goto L124
    L121:
        r113 = 524288;
    L124:
        if ((r105 & 12582912) != 0) goto L131;
        if (r5.changed(r100) == false) goto L128;
        int r114 = 8388608;
    L129:
        r18 = r18 | r114;
        goto L131
    L128:
        r114 = 4194304;
    L131:
        if ((r105 & 100663296) != 0) goto L138;
        if (r5.changed(r101) == false) goto L135;
        int r115 = 67108864;
    L136:
        r18 = r18 | r115;
        goto L138
    L135:
        r115 = 33554432;
    L138:
        if ((r105 & 805306368) == 0) goto L140;
    L144:
        int r9 = r18;
        if ((r42 & 306783379) != 306783378) goto L153;
        if ((306783379 & r9) != 306783378) goto L153;
        if (r5.getSkipping() == false) goto L153;
        r5.skipToGroupEnd();
        Composer r0 = r5;
    L288:
        ScopeUpdateScope r15 = r0.endRestartGroup();
        if (r15 == null) goto L292;
        r15.updateScope(new HeaderSectionKt$HeaderSection$2(r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r104, r105));
        return;
    L292:
        return;
    L153:
        if (ComposerKt.isTraceInProgress() == false) goto L155;
        ComposerKt.traceEventStart(1232662702, r42, r9, "com.ss.android.lark.profile_office.userprofile.section.HeaderSection (HeaderSection.kt:71)");
    L155:
        Modifier.Companion r10 = Modifier.Companion;
        float r11 = 32;
        Modifier r12 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(r10, 0.0f, 1, null), Dp.constructor-impl(r11), 0.0f, Dp.constructor-impl(r11), 0.0f, 10, null);
        Alignment.Companion r13 = Alignment.Companion;
        Alignment.Horizontal r14 = r13.getCenterHorizontally();
        Arrangement r43 = Arrangement.INSTANCE;
        MeasurePolicy r116 = ColumnKt.columnMeasurePolicy(r43.getTop(), r14, r5, 48);
        long r117 = ComposablesKt.getCurrentCompositeKeyHashCode(r5, 0);
        int r118 = (int) (r117 ^ (r117 >>> 32));
        CompositionLocalMap r119 = r5.getCurrentCompositionLocalMap();
        Modifier r120 = ComposedModifierKt.materializeModifier(r5, r12);
        ComposeUiNode.Companion r45 = ComposeUiNode.Companion;
        Function0 r121 = r45.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L158;
        ComposablesKt.invalidApplier();
    L158:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L161;
        r5.createNode(r121);
    L162:
        Composer r3 = Updater.constructor-impl(r5);
        Updater.set-impl(r3, r116, r45.getSetMeasurePolicy());
        Updater.set-impl(r3, r119, r45.getSetResolvedCompositionLocals());
        Function2 r6 = r45.getSetCompositeKeyHash();
        if (r3.getInserting() == false) goto L165;
    L166:
        r3.updateRememberedValue(Integer.valueOf(r118));
        r3.apply(Integer.valueOf(r118), r6);
    L167:
        Updater.set-impl(r3, r120, r45.getSetModifier());
        ColumnScopeInstance r4 = ColumnScopeInstance.INSTANCE;
        r5.startReplaceGroup(1849434622);
        Object r20 = r5.rememberedValue();
        Composer.Companion r21 = Composer.Companion;
        if (r20 != r21.getEmpty()) goto L170;
        r20 = InteractionSourceKt.MutableInteractionSource();
        r5.updateRememberedValue(r20);
    L170:
        MutableInteractionSource r23 = (MutableInteractionSource) r20;
        r5.endReplaceGroup();
        r5.startReplaceGroup(5004770);
        int r122 = 1879048192 & r9;
        if (r122 != 536870912) goto L173;
        boolean r123 = true;
    L174:
        Object r124 = r5.rememberedValue();
        if (r123 == false) goto L177;
    L178:
        r124 = new HeaderSectionKt$HeaderSection$1$onAvatarClick$1$1(r102);
        r5.updateRememberedValue(r124);
    L179:
        Function0 r28 = (Function0) r124;
        r5.endReplaceGroup();
        r5.startReplaceGroup(5004770);
        if (r122 != 536870912) goto L182;
        boolean r125 = true;
    L183:
        Object r126 = r5.rememberedValue();
        if (r125 == false) goto L186;
    L187:
        r126 = new HeaderSectionKt$HeaderSection$1$onQrCodeClick$1$1(r102);
        r5.updateRememberedValue(r126);
    L188:
        Function0 r127 = (Function0) r126;
        r5.endReplaceGroup();
        float r128 = 160;
        AvatarImageComponentKt.a(new a(r88, r87, Dp.constructor-impl(r128), ImageFormat.PNG), ClickableKt.clickable-O2vRcR0$default(ClipKt.clip(SizeKt.size-3ABfNKs(r10, Dp.constructor-impl(r128)), RoundedCornerShapeKt.getCircleShape()), r23, null, false, null, null, r28, 28, null), null, null, null, null, null, null, r5, 224640, 192);
        if (StringsKt.isBlank(r90) == false) goto L191;
        String r29 = r89;
    L192:
        float r129 = 16;
        Modifier r130 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(r10, 0.0f, Dp.constructor-impl(r129), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
        long r50 = TextUnitKt.getSp(22);
        FontWeight.Companion r131 = FontWeight.Companion;
        TextStyle r47 = new TextStyle(0, r50, r131.getBold(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null);
        long r132 = n.a(r5, 0).d.a;
        TextAlign.Companion r133 = TextAlign.Companion;
        int r134 = r133.getCenter-e0LSkKk();
        TextOverflow.Companion r135 = TextOverflow.Companion;
        String r136 = r29;
        TextKt.Text-Nvy7gAk(r136, r130, r132, null, 0, null, null, null, 0, null, TextAlign.box-impl(r134), 0, r135.getEllipsis-gIe3tQ8(), false, 1, 0, null, r47, r5, 48, 12607872, 109560);
        r5.startReplaceGroup(-2043633441);
        if ((!StringsKt.isBlank(r90)) == false) goto L195;
        Modifier r137 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(r10, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
        TextStyle r49 = new TextStyle(0, TextUnitKt.getSp(14), r131.getBold(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null);
        Composer r138 = r5;
        long r30 = n.a(r5, 0).d.a;
        int r31 = r133.getCenter-e0LSkKk();
        int r32 = r135.getEllipsis-gIe3tQ8();
        int r33 = 0;
        TextKt.Text-Nvy7gAk(r89, r137, r30, null, 0, null, null, null, 0, null, TextAlign.box-impl(r31), 0, r32, false, 1, 0, null, r49, r138, ((r42 >> 18) & 14) | 48, 12607872, 109560);
    L196:
        r138.endReplaceGroup();
        Composer r34 = r138;
        r34.startReplaceGroup(-2043615654);
        if (r84 == false) goto L199;
        int r35 = r9 >> 6;
        TenantNameWithTagKt.a(r95, r96, r97, r98, r99, SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(r10, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, null), 0.0f, 1, null), r34, (((((r35 & 14) | 196608) | (r35 & 112)) | (r35 & 896)) | (r35 & 7168)) | (r35 & 57344), 0);
    L199:
        r34.endReplaceGroup();
        if (r83 == false) goto L225;
        r34.startReplaceGroup(1072868584);
        r34.startReplaceGroup(-2043601483);
        String r36 = "";
        if (r100 != null) goto L204;
        String r37 = "";
    L206:
        if (r37.length() <= 0) goto L208;
        boolean r38 = true;
    L209:
        if (r38 == false) goto L211;
        TextKt.Text-Nvy7gAk("“" + r100 + 8221, SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(r10, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, null), 0.0f, 1, null), n.a(r34, r33).d.a, null, 0, null, null, null, 0, null, TextAlign.box-impl(r133.getCenter-e0LSkKk()), 0, 0, false, 0, 0, null, new TextStyle(0, TextUnitKt.getSp(14), r131.getNormal(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null), r34, 48, 12582912, 130040);
    L211:
        r34.endReplaceGroup();
        if (r101 != null) goto L214;
        String r39 = "";
    L216:
        if (r39.length() <= 0) goto L218;
        boolean r40 = true;
    L219:
        if (r40 == false) goto L224;
        if (r101 == null) goto L223;
        r36 = r101;
    L223:
        String r139 = r36;
        TextKt.Text-Nvy7gAk(r139, SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(r10, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, null), 0.0f, 1, null), n.a(r34, r33).d.c, null, 0, null, null, null, 0, null, TextAlign.box-impl(r133.getCenter-e0LSkKk()), 0, 0, false, 0, 0, null, new TextStyle(0, TextUnitKt.getSp(14), r131.getNormal(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null), r34, 48, 12582912, 130040);
    L224:
        r34.endReplaceGroup();
        int r1 = 16384;
    L252:
        r34.startReplaceGroup(-2043506523);
        if (r91.length() <= 0) goto L255;
        boolean r140 = true;
    L256:
        if (r140 == false) goto L284;
        final int r141 = ColorKt.toArgb-8_81llA(n.a(r34, 0).d.c);
        final int r142 = ColorKt.toArgb-8_81llA(n.a(r34, 0).a.b);
        boolean r143 = true;
        Modifier r144 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(r10, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
        r34.startReplaceGroup(1849434622);
        Object r41 = r34.rememberedValue();
        if (r41 != r21.getEmpty()) goto L260;
        r41 = HeaderSectionKt$HeaderSection$1$3$1.INSTANCE;
        r34.updateRememberedValue(r41);
    L260:
        Function1 r44 = (Function1) r41;
        r34.endReplaceGroup();
        r34.startReplaceGroup(-1224400529);
        if ((57344 & r42) != r1) goto L263;
        boolean r2 = true;
    L265:
        if ((234881024 & r42) != 67108864) goto L267;
        boolean r46 = true;
    L268:
        boolean r48 = r2 | r46;
        if ((1879048192 & r42) != 536870912) goto L271;
        boolean r51 = true;
    L272:
        boolean r52 = (((r48 | r51) | r34.changedInstance(r93)) | r34.changed(r141)) | r34.changed(r142);
        if (r122 == 536870912) goto L276;
        r143 = false;
    L276:
        boolean r53 = r52 | r143;
        Object r54 = r34.rememberedValue();
        if (r53 == false) goto L279;
    L282:
        r0 = r34;
        r54 = new HeaderSectionKt$HeaderSection$1$4$1(r87, r91, r92, r93, r141, r142, r102);
        r0.updateRememberedValue(r54);
    L283:
        r0.endReplaceGroup();
        AndroidView_androidKt.AndroidView(r44, r144, (Function1) r54, r0, 54, 0);
    L285:
        r0.endReplaceGroup();
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L288;
        ComposerKt.traceEventEnd();
        goto L288
    L279:
        if (r54 == r21.getEmpty()) goto L282;
        r0 = r34;
        goto L283
    L271:
        r51 = false;
        goto L272
    L267:
        r46 = false;
        goto L268
    L263:
        r2 = false;
        goto L265
    L284:
        r0 = r34;
        goto L285
    L255:
        r140 = false;
        goto L256
    L218:
        r40 = false;
        goto L219
    L214:
        r39 = r101;
        goto L216
    L208:
        r38 = false;
        goto L209
    L204:
        r37 = r100;
        goto L206
    L225:
        r34.startReplaceGroup(1074067664);
        if (r85 == true) goto L228;
        r1 = 16384;
    L251:
        r34.endReplaceGroup();
        goto L252
    L228:
        if (r94.length() != 0) goto L230;
        boolean r145 = true;
    L231:
        if (r145 == false) goto L233;
        String r55 = "-";
    L234:
        float r146 = 6;
        Modifier r56 = PaddingKt.padding-qDBjuR0$default(r10, 0.0f, Dp.constructor-impl(r146), 0.0f, 0.0f, 13, null);
        MeasurePolicy r147 = RowKt.rowMeasurePolicy(r43.getStart(), r13.getCenterVertically(), r34, 48);
        long r148 = ComposablesKt.getCurrentCompositeKeyHashCode(r34, r33);
        int r149 = (int) (r148 ^ (r148 >>> 32));
        CompositionLocalMap r150 = r34.getCurrentCompositionLocalMap();
        Modifier r57 = ComposedModifierKt.materializeModifier(r34, r56);
        Function0 r58 = r45.getConstructor();
        if ((r34.getApplier() instanceof Applier) == true) goto L237;
        ComposablesKt.invalidApplier();
    L237:
        r34.startReusableNode();
        if (r34.getInserting() == false) goto L240;
        r34.createNode(r58);
    L241:
        Composer r59 = Updater.constructor-impl(r34);
        Updater.set-impl(r59, r147, r45.getSetMeasurePolicy());
        Updater.set-impl(r59, r150, r45.getSetResolvedCompositionLocals());
        Function2 r60 = r45.getSetCompositeKeyHash();
        if (r59.getInserting() == false) goto L244;
    L245:
        r59.updateRememberedValue(Integer.valueOf(r149));
        r59.apply(Integer.valueOf(r149), r60);
    L246:
        Updater.set-impl(r59, r57, r45.getSetModifier());
        RowScopeInstance r61 = RowScopeInstance.INSTANCE;
        String r62 = StringResources_androidKt.stringResource(2131890051, r34, 0);
        ICUUtils.FormatArgsBuilder r63 = new ICUUtils.FormatArgsBuilder();
        r63.b("id", r55);
        TextKt.Text-Nvy7gAk(ICUUtils.icuFormat(r62, r63.a), null, n.a(r34, 0).d.c, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, new TextStyle(0, TextUnitKt.getSp(14), r131.getNormal(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null), r34, 0, 12582912, 131066);
        r34.startReplaceGroup(-1990017834);
        r1 = 16384;
        if (r86 == false) goto L249;
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r10, Dp.constructor-impl(r146)), r34, 6);
        IconKt.Icon-ww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.Companion, 2131238043, r34, 6), null, ClickableKt.clickable-O2vRcR0$default(SizeKt.size-3ABfNKs(r10, Dp.constructor-impl(r129)), r23, null, false, null, null, r127, 28, null), Color.Companion.getUnspecified-0d7_KjU(), r34, 3120, 0);
    L249:
        r34.endReplaceGroup();
        r34.endNode();
        goto L251
    L244:
        if (Intrinsics.areEqual(r59.rememberedValue(), Integer.valueOf(r149)) == true) goto L246;
    L240:
        r34.useNode();
        goto L241
    L233:
        r55 = r94;
        goto L234
    L230:
        r145 = false;
        goto L231
    L195:
        r33 = 0;
        r138 = r5;
        goto L196
    L191:
        r29 = r90;
        goto L192
    L186:
        if (r126 != r21.getEmpty()) goto L188;
    L182:
        r125 = false;
        goto L183
    L177:
        if (r124 != r21.getEmpty()) goto L179;
    L173:
        r123 = false;
        goto L174
    L165:
        if (Intrinsics.areEqual(r3.rememberedValue(), Integer.valueOf(r118)) == true) goto L167;
    L161:
        r5.useNode();
        goto L162
    L140:
        if (r5.changedInstance(r102) == false) goto L142;
        int r151 = 536870912;
    L143:
        r18 = r18 | r151;
        goto L144
    L142:
        r151 = 268435456;
        goto L143
    L76:
        if (r5.changedInstance(r93) == false) goto L78;
        r17 = 4;
    L78:
        r18 = r105 | r17;
        goto L81
    L69:
        if (r5.changed(r92) == false) goto L71;
        int r210 = 536870912;
    L72:
        r16 = r16 | r210;
        goto L73
    L71:
        r210 = 268435456;
        goto L72
    L20:
        if (r5.changed(r85) == false) goto L22;
        int r64 = 256;
    L23:
        r16 = r16 | r64;
        goto L24
    L22:
        r64 = 128;
        goto L23
    L13:
        if (r5.changed(r84) == false) goto L15;
        int r152 = 32;
    L16:
        r16 = r16 | r152;
        goto L17
    L15:
        r152 = 16;
        goto L16
    L5:
        if (r5.changed(r83) == false) goto L7;
        int r153 = 4;
    L8:
        r16 = r104 | r153;
        goto L11
    L7:
        r153 = 2;
        goto L8
    }
}
