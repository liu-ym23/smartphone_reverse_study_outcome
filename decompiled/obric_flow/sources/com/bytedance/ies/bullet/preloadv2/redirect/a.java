package com.bytedance.ies.bullet.preloadv2.redirect;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.ies.bullet.base.utils.b;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import com.lynx.tasm.behavior.utils.d;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tc.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f5885a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f5886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f5887c = null;

    static {
        f5887c = LazyKt.lazy(RedirectManager$mMap$2.f5884a);
    }

    public static String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (f5885a == true) goto L6;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPreload", "RedirectManager disable", null, 12);
        return null;
    L6:
        Lazy r10 = f5887c;
        String r11 = (String) ((LruCache) r10.getValue()).get(r5);
        b.m("RedirectManager getRedirectPath URL:" + r5 + ",redirectUrl:" + r11);
        if (r11 != null) goto L10;
    L19:
        b.m("RedirectManager file not exit,url:" + r5);
        ((LruCache) r10.getValue()).remove(r5);
        return null;
    L10:
        if (StringsKt.P(r11, "http") == false) goto L13;
    L16:
        b.m("RedirectManager file exit,url:" + r5);
        return r11;
    L13:
        if (StringsKt.P(r11, "file") == true) goto L15;
    L18:
        StringsKt.P(r11, "asset");
        goto L19
    L15:
        if (new File(Uri.parse(r11).getPath()).exists() == false) goto L18;
        goto L16
    }

    public static String b(String r5, ResourceFrom r10) {
        Intrinsics.checkNotNullParameter(r5, "filePath");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        if (d.g(Uri.parse(r5).getScheme()) == false) goto L6;
        return r5;
    L6:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (r10 != ResourceFrom.f4339b) goto L14;
        return new Uri.Builder().scheme("asset").authority("").path(r5).build().toString();
    L14:
        if (StringsKt.g(r5, "@") == true) goto L17;
        return Uri.fromFile(new File(r5)).toString();
    L17:
        return td.d.b("file:///", r5);
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (f5885a == true) goto L6;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPreload", "RedirectManager disable", null, 12);
        return;
    L6:
        if (r10 == null) goto L9;
        b.m("RedirectManager putRedirectPath URL:" + r5 + ",redirectUrl:" + r10);
        String r11 = (String) ((LruCache) f5887c.getValue()).put(r5, r10);
        return;
    }

    public static void d(String r5, String r10, String r11, boolean r12, long r13) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "resUrl");
        StringBuilder r14 = new StringBuilder();
        if (r12 == false) goto L5;
        String r15 = "命中";
    L6:
        f8.b.e(r14, r15, "命中重定向缓存 ", r10, ", ");
        r14.append(r11);
        b.m(r14.toString());
        c r16 = c.f22119c;
        i r17 = (i) c.f22119c.a(i.class, r5);
        if (r17 == null) goto L13;
        x r18 = new x("bdx_redirect_fetch");
        r18.f6023b = r10;
        JSONObject r19 = com.lynx.tasm.utils.d.k("res_url", r10);
        if (r11 != null) goto L11;
        r11 = "null";
    L11:
        r19.put("redirect_url", r11);
        r19.put("hit", r12 ? 1 : 0);
        r18.e = r19;
        JSONObject r20 = new JSONObject();
        r20.put("duration", r13);
        r18.f = r20;
        ((com.bytedance.ies.bullet.service.monitor.i) r17).d(r18);
        return;
    L13:
        return;
    L5:
        r15 = "错过";
        goto L6
    }
}
