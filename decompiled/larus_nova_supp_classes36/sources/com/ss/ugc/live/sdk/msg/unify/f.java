package com.ss.ugc.live.sdk.msg.unify;

import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWConnectionInfo;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWDownlinkPacket;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventType;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchRequest;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchResponse;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWUplinkPacket;
import com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;
import vlc.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements com.ss.ugc.live.sdk.msg.utils.d, com.ss.ugc.live.sdk.msg.utils.i.a {
    public final com.ss.ugc.live.sdk.msg.unify.network.a a;
    public final com.ss.ugc.live.sdk.msg.utils.i b;
    public final com.ss.ugc.live.sdk.msg.utils.i c;
    public long d;
    public long e;
    public String f;
    public volatile boolean g;
    public int h;
    public long i;
    public final com.ss.ugc.live.sdk.msg.utils.j j;
    public final l k;
    public final com.ss.ugc.live.sdk.msg.unify.b l;
    public final com.ss.ugc.live.sdk.msg.utils.task.c m;
    public final kmc.d n;
    public final gmc.a o;
    public final UnifyWSState p;

    public static final class a {
    }

    public final class b implements com.ss.ugc.live.sdk.msg.unify.network.d {
        public final /* synthetic */ f a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r0 = ((ArrayList) this.a.a.l.b()).iterator();     // Catch: Throwable -> L9
            L4:
                if (r0.hasNext() == false) goto L21;
                n r1 = ((com.ss.ugc.live.sdk.msg.unify.c) r0.next()).b;     // Catch: Throwable -> L9
                if (r1 == null) goto L4;
                r1.a();     // Catch: Throwable -> L9
                goto L4
            L21:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L13;
                return;
            L13:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.f$b$b, reason: collision with other inner class name */
        public static final class RunnableC0223b implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ String b;

            public RunnableC0223b(b r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r0 = ((ArrayList) this.a.a.l.b()).iterator();     // Catch: Throwable -> L9
            L4:
                if (r0.hasNext() == false) goto L21;
                n r1 = ((com.ss.ugc.live.sdk.msg.unify.c) r0.next()).b;     // Catch: Throwable -> L9
                if (r1 == null) goto L4;
                r1.b(this.b);     // Catch: Throwable -> L9
                goto L4
            L21:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L13;
                return;
            L13:
                throw th;
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ tlc.f b;

            public c(b r1, tlc.f r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r0 = ((ArrayList) this.a.a.l.b()).iterator();     // Catch: Throwable -> L9
            L4:
                if (r0.hasNext() == false) goto L21;
                n r1 = ((com.ss.ugc.live.sdk.msg.unify.c) r0.next()).b;     // Catch: Throwable -> L9
                if (r1 == null) goto L4;
                r1.d(this.b);     // Catch: Throwable -> L9
                goto L4
            L21:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L13;
                return;
            L13:
                throw th;
            }
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.network.d
        public final void a() {
            com.ss.ugc.live.sdk.msg.utils.a.c(this.a.n, "on ws connected");
            if (this.a.l.d() == true) goto L5;
            this.a.b.removeMessages(103);
        L5:
            this.a.c();
            this.a.h();
            this.a.k();
            MainTaskScheduler.a(new a(this));
        }

        public b(f r1) {
            this.a = r1;
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.network.d
        public final void b(String r4) {
            Intrinsics.checkNotNullParameter(r4, "reason");
            com.ss.ugc.live.sdk.msg.utils.a.c(this.a.n, "on ws disconnected, reason: " + r4);
            Iterator<Map.Entry<Long, com.ss.ugc.live.sdk.msg.unify.c>> r0 = this.a.l.a.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().getValue().c.d(com.ss.ugc.live.sdk.msg.unify.c.a.C0218a.a);
            goto L4
        L6:
            this.a.k.a.clear();
            f r1 = this.a;
            if (r1.b.hasMessages(107) == false) goto L9;
            r1.b.removeMessages(107);
        L9:
            this.a.c();
            f r2 = this.a;
            r2.g(r2.a());
            MainTaskScheduler.a(new RunnableC0223b(this, r4));
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.network.d
        public final void d(tlc.f r4) {
            Intrinsics.checkNotNullParameter(r4, "payloadItem");
            MainTaskScheduler.a(new c(this, r4));
            if (Intrinsics.areEqual(r4.c, PayloadItemType.PAYLOAD_TYPE_UMGW.getType()) == false) goto L7;
            Message r5 = this.a.b.obtainMessage(106, r4);
            if (r5 == null) goto L9;
            r5.sendToTarget();
            return;
        L9:
            return;
        L7:
            com.ss.ugc.live.sdk.msg.utils.a.c(this.a.n, "drop ws message due to payload type: " + r4.c);
        }
    }

    static {
    }

    public final long a() {
        long r0 = this.d;
        if (r0 > 0) goto L7;
        r0 = 1000;
    L7:
        if (this.i > 0) goto L9;
        return 0;
    L9:
        return Math.min(r0, Math.max(0, System.currentTimeMillis() - this.i));
    }

    public final void c() {
        if (this.b.hasMessages(108) == false) goto L6;
        this.b.removeMessages(108);
        return;
    }

    public final Map<String, String> f() {
        HashMap r0 = new HashMap();
        r0.put("resp_content_type", "protobuf");
        if (this.f.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0.put("umgw_global_ext", this.f);
    L8:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final void h() {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "trigger heartbeat timer");
        if (this.b.hasMessages(107) == false) goto L5;
        this.b.removeMessages(107);
    L5:
        Message r0 = this.b.obtainMessage(107);
        this.b.sendMessageDelayed(r0, this.e * 1000);
    }

    public final void k() {
        if (this.b.hasMessages(110) == false) goto L5;
        this.b.removeMessages(110);
    L5:
        this.b.sendEmptyMessage(110);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(com.ss.ugc.live.sdk.msg.utils.k r15) {
        Intrinsics.checkNotNullParameter(r15, "whatResult");
        mmc.c r0 = r15.a;
        if ((r0 instanceof jmc.a) == false) goto L49;
        k();
        jmc.a r1 = (jmc.a) r15.a;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r16 = r15.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r16, "result");
        if ((r16 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L40;
        hmc.a r17 = (hmc.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r16).b;
        this.g = false;
        this.h = 0;
        UMGWFetchResponse r2 = r17.b;
        UMGWConnectionInfo r4 = r2.connection_info;
        long r7 = 1000;
        if (r4 == null) goto L11;
        Long r9 = r4.fetch_interval;
        if (r9 == null) goto L11;
        long r10 = r9.longValue();
    L12:
        this.d = r10;
        UMGWConnectionInfo r11 = r2.connection_info;
        if (r11 == null) goto L17;
        Long r12 = r11.heartbeat_duration;
        if (r12 == null) goto L17;
        long r13 = r12.longValue();
    L18:
        this.e = Math.max(r13 / ((long) AudioViewModel.ASR_SESSION_IDLE), 10);
        String r3 = r2.umgw_global_ext;
        if (r3 == null) goto L22;
        this.f = r3;
    L22:
        if (Intrinsics.areEqual(this.p.d.b(), UnifyWSState.c.b.a) == false) goto L24;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "onUnifyHttpFetchSuccess, ws is connecting, umgw_global_ext: " + this.f + ", logId: " + com.ss.ugc.live.sdk.msg.utils.c.c(r17.a));
        e(r17.c, false);
        j(Conf$StickerSetManagerPosition.STICKER_SET_SHOP);
        return;
    L24:
        if (r4 == null) goto L35;
        Integer r5 = r4.fetch_type;
        if (r5 == null) goto L35;
        if (r5.intValue() != 1) goto L35;
        if (TextUtils.isEmpty(r4.wss_url) == true) goto L35;
        if (this.p.e() == true) goto L35;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "onUnifyHttpFetchSuccess, use ws, umgw_global_ext: " + this.f + ", logId: " + com.ss.ugc.live.sdk.msg.utils.c.c(r17.a));
        e(r17.c, false);
        this.b.obtainMessage(104, r2).sendToTarget();
        return;
    L35:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "onUnifyHttpFetchSuccess, use http, redetermine, umgw_global_ext: " + this.f + ", logId: " + com.ss.ugc.live.sdk.msg.utils.c.c(r17.a));
        e(r17.c, false);
        long r6 = this.d;
        if (r6 <= 0) goto L38;
        r7 = r6;
    L38:
        g(r7);
        return;
    L17:
        r13 = 0;
    L11:
        r10 = 1000;
        goto L12
    L40:
        if ((r16 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L47;
        E r18 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r16).b;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "onUnifyHttpFetchError: " + r18.getMessage());
        this.g = false;
        int r19 = this.h + 1;
        this.h = r19;
        if (r19 <= 3) goto L44;
        long r8 = 5000;
    L45:
        g(r8);
        return;
    L44:
        r8 = AudioViewModel.ASR_SESSION_IDLE * ((long) r19);
        goto L45
    L47:
        throw new NoWhenBranchMatchedException();
    L49:
        if ((r0 instanceof jmc.d) == false) goto L133;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r110 = r15.b;
        ((jmc.d) r0).getClass();
        Intrinsics.checkNotNullParameter(r110, "result");
        if ((r110 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L121;
        hmc.b r111 = (hmc.b) ((com.ss.ugc.live.sdk.msg.utils.g.c) r110).b;
        tlc.f r14 = r111.a;
        int r20 = com.ss.ugc.live.sdk.msg.utils.c.a;
        Long r21 = null;
        if (r14 == null) goto L66;
        List<com.ss.ugc.live.sdk.msg.network.d> r22 = r14.f;
        if (r22 == null) goto L66;
        Iterator<T> r23 = r22.iterator();
    L58:
        if (r23.hasNext() == false) goto L62;
        Object r24 = r23.next();
        if (StringsKt.equals("umgw_global_ext", ((com.ss.ugc.live.sdk.msg.network.d) r24).a, true) == false) goto L58;
    L63:
        com.ss.ugc.live.sdk.msg.network.d r25 = (com.ss.ugc.live.sdk.msg.network.d) r24;
        if (r25 == null) goto L66;
        String r26 = r25.b;
    L67:
        if (r26 == null) goto L69;
        this.f = r26;
    L69:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "on unify ws message decode: [event_type: " + r111.c.event_type + ", umgw_global_ext: " + this.f + ']');
        UMGWEventType r27 = r111.c.event_type;
        if (r27 == null) goto L143;
        int r28 = g.a[r27.ordinal()];
        if (r28 != 1) goto L75;
        k r29 = this.k.a.get(Long.valueOf(r111.c.unique_id.longValue()));
        if (r29 == null) goto L81;
        UMGWUplinkPacket r30 = r29.b;
    L82:
        if (r30 == null) goto L135;
        k r31 = this.k.a.get(Long.valueOf(r30.unique_id.longValue()));
        if (r31 == null) goto L88;
        Runnable r32 = r31.c;
        if (r32 == null) goto L88;
        this.b.removeCallbacks(r32);
    L88:
        l r33 = this.k;
        r33.getClass();
        Intrinsics.checkNotNullParameter(r30, "uplinkPacket");
        r33.a.remove(r30.unique_id);
        UMGWEventType r34 = r30.event_type;
        if (r34 != UMGWEventType.UPLINK_REGISTER) goto L107;
        UMGWDownlinkPacket r112 = r111.c;
        UMGWEventData r35 = r112.event_data;
        if (r35 != null) goto L93;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "on register business packet error due to event data is null");
        return;
    L93:
        c r36 = this.l.c(r35.token.longValue());
        if (r36 == null) goto L137;
        JSONObject r37 = new JSONObject();
        r37.put("service", r36.g());
        r37.put("method", r36.e());
        JSONObject r38 = new JSONObject();
        r38.put("use_time", String.valueOf(System.currentTimeMillis() - r29.a));
        JSONObject r39 = new JSONObject();
        Iterator r40 = ((ArrayList) r36.f()).iterator();
    L97:
        if (r40.hasNext() == false) goto L99;
        UMGWCustomData r41 = (UMGWCustomData) r40.next();
        r39.put(r41.key, r41.value);
        goto L97
    L99:
        Long r42 = r112.status_code;
        if (r42 != null) goto L103;
    L105:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "register business failed due to " + r112.status_code + " -- " + r112.status_message + " : " + r36.a());
        r37.put("is_success", false);
        r37.put("status_message", r112.status_message);
        this.n.e("ttlive_im_unified_channel_biz_register", r37, r38, r39);
        r36.c.d(new c.a.e(r112.unique_id.longValue()));
        return;
    L103:
        if (r42.longValue() != 0) goto L105;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "register business success: " + r36.a());
        r37.put("is_success", true);
        r37.put("status_message", "success");
        this.n.e("ttlive_im_unified_channel_biz_register", r37, r38, r39);
        r36.c.d(new c.a.f(r112.unique_id.longValue()));
        return;
    L137:
        return;
    L107:
        if (r34 != UMGWEventType.UPLINK_UNREGISTER) goto L140;
        UMGWDownlinkPacket r113 = r111.c;
        kmc.d r43 = this.n;
        StringBuilder r44 = new StringBuilder("unregister business success: [service: ");
        UMGWEventData r45 = r113.event_data;
        if (r45 == null) goto L111;
        Integer r46 = r45.service;
    L112:
        r44.append(r46);
        r44.append(", method: ");
        UMGWEventData r47 = r113.event_data;
        if (r47 == null) goto L115;
        Integer r48 = r47.method;
    L116:
        r44.append(r48);
        r44.append(", token: ");
        UMGWEventData r114 = r113.event_data;
        if (r114 == null) goto L119;
        r21 = r114.token;
    L119:
        r44.append(r21);
        r44.append(']');
        com.ss.ugc.live.sdk.msg.utils.a.c(r43, r44.toString());
        return;
    L115:
        r48 = null;
        goto L116
    L111:
        r46 = null;
        goto L112
    L140:
        return;
    L135:
        return;
    L81:
        r30 = null;
        goto L82
    L75:
        if (r28 != 2) goto L144;
        e(CollectionsKt.listOf(r111), true);
        return;
    L144:
        return;
    L143:
        return;
    L62:
        r24 = null;
    L66:
        r26 = null;
        goto L67
    L121:
        if ((r110 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L124;
        E r115 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r110).b;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "ws unify message decode failed due to " + r115.getMessage());
        return;
    L124:
        throw new NoWhenBranchMatchedException();
    }

    public final void d(String r4) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "disconnect ws due to ".concat(r4));
        UnifyWSState r0 = this.p;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "reason");
        r0.c = null;
        com.ss.ugc.live.sdk.msg.unify.network.b r2 = r0.b;
        if (r2 == null) goto L5;
        r2.disconnect();
    L5:
        r0.b = null;
        r0.d.d(new UnifyWSState.a.c(r4));
    }

    public final void g(long r5) {
        if (this.p.e() == false) goto L8;
        if (this.l.d() == true) goto L8;
        return;
    L8:
        if (this.b.hasMessages(103) == false) goto L10;
        return;
    L10:
        c();
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "redetermineFetchStrategy, delay: " + r5);
        this.b.sendMessageDelayed(this.b.obtainMessage(103, Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL), r5);
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.i.a
    public final void handleMsg(Message r23) {
        if (r23 == null) goto L136;
        boolean r3 = false;
        String r10 = null;
        switch(r23.what) {
            case 101: goto L112;
            case 102: goto L149;
            case 103: goto L76;
            case 104: goto L63;
            case 105: goto L58;
            case 106: goto L53;
            case 107: goto L46;
            case 108: goto L42;
            case 109: goto L149;
            case 110: goto L15;
            case 111: goto L149;
            case 112: goto L7;
            default: goto L149;
        };
    L7:
        Object r1 = r23.obj;
        if (r1 == null) goto L14;
        c r2 = (c) r1;
        if (this.p.e() == false) goto L150;
        long r20 = Long.valueOf(kmc.b.a.incrementAndGet()).longValue();
        UMGWUplinkPacket r4 = new UMGWUplinkPacket.Builder().unique_id(Long.valueOf(r20)).event_type(UMGWEventType.UPLINK_UNREGISTER).event_data(new UMGWEventData.Builder().token(Long.valueOf(r2.d)).service(Integer.valueOf(r2.g())).method(Integer.valueOf(r2.e())).params(r2.f()).m1697build()).m1707build();
        tlc.f r5 = new tlc.f(r2.g(), r2.e(), PayloadItemType.PAYLOAD_TYPE_UMGW.getType(), "pb", UMGWUplinkPacket.ADAPTER.encode(r4), CollectionsKt.emptyList(), r20, r20);
        this.k.a(r4, r2, null);
        this.p.f(r5);
        return;
    L150:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.unify.UnifyMessageBridge");
    L15:
        Collection<c> r6 = this.l.a.values();
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L17:
        if (r8.hasNext() == false) goto L30;
        Object r9 = r8.next();
        c r11 = (c) r9;
        if (Intrinsics.areEqual(r11.h(), c.d.f.a) == false) goto L21;
    L26:
        boolean r12 = true;
    L27:
        if (r12 == false) goto L17;
        r7.add(r9);
        goto L17
    L21:
        if (Intrinsics.areEqual(r11.h(), c.d.C0221c.a) == true) goto L26;
        if (Intrinsics.areEqual(r11.h(), c.d.a.a) == true) goto L26;
        r12 = false;
        goto L27
    L30:
        if (r7.isEmpty() == false) goto L33;
        return;
    L33:
        if (this.p.e() == false) goto L39;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "try register business, ws connected");
        Iterator r13 = r7.iterator();
    L36:
        if (r13.hasNext() == false) goto L154;
        c r14 = (c) r13.next();
        long r15 = Long.valueOf(kmc.b.a.incrementAndGet()).longValue();
        UMGWUplinkPacket r16 = new UMGWUplinkPacket.Builder().unique_id(Long.valueOf(r15)).event_type(UMGWEventType.UPLINK_REGISTER).event_data(new UMGWEventData.Builder().token(Long.valueOf(r14.d)).service(Integer.valueOf(r14.g())).method(Integer.valueOf(r14.e())).params(r14.f()).m1697build()).m1707build();
        tlc.f r17 = new tlc.f(r14.g(), r14.e(), PayloadItemType.PAYLOAD_TYPE_UMGW.getType(), "pb", UMGWUplinkPacket.ADAPTER.encode(r16), CollectionsKt.emptyList(), r15, r15);
        h r18 = new h(r14, this);
        this.k.a(r16, r14, r18);
        this.p.f(r17);
        r14.c.d(new c.a.C0219c(r15));
        this.b.postDelayed(r18, 2000);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "start ws register: " + r14.a());
        goto L36
    L154:
        return;
    L39:
        if (Intrinsics.areEqual(this.p.d.b(), UnifyWSState.c.b.a) == true) goto L138;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "try register business, ws is not connecting with disconnected");
        g(a());
        return;
    L138:
        return;
    L53:
        Object r19 = r23.obj;
        if (r19 == null) goto L57;
        jmc.e r21 = new jmc.e(this.l);
        this.m.b(r21, (tlc.f) r19, this.j);
        return;
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.PayloadItem");
    L58:
        Object r22 = r23.obj;
        if (r22 == null) goto L62;
        d((String) r22);
        return;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L63:
        Object r24 = r23.obj;
        if (r24 == null) goto L75;
        UMGWConnectionInfo r25 = ((UMGWFetchResponse) r24).connection_info;
        if (r25 == null) goto L70;
        String r26 = r25.wss_url;
        if (r26 == null) goto L70;
    L71:
        if (r25 == null) goto L73;
        r10 = r25.wss_url_v2;
    L73:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "connect ws, url: ".concat(r26));
        HashMap r27 = new HashMap();
        r27.putAll(f());
        r27.putAll(this.o.a());
        this.p.c(r26, r27, new b(this), r10);
        i(3000);
        j(Conf$StickerSetManagerPosition.STICKER_SET_SHOP);
        return;
    L70:
        r26 = "";
        goto L71
    L75:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchResponse");
    L76:
        Object r28 = r23.obj;
        if (r28 == null) goto L111;
        String r29 = (String) r28;
        if (this.g == false) goto L82;
        return;
    L82:
        if (this.l.a.isEmpty() == false) goto L84;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "current no business register");
        return;
    L84:
        Collection<c> r30 = this.l.a.values();
        ArrayList r31 = new ArrayList();
        Iterator<T> r32 = r30.iterator();
    L86:
        if (r32.hasNext() == false) goto L99;
        Object r33 = r32.next();
        c r34 = (c) r33;
        if (Intrinsics.areEqual(r34.h(), c.d.C0221c.a) == false) goto L90;
    L95:
        boolean r35 = true;
    L96:
        if (r35 == false) goto L86;
        r31.add(r33);
        goto L86
    L90:
        if (Intrinsics.areEqual(r34.h(), c.d.a.a) == true) goto L95;
        if (Intrinsics.areEqual(r34.h(), c.d.f.a) == true) goto L95;
        r35 = false;
        goto L96
    L99:
        if (r31.isEmpty() == false) goto L101;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "no need fallback to http business, ws connect: " + this.p.e());
        return;
    L101:
        HashMap r36 = new HashMap();
        r36.put("fetch_rule", r29);
        r36.putAll(this.o.a());
        r36.putAll(f());
        ArrayList r37 = new ArrayList();
        Iterator r38 = r31.iterator();
    L103:
        if (r38.hasNext() == false) goto L105;
        c r39 = (c) r38.next();
        ArrayList r110 = new ArrayList();
        r110.addAll(r39.f());
        r110.addAll(r39.b());
        r37.add(new UMGWEventData.Builder().service(Integer.valueOf(r39.g())).method(Integer.valueOf(r39.e())).token(Long.valueOf(r39.d)).params(r110).m1697build());
        goto L103
    L105:
        kmc.d r40 = this.n;
        StringBuilder r41 = new StringBuilder("fetch message with rule ");
        r41.append(r29);
        r41.append(", business list: ");
        ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));
        Iterator r43 = r31.iterator();
    L107:
        if (r43.hasNext() == false) goto L109;
        r42.add(((c) r43.next()).a());
        goto L107
    L109:
        r41.append(TextUtils.join(",", r42));
        com.ss.ugc.live.sdk.msg.utils.a.c(r40, r41.toString());
        UMGWFetchRequest r44 = new UMGWFetchRequest.Builder().event_data(r37).m1701build();
        com.ss.ugc.live.sdk.msg.network.f.a r45 = new com.ss.ugc.live.sdk.msg.network.f.a();
        r45.a.b = this.o.e().toString();
        com.ss.ugc.live.sdk.msg.network.f.a r46 = r45.query(r36);
        byte[] r47 = UMGWFetchRequest.ADAPTER.encode(r44);
        com.ss.ugc.live.sdk.msg.network.f r48 = r46.a;
        r48.e = r47;
        r48.g = "application/x-protobuf";
        com.ss.ugc.live.sdk.msg.network.f r49 = r46.a();
        this.g = true;
        this.m.b(new jmc.b(this.l, this.a), r49, this.j);
        this.i = System.currentTimeMillis();
        return;
    L111:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L112:
        String r50 = this.o.g().toString();
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "direct connect ws, url: " + r50);
        if (r50.length() != 0) goto L115;
        r3 = true;
    L115:
        if (r3 == false) goto L117;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "direct ws url is empty");
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "fallback to determine message fetch strategy");
        g(a());
        return;
    L117:
        HashMap r51 = new HashMap();
        r51.putAll(f());
        r51.putAll(this.o.a());
        b r52 = new b(this);
        UnifyWSState r53 = this.p;
        Uri r54 = this.o.f();
        if (r54 == null) goto L120;
        r10 = r54.toString();
    L120:
        r53.c(r50, r51, r52, r10);
        i(3000);
        return;
    L149:
        return;
    L42:
        if (Intrinsics.areEqual(this.p.d.b(), UnifyWSState.c.b.a) == false) goto L44;
        d("ws connect timeout");
    L44:
        g(a());
        return;
    L46:
        if (this.p.e() == false) goto L152;
        long r55 = Long.valueOf(kmc.b.a.incrementAndGet()).longValue();
        System.currentTimeMillis();
        List<c> r56 = this.l.b();
        ArrayList r57 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r56, 10));
        Iterator r58 = ((ArrayList) r56).iterator();
    L50:
        if (r58.hasNext() == false) goto L52;
        r57.add(Long.valueOf(((c) r58.next()).d));
        goto L50
    L52:
        String r59 = TextUtils.join(",", r57);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "send heartbeat packet: seqId is " + r55 + ", registered_token_list: " + r59);
        this.p.f(new tlc.f(1, 1, PayloadItemType.PAYLOAD_TYPE_UMGW.getType(), "pb", UMGWUplinkPacket.ADAPTER.encode(new UMGWUplinkPacket.Builder().unique_id(Long.valueOf(r55)).event_type(UMGWEventType.UPLINK_HB).event_data(new UMGWEventData.Builder().service(1).method(1).token(0L).params(CollectionsKt.listOf(new UMGWCustomData("registered_token_list", r59))).m1697build()).m1707build()), new ArrayList(), r55, r55));
        h();
        return;
    L152:
        return;
    }

    public final void i(long r5) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "trigger ws fallback timer");
        c();
        Message r6 = this.b.obtainMessage(108);
        this.b.sendMessageDelayed(r6, Math.max(1000, 3000));
    }

    public final void j(String r6) {
        if (this.p.e() == false) goto L8;
        if (this.l.d() == true) goto L8;
        return;
    L8:
        if (this.b.hasMessages(103) == false) goto L10;
        return;
    L10:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "start next fetch with rule 2");
        long r1 = this.d;
        if (r1 > 0) goto L14;
        r1 = 1000;
    L14:
        Message r7 = this.b.obtainMessage(103, Conf$StickerSetManagerPosition.STICKER_SET_SHOP);
        this.b.sendMessageDelayed(r7, r1);
    }

    public final void e(List<hmc.b> r24, boolean r25) {
        List<hmc.b> r1 = r24;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        Iterator<T> r4 = r24.iterator();
    L13:
        if (r4.hasNext() == false) goto L75;
        hmc.b r5 = (hmc.b) r4.next();
        UMGWEventData r6 = r5.c.event_data;
        if (r6 == null) goto L74;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "on packet dispatch: [service: " + r6.service + ", method: " + r6.method + ", token: " + r6.token + ']');
        c r7 = this.l.c(r6.token.longValue());
        if (r7 == null) goto L74;
        if (r25 == false) goto L20;
        boolean r8 = Intrinsics.areEqual(r7.h(), c.d.C0222d.a);
    L21:
        String r9 = null;
        if (r8 == true) goto L25;
        r7 = null;
    L25:
        if (r7 == null) goto L74;
        r7.f.c().b(r5.b);
        Intrinsics.checkNotNullParameter(r5, "packet");
        Iterator<imc.c> r10 = r7.a.iterator();
    L28:
        if (r10.hasNext() == false) goto L30;
        r10.next().a(r5);
        goto L28
    L30:
        if (r25 == false) goto L74;
        if (this.p.e() == false) goto L74;
        UMGWEventData r11 = r5.c.event_data;
        if (r11 == null) goto L74;
        long r12 = Long.valueOf(kmc.b.a.incrementAndGet()).longValue();
        c r13 = this.l.c(r11.token.longValue());
        if (r13 == null) goto L39;
        List<UMGWCustomData> r14 = r13.b();
    L40:
        ArrayList r15 = new ArrayList();
        r15.addAll(r14);
        UMGWDownlinkPacket r16 = r5.c;
        int r17 = com.ss.ugc.live.sdk.msg.utils.c.a;
        if (r16 == null) goto L56;
        UMGWEventData r18 = r16.event_data;
        if (r18 == null) goto L56;
        List<UMGWCustomData> r19 = r18.params;
        if (r19 == null) goto L56;
        Iterator<T> r20 = r19.iterator();
    L48:
        if (r20.hasNext() == false) goto L52;
        Object r110 = r20.next();
        if (StringsKt.equals("biz_seq_id", ((UMGWCustomData) r110).key, r2) == false) goto L48;
    L53:
        UMGWCustomData r111 = (UMGWCustomData) r110;
        if (r111 == null) goto L56;
        r9 = r111.value;
        goto L56
    L52:
        r110 = null;
    L56:
        if (r9 == null) goto L58;
        r15.add(new UMGWCustomData("biz_seq_id", r9));
    L58:
        String r21 = r5.a();
        if (r21 == null) goto L61;
        r15.add(new UMGWCustomData("biz_log_id", r21));
    L61:
        c r22 = this.l.c(r11.token.longValue());
        if (r22 == null) goto L66;
        byte[] r23 = r22.f.a();
        ByteString r26 = ByteString.of(Arrays.copyOf(r23, r23.length));
        if (r26 == null) goto L66;
    L67:
        UMGWEventData r27 = new UMGWEventData.Builder().token(r11.token).service(r11.service).method(r11.method).params(r15).payload(r26).m1697build();
        UMGWUplinkPacket r28 = new UMGWUplinkPacket.Builder().unique_id(Long.valueOf(r12)).event_type(UMGWEventType.UPLINK_ACK).event_data(r27).m1707build();
        int r112 = r11.service.intValue();
        int r113 = r11.method.intValue();
        String r29 = PayloadItemType.PAYLOAD_TYPE_UMGW.getType();
        byte[] r114 = UMGWUplinkPacket.ADAPTER.encode(r28);
        List r115 = CollectionsKt.emptyList();
        tlc.f r30 = r5.a;
        if (r30 == null) goto L70;
        long r116 = r30.g;
    L71:
        if (r30 == null) goto L73;
        r12 = r30.h;
    L73:
        this.p.f(new tlc.f(r112, r113, r29, "pb", r114, r115, r116, r12));
        com.ss.ugc.live.sdk.msg.utils.a.c(this.n, "send ws ack: [service: " + r27.service + ", method: " + r27.method + ", token: " + r27.token + "], log_id: " + r5.a() + ", internal_ext: " + com.ss.ugc.live.sdk.msg.utils.c.b(r15));
        goto L74
    L70:
        r116 = r12;
    L66:
        r26 = ByteString.EMPTY;
        goto L67
    L39:
        r14 = CollectionsKt.emptyList();
        goto L40
    L20:
        r8 = true;
    L74:
        r2 = true;
        goto L13
    L75:
        return;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public f(Looper r2, com.ss.ugc.live.sdk.msg.unify.b r3, com.ss.ugc.live.sdk.msg.utils.task.c r4, kmc.d r5, gmc.a r6, UnifyWSState r7) {
        Intrinsics.checkNotNullParameter(r2, "coreQueueLooper");
        Intrinsics.checkNotNullParameter(r3, "unifyLinkManager");
        Intrinsics.checkNotNullParameter(r4, "taskScheduler");
        Intrinsics.checkNotNullParameter(r5, "unifyTracer");
        Intrinsics.checkNotNullParameter(r6, "unifyMessageConfig");
        Intrinsics.checkNotNullParameter(r7, "wsState");
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.p = r7;
        this.a = r6.c();
        this.b = new com.ss.ugc.live.sdk.msg.utils.i(r2, this);
        this.c = new com.ss.ugc.live.sdk.msg.utils.i(r2, this);
        this.d = 1000;
        this.e = 10;
        this.f = "";
        this.j = new com.ss.ugc.live.sdk.msg.utils.j(this);
        this.k = new l();
    }
}
