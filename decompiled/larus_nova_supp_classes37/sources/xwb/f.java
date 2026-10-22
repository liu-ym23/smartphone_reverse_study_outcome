package xwb;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface f<T, D> {
    void a(Object r1, d r2, String r3, OfficeWebView r4);

    BridgeAuthType authType();

    boolean shouldRunInUIThread();
}
