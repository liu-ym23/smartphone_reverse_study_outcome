package com.larksuite.component.card.cardcontainer;

import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements ILynxContainerContext {
    public final HashMap<String, Object> a;
    public final OPTrace b;

    public final String getContainerType() {
        return "UniversalCard";
    }

    public final Map<String, Object> getBizExtra() {
        this.a.put("op_trace", this.b);
        return this.a;
    }

    public a() {
        this.a = new HashMap();
        this.b = gyb.a.a();
    }
}
