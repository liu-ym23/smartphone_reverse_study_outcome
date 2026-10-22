package u32;

import android.view.View;
import com.bytedance.android.livesdk.message.model.ii;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class d extends b {
    public final a a;

    public interface a {
        View a();

        View b();

        String c();

        List<Pair<String, String>> d();

        n e();

        View f();

        View g();

        void setContentDescription(String r1);
    }

    public abstract View d();

    public abstract void e();

    public abstract void f(ii r1);

    public abstract void g(long r1);

    public d(a r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        this.a = r2;
    }
}
