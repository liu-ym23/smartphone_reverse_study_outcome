package com.ss.android.lark.chameleon.storage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.IEnv;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/storage/SPKVStore;", "Lcom/ss/android/lark/chameleon/storage/IKVStorage;", "()V", "DOMAIN", BuildConfig.FLAVOR, "sp", "Landroid/content/SharedPreferences;", "clear", BuildConfig.FLAVOR, "getBoolean", BuildConfig.FLAVOR, "key", "defaultValue", "getSP", "getString", "init", "context", "Landroid/content/Context;", "putBoolean", "value", "putString", "remove", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SPKVStore implements IKVStorage {
    private static final String DOMAIN = "chameleon_debug";
    public static final SPKVStore INSTANCE = null;
    private static volatile SharedPreferences sp;

    static {
        INSTANCE = new SPKVStore();
    }

    private SPKVStore() {
    }

    private final SharedPreferences getSP() {
        SharedPreferences r0 = sp;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Env r1 = Env.INSTANCE;
        if (r1.getIEnv() == null) goto L23;
        IEnv r2 = r1.getIEnv();
        if (r2 == null) goto L10;
        Application r3 = r2.getApplication();
    L11:
        if (r3 == null) goto L23;
        monitor-enter(this);
        SharedPreferences r4 = sp;     // Catch: Throwable -> L20
        if (r4 != null) goto L17;
        r4 = Env.getApplication().getSharedPreferences(DOMAIN, 0);     // Catch: Throwable -> L20
        sp = r4;     // Catch: Throwable -> L20
    L17:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r4;
    L20:
        th = move-exception;
        throw th;
    L10:
        r3 = null;
    L23:
        return null;
    }

    public final void clear() {
        SharedPreferences r0 = getSP();
        if (r0 == null) goto L10;
        SharedPreferences.Editor r1 = r0.edit();
        if (r1 == null) goto L11;
        SharedPreferences.Editor r2 = r1.clear();
        if (r2 == null) goto L12;
        r2.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void init(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (sp == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sp != null) goto L9;
        sp = r3.getApplicationContext().getSharedPreferences(DOMAIN, 0);     // Catch: Throwable -> L12
    L9:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final void remove(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        SharedPreferences r0 = getSP();
        if (r0 == null) goto L10;
        SharedPreferences.Editor r1 = r0.edit();
        if (r1 == null) goto L11;
        SharedPreferences.Editor r3 = r1.remove(r2);
        if (r3 == null) goto L12;
        r3.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public boolean getBoolean(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        SharedPreferences r0 = getSP();
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r0.getBoolean(r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public String getString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        SharedPreferences r0 = getSP();
        if (r0 == null) goto L5;
        String r4 = r0.getString(r2, r3);
    L6:
        if (r4 != null) goto L9;
        return r3;
    L9:
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public void put(String r1, Object r2) {
        IKVStorage.DefaultImpls.put(this, r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public void putBoolean(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        SharedPreferences r0 = getSP();
        if (r0 == null) goto L10;
        SharedPreferences.Editor r1 = r0.edit();
        if (r1 == null) goto L11;
        SharedPreferences.Editor r4 = r1.putBoolean(r2, r3);
        if (r4 == null) goto L12;
        r4.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.ss.android.lark.chameleon.storage.IKVStorage
    public void putString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        SharedPreferences r0 = getSP();
        if (r0 == null) goto L10;
        SharedPreferences.Editor r1 = r0.edit();
        if (r1 == null) goto L11;
        SharedPreferences.Editor r4 = r1.putString(r2, r3);
        if (r4 == null) goto L12;
        r4.apply();
        return;
    L12:
        return;
    L11:
        return;
    }
}
