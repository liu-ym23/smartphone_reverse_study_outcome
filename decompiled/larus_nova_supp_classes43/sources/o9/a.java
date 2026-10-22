package o9;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.android.annie.bridge.method.z0;
import e7.m0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // o9.b
    public final void q1(m0 r10, Context r11, z0 r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Unit r1 = null;
        if (r10.a() == null) goto L5;
        r11.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", r10.a(), null)));
        r12.b();
        r1 = Unit.INSTANCE;
    L5:
        if (r1 != null) goto L8;
        r12.a();
        return;
    }
}
