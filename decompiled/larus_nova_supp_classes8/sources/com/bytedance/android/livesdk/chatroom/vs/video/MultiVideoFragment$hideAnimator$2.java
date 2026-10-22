package com.bytedance.android.livesdk.chatroom.vs.video;

import android.animation.ObjectAnimator;
import com.bytedance.android.live.core.utils.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
public final class MultiVideoFragment$hideAnimator$2 extends Lambda implements Function0<ObjectAnimator> {
    final /* synthetic */ MultiVideoFragment this$0;

    public MultiVideoFragment$hideAnimator$2(MultiVideoFragment r1) {
        this.this$0 = r1;
        super(0);
    }

    public final ObjectAnimator invoke() {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.this$0.k, "alpha", new float[]{1.0f, 0.0f});
        h.a(r0, new MultiVideoFragment$hideAnimator$2$$special$$inlined$apply$lambda$1(this));
        r0.setDuration(300);
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m356invoke() {
        return invoke();
    }
}
