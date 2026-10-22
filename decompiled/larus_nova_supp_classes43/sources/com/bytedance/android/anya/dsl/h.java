package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public final class h<STATE extends MVIState<?>, ACTION extends p> {
    public final List<i<STATE, ?, ?>> a;

    public final Sequence<i<STATE, ?, ?>> a() {
        return CollectionsKt.asSequence(this.a);
    }

    public h() {
        this.a = new ArrayList();
    }
}
