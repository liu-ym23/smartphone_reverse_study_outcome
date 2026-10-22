package z9;

import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.util.Attributes$Mode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Attributes$Mode f13808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f13809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Set<Integer> f13810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Set<OSwipeLayout> f13811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected aa.a f13812e;

    public a(aa.a r10) {
        this.f13808a = Attributes$Mode.Single;
        this.f13809b = -1;
        this.f13810c = new HashSet();
        this.f13811d = new HashSet();
        if (r10 == null) goto L7;
        this.f13812e = r10;
        return;
    L7:
        throw new IllegalArgumentException("SwipeAdapterInterface can not be null");
    }

    public void a(OSwipeLayout r10) {
        Iterator<OSwipeLayout> r11 = this.f13811d.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        OSwipeLayout r12 = r11.next();
        if (r12 == r10) goto L4;
        r12.r();
        goto L4
    }

    public void b() {
        if (this.f13808a != Attributes$Mode.Multiple) goto L5;
        this.f13810c.clear();
    L6:
        Iterator<OSwipeLayout> r10 = this.f13811d.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().r();
        goto L8
    L10:
        return;
    L5:
        this.f13809b = -1;
        goto L6
    }

    public void c(int r10) {
        if (this.f13808a != Attributes$Mode.Multiple) goto L6;
        this.f13810c.remove(Integer.valueOf(r10));
    L8:
        this.f13812e.notifyDatasetChanged();
        return;
    L6:
        if (this.f13809b != r10) goto L8;
        this.f13809b = -1;
        goto L8
    }

    public Attributes$Mode d() {
        return this.f13808a;
    }

    public List<Integer> e() {
        if (this.f13808a != Attributes$Mode.Multiple) goto L7;
        return new ArrayList(this.f13810c);
    L7:
        return Collections.singletonList(Integer.valueOf(this.f13809b));
    }

    public List<OSwipeLayout> f() {
        return new ArrayList(this.f13811d);
    }

    public boolean g(int r10) {
        if (this.f13808a != Attributes$Mode.Multiple) goto L7;
        return this.f13810c.contains(Integer.valueOf(r10));
    L7:
        if (this.f13809b != r10) goto L9;
        return true;
    L9:
        return false;
    }

    public void h(int r10) {
        if (this.f13808a == Attributes$Mode.Multiple) goto L5;
        this.f13809b = r10;
    L8:
        this.f13812e.notifyDatasetChanged();
        return;
    L5:
        if (this.f13810c.contains(Integer.valueOf(r10)) == true) goto L8;
        this.f13810c.add(Integer.valueOf(r10));
        goto L8
    }

    public void i(OSwipeLayout r10) {
        this.f13811d.remove(r10);
    }

    public void j(Attributes$Mode r10) {
        this.f13808a = r10;
        this.f13810c.clear();
        this.f13811d.clear();
        this.f13809b = -1;
    }
}
