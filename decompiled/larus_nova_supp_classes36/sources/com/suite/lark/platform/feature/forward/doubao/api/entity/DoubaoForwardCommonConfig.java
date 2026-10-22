package com.suite.lark.platform.feature.forward.doubao.api.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import npc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoForwardCommonConfig {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&¨\u0006\f"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoForwardCommonConfig$ForwardContentListener;", "Ljava/io/Serializable;", "onSuccess", "", "result", "", "", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoInfo;", "onFailed", "", "errorTitle", "errorMessage", "forward-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public interface ForwardContentListener extends Serializable {
        void onFailed(String r1, String r2);

        boolean onSuccess(Map<String, c> r1);
    }

    public DoubaoForwardCommonConfig() {
    }
}
