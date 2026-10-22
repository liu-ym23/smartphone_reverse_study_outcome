package com.bytedance.android.livesdk.interactivity.square.common.common;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;
import com.bytedance.bdlocation.BuildConfig;
import g52.e;
import h52.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/square/common/common/CommonSquarePublicScreenViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/base/AbsPublicScreenMessageViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonSquarePublicScreenViewHolder extends AbsPublicScreenMessageViewHolder {
    public final k<c> f;
    public final View g;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder
    public final void T3(c r6) {
        Intrinsics.checkNotNullParameter(r6, "model");
        TextView r1 = this.d;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setTag(2131389797, r6);
        r1.setAlpha(1.0f);
        r1.setAlwaysInvalidate(false);
        j r2 = this.f.b(r6, new f(false), new a(this, r6, r1));
        t.a r3 = t.a;
        CharSequence r4 = r2.a;
        if (r4 != null) goto L9;
        r4 = BuildConfig.FLAVOR;
    L9:
        t.b(r1, r4);
        i r5 = r2.b;
        if (r5 != null) goto L12;
    L14:
        e r7 = this.e.e.getTextConfig();
        if (r7 == null) goto L17;
        int r8 = e.j;
        r7.a(r1, true);
    L17:
        d3();
        this.f.a(r6);
        int r9 = com.bytedance.android.livesdk.interactivity.square.e.a;
        Intrinsics.checkNotNullParameter(r6, "model");
        com.bytedance.android.livesdk.interactivity.square.e.e++;
        if (r6.getUser() == null) goto L21;
        com.bytedance.android.livesdk.interactivity.square.e.f++;
        ((ArrayList) com.bytedance.android.livesdk.interactivity.square.e.g).add(Long.valueOf(r6.getMessageId()));
    L21:
        if (com.bytedance.android.livesdk.interactivity.square.e.e <= com.bytedance.android.livesdk.interactivity.square.e.a) goto L24;
        com.bytedance.android.livesdk.interactivity.square.e.b();
        return;
    L24:
        return;
    L12:
        if (r5.a != true) goto L14;
        r1.setAlwaysInvalidate(true);
        goto L14
    }

    public CommonSquarePublicScreenViewHolder(View r2, k52.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "pipelineConfig");
        super(r2, r3);
        this.g = r2;
        this.f = r3.f;
    }
}
