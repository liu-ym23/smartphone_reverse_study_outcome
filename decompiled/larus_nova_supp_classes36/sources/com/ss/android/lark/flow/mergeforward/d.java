package com.ss.android.lark.flow.mergeforward;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowMergeForwardActivity a;

    public d(Hilt_FlowMergeForwardActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowMergeForwardActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        ((a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent()).k1((FlowMergeForwardActivity) UnsafeCasts.unsafeCast(r3));
        return;
    }
}
