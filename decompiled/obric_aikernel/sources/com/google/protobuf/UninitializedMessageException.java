package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public UninitializedMessageException(MessageLite r10) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public UninitializedMessageException(List<String> r10) {
        super(buildDescription(r10));
        this.missingFields = r10;
    }

    private static String buildDescription(List<String> r10) {
        StringBuilder r11 = new StringBuilder("Message missing required fields: ");
        Iterator<String> r12 = r10.iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L11;
        String r14 = r12.next();
        if (r13 == false) goto L8;
        r13 = false;
    L9:
        r11.append(r14);
        goto L4
    L8:
        r11.append(", ");
        goto L9
    L11:
        return r11.toString();
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List<String> getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }
}
