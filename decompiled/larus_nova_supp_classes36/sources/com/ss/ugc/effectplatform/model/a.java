package com.ss.ugc.effectplatform.model;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a {
    private String panel;

    public a() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public String getPanel() {
        return this.panel;
    }

    public a(String r1) {
        this.panel = r1;
    }

    public void setPanel(String r1) {
        this.panel = r1;
    }

    public /* synthetic */ a(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
