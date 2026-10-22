package com.unicom.online.account.shield;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.unicom.online.account.kernel.a;
import com.unicom.online.account.kernel.ac;
import com.unicom.online.account.kernel.b;
import com.unicom.online.account.kernel.i;
import com.unicom.online.account.kernel.j;
import com.unicom.online.account.kernel.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class UniAccountHelper {
    private static final int CU_GET_TOKEN_GM = 3;
    private static final int CU_GET_TOKEN_IT = 2;
    private static final int CU_GET_TOKEN_LOOP = 32;
    private static final int CU_GET_UAID_GM = 25;
    private static final int CU_GET_UAID_IT = 24;
    private static final int CU_GET_UAID_LOOP = 33;
    private static final int CU_MOBILE_AUTH_GM = 5;
    private static final int CU_MOBILE_AUTH_IT = 4;
    private static final int ID_0_STOP_ONCE_SUCCESS = 0;
    private static final int ID_1_STOP_ALL_SEND = 1;
    private static final int LOOP_TYPE_TOKEN = 1;
    private static final int LOOP_TYPE_UAID = 2;
    private static final int LoopMaxNum = 5;
    private static int LoopTypeFlag = 0;
    private static final int SUCCESS = 100;
    private static final boolean enableToken = true;
    private static final boolean enableUAID = false;
    private static int loopNumCommon;
    private static int loopNumToken;
    private static int loopNumUaid;
    private static volatile UniAccountHelper s_instance;
    private Context mContext;
    Handler mainHandler;

    private UniAccountHelper() {
        this.mContext = null;
    }

    public static /* synthetic */ void access$000(UniAccountHelper r0) {
        r0.loopNumCommonMinus();
    }

    public static /* synthetic */ void access$100() {
        cuResetLoopSrc();
    }

    public static /* synthetic */ int access$200() {
        return loopNumCommon;
    }

    public static /* synthetic */ void access$300(UniAccountHelper r0, int r1, int r2, int r3, ResultListener r4) {
        r0.cuGetTokenUaidLoopCommon(r1, r2, r3, r4);
    }

    public static /* synthetic */ Context access$400(UniAccountHelper r0) {
        return r0.mContext;
    }

    private UniAccountHelper clearCache_one(int r3) {
        if (this.mContext != null) goto L6;
        a.a("clearCache sdk未初始化 ---> " + System.currentTimeMillis());
        return null;
    L6:
        b.a();
        i.a().a(this.mContext, r3);
        return s_instance;
    }

    private static int clrLoopTypeFlag() {
        LoopTypeFlag = 0;
        return 0;
    }

    private void cuGetTokenLoop(int r8, int r9, int r10, ResultListener r11) {
        a.a("cuGetTokenLoop ---> " + System.currentTimeMillis());
        if (isInUaidLoop() == false) goto L7;
        initFail(r9, r11, 410023, "取号服务中，勿重复调用", r10);
        return;
    L7:
        if (isInTokenLoop() == false) goto L10;
        initFail(r9, r11, 410023, "取号服务中，勿重复调用", r10);
        return;
    L10:
        setLoopTypeFlag(1);
        int r0 = loopNumToken + loopNumAdd(r8);
        loopNumToken = r0;
        loopNumCommon = r0;
        cuGetTokenUaidLoopCommon(0, r9, r10, r11);
    }

    private void cuGetTokenUaidLoopCommon(int r9, int r10, int r11, ResultListener r12) {
        if (loopNumCommon != 0) goto L7;
        cuResetLoopSrc();
        return;
    L7:
        if (r9 == 1) goto L11;
        1 r0 = new 1(this, r10, r12, r9, r11);
    L9:
        cuPreGetToken(r11, r10, "cuPreGetToken", r0);
        return;
    L11:
        r0 = new 2(this, r10, r12, r9, r11);
        goto L9
    }

    private void cuGetUaid(int r7, ResultListener r8) {
        initFail(0, r8, 410022, "不支持该服务", r7);
    }

    private void cuGetUaidLoop(int r7, int r8, int r9, ResultListener r10) {
        initFail(r8, r10, 410022, "不支持该服务", r9);
    }

    private void cuGetUaidLoop(int r7, int r8, ResultListener r9) {
        initFail(0, r9, 410022, "不支持该服务", r8);
    }

    private static boolean cuIsToken(int r0) {
        return ac.a(r0);
    }

    private static boolean cuIsUaid(int r0) {
        return ac.b(r0);
    }

    private void cuPreGetToken(int r10, int r11, String r12, ResultListener r13) {
        Context r0 = this.mContext;
        if (r0 != null) goto L7;
        initFail(r11, r13, "sdk未初始化", r10);
        return;
    L7:
        if (i.b(r0.getApplicationContext()) == true) goto L9;
        initFail(r11, r13, 410004, "数据网络未开启", r10);
        return;
    L9:
        if (getUseCacheFlag() == false) goto L36;
        i r1 = i.a();
        Context r2 = this.mContext;
        if (r12.equals(r1.b) == false) goto L13;
        String r3 = j.a(r2, i.a(r11), r12 + r1.c);
    L15:
        if (b.e(r3).booleanValue() == false) goto L36;
        JSONObject r4 = new JSONObject(r3);     // Catch: Exception -> L35
        int r5 = JSONObjectProtectorUtils.getInt(r4, "resultCode");     // Catch: Exception -> L35
        JSONObjectProtectorUtils.getInt(r4, EffectConfiguration.KEY_TYPE);     // Catch: Exception -> L67
    L20:
        if (cuIsToken(2) == false) goto L28;
        long r6 = JSONObjectProtectorUtils.getLong(JSONObjectProtectorUtils.getJSONObject(r4, "resultData"), "exp");     // Catch: Exception -> L35
        if (r5 != 100) goto L36;
        if (r6 <= System.currentTimeMillis()) goto L36;
        r13.onResult(r3);     // Catch: Exception -> L35
        return;
    L28:
        if (cuIsUaid(2) == false) goto L36;
        long r7 = JSONObjectProtectorUtils.getLong(r4, "exp");     // Catch: Exception -> L35
        if (r5 != 100) goto L36;
        if (r7 <= System.currentTimeMillis()) goto L36;
        r13.onResult(r3);     // Catch: Exception -> L35
        return;
    L13:
        r3 = "";
    L36:
        i.a();
        if (i.a(this.mContext) == true) goto L41;
        initFail(r11, r13, 410025, "操作频繁,请稍后再试", r10);
        return;
    L41:
        if (r12.equals("cuPreGetToken") == true) goto L44;
        initFail(r11, r13, "sdk参数错误", r10);
        return;
    L44:
        if (r11 != 2) goto L46;
    L61:
        i r8 = i.a();
        4 r9 = new 4(this, r11, r12, r10, r13);
        if (r8.a("cuPreGetToken", r10, r11, r9) == false) goto L72;
        new x().a(r8.a, r10, r11, r9);
        return;
    L72:
        return;
    L46:
        if (r11 == 3) goto L61;
        if (r11 == 4) goto L61;
        if (r11 == 5) goto L61;
        if (r11 != CU_GET_UAID_IT) goto L54;
    L57:
        i r14 = i.a();
        3 r15 = new 3(this, r11, r12, r13);
        if (r14.a("cuPreGetUAID", r10, r11, r15) == false) goto L71;
        new x().a(r14.a, r10, r11, r15);
        return;
    L71:
        return;
    L54:
        if (r11 == CU_GET_UAID_GM) goto L57;
        initFail(r11, r13, "sdk type 参数错误", r10);
    }

    private static void cuResetLoopSrc() {
        loopNumCommon = 0;
        loopNumToken = 0;
        loopNumUaid = 0;
        clrLoopTypeFlag();
    }

    public static String getCertFingerType() {
        return ac.e;
    }

    private String getHostName() {
        i.a();
        return i.d();
    }

    public static UniAccountHelper getInstance() {
        if (s_instance != null) goto L15;
        monitor-enter(UniAccountHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (s_instance != null) goto L9;
        s_instance = new UniAccountHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(UniAccountHelper.class);     // Catch: Throwable -> L11
    L15:
        return s_instance;
    }

    private static int getLoopTypeFlag() {
        return LoopTypeFlag;
    }

    private String getSdkVersion() {
        i.a();
        return i.b();
    }

    private UniAccountHelper initCustmType(int r1) {
        i.a();
        i.b(r1);
        return s_instance;
    }

    private void initFail(int r8, ResultListener r9, int r10, String r11, int r12) {
        a.b("type:" + r8 + "\nmsg:" + r11);
        String r2 = i.g();     // Catch: Exception -> L10
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L10
        r13.put("resultCode", r10);     // Catch: Exception -> L10
        r13.put("resultMsg", r11);     // Catch: Exception -> L10
        r13.put("resultData", "");     // Catch: Exception -> L10
        r13.put("seq", r2);     // Catch: Exception -> L10
        cuResetLoopSrc();     // Catch: Exception -> L10
        if (r9 == null) goto L6;
        r9.onResult(r13.toString());     // Catch: Exception -> L10
    L6:
        i.a();     // Catch: Exception -> L10
        if (i.c() == false) goto L15;
        i.a();     // Catch: Exception -> L10
        i.a().b(i.a(1, 1, r2, r10, r12, r10, r11));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        a.a(e);
    }

    private void initFail(int r7, ResultListener r8, String r9, int r10) {
        initFail(r7, r8, 410021, r9, r10);
    }

    private UniAccountHelper initHostName(String r1) {
        i.a();
        if (i.c(r1) == true) goto L7;
        a.b("初始化参数错误");
        return null;
    L7:
        return s_instance;
    }

    private static boolean isInTokenLoop() {
        if ((LoopTypeFlag & 1) == 0) goto L5;
        return enableToken;
    L5:
        return false;
    }

    private static boolean isInUaidLoop() {
        if ((LoopTypeFlag & 2) == 0) goto L6;
        return enableToken;
    L6:
        return false;
    }

    private int loopNumAdd(int r2) {
        if (r2 < 5) goto L6;
        return 5;
    L6:
        if (r2 > 1) goto L10;
        return 1;
    L10:
        return r2;
    }

    private void loopNumCommonMinus() {
        int r0 = loopNumCommon;
        if (r0 <= 5) goto L7;
        int r1 = 4;
    L5:
        loopNumCommon = r1;
        return;
    L7:
        if (r0 <= 0) goto L9;
        r1 = r0 - 1;
        goto L5
    L9:
        r1 = 0;
        goto L5
    }

    private static int setLoopTypeFlag(int r1) {
        int r2 = r1 | LoopTypeFlag;
        LoopTypeFlag = r2;
        return r2;
    }

    public UniAccountHelper clearCache() {
        if (this.mContext != null) goto L6;
        a.a("clearCache sdk未初始化 ---> " + System.currentTimeMillis());
        return null;
    L6:
        b.a();
        i.a();
        i.c(this.mContext);
        return s_instance;
    }

    public String cuDebugInfo(String r2) {
        if (this.mContext != null) goto L7;
        return "sdk 未初始化, context 为空";
    L7:
        return i.a().a(r2);
    }

    public void cuGetToken(int r3, ResultListener r4) {
        if (ac.a == false) goto L5;
        int r0 = 3;
    L6:
        cuPreGetToken(r3, r0, "cuPreGetToken", r4);
        return;
    L5:
        r0 = 2;
        goto L6
    }

    public void cuGetTokenLoop(int r2, int r3, ResultListener r4) {
        if (ac.a == false) goto L5;
        int r0 = 3;
    L6:
        cuGetTokenLoop(r2, r0, r3, r4);
        return;
    L5:
        r0 = 2;
        goto L6
    }

    public void cuMobileAuth(int r3, ResultListener r4) {
        if (ac.a == false) goto L5;
        int r0 = 5;
    L6:
        cuPreGetToken(r3, r0, "cuPreGetToken", r4);
        return;
    L5:
        r0 = 4;
        goto L6
    }

    public boolean getUseCacheFlag() {
        return ac.d;
    }

    public UniAccountHelper init(Context r2, String r3) {
        return init(r2, r3, false);
    }

    public UniAccountHelper init(Context r3, String r4, boolean r5) {
        if (r3 != null) goto L5;
    L19:
        String r6 = "初始化参数不能为空";
    L12:
        a.b(r6);
        return null;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        if (TextUtils.isEmpty(r4) == true) goto L19;
        if (this.mContext == null) goto L14;
        r6 = "重复初始化";
        goto L12
    L14:
        this.mContext = r3.getApplicationContext();
        if (i.a().a(r3, r4, r4, r5) == true) goto L17;
        r6 = "UniAuthHelper.getInstance().init 初始化错误";
        goto L12
    L17:
        b.a = r4;
        this.mainHandler = new Handler(Looper.getMainLooper());
        return s_instance;
    }

    public void releaseNetwork() {
        i.a();
        i.f();
    }

    public UniAccountHelper setCBinMainThread(boolean r1) {
        ac.f = r1;
        return s_instance;
    }

    public UniAccountHelper setCertFingerType(String r2) {
        if (r2.equalsIgnoreCase("MD5") == false) goto L5;
    L13:
        ac.e = r2.toLowerCase();
        return s_instance;
    L5:
        if (r2.equalsIgnoreCase("SHA1") == true) goto L13;
        if (r2.equalsIgnoreCase("SHA256") == true) goto L13;
        if (r2.equalsIgnoreCase("sm3") == true) goto L13;
        return null;
    }

    public UniAccountHelper setCryptoGM(boolean r1) {
        ac.a = r1;
        return s_instance;
    }

    public void setLogEnable(boolean r1) {
        a.a(r1);
        i.a();
        i.a(r1);
    }

    public UniAccountHelper setUseCacheFlag(boolean r1) {
        ac.d = r1;
        return s_instance;
    }
}
