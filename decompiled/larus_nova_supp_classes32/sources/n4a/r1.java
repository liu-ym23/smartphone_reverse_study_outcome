package n4a;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.dv;
import com.loc.dw;
import com.loc.dx;
import com.loc.dy;
import com.loc.dz;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r1 {
    public dv a;
    public dv b;
    public u2 c;
    public final a d;
    public final List<dv> e;

    public static class a {
        public byte a;
        public String b;
        public dv c;
        public dv d;
        public dv e;
        public final List<dv> f;
        public final List<dv> g;

        public a() {
            this.f = new ArrayList();
            this.g = new ArrayList();
        }

        public static boolean b(dv r4, dv r5) {
            if (r4 == null) goto L48;
            if (r5 == null) goto L48;
            if ((r4 instanceof dx) == false) goto L17;
            if ((r5 instanceof dx) == false) goto L17;
            dx r6 = (dx) r4;
            dx r7 = (dx) r5;
            if (r6.j == r7.j) goto L13;
        L15:
            return false;
        L13:
            if (r6.k != r7.k) goto L15;
            return true;
        L17:
            if ((r4 instanceof dw) == false) goto L29;
            if ((r5 instanceof dw) == false) goto L29;
            dw r8 = (dw) r4;
            dw r9 = (dw) r5;
            if (r8.l == r9.l) goto L23;
        L27:
            return false;
        L23:
            if (r8.k != r9.k) goto L27;
            if (r8.j != r9.j) goto L27;
            return true;
        L29:
            if ((r4 instanceof dy) == false) goto L39;
            if ((r5 instanceof dy) == false) goto L39;
            dy r10 = (dy) r4;
            dy r11 = (dy) r5;
            if (r10.j == r11.j) goto L35;
        L37:
            return false;
        L35:
            if (r10.k != r11.k) goto L37;
            return true;
        L39:
            if ((r4 instanceof dz) == true) goto L41;
        L47:
            return false;
        L41:
            if ((r5 instanceof dz) == false) goto L47;
            dz r12 = (dz) r4;
            dz r13 = (dz) r5;
            if (r12.j != r13.j) goto L47;
            if (r12.k != r13.k) goto L47;
            return true;
        L48:
            if (r4 != null) goto L50;
            boolean r14 = true;
        L51:
            if (r5 != null) goto L53;
            boolean r15 = true;
        L54:
            if (r14 != r15) goto L56;
            return true;
        L56:
            return false;
        L53:
            r15 = false;
            goto L54
        L50:
            r14 = false;
            goto L51
        }

        public final void a() {
            this.a = 0;
            this.b = NameKeys.UnloadStrategy_No_Strategy;
            this.c = null;
            this.d = null;
            this.e = null;
            ((ArrayList) this.f).clear();
            ((ArrayList) this.g).clear();
        }

        public final String toString() {
            return "CellInfo{radio=" + this.a + ", operator='" + this.b + "', mainCell=" + this.c + ", mainOldInterCell=" + this.d + ", mainNewInterCell=" + this.e + ", cells=" + this.f + ", historyMainCellList=" + this.g + '}';
        }
    }

    public r1() {
        this.d = new a();
        this.e = new ArrayList(3);
    }

    public final void a(dv r10) {
        int r0 = ((ArrayList) this.e).size();
        if (r0 == 0) goto L20;
        int r1 = -1;
        long r2 = Long.MAX_VALUE;
        int r4 = 0;
        int r5 = -1;
    L6:
        if (r4 >= r0) goto L16;
        dv r6 = (dv) ListProtector.get(this.e, r4);
        if (r10.equals(r6) == true) goto L9;
        r2 = Math.min(r2, r6.e);
        if (r2 != r6.e) goto L15;
        r5 = r4;
    L15:
        r4 = r4 + 1;
        goto L6
    L9:
        int r7 = r10.c;
        if (r7 == r6.c) goto L17;
        r6.e = r7;
        r6.c = r7;
    L17:
        if (r1 >= 0) goto L19;
        return;
    L19:
        if (r0 < 3) goto L20;
        if (r10.e <= r2) goto L32;
        if (r1 >= r0) goto L33;
        ListProtector.remove(this.e, r1);
        ((ArrayList) this.e).add(r10);
        return;
    L33:
        return;
    L32:
        return;
    L16:
        r1 = r5;
    L20:
        ((ArrayList) this.e).add(r10);
    }
}
