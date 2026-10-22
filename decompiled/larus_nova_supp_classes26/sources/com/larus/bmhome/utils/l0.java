package com.larus.bmhome.utils;

import android.text.InputFilter;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.FullScreenEditFrameLayout;
import com.larus.im.bean.bot.BotModel;
import de8.c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l0 {
    public final FragmentActivity a;
    public final Lazy b;
    public BotModel c;
    public Function1<? super Boolean, Unit> d;
    public Function3<? super CharSequence, ? super Boolean, ? super Boolean, Unit> e;
    public CharSequence f;
    public Integer g;
    public c h;
    public com.larus.bmhome.chat.component.cvs.y i;
    public int j;
    public com.larus.bmhome.chat.component.bottom.voice.d0 k;
    public Function0<Unit> l;
    public ViewGroup m;
    public boolean n;
    public boolean o;
    public InputFilter[] p;
    public Map<String, String> q;

    public final FullScreenEditFrameLayout a() {
        return (FullScreenEditFrameLayout) this.b.getValue();
    }

    public l0(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = LazyKt.lazy(new h0(this));
        this.d = new i0();
        this.e = new j0();
        this.f = "";
        this.l = new k0();
        this.q = MapsKt.emptyMap();
    }
}
