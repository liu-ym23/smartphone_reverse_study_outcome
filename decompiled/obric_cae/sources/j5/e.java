package j5;

import android.text.TextUtils;
import java.util.List;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f8658a;

    public class a implements c<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f8659a;

        public a(e r8) {
            this.f8659a = r8;
        }

        @Override // j5.e.c
        public final boolean a(String r8, String r10) {
            return x0.e(r8, r10);
        }

        @Override // j5.e.c
        public final String b(String r8, String r10, e r11) {
            return r11.h(r8, r10);
        }

        @Override // j5.e.c
        public final boolean c(String r8) {
            return x0.g(r8);
        }

        @Override // j5.e.c
        public final void d(String r8) {
            e r10 = this.f8659a;
            r10.b("openudid", r8);
        }

        @Override // j5.e.c
        public final String e() {
            return this.f8659a.c("openudid");
        }
    }

    public class b implements c<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f8660a;

        public b(e r8) {
            this.f8660a = r8;
        }

        @Override // j5.e.c
        public final boolean a(String r8, String r10) {
            return x0.e(r8, r10);
        }

        @Override // j5.e.c
        public final String b(String r8, String r10, e r11) {
            return r11.a(r8, r10);
        }

        @Override // j5.e.c
        public final boolean c(String r8) {
            return !TextUtils.isEmpty(r8);
        }

        @Override // j5.e.c
        public final void d(String r8) {
            e r10 = this.f8660a;
            r10.b("device_id", r8);
        }

        @Override // j5.e.c
        public final String e() {
            return this.f8660a.c("device_id");
        }
    }

    public interface c<L> {
        boolean a(L r8, L r10);

        L b(L r8, L r10, e r11);

        boolean c(L r8);

        void d(L r8);

        L e();
    }

    @Override // j5.m
    public final String a(String r8, String r10) {
        return (String) g(r8, r10, new b(this));
    }

    public abstract void d(String[] r8);

    public void e(List<String> r8) {
        e r10 = this.f8658a;
        if (r10 == null) goto L6;
        r10.e(r8);
        return;
    }

    public abstract String[] f();

    public final <T> T g(T r8, T r10, c<T> r11) {
        e r12 = this.f8658a;
        T r13 = r11.e();
        boolean r14 = r11.c(r8);
        boolean r15 = r11.c(r13);
        if (r14 == true) goto L6;
        if (r15 == false) goto L6;
        r8 = r13;
    L6:
        if (r12 == null) goto L11;
        T r16 = r11.b(r8, r10, r12);
        if (r11.a(r16, r13) == true) goto L10;
        r11.d(r16);
    L10:
        return r16;
    L11:
        if (r14 == true) goto L14;
        if (r15 == true) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == true) goto L17;
    L18:
        if (r14 == true) goto L20;
    L22:
        return r10;
    L20:
        if (r11.a(r10, r13) == true) goto L22;
    L21:
        r11.d(r10);
        goto L22
    L17:
        if (r11.c(r10) == true) goto L21;
    L14:
        r17 = false;
        r10 = r8;
        goto L15
    }

    public final String h(String r8, String r10) {
        return (String) g(r8, r10, new a(this));
    }
}
