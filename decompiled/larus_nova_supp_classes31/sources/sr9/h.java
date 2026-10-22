package sr9;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h implements com.larus.bmhome.instruction.helper.f {
    public static final h a = null;
    public static Function1<? super Uri, Unit> b;
    public static Function1<? super List<? extends Uri>, Unit> c;

    static {
        a = new h();
    }

    public h() {
    }

    public final void onDestroy() {
        b = null;
        c = null;
    }

    public final void b(Function1<? super Uri, Unit> r1) {
        b = r1;
    }

    public final void c(Function1<? super List<? extends Uri>, Unit> r1) {
        c = r1;
    }

    public final void a(FragmentActivity r1, boolean r2, int r3) {
        Function1<? super Uri, Unit> r4 = b;
        if (r4 == null) goto L5;
        r4.invoke(null);
    L5:
        Function1<? super List<? extends Uri>, Unit> r5 = c;
        if (r5 == null) goto L9;
        r5.invoke(CollectionsKt.emptyList());
        return;
    }
}
