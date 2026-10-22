package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a<T extends ILaunchDataInput> {
    Object a(T r1, BaseBundle r2, Continuation<? super Result<d>> r3);
}
