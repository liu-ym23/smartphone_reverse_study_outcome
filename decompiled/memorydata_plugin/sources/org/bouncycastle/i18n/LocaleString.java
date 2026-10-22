package org.bouncycastle.i18n;

import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class LocaleString extends LocalizedMessage {
    public String getLocaleString(Locale r2) {
        return getEntry(null, r2, null);
    }
}
