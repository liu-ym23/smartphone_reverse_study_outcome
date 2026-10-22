package com.obric.capabilitykit.common.intent;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"E", "Lcom/google/gson/Gson;", "invoke", "()Lcom/google/gson/Gson;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class IntentResult$a extends Lambda implements Function0<Gson> {
    public static final IntentResult$a a = null;

    static {
        a = new IntentResult$a();
    }

    public IntentResult$a() {
        super(0);
    }

    public final Gson a() {
        return new Gson();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return a();
    }
}
