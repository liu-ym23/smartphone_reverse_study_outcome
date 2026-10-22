package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.crypto.bridge.IEnvBridge;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public interface ICloudTransCrypto {
    @NonNull
    byte[] dataDecrypt(byte[] r10);

    @NonNull
    byte[] dataEncrypt(byte[] r10);

    void fullFileDecrypt(InputStream r10, OutputStream r11);

    void fullFileEncrypt(InputStream r10, OutputStream r11);

    void init(Context r10, String r11, String r12, IEnvBridge r13);

    TransCryptoContext initDecryptContext(Context r10, String r11, String r12, byte[] r13, IEnvBridge r14);

    TransCryptoContext initEncryptContext(Context r10, String r11, String r12, IEnvBridge r13);

    void pageFileDecrypt(TransCryptoContext r10, InputStream r11, OutputStream r12);

    void pageFileEncrypt(TransCryptoContext r10, InputStream r11, OutputStream r12);

    void streamDecrypt(InputStream r10, OutputStream r11);

    byte[] streamDecryptBytes(TransCryptoContext r10, byte[] r11);

    TransCryptoContext streamDecryptFirstBytes(byte[] r10);

    void streamEncrypt(InputStream r10, OutputStream r11);
}
