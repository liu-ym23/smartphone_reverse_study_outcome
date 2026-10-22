package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Comparator<T> {
    public final /* synthetic */ BottomToolbarContainerDataManager a;

    public a(BottomToolbarContainerDataManager r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.a.s(((s) r3).f)), Integer.valueOf(this.a.s(((s) r2).f)));
    }
}
