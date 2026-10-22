package com.obric.aikernel.middleware.interfaces;

import android.os.Bundle;
import com.obric.aikernel.sdk.config.RequestParams;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void notifyVMExecuteBegin(RequestParams r10, Bundle r11);

    void notifyVMExecuteEnd(RequestParams r10);
}
