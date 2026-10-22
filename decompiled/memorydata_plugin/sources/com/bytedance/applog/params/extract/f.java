package com.bytedance.applog.params.extract;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.log.q;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0002$%B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0017J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0017J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010#\u001a\u00020\u0017H\u0002R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/applog/params/extract/ParamsExtractManager;", "", "context", "Landroid/content/Context;", "maxCacheEntries", "", "overrideDao", "Lcom/bytedance/applog/params/extract/ParamsExtractDao;", "(Landroid/content/Context;ILcom/bytedance/applog/params/extract/ParamsExtractDao;)V", "appContext", "cache", "Lcom/bytedance/applog/params/extract/ParamsExtractCache;", "cacheHits", "", "cacheMisses", "dao", "dbHelper", "Lcom/bytedance/applog/params/extract/ParamsExtractDbHelper;", "appendCommonParamsId", "", TypedValues.AttributesType.S_TARGET, "Lorg/json/JSONObject;", OaidModel.KEY_ID, "", "cacheStats", "Lcom/bytedance/applog/params/extract/ParamsExtractManager$CacheStats;", "clearCommonParams", "clearHistorySessionData", "curSid", "createCommonParams", ObricMemoryConstants.KEY_SESSION_ID, "commonParams", "cpId", "fillCommonParams", "", "generateId", "CacheStats", "Companion", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1775a = null;
    private static final List<String> h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1776b;
    private final e c;
    private final c d;
    private final b e;
    private long f;
    private long g;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/applog/params/extract/ParamsExtractManager$Companion;", "", "()V", "TAG", "", "", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f1775a = new a(null);
        h = CollectionsKt.listOf("ParamsExtractManager");
    }

    public f(Context r3, int r4, c r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "context.applicationContext");
        Context r8 = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.f1776b = r8;
        e r0 = new e(r8);
        this.c = r0;
        if (r5 != null) goto L5;
        r5 = new c(r8, r0);
    L5:
        this.d = r5;
        this.e = new b(r4);
    }

    public final void a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "curSid");
        List<String> r2 = this.d.a(r9);     // Catch: Exception -> L5
    L22:
        int r3 = this.d.b(r9);     // Catch: Exception -> L9
    L24:
        Iterator<String> r4 = r2.iterator();     // Catch: Exception -> L16
    L13:
        if (r4.hasNext() == false) goto L18;
        this.e.b((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L16
    L18:
        q.a().b(h, "clearHistorySessionData currentSession=" + r9 + ", historyIdsSize: " + r2.size() + ", deleted=" + r3, new Object[0]);
        return;
    L16:
        e = move-exception;
        q.a().c(h, "cache remove ids by session failed", new Object[]{e});
    L9:
        e = move-exception;
        q.a().c(h, "deleteBySession failed", new Object[]{e});
        r3 = 0;
    L5:
        e = move-exception;
        q.a().c(h, "listIdsBySession failed for session=" + r9, new Object[]{e});
        r2 = CollectionsKt.emptyList();
        goto L22
    }

    public final void a(JSONObject r14) {
        Intrinsics.checkNotNullParameter(r14, TypedValues.AttributesType.S_TARGET);
        if (r14.optJSONArray("__applog_cp_ids") != null) goto L5;
        return;
    L5:
        List<String> r1 = com.bytedance.applog.params.extract.a.f1768a.a(r14);
        ArrayList r2 = new ArrayList(r1.size());
        ArrayList r3 = new ArrayList(r1.size());
        JSONArray r4 = new JSONArray();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        Iterator<String> r5 = r1.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        c.a r8 = this.e.a(r6);
        if (r8 != null) goto L12;
        r3.add(r6);
        this.g++;
        goto L9
    L12:
        r2.add(r8.a());
        r4.put(r6);
        this.f++;
    L15:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L62;
    L20:
        Map<String, JSONObject> r7 = MapsKt.emptyMap();
    L22:
        if ((!r7.isEmpty()) == false) goto L27;
        Iterator<Map.Entry<String, JSONObject>> r9 = r7.entrySet().iterator();
    L25:
        if (r9.hasNext() == false) goto L27;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin");
        this.e.a(r11, (JSONObject) ZeusTransformUtils.preCheckCast(r10.getValue(), JSONObject.class, "com.obric.memorydata.plugin"));
        r4.put(r11);
    L27:
        Iterator r13 = r2.iterator();
    L29:
        if (r13.hasNext() == false) goto L37;
        JSONObject r12 = (JSONObject) ZeusTransformUtils.preCheckCast(r13.next(), JSONObject.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.params.extract.a r15 = com.bytedance.applog.params.extract.a.f1768a;
        Intrinsics.checkNotNullExpressionValue(r12, "cp");
        Iterator<String> r16 = r15.b(r12).iterator();
    L32:
        if (r16.hasNext() == false) goto L29;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r17, "__applog_cp_ids") == true) goto L32;
        r14.remove(r17);     // Catch: Exception -> L52
        goto L32
    L37:
        Iterator<Map.Entry<String, JSONObject>> r18 = r7.entrySet().iterator();
    L39:
        if (r18.hasNext() == false) goto L60;
        Iterator<String> r19 = com.bytedance.applog.params.extract.a.f1768a.b((JSONObject) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), JSONObject.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r19.hasNext() == false) goto L39;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r20, "__applog_cp_ids") == true) goto L42;
        r14.remove(r20);     // Catch: Exception -> L53
        goto L42
    L60:
        if (r4.length() != 0) goto L50;
        r14.remove("__applog_cp_ids");     // Catch: Exception -> L54
    L59:
        return;
    L50:
        r14.put("__applog_cp_ids", r4);     // Catch: Exception -> L54
    L80:
        return;
    L62:
        r7 = this.d.a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        q.a().c(h, "clearCommonParams getByIds failed", new Object[]{e});
        goto L20
    }

    public final boolean b(JSONObject r18) {
        Intrinsics.checkNotNullParameter(r18, TypedValues.AttributesType.S_TARGET);
        List<String> r3 = com.bytedance.applog.params.extract.a.f1768a.a(r18);
        if (r3.isEmpty() == true) goto L67;
        ArrayList r6 = new ArrayList(r3.size());
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<String> r7 = r3.iterator();
    L8:
        if (r7.hasNext() == false) goto L14;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        c.a r9 = this.e.a(r8);
        if (r9 != null) goto L11;
        r0.add(r8);
        this.g++;
        goto L8
    L11:
        r6.add(r9.a());
        this.f++;
        goto L8
    L14:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L71;
    L19:
        Map<String, JSONObject> r1 = MapsKt.emptyMap();
    L20:
        Map<String, JSONObject> r10 = r1;
        if ((!r10.isEmpty()) == false) goto L26;
        Iterator<Map.Entry<String, JSONObject>> r2 = r10.entrySet().iterator();
    L24:
        if (r2.hasNext() == false) goto L26;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.e.a((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r11.getValue(), JSONObject.class, "com.obric.memorydata.plugin"));
    L26:
        Iterator r4 = r6.iterator();
    L28:
        if (r4.hasNext() == false) goto L40;
        JSONObject r12 = (JSONObject) ZeusTransformUtils.preCheckCast(r4.next(), JSONObject.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.params.extract.a r5 = com.bytedance.applog.params.extract.a.f1768a;
        Intrinsics.checkNotNullExpressionValue(r12, "cp");
        Iterator<String> r13 = r5.b(r12).iterator();
    L31:
        if (r13.hasNext() == false) goto L28;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r14, "__applog_cp_ids") == true) goto L31;
        if (r18.has(r14) == true) goto L31;
        r18.put(r14, r12.opt(r14));     // Catch: Exception -> L38
    L38:
        e = move-exception;
        q.a().c(h, "fillCommonParams put failed for key=" + r14, new Object[]{e});
        goto L31
    L40:
        Iterator<Map.Entry<String, JSONObject>> r15 = r10.entrySet().iterator();
    L42:
        if (r15.hasNext() == false) goto L65;
        JSONObject r16 = (JSONObject) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), JSONObject.class, "com.obric.memorydata.plugin");
        Iterator<String> r17 = com.bytedance.applog.params.extract.a.f1768a.b(r16).iterator();
    L45:
        if (r17.hasNext() == false) goto L42;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r19, "__applog_cp_ids") == true) goto L45;
        if (r18.has(r19) == true) goto L45;
        r18.put(r19, r16.opt(r19));     // Catch: Exception -> L52
    L52:
        e = move-exception;
        q.a().c(h, "fillCommonParams put failed for key=" + r19, new Object[]{e});
        goto L45
    L65:
        r18.remove("__applog_cp_ids");     // Catch: Exception -> L63
    L59:
        if ((r6.size() + r10.size()) != r3.size()) goto L62;
        return true;
    L62:
        return false;
    L71:
        r1 = this.d.a((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        q.a().c(h, "fillCommonParams getByIds failed", new Object[]{e});
        goto L19
    L67:
        r18.remove("__applog_cp_ids");     // Catch: Exception -> L64
    L5:
        return true;
    }
}
