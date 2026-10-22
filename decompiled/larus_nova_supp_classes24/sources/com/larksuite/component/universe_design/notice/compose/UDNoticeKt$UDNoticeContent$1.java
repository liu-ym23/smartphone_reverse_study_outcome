package com.larksuite.component.universe_design.notice.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDNoticeKt$UDNoticeContent$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ UDNoticeGravity $gravity;
    final /* synthetic */ ImageVector $icon;
    final /* synthetic */ ImageVector $iconButton;
    final /* synthetic */ long $iconButtonColor;
    final /* synthetic */ String $iconButtonContentDescription;
    final /* synthetic */ Painter $iconButtonPainter;
    final /* synthetic */ long $iconColor;
    final /* synthetic */ boolean $iconColorful;
    final /* synthetic */ Painter $iconPainter;
    final /* synthetic */ Function0<Unit> $onIconButtonClick;
    final /* synthetic */ Function1<String, Unit> $onTextActionClick;
    final /* synthetic */ float $radius;
    final /* synthetic */ boolean $shouldMarquee;
    final /* synthetic */ AnnotatedString $styledText;
    final /* synthetic */ AnnotatedString $text;
    final /* synthetic */ int $textAlign;
    final /* synthetic */ a $textButton;
    final /* synthetic */ long $textButtonColor;
    final /* synthetic */ UDNoticeTextButtonPosition $textButtonPosition;
    final /* synthetic */ long $textColor;
    final /* synthetic */ TextStyle $textStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public UDNoticeKt$UDNoticeContent$1(a r4, AnnotatedString r5, UDNoticeTextButtonPosition r6, float r7, long r8, UDNoticeGravity r10, ImageVector r11, Painter r12, long r13, boolean r15, AnnotatedString r16, long r17, TextStyle r19, int r20, boolean r21, Function1<? super String, Unit> r22, long r23, ImageVector r25, Painter r26, long r27, String r29, Function0<Unit> r30) {
        this.$text = r5;
        this.$textButtonPosition = r6;
        this.$radius = r7;
        this.$backgroundColor = r8;
        this.$gravity = r10;
        this.$icon = r11;
        this.$iconPainter = r12;
        this.$iconColor = r13;
        this.$iconColorful = r15;
        this.$styledText = r16;
        this.$textColor = r17;
        this.$textStyle = r19;
        this.$textAlign = r20;
        this.$shouldMarquee = r21;
        this.$onTextActionClick = r22;
        this.$textButtonColor = r23;
        this.$iconButton = r25;
        this.$iconButtonPainter = r26;
        this.$iconButtonColor = r27;
        this.$iconButtonContentDescription = r29;
        this.$onIconButtonClick = r30;
        super(3);
    }

    public static final void access$invoke$lambda$2(MutableState r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    public final void invoke(BoxWithConstraintsScope r34, Composer r35, int r36) {
        Intrinsics.checkNotNullParameter(r34, "$this$BoxWithConstraints");
        if ((r36 & 6) == 0) goto L5;
        int r2 = r36;
    L11:
        if ((r2 & 19) != 18) goto L17;
        if (r35.getSkipping() == false) goto L17;
        r35.skipToGroupEnd();
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1477363122, r2, -1, "com.larksuite.component.universe_design.notice.compose.UDNoticeContent.<anonymous> (UDNotice.kt:229)");
    L19:
        float r1 = r34.getMaxWidth-D9Ej5fM();
        r35.startReplaceGroup(-1224400529);
        boolean r3 = (r35.changed(this.$text) | r35.changed(null)) | r35.changed(this.$textButtonPosition.ordinal());
        boolean r4 = r35.changed(r1) | r3;
        Object r5 = r35.rememberedValue();
        if (r4 == false) goto L22;
    L23:
        r5 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r35.updateRememberedValue(r5);
    L24:
        final MutableState r8 = (MutableState) r5;
        r35.endReplaceGroup();
        UDNoticeTextButtonPosition r9 = UDNoticeTextButtonPosition.Right;
        Modifier.Companion r12 = Modifier.Companion;
        Modifier r6 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.defaultMinSize-VpY3zN4$default(SizeKt.fillMaxWidth$default(r12, 0.0f, 1, null), 0.0f, d.a, 1, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(this.$radius)), this.$backgroundColor, null, 2, null), d.b, 0.0f, 2, null);
        if (this.$gravity != UDNoticeGravity.Center) goto L27;
        Arrangement.HorizontalOrVertical r7 = Arrangement.INSTANCE.getCenter();
    L28:
        Alignment.Companion r11 = Alignment.Companion;
        Alignment.Vertical r10 = r11.getTop();
        ImageVector r13 = this.$icon;
        Painter r14 = this.$iconPainter;
        long r15 = this.$iconColor;
        boolean r16 = this.$iconColorful;
        UDNoticeGravity r17 = this.$gravity;
        AnnotatedString r19 = this.$styledText;
        long r110 = this.$textColor;
        TextStyle r20 = this.$textStyle;
        int r21 = this.$textAlign;
        boolean r22 = this.$shouldMarquee;
        final UDNoticeTextButtonPosition r23 = this.$textButtonPosition;
        Function1<String, Unit> r24 = this.$onTextActionClick;
        ImageVector r25 = this.$iconButton;
        Painter r26 = this.$iconButtonPainter;
        long r111 = this.$iconButtonColor;
        String r112 = this.$iconButtonContentDescription;
        Function0<Unit> r113 = this.$onIconButtonClick;
        MeasurePolicy r0 = RowKt.rowMeasurePolicy(r7, r10, r35, 48);
        long r114 = ComposablesKt.getCurrentCompositeKeyHashCode(r35, 0);
        int r27 = (int) (r114 ^ (r114 >>> 32));
        CompositionLocalMap r29 = r35.getCurrentCompositionLocalMap();
        Modifier r30 = ComposedModifierKt.materializeModifier(r35, r6);
        ComposeUiNode.Companion r115 = ComposeUiNode.Companion;
        Function0 r31 = r115.getConstructor();
        if ((r35.getApplier() instanceof Applier) == true) goto L31;
        ComposablesKt.invalidApplier();
    L31:
        r35.startReusableNode();
        if (r35.getInserting() == false) goto L34;
        r35.createNode(r31);
    L35:
        Composer r32 = Updater.constructor-impl(r35);
        Updater.set-impl(r32, r0, r115.getSetMeasurePolicy());
        Updater.set-impl(r32, r29, r115.getSetResolvedCompositionLocals());
        Function2 r33 = r115.getSetCompositeKeyHash();
        if (r32.getInserting() == false) goto L38;
    L39:
        r32.updateRememberedValue(Integer.valueOf(r27));
        r32.apply(Integer.valueOf(r27), r33);
    L40:
        Updater.set-impl(r32, r30, r115.getSetModifier());
        RowScopeInstance r37 = RowScopeInstance.INSTANCE;
        r35.startReplaceGroup(2089407544);
        if (r13 != null) goto L45;
        if (r14 != null) goto L45;
        int r116 = 0;
    L46:
        r35.endReplaceGroup();
        if (r9 != UDNoticeTextButtonPosition.Bottom) goto L68;
        r35.startReplaceGroup(347446144);
        if (r17 != UDNoticeGravity.Left) goto L51;
        boolean r38 = true;
    L52:
        Modifier r39 = PaddingKt.padding-qDBjuR0$default(r37.weight(r12, 1.0f, r38), 0.0f, 0.0f, 0.0f, d.f, 7, null);
        MeasurePolicy r40 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r11.getStart(), r35, r116);
        long r41 = ComposablesKt.getCurrentCompositeKeyHashCode(r35, r116);
        int r42 = (int) (r41 ^ (r41 >>> 32));
        CompositionLocalMap r43 = r35.getCurrentCompositionLocalMap();
        Modifier r44 = ComposedModifierKt.materializeModifier(r35, r39);
        Function0 r45 = r115.getConstructor();
        if ((r35.getApplier() instanceof Applier) == true) goto L55;
        ComposablesKt.invalidApplier();
    L55:
        r35.startReusableNode();
        if (r35.getInserting() == false) goto L58;
        r35.createNode(r45);
    L59:
        Composer r46 = Updater.constructor-impl(r35);
        Updater.set-impl(r46, r40, r115.getSetMeasurePolicy());
        Updater.set-impl(r46, r43, r115.getSetResolvedCompositionLocals());
        Function2 r47 = r115.getSetCompositeKeyHash();
        if (r46.getInserting() == false) goto L62;
    L63:
        r46.updateRememberedValue(Integer.valueOf(r42));
        r46.apply(Integer.valueOf(r42), r47);
    L64:
        Updater.set-impl(r46, r44, r115.getSetModifier());
        ColumnScopeInstance r48 = ColumnScopeInstance.INSTANCE;
        r35.startReplaceGroup(1849434622);
        Object r49 = r35.rememberedValue();
        if (r49 != Composer.Companion.getEmpty()) goto L67;
        r49 = UDNoticeKt$UDNoticeContent$1$1$1$1$1.INSTANCE;
        r35.updateRememberedValue(r49);
    L67:
        r35.endReplaceGroup();
        int r117 = 6;
        d.d(r19, r110, r20, r21, false, (Function1) r49, r24, PaddingKt.padding-qDBjuR0$default(r12, 0.0f, d.e, 0.0f, 0.0f, 13, null), r35, 12804096, 0);
        r35.startReplaceGroup(-519252652);
        r35.endReplaceGroup();
        r35.endNode();
        r35.endReplaceGroup();
    L78:
        r35.startReplaceGroup(2089484777);
        if (r25 != 0) goto L81;
        if (r26 != null) goto L81;
    L82:
        r35.endReplaceGroup();
        r35.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventEnd();
        return;
    L87:
        return;
    L81:
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r12, d.i), r35, r117);
        d.c(r25, r31, r111, r112, r113, r35, 0);
        goto L82
    L62:
        if (Intrinsics.areEqual(r46.rememberedValue(), Integer.valueOf(r42)) == true) goto L64;
    L58:
        r35.useNode();
        goto L59
    L51:
        r38 = false;
        goto L52
    L68:
        r35.startReplaceGroup(348510126);
        if (r17 != UDNoticeGravity.Left) goto L71;
        boolean r118 = true;
    L72:
        Modifier r50 = PaddingKt.padding-qDBjuR0$default(r37.weight(r12, 1.0f, r118), 0.0f, d.e, 0.0f, d.f, 5, null);
        r35.startReplaceGroup(-1633490746);
        boolean r51 = r35.changed(r23.ordinal()) | r35.changed(r8);
        Object r52 = r35.rememberedValue();
        if (r51 == false) goto L75;
    L76:
        r52 = new UDNoticeKt$UDNoticeContent$1$1$2$1(r23, r8);
        r35.updateRememberedValue(r52);
    L77:
        r35.endReplaceGroup();
        r117 = 6;
        d.d(r19, r110, r20, r21, r22, (Function1) r52, r24, r50, r35, 0, 0);
        r35.endReplaceGroup();
        goto L78
    L75:
        if (r52 != Composer.Companion.getEmpty()) goto L77;
    L71:
        r118 = false;
    L45:
        r116 = 0;
        d.b(r13, r14, r15, r16, r35, 0);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r12, d.h), r35, 6);
        goto L46
    L38:
        if (Intrinsics.areEqual(r32.rememberedValue(), Integer.valueOf(r27)) == true) goto L40;
    L34:
        r35.useNode();
        goto L35
    L27:
        r7 = Arrangement.INSTANCE.getStart();
        goto L28
    L22:
        if (r5 != Composer.Companion.getEmpty()) goto L24;
    L5:
        if (r35.changed(r34) == false) goto L7;
        int r53 = 4;
    L8:
        r2 = r36 | r53;
        goto L11
    L7:
        r53 = 2;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((BoxWithConstraintsScope) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
