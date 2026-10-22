package com.bytedance.pia.core.plugins;

import com.bytedance.pia.core.utils.a;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh.c;
import nh.d;
import org.json.JSONArray;
import org.json.JSONObject;
import yg.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/pia/core/plugins/BridgeDowngradePlugin;", "Lnh/c;", "Lnh/d;", "runtime", "Lyg/b;", "manifest", "<init>", "(Lnh/d;Lyg/b;)V", "mh/b", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class BridgeDowngradePlugin extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f7043c;

    public BridgeDowngradePlugin(d r5, b r10) {
        Intrinsics.checkNotNullParameter(r5, "runtime");
        Intrinsics.checkNotNullParameter(r10, "manifest");
        super(r5);
        this.f7043c = new a();
    }

    public static JavaOnlyArray h(JSONArray r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        JavaOnlyArray r10 = new JavaOnlyArray();
        int r11 = r5.length();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L15;
        Object r13 = r5.opt(r12);
        if ((r13 instanceof JSONObject) == false) goto L11;
        r10.add(i((JSONObject) r13));
    L14:
        r12 = r12 + 1;
        goto L6
    L11:
        if ((r13 instanceof JSONArray) == false) goto L13;
        r10.add(h((JSONArray) r13));
        goto L14
    L13:
        r10.add(r13);
        goto L14
    L15:
        return r10;
    }

    public static JavaOnlyMap i(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<String> r5 = r10.keys();
        JavaOnlyMap r11 = new JavaOnlyMap();
    L7:
        if (r5.hasNext() == false) goto L18;
        String r12 = r5.next();
        Object r13 = r10.opt(r12);
        if ((r13 instanceof JSONObject) == true) goto L10;
        if ((r13 instanceof JSONArray) == true) goto L13;
        if (r13 == JSONObject.NULL) goto L16;
        r11.put(r12, r13);
        goto L7
    L16:
        r11.put(r12, null);
        goto L7
    L13:
        r11.put(r12, h((JSONArray) r13));
        goto L7
    L10:
        r11.put(r12, i((JSONObject) r13));
        goto L7
    L18:
        return r11;
    }

    @Override // nh.c
    public final String c() {
        return "bridgeDowngrade";
    }

    @Override // nh.c
    public final void e(String r5, Object... r10) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r10, "args");
        if (Intrinsics.areEqual("event-on-bind-bridge-handle", r5) == true) goto L5;
        return;
    L5:
        com.bytedance.pia.nsr.c r11 = new com.bytedance.pia.nsr.c(r10, this, 2);
        this.f7043c.b(r11);
    }
}
