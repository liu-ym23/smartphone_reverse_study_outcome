package eh0;

import ch0.e;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements c {
    public b a;

    public a() {
    }

    @Override // eh0.c
    public abstract h.a a(List<e> r1);

    public final b b() {
        b r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        return r0;
    }

    public final void c() {
        b r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        h.a r1 = a(r0.d());
        if (r1.a == false) goto L12;
        b r2 = this.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L10:
        r2.m(r1);
        return;
    }
}
