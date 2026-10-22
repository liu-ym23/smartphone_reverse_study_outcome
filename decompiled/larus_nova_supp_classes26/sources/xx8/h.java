package xx8;

import android.content.Context;
import android.os.Handler;
import android.widget.TextSwitcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.camera.impl.ui.component.generalonly.p;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public TextSwitcher a;
    public final List<String> b;
    public final Function1<String, Unit> c;
    public int d;
    public Handler e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.b.size() < 2) goto L8;
        FLogger.a.i("TextViewSwitcherAdapter", "startSwitchInOrder curTextIndex=" + this.d);
        Handler r0 = this.e;
        if (r0 == null) goto L9;
        r0.postDelayed(new d(this), 2500);
        return;
    L9:
        return;
    }

    public final void c() {
        if (this.b.size() < 2) goto L8;
        FLogger.a.i("TextViewSwitcherAdapter", "startSwitchInOrder curTextIndex=" + this.d);
        Handler r0 = this.e;
        if (r0 == null) goto L9;
        r0.postDelayed(new g(this), 2500);
        return;
    L9:
        return;
    }

    public final String a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        String r0 = (String) ListProtector.get(this.b, ((Number) ListProtector.get((List) this.f.getValue(), this.d % this.b.size())).intValue());
        TextSwitcher r1 = this.a;
        if (r1 == null) goto L5;
        r1.setText(r0);
    L5:
        TextSwitcher r2 = this.a;
        if (r2 == null) goto L8;
        r2.setInAnimation(r5, 2130772383);
    L8:
        TextSwitcher r3 = this.a;
        if (r3 == null) goto L11;
        r3.setOutAnimation(r5, 2130772386);
    L11:
        this.d++;
        return r0;
    }

    public h(TextSwitcher r2, List r3, p r4) {
        Intrinsics.checkNotNullParameter(r3, "textList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = new Handler();
        this.f = LazyKt.lazy(new e(this));
        this.g = LazyKt.lazy(new f(this));
    }
}
