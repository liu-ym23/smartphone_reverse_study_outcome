package com.larus.bmhome.social.page.datasource.diff;

import android.os.Looper;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/social/page/datasource/diff/PagingAdapterListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "pagingAdapter", "Lcom/larus/bmhome/social/page/datasource/adapter/PagingAdapter;", "<init>", "(Lcom/larus/bmhome/social/page/datasource/adapter/PagingAdapter;)V", "onInserted", "", "position", "", "count", "onRemoved", "onMoved", "fromPosition", "toPosition", "onChanged", "payload", "", "logSubThreadStackTrace", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PagingAdapterListUpdateCallback implements ListUpdateCallback {
    public final void a() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        String r0 = ArraysKt.joinToString$default(ThreadMethodProxy.currentThread().getStackTrace(), "\n", null, null, 0, null, null, 62, null);
        FLogger.a.e("PagingAdapterListUpdateCallback", r0);
        com.larus.platform.service.g.a.ensureNotReachHere(new IllegalStateException("PagingAdapterListUpdateCallback sub thread update"));
        return;
    }

    public final void onInserted(final int r2, final int r3) {
        t0.e(new g(this, r2, r3));
        a();
    }

    public final void onMoved(final int r2, final int r3) {
        t0.e(new f(this, r2, r3));
        a();
    }

    public final void onRemoved(final int r2, final int r3) {
        t0.e(new d(this, r2, r3));
        a();
    }

    public final void onChanged(final int r2, final int r3, final Object r4) {
        t0.e(new e(this, r2, r3, r4));
        a();
    }
}
