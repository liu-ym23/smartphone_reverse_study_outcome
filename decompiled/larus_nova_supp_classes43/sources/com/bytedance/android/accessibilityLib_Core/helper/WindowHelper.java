package com.bytedance.android.accessibilityLib_Core.helper;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$appWindowEventListener$2$a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class WindowHelper extends e implements AppWindows.a {
    public final Lazy b;
    public final List<WeakReference<AppWindows.a>> c;

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void a() {
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void c(View r1, String r10) {
    }

    public WindowHelper() {
        this.b = LazyKt.lazy(WindowHelper$appWindows$2.INSTANCE);
        this.c = new ArrayList();
    }

    public final void d(final AbstractAccessibilityLibIsolation$appWindowEventListener$2$a r10) {
    L7:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L11;
        Context r0 = a.a;
    L11:
        e.printStackTrace();
        Unit r11 = Unit.INSTANCE;
        return;
    L3:
        if (Build.VERSION.SDK_INT < 24) goto L5;
        ((ArrayList) this.c).removeIf(new f(r10));     // Catch: Exception -> L7
    L13:
        return;
    L5:
        CollectionsKt.removeAll(this.c, new WindowHelper$removeEventListener$$inlined$Try$lambda$2(this, r10));     // Catch: Exception -> L7
        goto L13
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void b(Window r10, View r11, String r12) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        AppWindows.a r1 = (AppWindows.a) ((WeakReference) r0.next()).get();
        if (r1 == null) goto L4;
        r1.b(r10, r11, r12);
        goto L4
    }
}
