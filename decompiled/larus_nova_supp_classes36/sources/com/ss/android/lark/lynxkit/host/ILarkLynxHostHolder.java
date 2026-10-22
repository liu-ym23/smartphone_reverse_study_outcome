package com.ss.android.lark.lynxkit.host;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&J\u001e\u0010\t\u001a\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J\u001c\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&J\u001c\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001H&J\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H&¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/ILarkLynxHostHolder;", "", "load", "", "updateGlobalProps", "globalProps", "", "", "globalPropsJson", "updateData", "data", "json", "updateShareData", "shareData", "updateSize", "widthMeasureSpec", "", "heightMeasureSpec", "sendEvent", "name", "params", "", "getContainer", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "isDestroyed", "", "destroy", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface ILarkLynxHostHolder {
    void destroy();

    ILarkLynxContainer getContainer();

    boolean isDestroyed();

    void load();

    void sendEvent(String r1, Object r2);

    void sendEvent(String r1, List<? extends Object> r2);

    void updateData(String r1);

    void updateData(Map<String, ? extends Object> r1);

    void updateGlobalProps(String r1);

    void updateGlobalProps(Map<String, ? extends Object> r1);

    void updateShareData(Map<String, ? extends Object> r1);

    void updateSize(int r1, int r2);
}
