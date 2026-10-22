package com.bytedance.applog.priority.original;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/applog/priority/original/Config;", "", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "context", "Landroid/content/Context;", "appId", "", "(Lcom/bytedance/applog/log/AbsLogger;Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "configKey", "getContext", "()Landroid/content/Context;", "fastMatchEventTypes", "", "Lcom/bytedance/applog/priority/original/Model$EventType;", "getFastMatchEventTypes", "()Ljava/util/Set;", "fastMatchEventTypes$delegate", "Lkotlin/Lazy;", "fastMatchEventTypesKey", "keva", "Lcom/bytedance/keva/Keva;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "clear", "", "get", "Lorg/json/JSONObject;", "isFastMatchEvent", "", "eventType", "isMatchNothing", "save", "json", "saveFastMatchConfig", "fastMatchGroups", "Lcom/bytedance/applog/priority/original/Model$FastMatchGroups;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.log.a f1834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1835b;
    private final String c;
    private final String d;
    private final String e;
    private final Keva f;
    private final Lazy g;

    public f(com.bytedance.applog.log.a r3, Context r4, String r5) {
        com.bytedance.applog.log.a r6 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "logger");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r5, "appId");
        this.f1834a = r6;
        this.f1835b = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.c = r5;
        this.d = "data";
        this.e = "fast_match_event_types";
        Keva r8 = Keva.getRepo("applog_priority_origin@" + r5 + "_config", 0);
        Intrinsics.checkNotNullExpressionValue(r8, "getRepo(\"applog_priority…ants.MODE_SINGLE_PROCESS)");
        this.f = r8;
        this.g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new Config$fastMatchEventTypes$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Keva a(f r0) {
        return r0.f;
    }

    public static final /* synthetic */ String b(f r0) {
        return r0.e;
    }

    private final Set<Model.EventType> c() {
        return (Set) ZeusTransformUtils.preCheckCast(this.g.getValue(), Set.class, "com.obric.memorydata.plugin");
    }

    public final JSONObject a() {
        String r2 = this.f.getStringJustDisk(this.d, "");
        Intrinsics.checkNotNullExpressionValue(r2, "keva.getStringJustDisk(configKey, \"\")");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L12;
        return null;
    L12:
        return new JSONObject(r2);
    L11:
        return null;
    L5:
        r0 = false;
        goto L7
    }

    public final void a(Model.b r6) {
        Intrinsics.checkNotNullParameter(r6, "fastMatchGroups");
        c().clear();
        Set<Model.EventType> r7 = r6.b();
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        c().addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        Keva r8 = this.f;
        String r0 = this.e;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r5.iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        r1.add(((Model.EventType) ZeusTransformUtils.preCheckCast(r9.next(), Model.EventType.class, "com.obric.memorydata.plugin")).getAlias());
        goto L7
    L9:
        r8.storeStringSetJustDisk(r0, CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "json");
        this.f.storeStringJustDisk(this.d, r2);
    }

    public final boolean a(Model.EventType r2) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        return c().contains(r2);
    }

    public final boolean b() {
        return c().isEmpty();
    }

    public final Context getContext() {
        return this.f1835b;
    }
}
