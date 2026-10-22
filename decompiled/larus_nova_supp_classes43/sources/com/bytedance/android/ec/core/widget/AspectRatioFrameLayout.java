package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\r\u0010\u0014R+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/widget/AspectRatioFrameLayout;", "Landroid/widget/FrameLayout;", "", "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", "getRatio", "()F", "setRatio", "(F)V", "ratio", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AspectRatioFrameLayout extends FrameLayout {
    public static final /* synthetic */ KProperty[] b = null;
    public final ObservableProperty a;

    public static final class a extends ObservableProperty<Float> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ AspectRatioFrameLayout b;

        public a(Object r1, Object r10, AspectRatioFrameLayout r11) {
            this.a = r1;
            this.b = r11;
            super(r10);
        }

        public final void afterChange(KProperty<?> r10, Float r11, Float r12) {
            Intrinsics.checkNotNullParameter(r10, "property");
            if (r12.floatValue() == r11.floatValue()) goto L7;
            this.b.invalidate();
            return;
        }
    }

    public static final class b extends ObservableProperty<Float> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ AspectRatioFrameLayout b;

        public b(Object r1, Object r10, AspectRatioFrameLayout r11) {
            this.a = r1;
            this.b = r11;
            super(r10);
        }

        public final void afterChange(KProperty<?> r10, Float r11, Float r12) {
            Intrinsics.checkNotNullParameter(r10, "property");
            if (r12.floatValue() == r11.floatValue()) goto L7;
            this.b.invalidate();
            return;
        }
    }

    public static final class c extends ObservableProperty<Float> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ AspectRatioFrameLayout b;

        public c(Object r1, Object r10, AspectRatioFrameLayout r11) {
            this.a = r1;
            this.b = r11;
            super(r10);
        }

        public final void afterChange(KProperty<?> r10, Float r11, Float r12) {
            Intrinsics.checkNotNullParameter(r10, "property");
            if (r12.floatValue() == r11.floatValue()) goto L7;
            this.b.invalidate();
            return;
        }
    }

    static {
        b = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(AspectRatioFrameLayout.class, "ratio", "getRatio()F", 0))};
    }

    public final float getRatio() {
        return ((Number) this.a.getValue(this, b[0])).floatValue();
    }

    public final void setRatio(float r10) {
        this.a.setValue(this, b[0], Float.valueOf(r10));
    }

    public AspectRatioFrameLayout(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        Delegates r11 = Delegates.INSTANCE;
        Float r12 = Float.valueOf(1.0f);
        this.a = new a(r12, r12, this);
    }

    public AspectRatioFrameLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        Delegates r12 = Delegates.INSTANCE;
        Float r13 = Float.valueOf(1.0f);
        this.a = new b(r13, r13, this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(r10) * getRatio()), View.MeasureSpec.getMode(r10)));
    }

    public AspectRatioFrameLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        Delegates r13 = Delegates.INSTANCE;
        Float r14 = Float.valueOf(1.0f);
        this.a = new c(r14, r14, this);
    }
}
