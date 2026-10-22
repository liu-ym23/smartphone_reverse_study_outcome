package po8;

import android.content.Context;
import android.os.Handler;
import android.widget.TextSwitcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z {
    public TextSwitcher a;
    public final List<String> b;
    public final long c;
    public Function0<Unit> d;
    public int e;
    public Handler f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final void b() {
        Handler r1 = this.f;     // Catch: Exception -> L7
        if (r1 == null) goto L9;
        r1.removeCallbacksAndMessages(null);     // Catch: Exception -> L7
    L9:
        this.f = null;
        this.a = null;
        this.d = null;
        return;
    L7:
        e = move-exception;
        FLogger.a.e("SearchingSwitcherAdapter", "onDestroy e=" + e);
        goto L9
    }

    public final void c() {
        if (this.b.size() >= 2) goto L5;
        return;
    L5:
        if (this.e > 60) goto L11;
        Handler r0 = this.f;
        if (r0 == null) goto L12;
        r0.postDelayed(new y(this), this.c);
        return;
    L12:
        return;
    }

    public final void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        TextSwitcher r0 = this.a;
        if (r0 == null) goto L5;
        r0.setText((CharSequence) ListProtector.get(this.b, ((Number) ListProtector.get((List) this.g.getValue(), this.e % this.b.size())).intValue()));
    L5:
        TextSwitcher r1 = this.a;
        if (r1 == null) goto L8;
        r1.setInAnimation(r6, 2130772381);
    L8:
        TextSwitcher r2 = this.a;
        if (r2 == null) goto L11;
        r2.setOutAnimation(r6, 2130772385);
    L11:
        this.e++;
        Function0<Unit> r7 = this.d;
        if (r7 == null) goto L15;
        r7.invoke();
        return;
    }

    public /* synthetic */ z(TextSwitcher r7, List r8) {
        this(r7, r8, 800, null);
    }

    public z(TextSwitcher r2, List<String> r3, long r4, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "textList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.f = new Handler();
        this.g = LazyKt.lazy(new x(this));
    }
}
