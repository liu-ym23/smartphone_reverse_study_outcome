package com.bytedance.ies.bullet.prefetchv2;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rd.b f5875c;

    public r(boolean r5, String r10, rd.b r11) {
        Intrinsics.checkNotNullParameter(r11, "rawData");
        this.f5873a = r5;
        this.f5874b = r10;
        this.f5875c = r11;
    }

    public final String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return (String) ((com.bytedance.ies.bullet.service.sdk.b) this.f5875c).f6143o.get(r5);
    }

    public final String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        boolean r5 = false;
        List r11 = StringsKt.K(r10, new String[]{"."}, 0, 6);
        if (r11.size() != 2) goto L25;
        String r12 = a((String) r11.get(0));
        if (r12 != null) goto L7;
        return null;
    L7:
        JSONObject r13 = new JSONObject(r12);
        String r14 = (String) r11.get(1);
        ConcurrentHashMap r15 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r16 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r16 == null) goto L14;
        xc.d r17 = (xc.d) r16.a(xc.d.class);
        if (r17 == null) goto L14;
        Boolean r18 = r17.n();
        if (r18 == null) goto L14;
        boolean r19 = r18.booleanValue();
    L15:
        if (r19 == false) goto L23;
        String r20 = r13.optString(r14);
        if (r20.length() <= 0) goto L19;
        r5 = true;
    L19:
        if (r5 == false) goto L21;
        return r20;
    L21:
        return null;
    L23:
        return r13.optString(r14);
    L14:
        r19 = true;
        goto L15
    L25:
        throw new PrefetchException(td.d.b("配置错误，格式应该为a.b: ", r10));
    }
}
