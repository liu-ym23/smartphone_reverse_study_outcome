package com.larksuite.component.blockit.hashtag.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public int a;
    public final Set<Integer> b;
    public final Set<SwipeLayout> c;
    public final py7.a d;
    public final Attributes$Mode e;

    public class a implements SwipeLayout.f {
        public int a;
        public final /* synthetic */ b b;

        @Override // com.larksuite.component.blockit.hashtag.widget.SwipeLayout.f
        public final void a(SwipeLayout r6) {
            b r0 = this.b;
            int r1 = this.a;
            if (r0.e != Attributes$Mode.Multiple) goto L6;
            Set<Integer> r2 = r0.b;
            HashSet r3 = (HashSet) r2;
            boolean r4 = r3.contains(Integer.valueOf(r1));
        L9:
            if (r4 == false) goto L11;
            r6.i(false, false);
            return;
        L11:
            r6.b(false, false);
            return;
        L6:
            if (r0.a != r1) goto L8;
            r4 = true;
            goto L9
        L8:
            r4 = false;
            goto L9
        }

        public a(b r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.blockit.hashtag.widget.b$b, reason: collision with other inner class name */
    public class C0012b extends com.larksuite.component.blockit.hashtag.widget.a {
        public int a;
        public final /* synthetic */ b b;

        @Override // com.larksuite.component.blockit.hashtag.widget.a, com.larksuite.component.blockit.hashtag.widget.SwipeLayout.j
        public final void onClose() {
            b r0 = this.b;
            if (r0.e != Attributes$Mode.Multiple) goto L5;
            Set<Integer> r1 = r0.b;
            HashSet r2 = (HashSet) r1;
            r2.remove(Integer.valueOf(this.a));
            return;
        L5:
            r0.a = -1;
        }

        @Override // com.larksuite.component.blockit.hashtag.widget.SwipeLayout.j
        public final void c(SwipeLayout r4) {
            b r0 = this.b;
            if (r0.e != Attributes$Mode.Multiple) goto L5;
            Set<Integer> r5 = r0.b;
            HashSet r6 = (HashSet) r5;
            r6.add(Integer.valueOf(this.a));
            return;
        L5:
            Iterator r1 = ((HashSet) r0.c).iterator();
        L7:
            if (r1.hasNext() == false) goto L11;
            SwipeLayout r2 = (SwipeLayout) r1.next();
            if (r2 == r4) goto L7;
            r2.b(true, true);
            goto L7
        L11:
            b r7 = this.b;
            r7.a = this.a;
        }

        @Override // com.larksuite.component.blockit.hashtag.widget.a, com.larksuite.component.blockit.hashtag.widget.SwipeLayout.j
        public final void d(SwipeLayout r4) {
            b r0 = this.b;
            if (r0.e != Attributes$Mode.Single) goto L10;
            Iterator r1 = ((HashSet) r0.c).iterator();
        L6:
            if (r1.hasNext() == false) goto L16;
            SwipeLayout r2 = (SwipeLayout) r1.next();
            if (r2 == r4) goto L6;
            r2.b(true, true);
            goto L6
        L16:
            return;
        }

        public C0012b(b r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c {
        public final a a;
        public final C0012b b;

        public c(C0012b r1, a r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public b(py7.a r2) {
        this.a = -1;
        this.b = new HashSet();
        this.c = new HashSet();
        this.e = Attributes$Mode.Single;
        if (r2 == null) goto L7;
        this.d = r2;
        return;
    L7:
        throw new IllegalArgumentException("SwipeAdapterInterface can not be null");
    }

    public final void b(boolean r4) {
        if (this.e != Attributes$Mode.Multiple) goto L5;
        ((HashSet) this.b).clear();
    L6:
        Iterator r0 = ((HashSet) this.c).iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ((SwipeLayout) r0.next()).b(r4, true);
        goto L8
    L10:
        return;
    L5:
        this.a = -1;
        goto L6
    }

    public final void a(View r4, int r5) {
        int r0 = this.d.B0();
        SwipeLayout r6 = (SwipeLayout) r4.findViewById(r0);
        if (r6 == null) goto L13;
        if (r6.getTag(r0) != null) goto L10;
        a r1 = new a(this, r5);
        C0012b r2 = new C0012b(this, r5);
        ((ArrayList) r6.j).add(r2);
        if (r6.v != null) goto L9;
        r6.v = new ArrayList();
    L9:
        ((ArrayList) r6.v).add(r1);
        r6.setTag(r0, new c(r2, r1));
        ((HashSet) this.c).add(r6);
        return;
    L10:
        c r7 = (c) r6.getTag(r0);
        r7.b.a = r5;
        r7.a.a = r5;
        return;
    L13:
        throw new IllegalStateException("can not find SwipeLayout in target view");
    }
}
