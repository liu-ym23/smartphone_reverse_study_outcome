package com.larus.bmhome.chat.standarduikit.imagegroup.binder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.ImageGroupLegacyView;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.x;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.y;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.VLMImage;
import com.larus.im.bean.message.VLMMixerSearchResult;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import do8.j;
import do8.k;
import fh8.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import rl8.g;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ImageGroupBinder implements usc.f {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public String f;
    public Job g;
    public Integer h;

    public final void a() {
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, usc.e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final void f() {
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L9;
        ConcurrentHashMap<String, WeakReference<Message>> r0 = g.a;
        String r1 = this.f;
        if (r1 == null) goto L9;
        g.a.remove(r1);
    L9:
        if (g() == false) goto L15;
        Job r2 = this.g;
        if (r2 == null) goto L13;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L13:
        this.g = null;
        return;
    L15:
        ImageGroupLegacyView r3 = (ImageGroupLegacyView) ((ol8.c) this.c.getValue()).a.getValue();
        Iterator<T> r4 = r3.d.iterator();
    L17:
        if (r4.hasNext() == false) goto L19;
        ExposeXTrackerExtKt.e((View) r4.next());
        goto L17
    L19:
        r3.d.clear();
        Job r5 = this.g;
        if (r5 == null) goto L22;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L22:
        this.g = null;
    }

    public final boolean g() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    public final View asView() {
        if (g() == false) goto L6;
        return ((bo8.c) this.d.getValue()).b();
    L6:
        return (ImageGroupLegacyView) ((ol8.c) this.c.getValue()).a.getValue();
    }

    public ImageGroupBinder(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new a());
        this.b = LazyKt.lazy(new b());
        this.c = LazyKt.lazy(new c(r2));
        this.d = LazyKt.lazy(new d(r2));
        this.e = LazyKt.lazy(new e());
    }

    public static com.larus.bmhome.chat.markdown.imagegroup.a h(final usc.e r34, final Message r35) {
        wc8.b r2 = wc8.b.a;
        if (r35 == null) goto L5;
        String r4 = r35.getMessageId();
    L6:
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        RichMediaMeta r3 = r2.h(r4, r34.k(), "ImageGroupWidget");
        if (r3 == null) goto L92;
        ContainerAttribute r5 = r3.getContainerAttribute();
        if (r5 == null) goto L15;
        Boolean r6 = r5.isTop();
        if (r6 == null) goto L15;
        boolean r7 = r6.booleanValue();
    L16:
        ContainerAttribute r8 = r3.getContainerAttribute();
        if (r8 == null) goto L19;
        Integer r9 = r8.getImageShowType();
    L20:
        ContainerAttribute r10 = r3.getContainerAttribute();
        if (r10 == null) goto L23;
        Integer r11 = r10.getImageShowTypeVersion();
    L24:
        List r12 = r3.getMedia();
        if (r12 == null) goto L90;
        List r13 = r12;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L28:
        if (r15.hasNext() == false) goto L89;
        RichMediaItem r16 = (RichMediaItem) r15.next();
        SearchImageItem r17 = r16.image;
        if (r17 == null) goto L32;
        Long r18 = r17.id;
    L33:
        if (r17 == null) goto L35;
        String r19 = r17.itemId;
    L36:
        if (r17 == null) goto L38;
        String r110 = r17.uri;
    L39:
        if (r17 == null) goto L41;
        String r111 = r17.thumbUrl;
    L42:
        if (r17 == null) goto L44;
        String r112 = r17.originThumbUrl;
    L45:
        if (r17 == null) goto L47;
        List r113 = r17.fullSizeUrl;
    L48:
        if (r17 == null) goto L50;
        String r114 = r17.mainSiteUrl;
    L51:
        if (r17 == null) goto L53;
        Integer r115 = r17.width;
    L54:
        if (r17 == null) goto L56;
        Integer r116 = r17.height;
    L57:
        if (r17 == null) goto L59;
        String r20 = r17.docId;
    L60:
        if (r17 == null) goto L62;
        String r21 = r17.authorShortId;
    L63:
        if (r17 == null) goto L67;
        Long r22 = r17.sourceFrom;
        if (r22 == null) goto L67;
        Integer r23 = Integer.valueOf((int) r22.longValue());
    L68:
        SearchImageItem r24 = r16.image;
        if (r24 == null) goto L71;
        String r25 = r24.sourceAppName;
    L72:
        if (r24 == null) goto L74;
        String r26 = r24.sourceAppIcon;
    L75:
        if (r24 == null) goto L77;
        String r27 = r24.imgCaption;
    L79:
        if (r24 == null) goto L81;
        Integer r28 = r24.originWidth;
    L82:
        if (r24 == null) goto L84;
        Integer r29 = r24.originHeight;
    L85:
        if (r24 == null) goto L87;
        String r210 = r24.imageSource;
    L88:
        r14.add(new SearchImageInfo(r18, r19, r110, r111, r112, r113, r114, r115, r116, r20, r21, r23, r25, r26, r27, null, r28, r29, r210, null, 557056, null));
        r15 = r15;
        goto L28
    L87:
        r210 = null;
        goto L88
    L84:
        r29 = null;
        goto L85
    L81:
        r28 = null;
        goto L82
    L77:
        r27 = null;
        goto L79
    L74:
        r26 = null;
        goto L75
    L71:
        r25 = null;
    L67:
        r23 = null;
        goto L68
    L62:
        r21 = null;
        goto L63
    L59:
        r20 = null;
        goto L60
    L56:
        r116 = null;
        goto L57
    L53:
        r115 = null;
        goto L54
    L50:
        r114 = null;
        goto L51
    L47:
        r113 = null;
        goto L48
    L44:
        r112 = null;
        goto L45
    L41:
        r111 = null;
        goto L42
    L38:
        r110 = null;
        goto L39
    L35:
        r19 = null;
        goto L36
    L32:
        r18 = null;
        goto L33
    L89:
        ArrayList r30 = r14;
    L91:
        com.larus.bmhome.chat.markdown.imagegroup.a r31 = new com.larus.bmhome.chat.markdown.imagegroup.a(r9, r30, r11, Boolean.valueOf(r7), 44);
    L93:
        if (r31 == null) goto L95;
        return r31;
    L95:
        return (com.larus.bmhome.chat.markdown.imagegroup.a) fh8.b.a(r34, new f(r34, r35));
    L90:
        r30 = null;
        goto L91
    L23:
        r11 = null;
        goto L24
    L19:
        r9 = null;
    L15:
        r7 = false;
        goto L16
    L92:
        r31 = null;
        goto L93
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v36, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v48, types: [java.util.ArrayList] */
    public final Size d(TextView r40, Spanned r41, usc.e r42, int r43, Map<String, ? extends Object> r44) {
        Intrinsics.checkNotNullParameter(r40, "textView");
        Intrinsics.checkNotNullParameter(r41, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r42, "span");
        fh8.f r4 = h.b(r44);
        int r3 = 0;
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L29;
        ConcurrentHashMap<String, WeakReference<Message>> r0 = g.a;
        if (r4 == null) goto L7;
        Message r1 = r4.b;
    L8:
        if (r1 == null) goto L23;
        String r2 = r1.getMessageId();
        if (r2 == null) goto L23;
        ConcurrentHashMap<String, WeakReference<Message>> r5 = g.a;
        WeakReference<Message> r11 = r5.get(r2);
        if (r11 == null) goto L19;
        Message r12 = r11.get();
        if (r12 == null) goto L19;
        if (com.larus.bmhome.chat.bean.d.j0(r12) != true) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == true) goto L23;
        r5.put(r2, new WeakReference(r1));
    L19:
        r13 = false;
    L23:
        if (r4 == null) goto L27;
        Message r6 = r4.b;
        if (r6 == null) goto L27;
        String r7 = r6.getMessageId();
    L28:
        this.f = r7;
    L27:
        r7 = null;
        goto L28
    L7:
        r1 = null;
    L29:
        if (r4 == null) goto L31;
        Message r8 = r4.b;
    L176:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L51
        com.larus.bmhome.chat.markdown.imagegroup.a r10 = h(r42, r8);     // Catch: Throwable -> L51
        if (r10 == null) goto L36;
        boolean r14 = Intrinsics.areEqual(r10.d(), Boolean.TRUE);     // Catch: Throwable -> L51
    L37:
        if (r14 == false) goto L49;
        List r15 = r10.c();     // Catch: Throwable -> L51
        if (r15 != null) goto L41;
    L44:
        boolean r16 = true;
    L45:
        if (r16 == true) goto L49;
        if (r10.c().size() >= 3) goto L49;
        r10 = com.larus.bmhome.chat.markdown.imagegroup.a.a(r10, CollectionsKt.listOf(ListProtector.get(r10.c(), 0)));     // Catch: Throwable -> L51
        goto L49
    L41:
        if (r15.isEmpty() == true) goto L44;
        r16 = false;
    L49:
        Object r17 = Result.constructor-impl(r10);     // Catch: Throwable -> L51
    L53:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L57;
        r18.printStackTrace();
    L57:
        if (Result.isFailure-impl(r17) == false) goto L59;
        r17 = null;
    L59:
        com.larus.bmhome.chat.markdown.imagegroup.a r19 = (com.larus.bmhome.chat.markdown.imagegroup.a) r17;
        if (r19 != null) goto L64;
        return new Size(0, 0);
    L64:
        if (r41.getSpanStart(r42) != 0) goto L66;
        boolean r110 = true;
    L68:
        if (r41.getSpanEnd(r42) != r41.length()) goto L70;
        boolean r111 = true;
    L71:
        List r20 = r19.c();
        if (r20 == null) goto L74;
        SearchImageInfo r21 = (SearchImageInfo) CollectionsKt.firstOrNull(r20);
    L75:
        if (r21 == null) goto L79;
        Integer r22 = r21.getWidth();
        if (r22 == null) goto L79;
        int r23 = r22.intValue();
    L80:
        if (r21 == null) goto L84;
        Integer r24 = r21.getHeight();
        if (r24 == null) goto L84;
        int r25 = r24.intValue();
    L85:
        List r112 = r19.c();
        if (r112 == null) goto L88;
        int r113 = r112.size();
    L90:
        if (r23 == 0) goto L94;
        if (r25 == 0) goto L94;
        float r114 = r23 / r25;
    L95:
        com.larus.bmhome.chat.standarduikit.imagegroup.view.a r115 = new com.larus.bmhome.chat.standarduikit.imagegroup.view.a(r43, r110, r111, r113, r114, r19.d());
        Job r26 = this.g;
        if (r26 == null) goto L99;
        Job.DefaultImpls.cancel$default(r26, null, 1, null);
    L99:
        if (g() == false) goto L150;
        List r27 = r19.c();
        if (r27 == null) goto L106;
        List r28 = r27;
        ?? r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L104:
        if (r30.hasNext() == false) goto L107;
        SearchImageInfo r116 = (SearchImageInfo) r30.next();
        Long r117 = r116.getCardId();
        String r118 = r116.getUri();
        String r119 = r116.getThumbUrl();
        String r210 = r116.getOriginThumbUrl();
        r29.add(new VLMImage(r117, r118, r119, r116.getFullSizeUrl(), r116.getMainSiteUrl(), r116.getHeight(), r116.getWidth(), r116.getAuthorShortId(), r116.getSourceFrom(), r116.getSourceAppName(), r116.getSourceAppIcon(), r116.getImgCaption(), r210, r116.getOriginWidth(), r116.getOriginHeight(), null, r116.getImageSource(), r116.getDocId(), r116.getSearchId(), 32768, null));
    L107:
        if (r4 == null) goto L111;
        Message r120 = r4.b;
        if (r120 == null) goto L111;
        int r31 = w.c(w.a, r40.getContext(), r120, 0, Boolean.FALSE, false, false, null, r40, 96);
    L113:
        if (g() == false) goto L115;
        r3 = c7.b(15) * 2;
    L115:
        int r32 = r31 + r3;
        VLMMixerSearchResult r121 = new VLMMixerSearchResult(null, r29, 1, null);
        if (r4 == null) goto L118;
        Message r122 = r4.b;
    L119:
        Integer r33 = this.h;
        if (r33 != null) goto L123;
        r33 = ri8.c.k(r41, r42);
        this.h = r33;
    L123:
        Integer r123 = r33;
        PreviewScene r211 = PreviewScene.SEARCH_IMAGE;
        JSONObject r34 = new JSONObject();
        r34.put("picture_type", "mixed_picture");
        boolean r35 = r115.b;
        boolean r36 = r115.c;
        if (r4 == null) goto L126;
        Function0 r212 = r4.x;
    L127:
        j r124 = new j(true, true, r35, r36, r212, 16);
        if (r4 == null) goto L130;
        Boolean r213 = r4.u;
    L131:
        if (r4 == null) goto L133;
        Function1 r214 = r4.y;
    L134:
        k r37 = new k(r32, null, r122, r121, r123, true, r34, r124, null, r213, r211, r214, null, 8450);
        if (r4 == null) goto L137;
        AttachReceiver r125 = r4.o;
    L139:
        if (r4 == null) goto L141;
        q0 r126 = r4.q;
    L142:
        if (r4 == null) goto L144;
        LruSet r215 = r4.g;
    L145:
        if (r4 == null) goto L147;
        Boolean r216 = r4.h;
    L148:
        ((bo8.c) this.d.getValue()).a(r37, new do8.h(r125, null, null, null, null, null, null, r126, r215, r216, r4, r40, 126));
        bo8.c r38 = (bo8.c) this.d.getValue();
        r38.getClass();
        Intrinsics.checkNotNullParameter(r37, "vmData");
        return r38.b().B(r38.e, r32);
    L147:
        r216 = null;
        goto L148
    L144:
        r215 = null;
        goto L145
    L141:
        r126 = null;
        goto L142
    L137:
        r125 = null;
        goto L139
    L133:
        r214 = null;
        goto L134
    L130:
        r213 = null;
        goto L131
    L126:
        r212 = null;
        goto L127
    L118:
        r122 = null;
    L111:
        r31 = r43;
        goto L113
    L106:
        r29 = CollectionsKt.emptyList();
        goto L107
    L150:
        this.g = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ImageGroupBinder$bindData$1(r115, r19, r4, this, r41, r42, r40, null), 3, null);
        ol8.c r39 = (ol8.c) this.c.getValue();
        ql8.a r45 = new ql8.a(r115, 4094);
        r39.getClass();
        Intrinsics.checkNotNullParameter(r45, "vmData");
        ImageGroupLegacyView r46 = (ImageGroupLegacyView) r39.a.getValue();
        com.larus.bmhome.chat.standarduikit.imagegroup.view.a r47 = r45.a;
        int r127 = r47.a;
        boolean r128 = r47.b;
        boolean r129 = r47.c;
        int r130 = r47.d;
        float r48 = r47.e;
        Boolean r49 = r47.f;
        y r50 = new y(r127, r128, r129, r130, r48, r49);
        List r51 = r45.b.c();
        if (r51 != null) goto L153;
        r51 = CollectionsKt.emptyList();
    L153:
        x r52 = new x(r51, null, false);
        com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.w r53 = new com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.w(null, null, null, null);
        Intrinsics.checkNotNullParameter(r50, "sizeData");
        Intrinsics.checkNotNullParameter(r52, "imagesData");
        Intrinsics.checkNotNullParameter(r53, "imageTraceData");
        r46.getClass();
        if (r127 <= 0) goto L175;
        if (r130 <= 0) goto L175;
        if (Intrinsics.areEqual(r49, Boolean.TRUE) == false) goto L165;
        if (r130 >= 3) goto L162;
        Size r54 = new Size(r127, (int) (r127 / 1.7777778f));
    L173:
        r46.b = r54;
        Pair r55 = ImageGroupLegacyView.c(r128, r129);
        int r56 = ((Number) r55.component1()).intValue();
        r46.c = new Size(r127, (r46.b.getHeight() + r56) + ((Number) r55.component2()).intValue());
        goto L175
    L162:
        Size r57 = new Size(r127, (r127 - i5.j0()) / 3);
    L163:
        r54 = r57;
        goto L173
    L165:
        if (r130 != 1) goto L170;
        int r58 = ((r127 - i5.j0()) / 3) * 2;
        if (r48 <= 1.0f) goto L169;
        r54 = new Size(r58, (int) (r58 / r48));
        goto L173
    L169:
        r54 = new Size((int) (r58 * r48), r58);
        goto L173
    L170:
        if (r130 > 3) goto L172;
        r57 = new Size(r127, (r127 - i5.j0()) / 3);
        goto L163
    L172:
        r57 = new Size(r127, (((r127 - i5.j0()) / 3) * 2) + i5.N());
    L175:
        return r46.c;
    L94:
        r114 = 1.7777778f;
        goto L95
    L88:
        r113 = 0;
    L84:
        r25 = 0;
    L79:
        r23 = 0;
        goto L80
    L74:
        r21 = null;
        goto L75
    L70:
        r111 = false;
        goto L71
    L66:
        r110 = false;
        goto L68
    L36:
        r14 = false;
    L51:
        th = move-exception;
        Result.Companion r59 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L31:
        r8 = null;
        goto L176
    }
}
