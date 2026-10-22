package com.obric.livecard.api.entity;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/obric/livecard/api/entity/TransitionAnimation;", "", "(Ljava/lang/String;I)V", "SCALE", "VIBRATE", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum TransitionAnimation extends Enum<TransitionAnimation> {
    private static final /* synthetic */ TransitionAnimation[] $VALUES = null;
    public static final Companion Companion = null;
    public static final TransitionAnimation SCALE = null;
    public static final TransitionAnimation VIBRATE = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/livecard/api/entity/TransitionAnimation$Companion;", "", "()V", "fromString", "Lcom/obric/livecard/api/entity/TransitionAnimation;", EventBody.KEY_VALUE, "", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final TransitionAnimation fromString(String r2) {
            Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            Object r3 = Result.m1421constructorimpl(TransitionAnimation.valueOf(r2));     // Catch: Throwable -> L5
        L8:
            if (Result.m1427isFailureimpl(r3) == false) goto L11;
            r3 = null;
        L11:
            return (TransitionAnimation) ZeusTransformUtils.preCheckCast(r3, TransitionAnimation.class, "com.obric.memorydata.plugin");
        L5:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L8
        }
    }

    private static final /* synthetic */ TransitionAnimation[] $values() {
        return new TransitionAnimation[]{SCALE, VIBRATE};
    }

    static {
        SCALE = new TransitionAnimation("SCALE", 0);
        VIBRATE = new TransitionAnimation("VIBRATE", 1);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private TransitionAnimation(String r1, int r2) {
        super(r1, r2);
    }

    public static TransitionAnimation valueOf(String r2) {
        return (TransitionAnimation) ZeusTransformUtils.preCheckCast(Enum.valueOf(TransitionAnimation.class, r2), TransitionAnimation.class, "com.obric.memorydata.plugin");
    }

    public static TransitionAnimation[] values() {
        return (TransitionAnimation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TransitionAnimation[].class, "com.obric.memorydata.plugin");
    }
}
