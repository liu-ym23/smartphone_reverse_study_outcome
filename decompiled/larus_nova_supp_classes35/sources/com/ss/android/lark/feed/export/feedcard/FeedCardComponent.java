package com.ss.android.lark.feed.export.feedcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class FeedCardComponent<P, V extends View> {
    public final Context a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public abstract V a();

    public ViewGroup.MarginLayoutParams b() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public final V c() {
        return (V) this.b.getValue();
    }

    public Context getContext() {
        return this.a;
    }

    public FeedCardComponent(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new FeedCardComponent$view$2(this));
    }
}
