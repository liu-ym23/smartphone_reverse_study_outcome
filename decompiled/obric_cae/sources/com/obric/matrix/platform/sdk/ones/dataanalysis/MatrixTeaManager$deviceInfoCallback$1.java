package com.obric.matrix.platform.sdk.ones.dataanalysis;

import he.i;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class MatrixTeaManager$deviceInfoCallback$1 extends IDeviceInfoCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatrixTeaManager f6139a;

    public MatrixTeaManager$deviceInfoCallback$1(MatrixTeaManager r8) {
        this.f6139a = r8;
    }

    public final void I2(String r8) {
        i.f(r8, "deviceId");
        StringBuilder r10 = new StringBuilder("回调deviceId: ");
        r10.append(r8);
        r10.append("， listeners.size = ");
        MatrixTeaManager r11 = this.f6139a;
        r10.append(r11.f6128e.size());
        i.f(r10.toString(), "msg");
        MatrixTeaManager.f6123m = r8;
        Iterator<a> r12 = r11.f6128e.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        a r13 = r12.next();
        i.f("回调deviceId了，开始回调listener: " + r8 + " , listener = " + r13, "msg");
        r13.a();
        goto L4
    }

    public final void J2(String r8) {
        i.f(r8, "installId");
        Iterator<a> r10 = this.f6139a.f6128e.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().b();
        goto L4
    }
}
