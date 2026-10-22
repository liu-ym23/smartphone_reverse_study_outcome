package androidx.room;

import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final Room INSTANCE = null;
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    static {
        INSTANCE = new Room();
    }

    private Room() {
    }

    @JvmStatic
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context r10, Class<T> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "klass");
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L10:
        if ((true ^ r13) == false) goto L14;
        return new RoomDatabase.Builder(r10, r11, r12);
    L14:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    L5:
        if (StringsKt.isBlank(r12) == true) goto L8;
        r13 = false;
        goto L10
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T, C> T getGeneratedImplementation(Class<C> r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "klass");
        Intrinsics.checkNotNullParameter(r13, "suffix");
        Package r10 = r12.getPackage();
        Intrinsics.checkNotNull(r10);
        String r11 = r10.getName();
        String r14 = r12.getCanonicalName();
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNullExpressionValue(r11, "fullPackage");
        boolean r15 = false;
        if (r11.length() != 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == true) goto L9;
        r14 = r14.substring(r11.length() + 1);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
    L9:
        String r17 = StringsKt.replace$default(r14, '.', '_', false, 4, null) + r13;
        if (r11.length() != 0) goto L13;
        r15 = true;
    L13:
        if (r15 == false) goto L15;
        String r18 = r17;
    L16:
        Class<?> r19 = Class.forName(r18, true, r12.getClassLoader());     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
        return (T) r19.newInstance();
    L15:
        r18 = r11 + '.' + r17;     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
    L23:
        throw new RuntimeException("Cannot find implementation for " + r12.getCanonicalName() + ". " + r17 + " does not exist");
    L21:
        throw new RuntimeException("Cannot access the constructor " + r12 + ".canonicalName");
    L19:
        throw new RuntimeException("Failed to create an instance of " + r12 + ".canonicalName");
    L5:
        r16 = false;
        goto L6
    }

    @JvmStatic
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "klass");
        return new RoomDatabase.Builder(r10, r11, null);
    }
}
