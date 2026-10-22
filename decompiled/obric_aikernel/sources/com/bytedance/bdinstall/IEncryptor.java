package com.bytedance.bdinstall;

import g3.b;

/* JADX INFO: loaded from: classes.dex */
public interface IEncryptor {

    public static class DefaultEncryptor implements IEncryptor {
        public DefaultEncryptor() {
        }

        @Override // com.bytedance.bdinstall.IEncryptor
        public byte[] encrypt(byte[] r10, int r11) {
            return b.a(r10, r11);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    byte[] encrypt(byte[] r10, int r11);
}
