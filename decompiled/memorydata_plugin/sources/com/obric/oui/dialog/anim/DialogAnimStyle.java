package com.obric.oui.dialog.anim;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.animation.easy.b;
import com.obric.oui.c.c;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0014\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J0\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001b*\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\rJ:\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001b*\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ+\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H 0\u001b\"\b\b\u0000\u0010 *\u00020\b*\u0002H 2\b\b\u0001\u0010!\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/oui/dialog/anim/DialogAnimStyle;", "", "()V", "TAG", "", "adjustDialogTopSpace", "", "container", "Landroid/view/View;", "decideSpringParams", "Lkotlin/Pair;", "", "useNewDialogAnim", "", "heightLevel", "Lcom/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel;", "isShow", "updateWindowDimWithAnim", "window", "Landroid/view/Window;", "animFraction", "startDim", "endDim", "decideHeightLevel", "screenHeight", "", "dialogBottomHide", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "withDimAnim", "dialogBottomShow", "targetDimAmount", "spring", ExifInterface.GPS_DIRECTION_TRUE, "animId", "(Landroid/view/View;I)Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "HeightLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogAnimStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DialogAnimStyle f13797a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel;", "", "maxRatio", "", "(Ljava/lang/String;IF)V", "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HeightLevel extends Enum<HeightLevel> {
        private static final /* synthetic */ HeightLevel[] $VALUES = null;
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;
        private final float maxRatio;

        private static final /* synthetic */ HeightLevel[] $values() {
            return new HeightLevel[]{SMALL, MEDIUM, LARGE};
        }

        static {
            SMALL = new HeightLevel("SMALL", 0, 0.4f);
            MEDIUM = new HeightLevel("MEDIUM", 1, 0.8f);
            LARGE = new HeightLevel("LARGE", 2, 1.0f);
            $VALUES = $values();
        }

        private HeightLevel(String r1, int r2, float r3) {
            super(r1, r2);
            this.maxRatio = r3;
        }

        public static HeightLevel valueOf(String r2) {
            return (HeightLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(HeightLevel.class, r2), HeightLevel.class, "com.obric.memorydata.plugin");
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HeightLevel[].class, "com.obric.memorydata.plugin");
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13798a = null;

        static {
            int[] r0 = new int[HeightLevel.values().length];
            r0[HeightLevel.SMALL.ordinal()] = 1;
            r0[HeightLevel.MEDIUM.ordinal()] = 2;
            r0[HeightLevel.LARGE.ordinal()] = 3;
            f13798a = r0;
        }
    }

    static {
        f13797a = new DialogAnimStyle();
    }

    private DialogAnimStyle() {
    }

    public static /* synthetic */ b a(DialogAnimStyle r6, View r7, Window r8, boolean r9, float r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r8 = null;
    L5:
        Window r2 = r8;
        if ((r12 & 2) == 0) goto L8;
        boolean r3 = true;
    L10:
        if ((r12 & 4) == 0) goto L12;
        r10 = 0.6f;
    L12:
        float r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        boolean r5 = true;
    L17:
        return r6.a(r7, r2, r3, r4, r5);
    L15:
        r5 = r11;
        goto L17
    L8:
        r3 = r9;
        goto L10
    }

    public static /* synthetic */ b a(DialogAnimStyle r1, View r2, Window r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = true;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r5 = true;
    L12:
        return r1.a(r2, r3, r4, r5);
    }

    private final HeightLevel a(View r1, int r2) {
        if (r2 <= 0) goto L4;
        float r0 = r1.getHeight() / r2;
        if (r0 >= HeightLevel.SMALL.getMaxRatio()) goto L9;
        return HeightLevel.SMALL;
    L9:
        if (r0 >= HeightLevel.MEDIUM.getMaxRatio()) goto L12;
        return HeightLevel.MEDIUM;
    L12:
        return HeightLevel.LARGE;
    L4:
        return HeightLevel.MEDIUM;
    }

    private final Pair<Float, Float> a(boolean r4, HeightLevel r5, boolean r6) {
        Float r3 = Float.valueOf(1.0f);
        if (r4 == true) goto L7;
        return new Pair(r3, Float.valueOf(480.0f));
    L7:
        if (r6 == false) goto L18;
        int r7 = a.f13798a[r5.ordinal()];
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L30;
        if (r7 != 3) goto L15;
        return new Pair(r3, Float.valueOf(247.0f));
    L15:
        throw new NoWhenBranchMatchedException();
    L30:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r8 = a.f13798a[r5.ordinal()];
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L33;
        if (r8 != 3) goto L25;
        return new Pair(r3, Float.valueOf(322.0f));
    L25:
        throw new NoWhenBranchMatchedException();
    L33:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    private final void a(Window r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setDimAmount(r4 + (r6 * RangesKt.coerceIn(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("DialogAnimStyle", Intrinsics.stringPlus("updateWindowDimWithAnim: ", e.getMessage()));
    }

    private static final void a(Window r0, float r1, float r2, float r3, float r4, Ref.BooleanRef r5, b r6, com.obric.oui.animation.a.b r7, float r8, float r9) {
        Intrinsics.checkNotNullParameter(r5, "$isEnd");
        Intrinsics.checkNotNullParameter(r6, "$this_apply");
        f13797a.a(r0, com.obric.oui.c.b.a(r8, r1, r2), r3, r4);
        if (r5.element == false) goto L5;
        return;
    L5:
        if (r8 < r2) goto L9;
        r5.element = true;
        r6.d();
        return;
    }

    private static final void a(Window r0, float r1, float r2, float r3, com.obric.oui.animation.a.b r4, float r5, float r6) {
        f13797a.a(r0, com.obric.oui.c.b.a(r5, r1, r2), 0.0f, r3);
    }

    private final <T extends View> b<T> b(T r3, int r4) {
        c r2 = c.f13403a;
        Object r5 = r3.getTag(r4);
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        b<T> r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L11;
        b<T> r7 = new b(r3);
        r3.setTag(r4, r7);
        return r7;
    L11:
        return r6;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void lambda$Pmf7BWw3gpL8J4Qe9l7NJu920bM(Window r0, float r1, float r2, float r3, float r4, Ref.BooleanRef r5, b r6, com.obric.oui.animation.a.b r7, float r8, float r9) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void lambda$uXdMAvGv57vfw65OdJ0osnBHgEU(Window r0, float r1, float r2, float r3, com.obric.oui.animation.a.b r4, float r5, float r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }

    public final b<View> a(View r7, final Window r8, boolean r9, final float r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Size r0 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        int r2 = r7.getHeight();
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        int r5 = r4.bottomMargin;
    L9:
        final int r6 = (r2 + r5) + h.a(r7, 24);
        r7.setAlpha(1.0f);
        Pair<Float, Float> r12 = a(r11, a(r7, r0.getHeight()), true);
        final float r1 = ((Number) ZeusTransformUtils.preCheckCast(r12.component1(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        final float r13 = ((Number) ZeusTransformUtils.preCheckCast(r12.component2(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        b r14 = b(r7, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, OaidModel.KEY_ID, "o_dialog_anim_in"));
        Function1<? super com.obric.oui.animation.easy.a, Unit> r15 = (Function1) ZeusTransformUtils.preCheckCast(new DialogAnimStyle$dialogBottomShow$1(r1, r13, r6), Function1.class, "com.obric.memorydata.plugin");
        final float r16 = 0.0f;
        b<View> r17 = r14.a(0.0f, r15);
        if (r8 == null) goto L17;
        if (r9 == false) goto L17;
        r8.addFlags(2);     // Catch: Exception -> L15
        final float r18 = r6;
        r17.a(new $$Lambda$DialogAnimStyle$uXdMAvGv57vfw65OdJ0osnBHgEU(r8, r18, r16, r10));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.w("DialogAnimStyle", Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L17:
        return r17;
    L8:
        r5 = 0;
        goto L9
    }

    public final b<View> a(View r11, final Window r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Size r1 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        int r4 = r11.getHeight();
        ViewGroup.LayoutParams r5 = r11.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == true) goto L5;
        r5 = null;
    L5:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L8;
        int r7 = r6.bottomMargin;
    L9:
        int r8 = r4 + r7;
        int r9 = h.a(r11, 24) + r8;
        Pair<Float, Float> r2 = a(r14, a(r11, r1.getHeight()), false);
        final float r10 = ((Number) ZeusTransformUtils.preCheckCast(r2.component1(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        final float r3 = ((Number) ZeusTransformUtils.preCheckCast(r2.component2(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        final b<View> r15 = b(r11, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_out, OaidModel.KEY_ID, "o_dialog_anim_out")).a(r9, (Function1) ZeusTransformUtils.preCheckCast(new DialogAnimStyle$dialogBottomHide$spring$1(r10, r3), Function1.class, "com.obric.memorydata.plugin"));
        if (r12 == null) goto L17;
        if (r13 == false) goto L17;
        r12.addFlags(2);     // Catch: Exception -> L15
        final float r16 = 0.0f;
        final float r17 = r8;
        final float r18 = r12.getAttributes().dimAmount;     // Catch: Exception -> L15
        final float r19 = 0.0f;
        final Ref.BooleanRef r20 = new Ref.BooleanRef();     // Catch: Exception -> L15
        r15.a(new $$Lambda$DialogAnimStyle$Pmf7BWw3gpL8J4Qe9l7NJu920bM(r12, r16, r17, r18, r19, r20, r15));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.w("DialogAnimStyle", Intrinsics.stringPlus("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L17:
        com.obric.oui.animation.style.b.b(r11);
        return r15;
    L8:
        r7 = 0;
        goto L9
    }

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        int r3 = h.a(r4, 10);
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == true) goto L5;
    L7:
        r4.setLayoutParams(r0);
        return;
    L5:
        if (((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin >= r3) goto L7;
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = r3;
        goto L7
    }
}
