package nxb;

import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.g;
import java.util.HashSet;
import wwb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final HashSet<String> a;
    public final HashSet<String> b;

    public a(c r1) {
        this.a = new HashSet();
        this.b = new HashSet();
    }

    public final void a(g r3, String r4) {
        if (r3.e == false) goto L7;
        r3.setOpenFromMultiWindow(false);
        j.e("SecurityLinkChecker", "shouldInterceptUrlLoading is openFromMulti so return false");
        return;
    L7:
        if (r3.getHitTestResult() != null) goto L9;
    L13:
        this.b.add(r4);
        j.e("SecurityLinkChecker", "shouldInterceptUrlLoading hitTestResult = null || unknown so return false");
        return;
    L9:
        if (r3.getHitTestResult().getType() == 0) goto L13;
        j.e("SecurityLinkChecker", "shouldInterceptUrlLoading default return false");
    }
}
