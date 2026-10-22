package com.bytedance.applog;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.bdinstall.Level;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface g {
    void a(@NonNull String r10, @Nullable JSONObject r11);

    String addNetCommonParams(Context r10, String r11, boolean r12, Level r13);

    void b(String r10, int r11);

    void c(boolean r10);

    void d(@NonNull Context r10, @NonNull n r11);

    String e();

    void f(Context r10);

    void flush();

    void g(h r10);

    String getAppId();

    String getDid();

    String getIid();

    String getSessionId();

    void putCommonParams(Context r10, Map<String, String> r11, boolean r12, Level r13);
}
