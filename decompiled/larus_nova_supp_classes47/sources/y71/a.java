package y71;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public IBaseUser a;
    public IRoom b;
    public String c;
    public String d;
    public String e;
    public u f;
    public ReportObject g;
    public Map<String, String> h;
    public final ReportConstant$BusinessSource i;

    public a(ReportConstant$BusinessSource r2) {
        Intrinsics.checkNotNullParameter(r2, "businessSource");
        this.i = r2;
    }

    public final void a(String r4) {
        if (r4 == null) goto L15;
        this.g = ReportObject.valueOf(r4);     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        if (v.a() == true) goto L12;
        ALogger.e(a.class.getName(), e.getMessage());
        return;
    L12:
        throw new RuntimeException("无法从当前reportObject字符串: " + r4 + " 构造出ReportObject对象，请直接使用ReportObject.name生成string");
    }
}
