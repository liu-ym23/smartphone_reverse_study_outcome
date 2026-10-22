package mh;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.pia.core.plugins.PiaPropsPlugin;
import com.bytedance.pia.core.utils.m;
import com.google.gson.JsonElement;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements fh.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nh.a f20101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f20102c;

    public f(nh.a r5, WebView r10) {
        this.f20101b = r5;
        this.f20102c = new WeakReference(r10);
        m.a(new kh.b(3, this, r10));
    }

    public final String a(String r5) {
        Object r10 = this.f20101b.a("ctx-pia-runtime");
        if ((r10 instanceof nh.d) == false) goto L5;
        nh.d r11 = (nh.d) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        nh.c r12 = r11.j("pia_props");
        if ((r12 instanceof PiaPropsPlugin) == true) goto L11;
        return null;
    L11:
        JsonElement r13 = ((PiaPropsPlugin) r12).f7046c.get(r5);
        if (r13 != null) goto L15;
        return null;
    L15:
        return r13.getAsString();
    L5:
        r11 = null;
        goto L6
    }

    @JavascriptInterface
    public String getManifest() {
        return a("getManifest");
    }

    @JavascriptInterface
    public String getPageConfig() {
        return a("getPageConfig");
    }

    @Override // fh.c
    public final void release() {
        m.a(new com.obric.oui.lisitem.a(this, 18));
    }
}
