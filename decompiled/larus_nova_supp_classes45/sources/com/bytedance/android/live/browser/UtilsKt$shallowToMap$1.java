package com.bytedance.android.live.browser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u0016\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u00042\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "T", "key", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class UtilsKt$shallowToMap$1 extends Lambda implements Function1<String, Pair<? extends String, Object>> {
    final /* synthetic */ JsonObject $this_shallowToMap;
    final /* synthetic */ Function2 $transformValue;

    public UtilsKt$shallowToMap$1(JsonObject r1, Function2 r2) {
        this.$this_shallowToMap = r1;
        this.$transformValue = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }

    public final Pair<String, Object> invoke(String r4) {
        Function2 r1 = this.$transformValue;
        JsonElement r2 = this.$this_shallowToMap.get(r4);
        Intrinsics.checkNotNull(r2);
        return new Pair(r4, r1.invoke(r4, r2));
    }
}
