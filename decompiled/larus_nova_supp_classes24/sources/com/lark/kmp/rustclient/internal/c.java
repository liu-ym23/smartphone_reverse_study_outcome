package com.lark.kmp.rustclient.internal;

import com.bytedance.larksuite.wire.CommandScope;
import com.lark.kmp.pb.basic.v1.Command;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommandScope.values().length];
            r0[CommandScope.GlobalScope.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CommandScope.UserScope.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final CommandScope a(Command r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r0 = be6.a.a;
        Intrinsics.checkNotNullParameter(r1, "command");
        CommandScope r2 = (CommandScope) be6.a.a.get(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Command scope not found for: $command".toString());
    }
}
