package com.obric.flow.cardlistpage.apm;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.ui.component.feedlist.w;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f11447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f11448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.lynx.animax.player.e f11449c;

    public d(Context r10, w r11, RecyclerView r12, kotlinx.coroutines.internal.c r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "overlayStore");
        Intrinsics.checkNotNullParameter(r12, "recyclerView");
        Intrinsics.checkNotNullParameter(r13, "coroutineScope");
        this.f11447a = r11;
        this.f11448b = new e(r10, r13);
        this.f11449c = new com.lynx.animax.player.e(r13);
        BuildersKt.launch$default(r13, null, null, new FeedPerformanceMonitor$observeOverlayAnimation$1(this, null), 3, null);
        BuildersKt.launch$default(r13, null, null, new FeedPerformanceMonitor$observeOverlayAnimation$2(this, null), 3, null);
        BuildersKt.launch$default(r13, null, null, new FeedPerformanceMonitor$observeOverlayAnimation$3(this, null), 3, null);
        r12.addOnScrollListener(new FeedPerformanceMonitor$observeRecyclerViewScroll$1(this));
    }
}
