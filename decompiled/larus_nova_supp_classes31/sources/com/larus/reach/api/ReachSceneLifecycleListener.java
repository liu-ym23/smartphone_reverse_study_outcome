package com.larus.reach.api;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import ns9.e;
import ns9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J*\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/larus/reach/api/ReachSceneLifecycleListener;", "", "pushScene", "", "getPushScene", "()Ljava/lang/String;", "onReceive", "", "request", "Lcom/larus/reach/api/ReachRequest;", "onShow", "onDismiss", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "Lcom/larus/reach/api/ReachCloseReason;", "onDiscard", "Lcom/larus/reach/api/ReachRejectReason;", "onClick", "click", "Lcom/larus/reach/api/ReachClickEvent;", "onClickResult", "success", "", "failReason", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ReachSceneLifecycleListener {
    String a();

    void b(t r1);

    void c(t r1, e r2, boolean r3, String r4);

    void d(t r1, ReachCloseReason r2);

    void f(t r1, ReachRejectReason r2);

    void g(t r1);

    void h(t r1, e r2);
}
