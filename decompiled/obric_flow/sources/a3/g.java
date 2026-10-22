package a3;

import com.obric.widget.host.internal.DefaultWidgetHostView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f78a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f79b;

    public /* synthetic */ g(int r5, Function0 r10) {
        this.f78a = r5;
        this.f79b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f78a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        this.f79b.invoke();
        return;
    L6:
        DefaultWidgetHostView.a(this.f79b);
        return;
    L8:
        Function0 r5 = this.f79b;
        Intrinsics.checkNotNullParameter(r5, "$endFun");
        r5.invoke();
        return;
    L10:
        this.f79b.invoke();
        return;
    L12:
        this.f79b.invoke();
    }
}
