package z1a;

import android.util.Pair;
import com.larus.update.IBitsUpdateImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class g implements yhc.f {
    public final /* synthetic */ IBitsUpdateImpl a;

    public /* synthetic */ g(IBitsUpdateImpl r1) {
        this.a = r1;
    }

    public final Pair getRequestTagHeader() {
        h r0 = this.a.g;
        if (r0 == null) goto L7;
        Pair<String, String> r1 = r0.getRequestTagHeader();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new Pair("", "");
    }
}
