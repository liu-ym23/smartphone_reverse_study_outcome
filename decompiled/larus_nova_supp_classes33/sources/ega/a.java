package ega;

import com.obric.assistant.multiuser.api.IObricMultiUserService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    static {
    }

    public static boolean a() {
        IObricMultiUserService.a.getClass();
        IObricMultiUserService r0 = IObricMultiUserService.a.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        return true;
    }
}
