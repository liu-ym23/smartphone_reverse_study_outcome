package com.bytedance.lark.lark_biz_feed_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lark_biz_feed.proto.BizError;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/ViewFlowError;", "Lcom/bytedance/lark/lark_biz_feed_android/UnhandledException;", "()V", "into", "Llark_biz_feed/proto/ViewFlowError;", "Lcom/bytedance/lark/lark_biz_feed_android/ViewFlowErrorBiz;", "Lcom/bytedance/lark/lark_biz_feed_android/ViewFlowErrorNoContainerHandle;", "Lcom/bytedance/lark/lark_biz_feed_android/ViewFlowErrorViewFlowIsShutDown;", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ViewFlowError extends UnhandledException {
    private ViewFlowError() {
        super(null, 1, null);
    }

    public /* synthetic */ ViewFlowError(DefaultConstructorMarker r1) {
        this();
    }

    public final lark_biz_feed.proto.ViewFlowError into() {
        if ((this instanceof ViewFlowErrorViewFlowIsShutDown) == false) goto L6;
        return new lark_biz_feed.proto.ViewFlowError.Builder().view_flow_is_shut_down(Boolean.TRUE).build();
    L6:
        if ((this instanceof ViewFlowErrorNoContainerHandle) == false) goto L9;
        return new lark_biz_feed.proto.ViewFlowError.Builder().no_container_handle(Boolean.TRUE).build();
    L9:
        if ((this instanceof ViewFlowErrorBiz) == false) goto L13;
        lark_biz_feed.proto.ViewFlowError.Builder r0 = new lark_biz_feed.proto.ViewFlowError.Builder();
        d r1 = ((ViewFlowErrorBiz) this).getInner();
        r1.getClass();
        return r0.biz(new BizError(Integer.valueOf(r1.a), r1.b)).build();
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
