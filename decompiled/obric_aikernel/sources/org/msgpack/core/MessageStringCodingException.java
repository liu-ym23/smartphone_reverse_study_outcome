package org.msgpack.core;

import java.nio.charset.CharacterCodingException;

/* JADX INFO: loaded from: classes3.dex */
public class MessageStringCodingException extends MessagePackException {
    public MessageStringCodingException(String r10, CharacterCodingException r11) {
        super(r10, r11);
    }

    public MessageStringCodingException(CharacterCodingException r10) {
        super(r10);
    }

    @Override // java.lang.Throwable
    public /* bridge */ /* synthetic */ Throwable getCause() {
        return getCause();
    }

    @Override // java.lang.Throwable
    public CharacterCodingException getCause() {
        return (CharacterCodingException) super.getCause();
    }
}
