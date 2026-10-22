package com.obric.memorydata.ability.a;

import android.content.Context;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;
import com.obric.memorydata.ability.data.l;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/ability/helper/TelephonyHelper;", "", "<init>", "()V", "TAG", "", "CELL_MODEL_2G", "CELL_MODEL_3G", "CELL_MODEL_4G", "CELL_MODEL_5G", "CELLID_NR_MAX", "", "CELLID_UNAVAILABLE", "getDefaultSubId", "", "context", "Landroid/content/Context;", "requestCellInfo", "Landroid/telephony/CellInfo;", "subId", "mapping", "Lcom/obric/memorydata/ability/data/MobileCellularStandardData;", "cellInfo", "findOperator", "operatorAlphaLong", "getValueDefault", "i", "convertCellId", "nci", "z", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8302a = null;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/ability/helper/TelephonyHelper$requestCellInfo$1", "Landroid/telephony/TelephonyManager$CellInfoCallback;", "onCellInfo", "", "cellInfo", "", "Landroid/telephony/CellInfo;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TelephonyManager.CellInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<CellInfo> f8303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f8304b;

        a(ArrayList<CellInfo> r1, CountDownLatch r2) {
            this.f8303a = r1;
            this.f8304b = r2;
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "cellInfo");
            this.f8303a.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
            this.f8304b.countDown();
        }
    }

    static {
        f8302a = new d();
    }

    private d() {
    }

    private final int a(int r1) {
        if (r1 != Integer.MAX_VALUE) goto L6;
        return -1;
    L6:
        return r1;
    }

    private final long a(long r5, boolean r7) {
        if (r7 == true) goto L8;
        if (r5 == 2147483647L) goto L12;
        return r5;
    L12:
        return -1;
    L8:
        if (r5 > 68719476735L) goto L12;
        if (r5 < 0) goto L12;
        return r5;
    }

    private final String a(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        return r4;
    L9:
        if (CollectionsKt.listOf(new String[]{"46000", "46002", "46004", "46007"}).contains(r4) == false) goto L13;
        return "中国移动";
    L13:
        if (CollectionsKt.listOf(new String[]{"46001", "46006", "46009"}).contains(r4) == false) goto L17;
        return "中国联通";
    L17:
        if (CollectionsKt.listOf(new String[]{"46003", "46005", "46011"}).contains(r4) == false) goto L21;
        return "中国电信";
    L21:
        if (CollectionsKt.listOf("46020").contains(r4) == false) goto L24;
        return "中国铁通";
    L24:
        return r4;
    L5:
        r3 = false;
        goto L6
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean b(CellInfo r0) {
        return r0.isRegistered();
    }

    /* JADX INFO: renamed from: lambda$UOW3nLZHqUqqhc2QmVc-f1JaPrI, reason: not valid java name */
    public static /* synthetic */ boolean m431lambda$UOW3nLZHqUqqhc2QmVcf1JaPrI(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$r69th2GPWYDKx300b0XYN26AbBo(CellInfo r0) {
        return b(r0);
    }

    public final int a(Context r2) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "context");
        return SubscriptionManager.getDefaultSubscriptionId();
    }

    public final CellInfo a(Context r6, int r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (ActivityCompat.checkSelfPermission(r5, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L5;
        return null;
    L5:
        Object r8 = r5.getSystemService(MemoryKeyInfoEntity.KEY_PHONE);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager r9 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r8, TelephonyManager.class, "com.obric.memorydata.plugin");
        if (r7 < 0) goto L8;
        r9 = r9.createForSubscriptionId(r7);
        Intrinsics.checkNotNullExpressionValue(r9, "createForSubscriptionId(...)");
    L8:
        CountDownLatch r10 = new CountDownLatch(1);
        ArrayList r2 = new ArrayList();
        r9.requestCellInfoUpdate(r5.getMainExecutor(), (TelephonyManager.CellInfoCallback) ZeusTransformUtils.preCheckCast(new a(r2, r10), TelephonyManager.CellInfoCallback.class, "com.obric.memorydata.plugin"));
        r10.await(5, TimeUnit.SECONDS);
        Stream r11 = r2.stream();
        final $$Lambda$d$r69th2GPWYDKx300b0XYN26AbBo r12 = $$Lambda$d$r69th2GPWYDKx300b0XYN26AbBo.INSTANCE;
        return (CellInfo) ZeusTransformUtils.preCheckCast(r11.filter(new $$Lambda$d$UOW3nLZHqUqqhc2QmVcf1JaPrI(r12)).findFirst().orElse(null), CellInfo.class, "com.obric.memorydata.plugin");
    }

    public final l a(CellInfo r11) {
        Intrinsics.checkNotNullParameter(r11, "cellInfo");
        l r0 = new l();
        CharSequence r1 = r11.getCellIdentity().getOperatorAlphaLong();
        if (r1 != null) goto L5;
        r0.d("");
    L6:
        CharSequence r2 = r11.getCellIdentity().getOperatorAlphaShort();
        if (r2 != null) goto L9;
        r0.e("");
    L11:
        if (ZeusTransformUtils.instanceOf(r11, CellInfoNr.class) == false) goto L20;
        CellSignalStrength r3 = ((CellInfoNr) ZeusTransformUtils.preCheckCast(r11, CellInfoNr.class, "com.obric.memorydata.plugin")).getCellSignalStrength();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.telephony.CellSignalStrengthNr");
        CellSignalStrengthNr r4 = (CellSignalStrengthNr) ZeusTransformUtils.preCheckCast(r3, CellSignalStrengthNr.class, "com.obric.memorydata.plugin");
        if (r11.isRegistered() == false) goto L15;
        RunLog.INSTANCE.debug("TelephonyHelper", "CellInfoNr isRegistered:" + r4.getSsRsrp());
        r0.a(a(r4.getSsRsrp()));
        r0.a("5G");
    L15:
        CellIdentity r12 = ((CellInfoNr) ZeusTransformUtils.preCheckCast(r11, CellInfoNr.class, "com.obric.memorydata.plugin")).getCellIdentity();
        Intrinsics.checkNotNullExpressionValue(r12, "getCellIdentity(...)");
        if (ZeusTransformUtils.instanceOf(r12, CellIdentityNr.class) == false) goto L51;
        r0.a(Long.valueOf(a(((CellIdentityNr) ZeusTransformUtils.preCheckCast(r12, CellIdentityNr.class, "com.obric.memorydata.plugin")).getNci(), true)));
        r0.a(Integer.valueOf(((CellIdentityNr) ZeusTransformUtils.preCheckCast(r12, CellIdentityNr.class, "com.obric.memorydata.plugin")).getTac()));
        r0.b(((CellIdentityNr) ZeusTransformUtils.preCheckCast(r12, CellIdentityNr.class, "com.obric.memorydata.plugin")).getMccString());
        r0.c(((CellIdentityNr) ZeusTransformUtils.preCheckCast(r12, CellIdentityNr.class, "com.obric.memorydata.plugin")).getMncString());
        int r10 = ((CellIdentityNr) ZeusTransformUtils.preCheckCast(r12, CellIdentityNr.class, "com.obric.memorydata.plugin")).getPci();
    L18:
        r0.b(r10);
    L51:
        return r0;
    L20:
        if (ZeusTransformUtils.instanceOf(r11, CellInfoGsm.class) == false) goto L27;
        CellSignalStrengthGsm r5 = ((CellInfoGsm) ZeusTransformUtils.preCheckCast(r11, CellInfoGsm.class, "com.obric.memorydata.plugin")).getCellSignalStrength();
        Intrinsics.checkNotNullExpressionValue(r5, "getCellSignalStrength(...)");
        if (r11.isRegistered() == false) goto L24;
        RunLog.INSTANCE.debug("TelephonyHelper", "CellInfoGsm isRegistered:" + r5.getDbm());
        r0.a(a(r5.getDbm()));
        r0.a("2G");
    L24:
        r0.a(Long.valueOf(a(((CellInfoGsm) ZeusTransformUtils.preCheckCast(r11, CellInfoGsm.class, "com.obric.memorydata.plugin")).getCellIdentity().getCid(), false)));
        r0.a(Integer.valueOf(((CellInfoGsm) ZeusTransformUtils.preCheckCast(r11, CellInfoGsm.class, "com.obric.memorydata.plugin")).getCellIdentity().getLac()));
        CellIdentityGsm r13 = ((CellInfoGsm) ZeusTransformUtils.preCheckCast(r11, CellInfoGsm.class, "com.obric.memorydata.plugin")).getCellIdentity();
        Intrinsics.checkNotNullExpressionValue(r13, "getCellIdentity(...)");
        r0.b(r13.getMccString());
        String r14 = r13.getMncString();
    L25:
        r0.c(r14);
        goto L51
    L27:
        if (ZeusTransformUtils.instanceOf(r11, CellInfoCdma.class) == false) goto L33;
        CellSignalStrengthCdma r6 = ((CellInfoCdma) ZeusTransformUtils.preCheckCast(r11, CellInfoCdma.class, "com.obric.memorydata.plugin")).getCellSignalStrength();
        Intrinsics.checkNotNullExpressionValue(r6, "getCellSignalStrength(...)");
        if (r11.isRegistered() == false) goto L31;
        RunLog.INSTANCE.debug("TelephonyHelper", "CellInfoCdma isRegistered:" + r6.getDbm());
        r0.a(a(r6.getDbm()));
        r0.a("3G");
    L31:
        r0.a(Long.valueOf(a(((CellInfoCdma) ZeusTransformUtils.preCheckCast(r11, CellInfoCdma.class, "com.obric.memorydata.plugin")).getCellIdentity().getBasestationId(), false)));
        r0.a(Integer.valueOf(((CellInfoCdma) ZeusTransformUtils.preCheckCast(r11, CellInfoCdma.class, "com.obric.memorydata.plugin")).getCellIdentity().getSystemId()));
        goto L51
    L33:
        if (ZeusTransformUtils.instanceOf(r11, CellInfoLte.class) == false) goto L39;
        CellSignalStrengthLte r7 = ((CellInfoLte) ZeusTransformUtils.preCheckCast(r11, CellInfoLte.class, "com.obric.memorydata.plugin")).getCellSignalStrength();
        Intrinsics.checkNotNullExpressionValue(r7, "getCellSignalStrength(...)");
        if (r11.isRegistered() == false) goto L37;
        RunLog.INSTANCE.debug("TelephonyHelper", "CellInfoLte isRegistered:" + r7.getRsrp());
        r0.a(a(r7.getRsrp()));
        r0.a("4G");
    L37:
        r0.a(Long.valueOf(a(((CellInfoLte) ZeusTransformUtils.preCheckCast(r11, CellInfoLte.class, "com.obric.memorydata.plugin")).getCellIdentity().getCi(), false)));
        r0.a(Integer.valueOf(((CellInfoLte) ZeusTransformUtils.preCheckCast(r11, CellInfoLte.class, "com.obric.memorydata.plugin")).getCellIdentity().getTac()));
        CellIdentityLte r15 = ((CellInfoLte) ZeusTransformUtils.preCheckCast(r11, CellInfoLte.class, "com.obric.memorydata.plugin")).getCellIdentity();
        Intrinsics.checkNotNullExpressionValue(r15, "getCellIdentity(...)");
        r0.b(r15.getMccString());
        r0.c(r15.getMncString());
        r10 = r15.getPci();
        goto L18
    L39:
        if (ZeusTransformUtils.instanceOf(r11, CellInfoTdscdma.class) == false) goto L45;
        CellIdentityTdscdma r8 = ((CellInfoTdscdma) ZeusTransformUtils.preCheckCast(r11, CellInfoTdscdma.class, "com.obric.memorydata.plugin")).getCellIdentity();
        Intrinsics.checkNotNullExpressionValue(r8, "getCellIdentity(...)");
        CellSignalStrengthTdscdma r9 = ((CellInfoTdscdma) ZeusTransformUtils.preCheckCast(r11, CellInfoTdscdma.class, "com.obric.memorydata.plugin")).getCellSignalStrength();
        Intrinsics.checkNotNullExpressionValue(r9, "getCellSignalStrength(...)");
        if (r11.isRegistered() == false) goto L43;
        RunLog.INSTANCE.debug("TelephonyHelper", "CellInfoGsm isRegistered:" + r9.getDbm());
        r0.a(a(r9.getDbm()));
        r0.a("3G");
    L43:
        r0.a(Long.valueOf(a(r8.getCid(), false)));
        r0.a(Integer.valueOf(r8.getLac()));
        r0.b(r8.getMccString());
        r14 = r8.getMncString();
        goto L25
    L45:
        if (ZeusTransformUtils.instanceOf(r11, CellInfoWcdma.class) == false) goto L50;
        CellSignalStrengthWcdma r16 = ((CellInfoWcdma) ZeusTransformUtils.preCheckCast(r11, CellInfoWcdma.class, "com.obric.memorydata.plugin")).getCellSignalStrength();
        Intrinsics.checkNotNullExpressionValue(r16, "getCellSignalStrength(...)");
        if (r11.isRegistered() == false) goto L49;
        RunLog.INSTANCE.debug("TelephonyHelper", "CellInfoWcdma isRegistered:" + r16.getDbm());
        r0.a(a(r16.getDbm()));
        r0.a("3G");
    L49:
        CellIdentityWcdma r17 = ((CellInfoWcdma) ZeusTransformUtils.preCheckCast(r11, CellInfoWcdma.class, "com.obric.memorydata.plugin")).getCellIdentity();
        Intrinsics.checkNotNullExpressionValue(r17, "getCellIdentity(...)");
        r0.a(Long.valueOf(a(r17.getCid(), false)));
        r0.a(Integer.valueOf(r17.getLac()));
        r0.b(r17.getMccString());
        r14 = r17.getMncString();
        goto L25
    L50:
        RunLog.INSTANCE.debug("TelephonyHelper", "mapping: unknown type, " + r11);
        goto L51
    L9:
        r0.e(a(r2.toString()));
        goto L11
    L5:
        r0.d(a(r1.toString()));
        goto L6
    }
}
