package t3a;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends ViewOutlineProvider {
    public h() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r10, Outline r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "outline");
        FLogger.a.d("RealtimeVideoGlobalFloatWindow", "getOutline width: " + r10.getWidth() + ", height: " + r10.getHeight());
        r11.setRoundRect(0, 0, r10.getWidth(), r10.getHeight(), ((float) i5.r0()) / r10.getScaleX());
    }
}
