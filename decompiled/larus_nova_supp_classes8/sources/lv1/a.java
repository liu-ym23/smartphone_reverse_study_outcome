package lv1;

import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdkapi.feature.IFeatureOuterService;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements IFeatureOuterService {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final IFeatureService getFeatureService() {
        return k.f(IFeatureService.class);
    }
}
