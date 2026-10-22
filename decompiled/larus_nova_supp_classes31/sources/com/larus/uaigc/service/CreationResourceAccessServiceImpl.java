package com.larus.uaigc.service;

import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceTraceResult;
import com.larus.bmhome.resource.access.x0;
import com.larus.bmhome.resource.access.y0;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J2\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u001a"}, d2 = {"Lcom/larus/uaigc/service/CreationResourceAccessServiceImpl;", "Lcom/larus/uaigc/service/ICreationResourceAccessService;", "<init>", "()V", "submit", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "request", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "cancel", "", "fileIdentifier", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "observe", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", "bizScope", "query", "Lcom/larus/bmhome/resource/access/ResourceAccessSnapshot;", "taskId", "queryByFileIdentifier", "getArtifact", "Lcom/larus/bmhome/resource/access/ResourceArtifact;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationResourceAccessServiceImpl implements ICreationResourceAccessService {
    public CreationResourceAccessServiceImpl() {
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final com.larus.bmhome.resource.access.b0 b(p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        CreationResourceAccessUploader r0 = CreationResourceAccessUploader.a;
        return CreationResourceAccessUploader.l(r2);
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final com.larus.bmhome.resource.access.f0 c(String r3) {
        CreationResourceAccessUploader r0 = CreationResourceAccessUploader.a;
        Object r1 = CreationResourceAccessUploader.g;
        monitor-enter(r1);
        CreationResourceAccessUploader.e();     // Catch: Throwable -> L18
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r1);
        if (r3 != null) goto L9;
        return null;
    L9:
        if (r3.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 != null) goto L17;
        return null;
    L17:
        return CreationResourceAccessUploader.e.get(r3);
    L11:
        r4 = false;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public com.larus.bmhome.resource.access.z query(String r2) {
        return CreationResourceAccessUploader.a.query(r2);
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final boolean a(String r11, ResourceCancelReason r12) {
        Intrinsics.checkNotNullParameter(r12, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        CreationResourceAccessUploader r1 = CreationResourceAccessUploader.a;
        Intrinsics.checkNotNullParameter(r12, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.length() <= 0) goto L7;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r11 = null;
    L12:
        if (r11 == null) goto L56;
        ConcurrentHashMap<String, Long> r3 = CreationResourceAccessUploader.h;
        Long r5 = r3.get(r11);
        if (r5 != null) goto L17;
    L20:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L24;
        FLogger.a.i("CreationResourceAccessUploader", "[cancel] ignore cancel for send handoff, identifier=" + r11 + ", reason=" + r12);
        return false;
    L24:
        com.larus.bmhome.resource.access.y r6 = com.larus.bmhome.resource.access.y.a;
        Intrinsics.checkNotNullParameter(r11, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r12, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        x0 r7 = x0.a;
        y0 r8 = new y0(r11, null, null, null);
        Intrinsics.checkNotNullParameter(r8, "query");
        Intrinsics.checkNotNullParameter(r12, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        com.larus.bmhome.resource.access.f r9 = x0.c(r8, true);
        if (r9 == null) goto L35;
        String r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "taskId");
        Intrinsics.checkNotNullParameter(r12, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        com.larus.bmhome.resource.access.f r0 = (com.larus.bmhome.resource.access.f) x0.c.get(r10);
        if (r0 == null) goto L35;
        if (r0.c() == true) goto L35;
        if (r0.e(new com.larus.bmhome.resource.access.a0.a(r12)) == false) goto L35;
        Job r13 = (Job) r0.h.getAndSet(null);
        if (r13 == null) goto L39;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L39:
        x0.d(r0, ResourceTraceResult.CANCELLED, r12.name().toLowerCase(Locale.ROOT));
        ResourceUploader r14 = ResourceUploader.a;
        ResourceUploader.c(r0.c.d.a);
        x0.a();
        boolean r15 = true;
    L40:
        if (r15 == false) goto L42;
        CreationResourceAccessUploader.g(r11);
    L51:
        return true;
    L42:
        CreationResourceAccessUploader.a r16 = CreationResourceAccessUploader.c.get(r11);
        if (r16 != null) goto L45;
        CreationResourceAccessUploader.g(r11);
        ResourceUploader.c(r11);
        FLogger.a.i("CreationResourceAccessUploader", "[cancel] fallback cancel sdk upload task, identifier=" + r11 + ", reason=" + r12);
        goto L51
    L45:
        if (r16.d(new com.larus.bmhome.resource.access.a0.a(r12)) == false) goto L55;
        Job r17 = r16.f.getAndSet(null);
        if (r17 == null) goto L49;
        Job.DefaultImpls.cancel$default(r17, null, 1, null);
    L49:
        CreationResourceAccessUploader.g(r11);
        ResourceUploader.c(r11);
        goto L51
    L55:
        return false;
    L35:
        r15 = false;
        goto L40
    L17:
        if ((System.currentTimeMillis() - r5.longValue()) <= 300000) goto L19;
        r3.remove(r11);
        goto L20
    L19:
        r4 = true;
        goto L22
    L56:
        return false;
    L7:
        r2 = false;
        goto L9
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final com.larus.bmhome.resource.access.z d(String r4, com.larus.bmhome.resource.access.x r5, ResourceMediaType r6, String r7) {
        CreationResourceAccessUploader r0 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.f();
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L26;
        com.larus.bmhome.resource.access.y r2 = com.larus.bmhome.resource.access.y.a;
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        x0 r3 = x0.a;
        y0 r8 = new y0(r4, r5, r6, r7);
        Intrinsics.checkNotNullParameter(r8, "query");
        com.larus.bmhome.resource.access.f r9 = x0.c(r8, false);
        if (r9 == null) goto L16;
        com.larus.bmhome.resource.access.z r10 = r9.snapshot();
    L17:
        if (r10 != null) goto L22;
        CreationResourceAccessUploader.a r11 = CreationResourceAccessUploader.c.get(r4);
        if (r11 != null) goto L25;
        return null;
    L25:
        return r11.snapshot();
    L22:
        return r10;
    L16:
        r10 = null;
        goto L17
    L26:
        return null;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final com.larus.bmhome.resource.access.b0 e(String r2, com.larus.bmhome.resource.access.x r3, ResourceMediaType r4, String r5) {
        CreationResourceAccessUploader r0 = CreationResourceAccessUploader.a;
        return CreationResourceAccessUploader.i(r2, r3, r4, r5);
    }
}
