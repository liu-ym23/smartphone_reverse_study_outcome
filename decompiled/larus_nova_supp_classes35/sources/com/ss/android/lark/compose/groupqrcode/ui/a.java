package com.ss.android.lark.compose.groupqrcode.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    String i();

    void j(String r1, int r2, Modifier r3, Function0<Unit> r4, Function1<? super Throwable, Unit> r5, Composer r6, int r7);

    void k(boolean r1, Modifier r2, Function2<? super Composer, ? super Integer, Unit> r3, Composer r4, int r5);

    void l(Modifier r1, Composer r2, int r3);

    String m(long r1);
}
