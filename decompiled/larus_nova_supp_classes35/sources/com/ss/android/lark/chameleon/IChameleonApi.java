package com.ss.android.lark.chameleon;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J4\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u001e\u0010\u0011\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H&J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u001e\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H&J(\u0010\u0002\u001a\u00020\u001e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H&¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chameleon/IChameleonApi;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "open", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "bizPlugins", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "getChameleonFragment", "Landroidx/fragment/app/Fragment;", "openByForseti", "sourceFragment", "style", "Lcom/suite/lark/component/navroute/forseti/ForsetiNavOptions$DestinationStyle;", "preloadWebview", "destroyWebview", "Landroid/webkit/WebView;", "loadResource", "callback", "Lcom/ss/android/lark/chameleon/ChameleonResourceLoadCallback;", "getChameleonJsRuntime", "Lcom/ss/android/lark/chameleon/AbsChameleonJsRuntime;", "url", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "bizType", "Lcom/ss/android/lark/chameleon/ChameleonBizType;", "canOpen", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "targetUrl", "extraParams", "Landroid/os/Bundle;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChameleonApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean canOpen$default(IChameleonApi r0, String r1, Bundle r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L7;
            r2 = null;
        L7:
            return r0.canOpen(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canOpen");
        }

        public static /* synthetic */ void preloadWebview$default(IChameleonApi r0, ChameleonConfig r1, WebView r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            r0.preloadWebview(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadWebview");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Fragment getChameleonFragment$default(IChameleonApi r0, Context r1, ChameleonConfig r2, List r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L7;
            r3 = null;
        L7:
            return r0.getChameleonFragment(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChameleonFragment");
        }

        public static /* synthetic */ boolean open$default(IChameleonApi r0, Context r1, String r2, Bundle r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L7;
            r3 = null;
        L7:
            return r0.open(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: open");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void open$default(IChameleonApi r0, Context r1, ChameleonConfig r2, List r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            r0.open(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: open");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void openByForseti$default(IChameleonApi r0, Fragment r1, ForsetiNavOptions.DestinationStyle r2, ChameleonConfig r3, List r4, int r5, Object r6) {
            if (r6 != null) goto L9;
            if ((r5 & 8) == 0) goto L6;
            r4 = null;
        L6:
            r0.openByForseti(r1, r2, r3, r4);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openByForseti");
        }
    }

    boolean canOpen(String r1, Bundle r2);

    Fragment getChameleonFragment(Context r1, ChameleonConfig r2, List<? extends AbsChameleonPlugin> r3);

    AbsChameleonJsRuntime getChameleonJsRuntime(Context r1, String r2, ChameleonBizType r3);

    void loadResource(ChameleonConfig r1, ChameleonResourceLoadCallback r2);

    void open(Context r1, ChameleonConfig r2, List<? extends AbsChameleonPlugin> r3);

    boolean open(Context r1, String r2, Bundle r3);

    void openByForseti(Fragment r1, ForsetiNavOptions.DestinationStyle r2, ChameleonConfig r3, List<? extends AbsChameleonPlugin> r4);

    void preloadWebview(ChameleonConfig r1, WebView r2);
}
