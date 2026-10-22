package com.obric.assistant.feedback;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements IIMCallback<Map<String, ? extends Message>> {
    public final /* synthetic */ Set<String> a;
    public final /* synthetic */ i<ObricFeedbackService$b> b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        this.b.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r5) {
        Map r6 = (Map) r5;
        Intrinsics.checkNotNullParameter(r6, WindowEvent.Params.RESULT);
        Set<String> r0 = this.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        Message r3 = (Message) r6.get((String) r2.next());
        if (r3 == null) goto L8;
        String r4 = com.larus.im.bean.message.a.x(r3);
    L9:
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r1.add(r4);
        goto L4
    L8:
        r4 = null;
        goto L9
    L12:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r1.iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        Object r9 = r8.next();
        if (o0.d((String) r9) == false) goto L14;
        r7.add(r9);
        goto L14
    L18:
        List r10 = CollectionsKt.distinct(r7);
        i<ObricFeedbackService$b> r11 = this.b;
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.constructor-impl(new ObricFeedbackService$b(r6, r10)));
    }

    public c(Set r1, j r2) {
        this.a = r1;
        this.b = r2;
    }
}
