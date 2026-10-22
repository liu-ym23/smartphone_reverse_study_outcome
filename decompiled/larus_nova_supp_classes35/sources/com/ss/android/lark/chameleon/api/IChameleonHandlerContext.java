package com.ss.android.lark.chameleon.api;

import android.content.Context;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginsystem.WebFragment;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J'\u0010\u0011\u001a\u00020\u0012\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u0002H\u0013H&¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", BuildConfig.FLAVOR, "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "fragment", "Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "getFragment", "()Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "webviewLoader", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "getBizName", BuildConfig.FLAVOR, "getSession", "sendEvent", BuildConfig.FLAVOR, "T", "Ljava/io/Serializable;", IPortraitService.TYPE, Keys.API_RETURN_KEY_DATA, "(Ljava/lang/String;Ljava/io/Serializable;)V", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IChameleonHandlerContext {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static IChameleonLoader getWebviewLoader(IChameleonHandlerContext r0) {
            return null;
        }
    }

    Context getAppContext();

    String getBizName();

    WebFragment getFragment();

    String getSession();

    IChameleonLoader getWebviewLoader();

    <T extends Serializable> void sendEvent(String r1, T r2);
}
