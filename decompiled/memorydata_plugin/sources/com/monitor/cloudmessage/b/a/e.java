package com.monitor.cloudmessage.b.a;

import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e extends com.monitor.cloudmessage.b.a {
    public e() {
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "data_clear";
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r18) {
        JSONObject r2 = new JSONObject(r18.a());
        if (a(r2, r18) == false) goto L5;
        return true;
    L5:
        String r3 = com.monitor.cloudmessage.utils.c.c(r2.optString("rootNode"), r2.optString("relativeDirName"));
        String r6 = null;
        if (TextUtils.isEmpty(r3) == false) goto L8;
        File r5 = null;
        r6 = "目录名为空";
    L12:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        a(r6, r18);
        return true;
    L15:
        boolean r7 = false;
        int r4 = r2.optInt("deleteStrategy", 0);
        if (r4 == 0) goto L43;
        if (r4 == 1) goto L20;
        a("数据清理策略不合法", r18);
        return true;
    L20:
        long r8 = r2.optLong("expiration_time", -1);
        if (r8 >= 0) goto L24;
        a("数据清理过期时间为空", r18);
    L41:
        boolean r12 = true;
    L46:
        if (r12 == true) goto L48;
        a("数据删除失败(部分文件执行delete操作失败)", r18);
    L49:
        return true;
    L48:
        c(r18);
        goto L49
    L24:
        if (r5.isDirectory() == false) goto L36;
        File[] r9 = r5.listFiles();
        int r10 = r9.length;
        r12 = true;
        int r11 = 0;
    L26:
        if (r11 >= r10) goto L46;
        if (r9[r11].lastModified() >= (r8 * 1000)) goto L34;
        if (r12 == true) goto L31;
    L33:
        r12 = false;
        goto L34
    L31:
        if (r5.delete() == false) goto L33;
        r12 = true;
    L34:
        r11 = r11 + 1;
        goto L26
    L36:
        if (r5.lastModified() >= (r8 * 1000)) goto L41;
        if (r5.delete() == false) goto L40;
        r7 = true;
    L40:
        r12 = r7;
        goto L46
    L43:
        if (r5.isDirectory() == false) goto L45;
        r12 = com.monitor.cloudmessage.utils.c.a(r5.getAbsolutePath());
        goto L46
    L45:
        r12 = r5.delete();
        goto L46
    L8:
        r5 = new File(r3);
        if (r5.exists() == true) goto L12;
        r6 = "文件/目录不存在";
        goto L12
    }
}
