package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,3055:1\n*E\n"})
public final class BufferedChannel$sendImpl$1 extends Lambda implements Function4 {
    public static final BufferedChannel$sendImpl$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$sendImpl$1();
    }

    public BufferedChannel$sendImpl$1() {
        super(4);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Object r11, Object r12, Object r13) {
        return invoke((h) r10, ((Number) r11).intValue(), r12, ((Number) r13).longValue());
    }

    public final Void invoke(h<Object> r10, int r11, Object r12, long r13) {
        throw new IllegalStateException("unexpected".toString());
    }
}
