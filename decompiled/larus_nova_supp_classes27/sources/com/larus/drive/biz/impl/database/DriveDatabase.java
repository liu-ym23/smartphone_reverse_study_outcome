package com.larus.drive.biz.impl.database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import l79.c;
import l79.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/larus/drive/biz/impl/database/DriveDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "recentDao", "Lcom/larus/drive/biz/impl/database/DriveRecentFileDao;", "mineDao", "Lcom/larus/drive/biz/impl/database/DriveMineFileDao;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DriveDatabase extends RoomDatabase {
    public static final a a = null;
    public static final ConcurrentHashMap<String, DriveDatabase> b = null;

    public static final class a {
        public final DriveDatabase a() {
            String r1 = AccountService.a.getUserId();
            if (r1.length() != 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            r1 = "default";
        L8:
            ConcurrentHashMap<String, DriveDatabase> r3 = DriveDatabase.b;
            DriveDatabase r4 = r3.get(r1);
            if (r4 != null) goto L18;
            monitor-enter(this);
            r4 = r3.get(r1);     // Catch: Throwable -> L19
            if (r4 == null) goto L16;
            monitor-exit(this);
            goto L18
        L16:
            String r0 = "nova_drive_".concat(r1);     // Catch: Throwable -> L19
            r4 = (DriveDatabase) Room.databaseBuilder(AppHost.a.getApplication(), DriveDatabase.class, r0).build();     // Catch: Throwable -> L19
            r3.put(r1, r4);     // Catch: Throwable -> L19
            monitor-exit(this);
        L19:
            th = move-exception;
            throw th;
        L18:
            return r4;
        L5:
            r2 = false;
            goto L6
        }

        public a() {
        }
    }

    public abstract c c();

    public abstract h d();

    static {
        a = new a();
        b = new ConcurrentHashMap();
    }

    public DriveDatabase() {
    }
}
