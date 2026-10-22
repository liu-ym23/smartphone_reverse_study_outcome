package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAudienceServiceImpl;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/toolbar/MiniGameDetailPageDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniGameDetailPageDialog extends CommonStandardBottomDialog {
    public wo0.a B;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567105;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        System.currentTimeMillis();
        OpenPlatformMgAudienceServiceImpl.Companion.getClass();
        po0.a.b r4 = (po0.a.b) OpenPlatformMgAudienceServiceImpl.access$getDiComponent$cp();
        r4.getClass();
        wo0.a r5 = (wo0.a) r4.a.f.get();
        this.B = r5;
        if (r5 == null) goto L5;
        r5.a();
    L5:
        Intrinsics.checkNotNullParameter(xs2.b.a().b(h1.class).subscribe(new c(this), d.a), "$this$autoDispose");
        throw null;
    }
}
