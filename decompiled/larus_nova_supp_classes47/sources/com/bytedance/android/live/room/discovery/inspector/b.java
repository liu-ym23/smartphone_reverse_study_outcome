package com.bytedance.android.live.room.discovery.inspector;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ OfficialInspectorWidget a;
    public final /* synthetic */ l b;

    public b(OfficialInspectorWidget r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        if (r5 == null) goto L23;
        ImageView r0 = this.a.b;
        if (r0 == null) goto L8;
        r0.setImageBitmap(r5);
    L8:
        Disposable r6 = this.a.f;
        if (r6 != null) goto L11;
    L12:
        Disposable r7 = this.a.f;
        if (r7 == null) goto L15;
        r7.dispose();
    L15:
        OfficialInspectorWidget r8 = this.a;
        l r1 = this.b;
        r8.getClass();
        if (r1.a == false) goto L21;
        TextView r2 = r8.c;
        if (r2 == null) goto L22;
        r2.post(new e(r8, r1));
        return;
    L22:
        return;
    L21:
        return;
    L11:
        if (r6.isDisposed() == true) goto L15;
    }
}
