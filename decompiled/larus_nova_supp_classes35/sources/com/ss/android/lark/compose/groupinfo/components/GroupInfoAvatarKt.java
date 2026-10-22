package com.ss.android.lark.compose.groupinfo.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.compose.util.e;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.b;
import com.ss.android.lark.image.compose.common.CachePolicy;
import com.ss.android.lark.image.compose.common.ImageFormat;
import com.ss.android.lark.image.compose.common.avatar.AvatarImageComponentKt;
import com.ss.android.lark.image.compose.common.url.URLImageComponentKt;
import com.ss.android.lark.image.compose.common.url.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupInfoAvatarKt {
    public static final void b(Modifier r31, final Function0<Unit> r32, Composer r33, final int r34, final int r35) {
        Intrinsics.checkNotNullParameter(r32, "onClick");
        Composer r14 = r33.startRestartGroup(420569067);
        int r4 = r35 & 1;
        if (r4 == 0) goto L6;
        int r6 = r34 | 6;
        final Modifier r5 = r31;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L24:
        if ((r6 & 19) == 18) goto L26;
    L29:
        if (r4 == 0) goto L31;
        Modifier r30 = Modifier.Companion;
    L33:
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventStart(420569067, r6, -1, "com.ss.android.lark.compose.groupinfo.components.ChangeAvatarButton (GroupInfoAvatar.kt:81)");
    L35:
        Modifier r7 = e.a(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r30, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, null), Dp.constructor-impl(96)), Dp.constructor-impl(36)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(18))), n.a(r14, 0).c.c, null, 2, null), r32, r14, (r6 << 12) & 458752);
        MeasurePolicy r8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r9 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r10 = (int) (r9 ^ (r9 >>> 32));
        CompositionLocalMap r11 = r14.getCurrentCompositionLocalMap();
        Modifier r12 = ComposedModifierKt.materializeModifier(r14, r7);
        ComposeUiNode.Companion r13 = ComposeUiNode.Companion;
        Function0 r15 = r13.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L38;
        ComposablesKt.invalidApplier();
    L38:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L41;
        r14.createNode(r15);
    L42:
        Composer r16 = Updater.constructor-impl(r14);
        Updater.set-impl(r16, r8, r13.getSetMeasurePolicy());
        Updater.set-impl(r16, r11, r13.getSetResolvedCompositionLocals());
        Function2 r17 = r13.getSetCompositeKeyHash();
        if (r16.getInserting() == false) goto L45;
    L46:
        r16.updateRememberedValue(Integer.valueOf(r10));
        r16.apply(Integer.valueOf(r10), r17);
    L47:
        Updater.set-impl(r16, r12, r13.getSetModifier());
        BoxScopeInstance r18 = BoxScopeInstance.INSTANCE;
        Intrinsics.checkNotNullParameter(b.a, "<this>");
        String r19 = b0.a((z) CommonMainString0.I.getValue(), r14);
        long r20 = TextUnitKt.getSp(14);
        FontWeight r110 = FontWeight.Companion.getMedium();
        Composer r3 = r14;
        TextKt.Text-Nvy7gAk(r19, null, n.a(r14, 0).d.a, null, r20, null, r110, null, 0, null, null, 0, 0, false, 0, 0, null, null, r3, 1597440, 0, 262058);
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L50;
        ComposerKt.traceEventEnd();
    L50:
        r5 = r30;
    L51:
        ScopeUpdateScope r21 = r3.endRestartGroup();
        if (r21 == null) goto L55;
        r21.updateScope(new GroupInfoAvatarKt$ChangeAvatarButton$2(r5, r32, r34, r35));
        return;
    L55:
        return;
    L45:
        if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r10)) == true) goto L47;
    L41:
        r14.useNode();
        goto L42
    L31:
        r30 = r5;
        goto L33
    L26:
        if (r14.getSkipping() == false) goto L29;
        r14.skipToGroupEnd();
        r3 = r14;
        goto L51
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r14.changedInstance(r32) == false) goto L21;
        int r22 = 32;
    L22:
        r6 = r6 | r22;
        goto L24
    L21:
        r22 = 16;
        goto L22
    L6:
        if ((r34 & 6) != 0) goto L12;
        r5 = r31;
        if (r14.changed(r5) == false) goto L10;
        int r23 = 4;
    L11:
        r6 = r23 | r34;
        goto L14
    L10:
        r23 = 2;
        goto L11
    L12:
        r5 = r31;
        r6 = r34;
        goto L14
    }

    public static final void a(final String r28, final String r29, final String r30, final d r31, final long r32, Modifier r34, Composer r35, final int r36, final int r37) {
        Intrinsics.checkNotNullParameter(r28, "avatarKey");
        Intrinsics.checkNotNullParameter(r29, "selectedAvatarPath");
        Intrinsics.checkNotNullParameter(r30, "chatId");
        Intrinsics.checkNotNullParameter(r31, "rustClient");
        Composer r9 = r35.startRestartGroup(-965990709);
        if ((r37 & 1) == 0) goto L6;
        int r3 = r36 | 6;
    L14:
        if ((r37 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r37 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L34:
        if ((r37 & 16) == 0) goto L37;
        r3 = r3 | 24576;
    L43:
        int r4 = r37 & 32;
        if (r4 == 0) goto L47;
        r3 = r3 | 196608;
    L53:
        final Modifier r7 = r34;
    L54:
        int r12 = r3;
        if ((73875 & r12) == 73874) goto L57;
    L60:
        if (r4 == 0) goto L62;
        Modifier r27 = Modifier.Companion;
    L64:
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventStart(-965990709, r12, -1, "com.ss.android.lark.compose.groupinfo.components.AvatarSection (GroupInfoAvatar.kt:42)");
    L66:
        a r2 = URLImageComponentKt.b(r9);
        Long r5 = Long.valueOf(r32);
        r9.startReplaceGroup(-1633490746);
        boolean r8 = true;
        if ((57344 & r12) != 16384) goto L69;
        boolean r6 = true;
    L70:
        boolean r10 = r6 | r9.changedInstance(r2);
        Object r11 = r9.rememberedValue();
        if (r10 == false) goto L73;
    L74:
        r11 = new GroupInfoAvatarKt$AvatarSection$1$1(r32, r2, null);
        r9.updateRememberedValue(r11);
    L75:
        r9.endReplaceGroup();
        EffectsKt.LaunchedEffect(r5, (Function2) r11, r9, (r12 >> 12) & 14);
        if (r29.length() == 0) goto L80;
        r8 = false;
    L80:
        if (r8 == false) goto L82;
        r9.startReplaceGroup(-1547909528);
        float r13 = 100;
        AvatarImageComponentKt.a(new com.ss.android.lark.image.compose.common.avatar.a(r28, r30, Dp.constructor-impl(r13), ImageFormat.WEBP), ClipKt.clip(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r27, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, null), Dp.constructor-impl(r13)), RoundedCornerShapeKt.getCircleShape()), null, null, null, null, null, null, r9, 224640, 192);
        r9.endReplaceGroup();
        Composer r19 = r9;
    L84:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventEnd();
    L86:
        r7 = r27;
    L87:
        ScopeUpdateScope r14 = r19.endRestartGroup();
        if (r14 == null) goto L91;
        r14.updateScope(new GroupInfoAvatarKt$AvatarSection$2(r28, r29, r30, r31, r32, r7, r36, r37));
        return;
    L91:
        return;
    L82:
        r9.startReplaceGroup(-1547444497);
        Modifier r15 = ClipKt.clip(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r27, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, null), Dp.constructor-impl(100)), RoundedCornerShapeKt.getCircleShape());
        long r16 = Float.floatToRawIntBits(200.0f);
        tkb.b r17 = new tkb.b(Size.constructor-impl((((long) Float.floatToRawIntBits(200.0f)) & 4294967295L) | (r16 << 32)));
        CachePolicy r0 = CachePolicy.Disabled;
        r19 = r9;
        URLImageComponentKt.a(r29, r15, r17, null, null, null, null, null, r2, r0, r0, null, null, r19, ((((r12 >> 3) & 14) | 819683328) | 0) | 0, 6, 6152);
        r19.endReplaceGroup();
        goto L84
    L73:
        if (r11 != Composer.Companion.getEmpty()) goto L75;
    L69:
        r6 = false;
        goto L70
    L62:
        r27 = r7;
        goto L64
    L57:
        if (r9.getSkipping() == false) goto L60;
        r9.skipToGroupEnd();
        r19 = r9;
        goto L87
    L47:
        if ((196608 & r36) != 0) goto L53;
        r7 = r34;
        if (r9.changed(r7) == false) goto L51;
        int r18 = 131072;
    L52:
        r3 = r3 | r18;
        goto L54
    L51:
        r18 = 65536;
        goto L52
    L37:
        if ((r36 & 24576) != 0) goto L43;
        if (r9.changed(r32) == false) goto L41;
        int r20 = 16384;
    L42:
        r3 = r3 | r20;
        goto L43
    L41:
        r20 = 8192;
        goto L42
    L27:
        if ((r36 & 384) != 0) goto L34;
        if (r9.changed(r30) == false) goto L31;
        int r21 = 256;
    L32:
        r3 = r3 | r21;
        goto L34
    L31:
        r21 = 128;
        goto L32
    L17:
        if ((r36 & 48) != 0) goto L24;
        if (r9.changed(r29) == false) goto L21;
        int r22 = 32;
    L22:
        r3 = r3 | r22;
        goto L24
    L21:
        r22 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r3 = r36;
        goto L14
    L8:
        if (r9.changed(r28) == false) goto L10;
        int r23 = 4;
    L11:
        r3 = r23 | r36;
        goto L14
    L10:
        r23 = 2;
        goto L11
    }
}
