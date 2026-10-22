package com.bytedance.applog.params.extract;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/applog/params/extract/JsonUtils;", "", "()V", "KEY_CP_IDS", "", "extractCpIds", "", TypedValues.AttributesType.S_TARGET, "Lorg/json/JSONObject;", "keysOf", "Lkotlin/sequences/Sequence;", "obj", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1768a = null;

    static {
        f1768a = new a();
    }

    private a() {
    }

    public final List<String> a(JSONObject r7) {
        if (r7 == null) goto L4;
        JSONArray r6 = r7.optJSONArray("__applog_cp_ids");
        if (r6 == null) goto L8;
        ArrayList r8 = new ArrayList(r6.length());
        int r0 = r6.length();
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L22;
        Object r4 = r6.opt(r2);
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L20;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L20;
        r8.add(r4);
        goto L20
    L17:
        r3 = false;
    L20:
        r2 = r2 + 1;
        goto L11
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L8:
        return CollectionsKt.emptyList();
    L4:
        return CollectionsKt.emptyList();
    }

    public final Sequence<String> b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "obj");
        return SequencesKt.sequence((Function2) ZeusTransformUtils.preCheckCast(new JsonUtils$keysOf$1(r2, null), Function2.class, "com.obric.memorydata.plugin"));
    }
}
