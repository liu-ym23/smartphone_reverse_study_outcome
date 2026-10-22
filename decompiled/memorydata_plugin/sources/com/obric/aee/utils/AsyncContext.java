package com.obric.aee.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/aee/utils/AsyncContext;", "", "(Ljava/lang/String;I)V", "asDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "None", "Main", "IO", "Default", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum AsyncContext extends Enum<AsyncContext> {
    private static final /* synthetic */ AsyncContext[] $VALUES = null;
    public static final AsyncContext Default = null;
    public static final AsyncContext IO = null;
    public static final AsyncContext Main = null;
    public static final AsyncContext None = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5896a = null;

        static {
            int[] r0 = new int[AsyncContext.values().length];
            r0[AsyncContext.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AsyncContext.Main.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AsyncContext.IO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AsyncContext.Default.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f5896a = r0;
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

    private AsyncContext(String r1, int r2) {
        super(r1, r2);
    }

    public static AsyncContext valueOf(String r2) {
        return (AsyncContext) ZeusTransformUtils.preCheckCast(Enum.valueOf(AsyncContext.class, r2), AsyncContext.class, "com.obric.memorydata.plugin");
    }

    public static AsyncContext[] values() {
        return (AsyncContext[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AsyncContext[].class, "com.obric.memorydata.plugin");
    }

    public final ah asDispatcher() {
        int r2 = a.f5896a[ordinal()];
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L15;
        if (r2 != 4) goto L12;
        return ba.a();
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        return (ah) ZeusTransformUtils.preCheckCast(ba.b(), ah.class, "com.obric.memorydata.plugin");
    L15:
        return ba.c();
    }
}
