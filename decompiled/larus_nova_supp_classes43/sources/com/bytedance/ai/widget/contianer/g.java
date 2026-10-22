package com.bytedance.ai.widget.contianer;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AppletResourceTool;
import d3.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends a0 {
    public final String a;
    public final String b;
    public final ContainerType c;
    public final String d;
    public final String e;
    public final int f;
    public final /* synthetic */ AppletWidgetContainer g;

    @Override // d3.a0
    public final Integer getAppSourceType() {
        return Integer.valueOf(this.f);
    }

    @Override // d3.a0
    public final String getConversationId() {
        return this.g.b;
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
    public final String getUrl() {
        return this.e;
    }

    public g(Widget r10, AppletWidgetContainer r11) {
        this.g = r11;
        this.a = r10.b;
        this.b = r10.K;
        this.c = ContainerType.WIDGET;
        this.d = r11.f;
        this.e = AppletResourceTool.m(AppletResourceTool.a, r10, r10.L);
        this.f = r10.G;
    }
}
