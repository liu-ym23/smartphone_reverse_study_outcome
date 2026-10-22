package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ CustomNoPermissionFragment a;
    public final /* synthetic */ Function1<CustomDisplayTemplate, Unit> b;
    public final /* synthetic */ boolean c;

    public k(CustomNoPermissionFragment r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
        this.c = false;
    }

    public final void accept(Object r6) {
        CustomDisplayConfig r7 = (CustomDisplayConfig) r6;
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        if (this.a.getView() == null) goto L24;
        InternalSecurityAction r0 = this.a.i;
        if (r0 == null) goto L25;
        Function1<CustomDisplayTemplate, Unit> r1 = this.b;
        if (this.c == false) goto L20;
        CustomDisplayTemplate r8 = r7.template;
        Intrinsics.checkNotNullParameter(r8, "originalTemplate");
        Intrinsics.checkNotNullParameter(r0, Keys.API_PARAM_KEY_ACTION);
        Map r2 = MapsKt.toMutableMap(DisplayUtilsKt.b(r0));
        r2.putAll(DisplayUtilsKt.a(r0));
        CustomDisplayTemplate.Builder r3 = r8.newBuilder().title(DisplayUtilsKt.d(r8.title, r2)).text(DisplayUtilsKt.d(r8.text, r2));
        String r4 = r8.richText;
        String r5 = BuildConfig.FLAVOR;
        if (r4 != null) goto L15;
        r4 = BuildConfig.FLAVOR;
    L15:
        CustomDisplayTemplate.Builder r9 = r3.richText(DisplayUtilsKt.d(r4, r2));
        String r10 = r8.sub_text;
        if (r10 == null) goto L19;
        r5 = r10;
    L19:
        CustomDisplayTemplate r11 = r9.sub_text(DisplayUtilsKt.d(r5, r2)).build();
    L21:
        r1.invoke(r11);
        return;
    L20:
        r11 = DisplayUtilsKt.e(r7.template, r0);
        goto L21
    L25:
        return;
    }
}
