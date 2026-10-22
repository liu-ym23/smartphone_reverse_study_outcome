package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.settingsharness.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\bR,\u0010\u0004\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/SystemAppDataPageContract;", "", "<init>", "()V", "rows", "", "Lkotlin/Pair;", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSystemApp;", "", "", "bindingSpec", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageBindingSpec;", "getBindingSpec", "()Lcom/obric/memorydata/ui/settingsharness/SettingsPageBindingSpec;", "pageState", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageState;", "values", "", "", "appFor", "rowId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f11464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Pair<ContextAwarenessSystemApp, Pair<String, Integer>>> f11465b = null;
    private static final com.obric.memorydata.ui.settingsharness.g c = null;

    static {
        f11464a = new o();
        List<Pair<ContextAwarenessSystemApp, Pair<String, Integer>>> r0 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(ContextAwarenessSystemApp.SMS, new Pair("system_app_sms", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.system_app_sms, OaidModel.KEY_ID, "system_app_sms")))), TuplesKt.to(ContextAwarenessSystemApp.PHONE, new Pair("system_app_phone", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.system_app_phone, OaidModel.KEY_ID, "system_app_phone")))), TuplesKt.to(ContextAwarenessSystemApp.RECORDER, new Pair("system_app_recorder", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.system_app_recorder, OaidModel.KEY_ID, "system_app_recorder")))), TuplesKt.to(ContextAwarenessSystemApp.CALENDAR, new Pair("system_app_calendar", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.system_app_calendar, OaidModel.KEY_ID, "system_app_calendar")))), TuplesKt.to(ContextAwarenessSystemApp.ALARM, new Pair("system_app_alarm", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.system_app_alarm, OaidModel.KEY_ID, "system_app_alarm")))), TuplesKt.to(ContextAwarenessSystemApp.GALLERY, new Pair("system_app_gallery", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.system_app_gallery, OaidModel.KEY_ID, "system_app_gallery")))), TuplesKt.to(ContextAwarenessSystemApp.NOTE, new Pair("system_app_note", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.system_app_note, OaidModel.KEY_ID, "system_app_note")))), TuplesKt.to(ContextAwarenessSystemApp.FILE, new Pair("system_app_file", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.system_app_file, OaidModel.KEY_ID, "system_app_file"))))});
        f11465b = r0;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.memorydata.plugin")).component2(), Pair.class, "com.obric.memorydata.plugin");
        r2.add(new com.obric.memorydata.ui.settingsharness.n.c((String) ZeusTransformUtils.preCheckCast(r4.getFirst(), String.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue()));
        goto L4
    L6:
        c = new com.obric.memorydata.ui.settingsharness.g(CollectionsKt.listOf(new p("system_apps", null, null, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), 6, null)));
    }

    private o() {
    }

    public final ContextAwarenessSystemApp a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "rowId");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(f11465b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (Intrinsics.areEqual(((Pair) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r0, Pair.class, "com.obric.memorydata.plugin")).component2(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), r5) == false) goto L4;
    L9:
        Pair r6 = (Pair) ZeusTransformUtils.preCheckCast(r0, Pair.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        ContextAwarenessSystemApp r7 = (ContextAwarenessSystemApp) ZeusTransformUtils.preCheckCast(r6.getFirst(), ContextAwarenessSystemApp.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        return r7;
    L15:
        throw new IllegalStateException(("Unsupported system-app row: " + r5).toString());
    L8:
        r0 = null;
        goto L9
    }

    public final com.obric.memorydata.ui.settingsharness.g a() {
        return c;
    }

    public final com.obric.memorydata.ui.settingsharness.i a(Map<ContextAwarenessSystemApp, Boolean> r14) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "values");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(f11465b, Iterable.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L7;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r16.next(), Pair.class, "com.obric.memorydata.plugin");
        ContextAwarenessSystemApp r3 = (ContextAwarenessSystemApp) ZeusTransformUtils.preCheckCast(r2.component1(), ContextAwarenessSystemApp.class, "com.obric.memorydata.plugin");
        Pair r4 = TuplesKt.to(((Pair) ZeusTransformUtils.preCheckCast(r2.component2(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), new com.obric.memorydata.ui.settingsharness.o(false, false, false, Boolean.valueOf(Intrinsics.areEqual(r13.get(r3), true)), null, 23, null));
        r1.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new com.obric.memorydata.ui.settingsharness.i(r1);
    }
}
