package com.obric.aee.utils;

import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final enum AsyncContext extends Enum<AsyncContext> {
    private static final /* synthetic */ AsyncContext[] $VALUES = null;
    public static final AsyncContext Default = null;
    public static final AsyncContext IO = null;
    public static final AsyncContext Main = null;
    public static final AsyncContext None = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4359a = null;

        static {
            int[] r10 = new int[AsyncContext.values().length];
            r10[AsyncContext.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r10[AsyncContext.Main.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r10[AsyncContext.IO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r10[AsyncContext.Default.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f4359a = r10;
        }
    }

    private static final /* synthetic */ AsyncContext[] $values() {
        return new AsyncContext[]{None, Main, IO, Default};
    }

    static {
        None = new AsyncContext("None", 0);
        Main = new AsyncContext("Main", 1);
        IO = new AsyncContext("IO", 2);
        Default = new AsyncContext("Default", 3);
        $VALUES = $values();
    }

    private AsyncContext(String r10, int r11) {
        super(r10, r11);
    }

    public static AsyncContext valueOf(String r10) {
        return (AsyncContext) Enum.valueOf(AsyncContext.class, r10);
    }

    public static AsyncContext[] values() {
        return (AsyncContext[]) $VALUES.clone();
    }

    public final CoroutineDispatcher asDispatcher() {
        int r10 = a.f4359a[ordinal()];
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L17;
        if (r10 == 3) goto L15;
        if (r10 != 4) goto L12;
        return z0.a();
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        return z0.c();
    L15:
        return z0.b();
    }
}
