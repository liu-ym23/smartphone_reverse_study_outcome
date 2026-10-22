package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/OpenPlatformDebugFloatBall;", "Landroidx/appcompat/widget/AppCompatImageView;", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformDebugFloatBall extends AppCompatImageView {
    public static final /* synthetic */ int b = 0;
    public final IQRCodeService.b a;

    public static final class a {
    }

    static {
    }

    public final int j(Context r2, int r3) {
        Resources r4 = r2.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPlatformDebugFloatBall(ViewGroup r3, Context r4, MiniAppAnchorDebugContextService r5) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "scanResultListener");
        super(r4);
        this.a = r5;
        UtilityKotlinExtentionsKt.t(this);
        setImageDrawable(s1.m(2131252529));
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(j(r4, 36), j(r4, 36));
        r6.topMargin = j(r4, 134);
        r6.rightMargin = j(r4, 10);
        r6.gravity = 8388613;
        r3.addView(this, r6);
        setOnClickListener(new g(this));
    }
}
