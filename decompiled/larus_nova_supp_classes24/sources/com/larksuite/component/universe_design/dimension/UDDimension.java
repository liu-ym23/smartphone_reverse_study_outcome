package com.larksuite.component.universe_design.dimension;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/universe_design/dimension/UDDimension;", "", "value", "", "<init>", "(F)V", "getValue", "()F", "toPixels", "context", "Landroid/content/Context;", "Dp", "Px", "Sp", "Lcom/larksuite/component/universe_design/dimension/UDDimension$Dp;", "Lcom/larksuite/component/universe_design/dimension/UDDimension$Px;", "Lcom/larksuite/component/universe_design/dimension/UDDimension$Sp;", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class UDDimension {
    public static final int $stable = 0;
    private final float value;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/universe_design/dimension/UDDimension$Dp;", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "value", "", "<init>", "(F)V", "", "(I)V", "toPixels", "context", "Landroid/content/Context;", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Dp extends UDDimension {
        public static final int $stable = 0;

        public Dp(float r2) {
            super(r2, null);
        }

        public static DisplayMetrics INVOKEVIRTUAL_com_larksuite_component_universe_design_dimension_UDDimension$Dp_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
            return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        }

        @Override // com.larksuite.component.universe_design.dimension.UDDimension
        public float toPixels(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return TypedValue.applyDimension(1, getValue(), INVOKEVIRTUAL_com_larksuite_component_universe_design_dimension_UDDimension$Dp_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r3.getResources()));
        }

        public Dp(int r1) {
            this(r1);
        }
    }

    public static final class a extends UDDimension {
        public a(int r2) {
            super(r2, null);
        }

        @Override // com.larksuite.component.universe_design.dimension.UDDimension
        public final float toPixels(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return getValue();
        }

        public a(float r2) {
            super(r2, null);
        }
    }

    public static final class b extends UDDimension {
        public b(int r2) {
            super(r2, null);
        }

        @Override // com.larksuite.component.universe_design.dimension.UDDimension
        public final float toPixels(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            float r0 = getValue();
            Resources r4 = r3.getResources();
            return TypedValue.applyDimension(2, r0, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
        }

        public b(float r2) {
            super(r2, null);
        }
    }

    public /* synthetic */ UDDimension(float r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public abstract float toPixels(Context r1);

    public final float getValue() {
        return this.value;
    }

    private UDDimension(float r1) {
        this.value = r1;
    }
}
