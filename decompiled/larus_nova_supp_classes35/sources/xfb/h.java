package xfb;

import android.graphics.Point;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ Function1<Point, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public h(g r1, Function1<? super Point, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        WeakReference<View> r0 = this.a.a;
        if (r0 == null) goto L5;
        View r1 = r0.get();
    L6:
        if (r1 != null) goto L8;
        this.a.a();
    L8:
        WeakReference<View> r2 = this.a.a;
        if (r2 == null) goto L13;
        View r3 = r2.get();
        if (r3 == null) goto L13;
        Log.i("ScreenSizeManager", "viewWidth: " + r3.getWidth() + ", viewHeight: " + r3.getHeight());
        Point r4 = new Point(r3.getWidth(), r3.getHeight());
    L14:
        this.b.invoke(r4);
        return;
    L13:
        Log.i("ScreenSizeManager", "get an empty Point");
        r4 = new Point();
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
