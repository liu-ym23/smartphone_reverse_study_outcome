package com.larus.video.impl.douyin;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.SearchLoadMoreResult;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.utils.z;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0083\u0001\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132a\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 J\u0085\u0001\u0010!\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132a\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 H\u0002J\u0085\u0001\u0010\"\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132a\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 H\u0002J\u0085\u0001\u0010#\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132a\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 H\u0002J}\u0010$\u001a\u00020%2a\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 H\u0002J\u0085\u0001\u0010&\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u00132a\u0010\u0014\u001a]\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006("}, d2 = {"Lcom/larus/video/impl/douyin/DouYinActivityVideoModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "loadMoreParamsFromVideoSource", "Lcom/larus/video/impl/douyin/LoadMoreParamsFromVideoSource;", "poiFeedSupport", "Lcom/larus/video/impl/douyin/poi/PoiFeedSupportImpl;", "onCleared", NameKeys.UnloadStrategy_No_Strategy, "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "updateLoadMoreParamsFromVideoSource", "mediaEntityContainer", "Lcom/larus/platform/uimodel/MediaEntityContainer;", "requestLoadMore", "douYinVideoDataManager", "Lcom/larus/video/impl/douyin/DouYinVideoDataManager;", "onSuccess", "Lkotlin/Function3;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "haveMore", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "itemIdList", NameKeys.UnloadStrategy_No_Strategy, "ext", "onFail", "Lkotlin/Function0;", "requestLoadMoreFromUnlimitedRecommend", "requestLoadMoreFromAwemeFeed", "requestLoadMoreFromPoiFeed", "requestLoadMoreFormVideoSource", "Lkotlinx/coroutines/Job;", "requestLoadMoreForSearchList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouYinActivityVideoModel extends ViewModel {
    public static final a Companion = null;
    public static final String LOAD_MORE_PATH_FOR_RECOMMEND = "/alice/media/video/recommend";
    public static final String LOAD_MORE_PATH_FOR_SEARCH = "/alice/media/card_search/";
    private static final String LOAD_MORE_PATH_FOR_VIDEO = "/alice/media/source/3";
    public static final int QUERY_TYPE_DOUYIN = 1;
    public static final String TAG = "DouYinActivityVideoModel";
    private final Gson gson;
    private x loadMoreParamsFromVideoSource;
    private final m2a.f poiFeedSupport;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.video.impl.douyin.DouYinActivityVideoModel$requestLoadMoreForSearchList$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.video.impl.douyin.DouYinActivityVideoModel$requestLoadMoreForSearchList$1", f = "DouYinActivityVideoModel.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DouYinVideoDataManager $douYinVideoDataManager;
        final /* synthetic */ Function0<Unit> $onFail;
        final /* synthetic */ Function3<Boolean, List<String>, Map<String, String>, Unit> $onSuccess;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(DouYinVideoDataManager r1, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r2, Function0<Unit> r3, Continuation<? super AnonymousClass1> r4) {
            this.$douYinVideoDataManager = r1;
            this.$onSuccess = r2;
            this.$onFail = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$douYinVideoDataManager, this.$onSuccess, this.$onFail, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r16);
            Object r1 = r16;
        L16:
            y r2 = (com.larus.network.http.a) r1;
            if ((r2 instanceof y) == false) goto L53;
            SearchLoadMoreResult r3 = (SearchLoadMoreResult) ((com.larus.network.http.a) r2).b;
            if (r3 == null) goto L25;
            ur9.a r4 = r3.getSearchResult();
            if (r4 == null) goto L25;
            ur9.a.b r5 = r4.a();
            if (r5 == null) goto L25;
            List r6 = r5.a();
        L26:
            if (r6 != null) goto L28;
            r6 = CollectionsKt.emptyList();
        L28:
            ArrayList r7 = new ArrayList();
            Iterator r8 = r6.iterator();
        L30:
            if (r8.hasNext() == false) goto L37;
            MediaEntity r9 = (MediaEntity) r8.next();
            if (r9 == null) goto L34;
            String r10 = r9.getItem_id();
        L35:
            if (r10 == null) goto L30;
            r7.add(r10);
            goto L30
        L34:
            r10 = null;
            goto L35
        L37:
            MediaEntityContainer r11 = this.$douYinVideoDataManager.C;
            if (r11 == null) goto L45;
            if (r3 == null) goto L43;
            JsonObject r12 = r3.getQueryParams();
            if (r12 == null) goto L43;
            String r14 = r12.toString();
        L44:
            r11.setQueryParams(r14);
        L43:
            r14 = null;
        L45:
            Function3<Boolean, List<String>, Map<String, String>, Unit> r15 = this.$onSuccess;
            if (r3 == null) goto L50;
            Boolean r17 = r3.getHasMore();
            if (r17 == null) goto L50;
            boolean r18 = r17.booleanValue();
        L51:
            r15.invoke(Boxing.boxBoolean(r18), r7, null);
        L58:
            return Unit.INSTANCE;
        L50:
            r18 = false;
        L25:
            r6 = null;
            goto L26
        L53:
            if ((r2 instanceof com.larus.network.http.f) == false) goto L58;
            Function0<Unit> r19 = this.$onFail;
            if (r19 == null) goto L58;
            r19.invoke();
            goto L58
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r16);
            MediaEntityContainer r20 = this.$douYinVideoDataManager.C;
            if (r20 == null) goto L60;
            String r21 = r20.getQueryParams();
            if (r21 == null) goto L60;
            JSONObject r22 = new JSONObject();
            r22.put("query_type", 1);
            r22.put("query_params", z.b(r21));
            Unit r23 = Unit.INSTANCE;
            this.label = 1;
            r1 = HttpExtKt.k("Basic", SearchLoadMoreResult.class, DouYinActivityVideoModel.LOAD_MORE_PATH_FOR_SEARCH, r22, null, null, false, null, null, null, this, 1008);
            if (r1 != r13) goto L16;
            return r13;
        L60:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.video.impl.douyin.DouYinActivityVideoModel$requestLoadMoreFormVideoSource$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.video.impl.douyin.DouYinActivityVideoModel$requestLoadMoreFormVideoSource$1", f = "DouYinActivityVideoModel.kt", i = {0}, l = {187}, m = "invokeSuspend", n = {"loadMoreParamsFromVideoSource"}, s = {"L$0"})
    public static final class C01251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onFail;
        final /* synthetic */ Function3<Boolean, List<String>, Map<String, String>, Unit> $onSuccess;
        Object L$0;
        int label;
        final /* synthetic */ DouYinActivityVideoModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C01251(DouYinActivityVideoModel r1, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r2, Function0<Unit> r3, Continuation<? super C01251> r4) {
            this.this$0 = r1;
            this.$onSuccess = r2;
            this.$onFail = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01251(this.this$0, this.$onSuccess, this.$onFail, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            x r2 = (x) this.L$0;
            ResultKt.throwOnFailure(r14);
        L16:
            y r15 = (com.larus.network.http.a) r14;
            if ((r15 instanceof y) == false) goto L41;
            MediaEntityContainer r16 = (MediaEntityContainer) ((com.larus.network.http.a) r15).b;
            if (r16 == null) goto L22;
            r2.c = r16.getHas_more();
            r2.e = r16.getLimit();
            r2.d = r16.getOffset();
            r2.b = r16.getQuery();
            r2.a = r16.getSearch_id();
        L22:
            if (r16 == null) goto L34;
            ArrayList r3 = r16.mediaList();
            if (r3 == null) goto L34;
            Object r4 = new ArrayList();
            Iterator r5 = r3.iterator();
        L27:
            if (r5.hasNext() == false) goto L35;
            MediaEntity r6 = (MediaEntity) r5.next();
            if (r6 == null) goto L31;
            String r7 = r6.getItem_id();
        L32:
            if (r7 == null) goto L27;
            r4.add(r7);
            goto L27
        L31:
            r7 = null;
        L35:
            Function3<Boolean, List<String>, Map<String, String>, Unit> r8 = this.$onSuccess;
            if (r16 == null) goto L38;
            boolean r17 = r16.getHas_more();
        L39:
            r8.invoke(Boxing.boxBoolean(r17), r4, null);
        L46:
            return Unit.INSTANCE;
        L38:
            r17 = false;
        L34:
            r4 = CollectionsKt.emptyList();
            goto L35
        L41:
            if ((r15 instanceof com.larus.network.http.f) == false) goto L46;
            Function0<Unit> r18 = this.$onFail;
            if (r18 == null) goto L46;
            r18.invoke();
            goto L46
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            x r19 = DouYinActivityVideoModel.access$getLoadMoreParamsFromVideoSource$p(this.this$0);
            if (r19 == null) goto L11;
            JSONObject r9 = new JSONObject();
            r9.put("query", r19.b);
            r9.put("limit", r19.e);
            r9.put("offset", r19.d);
            r9.put("has_more", r19.c);
            r9.put("search_id", r19.a);
            Unit r10 = Unit.INSTANCE;
            this.L$0 = r19;
            this.label = 1;
            Object r11 = HttpExtKt.k("Basic", MediaEntityContainer.class, DouYinActivityVideoModel.LOAD_MORE_PATH_FOR_VIDEO, r9, null, null, false, null, null, null, this, 1008);
            if (r11 != r0) goto L15;
            return r0;
        L15:
            r2 = r19;
            r14 = r11;
            goto L16
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.video.impl.douyin.DouYinActivityVideoModel$requestLoadMoreFromAwemeFeed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.video.impl.douyin.DouYinActivityVideoModel$requestLoadMoreFromAwemeFeed$1", f = "DouYinActivityVideoModel.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DouYinVideoDataManager $douYinVideoDataManager;
        final /* synthetic */ Function0<Unit> $onFail;
        final /* synthetic */ Function3<Boolean, List<String>, Map<String, String>, Unit> $onSuccess;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C01261(DouYinVideoDataManager r1, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r2, Function0<Unit> r3, Continuation<? super C01261> r4) {
            this.$douYinVideoDataManager = r1;
            this.$onSuccess = r2;
            this.$onFail = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01261(this.$douYinVideoDataManager, this.$onSuccess, this.$onFail, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList] */
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L25:
            RecommendVideoData r16 = (RecommendVideoData) r15;
            if (r16 == null) goto L37;
            this.$douYinVideoDataManager.W++;
            Function3<Boolean, List<String>, Map<String, String>, Unit> r2 = this.$onSuccess;
            Boolean r3 = Boxing.boxBoolean(r16.getHasMore());
            List r17 = r16.getItemLists();
            if (r17 == null) goto L35;
            Object r4 = new ArrayList();
            Iterator r18 = r17.iterator();
        L31:
            if (r18.hasNext() == false) goto L36;
            String r5 = ((Content) r18.next()).getItemId();
            if (r5 == null) goto L31;
            r4.add(r5);
        L36:
            Unit r19 = (Unit) r2.invoke(r3, r4, null);
        L41:
            return Unit.INSTANCE;
        L35:
            r4 = CollectionsKt.emptyList();
            goto L36
        L37:
            Function0<Unit> r110 = this.$onFail;
            if (r110 == null) goto L41;
            r110.invoke();
            goto L41
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            ArrayList<MediaEntity> r111 = this.$douYinVideoDataManager.L;
            if (r111 == null) goto L21;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator<T> r112 = r111.iterator();
        L12:
            if (r112.hasNext() == false) goto L20;
            MediaEntity r7 = (MediaEntity) r112.next();
            if (r7 == null) goto L16;
            String r8 = r7.getItem_id();
        L17:
            if (r8 != null) goto L19;
            r8 = NameKeys.UnloadStrategy_No_Strategy;
        L19:
            r6.add(r8);
            goto L12
        L16:
            r8 = null;
            goto L17
        L20:
            String r9 = (String) CollectionsKt.firstOrNull(r6);
        L22:
            RecommendVideoApi r113 = RecommendVideoApi.a;
            SortScene r10 = SortScene.InnerStream;
            SortRequestType r11 = SortRequestType.UserLoadMore;
            int r12 = this.$douYinVideoDataManager.W;
            this.label = 1;
            r15 = RecommendVideoApi.b(r10, r11, r12, null, null, r9, null, null, this, SpeechEvent.SERVER_DOWNLINK_EVENT_BOT_TRIGGERED);
            if (r15 != r0) goto L25;
            return r0;
        L21:
            r9 = null;
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.larus.video.impl.douyin.DouYinActivityVideoModel$requestLoadMoreFromUnlimitedRecommend$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.video.impl.douyin.DouYinActivityVideoModel$requestLoadMoreFromUnlimitedRecommend$1", f = "DouYinActivityVideoModel.kt", i = {}, l = {SpeechEvent.SERVER_UPLINK_EVENT_TRIGGER_BOT, 106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DouYinVideoDataManager $douYinVideoDataManager;
        final /* synthetic */ Function0<Unit> $onFail;
        final /* synthetic */ Function3<Boolean, List<String>, Map<String, String>, Unit> $onSuccess;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C01271(DouYinVideoDataManager r1, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r2, Function0<Unit> r3, Continuation<? super C01271> r4) {
            this.$douYinVideoDataManager = r1;
            this.$onSuccess = r2;
            this.$onFail = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01271(this.$douYinVideoDataManager, this.$onSuccess, this.$onFail, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            Map<String, String> r15 = null;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r19);
            Object r1 = r19;
        L17:
            y r2 = (com.larus.network.http.a) r1;
            if ((r2 instanceof y) == false) goto L34;
            RecommendVideos r3 = (RecommendVideos) ((com.larus.network.http.a) r2).b;
            this.$douYinVideoDataManager.W++;
            if (r3 == null) goto L23;
            final List<String> r4 = r3.getItemIds();
            if (r4 == null) goto L23;
        L24:
            if (r3 == null) goto L26;
            r15 = r3.getExt();
        L26:
            ((ArrayList) this.$douYinVideoDataManager.X).addAll(r4);
            Function3<Boolean, List<String>, Map<String, String>, Unit> r5 = this.$onSuccess;
            if (r3 == null) goto L29;
            boolean r6 = r3.getHasMore();
        L30:
            r5.invoke(Boxing.boxBoolean(r6), r4, r15);
            if (this.$douYinVideoDataManager.S == false) goto L39;
            t0.a(new c(r4));
        L39:
            return Unit.INSTANCE;
        L29:
            r6 = false;
        L23:
            r4 = CollectionsKt.emptyList();
            goto L24
        L34:
            if ((r2 instanceof com.larus.network.http.f) == false) goto L39;
            Function0<Unit> r7 = this.$onFail;
            if (r7 == null) goto L39;
            r7.invoke();
            goto L39
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            String r8 = (String) this.L$2;
            Class r9 = (Class) this.L$1;
            String r10 = (String) this.L$0;
            ResultKt.throwOnFailure(r19);
            String r11 = r8;
            String r12 = r10;
            Class r14 = r9;
            Object r16 = r19;
        L14:
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            r1 = HttpExtKt.k(r12, r14, r11, (JSONObject) r16, null, null, false, null, null, null, this, 1008);
            if (r1 != r13) goto L17;
            return r13;
        L10:
            ResultKt.throwOnFailure(r19);
            DouYinVideoDataManager r17 = this.$douYinVideoDataManager;
            this.L$0 = "Basic";
            this.L$1 = RecommendVideos.class;
            r11 = DouYinActivityVideoModel.LOAD_MORE_PATH_FOR_RECOMMEND;
            this.L$2 = DouYinActivityVideoModel.LOAD_MORE_PATH_FOR_RECOMMEND;
            this.label = 1;
            r16 = r17.a(this);
            if (r16 != r13) goto L13;
            return r13;
        L13:
            r14 = RecommendVideos.class;
            r12 = "Basic";
            goto L14
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(Function3 r0, boolean r1, List r2) {
        return requestLoadMoreFromPoiFeed$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit yo(Function0 r0) {
        return requestLoadMoreFromPoiFeed$lambda$2(r0);
    }

    public DouYinActivityVideoModel() {
        this.poiFeedSupport = new m2a.f();
        this.gson = new Gson();
    }

    public void onCleared() {
        super.onCleared();
        this.poiFeedSupport.a.clear();
    }

    public final Gson getGson() {
        return this.gson;
    }

    public static final /* synthetic */ x access$getLoadMoreParamsFromVideoSource$p(DouYinActivityVideoModel r0) {
        return r0.loadMoreParamsFromVideoSource;
    }

    private static final Unit requestLoadMoreFromPoiFeed$lambda$2(Function0 r0) {
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        return Unit.INSTANCE;
    }

    public final void updateLoadMoreParamsFromVideoSource(MediaEntityContainer r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        x r0 = new x(0);
        r0.c = r3.getHas_more();
        r0.d = r3.getOffset();
        r0.e = r3.getLimit();
        r0.b = r3.getQuery();
        r0.a = r3.getSearch_id();
        this.loadMoreParamsFromVideoSource = r0;
    }

    private final Job requestLoadMoreFormVideoSource(Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r7, Function0<Unit> r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01251(this, r7, r8, null), 3, null);
    }

    private final Job requestLoadMoreForSearchList(DouYinVideoDataManager r7, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r8, Function0<Unit> r9) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r7, r8, r9, null), 3, null);
    }

    private final void requestLoadMoreFromAwemeFeed(DouYinVideoDataManager r7, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r8, Function0<Unit> r9) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01261(r7, r8, r9, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [m2a.b] */
    /* JADX WARN: Type inference failed for: r0v4, types: [m2a.d] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.video.impl.douyin.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.video.impl.douyin.b, java.lang.Object] */
    private final void requestLoadMoreFromPoiFeed(DouYinVideoDataManager r4, final Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r5, final Function0<Unit> r6) {
        m2a.f r0 = this.poiFeedSupport;
        String r7 = r4.U;
        final ?? r1 = new com.larus.video.impl.douyin.a(r5);
        final ?? r8 = new b(r6);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "onSuccess");
        Intrinsics.checkNotNullParameter(r8, "onFail");
        ConcurrentHashMap r9 = cy6.c.a;
        if (r7 != null) goto L5;
        String r10 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        Intrinsics.checkNotNullParameter(r10, "token");
        cy6.a r11 = (cy6.a) cy6.c.a.get(r10);
        if (r11 != null) goto L9;
        FLogger.a.e("PoiFeedSupportImpl", "loadMore: provider null, token=" + r7);
        r8.invoke();
        return;
    L9:
        CompositeDisposable r12 = r0.a;
        Single r13 = r11.a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final ?? r2 = new m2a.b(r1);
        Consumer r3 = new m2a.c(r2);
        final ?? r14 = new m2a.d(r8);
        r12.add(r13.subscribe(r3, new m2a.e(r14)));
        return;
    L5:
        r10 = r7;
        goto L6
    }

    private static final Unit requestLoadMoreFromPoiFeed$lambda$1(Function3 r1, boolean r2, List r3) {
        Intrinsics.checkNotNullParameter(r3, "itemIds");
        r1.invoke(Boolean.valueOf(r2), r3, null);
        return Unit.INSTANCE;
    }

    private final void requestLoadMoreFromUnlimitedRecommend(DouYinVideoDataManager r7, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r8, Function0<Unit> r9) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01271(r7, r8, r9, null), 3, null);
    }

    public final void requestLoadMore(DouYinVideoDataManager r3, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "douYinVideoDataManager");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        VideoParam.RecommendType r0 = r3.M;
        if (r0 != VideoParam.RecommendType.PoiFeed) goto L7;
        requestLoadMoreFromPoiFeed(r3, r4, r5);
        return;
    L7:
        if (r0 != VideoParam.RecommendType.Search) goto L11;
        requestLoadMoreFromUnlimitedRecommend(r3, r4, r5);
        return;
    L11:
        if (r0 != VideoParam.RecommendType.AwemeFeed) goto L14;
        requestLoadMoreFromAwemeFeed(r3, r4, r5);
        return;
    L14:
        MediaEntityContainer r1 = r3.C;
        if (r1 == null) goto L17;
        String r2 = r1.getQueryParams();
    L18:
        if (r2 == null) goto L21;
        requestLoadMoreForSearchList(r3, r4, r5);
        return;
    L21:
        requestLoadMoreFormVideoSource(r4, r5);
        return;
    L17:
        r2 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job requestLoadMoreFormVideoSource$default(DouYinActivityVideoModel r0, Function3 r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.requestLoadMoreFormVideoSource(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestLoadMore$default(DouYinActivityVideoModel r0, DouYinVideoDataManager r1, Function3 r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.requestLoadMore(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job requestLoadMoreForSearchList$default(DouYinActivityVideoModel r0, DouYinVideoDataManager r1, Function3 r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.requestLoadMoreForSearchList(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestLoadMoreFromAwemeFeed$default(DouYinActivityVideoModel r0, DouYinVideoDataManager r1, Function3 r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.requestLoadMoreFromAwemeFeed(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestLoadMoreFromPoiFeed$default(DouYinActivityVideoModel r0, DouYinVideoDataManager r1, Function3 r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.requestLoadMoreFromPoiFeed(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestLoadMoreFromUnlimitedRecommend$default(DouYinActivityVideoModel r0, DouYinVideoDataManager r1, Function3 r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.requestLoadMoreFromUnlimitedRecommend(r1, r2, r3);
    }
}
