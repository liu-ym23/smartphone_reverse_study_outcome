package com.bytedance.ai.model.widgets;

import android.util.LruCache;
import android.webkit.WebView;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.e0;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends m1.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2347c;
    public final ContainerType d;
    public final String e;
    public final String f;

    public i(Widget r5, AppletWidgetContainer r10) {
        this.f2345a = 2;
        this.f2346b = r5.f2259b;
        this.f2347c = r5.F;
        this.d = ContainerType.f1800b;
        this.e = r10.e;
        LruCache r11 = e0.f2711a;
        this.f = e0.d(r5, r5.G);
    }

    @Override // m1.j
    public final String a() {
        switch(this.f2345a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.f2347c;
    L7:
        return this.f2347c;
    L9:
        return this.f2347c;
    }

    @Override // m1.j
    public final String b() {
        switch(this.f2345a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.f2346b;
    L7:
        return this.f2346b;
    L9:
        return this.f2346b;
    }

    @Override // m1.j
    public final String c() {
        switch(this.f2345a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.e;
    L7:
        return this.e;
    L9:
        return this.e;
    }

    @Override // m1.j
    public final ContainerType d() {
        switch(this.f2345a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.d;
    L7:
        return this.d;
    L9:
        return this.d;
    }

    @Override // m1.j
    public final String e() {
        switch(this.f2345a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.f;
    L7:
        return this.f;
    L9:
        return this.f;
    }

    public i(LynxViewFloatingPage r5) {
        this.f2345a = 0;
        this.f2346b = r5.getAppletId();
        this.f2347c = r5.f2330b.getPageId();
        this.d = ContainerType.f1801c;
        this.e = r5.f2331c;
        this.f = r5.f2330b.getPageUrl();
    }

    public i(WebViewFloatingPageV2 r5, WebView r10) {
        this.f2345a = 1;
        this.f2346b = r5.getAppletId();
        this.f2347c = r5.getAppletId();
        this.d = ContainerType.f1801c;
        this.e = r5.f2331c;
        this.f = r10.getUrl();
    }
}
