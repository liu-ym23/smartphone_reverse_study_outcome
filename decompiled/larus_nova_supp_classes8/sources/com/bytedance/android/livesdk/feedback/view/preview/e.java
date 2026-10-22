package com.bytedance.android.livesdk.feedback.view.preview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ LargeCardPreviewView a;

    public e(LargeCardPreviewView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == true) goto L7;
        this.a.c.setVisibility(4);
        return;
    }
}
