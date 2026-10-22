package com.bytedance.applog.priority.original;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J \u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH&J\b\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH&J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\bH&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/applog/priority/original/GroupInterface;", "", "clear", "", "destroy", "doWork", "header", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "runTimeSecs", "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "getEventCount", "", "groupId", "insertEvent", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "eventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "eventName", "", "json", "interval", "isEmpty", "", "isTimeout", "match", "event", "paramJson", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface n {
    void a(Lazy<? extends JSONObject> r1, long r2);

    boolean a(long r1);

    int c();

    int d();

    void g();

    void h();
}
