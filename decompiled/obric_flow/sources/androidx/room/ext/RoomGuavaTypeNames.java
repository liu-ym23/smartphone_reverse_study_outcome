package androidx.room.ext;

import ai.j0;
import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/ext/RoomGuavaTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "GUAVA_ROOM", "Lcom/squareup/javapoet/e;", "getGUAVA_ROOM", "()Lcom/squareup/javapoet/e;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoomGuavaTypeNames {
    private static final e GUAVA_ROOM = null;
    public static final RoomGuavaTypeNames INSTANCE = null;

    static {
        INSTANCE = new RoomGuavaTypeNames();
        GUAVA_ROOM = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".guava"), "GuavaRoom", new String[0]);
    }

    private RoomGuavaTypeNames() {
    }

    public final e getGUAVA_ROOM() {
        return GUAVA_ROOM;
    }
}
