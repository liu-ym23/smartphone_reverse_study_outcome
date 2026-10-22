package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class MathParseException extends MathIllegalStateException {
    private static final long serialVersionUID = -6024911025449780478L;

    public MathParseException(String r4, int r5) {
        getContext().addMessage(LocalizedFormats.CANNOT_PARSE, new Object[]{r4, Integer.valueOf(r5)});
    }

    public MathParseException(String r4, int r5, Class<?> r6) {
        getContext().addMessage(LocalizedFormats.CANNOT_PARSE_AS_TYPE, new Object[]{r4, Integer.valueOf(r5), r6.getName()});
    }
}
