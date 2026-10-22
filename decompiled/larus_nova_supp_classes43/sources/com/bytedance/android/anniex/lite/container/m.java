package com.bytedance.android.anniex.lite.container;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.q1;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements com.bytedance.android.anniex.ui.e {
    public final qa.a a;
    public final com.bytedance.android.anniex.base.lifecycle.a b;
    public final ia.c c;

    @Override // com.bytedance.android.anniex.ui.e
    public final void c(AnnieXLynxView r1) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void f(AnnieXLynxView r1) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void g(AnnieXLynxView r1, LynxError r10) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void j(AnnieXLynxView r1, JSONObject r10) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void k(AnnieXLynxView r1, String r10) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void l(q1.b r1) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void m(AnnieXLynxView r1, JSONObject r10) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void o(q1.b r1) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void onModuleMethodInvoked(String r1, String r10, int r11) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void onTimingSetup(Map<String, Object> r1) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void onTimingUpdate(Map<String, Object> r1, Map<String, Long> r10, String r11) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void q(AnnieXLynxView r1, String r10) {
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final String shouldRedirectImageUrl(String r1) {
        return null;
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void a(TemplateBundle r10) {
        Intrinsics.checkNotNullParameter(r10, "templateBundle");
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void e(AnnieXLynxView r10) {
        this.b.d(this.a.e, this.c);
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void p(AnnieXLynxView r10) {
        this.b.k(this.a.e, this.c);
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void b(AnnieXLynxView r10, String r11) {
        this.b.g(this.a.e, this.c, new Throwable(r11));
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void d(Uri r10, AnnieXLynxView r11) {
        this.b.i(this.a.e, this.c);
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void n(Uri r10, AnnieXLynxView r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        this.b.h(r10.toString(), this.c);
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void onLoadFail(Uri r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "e");
        this.b.g(r10.toString(), this.c, r11);
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void onTemplateReady(String r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "resFrom");
    }

    public m(qa.a r10, AnnieXLiteContainer.b r11, ia.c r12) {
        Intrinsics.checkNotNullParameter(r10, "annieXContext");
        Intrinsics.checkNotNullParameter(r11, "originLifeCycle");
        Intrinsics.checkNotNullParameter(r12, "iContainer");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    @Override // com.bytedance.android.anniex.ui.e
    public final void loadImage(Context r1, String r10, String r11, float r12, float r13, Transformer r14, com.lynx.tasm.behavior.m.a r15) {
        com.bytedance.android.anniex.ui.e.b.a(r1, r15);
    }
}
