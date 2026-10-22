package com.bytedance.android.live.impl.service;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class FeatureManager$refreshFeature$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $name;

    public FeatureManager$refreshFeature$1(String r1) {
        this.$name = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m952invoke() {
        return "refreshFeature: " + this.$name;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m952invoke();
    }
}
