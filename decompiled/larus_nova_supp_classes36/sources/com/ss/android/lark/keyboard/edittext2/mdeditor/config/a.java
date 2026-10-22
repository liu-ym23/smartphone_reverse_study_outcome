package com.ss.android.lark.keyboard.edittext2.mdeditor.config;

import com.ss.android.lark.coremd.base.parse.j;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import t9b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static /* synthetic */ j b() {
        e r0 = e.a;
        return a(EditorMarkdownConfigKt$editor$1.INSTANCE);
    }

    public static final j a(final Function2 r2) {
        Intrinsics.checkNotNullParameter(e.a, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        return com.ss.android.lark.coremdbiz.facade.a.a(new EditorMarkdownConfigKt$editor$2(r2));
    }
}
