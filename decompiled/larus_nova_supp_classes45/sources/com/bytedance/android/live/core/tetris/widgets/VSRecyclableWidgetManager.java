package com.bytedance.android.live.core.tetris.widgets;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/VSRecyclableWidgetManager;", "Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "<init>", "()V", "a", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSRecyclableWidgetManager extends RecyclableWidgetManager {
    public static final /* synthetic */ int l = 0;
    public b k;

    public static final class a {
    }

    static {
    }

    public VSRecyclableWidgetManager() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager
    public final void continueLoad(Widget r2, ViewGroup r3, View r4) {
        b r0 = this.k;
        if (r0 == null) goto L5;
        r0.intercept();
        return;
    L5:
        super.continueLoad(r2, r3, r4);
    }
}
