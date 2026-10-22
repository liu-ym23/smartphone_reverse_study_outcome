package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import com.ss.android.lark.chat.utils.x;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "draft", "Lcom/ss/android/lark/chatbase/model/data/ComposeDrafts;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseKeyboardComponentV2$onEditMessageByDraft$1 extends Lambda implements Function1<a7b.a, Unit> {
    final /* synthetic */ BaseKeyboardComponentV2<mob.a> this$0;

    public BaseKeyboardComponentV2$onEditMessageByDraft$1(BaseKeyboardComponentV2<mob.a> r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(a7b.a r3) {
        if (r3 != null) goto L5;
        Log.w("BaseKeyboardComponentV2", "onEnterReEditModeByDraft: draft is null");
        return;
    L5:
        cya.h r4 = x.c(r3);
        this.this$0.L0(true, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a7b.a) r1);
        return Unit.INSTANCE;
    }
}
