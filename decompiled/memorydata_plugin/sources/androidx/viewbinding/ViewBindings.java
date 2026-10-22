package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ViewBindings {
    private ViewBindings() {
    }

    public static <T extends View> T findChildViewById(View r4, int r5) {
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == true) goto L5;
        return null;
    L5:
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        int r0 = r6.getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        T r3 = (T) r6.getChildAt(r2).findViewById(r5);
        if (r3 != null) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return r3;
    L11:
        return null;
    }
}
