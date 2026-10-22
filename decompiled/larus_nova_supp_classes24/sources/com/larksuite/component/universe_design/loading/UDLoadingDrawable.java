package com.larksuite.component.universe_design.loading;

import android.content.Context;
import android.graphics.Paint;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "universe-ui-loading_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDLoadingDrawable extends CircularProgressDrawable {
    public UDLoadingDrawable(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        setStyle(1);
        setColorSchemeColors(new int[]{UDColorUtils.getColor(r3, 2131106521)});
        setStrokeCap(Paint.Cap.ROUND);
    }
}
