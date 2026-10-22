package com.obric.assistant.omnidetailpage.componment;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ kotlinx.coroutines.i<Message> a;

    public final boolean mustInMain() {
        return true;
    }

    public v(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        CoroutineExtKt.c(this.a, null);
    }

    public final void onSuccess(Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter(r5, WindowEvent.Params.RESULT);
        Iterator r6 = r5.iterator();
    L3:
        Object r1 = null;
        String r2 = null;
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        Map r3 = ((Message) r0).getExt();
        if (r3 == null) goto L9;
        r2 = (String) r3.get("o_event_task");
    L9:
        if (com.flow.kmp.common.util.f.a(r2) == false) goto L3;
        r1 = r0;
    L11:
        kotlinx.coroutines.i<Message> r7 = this.a;
        CoroutineExtKt.c(r7, (Message) r1);
    }
}
