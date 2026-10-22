package com.bytedance.ies.abmock.datacenter.storage.cdn;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class CDNConfigInfoRepo$gson$2 extends Lambda implements Function0<Gson> {
    public static final CDNConfigInfoRepo$gson$2 INSTANCE = null;

    static {
        INSTANCE = new CDNConfigInfoRepo$gson$2();
    }

    CDNConfigInfoRepo$gson$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Gson invoke() {
        return new Gson();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Gson invoke() {
        return invoke();
    }
}
