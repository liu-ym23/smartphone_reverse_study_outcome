package com.ss.android.lark.flow.notification.offline;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Base64;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.pb.improto.AppId;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.improto.PutSameDeviceJudgeInfoRequest;
import com.ss.android.lark.pb.improto.PutSameDeviceJudgeInfoResponse;
import com.ss.android.lark.pb.improto.SameDeviceJudgeItem;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J.\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020$H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006&"}, d2 = {"Lcom/ss/android/lark/flow/notification/offline/InitFlowReportSameDeviceJudgeTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "kvRepo", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "getKvRepo", "()Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "kvRepo$delegate", "Lkotlin/Lazy;", "officeSDKFeedApi", "Lcom/ss/android/lark/officesdk/feed/api/IOfficeSDKFeedApi;", "getOfficeSDKFeedApi", "()Lcom/ss/android/lark/officesdk/feed/api/IOfficeSDKFeedApi;", "execute", "", "context", "Landroid/content/Context;", "reportIfNeeded", "buildItem", "Lcom/ss/android/lark/pb/improto/SameDeviceJudgeItem;", "detectApp", "Lcom/ss/android/lark/pb/improto/AppId;", "uid", "", "did", "nowMs", "", "detectPeerApp", "isPackageInstalled", "", "packageName", "getDeviceFingerprint", "buildStableBuildHash", "delayDuration", "", "Companion", "flow-notification_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitFlowReportSameDeviceJudgeTask extends AsyncLaunchTask<Object> {
    public static final /* synthetic */ int d = 0;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public final int c() {
        return 5;
    }

    public InitFlowReportSameDeviceJudgeTask() {
        this.c = LazyKt.lazy(InitFlowReportSameDeviceJudgeTask$kvRepo$2.INSTANCE);
    }

    public final void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        thb.a.b("InitFlowReportSameDeviceJudgeTask", "execute start");
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.feidou.report_device_info") == true) goto L28;
        thb.a.b("InitFlowReportSameDeviceJudgeTask", "not in fg, return");
        return;
    L28:
        qtb.b r1 = (qtb.b) k.a(LarkContext.getApplication(), qtb.b.class);     // Catch: Throwable -> L8
    L10:
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L26;
        thb.a.b("InitFlowReportSameDeviceJudgeTask", "im feature not opened, return");
        return;
    L26:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        k(r4);     // Catch: Throwable -> L20
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L30;
        Intrinsics.checkNotNullParameter("InitFlowReportSameDeviceJudgeTask", "tag");
        Intrinsics.checkNotNullParameter("reportIfNeeded exception", "msg");
        Log.e("InitFlowReportSameDeviceJudgeTask", "[FlowNotificationLog] ".concat("reportIfNeeded exception"), r6);
        return;
    L30:
        return;
    L20:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L12:
        if (r1.getIsImFeatureOpenedByHostManual() == true) goto L14;
        r2 = true;
    L8:
        th = move-exception;
        Log.e("InitFlowReportSameDeviceJudgeTask", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        r1 = null;
        goto L10
    }

    public final void k(Context r24) {
        if (j(r24, "com.ss.android.lark") == false) goto L5;
    L8:
        AppId r0 = AppId.APP_ID_FEISHU;
    L9:
        AppId r2 = r0;
        if (r2.getValue() == ((KVRepo) this.c.getValue()).getInt("peer_app_id", -1)) goto L12;
        boolean r1 = true;
    L13:
        final long r7 = System.currentTimeMillis();
        long r12 = ((KVRepo) this.c.getValue()).getLong("notify_time", 0);
        ((KVRepo) this.c.getValue()).putInt("peer_app_id", r2.getValue());
        if (r1 == true) goto L24;
        long r14 = r7 - r12;
        if (0 <= r14) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L24;
        thb.a.b("InitFlowReportSameDeviceJudgeTask", "skip: reported within 12h, last=" + r12);
        return;
    L18:
        if (r14 >= 43200000) goto L20;
        r3 = true;
    L24:
        String r4 = OfficeSDKManager.getCurrentUid();
        IDeviceInfoProvider r5 = OfficeSDKManager.getDeviceInfoProvider();
        SameDeviceJudgeItem r9 = null;
        if (r5 == null) goto L27;
        String r10 = r5.getDeviceId();
    L28:
        if (r4 == null) goto L30;
        Long r11 = StringsKt.toLongOrNull(r4);
    L31:
        if (r10 == null) goto L33;
        Long r13 = StringsKt.toLongOrNull(r10);
    L34:
        if (r11 == null) goto L50;
        if (r13 == null) goto L50;
        Object r15 = "";
        String[] r16 = new String[11];
        r16[0] = "MF=" + Build.MANUFACTURER;
        r16[1] = "BR=" + Build.BRAND;
        r16[2] = "MD=" + Build.MODEL;
        r16[3] = "DV=" + Build.DEVICE;
        r16[4] = "PR=" + Build.PRODUCT;
        r16[5] = "BD=" + Build.BOARD;
        r16[6] = "HW=" + Build.HARDWARE;
        r16[7] = "BL=" + Build.BOOTLOADER;
        r16[8] = "FP=" + Build.FINGERPRINT;
        r16[9] = "OS=" + Build.VERSION.SDK_INT;
        StringBuilder r6 = new StringBuilder("RV=");
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L43
        String r17 = Build.getRadioVersion();     // Catch: Throwable -> L43
        if (r17 != null) goto L41;
        r17 = "";
    L41:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L43
    L46:
        if (Result.isFailure-impl(r18) == true) goto L49;
        r15 = r18;
    L49:
        r6.append((String) r15);
        r16[10] = r6.toString();
        String r19 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r16), "|", null, null, 0, null, null, 62, null);
        thb.a.b("InitFlowReportSameDeviceJudgeTask", "build hash raw length=" + r19.length());
        String r20 = Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(r19.getBytes(Charsets.UTF_8)), 11);
        thb.a.b("InitFlowReportSameDeviceJudgeTask", "fingerprint source=BUILD_HASH, length=" + r20.length());
        thb.a.b("InitFlowReportSameDeviceJudgeTask", "execute data, uid: " + r4 + ", did: " + r10 + ", device_fingerprint: " + r20 + ", detectPeerApp: " + r2.name() + ", report_time_ms: " + r7);
        r9 = new SameDeviceJudgeItem.Builder().app_id(AppId.APP_ID_DOUBAO).uid(r11).did(r13).device_fingerprint(r20).peer_app_id(r2).report_time_ms(Long.valueOf(r7)).build();
    L51:
        if (r9 != null) goto L53;
        return;
    L53:
        PutSameDeviceJudgeInfoRequest.Builder r21 = new PutSameDeviceJudgeInfoRequest.Builder().item(r9);
        Command r22 = Command.PUT_SAME_DEVICE_JUDGE_INFO;
        IGetDataCallback<PutSameDeviceJudgeInfoResponse> r23 = new InitFlowReportSameDeviceJudgeTask$reportIfNeeded$1(this, r7);
        final ProtoAdapter r25 = PutSameDeviceJudgeInfoResponse.ADAPTER;
        SdkSender.sendPassThroughRequest(r22, r21, r23, new b(r25));
        return;
    L43:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L50:
        thb.a.b("InitFlowReportSameDeviceJudgeTask", "uid or did invalid");
        goto L51
    L33:
        r13 = null;
        goto L34
    L30:
        r11 = null;
        goto L31
    L27:
        r10 = null;
        goto L28
    L12:
        r1 = false;
        goto L13
    L5:
        if (j(r24, "com.larksuite.suite") == true) goto L8;
        r0 = AppId.APP_ID_NONE;
        goto L9
    }

    public static boolean j(Context r4, String r5) {
        r4.getPackageManager().getPackageInfo(r5, 0);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L8
        return true;
    L5:
        th = move-exception;
        String r6 = "check package " + r5 + " failed";
        int r1 = thb.a.a;
        Intrinsics.checkNotNullParameter("InitFlowReportSameDeviceJudgeTask", "tag");
        Intrinsics.checkNotNullParameter(r6, "msg");
        Log.w("InitFlowReportSameDeviceJudgeTask", "[FlowNotificationLog] " + r6, th);
        return false;
    L12:
        return false;
    }
}
