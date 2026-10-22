package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSDataContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public final List<ch0.h> b;
    public ch0.g c;
    public ch0.d d;
    public int e;
    public boolean f;
    public final CompositeDisposable g;
    public boolean h;
    public final d i;
    public eg6.b j;
    public final DataCenter k;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            sh6.b r7 = (sh6.b) r6;
            ph0.b r0 = (ph0.b) sh6.c.b(r7);
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.b;
        L6:
            boolean r3 = true;
            if (r2 != null) goto L9;
        L12:
            boolean r4 = true;
        L13:
            if (r4 == true) goto L25;
            ph0.b r5 = (ph0.b) sh6.c.b(r7);
            if (r5 != null) goto L17;
        L19:
            r3 = false;
        L20:
            d r8 = this.a.i;
            ph0.b r9 = (ph0.b) sh6.c.b(r7);
            if (r9 == null) goto L23;
            r1 = r9.b;
        L23:
            Intrinsics.checkNotNull(r1);
            r8.c(r1, r3);
            return;
        L17:
            if (r5.c != 2) goto L19;
        L25:
            return;
        L9:
            if (StringsKt.isBlank(r2) == true) goto L12;
            r4 = false;
            goto L13
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ v a;

        public c(v r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ch0.d r2 = (ch0.d) r1;
            this.a.a().l1().getClass();
        }
    }

    public static final class d extends eg6.a {
        public final /* synthetic */ v a;

        public final void o() {
            gh0.a.a("RtcListener", "call onLocalUserLeaved", true);
            ch0.d r1 = v.f(this.a);
            boolean r3 = false;
            if (r1 == null) goto L5;
            v r4 = this.a;
            r4.getClass();
            r4.c = new ch0.g("", 0, 0, 0, 0);
            ch0.g r5 = this.a.c;
            Intrinsics.checkNotNull(r5);
            r1 = ch0.d.a(r1, 0, 0, r5, 7);
            r3 = true;
        L5:
            v.d(this.a, r3, r1);
            v r2 = this.a;
            if ((true ^ ((CopyOnWriteArrayList) r2.b).isEmpty()) == false) goto L9;
            gh0.a.b("RtcListener", "clear", 4);
            ((CopyOnWriteArrayList) r2.b).clear();
            r2.c();
            return;
        }

        public d(v r1) {
            this.a = r1;
        }

        public final void b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            gh0.a.b("RtcListener", "call onFirstRemoteVideoFrame, interactId: " + r10, 4);
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r1).a, r10) == false) goto L4;
        L9:
            ch0.h r2 = (ch0.h) r1;
            if (r2 != null) goto L12;
        L15:
            boolean r11 = false;
        L16:
            v.e(this.a, r11);
            return;
        L12:
            if (r2.c == false) goto L15;
            ch0.h r12 = ch0.h.a(r2, null, false, false, false, 0, 123);
            ((CopyOnWriteArrayList) this.a.b).remove(r2);
            ((CopyOnWriteArrayList) this.a.b).add(r12);
            r11 = true;
            goto L16
        L8:
            r1 = null;
            goto L9
        }

        public final void d(int r6) {
            boolean r2 = true;
            gh0.a.a("RtcListener", "call onLocalUserVideoCaptureStateChanged, status: " + r6, true);
            ch0.d r0 = v.f(this.a);
            boolean r1 = false;
            if (r0 == null) goto L12;
            ch0.g r3 = this.a.c;
            if (r3 != null) goto L7;
        L10:
            r2 = false;
        L11:
            r1 = r2;
            goto L12
        L7:
            if (r3.b == r6) goto L10;
            r3.b = r6;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
        L12:
            v.d(this.a, r1, r0);
            r(r1, r0);
        }

        public final void i(String r11) {
            boolean r2 = true;
            gh0.a.a("RtcListener", "call onLocalUserJoined", true);
            ch0.d r0 = v.f(this.a);
            boolean r1 = false;
            if (r0 == null) goto L10;
            if (r11 != null) goto L6;
        L8:
            r2 = false;
        L9:
            r1 = r2;
            goto L10
        L6:
            if (TextUtils.equals(r11, v.f(this.a).d.a) == true) goto L8;
            ch0.g r3 = new ch0.g(r11, 0, 0, 1, 1);
            this.a.c = r3;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
        L10:
            v.d(this.a, r1, r0);
            if (r11 == null) goto L14;
            p(r11);
            b(r11);
            return;
        }

        public final void j(int r6) {
            boolean r2 = true;
            gh0.a.a("RtcListener", "call onLocalUserVideoPublishStateChanged videoPublishStatus = " + r6, true);
            ch0.d r0 = v.f(this.a);
            boolean r1 = false;
            if (r0 == null) goto L12;
            ch0.g r3 = this.a.c;
            if (r3 != null) goto L7;
        L10:
            r2 = false;
        L11:
            r1 = r2;
            goto L12
        L7:
            if (r3.d == r6) goto L10;
            r3.d = r6;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
        L12:
            v.d(this.a, r1, r0);
            r(r1, r0);
        }

        public final void l(String r4) {
            Intrinsics.checkNotNullParameter(r4, "interactId");
            gh0.a.b("RtcListener", "call onRemoteUserLeaved, interactId: ".concat(r4), 4);
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r1).a, r4) == false) goto L4;
        L9:
            ch0.h r2 = (ch0.h) r1;
            if (r2 == null) goto L12;
            ((CopyOnWriteArrayList) this.a.b).remove(r2);
            boolean r5 = true;
        L13:
            v.e(this.a, r5);
            return;
        L12:
            r5 = false;
            goto L13
        L8:
            r1 = null;
            goto L9
        }

        public final void m(int r6) {
            boolean r2 = true;
            gh0.a.a("RtcListener", "call onLocalUserAudioCaptureStateChanged, status: " + r6, true);
            ch0.d r0 = v.f(this.a);
            boolean r1 = false;
            if (r0 == null) goto L12;
            ch0.g r3 = this.a.c;
            if (r3 != null) goto L7;
        L10:
            r2 = false;
        L11:
            r1 = r2;
            goto L12
        L7:
            if (r3.c == r6) goto L10;
            r3.c = r6;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
        L12:
            v.d(this.a, r1, r0);
            a(r1, r0);
        }

        public final void n(int r6) {
            boolean r2 = true;
            gh0.a.a("RtcListener", "call onLocalUserAudioPublishStateChanged", true);
            ch0.d r0 = v.f(this.a);
            boolean r1 = false;
            if (r0 == null) goto L12;
            ch0.g r3 = this.a.c;
            if (r3 != null) goto L7;
        L10:
            r2 = false;
        L11:
            r1 = r2;
            goto L12
        L7:
            if (r3.e == r6) goto L10;
            r3.e = r6;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
        L12:
            v.d(this.a, r1, r0);
            a(r1, r0);
        }

        public final void p(String r9) {
            Intrinsics.checkNotNullParameter(r9, "interactId");
            gh0.a.b("RtcListener", "call onRemoteUserJoined, interactId: " + r9, 4);
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r1).a, r9) == false) goto L4;
        L10:
            if (((ch0.h) r1) != null) goto L12;
            ((CopyOnWriteArrayList) this.a.b).add(new ch0.h(r9, true, true, this.a.e, 32));
            boolean r10 = true;
        L13:
            v.e(this.a, r10);
            return;
        L12:
            r10 = false;
            goto L13
        L8:
            r1 = null;
            goto L10
        }

        public final void q(int r9) {
            v r0 = this.a;
            if (r0.e != r9) goto L5;
            return;
        L5:
            r0.e = r9;
            Iterator r10 = ((CopyOnWriteArrayList) r0.b).iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            ch0.h r1 = (ch0.h) r10.next();
            ch0.h r2 = ch0.h.a(r1, null, false, false, false, this.a.e, 63);
            ((CopyOnWriteArrayList) this.a.b).remove(r1);
            ((CopyOnWriteArrayList) this.a.b).add(r2);
            goto L7
        L9:
            v.e(this.a, true);
        }

        public final void a(boolean r4, ch0.d r5) {
            if (r4 == false) goto L19;
            ch0.g r6 = r5.d;
            int r7 = r6.c;
            boolean r1 = false;
            if (r7 == 2) goto L8;
            if (r7 == 1) goto L8;
            boolean r8 = false;
        L10:
            if (r6.e != 1) goto L12;
            boolean r0 = true;
        L13:
            String r9 = r6.a;
            if (r8 == false) goto L16;
            if (r0 == false) goto L16;
        L17:
            k(r9, r1);
            return;
        L16:
            r1 = true;
            goto L17
        L12:
            r0 = false;
        L8:
            r8 = true;
            goto L10
        }

        public final void c(String r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r11, "interactId");
            gh0.a.b("RtcListener", "call onRemoteVideoMute, interactId: " + r11 + ", isMuteVideo: " + r12, 4);
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L3:
            String r2 = null;
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r1).a, r11) == false) goto L3;
        L9:
            ch0.h r3 = (ch0.h) r1;
            boolean r4 = false;
            if (r3 != null) goto L12;
        L29:
            v.e(this.a, r4);
            return;
        L12:
            if (r3.c == r12) goto L29;
            ch0.e r5 = this.a.a().n1();
            if (r5 == null) goto L20;
            ILinkPlayerInfoBridge r6 = r5.a;
            if (r6 == null) goto L20;
            r2 = r6.getInteractId();
        L20:
            if (Intrinsics.areEqual(r2, r11) == true) goto L22;
        L24:
            boolean r13 = false;
        L25:
            if (r13 == false) goto L27;
            boolean r7 = false;
        L28:
            ch0.h r14 = ch0.h.a(r3, null, r7, false, false, 0, 123);
            ((CopyOnWriteArrayList) this.a.b).remove(r3);
            ((CopyOnWriteArrayList) this.a.b).add(r14);
            r4 = true;
            goto L29
        L27:
            r7 = r12;
            goto L28
        L22:
            if (((IInteractService) jc1.k.n(IInteractService.class)).isLinkCasting() == false) goto L24;
            r13 = true;
            goto L25
        L8:
            r1 = null;
            goto L9
        }

        public final void f(String r10, View r11) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            gh0.a.b("RtcListener", "call onFirstRemoteVideoFrame, interactId: " + r10 + ", view: " + r11, 4);
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r1).a, r10) == false) goto L4;
        L9:
            ch0.h r2 = (ch0.h) r1;
            if (r2 != null) goto L12;
        L15:
            v.e(this.a, true);
            return;
        L12:
            if (r2.b == r11) goto L15;
            ch0.h r12 = ch0.h.a(r2, r11, false, false, false, 0, 121);
            ((CopyOnWriteArrayList) this.a.b).remove(r2);
            ((CopyOnWriteArrayList) this.a.b).add(r12);
            goto L15
        L8:
            r1 = null;
            goto L9
        }

        public final void k(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            gh0.a.b("RtcListener", "call onRemoteAudioMute, interactId: " + r10 + ", isMuteAudio: " + r11, 4);
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r1).a, r10) == false) goto L4;
        L9:
            ch0.h r2 = (ch0.h) r1;
            if (r2 != null) goto L12;
        L15:
            boolean r12 = false;
        L16:
            v.e(this.a, r12);
            return;
        L12:
            if (r2.d == r11) goto L15;
            ch0.h r13 = ch0.h.a(r2, null, false, r11, false, 0, 119);
            ((CopyOnWriteArrayList) this.a.b).remove(r2);
            ((CopyOnWriteArrayList) this.a.b).add(r13);
            r12 = true;
            goto L16
        L8:
            r1 = null;
            goto L9
        }

        public final void onTalkStateUpdated(String[] r13, boolean[] r14) {
            if (r13 == null) goto L36;
            if (r14 != null) goto L5;
            return;
        L5:
            if (r13.length != r14.length) goto L38;
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
            v.e(this.a, r2);
            return;
        L38:
            return;
        }

        public final void r(boolean r4, ch0.d r5) {
            if (r4 == false) goto L21;
            ch0.g r6 = r5.d;
            int r7 = r6.b;
            boolean r1 = false;
            if (r7 != 2) goto L6;
        L10:
            boolean r8 = true;
        L12:
            if (r6.d != 1) goto L14;
            boolean r0 = true;
        L15:
            String r9 = r6.a;
            if (r8 == false) goto L18;
            if (r0 == false) goto L18;
        L19:
            c(r9, r1);
            return;
        L18:
            r1 = true;
            goto L19
        L14:
            r0 = false;
            goto L15
        L6:
            if (r7 == 3) goto L10;
            if (r7 == 1) goto L10;
            r8 = false;
            goto L12
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        eg6.b r0 = this.j;
        if (r0 == null) goto L5;
        r0.s(this.i);
    L5:
        this.g.clear();
        this.h = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        this.d = a().l1();
        eg6.b r0 = this.j;
        if (r0 == null) goto L5;
        r0.h0(this.i);
    L5:
        RxUtilKt.c(a().a1().subscribe(new c(this)), this.g);
        this.h = true;
    }

    public static final /* synthetic */ ch0.d f(v r1) {
        ch0.d r2 = r1.d;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentUserMergeData");
    L5:
        return r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r14) {
        Intrinsics.checkNotNullParameter(r14, "oldMergeDataList");
        if (this.f == false) goto L5;
    L23:
        List<ch0.h> r0 = this.b;
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();
    L25:
        if (r1.hasNext() == false) goto L27;
        Object r4 = r1.next();
        r5.put(((ch0.h) r4).a, r4);
        goto L25
    L27:
        List<ch0.e> r15 = r14;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
        boolean r3 = false;
        ch0.e r6 = null;
    L29:
        if (r16.hasNext() == false) goto L44;
        ch0.e r7 = (ch0.e) r16.next();
        ch0.h r9 = (ch0.h) r5.get(r7.a.getInteractId());
        if (r7.c(r9) == false) goto L33;
        boolean r8 = r3;
        ch0.e r10 = r7;
    L34:
        IBaseUser r11 = r10.a.getUser();
        if (r11 == null) goto L37;
        String r12 = r11.getIdString();
    L39:
        if (Intrinsics.areEqual(r12, gh0.a.c()) == false) goto L42;
        if (r10 == r7) goto L42;
        r6 = r10;
    L42:
        r2.add(r10);
        r3 = r8;
        goto L29
    L37:
        r12 = null;
        goto L39
    L33:
        r10 = ch0.e.a(r7, null, r9, null, null, 13);
        r8 = true;
        goto L34
    L44:
        return new h.a(r3, r2, r6);
    L5:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.n(this.k, null, 2).isAnchor(), Boolean.TRUE) == false) goto L23;
        Iterator<T> r13 = r14.iterator();
    L8:
        if (r13.hasNext() == false) goto L16;
        Object r17 = r13.next();
        IBaseUser r18 = ((ch0.e) r17).a.getUser();
        if (r18 == null) goto L12;
        String r19 = r18.getIdString();
    L14:
        if (Intrinsics.areEqual(r19, gh0.a.c()) == false) goto L8;
    L17:
        ch0.e r20 = (ch0.e) r17;
        if (r20 == null) goto L23;
        String r21 = r20.a.getInteractId();
        if (r21 != null) goto L22;
        r21 = "";
    L22:
        ch0.h r22 = new ch0.h(r21, false, false, 1, 32);
        this.f = true;
        ((CopyOnWriteArrayList) this.b).add(r22);
        gh0.a.b("RtcListener", "initAnchorRtcRemoteUserInfo success", 4);
        goto L23
    L12:
        r19 = null;
        goto L14
    L16:
        r17 = null;
        goto L17
    }

    public static final void e(v r0, boolean r1) {
        if (r1 == false) goto L4;
        r0.c();
        return;
    L4:
        r0.getClass();
    }

    public v(eg6.b r1, DataCenter r2, boolean r3) {
        this.j = r1;
        this.k = r2;
        this.b = new CopyOnWriteArrayList();
        CompositeDisposable r4 = new CompositeDisposable();
        this.g = r4;
        if (r4.isDisposed() == false) goto L5;
        this.g = new CompositeDisposable();
    L5:
        if (r3 == false) goto L15;
        RTSDataContext r5 = RTSDataContext.Companion.getContext();
        if (r5 == null) goto L15;
        com.bytedance.live.datacontext.n<ph0.b> r6 = r5.getLinkTypeEvent();
        if (r6 == null) goto L15;
        Observable r7 = r6.a();
        if (r7 == null) goto L15;
        Disposable r8 = r7.subscribe(new a(this));
        if (r8 == null) goto L15;
        RxUtilKt.c(r8, this.g);
    L15:
        this.i = new d(this);
    }

    public static final void d(v r0, boolean r1, ch0.d r2) {
        if (r1 == false) goto L4;
        r0.a().z0(r2);
        return;
    L4:
        r0.getClass();
    }
}
