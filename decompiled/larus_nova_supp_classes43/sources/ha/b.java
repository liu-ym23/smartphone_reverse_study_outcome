package ha;

import com.bytedance.android.annie.business.lynx.AnnieXLivePropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.base.service.AnnieXServiceProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends AnnieXServiceProvider {
    @Override // com.bytedance.android.anniex.base.service.AnnieXServiceProvider
    public final IAnnieXBizPropsProvider createIAnnieXBizPropsProvider() {
        return new AnnieXLivePropsProvider();
    }

    public b() {
    }
}
