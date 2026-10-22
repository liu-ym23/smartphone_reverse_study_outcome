package com.larus.uaigc.service;

import android.net.Uri;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, d2 = {"Lcom/larus/uaigc/service/ICreationUploadPolicyService;", "", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "mobDuplicateStatAsync", "", "scene", "", "uri", "Landroid/net/Uri;", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationUploadPolicyService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J+\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/larus/uaigc/service/ICreationUploadPolicyService$Companion;", "Lcom/larus/uaigc/service/ICreationUploadPolicyService;", "<init>", "()V", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "mobDuplicateStatAsync", "", "scene", "", "uri", "Landroid/net/Uri;", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationUploadPolicyService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationUploadPolicyService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationUploadPolicyService
        public final void U(String r8, Uri r9, ic8.n0 r10, long r11) {
            Intrinsics.checkNotNullParameter(r9, "uri");
            Intrinsics.checkNotNullParameter(r10, "processFileResult");
            this.b.U(r8, r9, r10, r11);
        }

        @Override // com.larus.uaigc.service.ICreationUploadPolicyService
        public final com.larus.uaigc.utils.a t() {
            return this.b.t();
        }

        private Companion() {
            ICreationUploadPolicyService r0 = (ICreationUploadPolicyService) ServiceManager.get().getService(ICreationUploadPolicyService.class);
            if (r0 != null) goto L5;
            r0 = new ICreationUploadPolicyServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    void U(String r1, Uri r2, ic8.n0 r3, long r4);

    com.larus.uaigc.utils.a t();
}
