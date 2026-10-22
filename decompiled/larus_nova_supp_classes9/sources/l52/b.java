package l52;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.square.h;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b {
    public final j52.b a;
    public Function1<? super List<? extends h52.c>, Unit> b;
    public final a c;
    public final m52.b d;
    public final k52.a e;
    public final c f;
    public final l g;

    public b(k52.a r2, h r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "pipelineConfig");
        Intrinsics.checkNotNullParameter(r3, "messageRepo");
        Intrinsics.checkNotNullParameter(r4, "publicScreenContext");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        r2.getClass();
        new ArrayDeque();
        this.a = new j52.b(r2.c, r2.d);
        this.c = new a(this);
        k<h52.c> r5 = r2.f;
        Handler r6 = new Handler(Looper.getMainLooper());
        m52.c r0 = m52.c.a;
        this.d = new m52.b(r5, r6);
    }
}
