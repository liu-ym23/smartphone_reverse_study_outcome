package com.bytedance.android.live.room.discovery.drawer.processor;

import android.os.SystemClock;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MoreLiveMarqueeProcessorContext {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final String g;
    public final Integer h;
    public final long i;
    public final Lazy j;
    public final Lazy k;
    public int l;
    public com.bytedance.android.live.base.model.moreliveentrance.b m;
    public LiveEntranceStatus n;
    public Function1<? super com.bytedance.android.live.base.model.moreliveentrance.b, Unit> o;
    public Function0<Unit> p;
    public final RoomContext q;

    public final boolean a() {
        return ((Boolean) this.j.getValue()).booleanValue();
    }

    public MoreLiveMarqueeProcessorContext(RoomContext r6, DataCenter r7) {
        this.q = r6;
        String r0 = "";
        this.g = "";
        String r1 = null;
        if (r6 == null) goto L5;
        Integer r2 = Integer.valueOf(r6.hashCode());
    L6:
        this.h = r2;
        this.i = SystemClock.elapsedRealtime();
        this.j = LazyKt.lazy(MoreLiveMarqueeProcessorContext$useNewShowStrategy$2.INSTANCE);
        this.k = LazyKt.lazy(MoreLiveMarqueeProcessorContext$maxTimeServerConfig$2.INSTANCE);
        this.n = LiveEntranceStatus.NOT_DISPLAYED;
        if (r6 == null) goto L11;
        n r3 = r6.getSourceEnterFromMerge();
        if (r3 == null) goto L11;
        String r4 = (String) r3.getValue();
    L12:
        this.a = r4;
        if (r6 == null) goto L17;
        n r5 = r6.getSourceEnterMethod();
        if (r5 == null) goto L17;
        String r8 = (String) r5.getValue();
    L18:
        this.b = r8;
        boolean r9 = false;
        if (r6 == null) goto L25;
        i r10 = r6.isFromLiveTab();
        if (r10 == null) goto L25;
        Boolean r12 = (Boolean) r10.getValue();
        if (r12 == null) goto L25;
        boolean r13 = r12.booleanValue();
    L26:
        this.c = r13;
        if (r6 == null) goto L33;
        m r14 = r6.getRoom();
        if (r14 == null) goto L33;
        Room r15 = (Room) r14.getValue();
        if (r15 == null) goto L33;
        long r16 = r15.getRoomId();
    L34:
        this.f = r16;
        if (r6 == null) goto L44;
        m r17 = r6.getRoom();
        if (r17 == null) goto L44;
        Room r18 = (Room) r17.getValue();
        if (r18 == null) goto L44;
        String r19 = r18.getAnchorId();
        if (r19 == null) goto L44;
        r0 = r19;
    L44:
        this.g = r0;
        if (r6 == null) goto L51;
        i r20 = r6.isFirstEnterRoom();
        if (r20 == null) goto L51;
        Boolean r22 = (Boolean) r20.getValue();
        if (r22 == null) goto L51;
        r9 = r22.booleanValue();
    L51:
        this.d = r9;
        if (r7 != null) goto L64;
    L57:
        HashMap r23 = null;
    L58:
        if (r23 == null) goto L61;
        r1 = (String) r23.get("float_view_enter_room_business_tag");
    L61:
        if (Intrinsics.areEqual(r1, "more_live") == false) goto L66;
        this.e = true;
        return;
    L66:
        return;
    L64:
        r23 = (HashMap) r7.get("data_room_business_extra", null);     // Catch: Exception -> L55
    L55:
        e = move-exception;
        d.a("getBusinessExtraMap error" + e.getMessage());
    L33:
        r16 = 0;
    L25:
        r13 = false;
    L17:
        r8 = null;
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }
}
