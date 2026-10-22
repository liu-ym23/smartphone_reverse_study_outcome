package com.volcengine.zeus.servermanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.volcengine.zeus.util.kv.IKVStore;
import com.volcengine.zeus.util.kv.KVStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import mqc.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0017¨\u0006\u000b"}, d2 = {"Lcom/volcengine/zeus/servermanager/MainServerManager;", "Lcom/volcengine/zeus/servermanager/AbsServerManager;", "", "method", "arg", "Landroid/os/Bundle;", "extras", "call", "<init>", "()V", "b", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public class MainServerManager extends AbsServerManager {
    public static final /* synthetic */ KProperty[] b = null;
    public final a a;

    public static final class a implements ReadWriteProperty<Object, String> {
        public final /* synthetic */ IKVStore a;

        public a(IKVStore r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final String getValue(Object r4, KProperty<?> r5) {
            Intrinsics.checkNotNullParameter(r4, "thisRef");
            Intrinsics.checkNotNullParameter(r5, "property");
            KClass r6 = Reflection.getOrCreateKotlinClass(String.class);
            String r1 = "";
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L6;
            return (String) Float.valueOf(this.a.getFloat("activity_hmac_key", ((Float) "").floatValue()));
        L6:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L9;
            return (String) Integer.valueOf(this.a.getInt("activity_hmac_key", ((Integer) "").intValue()));
        L9:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L15;
            String r7 = this.a.getString("activity_hmac_key", "");
            if (r7 == null) goto L35;
            r1 = r7;
        L35:
            return r1;
        L15:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L18;
            return (String) Boolean.valueOf(this.a.getBoolean("activity_hmac_key", ((Boolean) "").booleanValue()));
        L18:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L21;
            return (String) Long.valueOf(this.a.getLong("activity_hmac_key", ((Long) "").longValue()));
        L21:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L24;
            return (String) Double.valueOf(this.a.getDouble("activity_hmac_key", ((Double) "").doubleValue()));
        L24:
            if (Intrinsics.areEqual(r6, Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L32;
            byte[] r8 = this.a.getBytes("activity_hmac_key", (byte[]) "");
            if (r8 == 0) goto L30;
            return (String) r8;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L32:
            throw new UnsupportedOperationException("不支持的类型: " + String.class);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void setValue(Object r2, KProperty<?> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "thisRef");
            Intrinsics.checkNotNullParameter(r3, "property");
            KClass r5 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L10;
            IKVStore r6 = this.a;
            if (r4 == 0) goto L8;
            r6.storeFloat("activity_hmac_key", ((Float) r4).floatValue());
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L10:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L17;
            IKVStore r7 = this.a;
            if (r4 == 0) goto L15;
            r7.storeInt("activity_hmac_key", ((Integer) r4).intValue());
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L17:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L27;
            String r8 = r4;
            if (r8 == null) goto L21;
            boolean r9 = true;
        L22:
            if (r9 == false) goto L25;
            this.a.storeString("activity_hmac_key", r8);
            return;
        L25:
            throw new IllegalArgumentException("不允许向 kvStore 写入 null，key=activity_hmac_key".toString());
        L21:
            r9 = false;
            goto L22
        L27:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L34;
            IKVStore r10 = this.a;
            if (r4 == 0) goto L32;
            r10.storeBoolean("activity_hmac_key", ((Boolean) r4).booleanValue());
            return;
        L32:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L34:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
            IKVStore r11 = this.a;
            if (r4 == 0) goto L39;
            r11.storeLong("activity_hmac_key", ((Long) r4).longValue());
            return;
        L39:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        L41:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L48;
            IKVStore r12 = this.a;
            if (r4 == 0) goto L46;
            r12.storeDouble("activity_hmac_key", ((Double) r4).doubleValue());
            return;
        L46:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
        L48:
            if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L56;
            IKVStore r13 = this.a;
            if (r4 == 0) goto L54;
            r13.storeBytes("activity_hmac_key", (byte[]) r4);
            return;
        L54:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
        L56:
            throw new UnsupportedOperationException("不支持的类型: " + String.class);
        }
    }

    public static final class b {
    }

    static {
        b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MainServerManager.class, "hmacKeyString", "getHmacKeyString()Ljava/lang/String;", 0))};
    }

    public MainServerManager() {
        this.a = new a(KVStorage.INSTANCE.mainDynamicKV());
    }

    public Bundle call(String r4, String r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "method");
        if (Intrinsics.areEqual("kv_get", r4) == false) goto L10;
        if (r6 == null) goto L21;
        String r0 = r6.getString("kv_key");
        if (r0 == null) goto L21;
        String r7 = t.c().a.getString(r0, "");
        Bundle r8 = new Bundle();
        r8.putString("kv_value", r7);
        return r8;
    L21:
        return super.call(r4, r5, r6);
    L10:
        if (Intrinsics.areEqual("kv_set", r4) == false) goto L17;
        if (r6 == null) goto L21;
        String r1 = r6.getString("kv_key");
        String r2 = r6.getString("kv_value");
        if (r1 == null) goto L21;
        if (r2 == null) goto L21;
        SharedPreferences.Editor r3 = t.c().a.edit();
        r3.putString(r1, r2);
        r3.apply();
        goto L21
    L17:
        if (Intrinsics.areEqual("hmac_key", r4) == false) goto L21;
        Bundle r9 = new Bundle();
        r9.putString("hmac_key", (String) this.a.getValue(this, b[0]));
        return r9;
    }
}
