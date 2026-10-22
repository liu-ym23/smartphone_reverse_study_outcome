package com.ss.android.lark.contact.customized.myqrcode.view;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.DataSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Drawable.Callback {
    public final /* synthetic */ Drawable.Callback a;
    public final /* synthetic */ OfficeInviteExternalCardView b;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "who");
        Drawable.Callback r0 = this.a;
        if (r0 == null) goto L5;
        r0.invalidateDrawable(r3);
    L5:
        Function2<? super Boolean, ? super DataSource, Unit> r4 = this.b.b;
        if (r4 == null) goto L9;
        r4.invoke(Boolean.TRUE, null);
        return;
    }

    public a(Drawable.Callback r1, OfficeInviteExternalCardView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r2, "who");
        Intrinsics.checkNotNullParameter(r3, "what");
        Drawable.Callback r0 = this.a;
        if (r0 == null) goto L6;
        r0.unscheduleDrawable(r2, r3);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "who");
        Intrinsics.checkNotNullParameter(r3, "what");
        Drawable.Callback r0 = this.a;
        if (r0 == null) goto L6;
        r0.scheduleDrawable(r2, r3, r4);
        return;
    }
}
