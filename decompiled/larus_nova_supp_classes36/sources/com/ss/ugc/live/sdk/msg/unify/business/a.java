package com.ss.ugc.live.sdk.msg.unify.business;

import android.text.TextUtils;
import com.ss.ugc.live.sdk.msg.dispatch.f;
import com.ss.ugc.live.sdk.msg.unify.j;
import im2.l;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements imc.d {
    public static String k;
    public static String l;
    public com.ss.ugc.live.sdk.msg.data.c a;
    public String b;
    public String c;
    public final j d;
    public final b e;
    public final int f;
    public final int g;
    public final Map<String, String> h;
    public final f i;
    public final amc.d j;

    /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.business.a$a, reason: collision with other inner class name */
    public static final class C0217a {
    }

    static {
    }

    @Override // imc.d
    public final byte[] a() {
        String r0 = this.b;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        return r0.getBytes(Charsets.UTF_8);
    }

    @Override // imc.d
    public final Map<String, String> d() {
        HashMap r0 = new HashMap();
        com.ss.ugc.live.sdk.msg.data.c r1 = this.a;
        if (r1 == null) goto L5;
        HashMap r2 = new HashMap();
        r2.put("im-trace-receive_count", String.valueOf(r1.e));
        r2.put("im-trace-error_count", String.valueOf(r1.f.size()));
        r2.put("im-trace-error_msg_ids", TextUtils.join(",", CollectionsKt.take(r1.f, Math.max(0, 15))));
        r0.putAll(r2);
    L5:
        String r3 = this.b;
        if (r3 == null) goto L8;
        String r4 = (String) r0.put("internal_ext", r3);
    L8:
        String r5 = this.c;
        if (r5 == null) goto L11;
        String r6 = (String) r0.put("cursor", r5);
    L11:
        String r7 = k;
        if (r7 == null) goto L14;
        String r8 = (String) r0.put("live_cursor", r7);
    L14:
        String r9 = l;
        if (r9 == null) goto L17;
        r0.put("wrds_preload_ext", r9);
    L17:
        return r0;
    }

    @Override // imc.d
    public final j b() {
        return this.d;
    }

    @Override // imc.d
    public final b c() {
        return this.e;
    }

    public a(int r2, int r3, Map r4, bmc.b r5, l r6) {
        Intrinsics.checkNotNullParameter(r4, "customParams");
        Intrinsics.checkNotNullParameter(r5, "messageDecoder");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.d = new j(r2, r3, r4);
        this.e = new b(this);
    }
}
