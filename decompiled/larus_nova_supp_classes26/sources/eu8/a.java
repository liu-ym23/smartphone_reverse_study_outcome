package eu8;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a implements d {
    public final Context a;
    public final JsonElement b;

    public abstract String a();

    public final String toString() {
        StringBuilder r0 = new StringBuilder("CmdExecutorBase{sourceJson=");
        JsonElement r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }

    @Override // eu8.d
    public final Object execute() {
        return a();
    L4:
        e = move-exception;
        String r1 = nu8.a.a;
        Intrinsics.checkNotNullParameter("CmdExecutorBase", ShareType.TEXT);
        Intrinsics.checkNotNullParameter(e, "throwable");
        FLogger r2 = FLogger.a;
        if (r2.a() == false) goto L9;
        r2.e("bootprotector", "CmdExecutorBase", e);
    L9:
        return e.toString();
    }

    public static String b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L20:
        return r4;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L7;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L20;
        IBootProtectorLauncher.a.getClass();
        String r1 = IBootProtectorLauncher.a.b().getDid();
        if (TextUtils.isEmpty(r1) == true) goto L16;
        r4 = r4.replace("{did}", r1);
    L16:
        String r2 = IBootProtectorLauncher.a.b().getUid();
        if (TextUtils.isEmpty(r2) == true) goto L19;
        r4 = r4.replace("{uid}", r2);
    L19:
        nu8.a.h("CmdExecutorBase", "replacePlaceHolder result: " + r4);
        goto L20
    L7:
        if (r4.contains("{did}") == false) goto L9;
    L10:
        r0 = true;
        goto L12
    L9:
        if (r4.contains("{uid}") == false) goto L11;
        goto L10
    }

    public a(Context r1, JsonElement r2) {
        this.a = r1;
        this.b = r2;
    }
}
