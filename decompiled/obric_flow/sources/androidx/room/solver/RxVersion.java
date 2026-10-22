package androidx.room.solver;

import androidx.room.ext.RoomRxJava2TypeNames;
import androidx.room.ext.RoomRxJava3TypeNames;
import androidx.room.processor.ProcessorErrors;
import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Landroidx/room/solver/RxVersion;", "", "Lcom/squareup/javapoet/e;", "rxRoomClassName", "emptyResultExceptionClassName", "", "missingArtifactMessage", "<init>", "(Ljava/lang/String;ILcom/squareup/javapoet/e;Lcom/squareup/javapoet/e;Ljava/lang/String;)V", "Lcom/squareup/javapoet/e;", "getRxRoomClassName", "()Lcom/squareup/javapoet/e;", "getEmptyResultExceptionClassName", "Ljava/lang/String;", "getMissingArtifactMessage", "()Ljava/lang/String;", "TWO", "THREE", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum RxVersion extends Enum<RxVersion> {
    private static final /* synthetic */ RxVersion[] $VALUES = null;
    public static final RxVersion THREE = null;
    public static final RxVersion TWO = null;
    private final e emptyResultExceptionClassName;
    private final String missingArtifactMessage;
    private final e rxRoomClassName;

    private static final /* synthetic */ RxVersion[] $values() {
        return new RxVersion[]{TWO, THREE};
    }

    static {
        RoomRxJava2TypeNames r5 = RoomRxJava2TypeNames.INSTANCE;
        e r10 = r5.getRX_ROOM();
        e r11 = r5.getRX_EMPTY_RESULT_SET_EXCEPTION();
        ProcessorErrors r12 = ProcessorErrors.INSTANCE;
        TWO = new RxVersion("TWO", 0, r10, r11, r12.getMISSING_ROOM_RXJAVA2_ARTIFACT());
        RoomRxJava3TypeNames r13 = RoomRxJava3TypeNames.INSTANCE;
        THREE = new RxVersion("THREE", 1, r13.getRX_ROOM(), r13.getRX_EMPTY_RESULT_SET_EXCEPTION(), r12.getMISSING_ROOM_RXJAVA3_ARTIFACT());
        $VALUES = $values();
    }

    private RxVersion(String r5, int r10, e r11, e r12, String r13) {
        super(r5, r10);
        this.rxRoomClassName = r11;
        this.emptyResultExceptionClassName = r12;
        this.missingArtifactMessage = r13;
    }

    public static RxVersion valueOf(String r5) {
        return (RxVersion) Enum.valueOf(RxVersion.class, r5);
    }

    public static RxVersion[] values() {
        return (RxVersion[]) $VALUES.clone();
    }

    public final e getEmptyResultExceptionClassName() {
        return this.emptyResultExceptionClassName;
    }

    public final String getMissingArtifactMessage() {
        return this.missingArtifactMessage;
    }

    public final e getRxRoomClassName() {
        return this.rxRoomClassName;
    }
}
