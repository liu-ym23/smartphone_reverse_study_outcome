package com.ss.android.lark.compose.chatsetting.common.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    Modifier a(boolean r1, Function0<Unit> r2);

    void b(String r1, Modifier r2, Function1<? super List<String>, Unit> r3, String r4, Composer r5, int r6);

    void c();
}
