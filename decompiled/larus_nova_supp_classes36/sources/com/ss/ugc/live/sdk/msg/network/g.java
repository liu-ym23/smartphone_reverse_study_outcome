package com.ss.ugc.live.sdk.msg.network;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public int a;
    public String b;
    public List<d> c;
    public byte[] d;
    public Object e;
    public int f;

    public final boolean a() {
        int r0 = this.a;
        if (r0 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= 300) goto L7;
        return true;
    }

    public g() {
    }
}
