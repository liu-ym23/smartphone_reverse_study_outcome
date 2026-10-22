package com.bytedance.common.wschannel.app;

import android.os.Parcelable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IWsApp extends Parcelable {
    int getAppId();

    String getDeviceId();

    String getExtra();

    String j();

    int k();

    JSONObject l();

    int m();

    String n();

    int o();

    int q();

    List<String> s();
}
