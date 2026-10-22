package com.bytedance.crash.monitor;

import com.bytedance.crash.Global;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.SerializeFactory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class CacheManager {
    private static final String AID_SUFFIX = ".aid";
    private static final String CHN_SUFFIX = ".chn";
    private static final String DID_SUFFIX = ".did";
    private static final String DIR = "params";
    private static final long TOW_WEEKS = 1209600000;
    private static final String UID_SUFFIX = ".uid";
    private CachedString mAppIdCached;
    private CachedString mChannelCached;
    private CachedString mDeviceIdCached;
    private final File mDirectory;
    private CachedString mUserIdCached;
    private CachedVersion mVersionCached;

    static class CachedString implements Serializable {
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private String mValue;

        CachedString() {
        }

        static CachedString getCurrent(File r3, String r4) {
            CachedString r5 = (CachedString) ZeusTransformUtils.preCheckCast(SerializeFactory.load(new File(r3, "current" + r4)), CachedString.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L5;
            return r5;
        L5:
            return new CachedString();
        }

        String getBefore(File r8, String r9, long r10) {
            if (r10 == 0) goto L36;
            long r3 = this.mCreateTime;
            if (r3 != 0) goto L7;
        L9:
            File[] r11 = CacheManager.access$000(r8, r9);
            if (r11 == null) goto L12;
            int r1 = r11.length;
            int r2 = 0;
        L15:
            if (r2 >= r1) goto L25;
            File r4 = r11[r2];
            if (r10 <= CacheManager.access$100(r4, r9)) goto L24;
            CachedString r5 = (CachedString) ZeusTransformUtils.preCheckCast(SerializeFactory.load(r4), CachedString.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L23;
            String r6 = r5.mValue;
            if (r6 == null) goto L23;
            return r6;
        L23:
            FileUtils.deleteFile(r4);
        L24:
            r2 = r2 + 1;
            goto L15
        L25:
            int r12 = r11.length - 1;
        L26:
            if (r12 < 0) goto L34;
            CachedString r13 = (CachedString) ZeusTransformUtils.preCheckCast(SerializeFactory.load(r11[r12]), CachedString.class, "com.obric.memorydata.plugin");
            if (r13 == null) goto L32;
            String r14 = r13.mValue;
            if (r14 == null) goto L32;
            return r14;
        L32:
            r11[r12].delete();
            r12 = r12 - 1;
            goto L26
        L34:
            return this.mValue;
        L12:
            return this.mValue;
        L7:
            if (r10 <= r3) goto L9;
        L36:
            return this.mValue;
        }

        void update(File r7, String r8, String r9) {
            long r0 = System.currentTimeMillis();
            String r2 = this.mValue;
            if (r2 != null) goto L5;
        L8:
            this.mValue = r9;
            this.mCreateTime = r0;
            SerializeFactory.store(new File(r7, "current" + r8), this);
            return;
        L5:
            if (r2.equals(r9) == false) goto L7;
            return;
        L7:
            CacheManager.access$200(r7, r8);
            SerializeFactory.store(new File(r7, this.mCreateTime + r8), this);
            goto L8
        }
    }

    static class CachedVersion implements Serializable {
        public static final int VERSION_NEW = 2;
        public static final int VERSION_NO_CHANGE = 0;
        public static final int VERSION_UPDATE = 1;
        private static final String VER_SUFFIX = ".ver";
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private long mManifestCode;
        private String mName;
        private long mUpdateVersionCode;
        private long mVersionCode;

        CachedVersion() {
        }

        static CachedVersion getCurrent(File r2) {
            CachedVersion r3 = (CachedVersion) ZeusTransformUtils.preCheckCast(SerializeFactory.load(new File(r2, "current.ver")), CachedVersion.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L5;
            return r3;
        L5:
            return new CachedVersion();
        }

        AppVersionModel getAfter(File r19, long r20) {
            long r1 = this.mCreateTime;
            AppVersionModel r6 = null;
            if (r1 == 0) goto L8;
            if (r20 <= r1) goto L8;
            return null;
        L8:
            if (this.mVersionCode != 0) goto L10;
        L12:
            File[] r2 = CacheManager.access$000(r19, VER_SUFFIX);
            if (r2 == null) goto L27;
            int r3 = r2.length;
            int r5 = 0;
        L15:
            if (r5 >= r3) goto L27;
            File r7 = r2[r5];
            if (r20 >= CacheManager.access$100(r7, VER_SUFFIX)) goto L26;
            CachedVersion r8 = (CachedVersion) ZeusTransformUtils.preCheckCast(SerializeFactory.load(r7), CachedVersion.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L21;
        L25:
            FileUtils.deleteFile(r7);
            goto L26
        L21:
            if (r8.mName == null) goto L25;
            if (r8.mVersionCode == 0) goto L25;
            r6 = new AppVersionModel(r8.mVersionCode, r8.mUpdateVersionCode, r8.mManifestCode, r8.mName);
        L26:
            r5 = r5 + 1;
        L27:
            return r6;
        L10:
            if (this.mName == null) goto L12;
            r6 = new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
            goto L12
        }

        AppVersionModel getBefore(File r18, long r19) {
            if (r19 == 0) goto L30;
            long r3 = this.mCreateTime;
            if (r3 != 0) goto L7;
        L9:
            File[] r4 = CacheManager.access$000(r18, VER_SUFFIX);
            if (r4 == null) goto L27;
            int r5 = r4.length;
            int r6 = 0;
        L12:
            if (r6 >= r5) goto L35;
            File r7 = r4[r6];
            if (r19 <= CacheManager.access$100(r7, VER_SUFFIX)) goto L26;
            CachedVersion r8 = (CachedVersion) ZeusTransformUtils.preCheckCast(SerializeFactory.load(r7), CachedVersion.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L18;
        L25:
            FileUtils.deleteFile(r7);
            goto L26
        L18:
            if (r8.mName == null) goto L25;
            if (r8.mVersionCode == 0) goto L25;
            if (r8.mUpdateVersionCode == 0) goto L25;
            return new AppVersionModel(r8.mVersionCode, r8.mUpdateVersionCode, r8.mManifestCode, r8.mName);
        L26:
            r6 = r6 + 1;
            goto L12
        L35:
            return null;
        L27:
            return null;
        L7:
            if (r19 <= r3) goto L9;
        L30:
            return new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
        }

        void update(File r8, long r9, long r11, long r13, String r15) {
            long r0 = System.currentTimeMillis();
            String r2 = this.mName;
            if (r2 != null) goto L5;
        L16:
            Global.setAppLaunchMode(2);
        L17:
            this.mName = r15;
            this.mVersionCode = r9;
            this.mUpdateVersionCode = r11;
            this.mCreateTime = r0;
            this.mManifestCode = r13;
            SerializeFactory.store(new File(r8, "current.ver"), this);
            return;
        L5:
            if (this.mVersionCode == 0) goto L16;
            if (r2.equals(r15) == true) goto L9;
        L15:
            Global.setAppLaunchMode(1);
            CacheManager.access$200(r8, VER_SUFFIX);
            SerializeFactory.store(new File(r8, this.mCreateTime + VER_SUFFIX), this);
            goto L17
        L9:
            if (this.mVersionCode != r9) goto L15;
            if (r13 != this.mManifestCode) goto L15;
            if (this.mUpdateVersionCode != r11) goto L15;
        }
    }

    CacheManager(File r2) {
        this.mDirectory = FileSystemUtils.createDirectory(r2, "params");
    }

    CacheManager(File r2, String r3) {
        this.mDirectory = FileSystemUtils.createDirectory(FileSystemUtils.createDirectory(r2, "params"), r3);
    }

    static /* synthetic */ File[] access$000(File r0, String r1) {
        return getExpiredFiles(r0, r1);
    }

    static /* synthetic */ long access$100(File r0, String r1) {
        return getCreateTime(r0, r1);
    }

    static /* synthetic */ void access$200(File r0, String r1) {
        clear(r0, r1);
    }

    private static void clear(File r9, String r10) {
        File[] r11 = getExpiredFiles(r9, r10);
        if (r11 == null) goto L12;
        long r0 = System.currentTimeMillis();
        int r2 = r11.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L16;
        File r4 = r11[r3];
        long r5 = getCreateTime(r4, r10);
        if (r5 <= r0) goto L9;
    L10:
        FileUtils.deleteFile(r4);
    L11:
        r3 = r3 + 1;
        goto L5
    L9:
        if ((r0 - r5) <= TOW_WEEKS) goto L11;
    L16:
        return;
    }

    private CachedString getCachedString(String r5) {
        switch(r5.hashCode()) {
            case 1466958: goto L15;
            case 1468859: goto L12;
            case 1469841: goto L9;
            case 1486178: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        if (r0 == 0) goto L37;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L27;
        if (this.mChannelCached != null) goto L25;
        this.mChannelCached = CachedString.getCurrent(this.mDirectory, CHN_SUFFIX);
    L25:
        return this.mChannelCached;
    L27:
        if (this.mUserIdCached != null) goto L30;
        this.mUserIdCached = CachedString.getCurrent(this.mDirectory, r5);
    L30:
        return this.mUserIdCached;
    L32:
        if (this.mAppIdCached != null) goto L35;
        this.mAppIdCached = CachedString.getCurrent(this.mDirectory, r5);
    L35:
        return this.mAppIdCached;
    L37:
        if (this.mDeviceIdCached != null) goto L40;
        this.mDeviceIdCached = CachedString.getCurrent(this.mDirectory, r5);
    L40:
        return this.mDeviceIdCached;
    L6:
        if (r5.equals(UID_SUFFIX) == false) goto L17;
        r0 = 2;
        goto L18
    L9:
        if (r5.equals(DID_SUFFIX) == false) goto L17;
        r0 = 0;
        goto L18
    L12:
        if (r5.equals(CHN_SUFFIX) == false) goto L17;
        r0 = 3;
        goto L18
    L15:
        if (r5.equals(AID_SUFFIX) == false) goto L17;
        r0 = 1;
        goto L18
    }

    private CachedVersion getCachedVersion() {
        if (this.mVersionCached != null) goto L6;
        this.mVersionCached = CachedVersion.getCurrent(this.mDirectory);
    L6:
        return this.mVersionCached;
    }

    private static long getCreateTime(File r2, String r3) {
        String r4 = r2.getName();     // Catch: Throwable -> L4
        return Long.parseLong(r4.substring(0, r4.length() - r3.length()));
    L4:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        return -1;
    }

    private static File[] getExpiredFiles(File r1, final String r2) {
        File[] r3 = r1.listFiles(new AnonymousClass1(r2));
        if (r3 == null) goto L5;
        Arrays.sort(r3, new AnonymousClass2(r2));
    L5:
        return r3;
    }

    String getAppId() {
        return getAppId(0);
    }

    String getAppId(long r3) {
        return getCachedString(AID_SUFFIX).getBefore(this.mDirectory, AID_SUFFIX, r3);
    }

    String getChannel() {
        return getChannel(0);
    }

    String getChannel(long r3) {
        return getCachedString(CHN_SUFFIX).getBefore(this.mDirectory, CHN_SUFFIX, r3);
    }

    String getDeviceId() {
        return getDeviceId(0);
    }

    String getDeviceId(long r3) {
        return getCachedString(DID_SUFFIX).getBefore(this.mDirectory, DID_SUFFIX, r3);
    }

    long getUserId() {
        return getUserId(0);
    }

    long getUserId(long r3) {
        String r2 = getCachedString(UID_SUFFIX).getBefore(this.mDirectory, UID_SUFFIX, r3);
        if (r2 != null) goto L10;
    L8:
        return 0;
    L10:
        return Long.decode(r2).longValue();
    L6:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        goto L8
    }

    AppVersionModel getVersion() {
        AppVersionModel r8 = getVersion(0);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return new AppVersionModel(0, 0, 0, "0");
    }

    AppVersionModel getVersion(long r2) {
        return getCachedVersion().getBefore(this.mDirectory, r2);
    }

    AppVersionModel getVersionAfter(long r2) {
        return getCachedVersion().getAfter(this.mDirectory, r2);
    }

    void setAppId(String r3) {
        getCachedString(AID_SUFFIX).update(this.mDirectory, AID_SUFFIX, r3);
    }

    void setChannel(String r3) {
        getCachedString(CHN_SUFFIX).update(this.mDirectory, CHN_SUFFIX, r3);
    }

    void setDeviceId(String r3) {
        getCachedString(DID_SUFFIX).update(this.mDirectory, DID_SUFFIX, r3);
    }

    void setUserId(long r3) {
        getCachedString(UID_SUFFIX).update(this.mDirectory, UID_SUFFIX, String.valueOf(r3));
    }

    void setVersion(long r10, long r12, long r14, String r16) {
        getCachedVersion().update(this.mDirectory, r10, r12, r14, r16);
    }
}
