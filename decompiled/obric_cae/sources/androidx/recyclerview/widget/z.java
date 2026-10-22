package androidx.recyclerview.widget;

import android.view.View;
import com.sdk.bwdl.Utils.BWDLInnerConstant;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2570b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2573c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2574d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2575e;

        public a() {
            this.f2571a = 0;
        }

        public final boolean a() {
            int r8 = this.f2571a;
            int r10 = 2;
            if ((r8 & 7) == 0) goto L14;
            int r11 = this.f2574d;
            int r12 = this.f2572b;
            if (r11 <= r12) goto L7;
            int r13 = 1;
        L11:
            if (((r13 << 0) & r8) != 0) goto L14;
            return false;
        L7:
            if (r11 != r12) goto L9;
            r13 = 2;
            goto L11
        L9:
            r13 = 4;
        L14:
            if ((r8 & BWDLInnerConstant.LINK_RECOVERY) == 0) goto L25;
            int r14 = this.f2574d;
            int r15 = this.f2573c;
            if (r14 <= r15) goto L18;
            int r16 = 1;
        L22:
            if (((r16 << 4) & r8) != 0) goto L25;
            return false;
        L18:
            if (r14 != r15) goto L20;
            r16 = 2;
            goto L22
        L20:
            r16 = 4;
        L25:
            if ((r8 & 1792) == 0) goto L36;
            int r17 = this.f2575e;
            int r18 = this.f2572b;
            if (r17 <= r18) goto L29;
            int r19 = 1;
        L33:
            if (((r19 << 8) & r8) != 0) goto L36;
            return false;
        L29:
            if (r17 != r18) goto L31;
            r19 = 2;
            goto L33
        L31:
            r19 = 4;
        L36:
            if ((r8 & 28672) == 0) goto L46;
            int r20 = this.f2575e;
            int r21 = this.f2573c;
            if (r20 <= r21) goto L40;
            r10 = 1;
        L44:
            if (((r10 << 12) & r8) != 0) goto L46;
            return false;
        L40:
            if (r20 == r21) goto L44;
            r10 = 4;
        L46:
            return true;
        }
    }

    public interface b {
        int a(View r8);

        int b();

        int c();

        View d(int r8);

        int e(View r8);
    }

    public z(b r8) {
        this.f2569a = r8;
        this.f2570b = new a();
    }

    public final View a(int r10, int r11, int r12, int r13) {
        b r8 = this.f2569a;
        int r14 = r8.b();
        int r15 = r8.c();
        if (r11 <= r10) goto L5;
        int r16 = 1;
    L6:
        View r17 = null;
    L7:
        if (r10 == r11) goto L18;
        View r18 = r8.d(r10);
        int r19 = r8.a(r18);
        int r20 = r8.e(r18);
        a r21 = this.f2570b;
        r21.f2572b = r14;
        r21.f2573c = r15;
        r21.f2574d = r19;
        r21.f2575e = r20;
        if (r12 == 0) goto L13;
        r21.f2571a = r12 | 0;
        if (r21.a() == false) goto L13;
        return r18;
    L13:
        if (r13 == 0) goto L17;
        r21.f2571a = r13 | 0;
        if (r21.a() == false) goto L17;
        r17 = r18;
    L17:
        r10 = r10 + r16;
        goto L7
    L18:
        return r17;
    L5:
        r16 = -1;
        goto L6
    }

    public final boolean b(View r8) {
        b r10 = this.f2569a;
        int r11 = r10.b();
        int r12 = r10.c();
        int r13 = r10.a(r8);
        int r14 = r10.e(r8);
        a r15 = this.f2570b;
        r15.f2572b = r11;
        r15.f2573c = r12;
        r15.f2574d = r13;
        r15.f2575e = r14;
        r15.f2571a = 24579 | 0;
        return r15.a();
    }
}
