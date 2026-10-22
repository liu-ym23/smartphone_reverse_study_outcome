package com.larksuite.component.ui.toast.loading;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.apm.impl.protector.RunnableProtector;
import j08.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Runnable {
    public final /* synthetic */ LKUILoadingToastImpl a;

    public a(LKUILoadingToastImpl r1) {
        this.a = r1;
    }

    public final void a() {
        LKUILoadingToastImpl.b r0 = this.a.f;
        if (1 == r0.c) goto L17;
        r0.c = 1;
        ValueAnimator r1 = r0.e;
        Intrinsics.checkNotNull(r1);
        r1.cancel();
        r0.d = 0.0f;
        ImageView r3 = r0.b;
        Intrinsics.checkNotNull(r3);
        r3.setRotation(0.0f);
        int r2 = r0.c;
        if (r2 != 1) goto L8;
        Drawable r4 = AppCompatResources.getDrawable(r0.getContext(), 2131243841);
    L15:
        if (r4 == null) goto L17;
        r4.setTint(b.c(r0.getContext(), 2131103449, 1.0f));
        ImageView r5 = r0.b;
        Intrinsics.checkNotNull(r5);
        r5.setImageDrawable(r4);
        goto L17
    L8:
        if (r2 != 2) goto L10;
        r4 = AppCompatResources.getDrawable(r0.getContext(), 2131243842);
        goto L15
    L10:
        if (r2 == 3) goto L12;
        r4 = null;
        goto L15
    L12:
        r4 = AppCompatResources.getDrawable(r0.getContext(), 2131243840);
    L17:
        ValueAnimator r6 = r0.e;
        if (r6 == null) goto L21;
        r6.start();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
