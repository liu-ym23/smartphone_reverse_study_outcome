package im.quar.autolayout.attr;

import android.aimedia.a;
import im.quar.autolayout.utils.AutoUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AutoAttr<T> {
    private int pxVal;

    public AutoAttr(int r8) {
        this.pxVal = r8;
    }

    public void apply(T r8) {
        int r10 = AutoUtils.scaleValue(this.pxVal);
        if (r10 == 0) goto L5;
    L7:
        execute(r8, r10);
        return;
    L5:
        if (this.pxVal <= 0) goto L7;
        r10 = 1;
        goto L7
    }

    public abstract int attrVal();

    public abstract void execute(T r8, int r10);

    public String toString() {
        return a.f(new StringBuilder("AutoAttr{pxVal="), this.pxVal, '}');
    }
}
