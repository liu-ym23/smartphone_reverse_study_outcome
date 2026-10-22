package com.larus.setting.api;

import androidx.fragment.app.FragmentActivity;
import com.larus.setting.api.data.NotifySettingsItemId;
import com.larus.setting.api.data.NotifySettingsSectionId;
import com.larus.setting.api.data.SettingsItemAction;
import com.larus.utils.y;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q implements aza.a {
    public final /* synthetic */ List<zs9.c> a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Function1<List<zs9.c>, Unit> c;

    public final void a(final pza.b r8) {
        Intrinsics.checkNotNullParameter(r8, "settings");
        int r0 = m.a;
        List<zs9.c> r1 = this.a;
        FragmentActivity r2 = this.b;
        zs9.b r3 = new zs9.b();
        r3.a = NotifySettingsItemId.HUMAN_CHAT.getValue();
        r3.b = r8.b;
        r3.d = Integer.valueOf(r8.c);
        r3.e = Boolean.valueOf(r8.d);
        r3.g = SettingsItemAction.TOGGLE;
        r3.h = new l(r8);
        String r9 = NotifySettingsSectionId.NOTIFY_TYPE.getValue();
        Iterator<T> r4 = r1.iterator();
    L3:
        String r5 = null;
        if (r4.hasNext() == false) goto L8;
        Object r6 = r4.next();
        if (Intrinsics.areEqual(((zs9.c) r6).a, r9) == false) goto L3;
    L9:
        zs9.c r7 = (zs9.c) r6;
        if (r7 == null) goto L18;
        List r10 = CollectionsKt.listOf(r3);
        List<zs9.b> r11 = r7.c;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L13:
        if (r13.hasNext() == false) goto L17;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((zs9.b) r14).a, r3.a) == true) goto L13;
        r12.add(r14);
        goto L13
    L17:
        r7.a(CollectionsKt.plus(r10, r12));
    L22:
        SoftReference r15 = y.a;
        final Function1<List<zs9.c>, Unit> r16 = this.c;
        final List<zs9.c> r17 = this.a;
        y.c(new p(r16, r17));
        return;
    L18:
        zs9.c r18 = new zs9.c();
        r18.a = r9;
        if (r2 == null) goto L21;
        r5 = r2.getString(2131909304);
    L21:
        r18.b = r5;
        r18.a(CollectionsKt.listOf(r3));
        r1.add(r18);
        goto L22
    L8:
        r6 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(List<zs9.c> r1, FragmentActivity r2, Function1<? super List<zs9.c>, Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
