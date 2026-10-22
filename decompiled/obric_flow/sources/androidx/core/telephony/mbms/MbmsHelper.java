package androidx.core.telephony.mbms;

import android.content.Context;
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
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CharSequence getBestNameForService(Context r5, ServiceInfo r10) {
            Set<Locale> r11 = r10.getNamedContentLocales();
            if (r11.isEmpty() == false) goto L5;
            return null;
        L5:
            String[] r12 = new String[r11.size()];
            Iterator<Locale> r13 = r10.getNamedContentLocales().iterator();
            int r14 = 0;
        L7:
            if (r13.hasNext() == false) goto L9;
            r12[r14] = r13.next().toLanguageTag();
            r14 = r14 + 1;
            goto L7
        L9:
            Locale r15 = r5.getResources().getConfiguration().getLocales().getFirstMatch(r12);
            if (r15 != null) goto L13;
            return null;
        L13:
            return r10.getNameForLocale(r15);
        }
    }

    private MbmsHelper() {
    }

    @Nullable
    public static CharSequence getBestNameForService(@NonNull Context r5, @NonNull ServiceInfo r10) {
        return Api28Impl.getBestNameForService(r5, r10);
    }
}
