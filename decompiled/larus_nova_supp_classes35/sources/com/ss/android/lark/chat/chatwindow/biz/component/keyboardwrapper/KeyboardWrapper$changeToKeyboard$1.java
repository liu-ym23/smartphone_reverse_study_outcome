package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class KeyboardWrapper$changeToKeyboard$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ int $type;
    final /* synthetic */ KeyboardWrapper this$0;

    public KeyboardWrapper$changeToKeyboard$1(Function0<Unit> r1, KeyboardWrapper r2, int r3) {
        this.$action = r1;
        this.this$0 = r2;
        this.$type = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m202invoke() {
        Function0<Unit> r0 = this.$action;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        KeyboardWrapper r1 = this.this$0;
        r1.e = this.$type;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m202invoke();
        return Unit.INSTANCE;
    }
}
