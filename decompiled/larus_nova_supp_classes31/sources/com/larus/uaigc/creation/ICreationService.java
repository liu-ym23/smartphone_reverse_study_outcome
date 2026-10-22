package com.larus.uaigc.creation;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/larus/uaigc/creation/ICreationService;", "", "getAiReplicaWhiteTUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/creation/ICreationService$Companion;", "Lcom/larus/uaigc/creation/ICreationService;", "<init>", "()V", "getAiReplicaWhiteTUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.creation.ICreationService
        public final Object a(Continuation<? super String> r2) {
            return this.b.a(r2);
        }

        private Companion() {
            ICreationService r0 = (ICreationService) ServiceManager.get().getService(ICreationService.class);
            if (r0 != null) goto L5;
            r0 = new CreationServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    Object a(Continuation<? super String> r1);
}
