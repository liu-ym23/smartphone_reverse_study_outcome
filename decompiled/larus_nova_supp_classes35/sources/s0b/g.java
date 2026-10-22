package s0b;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.core.GlobalManager;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.m;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import ntb.k;
import org.json.JSONObject;
import swb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final AtomicBoolean a = null;
    public static GeckoClient b;
    public static String c;
    public static final byte[] d = null;
    public static final Application e = null;
    public static final Map<String, Boolean> f = null;

    public static final class a implements az5.a {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(String r1, JSONObject r2) {
            u1b.b.b(r1, r2);
        }
    }

    public g() {
    }

    static {
        a = new AtomicBoolean(false);
        d = new byte[0];
        int r0 = com.ss.android.lark.officesdk.utils.di.d.a;
        e = com.ss.android.lark.officesdk.utils.di.d.a.a();
        f = new HashMap();
    }

    public static boolean c(ChameleonConfig r15) {
        if (b == null) goto L6;
        j.f("CML_TAG_GeckoResManager", "initGeckoClient, client is already init");
        return false;
    L6:
        int r0 = com.ss.android.lark.officesdk.utils.di.h.a;
        DependencyContainer r1 = DependencyContainer.a;
        String[] r3 = null;
        com.ss.android.lark.officesdk.di.core.b r2 = DependencyContainer.a(k.class, null);
        if ((r2 instanceof k) == true) goto L9;
        r2 = null;
    L9:
        k r4 = (k) r2;
        if (r4 == null) goto L12;
        boolean r5 = r4.isPrivateKA();
    L13:
        if (r5 == false) goto L16;
        j.f("CML_TAG_GeckoResManager", "initGeckoClient, isPrivateKA feature switch close!");
        return false;
    L16:
        int r6 = m.a;
        String r7 = m.a.a().getDeviceId();
        c = r7;
        if (TextUtils.isEmpty(r7) == false) goto L20;
        j.b("CML_TAG_GeckoResManager", "initGeckoClient, deviceId is Empty!");
        return false;
    L20:
        int r8 = com.ss.android.lark.officesdk.utils.di.f.a;
        ntb.g r9 = DependencyContainer.a(ntb.g.class, null);
        if (r9 == null) goto L24;
        String r10 = r9.getGeckoDomain();
        if (r10 == null) goto L24;
    L26:
        if (TextUtils.isEmpty(r10) == false) goto L29;
        j.b("CML_TAG_GeckoResManager", "initGeckoClient, host is empty!");
        return false;
    L29:
        int r11 = s0b.a.a;
        Application r12 = e;
        Set r16 = ((HashMap) s0b.a.c(r12, r15)).keySet();
        if (r16 == null) goto L33;
        r3 = (String[]) r16.toArray(new String[0]);
    L33:
        if (r3 != null) goto L35;
    L41:
        boolean r13 = true;
    L42:
        if (r13 == false) goto L45;
        j.b("CML_TAG_GeckoResManager", "initGeckoClient, accessKeys is empty!");
        return false;
    L45:
        j.e("CML_TAG_GeckoResManager", "initGeckoClient, deviceId = " + c + ", host = " + r10 + ", appId = 1161, accessKey = " + ArraysKt.joinToString$default(r3, ",", null, null, 0, null, null, 62, null));
        if (com.bytedance.geckox.b.a.a.hasInit() == true) goto L59;
        boolean r14 = m.a.a().isBoe();
        if (r14 == false) goto L62;
        GeckoGlobalConfig.ENVType r17 = GeckoGlobalConfig.ENVType.BOE;
    L58:
        j.e("CML_TAG_GeckoResManager", "init global manager   env = " + r17);
        GeckoGlobalConfig.Builder r18 = new GeckoGlobalConfig.Builder(r12).host(r10).appVersion(swb.b.a(r12)).appId((long) 1161).deviceId(c).env(r17).netStack(new bkb.e(r14));
        s0b.a.b();
        GlobalManager.d(r18.build());
        goto L59
    L62:
        if ((r12.getApplicationInfo().flags & 2) == 0) goto L54;
        boolean r19 = true;
    L55:
        if (r19 == false) goto L57;
        r17 = GeckoGlobalConfig.ENVType.DEV;
        goto L58
    L57:
        r17 = GeckoGlobalConfig.ENVType.PROD;
    L54:
        r19 = false;
    L59:
        b = GeckoClient.create(new GeckoConfig.Builder(r12).accessKey((String[]) Arrays.copyOf(r3, r3.length)).allLocalAccessKeys((String[]) Arrays.copyOf(r3, r3.length)).appId(1161).host(r10).appVersion(n.a(r12)).deviceId(c).resRootDir(s0b.a.b()).needServerMonitor(false).statisticMonitor(a.a).build());
        GeckoLogger.enable();
        GeckoLogger.addLogger(new h());
        return true;
    L35:
        if (r3.length != 0) goto L37;
        boolean r20 = true;
    L38:
        if (r20 == true) goto L41;
        r13 = false;
        goto L42
    L37:
        r20 = false;
    L24:
        r10 = BuildConfig.FLAVOR;
        goto L26
    L12:
        r5 = false;
        goto L13
    }

    public static final VFSFile a(UpdatePackage r5, long r6) {
        VFSFiles.b.getClass();
        VFSFile r7 = VFSFiles.b(true).z(ResLoadUtils.getChannelPath(s0b.a.b(), r5.getAccessKey(), r5.getChannel(), r6)).toFile();
        if (r7.exists() == false) goto L15;
        VFSFile[] r8 = r7.listFiles();
        if (r8.length != 0) goto L7;
        boolean r9 = true;
    L9:
        if ((!r9) == false) goto L13;
        j.e("CML_TAG_GeckoResManager", "getGeckoDirResource: " + r8[0].getPath());
        return r8[0];
    L13:
        throw new IOException("getGeckoDirResource()... resFolder is not exist");
    L7:
        r9 = false;
        goto L9
    L15:
        throw new IOException("getGeckoDirResource()...channel -> " + r5.getChannel() + " channelFile not exists, file -> " + r7);
    }

    public static final void b(ChameleonConfig r6, UpdatePackage r7, String r8, VFSFile r9) {
        VFSFile r10 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.j(r6, r7);
        if (r10 == null) goto L25;
        VFSFiles.b.getClass();
        VFSFile r0 = VFSFiles.b(true).D(r10, r8.concat(ChameleonResConstants.TEMP_SUFFIX));
        j.e("CML_TAG_GeckoResManager", "transferToSD tempFile = " + r0);
        if (r0.exists() == false) goto L8;
        swb.j.h(r0.getVfsPath());
        j.e("CML_TAG_GeckoResManager", "transferToSD(): delete exists tempFile = ".concat(r8));
    L8:
        if (r0.mkdir() == false) goto L23;
        com.ss.android.lark.vfs.h r1 = VFSFiles.b(true);
        String r3 = r9.getName();
        if (r3 != null) goto L12;
        r3 = BuildConfig.FLAVOR;
    L12:
        VFSPath r2 = r1.H(r0, r3);
        j.e("CML_TAG_GeckoResManager", "transferToSD(): copyDir geckoFile = " + r9 + ", tempFileName = " + r2);
        swb.j.e(r9.getVfsPath(), r2);
        VFSFile r4 = VFSFiles.b(true).D(r10, r8);
        j.e("CML_TAG_GeckoResManager", "transferToSD(): copyDir geckoFile = " + r9 + ", reNameFile = " + r4);
        if (r0.renameTo(r4) == false) goto L21;
        VFSPath r11 = VFSFiles.b(true).D(r10, r8).getVfsPath();
        j.e("CML_TAG_GeckoResManager", "transferToSD(): copyDir resPath = " + r11);
        if (swb.g.a(r11) == false) goto L18;
        j.e("CML_TAG_GeckoResManager", "transferToSD(): success");
        return;
    L18:
        swb.j.h(r11);
        throw new IOException("transferToSD(): checkResourceIsValid failed");
    L21:
        throw new IOException("transferToSD(): rename folder failed");
    L23:
        throw new IOException("transferToSD(): tempFile mkdir failed");
    L25:
        throw new IOException("transferToSD(): resourceRootDir is null");
    }
}
