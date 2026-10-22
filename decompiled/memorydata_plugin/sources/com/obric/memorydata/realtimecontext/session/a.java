package com.obric.memorydata.realtimecontext.session;

import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.realtimecontext.RealTimeContextService;
import com.obric.memorydata.sdk.assistant.QueryType;
import com.obric.memorydata.sdk.realtime.RealTimeContextResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J4\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006)"}, d2 = {"Lcom/obric/memorydata/realtimecontext/session/AbsRealTimeContextProcessor;", "Lcom/obric/memorydata/sdk/realtime/IRealTimeContextService$Stub;", "dispatcher", "Lcom/obric/memorydata/realtimecontext/RealTimeContextService;", "<init>", "(Lcom/obric/memorydata/realtimecontext/RealTimeContextService;)V", "getDispatcher", "()Lcom/obric/memorydata/realtimecontext/RealTimeContextService;", "callingPkg", "", "getCallingPkg", "()Ljava/lang/String;", "setCallingPkg", "(Ljava/lang/String;)V", "onHandleAssist", "", "assistStructure", "Landroid/app/assist/AssistStructure;", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "onHandleScreenshot", "screenshot", "Landroid/graphics/Bitmap;", "queryRealTimeContext", "Lcom/obric/memorydata/sdk/realtime/RealTimeContextResult;", ChatMessage.TYPE_QUERY, "rewriteQuery", "queryId", "onHandleAssistWithCallback", "", "callback", "Lcom/obric/memorydata/sdk/realtime/IRealTimeContextCallback;", "actionContextStartMs", "", "onHandleQuery", "queryType", "Lcom/obric/memorydata/sdk/assistant/QueryType;", "provideRealTimeData", "Lcom/obric/memorydata/realtimecontext/session/RealTimeData;", "clear", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a extends com.obric.memorydata.sdk.realtime.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RealTimeContextService f12480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12481b;

    public a(RealTimeContextService r2) {
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        this.f12480a = r2;
    }

    public final RealTimeContextService a() {
        return this.f12480a;
    }

    @Override // com.obric.memorydata.sdk.realtime.b
    public RealTimeContextResult a(String r1, String r2, String r3) {
        return RealTimeContextResult.Companion.a();
    }

    @Override // com.obric.memorydata.sdk.realtime.b
    public void a(AssistStructure r1, List<? extends AppEntity> r2) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.sdk.realtime.b
    public void a(AssistStructure r1, List<AppEntity> r2, com.obric.memorydata.sdk.realtime.a r3) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.realtime.a r4 = (com.obric.memorydata.sdk.realtime.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.sdk.realtime.a.class, "com.obric.memorydata.plugin");
    }

    public void a(AssistStructure r1, List<AppEntity> r2, com.obric.memorydata.sdk.realtime.a r3, long r4) {
        a(r1, (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.sdk.realtime.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.sdk.realtime.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.sdk.realtime.b
    public void a(Bitmap r1) {
    }

    public void a(QueryType r1) {
        Intrinsics.checkNotNullParameter(r1, "queryType");
    }

    public final void a(String r1) {
        this.f12481b = r1;
    }

    public abstract c b();

    public void c() {
        b().j();
    }
}
