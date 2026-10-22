package com.ss.android.lark.chameleon;

import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J'\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0013H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J'\u0010\u001a\u001a\u00020\u0018\"\b\b\u0000\u0010\t*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u0002H\tH&¢\u0006\u0002\u0010\u001eR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "getCmlContext", "Landroid/content/Context;", "getFragment", "Landroidx/fragment/app/Fragment;", "getChameleonConfig", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "getWebService", "T", "Lcom/bytedance/ee/bear/browser/WebService;", "service", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/WebService;", "webviewLoader", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getSession", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "getBizName", "getWebview", "Landroid/webkit/WebView;", "destroyWebview", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "reloadWebview", "sendEvent", "Ljava/io/Serializable;", IPortraitService.TYPE, Keys.API_RETURN_KEY_DATA, "(Ljava/lang/String;Ljava/io/Serializable;)V", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChameleonHandlerContext {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void destroyWebview(IChameleonHandlerContext r0) {
        }

        public static ChameleonConfig getChameleonConfig(IChameleonHandlerContext r0) {
            return null;
        }

        public static Context getCmlContext(IChameleonHandlerContext r0) {
            return null;
        }

        public static Fragment getFragment(IChameleonHandlerContext r0) {
            return null;
        }

        public static <T extends m> T getWebService(IChameleonHandlerContext r0, Class<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "service");
            return null;
        }

        public static WebView getWebview(IChameleonHandlerContext r0) {
            return null;
        }

        public static IChameleonLoader getWebviewLoader(IChameleonHandlerContext r0) {
            return null;
        }

        public static void reloadWebview(IChameleonHandlerContext r0) {
        }
    }

    void destroyWebview();

    String getBizName();

    ChameleonConfig getChameleonConfig();

    Context getCmlContext();

    Fragment getFragment();

    String getSession();

    <T extends m> T getWebService(Class<T> r1);

    WebView getWebview();

    IChameleonLoader getWebviewLoader();

    void reloadWebview();

    <T extends Serializable> void sendEvent(String r1, T r2);
}
