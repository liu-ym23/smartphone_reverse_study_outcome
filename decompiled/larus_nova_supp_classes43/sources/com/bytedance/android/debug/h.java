package com.bytedance.android.debug;

import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements l.a {
    public final /* synthetic */ DebugGiftPreviewDebugWidget a;
    public final /* synthetic */ String b;

    @Override // com.bytedance.android.debug.l.a
    public final void a() {
    }

    @Override // com.bytedance.android.debug.l.a
    public final void b() {
    }

    @Override // com.bytedance.android.debug.l.a
    public final void onEnd() {
        HSImageView r0 = this.a.g;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.u(r0);
    L5:
        LinearLayout r1 = this.a.h;
        if (r1 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r1);
        return;
    }

    @Override // com.bytedance.android.debug.l.a
    public final void onStart() {
        if (this.b == null) goto L7;
        HSImageView r0 = this.a.g;
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r0);
    L7:
        LinearLayout r1 = this.a.h;
        if (r1 == null) goto L11;
        UtilityKotlinExtentionsKt.u(r1);
        return;
    }

    @Override // com.bytedance.android.debug.l.a
    public final void onStop() {
        LinearLayout r0 = this.a.h;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r0);
        return;
    }

    public h(DebugGiftPreviewDebugWidget r1, String r10) {
        this.a = r1;
        this.b = r10;
    }
}
