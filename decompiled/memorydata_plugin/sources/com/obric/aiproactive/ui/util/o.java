package com.obric.aiproactive.ui.util;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/ui/util/SourcePackageParser;", "", "<init>", "()V", "extract", "", "", "actionContext", "readArray", "", "out", "", "array", "Lorg/json/JSONArray;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f6895a = null;

    static {
        f6895a = new o();
    }

    private o() {
    }

    private final void a(Set<String> r7, JSONArray r8) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        int r9 = 0;
        int r1 = r8.length();
    L6:
        if (r9 >= r1) goto L17;
        Object r2 = r8.opt(r9);
        if (r2 == null) goto L16;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L14;
    L12:
        r6.add(r2);
        goto L16
    L14:
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L16;
        String r3 = ((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin")).optString(ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullExpressionValue(r3, "optString(...)");
        r6.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        String r4 = ((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin")).optString("package");
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        r6.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        String r5 = ((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin")).optString("pkg");
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L16:
        r9 = r9 + 1;
        goto L6
    L17:
        final $$Lambda$o$TG9hZ77mrgu89sGfUneuEv5Ioco r10 = $$Lambda$o$TG9hZ77mrgu89sGfUneuEv5Ioco.INSTANCE;
        r6.removeIf(new $$Lambda$o$6lNM4fHzfA4aUXl7EsyXTKz_jPw(r10));
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ boolean lambda$6lNM4fHzfA4aUXl7EsyXTKz_jPw(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$TG9hZ77mrgu89sGfUneuEv5Ioco(String r0) {
        return b(r0);
    }

    public final List<String> a(String r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.startsWith$default(r7, "{", false, 2, null) == false) goto L15;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        o r5 = (o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        JSONObject r3 = new JSONObject(r7);     // Catch: Throwable -> L18
        LinkedHashSet r8 = new LinkedHashSet();     // Catch: Throwable -> L18
        r5.a((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin"), r3.optJSONArray("sources"));     // Catch: Throwable -> L18
        r5.a((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin"), r3.optJSONArray("sourcePackages"));     // Catch: Throwable -> L18
        r5.a((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin"), r3.optJSONArray("packages"));     // Catch: Throwable -> L18
        Object r9 = Result.m1421constructorimpl(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L18
    L20:
        List r10 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r9) == false) goto L24;
        r9 = r10;
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    L15:
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
