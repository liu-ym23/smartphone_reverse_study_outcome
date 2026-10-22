package com.larus.uaigc.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/larus/uaigc/service/ICreationReportService;", "", "reportHelper", "Lcom/larus/uaigc/bean/IUgcReportHelper;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationReportService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0006"}, d2 = {"Lcom/larus/uaigc/service/ICreationReportService$Companion;", "Lcom/larus/uaigc/service/ICreationReportService;", "<init>", "()V", "reportHelper", "Lcom/larus/uaigc/bean/IUgcReportHelper;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationReportService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationReportService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationReportService
        public final hy9.d j() {
            return this.b.j();
        }

        private Companion() {
            ICreationReportService r0 = (ICreationReportService) ServiceManager.get().getService(ICreationReportService.class);
            if (r0 != null) goto L5;
            r0 = new ICreationReportServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    hy9.d j();
}
