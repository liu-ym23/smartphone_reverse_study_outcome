package org.msgpack.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.CharacterCodingException;

/* JADX INFO: loaded from: classes7.dex */
public class MessageStringCodingException extends MessagePackException {
    public MessageStringCodingException(String r1, CharacterCodingException r2) {
        super(r1, r2);
    }

    public MessageStringCodingException(CharacterCodingException r1) {
        super(r1);
    }

    @Override // java.lang.Throwable
    public /* bridge */ /* synthetic */ Throwable getCause() {
        return getCause();
    }

    @Override // java.lang.Throwable
    public CharacterCodingException getCause() {
        return (CharacterCodingException) ZeusTransformUtils.preCheckCast(super.getCause(), CharacterCodingException.class, "com.obric.memorydata.plugin");
    }
}
