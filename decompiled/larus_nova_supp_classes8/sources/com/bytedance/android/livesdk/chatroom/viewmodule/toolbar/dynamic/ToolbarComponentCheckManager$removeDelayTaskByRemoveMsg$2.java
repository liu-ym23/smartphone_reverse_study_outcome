package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/y;", "it", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/y;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$2 extends Lambda implements Function1<y, Unit> {
    final /* synthetic */ s $model;

    public ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$2(s r1) {
        this.$model = r1;
        super(1);
    }

    public final void invoke(y r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        s r0 = this.$model;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "model");
        Iterator<T> r1 = r6.c.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        NewToolbarButtonConstants r2 = (NewToolbarButtonConstants) r1.next();
        if (r2.getId() != r0.a) goto L4;
        r6.c.remove(r2);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((y) r1);
        return Unit.INSTANCE;
    }
}
