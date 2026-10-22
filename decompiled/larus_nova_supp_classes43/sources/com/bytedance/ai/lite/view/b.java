package com.bytedance.ai.lite.view;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b extends FrameLayout {
    public abstract void a();

    public abstract void b(String r1);

    public b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
    }
}
