package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f.i f1774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f1775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.d f1776c;

    public static final class a {
        public static int a(CharSequence r8, int r10, int r11) {
            int r12 = r8.length();
            if (r10 < 0) goto L30;
            if (r12 < r10) goto L30;
            if (r11 >= 0) goto L9;
            return -1;
        L9:
            boolean r13 = false;
        L10:
            if (r11 == 0) goto L11;
            r10 = r10 - 1;
            if (r10 < 0) goto L14;
            char r14 = r8.charAt(r10);
            if (r13 == true) goto L20;
            if (Character.isSurrogate(r14) == false) goto L25;
            if (Character.isHighSurrogate(r14) == true) goto L28;
            r13 = true;
            goto L10
        L28:
            return -1;
        L25:
            r11 = r11 - 1;
            goto L10
        L20:
            if (Character.isHighSurrogate(r14) == false) goto L21;
            r11 = r11 - 1;
            goto L9
        L21:
            return -1;
        L14:
            if (r13 == false) goto L16;
            return -1;
        L16:
            return 0;
        L11:
            return r10;
        L30:
            return -1;
        }

        public static int b(CharSequence r8, int r10, int r11) {
            int r12 = r8.length();
            if (r10 < 0) goto L29;
            if (r12 < r10) goto L29;
            if (r11 >= 0) goto L9;
            return -1;
        L9:
            boolean r13 = false;
        L10:
            if (r11 == 0) goto L11;
            if (r10 >= r12) goto L13;
            char r14 = r8.charAt(r10);
            if (r13 == true) goto L19;
            if (Character.isSurrogate(r14) == false) goto L24;
            if (Character.isLowSurrogate(r14) == true) goto L27;
            r10 = r10 + 1;
            r13 = true;
            goto L10
        L27:
            return -1;
        L24:
            r11 = r11 - 1;
            r10 = r10 + 1;
            goto L10
        L19:
            if (Character.isLowSurrogate(r14) == false) goto L20;
            r11 = r11 - 1;
            r10 = r10 + 1;
            goto L9
        L20:
            return -1;
        L13:
            if (r13 == false) goto L15;
            return -1;
        L15:
            return r12;
        L11:
            return r10;
        L29:
            return -1;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n.a f1778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n.a f1779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public n.a f1780d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1781e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1782f;

        public b(n.a r8) {
            this.f1777a = 1;
            this.f1778b = r8;
            this.f1779c = r8;
        }

        public final int a(int r8) {
            SparseArray<n.a> r10 = this.f1779c.f1800a;
            if (r10 != null) goto L5;
            n.a r11 = null;
        L6:
            int r12 = 1;
            if (this.f1777a == 2) goto L11;
            if (r11 == null) goto L32;
            this.f1777a = 2;
            this.f1779c = r11;
            this.f1782f = 1;
        L23:
            r12 = 2;
        L33:
            this.f1781e = r8;
            return r12;
        L32:
            b();
            goto L33
        L11:
            if (r11 == null) goto L13;
            this.f1779c = r11;
            this.f1782f++;
            goto L23
        L13:
            boolean r13 = false;
            if (r8 != 65038) goto L16;
            boolean r14 = true;
        L17:
            if (r14 == true) goto L32;
            if (r8 != 65039) goto L22;
            r13 = true;
        L22:
            if (r13 == true) goto L23;
            n.a r15 = this.f1779c;
            if (r15.f1801b == null) goto L32;
            if (this.f1782f == 1) goto L29;
        L31:
            this.f1780d = r15;
            b();
            r12 = 3;
            goto L33
        L29:
            if (c() == false) goto L32;
            r15 = this.f1779c;
            goto L31
        L16:
            r14 = false;
            goto L17
        L5:
            r11 = r10.get(r8);
            goto L6
        }

        public final void b() {
            this.f1777a = 1;
            this.f1779c = this.f1778b;
            this.f1782f = 0;
        }

        public final boolean c() {
            p0.a r8 = this.f1779c.f1801b.c();
            int r10 = r8.a(6);
            if (r10 != 0) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r11 == false) goto L11;
            return true;
        L11:
            if (this.f1781e != 65039) goto L13;
            boolean r12 = true;
        L14:
            if (r12 == false) goto L16;
            return true;
        L16:
            return false;
        L13:
            r12 = false;
            goto L14
        L5:
            if (r8.f9913b.get(r10 + r8.f9912a) == 0) goto L7;
            r11 = true;
            goto L8
        }
    }

    public j(n r8, f.i r10, d r11) {
        this.f1774a = r10;
        this.f1775b = r8;
        this.f1776c = r11;
    }

    public static boolean a(Editable r8, KeyEvent r10, boolean r11) {
        if ((!KeyEvent.metaStateHasNoModifiers(r10.getMetaState())) == false) goto L5;
        return false;
    L5:
        int r12 = Selection.getSelectionStart(r8);
        int r13 = Selection.getSelectionEnd(r8);
        if (r12 == (-1)) goto L11;
        if (r13 == (-1)) goto L11;
        if (r12 != r13) goto L11;
        boolean r14 = false;
    L12:
        if (r14 == false) goto L14;
        return false;
    L14:
        k[] r15 = (k[]) r8.getSpans(r12, r13, k.class);
        if (r15 != null) goto L17;
    L30:
        return false;
    L17:
        if (r15.length <= 0) goto L30;
        int r16 = r15.length;
        int r17 = 0;
    L19:
        if (r17 >= r16) goto L30;
        k r18 = r15[r17];
        int r19 = r8.getSpanStart(r18);
        int r20 = r8.getSpanEnd(r18);
        if (r11 == false) goto L23;
        if (r19 != r12) goto L23;
    L27:
        r8.delete(r19, r20);
        return true;
    L23:
        if (r11 == true) goto L25;
        if (r20 == r12) goto L27;
    L25:
        if (r12 <= r19) goto L29;
        if (r12 < r20) goto L27;
    L29:
        r17 = r17 + 1;
    L11:
        r14 = true;
        goto L12
    }

    public static boolean b(InputConnection r8, Editable r10, int r11, int r12, boolean r13) {
        if (r10 == null) goto L33;
        if (r8 == null) goto L33;
        if (r11 < 0) goto L33;
        if (r12 < 0) goto L33;
        int r14 = Selection.getSelectionStart(r10);
        int r15 = Selection.getSelectionEnd(r10);
        if (r14 == (-1)) goto L15;
        if (r15 == (-1)) goto L15;
        if (r14 != r15) goto L15;
        boolean r16 = false;
    L16:
        if (r16 == false) goto L18;
        return false;
    L18:
        if (r13 == false) goto L23;
        int r17 = a.a(r10, r14, Math.max(r11, 0));
        int r18 = a.b(r10, r15, Math.max(r12, 0));
        if (r17 == (-1)) goto L22;
        if (r18 == (-1)) goto L22;
    L24:
        k[] r19 = (k[]) r10.getSpans(r17, r18, k.class);
        if (r19 == null) goto L33;
        if (r19.length <= 0) goto L33;
        int r20 = r19.length;
        int r21 = 0;
    L29:
        if (r21 >= r20) goto L31;
        k r22 = r19[r21];
        int r23 = r10.getSpanStart(r22);
        int r24 = r10.getSpanEnd(r22);
        r17 = Math.min(r23, r17);
        r18 = Math.max(r24, r18);
        r21 = r21 + 1;
        goto L29
    L31:
        int r25 = Math.max(r17, 0);
        int r26 = Math.min(r18, r10.length());
        r8.beginBatchEdit();
        r10.delete(r25, r26);
        r8.endBatchEdit();
        return true;
    L22:
        return false;
    L23:
        r17 = Math.max(r14 - r11, 0);
        r18 = Math.min(r15 + r12, r10.length());
    L15:
        r16 = true;
    L33:
        return false;
    }

    public final boolean c(CharSequence r8, int r10, int r11, i r12) {
        if (r12.f1773c != 0) goto L19;
        f.d r13 = this.f1776c;
        p0.a r14 = r12.c();
        int r15 = r14.a(8);
        if (r15 == 0) goto L7;
        r14.f9913b.getShort(r15 + r14.f9912a);
    L7:
        d r16 = (d) r13;
        r16.getClass();
        ThreadLocal<StringBuilder> r17 = d.f1743b;
        if (r17.get() != null) goto L10;
        r17.set(new StringBuilder());
    L10:
        StringBuilder r18 = r17.get();
        r18.setLength(0);
    L11:
        if (r10 >= r11) goto L13;
        r18.append(r8.charAt(r10));
        r10 = r10 + 1;
        goto L11
    L13:
        TextPaint r19 = r16.f1744a;
        String r20 = r18.toString();
        int r21 = a0.c.f8a;
        if (a0.c.a.a(r19, r20) == false) goto L16;
        int r22 = 2;
    L17:
        r12.f1773c = r22;
        goto L19
    L16:
        r22 = 1;
    L19:
        if (r12.f1773c == 2) goto L21;
        return false;
    L21:
        return true;
    }
}
