package com.bytedance.salamander.anniex;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.rts.foundation.RTSIntKt;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static final i a(long r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "bidObject");
        i r5 = new i();
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.json.JSONObject{ com.bytedance.salamander.anniex.AnniexMonitorFoundationInterfaceBasicTypeKt.AnnieXJSONObject }");
        Iterator r13 = b.a(r11).iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = (String) r13.next();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Any");
        JSONObject r15 = b.b(r14, r11, r12);
        Intrinsics.checkNotNullParameter(r15, "jsonObj");
        Intrinsics.checkNotNullParameter("hit_sample", STGroup.DICT_KEY);
        long r16 = r15.optLong("hit_sample", 0);
        h r17 = new h(r14);
        r17.f7254b = r16;
        r17.f7255c = r10;
        Intrinsics.checkNotNullParameter(b(b.b("event_name_sample", r15, r12)), "<set-?>");
        c(r17, r16);
        RTSMapKt.set(r5.f7256a, r14, r17);
        goto L4
    L6:
        return r5;
    }

    public static final Map b(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        Map r10 = RTSMapKt.RTSMap();
        Iterator r11 = b.a(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = (String) r11.next();
        Intrinsics.checkNotNullParameter(r5, "jsonObj");
        Intrinsics.checkNotNullParameter(r12, STGroup.DICT_KEY);
        RTSMapKt.set(r10, r12, Integer.valueOf(r5.optInt(r12, 0)));
        goto L4
    L6:
        return r10;
    }

    public static final void c(h r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "bidConfig");
        int r5 = 0;
    L4:
        if (r5 >= 46) goto L16;
        if (r5 == 0) goto L9;
        r11 = r11 >> 1;
    L9:
        if ((r11 % 2) != RTSIntKt.toInt64(IntCompanionObject.INSTANCE, 1)) goto L15;
        Intrinsics.checkNotNullParameter(r10, "bidConfig");
        switch(r5) {
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L15;
            case 15: goto L15;
            case 16: goto L15;
            case 17: goto L15;
            case 18: goto L15;
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L15;
            case 22: goto L15;
            case 23: goto L15;
            case 24: goto L15;
            case 25: goto L15;
            case 26: goto L15;
            case 27: goto L15;
            case 28: goto L15;
            case 29: goto L15;
            case 30: goto L15;
            case 31: goto L15;
            case 32: goto L15;
            case 33: goto L15;
            case 34: goto L15;
            case 35: goto L13;
            case 36: goto L15;
            case 37: goto L15;
            case 38: goto L15;
            case 39: goto L15;
            case 40: goto L15;
            case 41: goto L15;
            case 42: goto L15;
            case 43: goto L15;
            case 44: goto L15;
            case 45: goto L15;
            default: goto L15;
        };
    L13:
        r10.e = true;
        goto L15
    L14:
        r10.d = true;
    L15:
        r5 = r5 + 1;
        goto L4
    }
}
