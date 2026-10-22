package com.bytedance.android.live.lynx.monitor;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitorV2.g;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LynxMonitor {
    public static final boolean a = false;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/lynx/monitor/LynxMonitor$FallbackType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "INIT_FAILED", "LOAD_FAILED", "MISS_GECKO", "UNKNOWN", "PLUGIN_NOT_INSTALLED", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FallbackType extends Enum<FallbackType> {
        public static final FallbackType INIT_FAILED = null;
        public static final FallbackType LOAD_FAILED = null;
        public static final FallbackType MISS_GECKO = null;
        public static final FallbackType PLUGIN_NOT_INSTALLED = null;
        public static final FallbackType UNKNOWN = null;
        public static final /* synthetic */ FallbackType[] a = null;
        private final String type;

        static {
            FallbackType r1 = new FallbackType("INIT_FAILED", 0, "LynxInitFailed");
            INIT_FAILED = r1;
            FallbackType r2 = new FallbackType("LOAD_FAILED", 1, "OnLoadFailed");
            LOAD_FAILED = r2;
            FallbackType r3 = new FallbackType("MISS_GECKO", 2, "MissGecko");
            MISS_GECKO = r3;
            FallbackType r4 = new FallbackType("UNKNOWN", 3, "UNKNOWN");
            UNKNOWN = r4;
            FallbackType r5 = new FallbackType("PLUGIN_NOT_INSTALLED", 4, "PLUGIN_NOT_INSTALLED");
            PLUGIN_NOT_INSTALLED = r5;
            a = new FallbackType[]{r1, r2, r3, r4, r5};
        }

        public static FallbackType valueOf(String r1) {
            return (FallbackType) a.a(FallbackType.class, r1);
        }

        public static FallbackType[] values() {
            return (FallbackType[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public FallbackType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/lynx/monitor/LynxMonitor$ReactRuntimeStatus;", "", "NOT_FOUND", "OFFLINE", "CDN", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ReactRuntimeStatus extends Enum<ReactRuntimeStatus> {
        public static final ReactRuntimeStatus CDN = null;
        public static final ReactRuntimeStatus NOT_FOUND = null;
        public static final ReactRuntimeStatus OFFLINE = null;
        public static final /* synthetic */ ReactRuntimeStatus[] a = null;

        static {
            ReactRuntimeStatus r1 = new ReactRuntimeStatus("NOT_FOUND", 0);
            NOT_FOUND = r1;
            ReactRuntimeStatus r2 = new ReactRuntimeStatus("OFFLINE", 1);
            OFFLINE = r2;
            ReactRuntimeStatus r3 = new ReactRuntimeStatus("CDN", 2);
            CDN = r3;
            a = new ReactRuntimeStatus[]{r1, r2, r3};
        }

        public static ReactRuntimeStatus valueOf(String r1) {
            return (ReactRuntimeStatus) a.a(ReactRuntimeStatus.class, r1);
        }

        public static ReactRuntimeStatus[] values() {
            return (ReactRuntimeStatus[]) a.clone();
        }

        public ReactRuntimeStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/lynx/monitor/LynxMonitor$VerifyTemplateType;", "", "", "TYPE", "Ljava/lang/String;", "getTYPE", "()Ljava/lang/String;", "EMPTY_FILE", "BROKEN_FILE", "VERIFY_SUCCEED", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum VerifyTemplateType extends Enum<VerifyTemplateType> {
        public static final VerifyTemplateType BROKEN_FILE = null;
        public static final VerifyTemplateType EMPTY_FILE = null;
        public static final VerifyTemplateType VERIFY_SUCCEED = null;
        public static final /* synthetic */ VerifyTemplateType[] a = null;
        private final String TYPE;

        static {
            VerifyTemplateType r1 = new VerifyTemplateType("EMPTY_FILE", 0, "Empty file");
            EMPTY_FILE = r1;
            VerifyTemplateType r2 = new VerifyTemplateType("BROKEN_FILE", 1, "Broken file");
            BROKEN_FILE = r2;
            VerifyTemplateType r3 = new VerifyTemplateType("VERIFY_SUCCEED", 2, "Verify succeed");
            VERIFY_SUCCEED = r3;
            a = new VerifyTemplateType[]{r1, r2, r3};
        }

        public static VerifyTemplateType valueOf(String r1) {
            return (VerifyTemplateType) a.a(VerifyTemplateType.class, r1);
        }

        public static VerifyTemplateType[] values() {
            return (VerifyTemplateType[]) a.clone();
        }

        public final String getTYPE() {
            return this.TYPE;
        }

        public VerifyTemplateType(String r1, int r2, String r3) {
            super(r1, r2);
            this.TYPE = r3;
        }
    }

    public LynxMonitor() {
    }

    static {
        a = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
    }

    public static /* synthetic */ void d(FallbackType r2, String r3) {
        c(r2, "", r3, 0);
    }

    public static void a(FallbackType r11, String r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r13, "path");
        c(r11, r12, r13, r14);
        JSONObject r8 = new JSONObject();
        r8.put("path", r13);
        JSONObject r6 = new JSONObject();
        r6.put("err_msg", r12);
        r6.put("code", r14);
        r6.put("type", r11.getType());
        JSONObject r9 = new JSONObject();
        r9.put("virtual_aid", "88888");
        if (a == false) goto L5;
        g.e().getClass();
        g.b(r13, "lynx_fallback", r6, null, r8, r9, 0);
        return;
    L5:
        HybridMonitor.getInstance().customReport(r13, "", "lynx_fallback", r6, null, r8, r9, false);
    }

    public static void c(FallbackType r6, String r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r8, "path");
        LocalTestManager.a(new Class[]{wy.a.class});
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_fallback", 1, MapsKt.mapOf(new Pair[]{TuplesKt.to("type", r6.getType()), TuplesKt.to("error_message", r7), TuplesKt.to("error_code", Integer.valueOf(r9)), TuplesKt.to("path", r8)}));
    }

    public static /* synthetic */ void b(FallbackType r2, String r3, String r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "";
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        a(r2, r3, r4, r5);
    }
}
