package j18;

import android.content.Context;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface b extends h {
    void c();

    void d(i18.d r1);

    i18.c getBridgeContext();

    Context getContext();

    void getParent();

    LKBasePluginResult sendEvent(LKEvent r1);
}
