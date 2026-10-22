package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MbmsHelper {

    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence getBestNameForService(Context r7, ServiceInfo r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            Set<Locale> r0 = r8.getNamedContentLocales();
            if (r0.isEmpty() == false) goto L5;
            return null;
        L5:
            String[] r1 = new String[r0.size()];
            int r2 = 0;
            Iterator<Locale> r4 = r8.getNamedContentLocales().iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            r1[r2] = ((Locale) ZeusTransformUtils.preCheckCast(r4.next(), Locale.class, "com.obric.memorydata.plugin")).toLanguageTag();
            r2 = r2 + 1;
            goto L7
        L9:
            Locale r10 = ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").getConfiguration().getLocales().getFirstMatch(r1);
            if (r10 != null) goto L13;
            return null;
        L13:
            return r8.getNameForLocale(r10);
        }
    }

    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context r2, ServiceInfo r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return null;
    L5:
        return Api28Impl.getBestNameForService(r4, r3);
    }
}
