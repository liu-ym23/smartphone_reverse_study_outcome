package com.larus.ugc.perf.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import nq9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/larus/ugc/perf/api/IUgcPerfService;", "", "IUgcAppreciablePoint", "Lcom/larus/platform/model/bot/IUgcAppreciablePoint;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IUgcPerfService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0006"}, d2 = {"Lcom/larus/ugc/perf/api/IUgcPerfService$Companion;", "Lcom/larus/ugc/perf/api/IUgcPerfService;", "<init>", "()V", "IUgcAppreciablePoint", "Lcom/larus/platform/model/bot/IUgcAppreciablePoint;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IUgcPerfService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IUgcPerfService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.ugc.perf.api.IUgcPerfService
        public final f a() {
            return this.b.a();
        }

        private Companion() {
            this.b = (IUgcPerfService) ServiceManager.get().getService(IUgcPerfService.class);
        }
    }

    static {
        a = Companion.c;
    }

    f a();
}
