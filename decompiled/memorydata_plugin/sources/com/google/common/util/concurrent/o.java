package com.google.common.util.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class o<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f4867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Object<L>> f4868b;

    interface a<L> {
        void call(L r1);
    }

    static {
        f4867a = Logger.getLogger(o.class.getName());
    }

    o() {
        this.f4868b = Collections.synchronizedList(new ArrayList());
    }
}
