package com.bytedance.als;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class h<T> extends f<T> {
    public h() {
    }

    @Override // com.bytedance.als.f
    public void postValue(T r1) {
        super.postValue(r1);
    }

    @Override // com.bytedance.als.f
    public void setValue(T r10) {
        Handler r0 = ThreadUtility.a;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        super.setValue(r10);
        return;
    L6:
        final ThreadUtility.IncorrectThreadException r11 = new ThreadUtility.IncorrectThreadException("This method must call on main thread");
        ThreadUtility.a.post(new i(r11));
        throw r11;
    }
}
