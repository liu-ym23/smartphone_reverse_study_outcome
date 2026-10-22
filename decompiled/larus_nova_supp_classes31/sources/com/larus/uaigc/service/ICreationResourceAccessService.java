package com.larus.uaigc.service;

import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J8\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\tH&J8\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u0019"}, d2 = {"Lcom/larus/uaigc/service/ICreationResourceAccessService;", "", "submit", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "request", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "cancel", "", "fileIdentifier", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "observe", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", "bizScope", "query", "Lcom/larus/bmhome/resource/access/ResourceAccessSnapshot;", "taskId", "queryByFileIdentifier", "getArtifact", "Lcom/larus/bmhome/resource/access/ResourceArtifact;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationResourceAccessService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J3\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J3\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001¨\u0006\u001a"}, d2 = {"Lcom/larus/uaigc/service/ICreationResourceAccessService$Companion;", "Lcom/larus/uaigc/service/ICreationResourceAccessService;", "<init>", "()V", "cancel", "", "fileIdentifier", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "getArtifact", "Lcom/larus/bmhome/resource/access/ResourceArtifact;", "observe", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", "bizScope", "query", "Lcom/larus/bmhome/resource/access/ResourceAccessSnapshot;", "taskId", "queryByFileIdentifier", "submit", "request", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationResourceAccessService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationResourceAccessService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final boolean a(String r2, ResourceCancelReason r3) {
            Intrinsics.checkNotNullParameter(r3, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
            return this.b.a(r2, r3);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final com.larus.bmhome.resource.access.b0 b(p0 r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            return this.b.b(r2);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final com.larus.bmhome.resource.access.f0 c(String r2) {
            return this.b.c(r2);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final com.larus.bmhome.resource.access.z d(String r2, com.larus.bmhome.resource.access.x r3, ResourceMediaType r4, String r5) {
            return this.b.d(r2, r3, r4, r5);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public final com.larus.bmhome.resource.access.b0 e(String r2, com.larus.bmhome.resource.access.x r3, ResourceMediaType r4, String r5) {
            return this.b.e(r2, r3, r4, r5);
        }

        @Override // com.larus.uaigc.service.ICreationResourceAccessService
        public com.larus.bmhome.resource.access.z query(String r2) {
            return this.b.query(r2);
        }

        private Companion() {
            ICreationResourceAccessService r0 = (ICreationResourceAccessService) ServiceManager.get().getService(ICreationResourceAccessService.class);
            if (r0 != null) goto L5;
            r0 = new ICreationResourceAccessServiceNoop();
        L5:
            this.b = r0;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(Companion r1, String r2) {
            r1.a(r2, ResourceCancelReason.UNKNOWN);
        }

        public static /* synthetic */ com.larus.bmhome.resource.access.b0 b(Companion r2, String r3, com.larus.bmhome.resource.access.x r4, ResourceMediaType r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r5 = null;
        L9:
            return r2.e(r3, r4, r5, null);
        }

        public static /* synthetic */ com.larus.bmhome.resource.access.z c(Companion r2, String r3, com.larus.bmhome.resource.access.x r4, ResourceMediaType r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r5 = null;
        L9:
            return r2.d(r3, r4, r5, null);
        }
    }

    static {
        a = Companion.c;
    }

    boolean a(String r1, ResourceCancelReason r2);

    com.larus.bmhome.resource.access.b0 b(p0 r1);

    com.larus.bmhome.resource.access.f0 c(String r1);

    com.larus.bmhome.resource.access.z d(String r1, com.larus.bmhome.resource.access.x r2, ResourceMediaType r3, String r4);

    com.larus.bmhome.resource.access.b0 e(String r1, com.larus.bmhome.resource.access.x r2, ResourceMediaType r3, String r4);

    com.larus.bmhome.resource.access.z query(String r1);
}
