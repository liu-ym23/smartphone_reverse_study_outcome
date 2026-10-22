package com.larus.bmhome.chat.component.receive;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ ChatReceiveServiceComponent a;

    public /* synthetic */ r(ChatReceiveServiceComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        ChatReceiveServiceComponent r0 = this.a;
        List r10 = (List) r9;
        int r1 = ChatReceiveServiceComponent.x;
        Intrinsics.checkNotNullParameter(r10, "uris");
        r0.getClass();
        if (z2.a.optPasteFile() == false) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new ChatReceiveServiceComponent$onPasteUris$1(r0, r10, null), 3, null);
    L10:
        return Unit.INSTANCE;
    L6:
        if (ChatReceiveServiceComponent.X2(r10) == true) goto L10;
        r0.m3(r10);
        goto L10
    }
}
