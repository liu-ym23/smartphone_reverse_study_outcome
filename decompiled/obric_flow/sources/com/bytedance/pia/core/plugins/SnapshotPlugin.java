package com.bytedance.pia.core.plugins;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.core.view.PointerIconCompat;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.k;
import com.bytedance.pia.core.utils.m;
import com.google.gson.Gson;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.p;
import dh.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ko.r;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import nh.c;
import nh.d;
import org.json.JSONObject;
import yg.b;
import ym.j;
import zh.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/pia/core/plugins/SnapshotPlugin;", "Lnh/c;", "Lnh/d;", "runtime", "Lyg/b;", "manifest", "<init>", "(Lnh/d;Lyg/b;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SnapshotPlugin extends c {
    public SnapshotPlugin(d r5, b r10) {
        Intrinsics.checkNotNullParameter(r5, "runtime");
        Intrinsics.checkNotNullParameter(r10, "manifest");
        super(r5);
    }

    @Override // nh.c
    public final f b(j r22, f r23) {
        Intrinsics.checkNotNullParameter(r22, "request");
        AtomicBoolean r5 = xh.b.f23150a;
        WebResourceRequest r10 = (WebResourceRequest) r22.f23302a;
        Uri r11 = r10.getUrl();
        if (r11 != null) goto L5;
        r11 = Uri.EMPTY;
    L5:
        Map<String, String> r12 = r10.getRequestHeaders();
        if (r23 == null) goto L8;
        WebResourceResponse r13 = com.bytedance.pia.core.utils.j.c(r23);
    L9:
        d r14 = this.f20236b;
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);
        if (xh.b.f23150a.get() == false) goto L124;
        Gson r15 = b.g;
        b r16 = com.lynx.tasm.utils.j.e(r11.toString(), r14);
        if (r16 == null) goto L124;
        if (r16.e != true) goto L124;
        r14.f20239j.a(PvEventType.f, 0);
        Lazy r17 = Settings.B;
        boolean r18 = p.a().t();
        kh.c r19 = r14.f20239j;
        if (r18 == true) goto L19;
        r19.b(PointerIconCompat.TYPE_ALIAS, "snapshot", "");
        goto L124
    L19:
        if (r13 == null) goto L140;
        Object r20 = r13;
    L34:
        if (r20 != null) goto L36;
        com.bytedance.pia.core.utils.j.y("[SnapShot] SnapShot response is null, return super response", null);
        r19.b(PointerIconCompat.TYPE_NO_DROP, "snapshot", "");
        goto L124
    L36:
        Keva r21 = zh.b.f23447a;
        Intrinsics.checkNotNullParameter(r11, "url");
        String r24 = com.bytedance.pia.core.utils.j.u(r11);
        Keva r25 = zh.b.f23447a;
        if (r25.contains(r24) == true) goto L39;
    L38:
        a r26 = null;
    L75:
        if (r26 != null) goto L77;
        r19.b(PointerIconCompat.TYPE_ALL_SCROLL, "snapshot", "");
        goto L124
    L77:
        r13 = (WebResourceResponse) r20;
        InputStream r27 = r13.getData();
        if (r27 == null) goto L80;
        InputStreamReader r110 = new InputStreamReader(r27, Charsets.UTF_8);
    L81:
        BufferedReader r28 = new BufferedReader(r110);
        String r29 = TextStreamsKt.readText(r28);     // Catch: Throwable -> L118
        CloseableKt.closeFinally(r28, null);
        Pattern r30 = Pattern.compile("<meta name=\"pia-snapshot\" content=\"(.*?)\">", 0);
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L88
        Matcher r32 = r30.matcher(r29);     // Catch: Throwable -> L88
        if (r32.find() == false) goto L90;
        String r33 = new JSONObject(URLDecoder.decode(r32.group(1))).get("v").toString();     // Catch: Throwable -> L88
    L95:
        long r111 = System.currentTimeMillis();
    L101:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Object r35 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L108:
        if (Result.m130isFailureimpl(r35) == false) goto L110;
        r35 = null;
    L110:
        a r36 = (a) r35;
        if (r36 != null) goto L113;
        r19.b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, "snapshot", "");
        goto L124
    L113:
        com.bytedance.pia.core.utils.j.y("[SnapShot] snapshot match,snapshot=" + r36, null);
        String r37 = StringsKt.H(StringsKt.H(r29, "<!-- __PIA__SNAPSHOT__ -->", r36.f23446c), "<!-- __PIA__SNAPSHOT__HEAD__ -->", r36.d);
        Charset r38 = Charsets.UTF_8;
        if (r37 == null) goto L117;
        r13.setData(new ByteArrayInputStream(r37.getBytes(r38)));
        ((Handler) m.f7156b.getValue()).post(xh.a.f23148c);
        r19.a(PvEventType.f, 1);
        goto L124
    L117:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L97:
        if (Intrinsics.areEqual(r26.e, String.valueOf(r33)) == true) goto L99;
    L103:
        r26 = null;
    L104:
        r35 = Result.m124constructorimpl(r26);     // Catch: Throwable -> L101
        goto L108
    L99:
        if (r26.g <= r111) goto L103;
    L90:
        r33 = null;
    L88:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Object r40 = Result.m124constructorimpl(ResultKt.createFailure(th));
        if (Result.m130isFailureimpl(r40) == false) goto L94;
        r40 = null;
    L94:
        r33 = (String) r40;
    L118:
        th = move-exception;
        throw th;     // Catch: Throwable -> L121
    L121:
        th = move-exception;
        CloseableKt.closeFinally(r28, th);
        throw th;
    L80:
        r110 = null;
        goto L81
    L39:
        String[] r112 = r25.getStringArray(r24, null);
        if (r112 != null) goto L43;
        zh.b.e(r24);
        goto L38
    L43:
        if (r112.length != 0) goto L45;
        String r41 = r24;
    L46:
        int r113 = r112.length;
        String r114 = r41;
        int r42 = 0;
    L47:
        if (r42 >= r113) goto L55;
        String r115 = r112[r42];
        if (r11.getQueryParameter(r115) == null) goto L38;
        String r116 = r114 + r115 + '=' + r11.getQueryParameter(r115);
        if (r42 >= (r112.length - 1)) goto L54;
        r116 = r116 + Typography.amp;
    L54:
        r114 = r116;
        r42 = r42 + 1;
        goto L47
    L55:
        Keva r43 = zh.b.c(r24);
        if (r43 == null) goto L38;
        if (r43.contains(r114) == false) goto L38;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L61
        Object r45 = Result.m124constructorimpl(new JSONObject(r43.getString(r114, "")));     // Catch: Throwable -> L61
    L64:
        if (Result.m127exceptionOrNullimpl(r45) != null) goto L74;
        JSONObject r46 = (JSONObject) r45;
        String r47 = r46.getString("content_UUID");
        long r117 = r46.getLong("expire_time");
        String r118 = r46.getString("snapshot_version");
        int r119 = r46.getInt("protocol_version");
        Keva r120 = zh.b.f23448b;
        Object r48 = Result.m124constructorimpl(new JSONObject(r120.getString(r47, "")));     // Catch: Throwable -> L68
    L71:
        if (Result.m127exceptionOrNullimpl(r48) != null) goto L73;
        JSONObject r49 = (JSONObject) r48;
        r26 = new a(r114, r112, r49.optString("content"), r49.optString("head"), r118, r119, r117);
        goto L75
    L73:
        r120.erase(r47);
        r43.erase(r114);
    L68:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r48 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L71
    L74:
        r43.erase(r114);
    L61:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r45 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L64
    L45:
        r41 = r24.concat("?");
        goto L46
    L140:
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L23
        f r52 = r14.f20240k.b(LoadFrom.f6956b, new r(17, r11, r12));     // Catch: Throwable -> L23
        if (r52 == null) goto L25;
        WebResourceResponse r53 = com.bytedance.pia.core.utils.j.c(r52);     // Catch: Throwable -> L23
    L26:
        Object r54 = Result.m124constructorimpl(r53);     // Catch: Throwable -> L23
    L30:
        if (Result.m130isFailureimpl(r54) == false) goto L32;
        r20 = null;
        goto L34
    L32:
        r20 = r54;
        goto L34
    L25:
        r53 = null;
    L23:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r54 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L124:
        if (r13 == null) goto L127;
        LoadFrom r56 = LoadFrom.f6957c;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r56, "from");
        return new k(r13);
    L127:
        return null;
    L8:
        r13 = null;
        goto L9
    }

    @Override // nh.c
    public final String c() {
        return "snapshot";
    }

    @Override // nh.c
    public final void f() {
        AtomicBoolean r5 = xh.b.f23150a;
        Intrinsics.checkNotNullParameter(d.E, "context");
        ((Handler) m.f7156b.getValue()).post(xh.a.f23147b);
    }
}
