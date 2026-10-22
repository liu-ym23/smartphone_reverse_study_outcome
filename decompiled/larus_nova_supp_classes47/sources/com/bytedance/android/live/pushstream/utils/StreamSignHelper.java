package com.bytedance.android.live.pushstream.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.config.gh;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.ms.ILiveMsManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class StreamSignHelper implements wv0.a {
    public final String a;
    public final boolean b;
    public final Lazy c;
    public final Lazy d;
    public ILiveMsManager e;
    public IRoom f;

    public static final class a {
    }

    static {
    }

    @Override // wv0.a
    public final void release() {
        this.e = null;
        this.f = null;
    }

    public StreamSignHelper(IRoom r2) {
        this.f = r2;
        StringBuilder r3 = new StringBuilder("StreamSignHelper[");
        IRoom r0 = this.f;
        if (r0 == null) goto L6;
        String r1 = r0.getIdStr();
        if (r1 == null) goto L6;
    L7:
        r3.append(r1);
        r3.append(']');
        this.a = r3.toString();
        this.b = !((Boolean) gh.a.getValue()).booleanValue();
        this.c = LazyKt.lazy(StreamSignHelper$deviceId$2.INSTANCE);
        this.d = LazyKt.lazy(StreamSignHelper$aid$2.INSTANCE);
        this.e = k.n(IMiddlewareHostBusiness.class).getMsManager();
        return;
    L6:
        r1 = "null";
        goto L7
    }

    @Override // wv0.a
    public final void a(d0 r2) {
        if (r2 != null) goto L5;
        ALogger.e(this.a, "addMetaData: null livestream, skip");
        return;
    L5:
        c(null, r2);
    }

    @Override // wv0.a
    public final void b(com.bytedance.android.live.pushstream.d r2) {
        if (r2 != null) goto L5;
        ALogger.e(this.a, "addMetaData: null livestream, skip");
        return;
    L5:
        c(r2, null);
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.live.pushstream.utils.StreamSignHelper$getSignResult$1] */
    public final void c(com.bytedance.android.live.pushstream.d r9, d0 r10) {
        String r0 = this.a;
        StringBuilder r1 = new StringBuilder("addUserMetaData: start do addUserMetaData. liveStream:");
        Object r2 = "null";
        if (r9 == null) goto L5;
        Object r3 = Integer.valueOf(r9.hashCode());
    L6:
        r1.append(r3);
        r1.append(", liveCore:");
        if (r10 == null) goto L9;
        r2 = Integer.valueOf(r10.hashCode());
    L9:
        r1.append(r2);
        ALogger.i(r0, r1.toString());
        long r4 = System.currentTimeMillis();
        final LinkedHashMap r5 = new LinkedHashMap();
        r5.put("aid", (String) this.d.getValue());
        IRoom r6 = this.f;
        String r7 = "";
        if (r6 == null) goto L15;
        IBaseUser r8 = r6.getOwner();
        if (r8 == null) goto L15;
        String r12 = r8.getIdString();
        if (r12 == null) goto L15;
    L16:
        r5.put("uid", r12);
        r5.put("did", (String) this.c.getValue());
        IRoom r13 = this.f;
        if (r13 == null) goto L22;
        String r14 = r13.getIdStr();
        if (r14 == null) goto L22;
        r7 = r14;
    L22:
        r5.put("roomid", r7);
        r5.put("frametype", String.valueOf(1));
        r5.put("index", DataType.FALSE);
        r5.put("timestamp", String.valueOf(System.currentTimeMillis()));
        ILiveMsManager r15 = this.e;
        ?? r16 = new StreamSignHelper$getSignResult$1(r5);
        String r17 = GsonProtectorUtils.toJson(GsonHelper.getDefault(), r5);
        ALogger.i(this.a, "get signInfo: " + r17);
        if (r15 != null) goto L25;
        ALogger.w(this.a, "null msManager, return default");
        Map<String, String> r18 = r16.invoke(r17);
    L32:
        ALogger.i(this.a, "addMetaData: get singResult from frameSign:" + r18);
        String r19 = GsonProtectorUtils.toJson(GsonHelper.getDefault(), r18);
        if (r9 == null) goto L35;
        r9.A0(r19);
    L35:
        if (r10 == null) goto L37;
        r10.h0();
    L37:
        ALogger.i(this.a, "addMetaData complete cost:" + (System.currentTimeMillis() - r4));
        if (this.b == false) goto L41;
        NewBroadcastMonitor.a r20 = NewBroadcastMonitor.c("ttlive_stream_info_code", null, null, 14);
        r20.l(0);
        r20.c(String.valueOf(10));
        r20.i("status_msg", "V3 MetaData");
        r20.i("signResult", r18.toString());
        r20.a().report();
        return;
    L41:
        return;
    L25:
        Map<String, String> r22 = r15.frameSign(r17, 2);
        if (r22 != null) goto L28;
    L31:
        ALogger.w(this.a, "null signResult, return default");
        r18 = r16.invoke(r17);
        goto L32
    L28:
        if (r22.isEmpty() == true) goto L31;
        r18 = r22;
    L15:
        r12 = "";
        goto L16
    L5:
        r3 = "null";
        goto L6
    }
}
