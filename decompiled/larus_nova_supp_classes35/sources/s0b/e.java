package s0b;

import android.os.SystemClock;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.officesdk.utils.di.j;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ChameleonConfig a;
    public final /* synthetic */ boolean b;

    public e(ChameleonConfig r1) {
        this.a = r1;
        this.b = false;
    }

    public final void accept(Object r6) {
        String r7 = (String) r6;
        if (g.b != null) goto L5;
        j.b("CML_TAG_GeckoResManager", "executeCheckUpdate failed, GeckoClient == null");
        return;
    L5:
        j.e("CML_TAG_GeckoResManager", "executeCheckUpdateInner start");
        d r8 = new d(this.a);
        r8.a = SystemClock.uptimeMillis();
        int r1 = a.a;
        Map r2 = a.c(g.e, this.a);
        boolean r3 = this.b;
        j.e("CML_TAG_GeckoResManager", "executeCheckUpdate, channels = " + r2);
        OptionCheckUpdateParams r9 = new OptionCheckUpdateParams().setListener(r8).setEnableThrottle(r3);
        GeckoClient r0 = g.b;
        if (r0 == null) goto L10;
        r0.checkUpdateMulti("default", r2, r9);
        return;
    }
}
