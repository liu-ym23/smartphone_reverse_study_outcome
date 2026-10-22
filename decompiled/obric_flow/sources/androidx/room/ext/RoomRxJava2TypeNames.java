package androidx.room.ext;

import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001f\u0010\u0011\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/room/ext/RoomRxJava2TypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "RX_ROOM", "Lcom/squareup/javapoet/e;", "getRX_ROOM", "()Lcom/squareup/javapoet/e;", "", "RX_ROOM_CREATE_FLOWABLE", "Ljava/lang/String;", "getRX_ROOM_CREATE_FLOWABLE", "()Ljava/lang/String;", "RX_ROOM_CREATE_OBSERVABLE", "getRX_ROOM_CREATE_OBSERVABLE", "RX_EMPTY_RESULT_SET_EXCEPTION", "getRX_EMPTY_RESULT_SET_EXCEPTION", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoomRxJava2TypeNames {
    public static final RoomRxJava2TypeNames INSTANCE = null;
    private static final e RX_EMPTY_RESULT_SET_EXCEPTION = null;
    private static final e RX_ROOM = null;
    private static final String RX_ROOM_CREATE_FLOWABLE = null;
    private static final String RX_ROOM_CREATE_OBSERVABLE = null;

    static {
        INSTANCE = new RoomRxJava2TypeNames();
        RX_ROOM = e.o(Package_extKt.getROOM_PACKAGE(), "RxRoom", new String[0]);
        RX_ROOM_CREATE_FLOWABLE = "createFlowable";
        RX_ROOM_CREATE_OBSERVABLE = "createObservable";
        RX_EMPTY_RESULT_SET_EXCEPTION = e.o(Package_extKt.getROOM_PACKAGE(), "EmptyResultSetException", new String[0]);
    }

    private RoomRxJava2TypeNames() {
    }

    public final e getRX_EMPTY_RESULT_SET_EXCEPTION() {
        return RX_EMPTY_RESULT_SET_EXCEPTION;
    }

    public final e getRX_ROOM() {
        return RX_ROOM;
    }

    public final String getRX_ROOM_CREATE_FLOWABLE() {
        return RX_ROOM_CREATE_FLOWABLE;
    }

    public final String getRX_ROOM_CREATE_OBSERVABLE() {
        return RX_ROOM_CREATE_OBSERVABLE;
    }
}
