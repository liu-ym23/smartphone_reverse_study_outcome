package com.obric.audio.enroll.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0014R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0012R\u001b\u0010\u001e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/obric/audio/enroll/view/VoiceFrequencyView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "barGap", "getBarGap", "()I", "barGap$delegate", "Lkotlin/Lazy;", "barWidth", "getBarWidth", "barWidth$delegate", "maxHeight", "getMaxHeight", "maxHeight$delegate", "minHeight", "getMinHeight", "minHeight$delegate", "halfHeight", "getHalfHeight", "halfHeight$delegate", "painter", "Landroid/graphics/Paint;", "getPainter", "()Landroid/graphics/Paint;", "painter$delegate", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceFrequencyView extends LinearLayout {
    public static final /* synthetic */ int h = 0;
    public final ArrayList<Float> a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    private final int getBarGap() {
        return ((Number) this.b.getValue()).intValue();
    }

    private final int getBarWidth() {
        return ((Number) this.c.getValue()).intValue();
    }

    private final int getHalfHeight() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final int getMaxHeight() {
        return ((Number) this.d.getValue()).intValue();
    }

    private final int getMinHeight() {
        return ((Number) this.e.getValue()).intValue();
    }

    private final Paint getPainter() {
        return (Paint) this.g.getValue();
    }

    public VoiceFrequencyView(Context r2) {
        this(r2, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        if (this.a.size() == 34) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= 35) goto L17;
        if (r12 == null) goto L10;
        r12.save();
    L10:
        if (r12 == null) goto L12;
        r12.translate((r0 * 2) * getBarGap(), getHalfHeight());
    L12:
        if (r12 == null) goto L14;
        float r2 = 2;
        r12.drawRoundRect(0.0f, ((-1) * ((Number) ListProtector.get(this.a, r0)).floatValue()) / r2, getBarWidth(), (1 * ((Number) ListProtector.get(this.a, r0)).floatValue()) / r2, getBarWidth() / 2.0f, getBarWidth() / 2.0f, getPainter());
    L14:
        if (r12 == null) goto L16;
        r12.restore();
    L16:
        r0 = r0 + 1;
        goto L7
    }

    public VoiceFrequencyView(final Context r2, AttributeSet r3) {
        super(r2, r3);
        this.a = new ArrayList(34);
        this.b = LazyKt.lazy(new z(r2));
        this.c = LazyKt.lazy(new a0(r2));
        this.d = LazyKt.lazy(new b0(r2));
        this.e = LazyKt.lazy(new c0(r2));
        this.f = LazyKt.lazy(new d0(r2));
        this.g = LazyKt.lazy(new e0(r2));
    }

    public VoiceFrequencyView(Context r1, AttributeSet r2, int r3) {
        this(r1, r2);
    }
}
