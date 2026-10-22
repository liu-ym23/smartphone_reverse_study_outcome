package za8;

import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function0 {
    public /* synthetic */ d() {
    }

    public final Object invoke() {
        FeatureConfig r1 = p0.a();
        boolean r2 = false;
        if (r1 == null) goto L9;
        FeatureDetail r3 = r1.J();
        if (r3 == null) goto L9;
        if (r3.b() != true) goto L9;
        boolean r4 = true;
    L10:
        FeatureConfig r5 = p0.a();
        if (r5 == null) goto L18;
        FeatureDetail r6 = r5.J();
        if (r6 == null) goto L18;
        if (r6.a() != true) goto L18;
        r2 = true;
    L18:
        return new FeatureDetail(r4, r2);
    L9:
        r4 = false;
        goto L10
    }
}
