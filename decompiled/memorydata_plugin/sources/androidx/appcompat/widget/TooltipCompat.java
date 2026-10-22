package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class TooltipCompat {

    static class Api26Impl {
        private Api26Impl() {
        }

        static void setTooltipText(View r2, CharSequence r3) {
            r2.setTooltipText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    private TooltipCompat() {
    }

    public static void setTooltipText(View r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setTooltipText(r2, r4);
        return;
    L5:
        TooltipCompatHandler.setTooltipText(r2, r4);
    }
}
