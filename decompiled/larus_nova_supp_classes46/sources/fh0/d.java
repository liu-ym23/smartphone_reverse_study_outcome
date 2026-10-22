package fh0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sh0.b0;
import sh0.c0;
import sh0.i0;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public c0 b;
    public final DataCenter c;

    public static final class a {
    }

    public static final class b implements ne0.a {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "store");
            gh0.a.b("SeatAnimHandler", "ShowSeatAnim " + r4, 4);
            d r5 = this.a;
            if ((r4 instanceof c0) == true) goto L5;
            r4 = null;
        L5:
            r5.b = (c0) r4;
            r5.c();
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        i0 r0 = j0.a(this.c);
        if (r0 == null) goto L6;
        r0.d(b0.b, new b(this));
        return;
    }

    public d(DataCenter r1) {
        this.c = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "oldMergeDataList");
        List<ch0.e> r14 = r13;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
        boolean r1 = false;
        ch0.e r3 = null;
    L4:
        if (r15.hasNext() == false) goto L27;
        ch0.e r4 = (ch0.e) r15.next();
        c0 r5 = this.b;
        if (r5 == null) goto L8;
        String r6 = r5.c;
    L9:
        IBaseUser r7 = r4.a.getUser();
        if (r7 == null) goto L12;
        String r8 = r7.getIdString();
    L13:
        boolean r11 = true;
        if ((!Intrinsics.areEqual(r6, r8)) == false) goto L16;
        r11 = r1;
        ch0.e r2 = r4;
    L17:
        IBaseUser r9 = r2.a.getUser();
        if (r9 == null) goto L20;
        String r10 = r9.getIdString();
    L22:
        if (Intrinsics.areEqual(r10, gh0.a.c()) == false) goto L25;
        if (r2 == r4) goto L25;
        r3 = r2;
    L25:
        r0.add(r2);
        r1 = r11;
        goto L4
    L20:
        r10 = null;
        goto L22
    L16:
        HashMap r12 = new HashMap(r4.d);
        r12.put("EXT_KEY_SEAT_ANIM_ACTION", Boolean.TRUE);
        r12.put("EXT_KEY_SEAT_ANIM_ACTION_PAYLOAD", this.b);
        r2 = ch0.e.a(r4, null, null, null, r12, 7);
        goto L17
    L12:
        r8 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    L27:
        return new h.a(r1, r0, r3);
    }
}
