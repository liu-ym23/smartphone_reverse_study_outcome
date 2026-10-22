package y02;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.k6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements f<NormalGiftMessage> {
    public final TreeSet<NormalGiftMessage> a;
    public final TreeSet<NormalGiftMessage> b;
    public final TreeSet<NormalGiftMessage> c;
    public final TreeSet<NormalGiftMessage> d;
    public final List<e> e;

    public static final class a {
    }

    public static final class b implements g<NormalGiftMessage> {
        public Iterator<? extends NormalGiftMessage> a;
        public int b;
        public final /* synthetic */ d c;

        @Override // y02.g
        public final boolean hasNext() {
        L2:
            Iterator<? extends NormalGiftMessage> r0 = this.a;
            if (r0 == null) goto L20;
            if (r0 == null) goto L20;
            if (r0.hasNext() == true) goto L20;
            int r1 = this.b + 1;
            this.b = r1;
            if (r1 == 0) goto L18;
            if (r1 != 1) goto L11;
            Iterator<NormalGiftMessage> r2 = this.c.c.iterator();
        L19:
            this.a = r2;
            goto L2
        L11:
            if (r1 != 2) goto L13;
            r2 = this.c.b.iterator();
            goto L19
        L13:
            if (r1 == 3) goto L15;
            r2 = null;
            goto L19
        L15:
            r2 = this.c.d.iterator();
            goto L19
        L18:
            r2 = this.c.a.iterator();
        L20:
            Iterator<? extends NormalGiftMessage> r3 = this.a;
            if (r3 != null) goto L33;
            return false;
        L33:
            return r3.hasNext();
        }

        @Override // y02.g
        public final NormalGiftMessage next() {
            Iterator<? extends NormalGiftMessage> r0 = this.a;
            if (r0 == null) goto L6;
            NormalGiftMessage r1 = r0.next();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return null;
        }

        @Override // y02.g
        public final void remove() {
            Iterator<? extends NormalGiftMessage> r0 = this.a;
            if (r0 == null) goto L6;
            r0.remove();
            return;
        }

        public b(d r1) {
            this.c = r1;
            this.a = r1.a.iterator();
        }
    }

    static {
    }

    @Override // y02.f
    public final int b() {
        return this.c.size();
    }

    @Override // y02.f
    public final void clear() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    @Override // y02.f
    public final g<NormalGiftMessage> iterator() {
        return new b(this);
    }

    @Override // y02.f
    public final NormalGiftMessage pollFirst() {
        if (this.a.size() <= 0) goto L6;
        return this.a.pollFirst();
    L6:
        if (this.c.size() <= 0) goto L9;
        return this.c.pollFirst();
    L9:
        if (this.b.size() <= 0) goto L12;
        return this.b.pollFirst();
    L12:
        if (this.d.size() > 0) goto L19;
        return null;
    L19:
        return this.d.pollFirst();
    }

    @Override // y02.f
    public final int size() {
        return ((this.a.size() + this.b.size()) + this.c.size()) + this.d.size();
    }

    public d() {
        y02.a r0 = new y02.a();
        this.a = new TreeSet(r0);
        this.b = new TreeSet(r0);
        this.c = new TreeSet(r0);
        this.d = new TreeSet(r0);
        this.e = new ArrayList();
    }

    @Override // y02.f
    public final void a(Function1<? super NormalGiftMessage, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Iterator<NormalGiftMessage> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke(r0.next());
        goto L4
    L6:
        Iterator<NormalGiftMessage> r1 = this.b.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r3.invoke(r1.next());
        goto L8
    L10:
        Iterator<NormalGiftMessage> r2 = this.c.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r3.invoke(r2.next());
        goto L12
    L14:
        Iterator<NormalGiftMessage> r4 = this.d.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r3.invoke(r4.next());
        goto L16
    }

    @Override // y02.f
    public final void c(com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.e).contains(r2) == true) goto L6;
        ((ArrayList) this.e).add(r2);
        return;
    }

    @Override // y02.f
    public final boolean d(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if ((r2.t instanceof k6) == false) goto L6;
        return this.a.remove(r2);
    L6:
        if (r2.n() == null) goto L12;
        if (this.b.contains(r2) == true) goto L17;
        return false;
    L17:
        return this.b.remove(r2);
    L12:
        if (r2.v == false) goto L15;
        return this.c.remove(r2);
    L15:
        return this.d.remove(r2);
    }

    @Override // y02.f
    public final void put(NormalGiftMessage r6) {
        NormalGiftMessage r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "msg");
        r7.h = System.currentTimeMillis();
        if ((r7.t instanceof k6) == false) goto L6;
        this.a.add(r7);
    L26:
        String r0 = v12.f.a;
        int r1 = this.c.size();
        List<e> r2 = this.e;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = ((ArrayList) r2).iterator();
    L28:
        if (r4.hasNext() == false) goto L30;
        r3.add(((e) r4.next()).getClass().getCanonicalName());
        goto L28
    L30:
        v12.f.K(r7, r1, r3);
        Iterator r8 = ((ArrayList) this.e).iterator();
    L32:
        if (r8.hasNext() == false) goto L34;
        ((e) r8.next()).b();
        goto L32
    L34:
        return;
    L6:
        if (r7.n() == null) goto L23;
        if (r7.n().getPrice() <= 0) goto L21;
        IBaseUser r5 = r7.n().getFromUser();
        String r9 = null;
        if (r5 == null) goto L12;
        String r10 = r5.getIdString();
    L13:
        k r11 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        if (r11 == null) goto L19;
        IBaseUser r13 = r11.getUser();
        if (r13 == null) goto L19;
        r9 = r13.getIdString();
    L19:
        if ((!Intrinsics.areEqual(r10, r9)) == false) goto L21;
        this.d.add(r7);
        goto L26
    L12:
        r10 = null;
    L21:
        this.b.add(r7);
        goto L26
    L23:
        if (r7.v == false) goto L25;
        this.c.add(r7);
        goto L26
    L25:
        this.d.add(r7);
        goto L26
    }

    @Override // y02.f
    public final void putFirst(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        throw new IllegalStateException("not support this function");
    }
}
