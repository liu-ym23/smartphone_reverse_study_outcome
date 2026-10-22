package com.bytedance.ies.abmock.datacenter.event;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ABMockEvent$repoDataStore$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $endTime;
    final /* synthetic */ Ref.ObjectRef<String> $errorMessage;
    final /* synthetic */ String $repoName;
    final /* synthetic */ long $startTime;
    final /* synthetic */ Ref.IntRef $status;
    final /* synthetic */ a this$0;

    ABMockEvent$repoDataStore$1(a r1, String r2, Ref.IntRef r3, long r4, long r6, Ref.ObjectRef<String> r8) {
        this.this$0 = r1;
        this.$repoName = r2;
        this.$status = r3;
        this.$endTime = r4;
        this.$startTime = r6;
        this.$errorMessage = r8;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        JSONObject r0 = new JSONObject();
        String r1 = this.$repoName;
        Ref.IntRef r2 = this.$status;
        long r3 = this.$endTime;
        long r5 = this.$startTime;
        Ref.ObjectRef<String> r7 = this.$errorMessage;
        r0.put("repo_name", r1);
        r0.put("repo_store_code", r2.element);
        r0.put("repo_store_time", (r3 - r5) / ((long) 1000));
        String r4 = (String) ZeusTransformUtils.preCheckCast(r7.element, String.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        r0.put(InfoRequestQPSOptTraceLogger.ERROR_MESSAGE, r4);
    L5:
        JSONArray r6 = a.i(this.this$0);
        a r9 = this.this$0;
        monitor-enter(r6);
        a.i(r9).put(r0);     // Catch: Throwable -> L13
        Keva r8 = a.b(r9);     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        r8.storeString(a.j(r9), a.i(r9).toString());     // Catch: Throwable -> L13
    L10:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r6);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
