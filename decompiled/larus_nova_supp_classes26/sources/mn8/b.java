package mn8;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.chat.standarduikit.searchmixedmedia.view.SearchMixedMediaView;
import com.larus.bmhome.searchmixedmedia.RatioMode;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.AuthorInfo;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ContentCover;
import com.larus.im.bean.message.block.ContentDescription;
import com.larus.im.bean.message.block.ImageDetailStruct;
import com.larus.im.bean.message.block.InteractInfo;
import com.larus.im.bean.message.block.InteractionStatistic;
import com.larus.im.bean.message.block.InteractionStatus;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.bean.message.block.SearchRichMediaBlock;
import com.larus.im.bean.message.block.SearchVideoContainerAttribute;
import com.larus.im.bean.message.block.UgcItem;
import com.larus.im.bean.message.block.UrlStruct;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc8.d;
import kc8.t0;
import kc8.y;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ln8.c;
import on8.h;
import on8.i;
import on8.j;
import pr8.e;
import xc8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public kc8.b d;
    public c e;
    public Message f;

    public final String c() {
        return "SearchMixedMediaBlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((a) r2, "blockModel");
        return new d(0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    public final void g(jc8.a r31) {
        a r1 = (a) r31;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.d = jc8.c.a(this, kc8.b.class);
        this.f = r1.j();
        BlockContent r2 = ((jc8.a) r1).a.getContent();
        if (r2 == null) goto L284;
        SearchRichMediaBlock r3 = r2.getRichMediaBlock();
        if (r3 == null) goto L289;
        List r4 = r3.creations;
        boolean r5 = false;
        if (r4 == null) goto L27;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r4.iterator();
    L11:
        if (r7.hasNext() == false) goto L21;
        Object r8 = r7.next();
        Integer r9 = ((RichMediaItem) r8).type;
        int r10 = RichMediaType.UGC.getValue();
        if (r9 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        if (r11 == false) goto L11;
        r6.add(r8);
        goto L11
    L16:
        if (r9.intValue() != r10) goto L18;
        r11 = true;
        goto L19
    L21:
        ?? r12 = new ArrayList();
        Iterator r13 = r6.iterator();
    L23:
        if (r13.hasNext() == false) goto L28;
        UgcItem r14 = ((RichMediaItem) r13.next()).ugcItem;
        if (r14 == null) goto L23;
        r12.add(r14);
    L28:
        if (r12 != 0) goto L30;
        r12 = CollectionsKt.emptyList();
    L30:
        RatioMode r15 = RatioMode.FIXED;
        Message r16 = this.f;
        if (r16 == null) goto L35;
        Map r17 = r16.getBusinessExt();
        if (r17 == null) goto L35;
        String r18 = (String) r17.get("share_pic_mode");
    L37:
        if (Intrinsics.areEqual(r18, "1") == false) goto L40;
        ExpandCardViewMode r19 = ExpandCardViewMode.EXPAND_PIC;
    L39:
        ExpandCardViewMode r20 = r19;
        SearchVideoContainerAttribute r21 = r3.containerAttribute;
        if (r21 == null) goto L50;
        String r110 = r21.videoTitle;
    L51:
        Message r22 = this.f;
        if (r22 == null) goto L54;
        String r111 = r22.getMessageId();
    L55:
        on8.a r112 = new on8.a(r15, r12, r20, r110, r111);
        Message r23 = this.f;
        if (r23 == null) goto L68;
        kc8.b r24 = this.d;
        if (r24 == null) goto L64;
        y r25 = r24.a;
        if (r25 == null) goto L64;
        q0 r26 = r25.x;
        if (r26 == null) goto L64;
        List<Message> r27 = r26.getCurrentList();
    L66:
        if (m.b(r23, r27) != true) goto L68;
        boolean r113 = true;
    L69:
        h r114 = new h(this.f, r12, Intrinsics.areEqual(r3.videoInfinite, Boolean.TRUE), r113, this.d);
        c r28 = this.e;
        String r29 = "";
        if (r28 == null) goto L195;
        Intrinsics.checkNotNullParameter(r112, "vmData");
        j r30 = (j) r28.b.getValue();
        r30.getClass();
        Intrinsics.checkNotNullParameter(r112, "vmData");
        r30.a = r112;
        r30.b = r114;
        j r32 = (j) r28.b.getValue();
        List<UgcItem> r33 = r32.a.b;
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r35 = r33.iterator();
    L73:
        if (r35.hasNext() == false) goto L194;
        UgcItem r115 = (UgcItem) r35.next();
        String r116 = r32.a.e;
        ContentCover r117 = r115.getCover();
        if (r117 == null) goto L82;
        ImageDetailStruct r118 = r117.getSelectedCover();
        if (r118 == null) goto L82;
        UrlStruct r119 = r118.getImageOri();
        if (r119 == null) goto L82;
        String r120 = r119.getUrl();
        if (r120 == null) goto L82;
    L97:
        String r121 = r120;
    L98:
        if (r117 == null) goto L106;
        ImageDetailStruct r122 = r117.getSelectedCover();
        if (r122 == null) goto L106;
        UrlStruct r123 = r122.getImageOri();
        if (r123 == null) goto L106;
        Long r124 = r123.getWidth();
        if (r124 == null) goto L106;
        String r210 = r29;
        Integer r36 = Integer.valueOf((int) r124.longValue());
    L123:
        Integer r125 = r36;
    L125:
        if (r117 == null) goto L133;
        ImageDetailStruct r37 = r117.getSelectedCover();
        if (r37 == null) goto L133;
        UrlStruct r38 = r37.getImageOri();
        if (r38 == null) goto L133;
        Long r39 = r38.getHeight();
        if (r39 == null) goto L133;
        Integer r40 = Integer.valueOf((int) r39.longValue());
    L149:
        Integer r126 = r40;
    L151:
        ContentDescription r41 = r115.getContentDescription();
        if (r41 == null) goto L155;
        String r42 = r41.getDescription();
        if (r42 == null) goto L155;
    L161:
        String r211 = r42;
    L162:
        AuthorInfo r43 = r115.getAuthorInfo();
        if (r43 == null) goto L169;
        IconImage r44 = r43.getAvatar();
        if (r44 == null) goto L169;
        ImageObj r45 = r44.imageThumb;
        if (r45 == null) goto L169;
        String r212 = r45.url;
    L170:
        AuthorInfo r46 = r115.getAuthorInfo();
        if (r46 == null) goto L173;
        String r213 = r46.getNickName();
    L174:
        InteractInfo r47 = r115.getInteractInfo();
        if (r47 == null) goto L179;
        InteractionStatus r48 = r47.getStatus();
        if (r48 == null) goto L179;
        Boolean r214 = Boolean.valueOf(r48.isLiked());
    L180:
        InteractInfo r49 = r115.getInteractInfo();
        if (r49 == null) goto L186;
        InteractionStatistic r50 = r49.getStatistic();
        if (r50 == null) goto L186;
        String r51 = r50.getFormattedLikedCount();
        if (r51 == null) goto L186;
    L191:
        String r215 = r51;
    L193:
        r34.add(new pr8.c(r115.getItemId(), r121, r125, r126, r115.getItemType(), r211, r212, r213, r214, r215, r115.getRequestId(), r115.getRecChannelId(), "chat_first_card", r116));
        r29 = r210;
    L186:
        InteractInfo r52 = r115.getInteractInfo();
        if (r52 == null) goto L192;
        InteractionStatistic r53 = r52.getStatistic();
        if (r53 == null) goto L192;
        r51 = Long.valueOf(r53.getLikedCount()).toString();
    L192:
        r215 = r210;
    L179:
        r214 = null;
        goto L180
    L173:
        r213 = null;
    L169:
        r212 = null;
    L155:
        ContentDescription r54 = r115.getContentDescription();
        if (r54 == null) goto L158;
        r42 = r54.getTitle();
    L159:
        if (r42 != null) goto L161;
        r211 = r210;
        goto L162
    L158:
        r42 = null;
    L133:
        if (r117 == null) goto L141;
        ImageDetailStruct r55 = r117.getOriginCover();
        if (r55 == null) goto L141;
        UrlStruct r56 = r55.getImageOri();
        if (r56 == null) goto L141;
        Long r57 = r56.getHeight();
        if (r57 == null) goto L141;
        r40 = Integer.valueOf((int) r57.longValue());
    L141:
        if (r117 == null) goto L150;
        ImageDetailStruct r58 = r117.getDynamicCover();
        if (r58 == null) goto L150;
        UrlStruct r59 = r58.getImageOri();
        if (r59 == null) goto L150;
        Long r60 = r59.getHeight();
        if (r60 == null) goto L150;
        r40 = Integer.valueOf((int) r60.longValue());
    L150:
        r126 = null;
    L106:
        r210 = r29;
        if (r117 == null) goto L115;
        ImageDetailStruct r61 = r117.getOriginCover();
        if (r61 == null) goto L115;
        UrlStruct r62 = r61.getImageOri();
        if (r62 == null) goto L115;
        Long r63 = r62.getWidth();
        if (r63 == null) goto L115;
        r36 = Integer.valueOf((int) r63.longValue());
    L115:
        if (r117 == null) goto L124;
        ImageDetailStruct r64 = r117.getDynamicCover();
        if (r64 == null) goto L124;
        UrlStruct r65 = r64.getImageOri();
        if (r65 == null) goto L124;
        Long r66 = r65.getWidth();
        if (r66 == null) goto L124;
        r36 = Integer.valueOf((int) r66.longValue());
    L124:
        r125 = null;
    L82:
        if (r117 == null) goto L88;
        ImageDetailStruct r127 = r117.getOriginCover();
        if (r127 == null) goto L88;
        UrlStruct r128 = r127.getImageOri();
        if (r128 == null) goto L88;
        r120 = r128.getUrl();
    L89:
        if (r120 != null) goto L97;
        if (r117 == null) goto L96;
        ImageDetailStruct r129 = r117.getDynamicCover();
        if (r129 == null) goto L96;
        UrlStruct r130 = r129.getImageOri();
        if (r130 == null) goto L96;
        r120 = r130.getUrl();
    L96:
        r121 = null;
    L88:
        r120 = null;
        goto L89
    L194:
        String r216 = r29;
        List r131 = CollectionsKt.take(r34, ((Number) com.larus.bmhome.video.b.a().getFirst()).intValue());
        RatioMode r132 = r32.a.a;
        int r133 = ((Number) com.larus.bmhome.video.b.a().getSecond()).intValue();
        on8.a r67 = r32.a;
        e r68 = new e(r132, r133, r131, r67.c, r67.d);
        j r69 = (j) r28.b.getValue();
        r69.getClass();
        ((SearchMixedMediaView) r28.a.getValue()).a(r68, new i(r69));
        ((SearchMixedMediaView) r28.a.getValue()).b(r112.c);
    L196:
        Intrinsics.checkNotNullParameter(r12, "ugcItems");
        ArrayList r70 = new ArrayList();
        Iterator r71 = ((Iterable) r12).iterator();
    L198:
        if (r71.hasNext() == false) goto L221;
        UgcItem r72 = (UgcItem) r71.next();
        String r73 = r72.getItemId();
        if (r73 != null) goto L202;
    L205:
        boolean r74 = true;
    L206:
        if (r74 == false) goto L208;
        pr9.a r75 = null;
    L219:
        if (r75 == null) goto L198;
        r70.add(r75);
        goto L198
    L208:
        String r76 = r72.getItemId();
        if (r76 != null) goto L211;
        r76 = r216;
    L211:
        Integer r77 = r72.getItemType();
        int r78 = ItemType.ARTICLE.getValue();
        if (r77 != null) goto L215;
    L217:
        boolean r79 = false;
    L218:
        r75 = new pr9.a(r76, r79, 12);
        goto L219
    L215:
        if (r77.intValue() != r78) goto L217;
        r79 = true;
        goto L218
    L202:
        if (r73.length() == 0) goto L205;
        r74 = false;
        goto L206
    L221:
        IFlowSdkDepend r80 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r80 == null) goto L231;
        r2 r81 = r80.A0();
        if (r81 == null) goto L231;
        Message r82 = r114.a;
        if (r82 == null) goto L228;
        String r83 = r82.getMessageId();
    L229:
        List r84 = r81.h(r83, 0);
        if (r84 == null) goto L231;
    L232:
        qr9.c r85 = VideoFeedProviderDelegate.b.b();
        if (r85 == null) goto L235;
        r85.b(CollectionsKt.plus(r70, r84));
    L235:
        kc8.b r86 = this.d;
        if (r86 == null) goto L242;
        y r87 = r86.a;
        if (r87 == null) goto L242;
        Function1 r88 = r87.B;
        if (r88 == null) goto L242;
        r88.invoke(Boolean.FALSE);
    L242:
        kc8.b r89 = this.d;
        if (r89 == null) goto L247;
        y r90 = r89.a;
        if (r90 == null) goto L247;
        Fragment r91 = r90.a;
    L249:
        if ((r91 instanceof xe8.a) == false) goto L251;
        xe8.a r92 = (xe8.a) r91;
    L252:
        if (r92 == null) goto L257;
        if (r92.F50() != true) goto L257;
        r5 = true;
    L257:
        if ((!r5) == false) goto L285;
        kc8.b r93 = this.d;
        if (r93 == null) goto L286;
        y r94 = r93.a;
        if (r94 == null) goto L287;
        Function0 r95 = r94.C;
        if (r95 == null) goto L288;
        r95.invoke();
        return;
    L288:
        return;
    L287:
        return;
    L286:
        return;
    L285:
        return;
    L251:
        r92 = null;
    L247:
        r91 = null;
        goto L249
    L228:
        r83 = null;
    L231:
        r84 = CollectionsKt.emptyList();
        goto L232
    L195:
        r216 = "";
    L64:
        r27 = null;
    L68:
        r113 = false;
        goto L69
    L54:
        r111 = null;
        goto L55
    L50:
        r110 = null;
        goto L51
    L40:
        kc8.b r96 = this.d;
        if (r96 == null) goto L46;
        t0 r97 = r96.h;
        if (r97 == null) goto L46;
        r19 = r97.a;
        if (r19 != null) goto L39;
    L46:
        r19 = ExpandCardViewMode.NORMAL;
    L35:
        r18 = null;
        goto L37
    L27:
        r12 = 0;
        goto L28
    L289:
        return;
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        c r0 = this.e;
        if (r0 != null) goto L6;
        r0 = new c(r2.getContext());
        this.e = r0;
    L6:
        return (SearchMixedMediaView) r0.a.getValue();
    }
}
