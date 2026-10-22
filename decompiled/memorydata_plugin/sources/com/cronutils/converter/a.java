package com.cronutils.converter;

import java.util.Collections;
import java.util.Map;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final c f3406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<Integer, Integer> f3407b;

    static {
        f3406a = d.a(a.class);
    }

    public a() {
        this.f3407b = Collections.unmodifiableMap(new BaseCronTransformer$1(this));
    }
}
