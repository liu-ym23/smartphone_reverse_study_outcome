package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.utils.FileUtils;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j0<T> implements SingleOnSubscribe {
    public final /* synthetic */ List a;

    public j0(List r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        FileUtils.removeFile((String) r0.next());
        goto L4
    L6:
        r3.onSuccess(Boolean.TRUE);
    }
}
