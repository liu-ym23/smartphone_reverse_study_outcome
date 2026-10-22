package com.obric.oui.swipeaction.a;

import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.util.Attributes;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f14516b;
    protected Set<Integer> c;
    protected Set<OSwipeLayout> d;
    protected com.obric.oui.swipeaction.b.a e;
    private Attributes.Mode f;

    public a(com.obric.oui.swipeaction.b.a r3) {
        com.obric.oui.swipeaction.b.a r4 = (com.obric.oui.swipeaction.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.swipeaction.b.a.class, "com.obric.memorydata.plugin");
        this.f = Attributes.Mode.Single;
        this.f14515a = -1;
        this.f14516b = -1;
        this.c = new HashSet();
        this.d = new HashSet();
        if (r4 == null) goto L7;
        this.e = r4;
        return;
    L7:
        throw new IllegalArgumentException("SwipeAdapterInterface can not be null");
    }

    public Attributes.Mode a() {
        return this.f;
    }

    public void a(int r3) {
        if (this.f == Attributes.Mode.Multiple) goto L5;
        this.f14516b = r3;
    L8:
        this.e.notifyDatasetChanged();
        return;
    L5:
        if (this.c.contains(Integer.valueOf(r3)) == true) goto L8;
        this.c.add(Integer.valueOf(r3));
        goto L8
    }

    public void a(OSwipeLayout r4) {
        Iterator<OSwipeLayout> r3 = this.d.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        OSwipeLayout r0 = (OSwipeLayout) ZeusTransformUtils.preCheckCast(r3.next(), OSwipeLayout.class, "com.obric.memorydata.plugin");
        if (r0 == r4) goto L4;
        r0.o();
        goto L4
    }

    public void a(Attributes.Mode r1) {
        this.f = r1;
        this.c.clear();
        this.d.clear();
        this.f14516b = -1;
    }

    public void b() {
        if (this.f != Attributes.Mode.Multiple) goto L5;
        this.c.clear();
    L6:
        Iterator<OSwipeLayout> r3 = this.d.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ((OSwipeLayout) ZeusTransformUtils.preCheckCast(r3.next(), OSwipeLayout.class, "com.obric.memorydata.plugin")).o();
        goto L8
    L10:
        return;
    L5:
        this.f14516b = -1;
        goto L6
    }

    public void b(int r3) {
        if (this.f != Attributes.Mode.Multiple) goto L6;
        this.c.remove(Integer.valueOf(r3));
    L8:
        this.e.notifyDatasetChanged();
        return;
    L6:
        if (this.f14516b != r3) goto L8;
        this.f14516b = -1;
        goto L8
    }

    public void b(OSwipeLayout r1) {
        this.d.remove(r1);
    }

    public List<Integer> c() {
        if (this.f != Attributes.Mode.Multiple) goto L7;
        return new ArrayList(this.c);
    L7:
        return Collections.singletonList(Integer.valueOf(this.f14516b));
    }

    public boolean c(int r3) {
        if (this.f != Attributes.Mode.Multiple) goto L7;
        return this.c.contains(Integer.valueOf(r3));
    L7:
        if (this.f14516b != r3) goto L9;
        return true;
    L9:
        return false;
    }

    public List<OSwipeLayout> d() {
        return new ArrayList(this.d);
    }
}
