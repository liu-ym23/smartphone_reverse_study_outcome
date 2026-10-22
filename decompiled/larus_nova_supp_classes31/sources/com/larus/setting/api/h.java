package com.larus.setting.api;

import androidx.fragment.app.FragmentActivity;
import com.larus.setting.api.data.FlowSettingsScene;
import com.larus.setting.api.data.NotifySettingsItemId;
import com.larus.setting.api.data.NotifySettingsSectionId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h implements i {
    public static final h a = null;
    public static final List<i> b = null;

    public h() {
    }

    static {
        a = new h();
        b = CollectionsKt.listOf(new i[]{d.a, FlowSocialSettingsProvider.a});
    }

    @Override // com.larus.setting.api.i
    public final void a(FragmentActivity r3, FlowSettingsScene r4, Function1<? super List<zs9.c>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "completion");
        if (r4 == FlowSettingsScene.NOTIFY) goto L6;
        r5.invoke(CollectionsKt.emptyList());
        return;
    L6:
        b(r3, r4, 0, new ArrayList(), r5);
    }

    public static void b(FragmentActivity r8, FlowSettingsScene r9, int r10, List r11, Function1 r12) {
        i r0 = (i) CollectionsKt.getOrNull(b, r10);
        if (r0 != null) goto L41;
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r11.iterator();
    L6:
        if (r14.hasNext() == false) goto L19;
        Iterator r15 = ((List) r14.next()).iterator();
    L9:
        if (r15.hasNext() == false) goto L6;
        zs9.c r16 = (zs9.c) r15.next();
        Object r1 = r16.a;
        if (r1 != null) goto L13;
        r1 = new Object();
    L13:
        zs9.c r2 = (zs9.c) r13.get(r1);
        if (r2 == null) goto L15;
        r2.a(CollectionsKt.plus(r2.c, r16.c));
        if (r2.b != null) goto L9;
        r2.b = r16.b;
        goto L9
    L15:
        zs9.c r3 = new zs9.c();
        r3.a = r16.a;
        r3.b = r16.b;
        r3.a(r16.c);
        r13.put(r1, r3);
        goto L9
    L19:
        EnumEntries<NotifySettingsSectionId> r17 = NotifySettingsSectionId.getEntries();
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
        int r4 = 0;
        int r5 = 0;
    L21:
        if (r19.hasNext() == false) goto L26;
        Object r6 = r19.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        r18.add(TuplesKt.to(((NotifySettingsSectionId) r6).getValue(), Integer.valueOf(r5)));
        r5 = r7;
        goto L21
    L26:
        Map r20 = MapsKt.toMap(r18);
        EnumEntries<NotifySettingsItemId> r110 = NotifySettingsItemId.getEntries();
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r111 = r110.iterator();
    L28:
        if (r111.hasNext() == false) goto L33;
        Object r112 = r111.next();
        int r22 = r4 + 1;
        if (r4 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        r21.add(TuplesKt.to(((NotifySettingsItemId) r112).getValue(), Integer.valueOf(r4)));
        r4 = r22;
        goto L28
    L33:
        Map r113 = MapsKt.toMap(r21);
        Collection r23 = r13.values();
        Iterator r114 = r23.iterator();
    L35:
        if (r114.hasNext() == false) goto L39;
        zs9.c r24 = (zs9.c) r114.next();
        if (Intrinsics.areEqual(r24.a, NotifySettingsSectionId.NOTIFY_TYPE.getValue()) == false) goto L35;
        r24.a(CollectionsKt.sortedWith(r24.c, new g(r113)));
        goto L35
    L39:
        r12.invoke(CollectionsKt.sortedWith(r23, new f(r20)));
        return;
    L41:
        r0.a(r8, r9, new e(r11, r8, r9, r10, r12));
    }
}
