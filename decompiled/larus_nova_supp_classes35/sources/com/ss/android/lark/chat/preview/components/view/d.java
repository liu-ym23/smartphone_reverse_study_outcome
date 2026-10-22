package com.ss.android.lark.chat.preview.components.view;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements a.InterfaceC0108a {
    public final WeakReference<View> a;

    @Override // com.ss.android.lark.chat.preview.components.view.a.InterfaceC0108a
    public final void a() {
        WeakReference<View> r0 = this.a;
        if (r0 == null) goto L8;
        View r1 = r0.get();
        if (r1 == null) goto L9;
        r1.postInvalidate();
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.chat.preview.components.view.a.InterfaceC0108a
    public final void onLoadFailed() {
        WeakReference<View> r0 = this.a;
        if (r0 == null) goto L8;
        View r1 = r0.get();
        if (r1 == null) goto L9;
        r1.postInvalidate();
        return;
    L9:
        return;
    }

    public d(WeakReference<View> r2) {
        Intrinsics.checkNotNullParameter(r2, "refs");
        this.a = r2;
    }
}
