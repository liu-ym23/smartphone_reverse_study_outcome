package com.bytedance.ies.web.jsbridge2;

import com.bytedance.ies.bullet.kit.web.SSWebView;
import java.util.LinkedHashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSWebView f6272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6274c;
    public uj.a d;
    public boolean e;
    public boolean f;
    public final LinkedHashSet g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f6275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f6276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f6277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CopyOnWriteArrayList f6278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f6279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f6280m;

    public d(SSWebView r5) {
        this.f6274c = "IESJSBridge";
        this.g = new LinkedHashSet();
        this.f6275h = "host";
        this.f6276i = new LinkedHashSet();
        this.f6277j = new LinkedHashSet();
        this.f6278k = new CopyOnWriteArrayList();
        this.f6279l = true;
        this.f6280m = true;
        this.f6272a = r5;
        this.f6273b = new a(r5);
    }
}
