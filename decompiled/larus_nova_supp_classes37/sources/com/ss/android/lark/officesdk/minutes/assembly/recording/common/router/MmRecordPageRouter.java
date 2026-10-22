package com.ss.android.lark.officesdk.minutes.assembly.recording.common.router;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmAppletPage;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingEntity;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingPageOpenSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.b;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordPageRouter {
    public final a a;
    public final Lazy b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/assembly/recording/common/router/MmRecordPageRouter$RecordingPageRouteResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "RECORDING_NOT_FOUND", "SESSION_NOT_ACTIVE", "UNSUPPORTED_UI", "NAVIGATOR_ROUTE_FAILED", "ROUTE_FAILED", "isSuccess", "", "officesdk-minutes-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum RecordingPageRouteResult extends Enum<RecordingPageRouteResult> {
        public static final RecordingPageRouteResult NAVIGATOR_ROUTE_FAILED = null;
        public static final RecordingPageRouteResult RECORDING_NOT_FOUND = null;
        public static final RecordingPageRouteResult ROUTE_FAILED = null;
        public static final RecordingPageRouteResult SESSION_NOT_ACTIVE = null;
        public static final RecordingPageRouteResult SUCCESS = null;
        public static final RecordingPageRouteResult UNSUPPORTED_UI = null;
        public static final /* synthetic */ RecordingPageRouteResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RecordingPageRouteResult> getEntries() {
            return b;
        }

        static {
            RecordingPageRouteResult r0 = new RecordingPageRouteResult("SUCCESS", 0);
            SUCCESS = r0;
            RecordingPageRouteResult r1 = new RecordingPageRouteResult("RECORDING_NOT_FOUND", 1);
            RECORDING_NOT_FOUND = r1;
            RecordingPageRouteResult r3 = new RecordingPageRouteResult("SESSION_NOT_ACTIVE", 2);
            SESSION_NOT_ACTIVE = r3;
            RecordingPageRouteResult r5 = new RecordingPageRouteResult("UNSUPPORTED_UI", 3);
            UNSUPPORTED_UI = r5;
            RecordingPageRouteResult r7 = new RecordingPageRouteResult("NAVIGATOR_ROUTE_FAILED", 4);
            NAVIGATOR_ROUTE_FAILED = r7;
            RecordingPageRouteResult r9 = new RecordingPageRouteResult("ROUTE_FAILED", 5);
            ROUTE_FAILED = r9;
            RecordingPageRouteResult[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static RecordingPageRouteResult[] values() {
            return (RecordingPageRouteResult[]) a.clone();
        }

        public final boolean isSuccess() {
            if (this != SUCCESS) goto L5;
            return true;
        L5:
            return false;
        }

        public static RecordingPageRouteResult valueOf(String r1) {
            return (RecordingPageRouteResult) r27.a.a(RecordingPageRouteResult.class, r1);
        }

        public RecordingPageRouteResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public MmRecordPageRouter(a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentApi");
        this.a = r2;
        this.b = LazyKt.lazy(new MmRecordPageRouter$recordingSessionManage$2(this));
    }

    public final RecordingPageRouteResult a(Context r22, String r23, MmRecordingPageOpenSource r24, MmRecordingUILaunchMode r25) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "recordingId");
        Intrinsics.checkNotNullParameter(r24, "openSource");
        Intrinsics.checkNotNullParameter(r25, "uiLaunchMode");
        MmRecordingSessionManager r2 = (MmRecordingSessionManager) this.b.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r23, "sessionId");
        MmRecordingSession r3 = r2.m(r23);
        if (r3 != null) goto L7;
        lvb.a.h("MmRecordPageRouter", "[routeToRecordingPage] session not found, recordingId=".concat(r23));
        return RecordingPageRouteResult.RECORDING_NOT_FOUND;
    L7:
        if (r3.g().a() == true) goto L11;
        lvb.a.h("MmRecordPageRouter", "[routeToRecordingPage] session not active, recordingId=" + r23 + ", state=" + r3.g());
        return RecordingPageRouteResult.SESSION_NOT_ACTIVE;
    L11:
        if (r25.shouldHandleUI() == true) goto L14;
        lvb.a.b("MmRecordPageRouter", "[routeToRecordingPage] skip route, uiLaunchMode=" + r25 + ", recordingId=" + r23);
        return RecordingPageRouteResult.UNSUPPORTED_UI;
    L14:
        k r4 = r3.f;
        uub.a r16 = null;
        if (r4 == null) goto L17;
        DoubaoStatisticInfo r9 = r4.a();
    L18:
        k r5 = r3.f;
        if (r5 == null) goto L21;
        MmRecordingSource r17 = r5.a;
    L22:
        MmRecordingEntity r10 = new MmRecordingEntity(r23, r24, r25, null, null, null, r9, r17, 56, null);
        if (r10.getUiLaunchMode().supportAppletNavigator() == false) goto L26;
        r16 = (uub.a) this.a.u(uub.a.class);
    L26:
        uub.a r6 = r16;
        StringBuilder r7 = new StringBuilder("[routeToRecordingPage] uiLaunchMode=");
        r7.append(r25);
        r7.append(", hasNavigator=");
        if (r6 == null) goto L29;
        boolean r8 = true;
    L30:
        r7.append(r8);
        r7.append(", recordingId=");
        r7.append(r23);
        lvb.a.e("MmRecordPageRouter", r7.toString());
        if (r6 != null) goto L37;
        bwb.a r11 = bwb.a.a;
        UserSession r12 = this.a.D();
        r11.getClass();
        if (bwb.a.a(r22, r10, r12) == false) goto L36;
        return RecordingPageRouteResult.SUCCESS;
    L36:
        return RecordingPageRouteResult.ROUTE_FAILED;
    L37:
        int r13 = b.c;
        String r14 = r10.getRecordingId();
        Intrinsics.checkNotNullParameter(r14, "recordingId");
        MmAppletPage.a r15 = MmAppletPage.Companion;
        MmAppletPage r18 = MmAppletPage.RECORDING;
        r15.getClass();
        r6.o0(r22, new b(MmAppletPage.a.a(r18, r14), r10), this.a.D());
        return RecordingPageRouteResult.SUCCESS;
    L29:
        r8 = false;
        goto L30
    L21:
        r17 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    }
}
