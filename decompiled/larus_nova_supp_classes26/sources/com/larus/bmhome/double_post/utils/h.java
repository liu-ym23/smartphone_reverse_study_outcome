package com.larus.bmhome.double_post.utils;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.auth.FeedDislikeOption;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ContentCover;
import com.larus.bmhome.video.ItemType;
import com.larus.bmhome.video.e;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.ScreenMenuLayout;
import com.larus.bmhome.view.screenmenu.e1;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.r0;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.InnerVideoPreloadScene;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.r2;
import com.larus.platform.api.v;
import com.larus.platform.api.v4;
import com.larus.platform.uimodel.ArticleParam;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final String b;
        public final VideoParam.RecommendType c;
        public final Integer d;
        public final String e;
        public final String f;
        public final ArrayList<String> g;

        public a() {
            this(null, null, null, null, null, null, 127);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            VideoParam.RecommendType r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            ArrayList<String> r19 = this.g;
            if (r19 == null) goto L31;
            r1 = r19.hashCode();
        L31:
            return r18 + r1;
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ExtraInfo(messageId=" + this.a + ", replyId=" + this.b + ", recommendType=" + this.c + ", ugcVideoScene=" + this.d + ", richMediaType=" + this.e + ", searchId=" + this.f + ", replyItemIds=" + this.g + ')';
        }

        public a(String r3, String r4, VideoParam.RecommendType r5, String r6, String r7, ArrayList r8, int r9) {
            if ((r9 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r9 & 16) == 0) goto L15;
            r6 = "";
        L15:
            if ((r9 & 32) == 0) goto L18;
            r7 = null;
        L18:
            if ((r9 & 64) == 0) goto L20;
            r8 = null;
        L20:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = null;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    static {
    }

    public h() {
    }

    public static void c(Fragment r51, final View r52, final Content r53, final float r54, final float r55, final Function4 r56) {
        Intrinsics.checkNotNullParameter(r51, "fragment");
        Intrinsics.checkNotNullParameter(r52, "anchor");
        Context r3 = r52.getContext();
        if (r3 != null) goto L5;
        return;
    L5:
        e0 r4 = (e0) AuthModelDelegate.b.e().getValue();
        if (r4 == null) goto L92;
        LaunchInfo r5 = r4.a;
        if (r5 == null) goto L93;
        final List r6 = r5.C0();
        if (r6 != null) goto L13;
        return;
    L13:
        if (r6.isEmpty() == false) goto L16;
        FLogger.a.i("AwemeRecommendClickHelper", "tryShowLongClickPanel: feedDislikeOptions is empty");
        return;
    L16:
        final x0 r7 = new x0();
        r7.d(r51);
        ArrayList r0 = new ArrayList();
        Iterator r8 = r6.iterator();
    L18:
        if (r8.hasNext() == false) goto L72;
        FeedDislikeOption r9 = (FeedDislikeOption) r8.next();
        i r10 = null;
        if (r9 == null) goto L22;
        String r11 = r9.b();
    L23:
        if (r11 == null) goto L67;
        String r12 = "";
        switch(r11.hashCode()) {
            case -740084458: goto L59;
            case 285626533: goto L51;
            case 297801562: goto L44;
            case 568839470: goto L36;
            case 1693902463: goto L28;
            default: goto L67;
        };
    L28:
        if (r11.equals("feed_dislike_menuOption_turnOff_recommend") == false) goto L67;
        int r13 = v19.c.b(2130971715, null, 2131241327);
        String r14 = r9.c();
        if (r14 == null) goto L34;
        r12 = r14;
    L34:
        i r15 = new i(5, r13, r12);
    L66:
        r10 = r15;
        goto L67
    L36:
        if (r11.equals("db_feed_card_dislike_similar_content_cn") == false) goto L67;
        int r16 = v19.c.b(2130971717, null, 2131241333);
        String r17 = r9.c();
        if (r17 == null) goto L42;
        r12 = r17;
    L42:
        r15 = new i(4, r16, r12);
        goto L66
    L44:
        if (r11.equals("db_feed_card_dislike_content_cn") == false) goto L67;
        int r18 = v19.c.b(2130971714, null, 2131241324);
        String r19 = r9.c();
        if (r19 == null) goto L49;
        r12 = r19;
    L49:
        r15 = new i(1, r18, r12);
        goto L66
    L51:
        if (r11.equals("db_feed_card_dislike_low_content_cn") == false) goto L67;
        int r20 = v19.c.b(2130971716, null, 2131241330);
        String r21 = r9.c();
        if (r21 == null) goto L57;
        r12 = r21;
    L57:
        r15 = new i(3, r20, r12);
        goto L66
    L59:
        if (r11.equals("db_feed_card_dislike_author_cn") == false) goto L67;
        int r22 = v19.c.b(2130971713, null, 2131241321);
        String r23 = r9.c();
        if (r23 == null) goto L65;
        r12 = r23;
    L65:
        r15 = new i(2, r22, r12);
    L67:
        if (r10 == null) goto L18;
        if (o0.d(r10.c) == false) goto L18;
        r0.add(new l0(r10.a, 0, r10.c, null, null, null, null, null, null, false, false, null, Integer.valueOf(r10.b), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        goto L18
    L22:
        r11 = null;
        goto L23
    L72:
        if (r0.isEmpty() == false) goto L75;
        FLogger.a.i("AwemeRecommendClickHelper", "tryShowLongClickPanel: menuItems is empty");
        return;
    L75:
        r7.i(new f(r52, r54, r55));
        CommonMenu r24 = new CommonMenu(r3);
        r24.d(i5.B());
        r24.g(r0, new g(r56, r53, r6, r7));
        View r1 = r24.i();
        Intrinsics.checkNotNullParameter(r52, "anchor");
        Intrinsics.checkNotNullParameter(r1, "menuViewHolder");
        FragmentActivity r25 = r7.e();
        if (r25 == null) goto L96;
        r25.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        ScreenMenuLayout r26 = r7.a;
        if (r26 == null) goto L94;
        int r27 = ScreenMenuLayout.h;
        Intrinsics.checkNotNullParameter(r52, "anchor");
        Intrinsics.checkNotNullParameter(r1, "menuView");
        r26.removeAllViews();
        r26.b = r52;
        r26.c = r1;
        r26.addView(r1);
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r28 = (FrameLayout.LayoutParams) r2;
        r28.width = -2;
        r28.height = -2;
        Function1<? super View, r0> r29 = r26.a;
        if (r29 == null) goto L83;
        r0 r30 = (r0) r29.invoke(r1);
    L83:
        r26.setVisibility(0);
        OneShotPreDrawListener.add(r26, new e1(r26, r26));
        return;
    L94:
        return;
    L96:
        return;
    L93:
        return;
    }

    public static void a(Context r69, View r70, Content r71, int r72, String r73, a r74, List r75, Integer r76, Integer r77, String r78) {
        Intrinsics.checkNotNullParameter(r69, "context");
        Intrinsics.checkNotNullParameter(r70, "anchor");
        Intrinsics.checkNotNullParameter(r71, "data");
        Intrinsics.checkNotNullParameter(r78, "bizScene");
        Integer r2 = r71.getItemType();
        int r3 = ItemType.ARTICLE.getValue();
        boolean r18 = false;
        String r19 = "";
        Integer r9 = null;
        if (r2 != null) goto L6;
    L52:
        ArrayList r8 = new ArrayList();
        r8.add(new MediaEntity(null, r71.getItemId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 16777213, null));
        if (r74 == null) goto L56;
        String r4 = r74.a;
        if (r4 == null) goto L56;
    L57:
        String r47 = r4;
        String r5 = r71.getRequestId();
        Integer r16 = r71.getImprIndex();
        if (r47 != null) goto L61;
        ArrayList r57 = r8;
    L60:
        int r6 = 1;
        v4 r10 = null;
    L70:
        ContentCover r7 = r71.getCover();
        if (r7 == null) goto L77;
        IconImage r11 = r7.getOriginCover();
        if (r11 == null) goto L77;
        ImageObj r12 = r11.imageOri;
        if (r12 == null) goto L77;
        String r13 = r12.url;
    L78:
        if (r13 != null) goto L80;
        String r14 = "";
    L81:
        ContentCover r15 = r71.getCover();
        int r17 = 10;
        if (r15 == null) goto L88;
        IconImage r20 = r15.getOriginCover();
        if (r20 == null) goto L88;
        ImageObj r21 = r20.imageOri;
        if (r21 == null) goto L88;
        int r22 = r21.width;
    L89:
        ContentCover r23 = r71.getCover();
        if (r23 == null) goto L97;
        IconImage r24 = r23.getOriginCover();
        if (r24 == null) goto L97;
        ImageObj r25 = r24.imageOri;
        if (r25 == null) goto L97;
        r17 = r25.height;
    L97:
        if (r74 == null) goto L100;
        VideoParam.RecommendType r26 = r74.c;
        if (r26 == null) goto L100;
    L101:
        VideoParam.RecommendType r27 = r26;
        String r28 = r71.getRequestId();
        String r56 = r71.getItemId();
        Integer r58 = r71.getImprIndex();
        int r49 = r72 + 1;
        if (r74 == null) goto L104;
        String r29 = r74.b;
    L105:
        if (r29 != null) goto L107;
        String r59 = "";
    L108:
        if (r74 == null) goto L112;
        Integer r30 = r74.d;
        if (r30 == null) goto L112;
        int r210 = r30.intValue();
    L113:
        if (r74 == null) goto L115;
        String r31 = r74.a;
    L116:
        if (r31 == null) goto L119;
        r19 = r31;
    L119:
        if (r74 == null) goto L121;
        String r60 = r74.e;
    L122:
        if (r74 == null) goto L124;
        String r61 = r74.f;
    L125:
        if (r74 == null) goto L127;
        ArrayList<String> r62 = r74.g;
    L128:
        if (r76 == null) goto L130;
        String r63 = String.valueOf(r76.intValue() + r6);
    L131:
        if (r77 == null) goto L133;
        String r64 = String.valueOf(r77.intValue() + r6);
    L135:
        if (Intrinsics.areEqual(r78, InnerVideoPreloadScene.ChatFeed.getSceneValue()) == false) goto L137;
        Integer r65 = r71.getImprIndex();
    L138:
        Integer r32 = r71.getRecChannelId();
        if (r32 != null) goto L141;
    L151:
        String r66 = "414";
    L153:
        if (r10 == null) goto L155;
        ArrayList r33 = r10.b;
    L156:
        if (r10 == null) goto L158;
        Map r34 = r10.a;
    L159:
        if (r10 == null) goto L161;
        Boolean r35 = Boolean.valueOf(r10.c);
    L162:
        if (r10 == null) goto L164;
        Map r36 = r10.d;
    L165:
        ArrayList r37 = r57;
        String r38 = r19;
        int r110 = r17;
        int r111 = r22;
        String r211 = r59;
        VideoParam r39 = new VideoParam(r37, null, null, null, r38, null, null, 0, null, r14, null, null, null, r110, r111, null, false, null, r28, null, r27, false, Integer.valueOf(r210), null, r211, r47, r73, r56, null, r58, Integer.valueOf(r49), r62, r65, r66, "normal_video", r63, r64, r60, null, null, null, r61, new FirstFramePreloadVideoData(r33, r34, r35, r36), new PrefetchRecommendVideoParam(r47, null, null, null, null, null, null, null, Boolean.TRUE, null, true, r71.getImprIndex(), null, false, null, 29438, null), false, 0, null, null, 279682542, 123840);
        IFlowSdkDepend r40 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r40 == null) goto L174;
        r2 r41 = r40.A0();
        if (r41 == null) goto L175;
        r41.r(r69, r39, r70, null);
        return;
    L175:
        return;
    L174:
        return;
    L164:
        r36 = null;
        goto L165
    L161:
        r35 = null;
        goto L162
    L158:
        r34 = null;
        goto L159
    L155:
        r33 = null;
        goto L156
    L141:
        if (r32.intValue() == 0) goto L143;
        r18 = true;
    L143:
        if (r18 == true) goto L146;
        r32 = null;
    L146:
        if (r32 == null) goto L151;
        String r42 = r32.toString();
        if (r42 == null) goto L151;
        r66 = r42;
        goto L153
    L137:
        r65 = null;
        goto L138
    L133:
        r64 = null;
        goto L135
    L130:
        r63 = null;
        goto L131
    L127:
        r62 = null;
        goto L128
    L124:
        r61 = null;
        goto L125
    L121:
        r60 = null;
        goto L122
    L115:
        r31 = null;
    L112:
        r210 = 0;
        goto L113
    L107:
        r59 = r29;
        goto L108
    L104:
        r29 = null;
    L100:
        r26 = VideoParam.RecommendType.AwemeFeed;
    L88:
        r22 = 10;
        goto L89
    L80:
        r14 = r13;
    L77:
        r13 = null;
        goto L78
    L61:
        if (r75 == null) goto L63;
        String r212 = (String) CollectionsKt.getOrNull(r75, r72);
    L64:
        r57 = r8;
        v r43 = new v(r47, Boolean.TRUE, r5, 4, r72, null, r212, r75, r78, null, null, r16, null, 5664);
        IFlowSdkDepend r44 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r44 == null) goto L60;
        r2 r45 = r44.A0();
        if (r45 == null) goto L60;
        r6 = 1;
        r10 = r45.d(r43, true);
        goto L70
    L63:
        r212 = null;
    L56:
        r4 = e.b;
        goto L57
    L6:
        if (r2.intValue() != r3) goto L52;
        String r213 = r71.getItemId();
        int r46 = r72 + 1;
        String r214 = e.b;
        Integer r215 = r71.getImprIndex();
        String r216 = r71.getRequestId();
        if (r74 == null) goto L10;
        String r310 = r74.e;
    L11:
        VideoParam.RecommendType r311 = VideoParam.RecommendType.AwemeFeed;
        if (r74 == null) goto L14;
        String r48 = r74.b;
    L15:
        if (r48 != null) goto L17;
        String r312 = "";
    L18:
        if (r74 == null) goto L20;
        String r50 = r74.a;
    L21:
        if (r50 != null) goto L23;
        String r313 = "";
    L24:
        if (r74 == null) goto L26;
        String r314 = r74.f;
    L27:
        if (r76 == null) goto L29;
        String r217 = String.valueOf(r76.intValue() + 1);
    L30:
        if (r77 == null) goto L32;
        String r218 = String.valueOf(r77.intValue() + 1);
    L33:
        ArticleParam r51 = new ArticleParam(r213, r73, Integer.valueOf(r46), r214, r215, r216, "normal_video", r217, r218, r310, null, null, r313, null, null, r312, r314, r311, 27648, null);
        Map<String, CopyOnWriteArrayList<com.larus.bmhome.video.g>> r52 = e.a;
        String r53 = r71.getItemId();
        if (r53 != null) goto L36;
        r53 = "";
    L36:
        String r54 = r71.getRequestId();
        Integer r55 = r71.getRecChannelId();
        if (r55 != null) goto L39;
    L46:
        String r67 = "414";
    L47:
        e.b("AwemeFeed", CollectionsKt.listOf(new com.larus.bmhome.video.g(r53, r54, r67)));
        IFlowSdkDepend r68 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r68 == null) goto L171;
        r2 r79 = r68.A0();
        if (r79 == null) goto L172;
        r79.m(r69, r51, r70);
        return;
    L172:
        return;
    L171:
        return;
    L39:
        if (r55.intValue() == 0) goto L41;
        r18 = true;
    L41:
        if (r18 == false) goto L43;
        r9 = r55;
    L43:
        if (r9 == null) goto L46;
        r67 = r9.toString();
        if (r67 != null) goto L47;
    L32:
        r218 = null;
        goto L33
    L29:
        r217 = null;
        goto L30
    L26:
        r314 = null;
        goto L27
    L23:
        r313 = r50;
        goto L24
    L20:
        r50 = null;
        goto L21
    L17:
        r312 = r48;
        goto L18
    L14:
        r48 = null;
        goto L15
    L10:
        r310 = null;
        goto L11
    }

    public static /* synthetic */ void b(Context r13, View r14, Content r15, int r16, String r17, a r18, Integer r19, Integer r20, String r21, int r22) {
        if ((r22 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r22 & 32) == 0) goto L9;
        a r8 = null;
    L11:
        if ((r22 & 128) == 0) goto L13;
        Integer r10 = null;
    L15:
        if ((r22 & 256) == 0) goto L17;
        Integer r11 = null;
    L19:
        if ((r22 & 512) == 0) goto L21;
        String r12 = InnerVideoPreloadScene.Unknown.getSceneValue();
    L22:
        a(r13, r14, r15, r16, r7, r8, null, r10, r11, r12);
        return;
    L21:
        r12 = r21;
        goto L22
    L17:
        r11 = r20;
        goto L19
    L13:
        r10 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r7 = r17;
        goto L7
    }
}
