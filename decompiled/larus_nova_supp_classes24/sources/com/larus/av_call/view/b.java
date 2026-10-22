package com.larus.av_call.view;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final View a;
    public final Function0<h88.b> b;
    public h88.d c;
    public boolean d;
    public final Map<Class<? extends h88.d>, Function3<View, Boolean, Boolean, Unit>> e;

    public static final class a {
    }

    static {
    }

    public final void a(h88.d r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        h88.d r0 = this.c;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getType();
    L7:
        if (Intrinsics.areEqual(r2, r7.getType()) == false) goto L10;
        FLogger.a.w("DynamicButton", "curState don't need change, type(" + r0.getType() + ')');
        return;
    L10:
        if (r0 == null) goto L12;
        r0.a = null;
        r0.d = null;
    L12:
        this.c = r7;
        View r3 = this.a;
        Function0<h88.b> r4 = this.b;
        r7.a = r3;
        r7.d = r4;
        r7.d(this.d);
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("button state changed from ");
        if (r0 == null) goto L15;
        r1 = r0.getType();
    L15:
        r6.append(r1);
        r6.append(" to ");
        r6.append(r7.getType());
        r5.w("DynamicButton", r6.toString());
        return;
    L5:
        r2 = null;
        goto L7
    }

    public b(AppCompatImageView r2, h88.d r3, z0 r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r4, "realtimeRuntimeDataProvider");
        this.a = r2;
        this.b = r4;
        this.e = new LinkedHashMap();
        if (r3 == null) goto L5;
        a(r3);
    L5:
        com.larus.utils.e1.d(r2, new com.larus.av_call.view.a(this));
    }
}
