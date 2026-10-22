package com.larus.bmhome.block.holder.content.lynx;

import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.api.e4;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0004\b\f\u0010\rJ \u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0006\u0010\u0019\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0002R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/IvyPluginViewPool;", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "maxKeyCount", "", "maxPerKey", "asViewGroupChild", "Lkotlin/Function1;", "Lcom/larus/platform/api/IvyPluginView;", "Landroid/view/View;", "<init>", "(Landroidx/lifecycle/Lifecycle;IILkotlin/jvm/functions/Function1;)V", "buckets", "Landroid/util/LruCache;", "", "Lkotlin/collections/ArrayDeque;", "acquire", "key", "data", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "", "v", "clearAll", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "detachFromParent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class IvyPluginViewPool extends SafeLifecycleObserver implements eh8.b {
    public final int a;
    public final Function1<e4, View> b;
    public final LruCache<String, ArrayDeque<e4>> c;

    public static final class a {
    }

    static {
    }

    public final void c(e4 r4) {
        View r5 = (View) this.b.invoke(r4);
        ViewGroup r0 = null;
        if (r5 == null) goto L5;
        ViewParent r1 = r5.getParent();
    L7:
        if ((r1 instanceof ViewGroup) == false) goto L9;
        r0 = (ViewGroup) r1;
    L9:
        if (r0 == null) goto L12;
        r0.removeView(r5);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onDestroy(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Iterator<T> r4 = this.c.snapshot().values().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        ArrayDeque r0 = (ArrayDeque) r4.next();
        Intrinsics.checkNotNull(r0);
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        c((e4) r1.next());
        goto L7
    L9:
        this.c.evictAll();
        FLogger.a.i("IvyViewPool", "clearAll");
    }

    @Override // eh8.b
    public final void a(String r4, e4 r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "v");
        FLogger.a.i("IvyViewPool", "release to pool ".concat(r4));
        c(r5);
        ArrayDeque<e4> r0 = this.c.get(r4);
        if (r0 != null) goto L6;
        r0 = new ArrayDeque();
        this.c.put(r4, r0);
    L6:
        if (r0.size() < this.a) goto L8;
        return;
    L8:
        r0.addLast(r5);
    }

    @Override // eh8.b
    public final e4 b(String r6, String r7) {
        ArrayDeque<e4> r0 = this.c.get(r6);
        if (r0 != null) goto L5;
    L7:
        e4 r8 = null;
    L8:
        if (r8 != null) goto L10;
        return null;
    L10:
        c(r8);
        return r8;
    L5:
        if ((!r0.isEmpty()) == false) goto L7;
        FLogger.a.i("IvyViewPool", "acquire from pool: size=" + r0.size() + " key=" + r6);
        r8 = (e4) r0.removeFirst();
        r8.updateData(r7);
        goto L8
    }

    public IvyPluginViewPool(LifecycleRegistry r2, int r3, int r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        Intrinsics.checkNotNullParameter(r5, "asViewGroupChild");
        this.a = r4;
        this.b = r5;
        this.c = new LruCache(r3);
        r2.addObserver(this);
    }
}
