package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T1, T2> implements ttc.a {
    public final /* synthetic */ AudienceStickerServiceWidget.b a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ zg1.o e;
    public final /* synthetic */ List f;
    public final /* synthetic */ AudienceStickerServiceWidget$onLoad$1$1 g;

    public g(AudienceStickerServiceWidget.b r1, Ref.BooleanRef r2, boolean r3, Ref.ObjectRef r4, zg1.o r5, List r6, AudienceStickerServiceWidget$onLoad$1$1 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void accept(Object r6, Object r7) {
        Sticker r8 = (Sticker) r6;
        Throwable r9 = (Throwable) r7;
        boolean r10 = this.b.element;
        if (r10 == true) goto L5;
    L14:
        if (r10 == false) goto L16;
    L26:
        zg1.q r11 = this.e.d;
        if (r11 == null) goto L38;
        zg1.q.a.a(r11, false);
        return;
    L38:
        return;
    L16:
        if (this.c == false) goto L26;
        if (Intrinsics.areEqual((String) this.d.element, com.bytedance.android.live.effect.api.d0.c) == false) goto L23;
        Sticker r12 = (Sticker) CollectionsKt.firstOrNull(this.f);
        if (r12 == null) goto L22;
        com.bytedance.android.livesdk.widget.z0 r2 = com.bytedance.android.livesdk.widget.z0.a();
        Context r3 = this.a.a.getContext();
        r2.getClass();
        com.bytedance.android.livesdk.widget.x0.b r4 = new com.bytedance.android.livesdk.widget.x0.b(r3, 4);
        r4.a.l = false;
        r4.l(2131918692);
        r4.i(0, 2131918693, new e(this, r12, r8));
        r4.i(1, 2131918684, new f(this));
        r4.k(0, true);
        r4.n();
        return;
    L22:
        this.g.invoke(r12, r8);
        return;
    L23:
        zg1.q r13 = this.e.d;
        if (r13 == null) goto L36;
        zg1.q.a.a(r13, false);
        return;
    L36:
        return;
    L5:
        if (this.c == true) goto L14;
        if (Intrinsics.areEqual((String) this.d.element, com.bytedance.android.live.effect.api.d0.c) == false) goto L11;
        List r14 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.LINK).a().O((String) this.d.element, r8, "AudienceStickerServiceWidget_changeSelectSticker_unselect");
        zg1.q r15 = this.e.d;
        if (r15 == null) goto L30;
        zg1.q.a.a(r15, true);
        return;
    L30:
        return;
    L11:
        zg1.q r16 = this.e.d;
        if (r16 == null) goto L32;
        zg1.q.a.a(r16, false);
        return;
    }
}
