package com.bytedance.android.ec.core.anchorv3;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.track.TrackerProvider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final void a(com.bytedance.android.ec.core.event.a r10, Context r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$postWithBase");
        TrackerProvider.a r0 = TrackerProvider.Companion;
        if (r11 == null) goto L10;
        Activity r13 = d0.a.getActivity(r11);
        if ((r13 instanceof FragmentActivity) == true) goto L8;
        r13 = null;
    L8:
        FragmentActivity r14 = (FragmentActivity) r13;
        if (r14 == null) goto L10;
        Object r15 = ViewModelProviders.of(r14).get(TrackerProvider.class).getTracker();
        if ((r15 instanceof com.bytedance.android.shopping.anchorv3.track.a) == true) goto L14;
        r15 = null;
    L14:
        com.bytedance.android.shopping.anchorv3.track.a r16 = (com.bytedance.android.shopping.anchorv3.track.a) r15;
    L15:
        if (r16 == null) goto L17;
        r16.a(r10, r12);
    L17:
        r10.post(null, null);
        return;
    L10:
        r16 = null;
        goto L15
    }
}
