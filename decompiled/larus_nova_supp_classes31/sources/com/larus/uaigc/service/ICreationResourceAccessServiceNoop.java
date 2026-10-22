package com.larus.uaigc.service;

import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J2\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u001a"}, d2 = {"Lcom/larus/uaigc/service/ICreationResourceAccessServiceNoop;", "Lcom/larus/uaigc/service/ICreationResourceAccessService;", "<init>", "()V", "submit", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "request", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "cancel", "", "fileIdentifier", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "observe", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", "bizScope", "query", "Lcom/larus/bmhome/resource/access/ResourceAccessSnapshot;", "taskId", "queryByFileIdentifier", "getArtifact", "Lcom/larus/bmhome/resource/access/ResourceArtifact;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationResourceAccessServiceNoop implements ICreationResourceAccessService {
    public ICreationResourceAccessServiceNoop() {
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final boolean a(String r1, ResourceCancelReason r2) {
        Intrinsics.checkNotNullParameter(r2, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        return false;
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final com.larus.bmhome.resource.access.f0 c(String r1) {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final com.larus.bmhome.resource.access.z d(String r1, com.larus.bmhome.resource.access.x r2, ResourceMediaType r3, String r4) {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final com.larus.bmhome.resource.access.b0 e(String r1, com.larus.bmhome.resource.access.x r2, ResourceMediaType r3, String r4) {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public com.larus.bmhome.resource.access.z query(String r1) {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationResourceAccessService
    public final com.larus.bmhome.resource.access.b0 b(p0 r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        ResourceUploadError r0 = new ResourceUploadError("resource_access_service_unavailable", "creation resource access service unavailable");
        r4.o.invoke(r0);
        return new x(r4, r0);
    }
}
