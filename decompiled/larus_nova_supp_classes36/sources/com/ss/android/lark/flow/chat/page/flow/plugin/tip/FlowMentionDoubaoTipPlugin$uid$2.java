package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FlowMentionDoubaoTipPlugin$uid$2 extends Lambda implements Function0<Long> {
    public static final FlowMentionDoubaoTipPlugin$uid$2 INSTANCE = null;

    static {
        INSTANCE = new FlowMentionDoubaoTipPlugin$uid$2();
    }

    public FlowMentionDoubaoTipPlugin$uid$2() {
        super(0);
    }

    public final Long invoke() {
        return StringsKt.toLongOrNull(ChatCoreModule.a().getLoginDependency().getUserId());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m145invoke() {
        return invoke();
    }
}
