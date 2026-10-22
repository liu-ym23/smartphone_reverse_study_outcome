package com.bytedance.android.live.effect.soundeffect;

import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.config.fv;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveSoundEffectHelper implements WeakHandler.IHandler {
    public static final /* synthetic */ int h = 0;
    public final ArrayList<Sticker> a;
    public final ArrayList<b> b;
    public int c;
    public Sticker d;
    public final SoundRepelContext e;
    public final WeakHandler f;
    public final LiveEffectContextFactoryDelegate$Type g;

    public static final class a {
    }

    public interface b {
        void a(Sticker r1);

        void onError();

        void x1(int r1, LiveSoundAdapter.ViewHolder r2);
    }

    public interface c {
        void onError();

        void onSuccess(List<Sticker> r1);
    }

    static {
    }

    public final void d() {
        if (this.c >= 0) goto L6;
        this.c = 0;
    L6:
        if (this.c != 0) goto L21;
        Sticker r0 = this.d;
        if (r0 == null) goto L16;
        SoundRepelContext r3 = this.e;
        if (r3 == null) goto L14;
        m<SoundRepelContext.SoundEffectState> r4 = r3.getSoundEffectState();
        if (r4 == null) goto L14;
        r4.setValue(SoundRepelContext.SoundEffectState.USING);
    L14:
        WeakHandler r5 = this.f;
        Map<String, Long> r6 = h.a;
        Intrinsics.checkNotNullParameter(r0, "sticker");
        Intrinsics.checkNotNullParameter(r5, "mHandler");
        h.b.put(r0.getEffectId(), Long.valueOf(System.currentTimeMillis()));
        Message r7 = new Message();
        r7.obj = r0;
        r7.what = 0;
        r5.sendMessageDelayed(r7, ((Number) fv.a.getValue()).longValue() * 1000);
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "add Sound Sticker, id = " + r0.getId() + ",path = " + r0.getUnzipPath());
        return;
    L16:
        SoundRepelContext r1 = this.e;
        if (r1 == null) goto L28;
        m<SoundRepelContext.SoundEffectState> r2 = r1.getSoundEffectState();
        if (r2 == null) goto L29;
        r2.setValue(SoundRepelContext.SoundEffectState.ENABLE);
        return;
    L29:
        return;
    L28:
        return;
    L21:
        SoundRepelContext.SoundEffectState r8 = SoundRepelContext.SoundEffectState.DISABLE_CAUSE_SOUNDSTICKER;
        SoundRepelContext r9 = this.e;
        if (r9 == null) goto L26;
        m<SoundRepelContext.SoundEffectState> r11 = r9.getSoundEffectState();
        if (r11 == null) goto L26;
        r11.setValue(r8);
    L26:
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "remove All Sound Sticker ,audio Resources now null");
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.g;
    }

    public LiveSoundEffectHelper(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.g = r2;
        new AtomicBoolean(true);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.f = new WeakHandler(this);
        DataContext r3 = com.bytedance.live.datacontext.d.d(SoundRepelContext.TAG);
        if ((r3 instanceof SoundRepelContext) == true) goto L5;
        r3 = null;
    L5:
        SoundRepelContext r4 = (SoundRepelContext) r3;
        this.e = r4;
        if (r4 == null) goto L13;
        m<Boolean> r5 = r4.getEffectGameState();
        if (r5 == null) goto L14;
        Observable r6 = r5.a();
        if (r6 == null) goto L15;
        RxUtilKt.n(r6, new AnonymousClass1(this));
        return;
    L15:
        return;
    L14:
        return;
    }

    public static boolean a(Sticker r1) {
        Intrinsics.checkNotNullParameter(r1, "sticker");
        return JSONObjectProtectorUtils.getBoolean(new JSONObject(r1.getExtra()), "Original");
    L6:
        return false;
    }

    public final void handleMsg(Message r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.what != 0) goto L13;
        Object r4 = r3.obj;
        if (r4 == null) goto L10;
        Sticker r5 = (Sticker) r4;
        Map<String, Long> r0 = h.a;
        LiveEffectContextFactoryDelegate$Type r1 = this.g;
        Intrinsics.checkNotNullParameter(r5, "sticker");
        Intrinsics.checkNotNullParameter(r1, "type");
        h.c(r5, "livesdk_live_take_voice_effective_use", r1);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.Sticker");
    }

    public final void b(Sticker r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "sticker");
        if (r13 == false) goto L20;
        if (r14 == false) goto L7;
        m90.b.y.e(this.g, Long.valueOf(r12.getId()));
    L7:
        if (a(r12) == false) goto L15;
        SoundRepelContext.SoundEffectState r15 = SoundRepelContext.SoundEffectState.ENABLE;
        SoundRepelContext r16 = this.e;
        if (r16 == null) goto L13;
        m<SoundRepelContext.SoundEffectState> r17 = r16.getSoundEffectState();
        if (r17 == null) goto L13;
        r17.setValue(r15);
    L13:
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "remove All Sound Sticker ,audio Resources now null");
        this.d = null;
        return;
    L15:
        this.d = r12;
        if (r12.isDownloaded() == true) goto L18;
        r12.setDownloaded(true);
    L18:
        d();
        return;
    L20:
        if (a(r12) == true) goto L26;
        WeakHandler r18 = this.f;
        LiveEffectContextFactoryDelegate$Type r19 = this.g;
        Map<String, Long> r4 = h.a;
        Intrinsics.checkNotNullParameter(r12, "sticker");
        Intrinsics.checkNotNullParameter(r18, "mHandler");
        Intrinsics.checkNotNullParameter(r19, "type");
        r18.removeMessages(0);
        long r5 = System.currentTimeMillis();
        Map<String, Long> r110 = h.b;
        Long r6 = (Long) ((LinkedHashMap) r110).get(r12.getEffectId());
        if (r6 == null) goto L24;
        long r9 = r6.longValue();
    L25:
        Map<String, Long> r7 = h.a;
        h.b(r12, "live_voice_use_time", r19, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("use_time", String.valueOf((r5 - r9) / ((long) 1000)))}));
        r110.put(r12.getEffectId(), 0L);
        goto L26
    L24:
        r9 = 0;
    L26:
        SoundRepelContext.SoundEffectState r111 = SoundRepelContext.SoundEffectState.ENABLE;
        SoundRepelContext r112 = this.e;
        if (r112 == null) goto L31;
        m<SoundRepelContext.SoundEffectState> r113 = r112.getSoundEffectState();
        if (r113 == null) goto L31;
        r113.setValue(r111);
    L31:
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "remove All Sound Sticker ,audio Resources now null");
    }

    public static void c(LiveSoundEffectHelper r2, Sticker r3, b r4, LiveSoundAdapter.ViewHolder r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "sticker");
        List<String> r7 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(r2.g).b().r().q(r3) == false) goto L17;
        r3.setDownloaded(true);
        if (r4 == null) goto L13;
        r4.a(r3);
    L13:
        Iterator<b> r8 = r2.b.iterator();
    L15:
        if (r8.hasNext() == false) goto L20;
        r8.next().a(r3);
        goto L15
    L20:
        return;
    L17:
        LiveEffectContext.a.a(r2.g).b().r().g("livesoundeffect", r3, new g(r2, r4, r5));
    }
}
