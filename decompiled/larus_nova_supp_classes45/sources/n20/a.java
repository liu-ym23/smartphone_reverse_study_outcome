package n20;

import com.bytedance.android.annie.service.appruntime.DegradeStatus;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import y8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements LevelAbility {
    public static int a;
    public static final a b = null;

    public a() {
    }

    public final void onPropertyChange(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "property");
    }

    static {
        b = new a();
    }

    public final boolean onLevelChange(int r3) {
        if (r3 >= 0) goto L5;
        a = 1;
        int r4 = d.a;
        d.a(DegradeStatus.liveDegrade, 1, 4);
    L6:
        return true;
    L5:
        a = 0;
        int r5 = d.a;
        d.b(DegradeStatus.liveDegrade);
        goto L6
    }
}
