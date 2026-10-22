package com.obric.memorydata.sdk.server.assistant;

import android.content.Intent;
import android.os.IBinder;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.assistant.QueryContext;
import com.obric.memorydata.sdk.assistant.WindowState;
import com.obric.memorydata.sdk.server.IPoolService;
import com.obric.memorydata.sdk.service.BinderCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/server/assistant/AssistantStateService;", "Lcom/obric/memorydata/sdk/server/IPoolService;", "<init>", "()V", "provideBinderCode", "Lcom/obric/memorydata/sdk/service/BinderCode;", "provideBinder", "Landroid/os/IBinder;", "Companion", "AssistantStateBinder", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantStateService implements IPoolService {
    public static final b Companion = null;
    private static final String TAG = "AssistantStateService";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/sdk/server/assistant/AssistantStateService$AssistantStateBinder;", "Lcom/obric/memorydata/sdk/assistant/IAssistantStateService$Stub;", "<init>", "()V", "onActive", "", "onQuery", "queryContext", "Lcom/obric/memorydata/sdk/assistant/QueryContext;", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a extends com.obric.memorydata.sdk.assistant.a.AbstractBinderC0691a {
        public a() {
        }

        @Override // com.obric.memorydata.sdk.assistant.a
        public void a() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AssistantStateService.TAG, "onActive", false, 4, null);
            Collection<com.obric.memorydata.sdk.server.assistant.b> r8 = com.obric.memorydata.sdk.server.assistant.a.f12858a.a().values();
            Intrinsics.checkNotNullExpressionValue(r8, "<get-values>(...)");
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r9.hasNext() == false) goto L6;
            ((com.obric.memorydata.sdk.server.assistant.b) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.sdk.server.assistant.b.class, "com.obric.memorydata.plugin")).a();
            goto L4
        }

        @Override // com.obric.memorydata.sdk.assistant.a
        public void a(QueryContext r9) {
            Intrinsics.checkNotNullParameter(r9, "queryContext");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AssistantStateService.TAG, "onQuery: " + r9, false, 4, null);
            WindowState r8 = WindowState.Companion.a(r9.getWindowState());
            if (r8 != null) goto L5;
            r8 = WindowState.NA;
        L5:
            com.obric.memorydata.sdk.server.assistant.a.f12858a.a(r8);
            Collection<com.obric.memorydata.sdk.server.assistant.b> r10 = com.obric.memorydata.sdk.server.assistant.a.f12858a.a().values();
            Intrinsics.checkNotNullExpressionValue(r10, "<get-values>(...)");
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            ((com.obric.memorydata.sdk.server.assistant.b) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.sdk.server.assistant.b.class, "com.obric.memorydata.plugin")).a(r9);
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/server/assistant/AssistantStateService$Companion;", "", "<init>", "()V", "TAG", "", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new b(null);
    }

    public AssistantStateService() {
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onBind(Intent r1) {
        IPoolService.a.a(this, r1);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onCreate() {
        IPoolService.a.a(this);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onDestroy() {
        IPoolService.a.b(this);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public boolean onUnbind(Intent r1) {
        return IPoolService.a.b(this, r1);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public IBinder provideBinder() {
        return (IBinder) ZeusTransformUtils.preCheckCast(new a(), IBinder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public BinderCode provideBinderCode() {
        return BinderCode.ASSISTANT_STATE;
    }
}
