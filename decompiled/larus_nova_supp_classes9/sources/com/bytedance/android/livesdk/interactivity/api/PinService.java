package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.pin.container.v2.PinContainerHighlightProcessor;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PinService;", "Lcom/bytedance/android/livesdk/interactivity/api/IPinService;", "Lp32/d;", "getPinContainerHighlightProcessor", "getPSPinContainerHighlightProcessor", "Lcom/bytedance/android/livesdkapi/depend/model/live/CommentPinContent;", "commentPinContent", BuildConfig.FLAVOR, "pinComment", BuildConfig.FLAVOR, "isAnchor", "hasPinPermission", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PinService implements IPinService {
    public PinService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPinService
    public p32.d getPSPinContainerHighlightProcessor() {
        return new com.bytedance.android.livesdk.interactivity.pin.container.v2.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPinService
    public p32.d getPinContainerHighlightProcessor() {
        return new PinContainerHighlightProcessor();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPinService
    public boolean hasPinPermission(boolean r1) {
        return com.bytedance.android.livesdk.interactivity.common.utils.h.b(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPinService
    public void pinComment(CommentPinContent r2) {
        Intrinsics.checkNotNullParameter(r2, "commentPinContent");
        k42.b.a(new e42.a(r2));
    }
}
