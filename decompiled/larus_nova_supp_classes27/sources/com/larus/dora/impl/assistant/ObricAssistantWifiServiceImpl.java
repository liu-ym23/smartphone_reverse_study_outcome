package com.larus.dora.impl.assistant;

import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\f\u0010\u000f\u001a\u00020\u0005*\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\n*\u00020\u0012H\u0002¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/assistant/ObricAssistantWifiServiceImpl;", "Lcom/larus/dora/impl/assistant/AssistantWifiService;", "<init>", "()V", "requestWifi", "Lcom/larus/dora/impl/assistant/AssistantWifiOperationResult;", "owner", "", "releaseWifi", "queryWifiState", "Lcom/larus/dora/impl/assistant/AssistantWifiStateResult;", "setWifiEnabledForDebug", "enabled", "", "queryWifiStateForDebug", "toAssistantWifiOperationResult", "Lcom/larus/dora/impl/assistant/DoraWifiIntentResult;", "toAssistantWifiStateResult", "Lcom/larus/dora/impl/assistant/DoraWifiStateResult;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantWifiServiceImpl implements AssistantWifiService {
    public ObricAssistantWifiServiceImpl() {
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final c b() {
        DoraWifiIntentClientImpl.a.getClass();
        a.a.getClass();
        f r0 = a.a();
        return new c(r0.a, r0.b, r0.c, r0.d);
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final b a(String r14) {
        Intrinsics.checkNotNullParameter(r14, "owner");
        DoraWifiIntentClientImpl.a.getClass();
        Intrinsics.checkNotNullParameter(r14, "owner");
        Object r3 = DoraWifiIntentClientImpl.b;
        monitor-enter(r3);
        String r15 = StringsKt.trim(r14).toString();     // Catch: Throwable -> L27
        if (r15.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        int r16 = e.d;     // Catch: Throwable -> L27
        e r17 = e.a.a("invalid_owner", "owner is empty");     // Catch: Throwable -> L27
    L24:
        monitor-exit(r3);
        return new b(r17.a, r17.b, r17.c);
    L10:
        Set<String> r5 = DoraWifiIntentClientImpl.c;     // Catch: Throwable -> L27
        r5.add(r15);     // Catch: Throwable -> L27
        a.a.getClass();     // Catch: Throwable -> L27
        f r6 = a.a();     // Catch: Throwable -> L27
        if (r6.a == true) goto L17;
        r5.remove(r15);     // Catch: Throwable -> L27
        int r18 = e.d;     // Catch: Throwable -> L27
        String r110 = r6.c;     // Catch: Throwable -> L27
        if (r110 != null) goto L15;
        r110 = "query_wifi_state_failed";
    L15:
        r17 = e.a.a(r110, r6.d);     // Catch: Throwable -> L27
        goto L24
    L17:
        if (r6.b == false) goto L19;
        FLogger.a.i("DoraWifiIntentClient", "requestWifi success, already enabled, ownerCount=" + r5.size());     // Catch: Throwable -> L27
        r17 = new e(true, null, null);     // Catch: Throwable -> L27
        goto L24
    L19:
        DoraWifiIntentClientImpl.a r2 = DoraWifiIntentClientImpl.d(true);     // Catch: Throwable -> L27
        e r12 = r2.a;     // Catch: Throwable -> L27
        DoraWifiIntentClientImpl.c(StringsKt.substringAfterLast(r15, ":", r15), r12, r2.b, r2.c);     // Catch: Throwable -> L27
        if (r12.a == false) goto L22;
        DoraWifiIntentClientImpl.d = true;     // Catch: Throwable -> L27
        FLogger.a.i("DoraWifiIntentClient", "requestWifi success, opened by client, ownerCount=" + r5.size());     // Catch: Throwable -> L27
    L23:
        r17 = r12;
        goto L24
    L22:
        r5.remove(r15);     // Catch: Throwable -> L27
        FLogger.a.w("DoraWifiIntentClient", "requestWifi failed, errorCode=" + r12.b + ", ownerCount=" + r5.size());     // Catch: Throwable -> L27
        goto L23
    L7:
        r4 = false;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final b c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        DoraWifiIntentClientImpl.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "owner");
        Object r0 = DoraWifiIntentClientImpl.b;
        monitor-enter(r0);
        String r5 = StringsKt.trim(r4).toString();     // Catch: Throwable -> L16
        if (r5.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        FLogger.a.w("DoraWifiIntentClient", "releaseWifi ignored, owner is empty");     // Catch: Throwable -> L16
        int r6 = e.d;     // Catch: Throwable -> L16
        e r7 = e.a.a("invalid_owner", "owner is empty");     // Catch: Throwable -> L16
    L11:
        monitor-exit(r0);
        if (r7 != null) goto L20;
        return null;
    L20:
        return new b(r7.a, r7.b, r7.c);
    L10:
        DoraWifiIntentClientImpl.c.remove(r5);     // Catch: Throwable -> L16
        r7 = DoraWifiIntentClientImpl.b();     // Catch: Throwable -> L16
        goto L11
    L7:
        r1 = false;
    L16:
        th = move-exception;
        throw th;
    }
}
