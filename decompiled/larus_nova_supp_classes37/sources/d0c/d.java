package d0c;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final /* synthetic */ Context a(c r0) {
        return getContext(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Context getContext(c r3) {
        if ((r3 instanceof Activity) == false) goto L6;
        return (Context) r3;
    L6:
        if ((r3 instanceof Service) == false) goto L9;
        return (Context) r3;
    L9:
        if ((r3 instanceof Fragment) == false) goto L12;
        return ((Fragment) r3).requireContext();
    L12:
        if ((r3 instanceof View) == false) goto L15;
        return ((View) r3).getContext();
    L15:
        if ((r3 instanceof a) == false) goto L19;
        return ((a) r3).getContext();
    L19:
        throw new IllegalStateException("UserScopeView should a instance of Activity, Service, Fragment or View. Found: " + r3.getClass());
    }
}
