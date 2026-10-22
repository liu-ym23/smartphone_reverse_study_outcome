package com.larus.bmhome.double_post.drag_panel;

import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.double_post.cache.AwemeDoublePostCacheManager;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostViewModel;
import com.larus.bmhome.double_post.fragment.e;
import com.larus.bmhome.double_post.fragment.t;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class n implements Function0 {
    public final /* synthetic */ ChatAwemeFeedComponent a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ List d;
    public final /* synthetic */ List e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ n(ChatAwemeFeedComponent r1, Message r2, Ref.ObjectRef r3, List r4, List r5, Ref.ObjectRef r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.larus.bmhome.double_post.fragment.o, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.double_post.fragment.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.ArrayList] */
    public final Object invoke() {
        ChatAwemeFeedComponent r2 = this.a;
        Message r3 = this.b;
        Ref.ObjectRef r0 = this.c;
        List r4 = this.d;
        List r5 = this.e;
        Ref.ObjectRef r6 = this.f;
        boolean r7 = this.g;
        AwemeDoublePostFragment r8 = r2.q;
        r8.t = r3;
        AwemeDoublePostViewModel r9 = r8.Z90();
        if (r3 == null) goto L5;
        String r11 = r3.getMessageId();
    L6:
        r9.setMessageId(r11);
        r8.Z90().setScene(r8.X90());
        AwemeDoublePostViewModel r10 = r8.Z90();
        Message r12 = r8.t;
        if (r12 != null) goto L9;
    L11:
        boolean r13 = false;
    L12:
        if (r13 == false) goto L14;
        String r14 = "AwemeFeed";
    L15:
        r10.setRecommendType(r14);
        AwemeDoublePostFragment r15 = r2.q;
        r15.u = (String) r0.element;
        r15.Z90().setReplyItemIdList(r4);
        r2.q.Z90().setLastItemIdList(r5);
        ChatAwemeFeedComponent.C3(r2, false, 6);
        AwemeDoublePostFragment r1 = r2.q;
        if (r1.p == false) goto L19;
        r1.o = true;
        r1.V90();
    L19:
        AwemeDoublePostFragment r16 = r2.q;
        String r17 = r3.getMessageId();
        String r18 = "";
        if (r17 != null) goto L22;
        r17 = "";
    L22:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "messageId");
        IFlowSdkDepend r19 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r19 == null) goto L36;
        r2 r20 = r19.A0();
        if (r20 == null) goto L36;
        String r21 = r20.f(r17);
        if (r21 == null) goto L36;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L30
        Object r23 = Result.constructor-impl((List) ((Gson) r16.v.getValue()).fromJson(r21, new t().getType()));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r23) == false) goto L35;
        r23 = null;
    L35:
        List r24 = (List) r23;
    L37:
        if (r24 == null) goto L49;
        Iterator r25 = r24.iterator();
    L40:
        if (r25.hasNext() == false) goto L49;
        Content r26 = (Content) r25.next();
        r26.setImprIndex(1);
        if (r16.X90() != SortScene.WelcomeBack) goto L45;
        String r110 = "wcb_feed";
    L48:
        r26.setBizTag(r110);
        goto L40
    L45:
        if (r16.X90() != SortScene.Recommend) goto L47;
        r110 = "chat_feed";
        goto L48
    L47:
        r110 = null;
    L49:
        r16.Z90().prefetchData(r24);
        IFlowSdkDepend r27 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r27 == null) goto L59;
        r2 r28 = r27.A0();
        if (r28 == null) goto L59;
        String r29 = r3.getMessageId();
        if (r29 != null) goto L57;
        r29 = "";
    L57:
        if (r28.i(r29) != true) goto L59;
        boolean r30 = true;
    L60:
        if (r30 == true) goto L63;
        r2.q.aa0(SortRequestType.UserPullRefresh, true);
    L101:
        return Unit.INSTANCE;
    L63:
        if (d.W(r3) == false) goto L85;
        IFlowSdkDepend r31 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r31 == null) goto L73;
        r2 r32 = r31.A0();
        if (r32 == null) goto L73;
        String r33 = r3.getMessageId();
        if (r33 == null) goto L72;
        r18 = r33;
    L72:
        r32.k(r18);
    L73:
        AwemeDoublePostFragment r34 = r2.q;
        List r35 = (List) r6.element;
        if (r35 == null) goto L83;
        List r36 = CollectionsKt.takeLast(r35, 10);
        if (r36 == null) goto L83;
        List r37 = CollectionsKt.take(r36, 8);
        if (r37 == null) goto L83;
        List r38 = r37;
        ?? r39 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
        Iterator r40 = r38.iterator();
    L81:
        if (r40.hasNext() == false) goto L84;
        r39.add(Content.copy$default((Content) r40.next(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 1, "wcb_feed", 32767, null));
    L84:
        r34.ba0(r39);
        AwemeDoublePostCacheManager r41 = AwemeDoublePostCacheManager.a;
        AwemeDoublePostCacheManager.d((List) r6.element, r3.getMessageId(), null);
    L83:
        r39 = CollectionsKt.emptyList();
        goto L84
    L85:
        IFlowSdkDepend r42 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r42 == null) goto L94;
        r2 r43 = r42.A0();
        if (r43 == null) goto L94;
        String r44 = r3.getMessageId();
        if (r44 == null) goto L93;
        r18 = r44;
    L93:
        r43.k(r18);
    L94:
        if (r7 == false) goto L96;
        r2.q.aa0(SortRequestType.UserPullRefresh, true);
        goto L101
    L96:
        final AwemeDoublePostFragment r45 = r2.q;
        final AwemeDoublePostFragment.a r46 = r45.z;
        final ?? r47 = new e(r45);
        r46.getClass();
        Intrinsics.checkNotNullParameter(r47, "onTimeout");
        r46.d = false;
        com.larus.bmhome.double_post.fragment.o r48 = r46.c;
        if (r48 == null) goto L99;
        r46.b.removeCallbacks(r48);
    L99:
        r46.d = true;
        ?? r49 = new com.larus.bmhome.double_post.fragment.o(r46, r47);
        r46.c = r49;
        r46.b.postDelayed(r49, r46.a);
    L59:
        r30 = false;
    L30:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        r24 = null;
        goto L37
    L14:
        r14 = "Search";
        goto L15
    L9:
        if (d.W(r12) != true) goto L11;
        r13 = true;
        goto L12
    L5:
        r11 = null;
        goto L6
    }
}
