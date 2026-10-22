package xoc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.PackageChannelManager;
import com.suite.lark.component.protocol.Biz;
import java.util.Locale;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static String a;

    /* JADX INFO: renamed from: xoc.a$a, reason: collision with other inner class name */
    public static class C0346a {
        public static String a(boolean r5) {
            if (r5 == false) goto L10;
            Log.i("UserAgentModule", "firstlyGetUserAgent return the mock ua.");
        L10:
            String r2 = Build.MODEL;     // Catch: Exception -> L7
            return String.format("Mozilla/5.0 (Linux; Android %s; %s Build/%s %s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36", new Object[]{Build.VERSION.RELEASE, r2, Build.MANUFACTURER, r2});
        L7:
            e = move-exception;
            Log.e("UserAgentModule", e);
            return "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
        }
    }

    public static String a(Context r8) {
        Log.i("UserAgentModule", "will use normal ua");
        Log.i("UserAgentModule", "use new Strategy UA :" + a);
        String r2 = "Feishu";
        if (TextUtils.isEmpty(a) == true) goto L5;
        Log.i("UserAgentModule", "use new Strategy UA cache");
        String r9 = b(a);
        a = r9;
    L27:
        if (LarkAppContext.inst().buildConfig().isUsPackage() == false) goto L30;
        r2 = "Lark";
    L30:
        if (LarkAppContext.inst().buildConfig().isMempopeApp() == false) goto L36;
        if (r9.contains("mempope") == true) goto L34;
        r9 = r9.concat(" mempope");
        Log.d("UserAgentModule", "add mempope to ua, ua is: " + r9);
    L34:
        r2 = "Mempope";
    L36:
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L38;
    L41:
        String r10 = r9 + " appid/482431; appname/" + r2 + ";";
        Log.d("UserAgentModule", "add appid and appname to ua, ua is: " + r10);
        if (TextUtils.isEmpty(null) == false) goto L44;
        return r10;
    L44:
        if (r10.contains(null) == true) goto L48;
        Log.i("UserAgentModule", "start appendUA to finalUserAgent");
        String r11 = r10.concat(" null");
        Log.i("UserAgentModule", "finalUA :" + r11);
        return r11;
    L48:
        return r10;
    L38:
        if (r9.contains("doubao") == true) goto L40;
        r9 = r9.concat(" doubao");
        Log.d("UserAgentModule", "add doubao to ua, ua is: " + r9);
    L40:
        r2 = "Doubao";
        goto L41
    L5:
        String r1 = LarkKVStorage.j(Biz.Core, true).getString("key_user_agent", "");
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = C0346a.a(true);
        Log.i("UserAgentModule", "mock ua:" + r1);
    L8:
        Log.i("UserAgentModule", "getUserAgent:" + r1);
        if (TextUtils.isEmpty(r1) == false) goto L11;
        Log.i("UserAgentModule", "inter ua is empty,use mocked_user_agent{NewStrategy}");
        r1 = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
    L11:
        String r6 = ApkUtil.getAppVersionName(r8);
        StringBuilder r7 = new StringBuilder();
        r7.append(r1);
        r7.append(" ");
        if (TextUtils.isEmpty(null) == false) goto L14;
        String r3 = "Lark";
    L15:
        r7.append(r3);
        r7.append("/");
        r7.append(r6);
        String r4 = b(r7.toString());
        if (r4.contains("ChannelName/") == false) goto L19;
        Log.e("UserAgentModule", "channel name is append,return");
        r9 = r4;
    L25:
        a = r9;
        goto L27
    L19:
        if (PackageChannelManager.getDeployMode(r8) == 1) goto L21;
    L23:
        String r12 = "Feishu";
    L24:
        r9 = r4 + " ChannelName/" + r12;
        goto L25
    L21:
        if (LarkAppContext.inst().buildConfig().isUsPackage() == false) goto L23;
        r12 = "Lark";
        goto L24
    L14:
        r3 = null;
        goto L15
    }

    public static String b(String r5) {
        e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        Locale r1 = com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
        if (TextUtils.isEmpty(r5) == true) goto L19;
        if (r1 == null) goto L19;
        String r2 = r1.getLanguage().toLowerCase() + "_" + r1.getCountry().toUpperCase();
        if ("in_ID".equals(r2) == false) goto L9;
        r2 = "id_ID";
    L9:
        Log.i("UserAgentModule", "UA locale param is: " + r2);
        if (r5.contains("LarkLocale/" + r2) == false) goto L12;
        return r5;
    L12:
        if (r5.contains("LarkLocale/") == false) goto L18;
        int r3 = r5.indexOf("LarkLocale/");
        int r4 = r5.indexOf(" ", r3);
        int r6 = r3 + 11;
        if (r4 != (-1)) goto L16;
        String r7 = r5.substring(r6);
    L17:
        String r8 = r5.replace(r7, r2);
        Log.i("UserAgentModule", "UA has replaced the locale, the old locale is: " + r7);
        return r8;
    L16:
        r7 = r5.substring(r6, r4);
        goto L17
    L18:
        String r9 = r5 + " LarkLocale/" + r2;
        Log.i("UserAgentModule", "UA has been added locale param directly");
        return r9;
    L19:
        Log.i("UserAgentModule", "TextUtils.isEmpty(larkUserAgent) || locale == null");
        return r5;
    }
}
