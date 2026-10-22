package com.larus.tts;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/larus/tts/IChatTtsService;", "", "getTtsSwitchStatus", "", "ttsSwitch", "", "isMainBot", "cvsId", "", "getGlobalTtsSwitchStatus", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IChatTtsService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/larus/tts/IChatTtsService$Companion;", "Lcom/larus/tts/IChatTtsService;", "<init>", "()V", "_delegate", "get_delegate", "()Lcom/larus/tts/IChatTtsService;", "getTtsSwitchStatus", "", "ttsSwitch", "", "isMainBot", "cvsId", "", "getGlobalTtsSwitchStatus", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IChatTtsService {
        public static final /* synthetic */ Companion b = null;

        static {
            b = new Companion();
        }

        private Companion() {
        }

        @Override // com.larus.tts.IChatTtsService
        public final boolean a(int r3) {
            IChatTtsService r0 = (IChatTtsService) ServiceManager.get().getService(IChatTtsService.class);
            if (r0 != null) goto L6;
            r0 = new ChatTtsServiceNoop();
        L6:
            return r0.a(r3);
        }

        @Override // com.larus.tts.IChatTtsService
        public final boolean b(int r3, boolean r4, String r5) {
            IChatTtsService r0 = (IChatTtsService) ServiceManager.get().getService(IChatTtsService.class);
            if (r0 != null) goto L6;
            r0 = new ChatTtsServiceNoop();
        L6:
            return r0.b(r3, r4, r5);
        }
    }

    static {
        a = Companion.b;
    }

    boolean a(int r1);

    boolean b(int r1, boolean r2, String r3);
}
