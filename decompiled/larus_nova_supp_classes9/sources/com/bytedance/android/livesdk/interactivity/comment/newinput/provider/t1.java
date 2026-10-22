package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.text.Spannable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.comment.wordassociate.WordAssociationApi;
import com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui.LinearDividerDecoration;
import com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.utils.WordAssociationAppLogger;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<c, z62.j> {
    public static final a d = null;
    public final InputSectionType a;
    public c b;
    public final d c;

    public static final class a implements z62.j {
        public a() {
        }

        @Override // z62.j
        public final int n() {
            return 0;
        }

        @Override // z62.j
        public final long v() {
            return 0;
        }
    }

    public static final class b {
    }

    public final class c extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public final float c;
        public float d;
        public final Long e;
        public final long f;
        public final FrameLayout g;
        public final RecyclerView h;
        public final MultiTypeAdapter i;
        public x62.c j;
        public Disposable k;
        public boolean l;
        public final List<Integer> m;
        public q4.b n;
        public q4.b o;
        public final Function0<Boolean> p;
        public long q;
        public boolean r;

        public final void h() {
            if (this.g.getVisibility() != 0) goto L9;
            q4.b r0 = this.o;
            if (r0 == null) goto L7;
            r0.a();
        L7:
            q4.b r1 = u4.c(new WordAssociateSectionProvider$WordAssociateController$dismissWithAnimate$1(this));
            r1.c();
            this.o = r1;
            return;
        }

        public final void i(List<? extends c32.d> r11) {
            List<? extends c32.d> r0 = r11;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            return;
        L11:
            List<? extends c32.d> r2 = r11;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator<T> r4 = r2.iterator();
        L13:
            if (r4.hasNext() == false) goto L15;
            r3.add(((c32.d) r4.next()).a());
            goto L13
        L15:
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator<T> r6 = r2.iterator();
        L17:
            if (r6.hasNext() == false) goto L26;
            Spannable r7 = ((c32.d) r6.next()).a;
            if (r7 == null) goto L24;
            String r8 = r7.toString();
            if (r8 == null) goto L24;
            String r9 = StringsKt.trim(r8).toString();
            if (r9 == null) goto L24;
        L25:
            r5.add(r9);
        L24:
            r9 = BuildConfig.FLAVOR;
            goto L25
        L26:
            WordAssociationAppLogger.e(r11, r3, r5, ((c32.d) CollectionsKt.first(r11)).b, ((c32.d) CollectionsKt.first(r11)).c, this.b.b, ((c32.d) CollectionsKt.first(r11)).d);
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }

        public c(View r6, final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7) {
            Intrinsics.checkNotNullParameter(r6, "container");
            Intrinsics.checkNotNullParameter(r7, "bridges");
            super(r6, r7);
            this.c = UtilityKotlinExtentionsKt.h(45);
            this.e = (Long) ec2.k0.a.getValue();
            IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
            long r1 = 0;
            if (r0 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r0, r7.R(), 0, 2);
            if (r2 == null) goto L11;
            com.bytedance.live.datacontext.m r3 = r2.getRoom();
            if (r3 == null) goto L11;
            IRoom r4 = (IRoom) r3.getValue();
            if (r4 == null) goto L11;
            r1 = r4.getId();
        L11:
            this.f = r1;
            this.g = (FrameLayout) r6.findViewById(2131393312);
            this.h = r6.findViewById(2131393313);
            this.i = new MultiTypeAdapter();
            this.m = (List) ec2.o1.a.getValue();
            this.p = new WordAssociateSectionProvider$WordAssociateController$predicate$1(r7);
            this.r = true;
        }

        public static final Observable g(c r5, String r6, long r7) {
            if (((Boolean) r5.p.invoke()).booleanValue() == false) goto L7;
            boolean r1 = true;
            if ((!StringsKt.isBlank(r6)) == false) goto L7;
        L8:
            if (r1 == true) goto L10;
            MainThreadPostUtils.b(new u1(r5));
            return Observable.empty();
        L10:
            c32.b r0 = new c32.b();
            r0.roomId = r5.f;
            Charset r2 = Charsets.UTF_8;
            if (r6 == null) goto L18;
            r0.contentEncode = Base64.encodeToString(r6.getBytes(r2), 2);
            String r8 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new c32.a()).second;
            if (r8 != null) goto L15;
            r8 = BuildConfig.FLAVOR;
        L15:
            WordAssociationApi r3 = (WordAssociationApi) com.bytedance.android.live.network.c.b().e(WordAssociationApi.class);
            HashMap r4 = new HashMap();
            r4.put("room_id", String.valueOf(r0.roomId));
            r4.put("content_encode", r0.contentEncode);
            return r3.association(r4, r8).map(new v1(r7)).doOnError(new x1(r5)).onErrorResumeNext(Observable.empty());
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L7:
            r1 = false;
            goto L8
        }

        public final void j(List<? extends c32.d> r14, long r15, boolean r17, String r18) {
            List<? extends c32.d> r1 = this.i.a;
            if ((r1 instanceof List) == true) goto L5;
            r1 = null;
        L5:
            List<? extends c32.d> r2 = r1;
            boolean r10 = false;
            if (r2 != null) goto L8;
        L11:
            boolean r3 = true;
        L12:
            if (r3 == true) goto L14;
            i(r1);
        L14:
            Items r4 = new Items();
            r4.addAll(r14);
            MultiTypeAdapter r5 = this.i;
            r5.a = r4;
            r5.notifyDataSetChanged();
            List<? extends c32.d> r13 = r14;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator<T> r7 = r13.iterator();
        L16:
            if (r7.hasNext() == false) goto L18;
            r6.add(((c32.d) r7.next()).a());
            goto L16
        L18:
            ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator<T> r9 = r13.iterator();
        L20:
            if (r9.hasNext() == false) goto L29;
            Spannable r11 = ((c32.d) r9.next()).a;
            if (r11 == null) goto L27;
            String r16 = r11.toString();
            if (r16 == null) goto L27;
            String r19 = StringsKt.trim(r16).toString();
            if (r19 == null) goto L27;
        L28:
            r8.add(r19);
        L27:
            r19 = BuildConfig.FLAVOR;
            goto L28
        L29:
            long r20 = 0;
            if (r15 <= 0) goto L32;
            r20 = System.currentTimeMillis() - r15;
        L32:
            WordAssociationAppLogger.f(r14, r6, r8, r20, r17, r18, this.b.b);
            if ((r13 instanceof Collection) == true) goto L35;
        L37:
            Iterator<T> r21 = r13.iterator();
        L39:
            if (r21.hasNext() == false) goto L43;
            if (Intrinsics.areEqual(((c32.d) r21.next()).a(), "member_emoji") == false) goto L39;
            r10 = true;
        L43:
            if (r10 == false) goto L45;
            int r23 = WordAssociationAppLogger.a;
            com.bytedance.android.livesdk.interactivity.common.utils.b.b();
        L45:
            Iterator<? extends c32.d> r24 = r14.iterator();
        L47:
            if (r24.hasNext() == false) goto L50;
            c32.d r25 = r24.next();
            r25.d = System.currentTimeMillis();
            r25.e = true;
            goto L47
        L50:
            if (this.g.getVisibility() == 0) goto L64;
            q4.b r26 = this.n;
            if (r26 == null) goto L54;
            r26.a();
        L54:
            q4.b r27 = u4.c(new WordAssociateSectionProvider$WordAssociateController$showWithAnimate$1(this));
            r27.c();
            this.n = r27;
            return;
        L64:
            return;
        L35:
            if (r13.isEmpty() == false) goto L37;
        L8:
            if (r2.isEmpty() == true) goto L11;
            r3 = false;
            goto L12
        }
    }

    public static final class d implements z62.j {
        public final /* synthetic */ t1 a;

        @Override // z62.j
        public final int n() {
            c r0 = this.a.b;
            if (r0 != null) goto L5;
            return 0;
        L5:
            if (r0.g.getVisibility() == 0) goto L7;
            return 0;
        L7:
            return (int) r0.d;
        }

        @Override // z62.j
        public final long v() {
            c r0 = this.a.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.q;
        }

        public d(t1 r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        d = new a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        c r0 = this.b;
        if (r0 == null) goto L18;
        List<? extends c32.d> r1 = r0.i.a;
        if ((r1 instanceof List) == true) goto L7;
        r1 = null;
    L7:
        if (r1 != null) goto L9;
    L13:
        Disposable r2 = r0.k;
        if (r2 == null) goto L16;
        r2.dispose();
    L16:
        r0.k = null;
        return;
    L9:
        if (r1.isEmpty() == true) goto L13;
        if (((c32.d) CollectionsKt.first(r1)).e == false) goto L13;
        r0.i(r1);
        goto L13
    }

    public t1() {
        this.a = InputSectionType.WORD_ASSOCIATE;
        this.c = new d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r10) {
        Intrinsics.checkNotNullParameter(r10, "panelBridge");
        Activity r0 = r10.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        View r1 = LayoutInflater.from(r0).inflate(2131567720, null);
        if (r1 != null) goto L8;
        return null;
    L8:
        c r2 = new c(r1, r10);
        Context r11 = r2.b.getContext();
        if (r11 == null) goto L40;
        EditText r3 = r2.b.a;
        if (r3 == null) goto L40;
        r2.j = new x62.c(r3);
        boolean r4 = false;
        r2.h.setLayoutManager(new LinearLayoutManager(r11, 0, false));
        r2.h.setPadding(UtilityKotlinExtentionsKt.i(5), 0, 0, 0);
        r2.h.setClipToPadding(false);
        r2.h.addItemDecoration(new LinearDividerDecoration(r11.getResources(), UtilityKotlinExtentionsKt.i(7)));
        MultiTypeAdapter r13 = r2.i;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = r2.b;
        r13.z2(c32.d.class, new com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui.b(r5, r5.b));
        r2.h.setAdapter(r2.i);
        IRoomContextService r14 = jc1.k.f(IRoomContextService.class);
        if (r14 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.o r15 = IRoomContextService.a.a(r14, r2.b.R(), 0, 2);
        if (r15 == null) goto L40;
        com.bytedance.live.datacontext.m r16 = r15.getRoom();
        if (r16 == null) goto L40;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L40;
        IRoomAuthStatus r18 = r17.getRoomAuthStatus();
        if (r18 == null) goto L40;
        com.bytedance.android.livesdk.interactivity.service.model.c r19 = (com.bytedance.android.livesdk.interactivity.service.model.c) r18.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r19 == null) goto L40;
        if (r19.getWordAssociation() != 0) goto L29;
    L30:
        r4 = true;
    L31:
        if (r4 != true) goto L40;
        r2.b.k(new y1(r2));
        r2.b.p(new z1(r2));
        Disposable r110 = r2.k;
        if (r110 == null) goto L36;
        r110.dispose();
    L36:
        x62.c r111 = r2.j;
        if (r111 == null) goto L40;
        r2.k = r111.map(new a2(r2)).distinctUntilChanged(new b2(r2)).debounce(r2.e.longValue(), TimeUnit.MILLISECONDS).switchMap(new d2(r2)).map(e2.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new f2(r2), new h2(r2));
        goto L40
    L29:
        if (r19.getWordAssociation() != 1) goto L31;
    L40:
        Unit r112 = Unit.INSTANCE;
        this.b = r2;
        return r1;
    }
}
