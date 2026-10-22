package com.lynx.devtoolwrapper;

import android.content.Context;
import com.lynx.tasm.LynxError;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxLogBox {
    void attachContext(Context r1);

    void onLoadTemplate();

    void showLogMessage(LynxError r1);
}
