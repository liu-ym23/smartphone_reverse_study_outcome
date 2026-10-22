package com.bytedance.env.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0014\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b%\u0010\nJ\u000f\u0010&\u001a\u00020\u0004H&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020(H&¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020(H&¢\u0006\u0004\b,\u0010-J\u0019\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H&¢\u0006\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/bytedance/env/api/EnvManagerApi;", "", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "", "enable", "setEnvWindowEnable", "(Z)V", "visible", "setFloatingWindowVisible", "isFloatingWindowVisible", "()Z", "setFloatingWindowRemovable", "Lcom/bytedance/env/api/b;", "config", "initEnvConfig", "(Lcom/bytedance/env/api/b;)V", "setEnvConfig", "", "envType", "", "lane", "(ILjava/lang/String;)V", "getEnvConfig", "()Lcom/bytedance/env/api/b;", "getEnvType", "()I", "getEnvLane", "()Ljava/lang/String;", "Lcom/bytedance/env/api/f;", "listener", "addOnEnvConfigChangeListener", "(Lcom/bytedance/env/api/f;)V", "removeOnEnvConfigChangeListener", "setAutoRebootEnable", "reboot", "()V", "Lcom/bytedance/env/api/e;", "initGeckoConfig", "(Lcom/bytedance/env/api/e;)V", "setGeckoConfig", "getGeckoConfig", "()Lcom/bytedance/env/api/e;", "Landroid/app/Activity;", "activity", "openDialog", "(Landroid/app/Activity;)V", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public interface EnvManagerApi {
    void addOnEnvConfigChangeListener(f r5);

    b getEnvConfig();

    String getEnvLane();

    int getEnvType();

    e getGeckoConfig();

    void init(Context r5);

    void initEnvConfig(b r5);

    void initGeckoConfig(e r5);

    boolean isFloatingWindowVisible();

    void openDialog(Activity r5);

    void reboot();

    void removeOnEnvConfigChangeListener(f r5);

    void setAutoRebootEnable(boolean r5);

    void setEnvConfig(int r5, String r10);

    void setEnvConfig(b r5);

    void setEnvWindowEnable(boolean r5);

    void setFloatingWindowRemovable(boolean r5);

    void setFloatingWindowVisible(boolean r5);

    void setGeckoConfig(e r5);
}
