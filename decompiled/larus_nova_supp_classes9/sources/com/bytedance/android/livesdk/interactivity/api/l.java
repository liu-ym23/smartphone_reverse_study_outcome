package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.ChatRoomAuthPlugin;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface l extends v42.b {
    void C(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r1);

    boolean E();

    void V(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r1);

    void Y(ChatRoomAuthPlugin.a r1);

    void c(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r1, Function2<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, ? super Integer, Unit> r2);

    void l(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r1, Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Unit> r2);

    com.bytedance.android.livesdk.interactivity.api.entity.f<?> m(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r1);

    boolean q();

    com.bytedance.android.livesdk.interactivity.api.entity.f<?> t(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r1, IntRange r2);

    void v(ChatRoomAuthPlugin.a r1);

    void x();

    int z(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r1, IntRange r2);
}
