package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final <T extends vh7.c<T>> vh7.c<T> a(vh7.c<T> r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if ((r1 instanceof vh7.e) == false) goto L12;
        Object r2 = ((vh7.e) r1).getFlexInstance();
        if (r2 == null) goto L9;
        return (vh7.c) r2;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
    L12:
        return r1;
    }
}
