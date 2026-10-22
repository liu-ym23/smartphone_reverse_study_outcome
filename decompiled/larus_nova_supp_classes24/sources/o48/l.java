package o48;

import com.larus.common_ui.dialog.p0;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l implements p0 {
    public final /* synthetic */ Function1<Boolean, Unit> a;
    public final /* synthetic */ JSONObject b;

    public final void confirm() {
        this.a.invoke(Boolean.TRUE);
        o r0 = o.a;
        JSONObject r1 = this.b;
        r1.put("click_type", "authorize");
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("sdk_video_notice_click", r1);
    }

    public l(f r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
