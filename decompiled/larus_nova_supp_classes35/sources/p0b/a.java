package p0b;

import com.ss.android.lark.chameleon.JsbAuthConfig;
import com.ss.android.lark.chameleon.JsbAuthGroup;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final JsbAuthConfig a;
    public final ChameleonWebView b;
    public final ConcurrentHashMap<String, String> c;

    /* JADX INFO: renamed from: p0b.a$a, reason: collision with other inner class name */
    public static final class C0273a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[JsbAuthGroup.values().length];
            r0[JsbAuthGroup.Private.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[JsbAuthGroup.Public.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[BridgeAuthType.values().length];
            r1[BridgeAuthType.Public.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[BridgeAuthType.Private.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[BridgeAuthType.Secure.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    public final boolean a() {
        int r0 = w1b.a.a;
        int r1 = g.a;
        if (g.a.a("chameleon.webview.jsb.auth.enable") == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.getJsbAuthEnable() == false) goto L7;
        return true;
    }

    public a(JsbAuthConfig r3, ChameleonWebView r4) {
        Intrinsics.checkNotNullParameter(r3, "authConfig");
        Intrinsics.checkNotNullParameter(r4, "cmlWebView");
        this.a = r3;
        this.b = r4;
        j.e("CML_TAG_JsbAuthManager", "init authManager with " + r3 + ", bizName = " + r4.getBizName());
        this.c = new ConcurrentHashMap();
    }
}
