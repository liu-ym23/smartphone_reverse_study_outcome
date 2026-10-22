package com.google.auto.common;

import com.google.common.collect.ImmutableSet;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends com.google.common.base.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f8629a = null;

    static {
        f8629a = new n0();
    }

    @Override // com.google.common.base.p
    public final boolean doEquivalent(Object r5, Object r10) {
        return o0.h((TypeMirror) r5, (TypeMirror) r10, ImmutableSet.of());
    }

    @Override // com.google.common.base.p
    public final int doHash(Object r5) {
        return o0.j((TypeMirror) r5, ImmutableSet.of());
    }
}
