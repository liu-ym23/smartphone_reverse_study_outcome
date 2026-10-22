package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends eh0.a {
    public final List<ch0.h> b;
    public int c;
    public final Map<String, Boolean> d;
    public final CompositeDisposable e;
    public boolean f;
    public final b g;
    public eg6.b h;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d i;

    public static final class a {
    }

    public static final class b extends eg6.a {
        public final /* synthetic */ c a;

        public final void o() {
            c.d(this.a);
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.i;
            if (r1 == null) goto L6;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerExV2", hashCode(), "onLocalUserLeaved", false, 24);
            return;
        }

        public b(c r1) {
            this.a = r1;
        }

        public final void i(String r8) {
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.i;
            if (r1 == null) goto L6;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerExV2", hashCode(), "onLocalUserJoined, interactId: " + r8, false, 24);
            return;
        }

        public final void q(int r9) {
            c r0 = this.a;
            if (r0.c != r9) goto L5;
            return;
        L5:
            r0.c = r9;
            Iterator r10 = ((CopyOnWriteArrayList) r0.b).iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            ch0.h r1 = (ch0.h) r10.next();
            ch0.h r2 = ch0.h.a(r1, null, false, false, false, this.a.c, 63);
            ((CopyOnWriteArrayList) this.a.b).remove(r1);
            ((CopyOnWriteArrayList) this.a.b).add(r2);
            goto L7
        L9:
            this.a.c();
        }

        public final void S1(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r9, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.i;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerExV2", hashCode(), "onExRtcRoomLocalUserLeaved, rtcRoomId: " + r8 + ", interactId: " + r9, false, 24);
        L5:
            c.d(this.a);
        }

        public final void e(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r9, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.i;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerExV2", hashCode(), "onExRtcRoomRemoteUserJoined, rtcRoomId: " + r8 + ", interactId: " + r9, false, 24);
        L5:
            Iterator r10 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L7:
            if (r10.hasNext() == false) goto L11;
            Object r0 = r10.next();
            if (Intrinsics.areEqual(((ch0.h) r0).a, r9) == false) goto L7;
        L13:
            if (((ch0.h) r0) != null) goto L15;
            ((CopyOnWriteArrayList) this.a.b).add(new ch0.h(r9, true, true, this.a.c, 32));
            boolean r11 = true;
        L16:
            c r12 = this.a;
            if (r11 == false) goto L19;
            r12.c();
            return;
        L19:
            r12.getClass();
            return;
        L15:
            r11 = false;
            goto L16
        L11:
            r0 = null;
            goto L13
        }

        public final void h(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r9, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.i;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerExV2", hashCode(), "onExRtcRoomRemoteUserLeaved, rtcRoomId: " + r8 + ", interactId: " + r9, false, 24);
        L5:
            Iterator r10 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L7:
            if (r10.hasNext() == false) goto L11;
            Object r0 = r10.next();
            if (Intrinsics.areEqual(((ch0.h) r0).a, r9) == false) goto L7;
        L12:
            ch0.h r2 = (ch0.h) r0;
            if (r2 == null) goto L15;
            ((CopyOnWriteArrayList) this.a.b).remove(r2);
            boolean r11 = true;
        L16:
            c r12 = this.a;
            if (r11 == false) goto L19;
            r12.c();
            return;
        L19:
            r12.getClass();
            return;
        L15:
            r11 = false;
            goto L16
        L11:
            r0 = null;
            goto L12
        }

        public final void n2(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r9, "interactId");
            super.n2(r8, r9);
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.i;
            if (r1 == null) goto L6;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerExV2", hashCode(), "onExRtcRoomLocalUserJoined, rtcRoomId: " + r8 + ", interactId: " + r9, false, 24);
            return;
        }

        public final void onTalkStateUpdated(String[] r9, boolean[] r10) {
            if (r9 == null) goto L33;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r9.length != r10.length) goto L36;
            LinkedHashMap r0 = new LinkedHashMap();
            LinkedHashMap r1 = new LinkedHashMap();
            int r2 = r9.length;
            boolean r3 = false;
            int r4 = 0;
        L8:
            if (r4 >= r2) goto L14;
            String r5 = r9[r4];
            boolean r6 = r10[r4];
            r0.put(r5, Boolean.valueOf(r6));
            if (r6 == false) goto L12;
            r1.put(r5, Long.valueOf(System.currentTimeMillis()));
        L13:
            r4 = r4 + 1;
            goto L8
        L12:
            r1.put(r5, 0L);
            goto L13
        L14:
            boolean r7 = true;
            if (r0.size() == this.a.d.size()) goto L17;
            r3 = true;
        L17:
            Iterator r11 = r0.entrySet().iterator();
        L19:
            if (r11.hasNext() == false) goto L23;
            Map.Entry r12 = (Map.Entry) r11.next();
            if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.a.d).get((String) r12.getKey()), Boolean.valueOf(((Boolean) r12.getValue()).booleanValue()))) == false) goto L19;
        L24:
            if (r7 == false) goto L35;
            ((LinkedHashMap) this.a.d).clear();
            this.a.d.putAll(r0);
            this.a.b().n(this.a.d);
            this.a.b().p(r1);
            return;
        L35:
            return;
        L23:
            r7 = r3;
            goto L24
        L36:
            return;
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        eg6.b r0 = this.h;
        if (r0 == null) goto L5;
        r0.h0(this.g);
    L5:
        this.f = true;
    }

    @Override // eh0.c
    public final void detach() {
        eg6.b r0 = this.h;
        if (r0 == null) goto L5;
        r0.s(this.g);
    L5:
        this.e.clear();
        this.f = false;
    }

    public static final void d(c r7) {
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r0 = r7.i;
        if (r0 == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r0, "RemoteRtcHandlerExV2", r7.hashCode(), "clear rtcRemoteUserInfoListSize=" + ((CopyOnWriteArrayList) r7.b).size(), false, 24);
    L6:
        if ((!((CopyOnWriteArrayList) r7.b).isEmpty()) == false) goto L12;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = r7.i;
        if (r1 == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerExV2", r7.hashCode(), "clear", false, 24);
    L10:
        ((CopyOnWriteArrayList) r7.b).clear();
        ((LinkedHashMap) r7.d).clear();
        r7.c();
        return;
    }

    @Override // eh0.a, eh0.c
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a a(List<ch0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "oldMergeDataList");
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.i;
        if (r1 == null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerExV2", hashCode(), "updateRemoteLinkUserMergeData", false, 24);
    L5:
        List<ch0.h> r0 = this.b;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r2 = ((CopyOnWriteArrayList) r0).iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Object r4 = r2.next();
        r3.put(((ch0.h) r4).a, r4);
        goto L7
    L9:
        List<ch0.e> r14 = r13;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
        boolean r6 = false;
        ch0.e r7 = null;
    L11:
        if (r15.hasNext() == false) goto L26;
        ch0.e r8 = (ch0.e) r15.next();
        ch0.h r9 = (ch0.h) r3.get(r8.a.getInteractId());
        if (r8.c(r9) == false) goto L15;
        boolean r10 = r6;
        ch0.e r11 = r8;
    L16:
        IBaseUser r12 = r11.a.getUser();
        if (r12 == null) goto L19;
        String r16 = r12.getIdString();
    L21:
        if (Intrinsics.areEqual(r16, gh0.a.c()) == false) goto L24;
        if (r11 == r8) goto L24;
        r7 = r11;
    L24:
        r5.add(r11);
        r6 = r10;
        goto L11
    L19:
        r16 = null;
        goto L21
    L15:
        r11 = ch0.e.a(r8, null, r9, null, null, 13);
        r10 = true;
        goto L16
    L26:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r6, r5, r7);
    }

    public c(eg6.b r1, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r2) {
        this.h = r1;
        this.i = r2;
        this.b = new CopyOnWriteArrayList();
        this.d = new LinkedHashMap();
        this.e = new CompositeDisposable();
        this.g = new b(this);
    }
}
