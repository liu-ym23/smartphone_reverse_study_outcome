package com.larus.bmhome.chat.list.datasource.adapter;

import android.os.Looper;
import androidx.recyclerview.widget.ListUpdateCallback;
import bh8.e;
import bh8.f;
import bh8.h;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.list.base.MessageCellAdapter;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0007R\u001a\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapterListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "pagingAdapter", "Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapter;", "<init>", "(Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapter;)V", "onInserted", "", "position", "", "count", "onRemoved", "onMoved", "fromPosition", "toPosition", "onChanged", "payload", "", "logSubThreadStackTrace", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class PagingAdapterListUpdateCallback implements ListUpdateCallback {
    public final PagingAdapter<?, ?, ?> a;

    public static final class a implements Function1<?, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;

        public a(int r1, int r2, Object r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object invoke(Object r4) {
            MessageCellAdapter r5 = (MessageCellAdapter) r4;
            Intrinsics.checkNotNullParameter(r5, "$this$safeNotify");
            r5.notifyItemRangeChanged(this.a, this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<?, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r3) {
            MessageCellAdapter r4 = (MessageCellAdapter) r3;
            Intrinsics.checkNotNullParameter(r4, "$this$safeNotify");
            r4.notifyItemRangeInserted(this.a, this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<?, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public c(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r3) {
            MessageCellAdapter r4 = (MessageCellAdapter) r3;
            Intrinsics.checkNotNullParameter(r4, "$this$safeNotify");
            r4.notifyItemMoved(this.a, this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Function1<?, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public d(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r3) {
            MessageCellAdapter r4 = (MessageCellAdapter) r3;
            Intrinsics.checkNotNullParameter(r4, "$this$safeNotify");
            r4.notifyItemRangeRemoved(this.a, this.b);
            return Unit.INSTANCE;
        }
    }

    public final void a() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        String r0 = ArraysKt.joinToString$default(ThreadMethodProxy.currentThread().getStackTrace(), "\n", null, null, 0, null, null, 62, null);
        FLogger.a.e("PagingAdapterListUpdateCallback", r0);
        g.a.ensureNotReachHere(new IllegalStateException("PagingAdapterListUpdateCallback sub thread update"));
        return;
    }

    public PagingAdapterListUpdateCallback(PagingAdapter<?, ?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "pagingAdapter");
        this.a = r2;
    }

    public final void onInserted(final int r2, final int r3) {
        t0.e(new h(r2, r3, this));
        a();
    }

    public final void onMoved(final int r2, final int r3) {
        t0.e(new e(r2, r3, this));
        a();
    }

    public final void onRemoved(final int r2, final int r3) {
        t0.e(new f(r2, r3, this));
        a();
    }

    public void onChanged(final int r2, final int r3, final Object r4) {
        t0.e(new bh8.g(r2, r3, r4, this));
        a();
    }
}
