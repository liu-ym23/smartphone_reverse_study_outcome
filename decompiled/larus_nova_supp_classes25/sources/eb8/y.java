package eb8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MixerMedia;
import com.larus.im.bean.message.MultiReference;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VLMImage;
import com.larus.im.bean.message.VLMMixerSearchResult;
import com.larus.im.bean.message.VideoCard;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.im.bean.message.block.SearchQueryResultBlock;
import com.larus.im.bean.message.block.SearchVideoItem;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kc8.w0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y extends jc8.b<fb8.e> {
    public boolean d;
    public kc8.b e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public ib8.f j;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolBlockInitStatus.values().length];
            r0[ToolBlockInitStatus.Fold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ToolBlockInitStatus.Expand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ToolBlockInitStatus.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b extends ib8.k {
        public final /* synthetic */ y i;

        public b(y r2, kc8.b r3) {
            this.i = r2;
            super(r3, null, null, 6);
        }

        @Override // ib8.g
        public final void b(Message r1, st8.a r2, ow8.a r3, LongClickSource r4) {
            Intrinsics.checkNotNullParameter(r2, "anchorView");
            Intrinsics.checkNotNullParameter(r4, "longClickSource");
            kc8.b r5 = (kc8.b) jc8.c.a(this.i, kc8.b.class);
            if (r5 == null) goto L10;
            kc8.y r6 = r5.a;
            if (r6 == null) goto L11;
            kc8.z r7 = r6.A;
            if (r7 == null) goto L12;
            r7.b(null, r2, r4);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    @Override // jc8.b
    public final String c() {
        return "ContentWebSearchBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        ib8.f r0 = this.j;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        ib8.f r1 = this.j;
        if (r1 == null) goto L10;
        st8.a r2 = r1.b();
        if (r2 == null) goto L10;
        ExposeXTrackerExtKt.e(r2);
    L10:
        this.d = true;
    }

    public y() {
        this.d = true;
        this.f = LazyKt.lazy(new p(this));
        this.g = LazyKt.lazy(new q(this));
        this.h = LazyKt.lazy(new r(this));
        this.i = LazyKt.lazy(new s(this));
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r3) {
        fb8.e r4 = (fb8.e) r3;
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        if (r4.n() == false) goto L5;
        int r5 = 14;
    L7:
        return new jc8.d(0, 0, 0, c7.b(Integer.valueOf(r5)));
    L5:
        r5 = 6;
        goto L7
    }

    @Override // jc8.b
    public final void g(jc8.a r3) {
        final fb8.e r4 = (fb8.e) r3;
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        this.e = (kc8.b) jc8.c.a(this, kc8.b.class);
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        k(r4, null);
        b r0 = (b) this.i.getValue();
        r0.h = new m(this, r4);
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        ib8.f r0 = new ib8.f(r2.getContext());
        this.j = r0;
        return r0.b();
    }

    public final BotModel j(Message r71) {
        kc8.b r1 = this.e;
        if (r1 == null) goto L10;
        kc8.y r2 = r1.a;
        if (r2 == null) goto L10;
        Function0<BotModel> r3 = r2.l;
        if (r3 == null) goto L10;
        BotModel r4 = (BotModel) r3.invoke();
        if (r4 == null) goto L10;
    L14:
        return r4;
    L10:
        String r5 = r71.getSenderId();
        if (r5 != null) goto L13;
        r5 = "unknown";
    L13:
        r4 = new BotModel(r5, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(final fb8.e r55, ib8.d0 r56) {
        BlockContent r2 = r55.a.getContent();
        if (r2 == null) goto L5;
        SearchQueryResultBlock r3 = r2.getSearchQueryResultBlock();
    L6:
        if (r3 == null) goto L8;
        List r4 = r3.queries;
    L10:
        if (r3 == null) goto L27;
        List r7 = r3.vlmRichMediaResults;
        if (r7 == null) goto L27;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        SearchImageItem r10 = ((RichMediaItem) r9.next()).image;
        if (r10 == null) goto L15;
        r8.add(r10);
        goto L15
    L19:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r12 = r8.iterator();
    L21:
        if (r12.hasNext() == false) goto L28;
        SearchImageItem r13 = (SearchImageItem) r12.next();
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Long r14 = r13.id;
        String r15 = r13.uri;
        String r16 = r13.thumbUrl;
        List r17 = r13.fullSizeUrl;
        String r18 = r13.mainSiteUrl;
        Integer r5 = r13.height;
        Integer r6 = r13.width;
        Iterator r32 = r12;
        String r19 = r13.authorShortId;
        Long r110 = r13.sourceFrom;
        if (r110 == null) goto L25;
        Integer r111 = Integer.valueOf((int) r110.longValue());
    L26:
        r11.add(new VLMImage(r14, r15, r16, r17, r18, r5, r6, r19, r111, r13.sourceAppName, r13.sourceAppIcon, r13.imgCaption, r13.originThumbUrl, r13.originWidth, r13.originHeight, r13.isBlurBackground, r13.imageSource, r13.docId, r13.searchId));
        r12 = r32;
        goto L21
    L25:
        r111 = null;
    L28:
        if (r3 == null) goto L41;
        List r0 = r3.vlmRichMediaResults;
        if (r0 == null) goto L41;
        ArrayList r1 = new ArrayList();
        Iterator r20 = r0.iterator();
    L33:
        if (r20.hasNext() == false) goto L37;
        SearchVideoItem r21 = ((RichMediaItem) r20.next()).video;
        if (r21 == null) goto L33;
        r1.add(r21);
        goto L33
    L37:
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r23 = r1.iterator();
    L39:
        if (r23.hasNext() == false) goto L42;
        SearchVideoItem r24 = (SearchVideoItem) r23.next();
        Intrinsics.checkNotNullParameter(r24, "<this>");
        r22.add(new MixerMedia(String.valueOf(r24.id), r24.itemId, r24.videoCaptions, r24.albumImage, r24.albumImageHeight, r24.albumImageWidth, r24.sourceFrom, r24.sourceAppName, r24.sourceAppIcon, null, null, null, null, null, null, null, null, null, null, r24.appJumpUrl, 523776, null));
    L42:
        MultiReference r25 = new MultiReference(new VLMMixerSearchResult(r22, r11), r4);
        kc8.b r26 = this.e;
        if (r26 == null) goto L45;
        w0 r27 = r26.v;
    L46:
        Message r28 = r55.j();
        if (r27 == null) goto L49;
        ToolBlockInitStatus r29 = r27.b;
    L50:
        Lazy r30 = qg8.b.a;
        kc8.b r31 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r31 == null) goto L55;
        kc8.y r33 = r31.a;
        if (r33 == null) goto L55;
        q0 r34 = r33.x;
    L56:
        kc8.b r35 = this.e;
        final boolean r112 = false;
        if (r35 == null) goto L61;
        kc8.y r36 = r35.a;
        if (r36 == null) goto L61;
        boolean r37 = Intrinsics.areEqual(r36.h, Boolean.TRUE);
    L62:
        kc8.b r38 = this.e;
        if (r38 == null) goto L71;
        kc8.y r39 = r38.a;
        if (r39 == null) goto L71;
        kc8.j r40 = r39.r;
        if (r40 == null) goto L71;
        Function0<Long> r41 = r40.d;
        if (r41 == null) goto L71;
        Long r42 = (Long) r41.invoke();
    L73:
        if (r29 != null) goto L75;
        int r43 = -1;
    L77:
        if (r43 == (-1)) goto L88;
        if (r43 != 1) goto L80;
        DeepThinkFoldStatus r44 = DeepThinkFoldStatus.CompleteFold;
    L87:
        DeepThinkFoldStatus r45 = r44;
    L89:
        kc8.b r46 = this.e;
        if (r46 == null) goto L94;
        kc8.y r47 = r46.a;
        if (r47 == null) goto L94;
        boolean r48 = Intrinsics.areEqual(r47.g, Boolean.TRUE);
    L95:
        DeepThinkFoldStatus r310 = qg8.b.c(r28, r34, r37, r42, true, r45, r48);
        BlockContent r49 = r55.a.getContent();
        if (r49 == null) goto L98;
        SearchQueryResultBlock r50 = r49.getSearchQueryResultBlock();
    L99:
        ArrayList r51 = new ArrayList();
        if (r50 == null) goto L112;
        List r52 = r50.results;
        if (r52 == null) goto L112;
        Iterator r53 = r52.iterator();
    L105:
        if (r53.hasNext() == false) goto L112;
        Reference r54 = (Reference) r53.next();
        TextCard r57 = r54.getTextCard();
        if (r57 == null) goto L109;
        r51.add(r57);
    L109:
        VideoCard r58 = r54.getVideoCard();
        if (r58 == null) goto L105;
        r51.add(r58);
    L112:
        if (r50 == null) goto L114;
        final String r59 = r50.summary;
    L116:
        if (r59 != null) goto L118;
        r59 = "";
    L118:
        boolean r60 = v19.h.a;
        v19.h.a(null);
        ib8.m r61 = new ib8.m(new t(), new u(r59), String.valueOf(r51.size()));
        Message r311 = r55.j();
        if (r27 == null) goto L121;
        ToolBlockInteractType r62 = r27.a;
    L123:
        if (r62 != ToolBlockInteractType.DisableHeaderInteract) goto L125;
        boolean r312 = true;
    L126:
        if (r27 == null) goto L128;
        ToolBlockInteractType r63 = r27.a;
    L130:
        if (r63 != ToolBlockInteractType.OpenFloatingPage) goto L132;
        v r313 = new v(this, r55);
    L133:
        boolean r410 = r55.i().isEmpty();
        kc8.b r64 = this.e;
        if (r64 == null) goto L138;
        kc8.y r65 = r64.a;
        if (r65 == null) goto L138;
        boolean r510 = Intrinsics.areEqual(r65.g, Boolean.TRUE);
    L139:
        ib8.c0 r113 = new ib8.c0(null, r56, r61, r311, false, r310, r313, r312, r410, false, true, new w(this), false, false, false, null, null, null, false, r510, 2088963);
        ib8.f r66 = this.j;
        if (r66 == null) goto L196;
        Context r114 = r66.getContext();
        if (r114 == null) goto L196;
        if (r25.getVlmMixerResult() == null) goto L196;
        VLMMixerSearchResult r67 = r25.getVlmMixerResult();
        if (r67 == null) goto L150;
        List r68 = r67.getMixerMedias();
    L151:
        List r69 = r68;
        if (r69 != null) goto L154;
    L157:
        boolean r70 = true;
    L158:
        if (r70 == false) goto L172;
        VLMMixerSearchResult r71 = r25.getVlmMixerResult();
        if (r71 == null) goto L162;
        List r72 = r71.getVlmImages();
    L163:
        List r73 = r72;
        if (r73 != null) goto L166;
    L169:
        boolean r74 = true;
    L170:
        if (r74 == false) goto L172;
        VLMMixerSearchResult r75 = null;
        do8.k r115 = null;
    L197:
        kc8.b r76 = this.e;
        if (r76 == null) goto L200;
        VLMMixerSearchResult r116 = r76.b;
    L201:
        List r77 = r25.getSearchQueries();
        if (r77 != null) goto L204;
    L207:
        boolean r78 = true;
    L208:
        if (r78 == false) goto L224;
        BlockContent r79 = r55.a.getContent();
        if (r79 == null) goto L214;
        SearchQueryResultBlock r80 = r79.getSearchQueryResultBlock();
        if (r80 == null) goto L214;
        VLMMixerSearchResult r81 = r80.results;
    L215:
        Collection r82 = (Collection) r81;
        if (r82 != null) goto L218;
    L221:
        boolean r83 = true;
    L222:
        if (r83 == false) goto L224;
        VLMMixerSearchResult r117 = r75;
    L252:
        ib8.b r84 = new ib8.b(r113, r117, null, null, r115, r116, 12);
        ib8.f r85 = this.j;
        if (r85 == null) goto L256;
        r85.a(r84, (b) this.i.getValue());
    L256:
        if (com.larus.im.bean.message.a.v(r55.j()) == true) goto L295;
        kb8.a r86 = r84.b;
        if (r86 == null) goto L265;
        List<Reference> r87 = r86.d;
        if (r87 == null) goto L265;
        if ((!r87.isEmpty()) != true) goto L265;
        boolean r88 = true;
    L266:
        if (r88 == true) goto L294;
        do8.k r89 = r84.e;
        if (r89 == null) goto L271;
        VLMMixerSearchResult r90 = r89.d;
    L272:
        if (r90 == null) goto L274;
        VLMMixerSearchResult r91 = r90.getVlmImages();
    L275:
        Collection r92 = (Collection) r91;
        if (r92 != null) goto L278;
    L281:
        boolean r93 = true;
    L282:
        if (r93 == false) goto L294;
        if (r90 == null) goto L285;
        VLMMixerSearchResult r94 = r90.getMixerMedias();
    L286:
        Collection r95 = (Collection) r94;
        if (r95 != null) goto L289;
    L292:
        boolean r96 = true;
    L293:
        if (r96 == true) goto L295;
    L289:
        if (r95.isEmpty() == true) goto L292;
        r96 = false;
        goto L293
    L285:
        r94 = r75;
        goto L286
    L278:
        if (r92.isEmpty() == true) goto L281;
        r93 = false;
        goto L282
    L274:
        r91 = r75;
        goto L275
    L271:
        r90 = r75;
    L294:
        r112 = true;
    L265:
        r88 = false;
    L295:
        ib8.f r97 = this.j;
        if (r97 == null) goto L320;
        st8.a r99 = r97.b();
        if (r99 == null) goto L321;
        ExposeXTrackerExtKt.b(r99, new x(r55, this, r112));
        return;
    L321:
        return;
    L320:
        return;
    L218:
        if (r82.isEmpty() == true) goto L221;
        r83 = false;
    L214:
        r81 = r75;
    L224:
        Message r210 = r55.j();
        String r100 = r55.j().getMessageId();
        if (r100 != null) goto L227;
        String r211 = "";
    L228:
        List r212 = r25.getSearchQueries();
        BlockContent r101 = r55.a.getContent();
        if (r101 == null) goto L234;
        SearchQueryResultBlock r102 = r101.getSearchQueryResultBlock();
        if (r102 == null) goto L234;
        List r103 = r102.results;
        if (r103 == null) goto L234;
    L235:
        List r213 = r103;
        String r104 = r55.j().getMessageId();
        if (r104 != null) goto L238;
        String r214 = "";
    L239:
        String r105 = r55.j().getConversationId();
        if (r105 != null) goto L242;
        String r215 = "";
    L243:
        String r106 = j(r55.j()).getBotId();
        if (r106 != null) goto L246;
        String r216 = "";
    L247:
        boolean r217 = com.larus.im.bean.message.a.f0(r55.j());
        String r107 = (String) this.g.getValue();
        if (r107 != null) goto L250;
        String r314 = "";
    L251:
        r117 = new kb8.a(r210, r211, r212, r213, new kb8.o(r214, r215, r216, r217, r314), false, 224);
        goto L252
    L250:
        r314 = r107;
        goto L251
    L246:
        r216 = r106;
        goto L247
    L242:
        r215 = r105;
        goto L243
    L238:
        r214 = r104;
    L234:
        r103 = CollectionsKt.emptyList();
        goto L235
    L227:
        r211 = r100;
        goto L228
    L204:
        if (r77.isEmpty() == true) goto L207;
        r78 = false;
        goto L208
    L200:
        r116 = r75;
        goto L201
    L166:
        if (r73.isEmpty() == true) goto L169;
        r74 = false;
        goto L170
    L162:
        r72 = null;
    L172:
        kc8.b r108 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r108 == null) goto L177;
        kc8.y r109 = r108.a;
        if (r109 == null) goto L177;
        Integer r118 = r109.j;
    L178:
        com.larus.bmhome.chat.layout.widget.handler.w r119 = com.larus.bmhome.chat.layout.widget.handler.w.a;
        Message r120 = r55.j();
        de8.c r121 = (de8.c) this.f.getValue();
        if (r121 == null) goto L181;
        Integer r122 = r121.m();
    L182:
        if (r122 == null) goto L184;
        boolean r123 = true;
    L185:
        Boolean r124 = Boolean.valueOf(r123);
        kc8.b r125 = this.e;
        if (r125 == null) goto L190;
        kc8.y r126 = r125.a;
        if (r126 == null) goto L190;
        boolean r218 = Intrinsics.areEqual(r126.h, Boolean.TRUE);
    L191:
        int r315 = com.larus.bmhome.chat.layout.widget.handler.w.c(r119, r114, r120, r118, r124, r218, true, null, this.c, 64);
        VLMMixerSearchResult r127 = r25.getVlmMixerResult();
        if (r127 != null) goto L194;
        r75 = null;
        r127 = new VLMMixerSearchResult(null, null, 3, null);
    L195:
        VLMMixerSearchResult r316 = r127;
        Message r317 = r55.j();
        JSONObject r128 = new JSONObject();
        r128.put("picture_type", "reference");
        r115 = new do8.k(r315, null, r317, r316, 1, false, r128, null, null, null, PreviewScene.SEARCH_IMAGE, null, null, 15266);
        goto L197
    L194:
        r75 = null;
    L190:
        r218 = false;
        goto L191
    L184:
        r123 = false;
        goto L185
    L181:
        r122 = null;
    L177:
        r118 = null;
        goto L178
    L154:
        if (r69.isEmpty() == true) goto L157;
        r70 = false;
        goto L158
    L150:
        r68 = null;
    L196:
        r75 = null;
        r115 = null;
    L138:
        r510 = false;
        goto L139
    L132:
        r313 = 0;
        goto L133
    L128:
        r63 = null;
        goto L130
    L125:
        r312 = false;
        goto L126
    L121:
        r62 = null;
        goto L123
    L114:
        r59 = null;
        goto L116
    L98:
        r50 = null;
    L94:
        r48 = false;
        goto L95
    L80:
        if (r43 == 2) goto L85;
        if (r43 == 3) goto L88;
        throw new NoWhenBranchMatchedException();
    L85:
        r44 = DeepThinkFoldStatus.CompleteExpand;
    L88:
        r45 = null;
        goto L89
    L75:
        r43 = a.a[r29.ordinal()];
    L71:
        r42 = null;
    L61:
        r37 = false;
    L55:
        r34 = null;
        goto L56
    L49:
        r29 = null;
        goto L50
    L45:
        r27 = null;
    L41:
        r22 = null;
    L27:
        r11 = null;
        goto L28
    L8:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
