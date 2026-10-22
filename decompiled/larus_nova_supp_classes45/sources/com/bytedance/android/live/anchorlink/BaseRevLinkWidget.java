package com.bytedance.android.live.anchorlink;

import com.bytedance.android.live.core.setting.k6;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/anchorlink/BaseRevLinkWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "liveanchorlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseRevLinkWidget extends LiveWidget {
    public abstract int getScene();

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public void onDestroy() {
        super.onDestroy();
        if (((Boolean) k6.a.getValue()).booleanValue() == false) goto L6;
        ((Widget) this).widgetCallback = null;
        return;
    }

    public BaseRevLinkWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public void onCreate() {
        super.onCreate();
    }
}
