package androidx.transition;

import android.view.View;
import android.view.WindowId;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class WindowIdApi18 implements WindowIdImpl {
    private final WindowId mWindowId;

    WindowIdApi18(View r1) {
        this.mWindowId = r1.getWindowId();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, WindowIdApi18.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WindowIdApi18) ZeusTransformUtils.preCheckCast(r3, WindowIdApi18.class, "com.obric.memorydata.plugin")).mWindowId.equals(this.mWindowId) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mWindowId.hashCode();
    }
}
