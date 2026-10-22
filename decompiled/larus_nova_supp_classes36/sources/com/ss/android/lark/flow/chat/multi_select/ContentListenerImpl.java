package com.ss.android.lark.flow.chat.multi_select;

import com.ss.android.eventbus.EventBus;
import com.ss.android.lark.biz.im.api.extension.message.ContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/flow/chat/multi_select/ContentListenerImpl;", "Lcom/ss/android/lark/biz/im/api/extension/message/ContentListener;", "<init>", "()V", "onSuccess", "", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "onFailed", "errorTitle", "errorMessage", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ContentListenerImpl implements ContentListener {
    public static final int $stable = 0;

    public ContentListenerImpl() {
    }

    public void onSuccess(Map<String, ? extends ForwardTargetBaseInfoNew> r9) {
        Intrinsics.checkNotNullParameter(r9, "result");
        EventBus.getDefault().trigger(new c(true, r9, null, null, 12));
    }

    public void onFailed(String r9, String r10) {
        EventBus.getDefault().trigger(new c(false, null, r9, r10, 2));
    }
}
