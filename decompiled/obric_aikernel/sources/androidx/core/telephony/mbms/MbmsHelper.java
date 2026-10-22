package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MbmsHelper {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence getBestNameForService(Context r10, ServiceInfo r11) {
            Set<Locale> r12 = r11.getNamedContentLocales();
            if (r12.isEmpty() == false) goto L5;
            return null;
        L5:
            String[] r13 = new String[r12.size()];
            int r14 = 0;
            Iterator<Locale> r15 = r11.getNamedContentLocales().iterator();
        L7:
            if (r15.hasNext() == false) goto L9;
            r13[r14] = r15.next().toLanguageTag();
            r14 = r14 + 1;
            goto L7
        L9:
            Locale r16 = r10.getResources().getConfiguration().getLocales().getFirstMatch(r13);
            if (r16 != null) goto L13;
            return null;
        L13:
            return r11.getNameForLocale(r16);
        }
    }

    private MbmsHelper() {
    }

    @Nullable
    public static CharSequence getBestNameForService(@NonNull Context r10, @NonNull ServiceInfo r11) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return null;
    L5:
        return Api28Impl.getBestNameForService(r10, r11);
    }
}
