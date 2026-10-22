package androidx.room;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J/\u0010\u0010\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0013J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/room/Room;", "", "()V", "CURSOR_CONV_SUFFIX", "", "LOG_TAG", "MASTER_TABLE_NAME", "databaseBuilder", "Landroidx/room/RoomDatabase$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/RoomDatabase;", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", ActivityLifecycle.NAME, "getGeneratedImplementation", "C", "suffix", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "inMemoryDatabaseBuilder", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context r2, Class<T> r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r3, "klass");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if ((!r1) == false) goto L14;
        return new RoomDatabase.Builder(r5, r3, r4);
    L14:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    @JvmStatic
    public static final <T, C> T getGeneratedImplementation(Class<C> r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "klass");
        Intrinsics.checkNotNullParameter(r14, "suffix");
        Package r1 = r13.getPackage();
        Intrinsics.checkNotNull(r1);
        String r2 = r1.getName();
        String r3 = r13.getCanonicalName();
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullExpressionValue(r2, "fullPackage");
        boolean r5 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L9;
        r3 = r3.substring(r2.length() + 1);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).substring(startIndex)");
    L9:
        String r15 = StringsKt.replace$default(r3, '.', '_', false, 4, null) + r14;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        r5 = true;
    L13:
        if (r5 == false) goto L15;
        String r6 = r15;
    L16:
        Class<?> r7 = Class.forName(r6, true, r13.getClassLoader());     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
        return (T) r7.newInstance();
    L15:
        r6 = r2 + '.' + r15;     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
    L23:
        throw new RuntimeException("Cannot find implementation for " + r13.getCanonicalName() + ". " + r15 + " does not exist");
    L21:
        throw new RuntimeException("Cannot access the constructor " + r13 + ".canonicalName");
    L19:
        throw new RuntimeException("Failed to create an instance of " + r13 + ".canonicalName");
    L5:
        r4 = false;
        goto L6
    }

    @JvmStatic
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context r2, Class<T> r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r3, "klass");
        return new RoomDatabase.Builder(r4, r3, null);
    }
}
