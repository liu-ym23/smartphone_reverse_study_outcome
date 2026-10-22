package org.apache.commons.math3.exception.util;

import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public interface Localizable extends Serializable {
    String getLocalizedString(Locale r1);

    String getSourceString();
}
