package com.bytedance.android.livesdk.dslservice.util.jsb;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ue7.c {
    public final /* synthetic */ View a;

    public final String b() {
        return "webcast";
    }

    public final Uri a() {
        return UriProtector.parse("");
    }

    public final Context context() {
        return this.a.getContext();
    }

    public final View i() {
        return this.a;
    }

    public a(View r1) {
        this.a = r1;
    }

    public final void sendEvent(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }
}
