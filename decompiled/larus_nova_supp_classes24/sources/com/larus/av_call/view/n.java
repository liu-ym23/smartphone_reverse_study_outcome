package com.larus.av_call.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n implements p<Object> {
    public final /* synthetic */ o<Object> a;

    public n(o<Object> r1) {
        this.a = r1;
    }

    @Override // com.larus.av_call.view.p
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "container");
        return LayoutInflater.from(r3).inflate(2131562626, r4, false);
    }

    @Override // com.larus.av_call.view.p
    public final void b(Object r2, int r3) {
        this.a.b.invoke(r2, Integer.valueOf(r3));
    }
}
