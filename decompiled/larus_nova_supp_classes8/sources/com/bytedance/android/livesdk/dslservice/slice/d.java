package com.bytedance.android.livesdk.dslservice.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements j {
    public final /* synthetic */ r a;

    @Override // yt1.j
    public final View getTargetView() {
        return this.a.c;
    }

    @Override // yt1.j
    public final r a() {
        return this.a;
    }

    public d(r r1) {
        this.a = r1;
    }

    @Override // yt1.j
    public final void b(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        SliceViewUtilsKt.b(this.a, r2, r3);
    }

    @Override // yt1.j
    public final void c(Map r3, int r4) {
        SliceViewUtilsKt.a(this.a, "", r3, r4);
    }
}
