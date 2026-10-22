package com.bytedance.android.livesdk.interactivity.common.cleanarch.widgetcompat;

import com.bytedance.android.livesdk.interactivity.common.cleanarch.IView;
import com.bytedance.android.livesdk.interactivity.common.cleanarch.ext.CompatLiveRecyclableWidget;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u00042\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/cleanarch/widgetcompat/CleanWidget;", BuildConfig.FLAVOR, "STATE", "ACTION", "Lcom/bytedance/android/livesdk/interactivity/common/cleanarch/ext/CompatLiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/interactivity/common/cleanarch/IView;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CleanWidget<STATE, ACTION> extends CompatLiveRecyclableWidget implements IView<STATE, ACTION> {
    @Override // com.bytedance.android.livesdk.interactivity.common.cleanarch.ext.CompatLiveRecyclableWidget
    public final void onUnload() {
        super.onUnload();
        aa();
    }

    public CleanWidget() {
    }

    public final void onLoad(Object[] r1) {
        aa();
        aa();
        aa();
    }
}
