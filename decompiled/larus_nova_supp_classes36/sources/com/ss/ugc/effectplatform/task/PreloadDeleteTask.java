package com.ss.ugc.effectplatform.task;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.net.DeleteCmd;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PreloadDeleteTask extends BaseTask {
    public final EffectConfig g;
    public final DeleteCmd h;
    public final a1 i;

    public static final class a {
    }

    static {
    }

    public final void b() {
    }

    public final void f() {
        DeleteCmd r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.getBusi_key_list();
        List<String> r1 = this.h.getResource_key_list();
        com.ss.ugc.effectplatform.preload.b.a r2 = com.ss.ugc.effectplatform.preload.b.d;
        Object r3 = this.g.G;
        r2.getClass();
        com.ss.ugc.effectplatform.preload.b r4 = com.ss.ugc.effectplatform.preload.b.a.a(r3);
        if (r1 == null) goto L27;
        Iterator<T> r5 = r1.iterator();
    L9:
        if (r5.hasNext() == false) goto L35;
        String r6 = (String) r5.next();
        com.ss.ugc.effectplatform.preload.c r7 = null;
        if (r4 != null) goto L28;
    L25:
        if (r7 == null) goto L9;
        StringBuilder r8 = new StringBuilder();
        r8.append(this.g.j);
        String r9 = FileManager.a;
        r8.append(FileManager.a);
        r8.append(r7.a);
        String r10 = r8.toString();
        Logger.INSTANCE.w("JKL", "[预加载][配置处理][删除过期文件" + r7.a + ']');
        FileManager.o(r10);
        r4.c(r7.a);
        goto L9
    L28:
        SQLiteDatabase r11 = r4.a;     // Catch: Exception -> L23
        if (r11 == null) goto L25;
        Cursor r12 = r11.rawQuery("select * from preload_table where resource_key=?", new String[]{r6});     // Catch: Exception -> L23
        if (r12 == null) goto L25;
        if (r12.moveToFirst() == true) goto L19;
    L21:
        r12.close();     // Catch: Exception -> L23
        goto L25
    L19:
        if (r12.isAfterLast() == true) goto L21;
        r7 = new com.ss.ugc.effectplatform.preload.c(r12.getString(0), r12.getString(1), r12.getString(2), r12.getString(3), r12.getLong(4), r12.getString(5));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L35:
        return;
    }

    public final void a() {
        f();     // Catch: Exception -> L4
    L6:
        e(new PreloadDeleteTask$execute$1(this));
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public PreloadDeleteTask(EffectConfig r2, DeleteCmd r3, String r4, com.ss.ugc.effectplatform.preload.f r5) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r5;
    }
}
