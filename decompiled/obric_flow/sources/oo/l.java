package oo;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile l f20819b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f20820a;

    public l(int r5) {
        switch(r5) {
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        this.f20820a = new HashMap();
        return;
    L5:
        this.f20820a = null;
        this.f20820a = new HashMap();
    }
}
