package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f7489b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7490a;

    static {
        f7489b = new c(UserDomainNativeStorageImpl$Companion$1.f7482a);
    }

    public f(Context r5) {
        this.f7490a = r5;
    }

    public final Pair a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "storageName");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Unit r11 = null;
        Context r12 = this.f7490a;
        if (r12 == null) goto L5;
        SharedPreferences r13 = r12.getSharedPreferences(r5 + "_xbridge_storage", 0);
    L6:
        if (r13 != null) goto L10;
        Boolean r14 = Boolean.FALSE;
        return new Pair(r14, r14);
    L10:
        if (r13.contains(r10) == true) goto L13;
        Boolean r15 = Boolean.FALSE;
        return new Pair(r15, r15);
    L13:
        if (r12 == null) goto L15;
        SharedPreferences r16 = r12.getSharedPreferences(r5 + "_xbridge_storage", 0);
    L16:
        if (r16 == null) goto L18;
        SharedPreferences.Editor r17 = r16.edit();
    L19:
        if (r17 == null) goto L23;
        SharedPreferences.Editor r18 = r17.remove(r10);
        if (r18 == null) goto L23;
        r18.apply();
        r11 = Unit.INSTANCE;
    L23:
        if (r11 == null) goto L25;
        Boolean r19 = Boolean.TRUE;
        return new Pair(r19, r19);
    L25:
        return new Pair(Boolean.TRUE, Boolean.FALSE);
    L18:
        r17 = null;
        goto L19
    L15:
        r16 = null;
        goto L16
    L5:
        r13 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Triple b(String r19, String r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r19, "storageName");
        Intrinsics.checkNotNullParameter(r20, STGroup.DICT_KEY);
        Context r13 = this.f7490a;
        if (r13 == null) goto L5;
        SharedPreferences r14 = r13.getSharedPreferences(r19 + "_xbridge_storage", 0);
    L6:
        if (r14 != null) goto L10;
        com.bytedance.sdk.xbridge.cn.utils.f.f(r21, "The storage of uid is not exist. So data is not exist.", r22);
        Boolean r5 = Boolean.FALSE;
        return new Triple(r5, r5, null);
    L10:
        if (r14.contains(r20) == true) goto L13;
        com.bytedance.sdk.xbridge.cn.utils.f.f(r21, "Data is not exist.", r22);
        Boolean r10 = Boolean.FALSE;
        return new Triple(r10, r10, null);
    L13:
        String r15 = r14.getString(r20, "");
        if (r15 != null) goto L16;
    L54:
        com.bytedance.sdk.xbridge.cn.utils.f.f(r21, "key:" + r20 + ", Data is not exist.", r22);
        Boolean r11 = Boolean.FALSE;
        return new Triple(r11, r11, null);
    L16:
        if (r15.length() == 0) goto L54;
        Gson r16 = jj.a.f18347a;     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(r15, "json");     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(g.class, "typeClass");     // Catch: Exception -> L21
        Gson r17 = jj.a.f18347a;     // Catch: Exception -> L21
        g r18 = (g) r17.fromJson(r15, g.class);     // Catch: Exception -> L21
        Long r110 = r18.b();     // Catch: Exception -> L21
        long r12 = System.currentTimeMillis();     // Catch: Exception -> L21
        StringBuilder r23 = new StringBuilder("expiredTime:");     // Catch: Exception -> L21
        if (r110 != null) goto L23;
        Object r24 = "null";
    L24:
        r23.append(r24);     // Catch: Exception -> L21
        r23.append("|curTime:");     // Catch: Exception -> L21
        r23.append(r12);     // Catch: Exception -> L21
        r23.append("|storageVal:");     // Catch: Exception -> L21
        r23.append(r18);     // Catch: Exception -> L21
        com.bytedance.sdk.xbridge.cn.utils.f.f(r21, r23.toString(), r22);     // Catch: Exception -> L21
        if (r110 != null) goto L28;
    L34:
        String r25 = r18.e();     // Catch: Exception -> L21
        String r111 = r18.d();     // Catch: Exception -> L21
        if (r111 == null) goto L37;
        if (r25 == null) goto L51;
        c(r19, r20, r18, r21, r22);     // Catch: Exception -> L21
        Object r26 = r25;
        switch(XReadableType.valueOf(r111).ordinal()) {
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L49;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L42;
            default: goto L41;
        };     // Catch: Exception -> L21
    L41:
        r26 = null;
        goto L49
    L42:
        r26 = Long.valueOf(Long.parseLong(r25));     // Catch: Exception -> L21
        goto L49
    L43:
        Intrinsics.checkNotNullParameter(r25, "json");     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(List.class, "typeClass");     // Catch: Exception -> L21
        r26 = r17.fromJson(r25, List.class);     // Catch: Exception -> L21
        goto L49
    L44:
        Intrinsics.checkNotNullParameter(r25, "json");     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(Map.class, "typeClass");     // Catch: Exception -> L21
        r26 = r17.fromJson(r25, Map.class);     // Catch: Exception -> L21
        goto L49
    L45:
        r26 = Integer.valueOf(Integer.parseInt(r25));     // Catch: Exception -> L21
        goto L49
    L46:
        r26 = Double.valueOf(Double.parseDouble(r25));     // Catch: Exception -> L21
        goto L49
    L47:
        r26 = Boolean.valueOf(Boolean.parseBoolean(r25));     // Catch: Exception -> L21
    L49:
        return new Triple(Boolean.TRUE, Boolean.FALSE, r26);
    L51:
        return new Triple(Boolean.TRUE, Boolean.FALSE, null);
    L37:
        return new Triple(Boolean.TRUE, Boolean.FALSE, null);
    L28:
        if (r12 <= r110.longValue()) goto L34;
        com.bytedance.sdk.xbridge.cn.utils.f.f(r21, "The data is expired. expiredTime:" + r110 + "|curTime:" + r12 + "|storageVal:" + r18, r22);     // Catch: Exception -> L32
        Pair r27 = a(r19, r20);     // Catch: Exception -> L32
        ((Boolean) r27.component1()).getClass();     // Catch: Exception -> L32
        ((Boolean) r27.component2()).getClass();     // Catch: Exception -> L32
        Boolean r28 = Boolean.TRUE;     // Catch: Exception -> L32
        return new Triple(r28, r28, null);
    L32:
        e = e;
        boolean r112 = true;
    L52:
        com.bytedance.sdk.xbridge.cn.utils.f.f(r21, "JSON deserialization failed.Error:" + e, r22);
        return new Triple(Boolean.TRUE, Boolean.valueOf(r112), null);
    L23:
        r24 = r110;
    L21:
        e = e;
        r112 = false;
        goto L52
    L5:
        r14 = null;
        goto L6
    }

    public final void c(String r11, String r12, g r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "storageName");
        Intrinsics.checkNotNullParameter(r12, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r13, "userDomainStorageValue");
        long r5 = System.currentTimeMillis();
        Gson r10 = jj.a.f18347a;
        g r16 = new g(r13.d(), r13.e(), r13.a(), Long.valueOf(r5), r13.c(), r13.b());
        Intrinsics.checkNotNullParameter(r16, "obj");
        String r17 = jj.a.f18347a.toJson(r16);
        com.bytedance.sdk.xbridge.cn.utils.f.f(r14, androidx.constraintlayout.motion.widget.a.p("modify: key:", r12, ",content:", r17), r15);
        SharedPreferences.Editor r18 = null;
        Context r19 = this.f7490a;
        if (r19 == null) goto L5;
        SharedPreferences r110 = r19.getSharedPreferences(r11 + "_xbridge_storage", 0);
    L6:
        if (r110 == null) goto L8;
        r18 = r110.edit();
    L8:
        if (r18 == null) goto L13;
        SharedPreferences.Editor r111 = r18.putString(r12, r17);
        if (r111 == null) goto L14;
        r111.apply();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r110 = null;
        goto L6
    }
}
