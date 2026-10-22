package com.obric.memorydata.ui;

import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ui/FloatingTitleBarOwner;", "", "getCurrentFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "getCurrentFloatingTitleBarActionHost", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static OFloatingTitleBarActionHost a(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            return null;
        }
    }

    OFloatingTitleBar getCurrentFloatingTitleBar();

    OFloatingTitleBarActionHost getCurrentFloatingTitleBarActionHost();
}
