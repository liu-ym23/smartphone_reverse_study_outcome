package ebb;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.diskmanage.clean.settings.DeleteConfig;
import com.ss.android.lark.framework.assembly.diskmange.DiskManageModuleDependencyInitor;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j {
    public String a;
    public String b;
    public List<File> c;

    public j() {
        this.a = BuildConfig.FLAVOR;
        this.b = BuildConfig.FLAVOR;
        this.c = new ArrayList();
    }

    public static DeleteConfig c(String r4) {
        DeleteConfig r5 = (DeleteConfig) JSON.parseObject(JSONObjectProtectorUtils.getString(new JSONObject(r4), "delete_global_config"), DeleteConfig.class);     // Catch: Exception -> L12
        if (r5.getDeleteConfig() == null) goto L5;
    L6:
        DiskManageModuleDependencyInitor.a r0 = dbb.a.b();     // Catch: Exception -> L12
        boolean r1 = false;
        if (r0 == null) goto L9;
        r1 = eac.a.a().getBoolean("small_disk_on", false);     // Catch: Exception -> L12
    L9:
        if (r1 == false) goto L11;
        r0.getClass();     // Catch: Exception -> L12
        r5.getExpiredConfig().setExpiredTime((long) (r5.getExpiredConfig().getExpiredTime() * eac.a.a().getFloat("disk_timeout_factor", 1.0f)));     // Catch: Exception -> L12
    L11:
        return r5;
    L5:
        if (r5.getExpiredConfig() != null) goto L6;
        return null;
    L12:
        e = move-exception;
        Log.e("RemoteDeleteHandler", "parse DeleteConfig fail. ", e);
        return null;
    }

    public final List<File> d(List<String> r6) {
        ArrayList r0 = new ArrayList();
        if (r6 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L18;
        String r1 = r7.next();
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (r1.startsWith("internal") == true) goto L13;
        if (r1.startsWith("external") == true) goto L16;
        r0.add(new PolarisFileWrapper(r1));
        goto L7
    L16:
        r0.add(new PolarisFileWrapper(r1.replaceFirst("external", this.b)));
        goto L7
    L13:
        r0.add(new PolarisFileWrapper(r1.replaceFirst("internal", this.a)));
        goto L7
    L18:
        return r0;
    }

    public static void a(long r3, File r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == true) goto L7;
        return;
    L7:
        if (r5.isDirectory() == false) goto L12;
        File[] r6 = r5.listFiles();
        int r0 = r6.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L19;
        a(r3, r6[r1]);
        r1 = r1 + 1;
        goto L9
    L19:
        return;
    L12:
        if (r5.lastModified() > r3) goto L17;
        FileUtils.g(r5.getPath());
        return;
    }

    public final void b(Context r9, DeleteConfig r10) {
        Log.i("RemoteDeleteHandler", "handleRemoteDelete config = " + r10);
        if (r10 != null) goto L6;
        Log.i("RemoteDeleteHandler", "handleRemoteDelete Expired error config is null");
        return;
    L6:
        String r0 = r9.getPackageName();
        this.a = r9.getFilesDir().getParent();
        this.b = Environment.getExternalStorageDirectory() + "/Android/data/" + r0;
        PolarisFileWrapper r1 = new PolarisFileWrapper(com.ss.android.lark.diskmanage.storage.d.p(r9));
        this.c = new ArrayList();
        if (r1.exists() == true) goto L9;
    L18:
        long r2 = System.currentTimeMillis();
        if (r10.getDeleteConfig() == null) goto L25;
        Iterator r11 = ((ArrayList) d(r10.getDeleteConfig().getFiles())).iterator();
    L22:
        if (r11.hasNext() == false) goto L25;
        a(r2, (File) r11.next());
    L25:
        if (r10.getExpiredConfig() == null) goto L35;
        if (r10.getExpiredConfig().getExpiredTime() >= 0) goto L30;
        Log.i("RemoteDeleteHandler", "handleRemoteDelete Expired error time < 0");
        return;
    L30:
        List<File> r12 = d(r10.getExpiredConfig().getFiles());
        long r3 = r2 - (r10.getExpiredConfig().getExpiredTime() * 1000);
        Iterator r13 = ((ArrayList) r12).iterator();
    L32:
        if (r13.hasNext() == false) goto L35;
        a(r3, (File) r13.next());
    L35:
        if (r10.getMainRustConfig() == null) goto L56;
        List<String> r14 = r10.getMainRustConfig().getFiles();
        ArrayList r15 = new ArrayList();
        if (r14 == null) goto L52;
        Iterator<String> r16 = r14.iterator();
    L41:
        if (r16.hasNext() == false) goto L52;
        String r4 = r16.next();
        if (TextUtils.isEmpty(r4) == true) goto L41;
        if (r4.startsWith("rust") == true) goto L47;
        r15.add(new PolarisFileWrapper(r4));
        goto L41
    L47:
        Iterator r5 = ((ArrayList) this.c).iterator();
    L49:
        if (r5.hasNext() == false) goto L41;
        r15.add(new PolarisFileWrapper(r4.replaceFirst("rust", ((File) r5.next()).getAbsolutePath())));
    L52:
        Iterator r17 = r15.iterator();
    L54:
        if (r17.hasNext() == false) goto L72;
        a(r2, (File) r17.next());
        goto L54
    L72:
        return;
    L56:
        return;
    L9:
        if (r1.isDirectory() == false) goto L18;
        File[] r18 = r1.listFiles();
        int r6 = r18.length;
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L18;
        File r8 = r18[r7];
        if (r8.isDirectory() == false) goto L17;
        if (r8.getName().length() != 32) goto L17;
        ((ArrayList) this.c).add(r8);
    L17:
        r7 = r7 + 1;
        goto L11
    }
}
