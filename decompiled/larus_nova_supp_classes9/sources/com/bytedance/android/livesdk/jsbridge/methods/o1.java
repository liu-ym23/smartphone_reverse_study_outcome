package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o1<T> implements SingleOnSubscribe {
    public final /* synthetic */ p1 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;

    public static final class a implements LiveSoundEffectHelper.c {
        public final /* synthetic */ o1 a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ LiveSoundEffectHelper c;
        public final /* synthetic */ SingleEmitter d;

        public final void onError() {
            this.d.onSuccess(TuplesKt.to(5, "load effect list failed"));
        }

        public final void onSuccess(List<Sticker> r8) {
            Intrinsics.checkNotNullParameter(r8, "stickerList");
            Iterator<T> r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L14;
            T r0 = r9.next();
            Sticker r2 = (Sticker) r0;
            if (this.b.element == false) goto L9;
            this.c.getClass();
            boolean r3 = LiveSoundEffectHelper.a(r2);
        L12:
            if (r3 == false) goto L4;
        L15:
            Sticker r1 = (Sticker) r0;
            if (r1 == null) goto L18;
            p1 r10 = this.a.a;
            SingleEmitter r4 = this.d;
            r10.getClass();
            List r11 = LiveEffectContext.h;
            LiveSoundEffectHelper r13 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).b().o();
            LiveSoundEffectHelper.c(r13, r1, new l1(r13, r4), null, 4);
            return;
        L18:
            this.d.onSuccess(TuplesKt.to(6, "sticker not in effect list"));
            return;
        L9:
            if (r2.getId() != CastLongProtector.parseLong(this.a.b)) goto L11;
            r3 = true;
            goto L12
        L11:
            r3 = false;
            goto L12
        L14:
            r0 = null;
            goto L15
        }

        public a(o1 r1, Ref.BooleanRef r2, LiveSoundEffectHelper r3, SingleEmitter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public o1(p1 r1, String r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(SingleEmitter<Pair<Integer, String>> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        boolean r1 = false;
        r0.element = false;
        this.a.getClass();
        List r2 = LiveEffectContext.h;
        LiveSoundEffectHelper r3 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).b().o();
        if (this.b.length() != 0) goto L5;
        r1 = true;
    L5:
        if (r1 == false) goto L7;
    L8:
        r0.element = true;
    L9:
        Sticker r4 = r3.d;
        if (this.c == true) goto L12;
    L20:
        a r5 = new a(this, r0, r3, r6);
        Intrinsics.checkNotNullParameter("livesoundeffect", "panel");
        LiveEffectContext.a.a(r3.g).b().r().l("livesoundeffect", new com.bytedance.android.live.effect.soundeffect.e(r3, r5));
        return;
    L12:
        if (this.d == true) goto L20;
        if (r4 == null) goto L20;
        if (LiveSoundEffectHelper.a(r4) == true) goto L20;
        if (r0.element == true) goto L20;
        r6.onSuccess(TuplesKt.to(3, "already applied"));
        return;
    L7:
        if (Intrinsics.areEqual(this.b, "0") == false) goto L9;
        goto L8
    }
}
