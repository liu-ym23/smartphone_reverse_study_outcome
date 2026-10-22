package com.ss.android.lark.locationmessage.ui.navigation;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.location.dto.Scene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b extends IModel {
    void S(Context r1, Token r2, Scene r3, u r4);

    boolean isAdminGpsEnabled();
}
