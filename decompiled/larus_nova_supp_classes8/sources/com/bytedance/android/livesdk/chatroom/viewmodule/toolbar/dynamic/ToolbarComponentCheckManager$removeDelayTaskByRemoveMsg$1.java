package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ s $model;

    public ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$1(s r1) {
        this.$model = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m229invoke() {
        Lazy r0 = ToolbarComponentCheckManager.a;
        Iterator<T> r1 = ToolbarComponentCheckManager.e.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        NewToolbarButtonConstants r2 = (NewToolbarButtonConstants) r1.next();
        if (r2.getId() != this.$model.a) goto L4;
        Lazy r3 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e.remove(r2);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m229invoke();
        return Unit.INSTANCE;
    }
}
