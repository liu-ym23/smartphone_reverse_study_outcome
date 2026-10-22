package com.ss.android.lark.flow.replyinthread.pages.repo;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class FlowReplyInThreadRepositoryFactory$create$1 extends FunctionReferenceImpl implements Function0<ThreadTopic> {
    public FlowReplyInThreadRepositoryFactory$create$1(Object r8) {
        super(0, r8, MutableLiveData.class, "getValue", "getValue()Ljava/lang/Object;", 0);
    }

    public final ThreadTopic invoke() {
        return (ThreadTopic) ((MutableLiveData) ((CallableReference) this).receiver).getValue();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m507invoke() {
        return invoke();
    }
}
