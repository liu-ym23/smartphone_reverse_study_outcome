package k6;

import android.content.Context;
import android.view.View;
import com.bytedance.android.accessibilityLib_Core.processor.ViewAccessibilityDelegateProcessor;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final WeakHashMap<View, WeakReference<ViewAccessibilityDelegateProcessor.a>> a;

    public a() {
        this.a = new WeakHashMap();
    }

    public final ViewAccessibilityDelegateProcessor.a a(View r10, int r11) {
        WeakReference<ViewAccessibilityDelegateProcessor.a> r0 = this.a.get(r10);     // Catch: Exception -> L18
        if (r0 == null) goto L7;
        ViewAccessibilityDelegateProcessor.a r1 = r0.get();     // Catch: Exception -> L18
        if (r1 == null) goto L7;
        r1.b = r11;     // Catch: Exception -> L18
    L8:
        if (r1 != null) goto L14;
        r1 = new ViewAccessibilityDelegateProcessor.a(new WeakReference(r10), r11);     // Catch: Exception -> L18
        WeakHashMap<View, WeakReference<ViewAccessibilityDelegateProcessor.a>> r12 = this.a;     // Catch: Exception -> L18
        monitor-enter(r12);     // Catch: Exception -> L18
        this.a.put(r10, new WeakReference(r1));     // Catch: Throwable -> L15
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Exception -> L18
        goto L14
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L14:
        return r1;
    L7:
        r1 = null;
    L18:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L23;
        Context r14 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L23:
        return new ViewAccessibilityDelegateProcessor.a(new WeakReference(r10), r11);
    }
}
