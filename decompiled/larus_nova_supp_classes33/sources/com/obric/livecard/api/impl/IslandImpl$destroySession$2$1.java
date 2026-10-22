package com.obric.livecard.api.impl;

import com.obric.livecard.api.entity.IslandSession;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/livecard/api/entity/IslandSession;", "invoke", "(Lcom/obric/livecard/api/entity/IslandSession;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class IslandImpl$destroySession$2$1 extends Lambda implements Function1<IslandSession, Boolean> {
    final /* synthetic */ IslandSession $session;

    public IslandImpl$destroySession$2$1(IslandSession r1) {
        this.$session = r1;
        super(1);
    }

    public final Boolean invoke(IslandSession r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        if (r5.getTaskId() != this.$session.getTaskId()) goto L5;
        boolean r6 = true;
    L7:
        return Boolean.valueOf(r6);
    L5:
        r6 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IslandSession) r1);
    }
}
