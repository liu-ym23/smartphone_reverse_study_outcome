package com.ss.android.lark.gadget.configuration.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "miniapp_process_delete")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/gadget/configuration/settings/MiniAppProcessDeleteSettings;", "", "<init>", "()V", "enable", "", "invokeIPCDirectly", "invokePreloadDirectly", "invokeHostActionDirectly", "appbrand_base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MiniAppProcessDeleteSettings {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("invokeHostActionDirectly")
    public boolean invokeHostActionDirectly;

    @SerializedName("invokeIPCDirectly")
    public boolean invokeIPCDirectly;

    @SerializedName("invokePreloadDirectly")
    public boolean invokePreloadDirectly;

    public MiniAppProcessDeleteSettings() {
    }
}
