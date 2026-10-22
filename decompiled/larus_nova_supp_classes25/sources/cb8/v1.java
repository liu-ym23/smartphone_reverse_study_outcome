package cb8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v1 implements jc8.k {
    public static final /* synthetic */ int e = 0;
    public List<? extends jc8.a> a;
    public List<? extends jc8.a> b;
    public final List<w1> c;
    public final Map<Class<?>, jc8.l> d;

    public static final class a {
    }

    static {
    }

    public v1() {
        this.a = CollectionsKt.emptyList();
        this.b = CollectionsKt.emptyList();
        this.c = new ArrayList();
        this.d = new LinkedHashMap();
    }

    @Override // jc8.k
    public final List<jc8.a> b() {
        return this.b;
    }

    @Override // jc8.k
    public final <T extends jc8.l> T a(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Object r1 = null;
        if (FlowRuntime.a().isDebug() == false) goto L22;
        Object r4 = ((LinkedHashMap) this.d).get(r3);
        if ((r4 instanceof jc8.l) == true) goto L7;
        return null;
    L7:
        return (T) r4;
    L22:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        Object r5 = ((LinkedHashMap) this.d).get(r3);     // Catch: Throwable -> L14
        if ((r5 instanceof jc8.l) == false) goto L11;
        jc8.l r6 = (jc8.l) r5;     // Catch: Throwable -> L14
    L12:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r7) == true) goto L21;
        r1 = r7;
    L21:
        return (T) r1;
    L11:
        r6 = null;
    L14:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final void c(int r7, View r8, jc8.b<? extends jc8.a> r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "baseBlockHolder");
        jc8.a r10 = (jc8.a) CollectionsKt.getOrNull(this.b, r7);
        if (r10 != null) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        r9.b(r10);
        jc8.d r11 = r9.e(r10);
        Object r3 = r8.getTag(2131364282);
        ViewGroup.MarginLayoutParams r5 = null;
        if ((r3 instanceof jc8.d) == false) goto L8;
        jc8.d r4 = (jc8.d) r3;
    L10:
        if (Intrinsics.areEqual(r11, r4) == true) goto L17;
        r8.setTag(2131364282, r11);
        ViewGroup.LayoutParams r12 = r8.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r5 = (ViewGroup.MarginLayoutParams) r12;
    L14:
        if (r5 == null) goto L17;
        r5.setMarginStart(r11.a);
        r5.setMarginEnd(r11.c);
        r5.topMargin = r11.b;
        r5.bottomMargin = r11.d;
    L17:
        if (r10.e.d == true) goto L20;
        FLogger.a.d("ExperimentalBlockAdapter", "onBindBlockHandler, msgId: " + r10.e.a + ", blockModel: " + r10.getClass().getSimpleName() + ", bind duration: " + (System.currentTimeMillis() - r0));
        return;
    L20:
        return;
    L8:
        r4 = null;
        goto L10
    }
}
