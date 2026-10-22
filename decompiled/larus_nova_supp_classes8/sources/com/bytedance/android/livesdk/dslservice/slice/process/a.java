package com.bytedance.android.livesdk.dslservice.slice.process;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.i;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends i {
    public final q d;
    public final String e;
    public final WeakReference<Context> f;

    public a(String r2, String r3, String r4, q r5, String r6, WeakReference<Context> r7) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r4, "version");
        Intrinsics.checkNotNullParameter(r5, "key");
        super(r2, r3, r4);
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
