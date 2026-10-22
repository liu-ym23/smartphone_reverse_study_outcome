package p28;

import android.view.View;
import com.larksuite.framework.ui.flowlayout.FlowLayout;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a<T> {
    public final List<T> a;
    public final HashSet<Integer> b;

    public abstract View a(FlowLayout r1, Object r2);

    public a(List<T> r2) {
        this.b = new HashSet();
        this.a = r2;
    }
}
