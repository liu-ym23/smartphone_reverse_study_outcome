package com.obric.memorydata.memory;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalPrivacySanitizer;", "", "<init>", "()V", "sanitize", "", "event", "Lorg/json/JSONObject;", "sanitizeObject", EventBody.KEY_VALUE, "inheritedRedacted", "", "sanitizeArray", "Lorg/json/JSONArray;", "isSensitiveTextKey", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10299a = null;

    static {
        f10299a = new m();
    }

    private m() {
    }

    private final void a(JSONArray r6, boolean r7) {
        int r0 = r6.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Object r2 = r6.opt(r1);
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L8;
        a((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin"), r7);
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == false) goto L10;
        a((JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin"), r7);
        goto L10
    }

    private final void a(JSONObject r5, boolean r6) {
        boolean r4 = false;
        if (r6 == false) goto L5;
    L6:
        r4 = true;
    L7:
        ArrayList r7 = new ArrayList();
        Iterator<String> r0 = r5.keys();
    L9:
        if (r0.hasNext() == false) goto L11;
        ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).add(r0.next());
        goto L9
    L11:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r8.hasNext() == false) goto L25;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L19;
        if (f10299a.a(r1) == false) goto L19;
        r5.remove(r1);
    L19:
        Object r2 = r5.opt(r1);
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == false) goto L13;
        f10299a.a((JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin"), r4);
        goto L13
    L21:
        f10299a.a((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin"), r4);
        goto L13
    L25:
        return;
    L5:
        if (r5.optBoolean("contentRedacted", false) == false) goto L7;
        goto L6
    }

    private final boolean a(String r4) {
        if (Intrinsics.areEqual(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT) == false) goto L5;
    L10:
        return true;
    L5:
        if (StringsKt.endsWith$default(r4, "Text", false, 2, null) == true) goto L10;
        if (Intrinsics.areEqual(r4, "contentDescription") == true) goto L10;
        if (Intrinsics.areEqual(r4, "stateDescription") == true) goto L10;
        return false;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        a(r2, false);
    }
}
