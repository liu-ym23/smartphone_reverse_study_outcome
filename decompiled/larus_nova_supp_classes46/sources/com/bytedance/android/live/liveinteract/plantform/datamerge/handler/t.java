package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t extends eh0.a {
    public final List<ch0.j> b;
    public final CompositeDisposable c;
    public boolean d;
    public final b e;
    public eg6.b f;

    public static final class a {
    }

    public static final class b extends eg6.a {
        public final /* synthetic */ t a;

        public b(t r1) {
            this.a = r1;
        }

        public final void i(String r4) {
            t r5 = this.a;
            if ((!((ArrayList) r5.b).isEmpty()) == false) goto L6;
            gh0.a.b("RemoteSeiHandler", "clear", 4);
            ((ArrayList) r5.b).clear();
            r5.c();
            return;
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        eg6.b r0 = this.f;
        if (r0 == null) goto L5;
        r0.h0(this.e);
    L5:
        this.d = true;
    }

    @Override // eh0.c
    public final void detach() {
        this.c.clear();
        eg6.b r0 = this.f;
        if (r0 == null) goto L5;
        r0.s(this.e);
    L5:
        this.d = false;
    }

    public t(eg6.b r1) {
        this.f = r1;
        this.b = new ArrayList();
        this.c = new CompositeDisposable();
        this.e = new b(this);
    }

    @Override // eh0.a, eh0.c
    public final h.a a(List<ch0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "oldMergeDataList");
        List<ch0.j> r0 = this.b;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = ((ArrayList) r0).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r2 = r1.next();
        r3.put(((ch0.j) r2).a, r2);
        goto L4
    L6:
        List<ch0.e> r14 = r13;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
        boolean r5 = false;
        ch0.e r6 = null;
    L8:
        if (r15.hasNext() == false) goto L23;
        ch0.e r7 = (ch0.e) r15.next();
        ch0.j r9 = (ch0.j) r3.get(r7.a.getInteractId());
        if (r7.d(r9) == false) goto L12;
        boolean r8 = r5;
        ch0.e r10 = r7;
    L13:
        IBaseUser r11 = r10.a.getUser();
        if (r11 == null) goto L16;
        String r12 = r11.getIdString();
    L18:
        if (Intrinsics.areEqual(r12, gh0.a.c()) == false) goto L21;
        if (r10 == r7) goto L21;
        r6 = r10;
    L21:
        r4.add(r10);
        r5 = r8;
        goto L8
    L16:
        r12 = null;
        goto L18
    L12:
        r10 = ch0.e.a(r7, null, null, r9, null, 11);
        r8 = true;
        goto L13
    L23:
        return new h.a(r5, r4, r6);
    }

    public final void d(SeiAppData r18) {
        Intrinsics.checkNotNullParameter(r18, "sei");
        String r1 = r18.getChannelId();
        Long r3 = null;
        IRoom r4 = je0.d.e(null);
        if (r4 == null) goto L5;
        Long r5 = Long.valueOf(r4.getId());
    L7:
        if ((!Intrinsics.areEqual(r1, String.valueOf(r5))) == false) goto L13;
        StringBuilder r2 = new StringBuilder("sei channel id wrong ");
        r2.append(r18.getChannelId());
        r2.append(" room ");
        IRoom r6 = je0.d.e(null);
        if (r6 == null) goto L11;
        r3 = Long.valueOf(r6.getId());
    L11:
        r2.append(r3);
        ALogger.d("RemoteSeiHandler", r2.toString());
        return;
    L13:
        ArrayList r7 = new ArrayList();
        int r8 = r18.getGrids().size();
        int r9 = 0;
        boolean r10 = false;
    L14:
        if (r9 >= r8) goto L37;
        SeiRegion r11 = (SeiRegion) ListProtector.get(r18.getGrids(), r9);
        Iterator r12 = ((ArrayList) this.b).iterator();
    L17:
        if (r12.hasNext() == false) goto L21;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((ch0.j) r13).a, r11.getInteractId()) == false) goto L17;
    L22:
        ch0.j r14 = (ch0.j) r13;
        if (r14 != null) goto L25;
        r7.add(new ch0.j(r11.getInteractId(), r11.isTalking(), r11.getType(), r11.position, r11.isVisible()));
    L35:
        r10 = true;
    L36:
        r9 = r9 + 1;
        goto L14
    L25:
        if (r11.getType() == r14.c) goto L27;
    L33:
        r7.add(ch0.j.a(r14, r11.isTalking(), r11.getType(), r11.position, r11.isVisible(), 1));
        goto L35
    L27:
        if (r11.position != r14.d) goto L33;
        if (r11.isTalking() != r14.b) goto L33;
        if (r11.isVisible() != r14.e) goto L33;
        r7.add(r14);
        goto L36
    L21:
        r13 = null;
        goto L22
    L37:
        if (r10 == false) goto L39;
    L40:
        ((ArrayList) this.b).clear();
        ((ArrayList) this.b).addAll(r7);
    L41:
        if (r10 == false) goto L50;
        c();
        return;
    L50:
        return;
    L39:
        if (r7.isEmpty() == false) goto L41;
    L5:
        r5 = null;
        goto L7
    }
}
