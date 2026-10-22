package pl8;

import android.content.Context;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.l;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final Lazy a;
    public ql8.a b;
    public pl8.a c;
    public final b d;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.b {
        public final /* synthetic */ k a;

        @Override // com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.b
        public final void a() {
            pl8.a r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public b(k r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.b
        public final void c(SearchImageInfo r42, String r43, int r44, int r45, int r46, Function0<? extends Map<String, ? extends Object>> r47) {
            Intrinsics.checkNotNullParameter(r43, "moduleType");
            k r1 = this.a;
            r1.getClass();
            ri8.c r2 = ri8.c.a;
            if (r42 == null) goto L5;
            Long r3 = r42.getCardId();
        L6:
            String r4 = String.valueOf(r3);
            String r5 = r1.b.c;
            pl8.a r6 = r1.c;
            if (r6 == null) goto L9;
            String r7 = r6.getConversationId();
        L10:
            String r8 = r1.b.e;
            pl8.a r9 = r1.c;
            if (r9 == null) goto L13;
            String r10 = r9.getCurrentPage();
        L14:
            pl8.a r11 = r1.c;
            if (r11 == null) goto L17;
            String r12 = r11.b();
        L18:
            pl8.a r13 = r1.c;
            if (r13 == null) goto L21;
            String r14 = r13.getBotId();
        L22:
            String r15 = ri8.c.h(r44, r45);
            ql8.a r16 = r1.b;
            Integer r17 = r16.h;
            String r18 = r16.f;
            Integer[] r19 = new Integer[2];
            int r110 = 0;
            if (r42 == null) goto L27;
            Integer r111 = r42.getOriginWidth();
            if (r111 == null) goto L27;
            int r112 = r111.intValue();
        L28:
            r19[0] = Integer.valueOf(r112);
            if (r42 == null) goto L33;
            Integer r113 = r42.getOriginHeight();
            if (r113 == null) goto L33;
            r110 = r113.intValue();
        L33:
            r19[1] = Integer.valueOf(r110);
            List r21 = CollectionsKt.listOf(r19);
            ql8.a r20 = r1.b;
            Integer r114 = r20.h;
            int r115 = r46 + 1;
            LruCache<String, wc9.e> r116 = ko8.a.a;
            String r22 = ko8.a.c(r20.a());
            if (r22 != null) goto L36;
            String r27 = "";
        L37:
            String r23 = ko8.a.d(r1.b.a());
            if (r23 != null) goto L40;
            String r28 = "";
        L41:
            if (r42 == null) goto L43;
            String r31 = r42.getDocId();
        L44:
            if (r42 == null) goto L46;
            String r29 = r42.getImageSource();
        L47:
            ri8.c.n(null, r4, r5, r7, r8, r10, r12, r114, Integer.valueOf(r115), "slideshow", "within_text", "picture", r14, r15, r43, r17, null, r18, null, null, r21, null, null, null, null, null, r27, r28, r29, null, r31, null, null, null, null, null, r47, null, -1544749055, 47);
            return;
        L46:
            r29 = null;
            goto L47
        L43:
            r31 = null;
            goto L44
        L40:
            r28 = r23;
            goto L41
        L36:
            r27 = r22;
        L27:
            r112 = 0;
            goto L28
        L21:
            r14 = null;
            goto L22
        L17:
            r12 = null;
            goto L18
        L13:
            r10 = null;
            goto L14
        L9:
            r7 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.b
        public final void b(Context r24, List<? extends View> r25, int r26, int r27, int r28, String r29, Function1<? super Integer, Unit> r30, Function0<? extends Map<String, ? extends Object>> r31) {
            int r8 = r28;
            Intrinsics.checkNotNullParameter(r24, "context");
            Intrinsics.checkNotNullParameter(r25, "imageViewList");
            Intrinsics.checkNotNullParameter(r29, "mobModuleType");
            k r2 = this.a;
            ql8.a r3 = r2.b;
            int r9 = 0;
            if (r3.l == null) goto L21;
            Message r1 = r3.a();
            if (r1 == null) goto L7;
            List r4 = rl8.g.c(r1);
        L8:
            int r5 = r4.indexOf(this.a.b.b);
            if (r5 <= 0) goto L17;
            int r6 = 0;
        L11:
            if (r6 >= r5) goto L17;
            List r7 = ((com.larus.bmhome.chat.markdown.imagegroup.a) ListProtector.get(r4, r6)).c();
            if (r7 == null) goto L15;
            int r10 = r7.size();
        L16:
            r8 = r8 + r10;
            r6 = r6 + 1;
            goto L11
        L15:
            r10 = 0;
        L17:
            Function1<Integer, Unit> r11 = this.a.b.l;
            if (r11 == null) goto L150;
            r11.invoke(Integer.valueOf(r8));
            return;
        L150:
            return;
        L7:
            r4 = CollectionsKt.emptyList();
            goto L8
        L21:
            if (((Boolean) r2.a.getValue()).booleanValue() == true) goto L23;
        L66:
            k r12 = this.a;
            List r13 = r12.b.b.c();
            if (r13 == null) goto L154;
            List<? extends View> r14 = r25;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator<T> r16 = r14.iterator();
            int r17 = 0;
        L71:
            if (r16.hasNext() == false) goto L76;
            Object r18 = r16.next();
            int r19 = r17 + 1;
            if (r17 >= 0) goto L75;
            CollectionsKt.throwIndexOverflow();
        L75:
            r15.add(TuplesKt.to(Integer.valueOf(r17), (View) r18));
            r17 = r19;
            goto L71
        L76:
            r12.b((SearchImageInfo) CollectionsKt.getOrNull(r13, r8), r29, r26, r27, r28);
            List r20 = k.a(r13);
            Pair[] r21 = new Pair[14];
            r21[0] = TuplesKt.to("user_type", "bot");
            String r22 = "chat";
            r21[1] = TuplesKt.to("enter_picture_method", "chat");
            pl8.a r23 = r12.c;
            if (r23 == null) goto L79;
            boolean r32 = Intrinsics.areEqual(r23.d(), Boolean.TRUE);
        L80:
            if (r32 == false) goto L82;
            r22 = "temporary_chat";
        L82:
            r21[2] = TuplesKt.to("enter_from", r22);
            pl8.a r33 = r12.c;
            String r34 = "";
            if (r33 == null) goto L86;
            String r35 = r33.getBotId();
            if (r35 == null) goto L86;
        L87:
            int r110 = 3;
            r21[3] = TuplesKt.to("bot_id", r35);
            pl8.a r36 = r12.c;
            if (r36 == null) goto L91;
            String r37 = r36.getChatType();
            if (r37 == null) goto L91;
        L92:
            r21[4] = TuplesKt.to("chat_type", r37);
            pl8.a r38 = r12.c;
            if (r38 == null) goto L96;
            String r39 = r38.b();
            if (r39 == null) goto L96;
        L97:
            r21[5] = TuplesKt.to("previous_page", r39);
            pl8.a r40 = r12.c;
            if (r40 == null) goto L101;
            String r41 = r40.getCurrentPage();
            if (r41 == null) goto L101;
        L102:
            r21[6] = TuplesKt.to("current_page", r41);
            pl8.a r42 = r12.c;
            if (r42 == null) goto L106;
            String r43 = r42.getConversationId();
            if (r43 == null) goto L106;
        L107:
            r21[7] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r43);
            r21[8] = TuplesKt.to("rich_media_type", "mixed_picture");
            r21[9] = TuplesKt.to("reply_id", String.valueOf(r12.b.e));
            r21[10] = TuplesKt.to("req_id", String.valueOf(r12.b.f));
            r21[11] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, String.valueOf(r12.b.c));
            LruCache<String, wc9.e> r44 = ko8.a.a;
            String r45 = ko8.a.c(r12.b.a());
            if (r45 != null) goto L110;
            r45 = "";
        L110:
            r21[12] = TuplesKt.to("agent_id", r45);
            String r46 = ko8.a.d(r12.b.a());
            if (r46 == null) goto L114;
            r34 = r46;
        L114:
            r21[13] = TuplesKt.to("agent_tool", r34);
            Map r47 = MapsKt.mapOf(r21);
            if (r31 == null) goto L118;
            Map r48 = (Map) r31.invoke();
            if (r48 == null) goto L118;
        L119:
            Map r49 = MapsKt.plus(r47, r48);
            List r111 = r13;
            ArrayList r50 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator r51 = r111.iterator();
            int r52 = 0;
        L121:
            if (r51.hasNext() == false) goto L132;
            Object r112 = r51.next();
            int r113 = r52 + 1;
            if (r52 >= 0) goto L125;
            CollectionsKt.throwIndexOverflow();
        L125:
            SearchImageInfo r114 = (SearchImageInfo) r112;
            Pair[] r53 = new Pair[r110];
            ri8.c r115 = ri8.c.a;
            r53[0] = TuplesKt.to("image_resolution", ri8.c.a(CollectionsKt.listOf(new Integer[]{r114.getOriginWidth(), r114.getOriginHeight()})));
            r53[1] = TuplesKt.to("card_id", String.valueOf(r114.getCardId()));
            r53[2] = TuplesKt.to("position", Integer.valueOf(r113));
            Map r54 = MapsKt.mutableMapOf(r53);
            String r116 = r114.getImageSource();
            if (r116 == null) goto L128;
            r54.put("tool_name", r116);
        L128:
            String r117 = r114.getDocId();
            if (r117 == null) goto L131;
            r54.put("doc_id", r117);
        L131:
            r50.add(r54);
            r52 = r113;
            r110 = 3;
            goto L121
        L132:
            uo8.k r55 = new uo8.k(r49, r50);
            pl8.a r56 = r12.c;
            if (r56 == null) goto L135;
            String r210 = r56.getChatType();
        L136:
            com.larus.bmhome.bigimg.k.c(r24, r15, r20, r28, r55, true, new HybridEventParams("message_markdown_image", "chat", r210, null, 120), r12.b.c, false, r30, null, null, null, 15104);
            return;
        L135:
            r210 = null;
        L118:
            r48 = MapsKt.emptyMap();
        L106:
            r43 = "";
        L101:
            r41 = "";
        L96:
            r39 = "";
        L91:
            r37 = "";
        L86:
            r35 = "";
            goto L87
        L79:
            r32 = false;
            goto L80
        L154:
            return;
        L23:
            if (Intrinsics.areEqual(this.a.b.k, Boolean.TRUE) == true) goto L66;
            k r118 = this.a;
            List r119 = r118.b.b.c();
            if (r119 == null) goto L153;
            r118.b((SearchImageInfo) CollectionsKt.getOrNull(r119, r8), r29, r26, r27, r28);
            Message r57 = r118.b.a();
            if (r57 == null) goto L30;
            List r58 = rl8.g.c(r57);
        L31:
            int r59 = r58.indexOf(r118.b.b);
            if (r59 < 0) goto L43;
            ArrayList r60 = new ArrayList();
            int r61 = r58.size();
            int r62 = r8;
        L34:
            if (r9 >= r61) goto L42;
            List r63 = ((com.larus.bmhome.chat.markdown.imagegroup.a) ListProtector.get(r58, r9)).c();
            if (r63 != null) goto L38;
            r63 = CollectionsKt.emptyList();
        L38:
            List r64 = k.a(r63);
            r60.add(r64);
            if (r9 >= r59) goto L41;
            r62 = r62 + ((ArrayList) r64).size();
        L41:
            r9 = r9 + 1;
            goto L34
        L42:
            List r65 = r60;
            int r66 = r62;
        L44:
            FLogger.a.i("ImageGroupLegacyViewModel", "clickImageViewWithNewPreview, groupIndex = " + r59 + ", imageIndex = " + r66);
            pl8.a r67 = r118.c;
            if (r67 == null) goto L47;
            BotModel r68 = r67.i();
        L48:
            Message r69 = r118.b.a();
            pl8.a r70 = r118.c;
            if (r70 == null) goto L51;
            com.larus.trace.tracknode.a r71 = r70.f();
        L52:
            pl8.a r72 = r118.c;
            if (r72 == null) goto L56;
            LifecycleCoroutineScope r73 = r72.c();
            if (r73 == null) goto L56;
        L57:
            LifecycleCoroutineScope r74 = r73;
            pl8.a r75 = r118.c;
            if (r75 == null) goto L60;
            q0 r120 = r75.getAdapter();
        L61:
            ty8.a r121 = new ty8.a(r68, r69, r71, r74, r120, r66, r24, (View) CollectionsKt.getOrNull(r25, r8), 0, 16128);
            Lazy r76 = rl8.c.a;
            pl8.a r77 = r118.c;
            if (r77 == null) goto L64;
            FragmentManager r122 = r77.getFragmentManager();
        L65:
            PreviewScene r78 = PreviewScene.SEARCH_IMAGE;
            JSONObject r79 = new JSONObject();
            r79.put("picture_type", "mixed_picture");
            Unit r80 = Unit.INSTANCE;
            rl8.c.a(r122, r121, r65, r78, 0, null, r79, null);
            return;
        L64:
            r122 = null;
            goto L65
        L60:
            r120 = null;
        L56:
            r73 = CoroutineScopeKt.MainScope();
            goto L57
        L51:
            r71 = null;
            goto L52
        L47:
            r68 = null;
            goto L48
        L43:
            r65 = CollectionsKt.listOf(k.a(r119));
            r66 = r8;
            goto L44
        L30:
            r58 = CollectionsKt.emptyList();
            goto L31
        }
    }

    static {
    }

    public k() {
        this.a = LazyKt.lazy(new j());
        this.b = new ql8.a(null, 4095);
        this.d = new b(this);
    }

    public static List a(List r17) {
        List r0 = r17;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L37;
        SearchImageInfo r3 = (SearchImageInfo) r2.next();
        String r4 = r3.getItemId();
        String r5 = "";
        if (r4 != null) goto L8;
        String r6 = "";
    L9:
        List r7 = r3.getFullSizeUrl();
        if (r7 == null) goto L13;
        String r8 = (String) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L13;
    L14:
        if (r8 != null) goto L16;
        String r9 = "";
    L17:
        String r10 = r3.getUri();
        if (r10 != null) goto L20;
        String r11 = "";
    L21:
        String r12 = r3.getAuthorShortId();
        String r13 = r3.getSourceAppName();
        String r14 = r3.getSourceAppIcon();
        Integer r15 = r3.getSourceFrom();
        String r16 = r3.getMainSiteUrl();
        String r18 = r3.getOriginThumbUrl();
        if (r18 != null) goto L24;
    L27:
        boolean r19 = true;
    L28:
        if (r19 == true) goto L32;
        String r20 = r3.getOriginThumbUrl();
        if (r20 == null) goto L34;
    L35:
        r5 = r20;
    L34:
        String r21 = r5;
        r1.add(new l(r6, r9, r11, r21, r12, r13, r14, r15, r16, r3.getImgCaption(), 1024));
        goto L4
    L32:
        r20 = r3.getThumbUrl();
        if (r20 != null) goto L35;
    L24:
        if (r18.length() == 0) goto L27;
        r19 = false;
        goto L28
    L20:
        r11 = r10;
        goto L21
    L16:
        r9 = r8;
    L13:
        r8 = r3.getThumbUrl();
        goto L14
    L8:
        r6 = r4;
        goto L9
    L37:
        return r1;
    }

    public final void b(SearchImageInfo r44, String r45, int r46, int r47, int r48) {
        ri8.c r1 = ri8.c.a;
        String r2 = null;
        if (r44 == null) goto L7;
        Long r3 = r44.getCardId();
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L8:
        String r5 = this.b.c;
        pl8.a r6 = this.c;
        if (r6 == null) goto L11;
        String r7 = r6.getConversationId();
    L12:
        String r8 = this.b.e;
        pl8.a r9 = this.c;
        if (r9 == null) goto L15;
        String r10 = r9.getCurrentPage();
    L16:
        pl8.a r11 = this.c;
        if (r11 == null) goto L19;
        String r12 = r11.b();
    L20:
        pl8.a r13 = this.c;
        if (r13 == null) goto L23;
        String r14 = r13.getBotId();
    L24:
        String r15 = ri8.c.h(r46, r47);
        ql8.a r16 = this.b;
        Integer r17 = r16.h;
        String r18 = r16.f;
        int r19 = r48 + 1;
        Integer[] r110 = new Integer[2];
        int r111 = 0;
        if (r44 == null) goto L29;
        Integer r112 = r44.getOriginWidth();
        if (r112 == null) goto L29;
        int r113 = r112.intValue();
    L30:
        r110[0] = Integer.valueOf(r113);
        if (r44 == null) goto L35;
        Integer r114 = r44.getOriginHeight();
        if (r114 == null) goto L35;
        r111 = r114.intValue();
    L35:
        r110[1] = Integer.valueOf(r111);
        List r24 = CollectionsKt.listOf(r110);
        LruCache<String, wc9.e> r115 = ko8.a.a;
        String r116 = ko8.a.c(this.b.a());
        if (r116 != null) goto L38;
        String r29 = "";
    L39:
        String r117 = ko8.a.d(this.b.a());
        if (r117 != null) goto L42;
        String r30 = "";
    L43:
        if (r44 == null) goto L45;
        String r34 = r44.getDocId();
    L46:
        if (r44 == null) goto L48;
        r2 = r44.getImageSource();
    L48:
        ri8.c.m(r4, r5, r7, r8, r10, r12, r17, Integer.valueOf(r19), "slideshow", "within_text", "picture", r14, r15, r45, "open_media", null, r17, null, r18, null, null, r24, null, null, null, null, r29, r30, r2, null, null, r34, null, null, null, this.b.i, null, null, 1675264000, 55);
        return;
    L45:
        r34 = null;
        goto L46
    L42:
        r30 = r117;
        goto L43
    L38:
        r29 = r116;
    L29:
        r113 = 0;
        goto L30
    L23:
        r14 = null;
        goto L24
    L19:
        r12 = null;
        goto L20
    L15:
        r10 = null;
        goto L16
    L11:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }
}
