package ei;

import android.view.View;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<T> {
    public final List<T> a;
    public final HashSet<Integer> b;

    public abstract View a(Object r1);

    public a(List<T> r10) {
        this.b = new HashSet();
        this.a = r10;
    }
}
