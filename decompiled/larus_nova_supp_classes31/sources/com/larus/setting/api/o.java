package com.larus.setting.api;

import com.larus.setting.api.data.SettingsItemAction;
import com.larus.utils.y;
import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o implements ltb.a<List<? extends mtb.f>> {
    public final /* synthetic */ Function1<List<zs9.c>, Unit> a;

    public final void onError(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "errorMsg");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function1<? super List<zs9.c>, Unit> r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r6) {
        List r7 = (List) r6;
        Intrinsics.checkNotNullParameter(r7, "data");
        final ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L20;
        final mtb.f r1 = (mtb.f) r8.next();
        int r2 = m.a;
        DoubaoAddFriendSettingType r3 = r1.a;
        int r4 = m.a.a[r3.ordinal()];
        if (r4 != 1) goto L8;
        final String r5 = "group";
    L19:
        zs9.b r9 = new zs9.b();
        r9.b = r1.b;
        r9.g = SettingsItemAction.TOGGLE;
        r9.e = Boolean.valueOf(r1.d);
        r9.d = Integer.valueOf(r1.c);
        r9.h = new k(r1, r5);
        r0.add(r9);
        goto L4
    L8:
        if (r4 != 2) goto L10;
        r5 = "qrcode_and_link";
        goto L19
    L10:
        if (r4 != 3) goto L12;
        r5 = "profile";
        goto L19
    L12:
        if (r4 != 4) goto L15;
        r5 = "doc";
        goto L19
    L15:
        throw new NoWhenBranchMatchedException();
    L20:
        SoftReference r10 = y.a;
        final Function1<List<zs9.c>, Unit> r11 = this.a;
        y.c(new n(r11, r0));
    }
}
