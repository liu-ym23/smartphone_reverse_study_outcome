package com.larus.uaigc.chat.loading;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;

    public /* synthetic */ b(String r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return ProgressLoadingViewModel.No(this.a, this.b, (Map) r3);
    }
}
