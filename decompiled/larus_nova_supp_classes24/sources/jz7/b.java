package jz7;

import android.content.Context;
import com.bytedance.ee.lark.plugin_annotation.bean.PluginEnv;
import com.larksuite.component.openplatform.plugins.container.DefaultContainerPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends a {
    public b(Context r2) {
        super(r2);
        PluginEnv r3 = PluginEnv.APP_ENV;
        this.a.b(new DefaultContainerPlugin(this));
    }
}
