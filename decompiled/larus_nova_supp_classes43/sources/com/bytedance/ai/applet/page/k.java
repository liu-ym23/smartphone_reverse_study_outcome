package com.bytedance.ai.applet.page;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.bridge.ContainerType;
import d3.a0;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k extends a0 {
    public final String a;
    public final String b;
    public final ContainerType c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;
    public final Long i;
    public final String j;

    @Override // d3.a0
    public final Integer getAppSourceType() {
        return Integer.valueOf(this.g);
    }

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
    public final String getConversationId() {
        return this.f;
    }

    @Override // d3.a0
    public final String getPath() {
        return this.j;
    }

    @Override // d3.a0
    public final String getTag() {
        return this.h;
    }

    @Override // d3.a0
    public final Long getTraceId() {
        return this.i;
    }

    @Override // d3.a0
    public final String getUrl() {
        return this.e;
    }

    public k(OnlineAppletApplication r10, AppletPageFragment r11) {
        this.a = r10.getAppId();
        this.b = r10.getAppId();
        this.c = ContainerType.PAGE;
        this.d = UUID.randomUUID().toString();
        this.e = r11.f;
        this.f = r11.n;
        this.g = r10.j().G;
        this.h = String.valueOf(System.currentTimeMillis());
        this.i = t2.b.b(r11);
        String r12 = r11.f;
        if (r12 == null) goto L5;
        String r13 = t2.c.a(r12);
    L6:
        this.j = r13;
        return;
    L5:
        r13 = null;
        goto L6
    }
}
