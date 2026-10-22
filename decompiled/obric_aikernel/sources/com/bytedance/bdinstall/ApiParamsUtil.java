package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.NetworkStatusProvider;
import com.bytedance.bdinstall.util.OptionsForCommonParamProxy;
import com.bytedance.bdinstall.util.RomUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.bdinstall.util.UIUtils;
import com.bytedance.common.utility.NetworkUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class ApiParamsUtil {
    private final IBDInstallApi installApi;
    private final Map<String, String> sCustomParam;
    private IExtraParams sExtraParams;
    private final Map<String, String> sL0OnlyParams;
    private NetworkStatusProvider sNetworkProvider;
    private int sParamCount;
    private volatile boolean sStarted;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.ApiParamsUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdinstall$Level = null;

        static {
            int[] r10 = new int[Level.values().length];
            $SwitchMap$com$bytedance$bdinstall$Level = r10;
            r10[Level.L0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bdinstall$Level[Level.L1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public ApiParamsUtil(IBDInstallApi r10) {
        this.sStarted = false;
        this.sParamCount = 36;
        this.sCustomParam = new ConcurrentHashMap();
        this.sL0OnlyParams = new ConcurrentHashMap();
        this.installApi = r10;
    }

    private void addCommonParam(Map<String, String> r10) {
        if (RomUtils.isHarmonyUI() == false) goto L5;
        String r11 = "harmony";
    L6:
        r10.put("os", r11);
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (RomUtils.isHarmonyUI() == false) goto L16;
        r10.put("sub_os_api", String.valueOf(SystemPropertiesWithCache.get("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L5:
        r11 = "android";
        goto L6
    }

    private static void copyMap(Map<String, String> r10, Map<String, String> r11, boolean r12) {
        if (r10 != null) goto L24;
        return;
    L24:
        if (r10.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, String>> r13 = r10.entrySet().iterator();     // Catch: Exception -> L23
    L6:
        if (r13.hasNext() == false) goto L43;
        Map.Entry<String, String> r14 = r13.next();     // Catch: Exception -> L23
        if (r14 == null) goto L6;
        String r15 = r14.getKey();     // Catch: Exception -> L23
        String r16 = r14.getValue();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r15) == true) goto L6;
        if (TextUtils.isEmpty(r16) == true) goto L6;
        if (r12 == false) goto L20;
        if (r11.containsKey(r15) == true) goto L6;
    L20:
        r11.put(r15, r16);     // Catch: Exception -> L23
        goto L6
    L43:
        return;
    L41:
        return;
    }

    private boolean started(Context r10, InstallOptions r11, boolean r12, InstallInfo r13) {
        if (r12 == false) goto L10;
        boolean r14 = this.sStarted;
        if (r14 == true) goto L9;
        r14 = LocalConstants.getCommonSp(r10, r11).getBoolean(Api.KEY_STARTED, false);
        if (r14 == false) goto L9;
        this.sStarted = true;
    L9:
        return r14;
    L10:
        if (r13 == null) goto L17;
        if (TextUtils.isEmpty(r13.getDid()) == true) goto L17;
        if (TextUtils.isEmpty(r13.getIid()) == true) goto L17;
        return true;
    L17:
        return false;
    }

    public void addCustomParamsWithLevel(String r10, String r11, Level r12) {
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r11) == true) goto L19;
        int r13 = AnonymousClass1.$SwitchMap$com$bytedance$bdinstall$Level[r12.ordinal()];
        if (r13 != 1) goto L12;
        Map<String, String> r14 = this.sL0OnlyParams;
    L16:
        r14.put(r10, r11);
        return;
    L12:
        if (r13 != 2) goto L20;
        r14 = this.sCustomParam;
        goto L16
    L20:
        return;
    }

    public String appendNetParams(Context r10, StringBuilder r11, String r12, boolean r13, Level r14) {
        String r15 = r11.toString();
        if (TextUtils.isEmpty(r15) == false) goto L5;
        return r15;
    L5:
        Uri r16 = Uri.parse(r15);
        Set<String> r17 = r16.getQueryParameterNames();
        Uri.Builder r18 = r16.buildUpon();
        LinkedHashMap r19 = new LinkedHashMap(this.sParamCount);
        appendParamsToMap(r10, r13, r12, r19, r14);
        Iterator<Map.Entry<String, String>> r110 = r19.entrySet().iterator();
    L7:
        if (r110.hasNext() == false) goto L13;
        Map.Entry<String, String> r111 = r110.next();
        String r112 = r111.getKey();
        String r113 = r111.getValue();
        if (r17.contains(r112) == true) goto L7;
        if (TextUtils.isEmpty(r113) == true) goto L7;
        r18.appendQueryParameter(r112, r111.getValue());
        goto L7
    L13:
        r11.delete(0, r11.length());
        r11.append(r18.build().toString());
        this.sParamCount = r19.size();
        return r11.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void appendParamsToMap(Context r10, boolean r11, String r12, Map<String, String> r13, Level r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        r13.put("device_platform", "android");
        addCommonParam(r13);
        if (r11 == false) goto L7;
        r13.put(Api.KEY_SSMIX, "a");
    L7:
        r13.put(Api.KEY_RTICKET, String.valueOf(System.currentTimeMillis()));
        InstallOptions r15 = this.installApi.getInstallOptions();
        AppContext r16 = this.installApi.getAppContext();
        String r17 = Cdid.get(r15);
        if (TextUtils.isEmpty(r17) == false) goto L14;
        if (r16 == 0) goto L14;
        if (r16.isMainInstance() == false) goto L14;
        r17 = Cdid.getMainInstanceCdid(r10);
    L14:
        if (TextUtils.isEmpty(r17) == true) goto L16;
        r13.put(Cdid.KEY_CDID, r17);
    L16:
        HashMap<String, String> r18 = null;
        if (r15 == null) goto L19;
        OptionsForCommonParamProxy r19 = new OptionsForCommonParamProxy(r15);
    L20:
        if (r19 != null) goto L23;
        if (r16 == 0) goto L23;
        r19 = new OptionsForCommonParamProxy(r16);
    L23:
        if (r19 == null) goto L39;
        String r20 = r19.getChannel();
        if (TextUtils.isEmpty(r20) == true) goto L28;
        r13.put("channel", r20);
    L28:
        if (r12 != null) goto L31;
        r12 = String.valueOf(r19.getAid());
    L31:
        r13.put("aid", r12);
        String r21 = r19.getAppName();
        if (r21 == null) goto L34;
        r13.put(Api.KEY_APP_NAME, r21);
    L35:
        r13.put("version_code", String.valueOf(r19.getVersionCode()));
        String r22 = r19.getVersion();
        if (r22 == null) goto L38;
        r13.put("version_name", r22);
    L38:
        r13.put("manifest_version_code", String.valueOf(r19.getManifestVersionCode()));
        r13.put("update_version_code", String.valueOf(r19.getUpdateVersionCode()));
        goto L39
    L34:
        DrLog.ysnp(new IllegalArgumentException("app_name is null"));
    L39:
        if (r15 == null) goto L41;
        IAbContext r23 = r15.getAbContext();
    L42:
        if (r23 == null) goto L45;
        r16 = r23;
    L45:
        if (r16 == 0) goto L61;
        String r24 = r16.getAbVersion();
        if (TextUtils.isEmpty(r24) == true) goto L49;
        r13.put(Api.KEY_AB_VERSION, r24);
    L49:
        String r25 = r16.getAbClient();
        if (TextUtils.isEmpty(r25) == true) goto L52;
        r13.put(Api.KEY_AB_CLIENT, r25);
    L52:
        String r26 = r16.getAbGroup();
        if (TextUtils.isEmpty(r26) == true) goto L55;
        r13.put(Api.KEY_AB_GROUP, r26);
    L55:
        String r27 = r16.getAbFeature();
        if (TextUtils.isEmpty(r27) == true) goto L58;
        r13.put(Api.KEY_AB_FEATURE, r27);
    L58:
        long r28 = r16.getAbFlag();
        if (r28 <= 0) goto L61;
        r13.put(Api.KEY_ABFLAG, String.valueOf(r28));
    L61:
        if (r15 == null) goto L65;
        INewUserModeService r29 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(r15.getAid()));
        if (r29 == null) goto L65;
        r29.mapCustomParams(r13);
    L65:
        String r30 = UIUtils.getScreenResolution(r10);
        if (TextUtils.isEmpty(r30) == true) goto L68;
        r13.put("resolution", r30);
    L68:
        int r31 = UIUtils.getDpi(r10);
        if (r31 <= 0) goto L71;
        r13.put(Api.KEY_DPI, String.valueOf(r31));
    L71:
        String r32 = Build.BRAND;
        if (r32.equals("Pico") == false) goto L74;
        String r33 = RomUtils.getProductName();
    L75:
        r13.put(Api.KEY_DEVICE_TYPE, r33);
        r13.put("device_brand", r32);
        r13.put(Api.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        r13.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r34 = Build.VERSION.RELEASE;     // Catch: Exception -> L123
        if (r34 != null) goto L79;
    L81:
        r13.put("os_version", r34);     // Catch: Exception -> L123
        goto L82
    L79:
        if (r34.length() <= 10) goto L81;
        r34 = r34.substring(0, 10);     // Catch: Exception -> L123
    L82:
        NetworkStatusProvider r35 = this.sNetworkProvider;
        if (r35 == null) goto L87;
        String r36 = r35.getNetworkType().name();
        if (TextUtils.isEmpty(r36) == true) goto L91;
        r13.put(Api.KEY_AC, r36);
        StringBuilder r37 = new StringBuilder();
        String r38 = "NetworkStatusProvider network type is ";
    L90:
        r37.append(r38);
        r37.append(r36);
        DrLog.d(r37.toString());
    L91:
        copyMap(this.sCustomParam, r13, false);
        if (r14 != Level.L0) goto L126;
        copyMap(this.sL0OnlyParams, r13, false);
    L126:
        IExtraParams r39 = this.sExtraParams;     // Catch: Exception -> L100
        if (r39 == null) goto L98;
        r18 = r39.getExtraParams(r14);     // Catch: Exception -> L100
    L98:
        copyMap(r18, r13, true);     // Catch: Exception -> L100
    L102:
        boolean r40 = Utils.isMainProcess(r10);
        InstallInfo r41 = this.installApi.getInstallInfo();
        if (started(r10, r15, r40, r41) == false) goto L119;
        if (r41 == null) goto L117;
        if (TextUtils.isEmpty(r41.getIid()) == true) goto L109;
        r13.put("iid", r41.getIid());
    L109:
        if (TextUtils.isEmpty(r41.getDid()) == true) goto L112;
        r13.put("device_id", r41.getDid());
    L112:
        if (r14 != Level.L0) goto L117;
        String r42 = r41.getOpenUdid();
        if (TextUtils.isEmpty(r42) == true) goto L117;
        r13.put("openudid", r42);
    L117:
        if (r14 != Level.L0) goto L119;
        ApiParamsForFlavor.addSstParams(r10, r13, r40, r15);
    L119:
        ApiParamsForFlavor.addCommonParams(r40, r10, r15);
        IParamFilter r43 = this.installApi.getParamsFilter();
        if (r43 == null) goto L128;
        r43.filterCommonParams(r13);
        return;
    L128:
        return;
    L100:
        e = move-exception;
        DrLog.ysnp(e);
        goto L102
    L87:
        r36 = NetworkUtils.c(r10);
        if (TextUtils.isEmpty(r36) == true) goto L91;
        r13.put(Api.KEY_AC, r36);
        r37 = new StringBuilder();
        r38 = "NetworkUtils network type is ";
        goto L90
    L74:
        r33 = Build.MODEL;
        goto L75
    L41:
        r23 = null;
        goto L42
    L19:
        r19 = null;
        goto L20
    }

    public void removeCustomParamsWithLevel(String r10, Level r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return;
    L7:
        int r12 = AnonymousClass1.$SwitchMap$com$bytedance$bdinstall$Level[r11.ordinal()];
        if (r12 != 1) goto L10;
        Map<String, String> r13 = this.sL0OnlyParams;
    L14:
        r13.remove(r10);
        return;
    L10:
        if (r12 != 2) goto L16;
        r13 = this.sCustomParam;
        goto L14
    }

    public void setExtraParams(IExtraParams r10) {
        if (this.sExtraParams != null) goto L7;
        if (r10 == null) goto L8;
        this.sExtraParams = r10;
        return;
    L8:
        return;
    }

    public void setNetworkProvider(NetworkStatusProvider r10) {
        this.sNetworkProvider = r10;
    }
}
