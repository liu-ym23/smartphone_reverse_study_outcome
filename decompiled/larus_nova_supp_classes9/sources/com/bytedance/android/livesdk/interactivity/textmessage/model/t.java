package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.view.View;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.LuckyBoxTextMessageParams;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdk.message.model.qa;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t extends com.bytedance.android.livesdk.interactivity.api.entity.f<qa> {
    public final LuckyBoxTextMessageParams G;

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        SpannableType r0 = SpannableType.NORMAL;
        int r1 = MessageCommonColorUtil.a;
        return MessageCommonColorUtil.e();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        SpannableType r0 = SpannableType.NORMAL;
        int r1 = MessageCommonColorUtil.a;
        return MessageCommonColorUtil.d();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        LuckyBoxTextMessageParams r0 = this.G;
        a5 r1 = null;
        if (r0 == null) goto L13;
        a5 r2 = r0.getText();
        if (r2 == null) goto L13;
        List r3 = r2.getPieces();
        if (r3 == null) goto L13;
        c5 r4 = (c5) ListProtector.get(r3, 0);
        if (r4 == null) goto L13;
        i5 r5 = r4.getUserValue();
        if (r5 == null) goto L13;
        IBaseUser r6 = r5.getUser();
    L14:
        if (r6 == null) goto L30;
        qa r7 = this.b;
        String r8 = r6.getNickName();
        if (r8 != null) goto L19;
        r8 = BuildConfig.FLAVOR;
    L19:
        if (r7.isRiskyOwner() == true) goto L21;
    L29:
        r6.setNickName(r8);
        goto L30
    L21:
        if (r8.length() <= 0) goto L23;
        boolean r9 = true;
    L24:
        if (r9 == false) goto L29;
        if (r8.offsetByCodePoints(0, 1) != 1) goto L28;
        r8 = StringsKt.take(r8, 1) + StringsKt.repeat("*", r8.codePointCount(0, r8.length()) - 1);
        goto L29
    L28:
        r8 = StringsKt.take(r8, 2) + StringsKt.repeat("*", r8.codePointCount(0, r8.length()) - 1);
        goto L29
    L23:
        r9 = false;
    L30:
        LuckyBoxTextMessageParams r10 = this.G;
        if (r10 == null) goto L36;
        a5 r11 = r10.getText();
        if (r11 == null) goto L36;
        r1 = r11;
    L39:
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r13 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.b;
        if (r1 != null) goto L42;
        r1 = (a5) vh7.f.c(a5.class);
    L42:
        yb2.a r14 = j();
        Intrinsics.checkNotNullParameter(r1, "text");
        return com.bytedance.android.livesdk.interactivity.service.textrender.core.r.a(r1, r14);
    L36:
        m0 r15 = this.b.getCommonData();
        if (r15 == null) goto L39;
        r1 = r15.getDisplayText();
    L13:
        r6 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUser();
    }

    public t(qa r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        super(r2, 0);
        LuckyBoxTextMessageParams r3 = r2.getTextMessageParams();
        if (r3 == null) goto L7;
        this.G = r3;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.LuckyBoxTextMessageParams");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r2) {
        if (this.b.isRiskyOwner() == false) goto L7;
        return false;
    L7:
        return super.E(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void H(View r2, g52.c r3, TextMessageRenderViewHolder r4, WeakReference r5) {
        if (this.b.isRiskyOwner() == false) goto L5;
        return;
    L5:
        super.H(r2, r3, r4, r5);
    }
}
