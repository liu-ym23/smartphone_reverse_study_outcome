package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSDataContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public final List<ch0.h> b;
    public ch0.g c;
    public ch0.d d;
    public int e;
    public final Map<String, Boolean> f;
    public final Map<String, Long> g;
    public boolean h;
    public final CompositeDisposable i;
    public boolean j;
    public final c k;
    public eg6.b l;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d m;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ o a;

        public a(o r1) {
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
            c r8 = this.a.k;
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

    public static final class c extends eg6.a {
        public final /* synthetic */ o a;

        public final void o() {
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onLocalUserLeaved", false, 24);
        L5:
            ch0.d r0 = o.f(this.a);
            boolean r2 = false;
            if (r0 == null) goto L8;
            o r3 = this.a;
            r3.getClass();
            r3.c = new ch0.g("", 0, 0, 0, 0);
            ch0.g r4 = this.a.c;
            Intrinsics.checkNotNull(r4);
            r0 = ch0.d.a(r0, 0, 0, r4, 7);
            r2 = true;
        L8:
            o.d(this.a, r2, r0);
            o r5 = this.a;
            if ((!((CopyOnWriteArrayList) r5.b).isEmpty()) == false) goto L15;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r6 = r5.m;
            if (r6 == null) goto L13;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r6, "RtcListener", r5.hashCode(), "clear", false, 24);
        L13:
            ((CopyOnWriteArrayList) r5.b).clear();
            r5.c();
            ((LinkedHashMap) r5.f).clear();
            ((LinkedHashMap) r5.g).clear();
            r5.g(true);
            return;
        }

        public c(o r1) {
            this.a = r1;
        }

        public final void b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onFirstRemoteVideoFrame, interactId: " + r10, false, 24);
        L5:
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            Object r2 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r2).a, r10) == false) goto L7;
        L12:
            ch0.h r3 = (ch0.h) r2;
            if (r3 != null) goto L15;
        L18:
            boolean r11 = false;
        L19:
            o.e(this.a, r11);
            return;
        L15:
            if (r3.c == false) goto L18;
            ch0.h r12 = ch0.h.a(r3, null, false, false, false, 0, 123);
            ((CopyOnWriteArrayList) this.a.b).remove(r3);
            ((CopyOnWriteArrayList) this.a.b).add(r12);
            r11 = true;
            goto L19
        L11:
            r2 = null;
            goto L12
        }

        public final void d(int r8) {
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onLocalUserVideoCaptureStateChanged, status: " + r8, false, 24);
        L5:
            ch0.d r0 = o.f(this.a);
            boolean r2 = false;
            if (r0 == null) goto L13;
            ch0.g r3 = this.a.c;
            if (r3 == null) goto L13;
            if (r3.b == r8) goto L13;
            r3.b = r8;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
            r2 = true;
        L13:
            o.d(this.a, r2, r0);
            r(r2, r0);
        }

        public final void i(String r10) {
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onLocalUserJoined", false, 24);
        L5:
            ch0.d r0 = o.f(this.a);
            boolean r2 = false;
            if (r0 == null) goto L11;
            if (r10 == null) goto L11;
            if (TextUtils.equals(r10, o.f(this.a).d.a) == true) goto L11;
            ch0.g r3 = new ch0.g(r10, 0, 0, 1, 1);
            this.a.c = r3;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
            r2 = true;
        L11:
            o.d(this.a, r2, r0);
            if (r10 == null) goto L15;
            p(r10);
            b(r10);
            return;
        }

        public final void j(int r8) {
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onLocalUserVideoPublishStateChanged videoPublishStatus = " + r8, false, 24);
        L5:
            ch0.d r0 = o.f(this.a);
            boolean r2 = false;
            if (r0 == null) goto L13;
            ch0.g r3 = this.a.c;
            if (r3 == null) goto L13;
            if (r3.d == r8) goto L13;
            r3.d = r8;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
            r2 = true;
        L13:
            o.d(this.a, r2, r0);
            r(r2, r0);
        }

        public final void l(String r8) {
            Intrinsics.checkNotNullParameter(r8, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onRemoteUserLeaved, interactId: ".concat(r8), false, 24);
        L5:
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            Object r2 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r2).a, r8) == false) goto L7;
        L12:
            ch0.h r3 = (ch0.h) r2;
            if (r3 == null) goto L15;
            ((CopyOnWriteArrayList) this.a.b).remove(r3);
            this.a.f.remove(r8);
            Long r9 = this.a.g.remove(r8);
            boolean r10 = true;
        L16:
            o.e(this.a, r10);
            this.a.g(r10);
            return;
        L15:
            r10 = false;
            goto L16
        L11:
            r2 = null;
            goto L12
        }

        public final void m(int r8) {
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onLocalUserAudioCaptureStateChanged, status: " + r8, false, 24);
        L5:
            ch0.d r0 = o.f(this.a);
            boolean r2 = false;
            if (r0 == null) goto L13;
            ch0.g r3 = this.a.c;
            if (r3 == null) goto L13;
            if (r3.c == r8) goto L13;
            r3.c = r8;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
            r2 = true;
        L13:
            o.d(this.a, r2, r0);
            a(r2, r0);
        }

        public final void n(int r8) {
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onLocalUserAudioPublishStateChanged", false, 24);
        L5:
            ch0.d r0 = o.f(this.a);
            boolean r2 = false;
            if (r0 == null) goto L13;
            ch0.g r3 = this.a.c;
            if (r3 == null) goto L13;
            if (r3.e == r8) goto L13;
            r3.e = r8;
            Intrinsics.checkNotNull(r3);
            r0 = ch0.d.a(r0, 0, 0, r3, 7);
            r2 = true;
        L13:
            o.d(this.a, r2, r0);
            a(r2, r0);
        }

        public final void p(String r9) {
            Intrinsics.checkNotNullParameter(r9, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onRemoteUserJoined, interactId: " + r9, false, 24);
        L5:
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            Object r2 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r2).a, r9) == false) goto L7;
        L13:
            if (((ch0.h) r2) != null) goto L15;
            ((CopyOnWriteArrayList) this.a.b).add(new ch0.h(r9, true, true, this.a.e, 32));
            this.a.f.put(r9, Boolean.FALSE);
            boolean r10 = true;
        L16:
            o.e(this.a, r10);
            return;
        L15:
            r10 = false;
            goto L16
        L11:
            r2 = null;
            goto L13
        }

        public final void q(int r9) {
            o r0 = this.a;
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
            o.e(this.a, true);
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
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onRemoteVideoMute, interactId: " + r11 + ", isMuteVideo: " + r12, false, 24);
        L5:
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L6:
            String r2 = null;
            if (r0.hasNext() == false) goto L11;
            Object r3 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r3).a, r11) == false) goto L6;
        L12:
            ch0.h r4 = (ch0.h) r3;
            boolean r5 = false;
            if (r4 != null) goto L15;
        L32:
            o.e(this.a, r5);
            return;
        L15:
            if (r4.c == r12) goto L32;
            ch0.e r6 = this.a.a().n1();
            if (r6 == null) goto L23;
            ILinkPlayerInfoBridge r7 = r6.a;
            if (r7 == null) goto L23;
            r2 = r7.getInteractId();
        L23:
            if (Intrinsics.areEqual(r2, r11) == true) goto L25;
        L27:
            boolean r13 = false;
        L28:
            if (r13 == false) goto L30;
            boolean r8 = false;
        L31:
            ch0.h r14 = ch0.h.a(r4, null, r8, false, false, 0, 123);
            ((CopyOnWriteArrayList) this.a.b).remove(r4);
            ((CopyOnWriteArrayList) this.a.b).add(r14);
            r5 = true;
            goto L32
        L30:
            r8 = r12;
            goto L31
        L25:
            if (((IInteractService) jc1.k.n(IInteractService.class)).isLinkCasting() == false) goto L27;
            r13 = true;
            goto L28
        L11:
            r3 = null;
            goto L12
        }

        public final void f(String r10, View r11) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onFirstRemoteVideoFrame, interactId: " + r10 + ", view: " + r11, false, 24);
        L5:
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            Object r2 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r2).a, r10) == false) goto L7;
        L12:
            ch0.h r3 = (ch0.h) r2;
            if (r3 != null) goto L15;
        L18:
            o.e(this.a, true);
            return;
        L15:
            if (r3.b == r11) goto L18;
            ch0.h r12 = ch0.h.a(r3, r11, false, false, false, 0, 121);
            ((CopyOnWriteArrayList) this.a.b).remove(r3);
            ((CopyOnWriteArrayList) this.a.b).add(r12);
            goto L18
        L11:
            r2 = null;
            goto L12
        }

        public final void k(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.m;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RtcListener", hashCode(), "call onRemoteAudioMute, interactId: " + r10 + ", isMuteAudio: " + r11, false, 24);
        L5:
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            Object r2 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r2).a, r10) == false) goto L7;
        L12:
            ch0.h r3 = (ch0.h) r2;
            if (r3 != null) goto L15;
        L18:
            boolean r12 = false;
        L19:
            o.e(this.a, r12);
            return;
        L15:
            if (r3.d == r11) goto L18;
            ch0.h r13 = ch0.h.a(r3, null, false, r11, false, 0, 119);
            ((CopyOnWriteArrayList) this.a.b).remove(r3);
            ((CopyOnWriteArrayList) this.a.b).add(r13);
            r12 = true;
            goto L19
        L11:
            r2 = null;
            goto L12
        }

        public final void onTalkStateUpdated(String[] r8, boolean[] r9) {
            if (r8 == null) goto L22;
            if (r9 != null) goto L5;
            return;
        L5:
            if (r8.length != r9.length) goto L24;
            int r0 = r8.length;
            int r1 = 0;
            boolean r2 = false;
        L8:
            if (r1 >= r0) goto L17;
            String r3 = r8[r1];
            boolean r4 = r9[r1];
            if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.a.f).get(r3), Boolean.valueOf(r4))) == false) goto L16;
            this.a.f.put(r3, Boolean.valueOf(r4));
            if (r4 == false) goto L14;
            this.a.g.put(r3, Long.valueOf(System.currentTimeMillis()));
        L15:
            r2 = true;
            goto L16
        L14:
            this.a.g.put(r3, 0L);
        L16:
            r1 = r1 + 1;
            goto L8
        L17:
            this.a.g(r2);
            return;
        L24:
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
        eg6.b r0 = this.l;
        if (r0 == null) goto L5;
        r0.s(this.k);
    L5:
        this.i.clear();
        this.j = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        this.d = a().l1();
        eg6.b r0 = this.l;
        if (r0 == null) goto L5;
        r0.h0(this.k);
    L5:
        this.j = true;
    }

    public static final /* synthetic */ ch0.d f(o r1) {
        ch0.d r2 = r1.d;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentUserMergeData");
    L5:
        return r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a b(List<ch0.e> r14) {
        Intrinsics.checkNotNullParameter(r14, "oldMergeDataList");
        if (this.h == false) goto L5;
    L25:
        List<ch0.h> r0 = this.b;
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();
    L27:
        if (r1.hasNext() == false) goto L29;
        Object r4 = r1.next();
        r5.put(((ch0.h) r4).a, r4);
        goto L27
    L29:
        List<ch0.e> r15 = r14;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
        boolean r3 = false;
        ch0.e r6 = null;
    L31:
        if (r16.hasNext() == false) goto L46;
        ch0.e r7 = (ch0.e) r16.next();
        ch0.h r9 = (ch0.h) r5.get(r7.a.getInteractId());
        if (r7.c(r9) == false) goto L35;
        boolean r8 = r3;
        ch0.e r10 = r7;
    L36:
        IBaseUser r11 = r10.a.getUser();
        if (r11 == null) goto L39;
        String r12 = r11.getIdString();
    L41:
        if (Intrinsics.areEqual(r12, gh0.a.c()) == false) goto L44;
        if (r10 == r7) goto L44;
        r6 = r10;
    L44:
        r2.add(r10);
        r3 = r8;
        goto L31
    L39:
        r12 = null;
        goto L41
    L35:
        r10 = ch0.e.a(r7, null, r9, null, null, 13);
        r8 = true;
        goto L36
    L46:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r3, r2, r6);
    L5:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L25;
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
        if (r20 == null) goto L25;
        String r21 = r20.a.getInteractId();
        if (r21 != null) goto L22;
        r21 = "";
    L22:
        ch0.h r22 = new ch0.h(r21, false, false, 1, 32);
        this.h = true;
        ((CopyOnWriteArrayList) this.b).add(r22);
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r23 = this.m;
        if (r23 == null) goto L25;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r23, "RtcListener", hashCode(), "initAnchorRtcRemoteUserInfo success", false, 24);
        goto L25
    L12:
        r19 = null;
        goto L14
    L16:
        r17 = null;
        goto L17
    }

    public final void g(boolean r2) {
        if (r2 == false) goto L5;
        a().J0(this.f);
        a().U0(this.g);
        ALogger.d("hjl-test", "updateRtcTalkingStatus");
        return;
    }

    public o(eg6.b r1, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r2) {
        this.l = r1;
        this.m = r2;
        this.b = new CopyOnWriteArrayList();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        CompositeDisposable r3 = new CompositeDisposable();
        this.i = r3;
        if (r3.isDisposed() == false) goto L5;
        this.i = new CompositeDisposable();
    L5:
        RTSDataContext r4 = RTSDataContext.Companion.getContext();
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.n<ph0.b> r5 = r4.getLinkTypeEvent();
        if (r5 == null) goto L14;
        Observable r6 = r5.a();
        if (r6 == null) goto L14;
        Disposable r7 = r6.subscribe(new a(this));
        if (r7 == null) goto L14;
        RxUtilKt.c(r7, this.i);
    L14:
        this.k = new c(this);
    }

    public static final void e(o r0, boolean r1) {
        if (r1 == false) goto L4;
        r0.c();
        return;
    L4:
        r0.getClass();
    }

    public static final void d(o r0, boolean r1, ch0.d r2) {
        if (r1 == false) goto L4;
        r0.a().z0(r2);
        return;
    L4:
        r0.getClass();
    }
}
