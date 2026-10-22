package com.bytedance.android.livesdk.gamesticker.t01;

import com.bytedance.android.livesdk.chatroom.model.r3;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((r3) r1).a()), Integer.valueOf(((r3) r2).a()));
    }
}
