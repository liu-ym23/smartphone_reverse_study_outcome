package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.hh;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/RecordingSummaryEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "buildEvent", "Lcom/obric/memorydata/database/entity/RawRecordingEntity;", "hasMeaningfulSummary", "", "entity", "isPlaceholderSummary", "summary", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12220a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/RecordingSummaryEventHandler$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12220a = new a(null);
    }

    public k() {
    }

    private final List<com.obric.memorydata.personalcontext.impl.events.a> a(long r24, hh r26, hh r27) {
        String r4 = r27.g();
        String r6 = null;
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        String r7 = "";
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L14;
        return CollectionsKt.emptyList();
    L14:
        if (a(r5) == false) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecordingSummaryEventHandler", "ignore placeholder summary rawId=" + r24 + " summary=" + r5, false, 4, null);
        return CollectionsKt.emptyList();
    L18:
        if (r26 == null) goto L20;
    L23:
        int r9 = 0;
        if (a(r26) == false) goto L32;
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("skip dispatch (already had summary) rawId=").append(r24).append(" oldSummary.len=");
        if (r26 == null) goto L30;
        String r2 = r26.g();
        if (r2 == null) goto L30;
        r9 = r2.length();
    L30:
        r0.debug("RecordingSummaryEventHandler", r1.append(r9).toString());
        return CollectionsKt.emptyList();
    L32:
        String r3 = r27.l();
        if (r3 != null) goto L35;
    L39:
        r3 = r27.getPackageName();
    L40:
        String r8 = r27.k();
        if (r8 != null) goto L43;
    L49:
        com.obric.memorydata.utils.c.a r10 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r3, null, 2, null);
        if (r10 == null) goto L52;
        r6 = r10.a();
    L52:
        if (r6 == null) goto L55;
        r7 = r6;
    L55:
        long r11 = System.currentTimeMillis();
        long r13 = r27.getCreateTime() + (((long) r27.e()) * 1000);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecordingSummaryEventHandler", "dispatch recording_summary_generated rawId=" + r24 + " pkg=" + r3 + " appName.len=" + r7.length() + " summary.len=" + r5.length(), false, 4, null);
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(EventNames.RECORDING_SUMMARY_GENERATED, MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r24)), TuplesKt.to("raw_table", "RawRecordingEntity"), TuplesKt.to("package_name", r3), TuplesKt.to(Api.KEY_APP_NAME, r7), TuplesKt.to("summary", r5), TuplesKt.to("create_time", Long.valueOf(r27.getCreateTime())), TuplesKt.to("end_time", Long.valueOf(r13)), TuplesKt.to("current_time", Long.valueOf(r11))})));
    L43:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L46;
        r8 = null;
    L46:
        if (r8 == null) goto L49;
        r7 = r8;
        goto L55
    L35:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L38;
        r3 = null;
    L38:
        if (r3 != null) goto L40;
    L20:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.a(r27.getCreateTime()) == false) goto L23;
        RunLog.INSTANCE.debug("RecordingSummaryEventHandler", "skip historical insert rawId=" + r24 + " createTime=" + r27.getCreateTime());
        return CollectionsKt.emptyList();
    L5:
        r5 = null;
        goto L6
    }

    private final boolean a(hh r3) {
        if (r3 == null) goto L7;
        String r4 = r3.g();
        if (r4 == null) goto L7;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L8:
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
    L15:
        return false;
    L13:
        if (a(r5) == true) goto L15;
        return true;
    L7:
        r5 = null;
        goto L8
    }

    private final boolean a(String r6) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        String r7 = new Regex("\\s+").replace(r5, "");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("音频较短", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("未生成纪要内容", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r4, Object r6) {
        Intrinsics.checkNotNullParameter(r6, "raw");
        if (ZeusTransformUtils.instanceOf(r6, hh.class) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a(r4, null, (hh) ZeusTransformUtils.preCheckCast(r6, hh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r3, Object r5, Object r6) {
        Intrinsics.checkNotNullParameter(r6, "raw");
        if (ZeusTransformUtils.instanceOf(r6, hh.class) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (ZeusTransformUtils.instanceOf(r5, hh.class) == false) goto L9;
        hh r7 = (hh) ZeusTransformUtils.preCheckCast(r5, hh.class, "com.obric.memorydata.plugin");
    L11:
        return a(r3, r7, (hh) ZeusTransformUtils.preCheckCast(r6, hh.class, "com.obric.memorydata.plugin"));
    L9:
        r7 = null;
        goto L11
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r1, Object r3) {
        return CollectionsKt.emptyList();
    }
}
