package com.bytedance.android.anniex.ui;

import android.content.Context;
import android.net.Uri;
import com.bytedance.forest.model.Response;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface e {

    public static class a implements e {
        public a() {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void a(TemplateBundle r10) {
            Intrinsics.checkNotNullParameter(r10, "templateBundle");
        }

        @Override // com.bytedance.android.anniex.ui.e
        @Deprecated(message = "Use onLoadFailed with errorCode instead")
        public void b(AnnieXLynxView r1, String r10) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void c(AnnieXLynxView r1) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void d(Uri r1, AnnieXLynxView r10) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void e(AnnieXLynxView r1) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void f(AnnieXLynxView r1) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void g(AnnieXLynxView r1, LynxError r10) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void j(AnnieXLynxView r1, JSONObject r10) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void k(AnnieXLynxView r1, String r10) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void l(q1.b r1) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void loadImage(Context r1, String r10, String r11, float r12, float r13, Transformer r14, m.a r15) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r15, "handler");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void m(AnnieXLynxView r1, JSONObject r10) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void n(Uri r1, AnnieXLynxView r10) {
            Intrinsics.checkNotNullParameter(r1, "uri");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void o(q1.b r1) {
        }

        public void onDestroy() {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onLoadFail(Uri r10, Throwable r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            Intrinsics.checkNotNullParameter(r11, "e");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onModuleMethodInvoked(String r1, String r10, int r11) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onTemplateReady(String r1, boolean r10) {
            Intrinsics.checkNotNullParameter(r1, "resFrom");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onTimingSetup(Map<String, Object> r1) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onTimingUpdate(Map<String, Object> r1, Map<String, Long> r10, String r11) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void p(AnnieXLynxView r1) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void q(AnnieXLynxView r1, String r10) {
        }

        public void s(String r1) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public String shouldRedirectImageUrl(String r1) {
            return null;
        }

        public void t(Response r10) {
            Intrinsics.checkNotNullParameter(r10, "response");
        }
    }

    public static final class b {
        public static void a(Context r1, m.a r10) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r10, "handler");
        }

        public static void b(Uri r1, Throwable r10) {
            Intrinsics.checkNotNullParameter(r1, "uri");
            Intrinsics.checkNotNullParameter(r10, "e");
        }
    }

    void a(TemplateBundle r1);

    void b(AnnieXLynxView r1, String r10);

    void c(AnnieXLynxView r1);

    void d(Uri r1, AnnieXLynxView r10);

    void e(AnnieXLynxView r1);

    void f(AnnieXLynxView r1);

    void g(AnnieXLynxView r1, LynxError r10);

    void j(AnnieXLynxView r1, JSONObject r10);

    void k(AnnieXLynxView r1, String r10);

    void l(q1.b r1);

    void loadImage(Context r1, String r10, String r11, float r12, float r13, Transformer r14, m.a r15);

    void m(AnnieXLynxView r1, JSONObject r10);

    void n(Uri r1, AnnieXLynxView r10);

    void o(q1.b r1);

    void onLoadFail(Uri r1, Throwable r10);

    void onModuleMethodInvoked(String r1, String r10, int r11);

    void onTemplateReady(String r1, boolean r10);

    void onTimingSetup(Map<String, Object> r1);

    void onTimingUpdate(Map<String, Object> r1, Map<String, Long> r10, String r11);

    void p(AnnieXLynxView r1);

    void q(AnnieXLynxView r1, String r10);

    String shouldRedirectImageUrl(String r1);
}
