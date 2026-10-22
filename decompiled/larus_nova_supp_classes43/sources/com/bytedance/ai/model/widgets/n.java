package com.bytedance.ai.model.widgets;

import com.bytedance.ai.bridge.ContainerType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends d3.a0 {
    public final String a;
    public final String b;
    public final ContainerType c;
    public final String d;
    public final String e;
    public final String f;

    @Override // d3.a0
    public final String getAppId() {
        return this.b;
    }

    @Override // d3.a0
    public final String getAppletId() {
        return this.a;
    }

    @Override // d3.a0
    public final String getContainerId() {
        return this.d;
    }

    @Override // d3.a0
    public final ContainerType getContainerType() {
        return this.c;
    }

    @Override // d3.a0
    public final String getTag() {
        return this.f;
    }

    @Override // d3.a0
    public final String getUrl() {
        return this.e;
    }

    public n(k2.j r10, String r11) {
        this.a = r10.getAppletId();
        this.b = r10.getPageInfo().getPageId();
        this.c = ContainerType.PAGE;
        this.d = r10.getPageID();
        this.e = r10.getPageInfo().getPageUrl();
        this.f = r11;
    }
}
