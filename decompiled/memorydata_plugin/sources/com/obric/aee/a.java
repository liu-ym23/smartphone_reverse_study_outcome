package com.obric.aee;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.sdk.ext.Params;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fH&J \u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH&¨\u0006\u0015"}, d2 = {"Lcom/obric/aee/EngineCallback;", "", "enableDebug", "", "getContext", "Landroid/content/Context;", "getRootDir", "Ljava/io/File;", "onEvent", "", "event", "", "args", "Landroid/os/Bundle;", "onGetGlobalConfig", "", "onLog", "priority", "", LocationMonitorConst.TAG, Params.CONTENT, "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface a {
    File a();

    void a(int r1, String r2, String r3);

    void a(String r1, Bundle r2);

    boolean b();

    Map<String, String> c();

    Context getContext();
}
