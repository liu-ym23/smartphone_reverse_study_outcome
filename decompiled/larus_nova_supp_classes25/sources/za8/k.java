package za8;

import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Function0 {
    public /* synthetic */ k() {
    }

    public final Object invoke() {
        com.larus.bmhome.auth.e0 r0 = AuthModelDelegate.b.D();
        if (r0 == null) goto L5;
        FeatureDetail r1 = r0.z();
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r1 == null) goto L17;
        if (r1.a() != true) goto L17;
        r2 = true;
    L17:
        return new FeatureDetail(r4, r2);
    L9:
        if (r1.b() != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
