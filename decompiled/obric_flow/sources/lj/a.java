package lj;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.service.base.b;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.storage.utils.XReadableType;
import com.bytedance.sdk.xbridge.cn.storage.utils.e;
import com.bytedance.sdk.xbridge.cn.utils.f;
import com.google.gson.Gson;
import com.lynx.tasm.behavior.utils.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
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
    public static LinkedHashMap a(Context r18, Uri r19) {
        Uri r5 = r19;
        if (r18 == null) goto L5;
        LinkedHashMap r10 = new LinkedHashMap();
        if (r5 == null) goto L14;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter("bullet_storage_keys", STGroup.DICT_KEY);
        if (r19.isHierarchical() == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L14;
        String r11 = r5.getQueryParameter("bullet_storage_keys");
    L16:
        if (d.g(r11) == false) goto L61;
        List r12 = StringsKt.K(Uri.decode(r11), new String[]{","}, 0, 6);
        Intrinsics.checkNotNullParameter(r18, "context");
        com.bytedance.sdk.xbridge.cn.storage.utils.a r13 = (com.bytedance.sdk.xbridge.cn.storage.utils.a) com.bytedance.sdk.xbridge.cn.storage.utils.d.f7484b.a(r18.getApplicationContext());
        Iterator r14 = r12.iterator();
    L19:
        if (r14.hasNext() == false) goto L60;
        String r15 = (String) r14.next();
        com.bytedance.sdk.xbridge.cn.storage.utils.d r16 = (com.bytedance.sdk.xbridge.cn.storage.utils.d) r13;
        if (r15 != null) goto L24;
        r16.getClass();
    L23:
        Object r17 = null;
    L58:
        if (r17 == null) goto L19;
        r10.put(r15, r17);
        goto L19
    L24:
        SharedPreferences r20 = r16.f7485a;
        if (r20 == null) goto L23;
        if (r20.contains(r15) == false) goto L23;
        String r21 = r20.getString(r15, "");
        if (TextUtils.isEmpty(r21) == true) goto L23;
        Intrinsics.checkNotNull(r21);
        Gson r22 = jj.a.f18347a;
        Intrinsics.checkNotNullParameter(r21, "json");
        Intrinsics.checkNotNullParameter(e.class, "typeClass");
        Gson r110 = jj.a.f18347a;
        e r23 = (e) r110.fromJson(r21, e.class);
        Long r111 = r23.a();
        long r112 = System.currentTimeMillis();
        StringBuilder r113 = new StringBuilder("expiredTime:");
        if (r111 != null) goto L36;
        Object r24 = "null";
    L37:
        r113.append(r24);
        r113.append("|curTime:");
        r113.append(r112);
        r113.append("|storageVal:");
        r113.append(r23);
        f.f("getStorageValues", r113.toString(), "");
        if (r111 != null) goto L40;
    L49:
        String r25 = r23.c();
        r17 = r25;
        switch(XReadableType.valueOf(r23.b()).ordinal()) {
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L55;
            case 4: goto L58;
            case 5: goto L54;
            case 6: goto L53;
            case 7: goto L52;
            default: goto L23;
        };
    L52:
        r17 = Long.valueOf(Long.parseLong(r25));
        goto L58
    L53:
        Intrinsics.checkNotNullParameter(r25, "json");
        Intrinsics.checkNotNullParameter(List.class, "typeClass");
        r17 = r110.fromJson(r25, List.class);
        goto L58
    L54:
        Intrinsics.checkNotNullParameter(r25, "json");
        Intrinsics.checkNotNullParameter(Map.class, "typeClass");
        r17 = r110.fromJson(r25, Map.class);
        goto L58
    L55:
        r17 = Integer.valueOf(Integer.parseInt(r25));
        goto L58
    L56:
        r17 = Double.valueOf(Double.parseDouble(r25));
        goto L58
    L57:
        r17 = Boolean.valueOf(Boolean.parseBoolean(r25));
        goto L58
    L40:
        if (r112 <= r111.longValue()) goto L49;
        if (r20.contains(r15) == false) goto L23;
        SharedPreferences.Editor r26 = r20.edit();
        if (r26 == null) goto L23;
        SharedPreferences.Editor r27 = r26.remove(r15);
        if (r27 == null) goto L23;
        r27.apply();
        Unit r28 = Unit.INSTANCE;
        goto L23
    L36:
        r24 = r111;
        goto L37
    L60:
        boolean r29 = b.f5956a;
        b.a(6, "GlobalPropsInject-getStorageValues.user_domain_map:" + r10, null);
    L61:
        return r10;
    L14:
        r11 = null;
        goto L16
    L5:
        return new LinkedHashMap();
    }

    public static LinkedHashMap b(Context r10, Uri r11) {
        if (r10 == null) goto L4;
        IHostUserDepend r5 = h.f20142n;
        if (r5 == null) goto L8;
        Boolean r12 = Boolean.valueOf(r5.hasLogin());
    L10:
        if (Intrinsics.areEqual(r12, Boolean.FALSE) == false) goto L13;
        b.a(6, "GlobalPropsInject:getUserDomainStorageValuesFail.Fail. user is not login ", null);
        return new LinkedHashMap();
    L13:
        IHostUserDepend r13 = h.f20142n;
        if (r13 == null) goto L16;
        String r14 = r13.getUserId();
    L17:
        if (r14 != null) goto L19;
    L46:
        b.a(6, "GlobalPropsInject:getUserDomainStorageValuesFail.Fail. userId is null or empty.", null);
        return new LinkedHashMap();
    L19:
        if (r14.length() == 0) goto L46;
        LinkedHashMap r15 = new LinkedHashMap();
        if (r11 == null) goto L29;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter("user_domain_storage_keys", STGroup.DICT_KEY);
        if (r11.isHierarchical() == true) goto L27;
        r11 = null;
    L27:
        if (r11 == null) goto L29;
        String r16 = r11.getQueryParameter("user_domain_storage_keys");
    L31:
        if (d.g(r16) == false) goto L45;
        boolean r17 = b.f5956a;
        b.a(6, "GlobalPropsInjectgetUserDomainStorageValues,keyList:" + r16, null);
        if (r16 == null) goto L35;
        List r18 = StringsKt.K(Uri.decode(r16), new String[]{","}, 0, 6);
    L36:
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.sdk.xbridge.cn.storage.utils.b r19 = (com.bytedance.sdk.xbridge.cn.storage.utils.b) com.bytedance.sdk.xbridge.cn.storage.utils.f.f7489b.a(r10.getApplicationContext());
        if (r18 == null) goto L44;
        Iterator r20 = r18.iterator();
    L40:
        if (r20.hasNext() == false) goto L44;
        String r21 = (String) r20.next();
        Triple r22 = ((com.bytedance.sdk.xbridge.cn.storage.utils.f) r19).b(r14, r21, "getUserDomainStorageValues", "");
        ((Boolean) r22.component1()).getClass();
        ((Boolean) r22.component2()).getClass();
        Object r23 = r22.component3();
        if (r23 == null) goto L40;
        r15.put(r21, r23);
    L44:
        boolean r24 = b.f5956a;
        b.a(6, "GlobalPropsInject-getUserDomainStorageValues.user_domain_map:" + r15, null);
        goto L45
    L35:
        r18 = null;
    L45:
        return r15;
    L29:
        r16 = null;
        goto L31
    L16:
        r14 = null;
        goto L17
    L8:
        r12 = null;
        goto L10
    L4:
        return new LinkedHashMap();
    }
}
