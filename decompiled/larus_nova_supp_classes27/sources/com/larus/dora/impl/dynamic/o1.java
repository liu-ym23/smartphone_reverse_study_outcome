package com.larus.dora.impl.dynamic;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/dynamic/GeneraGroup;", "Lcom/larus/dora/impl/dynamic/entity/ICardProtocol;", "<init>", "()V", "items", "", "Lcom/larus/dora/impl/dynamic/GeneraItem;", "getItems", "()Ljava/util/List;", "desc", "Lcom/larus/dora/impl/dynamic/Identifier;", "getDesc", "()Lcom/larus/dora/impl/dynamic/Identifier;", "shouldVisible", "", "connected", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o1 implements d59.j {

    @SerializedName("desc")
    private final s1 desc;

    @SerializedName("items")
    private final List<p1> items;

    public static final class a {
    }

    static {
    }

    public o1() {
    }

    public final s1 b() {
        return this.desc;
    }

    public final List<p1> c() {
        return this.items;
    }

    @Override // d59.j
    public final boolean a(boolean r8) {
        g49.d.d("CardItem", "shouldVisible generaGroup ,   connected : " + r8);
        List<p1> r0 = this.items;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterator<p1> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L50;
        p1 r2 = r1.next();
        StringBuilder r3 = new StringBuilder("shouldVisible generaGroup itemType  : ");
        String r4 = null;
        if (r2 == null) goto L11;
        String r5 = r2.c();
    L12:
        r3.append(r5);
        r3.append(" , title : ");
        if (r2 == null) goto L15;
        s1 r6 = r2.e();
    L16:
        r3.append(r6);
        r3.append(" , actionUrl : ");
        if (r2 == null) goto L19;
        String r7 = r2.b();
    L20:
        r3.append(r7);
        r3.append(",  connected : ");
        r3.append(r8);
        g49.d.d("CardItem", r3.toString());
        if (r2 == null) goto L23;
        String r9 = r2.c();
    L25:
        if (Intrinsics.areEqual(r9, "simul_interpret") == true) goto L26;
        if (r2 == null) goto L35;
        r4 = r2.c();
    L35:
        if (Intrinsics.areEqual(r4, "wifi_settings") == false) goto L7;
        kj4.a r10 = kj4.a.g();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (kj4.a.g().c() != null) goto L39;
        boolean r11 = false;
    L44:
        g49.d.d("CardItem", "shouldVisible isSupportWifiSettings: " + r11);
        if (r11 == false) goto L48;
        if (r8 == false) goto L48;
        return true;
    L48:
        return false;
    L39:
        sk4.e r12 = r10.requestProtocolInfo();
        if (r12 == null) goto L42;
        r11 = r12.b("wifiSettings");
    L43:
        g49.d.d("DoraAdapterExt", "isSupportWifiSettings: protocolInfo=" + r12 + ", ability=" + r11);
        goto L44
    L42:
        r11 = false;
        goto L43
    L26:
        boolean r13 = DoraAdapterExtKt.x(kj4.a.g());
        g49.d.d("CardItem", "shouldVisible isSupportSimulInterpret  : " + r13);
        if (r13 == false) goto L30;
        if (r8 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        r9 = null;
        goto L25
    L19:
        r7 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    L50:
        return r8;
    }
}
