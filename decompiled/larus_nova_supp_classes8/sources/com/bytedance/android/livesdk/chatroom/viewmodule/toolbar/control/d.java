package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface d {
    void bindDisposable(Disposable r1);

    void checkDataBeforeShowDialog(a r1);

    boolean hasDynamicData();

    boolean isRequesting();

    void requestData(int r1, Function1<? super Boolean, Unit> r2, Function1<? super Throwable, Unit> r3);
}
