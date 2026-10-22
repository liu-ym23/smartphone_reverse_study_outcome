package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.utils.SkinLoadResultType;
import com.bytedance.android.livesdk.chatroom.utils.a4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class SkinAnimationImgHandler$playAnimationOnce$controller$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a4 $callback;

    public SkinAnimationImgHandler$playAnimationOnce$controller$1(a4 r1) {
        this.$callback = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m219invoke() {
        a4 r0 = this.$callback;
        if (r0 == null) goto L6;
        r0.b(SkinLoadResultType.START, null);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m219invoke();
        return Unit.INSTANCE;
    }
}
