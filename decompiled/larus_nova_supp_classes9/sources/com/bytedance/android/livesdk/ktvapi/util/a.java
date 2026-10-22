package com.bytedance.android.livesdk.ktvapi.util;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a {
    void Gd(LifecycleOwner r1, Observer<e> r2);

    List<jd2.e> Sh();

    void Vi(MusicPanel r1, Function1<Object, Unit> r2, Function1<? super Throwable, Unit> r3);

    jd2.d Ze();

    e bj();

    void cancelApply(h80.a<Boolean> r1);

    void gj(MusicPanel r1, Function1<? super com.bytedance.android.live.network.response.e<Object>, Unit> r2, Function1<? super Throwable, Unit> r3);

    int i0();

    void i5(IBaseUser r1, h80.a<Boolean> r2, String r3);

    void r9(LifecycleOwner r1, Observer<List<jd2.e>> r2);

    void z9(h80.a<Boolean> r1);
}
