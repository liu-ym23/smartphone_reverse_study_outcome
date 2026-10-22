package com.bytedance.android.annie.lynx.service.latch;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.latch.LatchOptions;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Url;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LatchScriptContentLoader implements LatchOptions.ScriptContentLoader {
    public final Lazy a;
    public final Lazy b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/lynx/service/latch/LatchScriptContentLoader$ILatchRetrofitApi;", "", "get", "Lcom/bytedance/retrofit2/Call;", "", com.bytedance.android.ec.core.event.a.KEY_URL, "annie-lynx_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public interface ILatchRetrofitApi {
        @GET
        Call<String> get(@Url String r1);
    }

    public static final class a {
    }

    static {
    }

    public LatchScriptContentLoader() {
        this.a = LazyKt.lazy(LatchScriptContentLoader$loader$2.INSTANCE);
        this.b = LazyKt.lazy(LatchScriptContentLoader$api$2.INSTANCE);
    }

    public static String b(final String r10) {
        Matcher r0 = (Matcher) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(AnnieConfigSettingKeys.LIVE_OFFLINE_PATTERNS.a()), new LatchScriptContentLoader$extractChannel$1(r10)), LatchScriptContentLoader$extractChannel$2.INSTANCE));
        if (r0 == null) goto L31;
        int r1 = StringsKt.indexOf$default(r10, "?", 0, false, 6, null);
        int r11 = StringsKt.indexOf$default(r10, "#", 0, false, 6, null);
        Integer r12 = Integer.valueOf(RangesKt.coerceAtMost(r1, r11));
        if (r12.intValue() < 0) goto L7;
        boolean r13 = true;
    L9:
        if (r13 == true) goto L12;
        r12 = null;
    L12:
        if (r12 == null) goto L14;
        int r14 = r12.intValue();
    L16:
        if (r14 == (-1)) goto L22;
        int r15 = r0.end();
        if (r10 == null) goto L21;
        String r16 = r10.substring(r15, r14);
    L25:
        String r17 = StringsKt.substringBefore$default(StringsKt.trim(r16, new char[]{'/'}), '/', null, 2, null);
        if (r17 == null) goto L31;
        return r17;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L22:
        int r18 = r0.end();
        if (r10 == null) goto L29;
        r16 = r10.substring(r18);
        goto L25
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L14:
        r14 = RangesKt.coerceAtLeast(r1, r11);
        goto L16
    L7:
        r13 = false;
    L31:
        throw new IllegalStateException(("Failed to extract channel from url: " + r10).toString());
    }

    public static com.bytedance.android.annie.service.resource.i c(String r10, String r11, Function1 r12) {
        RequestConfig r0 = new RequestConfig(AnnieResType.LYNX_CHILD_RESOURCE);
        r12.invoke(r0);
        Uri r13 = UriProtector.parse(r10);
        if (com.bytedance.android.annie.resource.n.i(Intrinsics.areEqual(UriProtector.getQueryParameter(r13, "lock_resource"), "1")) == false) goto L5;
        r0.h = UriProtector.getQueryParameter(r13, "forest_session_id");
    L5:
        r0.c = com.bytedance.android.annie.resource.n.c(IHybridComponent.HybridType.LYNX);
        com.bytedance.android.annie.service.resource.h r14 = com.bytedance.android.annie.resource.n.h(r11, r0);
        if (r14 != null) goto L10;
        return null;
    L10:
        return r14.b();
    }

    public final void a(Context r24, LatchOptions.ScriptContentLoader.a r25, Function2<? super String, ? super LatchOptions.ScriptContentLoader.Source, Unit> r26) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "input");
        Intrinsics.checkNotNullParameter(r26, "callback");
        int r10 = h9.a.a;
        final y9.p.a r11 = h9.a.a(r25.a);
        if ((r25 instanceof LatchOptions.ScriptContentLoader.a.a) == false) goto L132;
        LatchOptions.ScriptContentLoader.a.a r12 = (LatchOptions.ScriptContentLoader.a.a) r25;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(b(((LatchOptions.ScriptContentLoader.a) r12).a));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        String r13 = (String) r1;
        if (r13 != null) goto L15;
        String r27 = "";
    L17:
        if (AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue() == false) goto L19;
        String r14 = r27;
        String r15 = ((LatchOptions.ScriptContentLoader.a) r12).a;
        Uri r16 = UriProtector.parse(r15);
        if (r11 != null) goto L48;
    L50:
        boolean r17 = false;
    L51:
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        LatchOptions.ScriptContentLoader.Source r19 = LatchOptions.ScriptContentLoader.Source.OFFLINE;
        r18.element = r19;
        if (r17 == false) goto L54;
    L92:
        String r20 = r16.getPath();
        if (r20 == null) goto L130;
        if (StringsKt.endsWith$default(r20, "template.js", false, 2, null) == false) goto L128;
        if (r11 == null) goto L98;
        String r21 = r11.a();
    L99:
        String r22 = d(r16, r15, r20, r21);
        com.bytedance.android.annie.service.resource.i r23 = c(((LatchOptions.ScriptContentLoader.a) r12).a, r22, new LatchScriptContentLoader$loadInitScript$inputStream$resource$1(r11));
        if (r23 == null) goto L102;
        long r110 = r23.f;
        long r28 = 0;
    L104:
        if (r110 > r28) goto L107;
        r19 = LatchOptions.ScriptContentLoader.Source.CDN;
    L107:
        r18.element = r19;
        if (r23 == null) goto L110;
        InputStream r29 = r23.c();
    L111:
        if (r29 == null) goto L126;
        InputStream r30 = r29;
    L113:
        Reader r31 = new InputStreamReader(r30, Charsets.UTF_8);
        if ((r31 instanceof BufferedReader) == false) goto L116;
        BufferedReader r32 = (BufferedReader) r31;
    L211:
        String r33 = TextStreamsKt.readText(r32);     // Catch: Throwable -> L119
        CloseableKt.closeFinally(r32, null);
        r26.invoke(r33, r18.element);
        return;
    L119:
        th = move-exception;
        throw th;     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        CloseableKt.closeFinally(r32, th);
        throw th;
    L116:
        r32 = new BufferedReader(r31, 8192);
        goto L211
    L126:
        throw new IllegalArgumentException("Failed to load latch.init.js from forest by url: ".concat(r22).toString());
    L110:
        r29 = null;
        goto L111
    L102:
        r28 = 0;
        r110 = 0;
        goto L104
    L98:
        r21 = null;
        goto L99
    L128:
        throw new IllegalStateException(("Unsupported page url: " + r15).toString());
    L130:
        throw new IllegalStateException(("No path in url: " + r15).toString());
    L54:
        if (com.bytedance.android.annie.resource.n.j(r15, IHybridComponent.HybridType.LYNX, UriProtector.getQueryParameter(r16, "loader_name")) == true) goto L92;
        com.bytedance.android.annie.service.prefetch.b r34 = (com.bytedance.android.annie.service.prefetch.b) this.a.getValue();
        r34.getClass();
        Intrinsics.checkNotNullParameter("latch.init.js", "relativePath");
        Intrinsics.checkNotNullParameter(r14, "channel");
        Object r35 = Result.constructor-impl(((qv5.b) r34.a.getValue()).getInputStream(r14.concat("/latch.init.js")));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r35) == false) goto L64;
        r35 = null;
    L64:
        r30 = (InputStream) r35;
        if (r30 != null) goto L88;
        if (r11 != null) goto L68;
    L70:
        boolean r210 = false;
    L71:
        if (r210 == false) goto L88;
        String r36 = r16.getPath();
        if (r36 == null) goto L87;
        if (StringsKt.endsWith$default(r36, "template.js", false, 2, null) == false) goto L85;
        com.bytedance.android.annie.service.resource.i r37 = c(((LatchOptions.ScriptContentLoader.a) r12).a, d(r16, r15, r36, r11.a()), new LatchScriptContentLoader$loadInitScript$inputStream$4(r18));
        if (r37 == null) goto L79;
        r30 = r37.c();
    L80:
        if (r30 != null) goto L113;
        throw new IllegalArgumentException("Required value was null.".toString());
    L79:
        r30 = null;
        goto L80
    L85:
        throw new IllegalStateException(("Unsupported page url: " + r15).toString());
    L87:
        throw new IllegalStateException(("No path in url: " + r15).toString());
    L68:
        if (r11.b() != 1) goto L70;
        r210 = true;
    L88:
        if (r30 != null) goto L113;
        throw new IllegalArgumentException("Failed to load latch.init.js from channel: ".concat(r14).toString());
    L59:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L48:
        if (r11.b() != 2) goto L50;
        r17 = true;
        goto L51
    L19:
        if (r27.length() != 0) goto L21;
        boolean r39 = true;
    L23:
        if (r39 == false) goto L39;
        String r40 = ((LatchOptions.ScriptContentLoader.a) r12).a;
        int r41 = StringsKt.lastIndexOf$default(r40, "pages", 0, false, 6, null);
        if (r41 <= (-1)) goto L31;
        StringBuilder r42 = new StringBuilder();
        if (r40 == null) goto L30;
        r42.append(r40.substring(0, r41));
        r42.append("latch.init.js");
        String r43 = r42.toString();
    L42:
        r26.invoke(((ILatchRetrofitApi) this.b.getValue()).get(r43).execute().body(), LatchOptions.ScriptContentLoader.Source.CDN);
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L31:
        int r44 = StringsKt.lastIndexOf$default(r40, "template.js", 0, false, 6, null) - 1;
        if (r40 == null) goto L38;
        String r45 = (String) CollectionsKt.lastOrNull(StringsKt.split$default(r40.substring(0, r44), new String[]{"/"}, false, 0, 6, null));
        if (r45 != null) goto L36;
        r45 = "";
    L36:
        r43 = StringsKt.replace$default(((LatchOptions.ScriptContentLoader.a) r12).a, r45.concat("/template.js"), "latch.init.js", false, 4, null);
        goto L42
    L38:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L39:
        int r46 = StringsKt.lastIndexOf$default(((LatchOptions.ScriptContentLoader.a) r12).a, r27, 0, false, 6, null);
        StringBuilder r47 = new StringBuilder();
        String r48 = ((LatchOptions.ScriptContentLoader.a) r12).a;
        if (r48 == null) goto L44;
        r47.append(r48.substring(0, r46));
        r47.append(r27);
        r47.append("/latch.init.js");
        r43 = r47.toString();
        goto L42
    L44:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        r39 = false;
        goto L23
    L15:
        r27 = r13;
    L7:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L132:
        if ((r25 instanceof LatchOptions.ScriptContentLoader.a.b) == false) goto L208;
        LatchOptions.ScriptContentLoader.a.b r49 = (LatchOptions.ScriptContentLoader.a.b) r25;
        Uri r50 = UriProtector.parse(((LatchOptions.ScriptContentLoader.a) r49).a);
        String r51 = r50.getPath();
        if (r51 == null) goto L206;
        if (StringsKt.endsWith$default(r51, "template.js", false, 2, null) == false) goto L204;
        String r52 = r50.buildUpon().path(r51.substring(0, r51.length() - 11) + "prefetch.js").build().toString();
        if (AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue() == true) goto L140;
        r26.invoke(((ILatchRetrofitApi) this.b.getValue()).get(r52).execute().body(), LatchOptions.ScriptContentLoader.Source.CDN);
        return;
    L140:
        String r53 = ((LatchOptions.ScriptContentLoader.a) r49).a;
        if (r11 != null) goto L143;
    L145:
        boolean r54 = false;
    L146:
        final Ref.ObjectRef r55 = new Ref.ObjectRef();
        LatchOptions.ScriptContentLoader.Source r112 = LatchOptions.ScriptContentLoader.Source.OFFLINE;
        r55.element = r112;
        if (r54 == false) goto L149;
    L174:
        com.bytedance.android.annie.service.resource.i r56 = c(((LatchOptions.ScriptContentLoader.a) r49).a, r52, new LatchScriptContentLoader$loadPrefetchScript$inputStream$resource$1(r11));
        if (r56 == null) goto L177;
        long r113 = r56.f;
        long r57 = 0;
    L179:
        if (r113 > r57) goto L182;
        r112 = LatchOptions.ScriptContentLoader.Source.CDN;
    L182:
        r55.element = r112;
        if (r56 == null) goto L185;
        InputStream r58 = r56.c();
    L186:
        if (r58 == null) goto L202;
        InputStream r59 = r58;
    L188:
        Reader r60 = new InputStreamReader(r59, Charsets.UTF_8);
        if ((r60 instanceof BufferedReader) == false) goto L191;
        BufferedReader r61 = (BufferedReader) r60;
    L217:
        String r62 = TextStreamsKt.readText(r61);     // Catch: Throwable -> L195
        CloseableKt.closeFinally(r61, null);
        r26.invoke(r62, r55.element);
        return;
    L195:
        th = move-exception;
        throw th;     // Catch: Throwable -> L198
    L198:
        th = move-exception;
        CloseableKt.closeFinally(r61, th);
        throw th;
    L191:
        r61 = new BufferedReader(r60, 8192);
        goto L217
    L202:
        throw new IllegalArgumentException("Failed to load latch.prefetch.js from forest by url: ".concat(r52).toString());
    L185:
        r58 = null;
        goto L186
    L177:
        r57 = 0;
        r113 = 0;
        goto L179
    L149:
        if (com.bytedance.android.annie.resource.n.j(r53, IHybridComponent.HybridType.LYNX, UriProtector.getQueryParameter(UriProtector.parse(r53), "loader_name")) == true) goto L174;
        WebResourceResponse r63 = com.bytedance.android.annie.service.resource.a.a.j(r52);
        if (r63 == null) goto L154;
        r59 = r63.getData();
    L155:
        if (r59 != null) goto L170;
        if (r11 != null) goto L158;
    L160:
        boolean r114 = false;
    L161:
        if (r114 == false) goto L170;
        com.bytedance.android.annie.service.resource.i r64 = c(((LatchOptions.ScriptContentLoader.a) r49).a, r52, new LatchScriptContentLoader$loadPrefetchScript$inputStream$2(r55));
        if (r64 == null) goto L165;
        InputStream r65 = r64.c();
    L166:
        if (r65 == null) goto L169;
        r59 = r65;
        goto L188
    L169:
        throw new IllegalArgumentException("Required value was null.".toString());
    L165:
        r65 = null;
        goto L166
    L158:
        if (r11.b() != 1) goto L160;
        r114 = true;
    L170:
        if (r59 != null) goto L188;
        throw new IllegalArgumentException("Failed to load prefetch.js from url: ".concat(r52).toString());
    L154:
        r59 = null;
        goto L155
    L143:
        if (r11.b() != 2) goto L145;
        r54 = true;
        goto L146
    L204:
        throw new IllegalStateException(("Unsupported page url: " + ((LatchOptions.ScriptContentLoader.a) r49).a).toString());
    L206:
        throw new IllegalStateException(("No path in url: " + ((LatchOptions.ScriptContentLoader.a) r49).a).toString());
    L208:
        throw new NoWhenBranchMatchedException();
    }

    public final String d(Uri r10, String r11, String r12, String r13) {
        Uri.Builder r14 = r10.buildUpon();
        if (r13 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        String r15 = new URI(r12).resolve(r13).toString();
    L13:
        return r14.path(r15).build().toString();
    L11:
        r15 = r12.substring(0, r12.length() - com.bytedance.android.annie.resource.n.b(r11, r12).c.length()) + "latch.init.js";
        goto L13
    L5:
        if (r13.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
