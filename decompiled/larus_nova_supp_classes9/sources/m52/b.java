package m52;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final List<h52.c> a;
    public final a b;
    public WeakHandler c;
    public HandlerThread d;
    public final k<h52.c> e;
    public final Handler f;
    public final d g;
    public Function1<? super List<? extends h52.c>, Unit> h;

    public b(k r3, Handler r4) {
        c r0 = c.a;
        Intrinsics.checkNotNullParameter(r3, "renderProcessor");
        Intrinsics.checkNotNullParameter(r4, "uiHandler");
        Intrinsics.checkNotNullParameter(r0, "preProcessor");
        this.e = r3;
        this.f = r4;
        this.g = r0;
        this.h = null;
        this.a = new LinkedList();
        this.b = new a(this);
    }
}
