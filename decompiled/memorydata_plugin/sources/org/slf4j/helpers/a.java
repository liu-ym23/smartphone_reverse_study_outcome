package org.slf4j.helpers;

import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class a implements org.slf4j.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f20264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InheritableThreadLocal<Map<String, String>> f20265b;

    public a() {
        this.f20264a = new k();
        this.f20265b = new AnonymousClass1(this);
    }
}
