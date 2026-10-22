package com.larus.dora.impl.ota.g2;

import com.larus.dora.impl.ota.connector.DoraOTAWifiConnector;
import com.larus.dora.impl.ota.connector.h;
import g49.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements h {
    final /* synthetic */ p4$a $callback;
    final /* synthetic */ e $key;
    final /* synthetic */ long $operationId;
    final /* synthetic */ String $ownerId;
    final /* synthetic */ i this$0;

    @Override // com.larus.dora.impl.ota.connector.h
    public final void onSuccess(long r4) {
        d.d("G2OtaTransport", "upload success owner=" + this.$ownerId + " operation=" + this.$operationId + " upload=" + r4);
        this.$callback.b(true, FailureReason.NONE);
        DoraOTAWifiConnector r5 = i.f(this.this$0);
        i r6 = this.this$0;
        e r0 = this.$key;
        String r1 = this.$ownerId;
        r6.getClass();
        String r7 = i.l(r0, r1);
        r5.getClass();
        DoraOTAWifiConnector.g(r7);
    }

    @Override // com.larus.dora.impl.ota.connector.h
    public final void b(long r1, int r3) {
        this.$callback.c(r3);
    }

    @Override // com.larus.dora.impl.ota.connector.h
    public final void a(long r3, int r5, String r6) {
        d.b("G2OtaTransport", "upload failed owner=" + this.$ownerId + " operation=" + this.$operationId + " upload=" + r3 + " code=" + r5);
        this.$callback.b(false, FailureReason.TRANSFER_FAILED);
        DoraOTAWifiConnector r4 = i.f(this.this$0);
        i r7 = this.this$0;
        e r8 = this.$key;
        String r9 = this.$ownerId;
        r7.getClass();
        String r10 = i.l(r8, r9);
        r4.getClass();
        DoraOTAWifiConnector.g(r10);
    }

    public j(p4$a r1, String r2, long r3, i r5, e r6) {
        this.$callback = r1;
        this.$ownerId = r2;
        this.$operationId = r3;
        this.this$0 = r5;
        this.$key = r6;
    }
}
