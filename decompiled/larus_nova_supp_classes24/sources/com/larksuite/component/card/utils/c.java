package com.larksuite.component.card.utils;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.utils.a1;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.select.m;
import com.ss.android.lark.widget.select.p;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements m.d {
        public final /* synthetic */ Function1<CharSequence, Unit> a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ com.ss.android.lark.widget.select.a c;
        public final /* synthetic */ int d;

        /* JADX INFO: renamed from: com.larksuite.component.card.utils.c$a$a, reason: collision with other inner class name */
        public static final class C0031a implements u.c {
            public final /* synthetic */ com.ss.android.lark.widget.select.a a;
            public final /* synthetic */ Function1<CharSequence, Unit> b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;
            public final /* synthetic */ int e;
            public final /* synthetic */ int f;
            public final /* synthetic */ boolean g;
            public final /* synthetic */ int h;

            /* JADX INFO: renamed from: com.larksuite.component.card.utils.c$a$a$a, reason: collision with other inner class name */
            public static final class RunnableC0032a implements Runnable {
                public final /* synthetic */ com.ss.android.lark.widget.select.a a;
                public final /* synthetic */ Function1<CharSequence, Unit> b;

                /* JADX WARN: Multi-variable type inference failed */
                public RunnableC0032a(com.ss.android.lark.widget.select.a r1, Function1<? super CharSequence, Unit> r2) {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a();     // Catch: Throwable -> L4
                    this.b.invoke("");     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public final void a() {
                UICallbackExecutor.post(new RunnableC0032a(this.a, this.b));
            }

            public final void b() {
                this.a.b();
            }

            public final void c() {
                this.a.f();
            }

            public final void d(int[] r2) {
                this.a.g(r2);
            }

            public final a1 e(boolean r9) {
                if (r9 == true) goto L4;
                com.ss.android.lark.widget.select.g r10 = this.a.c();
                if (r10 != null) goto L10;
                return null;
            L10:
                return new a1(r10.b, r10.c, r10.d, r10.e, r10.f, this.h);
            L4:
                return new a1(this.c, this.d, this.e, this.f, this.g, this.h);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0031a(com.ss.android.lark.widget.select.a r1, Function1<? super CharSequence, Unit> r2, int r3, int r4, int r5, int r6, boolean r7, boolean r8, int r9) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
                this.g = r7;
                this.h = r9;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super CharSequence, Unit> r1, Function0<Unit> r2, com.ss.android.lark.widget.select.a r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a(com.ss.android.lark.widget.select.g r12) {
            Intrinsics.checkNotNullParameter(r12, "<destruct>");
            CharSequence r0 = r12.a;
            int r4 = r12.b;
            int r5 = r12.c;
            int r6 = r12.d;
            int r7 = r12.e;
            boolean r8 = r12.f;
            boolean r13 = r12.g;
            this.a.invoke(r0);
            C0031a r1 = new C0031a(this.c, this.a, r4, r5, r6, r7, r8, r13, this.d);
            u r2 = u.a.a;
            monitor-enter(r2);
            r2.c();     // Catch: Throwable -> L8
            r2.a = r1;     // Catch: Throwable -> L8
            monitor-exit(r2);
            r2.c = r13;
            r2.d = true;
            this.b.invoke();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static final class b implements m.c {
        public b() {
        }

        public final /* synthetic */ void a() {
        }

        public final void b() {
            u r0 = u.a.a;
            monitor-enter(r0);
            r0.c();     // Catch: Throwable -> L8
            r0.a = null;     // Catch: Throwable -> L8
            monitor-exit(r0);
            r0.e();
            r0.f = true;
            r0.g = 1;
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public static void a(View r1, com.ss.android.lark.widget.select.a r2, Function1 r3, Function0 r4) {
        int[] r0 = new int[2];
        r1.getLocationOnScreen(r0);
        r2.d(new a(r3, r4, r2, r0[0]));
        r2.e(new b());
        r2.show();
    }

    @JvmStatic
    public static final void b(AppCompatTextView r3, Activity r4, Function1<? super CharSequence, Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r5, "changeCopyAction");
        Intrinsics.checkNotNullParameter(r6, "onTextSelectedAction");
        p.a r0 = new p.a(r3, r4);
        r0.c = UIUtils.getColor(r3.getContext(), 2131105548);
        r0.e = UIHelper.dp2px(15.0f);
        r0.d = j08.b.c(r3.getContext(), 2131105548, 0.2f);
        p r7 = new p(r0);
        Intrinsics.checkNotNull(r7);
        a(r3, r7, r5, r6);
    }
}
