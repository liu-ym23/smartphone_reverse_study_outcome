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
@XBridgeMethod(name = "dora.diary.feedback")
public final class p extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.diary.feedback")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "action_type", required = true)
        Number getActionType();

        @XBridgeParamField(isGetter = true, keyPath = "diary_id", required = true)
        String getDiaryId();

        @XBridgeParamField(isGetter = true, keyPath = "diary_version", required = BuildConfig.DEBUG)
        Number getDiaryVersion();

        @XBridgeParamField(isGetter = true, keyPath = "snapshot_json", required = BuildConfig.DEBUG)
        String getSnapshotJson();

        @XBridgeParamField(isGetter = true, keyPath = "target_id", required = BuildConfig.DEBUG)
        String getTargetId();

        @XBridgeParamField(isGetter = true, keyPath = "target_type", required = BuildConfig.DEBUG)
        Number getTargetType();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public p() {
        this.a = "dora.diary.feedback";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r8, XBaseParamModel r9, CompletionBlock r10) {
        b r11 = (b) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        String r12 = r11.getDiaryId();
        Number r0 = r11.getActionType();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        int r2 = 0;
        if (r12 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L48;
        if (r1 >= 0) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L48;
        Intent r5 = new Intent("com.larus.dora.diary.FEEDBACK");
        r5.putExtra("diary_id", r12);
        r5.putExtra("feedback_action", r1);
        Number r6 = r11.getTargetType();
        if (r6 == null) goto L32;
        Integer r7 = Integer.valueOf(r6.intValue());
        if (r7.intValue() <= 0) goto L26;
        boolean r13 = true;
    L27:
        if (r13 == true) goto L30;
        r7 = null;
    L30:
        if (r7 == null) goto L32;
        int r14 = r7.intValue();
    L33:
        r5.putExtra("feedback_target_type", r14);
        String r15 = r11.getTargetId();
        if (r15 != null) goto L36;
    L40:
        r15 = r12;
    L41:
        r5.putExtra("feedback_target_id", r15);
        String r16 = r11.getSnapshotJson();
        if (r16 != null) goto L44;
        r16 = "";
    L44:
        r5.putExtra("feedback_snapshot_json", r16);
        Number r17 = r11.getDiaryVersion();
        if (r17 == null) goto L47;
        r2 = r17.intValue();
    L47:
        r5.putExtra("feedback_diary_version", r2);
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r5);
        FLogger.a.i("DoraDiaryFeedbackMethod", "dora.diary.feedback diary=" + r12 + " action=" + r1);
        CompletionBlock.DefaultImpls.onSuccess$default(r10, ne7.e.b(c.class), null, 2, null);
        return;
    L36:
        if ((true ^ StringsKt.isBlank(r15)) == true) goto L39;
        r15 = null;
    L39:
        if (r15 != null) goto L41;
    L26:
        r13 = false;
    L32:
        r14 = 1;
        goto L33
    L16:
        if (r1 >= 3) goto L18;
        r4 = true;
    L48:
        r10.onFailure(-3, "diary_id required, action_type must be 0(cancel)/1(like)/2(dislike)", ne7.e.b(c.class));
        return;
    L9:
        if (StringsKt.isBlank(r12) == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = -1;
        goto L6
    }
}
