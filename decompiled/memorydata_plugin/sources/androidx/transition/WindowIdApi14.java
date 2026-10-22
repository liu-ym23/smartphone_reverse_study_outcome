package androidx.transition;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    WindowIdApi14(IBinder r3) {
        this.mToken = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, WindowIdApi14.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WindowIdApi14) ZeusTransformUtils.preCheckCast(r3, WindowIdApi14.class, "com.obric.memorydata.plugin")).mToken.equals(this.mToken) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
