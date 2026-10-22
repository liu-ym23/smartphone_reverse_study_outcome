package com.obric.memorydata.memory.review.trace;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bridge.AuditoryBridgeAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportHotwordsReader;", "", "hotwordsLookup", "Lkotlin/Function1;", "", "accountScopeProvider", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "readHotwords", "Lorg/json/JSONArray;", "rawObservations", "", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "isAuditory", "", "entity", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<String, String> f10492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<String> f10493b;

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public h(Function1<? super String, String> r3, Function0<String> r4) {
        Function1<String, String> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function0<String> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "hotwordsLookup");
        Intrinsics.checkNotNullParameter(r6, "accountScopeProvider");
        this.f10492a = r5;
        this.f10493b = r6;
    }

    public /* synthetic */ h(Function1 r2, Function0 r3, int r4, DefaultConstructorMarker r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = (Function1) ZeusTransformUtils.preCheckCast(new MemoryTraceReportHotwordsReader$1(AuditoryBridgeAPI.INSTANCE), Function1.class, "com.obric.memorydata.plugin");
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = (Function0) ZeusTransformUtils.preCheckCast(new MemoryTraceReportHotwordsReader$2(UserSettings.INSTANCE), Function0.class, "com.obric.memorydata.plugin");
    L8:
        this(r6, r7);
    }

    private final boolean a(RawObservationEntity r1) {
        return Intrinsics.areEqual(r1.getSource(), "auditory");
    }

    public final JSONArray a(List<RawObservationEntity> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "rawObservations");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L6;
        if (a((RawObservationEntity) ZeusTransformUtils.preCheckCast(r9.next(), RawObservationEntity.class, "com.obric.memorydata.plugin")) == false) goto L9;
        boolean r10 = false;
    L14:
        if (r10 == false) goto L16;
        return null;
    L16:
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(this.f10493b.invoke(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L22;
        return null;
    L22:
        String r5 = this.f10492a.invoke(r11);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L26;
        r5 = null;
    L26:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L36;
        return null;
    L36:
        JSONArray r13 = new JSONArray(r12);     // Catch: JSONException -> L35
        if (r13.length() <= 0) goto L32;
        r2 = true;
    L32:
        if (r2 == true) goto L34;
        return null;
    L34:
        return r13;
    L42:
        return null;
    L19:
        r4 = false;
    L6:
        r10 = true;
        goto L14
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }
}
