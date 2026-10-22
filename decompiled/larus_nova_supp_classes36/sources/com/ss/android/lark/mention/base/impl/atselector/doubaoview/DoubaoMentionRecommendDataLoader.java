package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.pb.graph.ChatterMeta;
import com.ss.android.lark.pb.graph.PullClosestChattersResponse;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoMentionRecommendDataLoader {
    public final Function1<Continuation<? super Result<PullClosestChattersResponse>>, Object> a;

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecommendDataLoader$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Continuation<? super Result<? extends PullClosestChattersResponse>>, Object>, SuspendFunction {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1, g.class, "requestClosestChatters", "requestClosestChatters(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return m1423invokeIoAF18A((Continuation) r1);
        }

        /* JADX INFO: renamed from: invoke-IoAF18A, reason: not valid java name */
        public final Object m1423invokeIoAF18A(Continuation<? super Result<PullClosestChattersResponse>> r2) {
            Object r3 = g.a(r2);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Result.box-impl(r3);
        }
    }

    public static final class a {
    }

    static {
    }

    public DoubaoMentionRecommendDataLoader() {
        this(null);
    }

    public DoubaoMentionRecommendDataLoader(Object r2) {
        AnonymousClass1 r3 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "closestChatterRequester");
        this.a = r3;
    }

    public static SearchBean c(ChatterMeta r23) {
        String r1 = r23.mavatar_key;
        if (r1 != null) goto L5;
        String r5 = "";
    L6:
        String r3 = r23.mid;
        if (r3 != null) goto L9;
        String r4 = "";
    L10:
        String r6 = r23.mname;
        if (r6 != null) goto L13;
        String r7 = "";
    L14:
        String r0 = r23.mdefaultDepartmentName;
        if (r0 != null) goto L17;
        String r8 = "";
    L19:
        return new SearchBean(new com.ss.android.lark.mention.base.impl.atselector.bean.a(r4, r5, r7, r8, CollectionsKt.emptyList(), CollectionsKt.emptyList(), Chatter.ChatterType.USER, new ChatterDescription(), true, "#", null, 0, false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, false, false));
    L17:
        r8 = r0;
        goto L19
    L13:
        r7 = r6;
        goto L14
    L9:
        r4 = r3;
        goto L10
    L5:
        r5 = r1;
        goto L6
    }

    public final Object a(Continuation<? super Result<? extends List<? extends BaseAtBean>>> r7) {
        if ((r7 instanceof DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1) == false) goto L7;
        DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1 r0 = (DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1) r7;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        DoubaoMentionRecommendDataLoader r4 = (DoubaoMentionRecommendDataLoader) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L33
    L21:
        Object r9 = ((Result) r8).unbox-impl();     // Catch: Throwable -> L33
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L33
        PullClosestChattersResponse r10 = (PullClosestChattersResponse) r9;     // Catch: Throwable -> L33
        if (r10 == null) goto L24;
        List r11 = r10.mchatters;     // Catch: Throwable -> L33
    L25:
        if (r11 != null) goto L27;
        r11 = CollectionsKt.emptyList();     // Catch: Throwable -> L33
    L27:
        List r5 = r11;     // Catch: Throwable -> L33
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));     // Catch: Throwable -> L33
        Iterator r12 = r5.iterator();     // Catch: Throwable -> L33
    L29:
        if (r12.hasNext() == false) goto L31;
        ChatterMeta r13 = (ChatterMeta) r12.next();     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L33
        r4.getClass();     // Catch: Throwable -> L33
        r6.add(c(r13));     // Catch: Throwable -> L33
        goto L29
    L31:
        List r14 = CollectionsKt.take(r6, 10);     // Catch: Throwable -> L33
        Log.i("DoubaoMentionRecommendDataLoader", "load closest chatters count=" + r11.size() + ", result count=" + r14.size());     // Catch: Throwable -> L33
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L33
    L35:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 != null) goto L38;
    L41:
        return r15;
    L38:
        if ((r16 instanceof CancellationException) == true) goto L40;
        Log.e("DoubaoMentionRecommendDataLoader", "load closest chatters failed", r16);
        goto L41
    L40:
        throw r16;
    L24:
        r11 = null;
        goto L25
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L33
        Function1<Continuation<? super Result<PullClosestChattersResponse>>, Object> r18 = this.a;     // Catch: Throwable -> L33
        r0.L$0 = this;     // Catch: Throwable -> L33
        r0.label = 1;     // Catch: Throwable -> L33
        r8 = r18.invoke(r0);     // Catch: Throwable -> L33
        if (r8 != r2) goto L20;
        return r2;
    L20:
        r4 = this;
    L33:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1(this, r7);
        goto L8
    }

    public final Object b(String r34, String r35, Continuation<? super Result<? extends List<? extends BaseAtBean>>> r36) {
        String r1 = r35;
        if ((r36 instanceof DoubaoMentionRecommendDataLoader$search$1) == false) goto L7;
        DoubaoMentionRecommendDataLoader$search$1 r2 = (DoubaoMentionRecommendDataLoader$search$1) r36;
        int r3 = r2.label;
        if ((r3 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r2.label = r3 - Target.SIZE_ORIGINAL;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L15;
        r1 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L22
    L20:
        Object r6 = Result.constructor-impl((SearchResponse) r0);     // Catch: Throwable -> L22
    L24:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 != null) goto L75;
        List r8 = ((SearchResponse) r6).getInfoList();
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L28:
        if (r10.hasNext() == false) goto L32;
        Object r11 = r10.next();
        if ((r11 instanceof SearchChatterInfo) == false) goto L28;
        r9.add(r11);
        goto L28
    L32:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r13 = r9.iterator();
    L34:
        if (r13.hasNext() == false) goto L68;
        SearchChatterInfo r14 = (SearchChatterInfo) r13.next();
        String r15 = r14.getId();
        if (r15 != null) goto L38;
        String r16 = "";
    L39:
        r14.getAvatarKey();
        String r17 = r14.getAvatarKey();
        if (r17 != null) goto L42;
        String r18 = "";
    L43:
        String r19 = r14.getTitle();
        if (r19 != null) goto L46;
        String r110 = "";
    L47:
        String r111 = r14.getSubTitle();
        if (r111 != null) goto L50;
        String r112 = "";
    L51:
        List r113 = r14.getTitleHitTerms();
        if (r113 != null) goto L54;
        r113 = CollectionsKt.emptyList();
    L54:
        List r114 = r113;
        List r115 = r14.getSubTitleHitTerms();
        if (r115 != null) goto L57;
        r115 = CollectionsKt.emptyList();
    L57:
        List r116 = r115;
        Chatter.ChatterType r117 = r14.getChatterType();
        if (r117 != null) goto L60;
        r117 = Chatter.ChatterType.USER;
    L60:
        Chatter.ChatterType r118 = r117;
        ChatterDescription r119 = r14.getChatterDescription();
        if (r119 != null) goto L63;
        r119 = new ChatterDescription();
    L63:
        ChatterDescription r20 = r119;
        boolean r21 = r14.isRegistered();
        boolean r22 = r14.isResigned();
        WorkStatus r24 = r14.getWorkStatus();
        long r25 = r14.getZenModeEndTime();
        boolean r27 = r14.isCrossTenant();
        List r28 = CollectionsKt.emptyList();
        List r29 = r14.getStatusList();
        TagData r31 = r14.getTagData();
        if (r14.getChatterType() != Chatter.ChatterType.BOT) goto L66;
        boolean r32 = true;
    L67:
        String r120 = r16;
        String r121 = r18;
        String r122 = r110;
        String r123 = r112;
        boolean r210 = r32;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r124 = new com.ss.android.lark.mention.base.impl.atselector.bean.a(r120, r121, r122, r123, r114, r116, r118, r20, r21, r22, "#", r24, r25, r27, r28, r29, r31, r210, r14.isAgent());
        r14.getBotExtType();
        r12.add(new SearchBean(r124));
        goto L34
    L66:
        r32 = false;
        goto L67
    L50:
        r112 = r111;
        goto L51
    L46:
        r110 = r19;
        goto L47
    L42:
        r18 = r17;
        goto L43
    L38:
        r16 = r15;
        goto L39
    L68:
        List r23 = CollectionsKt.take(r12, 10);
        StringBuilder r26 = new StringBuilder("search people count=");
        r26.append(r9.size());
        r26.append(", result count=");
        r26.append(r23.size());
        r26.append(", keyword empty=");
        if (r1.length() != 0) goto L71;
        boolean r30 = true;
    L72:
        r26.append(r30);
        Log.i("DoubaoMentionRecommendDataLoader", r26.toString());
        return Result.constructor-impl(r23);
    L71:
        r30 = false;
        goto L72
    L75:
        if ((r7 instanceof CancellationException) == true) goto L82;
        StringBuilder r33 = new StringBuilder("search failed, keyword empty=");
        if (r1.length() != 0) goto L79;
        boolean r37 = true;
    L80:
        r33.append(r37);
        Log.e("DoubaoMentionRecommendDataLoader", r33.toString(), r7);
        return Result.constructor-impl(ResultKt.createFailure(r7));
    L79:
        r37 = false;
        goto L80
    L82:
        throw r7;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
        SearcherConfig r38 = new SearcherConfig(new Permissions(CollectionsKt.emptyList()));
        SearcherConfig.chatter$default(r38, false, DoubaoMentionRecommendDataLoader$search$config$1$1.INSTANCE, 1, null);
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L22
        CoroutineDispatcher r40 = Dispatchers.getIO();     // Catch: Throwable -> L22
        DoubaoMentionRecommendDataLoader$search$searchResponse$1$1 r41 = new DoubaoMentionRecommendDataLoader$search$searchResponse$1$1(r34, r1, r38, null);     // Catch: Throwable -> L22
        r2.L$0 = r1;     // Catch: Throwable -> L22
        r2.label = 1;     // Catch: Throwable -> L22
        r0 = BuildersKt.withContext(r40, r41, r2);     // Catch: Throwable -> L22
        if (r0 != r4) goto L20;
        return r4;
    L22:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoubaoMentionRecommendDataLoader$search$1(this, r36);
        goto L8
    }
}
