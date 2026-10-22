package com.obric.assistant.component;

import java.util.LinkedHashSet;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricIntercomComponent$c {
    public final String a;
    public final laa.n b;
    public boolean c;
    public boolean d;
    public ObricIntercomComponent$TouchTerminalIntent e;
    public boolean f;
    public final LinkedHashSet<String> g;
    public String h;

    public ObricIntercomComponent$c(String r3, com.obric.assistant.view.listening.b r4) {
        ObricIntercomComponent$TouchTerminalIntent r0 = ObricIntercomComponent$TouchTerminalIntent.NONE;
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "listeningUiHandle");
        Intrinsics.checkNotNullParameter(r0, "terminalIntent");
        this.a = r3;
        this.b = r4;
        this.c = false;
        this.d = false;
        this.e = r0;
        this.f = false;
        this.g = SetsKt.linkedSetOf(new String[]{r3});
    }
}
