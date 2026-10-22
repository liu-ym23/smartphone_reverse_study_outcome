package io.noties.markwon.html;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: io.noties.markwon.html.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class a extends c {

        /* JADX INFO: renamed from: io.noties.markwon.html.c$a$a, reason: collision with other inner class name */
        private static class C0865a implements Iterable<d> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f16559a;

            /* JADX INFO: renamed from: io.noties.markwon.html.c$a$a$a, reason: collision with other inner class name */
            private class C0866a implements Iterator<d> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ C0865a f16560a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final d f16561b;
                private final StringBuilder c;
                private final int d;
                private int e;

                private C0866a(C0865a r2) {
                    this.f16560a = r2;
                    this.f16561b = new d();
                    this.c = new StringBuilder();
                    this.d = C0865a.a(r2).length();
                }

                /* synthetic */ C0866a(C0865a r1, AnonymousClass1 r2) {
                    this(r1);
                }

                private boolean a(String r1, String r2) {
                    if (TextUtils.isEmpty(r1) == false) goto L5;
                L7:
                    return false;
                L5:
                    if (TextUtils.isEmpty(r2) == true) goto L7;
                    return true;
                }

                private void b() {
                    this.f16561b.a("", "");
                    this.c.setLength(0);
                    int r0 = this.e;
                    String r2 = null;
                    boolean r4 = false;
                    String r3 = null;
                L4:
                    if (r0 >= this.d) goto L35;
                    char r5 = C0865a.a(this.f16560a).charAt(r0);
                    if (r2 == null) goto L8;
                    if (r3 != null) goto L34;
                    if (Character.isWhitespace(r5) == true) goto L26;
                    if (';' != r5) goto L33;
                    r3 = this.c.toString().trim();
                    this.c.setLength(0);
                    if (a(r2, r3) == false) goto L34;
                    this.e = r0 + 1;
                    this.f16561b.a(r2, r3);
                    return;
                L33:
                    this.c.append(r5);
                    goto L34
                L26:
                    if (this.c.length() > 0) goto L33;
                L34:
                    r0 = r0 + 1;
                    goto L4
                L8:
                    if (':' == r5) goto L10;
                    if (';' != r5) goto L16;
                L12:
                    this.c.setLength(0);
                    goto L34
                L16:
                    if (Character.isWhitespace(r5) == true) goto L18;
                    if (r4 == false) goto L33;
                    this.c.setLength(0);
                    this.c.append(r5);
                    r4 = false;
                    goto L34
                L18:
                    if (this.c.length() <= 0) goto L34;
                    r4 = true;
                    goto L34
                L10:
                    if (this.c.length() <= 0) goto L12;
                    r2 = this.c.toString().trim();
                    goto L12
                L35:
                    if (r2 != null) goto L37;
                    return;
                L37:
                    if (this.c.length() <= 0) goto L51;
                    this.f16561b.a(r2, this.c.toString().trim());
                    this.e = this.d;
                    return;
                }

                private boolean c() {
                    return a(this.f16561b.a(), this.f16561b.b());
                }

                public d a() {
                    if (c() == false) goto L7;
                    return this.f16561b;
                L7:
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    b();
                    return c();
                }

                @Override // java.util.Iterator
                public /* synthetic */ d next() {
                    return a();
                }
            }

            C0865a(String r1) {
                this.f16559a = r1;
            }

            static /* synthetic */ String a(C0865a r0) {
                return r0.f16559a;
            }

            @Override // java.lang.Iterable
            public Iterator<d> iterator() {
                return new C0866a(this, null);
            }
        }

        a() {
        }

        @Override // io.noties.markwon.html.c
        public Iterable<d> a(String r1) {
            return new C0865a(r1);
        }
    }

    public c() {
    }

    public static c a() {
        return new a();
    }

    public abstract Iterable<d> a(String r1);
}
