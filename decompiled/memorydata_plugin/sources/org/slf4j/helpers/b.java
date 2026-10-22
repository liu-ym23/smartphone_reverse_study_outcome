package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes8.dex */
public class b implements org.slf4j.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, Marker> f20267a;

    public b() {
        this.f20267a = new ConcurrentHashMap();
    }
}
