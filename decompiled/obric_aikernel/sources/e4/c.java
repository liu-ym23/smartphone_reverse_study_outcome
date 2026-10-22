package e4;

import androidx.annotation.Nullable;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.obric.aikernel.middleware.impl.settings.api.AppInfoSettings$$Impl;
import com.obric.aikernel.middleware.impl.settings.api.PluginInfoSettings$$Impl;
import f4.h;

/* JADX INFO: loaded from: classes.dex */
public class c {
    @Nullable
    public static ISettings a(String r10, final h r11) {
        if ("com.obric.aikernel.middleware.impl.settings.api.AppInfoSettings".equals(r10) == false) goto L7;
        return new AppInfoSettings$$Impl(r11);
    L7:
        if ("com.obric.aikernel.middleware.impl.settings.api.PluginInfoSettings".equals(r10) == true) goto L9;
        return null;
    L9:
        return new PluginInfoSettings$$Impl(r11);
    }
}
