package l1c;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.v2.api.IPrimaryTabService;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d extends k1c.a<String> {
    public String d;

    public static final class a {
    }

    static {
    }

    @Override // k1c.a
    public final String n() {
        String r0 = this.d;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public d() {
    }

    @Override // k1c.a, k1c.b
    public final void j(Context r2, e1c.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "manager");
        super.j(r2, r3);
        this.d = ((IPrimaryTabService) LarkContext.spiByDwarf(IPrimaryTabService.class)).getDefaultTabName();
        Log.i("Detector/PrimaryTabDetector", "init:" + this.d);
    }
}
