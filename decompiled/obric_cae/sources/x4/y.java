package x4;

import com.bytedance.frameworks.encryptor.EncryptorUtil;

/* JADX INFO: loaded from: classes.dex */
public interface y {

    public static class a implements y {
        @Override // x4.y
        public final byte[] a(int r8, byte[] r10) {
            return EncryptorUtil.a(r8, r10);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    byte[] a(int r8, byte[] r10);
}
