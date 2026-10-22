package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ReferenceContainer implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Map impl;

    public ReferenceContainer() {
        this.impl = new HashMap();
    }

    public final ReferenceExp _get(String r2) {
        Object r1 = this.impl.get(r2);
        if (r1 != null) goto L5;
        return null;
    L5:
        return (ReferenceExp) ZeusTransformUtils.preCheckCast(r1, ReferenceExp.class, "com.obric.memorydata.plugin");
    }

    public final ReferenceExp _getOrCreate(String r2) {
        Object r0 = this.impl.get(r2);
        if (r0 != null) goto L5;
        ReferenceExp r1 = createReference(r2);
        this.impl.put(r2, r1);
        return r1;
    L5:
        return (ReferenceExp) ZeusTransformUtils.preCheckCast(r0, ReferenceExp.class, "com.obric.memorydata.plugin");
    }

    public abstract ReferenceExp createReference(String r1);

    public final ReferenceExp[] getAll() {
        ReferenceExp[] r0 = new ReferenceExp[size()];
        this.impl.values().toArray(r0);
        return r0;
    }

    public final Iterator iterator() {
        return this.impl.values().iterator();
    }

    public void redefine(String r1, ReferenceExp r2) {
        if (this.impl.put(r1, r2) == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException();
    }

    public final ReferenceExp remove(String r2) {
        return (ReferenceExp) ZeusTransformUtils.preCheckCast(this.impl.remove(r2), ReferenceExp.class, "com.obric.memorydata.plugin");
    }

    public final int size() {
        return this.impl.size();
    }
}
