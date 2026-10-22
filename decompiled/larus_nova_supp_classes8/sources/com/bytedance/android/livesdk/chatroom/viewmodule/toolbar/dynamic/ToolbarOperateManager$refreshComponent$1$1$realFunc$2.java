package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "p1", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "kotlin.jvm.PlatformType", "p2", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ToolbarOperateManager$refreshComponent$1$1$realFunc$2 extends FunctionReferenceImpl implements Function2<s, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Unit> {
    public ToolbarOperateManager$refreshComponent$1$1$realFunc$2(x3 r8) {
        super(2, r8, x3.class, "unloadNetButton", "unloadNetButton(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/NewToolbarModel;Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/IToolbarManager$IToolbarBehavior;)V", 0);
    }

    public final void invoke(s r2, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((x3) ((CallableReference) this).receiver).G(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((s) r1, (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) r2);
        return Unit.INSTANCE;
    }
}
