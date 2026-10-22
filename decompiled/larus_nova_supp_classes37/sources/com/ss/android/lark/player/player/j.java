package com.ss.android.lark.player.player;

import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.SeekCompletionListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements SeekCompletionListener {
    public final WeakReference<s> a;

    public static final class a {
    }

    static {
    }

    public j(s r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        this.a = new WeakReference(r2);
    }

    public final void onCompletion(boolean r3) {
        Log.i("LarkSeekCompletionListener", "EVENT_CODE_SEEK_COMPLETE");
        s r4 = this.a.get();
        if (r4 == null) goto L5;
        r4.a(-99014, null);
    L5:
        s r5 = this.a.get();
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.c() != r5.d()) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L15;
        r5.h();
        return;
    L15:
        return;
    L10:
        r0 = false;
        goto L11
    }
}
