package com.ss.android.lark.lynxkit.host;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.http.model.http.HttpHeaders;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/ILarkLynxPageHolder;", "Lcom/ss/android/lark/lynxkit/host/ILarkLynxHostHolder;", "open", "", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface ILarkLynxPageHolder extends ILarkLynxHostHolder {
    void close();

    boolean open();
}
