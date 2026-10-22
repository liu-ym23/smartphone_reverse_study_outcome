package com.ss.android.lark.profile_office.userprofile.section;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TenantNameWithTagKt {
    public static final void a(final String r68, final boolean r69, final boolean r70, final boolean r71, final boolean r72, Modifier r73, Composer r74, final int r75, final int r76) {
        Intrinsics.checkNotNullParameter(r68, "tenantName");
        Composer r6 = r74.startRestartGroup(487157441);
        if ((r76 & 1) == 0) goto L6;
        int r8 = r75 | 6;
    L14:
        if ((r76 & 2) == 0) goto L17;
        r8 = r8 | 48;
    L24:
        if ((r76 & 4) == 0) goto L27;
        r8 = r8 | 384;
    L34:
        if ((r76 & 8) == 0) goto L37;
        r8 = r8 | 3072;
    L44:
        if ((r76 & 16) == 0) goto L47;
        r8 = r8 | 24576;
    L53:
        int r9 = r76 & 32;
        if (r9 == 0) goto L57;
        r8 = r8 | 196608;
    L63:
        Modifier r14 = r73;
    L64:
        int r15 = r8;
        if ((74899 & r15) == 74898) goto L67;
    L70:
        if (r9 == 0) goto L72;
        Modifier r35 = Modifier.Companion;
    L74:
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventStart(487157441, r15, -1, "com.ss.android.lark.profile_office.userprofile.section.TenantNameWithTag (TenantNameWithTag.kt:36)");
    L76:
        if (r69 == true) goto L82;
        if (r70 == true) goto L82;
        if (r71 == true) goto L82;
        if (r72 == true) goto L82;
        boolean r10 = false;
    L83:
        Context r13 = (Context) r6.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Density r16 = (Density) r6.consume(CompositionLocalsKt.getLocalDensity());
        r6.startReplaceGroup(-1224400529);
        boolean r11 = r6.changed(r13) | r6.changed(r16);
        if ((r15 & 112) != 32) goto L86;
        boolean r0 = true;
    L87:
        boolean r1 = r0 | r11;
        if ((r15 & 896) != 256) goto L90;
        boolean r12 = true;
    L91:
        boolean r2 = r1 | r12;
        if ((r15 & 7168) != 2048) goto L94;
        boolean r17 = true;
    L95:
        boolean r3 = r2 | r17;
        if ((57344 & r15) != 16384) goto L98;
        boolean r18 = true;
    L99:
        boolean r4 = r3 | r18;
        Object r19 = r6.rememberedValue();
        if (r4 == false) goto L102;
    L103:
        if (r10 == false) goto L107;
        FlowTagBuilder r5 = new FlowTagBuilder(r13);
        r5.c = false;
        r5.d = false;
        r5.e = r69;
        r5.f = r70;
        r5.g = r71;
        r5.h = r72;
        r5.i = false;
        FlowTagView r7 = r5.b();
        if (r7 == null) goto L107;
        int r20 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r7.measure(r20, r20);
        r19 = r7;
    L108:
        r6.updateRememberedValue(r19);
    L109:
        final FlowTagView r21 = (FlowTagView) r19;
        r6.endReplaceGroup();
        if (r68.length() != 0) goto L112;
        boolean r22 = true;
    L113:
        if (r22 == false) goto L122;
        if (r21 != null) goto L122;
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventEnd();
    L118:
        ScopeUpdateScope r23 = r6.endRestartGroup();
        if (r23 == null) goto L152;
        final Modifier r24 = r35;
        r23.updateScope(new TenantNameWithTagKt$TenantNameWithTag$1(r68, r69, r70, r71, r72, r24, r75, r76));
        return;
    L152:
        return;
    L122:
        r6.startReplaceGroup(6899349);
        if (r21 != null) goto L125;
        Map r25 = null;
    L126:
        r6.endReplaceGroup();
        if (r25 != null) goto L129;
        r25 = MapsKt.emptyMap();
    L129:
        Map r28 = r25;
        AnnotatedString.Builder r26 = new AnnotatedString.Builder(0, 1, null);
        if (r68.length() <= 0) goto L132;
        boolean r110 = true;
    L133:
        if (r110 == false) goto L135;
        r26.append(r68);
    L135:
        if (r21 != null) goto L137;
    L144:
        Modifier r27 = r35;
        TextKt.Text-Z58ophY(r26.toAnnotatedString(), r27, n.a(r6, 0).d.c, null, 0, null, null, null, 0, null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, 0, false, 0, 0, r28, null, new TextStyle(0, TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null), r6, (r15 >> 12) & 112, 100663296, 195576);
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventEnd();
    L147:
        r14 = r35;
    L148:
        ScopeUpdateScope r29 = r6.endRestartGroup();
        if (r29 == null) goto L153;
        final Modifier r30 = r14;
        r29.updateScope(new TenantNameWithTagKt$TenantNameWithTag$3(r68, r69, r70, r71, r72, r30, r75, r76));
        return;
    L153:
        return;
    L137:
        if (r68.length() <= 0) goto L139;
        boolean r31 = true;
    L141:
        if (r31 == false) goto L143;
        r26.append(" ");
    L143:
        InlineTextContentKt.appendInlineContent(r26, "tenant_status_tag", " ");
        goto L144
    L139:
        r31 = false;
        goto L141
    L132:
        r110 = false;
        goto L133
    L125:
        r25 = MapsKt.mapOf(TuplesKt.to("tenant_status_tag", new InlineTextContent(new Placeholder(r16.toSp-kPz2Gy4(r21.getMeasuredWidth()), r16.toSp-kPz2Gy4(r21.getMeasuredHeight()), PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc(), null), ComposableLambdaKt.rememberComposableLambda(-1152665884, true, new TenantNameWithTagKt$TenantNameWithTag$inlineContent$1$3(r21), r6, 54))));
        goto L126
    L112:
        r22 = false;
    L107:
        r19 = null;
        goto L108
    L102:
        if (r19 != Composer.Companion.getEmpty()) goto L109;
    L98:
        r18 = false;
        goto L99
    L94:
        r17 = false;
        goto L95
    L90:
        r12 = false;
        goto L91
    L86:
        r0 = false;
    L82:
        r10 = true;
        goto L83
    L72:
        r35 = r14;
        goto L74
    L67:
        if (r6.getSkipping() == false) goto L70;
        r6.skipToGroupEnd();
        goto L148
    L57:
        if ((196608 & r75) != 0) goto L63;
        r14 = r73;
        if (r6.changed(r14) == false) goto L61;
        int r111 = 131072;
    L62:
        r8 = r8 | r111;
        goto L64
    L61:
        r111 = 65536;
        goto L62
    L47:
        if ((r75 & 24576) != 0) goto L53;
        if (r6.changed(r72) == false) goto L51;
        int r32 = 16384;
    L52:
        r8 = r8 | r32;
        goto L53
    L51:
        r32 = 8192;
        goto L52
    L37:
        if ((r75 & 3072) != 0) goto L44;
        if (r6.changed(r71) == false) goto L41;
        int r33 = 2048;
    L42:
        r8 = r8 | r33;
        goto L44
    L41:
        r33 = 1024;
        goto L42
    L27:
        if ((r75 & 384) != 0) goto L34;
        if (r6.changed(r70) == false) goto L31;
        int r34 = 256;
    L32:
        r8 = r8 | r34;
        goto L34
    L31:
        r34 = 128;
        goto L32
    L17:
        if ((r75 & 48) != 0) goto L24;
        if (r6.changed(r69) == false) goto L21;
        int r36 = 32;
    L22:
        r8 = r8 | r36;
        goto L24
    L21:
        r36 = 16;
        goto L22
    L6:
        if ((r75 & 6) == 0) goto L8;
        r8 = r75;
        goto L14
    L8:
        if (r6.changed(r68) == false) goto L10;
        int r37 = 4;
    L11:
        r8 = r37 | r75;
        goto L14
    L10:
        r37 = 2;
        goto L11
    }
}
