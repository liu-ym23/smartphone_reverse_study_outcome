package j5;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f18245b;

    public f(View r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "type");
        this.f18244a = r10;
        this.f18245b = new WeakReference(r5);
    }
}
