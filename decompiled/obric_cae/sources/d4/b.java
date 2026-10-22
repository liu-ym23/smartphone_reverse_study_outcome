package d4;

import android.content.SharedPreferences;
import c4.e;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f6755a;

    public b(c r8) {
        this.f6755a = r8;
    }

    @Override // c4.e.b
    public final JSONObject a() {
        c r13 = this.f6755a;
        long r8 = r13.f6761e.getLong("app_log_last_config_time", 0);
        SharedPreferences r10 = r13.f6761e;
        if (r8 > 0) goto L6;
        return null;
    L6:
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        r11.put("appId", r13.f6768l.f11401i);     // Catch: Throwable -> L38
        long r14 = r10.getLong("session_interval", 0);     // Catch: Throwable -> L38
        String r15 = "--";
        if (r14 <= 0) goto L11;
        String r16 = r14 + "ms";     // Catch: Throwable -> L38
    L12:
        r12.put("后台会话时长", r16);     // Catch: Throwable -> L38
        long r17 = r10.getLong("batch_event_interval", 0);     // Catch: Throwable -> L38
        if (r17 <= 0) goto L15;
        String r18 = r17 + "ms";     // Catch: Throwable -> L38
    L16:
        r12.put("事件上报周期", r18);     // Catch: Throwable -> L38
        long r19 = r10.getLong("abtest_fetch_interval", 0);     // Catch: Throwable -> L38
        if (r19 <= 0) goto L19;
        String r20 = r19 + "ms";     // Catch: Throwable -> L38
    L20:
        r12.put("AB实验更新周期", r20);     // Catch: Throwable -> L38
        r12.put("全埋点", r10.getBoolean("bav_log_collect", false));     // Catch: Throwable -> L38
        r12.put("AB实验", r10.getBoolean("bav_ab_config", false));     // Catch: Throwable -> L38
        r12.put("实时埋点事件", r10.getString("real_time_events", "[]"));     // Catch: Throwable -> L38
        r12.put("禁止采集手机详情", r10.getBoolean("forbid_report_phone_detail_info", false));     // Catch: Throwable -> L38
        long r110 = r10.getLong("fetch_interval", 0);     // Catch: Throwable -> L38
        if (r110 <= 0) goto L23;
        r15 = r110 + "ms";     // Catch: Throwable -> L38
    L23:
        r12.put("服务端配置更新周期", r15);     // Catch: Throwable -> L38
        int r21 = r10.getInt("content_encode_method", 0);     // Catch: Throwable -> L38
        boolean r22 = true;
        if (r21 == 0) goto L31;
        if (r21 != 1) goto L27;
        String r23 = "ZSTD";
    L32:
        r12.put("日志压缩方式", r23);     // Catch: Throwable -> L38
        r12.put("LogBack配置", r10.getString("log_back", ""));     // Catch: Throwable -> L38
        if (r10.getLong("max_pack_size", 0) > 0) goto L36;
        r22 = false;
    L36:
        r12.put("包大小限制", r22);     // Catch: Throwable -> L38
        r12.put("包最大体积", r10.getLong("max_pack_size", 0));     // Catch: Throwable -> L38
        r12.put("忽略分级", r10.getBoolean("ignore_event_priority", false));     // Catch: Throwable -> L38
        r11.put("config", r12);     // Catch: Throwable -> L38
        goto L37
    L27:
        if (r21 == 2) goto L29;
        r23 = BdimCategoryConstants.VALUE_UNKNOWN;
        goto L32
    L29:
        r23 = "ZSTD+DICT";
        goto L32
    L31:
        r23 = "GZIP";
        goto L32
    L19:
        r20 = "--";
        goto L20
    L15:
        r18 = "--";
        goto L16
    L11:
        r16 = "--";
    L37:
        return r11;
    }
}
