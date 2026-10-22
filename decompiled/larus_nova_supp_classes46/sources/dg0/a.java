package dg0;

import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.MicrophoneType;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static IMicrophoneItem a(List r4) {
        List r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        IMicrophoneItem r2 = (IMicrophoneItem) r5.next();
        if (r2.getMicrophoneType() != MicrophoneType.Golden.ordinal()) goto L14;
        return r2;
    L18:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }
}
