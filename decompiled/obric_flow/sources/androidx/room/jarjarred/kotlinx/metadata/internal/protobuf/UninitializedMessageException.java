package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public UninitializedMessageException(MessageLite r5) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    private static String buildDescription(List<String> r5) {
        StringBuilder r10 = new StringBuilder("Message missing required fields: ");
        Iterator<String> r11 = r5.iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L11;
        String r13 = r11.next();
        if (r12 == false) goto L8;
        r12 = false;
    L9:
        r10.append(r13);
        goto L4
    L8:
        r10.append(", ");
        goto L9
    L11:
        return r10.toString();
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List<String> getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }

    public UninitializedMessageException(List<String> r5) {
        super(buildDescription(r5));
        this.missingFields = r5;
    }
}
