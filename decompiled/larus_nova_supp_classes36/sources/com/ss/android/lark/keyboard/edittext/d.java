package com.ss.android.lark.keyboard.edittext;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int d = 0;
    public final KeyboardFunctionEditText a;
    public final CoroutineScope b;
    public final ExecutorCoroutineDispatcher c;

    public static final class a {
    }

    static {
    }

    public d(KeyboardFunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        this.a = r2;
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
        this.c = ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
    }
}
