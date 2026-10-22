package com.obric.aikernel.model_decrypt.api.decrypt;

import com.bytedance.news.common.service.manager.IService;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface IModelDecrypt extends IService {

    public static final class DefaultImpls {
        public static /* synthetic */ boolean decryptModelFileByFEKCipher$default(IModelDecrypt r10, String r11, InputStream r12, OutputStream r13, String r14, boolean r15, boolean r16, int r17, Object r18) {
            if (r18 != null) goto L9;
            if ((r17 & 32) == 0) goto L7;
            r16 = false;
        L7:
            return r10.decryptModelFileByFEKCipher(r11, r12, r13, r14, r15, r16);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decryptModelFileByFEKCipher");
        }
    }

    boolean checkModelIntegrity(String r10);

    boolean checkModelIntegrity(String r10, InputStream r11);

    boolean decryptModelFileByFEKCipher(String r10, InputStream r11, OutputStream r12, String r13, boolean r14, boolean r15);

    boolean decryptModelFileByFEKCipher(String r10, InputStream r11, String r12, String r13, boolean r14);

    boolean decryptModelFileByFEKCipher(String r10, InputStream r11, ByteBuffer r12, String r13, boolean r14);

    boolean decryptModelFileByFEKCipher(String r10, String r11, String r12, String r13, boolean r14);

    boolean decryptModelFileByKeyInfo(String r10, InputStream r11, String r12, String r13, String r14);

    boolean decryptModelFileByKeyInfo(String r10, String r11, String r12, String r13);
}
