package com.ss.android.lark.conditional.access.display;

import android.content.Context;
import android.util.Base64;
import com.bytedance.lark.pb.security.v1.CustomDisplayContent;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.commonmark.html.HtmlCompatMarkdownParser;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.coremd.base.parse.n;
import com.ss.android.lark.coremd.impl.parse.l;
import com.ss.android.lark.coremdbiz.facade.plugins.u;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.e0;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DisplayUtilsKt {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/conditional/access/display/DisplayUtilsKt$parseB64Extra$1", "Lcom/google/gson/reflect/TypeToken;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/conditional/access/display/DisplayUtilsKt$parseDisplayExtra$1", "Lcom/google/gson/reflect/TypeToken;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    public static final class c implements com.ss.android.lark.coremd.base.parse.g {
        public final /* synthetic */ Function1<n, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super n, Unit> r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void a(l.a r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
            this.a.invoke(r2);
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }
    }

    public static final class d implements com.ss.android.lark.commonmark.html.a {
        public d() {
        }

        @Override // com.ss.android.lark.commonmark.html.a
        public final s a(String r4, Map r5) {
            Intrinsics.checkNotNullParameter(r4, "tagName");
            Intrinsics.checkNotNullParameter(r5, "attributes");
            if (Intrinsics.areEqual(r4, SRStrategy.MEDIAINFO_KEY_BITRATE) == false) goto L7;
            return new v7b.h();
        L7:
            if (Intrinsics.areEqual(r4, "at") == false) goto L24;
            String r6 = (String) r5.get("data-user-name");
            String r7 = (String) r5.get("data-user-id");
            boolean r0 = true;
            if (r6 != null) goto L11;
        L14:
            boolean r2 = true;
        L15:
            if (r2 == true) goto L24;
            if (r7 != null) goto L18;
        L21:
            if (r0 == true) goto L24;
            return new eab.a(StringsKt.removePrefix(r6, "@"), r7);
        L18:
            if (r7.length() == 0) goto L21;
            r0 = false;
            goto L21
        L11:
            if (r6.length() == 0) goto L14;
            r2 = false;
        L24:
            return null;
        }
    }

    public static final Map<String, String> a(InternalSecurityAction r2) {
        if (r2 == null) goto L4;
        String r3 = r2.getCurrentAction().getParams().get("b64Extra");
        if (r3 != null) goto L8;
        r3 = BuildConfig.FLAVOR;
    L8:
        String r1 = new String(Base64.decode(r3, 0), Charsets.UTF_8);
        Gson r4 = e0.a;
        Map<String, String> r5 = (Map) e0.b(r1, new a().getType());
        if (r5 == null) goto L11;
        return r5;
    L11:
        return MapsKt.emptyMap();
    L4:
        return MapsKt.emptyMap();
    }

    public static final Map<String, String> b(InternalSecurityAction r1) {
        Intrinsics.checkNotNullParameter(r1, Keys.API_PARAM_KEY_ACTION);
        String r2 = r1.getCurrentAction().getParams().get("displayExtra");
        Gson r0 = e0.a;
        Map<String, String> r3 = (Map) e0.b(r2, new b().getType());
        if (r3 == null) goto L5;
        return r3;
    L5:
        return MapsKt.emptyMap();
    }

    public static final Integer c(InternalSecurityAction r3) {
        Object r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        String r4 = r3.getCurrentAction().getParams().get("b64Extra");
        if (r4 != null) goto L9;
        return null;
    L9:
        if (StringsKt.isBlank(r4) == false) goto L35;
        return null;
    L35:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        JsonElement r5 = JsonParser.parseString(new String(Base64.decode(r4, 0), Charsets.UTF_8)).getAsJsonObject().get("geoChallengeType");     // Catch: Throwable -> L27
        if (r5 != null) goto L15;
        return null;
    L15:
        if (r5.isJsonPrimitive() == false) goto L20;
        if (r5.getAsJsonPrimitive().isNumber() == false) goto L20;
        Integer r6 = Integer.valueOf(r5.getAsInt());     // Catch: Throwable -> L27
    L25:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r7) == true) goto L34;
        r0 = r7;
    L34:
        return (Integer) r0;
    L20:
        if (r5.isJsonPrimitive() == true) goto L22;
    L24:
        r6 = null;
        goto L25
    L22:
        if (r5.getAsJsonPrimitive().isString() == false) goto L24;
        r6 = StringsKt.toIntOrNull(r5.getAsString());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public static final String d(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "display");
        Intrinsics.checkNotNullParameter(r6, "extra");
        if (r6.isEmpty() == false) goto L5;
        return r5;
    L5:
        String r0 = UIHelper.mustacheFormat(r5, r6);
        Intrinsics.checkNotNull(r0);
        if (StringsKt.contains$default(r0, "{{", false, 2, null) == false) goto L8;
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModel", "replaceDisplayExtra remain {{}}, display: " + r5 + ", extra: " + r6 + ", result: " + r0);
        FileAuthMonitor.UpdateTrigger[] r7 = FileAuthMonitor.a;
        FileAuthMonitor.e(401, r0);
    L8:
        return r0;
    }

    public static final CustomDisplayTemplate e(CustomDisplayTemplate r14, InternalSecurityAction r15) {
        Intrinsics.checkNotNullParameter(r14, "originalTemplate");
        Intrinsics.checkNotNullParameter(r15, Keys.API_PARAM_KEY_ACTION);
        Map r0 = MapsKt.toMutableMap(b(r15));
        r0.putAll(a(r15));
        CustomDisplayTemplate.Builder r16 = r14.newBuilder().title(d(r14.title, r0)).text(d(r14.text, r0));
        String r1 = r14.richText;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        CustomDisplayTemplate.Builder r17 = r16.richText(d(r1, r0));
        String r2 = r14.sub_text;
        if (r2 != null) goto L8;
        r2 = BuildConfig.FLAVOR;
    L8:
        CustomDisplayTemplate.Builder r18 = r17.sub_text(d(r2, r0));
        List r3 = r14.content_list;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L27;
        CustomDisplayContent r6 = (CustomDisplayContent) r5.next();
        CustomDisplayContent.Builder r7 = r6.newBuilder().title(d(r6.title, r0)).text(d(r6.text, r0));
        String r8 = r6.richText;
        if (r8 != null) goto L14;
        r8 = BuildConfig.FLAVOR;
    L14:
        CustomDisplayContent.Builder r9 = r7.richText(d(r8, r0));
        List r10 = r6.handler_list;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L16:
        if (r12.hasNext() == false) goto L26;
        CustomDisplayHandler r13 = (CustomDisplayHandler) r12.next();
        CustomDisplayHandler.Builder r19 = r13.newBuilder().name(d(r13.name, r0));
        Map r110 = r13.link;
        LinkedHashMap r111 = new LinkedHashMap(MapsKt.mapCapacity(r110.size()));
        Iterator r112 = r110.entrySet().iterator();
    L19:
        if (r112.hasNext() == false) goto L21;
        Map.Entry r113 = (Map.Entry) r112.next();
        r111.put(r113.getKey(), d((String) r113.getValue(), r0));
        goto L19
    L21:
        CustomDisplayHandler.Builder r20 = r19.link(r111);
        Map r21 = r13.params;
        LinkedHashMap r114 = new LinkedHashMap(MapsKt.mapCapacity(r21.size()));
        Iterator r22 = r21.entrySet().iterator();
    L23:
        if (r22.hasNext() == false) goto L25;
        Map.Entry r115 = (Map.Entry) r22.next();
        r114.put(r115.getKey(), d((String) r115.getValue(), r0));
        goto L23
    L25:
        r11.add(r20.params(r114).build());
        goto L16
    L26:
        r4.add(r9.handler_list(r11).build());
        goto L10
    L27:
        CustomDisplayTemplate.Builder r116 = r18.content_list(r4);
        List r117 = r14.handler_list;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator r118 = r117.iterator();
    L29:
        if (r118.hasNext() == false) goto L39;
        CustomDisplayHandler r24 = (CustomDisplayHandler) r118.next();
        CustomDisplayHandler.Builder r25 = r24.newBuilder().name(d(r24.name, r0));
        Map r26 = r24.link;
        LinkedHashMap r27 = new LinkedHashMap(MapsKt.mapCapacity(r26.size()));
        Iterator r28 = r26.entrySet().iterator();
    L32:
        if (r28.hasNext() == false) goto L34;
        Map.Entry r29 = (Map.Entry) r28.next();
        r27.put(r29.getKey(), d((String) r29.getValue(), r0));
        goto L32
    L34:
        CustomDisplayHandler.Builder r30 = r25.link(r27);
        Map r31 = r24.params;
        LinkedHashMap r32 = new LinkedHashMap(MapsKt.mapCapacity(r31.size()));
        Iterator r33 = r31.entrySet().iterator();
    L36:
        if (r33.hasNext() == false) goto L38;
        Map.Entry r34 = (Map.Entry) r33.next();
        r32.put(r34.getKey(), d((String) r34.getValue(), r0));
        goto L36
    L38:
        r23.add(r30.params(r32).build());
        goto L29
    L39:
        CustomDisplayTemplate r119 = r116.handler_list(r23).build();
        Intrinsics.checkNotNull(r119);
        return r119;
    }

    public static /* synthetic */ CharSequence g(String r1, final Context r2) {
        return f(r1, r2, new DisplayUtilsKt$transRichText$1(r2));
    }

    public static final CharSequence f(String r4, Context r5, Function1<? super n, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "clickRegistry");
        boolean r0 = idb.f.a().isEnable("im.richtext.link.inline_render");
        t9b.a r1 = t9b.a.a;
        HtmlCompatMarkdownParser r2 = new HtmlCompatMarkdownParser();
        d r3 = new d();
        if (r2.a == r0) goto L5;
        r2.a = r0;
        r2.d = null;
    L5:
        r2.a(r3);
        s r7 = r2.b(r4);
        t9b.b r8 = t9b.b.a;
        com.ss.android.lark.coremd.impl.parse.b.a r9 = t9b.b.a(r5);
        t9b.e r10 = t9b.e.a;
        r9.c(com.ss.android.lark.coremdbiz.facade.a.a(DisplayUtilsKt$transRichText$2.INSTANCE));
        Intrinsics.checkNotNullParameter(t9b.d.a, "<this>");
        r9.e(u.a);
        r9.e(new c(r6));
        if (w4c.c.a().R() == false) goto L9;
        r9.b(new j());
    L9:
        return r9.d(r7);
    }
}
