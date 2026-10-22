package androidx.room.solver;

import androidx.room.ext.RoomRxJava2TypeNames;
import androidx.room.ext.RoomRxJava3TypeNames;
import androidx.room.ext.RxJava2TypeNames;
import androidx.room.ext.RxJava3TypeNames;
import com.squareup.javapoet.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\rj\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Landroidx/room/solver/RxType;", "", "Landroidx/room/solver/RxVersion;", "version", "Lcom/squareup/javapoet/e;", "className", "", "factoryMethodName", "", "canBeNull", "<init>", "(Ljava/lang/String;ILandroidx/room/solver/RxVersion;Lcom/squareup/javapoet/e;Ljava/lang/String;Z)V", "isSingle", "()Z", "Landroidx/room/solver/RxVersion;", "getVersion", "()Landroidx/room/solver/RxVersion;", "Lcom/squareup/javapoet/e;", "getClassName", "()Lcom/squareup/javapoet/e;", "Ljava/lang/String;", "getFactoryMethodName", "()Ljava/lang/String;", "Z", "getCanBeNull", "RX2_FLOWABLE", "RX2_OBSERVABLE", "RX2_SINGLE", "RX2_MAYBE", "RX2_COMPLETABLE", "RX3_FLOWABLE", "RX3_OBSERVABLE", "RX3_SINGLE", "RX3_MAYBE", "RX3_COMPLETABLE", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum RxType extends Enum<RxType> {
    private static final /* synthetic */ RxType[] $VALUES = null;
    public static final RxType RX2_COMPLETABLE = null;
    public static final RxType RX2_FLOWABLE = null;
    public static final RxType RX2_MAYBE = null;
    public static final RxType RX2_OBSERVABLE = null;
    public static final RxType RX2_SINGLE = null;
    public static final RxType RX3_COMPLETABLE = null;
    public static final RxType RX3_FLOWABLE = null;
    public static final RxType RX3_MAYBE = null;
    public static final RxType RX3_OBSERVABLE = null;
    public static final RxType RX3_SINGLE = null;
    private final boolean canBeNull;
    private final e className;
    private final String factoryMethodName;
    private final RxVersion version;

    private static final /* synthetic */ RxType[] $values() {
        return new RxType[]{RX2_FLOWABLE, RX2_OBSERVABLE, RX2_SINGLE, RX2_MAYBE, RX2_COMPLETABLE, RX3_FLOWABLE, RX3_OBSERVABLE, RX3_SINGLE, RX3_MAYBE, RX3_COMPLETABLE};
    }

    static {
        RxVersion r10 = RxVersion.TWO;
        RxJava2TypeNames r11 = RxJava2TypeNames.INSTANCE;
        e r5 = r11.getFLOWABLE();
        RoomRxJava2TypeNames r12 = RoomRxJava2TypeNames.INSTANCE;
        int r13 = 8;
        DefaultConstructorMarker r14 = null;
        String r15 = "RX2_FLOWABLE";
        int r16 = 0;
        boolean r17 = false;
        RX2_FLOWABLE = new RxType(r15, r16, r10, r5, r12.getRX_ROOM_CREATE_FLOWABLE(), r17, r13, r14);
        String r18 = "RX2_OBSERVABLE";
        int r19 = 1;
        RX2_OBSERVABLE = new RxType(r18, r19, r10, r11.getOBSERVABLE(), r12.getRX_ROOM_CREATE_OBSERVABLE(), r17, r13, r14);
        String r20 = "RX2_SINGLE";
        int r21 = 2;
        String r22 = null;
        RX2_SINGLE = new RxType(r20, r21, r10, r11.getSINGLE(), r22, r17, 12, r14);
        String r23 = "RX2_MAYBE";
        int r24 = 3;
        boolean r25 = true;
        RX2_MAYBE = new RxType(r23, r24, r10, r11.getMAYBE(), r22, r25, 4, r14);
        String r26 = "RX2_COMPLETABLE";
        int r27 = 4;
        boolean r28 = false;
        RX2_COMPLETABLE = new RxType(r26, r27, r10, r11.getCOMPLETABLE(), r22, r28, 12, r14);
        RxVersion r110 = RxVersion.THREE;
        RxJava3TypeNames r29 = RxJava3TypeNames.INSTANCE;
        e r111 = r29.getFLOWABLE();
        RoomRxJava3TypeNames r30 = RoomRxJava3TypeNames.INSTANCE;
        String r112 = "RX3_FLOWABLE";
        int r113 = 5;
        boolean r114 = false;
        RX3_FLOWABLE = new RxType(r112, r113, r110, r111, r30.getRX_ROOM_CREATE_FLOWABLE(), r114, 8, null);
        DefaultConstructorMarker r31 = null;
        String r32 = "RX3_OBSERVABLE";
        int r33 = 6;
        boolean r34 = false;
        RX3_OBSERVABLE = new RxType(r32, r33, r110, r29.getOBSERVABLE(), r30.getRX_ROOM_CREATE_OBSERVABLE(), r34, 8, r31);
        String r35 = "RX3_SINGLE";
        int r36 = 7;
        String r37 = null;
        RX3_SINGLE = new RxType(r35, r36, r110, r29.getSINGLE(), r37, r34, 12, r31);
        String r38 = "RX3_MAYBE";
        int r39 = 8;
        boolean r40 = true;
        RX3_MAYBE = new RxType(r38, r39, r110, r29.getMAYBE(), r37, r40, 4, r31);
        String r41 = "RX3_COMPLETABLE";
        int r42 = 9;
        boolean r43 = false;
        RX3_COMPLETABLE = new RxType(r41, r42, r110, r29.getCOMPLETABLE(), r37, r43, 12, r31);
        $VALUES = $values();
    }

    private RxType(String r5, int r10, RxVersion r11, e r12, String r13, boolean r14) {
        super(r5, r10);
        this.version = r11;
        this.className = r12;
        this.factoryMethodName = r13;
        this.canBeNull = r14;
    }

    public static RxType valueOf(String r5) {
        return (RxType) Enum.valueOf(RxType.class, r5);
    }

    public static RxType[] values() {
        return (RxType[]) $VALUES.clone();
    }

    public final boolean getCanBeNull() {
        return this.canBeNull;
    }

    public final e getClassName() {
        return this.className;
    }

    public final String getFactoryMethodName() {
        return this.factoryMethodName;
    }

    public final RxVersion getVersion() {
        return this.version;
    }

    public final boolean isSingle() {
        if (this != RX2_SINGLE) goto L5;
    L8:
        return true;
    L5:
        if (this == RX3_SINGLE) goto L8;
        return false;
    }

    public /* synthetic */ RxType(String r10, int r11, RxVersion r12, e r13, String r14, boolean r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        r14 = null;
    L5:
        String r5 = r14;
        if ((r16 & 8) == 0) goto L8;
        r15 = false;
    L8:
        this(r10, r11, r12, r13, r5, r15);
    }
}
