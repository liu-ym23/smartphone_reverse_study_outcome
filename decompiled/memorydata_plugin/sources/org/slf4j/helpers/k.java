package org.slf4j.helpers;

import java.util.Deque;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ThreadLocal<Map<String, Deque<String>>> f20276a;

    public k() {
        this.f20276a = new ThreadLocal();
    }
}
