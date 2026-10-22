package com.ss.android.lark.lynxkit.container;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "", "containerType", "", "getContainerType", "()Ljava/lang/String;", "getBizExtra", "", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface ILynxContainerContext {
    Map<String, Object> getBizExtra();

    String getContainerType();
}
