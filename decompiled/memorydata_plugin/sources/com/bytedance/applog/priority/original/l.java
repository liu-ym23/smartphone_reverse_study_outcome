package com.bytedance.applog.priority.original;

import kotlin.Lazy;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applog/priority/original/EventTracker;", "", "onEvent", "", "eventName", "", "eventType", "", "json", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface l {
    boolean a(String r1, int r2, Lazy<? extends JSONObject> r3);
}
