package org.apache.commons.compress;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class PasswordRequiredException extends IOException {
    private static final long serialVersionUID = 1391070005491684483L;

    public PasswordRequiredException(String r3) {
        super("Cannot read encrypted content from " + r3 + " without a password.");
    }
}
