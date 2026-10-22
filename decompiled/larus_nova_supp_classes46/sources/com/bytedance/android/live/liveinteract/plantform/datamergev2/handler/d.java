package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedDataMessageSourceType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.Gson;
import io.reactivex.disposables.CompositeDisposable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sh0.h0;
import sh0.i0;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends eh0.a {
    public final List<ch0.h> b;
    public final List<ch0.h> c;
    public int d;
    public final Map<String, Boolean> e;
    public final Map<String, Long> f;
    public final Map<String, Boolean> g;
    public final Map<String, Long> h;
    public final CompositeDisposable i;
    public boolean j;
    public final b k;
    public final DataCenter l;
    public eg6.b m;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d n;

    public static final class a {
    }

    public static final class b extends eg6.a {
        public final /* synthetic */ d a;

        public final void d(int r1) {
        }

        public final void i(String r1) {
        }

        public final void j(int r1) {
        }

        public final void m(int r1) {
        }

        public final void n(int r1) {
        }

        public final void o() {
            d r0 = this.a;
            if ((!((CopyOnWriteArrayList) r0.b).isEmpty()) == false) goto L9;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r3 = r0.n;
            if (r3 == null) goto L7;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r3, "RemoteRtcHandlerV2", r0.hashCode(), "clear", false, 24);
        L7:
            ((CopyOnWriteArrayList) r0.b).clear();
            ((LinkedHashMap) r0.e).clear();
            ((LinkedHashMap) r0.f).clear();
            ((LinkedHashMap) r0.g).clear();
            ((LinkedHashMap) r0.h).clear();
            r0.f(true);
            r0.c();
            return;
        }

        public b(d r1) {
            this.a = r1;
        }

        public final void b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.n;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerV2", hashCode(), "call onFirstRemoteVideoFrame, interactId: ".concat(r10), false, 24);
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
            this.a.g(r11);
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

        public final void l(String r8) {
            Intrinsics.checkNotNullParameter(r8, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.n;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerV2", hashCode(), "call onRemoteUserLeaved, interactId: ".concat(r8), false, 24);
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
            this.a.e.remove(r8);
            this.a.f.remove(r8);
            this.a.g.remove(r8);
            Long r9 = this.a.h.remove(r8);
            boolean r10 = true;
        L16:
            this.a.g(r10);
            this.a.f(r10);
            return;
        L15:
            r10 = false;
            goto L16
        L11:
            r2 = null;
            goto L12
        }

        public final void p(String r9) {
            Intrinsics.checkNotNullParameter(r9, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.n;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerV2", hashCode(), "call onRemoteUserJoined, interactId: ".concat(r9), false, 24);
        L5:
            Iterator r0 = ((CopyOnWriteArrayList) this.a.b).iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            Object r2 = r0.next();
            if (Intrinsics.areEqual(((ch0.h) r2).a, r9) == false) goto L7;
        L13:
            if (((ch0.h) r2) != null) goto L15;
            ch0.h r3 = new ch0.h(r9, true, true, this.a.d, 32);
            ((CopyOnWriteArrayList) this.a.b).add(r3);
            boolean r10 = true;
        L16:
            this.a.g(r10);
            return;
        L15:
            r10 = false;
            goto L16
        L11:
            r2 = null;
            goto L13
        }

        public final void q(int r9) {
            d r0 = this.a;
            if (r0.d != r9) goto L5;
            return;
        L5:
            r0.d = r9;
            Iterator r10 = ((CopyOnWriteArrayList) r0.b).iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            ch0.h r1 = (ch0.h) r10.next();
            ch0.h r2 = ch0.h.a(r1, null, false, false, false, this.a.d, 63);
            ((CopyOnWriteArrayList) this.a.b).remove(r1);
            ((CopyOnWriteArrayList) this.a.b).add(r2);
            goto L7
        L9:
            this.a.g(true);
        }

        public final void c(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.n;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerV2", hashCode(), "call onRemoteVideoMute, interactId: " + r10 + ", isMuteVideo: " + r11, false, 24);
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
            this.a.g(r12);
            return;
        L15:
            if (r3.c == r11) goto L18;
            ch0.h r13 = ch0.h.a(r3, null, r11, false, false, 0, 123);
            ((CopyOnWriteArrayList) this.a.b).remove(r3);
            ((CopyOnWriteArrayList) this.a.b).add(r13);
            r12 = true;
            goto L19
        L11:
            r2 = null;
            goto L12
        }

        public final void f(String r10, View r11) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.n;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerV2", hashCode(), "call onFirstRemoteVideoFrame, interactId: " + r10 + ", view: " + r11, false, 24);
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
            this.a.g(r12);
            return;
        L15:
            if (r3.b == r11) goto L18;
            ch0.h r13 = ch0.h.a(r3, r11, false, false, false, 0, 125);
            ((CopyOnWriteArrayList) this.a.b).remove(r3);
            ((CopyOnWriteArrayList) this.a.b).add(r13);
            r12 = true;
            goto L19
        L11:
            r2 = null;
            goto L12
        }

        public final void g(ByteBuffer r3, int r4) {
            if (r4 != LiveWrappedDataMessageSourceType.DATA_MESSAGE_SOURCE_TYPE_SYSTEM.value()) goto L43;
            if (r3 == null) goto L44;
            int r5 = ee0.a.a;
            String r6 = ee0.a.C0203a.a(r3);
            if (r6 == null) goto L45;
        L39:
            e = move-exception;
            ALogger.e(LinkRoomFightContext.TAG, "onPublicStreamSEIMessageReceived error " + e);
            return;
        L8:
            if (r6.length() != 0) goto L10;
            boolean r7 = true;
        L11:
            if (r7 == true) goto L46;
            LiveSeiUtil.i.getClass();     // Catch: Exception -> L39
            if (LiveSeiUtil.e(r6) == false) goto L47;
            Gson r8 = com.bytedance.android.annie.api.data.subscribe.d.a;     // Catch: Exception -> L39
            com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.b r9 = (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.b) com.bytedance.android.annie.api.data.subscribe.d.a(r6, com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.b.class);     // Catch: Exception -> L39
            Objects.toString(r9);     // Catch: Exception -> L39
            String r10 = r9.getType();     // Catch: Exception -> L39
            if (r10 == null) goto L48;
            int r0 = r10.hashCode();     // Catch: Exception -> L39
            if (r0 != (-860629884)) goto L21;
            r10.equals("UserCaptureStats");     // Catch: Exception -> L39
            return;
        L21:
            if (r0 == (-341104496)) goto L32;
            if (r0 == 772629099) goto L26;
            return;
        L26:
            if (r10.equals("VolumeInfos") == false) goto L50;
            d r11 = this.a;     // Catch: Exception -> L39
            List<com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.d> r12 = r9.b();     // Catch: Exception -> L39
            if (r12 != null) goto L30;
            r12 = CollectionsKt.emptyList();     // Catch: Exception -> L39
        L30:
            d.e(r11, r12);     // Catch: Exception -> L39
            return;
        L50:
            return;
        L32:
            if (r10.equals("StreamPublishStats") == false) goto L52;
            d r13 = this.a;     // Catch: Exception -> L39
            List<com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.c> r14 = r9.a();     // Catch: Exception -> L39
            if (r14 != null) goto L36;
            r14 = CollectionsKt.emptyList();     // Catch: Exception -> L39
        L36:
            d.d(r13, r14);     // Catch: Exception -> L39
            return;
        L52:
            return;
        L48:
            return;
        L47:
            return;
        L46:
            return;
        L10:
            r7 = false;
            goto L11
        L45:
            return;
        L44:
            return;
        }

        public final void k(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "interactId");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.n;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteRtcHandlerV2", hashCode(), "call onRemoteAudioMute, interactId: " + r10 + ", isMuteAudio: " + r11, false, 24);
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
            this.a.g(r12);
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
            if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.a.e).get(r3), Boolean.valueOf(r4))) == false) goto L16;
            this.a.e.put(r3, Boolean.valueOf(r4));
            if (r4 == false) goto L14;
            this.a.f.put(r3, Long.valueOf(System.currentTimeMillis()));
        L15:
            r2 = true;
            goto L16
        L14:
            this.a.f.put(r3, 0L);
        L16:
            r1 = r1 + 1;
            goto L8
        L17:
            this.a.f(r2);
            return;
        L24:
            return;
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        eg6.b r0 = this.m;
        if (r0 == null) goto L5;
        r0.h0(this.k);
    L5:
        this.j = true;
    }

    @Override // eh0.c
    public final void detach() {
        eg6.b r0 = this.m;
        if (r0 == null) goto L5;
        r0.s(this.k);
    L5:
        this.i.clear();
        this.j = false;
    }

    @Override // eh0.a, eh0.c
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a a(List<ch0.e> r14) {
        Intrinsics.checkNotNullParameter(r14, "oldMergeDataList");
        i0 r0 = j0.a;
        DataCenter r1 = this.l;
        int r2 = h0.a;
        Boolean r3 = (Boolean) j0.d(r1, "is_public_stream_pulling");
        ALogger.w("RemoteRtcHandlerV2", "updateRemoteLinkUserMergeData isPullingPublicStream " + r3);
        boolean r4 = false;
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L26;
        List<ch0.h> r5 = this.c;
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16));
        Iterator r7 = ((CopyOnWriteArrayList) r5).iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Object r8 = r7.next();
        r6.put(((ch0.h) r8).a, r8);
        goto L6
    L8:
        List<ch0.e> r15 = r14;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
        ch0.e r10 = null;
    L10:
        if (r16.hasNext() == false) goto L25;
        ch0.e r11 = (ch0.e) r16.next();
        ch0.h r12 = (ch0.h) r6.get(r11.a.getInteractId());
        if (r11.c(r12) == false) goto L14;
        boolean r13 = r4;
        ch0.e r17 = r11;
    L15:
        IBaseUser r18 = r17.a.getUser();
        if (r18 == null) goto L18;
        String r19 = r18.getIdString();
    L20:
        if (Intrinsics.areEqual(r19, gh0.a.c()) == false) goto L23;
        if (r17 == r11) goto L23;
        r10 = r17;
    L23:
        r9.add(r17);
        r4 = r13;
        goto L10
    L18:
        r19 = null;
        goto L20
    L14:
        r17 = ch0.e.a(r11, null, r12, null, null, 13);
        r13 = true;
        goto L15
    L25:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r4, r9, r10);
    L26:
        List<ch0.h> r20 = this.b;
        LinkedHashMap r21 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r20, 10)), 16));
        Iterator r22 = ((CopyOnWriteArrayList) r20).iterator();
    L28:
        if (r22.hasNext() == false) goto L30;
        Object r23 = r22.next();
        r21.put(((ch0.h) r23).a, r23);
        goto L28
    L30:
        List<ch0.e> r110 = r14;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r111 = r110.iterator();
        ch0.e r25 = null;
    L32:
        if (r111.hasNext() == false) goto L47;
        ch0.e r26 = (ch0.e) r111.next();
        ch0.h r27 = (ch0.h) r21.get(r26.a.getInteractId());
        if (r26.c(r27) == false) goto L36;
        boolean r28 = r4;
        ch0.e r29 = r26;
    L37:
        IBaseUser r30 = r29.a.getUser();
        if (r30 == null) goto L40;
        String r31 = r30.getIdString();
    L42:
        if (Intrinsics.areEqual(r31, gh0.a.c()) == false) goto L45;
        if (r29 == r26) goto L45;
        r25 = r29;
    L45:
        r24.add(r29);
        r4 = r28;
        goto L32
    L40:
        r31 = null;
        goto L42
    L36:
        r29 = ch0.e.a(r26, null, r27, null, null, 13);
        r28 = true;
        goto L37
    L47:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r4, r24, r25);
    }

    public final void f(boolean r3) {
        if (r3 == false) goto L5;
        eh0.b r4 = b();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.e);
        r0.putAll(this.g);
        r4.n(r0);
        eh0.b r5 = b();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(this.f);
        r1.putAll(this.h);
        r5.p(r1);
        return;
    }

    public final void g(boolean r1) {
        if (r1 == false) goto L5;
        c();
        return;
    }

    public static final void d(d r14, List r15) {
        r14.getClass();
        ArrayList r0 = new ArrayList();
        Iterator r16 = r15.iterator();
        boolean r2 = false;
    L4:
        if (r16.hasNext() == false) goto L37;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.c r3 = (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.c) r16.next();
        String r4 = r3.b();
        if (r3.c() != 0) goto L8;
        boolean r9 = true;
    L10:
        if (r3.a() != 0) goto L12;
        boolean r10 = true;
    L13:
        Iterator r5 = ((CopyOnWriteArrayList) r14.c).iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((ch0.h) r6).a, r4) == false) goto L15;
    L20:
        ch0.h r7 = (ch0.h) r6;
        if (r7 != null) goto L27;
        if (r4 != null) goto L25;
        r4 = "";
    L25:
        r0.add(new ch0.h(r4, r9, r10, r14.d, 32));
    L32:
        r2 = true;
    L34:
        if (r0.size() == ((CopyOnWriteArrayList) r14.c).size()) goto L36;
        r2 = true;
    L36:
        ((CopyOnWriteArrayList) r14.c).clear();
        ((CopyOnWriteArrayList) r14.c).addAll(r0);
        r14.g(r2);
        goto L4
    L27:
        if (r7.c == r9) goto L29;
    L31:
        r0.add(ch0.h.a(r7, null, r9, r10, false, 0, 115));
        goto L32
    L29:
        if (r7.d != r10) goto L31;
        r0.add(r7);
        goto L34
    L19:
        r6 = null;
        goto L20
    L12:
        r10 = false;
        goto L13
    L8:
        r9 = false;
        goto L10
    }

    public static final void e(d r8, List r9) {
        r8.getClass();
        Iterator r10 = r9.iterator();
        boolean r1 = false;
    L4:
        if (r10.hasNext() == false) goto L19;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.d r2 = (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.d) r10.next();
        String r3 = r2.b();
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r2.a() < 30) goto L11;
        boolean r4 = true;
    L13:
        if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) r8.g).get(r3), Boolean.valueOf(r4))) == false) goto L4;
        r8.g.put(r3, Boolean.valueOf(r4));
        if (r4 == false) goto L17;
        r8.h.put(r3, Long.valueOf(System.currentTimeMillis()));
    L18:
        r1 = true;
        goto L4
    L17:
        r8.h.put(r3, 0L);
        goto L18
    L11:
        r4 = false;
        goto L13
    L19:
        r8.f(r1);
    }

    public d(DataCenter r1, eg6.b r2, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r3) {
        this.l = r1;
        this.m = r2;
        this.n = r3;
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new CompositeDisposable();
        this.k = new b(this);
    }
}
