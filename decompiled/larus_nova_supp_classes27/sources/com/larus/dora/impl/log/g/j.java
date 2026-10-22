package com.larus.dora.impl.log.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements ff7.e {
    public final /* synthetic */ long a;

    public final void onSuccess() {
        g49.d.d("DoraGLogManager", "upload log success");
        DoraGLogManager.a.r(true, "upload log success");
        int r0 = a.a;
        a.b(0, System.currentTimeMillis() - this.a);
    }

    public j(long r1) {
        this.a = r1;
    }

    public final void onFail(String r5) {
        g49.d.b("DoraGLogManager", "upload log failed msg:" + r5);
        DoraGLogManager.a.r(false, "upload log failed");
        int r6 = a.a;
        a.b(1, System.currentTimeMillis() - this.a);
    }
}
