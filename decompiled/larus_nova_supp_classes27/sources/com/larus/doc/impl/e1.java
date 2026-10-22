package com.larus.doc.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentActivity;
import com.larus.doc.biz.impl.databinding.LarusLayoutDocDetailFragmentBinding;
import com.larus.doc.impl.util.DocUtils;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e1 implements com.larus.doc.impl.operation.o {
    public final /* synthetic */ DocFragment a;

    @Override // com.larus.doc.impl.operation.o
    public final void a() {
        this.a.Ba0(true);
        DocFragment.za0(this.a, true, 2);
    }

    @Override // com.larus.doc.impl.operation.o
    public final Drawable b() {
        DocFragment r0 = this.a;
        LarusLayoutDocDetailFragmentBinding r1 = r0.g;
        if (r1 == null) goto L25;
        ConstraintLayout r2 = r1.a;
        if (r2 == null) goto L26;
        FragmentActivity r3 = r0.getActivity();
        if (r3 == null) goto L27;
        DocUtils.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r3.isDestroyed() == false) goto L11;
    L18:
        FLogger.a.e("DocUtils", "activity is illegal");
    L19:
        Bitmap r4 = null;
    L20:
        if (r4 == null) goto L28;
        r0.Ba0(false);
        DocFragment.za0(r0, false, 2);
        return new BitmapDrawable(r0.getResources(), r4);
    L28:
        return null;
    L11:
        if (r3.isFinishing() == true) goto L18;
        r4 = ViewKt.drawToBitmap$default(r2, null, 1, null);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        FLogger.a.e("DocUtils", th.getMessage());
        goto L19
    L27:
        return null;
    L26:
        return null;
    L25:
        return null;
    }

    public e1(DocFragment r1) {
        this.a = r1;
    }
}
