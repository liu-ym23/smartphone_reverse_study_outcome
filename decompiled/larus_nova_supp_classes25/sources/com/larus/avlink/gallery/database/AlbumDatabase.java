package com.larus.avlink.gallery.database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/larus/avlink/gallery/database/AlbumDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "mediaDataDao", "Lcom/larus/avlink/gallery/database/MediaDataDao;", "thumbnailDataDao", "Lcom/larus/avlink/gallery/database/ThumbnailDataDao;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class AlbumDatabase extends RoomDatabase {
    public static final a a = null;
    public static final ConcurrentHashMap<String, AlbumDatabase> b = null;
    public static final AlbumDatabase$Companion$MIGRATION_1_2$1 c = null;

    public static final class a {
        public final AlbumDatabase a() {
            String r1 = AccountService.a.getUserId();
            if (r1.length() != 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            r1 = "default";
        L8:
            ConcurrentHashMap<String, AlbumDatabase> r3 = AlbumDatabase.b;
            AlbumDatabase r5 = r3.get(r1);
            if (r5 != null) goto L18;
            monitor-enter(this);
            r5 = r3.get(r1);     // Catch: Throwable -> L19
            if (r5 == null) goto L16;
            monitor-exit(this);
            goto L18
        L16:
            r5 = (AlbumDatabase) Room.databaseBuilder(AppHost.a.getApplication(), AlbumDatabase.class, "dora_album_".concat(r1)).addMigrations(new Migration[]{AlbumDatabase.c}).build();     // Catch: Throwable -> L19
            r3.put(r1, r5);     // Catch: Throwable -> L19
            monitor-exit(this);
        L19:
            th = move-exception;
            throw th;
        L18:
            return r5;
        L5:
            r2 = false;
            goto L6
        }

        public a() {
        }
    }

    public abstract b c();

    public abstract j d();

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avlink.gallery.database.AlbumDatabase$Companion$MIGRATION_1_2$1] */
    static {
        a = new a();
        b = new ConcurrentHashMap();
        c = new AlbumDatabase$Companion$MIGRATION_1_2$1();
    }

    public AlbumDatabase() {
    }
}
