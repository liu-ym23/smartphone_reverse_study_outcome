package x4b;

import com.larksuite.framework.utils.CollectionUtils;
import f5b.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a<T extends f5b.b> {
    public final List<T> a;
    public final List<Integer> b;
    public final List<Integer> c;

    public a() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public a(List<T> r4, List<Integer> r5, List<Integer> r6) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        ArrayList r1 = new ArrayList();
        this.b = r1;
        ArrayList r2 = new ArrayList();
        this.c = r2;
        CollectionUtils.resetToList(r0, r4);
        CollectionUtils.resetToList(r1, r5);
        CollectionUtils.resetToList(r2, r6);
    }
}
