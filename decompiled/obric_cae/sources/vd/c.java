package vd;

import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements WeakHandler.IHandler {
    public static String a(Object r8) {
        String r10 = r8.toString();
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return "";
    L7:
        if (r10.length() > 10) goto L9;
        return r10;
    L9:
        return r10.substring(0, 9) + "***" + r10.substring(r10.length() - 5);
    }
}
