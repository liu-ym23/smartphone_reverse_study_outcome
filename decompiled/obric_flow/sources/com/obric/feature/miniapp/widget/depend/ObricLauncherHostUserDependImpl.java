package com.obric.feature.miniapp.widget.depend;

import android.app.Activity;
import com.bytedance.ai.bridge.service.IHostUserDepend$ILoginStatusCallback;
import com.bytedance.ai.bridge.service.IHostUserDepend$ILogoutStatusCallback;
import com.bytedance.ai.bridge.service.IHostUserDepend$LoginParamsExt;
import com.bytedance.ai.bridge.service.IHostUserDepend$UserModelExt;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u0018\u0010\u001cJ5\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001d2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/obric/feature/miniapp/widget/depend/ObricLauncherHostUserDependImpl;", "<init>", "()V", "", "getAvatarURL", "()Ljava/lang/String;", "getBoundPhone", "getNickname", "getSecUid", "getUniqueID", "getUserId", "Lcom/bytedance/ai/bridge/service/IHostUserDepend$UserModelExt;", "getUserModelExt", "()Lcom/bytedance/ai/bridge/service/IHostUserDepend$UserModelExt;", "", "hasLogin", "()Z", "Landroid/app/Activity;", "activity", "Lcom/bytedance/ai/bridge/service/IHostUserDepend$ILoginStatusCallback;", "loginStatusCallback", "", "extraData", "", "login", "(Landroid/app/Activity;Lcom/bytedance/ai/bridge/service/IHostUserDepend$ILoginStatusCallback;Ljava/util/Map;)V", "Lcom/bytedance/ai/bridge/service/IHostUserDepend$LoginParamsExt;", LynxResourceModule.PARAMS_KEY, "(Landroid/app/Activity;Lcom/bytedance/ai/bridge/service/IHostUserDepend$ILoginStatusCallback;Ljava/util/Map;Lcom/bytedance/ai/bridge/service/IHostUserDepend$LoginParamsExt;)V", "Lcom/bytedance/ai/bridge/service/IHostUserDepend$ILogoutStatusCallback;", "logoutStatusCallback", "logout", "(Landroid/app/Activity;Lcom/bytedance/ai/bridge/service/IHostUserDepend$ILogoutStatusCallback;Ljava/util/Map;)V", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricLauncherHostUserDependImpl {
    public ObricLauncherHostUserDependImpl() {
    }

    public String getAvatarURL() {
        return null;
    }

    public String getBoundPhone() {
        return null;
    }

    public String getNickname() {
        return "";
    }

    public String getSecUid() {
        return "";
    }

    public String getUniqueID() {
        return "";
    }

    public String getUserId() {
        return "";
    }

    public IHostUserDepend$UserModelExt getUserModelExt() {
        return null;
    }

    public boolean hasLogin() {
        return false;
    }

    public void login(Activity r5, IHostUserDepend$ILoginStatusCallback r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "loginStatusCallback");
    }

    public void logout(Activity r5, IHostUserDepend$ILogoutStatusCallback r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "logoutStatusCallback");
    }

    public void login(Activity r5, IHostUserDepend$ILoginStatusCallback r10, Map<String, String> r11, IHostUserDepend$LoginParamsExt r12) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "loginStatusCallback");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
    }
}
