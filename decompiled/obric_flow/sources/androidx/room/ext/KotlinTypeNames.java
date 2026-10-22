package androidx.room.ext;

import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001f\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001f\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001f\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\tR\u001f\u0010\u0012\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\tR\u001f\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/room/ext/KotlinTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "UNIT", "Lcom/squareup/javapoet/e;", "getUNIT", "()Lcom/squareup/javapoet/e;", "CONTINUATION", "getCONTINUATION", "COROUTINE_SCOPE", "getCOROUTINE_SCOPE", "CHANNEL", "getCHANNEL", "RECEIVE_CHANNEL", "getRECEIVE_CHANNEL", "SEND_CHANNEL", "getSEND_CHANNEL", "FLOW", "getFLOW", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinTypeNames {
    private static final e CHANNEL = null;
    private static final e CONTINUATION = null;
    private static final e COROUTINE_SCOPE = null;
    private static final e FLOW = null;
    public static final KotlinTypeNames INSTANCE = null;
    private static final e RECEIVE_CHANNEL = null;
    private static final e SEND_CHANNEL = null;
    private static final e UNIT = null;

    static {
        INSTANCE = new KotlinTypeNames();
        UNIT = e.o("kotlin", "Unit", new String[0]);
        CONTINUATION = e.o("kotlin.coroutines", "Continuation", new String[0]);
        COROUTINE_SCOPE = e.o("kotlinx.coroutines", "CoroutineScope", new String[0]);
        CHANNEL = e.o("kotlinx.coroutines.channels", "Channel", new String[0]);
        RECEIVE_CHANNEL = e.o("kotlinx.coroutines.channels", "ReceiveChannel", new String[0]);
        SEND_CHANNEL = e.o("kotlinx.coroutines.channels", "SendChannel", new String[0]);
        FLOW = e.o("kotlinx.coroutines.flow", "Flow", new String[0]);
    }

    private KotlinTypeNames() {
    }

    public final e getCHANNEL() {
        return CHANNEL;
    }

    public final e getCONTINUATION() {
        return CONTINUATION;
    }

    public final e getCOROUTINE_SCOPE() {
        return COROUTINE_SCOPE;
    }

    public final e getFLOW() {
        return FLOW;
    }

    public final e getRECEIVE_CHANNEL() {
        return RECEIVE_CHANNEL;
    }

    public final e getSEND_CHANNEL() {
        return SEND_CHANNEL;
    }

    public final e getUNIT() {
        return UNIT;
    }
}
