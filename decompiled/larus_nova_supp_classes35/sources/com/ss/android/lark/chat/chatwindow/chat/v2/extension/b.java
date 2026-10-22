package com.ss.android.lark.chat.chatwindow.chat.v2.extension;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larksuite.framework.callback.UICallbackExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final MediatorLiveData a(MutableLiveData r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r2, new ExtensionsKt$distinctUntilChanged$1(r0));
        return r0;
    }

    public static final void b(final MutableLiveData r3, LifecycleOwner r4, final Observer r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "observer");
        Object r0 = r3.getValue();
        if (r0 != null) goto L5;
    L7:
        r3.observe(r4, new ExtensionsKt$observeOnce$2(r5, r3));
        return;
    L5:
        if (r4.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        UICallbackExecutor.execute(new a(r5, r0));
        goto L7
    }
}
