package kxb;

import android.webkit.ValueCallback;
import com.ss.android.lark.officewebview.quality.hang.detect.ResetPingSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d<T> implements ValueCallback {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r2) {
        String r3 = (String) r2;
        this.a.c(ResetPingSource.Normal.getValue());
        this.a.c.invoke();
    }
}
