package q0a;

import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.impl.viewholder.CreationVideoViewHolder;
import com.larus.ugc.feed.impl.viewholder.h0;
import com.larus.ugc.feed.impl.viewholder.i0;
import com.larus.utils.y;
import com.larus.video.impl.sdk.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public IVideoController a;
    public final ConcurrentLinkedQueue<WeakReference<CreationVideoViewHolder>> b;
    public WeakReference<CreationVideoViewHolder> c;
    public int d;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            CreationVideoViewHolder r4 = (CreationVideoViewHolder) ((WeakReference) r2).get();
            Integer r0 = null;
            if (r4 == null) goto L5;
            Integer r5 = Integer.valueOf(r4.getAbsoluteAdapterPosition());
        L6:
            CreationVideoViewHolder r6 = (CreationVideoViewHolder) ((WeakReference) r3).get();
            if (r6 == null) goto L10;
            r0 = Integer.valueOf(r6.getAbsoluteAdapterPosition());
        L10:
            return ComparisonsKt.compareValues(r5, r0);
        L5:
            r5 = null;
            goto L6
        }
    }

    public static boolean a() {
        return z2.a.downgradeCreationFeedVideoFix();
    }

    public final List<WeakReference<CreationVideoViewHolder>> b() {
        List r0 = CollectionsKt.sortedWith(this.b, new a());
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((WeakReference) r3).get() == null) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        return r1;
    }

    public f() {
        this.b = new ConcurrentLinkedQueue();
        this.d = -1;
    }

    public final void d() {
        this.c = (WeakReference) CollectionsKt.firstOrNull(b());
        if (a() == false) goto L10;
        WeakReference<CreationVideoViewHolder> r0 = this.c;
        if (r0 == null) goto L10;
        CreationVideoViewHolder r1 = r0.get();
        if (r1 == null) goto L10;
        c(r1);
    L10:
        if (a() == true) goto L32;
        Iterator<WeakReference<CreationVideoViewHolder>> r2 = this.b.iterator();
    L13:
        if (r2.hasNext() == false) goto L19;
        WeakReference<CreationVideoViewHolder> r3 = r2.next();
        if (Intrinsics.areEqual(r3, this.c) == true) goto L13;
        final CreationVideoViewHolder r4 = r3.get();
        if (r4 == null) goto L13;
        y.c(new i0(r4));
        goto L13
    L19:
        WeakReference<CreationVideoViewHolder> r5 = this.c;
        if (r5 == null) goto L33;
        CreationVideoViewHolder r6 = r5.get();
        if (r6 == null) goto L34;
        c(r6);
        return;
    L34:
        return;
    L33:
        return;
    }

    public final void c(final CreationVideoViewHolder r5) {
        if (a() == true) goto L14;
        IVideoController r0 = this.a;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        if (this.d != r5.getAdapterPosition()) goto L14;
        return;
    L7:
        if (r0.p3() != true) goto L9;
        r1 = true;
    L14:
        WeakReference<CreationVideoViewHolder> r2 = this.c;
        if (r2 == null) goto L19;
        CreationVideoViewHolder r3 = r2.get();
        if (r3 == null) goto L19;
        int r4 = r3.getAdapterPosition();
    L20:
        this.d = r4;
        IVideoController r6 = this.a;
        if (r6 == null) goto L23;
        r6.release();
    L23:
        IVideoController r7 = null;
        this.a = null;
        IVideoController r8 = q3.b("ugc_video", null, 6);
        if (r8 == null) goto L26;
        ((o) r8).setSubTag("message_card");
        r7 = r8;
    L26:
        this.a = r7;
        VideoPlayView r9 = r5.e;
        if (r7 != null) goto L29;
        r9.getClass();
    L35:
        boolean r10 = w0a.a.a;
        UserCreationKmp r11 = r5.i;
        if (r11 == null) goto L41;
        Long r12 = r11.getCreateTime();
        if (r12 == null) goto L41;
        String r13 = r12.toString();
        if (r13 == null) goto L41;
    L42:
        w0a.a.c("onCardDisplay", r13);
        y.c(new h0(r5));
        return;
    L41:
        r13 = "";
        goto L42
    L29:
        if (r7 == r9.C) goto L31;
        r9.N();
    L31:
        r9.C = r7;
        ((o) r7).setLooping(true);
        IVideoController r14 = r9.C;
        if (r14 == null) goto L35;
        r14.C(r9.s);
    L19:
        r4 = -1;
        goto L20
    }
}
