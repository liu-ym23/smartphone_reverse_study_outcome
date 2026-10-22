package rh8;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.markdown.videogroup.VideoGroupV2Widget;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.video.Content;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusMdVideoGroupV2Binding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.service.z2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements ip8.f {
    public final /* synthetic */ rh8.a a;
    public final /* synthetic */ VideoGroupV2Widget b;
    public final /* synthetic */ Map<String, Object> c;
    public final /* synthetic */ TextView d;

    public static final class a implements ip8.e {
        public final /* synthetic */ rh8.a a;
        public final /* synthetic */ VideoGroupV2Widget b;
        public final /* synthetic */ Map<String, Object> c;
        public final /* synthetic */ TextView d;

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        /* JADX WARN: Type inference failed for: r5v0, types: [rh8.f] */
        public final void c(View r90, Content r91) {
            Intrinsics.checkNotNullParameter(r90, "view");
            if (r91 != null) goto L5;
            return;
        L5:
            List<VideoInfo> r1 = this.a.b();
            if (r1 == null) goto L93;
            final VideoGroupV2Widget r2 = this.b;
            int r3 = VideoGroupV2Widget.i;
            r2.getClass();
            final VideoInfo r4 = (VideoInfo) ListProtector.get(r1, 0);
            final ?? r5 = new f(r4, r2);
            if (z2.a.enableTrackerOptimize() == false) goto L10;
            t0.a(new g(r5));
        L12:
            if (AppHost.a.isOversea() == false) goto L30;
            String r6 = ((VideoInfo) ListProtector.get(r1, 0)).getHostPageUrl();
            if (r6 == null) goto L94;
            IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r8 == null) goto L95;
            r8.L();
            com.larus.home.impl.sdk.t0 r9 = com.larus.home.impl.sdk.t0.a;
            Context r10 = r2.getContext();
            Pair[] r11 = new Pair[4];
            Message r12 = r2.b;
            if (r12 == null) goto L20;
            String r13 = r12.getMessageId();
        L21:
            r11[0] = TuplesKt.to("message_id", r13);
            Message r14 = r2.b;
            if (r14 == null) goto L24;
            String r15 = r14.getSectionId();
        L25:
            r11[1] = TuplesKt.to("section_id", r15);
            r11[2] = TuplesKt.to("bot_id", r2.d);
            VideoInfo r7 = (VideoInfo) CollectionsKt.getOrNull(r1, 0);
            if (r7 == null) goto L28;
            String r16 = r7.getItemId();
        L29:
            r11[3] = TuplesKt.to("video_id", r16);
            r9.i(r10, r6, MapsKt.mapOf(r11));
            return;
        L28:
            r16 = null;
            goto L29
        L24:
            r15 = null;
            goto L25
        L20:
            r13 = null;
            goto L21
        L95:
            return;
        L94:
            return;
        L30:
            List<VideoInfo> r17 = r1;
            ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
            Iterator<T> r19 = r17.iterator();
        L32:
            if (r19.hasNext() == false) goto L34;
            VideoInfo r20 = (VideoInfo) r19.next();
            r18.add(new MediaEntity(null, r20.getItemId(), null, null, null, null, null, null, null, null, null, null, r20.getSourceFrom(), null, null, null, 0, null, null, null, null, null, null, r20.getHostVideoSchema(), 8384509, null));
            goto L32
        L34:
            ArrayList r21 = new ArrayList(r18);
            MediaEntityContainer r22 = new MediaEntityContainer(null, r21, null, null, false, 0, 0, null, 253, null);
            fh8.f r23 = r2.h;
            if (r23 == null) goto L39;
            Message r24 = r23.b;
            if (r24 == null) goto L39;
            String r42 = r24.getMessageId();
        L40:
            fh8.f r25 = r2.h;
            if (r25 == null) goto L45;
            Message r26 = r25.b;
            if (r26 == null) goto L45;
            String r55 = r26.getSectionId();
        L46:
            fh8.f r27 = r2.h;
            if (r27 == null) goto L51;
            Message r28 = r27.b;
            if (r28 == null) goto L51;
            String r56 = com.larus.bmhome.chat.bean.d.x(r28).getReqId();
        L52:
            fh8.f r29 = r2.h;
            if (r29 == null) goto L57;
            Message r30 = r29.b;
            if (r30 == null) goto L57;
            String r31 = (String) com.larus.bmhome.chat.bean.d.x(r30).get("enable_video_recommend");
        L58:
            boolean r32 = Intrinsics.areEqual(r31, "1");
            Pair<Integer, Integer> r33 = ((VideoInfo) ListProtector.get(r1, 0)).getFirstFrameSize();
            int r52 = ((Number) r33.component1()).intValue();
            int r51 = ((Number) r33.component2()).intValue();
            fh8.f r34 = r2.h;
            if (r34 == null) goto L63;
            Message r35 = r34.b;
            if (r35 == null) goto L63;
            String r62 = r35.getReplyId();
        L64:
            fh8.f r36 = r2.h;
            if (r36 == null) goto L67;
            String r57 = r36.a;
        L68:
            if (r36 == null) goto L70;
            boolean r37 = Intrinsics.areEqual(r36.h, Boolean.TRUE);
        L71:
            MediaEntity r110 = (MediaEntity) CollectionsKt.firstOrNull(r21);
            if (r110 == null) goto L74;
            Integer r40 = r110.getSource_from();
        L75:
            String r111 = r2.d;
            String r112 = r2.c;
            String r47 = ((VideoInfo) ListProtector.get(r1, 0)).getFirstFrameImage();
            if (r37 == false) goto L78;
            EnterVideoMethod r38 = EnterVideoMethod.COLLECTION_VIDEO_PAGE;
        L79:
            String r46 = r38.getValue();
            Map r49 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", "click_video_card"), TuplesKt.to("previous_page", "chat")});
            String r48 = MainBotServiceDelegate.b.a();
            if (r32 == false) goto L82;
            VideoParam.RecommendType r39 = VideoParam.RecommendType.Search;
        L83:
            VideoParam.RecommendType r58 = r39;
            LruCache r41 = ko8.a.a;
            VideoParam r43 = new VideoParam(r21, r22, r40, r111, r42, r112, null, 0, r46, r47, r48, r49, null, r51, r52, null, false, r55, r56, r57, r58, false, null, null, r62, null, null, null, ko8.a.c(r2.b), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, -287207360, 131071);
            IFlowSdkDepend r44 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r44 == null) goto L97;
            r2 r45 = r44.A0();
            if (r45 == null) goto L98;
            Context r50 = r2.getContext();
            LarusMdVideoGroupV2Binding r53 = r2.a;
            if (r53 != null) goto L90;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r53 = null;
        L90:
            r45.r(r50, r43, r53.b, null);
            return;
        L98:
            return;
        L97:
            return;
        L82:
            r39 = VideoParam.RecommendType.Non;
            goto L83
        L78:
            r38 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
            goto L79
        L74:
            r40 = null;
            goto L75
        L70:
            r37 = false;
            goto L71
        L67:
            r57 = null;
        L63:
            r62 = null;
        L57:
            r31 = null;
        L51:
            r56 = null;
        L45:
            r55 = null;
        L39:
            r42 = null;
            goto L40
        L10:
            r5.invoke();
            goto L12
        }

        public a(rh8.a r1, VideoGroupV2Widget r2, Map<String, ? extends Object> r3, TextView r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void b(View r1, Content r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r1, "view");
            this.d.performLongClick();
        }
    }

    public final boolean a() {
        return false;
    }

    public final boolean b() {
        return true;
    }

    public final void c() {
    }

    public final ip8.e e() {
        return new a(this.a, this.b, this.c, this.d);
    }

    public final int d() {
        return VideoGroupV2Widget.i;
    }

    public j(rh8.a r1, VideoGroupV2Widget r2, Map<String, ? extends Object> r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
