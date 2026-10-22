package com.obric.memorydata.personalcontext.search;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\bJ\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u0007J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/AssistantSearchDomainSwitchStatus;", "", "<init>", "()V", "TAG", "", "SWITCH_KEY_TO_DOMAIN_MAP", "", "", "MEMORY_ENTITY_SWITCH_TO_ENTITY_TYPE_MAP", "", "SWITCH_KEY_TO_ENTITY_TYPE_MAP", "getSwitchStatusOffDomains", "getSwitchStatusOffMemoryEntityTypes", "getSwitchStatusOfEntityTypes", "", "queryAssistantSwitchStatus", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12274a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Set<String>, Set<String>> f12275b = null;
    private static final Map<String, Set<Integer>> c = null;
    private static final Map<String, Set<Integer>> d = null;

    static {
        f12274a = new a();
        f12275b = MapsKt.mapOf(new Pair[]{TuplesKt.to(SetsKt.setOf("contacts"), SetsKt.setOf("Contact")), TuplesKt.to(SetsKt.setOf("call_logs"), SetsKt.setOf("CallHistory")), TuplesKt.to(SetsKt.setOf("message"), SetsKt.setOf("Sms")), TuplesKt.to(SetsKt.setOf("clock"), SetsKt.setOf("Alarm")), TuplesKt.to(SetsKt.setOf("notes"), SetsKt.setOf(i.H)), TuplesKt.to(SetsKt.setOf("album"), SetsKt.setOf(new String[]{"Photo", "Album"})), TuplesKt.to(SetsKt.setOf("record"), SetsKt.setOf("Recording")), TuplesKt.to(SetsKt.setOf("file_management"), SetsKt.setOf("File")), TuplesKt.to(SetsKt.setOf("calendar"), SetsKt.setOf("Schedule")), TuplesKt.to(SetsKt.setOf(new String[]{"collection_memory", "personal_info_memory"}), SetsKt.setOf("Memory")), TuplesKt.to(SetsKt.setOf("screen_memory"), SetsKt.setOf("RecMemory")), TuplesKt.to(SetsKt.setOf("hearing_memory"), SetsKt.setOf("AuditoryRecording")), TuplesKt.to(SetsKt.setOf("ai_diary"), SetsKt.setOf("LifeLog")), TuplesKt.to(SetsKt.setOf("global_memory"), SetsKt.setOf(new String[]{"Memory", "RecMemory", "AuditoryRecording", "AutoMemoryPro"}))});
        Integer r12 = Integer.valueOf(EntityType.MEMORY_COLLECT_CONTENT);
        Integer r13 = Integer.valueOf(EntityType.MEMORY_COLLECT_STORE);
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("collection_memory", SetsKt.setOf(new Integer[]{r12, r13, 10001, 10002, 10004, 10003, 10006, Integer.valueOf(EntityType.MEMORY_EVENT_SCHEDULE), Integer.valueOf(EntityType.MEMORY_EVENT_TODO), 10005, Integer.valueOf(EntityType.MEMORY_COMMON_TEXT)})), TuplesKt.to("personal_info_memory", SetsKt.setOf(new Integer[]{Integer.valueOf(EntityType.MEMORY_INFO_DOCUMENTS), Integer.valueOf(EntityType.MEMORY_INFO_ADDRESS), Integer.valueOf(EntityType.MEMORY_INFO_ANNIVERSARY), Integer.valueOf(EntityType.MEMORY_INFO_RELATIONSHIP), Integer.valueOf(EntityType.MEMORY_INFO_COMMON)})), TuplesKt.to("global_memory", SetsKt.setOf(new Integer[]{r12, r13, 10005, Integer.valueOf(EntityType.MEMORY_COMMON_TEXT), 10001, 10002, 10004, 10003, 10006, Integer.valueOf(EntityType.MEMORY_EVENT_SCHEDULE), Integer.valueOf(EntityType.MEMORY_EVENT_TODO), Integer.valueOf(EntityType.MEMORY_INFO_DOCUMENTS), Integer.valueOf(EntityType.MEMORY_INFO_ADDRESS), Integer.valueOf(EntityType.MEMORY_INFO_ANNIVERSARY), Integer.valueOf(EntityType.MEMORY_INFO_RELATIONSHIP), Integer.valueOf(EntityType.MEMORY_INFO_COMMON)}))});
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to("contacts", SetsKt.setOf(201)), TuplesKt.to("call_logs", SetsKt.setOf(202)), TuplesKt.to("message", SetsKt.setOf(101)), TuplesKt.to("clock", SetsKt.setOf(701)), TuplesKt.to("notes", SetsKt.setOf(601)), TuplesKt.to("album", SetsKt.setOf(new Integer[]{301, 302})), TuplesKt.to("record", SetsKt.setOf(501)), TuplesKt.to("file_management", SetsKt.setOf(Integer.valueOf(EntityType.FILE))), TuplesKt.to("calendar", SetsKt.setOf(401)), TuplesKt.to("collection_memory", SetsKt.setOf(new Integer[]{r12, r13, 10005, Integer.valueOf(EntityType.MEMORY_COMMON_TEXT), 10001, 10002, 10004, 10003, 10006, Integer.valueOf(EntityType.MEMORY_EVENT_SCHEDULE), Integer.valueOf(EntityType.MEMORY_EVENT_TODO)})), TuplesKt.to("personal_info_memory", SetsKt.setOf(new Integer[]{Integer.valueOf(EntityType.MEMORY_INFO_DOCUMENTS), Integer.valueOf(EntityType.MEMORY_INFO_ADDRESS), Integer.valueOf(EntityType.MEMORY_INFO_ANNIVERSARY), Integer.valueOf(EntityType.MEMORY_INFO_RELATIONSHIP), Integer.valueOf(EntityType.MEMORY_INFO_COMMON)})), TuplesKt.to("screen_memory", SetsKt.setOf(-306)), TuplesKt.to("hearing_memory", SetsKt.setOf(502)), TuplesKt.to("ai_diary", SetsKt.setOf(Integer.valueOf(EntityType.LIFE_LOG))), TuplesKt.to("global_memory", SetsKt.setOf(new Integer[]{r12, r13, 10005, Integer.valueOf(EntityType.MEMORY_COMMON_TEXT), 10001, 10002, 10004, 10003, 10006, Integer.valueOf(EntityType.MEMORY_EVENT_SCHEDULE), Integer.valueOf(EntityType.MEMORY_EVENT_TODO), Integer.valueOf(EntityType.MEMORY_INFO_DOCUMENTS), Integer.valueOf(EntityType.MEMORY_INFO_ADDRESS), Integer.valueOf(EntityType.MEMORY_INFO_ANNIVERSARY), Integer.valueOf(EntityType.MEMORY_INFO_RELATIONSHIP), Integer.valueOf(EntityType.MEMORY_INFO_COMMON), -306, 502, Integer.valueOf(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED)}))});
    }

    private a() {
    }

    private final Map<String, Boolean> d() {
        Cursor r9 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.assistant.provider.ObricPersonalContextProvider/settings"), null, null, null, null, "com.obric.memorydata.plugin");
        if (r9 == null) goto L34;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        Map<String, Boolean> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        Integer r3 = Integer.valueOf(r1.getColumnIndex("toggle_name"));     // Catch: Throwable -> L28
        boolean r5 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L8;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L27;
        int r6 = r3.intValue();     // Catch: Throwable -> L28
        Integer r7 = Integer.valueOf(r1.getColumnIndex("is_on"));     // Catch: Throwable -> L28
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue() >= 0) goto L18;
        r5 = false;
    L18:
        if (r5 == true) goto L21;
        r7 = null;
    L21:
        if (r7 == null) goto L27;
        int r0 = r7.intValue();     // Catch: Throwable -> L28
    L24:
        if (r1.moveToNext() == false) goto L27;
        r2.put(r1.getString(r6), Boolean.valueOf(Boolean.parseBoolean(r1.getString(r0))));     // Catch: Throwable -> L28
    L27:
        CloseableKt.closeFinally(r10, null);
        return r2;
    L8:
        r4 = false;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L34:
        return MapsKt.emptyMap();
    }

    public final Set<String> a() {
        Map<String, Boolean> r9 = d();
        Set<String> r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantSearchDomainSwitchStatus", "domainSwitchStatus: " + r9, false, 4, null);
        Iterator<Map.Entry<Set<String>, Set<String>>> r1 = f12275b.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3.getKey(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r6 = true;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L8;
    L10:
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        if ((!Intrinsics.areEqual(r9.get((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin")), true)) == true) goto L12;
        r6 = false;
    L16:
        if (r6 == false) goto L4;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r3.getValue(), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
    L18:
        return r0;
    }

    public final Set<Integer> b() {
        Map<String, Boolean> r9 = d();
        Set<Integer> r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantSearchDomainSwitchStatus", "domainSwitchStatus: " + r9, false, 4, null);
        Iterator<Map.Entry<String, Set<Integer>>> r1 = c.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r9.get(r3.getKey()), true) == true) goto L4;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r3.getValue(), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        return r0;
    }

    public final Map<Integer, Boolean> c() {
        Map<String, Boolean> r9 = d();
        Map<Integer, Boolean> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantSearchDomainSwitchStatus", "domainSwitchStatus: " + r9, false, 4, null);
        Iterator<Map.Entry<String, Set<Integer>>> r1 = d.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3.getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        r0.put(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4.next(), Number.class, "com.obric.memorydata.plugin")).intValue()), Boolean.valueOf(Intrinsics.areEqual(r9.get(r3.getKey()), true)));
        goto L7
    L9:
        return r0;
    }
}
