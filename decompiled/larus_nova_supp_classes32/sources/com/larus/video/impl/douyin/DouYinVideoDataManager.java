package com.larus.video.impl.douyin;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.o0;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class DouYinVideoDataManager {
    public String A;
    public final Set<String> B;
    public MediaEntityContainer C;
    public String D;
    public String E;
    public final Map<String, String> F;
    public final Map<String, String> G;
    public String H;
    public String I;
    public String J;
    public String K;
    public ArrayList<MediaEntity> L;
    public VideoParam.RecommendType M;
    public boolean N;
    public boolean O;
    public PrefetchRecommendVideoParam P;
    public FirstFramePreloadVideoData Q;
    public ArrayList<String> R;
    public boolean S;
    public JSONObject T;
    public String U;
    public JSONObject V;
    public int W;
    public final List<String> X;
    public ArrayList<String> a;
    public String b;
    public String c;
    public int d;
    public List<String> e;
    public int f;
    public long g;
    public boolean h;
    public boolean i;
    public String j;
    public String k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String p;
    public Integer q;
    public Integer r;
    public Integer s;
    public String t;
    public boolean u;
    public final ConcurrentHashMap<String, Integer> v;
    public final Lazy w;
    public boolean x;
    public String y;
    public String z;

    public static final class a {
    }

    static {
    }

    public DouYinVideoDataManager() {
        this.f = -1;
        this.j = NameKeys.UnloadStrategy_No_Strategy;
        this.k = NameKeys.UnloadStrategy_No_Strategy;
        this.l = 10;
        this.m = 10;
        this.v = new ConcurrentHashMap();
        this.w = LazyKt.lazy(new o());
        this.x = true;
        this.y = NameKeys.UnloadStrategy_No_Strategy;
        this.B = new LinkedHashSet();
        this.F = new LinkedHashMap();
        this.G = new LinkedHashMap();
        this.M = VideoParam.RecommendType.Non;
        this.O = true;
        this.W = 1;
        this.X = new ArrayList();
    }

    public final Object a(Continuation<? super JSONObject> r12) {
        if ((r12 instanceof DouYinVideoDataManager$generateRecommendRequestParams$1) == false) goto L7;
        DouYinVideoDataManager$generateRecommendRequestParams$1 r0 = (DouYinVideoDataManager$generateRecommendRequestParams$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r5 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L42:
        Message r14 = (Message) r13;
        if (r14 == null) goto L45;
        String r15 = r14.getReplyId();
    L46:
        if (r15 != null) goto L48;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L48:
        ArrayList<MediaEntity> r4 = this.L;
        if (r4 == null) goto L60;
        ArrayList<String> r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r7 = r4.iterator();
    L52:
        if (r7.hasNext() == false) goto L61;
        MediaEntity r8 = (MediaEntity) r7.next();
        if (r8 == null) goto L56;
        String r9 = r8.getItem_id();
    L57:
        if (r9 != null) goto L59;
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L59:
        r6.add(r9);
        goto L52
    L56:
        r9 = null;
    L61:
        JSONObject r10 = new JSONObject();
        int r11 = this.d;
        if (r11 != 1) goto L65;
        r10.put("scene", r11);
        r10.put("query", new JSONArray(this.e));
        r10.put("reply_item_ids", new JSONArray(r6));
    L86:
        r10.put("page_index", this.W);
        r10.put("click_index", this.f);
        r10.put("playlist_item_ids", new JSONArray(this.X));
        String r16 = this.p;
        if (r16 == null) goto L89;
        r10.put("click_item_id", r16);
    L89:
        Integer r17 = this.r;
        if (r17 == null) goto L92;
        r10.put("stream_index", r17.intValue());
    L92:
        r10.put("playlist_playtime", new JSONObject(GsonProtectorUtils.toJson((Gson) this.w.getValue(), this.v)));
        return r10;
    L65:
        if (r11 != 2) goto L74;
        r10.put("scene", r11);
        r10.put("question_id", StringsKt.toLongOrNull(r15));
        String r18 = this.E;
        if (r18 == null) goto L69;
        Long r19 = StringsKt.toLongOrNull(r18);
    L70:
        r10.put("answer_id", r19);
        if (r6 == null) goto L73;
        r5 = (String) CollectionsKt.getOrNull(r6, this.f);
    L73:
        r10.put("reply_item_ids", new JSONArray(CollectionsKt.listOf(r5)));
        goto L86
    L69:
        r19 = null;
        goto L70
    L74:
        List<String> r20 = this.e;
        if (r20 != null) goto L77;
    L79:
        r10.put("question_id", StringsKt.toLongOrNull(r15));
        String r110 = this.E;
        if (r110 == null) goto L82;
        r5 = StringsKt.toLongOrNull(r110);
    L82:
        r10.put("answer_id", r5);
        ArrayList<String> r21 = this.R;
        if (r21 == null) goto L85;
        r6 = r21;
    L85:
        r10.put("reply_item_ids", new JSONArray(r6));
        goto L86
    L77:
        if ((true ^ r20.isEmpty()) == false) goto L79;
        r10.put("query", new JSONArray(r20));
        goto L79
    L60:
        r6 = null;
        goto L61
    L45:
        r15 = null;
        goto L46
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (o0.d(this.t) == false) goto L20;
        String r111 = this.t;
        if (r111 != null) goto L19;
        r111 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        List r112 = CollectionsKt.listOf(r111);
    L22:
        if (((ArrayList) this.X).isEmpty() == false) goto L34;
        ((ArrayList) this.X).addAll(r112);
        if (this.u == false) goto L34;
        List<String> r113 = this.X;
        FirstFramePreloadVideoData r22 = this.Q;
        if (r22 == null) goto L32;
        ArrayList r23 = r22.getPreLoadFirstRequestItemIdList();
        if (r23 == null) goto L32;
        List r24 = CollectionsKt.filterNotNull(r23);
        if (r24 == null) goto L32;
    L33:
        ((ArrayList) r113).addAll(r24);
    L32:
        r24 = CollectionsKt.emptyList();
    L34:
        r15 = this.z;
        if (r15 != null) goto L48;
        IChatRepoService r114 = RepoDispatcherDelegate.b.e();
        String r25 = this.E;
        if (r25 != null) goto L39;
        r25 = NameKeys.UnloadStrategy_No_Strategy;
    L39:
        r0.label = 1;
        r13 = r114.E1(r25, r0);
        if (r13 != r2) goto L42;
        return r2;
    L20:
        r112 = CollectionsKt.emptyList();
    L7:
        r0 = new DouYinVideoDataManager$generateRecommendRequestParams$1(this, r12);
        goto L8
    }
}
