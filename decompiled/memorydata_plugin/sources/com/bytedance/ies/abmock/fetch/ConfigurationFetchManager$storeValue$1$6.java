package com.bytedance.ies.abmock.fetch;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ConfigurationFetchManager$storeValue$1$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsonObject $abJsonObject;
    final /* synthetic */ a $interceptor;

    ConfigurationFetchManager$storeValue$1$6(a r1, JsonObject r2) {
        this.$interceptor = r1;
        this.$abJsonObject = r2;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a r0 = this.$interceptor;
        if (r0 == null) goto L6;
        r0.a(this.$abJsonObject);
        return;
    }
}
