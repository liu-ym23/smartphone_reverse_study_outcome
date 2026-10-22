package com.bytedance.android.livesdk.dslservice.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements yt1.n {
    public q() {
    }

    @Override // yt1.n
    public final void a(yt1.q r1, yt1.k r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
    }

    @Override // yt1.n
    public final boolean b(String r1, yt1.q r2) {
        return false;
    }

    @Override // yt1.n
    public final void e(yt1.q r1, Map r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter("", "data");
    }

    @Override // yt1.n
    public final void f(Context r1, yt1.l r2, ArrayList<yt1.h> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // yt1.n
    public final void g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // yt1.n
    public final void release() {
    }

    @Override // yt1.n
    public final yt1.k c(yt1.o r1, String r2, Context r3, yt1.r r4, yt1.m r5) {
        Intrinsics.checkNotNullParameter(r1, "template");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "context");
        return new yt1.g(new View(r3));
    }

    @Override // yt1.n
    public final yt1.k d(yt1.o r1, String r2, ViewGroup r3, yt1.r r4, yt1.m r5) {
        Intrinsics.checkNotNullParameter(r1, "template");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        return new yt1.g(r3);
    }
}
