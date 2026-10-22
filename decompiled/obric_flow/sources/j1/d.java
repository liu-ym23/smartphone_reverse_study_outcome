package j1;

import android.webkit.WebResourceResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ol.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f18223a;

    public d(e r5) {
        this.f18223a = r5;
    }

    @Override // ol.f
    public final WebResourceResponse a(String r5, WebResourceResponse r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (r10 != null) goto L5;
    L26:
        Intrinsics.checkNotNullParameter(r5, "url");
        return r10;
    L5:
        if (Intrinsics.areEqual(r10.getMimeType(), "text/html") == false) goto L26;
        e r11 = this.f18223a;
        r11.f18225b.a("[afterLoadResource] " + r10.getMimeType() + " inject data for the webview");
        InputStream r12 = r10.getData();
        if (r12 == null) goto L25;
        g1.d r13 = r11.f18226c;
        if (r13.d.length() != 0) goto L11;
        String r14 = "JSON.stringify('')";
    L12:
        StringBuilder r15 = com.lynx.tasm.utils.e.b("\n                            window.__AI_SDK_VERSION__ = '0.90.0-rc.37-miniapp';\n                            window.__APPLET_VIEW_DATA__ = ", r14, ";\n                            window.__APPLET_VIEW_CONTEXT__ = ");
        r15.append(new JSONObject(r13.f17017c));
        r15.append(";\n                            window.__START_GET_FMP__ = true;\n                        ");
        String r16 = StringsKt.trimIndent(r15.toString());
        Intrinsics.checkNotNullParameter(r12, "<this>");
        StringBuilder r17 = new StringBuilder();
        BufferedReader r18 = new BufferedReader(new InputStreamReader(r12));
        String r19 = r18.readLine();     // Catch: Throwable -> L16
    L14:
        if (r19 == null) goto L18;
        r17.append(r19);     // Catch: Throwable -> L16
        r17.append("\n");     // Catch: Throwable -> L16
        r19 = r18.readLine();     // Catch: Throwable -> L16
        goto L14
    L18:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r18, null);
        return new WebResourceResponse(r10.getMimeType(), "utf-8", new ByteArrayInputStream(StringsKt.F(r17.toString(), "<!-- INJECT_GLOBAL_VARIABLES_CONTENT -->", com.lynx.tasm.utils.g.d("<script>", r16, "</script>")).getBytes(Charsets.UTF_8)));
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L11:
        r14 = r13.d.toString();
        Intrinsics.checkNotNull(r14);
        goto L12
    L25:
        return null;
    }
}
