package com.bytedance.android.annie.ng;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final Context a;
    public final Uri b;
    public final String c;
    public b7.a d;
    public Bundle e;

    public final HybridCard a() {
        Bundle r0 = this.e;
        if (r0 != null) goto L5;
        r0 = new Bundle();
        r0.putString("biz_key", this.c);
    L7:
        return Annie.getHybridCard(this.a, this.b, this.d, r0);
    L5:
        r0.putString("biz_key", this.c);
        goto L7
    }

    public c(Context r10, Uri r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "uri");
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
