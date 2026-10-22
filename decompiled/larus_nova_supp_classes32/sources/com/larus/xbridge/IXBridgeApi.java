package com.larus.xbridge;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J4\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H&¨\u0006\f"}, d2 = {"Lcom/larus/xbridge/IXBridgeApi;", NameKeys.UnloadStrategy_No_Strategy, "init", NameKeys.UnloadStrategy_No_Strategy, "registerCustomBridges", "sendEvent", "eventName", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.PARAMS_KEY, NameKeys.UnloadStrategy_No_Strategy, "containerID", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IXBridgeApi {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J0\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/xbridge/IXBridgeApi$Companion;", "Lcom/larus/xbridge/IXBridgeApi;", "<init>", "()V", "impl", "init", NameKeys.UnloadStrategy_No_Strategy, "registerCustomBridges", "sendEvent", "eventName", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.PARAMS_KEY, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "containerID", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IXBridgeApi {
        public static final /* synthetic */ Companion b = null;
        public static final IXBridgeApi c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = (IXBridgeApi) ServiceManager.get().getService(IXBridgeApi.class);
        }

        @Override // com.larus.xbridge.IXBridgeApi
        public final void a() {
            IXBridgeApi r0 = c;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        @Override // com.larus.xbridge.IXBridgeApi
        public final void init() {
            IXBridgeApi r0 = c;
            if (r0 == null) goto L6;
            r0.init();
            return;
        }

        @Override // com.larus.xbridge.IXBridgeApi
        public final void b(String r2, Map<String, ? extends Object> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            IXBridgeApi r0 = c;
            if (r0 == null) goto L6;
            r0.b(r2, r3, r4);
            return;
        }
    }

    static {
        a = Companion.b;
    }

    void a();

    void b(String r1, Map<String, ? extends Object> r2, String r3);

    void init();
}
