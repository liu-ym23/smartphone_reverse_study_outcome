package com.bytedance.android.annie.business.latch;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.latch.LatchOptions;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.o;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.PrefetchType;
import com.bytedance.ies.argus.api.params.a0;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import y9.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieBusinessLatchScriptContentLoader implements LatchOptions.ScriptContentLoader {

    public static final class a {
    }

    static {
    }

    public AnnieBusinessLatchScriptContentLoader() {
    }

    public static boolean c(Response r10) {
        if (r10 != null) goto L5;
        return true;
    L5:
        Lazy r1 = ArgusGlobalDelegate.c;
        ArgusGlobalDelegate r11 = ArgusGlobalDelegate.a.a();
        if (r11 != null) goto L8;
        return true;
    L8:
        String r0 = r10.q.getGeckoModel().b;
        String r12 = r10.q.getGeckoModel().c;
        String r13 = r10.q.getUrl();
        ResourceFrom r14 = r10.w;
        ResourceFrom r15 = ResourceFrom.CDN;
        if (r14 == r15) goto L13;
        if (r10.u == r15) goto L13;
    L17:
        r13 = null;
    L19:
        return r11.a(new a0(r13, r0, r12, PrefetchType.Latch)).d();
    L13:
        if (StringsKt.startsWith$default(r13, "http://", false, 2, null) == true) goto L19;
        if (StringsKt.startsWith$default(r13, "https://", false, 2, null) == false) goto L17;
        goto L17
    }

    public final void a(Context r17, LatchOptions.ScriptContentLoader.a r18, Function2<? super String, ? super LatchOptions.ScriptContentLoader.Source, Unit> r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "input");
        Intrinsics.checkNotNullParameter(r19, "callback");
        HybridLogger r10 = HybridLogger.a;
        String r11 = null;
        HybridLogger.f("AnnieBusinessLatchService", "AnnieBusinessLatchScriptContentLoader load " + r18.a, null, 12);
        int r12 = h9.a.a;
        p.a r13 = h9.a.a(r18.a);
        HybridLogger.f("AnnieBusinessLatchService", "AnnieBusinessLatchScriptContentLoader res " + r13, null, 12);
        if ((r18 instanceof LatchOptions.ScriptContentLoader.a.a) == false) goto L26;
        LatchOptions.ScriptContentLoader.a.a r0 = (LatchOptions.ScriptContentLoader.a.a) r18;
        String r14 = ((LatchOptions.ScriptContentLoader.a) r0).a;
        Uri r15 = UriProtector.parse(r14);
        String r16 = r15.getPath();
        if (r16 == null) goto L24;
        HybridLogger.f("AnnieBusinessLatchService", "AnnieBusinessLatchScriptContentLoader loadInitScript...pageUrl: " + r14 + ", pagePath: " + r16, null, 12);
        if (StringsKt.endsWith$default(r16, "template.js", false, 2, null) == false) goto L22;
        if (r13 == null) goto L10;
        r11 = r13.a();
    L10:
        Uri.Builder r20 = r15.buildUpon();
        if (r11 != null) goto L13;
    L16:
        boolean r21 = true;
    L17:
        if (r21 == true) goto L19;
        String r22 = new URI(r16).resolve(r11).toString();
    L20:
        b(((LatchOptions.ScriptContentLoader.a) r0).a, r20.path(r22).build().toString(), r19, r13);
        return;
    L19:
        r22 = r16.substring(0, r16.length() - n.b(r14, r16).c.length()) + "latch.init.js";
        goto L20
    L13:
        if (r11.length() == 0) goto L16;
        r21 = false;
        goto L17
    L22:
        throw new IllegalStateException(("Unsupported page url: " + r14).toString());
    L24:
        throw new IllegalStateException(("No path in url: " + r14).toString());
    L26:
        if ((r18 instanceof LatchOptions.ScriptContentLoader.a.b) == false) goto L38;
        LatchOptions.ScriptContentLoader.a.b r1 = (LatchOptions.ScriptContentLoader.a.b) r18;
        Uri r23 = UriProtector.parse(((LatchOptions.ScriptContentLoader.a) r1).a);
        String r110 = r23.getPath();
        if (r110 == null) goto L36;
        HybridLogger.f("AnnieBusinessLatchService", "AnnieBusinessLatchScriptContentLoader loadPrefetchScript...pageUrl: " + ((LatchOptions.ScriptContentLoader.a) r1).a + ", pagePath: " + r110, null, 12);
        if (StringsKt.endsWith$default(r110, "template.js", false, 2, null) == false) goto L34;
        b(((LatchOptions.ScriptContentLoader.a) r1).a, r23.buildUpon().path(r110.substring(0, r110.length() - 11) + "prefetch.js").build().toString(), r19, r13);
        return;
    L34:
        throw new IllegalStateException(("Unsupported page url: " + ((LatchOptions.ScriptContentLoader.a) r1).a).toString());
    L36:
        throw new IllegalStateException(("No path in url: " + ((LatchOptions.ScriptContentLoader.a) r1).a).toString());
    L38:
        throw new NoWhenBranchMatchedException();
    }

    public static void b(String r10, String r11, Function2 r12, final p.a r13) {
        Function1<RequestParams, Unit> r1 = new AnnieBusinessLatchScriptContentLoader$loadScript$response$1(r13);
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.f("AnnieBusinessLatchService", "AnnieBusinessLatchScriptContentLoader loadScriptByForest...pageUrl: " + r10 + ", resourceUrl: " + r11, null, 12);
        com.bytedance.ies.bullet.forest.f r15 = ForestLoader.a;
        Forest r16 = ForestLoader.d();
        if (r16 == null) goto L10;
        RequestParams r17 = new RequestParams(Scene.LYNX_CHILD_RESOURCE);
        r1.invoke(r17);
        Uri r18 = UriProtector.parse(r10);
        if (n.i(Intrinsics.areEqual(UriProtector.getQueryParameter(r18, "lock_resource"), "1")) == false) goto L7;
        r17.x = UriProtector.getQueryParameter(r18, "forest_session_id");
    L7:
        r17.u = Boolean.valueOf(n.c(IHybridComponent.HybridType.LYNX));
        o r19 = r16.createSyncRequest(n.a(r11), r17);
        if (r19 == null) goto L10;
        Response r20 = r19.b();
    L12:
        if (r20 == null) goto L14;
        long r21 = r20.B;
    L16:
        if (r21 <= 0) goto L18;
        LatchOptions.ScriptContentLoader.Source r110 = LatchOptions.ScriptContentLoader.Source.OFFLINE;
    L53:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L45
        if (r20 == null) goto L23;
        InputStream r23 = r20.l();     // Catch: Throwable -> L45
    L25:
        if (r23 != null) goto L27;
        HybridLogger.f("AnnieBusinessLatchService", "Failed to load url: " + r11, null, 12);     // Catch: Throwable -> L45
        throw new IllegalArgumentException(("Failed to load latch.prefetch.js from forest by url: " + r11).toString());     // Catch: Throwable -> L45
    L27:
        if (c(r20) == false) goto L41;
        Reader r0 = new InputStreamReader(r23, Charsets.UTF_8);     // Catch: Throwable -> L45
        if ((r0 instanceof BufferedReader) == false) goto L32;
        BufferedReader r24 = (BufferedReader) r0;     // Catch: Throwable -> L45
    L54:
        String r25 = TextStreamsKt.readText(r24);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r24, null);     // Catch: Throwable -> L45
        r12.invoke(r25, r110);     // Catch: Throwable -> L45
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L48:
        if (Result.exceptionOrNull-impl(r26) == null) goto L56;
        HybridLogger r27 = HybridLogger.a;
        HybridLogger.i("AnnieBusinessLatchService", "exception in loading url: " + r11, null, 12);
        return;
    L56:
        return;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r24, th);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L32:
        r24 = new BufferedReader(r0, 8192);     // Catch: Throwable -> L45
        goto L54
    L41:
        HybridLogger.i("AnnieBusinessLatchService", "Failed to load url: " + r11, null, 12);     // Catch: Throwable -> L45
        throw new IllegalStateException(("Failed to load url: " + r11 + ", for security reason").toString());     // Catch: Throwable -> L45
    L23:
        r23 = null;
    L45:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L18:
        r110 = LatchOptions.ScriptContentLoader.Source.CDN;
        goto L53
    L14:
        r21 = 0;
    L10:
        r20 = null;
        goto L12
    }
}
