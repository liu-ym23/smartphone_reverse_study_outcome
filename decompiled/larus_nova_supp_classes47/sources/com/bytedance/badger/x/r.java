package com.bytedance.badger.x;

import android.content.Context;
import android.os.Build;
import com.bm.badgervi.b;
import com.bytedance.badger.BadgerCore;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r extends q {
    public r() {
    }

    public static String g() {
        BadgerCore.Companion.getClass();
        return com.bytedance.badger.j.b(6652161667115517076L);
    }

    public static String h() {
        String r0 = p.f;
        if (r0 != null) goto L6;
        BadgerCore.Companion.getClass();
        return com.bytedance.badger.j.b(5819945665527921280L);
    L6:
        return r0;
    }

    @Override // com.bytedance.badger.x.q
    public final String c() {
        return "provider";
    }

    @Override // com.bytedance.badger.x.q
    public final void d(Context r1) {
        if (p.e == false) goto L5;
        return;
    L5:
        p.i();
    }

    @Override // com.bytedance.badger.x.q
    public final boolean e() {
        KeyStore r0 = KeyStore.getInstance(p.f);
        r0.load(null);
        if (r0.getCertificate(g()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.badger.x.q
    public final void f() {
        KeyStore r0 = KeyStore.getInstance(h());
        r0.load(null);
        r0.deleteEntry(g());
    }

    @Override // com.bytedance.badger.x.q
    public final String a() {
        KeyStore r0 = KeyStore.getInstance(h());
        r0.load(null);
        if (StringsKt.split$default(h(), new String[]{"."}, false, 0, 6, null).size() <= 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L19;
        Certificate[] r2 = r0.getCertificateChain(g());
        if (r2 == null) goto L18;
        if (r2.length != 0) goto L12;
        boolean r3 = true;
    L14:
        if ((!r3) == false) goto L18;
        JSONObject r4 = b.e((X509Certificate) r2[0]);
        BadgerCore.Companion.getClass();
        return JSONObjectProtectorUtils.getString(r4, com.bytedance.badger.j.b(3852863012899441828L));
    L12:
        r3 = false;
    L18:
        throw new IllegalStateException("certificates is null");
    L19:
        String r5 = g();
        BadgerCore.Companion.getClass();
        String r6 = com.bytedance.badger.j.b(7897631484142453971L);
        if (r6 == null) goto L28;
        Key r7 = r0.getKey(r5, r6.toCharArray());
        if (r7 == null) goto L26;
        return p.c(r7.getEncoded());
    L26:
        throw new IllegalStateException("key is null");
    L28:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.badger.x.q
    public final void b() {
        KeyStore.getInstance(h()).load(null);
        BadgerCore.Companion.getClass();
        String r0 = com.bytedance.badger.j.b(5819945665527921280L);
        boolean r2 = true;
        if (StringsKt.split$default(h(), new String[]{"."}, false, 0, 6, null).size() > 1) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L8;
        r0 = h();
        int r1 = 16;
    L9:
        KeyPairGenerator r3 = KeyPairGenerator.getInstance("RSA", r0);
        String r4 = g() + com.bytedance.badger.j.b(9130210732707849621L);
        if (Build.VERSION.SDK_INT < 23) goto L12;
        k r5 = new e(r4, r1);
    L13:
        r3.initialize(r5.a(new String[]{"SHA-256"}).c(new String[]{"PSS"}).b());
        r3.generateKeyPair();
        return;
    L12:
        r5 = new j(r4, r1);
        goto L13
    L8:
        r1 = 4;
        goto L9
    }
}
