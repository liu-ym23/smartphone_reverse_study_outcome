package do8;

import android.content.Context;
import android.util.Size;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import com.larus.bmhome.chat.markdown.vlm.RenderType;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MixerMedia;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.VLMImage;
import com.larus.im.bean.message.VLMMixerSearchResult;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.InnerVideoPreloadScene;
import com.larus.platform.api.OuterFallbackInfo;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.r2;
import com.larus.platform.api.v4;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w {
    public do8.a a;
    public k b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public List<com.larus.bmhome.chat.standarduikit.vlm.view.l> i;
    public final Lazy j;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.standarduikit.vlm.view.b {
        public final /* synthetic */ w a;

        @Override // com.larus.bmhome.chat.standarduikit.vlm.view.b
        public final boolean a() {
            do8.a r0 = this.a.a;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a();
        }

        public b(w r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.chat.standarduikit.vlm.view.b
        public final void b(int r46, Size r47) {
            Intrinsics.checkNotNullParameter(r47, "size");
            w r3 = this.a;
            com.larus.bmhome.chat.standarduikit.vlm.view.l r4 = (com.larus.bmhome.chat.standarduikit.vlm.view.l) CollectionsKt.getOrNull(r3.i, r46);
            if (r4 == null) goto L117;
            String r16 = ao8.e.a(r4);
            String r6 = r4.b;
            MixerMedia r5 = r4.i.b;
            if (r5 == null) goto L8;
            String r21 = r5.getItemId();
        L9:
            List<Integer> r25 = ao8.e.b(r4);
            VLMImage r7 = r4.i.a;
            if (r7 == null) goto L13;
            String r8 = r7.getSearchId();
            if (r8 == null) goto L13;
        L16:
            String r42 = r8;
        L18:
            k r9 = r3.b;
            boolean r10 = true;
            if (r9 == null) goto L25;
            j r11 = r9.h;
            if (r11 == null) goto L25;
            if (r11.e != true) goto L25;
            boolean r12 = true;
        L26:
            if (r12 == false) goto L28;
            String r40 = EnterVideoMethod.FLOW_CLICK_MIXED_VIDEO_CARD.getValue();
        L29:
            if (r12 == false) goto L40;
            k r13 = r3.b;
            if (r13 == null) goto L37;
            VLMMixerSearchResult r14 = r13.d;
            if (r14 == null) goto L37;
            List r15 = r14.getMixerMedias();
            if (r15 == null) goto L37;
            int r17 = r15.size();
        L38:
            if (r17 > 1) goto L40;
            String r18 = "single_card";
        L41:
            String r19 = r18;
            ri8.c r20 = ri8.c.a;
            do8.a r22 = r3.a;
            if (r22 == null) goto L44;
            LruSet<String> r23 = r22.g();
        L45:
            k r110 = r3.b;
            if (r110 == null) goto L50;
            Message r111 = r110.c;
            if (r111 == null) goto L50;
            String r112 = r111.getMessageId();
        L51:
            do8.a r113 = r3.a;
            if (r113 == null) goto L54;
            String r114 = r113.getConversationId();
        L55:
            k r115 = r3.b;
            if (r115 == null) goto L60;
            Message r116 = r115.c;
            if (r116 == null) goto L60;
            String r117 = r116.getReplyId();
        L61:
            do8.a r118 = r3.a;
            if (r118 == null) goto L64;
            String r119 = r118.getCurrentPage();
        L65:
            do8.a r120 = r3.a;
            if (r120 == null) goto L68;
            String r121 = r120.b();
        L69:
            do8.a r122 = r3.a;
            if (r122 == null) goto L72;
            String r24 = r122.getBotId();
        L73:
            String r2 = ri8.c.h(r47.getWidth(), r47.getHeight());
            k r123 = r3.b;
            if (r123 == null) goto L76;
            Integer r26 = r123.e;
        L77:
            if (r123 == null) goto L81;
            Message r124 = r123.c;
            if (r124 == null) goto L81;
            String r27 = com.larus.bmhome.chat.bean.d.x(r124).getReqId();
        L82:
            k r125 = r3.b;
            if (r125 == null) goto L85;
            Integer r30 = r125.e;
        L86:
            int r0 = r46 + 1;
            RenderType r126 = r4.h;
            RenderType r127 = RenderType.Picture;
            if (r126 != r127) goto L91;
            VLMImage r128 = r4.i.a;
            if (r128 == null) goto L91;
            String r33 = r128.getImageSource();
        L93:
            if (r4.h != r127) goto L97;
            VLMImage r28 = r4.i.a;
            if (r28 == null) goto L97;
            String r35 = r28.getDocId();
        L98:
            k r29 = r3.b;
            if (r29 != null) goto L101;
        L103:
            boolean r31 = false;
        L104:
            if (r31 == false) goto L106;
            String r32 = "vlm";
        L107:
            if (r29 != null) goto L109;
        L111:
            r10 = false;
        L112:
            if (r10 == false) goto L114;
            String r34 = "vlm_search";
        L115:
            ri8.c.n(r23, r6, r112, r114, r117, r119, r121, r30, Integer.valueOf(r0), "slideshow", "within_text", r16, r24, r2, r19, r26, r21, r27, null, null, r25, r34, null, null, null, r32, null, null, r33, null, r35, null, null, null, null, r40, null, r42, -1379139584, 23);
            return;
        L114:
            r34 = "normal";
            goto L115
        L109:
            if (r29.l != true) goto L111;
        L106:
            r32 = null;
            goto L107
        L101:
            if (r29.l != true) goto L103;
            r31 = true;
        L97:
            r35 = null;
        L91:
            r33 = null;
            goto L93
        L85:
            r30 = null;
        L81:
            r27 = null;
            goto L82
        L76:
            r26 = null;
            goto L77
        L72:
            r24 = null;
            goto L73
        L68:
            r121 = null;
            goto L69
        L64:
            r119 = null;
        L60:
            r117 = null;
            goto L61
        L54:
            r114 = null;
        L50:
            r112 = null;
            goto L51
        L44:
            r23 = null;
        L37:
            r17 = 0;
        L40:
            r18 = "multiple_card";
            goto L41
        L28:
            r40 = null;
        L25:
            r12 = false;
        L13:
            MixerMedia r36 = r4.i.b;
            if (r36 == null) goto L17;
            r8 = r36.getSearchId();
            goto L16
        L17:
            r42 = null;
            goto L18
        L8:
            r21 = null;
            goto L9
        }

        /* JADX WARN: Type inference failed for: r5v12, types: [do8.v] */
        @Override // com.larus.bmhome.chat.standarduikit.vlm.view.b
        public final void c(Context r99, final int r100, final Size r101, View r102, Function1<? super Integer, ? extends List<? extends Pair<Integer, ? extends View>>> r103, Function1<? super Integer, Unit> r104) {
            Intrinsics.checkNotNullParameter(r99, "context");
            Intrinsics.checkNotNullParameter(r101, "size");
            IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r1 == null) goto L11;
            r1.P();
            Fragment r2 = ChatServiceImpl.a.f();
            if (r2 == null) goto L11;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r3 = s1a.a.g(r2).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
            if (r3 == null) goto L11;
            if (r3.Lo() != true) goto L11;
            boolean r4 = true;
        L12:
            if (r4 == false) goto L15;
            t19.s.a.getClass();
            t19.s.s(r99, 2131911054);
            return;
        L15:
            List<com.larus.bmhome.chat.standarduikit.vlm.view.l> r5 = this.a.i;
            if (r5 == null) goto L445;
            com.larus.bmhome.chat.standarduikit.vlm.view.l r6 = (com.larus.bmhome.chat.standarduikit.vlm.view.l) CollectionsKt.getOrNull(r5, r100);
            if (r6 == null) goto L447;
            String r10 = "";
            String r11 = "chat";
            if (r6.h == RenderType.Picture) goto L248;
            MixerMedia r7 = r6.i.b;
            FlowRuntime.a().isOversea();
            w r8 = this.a;
            k r9 = r8.b;
            if (r9 == null) goto L244;
            VLMMixerSearchResult r12 = r9.d;
            if (r12 == null) goto L244;
            List r13 = r12.getMixerMedias();
            if (r13 == null) goto L244;
            List r14 = r13;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator r16 = r14.iterator();
        L31:
            if (r16.hasNext() == false) goto L33;
            MixerMedia r17 = (MixerMedia) r16.next();
            r15.add(new MediaEntity(null, r17.getItemId(), null, null, null, null, null, null, null, null, null, null, r17.getSourceFrom(), null, null, null, 0, null, null, null, null, null, null, null, 16773117, null));
            goto L31
        L33:
            k r18 = r8.b;
            if (r18 == null) goto L40;
            j r19 = r18.h;
            if (r19 == null) goto L40;
            if (r19.e != true) goto L40;
            boolean r67 = true;
        L41:
            if (r18 == null) goto L47;
            i r20 = r18.i;
            if (r20 == null) goto L47;
            if (r20.a != true) goto L47;
            boolean r21 = true;
        L48:
            if (r67 == false) goto L53;
            MediaEntity r22 = (MediaEntity) CollectionsKt.getOrNull(r15, r100);
            if (r22 == null) goto L244;
            ArrayList r23 = new ArrayList();
            r23.add(r22);
            ArrayList r24 = r23;
        L54:
            MediaEntityContainer r47 = new MediaEntityContainer(null, r24, null, null, false, 0, 0, null, 253, null);
            k r25 = r8.b;
            if (r25 == null) goto L61;
            i r26 = r25.i;
            if (r26 == null) goto L61;
            if (r26.a != true) goto L61;
            boolean r27 = true;
        L62:
            if (r27 == false) goto L106;
            ArrayList r28 = new ArrayList();
            Iterator r110 = r24.iterator();
        L66:
            if (r110.hasNext() == false) goto L74;
            MediaEntity r111 = (MediaEntity) r110.next();
            if (r111 == null) goto L70;
            String r112 = r111.getItem_id();
        L71:
            if (r112 == null) goto L66;
            r28.add(r112);
            goto L66
        L70:
            r112 = null;
            goto L71
        L74:
            k r113 = r8.b;
            if (r113 == null) goto L106;
            Message r114 = r113.c;
            if (r114 == null) goto L106;
            String r115 = r114.getMessageId();
            if (r115 == null) goto L106;
            if (StringsKt.isBlank(r115) == true) goto L106;
            String r116 = r114.getMessageId();
            if (r116 != null) goto L88;
            String r117 = "";
        L89:
            Map r118 = r114.getExt();
            if (r118 == null) goto L92;
            String r29 = (String) r118.get("req_id");
        L93:
            do8.a r30 = r8.a;
            if (r30 == null) goto L96;
            Boolean r210 = r30.h(r114);
        L97:
            LruCache<String, wc9.e> r31 = ko8.a.a;
            String r211 = ko8.a.c(r114);
            String r212 = (String) CollectionsKt.firstOrNull(r28);
            do8.a r32 = r8.a;
            if (r32 == null) goto L100;
            String r213 = r32.j();
        L101:
            com.larus.platform.api.v r33 = new com.larus.platform.api.v(r117, r210, r29, 1, 0, r211, r212, r28, InnerVideoPreloadScene.RelatedVideo.getSceneValue(), r114.getSenderId(), r213, null, null, 6144);
            IFlowSdkDepend r34 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r34 == null) goto L106;
            r2 r35 = r34.A0();
            if (r35 == null) goto L106;
            v4 r36 = r35.d(r33, false);
        L107:
            if (r67 == false) goto L109;
            int r37 = r100;
        L110:
            com.larus.bmhome.chat.standarduikit.vlm.view.l r119 = (com.larus.bmhome.chat.standarduikit.vlm.view.l) CollectionsKt.getOrNull(r8.i, r37);
            if (r119 == null) goto L115;
            com.larus.bmhome.chat.standarduikit.vlm.view.c r120 = r119.i;
            if (r120 == null) goto L115;
            MixerMedia r121 = r120.b;
        L116:
            k r122 = r8.b;
            if (r122 == null) goto L127;
            VLMMixerSearchResult r123 = r122.d;
            if (r123 == null) goto L127;
            List r124 = r123.getMixerMedias();
            if (r124 == null) goto L127;
            MixerMedia r38 = (MixerMedia) CollectionsKt.getOrNull(r124, r37);
            if (r38 == null) goto L127;
            Long r39 = r38.getStartTime();
            if (r39 == null) goto L127;
            long r125 = r39.longValue();
        L128:
            long r91 = r125 * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
            MediaEntity r40 = (MediaEntity) CollectionsKt.firstOrNull(r24);
            if (r40 == null) goto L131;
            Integer r48 = r40.getSource_from();
        L132:
            do8.a r41 = r8.a;
            if (r41 == null) goto L135;
            String r49 = r41.getBotId();
        L136:
            Message r42 = r9.c;
            if (r42 == null) goto L139;
            String r50 = r42.getMessageId();
        L140:
            do8.a r43 = r8.a;
            if (r43 == null) goto L143;
            String r51 = r43.getConversationId();
        L144:
            if (r121 == null) goto L149;
            String r44 = r121.getVideoFirstFrameImage();
            if (r44 == null) goto L149;
            String r55 = r44;
        L150:
            if (r121 == null) goto L155;
            String r45 = r121.getSearchId();
            if (r45 == null) goto L155;
            String r87 = r45;
        L156:
            do8.a r46 = r8.a;
            if (r46 == null) goto L159;
            boolean r52 = Intrinsics.areEqual(r46.d(), Boolean.TRUE);
        L160:
            if (r52 == false) goto L162;
            String r53 = EnterVideoMethod.COLLECTION_VIDEO_PAGE.getValue();
        L163:
            String r54 = r53;
            Map r57 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", "click_video_card"), TuplesKt.to("previous_page", "chat")});
            String r56 = MainBotServiceDelegate.b.a();
            if (r121 == null) goto L168;
            Integer r58 = r121.getWidth();
            if (r58 == null) goto L168;
            int r60 = r58.intValue();
        L169:
            String r72 = EnterVideoMethod.FLOW_CLICK_MIXED_VIDEO_CARD.getValue();
            MediaEntity r59 = (MediaEntity) CollectionsKt.firstOrNull(r24);
            if (r59 == null) goto L172;
            String r73 = r59.getItem_id();
        L173:
            k r61 = r8.b;
            if (r61 == null) goto L176;
            Integer r62 = r61.e;
        L177:
            String r81 = String.valueOf(r62);
            String r82 = String.valueOf(r100 + 1);
            Message r63 = r9.c;
            if (r63 == null) goto L180;
            String r70 = r63.getReplyId();
        L181:
            if (r121 == null) goto L185;
            Integer r64 = r121.getHeight();
            if (r64 == null) goto L185;
            int r510 = r64.intValue();
        L186:
            Message r65 = r9.c;
            if (r65 == null) goto L189;
            String r66 = r65.getSectionId();
        L190:
            Message r68 = r9.c;
            if (r68 == null) goto L193;
            String r69 = com.larus.bmhome.chat.bean.d.x(r68).getReqId();
        L194:
            do8.a r71 = r8.a;
            if (r71 == null) goto L197;
            String r610 = r71.getChatType();
        L198:
            k r74 = r8.b;
            if (r74 == null) goto L207;
            i r75 = r74.i;
            if (r75 == null) goto L207;
            List<String> r76 = r75.d;
            if (r76 == null) goto L207;
            List r77 = CollectionsKt.filterNotNull(r76);
            if (r77 == null) goto L207;
            ArrayList r611 = new ArrayList(r77);
        L208:
            if (r21 == false) goto L210;
            VideoParam.RecommendType r78 = VideoParam.RecommendType.Search;
        L211:
            VideoParam.RecommendType r612 = r78;
            PrefetchRecommendVideoParam r89 = r8.d(r24, null);
            if (r36 == null) goto L214;
            ArrayList r79 = r36.b;
        L215:
            if (r36 == null) goto L217;
            Map r80 = r36.a;
        L218:
            if (r36 == null) goto L220;
            Boolean r83 = Boolean.valueOf(r36.c);
        L221:
            LinkedHashMap r84 = new LinkedHashMap();
            Iterator r85 = CollectionsKt.filterNotNull(r24).iterator();
        L223:
            if (r85.hasNext() == false) goto L227;
            String r126 = ((MediaEntity) r85.next()).getItem_id();
            if (r126 == null) goto L223;
            r84.put(r126, "414");
            Unit r127 = Unit.INSTANCE;
            goto L223
        L227:
            if (r36 == null) goto L237;
            ArrayList r86 = r36.b;
            if (r86 == null) goto L237;
            List r88 = CollectionsKt.filterNotNull(r86);
            if (r88 == null) goto L237;
            Iterator r90 = r88.iterator();
        L234:
            if (r90.hasNext() == false) goto L236;
            r84.put((String) r90.next(), "416");
            goto L234
        L236:
            Unit r92 = Unit.INSTANCE;
        L237:
            Unit r93 = Unit.INSTANCE;
            VideoParam r94 = new VideoParam(r24, r47, r48, r49, r50, r51, null, 0, r54, r55, r56, r57, null, r510, r60, null, false, r66, r69, r610, r612, r67, null, r611, r70, null, r72, r73, null, null, null, null, null, null, "normal_video", r81, r82, null, null, null, null, r87, new FirstFramePreloadVideoData(r79, r80, r83, r84), r89, true, r91, null, null, -230584256, 99299);
            IFlowSdkDepend r95 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r95 == null) goto L240;
            r2 r96 = r95.A0();
        L241:
            if (r102 == null) goto L245;
            if (r96 == null) goto L244;
            String r128 = null;
            r96.r(r99, r94, r102, null);
        L260:
            String r214 = r128;
        L395:
            final Integer r129 = null;
            final w r130 = this.a;
            final k r97 = r130.b;
            if (r97 == null) goto L448;
            final com.larus.bmhome.chat.standarduikit.vlm.view.l r98 = (com.larus.bmhome.chat.standarduikit.vlm.view.l) CollectionsKt.getOrNull(r130.i, r100);
            if (r98 == null) goto L449;
            final String r105 = ao8.e.a(r98);
            final String r106 = r98.b;
            MixerMedia r107 = r98.i.b;
            if (r107 == null) goto L404;
            final String r131 = r107.getItemId();
        L405:
            final List<Integer> r132 = ao8.e.b(r98);
            VLMImage r108 = r98.i.a;
            if (r108 == null) goto L409;
            String r109 = r108.getSearchId();
            if (r109 == null) goto L409;
        L412:
            String r133 = r109;
        L414:
            boolean r134 = r97.h.e;
            if (r134 == false) goto L417;
            final String r135 = EnterVideoMethod.FLOW_CLICK_MIXED_VIDEO_CARD.getValue();
        L418:
            if (r134 == false) goto L426;
            List r136 = r97.d.getMixerMedias();
            if (r136 == null) goto L422;
            int r137 = r136.size();
        L424:
            if (r137 > 1) goto L426;
            String r138 = "single_card";
        L427:
            final String r139 = r138;
            final String r140 = r133;
            final ?? r141 = new v(r130, r97, r101, r100, r98, r106, r105, r139, r131, r132, r135, r140, r129);
            if (((Boolean) r130.c.getValue()).booleanValue() == false) goto L430;
            t0.a(new m(r141));
            return;
        L430:
            r141.invoke();
            return;
        L422:
            r137 = 0;
        L426:
            r138 = "multiple_card";
            goto L427
        L417:
            r135 = r214;
        L409:
            MixerMedia r142 = r98.i.b;
            if (r142 == null) goto L413;
            r109 = r142.getSearchId();
            goto L412
        L413:
            r133 = r214;
            goto L414
        L404:
            r131 = r214;
            goto L405
        L449:
            return;
        L448:
            return;
        L245:
            r128 = null;
            if (r96 == null) goto L260;
            r96.p(r99, "", r94);
            goto L260
        L240:
            r96 = null;
            goto L241
        L220:
            r83 = null;
            goto L221
        L217:
            r80 = null;
            goto L218
        L214:
            r79 = null;
            goto L215
        L210:
            r78 = VideoParam.RecommendType.Non;
        L207:
            r611 = new ArrayList();
            goto L208
        L197:
            r610 = null;
            goto L198
        L193:
            r69 = null;
            goto L194
        L189:
            r66 = null;
        L185:
            r510 = 0;
            goto L186
        L180:
            r70 = null;
            goto L181
        L176:
            r62 = null;
            goto L177
        L172:
            r73 = null;
        L168:
            r60 = 0;
            goto L169
        L162:
            r53 = EnterVideoMethod.SEARCH_VIDEO_PAGE.getValue();
            goto L163
        L159:
            r52 = false;
        L155:
            r87 = "";
        L149:
            r55 = "";
            goto L150
        L143:
            r51 = null;
            goto L144
        L139:
            r50 = null;
            goto L140
        L135:
            r49 = null;
            goto L136
        L131:
            r48 = null;
        L127:
            r125 = 0;
        L115:
            r121 = null;
            goto L116
        L109:
            r37 = 0;
            goto L110
        L100:
            r213 = null;
            goto L101
        L96:
            r210 = null;
            goto L97
        L92:
            r29 = null;
            goto L93
        L88:
            r117 = r116;
        L106:
            r36 = null;
        L61:
            r27 = false;
            goto L62
        L53:
            r24 = new ArrayList(r15);
        L47:
            r21 = false;
        L40:
            r67 = false;
        L244:
            r128 = null;
            goto L260
        L248:
            r128 = null;
            w r143 = this.a;
            if (r99 != null) goto L251;
            r143.getClass();
            goto L260
        L251:
            k r144 = r143.b;
            if (r144 == null) goto L260;
            com.larus.bmhome.chat.standarduikit.vlm.view.l r145 = (com.larus.bmhome.chat.standarduikit.vlm.view.l) CollectionsKt.getOrNull(r143.i, r100);
            if (r145 == null) goto L260;
            if (r144.m == null) goto L263;
            r144.m.invoke(Integer.valueOf(((Number) w.b(r144, r145, r144.f).component1()).intValue()));
            goto L260
        L263:
            if (((Boolean) r143.e.getValue()).booleanValue() == true) goto L265;
        L296:
            r214 = null;
            List r146 = CollectionsKt.emptyList();
            k r147 = r143.b;
            if (r147 == null) goto L302;
            VLMMixerSearchResult r148 = r147.d;
            if (r148 == null) goto L302;
            List r149 = r148.getVlmImages();
            if (r149 == null) goto L302;
        L303:
            List r150 = w.h(r149);
            int r151 = r145.i.c;
            Pair[] r152 = new Pair[12];
            r152[0] = TuplesKt.to("user_type", "bot");
            r152[1] = TuplesKt.to("enter_picture_method", "chat");
            do8.a r153 = r143.a;
            if (r153 == null) goto L306;
            boolean r154 = Intrinsics.areEqual(r153.d(), Boolean.TRUE);
        L307:
            if (r154 == false) goto L309;
            r11 = "temporary_chat";
        L309:
            r152[2] = TuplesKt.to("enter_from", r11);
            do8.a r155 = r143.a;
            if (r155 == null) goto L312;
            String r156 = r155.getBotId();
        L313:
            if (r156 != null) goto L315;
            r156 = "";
        L315:
            r152[3] = TuplesKt.to("bot_id", r156);
            do8.a r157 = r143.a;
            if (r157 == null) goto L318;
            String r158 = r157.getChatType();
        L319:
            if (r158 != null) goto L321;
            r158 = "";
        L321:
            r152[4] = TuplesKt.to("chat_type", r158);
            do8.a r159 = r143.a;
            if (r159 == null) goto L324;
            String r160 = r159.b();
        L325:
            if (r160 != null) goto L327;
            r160 = "";
        L327:
            Pair r161 = TuplesKt.to("previous_page", r160);
            int r162 = 5;
            r152[5] = r161;
            do8.a r163 = r143.a;
            if (r163 == null) goto L330;
            String r164 = r163.getCurrentPage();
        L331:
            if (r164 != null) goto L333;
            r164 = "";
        L333:
            r152[6] = TuplesKt.to("current_page", r164);
            do8.a r165 = r143.a;
            if (r165 == null) goto L336;
            String r166 = r165.getConversationId();
        L337:
            if (r166 != null) goto L339;
            r166 = "";
        L339:
            r152[7] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r166);
            r152[8] = TuplesKt.to("rich_media_type", "slideshow");
            Message r167 = r144.c;
            if (r167 == null) goto L342;
            String r168 = r167.getReplyId();
        L343:
            if (r168 != null) goto L345;
            r168 = "";
        L345:
            r152[9] = TuplesKt.to("reply_id", r168);
            Message r169 = r144.c;
            if (r169 == null) goto L348;
            String r170 = com.larus.bmhome.chat.bean.d.x(r169).getReqId();
        L349:
            if (r170 != null) goto L351;
            r170 = "";
        L351:
            r152[10] = TuplesKt.to("req_id", r170);
            Message r171 = r144.c;
            if (r171 == null) goto L354;
            String r172 = r171.getMessageId();
        L355:
            if (r172 != null) goto L357;
            r172 = "";
        L357:
            r152[11] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r172);
            Map r173 = MapsKt.mapOf(r152);
            k r174 = r143.b;
            if (r174 == null) goto L377;
            VLMMixerSearchResult r175 = r174.d;
            if (r175 == null) goto L377;
            List r176 = r175.getVlmImages();
            if (r176 == null) goto L377;
            List r177 = r176;
            ArrayList r178 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r177, 10));
            Iterator r179 = r177.iterator();
            int r180 = 0;
        L365:
            if (r179.hasNext() == false) goto L376;
            Object r181 = r179.next();
            int r182 = r180 + 1;
            if (r180 >= 0) goto L369;
            CollectionsKt.throwIndexOverflow();
        L369:
            VLMImage r183 = (VLMImage) r181;
            Pair[] r184 = new Pair[r162];
            ri8.c r185 = ri8.c.a;
            r184[0] = TuplesKt.to("image_resolution", ri8.c.a(CollectionsKt.listOf(new Integer[]{r183.getOriginWidth(), r183.getOriginHeight()})));
            r184[1] = TuplesKt.to("card_id", String.valueOf(r183.getCardId()));
            r184[2] = TuplesKt.to("position", Integer.valueOf(r100 + 1));
            String r186 = r183.getImageSource();
            if (r186 != null) goto L372;
            r186 = "";
        L372:
            r184[3] = TuplesKt.to("tool_name", r186);
            String r187 = r183.getDocId();
            if (r187 != null) goto L375;
            r187 = "";
        L375:
            r184[4] = TuplesKt.to("doc_id", r187);
            r178.add(MapsKt.mapOf(r184));
            r180 = r182;
            r162 = 5;
            goto L365
        L376:
            ArrayList r188 = r178;
        L378:
            uo8.k r189 = new uo8.k(r173, r188);
            do8.a r190 = r143.a;
            if (r190 == null) goto L381;
            String r191 = r190.getChatType();
        L382:
            if (r191 != null) goto L384;
            String r215 = "";
        L385:
            HybridEventParams r192 = new HybridEventParams("message_markdown_image", "chat", r215, null, 120);
            k r193 = r143.b;
            if (r193 == null) goto L390;
            Message r194 = r193.c;
            if (r194 == null) goto L390;
            String r195 = r194.getMessageId();
        L391:
            if (r195 == null) goto L394;
            r10 = r195;
        L394:
            com.larus.bmhome.bigimg.k.c(r99, r146, r150, r151, r189, true, r192, r10, false, null, r103, r104, null, 9984);
        L390:
            r195 = null;
            goto L391
        L384:
            r215 = r191;
            goto L385
        L381:
            r191 = null;
        L377:
            r188 = null;
            goto L378
        L354:
            r172 = null;
            goto L355
        L348:
            r170 = null;
            goto L349
        L342:
            r168 = null;
            goto L343
        L336:
            r166 = null;
            goto L337
        L330:
            r164 = null;
            goto L331
        L324:
            r160 = null;
            goto L325
        L318:
            r158 = null;
            goto L319
        L312:
            r156 = null;
            goto L313
        L306:
            r154 = false;
        L302:
            r149 = CollectionsKt.emptyList();
            goto L303
        L265:
            if (Intrinsics.areEqual(r144.j, Boolean.TRUE) == true) goto L296;
            boolean r196 = r144.f;
            do8.a r197 = r143.a;
            Triple r198 = w.b(r144, r145, r196);
            int r199 = ((Number) r198.component1()).intValue();
            List r1100 = (List) r198.component2();
            int r216 = ((Number) r198.component3()).intValue();
            if (r197 == null) goto L269;
            BotModel r200 = r197.i();
        L270:
            Message r201 = r144.c;
            if (r197 == null) goto L273;
            com.larus.trace.tracknode.a r202 = r197.f();
        L274:
            if (r197 == null) goto L277;
            CoroutineScope r203 = r197.c();
            if (r203 == null) goto L277;
        L278:
            CoroutineScope r204 = r203;
            if (r197 == null) goto L281;
            q0 r205 = r197.e();
        L282:
            r214 = null;
            ty8.a r1101 = new ty8.a(r200, r201, r202, r204, r205, r199, r99, r102, 0, 16128);
            Lazy r206 = rl8.c.a;
            if (r197 == null) goto L287;
            Fragment r207 = r197.getHostFragment();
            if (r207 == null) goto L287;
            FragmentManager r1102 = r207.getParentFragmentManager();
        L288:
            PreviewScene r208 = r144.k;
            JSONObject r209 = r144.g;
            if (r197 == null) goto L291;
            String r217 = r197.getCurrentPage();
        L292:
            if (r197 == null) goto L294;
            String r218 = r197.getChatType();
        L295:
            rl8.c.a(r1102, r1101, r1100, r208, r216, r104, r209, new HybridEventParams("message_markdown_image", r217, r218, null, 120));
            goto L395
        L294:
            r218 = null;
            goto L295
        L291:
            r217 = null;
        L287:
            r1102 = null;
            goto L288
        L281:
            r205 = null;
        L277:
            r203 = CoroutineScopeKt.MainScope();
            goto L278
        L273:
            r202 = null;
            goto L274
        L269:
            r200 = null;
            goto L270
        L447:
            return;
        L445:
            return;
        L11:
            r4 = false;
            goto L12
        }
    }

    static {
    }

    public final com.larus.bmhome.chat.standarduikit.vlm.view.a g() {
        k r0 = this.b;
        if (r0 != null) goto L14;
        FlowVLMContainerViewType r1 = FlowVLMContainerViewType.NoContent;
        List r2 = CollectionsKt.emptyList();
        k r3 = this.b;
        if (r3 == null) goto L7;
        Boolean r4 = r3.n;
    L8:
        if (r3 == null) goto L11;
        j r5 = r3.h;
        if (r5 == null) goto L11;
    L13:
        return new com.larus.bmhome.chat.standarduikit.vlm.view.a(r4, r1, r2, r5);
    L11:
        r5 = new j(false, false, false, false, null, 63);
        goto L13
    L7:
        r4 = null;
        goto L8
    L14:
        List<com.larus.bmhome.chat.standarduikit.vlm.view.l> r6 = this.i;
        return new com.larus.bmhome.chat.standarduikit.vlm.view.a(r0.n, k(r0.d), r6, r0.h);
    }

    public final int j() {
        k r0 = this.b;
        boolean r1 = false;
        if (r0 == null) goto L9;
        j r2 = r0.h;
        if (r2 == null) goto L9;
        if (r2.e != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L12;
        return 3;
    L12:
        return 1;
    }

    public w(final th8.f.b r2) {
        Intrinsics.checkNotNullParameter(r2, "sizeConfig");
        this.c = LazyKt.lazy(new n());
        this.d = LazyKt.lazy(new o());
        this.e = LazyKt.lazy(new p());
        this.f = LazyKt.lazy(new q());
        this.g = LazyKt.lazy(new r(r2));
        this.h = LazyKt.lazy(new s());
        this.i = CollectionsKt.emptyList();
        this.j = LazyKt.lazy(new t(this));
    }

    public static List h(List r15) {
        if (r15 == null) goto L35;
        List r16 = r15;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r17 = r16.iterator();
    L5:
        if (r17.hasNext() == false) goto L40;
        VLMImage r1 = (VLMImage) r17.next();
        String r4 = String.valueOf(r1.getCardId());
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List r3 = r1.getFullSizeUrl();
        if (r3 == null) goto L10;
        String r5 = (String) CollectionsKt.firstOrNull(r3);
        if (r5 == null) goto L10;
    L12:
        if (r5 != null) goto L14;
        String r6 = "";
    L15:
        String r7 = r1.getUri();
        if (r7 != null) goto L18;
        String r8 = "";
    L19:
        String r9 = r1.getAuthorShortId();
        String r10 = r1.getSourceAppName();
        String r11 = r1.getSourceAppIcon();
        Integer r12 = r1.getSourceFrom();
        String r13 = r1.getMainSiteUrl();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.getOriginThumbUrl();
        if (r2 != null) goto L22;
    L25:
        boolean r14 = true;
    L26:
        if (r14 == true) goto L30;
        String r18 = r1.getOriginThumbUrl();
        if (r18 != null) goto L33;
    L32:
        r18 = "";
    L33:
        String r19 = r6;
        String r20 = r8;
        String r21 = r18;
        r0.add(new com.larus.bmhome.bigimg.l(r4, r19, r20, r21, r9, r10, r11, r12, r13, r1.getImgCaption(), r1.getDocId()));
        goto L5
    L30:
        r18 = r1.getThumbUrl();
        if (r18 != null) goto L33;
    L22:
        if (r2.length() == 0) goto L25;
        r14 = false;
        goto L26
    L18:
        r8 = r7;
        goto L19
    L14:
        r6 = r5;
    L10:
        r5 = r1.getThumbUrl();
        goto L12
    L40:
        return r0;
    L35:
        return CollectionsKt.emptyList();
    }

    public final Pair<Integer, Integer> i(VLMMixerSearchResult r4) {
        List r0 = r4.getVlmImages();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        int r3 = Math.min(r2, 3);
        List r5 = r4.getMixerMedias();
        if (r5 == null) goto L9;
        r1 = r5.size();
    L9:
        int r6 = Math.min(r1, j());
        return new Pair(Integer.valueOf(r3), Integer.valueOf(r6));
    L5:
        r2 = 0;
        goto L6
    }

    public final FlowVLMContainerViewType k(VLMMixerSearchResult r2) {
        Pair<Integer, Integer> r3 = i(r2);
        int r0 = ((Number) r3.component1()).intValue() + ((Number) r3.component2()).intValue();
        if (r0 != 0) goto L6;
        return FlowVLMContainerViewType.NoContent;
    L6:
        if (r0 != 1) goto L9;
        return FlowVLMContainerViewType.SingleItem;
    L9:
        return FlowVLMContainerViewType.MultipleItem;
    }

    public final void a(k r27, do8.a r28) {
        Intrinsics.checkNotNullParameter(r27, "vmData");
        this.b = r27;
        this.a = r28;
        if (((Boolean) this.f.getValue()).booleanValue() == false) goto L5;
    L8:
        k r10 = r27;
    L9:
        this.b = r10;
        VLMMixerSearchResult r8 = r10.d;
        ArrayList r11 = new ArrayList();
        Pair<Integer, Integer> r0 = i(r8);
        int r6 = ((Number) r0.getFirst()).intValue();
        int r12 = ((Number) r0.getSecond()).intValue();
        boolean r13 = true;
        if (r6 != 0) goto L13;
        if (r12 <= 0) goto L13;
        boolean r15 = true;
    L14:
        FlowVLMContainerViewType r16 = k(r8);
        List r1 = r8.getVlmImages();
        if (r1 == null) goto L17;
        int r7 = r1.size();
    L19:
        if (r7 <= 3) goto L21;
        List<Integer> r2 = CollectionsKt.toList(RangesKt.until(3, r7));
    L22:
        List<Integer> r17 = r2;
        List r3 = r8.getMixerMedias();
        if (r3 == null) goto L25;
        int r18 = r3.size();
    L27:
        if (r10.h.e == false) goto L47;
        List r4 = r8.getMixerMedias();
        if (r4 == null) goto L124;
        List r5 = CollectionsKt.take(r4, r12);
        if (r5 == null) goto L124;
        Iterator r14 = r5.iterator();
        int r9 = 0;
    L34:
        if (r14.hasNext() == false) goto L124;
        Object r19 = r14.next();
        int r110 = r9 + 1;
        if (r9 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        MixerMedia r20 = (MixerMedia) r19;
        int r21 = r10.a;
        Message r22 = r10.c;
        if (r22 == null) goto L41;
        String r23 = r22.getMessageId();
    L42:
        if (r23 != null) goto L44;
        String r24 = "";
    L45:
        r11.add(e(r15, r21, r24, r20, r16, true, r9, r18));
        r9 = r110;
        goto L34
    L44:
        r24 = r23;
        goto L45
    L41:
        r23 = null;
    L124:
        this.i = r11;
        k r25 = this.b;
        if (r25 == null) goto L131;
        i r26 = r25.i;
        if (r26 == null) goto L131;
        if (r26.b != true) goto L131;
        boolean r29 = true;
    L132:
        if (r29 == false) goto L158;
        if (r25 == null) goto L138;
        VLMMixerSearchResult r30 = r25.d;
        if (r30 == null) goto L138;
        final List r111 = r30.getMixerMedias();
    L139:
        List r31 = r111;
        if (r31 != null) goto L142;
    L145:
        if (r13 == true) goto L159;
        t0.a(new l(this, r111));
        return;
    L159:
        return;
    L142:
        if (r31.isEmpty() == true) goto L145;
        r13 = false;
    L138:
        r111 = null;
        goto L139
    L158:
        return;
    L131:
        r29 = false;
        goto L132
    L47:
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L86;
        if (r12 <= 0) goto L68;
        List r32 = r8.getMixerMedias();
        if (r32 != null) goto L52;
    L54:
        boolean r33 = false;
    L55:
        if (r33 == false) goto L68;
        int r34 = r10.a;
        Message r35 = r10.c;
        if (r35 == null) goto L59;
        String r36 = r35.getMessageId();
    L60:
        if (r36 != null) goto L62;
        String r37 = "";
    L63:
        List r38 = r8.getMixerMedias();
        if (r38 == null) goto L66;
        MixerMedia r39 = (MixerMedia) CollectionsKt.getOrNull(r38, 0);
    L67:
        r11.add(f(this, r15, r34, r37, r39, r16));
        goto L68
    L66:
        r39 = null;
        goto L67
    L62:
        r37 = r36;
        goto L63
    L59:
        r36 = null;
        goto L60
    L52:
        if ((!r32.isEmpty()) != true) goto L54;
        r33 = true;
    L68:
        List r40 = r8.getVlmImages();
        if (r40 == null) goto L124;
        List r41 = CollectionsKt.take(r40, r6);
        if (r41 == null) goto L124;
        Iterator r42 = r41.iterator();
        int r43 = 0;
    L74:
        if (r42.hasNext() == false) goto L124;
        Object r44 = r42.next();
        int r112 = r43 + 1;
        if (r43 >= 0) goto L78;
        CollectionsKt.throwIndexOverflow();
    L78:
        VLMImage r45 = (VLMImage) r44;
        Message r46 = r10.c;
        if (r46 == null) goto L81;
        String r47 = r46.getMessageId();
    L82:
        if (r47 != null) goto L84;
        String r48 = "";
    L85:
        r11.add(c(r17, r48, r10.a, r45, r43, r7, r16));
        r43 = r112;
        r7 = r7;
        goto L74
    L84:
        r48 = r47;
        goto L85
    L81:
        r47 = null;
        goto L82
    L86:
        int r113 = r7;
        List r49 = r8.getVlmImages();
        if (r49 == null) goto L104;
        List r50 = CollectionsKt.take(r49, r6);
        if (r50 == null) goto L104;
        Iterator r210 = r50.iterator();
        int r51 = 0;
    L92:
        if (r210.hasNext() == false) goto L104;
        Object r52 = r210.next();
        int r211 = r51 + 1;
        if (r51 >= 0) goto L96;
        CollectionsKt.throwIndexOverflow();
    L96:
        VLMImage r53 = (VLMImage) r52;
        Message r54 = r10.c;
        if (r54 == null) goto L99;
        String r55 = r54.getMessageId();
    L100:
        if (r55 != null) goto L102;
        String r56 = "";
    L103:
        r11.add(c(r17, r56, r10.a, r53, r51, r113, r16));
        r51 = r211;
        goto L92
    L102:
        r56 = r55;
        goto L103
    L99:
        r55 = null;
    L104:
        if (r12 <= 0) goto L124;
        List r57 = r8.getMixerMedias();
        if (r57 != null) goto L108;
    L110:
        boolean r58 = false;
    L111:
        if (r58 == false) goto L124;
        int r59 = r10.a;
        Message r60 = r10.c;
        if (r60 == null) goto L115;
        String r61 = r60.getMessageId();
    L116:
        if (r61 != null) goto L118;
        String r62 = "";
    L119:
        List r63 = r8.getMixerMedias();
        if (r63 == null) goto L122;
        MixerMedia r64 = (MixerMedia) CollectionsKt.getOrNull(r63, 0);
    L123:
        r11.add(f(this, r15, r59, r62, r64, r16));
        goto L124
    L122:
        r64 = null;
        goto L123
    L118:
        r62 = r61;
        goto L119
    L115:
        r61 = null;
        goto L116
    L108:
        if ((!r57.isEmpty()) != true) goto L110;
        r58 = true;
        goto L111
    L25:
        r18 = 0;
        goto L27
    L21:
        r2 = CollectionsKt.emptyList();
        goto L22
    L17:
        r7 = 0;
    L13:
        r15 = false;
        goto L14
    L5:
        if (r27.h.e == true) goto L8;
        VLMMixerSearchResult r114 = VLMMixerSearchResult.copy$default(r27.d, null, null, 2, null);
        int r115 = r27.a;
        String r116 = r27.b;
        Message r117 = r27.c;
        Integer r65 = r27.e;
        boolean r66 = r27.f;
        JSONObject r67 = r27.g;
        j r68 = r27.h;
        i r69 = r27.i;
        Boolean r70 = r27.j;
        PreviewScene r71 = r27.k;
        boolean r72 = r27.l;
        Function1<Integer, Unit> r118 = r27.m;
        Boolean r73 = r27.n;
        Intrinsics.checkNotNullParameter(r114, "model");
        Intrinsics.checkNotNullParameter(r68, "uiConfig");
        Intrinsics.checkNotNullParameter(r69, "preloadAndRecommendConfig");
        Intrinsics.checkNotNullParameter(r71, "previewScene");
        r10 = new k(r115, r116, r117, r114, r65, r66, r67, r68, r69, r70, r71, r72, r118, r73);
        goto L9
    }

    public final PrefetchRecommendVideoParam d(List<MediaEntity> r24, OuterFallbackInfo r25) {
        k r1 = this.b;
        boolean r2 = true;
        if (r1 == null) goto L9;
        i r3 = r1.i;
        if (r3 == null) goto L9;
        if (r3.a != true) goto L9;
        boolean r4 = true;
    L10:
        List<String> r5 = null;
        if (r4 == true) goto L14;
        return null;
    L14:
        if (r24.isEmpty() == false) goto L16;
        return null;
    L16:
        k r6 = this.b;
        if (r6 == null) goto L72;
        final Message r7 = r6.c;
        if (r7 == null) goto L73;
        String r8 = r7.getMessageId();
        if (r8 != null) goto L24;
    L27:
        if (r2 == false) goto L29;
        return null;
    L29:
        ArrayList r9 = new ArrayList(r24);
        CachedVideosPreloadFrom r11 = CachedVideosPreloadFrom.BIND_PULL_API;
        String r10 = r7.getReplyId();
        String r12 = r7.getMessageId();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r24.iterator();
    L31:
        if (r14.hasNext() == false) goto L38;
        MediaEntity r15 = (MediaEntity) r14.next();
        if (r15 == null) goto L35;
        String r16 = r15.getItem_id();
    L36:
        if (r16 == null) goto L31;
        r13.add(r16);
        goto L31
    L35:
        r16 = null;
        goto L36
    L38:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r9.iterator();
    L40:
        if (r18.hasNext() == false) goto L47;
        MediaEntity r19 = (MediaEntity) r18.next();
        if (r19 == null) goto L44;
        String r20 = r19.getItem_id();
    L45:
        if (r20 == null) goto L40;
        r17.add(r20);
        goto L40
    L44:
        r20 = null;
        goto L45
    L47:
        do8.a r21 = this.a;
        if (r21 == null) goto L50;
        boolean r22 = Intrinsics.areEqual(r21.h(r7), Boolean.TRUE);
    L51:
        do8.a r23 = this.a;
        if (r23 == null) goto L54;
        String r110 = r23.j();
    L55:
        k r26 = this.b;
        if (r26 == null) goto L61;
        i r27 = r26.i;
        if (r27 == null) goto L61;
        r5 = r27.d;
    L61:
        return new PrefetchRecommendVideoParam(r12, r10, Boolean.TRUE, r13, 0, r11, r17, new u(this, r7), Boolean.valueOf(r22), r110, false, null, r25, true, r5, 3072, null);
    L54:
        r110 = null;
        goto L55
    L50:
        r22 = false;
        goto L51
    L24:
        if (r8.length() == 0) goto L27;
        r2 = false;
        goto L27
    L73:
        return null;
    L72:
        return null;
    L9:
        r4 = false;
        goto L10
    }

    public static Triple b(k r26, com.larus.bmhome.chat.standarduikit.vlm.view.l r27, boolean r28) {
        List r2 = r26.d.getVlmImages();
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        int r3 = 0;
        if (r28 == true) goto L8;
        int r0 = r27.i.c;
        List r1 = CollectionsKt.listOf(h(r2));
    L110:
        return new Triple(Integer.valueOf(r0), r1, Integer.valueOf(r3));
    L8:
        Message r4 = r26.c;
        if (r4 == null) goto L11;
        List r5 = rl8.g.c(r4);
    L12:
        Iterator r6 = r5.iterator();
        int r7 = 0;
    L14:
        if (r6.hasNext() == false) goto L52;
        List r8 = ((com.larus.bmhome.chat.markdown.imagegroup.a) r6.next()).c();
        if (r8 != null) goto L19;
    L47:
        boolean r9 = false;
    L49:
        if (r9 == true) goto L53;
        r7 = r7 + 1;
    L53:
        int r10 = r27.i.c;
        if (r7 < 0) goto L62;
        int r11 = r5.size();
        int r12 = 0;
    L56:
        if (r12 >= r11) goto L62;
        List r13 = ((com.larus.bmhome.chat.markdown.imagegroup.a) ListProtector.get(r5, r12)).c();
        if (r13 != null) goto L60;
        r13 = CollectionsKt.emptyList();
    L60:
        if (r12 >= r7) goto L62;
        r10 = r10 + r13.size();
        r12 = r12 + 1;
    L62:
        if (r7 < 0) goto L105;
        ArrayList r14 = new ArrayList();
        int r15 = r5.size();
        int r16 = 0;
    L64:
        if (r16 >= r15) goto L104;
        List r17 = ((com.larus.bmhome.chat.markdown.imagegroup.a) ListProtector.get(r5, r16)).c();
        if (r17 != null) goto L68;
        r17 = CollectionsKt.emptyList();
    L68:
        List r18 = r17;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L70:
        if (r20.hasNext() == false) goto L103;
        SearchImageInfo r110 = (SearchImageInfo) r20.next();
        String r111 = r110.getItemId();
        String r112 = "";
        if (r111 != null) goto L74;
        String r113 = "";
    L75:
        List r114 = r110.getFullSizeUrl();
        if (r114 == null) goto L79;
        String r115 = (String) CollectionsKt.firstOrNull(r114);
        if (r115 == null) goto L79;
    L80:
        if (r115 != null) goto L82;
        String r116 = "";
    L83:
        String r117 = r110.getUri();
        if (r117 != null) goto L86;
        String r118 = "";
    L87:
        String r119 = r110.getAuthorShortId();
        String r120 = r110.getSourceAppName();
        String r21 = r110.getSourceAppIcon();
        Integer r22 = r110.getSourceFrom();
        String r23 = r110.getMainSiteUrl();
        String r121 = r110.getOriginThumbUrl();
        if (r121 != null) goto L90;
    L93:
        boolean r122 = true;
    L94:
        if (r122 == true) goto L98;
        String r123 = r110.getOriginThumbUrl();
        if (r123 == null) goto L102;
    L101:
        r112 = r123;
    L102:
        r19.add(new com.larus.bmhome.bigimg.l(r113, r116, r118, r112, r119, r120, r21, r22, r23, r110.getImgCaption(), r110.getDocId()));
        goto L70
    L98:
        r123 = r110.getThumbUrl();
        if (r123 != null) goto L101;
    L90:
        if (r121.length() == 0) goto L93;
        r122 = false;
        goto L94
    L86:
        r118 = r117;
        goto L87
    L82:
        r116 = r115;
    L79:
        r115 = r110.getThumbUrl();
        goto L80
    L74:
        r113 = r111;
        goto L75
    L103:
        r14.add(r19);
        r16 = r16 + 1;
        goto L64
    L104:
        List r24 = r14;
    L106:
        if (r7 < 0) goto L108;
        r3 = r7;
    L108:
        int r25 = r10;
        r1 = r24;
        r0 = r25;
        goto L110
    L105:
        r24 = CollectionsKt.listOf(h(r2));
        goto L106
    L19:
        if (r8.size() != r2.size()) goto L47;
        Collection r29 = CollectionsKt.getIndices(r8);
        if ((r29 instanceof Collection) == true) goto L24;
    L26:
        IntIterator r30 = r29.iterator();
    L28:
        if (r30.hasNext() == false) goto L48;
        int r31 = r30.nextInt();
        SearchImageInfo r124 = (SearchImageInfo) ListProtector.get(r8, r31);
        VLMImage r32 = (VLMImage) ListProtector.get(r2, r31);
        String r125 = r124.getUri();
        String r126 = null;
        if (r125 != null) goto L37;
        List r127 = r124.getFullSizeUrl();
        if (r127 == null) goto L34;
        r125 = (String) CollectionsKt.firstOrNull(r127);
    L35:
        if (r125 != null) goto L37;
        r125 = r124.getThumbUrl();
        goto L37
    L34:
        r125 = null;
    L37:
        String r128 = r32.getUri();
        if (r128 != null) goto L46;
        List r129 = r32.getFullSizeUrl();
        if (r129 == null) goto L42;
        r126 = (String) CollectionsKt.firstOrNull(r129);
    L42:
        if (r126 != null) goto L44;
        r128 = r32.getThumbUrl();
        goto L46
    L44:
        r128 = r126;
    L46:
        if (Intrinsics.areEqual(r125, r128) == true) goto L28;
    L48:
        r9 = true;
        goto L49
    L24:
        if (r29.isEmpty() == false) goto L26;
    L52:
        r7 = -1;
        goto L53
    L11:
        r5 = CollectionsKt.emptyList();
        goto L12
    }

    public static /* synthetic */ com.larus.bmhome.chat.standarduikit.vlm.view.l f(w r9, boolean r10, int r11, String r12, MixerMedia r13, FlowVLMContainerViewType r14) {
        return r9.e(r10, r11, r12, r13, r14, false, 0, 0);
    }

    public final com.larus.bmhome.chat.standarduikit.vlm.view.l c(List<Integer> r27, String r28, int r29, VLMImage r30, int r31, int r32, FlowVLMContainerViewType r33) {
        int r1 = r32 - 3;
        if (r31 != 2) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        if (r1 < 1) goto L9;
    L10:
        if (r3 == false) goto L12;
        List<Integer> r6 = r27;
    L13:
        th8.f r7 = (th8.f) this.g.getValue();
        String r2 = null;
        if (r30 == null) goto L16;
        Integer r10 = r30.getWidth();
    L17:
        if (r30 == null) goto L19;
        Integer r11 = r30.getHeight();
    L20:
        Size r17 = r7.a(r29, r33, r10, r11, ((Boolean) this.d.getValue()).booleanValue(), false);
        if (r30 == null) goto L23;
        Long r4 = r30.getCardId();
    L24:
        String r16 = String.valueOf(r4);
        Integer r19 = Integer.valueOf(r1);
        if (r30 == null) goto L28;
        r2 = r30.getThumbUrl();
    L28:
        return new com.larus.bmhome.chat.standarduikit.vlm.view.l(r28, r16, r17, null, r19, null, r2, RenderType.Picture, new com.larus.bmhome.chat.standarduikit.vlm.view.c(r30, null, r31, r6, 2), r33, false);
    L23:
        r4 = null;
        goto L24
    L19:
        r11 = null;
        goto L20
    L16:
        r10 = null;
        goto L17
    L12:
        r6 = CollectionsKt.emptyList();
    L9:
        r1 = 0;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    public final com.larus.bmhome.chat.standarduikit.vlm.view.l e(boolean r17, int r18, String r19, MixerMedia r20, FlowVLMContainerViewType r21, boolean r22, int r23, int r24) {
        int r1 = r24 - j();
        boolean r8 = false;
        if (r22 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        if (r1 < 1) goto L11;
        int r10 = r1;
    L12:
        String r11 = null;
        if (r22 == false) goto L28;
        if (r20 == null) goto L19;
        Integer r3 = r20.getAlbumImageWidth();
        if (r3 == null) goto L19;
        int r4 = r3.intValue();
    L20:
        Integer r5 = Integer.valueOf(r4);
        if (r20 == null) goto L25;
        Integer r6 = r20.getAlbumImageHeight();
        if (r6 == null) goto L25;
        int r7 = r6.intValue();
    L26:
        Pair r9 = new Pair(r5, Integer.valueOf(r7));
    L35:
        Size r12 = ((th8.f) this.g.getValue()).a(r18, r21, (Integer) r9.component1(), (Integer) r9.component2(), r22, r22);
        if (r17 == false) goto L47;
        k r13 = this.b;
        if (r13 == null) goto L44;
        j r14 = r13.h;
        if (r14 == null) goto L44;
        if (r14.e != true) goto L44;
        r8 = true;
    L44:
        if (r8 == true) goto L47;
        if (r20 == null) goto L47;
        String r15 = r20.getDescription();
    L49:
        if (r20 == null) goto L51;
        String r16 = r20.getCardId();
    L52:
        if (r16 != null) goto L54;
        r16 = "";
    L54:
        String r25 = r16;
        Integer r110 = Integer.valueOf(r10);
        if (r20 == null) goto L57;
        String r111 = r20.getSourceAppIcon();
    L58:
        if (r20 == null) goto L61;
        r11 = r20.getImageUrl();
    L61:
        return new com.larus.bmhome.chat.standarduikit.vlm.view.l(r19, r25, r12, r15, r110, r111, r11, RenderType.Video, new com.larus.bmhome.chat.standarduikit.vlm.view.c(null, r20, 0, null, 9), r21, r22);
    L57:
        r111 = null;
        goto L58
    L51:
        r16 = null;
    L47:
        r15 = null;
    L25:
        r7 = 0;
    L19:
        r4 = 0;
        goto L20
    L28:
        if (r20 == null) goto L30;
        Integer r26 = r20.getWidth();
    L31:
        if (r20 == null) goto L33;
        Integer r27 = r20.getHeight();
    L34:
        r9 = new Pair(r26, r27);
        goto L35
    L33:
        r27 = null;
        goto L34
    L30:
        r26 = null;
    L11:
        r10 = 0;
        goto L12
    L5:
        if (r23 != (j() - 1)) goto L7;
        r2 = true;
        goto L8
    }
}
