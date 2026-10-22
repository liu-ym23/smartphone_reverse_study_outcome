package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n extends com.ss.android.lark.appcontext.applifecycle.a {
    public final WeakReference<Activity> a;

    public static final class a {
    }

    static {
    }

    public n(WeakReference<Activity> r2) {
        Intrinsics.checkNotNullParameter(r2, "curActivity");
        this.a = r2;
    }

    public final void onActivityCreated(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Activity r4 = this.a.get();
        if (r4 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r2, this.a.get()) == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r2.getClass().getName(), r4.getClass().getName()) == false) goto L12;
        Log.i("MsgFullScreenLifeCycle", "new instance start, finish current Activity!");
        r4.finish();
        return;
    }
}
