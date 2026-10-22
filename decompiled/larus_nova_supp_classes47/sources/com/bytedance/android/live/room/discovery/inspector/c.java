package com.bytedance.android.live.room.discovery.inspector;

import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ OfficialInspectorWidget a;
    public final /* synthetic */ l b;

    public c(OfficialInspectorWidget r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        StringBuilder r0 = new StringBuilder("download icon error, ImageMode: ");
        ImageModel r1 = this.b.b;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        r0.append(r3);
        r0.append(", error: ");
        if (r5 == null) goto L9;
        r2 = r5.toString();
    L9:
        r0.append(r2);
        ALogger.e("OfficialInspectorWidget", r0.toString());
        ImageView r6 = this.a.b;
        if (r6 == null) goto L12;
        r6.setVisibility(8);
    L12:
        Disposable r7 = this.a.f;
        if (r7 != null) goto L15;
    L16:
        Disposable r8 = this.a.f;
        if (r8 == null) goto L19;
        r8.dispose();
    L19:
        OfficialInspectorWidget r9 = this.a;
        l r10 = this.b;
        r9.getClass();
        if (r10.a == false) goto L25;
        TextView r12 = r9.c;
        if (r12 == null) goto L26;
        r12.post(new e(r9, r10));
        return;
    L26:
        return;
    L25:
        return;
    L15:
        if (r7.isDisposed() == true) goto L19;
    L5:
        r3 = null;
        goto L6
    }
}
