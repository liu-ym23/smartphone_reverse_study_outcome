package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s extends eh0.a {
    public final List<ch0.h> b;
    public int c;
    public final CompositeDisposable d;
    public boolean e;
    public final b f;
    public eg6.b g;

    public static final class a {
    }

    public static final class b extends eg6.a {
        public final /* synthetic */ s a;

        public final void o() {
            s.d(this.a);
            gh0.a.b("RemoteRtcHandlerEx", "onLocalUserLeaved", 4);
        }

        public b(s r1) {
            this.a = r1;
        }

        public final void i(String r3) {
            gh0.a.b("RemoteRtcHandlerEx", "onLocalUserJoined, interactId: " + r3, 4);
        }

        public final void q(int r9) {
            s r0 = this.a;
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

        public final void S1(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r4, "interactId");
            gh0.a.b("RemoteRtcHandlerEx", "onExRtcRoomLocalUserLeaved, rtcRoomId: " + r3 + ", interactId: " + r4, 4);
            s.d(this.a);
        }

        public final void e(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r9, "interactId");
            gh0.a.b("RemoteRtcHandlerEx", "onExRtcRoomRemoteUserJoined, rtcRoomId: " + r8 + ", interactId: " + r9, 4);
            Iterator r10 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L4:
            if (r10.hasNext() == false) goto L8;
            Object r0 = r10.next();
            if (Intrinsics.areEqual(((ch0.h) r0).a, r9) == false) goto L4;
        L10:
            if (((ch0.h) r0) != null) goto L12;
            ((CopyOnWriteArrayList) this.a.b).add(new ch0.h(r9, true, true, this.a.c, 32));
            boolean r11 = true;
        L13:
            s r12 = this.a;
            if (r11 == false) goto L16;
            r12.c();
            return;
        L16:
            r12.getClass();
            return;
        L12:
            r11 = false;
            goto L13
        L8:
            r0 = null;
            goto L10
        }

        public final void h(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r4, "interactId");
            gh0.a.b("RemoteRtcHandlerEx", "onExRtcRoomRemoteUserLeaved, rtcRoomId: " + r3 + ", interactId: " + r4, 4);
            Iterator r5 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Object r0 = r5.next();
            if (Intrinsics.areEqual(((ch0.h) r0).a, r4) == false) goto L4;
        L9:
            ch0.h r1 = (ch0.h) r0;
            if (r1 == null) goto L12;
            ((CopyOnWriteArrayList) this.a.b).remove(r1);
            boolean r6 = true;
        L13:
            s r7 = this.a;
            if (r6 == false) goto L16;
            r7.c();
            return;
        L16:
            r7.getClass();
            return;
        L12:
            r6 = false;
            goto L13
        L8:
            r0 = null;
            goto L9
        }

        public final void n2(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r4, "interactId");
            super.n2(r3, r4);
            gh0.a.b("RemoteRtcHandlerEx", "onExRtcRoomLocalUserJoined, rtcRoomId: " + r3 + ", interactId: " + r4, 4);
        }

        public final void onTalkStateUpdated(String[] r13, boolean[] r14) {
            if (r13 == null) goto L39;
            if (r14 != null) goto L5;
            return;
        L5:
            if (r13.length != r14.length) goto L42;
            int r0 = r13.length;
            int r1 = 0;
            boolean r2 = false;
        L8:
            if (r1 >= r0) goto L27;
            String r3 = r13[r1];
            boolean r11 = r14[r1];
            Iterator r4 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L11:
            if (r4.hasNext() == false) goto L15;
            Object r5 = r4.next();
            if (Intrinsics.areEqual(((ch0.h) r5).a, r3) == false) goto L11;
        L16:
            ch0.h r6 = (ch0.h) r5;
            if (r6 == null) goto L26;
            if (r6.e == r11) goto L26;
            ch0.h r7 = ch0.h.a(r6, null, false, false, r11, 0, 111);
            ((CopyOnWriteArrayList) this.a.b).remove(r6);
            ((CopyOnWriteArrayList) this.a.b).add(r7);
            if (r11 == false) goto L24;
            r7.f = System.currentTimeMillis();
        L25:
            r2 = true;
            goto L26
        L24:
            r7.f = 0;
        L26:
            r1 = r1 + 1;
            goto L8
        L15:
            r5 = null;
            goto L16
        L27:
            s r15 = this.a;
            if (r2 == false) goto L30;
            r15.c();
            return;
        L30:
            r15.getClass();
            return;
        L42:
            return;
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        eg6.b r0 = this.g;
        if (r0 == null) goto L5;
        r0.h0(this.f);
    L5:
        this.e = true;
    }

    @Override // eh0.c
    public final void detach() {
        eg6.b r0 = this.g;
        if (r0 == null) goto L5;
        r0.s(this.f);
    L5:
        this.d.clear();
        this.e = false;
    }

    public s(eg6.b r1) {
        this.g = r1;
        this.b = new CopyOnWriteArrayList();
        this.d = new CompositeDisposable();
        this.f = new b(this);
    }

    public static final void d(s r3) {
        r3.getClass();
        ALogger.i("RemoteRtcHandlerEx", "clear");
        if ((!((CopyOnWriteArrayList) r3.b).isEmpty()) == false) goto L6;
        gh0.a.b("RemoteRtcHandlerEx", "clear", 4);
        ((CopyOnWriteArrayList) r3.b).clear();
        r3.c();
        return;
    }

    @Override // eh0.a, eh0.c
    public final h.a a(List<ch0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "oldMergeDataList");
        ALogger.i("RemoteRtcHandlerEx", "updateRemoteLinkUserMergeData");
        List<ch0.h> r0 = this.b;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r2 = r1.next();
        r3.put(((ch0.h) r2).a, r2);
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
        ch0.h r8 = (ch0.h) r3.get(r7.a.getInteractId());
        if (r7.c(r8) == false) goto L12;
        boolean r9 = r5;
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
        r5 = r9;
        goto L8
    L16:
        r12 = null;
        goto L18
    L12:
        r10 = ch0.e.a(r7, null, r8, null, null, 13);
        r9 = true;
        goto L13
    L23:
        return new h.a(r5, r4, r6);
    }
}
