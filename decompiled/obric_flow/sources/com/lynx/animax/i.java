package com.lynx.animax;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i extends on.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f9618h;

    public /* synthetic */ i(int r5, String r10) {
        this.f9618h = 1;
        super(r5, r10);
    }

    @Override // on.b
    public Map b() {
        switch(this.f9618h) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.b();
    L7:
        return this.g;
    }

    @Override // on.b
    public final String c() {
        switch(this.f9618h) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return "detail";
    L6:
        return "detail";
    L8:
        return "detail";
    }

    public /* synthetic */ i(Map r5, String r10, int r11, int r12) {
        this.f9618h = r12;
        super(r11, r10, r5);
    }
}
