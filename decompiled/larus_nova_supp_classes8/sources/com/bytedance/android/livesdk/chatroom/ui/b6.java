package com.bytedance.android.livesdk.chatroom.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b6 implements Runnable {
    public final /* synthetic */ EditIntroductionFragment.b a;
    public final /* synthetic */ Bitmap b;

    public b6(EditIntroductionFragment.b r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        FragmentActivity r1 = this.a.a.getActivity();
        if (r1 == null) goto L5;
        Resources r2 = r1.getResources();
    L6:
        BitmapDrawable r0 = new BitmapDrawable(r2, this.b);
        int r3 = r0.getIntrinsicWidth();
        EditText r4 = this.a.a.f;
        if (r4 == null) goto L9;
        int r5 = r4.getMeasuredWidth();
    L10:
        int r6 = r0.getIntrinsicHeight();
        if (r3 < 0) goto L14;
        if (r5 <= 0) goto L14;
        r6 = (int) (r5 * (r0.getIntrinsicHeight() / r3));
        r3 = r5;
    L14:
        r0.setBounds(0, 0, r3, r6);
        EditIntroductionFragment.b r7 = this.a;
        r7.b.invoke(r7.c, r0);
        return;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
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
