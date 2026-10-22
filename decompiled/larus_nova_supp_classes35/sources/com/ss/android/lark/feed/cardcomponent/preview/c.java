package com.ss.android.lark.feed.cardcomponent.preview;

import com.ss.android.lark.chat.entity.reaction.Reaction;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final c g = null;
    public final List<Reaction> a;
    public final int b;
    public final boolean c;
    public boolean d;
    public boolean e;
    public int f;

    public static final class a {
    }

    static {
        g = new c(CollectionsKt.emptyList(), 0);
    }

    public c(List r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "reactionList");
        this.a = r2;
        this.b = r3;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = 14;
    }
}
