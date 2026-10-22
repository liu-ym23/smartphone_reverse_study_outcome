package com.google.crypto.tink.subtle;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes2.dex */
public interface c<T> {

    public static class a implements c<Cipher> {
        public a() {
        }

        @Override // com.google.crypto.tink.subtle.c
        public /* synthetic */ Cipher a(String r1, Provider r2) {
            return b(r1, r2);
        }

        public Cipher b(String r1, Provider r2) {
            if (r2 != null) goto L6;
            return Cipher.getInstance(r1);
        L6:
            return Cipher.getInstance(r1, r2);
        }
    }

    public static class b implements c<KeyAgreement> {
        public b() {
        }

        @Override // com.google.crypto.tink.subtle.c
        public /* synthetic */ KeyAgreement a(String r1, Provider r2) {
            return b(r1, r2);
        }

        public KeyAgreement b(String r1, Provider r2) {
            if (r2 != null) goto L6;
            return KeyAgreement.getInstance(r1);
        L6:
            return KeyAgreement.getInstance(r1, r2);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.c$c, reason: collision with other inner class name */
    public static class C0211c implements c<KeyFactory> {
        public C0211c() {
        }

        @Override // com.google.crypto.tink.subtle.c
        public /* synthetic */ KeyFactory a(String r1, Provider r2) {
            return b(r1, r2);
        }

        public KeyFactory b(String r1, Provider r2) {
            if (r2 != null) goto L6;
            return KeyFactory.getInstance(r1);
        L6:
            return KeyFactory.getInstance(r1, r2);
        }
    }

    public static class d implements c<KeyPairGenerator> {
        public d() {
        }

        @Override // com.google.crypto.tink.subtle.c
        public /* synthetic */ KeyPairGenerator a(String r1, Provider r2) {
            return b(r1, r2);
        }

        public KeyPairGenerator b(String r1, Provider r2) {
            if (r2 != null) goto L6;
            return KeyPairGenerator.getInstance(r1);
        L6:
            return KeyPairGenerator.getInstance(r1, r2);
        }
    }

    public static class e implements c<Mac> {
        public e() {
        }

        @Override // com.google.crypto.tink.subtle.c
        public /* synthetic */ Mac a(String r1, Provider r2) {
            return b(r1, r2);
        }

        public Mac b(String r1, Provider r2) {
            if (r2 != null) goto L6;
            return Mac.getInstance(r1);
        L6:
            return Mac.getInstance(r1, r2);
        }
    }

    public static class f implements c<MessageDigest> {
        public f() {
        }

        @Override // com.google.crypto.tink.subtle.c
        public /* synthetic */ MessageDigest a(String r1, Provider r2) {
            return b(r1, r2);
        }

        public MessageDigest b(String r1, Provider r2) {
            if (r2 != null) goto L6;
            return MessageDigest.getInstance(r1);
        L6:
            return MessageDigest.getInstance(r1, r2);
        }
    }

    public static class g implements c<Signature> {
        public g() {
        }

        @Override // com.google.crypto.tink.subtle.c
        public /* synthetic */ Signature a(String r1, Provider r2) {
            return b(r1, r2);
        }

        public Signature b(String r1, Provider r2) {
            if (r2 != null) goto L6;
            return Signature.getInstance(r1);
        L6:
            return Signature.getInstance(r1, r2);
        }
    }

    T a(String r1, Provider r2);
}
