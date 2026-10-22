package com.ss.android.lark.image.compose.common.url;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final MutableState a;

    public a() {
        this(0);
    }

    public a(int r3) {
        this.a = SnapshotStateKt.mutableStateOf$default(Integer.valueOf(r3), null, 2, null);
    }
}
