package com.larus.photopicker.v2.impl.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/photopicker/v2/impl/viewmodel/MediaPreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "previewPageAlphaPercentChange", "Landroidx/lifecycle/MutableLiveData;", "", "getPreviewPageAlphaPercentChange", "()Landroidx/lifecycle/MutableLiveData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaPreviewViewModel extends ViewModel {
    private final MutableLiveData<Float> previewPageAlphaPercentChange;

    public MediaPreviewViewModel() {
        this.previewPageAlphaPercentChange = new MutableLiveData();
    }

    public final MutableLiveData<Float> getPreviewPageAlphaPercentChange() {
        return this.previewPageAlphaPercentChange;
    }
}
