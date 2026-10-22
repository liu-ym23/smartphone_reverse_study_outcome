package com.bytedance.android.livesdk.gift.platform.business.anchor;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements dy0.c, o {
    public zy0.d a;

    public final void onStart() {
    }

    public final void onStop() {
        zy0.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
    }

    public a() {
    }

    public final void a(Context r6, AnchorGiftPanelSource r7, Function0<Unit> r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "showFrom");
        Intrinsics.checkNotNullParameter(r8, "onSucceed");
        Intrinsics.checkNotNullParameter(r9, "onFailed");
        ReadOnlyProperty r0 = b.c;
        KProperty[] r1 = b.a;
        if (StringsKt.isBlank((String) r0.getValue(null, r1[1])) == false) goto L6;
        r9.invoke();
        return;
    L6:
        Uri.Builder r2 = UriProtector.parse((String) r0.getValue(null, r1[1])).buildUpon();
        r2.appendQueryParameter("show_from", r7.getValue());
        Uri r10 = r2.build();
        this.a = f.a(vy0.c.class).U0(r6, r10, null);     // Catch: NullPointerException -> L9
        r8.invoke();     // Catch: NullPointerException -> L9
        return;
    L9:
        e = move-exception;
        r9.invoke();
        zy0.d r11 = this.a;
        if (r11 == null) goto L13;
        r11.dispose();
    L13:
        this.a = null;
        Objects.toString(e.getCause());
    }
}
