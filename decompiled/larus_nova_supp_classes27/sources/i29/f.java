package i29;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.community.impl.viewholder.CreationVideoViewHolder;
import com.larus.community.impl.viewholder.l0;
import com.larus.community.impl.viewholder.n0;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.utils.y;
import com.larus.video.impl.sdk.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public final String a;
    public final String b;
    public IVideoController c;
    public final ConcurrentLinkedQueue<WeakReference<CreationVideoViewHolder>> d;
    public WeakReference<CreationVideoViewHolder> e;
    public int f;

    public static final class a<T> implements Comparator {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            CreationVideoViewHolder r5 = (CreationVideoViewHolder) ((WeakReference) r3).get();
            Integer r0 = null;
            if (r5 == null) goto L5;
            this.a.getClass();
            Integer r6 = Integer.valueOf(f.b(r5));
        L6:
            CreationVideoViewHolder r7 = (CreationVideoViewHolder) ((WeakReference) r4).get();
            if (r7 == null) goto L10;
            this.a.getClass();
            r0 = Integer.valueOf(f.b(r7));
        L10:
            return ComparisonsKt.compareValues(r6, r0);
        L5:
            r6 = null;
            goto L6
        }
    }

    public static boolean a() {
        return z2.a.downgradeCreationFeedVideoFix();
    }

    public final List<WeakReference<CreationVideoViewHolder>> c() {
        List r0 = CollectionsKt.sortedWith(this.d, new a(this));
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        CreationVideoViewHolder r4 = (CreationVideoViewHolder) ((WeakReference) r3).get();
        if (r4 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == false) goto L4;
        r1.add(r3);
        goto L4
    L9:
        if (b(r4) == (-1)) goto L11;
        r5 = true;
        goto L12
    L14:
        return r1;
    }

    public final void e() {
        this.e = (WeakReference) CollectionsKt.firstOrNull(c());
        if (a() == false) goto L10;
        WeakReference<CreationVideoViewHolder> r0 = this.e;
        if (r0 == null) goto L10;
        CreationVideoViewHolder r1 = r0.get();
        if (r1 == null) goto L10;
        d(r1);
    L10:
        if (a() == true) goto L32;
        Iterator<WeakReference<CreationVideoViewHolder>> r2 = this.d.iterator();
    L13:
        if (r2.hasNext() == false) goto L19;
        WeakReference<CreationVideoViewHolder> r3 = r2.next();
        if (Intrinsics.areEqual(r3, this.e) == true) goto L13;
        final CreationVideoViewHolder r4 = r3.get();
        if (r4 == null) goto L13;
        y.c(new n0(r4));
        goto L13
    L19:
        WeakReference<CreationVideoViewHolder> r5 = this.e;
        if (r5 == null) goto L33;
        CreationVideoViewHolder r6 = r5.get();
        if (r6 == null) goto L34;
        d(r6);
        return;
    L34:
        return;
    L33:
        return;
    }

    public static int b(CreationVideoViewHolder r2) {
        RecyclerView r0 = ((RecyclerView.ViewHolder) r2).itemView.getParent();
        if ((r0 instanceof RecyclerView) == false) goto L5;
        RecyclerView r1 = r0;
    L6:
        if (r1 != null) goto L10;
        return -1;
    L10:
        return r1.getChildAdapterPosition(((RecyclerView.ViewHolder) r2).itemView);
    L5:
        r1 = null;
        goto L6
    }

    public final void d(final CreationVideoViewHolder r5) {
        if (a() == true) goto L14;
        IVideoController r0 = this.c;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        if (this.f != r5.getAdapterPosition()) goto L14;
        return;
    L7:
        if (r0.p3() != true) goto L9;
        r1 = true;
    L14:
        WeakReference<CreationVideoViewHolder> r2 = this.e;
        if (r2 == null) goto L19;
        CreationVideoViewHolder r3 = r2.get();
        if (r3 == null) goto L19;
        int r4 = r3.getAdapterPosition();
    L20:
        this.f = r4;
        IVideoController r6 = this.c;
        if (r6 == null) goto L23;
        r6.release();
    L23:
        IVideoController r7 = null;
        this.c = null;
        Lazy r8 = q3.a;
        IVideoController r9 = q3.b(this.a, null, 6);
        if (r9 == null) goto L26;
        o r10 = (o) r9;
        r10.setSubTag(this.b);
        r7 = r9;
    L26:
        this.c = r7;
        VideoPlayView r11 = r5.j;
        if (r7 != null) goto L29;
        r11.getClass();
    L35:
        boolean r12 = m29.a.a;
        UserCreation r13 = r5.n;
        if (r13 == null) goto L41;
        Long r14 = r13.m;
        if (r14 == null) goto L41;
        String r15 = r14.toString();
        if (r15 == null) goto L41;
    L42:
        m29.a.c("onCardDisplay", r15);
        y.c(new l0(r5));
        return;
    L41:
        r15 = "";
        goto L42
    L29:
        if (r7 == r11.C) goto L31;
        r11.N();
    L31:
        r11.C = r7;
        ((o) r7).setLooping(true);
        IVideoController r16 = r11.C;
        if (r16 == null) goto L35;
        r16.C(r11.s);
    L19:
        r4 = -1;
        goto L20
    }

    public f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "videoEngineTag");
        Intrinsics.checkNotNullParameter(r3, "videoEngineSubTag");
        this.a = r2;
        this.b = r3;
        this.d = new ConcurrentLinkedQueue();
        this.f = -1;
    }
}
