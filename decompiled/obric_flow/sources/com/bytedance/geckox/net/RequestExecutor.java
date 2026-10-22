package com.bytedance.geckox.net;

import android.content.Context;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.geckox.AppSettingsManager$IGeckoAppSettings;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.d;
import com.bytedance.iesgurd.model.RequestBodyBase;
import com.lynx.tasm.behavior.ui.utils.n;
import df.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import oa.b;
import we.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bJ\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0082 ¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/geckox/net/RequestExecutor;", "", "", "requestBody", STGroup.DICT_KEY, "", "encrypt", "(Ljava/lang/String;Ljava/lang/String;)V", "hash", "proceedRequest", "(Ljava/lang/String;)V", "td/e", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class RequestExecutor {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestBodyBase f4766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lambda f4768c;

    static {
        d.h("gecko_encrypt");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestExecutor(RequestBodyBase r5, String r10, Function1 r11) {
        this.f4766a = r5;
        this.f4767b = r10;
        this.f4768c = (Lambda) r11;
    }

    private final native void encrypt(String r5, String r10);

    /* JADX WARN: Type inference failed for: r9v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public final void a() {
        String r5 = b.f20421b.f20423a.toJson(this.f4766a);
        c.f16652i.a();
        GeckoGlobalConfig r10 = c.f;
        ta.c r11 = r10.getNetWork().a(this.f4767b, r5);
        if (r10.getEnv() == GeckoGlobalConfig.ENVType.PROD) goto L15;
        String r12 = (String) r11.f22114a.get("X-Gecko-Tt-Env");
        if (r12 != null) goto L8;
    L9:
        r12 = (String) r11.f22114a.get("x-gecko-tt-env");
    L10:
        a r13 = d.f4794a;
        String r14 = r13.e(r10.getContext(), "gecko_x_tt_env", null);
        if (r12 == null) goto L15;
        if (Intrinsics.areEqual(r12, r14) == true) goto L15;
        GeckoLogger.a("X-Gecko-Tt-Env change from " + r14 + " to " + r12 + ", delete all resources");
        com.lynx.tasm.behavior.utils.d.d();
        com.bytedance.iesgurd.settings.d.f6692a = null;
        com.bytedance.iesgurd.settings.d.f6693b = "0";
        n r15 = com.bytedance.iesgurd.settings.d.f6694c;
        r15.getClass();
        GeckoLogger.a("settings cache deleted");
        r13.f((Context) r15.f10761a);
        r13.g(r10.getContext(), "gecko_x_tt_env", r12);
        goto L15
    L8:
        if (r12.length() != 0) goto L10;
    L15:
        this.f4768c.invoke(r11);
    }

    public final void b() {
        AppSettingsManager$IGeckoAppSettings r5 = com.bytedance.geckox.b.f4736a.a();
        if (r5 != null) goto L5;
    L9:
        RequestBodyBase r10 = this.f4766a;
        encrypt(r10.getCommon().getEncryptStr(), r10.getAuth().getRandom());
        return;
    L5:
        if (r5.isUseEncrypt() == true) goto L9;
        a();
    }

    public final void proceedRequest(String r5) {
        if (r5 == null) goto L4;
        this.f4766a.getAuth().setSign(StringsKt.trim(r5).toString());
    L4:
        a();
    }
}
