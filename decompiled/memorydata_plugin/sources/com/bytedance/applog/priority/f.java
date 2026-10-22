package com.bytedance.applog.priority;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/applog/priority/PriorityConst;", "", "()V", "OPTIONS_KEYS", "", "", "getOPTIONS_KEYS", "()Ljava/util/List;", "OPTIONS_KEY_BACKOFF_PRIORITY", "OPTIONS_KEY_GROUP_PRIORITY", "OPTIONS_KEY_PRIORITY_CONFIG", "RESPONSE_KEYS", "getRESPONSE_KEYS", "RESPONSE_KEY_BACKOFF_CONFIG", "RESPONSE_KEY_GROUP_LIST", "RESPONSE_KEY_PRIORITY_CONFIG", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f1787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f1788b = null;
    private static final List<String> c = null;

    static {
        f1787a = new f();
        f1788b = CollectionsKt.listOf(new String[]{"backoff_priority", "group_priority", "event_priority_config"});
        c = CollectionsKt.listOf(new String[]{"backoff_priority_list", "event_priority_config", "group_priority_list"});
    }

    private f() {
    }

    public final List<String> a() {
        return f1788b;
    }

    public final List<String> b() {
        return c;
    }
}
