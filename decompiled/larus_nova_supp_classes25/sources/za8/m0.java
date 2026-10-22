package za8;

import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetailWithSwitch;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m0 implements Function0 {
    public /* synthetic */ m0() {
    }

    public final Object invoke() {
        FeatureConfig r1 = p0.a();
        boolean r2 = false;
        if (r1 == null) goto L9;
        FeatureDetailWithSwitch r3 = r1.w0();
        if (r3 == null) goto L9;
        if (r3.b() != true) goto L9;
        boolean r4 = true;
    L10:
        FeatureConfig r5 = p0.a();
        if (r5 == null) goto L17;
        FeatureDetailWithSwitch r6 = r5.w0();
        if (r6 == null) goto L17;
        if (r6.a() != true) goto L17;
        boolean r7 = true;
    L18:
        FeatureConfig r8 = p0.a();
        if (r8 == null) goto L26;
        FeatureDetailWithSwitch r9 = r8.w0();
        if (r9 == null) goto L26;
        if (r9.c() != true) goto L26;
        r2 = true;
    L26:
        return new FeatureDetailWithSwitch(r4, r7, r2);
    L17:
        r7 = false;
    L9:
        r4 = false;
        goto L10
    }
}
