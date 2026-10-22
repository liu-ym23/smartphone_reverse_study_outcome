package com.obric.memorydata.awareness.impl.producer;

import com.obric.memorydata.utils.aw;
import com.obric.memorydata.utils.r;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/TimeUtil;", "", "<init>", "()V", "requestCalender", "Lorg/json/JSONObject;", "uriStr", "", "getJulianDay", "", "getDayTypeInfo", "timestamp", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8749a = null;

    static {
        f8749a = new f();
    }

    private f() {
    }

    public static /* synthetic */ String a(f r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = System.currentTimeMillis();
    L6:
        return r0.a(r1);
    }

    public final String a(long r7) {
        aw.a r1 = aw.f13185a.a(r7);     // Catch: Exception -> L16
        int r2 = r.c(r7);     // Catch: Exception -> L16
        boolean r3 = false;
        if (1 <= r2) goto L6;
    L8:
        if (r1 == null) goto L13;
        if (r1.b() == false) goto L22;
        return "holiday";
    L22:
        return "weekday";
    L13:
        if (r3 == true) goto L15;
        return "weekend";
    L15:
        return "weekday";
    L6:
        if (r2 >= 6) goto L8;
        r3 = true;
    L17:
        if (r.d(r7) == false) goto L19;
        return "weekday";
    L19:
        return "weekend";
    }
}
