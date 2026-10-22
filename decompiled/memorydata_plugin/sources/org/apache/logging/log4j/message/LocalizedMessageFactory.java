package org.apache.logging.log4j.message;

import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes6.dex */
public class LocalizedMessageFactory extends AbstractMessageFactory {
    private static final long serialVersionUID = -1996295808703146741L;
    private final String baseName;
    private final transient ResourceBundle resourceBundle;

    public LocalizedMessageFactory(String r2) {
        this.resourceBundle = null;
        this.baseName = r2;
    }

    public LocalizedMessageFactory(ResourceBundle r1) {
        this.resourceBundle = r1;
        this.baseName = null;
    }

    public String getBaseName() {
        return this.baseName;
    }

    public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    @Override // org.apache.logging.log4j.message.AbstractMessageFactory, org.apache.logging.log4j.message.d
    public Message newMessage(String r2) {
        if (this.resourceBundle != null) goto L7;
        return new LocalizedMessage(this.baseName, r2);
    L7:
        return new LocalizedMessage(this.resourceBundle, r2);
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r2, Object... r3) {
        if (this.resourceBundle != null) goto L7;
        return new LocalizedMessage(this.baseName, r2, r3);
    L7:
        return new LocalizedMessage(this.resourceBundle, r2, r3);
    }
}
