package ii;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import oo.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hi.a f17572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f17573c;

    public final void a(Context r10) {
        hi.a r5 = this.f17572b;
        if (r5 != null) goto L6;
        Log.e("SmartRouter", "SysComponentRoute open routeIntent but the routeIntent is null!!!");
        return;
    L6:
        l r11 = this.f17573c;
        String r12 = this.f17571a;
        r11.getClass();
        Class<?> r13 = null;
        if (TextUtils.isEmpty(r12) == false) goto L9;
        String r14 = "";
    L28:
        if (TextUtils.isEmpty(r14) == false) goto L31;
        Log.e("SmartRouter", "SysComponentRoute open routeIntent but the classPath is null!!!");
        return;
    L31:
        Intent r15 = r5.f17328b;
        if (r15 != null) goto L44;
        Log.e("SmartRouter", "SysComponentRoute open routeIntent but the intent is null!!!");
        return;
    L44:
        r13 = Class.forName(r14);     // Catch: ClassNotFoundException -> L37
    L39:
        if (r13 == null) goto L41;
        ComponentName r16 = new ComponentName(r10, r13);
    L42:
        r15.setComponent(r16);
        r15.setPackage(r10.getPackageName());
        b(r10, r15);
        return;
    L41:
        r16 = new ComponentName(r10.getPackageName(), r14);
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L9:
        HashMap r17 = r11.f20820a;
        Uri r18 = Uri.parse(r12);
        if (r18.isHierarchical() == true) goto L12;
        String r19 = null;
    L16:
        String r20 = (String) r17.get(r19);
        if (TextUtils.isEmpty(r20) == false) goto L26;
        Uri r21 = Uri.parse(r12);
        if (r21.isHierarchical() == true) goto L21;
        String r22 = null;
    L25:
        r14 = (String) r17.get(r22);
        goto L28
    L21:
        if (TextUtils.isEmpty(r21.getScheme()) == true) goto L23;
        r22 = r21.getScheme() + "://" + r21.getAuthority() + r21.getPath();
        goto L25
    L23:
        r22 = "//" + r21.getAuthority() + r21.getPath();
        goto L25
    L26:
        r14 = r20;
        goto L28
    L12:
        if (TextUtils.isEmpty(r18.getScheme()) == true) goto L14;
        r19 = "//" + r18.getAuthority() + r18.getPath();
        goto L16
    L14:
        r19 = r12;
        goto L16
    }

    public abstract void b(Context r5, Intent r10);
}
