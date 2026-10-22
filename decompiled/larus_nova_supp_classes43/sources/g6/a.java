package g6;

import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends AbstractBaseConfig {
    public final String c;
    public final int d;
    public final Function1<AbstractBaseConfig, Unit> e;

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig, com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final AccessiblityScope getScope() {
        return AccessiblityScope.ViewGroup;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig, com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final int layoutRoot() {
        return this.d;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig, com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final String name() {
        return this.c;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final void config(ViewVirtualNode r1) {
        Function1<AbstractBaseConfig, Unit> r10 = this.e;
        if (r10 == null) goto L6;
        Unit r11 = (Unit) r10.invoke(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r1, int r10, Function1<? super AbstractBaseConfig, Unit> r11) {
        this.c = r1;
        this.d = r10;
        this.e = r11;
    }
}
