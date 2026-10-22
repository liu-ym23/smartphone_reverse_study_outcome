package com.obric.assistant.util;

import com.obric.assistant.utils.IObricSensitiveErase;
import kotlin.Metadata;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/util/ObricSensitiveEraseImpl;", "Lcom/obric/assistant/utils/IObricSensitiveErase;", "<init>", "()V", "maskContentInLog", "", "log", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSensitiveEraseImpl implements IObricSensitiveErase {
    public static final Regex a = null;

    public static final class a {
    }

    public ObricSensitiveEraseImpl() {
    }

    static {
        a = new Regex("(?<=content[=:]).+?(?=\\.\\s*\\]\\))");
    }

    @Override // com.obric.assistant.utils.IObricSensitiveErase
    public final String a(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L13;
        if (r3 != null) goto L14;
        return "null";
    L14:
        return r3;
    L13:
        return a.replace(r3, "***[MASKED_FOR_SECURITY]***");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
