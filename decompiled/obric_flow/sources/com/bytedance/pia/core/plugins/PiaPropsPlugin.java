package com.bytedance.pia.core.plugins;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.jvm.internal.Intrinsics;
import mh.f;
import nh.a;
import nh.c;
import nh.d;

/* JADX INFO: loaded from: classes2.dex */
public class PiaPropsPlugin extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonObject f7046c;

    public PiaPropsPlugin(d r5) {
        super(r5);
        this.f7046c = new JsonObject();
    }

    @Override // nh.c
    public final String c() {
        return "pia_props";
    }

    @Override // nh.c
    public final void d(View r5) {
        if ((r5 instanceof WebView) == false) goto L13;
        WebView r10 = (WebView) r5;
        a r11 = this.f20236b.D;
        if (r11 != null) goto L9;
        return;
    L9:
        if ((r11.a("ctx-pia-props-jsi") instanceof f) == false) goto L11;
        return;
    L11:
        r11.b(new f(r11, r10), "ctx-pia-props-jsi");
        return;
    }

    @Override // nh.c
    public final void f() {
        JsonPrimitive r5 = new JsonPrimitive(i.a().toJson(this.f20236b.d));
        JsonObject r10 = this.f7046c;
        r10.add("getPageConfig", r5);
        r10.add("getManifest", new JsonPrimitive("{}"));
    }

    @Override // nh.c
    public final void g() {
        View r5 = this.f20236b.c();
        if ((r5 instanceof WebView) == true) goto L5;
        return;
    L5:
        StringBuilder r10 = new StringBuilder("(function(n){var r={},o=JSON.parse(n);for(var i in o)r[i]=function(n){return function(){return o[n]}}(i);window.pia_props=r})");
        j.r(r10, this.f7046c.toString());
        String r11 = r10.toString();
        Intrinsics.checkNotNullParameter(r11, "script");
        j.o((WebView) r5, r11, null);
    }
}
