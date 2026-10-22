package com.ss.android.lark.imageocr.mvp;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.imageocr.view.OCRBottomView;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements com.ss.android.lark.imageocr.view.a.b {
    public final /* synthetic */ d a;

    @Override // com.ss.android.lark.imageocr.view.a.b
    public final void a() {
        this.a.h.b();
    }

    @Override // com.ss.android.lark.imageocr.view.a.b
    public final void f() {
        this.a.e.getScaleImageView().invalidate();
        ArrayList<ilb.b> r0 = this.a.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r0 = null;
    L5:
        int r1 = r0.size();
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L25;
        ArrayList<ilb.b> r5 = this.a.k;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r5 = null;
    L11:
        if (((ilb.b) ListProtector.get(r5, r4)).j.d == true) goto L12;
        ArrayList<ilb.b> r6 = this.a.k;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r6 = null;
    L17:
        if (r4 != (r6.size() - 1)) goto L19;
        this.a.f.a();
    L19:
        r4 = r4 + 1;
        goto L6
    L12:
        OCRBottomView r2 = this.a.f;
        r2.getClass();
        Log.i("OCRBottomView", "showSelectMode");
        r2.setVisibility(0);
        r2.b(CollectionsKt.arrayListOf(new OCRBottomView.a[]{new OCRBottomView.a(4, 2131254165, 2131891162), new OCRBottomView.a(5, 2131254801, 2131891171), new OCRBottomView.a(6, 2131254206, 2131891165)}));
        return;
    }

    public g(d r1) {
        this.a = r1;
    }
}
