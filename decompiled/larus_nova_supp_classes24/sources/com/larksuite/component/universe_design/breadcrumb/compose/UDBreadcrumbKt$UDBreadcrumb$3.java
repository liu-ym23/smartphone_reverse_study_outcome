package com.larksuite.component.universe_design.breadcrumb.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.larksuite.component.universe_design.compose.foundation.g0;
import com.larksuite.component.universe_design.compose.foundation.i0;
import com.larksuite.component.universe_design.compose.foundation.n;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDBreadcrumbKt$UDBreadcrumb$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ a $colors;
    final /* synthetic */ float $itemMaxWidth;
    final /* synthetic */ List<String> $items;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Integer, Unit> $onItemClick;
    final /* synthetic */ LazyListState $state;

    /* JADX WARN: Multi-variable type inference failed */
    public UDBreadcrumbKt$UDBreadcrumb$3(List<String> r1, Modifier r2, float r3, a r4, Function1<? super Integer, Unit> r5, LazyListState r6, int r7, int r8) {
        this.$items = r1;
        this.$modifier = r2;
        this.$itemMaxWidth = r3;
        this.$colors = r4;
        this.$onItemClick = r5;
        this.$state = r6;
        this.$$changed = r7;
        this.$$default = r8;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r40, int r41) {
        final List<String> r2 = this.$items;
        Modifier r1 = this.$modifier;
        final float r3 = this.$itemMaxWidth;
        final a r4 = this.$colors;
        final Function1<Integer, Unit> r5 = this.$onItemClick;
        LazyListState r6 = this.$state;
        int r9 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r10 = this.$$default;
        Intrinsics.checkNotNullParameter(r2, "items");
        Composer r15 = r40.startRestartGroup(631621774);
        if ((r10 & 1) == 0) goto L6;
        int r11 = r9 | 6;
    L13:
        int r13 = r10 & 2;
        if (r13 == 0) goto L17;
        r11 = r11 | 48;
    L23:
        int r14 = r10 & 4;
        if (r14 == 0) goto L27;
        r11 = r11 | 384;
    L33:
        int r8 = r11;
    L35:
        if ((r9 & 3072) == 0) goto L37;
    L43:
        int r12 = r10 & 16;
        if (r12 == 0) goto L47;
        r8 = r8 | 24576;
    L54:
        if ((r9 & 196608) != 0) goto L63;
        if ((r10 & 32) == 0) goto L58;
    L60:
        int r19 = 65536;
    L61:
        r8 = r8 | r19;
        goto L63
    L58:
        if (r15.changed(r6) == false) goto L60;
        r19 = 131072;
    L63:
        if ((r8 & 74899) == 74898) goto L65;
    L69:
        r15.startDefaults();
        if ((r9 & 1) != 0) goto L72;
    L80:
        if (r13 == 0) goto L82;
        r1 = Modifier.Companion;
    L82:
        if (r14 == 0) goto L85;
        r3 = b.a;
    L85:
        if ((r10 & 8) == 0) goto L94;
        float r7 = b.a;
        r15.startReplaceGroup(-1547679077);
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(-1547679077, 6, -1, "com.larksuite.component.universe_design.breadcrumb.compose.UDBreadcrumbDefaults.colors (UDBreadcrumb.kt:67)");
    L89:
        g0 r16 = i0.a(r15);
        long r26 = r16.a();
        long r17 = r16.d.f.b;
        long r0 = r16.a.d.h;
        n r20 = r16.b.a;
        a r21 = new a(r26, r17, r0, r20.b, r20.a);
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventEnd();
    L92:
        r15.endReplaceGroup();
        r8 = r8 & (-7169);
        r4 = r21;
    L94:
        if (r12 == 0) goto L96;
        r5 = null;
    L98:
        if ((r10 & 32) == 0) goto L100;
        r6 = LazyListStateKt.rememberLazyListState(0, 0, r15, 0, 3);
        r8 = r8 & (-458753);
    L101:
        r3 = r3;
    L102:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventStart(631621774, r8, -1, "com.larksuite.component.universe_design.breadcrumb.compose.UDBreadcrumb (UDBreadcrumb.kt:87)");
    L105:
        List r22 = CollectionsKt.toList(r2);
        r15.startReplaceGroup(1849434622);
        Object r23 = r15.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r23 != r110.getEmpty()) goto L108;
        r23 = SnapshotStateKt.mutableStateOf$default(r22, null, 2, null);
        r15.updateRememberedValue(r23);
    L108:
        MutableState r24 = (MutableState) r23;
        r15.endReplaceGroup();
        r15.startReplaceGroup(-1746271574);
        boolean r111 = r15.changedInstance(r22);
        if (((458752 & r8) ^ 196608) <= 131072) goto L113;
        if (r15.changed(r6) == false) goto L113;
    L114:
        boolean r112 = true;
    L116:
        boolean r113 = r111 | r112;
        Object r114 = r15.rememberedValue();
        if (r113 == false) goto L119;
    L122:
        Object r115 = null;
        r114 = new UDBreadcrumbKt$UDBreadcrumb$1$1(r22, r6, r24, null);
        r15.updateRememberedValue(r114);
    L123:
        r15.endReplaceGroup();
        EffectsKt.LaunchedEffect(r22, (Function2) r114, r15, 0);
        Modifier r25 = SizeKt.height-3ABfNKs(r1, b.c);
        PaddingValues r116 = PaddingKt.PaddingValues-YgX7TsA$default(b.b, 0.0f, 2, r115);
        Alignment.Vertical r117 = Alignment.Companion.getCenterVertically();
        r15.startReplaceGroup(-1224400529);
        boolean r118 = r15.changedInstance(r2);
        if (((r8 & 7168) ^ 3072) <= 2048) goto L128;
        if (r15.changed(r4) == false) goto L128;
    L129:
        boolean r27 = true;
    L131:
        boolean r29 = r27 | r118;
        if ((r8 & 896) != 256) goto L134;
        boolean r119 = true;
    L135:
        boolean r30 = r29 | r119;
        if ((57344 & r8) != 16384) goto L138;
        boolean r210 = true;
    L139:
        boolean r31 = r30 | r210;
        Object r120 = r15.rememberedValue();
        if (r31 == false) goto L142;
    L143:
        r120 = new UDBreadcrumbKt$UDBreadcrumb$2$1(r2, r4, r3, r5);
        r15.updateRememberedValue(r120);
    L144:
        r15.endReplaceGroup();
        LazyListState r121 = r6;
        Composer r32 = r15;
        LazyDslKt.LazyRow(r25, r121, r116, false, null, r117, null, false, null, (Function1) r120, r32, ((r8 >> 12) & 112) | 196992, 472);
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventEnd();
    L147:
        LazyListState r33 = r6;
    L68:
        Function1<Integer, Unit> r34 = r5;
        a r35 = r4;
        float r36 = r3;
        Modifier r37 = r1;
        ScopeUpdateScope r38 = r32.endRestartGroup();
        if (r38 == null) goto L152;
        r38.updateScope(new UDBreadcrumbKt$UDBreadcrumb$3(r2, r37, r36, r35, r34, r33, r9, r10));
        return;
    L152:
        return;
    L142:
        if (r120 != r110.getEmpty()) goto L144;
    L138:
        r210 = false;
        goto L139
    L134:
        r119 = false;
    L128:
        if ((r8 & 3072) == 2048) goto L129;
        r27 = false;
        goto L131
    L119:
        if (r114 == r110.getEmpty()) goto L122;
        r115 = null;
    L113:
        if ((196608 & r8) == 131072) goto L114;
        r112 = false;
        goto L116
    L100:
        r6 = r6;
        goto L101
    L96:
        r5 = r5;
        goto L98
    L72:
        if (r15.getDefaultsInvalid() == true) goto L80;
        r15.skipToGroupEnd();
        if ((r10 & 8) == 0) goto L78;
        r8 = r8 & (-7169);
    L78:
        if ((r10 & 32) == 0) goto L102;
        r8 = r8 & (-458753);
        goto L102
    L65:
        if (r15.getSkipping() == false) goto L69;
        r15.skipToGroupEnd();
        r33 = r6;
        r32 = r15;
        goto L68
    L47:
        if ((r9 & 24576) != 0) goto L54;
        if (r15.changedInstance(r5) == false) goto L51;
        int r122 = 16384;
    L52:
        r8 = r8 | r122;
        goto L54
    L51:
        r122 = 8192;
        goto L52
    L37:
        if ((r10 & 8) == 0) goto L39;
    L41:
        int r123 = 1024;
    L42:
        r8 = r8 | r123;
        goto L43
    L39:
        if (r15.changed(r4) == false) goto L41;
        r123 = 2048;
        goto L42
    L27:
        if ((r9 & 384) != 0) goto L33;
        if (r15.changed(r3) == false) goto L31;
        int r39 = 256;
    L32:
        r8 = r39 | r11;
        goto L35
    L31:
        r39 = 128;
        goto L32
    L17:
        if ((r9 & 48) != 0) goto L23;
        if (r15.changed(r1) == false) goto L21;
        int r124 = 32;
    L22:
        r11 = r11 | r124;
        goto L23
    L21:
        r124 = 16;
        goto L22
    L6:
        if ((r9 & 6) == 0) goto L8;
        r11 = r9;
        goto L13
    L8:
        if (r15.changedInstance(r2) == false) goto L10;
        int r125 = 4;
    L11:
        r11 = r125 | r9;
        goto L13
    L10:
        r125 = 2;
        goto L11
    }
}
