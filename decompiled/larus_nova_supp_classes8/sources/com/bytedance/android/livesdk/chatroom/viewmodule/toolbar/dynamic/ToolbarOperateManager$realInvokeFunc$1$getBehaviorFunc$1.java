package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "p1", "", "p2", "p3", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;ZZ)Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ToolbarOperateManager$realInvokeFunc$1$getBehaviorFunc$1 extends FunctionReferenceImpl implements Function3<s, Boolean, Boolean, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b> {
    public ToolbarOperateManager$realInvokeFunc$1$getBehaviorFunc$1(k r8) {
        super(3, r8, k.class, "getOrCreateBehavior", "getOrCreateBehavior(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/NewToolbarModel;ZZ)Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/IToolbarManager$IToolbarBehavior;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((s) r1, ((Boolean) r2).booleanValue(), ((Boolean) r3).booleanValue());
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b invoke(s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return ((k) ((CallableReference) this).receiver).b(r2, r3, r4);
    }
}
