package com.obric.oui.orecyclerview.widget;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class h extends z {
    private static TimeInterpolator i;
    private static TimeInterpolator j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.v>> f14163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<ArrayList<b>> f14164b;
    ArrayList<ArrayList<a>> c;
    ArrayList<RecyclerView.v> d;
    ArrayList<RecyclerView.v> e;
    ArrayList<RecyclerView.v> f;
    ArrayList<RecyclerView.v> g;
    private ArrayList<RecyclerView.v> k;
    private ArrayList<RecyclerView.v> l;
    private ArrayList<b> m;
    private ArrayList<a> n;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.v f14181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.v f14182b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(RecyclerView.v r1, RecyclerView.v r2) {
            this.f14181a = r1;
            this.f14182b = r2;
        }

        a(RecyclerView.v r1, RecyclerView.v r2, int r3, int r4, int r5, int r6) {
            this(r1, r2);
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f14181a + ", newHolder=" + this.f14182b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.v f14183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14184b;
        public int c;
        public int d;
        public int e;

        b(RecyclerView.v r1, int r2, int r3, int r4, int r5) {
            this.f14183a = r1;
            this.f14184b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public h() {
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.f14163a = new ArrayList();
        this.f14164b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    private void a(List<a> r5, RecyclerView.v r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size() - 1;
    L3:
        if (r0 < 0) goto L12;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r7.get(r0), a.class, "com.obric.memorydata.plugin");
        if (a(r2, r6) == false) goto L11;
        if (r2.f14181a != null) goto L11;
        if (r2.f14182b != null) goto L11;
        r7.remove(r2);
    L11:
        r0 = r0 - 1;
        goto L3
    }

    private boolean a(a r5, RecyclerView.v r6) {
        boolean r3 = false;
        if (r5.f14182b != r6) goto L6;
        r5.f14182b = null;
    L8:
        r6.c.setAlpha(1.0f);
        r6.c.setTranslationX(0.0f);
        r6.c.setTranslationY(0.0f);
        a(r6, r3);
        return true;
    L6:
        if (r5.f14181a != r6) goto L10;
        r5.f14181a = null;
        r3 = true;
        goto L8
    L10:
        return false;
    }

    private void b(a r2) {
        if (r2.f14181a == null) goto L6;
        a(r2, r2.f14181a);
    L6:
        if (r2.f14182b == null) goto L9;
        a(r2, r2.f14182b);
        return;
    }

    static /* synthetic */ TimeInterpolator f() {
        return i;
    }

    private void u(final RecyclerView.v r5) {
        final View r0 = r5.c;
        final ViewPropertyAnimator r1 = r0.animate();
        this.f.add(r5);
        r1.setDuration(a()).alpha(0.0f).setInterpolator(j).setListener(new AnonymousClass4(this, r5, r0, r1)).start();
    }

    private void v(RecyclerView.v r3) {
        if (i != null) goto L6;
        i = new com.obric.oui.orecyclerview.base.g();
    L6:
        if (j != null) goto L8;
        j = new LinearInterpolator();
    L8:
        r3.c.animate().setInterpolator(i);
        b(r3);
    }

    void a(final a r7) {
        RecyclerView.v r0 = r7.f14181a;
        final View r1 = null;
        if (r0 != null) goto L5;
        final View r2 = null;
    L6:
        RecyclerView.v r3 = r7.f14182b;
        if (r3 == null) goto L10;
        r1 = r3.c;
    L10:
        if (r2 == null) goto L12;
        final ViewPropertyAnimator r4 = r2.animate().setDuration(i());
        this.g.add(r7.f14181a);
        r4.translationX(r7.e - r7.c);
        r4.translationY(r7.f - r7.d);
        r4.alpha(0.0f).setListener(new AnonymousClass7(this, r7, r4, r2)).start();
    L12:
        if (r1 == null) goto L15;
        final ViewPropertyAnimator r5 = r1.animate();
        this.g.add(r7.f14182b);
        r5.translationX(0.0f).translationY(0.0f).setDuration(i()).alpha(1.0f).setListener(new AnonymousClass8(this, r7, r5, r1)).start();
        return;
    L15:
        return;
    L5:
        r2 = r0.c;
        goto L6
    }

    void a(List<RecyclerView.v> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r5 = r3.size() - 1;
    L3:
        if (r5 < 0) goto L5;
        ((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3.get(r5), RecyclerView.v.class, "com.obric.memorydata.plugin")).c.animate().cancel();
        r5 = r5 - 1;
        goto L3
    }

    @Override // com.obric.oui.orecyclerview.widget.z
    public boolean a(RecyclerView.v r1) {
        v(r1);
        this.k.add(r1);
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.z
    public boolean a(RecyclerView.v r9, int r10, int r11, int r12, int r13) {
        View r0 = r9.c;
        int r4 = r10 + ((int) r9.c.getTranslationX());
        int r5 = r11 + ((int) r9.c.getTranslationY());
        v(r9);
        int r14 = r12 - r4;
        int r15 = r13 - r5;
        if (r14 != 0) goto L7;
        if (r15 != 0) goto L7;
        j(r9);
        return false;
    L7:
        if (r14 == 0) goto L9;
        r0.setTranslationX(-r14);
    L9:
        if (r15 == 0) goto L11;
        r0.setTranslationY(-r15);
    L11:
        this.m.add(new b(r9, r4, r5, r12, r13));
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.z
    public boolean a(RecyclerView.v r9, RecyclerView.v r10, int r11, int r12, int r13, int r14) {
        if (r9 == r10) goto L4;
        float r0 = r9.c.getTranslationX();
        float r1 = r9.c.getTranslationY();
        float r2 = r9.c.getAlpha();
        v(r9);
        int r3 = (int) ((r13 - r11) - r0);
        int r4 = (int) ((r14 - r12) - r1);
        r9.c.setTranslationX(r0);
        r9.c.setTranslationY(r1);
        r9.c.setAlpha(r2);
        if (r10 == null) goto L8;
        v(r10);
        r10.c.setTranslationX(-r3);
        r10.c.setTranslationY(-r4);
        r10.c.setAlpha(0.0f);
    L8:
        this.n.add(new a(r9, r10, r11, r12, r13, r14));
        return true;
    L4:
        return a(r9, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public boolean a(RecyclerView.v r3, List<Object> r4) {
        List<Object> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.a(r3, r5) == true) goto L8;
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public void b() {
        boolean r0 = !this.k.isEmpty();
        boolean r1 = !this.m.isEmpty();
        boolean r2 = !this.n.isEmpty();
        boolean r3 = !this.l.isEmpty();
        if (r0 == true) goto L8;
        if (r1 == true) goto L8;
        if (r3 == true) goto L8;
        if (r2 == true) goto L8;
        return;
    L8:
        Iterator<RecyclerView.v> r4 = this.k.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        u((RecyclerView.v) ZeusTransformUtils.preCheckCast(r4.next(), RecyclerView.v.class, "com.obric.memorydata.plugin"));
        goto L10
    L12:
        this.k.clear();
        if (r1 == false) goto L18;
        final ArrayList<b> r5 = new ArrayList();
        r5.addAll(this.m);
        this.f14164b.add(r5);
        this.m.clear();
        Runnable r7 = new AnonymousClass1(this, r5);
        if (r0 == false) goto L17;
        ViewCompat.postOnAnimationDelayed(((b) ZeusTransformUtils.preCheckCast(r5.get(0), b.class, "com.obric.memorydata.plugin")).f14183a.c, r7, a());
        goto L18
    L17:
        r7.run();
    L18:
        if (r2 == false) goto L23;
        final ArrayList<a> r6 = new ArrayList();
        r6.addAll(this.n);
        this.c.add(r6);
        this.n.clear();
        Runnable r8 = new AnonymousClass2(this, r6);
        if (r0 == false) goto L22;
        ViewCompat.postOnAnimationDelayed(((a) ZeusTransformUtils.preCheckCast(r6.get(0), a.class, "com.obric.memorydata.plugin")).f14181a.c, r8, a());
        goto L23
    L22:
        r8.run();
    L23:
        if (r3 == false) goto L42;
        final ArrayList<RecyclerView.v> r9 = new ArrayList();
        r9.addAll(this.l);
        this.f14163a.add(r9);
        this.l.clear();
        Runnable r10 = new AnonymousClass3(this, r9);
        if (r0 == true) goto L30;
        if (r1 == true) goto L30;
        if (r2 == true) goto L30;
        r10.run();
        return;
    L30:
        long r11 = 0;
        if (r0 == false) goto L33;
        long r12 = a();
    L34:
        if (r1 == false) goto L36;
        long r13 = g();
    L37:
        if (r2 == false) goto L39;
        r11 = i();
    L39:
        ViewCompat.postOnAnimationDelayed(((RecyclerView.v) ZeusTransformUtils.preCheckCast(r9.get(0), RecyclerView.v.class, "com.obric.memorydata.plugin")).c, r10, r12 + Math.max(r13, r11));
        return;
    L36:
        r13 = 0;
        goto L37
    L33:
        r12 = 0;
        goto L34
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public void b(RecyclerView.v r10) {
        View r0 = r10.c;
        r0.animate().cancel();
        int r1 = this.m.size();
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L9;
        if (((b) ZeusTransformUtils.preCheckCast(this.m.get(r1), b.class, "com.obric.memorydata.plugin")).f14183a != r10) goto L3;
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        j(r10);
        this.m.remove(r1);
        goto L3
    L9:
        a(this.n, r10);
        if (this.k.remove(r10) == false) goto L13;
        r0.setAlpha(1.0f);
        i(r10);
    L13:
        if (this.l.remove(r10) == false) goto L15;
        r0.setAlpha(1.0f);
        k(r10);
    L15:
        int r2 = this.c.size() - 1;
    L16:
        if (r2 < 0) goto L21;
        ArrayList r5 = (ArrayList) ZeusTransformUtils.preCheckCast(this.c.get(r2), ArrayList.class, "com.obric.memorydata.plugin");
        a(r5, r10);
        if (r5.isEmpty() == false) goto L20;
        this.c.remove(r2);
    L20:
        r2 = r2 - 1;
        goto L16
    L21:
        int r3 = this.f14164b.size() - 1;
    L22:
        if (r3 < 0) goto L32;
        ArrayList r6 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f14164b.get(r3), ArrayList.class, "com.obric.memorydata.plugin");
        int r7 = r6.size() - 1;
    L24:
        if (r7 < 0) goto L31;
        if (((b) ZeusTransformUtils.preCheckCast(r6.get(r7), b.class, "com.obric.memorydata.plugin")).f14183a == r10) goto L27;
        r7 = r7 - 1;
        goto L24
    L27:
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        j(r10);
        r6.remove(r7);
        if (r6.isEmpty() == false) goto L31;
        this.f14164b.remove(r3);
    L31:
        r3 = r3 - 1;
        goto L22
    L32:
        int r4 = this.f14163a.size() - 1;
    L33:
        if (r4 < 0) goto L40;
        ArrayList r8 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f14163a.get(r4), ArrayList.class, "com.obric.memorydata.plugin");
        if (r8.remove(r10) == false) goto L39;
        r0.setAlpha(1.0f);
        k(r10);
        if (r8.isEmpty() == false) goto L39;
        this.f14163a.remove(r4);
    L39:
        r4 = r4 - 1;
        goto L33
    L40:
        this.f.remove(r10);
        this.d.remove(r10);
        this.g.remove(r10);
        this.e.remove(r10);
        e();
    }

    void b(final RecyclerView.v r8, int r9, int r10, int r11, int r12) {
        final View r4 = r8.c;
        final int r3 = r11 - r9;
        final int r5 = r12 - r10;
        if (r3 == 0) goto L5;
        r4.animate().translationX(0.0f);
    L5:
        if (r5 == 0) goto L7;
        r4.animate().translationY(0.0f);
    L7:
        final ViewPropertyAnimator r6 = r4.animate();
        this.e.add(r8);
        r6.setDuration(g()).setListener(new AnonymousClass6(this, r8, r3, r4, r5, r6)).start();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public boolean c() {
        if (this.l.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.n.isEmpty() == false) goto L26;
        if (this.m.isEmpty() == false) goto L26;
        if (this.k.isEmpty() == false) goto L26;
        if (this.e.isEmpty() == false) goto L26;
        if (this.f.isEmpty() == false) goto L26;
        if (this.d.isEmpty() == false) goto L26;
        if (this.g.isEmpty() == false) goto L26;
        if (this.f14164b.isEmpty() == false) goto L26;
        if (this.f14163a.isEmpty() == false) goto L26;
        if (this.c.isEmpty() == false) goto L26;
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.z
    public boolean c(RecyclerView.v r3) {
        v(r3);
        r3.c.setAlpha(0.0f);
        this.l.add(r3);
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e
    public void d() {
        int r0 = this.m.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.m.get(r0), b.class, "com.obric.memorydata.plugin");
        View r3 = r2.f14183a.c;
        r3.setTranslationY(0.0f);
        r3.setTranslationX(0.0f);
        j(r2.f14183a);
        this.m.remove(r0);
        goto L3
    L6:
        int r1 = this.k.size() - 1;
    L7:
        if (r1 < 0) goto L9;
        i((RecyclerView.v) ZeusTransformUtils.preCheckCast(this.k.get(r1), RecyclerView.v.class, "com.obric.memorydata.plugin"));
        this.k.remove(r1);
        r1 = r1 - 1;
        goto L7
    L9:
        int r4 = this.l.size();
    L10:
        r4 = r4 - 1;
        if (r4 < 0) goto L13;
        RecyclerView.v r5 = (RecyclerView.v) ZeusTransformUtils.preCheckCast(this.l.get(r4), RecyclerView.v.class, "com.obric.memorydata.plugin");
        r5.c.setAlpha(1.0f);
        k(r5);
        this.l.remove(r4);
        goto L10
    L13:
        int r6 = this.n.size() - 1;
    L14:
        if (r6 < 0) goto L16;
        b((a) ZeusTransformUtils.preCheckCast(this.n.get(r6), a.class, "com.obric.memorydata.plugin"));
        r6 = r6 - 1;
        goto L14
    L16:
        this.n.clear();
        if (c() == true) goto L19;
        return;
    L19:
        int r7 = this.f14164b.size() - 1;
    L20:
        if (r7 < 0) goto L28;
        ArrayList r8 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f14164b.get(r7), ArrayList.class, "com.obric.memorydata.plugin");
        int r9 = r8.size() - 1;
    L22:
        if (r9 < 0) goto L27;
        b r10 = (b) ZeusTransformUtils.preCheckCast(r8.get(r9), b.class, "com.obric.memorydata.plugin");
        View r11 = r10.f14183a.c;
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        j(r10.f14183a);
        r8.remove(r9);
        if (r8.isEmpty() == false) goto L26;
        this.f14164b.remove(r8);
    L26:
        r9 = r9 - 1;
        goto L22
    L27:
        r7 = r7 - 1;
        goto L20
    L28:
        int r12 = this.f14163a.size() - 1;
    L29:
        if (r12 < 0) goto L37;
        ArrayList r13 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f14163a.get(r12), ArrayList.class, "com.obric.memorydata.plugin");
        int r14 = r13.size() - 1;
    L31:
        if (r14 < 0) goto L36;
        RecyclerView.v r15 = (RecyclerView.v) ZeusTransformUtils.preCheckCast(r13.get(r14), RecyclerView.v.class, "com.obric.memorydata.plugin");
        r15.c.setAlpha(1.0f);
        k(r15);
        r13.remove(r14);
        if (r13.isEmpty() == false) goto L35;
        this.f14163a.remove(r13);
    L35:
        r14 = r14 - 1;
        goto L31
    L36:
        r12 = r12 - 1;
        goto L29
    L37:
        int r16 = this.c.size() - 1;
    L38:
        if (r16 < 0) goto L46;
        ArrayList r17 = (ArrayList) ZeusTransformUtils.preCheckCast(this.c.get(r16), ArrayList.class, "com.obric.memorydata.plugin");
        int r18 = r17.size() - 1;
    L40:
        if (r18 < 0) goto L45;
        b((a) ZeusTransformUtils.preCheckCast(r17.get(r18), a.class, "com.obric.memorydata.plugin"));
        if (r17.isEmpty() == false) goto L44;
        this.c.remove(r17);
    L44:
        r18 = r18 - 1;
        goto L40
    L45:
        r16 = r16 - 1;
        goto L38
    L46:
        a(this.f);
        a(this.e);
        a(this.d);
        a(this.g);
        j();
    }

    void d(final RecyclerView.v r6) {
        final View r0 = r6.c;
        final ViewPropertyAnimator r1 = r0.animate();
        this.d.add(r6);
        r1.alpha(1.0f).setDuration(h()).setInterpolator(j).setListener(new AnonymousClass5(this, r6, r0, r1)).start();
    }

    void e() {
        if (c() == true) goto L6;
        j();
        return;
    }
}
