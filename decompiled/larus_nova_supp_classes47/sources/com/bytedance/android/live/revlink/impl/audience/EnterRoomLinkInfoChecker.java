package com.bytedance.android.live.revlink.impl.audience;

import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class EnterRoomLinkInfoChecker {
    public final ld.a a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/audience/EnterRoomLinkInfoChecker$Error;", "", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "", Constants.OperatorKey.MSG, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "LINKER_MAP_CONTAINS_1_AND_7", "LINKER_MAP_PK_BUT_LINK_MIC_NULL", "LINKER_MAP_PK_BUT_PLAY_MODE_MULTI_PK", "LINKER_MAP_MULTI_BUT_LINK_MIC_NONNULL", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error LINKER_MAP_CONTAINS_1_AND_7 = null;
        public static final Error LINKER_MAP_MULTI_BUT_LINK_MIC_NONNULL = null;
        public static final Error LINKER_MAP_PK_BUT_LINK_MIC_NULL = null;
        public static final Error LINKER_MAP_PK_BUT_PLAY_MODE_MULTI_PK = null;
        public static final /* synthetic */ Error[] a = null;
        private final int code;
        private final String msg;

        static {
            Error r1 = new Error("LINKER_MAP_CONTAINS_1_AND_7", 0, 10001, "linker_map contains 1 and 7");
            LINKER_MAP_CONTAINS_1_AND_7 = r1;
            Error r2 = new Error("LINKER_MAP_PK_BUT_LINK_MIC_NULL", 1, 10002, "linker_map pk but link_mic null");
            LINKER_MAP_PK_BUT_LINK_MIC_NULL = r2;
            Error r3 = new Error("LINKER_MAP_PK_BUT_PLAY_MODE_MULTI_PK", 2, 10003, "linker_map pk but play_mode=multi_pk");
            LINKER_MAP_PK_BUT_PLAY_MODE_MULTI_PK = r3;
            Error r4 = new Error("LINKER_MAP_MULTI_BUT_LINK_MIC_NONNULL", 3, 10004, "linker_map multi but link_mic nonnull");
            LINKER_MAP_MULTI_BUT_LINK_MIC_NONNULL = r4;
            a = new Error[]{r1, r2, r3, r4};
        }

        public static Error valueOf(String r1) {
            return (Error) r27.a.a(Error.class, r1);
        }

        public static Error[] values() {
            return (Error[]) a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public Error(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.code = r3;
            this.msg = r4;
        }
    }

    public final void a(Error r13) {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        d31.f r1 = null;
        if (r0 == null) goto L5;
        LiveFullLinkPKMonitor r2 = r0.getLiveFullLinkPKMonitor();
    L6:
        if (r2 == null) goto L21;
        int r9 = r13.getCode();
        String r14 = r13.getMsg();
        ld.a r3 = this.a;
        if (r3 == null) goto L13;
        NextLiveData r4 = r3.h4();
        if (r4 == null) goto L13;
        String r5 = (String) r4.getValue();
        if (r5 == null) goto L13;
    L14:
        Intrinsics.checkNotNullParameter(r14, Constants.Keys.ERROR);
        Intrinsics.checkNotNullParameter(r5, "firstSei");
        JSONObject r6 = new JSONObject();
        int r7 = y50.b.a;
        y50.b.a.d(r6, "business_api_name", "unexpected_enter_room_link_info");
        y50.b.a.d(r6, "sei", r5);
        LiveFullLinkPKMonitor.u(r2, "unexpected_enter_room_link_info", r6, r9, r14, null, 16);
        com.bytedance.android.live.revlink.impl.global.c r8 = r2.o;
        if (r8 == null) goto L17;
        r1 = r8.y2();
    L17:
        d31.f r10 = r1;
        if (r10 == null) goto L22;
        d31.f.f(r10, "unexpected_enter_room_link_info", r9, r14, 0, 0, null, null, null, 248);
        return;
    L22:
        return;
    L13:
        r5 = "";
        goto L14
    L21:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public EnterRoomLinkInfoChecker(ld.a r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
