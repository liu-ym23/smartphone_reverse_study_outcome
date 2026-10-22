package com.bytedance.crash.monitor;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.Global;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
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

    @Keep
    static class CachedString implements Serializable {
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private String mValue;

        CachedString() {
        }

        @NonNull
        static CachedString getCurrent(File r10, @NonNull String r11) {
            CachedString r12 = (CachedString) SerializeFactory.load(new File(r10, "current" + r11));
            if (r12 == null) goto L5;
            return r12;
        L5:
            return new CachedString();
        }

        String getBefore(@NonNull File r10, @NonNull String r11, long r12) {
            if (r12 == 0) goto L35;
            long r13 = this.mCreateTime;
            if (r13 != 0) goto L7;
        L9:
            File[] r14 = CacheManager.access$000(r10, r11);
            if (r14 == null) goto L12;
            int r15 = r14.length;
            int r16 = 0;
        L14:
            if (r16 >= r15) goto L24;
            File r17 = r14[r16];
            if (r12 <= CacheManager.access$100(r17, r11)) goto L23;
            CachedString r18 = (CachedString) SerializeFactory.load(r17);
            if (r18 == null) goto L22;
            String r19 = r18.mValue;
            if (r19 == null) goto L22;
            return r19;
        L22:
            FileUtils.deleteFile(r17);
        L23:
            r16 = r16 + 1;
            goto L14
        L24:
            int r20 = r14.length - 1;
        L25:
            if (r20 < 0) goto L33;
            CachedString r21 = (CachedString) SerializeFactory.load(r14[r20]);
            if (r21 == null) goto L31;
            String r22 = r21.mValue;
            if (r22 == null) goto L31;
            return r22;
        L31:
            r14[r20].delete();
            r20 = r20 - 1;
            goto L25
        L33:
            return this.mValue;
        L12:
            return this.mValue;
        L7:
            if (r12 <= r13) goto L9;
        L35:
            return this.mValue;
        }

        void update(@NonNull File r10, @NonNull String r11, @NonNull String r12) {
            long r13 = System.currentTimeMillis();
            String r14 = this.mValue;
            if (r14 != null) goto L5;
        L8:
            this.mValue = r12;
            this.mCreateTime = r13;
            SerializeFactory.store(new File(r10, "current" + r11), this);
            return;
        L5:
            if (r14.equals(r12) == false) goto L7;
            return;
        L7:
            CacheManager.access$200(r10, r11);
            SerializeFactory.store(new File(r10, this.mCreateTime + r11), this);
            goto L8
        }
    }

    @Keep
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

        @NonNull
        static CachedVersion getCurrent(File r10) {
            CachedVersion r11 = (CachedVersion) SerializeFactory.load(new File(r10, "current.ver"));
            if (r11 == null) goto L5;
            return r11;
        L5:
            return new CachedVersion();
        }

        AppVersionModel getAfter(@NonNull File r18, long r19) {
            long r10 = this.mCreateTime;
            AppVersionModel r11 = null;
            if (r10 != 0) goto L5;
        L7:
            long r12 = this.mVersionCode;
            if (r12 == 0) goto L12;
            String r14 = this.mName;
            if (r14 == null) goto L12;
            r11 = new AppVersionModel(r12, this.mUpdateVersionCode, this.mManifestCode, r14);
        L12:
            File[] r13 = CacheManager.access$000(r18, VER_SUFFIX);
            if (r13 == null) goto L27;
            int r15 = r13.length;
            int r16 = 0;
        L15:
            if (r16 >= r15) goto L27;
            File r17 = r13[r16];
            if (r19 >= CacheManager.access$100(r17, VER_SUFFIX)) goto L26;
            CachedVersion r20 = (CachedVersion) SerializeFactory.load(r17);
            if (r20 == null) goto L25;
            String r110 = r20.mName;
            if (r110 == null) goto L25;
            long r111 = r20.mVersionCode;
            if (r111 == 0) goto L25;
            r11 = new AppVersionModel(r111, r20.mUpdateVersionCode, r20.mManifestCode, r110);
        L25:
            FileUtils.deleteFile(r17);
        L26:
            r16 = r16 + 1;
        L27:
            return r11;
        L5:
            if (r19 <= r10) goto L7;
            return null;
        }

        AppVersionModel getBefore(File r17, long r18) {
            if (r18 == 0) goto L30;
            long r10 = this.mCreateTime;
            if (r10 != 0) goto L7;
        L9:
            File[] r11 = CacheManager.access$000(r17, VER_SUFFIX);
            if (r11 == null) goto L27;
            int r12 = r11.length;
            int r13 = 0;
        L12:
            if (r13 >= r12) goto L35;
            File r14 = r11[r13];
            if (r18 <= CacheManager.access$100(r14, VER_SUFFIX)) goto L26;
            CachedVersion r15 = (CachedVersion) SerializeFactory.load(r14);
            if (r15 == null) goto L25;
            String r16 = r15.mName;
            if (r16 == null) goto L25;
            long r19 = r15.mVersionCode;
            if (r19 == 0) goto L25;
            long r110 = r15.mUpdateVersionCode;
            if (r110 == 0) goto L25;
            return new AppVersionModel(r19, r110, r15.mManifestCode, r16);
        L25:
            FileUtils.deleteFile(r14);
        L26:
            r13 = r13 + 1;
            goto L12
        L35:
            return null;
        L27:
            return null;
        L7:
            if (r18 <= r10) goto L9;
        L30:
            return new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
        }

        void update(@NonNull File r10, long r11, long r12, long r13, @NonNull String r15) {
            long r14 = System.currentTimeMillis();
            String r16 = this.mName;
            if (r16 != null) goto L5;
        L16:
            Global.setAppLaunchMode(2);
        L17:
            this.mName = r15;
            this.mVersionCode = r11;
            this.mUpdateVersionCode = r12;
            this.mCreateTime = r14;
            this.mManifestCode = r13;
            SerializeFactory.store(new File(r10, "current.ver"), this);
            return;
        L5:
            if (this.mVersionCode == 0) goto L16;
            if (r16.equals(r15) == true) goto L9;
        L15:
            Global.setAppLaunchMode(1);
            CacheManager.access$200(r10, VER_SUFFIX);
            SerializeFactory.store(new File(r10, this.mCreateTime + VER_SUFFIX), this);
            goto L17
        L9:
            if (this.mVersionCode != r11) goto L15;
            if (r13 != this.mManifestCode) goto L15;
            if (this.mUpdateVersionCode != r12) goto L15;
        }
    }

    CacheManager(File r10) {
        this.mDirectory = FileSystemUtils.createDirectory(r10, DIR);
    }

    CacheManager(File r10, @NonNull String r11) {
        this.mDirectory = FileSystemUtils.createDirectory(FileSystemUtils.createDirectory(r10, DIR), r11);
    }

    static /* synthetic */ File[] access$000(File r10, String r11) {
        return getExpiredFiles(r10, r11);
    }

    static /* synthetic */ long access$100(File r10, String r11) {
        return getCreateTime(r10, r11);
    }

    static /* synthetic */ void access$200(File r10, String r11) {
        clear(r10, r11);
    }

    private static void clear(@NonNull File r10, @NonNull String r11) {
        File[] r12 = getExpiredFiles(r10, r11);
        if (r12 == null) goto L12;
        long r13 = System.currentTimeMillis();
        int r14 = r12.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L16;
        File r16 = r12[r15];
        long r17 = getCreateTime(r16, r11);
        if (r17 <= r13) goto L9;
    L10:
        FileUtils.deleteFile(r16);
    L11:
        r15 = r15 + 1;
        goto L5
    L9:
        if ((r13 - r17) <= TOW_WEEKS) goto L11;
    L16:
        return;
    }

    private CachedString getCachedString(@NonNull String r10) {
        switch(r10.hashCode()) {
            case 1466958: goto L15;
            case 1468859: goto L12;
            case 1469841: goto L9;
            case 1486178: goto L6;
            default: goto L17;
        };
    L17:
        byte r11 = -1;
    L18:
        if (r11 == 0) goto L37;
        if (r11 == 1) goto L32;
        if (r11 == 2) goto L27;
        if (this.mChannelCached != null) goto L25;
        this.mChannelCached = CachedString.getCurrent(this.mDirectory, CHN_SUFFIX);
    L25:
        return this.mChannelCached;
    L27:
        if (this.mUserIdCached != null) goto L30;
        this.mUserIdCached = CachedString.getCurrent(this.mDirectory, r10);
    L30:
        return this.mUserIdCached;
    L32:
        if (this.mAppIdCached != null) goto L35;
        this.mAppIdCached = CachedString.getCurrent(this.mDirectory, r10);
    L35:
        return this.mAppIdCached;
    L37:
        if (this.mDeviceIdCached != null) goto L40;
        this.mDeviceIdCached = CachedString.getCurrent(this.mDirectory, r10);
    L40:
        return this.mDeviceIdCached;
    L6:
        if (r10.equals(UID_SUFFIX) == false) goto L17;
        r11 = 2;
        goto L18
    L9:
        if (r10.equals(DID_SUFFIX) == false) goto L17;
        r11 = 0;
        goto L18
    L12:
        if (r10.equals(CHN_SUFFIX) == false) goto L17;
        r11 = 3;
        goto L18
    L15:
        if (r10.equals(AID_SUFFIX) == false) goto L17;
        r11 = 1;
        goto L18
    }

    private CachedVersion getCachedVersion() {
        if (this.mVersionCached != null) goto L6;
        this.mVersionCached = CachedVersion.getCurrent(this.mDirectory);
    L6:
        return this.mVersionCached;
    }

    private static long getCreateTime(File r10, String r11) {
        String r12 = r10.getName();     // Catch: Throwable -> L4
        return Long.parseLong(r12.substring(0, r12.length() - r11.length()));
    L4:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        return -1;
    }

    private static File[] getExpiredFiles(@NonNull File r10, @NonNull final String r11) {
        File[] r12 = r10.listFiles(new AnonymousClass1(r11));
        if (r12 == null) goto L5;
        Arrays.sort(r12, new AnonymousClass2(r11));
    L5:
        return r12;
    }

    String getAppId() {
        return getAppId(0);
    }

    String getAppId(long r10) {
        return getCachedString(AID_SUFFIX).getBefore(this.mDirectory, AID_SUFFIX, r10);
    }

    String getChannel() {
        return getChannel(0);
    }

    String getChannel(long r10) {
        return getCachedString(CHN_SUFFIX).getBefore(this.mDirectory, CHN_SUFFIX, r10);
    }

    String getDeviceId() {
        return getDeviceId(0);
    }

    String getDeviceId(long r10) {
        return getCachedString(DID_SUFFIX).getBefore(this.mDirectory, DID_SUFFIX, r10);
    }

    long getUserId() {
        return getUserId(0);
    }

    long getUserId(long r10) {
        String r11 = getCachedString(UID_SUFFIX).getBefore(this.mDirectory, UID_SUFFIX, r10);
        if (r11 != null) goto L10;
    L8:
        return 0;
    L10:
        return Long.decode(r11).longValue();
    L6:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        goto L8
    }

    @NonNull
    AppVersionModel getVersion() {
        AppVersionModel r10 = getVersion(0);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new AppVersionModel(0, 0, 0, NetConst.NOT_ENCRYPT_VERISON_CODE);
    }

    AppVersionModel getVersion(long r10) {
        return getCachedVersion().getBefore(this.mDirectory, r10);
    }

    AppVersionModel getVersionAfter(long r10) {
        return getCachedVersion().getAfter(this.mDirectory, r10);
    }

    void setAppId(String r10) {
        getCachedString(AID_SUFFIX).update(this.mDirectory, AID_SUFFIX, r10);
    }

    void setChannel(String r10) {
        getCachedString(CHN_SUFFIX).update(this.mDirectory, CHN_SUFFIX, r10);
    }

    void setDeviceId(String r10) {
        getCachedString(DID_SUFFIX).update(this.mDirectory, DID_SUFFIX, r10);
    }

    void setUserId(long r10) {
        getCachedString(UID_SUFFIX).update(this.mDirectory, UID_SUFFIX, String.valueOf(r10));
    }

    void setVersion(long r10, long r12, long r14, @NonNull String r16) {
        getCachedVersion().update(this.mDirectory, r10, r12, r14, r16);
    }
}
