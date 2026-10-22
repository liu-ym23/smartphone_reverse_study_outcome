package qa;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f2 f10963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f2 f10964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m2 f10965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f10966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f10967e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f10968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f2 f10970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f2 f10971d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f2 f10972e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList f10973f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ArrayList f10974g;

        public a() {
            this.f10973f = new ArrayList();
            this.f10974g = new ArrayList();
        }

        public static boolean b(f2 r8, f2 r10) {
            if (r8 == null) goto L48;
            if (r10 == null) goto L48;
            if ((r8 instanceof h2) == false) goto L17;
            if ((r10 instanceof h2) == false) goto L17;
            h2 r11 = (h2) r8;
            h2 r12 = (h2) r10;
            if (r11.f10498t == r12.f10498t) goto L13;
        L15:
            return false;
        L13:
            if (r11.f10499u != r12.f10499u) goto L15;
            return true;
        L17:
            if ((r8 instanceof g2) == false) goto L29;
            if ((r10 instanceof g2) == false) goto L29;
            g2 r13 = (g2) r8;
            g2 r14 = (g2) r10;
            if (r13.f10448v == r14.f10448v) goto L23;
        L27:
            return false;
        L23:
            if (r13.f10447u != r14.f10447u) goto L27;
            if (r13.f10446t != r14.f10446t) goto L27;
            return true;
        L29:
            if ((r8 instanceof i2) == false) goto L39;
            if ((r10 instanceof i2) == false) goto L39;
            i2 r15 = (i2) r8;
            i2 r16 = (i2) r10;
            if (r15.f10520t == r16.f10520t) goto L35;
        L37:
            return false;
        L35:
            if (r15.f10521u != r16.f10521u) goto L37;
            return true;
        L39:
            if ((r8 instanceof j2) == true) goto L41;
        L47:
            return false;
        L41:
            if ((r10 instanceof j2) == false) goto L47;
            j2 r17 = (j2) r8;
            j2 r18 = (j2) r10;
            if (r17.f10624t != r18.f10624t) goto L47;
            if (r17.f10625u != r18.f10625u) goto L47;
            return true;
        L48:
            if (r8 != null) goto L50;
            boolean r19 = true;
        L51:
            if (r10 != null) goto L53;
            boolean r20 = true;
        L54:
            if (r19 != r20) goto L56;
            return true;
        L56:
            return false;
        L53:
            r20 = false;
            goto L54
        L50:
            r19 = false;
            goto L51
        }

        public final void a() {
            this.f10968a = 0;
            this.f10969b = "";
            this.f10970c = null;
            this.f10971d = null;
            this.f10972e = null;
            this.f10973f.clear();
            this.f10974g.clear();
        }

        public final String toString() {
            return "CellInfo{radio=" + this.f10968a + ", operator='" + this.f10969b + "', mainCell=" + this.f10970c + ", mainOldInterCell=" + this.f10971d + ", mainNewInterCell=" + this.f10972e + ", cells=" + this.f10973f + ", historyMainCellList=" + this.f10974g + '}';
        }
    }

    public r1() {
        this.f10966d = new a();
        this.f10967e = new ArrayList(3);
    }

    public final void a(f2 r10) {
        ArrayList r11 = this.f10967e;
        int r8 = r11.size();
        if (r8 == 0) goto L20;
        int r12 = -1;
        long r13 = Long.MAX_VALUE;
        int r14 = 0;
        int r15 = -1;
    L6:
        if (r14 >= r8) goto L16;
        f2 r16 = (f2) r11.get(r14);
        if (r10.equals(r16) == true) goto L9;
        r13 = Math.min(r13, r16.f10406o);
        if (r13 != r16.f10406o) goto L15;
        r15 = r14;
    L15:
        r14 = r14 + 1;
        goto L6
    L9:
        int r17 = r10.f10404m;
        if (r17 == r16.f10404m) goto L17;
        r16.f10406o = r17;
        r16.f10404m = r17;
    L17:
        if (r12 >= 0) goto L19;
        return;
    L19:
        if (r8 < 3) goto L20;
        if (r10.f10406o <= r13) goto L32;
        if (r12 >= r8) goto L33;
        r11.remove(r12);
        r11.add(r10);
        return;
    L33:
        return;
    L32:
        return;
    L16:
        r12 = r15;
    L20:
        r11.add(r10);
    }
}
