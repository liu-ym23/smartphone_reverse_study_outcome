package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0082\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/plugins/DoraIsolatedEnterCallSessionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INITIAL", "INIT_ENGINE", "CREATE_HANDLE", "CREATE_CONNECTION", "UPDATE_ASR_CONFIG", "UPDATE_TTS_CONFIG", "START_TASK", "START_SESSION", "SOCKET_CONNECTED", "SOCKET_CONNECT_FAILED", "SOCKET_CONNECT_CLOSED", "TASK_STARTED", "TASK_FAILED", "SESSION_STARTED", "SESSION_FAILED", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final enum DoraIsolatedEnterCallSessionStatus extends Enum<DoraIsolatedEnterCallSessionStatus> {
    public static final DoraIsolatedEnterCallSessionStatus CREATE_CONNECTION = null;
    public static final DoraIsolatedEnterCallSessionStatus CREATE_HANDLE = null;
    public static final a Companion = null;
    public static final DoraIsolatedEnterCallSessionStatus INITIAL = null;
    public static final DoraIsolatedEnterCallSessionStatus INIT_ENGINE = null;
    public static final DoraIsolatedEnterCallSessionStatus SESSION_FAILED = null;
    public static final DoraIsolatedEnterCallSessionStatus SESSION_STARTED = null;
    public static final DoraIsolatedEnterCallSessionStatus SOCKET_CONNECTED = null;
    public static final DoraIsolatedEnterCallSessionStatus SOCKET_CONNECT_CLOSED = null;
    public static final DoraIsolatedEnterCallSessionStatus SOCKET_CONNECT_FAILED = null;
    public static final DoraIsolatedEnterCallSessionStatus START_SESSION = null;
    public static final DoraIsolatedEnterCallSessionStatus START_TASK = null;
    public static final DoraIsolatedEnterCallSessionStatus TASK_FAILED = null;
    public static final DoraIsolatedEnterCallSessionStatus TASK_STARTED = null;
    public static final DoraIsolatedEnterCallSessionStatus UPDATE_ASR_CONFIG = null;
    public static final DoraIsolatedEnterCallSessionStatus UPDATE_TTS_CONFIG = null;
    public static final /* synthetic */ DoraIsolatedEnterCallSessionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DoraIsolatedEnterCallSessionStatus> getEntries() {
        return b;
    }

    static {
        DoraIsolatedEnterCallSessionStatus r0 = new DoraIsolatedEnterCallSessionStatus("INITIAL", 0, 0);
        INITIAL = r0;
        DoraIsolatedEnterCallSessionStatus r1 = new DoraIsolatedEnterCallSessionStatus("INIT_ENGINE", 1, 1);
        INIT_ENGINE = r1;
        DoraIsolatedEnterCallSessionStatus r3 = new DoraIsolatedEnterCallSessionStatus("CREATE_HANDLE", 2, 2);
        CREATE_HANDLE = r3;
        DoraIsolatedEnterCallSessionStatus r5 = new DoraIsolatedEnterCallSessionStatus("CREATE_CONNECTION", 3, 3);
        CREATE_CONNECTION = r5;
        DoraIsolatedEnterCallSessionStatus r7 = new DoraIsolatedEnterCallSessionStatus("UPDATE_ASR_CONFIG", 4, 4);
        UPDATE_ASR_CONFIG = r7;
        DoraIsolatedEnterCallSessionStatus r9 = new DoraIsolatedEnterCallSessionStatus("UPDATE_TTS_CONFIG", 5, 5);
        UPDATE_TTS_CONFIG = r9;
        DoraIsolatedEnterCallSessionStatus r11 = new DoraIsolatedEnterCallSessionStatus("START_TASK", 6, 6);
        START_TASK = r11;
        DoraIsolatedEnterCallSessionStatus r13 = new DoraIsolatedEnterCallSessionStatus("START_SESSION", 7, 7);
        START_SESSION = r13;
        DoraIsolatedEnterCallSessionStatus r15 = new DoraIsolatedEnterCallSessionStatus("SOCKET_CONNECTED", 8, 10);
        SOCKET_CONNECTED = r15;
        DoraIsolatedEnterCallSessionStatus r14 = new DoraIsolatedEnterCallSessionStatus("SOCKET_CONNECT_FAILED", 9, 11);
        SOCKET_CONNECT_FAILED = r14;
        DoraIsolatedEnterCallSessionStatus r12 = new DoraIsolatedEnterCallSessionStatus("SOCKET_CONNECT_CLOSED", 10, 12);
        SOCKET_CONNECT_CLOSED = r12;
        DoraIsolatedEnterCallSessionStatus r8 = new DoraIsolatedEnterCallSessionStatus("TASK_STARTED", 11, 20);
        TASK_STARTED = r8;
        DoraIsolatedEnterCallSessionStatus r2 = new DoraIsolatedEnterCallSessionStatus("TASK_FAILED", 12, 21);
        TASK_FAILED = r2;
        DoraIsolatedEnterCallSessionStatus r6 = new DoraIsolatedEnterCallSessionStatus("SESSION_STARTED", 13, 30);
        SESSION_STARTED = r6;
        DoraIsolatedEnterCallSessionStatus r4 = new DoraIsolatedEnterCallSessionStatus("SESSION_FAILED", 14, 31);
        SESSION_FAILED = r4;
        DoraIsolatedEnterCallSessionStatus[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r8, r2, r6, r4};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public static DoraIsolatedEnterCallSessionStatus[] values() {
        return (DoraIsolatedEnterCallSessionStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DoraIsolatedEnterCallSessionStatus valueOf(String r1) {
        return (DoraIsolatedEnterCallSessionStatus) r27.a.a(DoraIsolatedEnterCallSessionStatus.class, r1);
    }

    public DoraIsolatedEnterCallSessionStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
