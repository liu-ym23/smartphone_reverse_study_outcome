package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&JG\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u000bH&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventsGateway;", "", "queryEventsSince", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventQueryResultDto;", "lastSequence", "", "maxResults", "", "subscribeEvents", "startSequenceNumber", "onEvents", "Lkotlin/Function1;", "", "onClosed", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "reasonCode", "unsubscribeEvents", "subscriptionId", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface g {
    int a(long r1, Function1<? super f, Unit> r3, Function1<? super Integer, Unit> r4);

    f a(long r1, int r3);

    void a(int r1);
}
