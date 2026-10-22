package io.noties.markwon.core.spans;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJR\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0018H\u0016J4\u0010.\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00108\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u001e\u001a\n \u0019*\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \u0019*\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lio/noties/markwon/core/spans/CustomCitationSpan;", "Landroid/text/style/ReplacementSpan;", "Lcom/larus/business/markdown/api/model/ICustomCitationSpan;", "Lio/noties/markwon/movement/IHandlerTouchSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "mTitle", "", "mLink", "linkResolver", "Lio/noties/markwon/LinkResolver;", "handler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;Ljava/lang/String;Lio/noties/markwon/LinkResolver;Lcom/larus/business/markdown/api/citation/ICitationHandler;)V", "completeTouchProgress", "", "dp10", "", "dp26", "dp8", "link", "getLink", "()Ljava/lang/String;", "paint", "Landroid/graphics/Paint;", "kotlin.jvm.PlatformType", "getTheme", "()Lio/noties/markwon/core/MarkwonTheme;", "title", "getTitle", "touchDownAnimator", "Landroid/animation/ValueAnimator;", "touchUpAnimator", "draw", "", "canvas", "Landroid/graphics/Canvas;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "x", "top", "y", "bottom", "pt", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "onClick", "view", "Landroid/view/View;", "onTouchCancel", "widget", "Landroid/widget/TextView;", "onTouchDown", "onTouchUp", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g extends ReplacementSpan implements com.larus.business.markdown.api.model.d, io.noties.markwon.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final io.noties.markwon.d f16467b;
    private final com.larus.business.markdown.api.a.a c;
    private final String d;
    private final String e;
    private final Paint f;
    private final int g;
    private final int h;
    private final int i;
    private float j;
    private final ValueAnimator k;
    private final ValueAnimator l;

    public g(io.noties.markwon.core.c r5, String r6, String r7, io.noties.markwon.d r8, com.larus.business.markdown.api.a.a r9) {
        io.noties.markwon.d r10 = (io.noties.markwon.d) ZeusTransformUtils.wrapperContextForParams(r8, io.noties.markwon.d.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.a.a r11 = (com.larus.business.markdown.api.a.a) ZeusTransformUtils.wrapperContextForParams(r9, com.larus.business.markdown.api.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "theme");
        Intrinsics.checkNotNullParameter(r6, "mTitle");
        Intrinsics.checkNotNullParameter(r7, "mLink");
        Intrinsics.checkNotNullParameter(r10, "linkResolver");
        this.f16466a = r5;
        this.f16467b = r10;
        this.c = r11;
        this.d = r6;
        this.e = r7;
        this.f = n.c();
        this.g = com.larus.business.markdown.impl.common.utils.c.a(ZeusTransformUtils.mapRes(R.dimen.dp_26, "dimen", "dp_26"));
        this.h = com.larus.business.markdown.impl.common.utils.c.a(ZeusTransformUtils.mapRes(R.dimen.dp_10, "dimen", "dp_10"));
        this.i = com.larus.business.markdown.impl.common.utils.c.a(ZeusTransformUtils.mapRes(R.dimen.dp_8, "dimen", "dp_8"));
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.setDuration(60);
        r12.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new CubicBezierInterpolator(0.25f, 1.0f, 0.25f, 1.0f), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        this.k = r12;
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r13.setDuration(60);
        r13.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new CubicBezierInterpolator(0.25f, 1.0f, 0.25f, 1.0f), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        this.l = r13;
    }

    public static final /* synthetic */ Paint a(g r0) {
        return r0.f;
    }

    private static final void a(g r2, TextView r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$widget");
        Intrinsics.checkNotNullParameter(r4, "it");
        Object r5 = r4.getAnimatedValue();
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L5;
        Float r6 = (Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L8;
        float r7 = r6.floatValue();
    L9:
        r2.j = r7;
        r3.invalidate();
        return;
    L8:
        r7 = 0.0f;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    public static final /* synthetic */ int b(g r0) {
        return r0.g;
    }

    private static final void b(g r2, TextView r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$widget");
        Intrinsics.checkNotNullParameter(r4, "it");
        Object r5 = r4.getAnimatedValue();
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L5;
        Float r6 = (Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L8;
        float r7 = r6.floatValue();
    L9:
        r2.j = r7;
        r3.invalidate();
        return;
    L8:
        r7 = 0.0f;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    public static final /* synthetic */ int c(g r0) {
        return r0.h;
    }

    private static final void c(g r2, TextView r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$widget");
        Intrinsics.checkNotNullParameter(r4, "it");
        Object r5 = r4.getAnimatedValue();
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L5;
        Float r6 = (Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L8;
        float r7 = r6.floatValue();
    L9:
        r2.j = r7;
        r3.invalidate();
        return;
    L8:
        r7 = 0.0f;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$9bWcvNMmTN2KfpIk-KOtom72drA, reason: not valid java name */
    public static /* synthetic */ void m1415lambda$9bWcvNMmTN2KfpIkKOtom72drA(g r0, TextView r1, ValueAnimator r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$E0nAzHKEHf5-v9hm_ktHWlToiMI, reason: not valid java name */
    public static /* synthetic */ void m1416lambda$E0nAzHKEHf5v9hm_ktHWlToiMI(g r0, TextView r1, ValueAnimator r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$NA0KXonfHigE7rYzFB3f3Wgb7LI(g r0, TextView r1, ValueAnimator r2) {
        c(r0, r1, r2);
    }

    public final io.noties.markwon.core.c a() {
        return this.f16466a;
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.f16467b.resolve(r2, c());
    }

    @Override // io.noties.markwon.c.a
    public void a(final TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        this.k.cancel();
        this.k.removeAllUpdateListeners();
        this.k.addUpdateListener(new $$Lambda$g$9bWcvNMmTN2KfpIkKOtom72drA(this, r3));
        this.k.start();
    }

    public String b() {
        return this.d;
    }

    @Override // io.noties.markwon.c.a
    public void b(final TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        this.k.end();
        this.l.cancel();
        this.l.removeAllUpdateListeners();
        this.l.addUpdateListener(new $$Lambda$g$E0nAzHKEHf5v9hm_ktHWlToiMI(this, r3));
        this.l.start();
    }

    public String c() {
        return this.e;
    }

    @Override // io.noties.markwon.c.a
    public void c(final TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        this.k.end();
        this.l.cancel();
        this.l.removeAllUpdateListeners();
        this.l.addUpdateListener(new $$Lambda$g$NA0KXonfHigE7rYzFB3f3Wgb7LI(this, r3));
        this.l.start();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(final Canvas r17, CharSequence r18, int r19, int r20, final float r21, int r22, final int r23, int r24, Paint r25) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r18, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "canvas");
        Intrinsics.checkNotNullParameter(r25, "pt");
        this.f.set(r25);
        Unit r5 = null;
        if (ZeusTransformUtils.instanceOf(r2, SpannableString.class) == false) goto L5;
        SpannableString r4 = (SpannableString) ZeusTransformUtils.preCheckCast(r2, SpannableString.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L13;
        m[] r6 = (m[]) ZeusTransformUtils.preCheckCast(r4.getSpans(r19, r20, m.class), m[].class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        m r7 = (m) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r6), m.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        Integer r8 = Integer.valueOf(r7.a());
    L14:
        if (r8 == null) goto L16;
        this.f.setAlpha(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
    L16:
        Function0 r14 = (Function0) ZeusTransformUtils.preCheckCast(new CustomCitationSpan$draw$defaultHandler$1(this, r17, r21, r23), Function0.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.a.a r3 = this.c;
        if (r3 == null) goto L19;
        Paint r11 = this.f;
        Intrinsics.checkNotNullExpressionValue(r11, "paint");
        r3.a(r17, r2, r19, r20, r21, r22, r23, r24, r25, r11, this.f16466a, new com.larus.business.markdown.api.a.a.C0214a.C0215a(b(), c()), this.j);
        r5 = Unit.INSTANCE;
    L19:
        if (r5 != null) goto L22;
        r14.invoke();
        return;
    L22:
        return;
    L13:
        r8 = null;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r8, CharSequence r9, int r10, int r11, Paint.FontMetricsInt r12) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "paint");
        com.larus.business.markdown.api.a.a r0 = this.c;
        if (r0 == null) goto L6;
        return r0.a(r8, r2, r10, r11, r12, new com.larus.business.markdown.api.a.a.C0214a.C0215a(b(), c()));
    L6:
        return this.g;
    }
}
