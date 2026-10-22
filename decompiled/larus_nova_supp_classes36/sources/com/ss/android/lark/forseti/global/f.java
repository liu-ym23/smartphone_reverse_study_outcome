package com.ss.android.lark.forseti.global;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.forseti.node.ForsetiNodeFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements yua.b {
    public final Fragment a;
    public final Fragment b;
    public final Fragment c;

    public final Fragment a() {
        return this.b;
    }

    public final Fragment b() {
        return this.c;
    }

    public final Fragment getFragment() {
        return this.a;
    }

    public f(Fragment r2, ForsetiNodeFragment r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "forsetiNodePieceFragment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
