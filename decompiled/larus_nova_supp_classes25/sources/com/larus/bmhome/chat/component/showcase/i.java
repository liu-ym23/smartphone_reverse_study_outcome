package com.larus.bmhome.chat.component.showcase;

import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.platform.model.showcase.Case;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ ChatCaseMessageComponent a;

    public /* synthetic */ i(ChatCaseMessageComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r12) {
        ChatCaseMessageComponent r0 = this.a;
        int r1 = ChatCaseMessageComponent.z;
        Intrinsics.checkNotNullParameter((Button) r12, "it");
        u7 r13 = (u7) r0.q.getValue();
        if (r13 == null) goto L5;
        r13.a90();
    L5:
        y r14 = (y) r0.w.getValue();
        if (r14 == null) goto L8;
        r14.JG(false);
    L8:
        String r15 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new ChatCaseMessageComponent$onViewCreated$2$1(r0, null), 3, null);
        e r2 = (e) AuthModelDelegate.b.y().getValue();
        if (r2 == null) goto L15;
        String r3 = r2.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Fragment r4 = com.larus.ui.arch.component.internal.attach.a.b(r0, r0);
        if (r4 == null) goto L15;
        LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(r4);
        if (r5 == null) goto L15;
        BuildersKt.launch$default(r5, null, null, new ChatCaseMessageComponent$onViewCreated$2$2$1$1(r3, r0, r2, null), 3, null);
    L15:
        String r6 = r0.Y2();
        Case r7 = r0.mz(false);
        if (r7 == null) goto L18;
        r15 = r7.getRequestId();
    L18:
        tx9.w.a("continue_talk", r15, r6);
        return Unit.INSTANCE;
    }
}
