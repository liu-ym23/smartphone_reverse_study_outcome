package com.bytedance.android.live.effect;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.u;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements com.bytedance.android.live.effect.api.d {
    public final List<Sticker> a;
    public final LiveEffectContextFactoryDelegate$Type b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.b$b, reason: collision with other inner class name */
    public static final class C0180b implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ com.bytedance.android.live.effect.composer.n a;
        public final /* synthetic */ com.bytedance.android.live.effect.composer.n b;
        public final /* synthetic */ Sticker c;
        public final /* synthetic */ List d;
        public final /* synthetic */ List e;

        public C0180b(com.bytedance.android.live.effect.composer.n r1, com.bytedance.android.live.effect.composer.n r2, Sticker r3, List r4, List r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "beauty replaced: name: " + this.c.getName() + ", global_effectId: " + this.b.b + ", area_effectId: " + this.c.getEffectId() + ", tagList: " + this.a.i;
        }
    }

    public static final class c implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ Sticker a;

        public c(Sticker r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "downloaded area small item beauty: " + this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/effect/b$d", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d extends TypeToken<List<? extends Sticker.ComposerConfig>> {
        public d() {
        }
    }

    public static final class e implements com.bytedance.android.live.effect.api.k.i {
        public final /* synthetic */ b a;

        public static final class a implements Runnable {
            public final /* synthetic */ e a;
            public final /* synthetic */ EffectChannelResponse b;

            public a(e r1, EffectChannelResponse r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                b r0 = this.a.a;
                List r1 = this.b.getAllCategoryEffects();
                ((CopyOnWriteArrayList) r0.a).clear();
                Iterator r2 = r1.iterator();
            L4:
                if (r2.hasNext() == false) goto L39;
                Effect r3 = (Effect) r2.next();
                boolean r5 = true;
                boolean r6 = false;
                if (r3.getEffectType() == 1) goto L8;
            L10:
                boolean r4 = false;
            L40:
                JsonObject r7 = new JsonParser().parse(r3.getExtra()).getAsJsonObject();     // Catch: Throwable -> L23
                boolean r8 = r7.has("ab_group");     // Catch: Throwable -> L23
                if (r8 == true) goto L42;
            L21:
                r5 = false;
            L22:
                r6 = r5;
            L26:
                ArrayList r9 = new ArrayList();
                if (r4 == false) goto L38;
                if (r8 == false) goto L30;
                if (r6 == false) goto L38;
            L30:
                String r11 = r3.getResourceId();
                List r12 = r3.getChildEffects();
                if (r12 == null) goto L38;
                Iterator r13 = r12.iterator();
            L34:
                if (r13.hasNext() == false) goto L38;
                Sticker r14 = r0.e((Effect) r13.next(), r11);
                if (CollectionsKt.firstOrNull(r14.getComposerConfigList()) == null) goto L34;
                r9.add(r14);
            L38:
                r0.e(r3, null).setSubStickers(r9);
                goto L4
            L42:
                Integer r15 = LiveEffectSettings.LIVE_SMALL_BEAUTY_AB_GROUP.getValue();     // Catch: Throwable -> L19
                int r16 = r7.get("ab_group").getAsInt();     // Catch: Throwable -> L19
                if (r15 == null) goto L21;
                if (r15.intValue() != r16) goto L21;
            L19:
                th = th;
            L25:
                ALogger.e("LiveAreaSmallBeautyHelper", th);
            L23:
                th = th;
                r8 = false;
                goto L25
            L8:
                if (CollectionUtils.isEmpty(r3.getChildEffects()) == true) goto L10;
                r4 = true;
                goto L40
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void b() {
            ALogger.e("LiveAreaSmallBeautyHelper", "Area small item beauty load failed.");
        }

        public e(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void a(EffectChannelResponse r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (Lists.isEmpty(r3.getAllCategoryEffects()) == true) goto L9;
            TTExecutors.getNormalExecutor().submit(new a(this, r3));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.effect.api.d
    public final void a() {
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = u.a;
        u.b(this.b).b().p(d0.j, new e(this), true);
    }

    @Override // com.bytedance.android.live.effect.api.d
    public final String b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((Sticker) r1).getName(), "美白") == false) goto L4;
    L9:
        Sticker r2 = (Sticker) r1;
        if (r2 == null) goto L13;
        String r3 = r2.getReplaceBeauty();
        if (r3 == null) goto L13;
        return r3;
    L13:
        return "";
    L8:
        r1 = null;
        goto L9
    }

    public final List<Sticker> d() {
        return this.a;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.b;
    }

    public b(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.b = r2;
        this.a = new CopyOnWriteArrayList();
    }

    public final List<com.bytedance.android.live.effect.composer.n> c(List<com.bytedance.android.live.effect.composer.n> r22) {
        Intrinsics.checkNotNullParameter(r22, "oldList");
        ALogger.d("COMMODITY_NO_FILTER", "start to replace beauty resources");
        ArrayList r8 = new ArrayList();
        r8.addAll(r22);
        Iterator r11 = ((CopyOnWriteArrayList) this.a).iterator();
    L4:
        if (r11.hasNext() == false) goto L37;
        Sticker r3 = (Sticker) r11.next();
        Iterator<T> r0 = r22.iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        Object r1 = r0.next();
        com.bytedance.android.live.effect.composer.n r12 = (com.bytedance.android.live.effect.composer.n) r1;
        if (Intrinsics.areEqual(r12.a, d0.i) == true) goto L11;
    L13:
        boolean r13 = false;
    L14:
        if (r13 == false) goto L7;
    L17:
        com.bytedance.android.live.effect.composer.n r14 = (com.bytedance.android.live.effect.composer.n) r1;
        if (r14 == null) goto L4;
        r8.remove(r14);
        com.bytedance.android.live.effect.composer.n r2 = new com.bytedance.android.live.effect.composer.n(r14.a, r3.getEffectId(), r3.getResourceId(), r3.getUnzipPath(), r14.e, r14.f, r14.g);
        r2.j = r14.j;
        List<Integer> r4 = r2.h;
        ArrayList r5 = (ArrayList) r4;
        r5.addAll(r14.h);
        List<com.bytedance.android.live.effect.composer.p> r6 = r2.i;
        List<com.bytedance.android.live.effect.composer.p> r7 = r14.i;
        ArrayList r9 = new ArrayList();
        Iterator r15 = ((ArrayList) r7).iterator();
    L21:
        if (r15.hasNext() == false) goto L36;
        Object r16 = r15.next();
        com.bytedance.android.live.effect.composer.p r17 = (com.bytedance.android.live.effect.composer.p) r16;
        Iterator r18 = r3.getComposerConfigList().iterator();
    L24:
        if (r18.hasNext() == false) goto L29;
        Object r19 = r18.next();
        String r21 = ((Sticker.ComposerConfig) r19).getTag();
        com.bytedance.android.live.effect.composer.n r110 = r2;
        if (Intrinsics.areEqual(r21, r17.b) == true) goto L30;
        r2 = r110;
    L30:
        if (r19 == null) goto L32;
        boolean r23 = true;
    L33:
        if (r23 == false) goto L35;
        r9.add(r16);
    L35:
        r2 = r110;
        goto L21
    L32:
        r23 = false;
        goto L33
    L29:
        r110 = r2;
        r19 = null;
        goto L30
    L36:
        com.bytedance.android.live.effect.composer.n r111 = r2;
        ((ArrayList) r6).addAll(r9);
        ALogger.d("COMMODITY_NO_FILTER", new C0180b(r111, r14, r3, r22, r8));
        Unit r24 = Unit.INSTANCE;
        r8.add(r111);
        goto L4
    L11:
        if (Intrinsics.areEqual(r12.b, r3.getReplaceBeauty()) == false) goto L13;
        r13 = true;
        goto L14
    L16:
        r1 = null;
        goto L17
    L37:
        return r8;
    }

    public final Sticker e(Effect r4, String r5) {
        Sticker r1 = com.bytedance.android.live.effect.sticker.d.b(r4);
        r1.setParentResId(r5);
        String r6 = r4.getExtra();     // Catch: Throwable -> L45
        if (r6 != null) goto L6;
    L9:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
        return r1;
    L12:
        JsonObject r8 = new JsonParser().parse(r4.getExtra()).getAsJsonObject();     // Catch: Throwable -> L45
        if (r8.has("ab_group") == false) goto L20;
        Integer r9 = LiveEffectSettings.LIVE_SMALL_BEAUTY_AB_GROUP.getValue();     // Catch: Throwable -> L45
        int r0 = r8.get("ab_group").getAsInt();     // Catch: Throwable -> L45
        if (r9 != null) goto L18;
    L19:
        return r1;
    L18:
        if (r9.intValue() != r0) goto L19;
    L20:
        JsonElement r11 = r8.get("video_tag");     // Catch: Throwable -> L45
        String r2 = "";
        if (r11 == null) goto L25;
        String r12 = r11.getAsString();     // Catch: Throwable -> L45
        if (r12 == null) goto L25;
    L26:
        JsonElement r3 = r8.get("replace_livebeauty");     // Catch: Throwable -> L45
        if (r3 == null) goto L29;
        String r13 = r3.getAsString();     // Catch: Throwable -> L45
    L30:
        r1.setReplaceBeauty(r13);     // Catch: Throwable -> L45
        JsonElement r14 = r8.get("beautyConfig");     // Catch: Throwable -> L45
        if (r14 == null) goto L36;
        String r15 = r14.getAsString();     // Catch: Throwable -> L45
        if (r15 == null) goto L36;
        r2 = r15;
    L36:
        JsonArray r16 = new JsonParser().parse(r2).getAsJsonObject().getAsJsonArray("items");     // Catch: Throwable -> L45
        Type r17 = new d().getType();     // Catch: Throwable -> L45
        List r18 = (List) GsonHelper.get().fromJson(r16, r17);     // Catch: Throwable -> L45
        r1.setComposerConfigList(r18);     // Catch: Throwable -> L45
        r1.setVideoTag(r12);     // Catch: Throwable -> L45
        Iterator r19 = r18.iterator();     // Catch: Throwable -> L45
    L38:
        if (r19.hasNext() == false) goto L40;
        Sticker.ComposerConfig r21 = (Sticker.ComposerConfig) r19.next();     // Catch: Throwable -> L45
        r1.getUpdateKeys().add(r21.getTag());     // Catch: Throwable -> L45
        goto L38
    L40:
        ((CopyOnWriteArrayList) this.a).add(r1);     // Catch: Throwable -> L45
        ALogger.d("COMMODITY_NO_FILTER", new c(r1));     // Catch: Throwable -> L45
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r22 = u.a;     // Catch: Throwable -> L45
        if (u.b(this.b).b().q(r1) == true) goto L47;
        u.b(this.b).b().g(d0.j, r1, new com.bytedance.android.live.effect.c());     // Catch: Throwable -> L45
    L47:
        return r1;
    L29:
        r13 = null;
    L25:
        r12 = "";
        goto L26
    L6:
        if (r6.length() == 0) goto L9;
        r7 = false;
    L45:
        th = move-exception;
        ALogger.e("LiveAreaSmallBeautyHelper", th);
        goto L47
    }
}
