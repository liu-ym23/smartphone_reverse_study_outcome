package td;

import android.content.Context;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    void a();

    void b(int r1);

    void c(boolean r1);

    void d();

    void e();

    void f();

    Observable<ge.a> g(Context r1, ge.b r10);

    re.a getLogger(Class r1);

    void h(ud.a<String, String> r1);

    boolean insertLegalMessage(long r1, String r10);

    void isLinkmic();

    void jetDanmaku(String r1, long r10, String r11, String r12);

    void onCouponMessage(int r1, long r10, String r11, int r12, long r13);

    void onPurchasingIntentionAction();
}
