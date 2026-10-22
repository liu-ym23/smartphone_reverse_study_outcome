package obric.flow.miniappwidget;

import android.content.Context;
import android.os.Bundle;
import com.obric.widget.host.WidgetHostContract;
import com.obric.widget.host.WidgetPerfReporter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements WidgetHostContract {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.internal.c f20489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f20490c;

    public k(l r5) {
        this.f20490c = r5;
        this.f20488a = r5.d;
        this.f20489b = r5.f20498l;
    }

    @Override // com.obric.widget.host.WidgetHostContract
    public final Context getContext() {
        return this.f20488a;
    }

    @Override // com.obric.widget.host.WidgetHostContract
    public final CoroutineScope getCoroutineScope() {
        return this.f20489b;
    }

    @Override // com.obric.widget.host.WidgetHostContract
    public final WidgetPerfReporter getPerfReporter() {
        return WidgetHostContract.DefaultImpls.getPerfReporter(this);
    }

    @Override // com.obric.widget.host.WidgetHostContract
    public final boolean openPage(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        l r5 = this.f20490c;
        ug.e r11 = r5.f20493c;     // Catch: Throwable -> L7
        if (r11 == null) goto L16;
        return r11.h(r10);
    L16:
        return false;
    L7:
        th = move-exception;
        String r12 = "openPage failed hostId=" + r5.f20491a;
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L13;
        ((ju.b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppWidgetHost", r12, th);
        return false;
    L13:
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
