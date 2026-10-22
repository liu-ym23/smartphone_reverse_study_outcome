package com.bytedance.android.live.ktv.common.midi.v2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.FeedbackMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class d implements com.bytedance.android.live.ktv.common.midi.g {
    public MidiSkinDressInfo a;
    public final Map<String, BitmapDrawable> b;
    public final Map<String, Bitmap> c;
    public final CompositeDisposable d;
    public final List<Drawable> e;
    public final List<Drawable> f;
    public final List<Drawable> g;
    public final List<Bitmap> h;
    public final List<Bitmap> i;
    public final List<Bitmap> j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;

        public a(d r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Bitmap r6 = (Bitmap) r5;
            this.a.b.put(this.b, new BitmapDrawable(s1.getResources(), r6));
            this.a.c.put(this.b, r6);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public boolean A() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public int C() {
        return 100;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int F() {
        return 4;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void H() {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public boolean L() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int getCurrentMode() {
        return 0;
    }

    public d() {
        LinkedHashMap r1 = new LinkedHashMap();
        this.b = r1;
        LinkedHashMap r2 = new LinkedHashMap();
        this.c = r2;
        this.d = new CompositeDisposable();
        ArrayList r3 = new ArrayList();
        this.f = r3;
        ArrayList r4 = new ArrayList();
        this.i = r4;
        this.e = CollectionsKt.listOf(s1.m(2131252074));
        Drawable r7 = (BitmapDrawable) r1.get("advan_scatter_deco_a");
        if (r7 != null) goto L6;
        r7 = s1.m(2131252077);
    L6:
        Drawable r5 = (BitmapDrawable) r1.get("advan_scatter_deco_b");
        if (r5 != null) goto L10;
        r5 = s1.m(2131252078);
    L10:
        List r6 = CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076), r7, r5, r7, r5, r7, r5});
        r3.clear();
        r3.addAll(r6);
        Bitmap r8 = (Bitmap) r2.get("advan_scatter_deco_a");
        if (r8 != null) goto L13;
        r8 = BitmapFactory.decodeResource(s1.getResources(), 2131252077);
    L13:
        Bitmap r9 = (Bitmap) r2.get("advan_scatter_deco_b");
        if (r9 != null) goto L16;
        r9 = BitmapFactory.decodeResource(s1.getResources(), 2131252078);
    L16:
        List r11 = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), 2131252074), BitmapFactory.decodeResource(s1.getResources(), 2131252075), BitmapFactory.decodeResource(s1.getResources(), 2131252076), r8, r9, r8, r9, r8, r9});
        r4.clear();
        r4.addAll(r11);
        this.g = CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076)});
        this.h = CollectionsKt.listOf(BitmapFactory.decodeResource(s1.getResources(), 2131252074));
        this.j = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), 2131252074), BitmapFactory.decodeResource(s1.getResources(), 2131252075), BitmapFactory.decodeResource(s1.getResources(), 2131252076)});
    }

    public final boolean a() {
        MidiSkinDressInfo r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getDressId();
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        MidiSkinDressInfo r3 = this.a;
        if (r3 == null) goto L12;
        r1 = r3.getDressId();
    L12:
        if ((!Intrinsics.areEqual(r1, "0")) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void clear() {
        ((LinkedHashMap) this.b).clear();
        ((LinkedHashMap) this.c).clear();
        this.d.dispose();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int B() {
        return s1.h(2131107710);
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int D() {
        return vm2.h.w();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final Pair<String, String> E() {
        if (a() == false) goto L19;
        MidiSkinDressInfo r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L11;
        MidiSkinMaterial r2 = r0.getMaterial();
        if (r2 == null) goto L11;
        BackgroundMaterial r3 = r2.getBg();
        if (r3 == null) goto L11;
        String r4 = r3.getToneLineStart();
    L12:
        MidiSkinDressInfo r5 = this.a;
        if (r5 == null) goto L21;
        MidiSkinMaterial r6 = r5.getMaterial();
        if (r6 == null) goto L21;
        BackgroundMaterial r7 = r6.getBg();
        if (r7 == null) goto L21;
        r1 = r7.getToneLineEnd();
    L21:
        return TuplesKt.to(r4, r1);
    L11:
        r4 = null;
        goto L12
    L19:
        r4 = "#FF4BE8";
        r1 = "#FF386B";
        goto L21
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final k G() {
        if (a() == false) goto L12;
        MidiSkinDressInfo r0 = this.a;
        if (r0 == null) goto L13;
        MidiSkinMaterial r1 = r0.getMaterial();
        if (r1 == null) goto L14;
        BackgroundMaterial r2 = r1.getBg();
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getBuoyAreaBg();
    L14:
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final String J() {
        if (a() == false) goto L17;
        MidiSkinDressInfo r0 = this.a;
        if (r0 == null) goto L17;
        MidiSkinMaterial r1 = r0.getMaterial();
        if (r1 == null) goto L17;
        FeedbackMaterial r2 = r1.getFeedback();
        if (r2 == null) goto L17;
        k r3 = r2.getAdvanPerfectBg();
        if (r3 == null) goto L17;
        List<String> r4 = r3.getUrls();
        if (r4 == null) goto L17;
        String r5 = (String) CollectionsKt.first(r4);
        if (r5 == null) goto L17;
        return r5;
    L17:
        return com.bytedance.android.live.ktv.common.midi.c.a;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final MidiSkinDressInfo z() {
        return this.a;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void y(MidiSkinDressInfo r4) {
        this.a = r4;
        if (a() == false) goto L20;
        k r0 = null;
        if (r4 == null) goto L11;
        MidiSkinMaterial r1 = r4.getMaterial();
        if (r1 == null) goto L11;
        BuoyMaterial r2 = r1.getBuoy();
        if (r2 == null) goto L11;
        k r3 = r2.getAdvanScatterDecoA();
    L12:
        b("advan_scatter_deco_a", r3);
        if (r4 == null) goto L19;
        MidiSkinMaterial r5 = r4.getMaterial();
        if (r5 == null) goto L19;
        BuoyMaterial r6 = r5.getBuoy();
        if (r6 == null) goto L19;
        r0 = r6.getAdvanScatterDecoB();
    L19:
        b("advan_scatter_deco_b", r0);
        return;
    L11:
        r3 = null;
        goto L12
    L20:
        ((LinkedHashMap) this.c).clear();
        ((LinkedHashMap) this.b).clear();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Bitmap> I(Integer r3, boolean r4) {
        if (r3 != null) goto L5;
    L7:
        if (r3 != null) goto L10;
    L12:
        if (r3 == null) goto L20;
        if (r3.intValue() != 3) goto L20;
        if (r4 == false) goto L23;
        return this.i;
    L23:
        return this.j;
    L20:
        return this.h;
    L10:
        if (r3.intValue() != 2) goto L12;
    L21:
        return this.h;
    L5:
        if (r3.intValue() != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final String K(int r4, boolean r5) {
        boolean r0 = a();
        if (r4 != 1) goto L5;
        if (r0 == false) goto L62;
        MidiSkinDressInfo r6 = this.a;
        if (r6 == null) goto L84;
        MidiSkinMaterial r7 = r6.getMaterial();
        if (r7 == null) goto L85;
        FeedbackMaterial r8 = r7.getFeedback();
        if (r8 == null) goto L86;
        k r9 = r8.getNice();
        if (r9 == null) goto L87;
        List<String> r11 = r9.getUrls();
        if (r11 != null) goto L89;
        return null;
    L89:
        return (String) CollectionsKt.first(r11);
    L87:
        return null;
    L86:
        return null;
    L85:
        return null;
    L84:
        return null;
    L62:
        String r12 = com.bytedance.android.live.ktv.common.midi.c.a;
        return com.bytedance.android.live.ktv.common.midi.c.e;
    L5:
        if (r4 != 2) goto L7;
        if (r0 == false) goto L49;
        MidiSkinDressInfo r13 = this.a;
        if (r13 == null) goto L77;
        MidiSkinMaterial r14 = r13.getMaterial();
        if (r14 == null) goto L78;
        FeedbackMaterial r15 = r14.getFeedback();
        if (r15 == null) goto L79;
        k r16 = r15.getGood();
        if (r16 == null) goto L80;
        List<String> r17 = r16.getUrls();
        if (r17 != null) goto L82;
        return null;
    L82:
        return (String) CollectionsKt.first(r17);
    L80:
        return null;
    L79:
        return null;
    L78:
        return null;
    L77:
        return null;
    L49:
        String r18 = com.bytedance.android.live.ktv.common.midi.c.a;
        return com.bytedance.android.live.ktv.common.midi.c.f;
    L7:
        if (r4 != 3) goto L90;
        if (r5 == false) goto L23;
        if (r0 == false) goto L22;
        MidiSkinDressInfo r19 = this.a;
        if (r19 == null) goto L64;
        MidiSkinMaterial r21 = r19.getMaterial();
        if (r21 == null) goto L65;
        FeedbackMaterial r22 = r21.getFeedback();
        if (r22 == null) goto L66;
        k r23 = r22.getAdvanPerfectTx();
        if (r23 == null) goto L67;
        List<String> r24 = r23.getUrls();
        if (r24 != null) goto L69;
        return null;
    L69:
        return (String) CollectionsKt.first(r24);
    L67:
        return null;
    L66:
        return null;
    L65:
        return null;
    L64:
        return null;
    L22:
        String r25 = com.bytedance.android.live.ktv.common.midi.c.a;
        return com.bytedance.android.live.ktv.common.midi.c.c;
    L23:
        if (r0 == false) goto L35;
        MidiSkinDressInfo r26 = this.a;
        if (r26 == null) goto L71;
        MidiSkinMaterial r27 = r26.getMaterial();
        if (r27 == null) goto L72;
        FeedbackMaterial r28 = r27.getFeedback();
        if (r28 == null) goto L73;
        k r29 = r28.getPerfect();
        if (r29 == null) goto L74;
        List<String> r31 = r29.getUrls();
        if (r31 == null) goto L75;
        String r32 = (String) CollectionsKt.first(r31);
    L76:
        return r32;
    L75:
        return null;
    L74:
        return null;
    L73:
        return null;
    L72:
        return null;
    L71:
        return null;
    L35:
        String r33 = com.bytedance.android.live.ktv.common.midi.c.a;
        r32 = com.bytedance.android.live.ktv.common.midi.c.g;
        goto L76
    L90:
        return null;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Drawable> M(Integer r3, boolean r4) {
        if (r3 != null) goto L5;
    L7:
        if (r3 != null) goto L10;
    L12:
        if (r3 == null) goto L20;
        if (r3.intValue() != 3) goto L20;
        if (r4 == false) goto L23;
        return this.f;
    L23:
        return this.g;
    L20:
        return this.e;
    L10:
        if (r3.intValue() != 2) goto L12;
    L21:
        return this.e;
    L5:
        if (r3.intValue() != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Drawable> N(Integer r9, boolean r11) {
        if (r9 == null) goto L9;
        if (r9.intValue() != 1) goto L9;
    L32:
        return CollectionsKt.listOf(s1.m(2131252074));
    L9:
        if (r9 != null) goto L12;
    L14:
        if (r9 == null) goto L31;
        if (r9.intValue() != 3) goto L31;
        if (r11 == false) goto L34;
        Drawable r12 = (BitmapDrawable) ((LinkedHashMap) this.b).get("advan_scatter_deco_a");
        if (r12 != null) goto L24;
        r12 = s1.m(2131252077);
    L24:
        Drawable r6 = (BitmapDrawable) ((LinkedHashMap) this.b).get("advan_scatter_deco_b");
        if (r6 != null) goto L33;
        r6 = s1.m(2131252078);
    L33:
        return CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076), r12, r6, r12, r6, r12, r6});
    L34:
        return CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076)});
    L31:
        return CollectionsKt.listOf(s1.m(2131252074));
    L12:
        if (r9.intValue() != 2) goto L14;
        goto L14
    }

    public final void b(String r2, k r3) {
        if (StringsKt.isBlank(r2) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L13;
        if (r3 != null) goto L9;
    L11:
        RxUtilKt.c(a1.k(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r2), b.a), this.d);
        return;
    L9:
        if (r3.isValid() == true) goto L11;
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
