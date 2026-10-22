package com.bytedance.android.ec.core.monitor.param;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECParamTracker$enterPage$2 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ String $schema;
    final /* synthetic */ ECParamTracker this$0;

    public ECParamTracker$enterPage$2(ECParamTracker r1, String r10) {
        this.this$0 = r1;
        this.$schema = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m1393invoke() {
        return ECParamTracker.o(this.this$0, UriProtector.parse(this.$schema));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1393invoke();
    }
}
