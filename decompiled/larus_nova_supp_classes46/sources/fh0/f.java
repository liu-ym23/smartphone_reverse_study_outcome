package fh0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sh0.h0;
import sh0.i0;
import sh0.j0;
import sh0.o;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public boolean b;
    public long c;
    public p d;
    public Object e;
    public final CompositeDisposable f;
    public final DataCenter g;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            f r0 = this.a;
            if (r4 == null) goto L5;
            Object r1 = r4.getData();
        L6:
            if (r1 == null) goto L12;
            Object r5 = r4.getData();
            if (r5 == null) goto L11;
            boolean r6 = ((Boolean) r5).booleanValue();
        L13:
            r0.b = r6;
            gh0.a.b("UniversalPlayModeExtHandler", "state changed isGuestBattleShowing: " + this.a.b + ' ', 4);
            this.a.a().c1(this.a.b);
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L12:
            r6 = false;
            goto L13
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c implements ne0.a {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r7, Object r8) {
            Intrinsics.checkNotNullParameter(r7, "store");
            if ((r8 instanceof sh0.p) == false) goto L9;
            f r9 = this.a;
            ((sh0.p) r8).getClass();
            r9.getClass();
            g r10 = new g(r9);
            if ((System.currentTimeMillis() - r9.c) >= 60) goto L7;
            gh0.a.b("UniversalPlayModeExtHandler", "dispatchGuestBattleMicSeatUpdateAction: null, delay", 4);
            MainThreadPostUtils.c(r10, 60);
            return;
        L7:
            gh0.a.b("UniversalPlayModeExtHandler", "dispatchGuestBattleMicSeatUpdateAction: null", 4);
            r10.run();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        i0 r0 = j0.a;
        DataCenter r1 = this.g;
        int r2 = h0.a;
        j0.f(r1, "is_guestbattle_showing", new b(this));
        i0 r3 = j0.a(this.g);
        if (r3 == null) goto L6;
        r3.d(o.b, new c(this));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.f.dispose();
    }

    public f(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.g = r2;
        this.f = new CompositeDisposable();
        i0 r3 = j0.a(r2);
        if (r3 == null) goto L11;
        ne0.g r4 = r3.b;
        if (r4 == null) goto L7;
        int r0 = h0.a;
        Boolean r5 = (Boolean) r4.a("is_guestbattle_showing");
    L8:
        boolean r1 = true;
        if (Intrinsics.areEqual(r5, Boolean.TRUE) != true) goto L11;
    L12:
        this.b = r1;
        return;
    L7:
        r5 = null;
    L11:
        r1 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r11) {
        Intrinsics.checkNotNullParameter(r11, "oldMergeDataList");
        List<ch0.e> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
        ch0.e r2 = null;
    L4:
        if (r13.hasNext() == false) goto L15;
        ch0.e r3 = (ch0.e) r13.next();
        HashMap r8 = new HashMap(r3.d);
        r8.put("EXT_KEY_GUEST_BATTLE_ACTION", this.d);
        r8.put("EXT_KEY_GUEST_BATTLE_ACTION_PAYLOAD", this.e);
        ch0.e r4 = ch0.e.a(r3, null, null, null, r8, 7);
        IBaseUser r5 = r4.a.getUser();
        if (r5 == null) goto L8;
        String r6 = r5.getIdString();
    L10:
        if (Intrinsics.areEqual(r6, gh0.a.c()) == false) goto L13;
        if (r4 == r3) goto L13;
        r2 = r4;
    L13:
        r0.add(r4);
        goto L4
    L8:
        r6 = null;
        goto L10
    L15:
        return new h.a(true, r0, r2);
    }
}
