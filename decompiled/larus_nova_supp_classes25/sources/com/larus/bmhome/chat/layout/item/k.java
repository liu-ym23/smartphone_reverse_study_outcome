package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class k extends xc8.h {
    public final Lazy p;
    public Integer q;

    public static final class a {
    }

    static {
    }

    public abstract void n(Message r1, boolean r2);

    public final boolean getShowProgress() {
        return ((Boolean) this.p.getValue()).booleanValue();
    }

    public final Integer getCurrentLoadingProgress() {
        return this.q;
    }

    public k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.p = LazyKt.lazy(new j());
    }

    public void o(int r4) {
        FLogger.a.i("BaseProgressLoadingBox", "onLoadingProgressUpdate " + r4);
        this.q = Integer.valueOf(r4);
    }

    public final void setCurrentLoadingProgress(Integer r1) {
        this.q = r1;
    }
}
