package com.bytedance.android.livesdk.interactivity.answer;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x61.c;
import x61.f;
import x61.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AnswerQuestionCard extends v61.a {
    public final MsgWindowPosition m;
    public final HybridCard n;

    public final h<?, ?> content() {
        h.a r0 = h.a;
        Function1<c.a, View> r1 = new AnonymousClass1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "inflate");
        return new f(r1);
    }

    public final void dismissWindow() {
        this.n.release();     // Catch: Exception -> L4
    L6:
        dismiss();
        return;
    L4:
        e = move-exception;
        ALogger.d("AnswerQuestionCard", "Dismiss Answer Card：" + ExceptionsKt.stackTraceToString(e));
        goto L6
    }

    public final CardConstraint z() {
        CardConstraint r0 = new CardConstraint(-2, -2);
        r0.b(CardConstraint.Position.TopLeft);
        return r0;
    }

    public final MsgWindowPosition getPosition() {
        return this.m;
    }

    public AnswerQuestionCard(HybridCard r2, DataCenter r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "contentView");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "cardType");
        super(r3, r4, 1);
        this.n = r2;
        this.m = MsgWindowPosition.TOP_LEFT;
    }
}
