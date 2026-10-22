package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements d1.b<Boolean> {

    public static class a extends f.c {
        public a(Context r8) {
            super(new b(r8));
            this.f1760b = 1;
        }
    }

    public static class b implements f.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1739a;

        public b(Context r8) {
            this.f1739a = r8.getApplicationContext();
        }

        @Override // androidx.emoji2.text.f.g
        public final void a(f.h r11) {
            androidx.emoji2.text.a r8 = new androidx.emoji2.text.a("EmojiCompatInitializer", 0);
            ThreadPoolExecutor r10 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r8);
            r10.allowCoreThreadTimeOut(true);
            r10.execute(new g(this, r11, r10, 0));
        }
    }

    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            f0.h.a("EmojiCompat.EmojiCompatInitializer.run");     // Catch: Throwable -> L10
            if (f.f1747j == null) goto L5;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L8;
            f.a().c();     // Catch: Throwable -> L10
        L8:
            f0.h.b();
            return;
        L5:
            r8 = false;
        L10:
            th = move-exception;
            f0.h.b();
            throw th;
        }
    }

    public EmojiCompatInitializer() {
    }

    @Override // d1.b
    public final List<Class<? extends d1.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // d1.b
    public final /* bridge */ /* synthetic */ Boolean b(Context r8) {
        return c(r8);
    }

    public final Boolean c(Context r8) {
        a r10 = new a(r8);
        if (f.f1747j != null) goto L14;
        Object r11 = f.f1746i;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f.f1747j != null) goto L9;
        f.f1747j = new f(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    L14:
        d1.a r12 = d1.a.c(r8);
        r12.getClass();
        Object r13 = d1.a.f6746e;
        monitor-enter(r13);
        Object r14 = r12.f6747a.get(ProcessLifecycleInitializer.class);     // Catch: Throwable -> L19
        if (r14 != null) goto L21;
        r14 = r12.b(ProcessLifecycleInitializer.class, new HashSet());     // Catch: Throwable -> L19
    L21:
        monitor-exit(r13);     // Catch: Throwable -> L19
        final androidx.lifecycle.h r15 = ((androidx.lifecycle.m) r14).getLifecycle();
        r15.a(new AnonymousClass1(this, r15));
        return Boolean.TRUE;
    L19:
        th = move-exception;
        throw th;
    }
}
