package com.bytedance.android.live.effect;

import android.os.Looper;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyFragment;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveSmallItemBeautyHelper {
    public final List<Sticker> a;
    public final List<Sticker> b;
    public final List<b> c;
    public final com.bytedance.android.live.effect.sticker.e d;
    public final List<Sticker> e;
    public final List<Sticker> f;
    public final LiveEffectContextFactoryDelegate$Type g;

    public static final class a {
    }

    public interface b {
        void a(Sticker r1);

        void onError();
    }

    public interface c {
        void onError();

        void onSuccess(List<Sticker> r1);
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/effect/LiveSmallItemBeautyHelper$d", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d extends TypeToken<List<? extends Sticker.ComposerConfig>> {
        public d() {
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ Sticker b;

        public e(b r1, Sticker r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ LiveSmallItemBeautyHelper a;
        public final /* synthetic */ Sticker b;
        public final /* synthetic */ boolean c;

        public f(LiveSmallItemBeautyHelper r1, Sticker r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ Sticker b;

        public g(b r1, Sticker r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements com.bytedance.android.live.effect.api.k.f {
        public final /* synthetic */ LiveSmallItemBeautyHelper a;
        public final /* synthetic */ LiveSmallItemBeautyHelper$tryDownloadSticker$1 b;
        public final /* synthetic */ b c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void Z(String r1, Sticker r2) {
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void O1(String r3, Sticker r4) {
            if (Intrinsics.areEqual(d0.i, r3) == false) goto L12;
            if (r4 != null) goto L6;
        L8:
            this.b.invoke(this.c, r4);
            Iterator<T> r5 = this.a.c.iterator();
        L10:
            if (r5.hasNext() == false) goto L14;
            b r0 = (b) r5.next();
            this.b.invoke(r0, r4);
            goto L10
        L14:
            return;
        L6:
            if (this.d == false) goto L8;
            this.a.h(r4, this.e);
            goto L8
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void z0(String r2, Sticker r3, ExceptionResult r4) {
            if (Intrinsics.areEqual(d0.i, r2) == false) goto L8;
            this.b.invoke(this.c, null);
            Iterator<T> r5 = this.a.c.iterator();
        L6:
            if (r5.hasNext() == false) goto L10;
            b r6 = (b) r5.next();
            this.b.invoke(r6, null);
            goto L6
        L10:
            return;
        }

        public h(LiveSmallItemBeautyHelper r1, LiveSmallItemBeautyHelper$tryDownloadSticker$1 r2, b r3, boolean r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.g;
    }

    public LiveSmallItemBeautyHelper(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.g = r2;
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new com.bytedance.android.live.effect.sticker.e(FileUtils.BEAUTY);
        this.e = new ArrayList();
        this.f = new CopyOnWriteArrayList();
    }

    public final void a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (((CopyOnWriteArrayList) this.c).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.c).add(r2);
        return;
    }

    public final void e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (((CopyOnWriteArrayList) this.c).contains(r2) == false) goto L6;
        ((CopyOnWriteArrayList) this.c).remove(r2);
        return;
    }

    @Deprecated(message = "")
    public final void h(Sticker r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r22, "sticker");
        boolean r1 = y50.c.a;
        long r3 = y50.c.g("beauty_updateLocalTagValue");
        List<String> r5 = LiveEffectContext.h;
        ILiveEffectComposerManager r6 = LiveEffectContext.a.a(this.g).a();
        if (r23 == false) goto L5;
        List<Sticker> r7 = this.e;
    L6:
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        Object r11 = r9.next();
        if (StringUtils.equal(((Sticker) r11).getResourceId(), r22.getResourceId()) == false) goto L8;
        r8.add(r11);
        goto L8
    L12:
        Iterator r2 = r8.iterator();
    L14:
        if (r2.hasNext() == false) goto L26;
        Sticker r13 = (Sticker) r2.next();
        Sticker.ComposerConfig r14 = r13.getSmallItemConfig();
        if (r14 == null) goto L25;
        if (r6.G(r13.getEffectId(), r14.getTag()) != null) goto L25;
        String r15 = d0.i;
        ILiveEffectComposerManager.f.a(r6, r15, r13, "LiveSmallItemBeautyHelper_updateLocalTagValue", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), null, 48);
        Float r12 = r6.G(r13.getEffectId(), r14.getTag());
        if (r12 == null) goto L22;
        float r16 = r12.floatValue();
    L23:
        ILiveEffectComposerManager.f.d(r6, r15, r13, r14.getTag(), r16, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 16);
        goto L25
    L22:
        r16 = q.d(r13, r14.getDefaultValue());
    L25:
        r2 = r2;
        goto L14
    L26:
        boolean r0 = y50.c.a;
        y50.c.h("beauty_updateLocalTagValue", r3);
        return;
    L5:
        r7 = this.b;
        goto L6
    }

    public static /* synthetic */ void d(LiveSmallItemBeautyHelper r2, LiveSmallItemBeautyFragment.b r3, int r4) {
        String r1 = null;
        if ((r4 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r1 = d0.i;
    L8:
        r2.c(r3, r1, false);
    }

    public final void c(c r13, String r14, boolean r15) {
        String r0 = d0.i;
        if (Intrinsics.areEqual(r14, r0) == true) goto L5;
    L11:
        System.currentTimeMillis();
        m r7 = new m(this, r13);
        List<String> r16 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.g).b().h().c() == false) goto L18;
        com.bytedance.android.live.effect.sticker.presenter.o r5 = LiveEffectContext.a.a(this.g).b().d();
        if (r14 != null) goto L16;
        String r6 = r0;
    L17:
        r5.a(r6, r7, true, true, false, true);
        return;
    L16:
        r6 = r14;
        goto L17
    L18:
        LiveEffectContext.a.a(this.g).b().r().p(r14, r7, true);
        return;
    L5:
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == false) goto L7;
        List<String> r1 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.g).b().l(), "style", this.g, null, 12);
    L7:
        if (r15 == false) goto L11;
        List<String> r17 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.g).b().l(), "beautyclassify", this.g, null, 12);
        if (r13 != null) goto L11;
    }

    public final void f(Sticker r11, boolean r12, b r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "sticker");
        LiveSmallItemBeautyHelper$tryDownloadSticker$1 r3 = new LiveSmallItemBeautyHelper$tryDownloadSticker$1(Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())));
        List<String> r0 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.g).b().r().q(r11) == false) goto L11;
        if (r12 == false) goto L6;
        AndroidSchedulers.mainThread().scheduleDirect(new f(this, r11, r14));
    L6:
        AndroidSchedulers.mainThread().scheduleDirect(new g(r13, r11));
        Iterator r15 = ((CopyOnWriteArrayList) this.c).iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        b r16 = (b) r15.next();
        AndroidSchedulers.mainThread().scheduleDirect(new e(r16, r11));
        goto L8
    L10:
        return;
    L11:
        LiveEffectContext.a.a(this.g).b().r().g(d0.i, r11, new h(this, r3, r13, r12, r14));
    }

    public static /* synthetic */ void g(LiveSmallItemBeautyHelper r0, Sticker r1, boolean r2, boolean r3, int r4) {
        if ((r4 & 8) == 0) goto L5;
        r3 = false;
    L5:
        r0.f(r1, r2, null, r3);
    }

    public final Sticker b(List<Sticker> r4, Effect r5, boolean r6, String r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r4, "stickerList");
        Intrinsics.checkNotNullParameter(r5, NewBroadcastMonitor.STAGE.EFFECT);
        Sticker r0 = com.bytedance.android.live.effect.sticker.d.b(r5);
        r0.setParentResId(r7);
        JsonObject r11 = new JsonParser().parse(r5.getExtra()).getAsJsonObject();     // Catch: Throwable -> L32
        JsonElement r12 = r11.get("video_tag");     // Catch: Throwable -> L32
        String r1 = "";
        if (r12 == null) goto L8;
        String r13 = r12.getAsString();     // Catch: Throwable -> L32
        if (r13 == null) goto L8;
    L9:
        JsonElement r14 = r11.get("beautyConfig");     // Catch: Throwable -> L32
        if (r14 == null) goto L16;
        String r15 = r14.getAsString();     // Catch: Throwable -> L32
        if (r15 == null) goto L16;
        r1 = r15;
    L16:
        if (r1.length() != 0) goto L18;
        boolean r16 = true;
    L19:
        if (r16 == false) goto L21;
        return r0;
    L21:
        JsonArray r17 = new JsonParser().parse(r1).getAsJsonObject().getAsJsonArray("items");     // Catch: Throwable -> L32
        Type r2 = new d().getType();     // Catch: Throwable -> L32
        List r18 = (List) GsonHelper.get().fromJson(r17, r2);     // Catch: Throwable -> L32
        r0.setComposerConfigList(r18);     // Catch: Throwable -> L32
        r0.setVideoTag(r13);     // Catch: Throwable -> L32
        Iterator r19 = r18.iterator();     // Catch: Throwable -> L32
    L23:
        if (r19.hasNext() == false) goto L25;
        Sticker.ComposerConfig r21 = (Sticker.ComposerConfig) r19.next();     // Catch: Throwable -> L32
        r0.getUpdateKeys().add(r21.getTag());     // Catch: Throwable -> L32
        goto L23
    L25:
        if (r8 == true) goto L27;
        r4.add(r0);     // Catch: Throwable -> L32
    L30:
        f(r0, r6, null, r9);     // Catch: Throwable -> L32
    L34:
        return r0;
    L27:
        if (r4.contains(r0) == true) goto L30;
        r4.add(r0);     // Catch: Throwable -> L32
        goto L30
    L18:
        r16 = false;
    L8:
        r13 = "";
    L32:
        th = move-exception;
        ALogger.e("LiveSmallItemBeautyDialogFragment", th);
        goto L34
    }
}
