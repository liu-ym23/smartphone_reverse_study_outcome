package com.bytedance.android.livesdk.floatview;

import android.content.Context;
import com.bytedance.android.livesdkapi.service.IFloatWindowService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/FloatWindowService;", "Lcom/bytedance/android/livesdkapi/service/IFloatWindowService;", "()V", "hideFloatWindow", "", "isAppBackground", "", "isFloatWindowOpen", "context", "Landroid/content/Context;", "isInnerFloatPlay", "isPipModeOpen", "useSharePlayer", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatWindowService implements IFloatWindowService {
    public FloatWindowService() {
    }

    public void hideFloatWindow() {
        q r0 = VideoFloatWindowManager.f;
        IFloatWindowManager.a.a(VideoFloatWindowManager.b.a(), false, 3);
    }

    public boolean isAppBackground() {
        q r0 = NewVideoInnerFloatManager.p;
        return NewVideoInnerFloatManager.p.a;
    }

    public boolean isInnerFloatPlay() {
        q r0 = NewVideoInnerFloatManager.p;
        return NewVideoInnerFloatManager.b.a().i();
    }

    public boolean useSharePlayer() {
        q r0 = NewVideoInnerFloatManager.p;
        VideoFloatWindowView r1 = NewVideoInnerFloatManager.b.a().b;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.n() != true) goto L7;
        return true;
    }

    public boolean isPipModeOpen() {
        return p.f();
    }

    public boolean isFloatWindowOpen(Context r1) {
        return p.d(r1);
    }
}
