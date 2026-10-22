package p31;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.revlink.impl.multianchor.service.f;
import com.bytedance.android.live.revlink.impl.pk.ui.CrossRoomContainerLayout;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements f {
    public final HashMap<Class<? extends View>, View> b;
    public final Deque<View> c;
    public final AsyncLayoutInflater d;
    public final C0289a e;
    public final b f;
    public final Context g;

    /* JADX INFO: renamed from: p31.a$a, reason: collision with other inner class name */
    public static final class C0289a implements androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener {
        public final /* synthetic */ a a;

        public C0289a(a r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onCancel(int r1) {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener.-CC.$default$onCancel(this, r1);
        }

        public final void onInflateFinished(View r4, int r5, ViewGroup r6) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Iterator<T> r7 = p31.b.a.iterator();
        L4:
            if (r7.hasNext() == false) goto L11;
            Object r0 = r7.next();
            ((c) r0).getClass();
            if (r5 != 0) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
        L12:
            c r1 = (c) r0;
            if (Intrinsics.areEqual(null, CrossRoomContainerLayout.class) == false) goto L15;
            r1.getClass();
            jy0.b.f("MultiLinkPreloadWidget", "async inflate done for null", null, 4);
        L15:
            if (r1 == null) goto L23;
            this.a.b.put(null, r4);
            return;
        L23:
            return;
        L8:
            r2 = false;
            goto L9
        L11:
            r0 = null;
            goto L12
        }
    }

    public static final class b implements androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onCancel(int r1) {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener.-CC.$default$onCancel(this, r1);
        }

        public final void onInflateFinished(View r2, int r3, ViewGroup r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            ((LinkedList) this.a.c).add(r2);
            jy0.b.f("link_preload", "async done for " + ((LinkedList) this.a.c).size(), null, 4);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.f
    public final int a() {
        return ((LinkedList) this.c).size();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.f
    public final void c() {
        jy0.b.f("link_preload", "start asyncInflatePkLayouts", null, 4);
        FrameLayout r1 = new FrameLayout(this.g);
        Iterator<T> r4 = p31.b.a.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        c r5 = (c) r4.next();
        HashMap<Class<? extends View>, View> r6 = this.b;
        r5.getClass();
        if (r6.get(null) != null) goto L7;
        this.d.inflate(0, r1, this.e);
        goto L4
    L7:
        jy0.b.c("link_preload", "already loaded layout " + r5, null, 4);
        goto L4
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.g = r2;
        this.b = new HashMap();
        this.c = new LinkedList();
        this.d = new AsyncLayoutInflater(r2);
        this.e = new C0289a(this);
        this.f = new b(this);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.f
    public final void b(int r6) {
        jy0.b.f("link_preload", "start asyncInflateMultiAnchorLayout windowCnt=" + r6, null, 4);
        if (r6 <= 0) goto L8;
        AsyncLayoutInflater r0 = new AsyncLayoutInflater(this.g);
        int r1 = 0;
        int r7 = RangesKt.coerceAtLeast(r6 - ((LinkedList) this.c).size(), 0);
    L6:
        if (r1 >= r7) goto L10;
        r0.inflate(2131566208, null, this.f);
        r1 = r1 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.f
    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        jy0.b.c("link_preload", "clear by " + r4 + " , layoutMap:" + this.b.size() + " asyncViews:" + ((LinkedList) this.c).size(), null, 4);
        this.b.clear();
        ((LinkedList) this.c).clear();
    }
}
