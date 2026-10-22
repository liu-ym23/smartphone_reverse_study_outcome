package com.facebook.common.memory;

import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: classes2.dex */
public interface Pool<V> extends ResourceReleaser<V> {
    Object get(int r5);
}
