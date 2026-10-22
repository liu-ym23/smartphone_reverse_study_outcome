package p6;

import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends o6.a {
    public e() {
    }

    @Override // o6.a
    public String f() {
        return "data_clear";
    }

    @Override // o6.a
    public boolean g(n6.a r18) {
        JSONObject r10 = new JSONObject(r18.c());
        if (e(r10, r18) == false) goto L5;
        return true;
    L5:
        String r11 = com.monitor.cloudmessage.utils.b.i(r10.optString("rootNode"), r10.optString("relativeDirName"));
        String r12 = null;
        if (TextUtils.isEmpty(r11) == false) goto L8;
        File r13 = null;
        r12 = "目录名为空";
    L12:
        if (TextUtils.isEmpty(r12) == true) goto L15;
        k(r12, r18);
        return true;
    L15:
        boolean r14 = false;
        int r15 = r10.optInt("deleteStrategy", 0);
        if (r15 == 0) goto L43;
        if (r15 == 1) goto L20;
        k("数据清理策略不合法", r18);
        return true;
    L20:
        long r16 = r10.optLong("expiration_time", -1);
        if (r16 >= 0) goto L24;
        k("数据清理过期时间为空", r18);
    L41:
        boolean r17 = true;
    L46:
        if (r17 == true) goto L48;
        k("数据删除失败(部分文件执行delete操作失败)", r18);
    L49:
        return true;
    L48:
        l(r18);
        goto L49
    L24:
        if (r13.isDirectory() == false) goto L36;
        File[] r19 = r13.listFiles();
        int r110 = r19.length;
        r17 = true;
        int r111 = 0;
    L26:
        if (r111 >= r110) goto L46;
        if (r19[r111].lastModified() >= (r16 * 1000)) goto L34;
        if (r17 == true) goto L31;
    L33:
        r17 = false;
        goto L34
    L31:
        if (r13.delete() == false) goto L33;
        r17 = true;
    L34:
        r111 = r111 + 1;
        goto L26
    L36:
        if (r13.lastModified() >= (r16 * 1000)) goto L41;
        if (r13.delete() == false) goto L40;
        r14 = true;
    L40:
        r17 = r14;
        goto L46
    L43:
        if (r13.isDirectory() == false) goto L45;
        r17 = com.monitor.cloudmessage.utils.b.k(r13.getAbsolutePath());
        goto L46
    L45:
        r17 = r13.delete();
        goto L46
    L8:
        r13 = new File(r11);
        if (r13.exists() == true) goto L12;
        r12 = "文件/目录不存在";
        goto L12
    }
}
