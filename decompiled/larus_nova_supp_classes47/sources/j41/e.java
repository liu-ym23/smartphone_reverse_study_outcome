package j41;

import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final Observable a(String r2, int r3) {
        k r0 = vh7.f.c(k.class);
        ArrayList r1 = new ArrayList();
        r1.add(r2);
        r0.setUrls(r1);
        Observable r4 = a1.k(r0).map(new d(r3));
        int r5 = p.a;
        return r4.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
