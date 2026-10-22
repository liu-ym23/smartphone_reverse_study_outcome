package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ CompatComponentScheduler a;

    public d(CompatComponentScheduler r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (this.a.o == true) goto L21;
        if (r4 == null) goto L7;
        String r5 = r4.getKey();
    L8:
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.hashCode() == 1457041107) goto L14;
        return;
    L14:
        if (r5.equals("cmd_fs_widget_loaded") == false) goto L19;
        IComponentScheduler.a r6 = this.a.m;
        if (r6 == null) goto L20;
        r6.b(IComponentScheduler.LoadBatch.FIRST_SCREEN);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
