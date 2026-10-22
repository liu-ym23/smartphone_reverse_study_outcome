package com.ss.android.lark.chatwindow.view.preview;

import android.view.ViewGroup;
import com.ss.android.lark.chatwindow.view.preview.c.a;
import h2b.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c<T extends a, S extends h2b.a> {

    public static class a {
        public final ViewGroup a;

        public a(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "containerView");
            this.a = r2;
        }
    }

    void a(S r1, T r2);

    T b(S r1, ViewGroup r2);

    int getPreviewType();
}
