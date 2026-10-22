package com.larus.platform.api;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.model.ecommerce.ECNotifyBinderDialogType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface l2 {
    void a(String r1, String r2, String r3);

    void b(String r1, String r2);

    boolean c(Context r1, Uri r2);

    void d(FragmentActivity r1, Integer r2, String r3, String r4);

    void e(uq9.d r1, Function3<? super String, ? super String, ? super ECNotifyBinderDialogType, Unit> r2, Function1<? super uq9.e, Unit> r3);

    void f(String r1, uq9.l r2);

    int getVersion();

    boolean h(Context r1, String r2);

    boolean i();
}
