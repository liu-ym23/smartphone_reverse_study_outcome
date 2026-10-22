package com.larus.bmhome.video;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.FeedItemConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.k;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qr9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RecommendVideoApi {
    public static final RecommendVideoApi a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final List<Content> d = null;
    public static final long e = 0;
    public static long f;
    public static final int g = 0;
    public static final int h = 0;
    public static final Lazy i = null;
    public static final ConcurrentHashMap<String, Integer> j = null;
    public static final List<Content> k = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SortRequestType.values().length];
            r0[SortRequestType.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[SortRequestType.PreLoad.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[SortRequestType.UserClickEnterPage.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[SortRequestType.UserSlideEnterPage.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[SortRequestType.LandingEnterPage.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[SortRequestType.UserLoadMore.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[SortRequestType.UserPullRefresh.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[SortRequestType.UserClickTabRefresh.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[SortRequestType.AutoRefresh.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    public RecommendVideoApi() {
    }

    static {
        a = new RecommendVideoApi();
        b = new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        Lazy r0 = b.a;
        e = ((long) z2.a.getAwemeVideoFeedConfig().j()) * 1000;
        AuthModelDelegate r1 = AuthModelDelegate.b;
        LaunchInfo r2 = (LaunchInfo) r1.x().getValue();
        if (r2 == null) goto L7;
        FeedItemConfig r3 = r2.F0();
        if (r3 == null) goto L7;
        int r4 = r3.c();
    L8:
        g = r4;
        LaunchInfo r5 = (LaunchInfo) r1.x().getValue();
        if (r5 == null) goto L13;
        FeedItemConfig r6 = r5.F0();
        if (r6 == null) goto L13;
        int r7 = r6.a();
    L14:
        h = r7;
        i = LazyKt.lazy(new f());
        j = new ConcurrentHashMap();
        k = new ArrayList();
        return;
    L13:
        r7 = 8;
    L7:
        r4 = 6;
        goto L8
    }

    public static void a() {
        FLogger.a.i("RecommendVideoApi", "exposePrefetchData");
        ((ArrayList) d).clear();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0080 -> B:27:0x0083). Please report as a decompilation issue!!! */
    public final Object c(SortScene r17, Continuation<? super List<Content>> r18) {
        if ((r18 instanceof RecommendVideoApi$prefetchData$1) == false) goto L7;
        RecommendVideoApi$prefetchData$1 r1 = (RecommendVideoApi$prefetchData$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
        RecommendVideoApi r3 = this;
    L8:
        Object r0 = r1.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r1.I$0;
        SortScene r8 = (SortScene) r1.L$0;
        ResultKt.throwOnFailure(r0);
        RecommendVideoApi r14 = r3;
    L27:
        RecommendVideoData r7 = (RecommendVideoData) r0;
        if (r7 == null) goto L30;
        List<Content> r9 = r7.getItemLists();
    L31:
        if (r9 != null) goto L33;
    L35:
        boolean r10 = false;
    L36:
        if (r10 == true) goto L44;
        if (r7 != null) goto L40;
    L42:
        boolean r11 = false;
    L43:
        if (r11 == true) goto L44;
        r6 = r6 + 1;
        SortScene r12 = r8;
        List<Content> r13 = r9;
    L22:
        if (r6 >= 4) goto L46;
        SortRequestType r15 = SortRequestType.PreLoad;
        int r16 = g;
        r1.L$0 = r12;
        r1.I$0 = r6;
        r1.label = 1;
        Object r19 = f(r14, r12, r15, r16, false, r1);
        if (r19 != r4) goto L26;
        return r4;
    L26:
        r8 = r12;
        r0 = r19;
    L46:
        if (r13 == null) goto L49;
        f = AppHost.a.getAppClock().currentTimeMillis();
        Boxing.boxBoolean(((ArrayList) d).addAll(r13));
    L49:
        if (r12 != SortScene.InnerStream) goto L51;
    L54:
        return r13;
    L51:
        if (((ArrayList) k).size() >= 2) goto L54;
        FLogger.a.i("RecommendVideoApi", "prefetchForInnerStream");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RecommendVideoApi$tryPrefetchInnerStreamData$1(null), 3, null);
        goto L54
    L40:
        if (r7.getHasMore() == true) goto L42;
        r11 = true;
    L44:
        r12 = r8;
        r13 = r9;
        goto L46
    L33:
        if ((!r9.isEmpty()) != true) goto L35;
        r10 = true;
        goto L36
    L30:
        r9 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        List<Content> r20 = d;
        if (((ArrayList) r20).isEmpty() == false) goto L17;
    L20:
        r12 = r17;
        r14 = r3;
        r13 = null;
        r6 = 0;
        goto L22
    L17:
        if ((AppHost.a.getAppClock().currentTimeMillis() - f) > e) goto L20;
        return r20;
    L7:
        r3 = this;
        r1 = new RecommendVideoApi$prefetchData$1(r3, r18);
        goto L8
    }

    public static void d(boolean r1, SortScene r2, SortRequestType r3, long r4, String r6) {
        if (r2 != SortScene.InnerStream) goto L6;
        return;
    L6:
        switch(a.a[r3.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        String r5 = "auto_request";
    L17:
        Integer r7 = Integer.valueOf(r1 ? 1 : 0);
        Long r8 = Long.valueOf(r4);
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r7 != null) goto L32;
    L20:
        r9.put("host_enter_from", "chat_feed_tab");     // Catch: JSONException -> L28
        if (r5 == null) goto L23;
        r9.put("click_from", r5);     // Catch: JSONException -> L28
    L23:
        if (r8 == null) goto L25;
        r9.put("duration", r8.longValue());     // Catch: JSONException -> L28
    L25:
        if (r6 == null) goto L30;
        r9.put("req_id", r6);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        FLogger.a.e("AwemeFeedEventHelper", "error in AwemeFeedEventHelper mobRefreshFeedResult " + e.getLocalizedMessage());
    L30:
        TrackParams r10 = new TrackParams().merge(r9);
        by7.a r11 = new by7.a("refresh_feed_result");
        r11.a.merge(r10);
        r11.b();
        return;
    L32:
        r9.put("success", r7.intValue());     // Catch: JSONException -> L28
        goto L20
    L10:
        r5 = "click_tab";
        goto L17
    L11:
        r5 = "slide_up";
        goto L17
    L12:
        r5 = "slide_down";
        goto L17
    L13:
        r5 = "landing";
        goto L17
    L14:
        r5 = "auto_request_more";
        goto L17
    L15:
        r5 = "preload";
        goto L17
    L16:
        r5 = null;
        goto L17
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object f(RecommendVideoApi r13, SortScene r14, SortRequestType r15, int r16, boolean r17, Continuation r18) {
        return r13.e(r14, r15, 1, r16, true, r17, null, null, null, null, null, r18);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public static Object b(SortScene r13, SortRequestType r14, int r15, List r16, List r17, String r18, String r19, String r20, Continuation r21, int r22) {
        RecommendVideoApi r1 = a;
        if ((r22 & 8) == 0) goto L5;
        List r7 = null;
    L7:
        if ((r22 & 16) == 0) goto L9;
        List r8 = null;
    L11:
        if ((r22 & 32) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r22 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r22 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if (r13 != SortScene.InnerStream) goto L25;
        int r0 = h;
    L27:
        return r1.e(r13, r14, r15, r0, true, false, r7, r8, r9, r10, r11, r21);
    L25:
        r0 = h + 2;
        goto L27
    L21:
        r11 = r20;
        goto L23
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public final Object e(SortScene r22, SortRequestType r23, int r24, int r25, boolean r26, boolean r27, List<String> r28, List<String> r29, String r30, String r31, String r32, Continuation<? super RecommendVideoData> r33) {
        if ((r33 instanceof RecommendVideoApi$requestRecommendVideo$1) == false) goto L7;
        RecommendVideoApi$requestRecommendVideo$1 r2 = (RecommendVideoApi$requestRecommendVideo$1) r33;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        RecommendVideoApi$requestRecommendVideo$1 r14 = r2;
        Object r1 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r14.J$0;
        boolean r0 = r14.Z$0;
        int r7 = r14.I$0;
        String r8 = (String) r14.L$3;
        String r9 = (String) r14.L$2;
        SortRequestType r10 = (SortRequestType) r14.L$1;
        SortScene r11 = (SortScene) r14.L$0;
        ResultKt.throwOnFailure(r1);
        long r19 = r6;
        Object r12 = r1;
        boolean r13 = r0;
    L28:
        y r15 = (com.larus.network.http.a) r12;
        long r16 = System.currentTimeMillis() - r19;
        if ((r15 instanceof y) == false) goto L52;
        RecommendVideoData r17 = (RecommendVideoData) ((com.larus.network.http.a) r15).b;
        FLogger r18 = FLogger.a;
        StringBuilder r110 = new StringBuilder("[");
        r110.append(r11);
        r110.append("] Request page.");
        r110.append(r7);
        r110.append(" recommend video success, return ");
        if (r17 == null) goto L42;
        List<Content> r111 = r17.getItemLists();
        if (r111 == null) goto L42;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r111.iterator();
    L36:
        if (r113.hasNext() == false) goto L41;
        String r20 = ((Content) r113.next()).getItemId();
        if (r20 == null) goto L36;
        r112.add(r20);
        goto L36
    L41:
        Integer r21 = Boxing.boxInt(r112.size());
    L43:
        r110.append(r21);
        r110.append(" data, hasMore: ");
        if (r17 == null) goto L46;
        Boolean r34 = Boxing.boxBoolean(r17.getHasMore());
    L47:
        r110.append(r34);
        r18.d("RecommendVideoApi", r110.toString());
        if (r17 == null) goto L50;
        String r35 = r17.getRequestId();
    L51:
        d(true, r11, r10, r16, r35);
    L60:
        if (r17 == null) goto L74;
        List<Content> r36 = r17.getItemLists();
        if (r36 == null) goto L74;
        Iterator<T> r37 = r36.iterator();
    L65:
        if (r37.hasNext() == false) goto L74;
        Content r38 = (Content) r37.next();
        r38.setImprIndex(Boxing.boxInt(r7));
        if (r11 != SortScene.WelcomeBack) goto L70;
        String r39 = "wcb_feed";
    L73:
        r38.setBizTag(r39);
        goto L65
    L70:
        if (r11 != SortScene.Recommend) goto L72;
        r39 = "chat_feed";
        goto L73
    L72:
        r39 = null;
    L74:
        if (r17 == null) goto L83;
        List<Content> r40 = r17.getItemLists();
        if (r40 == null) goto L83;
        ArrayList r41 = new ArrayList();
        Iterator<T> r42 = r40.iterator();
    L79:
        if (r42.hasNext() == false) goto L85;
        String r43 = ((Content) r42.next()).getItemId();
        if (r43 == null) goto L79;
        r41.add(r43);
    L85:
        if (r41 == null) goto L90;
        List<String> r44 = b;
        ArrayList r45 = (ArrayList) r44;
        r45.addAll(0, r41);
        if (r45.size() <= 32) goto L90;
        List r46 = CollectionsKt.take(r44, 32);
        r45.clear();
        r45.addAll(r46);
    L90:
        if (r11 != SortScene.InnerStream) goto L127;
        if (r13 == true) goto L127;
        if (r17 == null) goto L127;
        List<Content> r47 = r17.getItemLists();
        if (r47 == null) goto L127;
        Map<String, CopyOnWriteArrayList<g>> r48 = e.a;
        if (r8 != null) goto L99;
        r8 = "AwemeFeed";
    L99:
        ArrayList r49 = new ArrayList();
        Iterator<T> r50 = r47.iterator();
    L101:
        if (r50.hasNext() == false) goto L125;
        Content r51 = (Content) r50.next();
        String r114 = r51.getItemId();
        if (r114 != null) goto L105;
    L108:
        boolean r115 = true;
    L109:
        if (r115 == false) goto L111;
        g r116 = null;
    L123:
        if (r116 == null) goto L101;
        r49.add(r116);
        goto L101
    L111:
        String r117 = r51.getItemId();
        Integer r118 = r51.getItemType();
        int r119 = ItemType.VIDEO.getValue();
        if (r118 != null) goto L115;
    L117:
        GroupType r120 = GroupType.Graphic;
    L118:
        String r121 = r51.getRequestId();
        Integer r122 = Integer.valueOf(r7);
        Integer r52 = r51.getRecChannelId();
        if (r52 == null) goto L121;
        String r53 = r52.toString();
    L122:
        r116 = new g(r117, r120, r121, r122, r53);
        goto L123
    L121:
        r53 = null;
        goto L122
    L115:
        if (r118.intValue() != r119) goto L117;
        r120 = GroupType.Video;
        goto L118
    L105:
        if (r114.length() == 0) goto L108;
        r115 = false;
        goto L109
    L125:
        e.b(r8, r49);
    L127:
        if (r11 != SortScene.InnerStream) goto L129;
        if (r13 == true) goto L129;
    L167:
        if (o0.d(r9) == false) goto L231;
        if (r17 == null) goto L173;
        List<Content> r54 = r17.getItemLists();
        if (r54 == null) goto L173;
        List r55 = CollectionsKt.takeLast(r54, 2);
        if (r55 == null) goto L173;
    L174:
        if (r9 == null) goto L231;
        HashMap r56 = new HashMap();
        HashMap r57 = new HashMap();
        List r58 = r55;
        Iterator r59 = r58.iterator();
    L178:
        if (r59.hasNext() == false) goto L216;
        Content r60 = (Content) r59.next();
        String r61 = r60.getItemId();
        String r123 = r60.getRequestId();
        if (r61 != null) goto L182;
    L185:
        boolean r124 = true;
    L186:
        if (r124 == true) goto L195;
        if (r123 != null) goto L189;
    L192:
        boolean r125 = true;
    L193:
        if (r125 == true) goto L195;
        r56.put(r61, r123);
        goto L195
    L189:
        if (r123.length() == 0) goto L192;
        r125 = false;
    L195:
        if (r61 != null) goto L197;
    L200:
        boolean r126 = true;
    L201:
        if (r126 == true) goto L178;
        Integer r62 = r60.getRecChannelId();
        if (r62 != null) goto L205;
    L214:
        String r63 = "414";
    L215:
        r57.put(r61, r63);
        goto L178
    L205:
        if (r62.intValue() == 0) goto L207;
        boolean r127 = true;
    L208:
        if (r127 == true) goto L211;
        r62 = null;
    L211:
        if (r62 == null) goto L214;
        r63 = r62.toString();
        if (r63 != null) goto L215;
    L207:
        r127 = false;
        goto L208
    L197:
        if (r61.length() == 0) goto L200;
        r126 = false;
        goto L201
    L182:
        if (r61.length() == 0) goto L185;
        r124 = false;
        goto L186
    L216:
        long r64 = AppHost.a.getAppClock().currentTimeMillis();
        ArrayList r65 = new ArrayList();
        Iterator r66 = r58.iterator();
    L218:
        if (r66.hasNext() == false) goto L222;
        String r128 = ((Content) r66.next()).getItemId();
        if (r128 == null) goto L218;
        r65.add(r128);
        goto L218
    L222:
        ArrayList r67 = new ArrayList(r65);
        CachedVideosPreloadFrom r68 = CachedVideosPreloadFrom.UNLIMITED_FLOW;
        Content r69 = (Content) CollectionsKt.firstOrNull(r55);
        if (r69 == null) goto L225;
        Integer r70 = r69.getImprIndex();
    L226:
        k r129 = new k(r56, r9, r64, r67, r68, r70, r57);
        IFlowSdkDepend r71 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r71 == null) goto L231;
        r2 r72 = r71.A0();
        if (r72 == null) goto L231;
        r72.o(r129, true);
        goto L231
    L225:
        r70 = null;
    L173:
        r55 = CollectionsKt.emptyList();
    L231:
        if (r17 == null) goto L237;
        List<Content> r73 = r17.getItemLists();
        if (r73 == null) goto L235;
        List r130 = CollectionsKt.take(r73, h);
    L271:
        return RecommendVideoData.copy$default(r17, r130, null, false, 6, null);
    L235:
        r130 = null;
        goto L271
    L237:
        return null;
    L129:
        if (r17 == null) goto L131;
        List<Content> r74 = r17.getItemLists();
    L132:
        List<Content> r75 = r74;
        if (r75 != null) goto L135;
    L138:
        boolean r76 = true;
    L139:
        if (r76 == true) goto L167;
        ArrayList r77 = new ArrayList();
        Iterator<T> r78 = r74.iterator();
    L143:
        if (r78.hasNext() == false) goto L163;
        Content r79 = (Content) r78.next();
        String r80 = r79.getItemId();
        if (r80 != null) goto L147;
    L150:
        boolean r81 = true;
    L151:
        if (r81 == false) goto L153;
        pr9.a r82 = null;
    L161:
        if (r82 == null) goto L143;
        r77.add(r82);
        goto L143
    L153:
        String r83 = r79.getItemId();
        Integer r84 = r79.getItemType();
        int r85 = ItemType.ARTICLE.getValue();
        if (r84 != null) goto L157;
    L159:
        boolean r86 = false;
    L160:
        r82 = new pr9.a(r83, r86, 12);
        goto L161
    L157:
        if (r84.intValue() != r85) goto L159;
        r86 = true;
        goto L160
    L147:
        if (r80.length() == 0) goto L150;
        r81 = false;
        goto L151
    L163:
        c r87 = VideoFeedProviderDelegate.b.b();
        if (r87 == null) goto L167;
        r87.b(r77);
        goto L167
    L135:
        if (r75.isEmpty() == true) goto L138;
        r76 = false;
        goto L139
    L131:
        r74 = null;
    L83:
        r41 = null;
        goto L85
    L50:
        r35 = null;
        goto L51
    L46:
        r34 = null;
    L42:
        r21 = null;
        goto L43
    L52:
        FLogger r88 = FLogger.a;
        StringBuilder r89 = new StringBuilder("[");
        r89.append(r11);
        r89.append("] Request page.");
        r89.append(r7);
        r89.append(" recommend video failed: ");
        if ((r15 instanceof com.larus.network.http.f) == false) goto L55;
        com.larus.network.http.f r90 = (com.larus.network.http.f) r15;
    L56:
        if (r90 == null) goto L58;
        AsyncThrowable r91 = r90.d;
    L59:
        r89.append(r91);
        r88.d("RecommendVideoApi", r89.toString());
        d(false, r11, r10, r16, null);
        r17 = null;
        goto L60
    L58:
        r91 = null;
        goto L59
    L55:
        r90 = null;
        goto L56
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        long r131 = System.currentTimeMillis();
        JSONObject r92 = new JSONObject();
        r92.put("user_id", AccountService.a.getUserId());
        if (r28 == null) goto L18;
        r92.put("reply_item_ids", new JSONArray(r28));
    L18:
        if (r29 != null) goto L20;
        List<String> r93 = CollectionsKt.plus(b, c);
    L21:
        r92.put("last_item_ids", new JSONArray(r93));
        r92.put("count", r25);
        r92.put("sort_scene", r22.getValue());
        r92.put("sort_request_type", r23.getValue());
        r92.put("session_index", r24);
        r92.put("need_pack", r26);
        r92.put("entrance_item_id", r30);
        ConcurrentHashMap<String, Integer> r94 = j;
        if ((!r94.isEmpty()) == false) goto L24;
        r92.put("playlist_playtime", new JSONObject(GsonProtectorUtils.toJson((Gson) i.getValue(), r94)));
    L24:
        Unit r95 = Unit.INSTANCE;
        r14.L$0 = r22;
        r14.L$1 = r23;
        r14.L$2 = r31;
        r14.L$3 = r32;
        r14.I$0 = r24;
        r14.Z$0 = r27;
        r14.J$0 = r131;
        r14.label = 1;
        r19 = r131;
        r12 = HttpExtKt.k("Basic", RecommendVideoData.class, "/biz/feed/get_rec_video_ids", r92, null, null, false, null, null, null, r14, 1008);
        if (r12 != r4) goto L27;
        return r4;
    L27:
        r11 = r22;
        r7 = r24;
        r9 = r31;
        r8 = r32;
        r10 = r23;
        r13 = r27;
        goto L28
    L20:
        r93 = r29;
    L7:
        r2 = new RecommendVideoApi$requestRecommendVideo$1(this, r33);
        goto L8
    }
}
