package com.bytedance.android.ec.core.utils;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t1<T> implements Consumer {
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ TextView e;

    public t1(List r1, String r10, float r11, TextView r12) {
        this.a = r1;
        this.b = r10;
        this.c = 3.0f;
        this.d = r11;
        this.e = r12;
    }

    public final void accept(Object r10) {
        Unit r11 = (Unit) r10;
        p1.h(p1.d, this.a, this.b, this.c, this.d, this.e);
    }
}
