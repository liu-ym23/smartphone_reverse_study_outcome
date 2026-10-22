package y9a;

import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.aiagent.product.platform.impl.rom.PublicRomInfoImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class b implements ServiceProvider {
    public /* synthetic */ b() {
    }

    public final Object get() {
        RomInfo r0 = RomInfo.a;
        return new PublicRomInfoImpl();
    }
}
