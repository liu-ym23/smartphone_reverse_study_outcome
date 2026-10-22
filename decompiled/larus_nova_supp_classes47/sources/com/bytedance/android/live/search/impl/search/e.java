package com.bytedance.android.live.search.impl.search;

import android.os.Bundle;
import android.util.Pair;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final String a;
    public int b;
    public String c;
    public FeedExtra d;
    public boolean e;
    public final CompositeDisposable f;
    public final qa1.a g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public a(e r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void accept(Object r13) {
            Pair r14 = (Pair) r13;
            if (r14 != null) goto L5;
            this.a.e = false;
            return;
        L5:
            this.a.d = (FeedExtra) r14.second;
            Object r1 = r14.first;
            if (r1 != null) goto L8;
        L47:
            this.a.e = false;
            return;
        L8:
            if (((List) r1).isEmpty() == true) goto L47;
            e r2 = this.a;
            List r3 = (List) r14.first;
            FeedExtra r15 = (FeedExtra) r14.second;
            r2.getClass();
            ra1.b r4 = null;
            if (r3.isEmpty() == true) goto L43;
            HashSet r5 = new HashSet();
            ArrayList r6 = new ArrayList();
            Iterator<T> r7 = r3.iterator();
        L15:
            if (r7.hasNext() == false) goto L42;
            FeedItem r8 = (FeedItem) r7.next();
            if (r8.getItem() == null) goto L50;
        L22:
            Item r9 = r8.getItem();
            if ((r9 instanceof Room) == true) goto L25;
            r9 = null;
        L25:
            Room r10 = (Room) r9;
            if (r10 == null) goto L15;
            r10.setIsFromRecommendCard(r8.isRecommendCard);
            r10.setLiveReason(r8.liveReason);
            Bundle r12 = ArgumentsBuilder.buildRoomArgs(r10);
            if (r12 != null) goto L31;
        L33:
            r5.add(Long.valueOf(r10.id));
            int r16 = ra1.a.d;
            Room r17 = r8.getItem();
            if (r17 == null) goto L41;
            Room r18 = r17;
            Intrinsics.checkNotNullParameter(r18, "_room");
            ra1.a r19 = new ra1.a();
            r19.c = r18;
            String r20 = r18.getRequestId();
            Intrinsics.checkNotNullParameter(r20, "<set-?>");
            r19.a = r20;
            r19.c(String.valueOf(r18.mGroupId));
            Room r22 = r19.b();
            if (r22 == null) goto L52;
            r22.setIsFromRecommendCard(true);
        L52:
            JsonObject r23 = (JsonObject) GsonHelper.get().fromJson(r18.getLog_pb(), JsonObject.class);     // Catch: Exception -> L49
            Intrinsics.checkNotNullParameter(r23, "<set-?>");     // Catch: Exception -> L49
            r19.b = r23;     // Catch: Exception -> L49
        L39:
            ra1.f r24 = new ra1.f();
            r24.b(r19);
            Unit r25 = Unit.INSTANCE;
            r6.add(r24);
            goto L15
        L41:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
        L31:
            if (r8.isPseudoLiving == false) goto L33;
            r12.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", true);
            goto L33
        L50:
            r8.setItem(r8.getRoom());     // Catch: Exception -> L20
            e.a(r8);     // Catch: Exception -> L20
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        L42:
            r4 = new ra1.b();
            r4.a = r15;
            r4.n(r6);
            r4.o(r15.getLogPb());
            r4.l(r15.maxTime);
            r4.m();
        L43:
            e r110 = this.a;
            r110.e = false;
            if (r4 == null) goto L46;
            r110.g.b(r4, this.b, this.c);
            return;
        L46:
            r110.g.a();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ boolean b;

        public b(e r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.e = false;
            r4.printStackTrace();
            this.a.g.c(r4, this.b);
        }
    }

    public e(h.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.g = r2;
        this.a = "https://" + jc1.k.n(IHostNetwork.class).getHostDomain() + "/webcast/feed/?content_type=0&channel_id=%d&hidden_banner=true";
        this.b = 21;
        this.c = "live_merge-live_cover";
        this.f = new CompositeDisposable();
    }

    public static void a(FeedItem r3) {
        int r0 = r3.type;
        if (r0 == 1) goto L7;
        if (r0 == 2) goto L7;
        return;
    L7:
        if ((r3.getItem() instanceof Room) == false) goto L20;
        Room r1 = r3.getItem();
        if (r1 == null) goto L18;
        Room r2 = r1;
        r2.setLog_pb(r3.logPb);
        IBaseUser r4 = r2.getOwnerKt();
        if (r4 == null) goto L16;
        String r5 = r3.logPb;
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r4.setLogPb(r5);
    L16:
        r2.setRequestId(r3.resId);
        r2.setIsFromRecommendCard(r3.isRecommendCard);
        r2.setLiveReason(r3.liveReason);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
    }

    public final void b(boolean r20, String r22) {
        Intrinsics.checkNotNullParameter(r22, "keyWord");
        if (r20 == true) goto L5;
        this.d = null;
    L5:
        FeedExtra r3 = this.d;
        if (r3 == null) goto L11;
        if (((Extra) r3).hasMore == true) goto L11;
        return;
    L11:
        if (this.e == false) goto L14;
        return;
    L14:
        if (r3 == null) goto L16;
        long r10 = r3.maxTime;
    L17:
        if (r3 == null) goto L19;
        long r6 = r3.maxTime;
    L21:
        if (r6 != 0) goto L23;
        String r4 = "live_search_refresh";
    L24:
        String r12 = r4;
        String r5 = this.c;
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        Observable r8 = ((FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class)).feed(String.format(this.a, Arrays.copyOf(new Object[]{Integer.valueOf(this.b)}, 1)), r10, r12, 0, -1, "-1", r5).map(c.a).doOnNext(new d(this));
        this.e = true;
        this.f.add(r8.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r20, r22), new b(this, r20)));
        return;
    L23:
        r4 = "live_search_loadmore";
        goto L24
    L19:
        r6 = 0;
        goto L21
    L16:
        r10 = 0;
        goto L17
    }
}
