package com.bytedance.android.live.profit.livepet.container;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/google/gson/JsonObject;", "Lcom/bytedance/revenue/platform/api/core/JsonObject;", "p1", "Lqu0/a$b;", "invoke", "(Lcom/google/gson/JsonObject;)Lqu0/a$b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class LivePetGiftInterceptor$processSendGiftScheme$1 extends FunctionReferenceImpl implements Function1<JsonObject, qu0.a.b> {
    public static final LivePetGiftInterceptor$processSendGiftScheme$1 INSTANCE = null;

    static {
        INSTANCE = new LivePetGiftInterceptor$processSendGiftScheme$1();
    }

    public LivePetGiftInterceptor$processSendGiftScheme$1() {
        super(1, qu0.a.b.class, "<init>", "<init>(Lcom/google/gson/JsonObject;)V", 0);
    }

    public final qu0.a.b invoke(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return new qu0.a.b(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
