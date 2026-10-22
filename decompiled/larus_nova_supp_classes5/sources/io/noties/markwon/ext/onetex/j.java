package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.business.markdown.api.model.ImageSpanStatus;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wsc.a;
import wsc.b;
import wsc.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j extends b {
    public Function2<? super String, Object, Unit> a;

    @Override // wsc.b
    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
    }

    @Override // wsc.b
    public final void c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
    }

    public j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new WeakReference(r2);
    }

    @Override // wsc.b
    public final void b(a r3) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        Function2<? super String, Object, Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke(r3.a, new a());
        return;
    }

    private final void setResult(a r2, Drawable r3, ImageSpanStatus r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getBounds().isEmpty() == false) goto L7;
        r3.setBounds(m.a(r3));
    L7:
        if (r2.getCallback() == null) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return;
    L12:
        if (r4 != ImageSpanStatus.SUCC) goto L15;
        r2.setResult(r3);
    L18:
        r2.invalidateSelf();
        return;
    L15:
        if (r2.l == true) goto L18;
        r2.setResult(r3);
        goto L18
    L9:
        r0 = false;
        goto L10
    }
}
