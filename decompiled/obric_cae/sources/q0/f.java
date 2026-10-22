package q0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f10113a;

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f10114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f10115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10116c;

        public a(TextView r8) {
            this.f10114a = r8;
            this.f10116c = true;
            this.f10115b = new d(r8);
        }

        @Override // q0.f.b
        public final InputFilter[] a(InputFilter[] r8) {
            int r10 = 0;
            if (this.f10116c == true) goto L22;
            SparseArray r11 = new SparseArray(1);
            int r12 = 0;
        L6:
            if (r12 >= r8.length) goto L12;
            InputFilter r13 = r8[r12];
            if ((r13 instanceof d) == false) goto L10;
            r11.put(r12, r13);
        L10:
            r12 = r12 + 1;
            goto L6
        L12:
            if (r11.size() == 0) goto L39;
            int r14 = r8.length;
            InputFilter[] r15 = new InputFilter[r8.length - r11.size()];
            int r16 = 0;
        L15:
            if (r10 >= r14) goto L21;
            if (r11.indexOfKey(r10) >= 0) goto L19;
            r15[r16] = r8[r10];
            r16 = r16 + 1;
        L19:
            r10 = r10 + 1;
            goto L15
        L21:
            return r15;
        L39:
            return r8;
        L22:
            int r17 = r8.length;
            int r18 = 0;
        L23:
            d r19 = this.f10115b;
            if (r18 >= r17) goto L29;
            if (r8[r18] == r19) goto L40;
            r18 = r18 + 1;
            goto L23
        L40:
            return r8;
        L29:
            InputFilter[] r20 = new InputFilter[r8.length + 1];
            System.arraycopy(r8, 0, r20, 0, r17);
            r20[r17] = r19;
            return r20;
        }

        @Override // q0.f.b
        public final void b(boolean r8) {
            if (r8 == false) goto L5;
            d();
            return;
        }

        @Override // q0.f.b
        public final void c(boolean r8) {
            this.f10116c = r8;
            d();
            TextView r10 = this.f10114a;
            r10.setFilters(a(r10.getFilters()));
        }

        public final void d() {
            TextView r8 = this.f10114a;
            TransformationMethod r10 = r8.getTransformationMethod();
            if (this.f10116c == false) goto L12;
            if ((r10 instanceof h) == false) goto L8;
        L14:
            r8.setTransformationMethod(r10);
            return;
        L8:
            if ((r10 instanceof PasswordTransformationMethod) == true) goto L14;
            r10 = new h(r10);
            goto L14
        L12:
            if ((r10 instanceof h) == false) goto L14;
            r10 = ((h) r10).f10123a;
            goto L14
        }
    }

    public static class b {
        public InputFilter[] a(InputFilter[] r8) {
            throw null;
        }

        public void b(boolean r8) {
            throw null;
        }

        public void c(boolean r8) {
            throw null;
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f10117a;

        public c(TextView r8) {
            this.f10117a = new a(r8);
        }

        @Override // q0.f.b
        public final InputFilter[] a(InputFilter[] r8) {
            if (androidx.emoji2.text.f.f1747j == null) goto L5;
            boolean r10 = true;
        L7:
            if ((!r10) == false) goto L10;
            return r8;
        L10:
            return this.f10117a.a(r8);
        L5:
            r10 = false;
            goto L7
        }

        @Override // q0.f.b
        public final void b(boolean r8) {
            if (androidx.emoji2.text.f.f1747j == null) goto L5;
            boolean r10 = true;
        L7:
            if ((!r10) == false) goto L9;
            return;
        L9:
            this.f10117a.b(r8);
            return;
        L5:
            r10 = false;
            goto L7
        }

        @Override // q0.f.b
        public final void c(boolean r8) {
            if (androidx.emoji2.text.f.f1747j == null) goto L5;
            boolean r10 = true;
        L6:
            boolean r11 = !r10;
            a r12 = this.f10117a;
            if (r11 == false) goto L9;
            r12.f10116c = r8;
            return;
        L9:
            r12.c(r8);
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    public f(TextView r8) {
        t2.b.n(r8, "textView cannot be null");
        this.f10113a = new c(r8);
    }
}
