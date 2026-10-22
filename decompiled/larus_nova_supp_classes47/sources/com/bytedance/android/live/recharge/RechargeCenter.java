package com.bytedance.android.live.recharge;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.recharge.balance.WalletBalanceService;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class RechargeCenter implements zv0.f {
    private static final String TAG = "RechargeCenter";
    private static volatile RechargeCenter sInstance;
    private boolean isFirstEnterRoom;
    private final pa0.f userIncomeRepository;
    private com.bytedance.android.live.recharge.balance.d walletBalanceService;

    public static /* synthetic */ void a(com.bytedance.android.live.recharge.balance.c r0) {
        lambda$syncWithExtra$3(r0);
    }

    public static /* synthetic */ void b(Throwable r0) {
        lambda$syncFromEnterRoom$6(r0);
    }

    public static /* synthetic */ void c(RechargeCenter r0, com.bytedance.android.live.recharge.balance.c r1) {
        r0.lambda$syncFromEnterRoom$5(r1);
    }

    public static /* synthetic */ void d(String r0, Throwable r1) {
        lambda$sync$2(r0, r1);
    }

    public static /* synthetic */ ExchangeInfo e(pa0.e r0) {
        return lambda$observeExchangeInfo$0(r0);
    }

    public static /* synthetic */ void f(String r0, Throwable r1) {
        lambda$syncWithExtra$4(r0, r1);
    }

    public static /* synthetic */ void g(com.bytedance.android.live.recharge.balance.c r0) {
        lambda$sync$1(r0);
    }

    private static /* synthetic */ void lambda$sync$1(com.bytedance.android.live.recharge.balance.c r0) throws Exception {
    }

    private static /* synthetic */ void lambda$syncWithExtra$3(com.bytedance.android.live.recharge.balance.c r0) throws Exception {
    }

    public static zv0.f getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(RechargeCenter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new RechargeCenter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RechargeCenter.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private com.bytedance.android.live.recharge.balance.d getWalletBalanceService() {
        com.bytedance.android.live.recharge.balance.d r0 = this.walletBalanceService;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.android.live.recharge.core.d r1 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r1, "$this$walletBalanceService");
        com.bytedance.android.live.recharge.balance.d r2 = (com.bytedance.android.live.recharge.balance.d) r1.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.balance.d.class));
        this.walletBalanceService = r2;
        return r2;
    }

    private boolean isNeedSyncWalletInfo() {
        int r0 = ((Number) com.bytedance.android.live.recharge.utils.j.e.getValue(null, com.bytedance.android.live.recharge.utils.j.a[3])).intValue();
        if (r0 != 0) goto L5;
        return true;
    L5:
        String r3 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getUserId();
        if (r3 != null) goto L8;
    L22:
        return false;
    L8:
        if (r3.isEmpty() == true) goto L22;
        com.bytedance.tools.kcp.spongepreference.runtime.a r5 = r.d;
        KProperty[] r6 = r.a;
        Map r8 = (Map) r5.getValue(null, r6[2]);
        Long r9 = (Long) r8.get(r3);
        long r10 = System.currentTimeMillis();
        if (r9 != null) goto L13;
    L20:
        r8.put(r3, Long.valueOf(r10));
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r5.setValue(null, r6[2], r8);
        return true;
    L13:
        if (r9.longValue() <= 0) goto L20;
        if ((r10 - r9.longValue()) < ((((long) r0) * 60) * 1000)) goto L18;
        r8.put(r3, Long.valueOf(r10));
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r5.setValue(null, r6[2], r8);
        return true;
    L18:
        com.bytedance.android.live.recharge.utils.f.b("livesdk_wallet_info_request_intercept");
        return false;
    }

    private boolean userLogin() {
        return ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin();
    }

    @Override // zv0.f
    public ExchangeInfo getExchangeInfo() {
        return ((pa0.e) this.userIncomeRepository.a().b).a();
    }

    @Override // zv0.f
    public Observable<ExchangeInfo> observeExchangeInfo() {
        return com.bytedance.android.live.revenue.common.reactive.j.a(this.userIncomeRepository.a(), false).map(new u());
    }

    @Override // zv0.f
    public void syncExchangeInfo() {
        this.userIncomeRepository.b();
    }

    private RechargeCenter() {
        this.isFirstEnterRoom = true;
        this.userIncomeRepository = pa0.o.c;
    }

    @Override // zv0.f
    public long getAvailableDiamonds() {
        if (userLogin() == true) goto L7;
        return 0;
    L7:
        return ((Long) getWalletBalanceService().n().getValue()).longValue();
    }

    @Override // zv0.f
    public boolean isSyncWalletInfoSuccess() {
        if (getWalletBalanceService().U().b == WalletBalanceService.f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zv0.f
    public Observable<Long> observeWallet() {
        return com.bytedance.android.live.revenue.common.reactive.j.a(getWalletBalanceService().n(), false).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // zv0.f
    public void syncFromEnterRoom() {
        if (userLogin() == true) goto L6;
        reportSyncWalletNotLogin("enter_room");
        ALogger.e(TAG, "user not login");
        return;
    L6:
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 != null) goto L9;
        return;
    L9:
        IRoom r1 = r0.getRoom();
        if (r1.getRoomAuthStatus() != null) goto L12;
    L24:
        ALogger.e(TAG, "room auth error");
        return;
    L12:
        if (r1.getRoomAuthStatus().getEnableGift() == false) goto L24;
        if (((com.bytedance.android.live.recharge.utils.b) com.bytedance.android.live.recharge.utils.j.m.getValue(null, com.bytedance.android.live.recharge.utils.j.a[11])).a() == true) goto L20;
        if (this.isFirstEnterRoom == false) goto L26;
        getWalletBalanceService().C1(new com.bytedance.android.live.recharge.balance.f("enter_room", null)).subscribe(new s(this), new t());
        return;
    L26:
        return;
    L20:
        if (isNeedSyncWalletInfo() == true) goto L22;
        return;
    L22:
        sync("enter_room");
    }

    private static /* synthetic */ ExchangeInfo lambda$observeExchangeInfo$0(pa0.e r0) throws Exception {
        return r0.a();
    }

    private /* synthetic */ void lambda$syncFromEnterRoom$5(com.bytedance.android.live.recharge.balance.c r1) throws Exception {
        this.isFirstEnterRoom = false;
    }

    private static /* synthetic */ void lambda$syncFromEnterRoom$6(Throwable r0) throws Exception {
        com.bytedance.android.live.recharge.utils.f.b("livesdk_wallet_info_enter_room_fail");
    }

    private void reportSyncWalletNotLogin(String r3) {
        HashMap r0 = new HashMap();
        r0.put("entrance", r3);
        r0.put("error_code", "-999");
        r0.put("error_msg", "user not login");
        com.bytedance.android.live.recharge.trace.g r4 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_WALLET_INFO, r0);
    }

    @Override // zv0.f
    public boolean isDiamondAvailable(long r5) {
        if (userLogin() == true) goto L6;
        return false;
    L6:
        if (getAvailableDiamonds() < r5) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // zv0.f
    public void setAvailableDiamonds(long r2) {
        if (userLogin() == true) goto L5;
        return;
    L5:
        getWalletBalanceService().x1(r2);
    }

    @Override // zv0.f
    public void sync(final String r4) {
        if (userLogin() == true) goto L6;
        reportSyncWalletNotLogin(r4);
        return;
    L6:
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        getWalletBalanceService().C1(new com.bytedance.android.live.recharge.balance.f(r4, null)).subscribe(new p(), new q(r4));
    }

    private static /* synthetic */ void lambda$sync$2(String r2, Throwable r3) throws Exception {
        ALogger.e(TAG, "sync wallet info failed, entrance = " + r2, r3);
    }

    private static /* synthetic */ void lambda$syncWithExtra$4(String r2, Throwable r3) throws Exception {
        ALogger.e(TAG, "sync wallet info with extra failed, entrance = " + r2, r3);
    }

    @Override // zv0.f
    public void syncWithExtra(final String r3, String r4) {
        if (userLogin() == true) goto L6;
        reportSyncWalletNotLogin(r3);
        return;
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        getWalletBalanceService().C1(new com.bytedance.android.live.recharge.balance.f(r3, r4)).subscribe(new n(), new o(r3));
    }
}
