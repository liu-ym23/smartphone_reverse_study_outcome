package wsb;

import com.larksuite.framework.callback.Entity.ErrorResult;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final String a(Locale r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2.getLanguage() + '_' + r2.getCountry();
    }

    public static final ErrorResult b(Throwable r2) {
        if ((r2 instanceof ErrorResult) == false) goto L6;
        return (ErrorResult) r2;
    L6:
        if ((r2 instanceof Exception) == false) goto L8;
        Exception r0 = (Exception) r2;
    L12:
        if (r2 == null) goto L15;
        String r3 = r2.getMessage();
        if (r3 == null) goto L15;
    L17:
        return new ErrorResult(r3, r0);
    L15:
        r3 = "";
        goto L17
    L8:
        if (r2 == null) goto L10;
        r0 = new Exception(r2);
        goto L12
    L10:
        r0 = null;
        goto L12
    }
}
