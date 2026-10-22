package u7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.util.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a {
    public final Context a;
    public final ViewGroup b;
    public View c;

    /* JADX INFO: renamed from: u7.a$a, reason: collision with other inner class name */
    public static final class RunnableC0202a implements Runnable {
        public final /* synthetic */ a a;

        public RunnableC0202a(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.b.getVisibility() == 8) goto L9;
            this.a.b.setVisibility(8);     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.b.getVisibility() == 0) goto L9;
            this.a.b.setVisibility(0);     // Catch: Throwable -> L6
            return;
        }
    }

    public abstract View b();

    public void c() {
        ThreadUtils.c(new RunnableC0202a(this));
    }

    public void d() {
        ThreadUtils.c(new b(this));
    }

    public View a() {
        View r0 = b();
        this.b.addView(r0);
        this.c = r0;
        return r0;
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parent");
        this.a = r10;
        this.b = r11;
    }
}
