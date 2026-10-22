package com.obric.aiproactive.ui.model;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/model/InspirationStatusOverrideStore;", "", "<init>", "()V", "TAG", "", "overrides", "Ljava/util/concurrent/ConcurrentHashMap;", "", "record", "", "inspirationId", "recommendStatus", "(Ljava/lang/String;Ljava/lang/Integer;)V", "apply", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "dto", "", Constants.KEY_LIST, "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f6729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f6730b = null;

    static {
        f6729a = new i();
        f6730b = new ConcurrentHashMap();
    }

    private i() {
    }

    private static final Integer a(int r6, String r7, String r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "<unused var>");
        if (r9 == null) goto L5;
        int r10 = r9.intValue();
    L6:
        int r11 = Math.max(r10, r6);
        if (r9 != null) goto L9;
    L10:
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("[OverrideStore] record inspirationId=").append(r7).append(" status=");
        Object r13 = r9;
        if (r9 != null) goto L13;
        r13 = "null";
    L13:
        IRunLog.a.a(r0, "ProactiveUI", r12.append(r13).append("->").append(r11).toString(), false, 4, null);
    L15:
        return Integer.valueOf(r11);
    L9:
        if (r11 == r9.intValue()) goto L15;
    L5:
        r10 = r6;
        goto L6
    }

    private static final Integer a(Function2 r2, Object r3, Object r4) {
        return (Integer) ZeusTransformUtils.preCheckCast(((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4), Integer.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Integer lambda$3yXHs7LcWhNsA16xT_aCNWERIq0(Function2 r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$kJ8BCgIo0fGb656JYdQ-2LX13m4, reason: not valid java name */
    public static /* synthetic */ Integer m310lambda$kJ8BCgIo0fGb656JYdQ2LX13m4(int r0, String r1, String r2, Integer r3) {
        return a(r0, r1, r2, r3);
    }

    public final ProactiveRecommendationDto a(ProactiveRecommendationDto r36) {
        Intrinsics.checkNotNullParameter(r36, "dto");
        String r1 = l.a(r36);
        if (r1 != null) goto L5;
        return r36;
    L5:
        ConcurrentHashMap<String, Integer> r2 = f6730b;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(r1), Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        int r15 = r3.intValue();
        if (r36.getRecommendStatus() < r15) goto L11;
        r2.remove(r1, Integer.valueOf(r15));
        return r36;
    L11:
        RunLog.INSTANCE.debug("ProactiveUI", "[OverrideStore] apply inspirationId=" + r1 + ' ' + r36.getRecommendStatus() + "->" + r15);
        return ProactiveRecommendationDto.copy$default(r36, null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, r15, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 134209535, null);
    L13:
        return r36;
    }

    public final List<ProactiveRecommendationDto> a(List<ProactiveRecommendationDto> r14) {
        List<ProactiveRecommendationDto> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, Constants.KEY_LIST);
        if (r13.isEmpty() == false) goto L5;
        return r13;
    L5:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L8;
    L10:
        Iterator r16 = r15.iterator();
        int r1 = 0;
    L12:
        if (r16.hasNext() == false) goto L21;
        if (((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r16.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus() < 2) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L12;
        r1 = r1 + 1;
        if (r1 >= 0) goto L12;
        CollectionsKt.throwCountOverflow();
        goto L12
    L16:
        r5 = false;
    L21:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L23:
        if (r18.hasNext() == false) goto L25;
        r6.add(f6729a.a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r18.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")));
        goto L23
    L25:
        List<ProactiveRecommendationDto> r19 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L28;
    L30:
        Iterator r8 = r7.iterator();
        int r9 = 0;
    L32:
        if (r8.hasNext() == false) goto L41;
        if (((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r8.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus() < 2) goto L36;
        boolean r10 = true;
    L37:
        if (r10 == false) goto L32;
        r9 = r9 + 1;
        if (r9 >= 0) goto L32;
        CollectionsKt.throwCountOverflow();
        goto L32
    L36:
        r10 = false;
        goto L37
    L41:
        r4 = r9;
    L42:
        if (r1 == r4) goto L48;
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r110 = new StringBuilder().append("[OverrideStore] applyList size=").append(r13.size()).append(" adopted=").append(r1).append("->").append(r4).append(" ids=");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin"), 3), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r2.iterator();
    L45:
        if (r12.hasNext() == false) goto L47;
        ProactiveRecommendationDto r20 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r12.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        r3.add(TuplesKt.to(r20.getRecommendId(), Integer.valueOf(r20.getRecommendStatus())));
        goto L45
    L47:
        IRunLog.a.a(r11, "ProactiveUI", r110.append((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).toString(), false, 4, null);
    L48:
        return r19;
    L28:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L30;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        r1 = 0;
        goto L21
    }

    public final void a(String r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r7, "inspirationId");
        final String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r8 == null) goto L10;
        final int r9 = r8.intValue();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[OverrideStore] ignoreBlankInspirationId", null, 4, null);
        return;
    L8:
        ConcurrentHashMap<String, Integer> r10 = f6730b;
        final Function2 r0 = new $$Lambda$i$kJ8BCgIo0fGb656JYdQ2LX13m4(r9, r6);
        r10.compute(r6, new $$Lambda$i$3yXHs7LcWhNsA16xT_aCNWERIq0(r0));
        return;
    }
}
