package com.ss.android.lark.myai.export;

import android.os.Bundle;
import com.ss.android.lark.myai.export.model.ChatContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import osb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final List<com.ss.android.lark.myai.export.a> a;
    public final Function0<ChatContext> b;
    public final List<String> c;
    public final List<Object> d;

    public static final class a {
        public j a;
        public Bundle b;
        public List<com.ss.android.lark.myai.export.a> c;
        public Function0<ChatContext> d;
        public e e;
        public List<String> f;
        public final List<Object> g;

        public a(String r1, long r2) {
            Intrinsics.checkNotNullParameter(r1, "chatId");
            this.a = null;
            this.b = new Bundle();
            this.c = CollectionsKt.emptyList();
            this.d = null;
            this.e = null;
            this.f = new ArrayList();
            this.g = new ArrayList();
        }
    }

    public b(a r2) {
        r2.getClass();
        j r0 = r2.a;
        if (r2.b != null) goto L5;
        new Bundle();
    L5:
        this.a = CollectionsKt.toList(r2.c);
        this.b = r2.d;
        e r1 = r2.e;
        this.c = r2.f;
        this.d = CollectionsKt.toList(r2.g);
    }
}
