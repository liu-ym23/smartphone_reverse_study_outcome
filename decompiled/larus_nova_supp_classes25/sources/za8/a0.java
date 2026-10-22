package za8;

import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a0 implements Function0 {
    public /* synthetic */ a0() {
    }

    public final Object invoke() {
        FeatureConfig r1 = p0.a();
        boolean r2 = false;
        if (r1 == null) goto L9;
        FeatureDetail r3 = r1.R();
        if (r3 == null) goto L9;
        if (r3.b() == true) goto L9;
        boolean r4 = true;
    L10:
        boolean r5 = !r4;
        FeatureConfig r6 = p0.a();
        if (r6 == null) goto L18;
        FeatureDetail r7 = r6.R();
        if (r7 == null) goto L18;
        if (r7.a() == true) goto L18;
        r2 = true;
    L18:
        return new FeatureDetail(r5, !r2);
    L9:
        r4 = false;
        goto L10
    }
}
