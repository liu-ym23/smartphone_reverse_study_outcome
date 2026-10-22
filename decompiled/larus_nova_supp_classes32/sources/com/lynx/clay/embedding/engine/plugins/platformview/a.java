package com.lynx.clay.embedding.engine.plugins.platformview;

import android.content.Context;
import android.view.View;
import java.util.List;
import java.util.Map;
import n5a.h;
import n5a.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a {
    public final String a;
    public View b;
    public j c;
    public List<String> d;
    public final Context e;
    public InternalPlatformViewRegistry.ViewDrawType f;
    public LynxUIClayUIBridge$CompositionPreference g;

    public abstract View a(Context r1);

    public abstract boolean d(String r1, JSONObject r2, n5a.a r3);

    public void g() {
    }

    public void h() {
    }

    public void i(int r1, int r2, int r3, int r4) {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public abstract void n(String r1, Object r2);

    public final View b() {
        if (this.b != null) goto L6;
        this.b = a(this.e);
    L6:
        return this.b;
    }

    public final void e() {
        this.c.markLayoutDirty();
    }

    public final boolean c(String r2) {
        List<String> r0 = this.d;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.contains(r2);
    }

    public void o(j r1) {
        this.c = r1;
    }

    public void p(List<String> r1) {
        this.d = r1;
    }

    public final void q(String r2, Map<String, Object> r3) {
        if (this.c != null) goto L5;
        return;
    L5:
        if (c(r2) == false) goto L9;
        this.c.sendEvent(r2, r3);
        return;
    }

    public a(Context r1, int r2, String r3) {
        this.f = InternalPlatformViewRegistry.ViewDrawType.DRAWABLE;
        this.g = LynxUIClayUIBridge$CompositionPreference.AUTO;
        this.e = r1;
        this.a = r3;
    }

    public h f(MeasureMode r1, int r2, MeasureMode r3, int r4) {
        return new h(0.0f, 0.0f);
    }

    public void r(float r2, float r3, float r4, float r5) {
        View r0 = b();
        if (r0 == null) goto L6;
        r0.setPadding((int) r2, (int) r3, (int) r4, (int) r5);
        return;
    }
}
