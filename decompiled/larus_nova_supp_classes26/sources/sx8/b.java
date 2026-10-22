package sx8;

import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.larus.camera.impl.ui.activity.CameraCaptureActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b implements OnApplyWindowInsetsListener {
    public final /* synthetic */ CameraCaptureActivity a;

    public /* synthetic */ b(CameraCaptureActivity r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r6, WindowInsetsCompat r7) {
        CameraCaptureActivity r0 = this.a;
        int r1 = CameraCaptureActivity.d;
        Intrinsics.checkNotNullParameter(r6, "v");
        Intrinsics.checkNotNullParameter(r7, "insets");
        int r2 = r7.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L7:
        boolean r3 = false;
    L8:
        z2.a.w3();
        FLogger.a.i("CameraCaptureActivity", "insets top is " + r2 + ", paddingTop=" + r6.getPaddingTop() + ", isInMultiWindowMode=" + r3 + ", enableSmallWindowTopPaddingFix=false");
        if (r6.getPaddingTop() <= 0) goto L11;
        r6.setPadding(r6.getPaddingLeft(), r2, r6.getPaddingRight(), r6.getPaddingBottom());
    L11:
        return r7;
    L5:
        if (r0.isInMultiWindowMode() == false) goto L7;
        r3 = true;
        goto L8
    }
}
