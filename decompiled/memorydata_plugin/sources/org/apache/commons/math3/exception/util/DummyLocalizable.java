package org.apache.commons.math3.exception.util;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class DummyLocalizable implements Localizable {
    private static final long serialVersionUID = 8843275624471387299L;
    private final String source;

    public DummyLocalizable(String r1) {
        this.source = r1;
    }

    @Override // org.apache.commons.math3.exception.util.Localizable
    public String getLocalizedString(Locale r1) {
        return this.source;
    }

    @Override // org.apache.commons.math3.exception.util.Localizable
    public String getSourceString() {
        return this.source;
    }

    public String toString() {
        return this.source;
    }
}
