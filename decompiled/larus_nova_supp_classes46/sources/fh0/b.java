package fh0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import com.bytedance.android.livesdk.message.model.n7;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sh0.i0;
import sh0.j0;
import sh0.u;
import sh0.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public n7 b;
    public final DataCenter c;

    public static final class a {
    }

    /* JADX INFO: renamed from: fh0.b$b, reason: collision with other inner class name */
    public static final class C0208b implements ne0.a {
        public final /* synthetic */ b a;

        public C0208b(b r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "store");
            gh0.a.b("GiftIconFlashHandler", "OnGiftIconFlash " + r4, 4);
            b r5 = this.a;
            n7 r1 = null;
            if ((r4 instanceof v) == true) goto L5;
            r4 = null;
        L5:
            v r6 = (v) r4;
            if (r6 == null) goto L8;
            r1 = r6.a;
        L8:
            r5.b = r1;
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
        r0.d(u.b, new C0208b(this));
        return;
    }

    public b(DataCenter r1) {
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
        if (r15.hasNext() == false) goto L28;
        ch0.e r4 = (ch0.e) r15.next();
        n7 r5 = this.b;
        if (r5 == null) goto L17;
        List r6 = r5.getUserIdStrings();
        if (r6 == null) goto L17;
        List r7 = r6;
        IBaseUser r8 = r4.a.getUser();
        if (r8 == null) goto L12;
        String r9 = r8.getIdString();
    L13:
        boolean r11 = true;
        if (CollectionsKt.contains(r7, r9) != true) goto L17;
        HashMap r10 = new HashMap(r4.d);
        r10.put("EXT_KEY_GIFT_ICON_FLASH", Boolean.TRUE);
        ch0.e r2 = ch0.e.a(r4, null, null, null, r10, 7);
    L18:
        IBaseUser r12 = r2.a.getUser();
        if (r12 == null) goto L21;
        String r16 = r12.getIdString();
    L23:
        if (Intrinsics.areEqual(r16, gh0.a.c()) == false) goto L26;
        if (r2 == r4) goto L26;
        r3 = r2;
    L26:
        r0.add(r2);
        r1 = r11;
        goto L4
    L21:
        r16 = null;
        goto L23
    L12:
        r9 = null;
    L17:
        r11 = r1;
        r2 = r4;
        goto L18
    L28:
        return new h.a(r1, r0, r3);
    }
}
