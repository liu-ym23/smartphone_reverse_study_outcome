package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import com.bytedance.crypto.bridge.IEnvBridge;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ICloudTransCrypto {
    byte[] dataDecrypt(byte[] r1);

    byte[] dataEncrypt(byte[] r1);

    void fullFileDecrypt(InputStream r1, OutputStream r2);

    void fullFileEncrypt(InputStream r1, OutputStream r2);

    void init(Context r1, String r2, String r3, IEnvBridge r4);

    TransCryptoContext initDecryptContext(Context r1, String r2, String r3, byte[] r4, IEnvBridge r5);

    TransCryptoContext initEncryptContext(Context r1, String r2, String r3, IEnvBridge r4);

    void pageFileDecrypt(TransCryptoContext r1, InputStream r2, OutputStream r3);

    void pageFileEncrypt(TransCryptoContext r1, InputStream r2, OutputStream r3);

    void streamDecrypt(InputStream r1, OutputStream r2);

    byte[] streamDecryptBytes(TransCryptoContext r1, byte[] r2);

    TransCryptoContext streamDecryptFirstBytes(byte[] r1);

    void streamEncrypt(InputStream r1, OutputStream r2);
}
