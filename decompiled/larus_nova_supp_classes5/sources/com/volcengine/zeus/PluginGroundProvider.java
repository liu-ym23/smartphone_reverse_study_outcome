package com.volcengine.zeus;

import com.volcengine.zeus.plugin.i;
import gqc.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0004¨\u0006\n"}, d2 = {"Lcom/volcengine/zeus/PluginGroundProvider;", "", "()V", "isForeground", "", "pluginPkg", "", "onAppGroundChanged", "", "isActive", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class PluginGroundProvider {
    public PluginGroundProvider() {
    }

    public abstract boolean isForeground(String r1);

    public final void onAppGroundChanged(boolean r1) {
        i.b();
        if (r1 == true) goto L6;
        b.a().b();
        return;
    }
}
