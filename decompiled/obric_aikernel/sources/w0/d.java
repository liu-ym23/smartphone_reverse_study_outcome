package w0;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    void a(g1.b r10, Env r11, Looper r12, com.bytedance.applog.d r13);

    String addNetCommonParams(Context r10, StringBuilder r11, boolean r12, Level r13);

    void b();

    void c(Application r10, String r11);

    void clearAndSetEnv(Env r10);

    void clearInstallInfoWhenSwitchChildMode(Env r10);

    void d(b.g r10);

    boolean getCurrentHeader(JSONObject r10);

    String getDid();

    InstallInfo getInstallInfo();

    @Nullable
    InstallOptions getInstallOptions();

    void putCommonParams(Context r10, Map<String, String> r11, boolean r12, Level r13);

    void resetAndReInstall(Context r10, Env r11, long r12, OnResetListener r13);

    void resetInstallInfoWhenSwitchChildMode(Context r10, Env r11, long r12, OnResetListener r13);

    void start();
}
