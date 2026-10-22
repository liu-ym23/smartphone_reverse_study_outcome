package com.obric.memorydata.memory.ui.feedback;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.memory.ui.list.MemoryTab;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportDataProvider;", "", "<init>", "()V", "TAG", "", "fromMemoryItem", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportData;", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "fromAutoMemoryPro", "entity", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "fromMemoryEntity", "entityId", "tab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "fallbackLogId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10952a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10953a = null;

        static {
            int[] r0 = new int[MemoryTab.values().length];
            r0[MemoryTab.COLLECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemoryTab.PROFILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10953a = r0;
        }
    }

    static {
        f10952a = new i();
    }

    private i() {
    }

    private final h a(String r4, MemoryTab r5, String r6) {
        int r3 = a.f10953a[r5.ordinal()];
        String r0 = "";
        if (r3 != 1) goto L5;
        EpisodicMemoryEntity r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r4);
        if (r7 != null) goto L22;
        return null;
    L22:
        MemoryReviewModule r8 = MemoryReviewModule.COLLECTION_MEMORY;
        String r9 = r7.getLogId();
        if (r9 == null) goto L26;
        r0 = r9;
    L26:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r11 = r6;
        if (StringsKt.isBlank(r10) == true) goto L31;
        r11 = r10;
    L31:
        return new h(r8, (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"), g.f10949a.a(r7));
    L5:
        if (r3 != 2) goto L33;
        ip r12 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r4);
        if (r12 != null) goto L10;
        return null;
    L10:
        MemoryReviewModule r13 = MemoryReviewModule.PERSONAL_MEMORY;
        String r14 = r12.m();
        if (r14 == null) goto L14;
        r0 = r14;
    L14:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r16 = r6;
        if (StringsKt.isBlank(r15) == true) goto L32;
        r16 = r15;
    L32:
        return new h(r13, (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin"), r12.x());
    L33:
        return null;
    }

    public final h a(AutoMemoryProEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        return new h(MemoryReviewModule.AUTO_MEMORY_PRO, r3.getLogId(), r3.toJsonObject());
    }

    public final h a(com.obric.memorydata.memory.ui.data.a r9) {
        Intrinsics.checkNotNullParameter(r9, "memoryItem");
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L33
        i r8 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        String r3 = "";
        if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L12;
        MemoryReviewModule r4 = MemoryReviewModule.SCREEN_MEMORY;     // Catch: Throwable -> L33
        String r5 = ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getLogId();     // Catch: Throwable -> L33
        if (r5 == null) goto L10;
        r3 = r5;
    L10:
        h r10 = new h(r4, r3, g.f10949a.a(((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b()));     // Catch: Throwable -> L33
    L31:
        Object r11 = Result.m1421constructorimpl(r10);     // Catch: Throwable -> L33
    L35:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L39;
        RunLog.INSTANCE.warn("MemoryFeedbackOdpData", "build memory feedback ODP data failed", r12);
    L39:
        if (Result.m1427isFailureimpl(r11) == true) goto L43;
        r1 = r11;
    L43:
        return (h) ZeusTransformUtils.preCheckCast(r1, h.class, "com.obric.memorydata.plugin");
    L12:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L15;
        r10 = new h(MemoryReviewModule.AUDIO_MEMORY, "", g.f10949a.a(((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b(), n.f10961a.a(((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().g())));     // Catch: Throwable -> L33
        goto L31
    L15:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L18;
        r10 = r8.a(((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b());     // Catch: Throwable -> L33
        goto L31
    L18:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L25;
        String r6 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId();     // Catch: Throwable -> L33
        MemoryTab r7 = com.obric.memorydata.memory.utils.f.f11537a.a((AppEntity) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b(), AppEntity.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L33
        String r13 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L33
        if (r13 == null) goto L23;
        r3 = r13;
    L23:
        r10 = r8.a(r6, r7, r3);     // Catch: Throwable -> L33
        goto L31
    L25:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L30;
        r6 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getId();     // Catch: Throwable -> L33
        r7 = com.obric.memorydata.memory.utils.f.f11537a.a((AppEntity) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b(), AppEntity.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L33
        String r14 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getLogId();     // Catch: Throwable -> L33
        if (r14 == null) goto L23;
        r3 = r14;
        goto L23
    L30:
        r10 = null;
    L33:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L35
    }
}
