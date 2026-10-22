package androidx.room;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J/\u0010\u0010\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0013J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/room/Room;", "", "()V", "CURSOR_CONV_SUFFIX", "", "LOG_TAG", "MASTER_TABLE_NAME", "databaseBuilder", "Landroidx/room/RoomDatabase$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/RoomDatabase;", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", "name", "getGeneratedImplementation", "C", "suffix", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "inMemoryDatabaseBuilder", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context r5, Class<T> r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "klass");
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L13;
        return new RoomDatabase.Builder(r5, r10, r11);
    L13:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r12 = false;
        goto L9
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T, C> T getGeneratedImplementation(Class<C> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        Package r5 = r10.getPackage();
        Intrinsics.checkNotNull(r5);
        String r12 = r5.getName();
        String r13 = r10.getCanonicalName();
        Intrinsics.checkNotNull(r13);
        if (r12.length() == 0) goto L6;
        r13 = r13.substring(r12.length() + 1);
    L6:
        String r14 = StringsKt.E(r13, '.', '_') + r11;
        if (r12.length() != 0) goto L10;
        String r15 = r14;
    L11:
        Class<?> r16 = Class.forName(r15, true, r10.getClassLoader());     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
        return (T) r16.newInstance();
    L10:
        r15 = r12 + '.' + r14;     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
    L18:
        throw new RuntimeException("Cannot find implementation for " + r10.getCanonicalName() + ". " + r14 + " does not exist");
    L16:
        throw new RuntimeException("Cannot access the constructor " + r10 + ".canonicalName");
    L14:
        throw new RuntimeException("Failed to create an instance of " + r10 + ".canonicalName");
    }

    @JvmStatic
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context r5, Class<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "klass");
        return new RoomDatabase.Builder(r5, r10, null);
    }
}
