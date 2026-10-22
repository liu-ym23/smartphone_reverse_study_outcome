package com.bytedance.android.live.core.tetris.layer.core.layout;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.livesdk.tetris.ConstraintWidgetService")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/layout/IConstraintWidgetService;", "Lcom/bytedance/android/live/base/IService;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "layout", "Landroid/view/View;", "view", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/b$a;", "getViewWidget", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IConstraintWidgetService extends IService {
    b.a getViewWidget(ConstraintLayout r1, View r2);
}
