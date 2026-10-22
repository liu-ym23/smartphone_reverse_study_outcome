package opb;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import idb.f;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements yva.a {
    public final /* synthetic */ IGetDataCallback a;
    public final /* synthetic */ e b;

    public d(e r1) {
        this.b = r1;
        this.a = null;
    }

    public final void onError(ErrorResult r3) {
        Log.w("AppSettingService", "pullAppSettings onError:" + r3);
        IGetDataCallback r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError(r3);
        return;
    }

    public final void a(Map<String, String> r9, boolean r10) {
        Iterator<AbstractBaseSettingHandler> r0 = this.b.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().i(r9, r10, true, false, "");
        goto L4
    L6:
        e r1 = this.b;
        b r2 = r1.d;
        Map<String, jpb.a> r3 = r1.b();
        ((LarkSettingModuleDependency.a) this.b.e).getClass();
        r2.a(r9, r3, true, r10, f.a().isEnable("common_settings_opt_close"));
        IGetDataCallback r11 = this.a;
        if (r11 == null) goto L11;
        r11.onSuccess(Boolean.valueOf(r10));
        return;
    }
}
