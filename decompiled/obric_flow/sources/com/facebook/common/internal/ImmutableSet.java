package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@Nullsafe(Nullsafe.Mode.STRICT)
public class ImmutableSet<E> extends HashSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7651a = 0;

    public ImmutableSet(HashSet r5) {
        super(r5);
    }
}
