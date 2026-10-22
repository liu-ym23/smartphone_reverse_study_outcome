package com.obric.memorydata.middleware.api.appcontext;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u001eJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0005H&J\b\u0010\u0019\u001a\u00020\fH&J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\fH\u0016¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/middleware/api/appcontext/IAppConfig;", "", "getVersionCode", "", "getVersionName", "", "getPluginVersionName", "getChannel", "getPluginPkgName", "getHostPkgName", "getUpdateVersionCode", "isDebug", "", "isAdminMode", "getAid", "getAppName", "getBuildInfo", "getSlardarExtras", "", "appEnv", "defaultTTEnvHeader", "defaultWebEnvHeader", "getApkId", "", "getAppTrackerTag", "isHostApp", "getHost", "hostType", "Lcom/obric/memorydata/middleware/api/appcontext/IAppConfig$HOST_TYPE;", "isPureAndroid", "HOST_TYPE", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppConfig {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/api/appcontext/IAppConfig$HOST_TYPE;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RELEASE_HOST", "PPE_HOST", "BOE_HOST", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum HOST_TYPE extends Enum<HOST_TYPE> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ HOST_TYPE[] $VALUES = null;
        public static final HOST_TYPE BOE_HOST = null;
        public static final HOST_TYPE PPE_HOST = null;
        public static final HOST_TYPE RELEASE_HOST = null;
        private final int value;

        private static final /* synthetic */ HOST_TYPE[] $values() {
            return new HOST_TYPE[]{RELEASE_HOST, PPE_HOST, BOE_HOST};
        }

        static {
            RELEASE_HOST = new HOST_TYPE("RELEASE_HOST", 0, 0);
            PPE_HOST = new HOST_TYPE("PPE_HOST", 1, 1);
            BOE_HOST = new HOST_TYPE("BOE_HOST", 2, 2);
            HOST_TYPE[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private HOST_TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<HOST_TYPE> getEntries() {
            return $ENTRIES;
        }

        public static HOST_TYPE valueOf(String r2) {
            return (HOST_TYPE) ZeusTransformUtils.preCheckCast(Enum.valueOf(HOST_TYPE.class, r2), HOST_TYPE.class, "com.obric.memorydata.plugin");
        }

        public static HOST_TYPE[] values() {
            return (HOST_TYPE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HOST_TYPE[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static boolean a(IAppConfig r2) {
            IAppConfig r3 = (IAppConfig) ZeusTransformUtils.wrapperContextForParams(r2, IAppConfig.class, "com.obric.memorydata.plugin");
            return false;
        }
    }

    String appEnv();

    String defaultTTEnvHeader();

    String defaultWebEnvHeader();

    int getAid();

    long getApkId();

    String getAppName();

    String getAppTrackerTag();

    String getBuildInfo();

    String getChannel();

    String getHost(HOST_TYPE r1);

    String getHostPkgName();

    String getPluginPkgName();

    String getPluginVersionName();

    Map<String, Object> getSlardarExtras();

    int getUpdateVersionCode();

    int getVersionCode();

    String getVersionName();

    boolean isAdminMode();

    boolean isDebug();

    boolean isHostApp();

    boolean isPureAndroid();
}
