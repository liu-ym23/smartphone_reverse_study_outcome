package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class m implements Function1 {
    public /* synthetic */ m() {
    }

    public final Object invoke(Object r3) {
        Log.e("DraftService", "addDraft: error occurred: error is " + ((ErrorResult) r3).getDisplayMsg());
        return null;
    }
}
