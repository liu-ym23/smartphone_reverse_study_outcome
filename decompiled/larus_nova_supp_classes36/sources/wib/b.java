package wib;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.AIConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import ova.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends d {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final boolean a(Context r6, AppLink r7) {
        Log.i("ForwardTextAppLinkHandler", "handle forward appLink");
        if (r6 != null) goto L5;
    L18:
        Log.e("ForwardTextAppLinkHandler", "invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r7.a) == true) goto L18;
        Uri r8 = UriProtector.parse(r7.a);
        if (r8 == null) goto L11;
        String r9 = UriProtector.getQueryParameter(r8, "text_content");
        if (r9 == null) goto L11;
    L13:
        if (TextUtils.isEmpty(r9) == false) goto L16;
        Log.e("ForwardTextAppLinkHandler", "invalid parameter by text_content");
        return false;
    L16:
        IncludeConfig.CREATOR.getClass();
        IncludeConfig r0 = IncludeConfig.b.a();
        EntityItem.a r1 = new EntityItem.a();
        r1.a(new AIConfig());
        r0.a(r1.c());
        ForwardTemplateNew.a r2 = new ForwardTemplateNew.a();
        TextForwardContent.a r3 = new TextForwardContent.a();
        Intrinsics.checkNotNullParameter(r9, "content");
        r3.a = r9;
        r2.f = r3.a();
        ForwardTargetConfig.a r4 = new ForwardTargetConfig.a();
        Intrinsics.checkNotNullParameter(r0, "includeConfig");
        r4.d = r0;
        ForwardTargetConfig r5 = r4.a();
        Intrinsics.checkNotNullParameter(r5, "forwardTargetConfig");
        r2.a = r5;
        ForwardConfirmDialogConfig.a r10 = new ForwardConfirmDialogConfig.a();
        BasicDialogContentConfig.a r11 = new BasicDialogContentConfig.a();
        Intrinsics.checkNotNullParameter(r9, "content");
        r11.c = r9;
        r10.d = r11.a();
        ForwardConfirmDialogConfig r12 = r10.a();
        Intrinsics.checkNotNullParameter(r12, "forwardConfirmDialogConfig");
        r2.e = r12;
        com.ss.android.lark.forwardv3.forward.textforward.a.a(r6, 11, -1, r2.a());
        return true;
    L11:
        r9 = "";
        goto L13
    }

    public final boolean b(Context r3, AppLink r4) {
        Log.i("ForwardTextAppLinkHandler", "canOpen");
        if (r3 != null) goto L5;
    L9:
        Log.e("ForwardTextAppLinkHandler", "canOpen invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r4.a) == true) goto L9;
        return true;
    }
}
