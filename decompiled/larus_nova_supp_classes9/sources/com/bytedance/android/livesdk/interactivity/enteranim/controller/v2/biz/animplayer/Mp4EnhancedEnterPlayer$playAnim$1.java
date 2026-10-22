package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"finished", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
public final class Mp4EnhancedEnterPlayer$playAnim$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.BooleanRef $isFinished;
    final /* synthetic */ a $playerListener;
    final /* synthetic */ Mp4EnhancedEnterPlayer this$0;

    public Mp4EnhancedEnterPlayer$playAnim$1(Mp4EnhancedEnterPlayer r1, Ref.BooleanRef r2, a r3) {
        this.this$0 = r1;
        this.$isFinished = r2;
        this.$playerListener = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m659invoke() {
        Ref.BooleanRef r0 = this.$isFinished;
        if (r0.element == false) goto L5;
        return;
    L5:
        r0.element = true;
        this.this$0.f = null;
        ((v72.c.a) this.$playerListener).a();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m659invoke();
        return Unit.INSTANCE;
    }
}
