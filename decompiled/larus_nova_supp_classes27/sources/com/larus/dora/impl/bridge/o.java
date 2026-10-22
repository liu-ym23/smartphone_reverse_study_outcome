package com.larus.dora.impl.bridge;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.common.apphost.AppHost;
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.diary.onDateChanged")
public final class o extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.diary.onDateChanged")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "date", required = true)
        String getDate();

        @XBridgeParamField(isGetter = true, keyPath = "diary_id", required = BuildConfig.DEBUG)
        String getDiaryId();

        @XBridgeParamField(isGetter = true, keyPath = "earliest_date", required = BuildConfig.DEBUG)
        String getEarliestDate();

        @XBridgeParamField(isGetter = true, keyPath = "entry", required = BuildConfig.DEBUG)
        String getEntry();

        @XBridgeParamField(isGetter = true, keyPath = "last_update_time", required = BuildConfig.DEBUG)
        String getLastUpdateTime();

        @XBridgeParamField(isGetter = true, keyPath = "recorded_diary_days", required = BuildConfig.DEBUG)
        Number getRecordedDiaryDays();

        @XBridgeParamField(isGetter = true, keyPath = "source", required = BuildConfig.DEBUG)
        String getSource();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public o() {
        this.a = "dora.diary.onDateChanged";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r6, XBaseParamModel r7, CompletionBlock r8) {
        b r9 = (b) r7;
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        String r10 = r9.getDate();
        int r0 = 0;
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        r8.onFailure(-3, "date is required", ne7.e.b(c.class));
        return;
    L11:
        Intent r2 = new Intent("com.larus.dora.diary.DATE_CHANGED");
        r2.putExtra("date", r10);
        String r3 = r9.getDiaryId();
        String r4 = "";
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        r2.putExtra("diary_id", r3);
        String r5 = r9.getLastUpdateTime();
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r2.putExtra("last_update_time", r5);
        String r11 = r9.getSource();
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r2.putExtra("report_source", r11);
        String r12 = r9.getEntry();
        if (r12 != null) goto L23;
        r12 = "";
    L23:
        r2.putExtra("report_entry", r12);
        String r13 = r9.getEarliestDate();
        if (r13 == null) goto L27;
        r4 = r13;
    L27:
        r2.putExtra("earliest_date", r4);
        Number r14 = r9.getRecordedDiaryDays();
        if (r14 == null) goto L30;
        r0 = r14.intValue();
    L30:
        r2.putExtra("recorded_diary_days", r0);
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r2);
        FLogger.a.i("DoraDiaryDateChangedMethod", "dora.diary.onDateChanged date=" + r10);
        CompletionBlock.DefaultImpls.onSuccess$default(r8, ne7.e.b(c.class), null, 2, null);
        return;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r1 = false;
        goto L9
    }
}
