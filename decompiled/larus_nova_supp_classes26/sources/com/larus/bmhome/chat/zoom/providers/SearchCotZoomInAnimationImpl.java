package com.larus.bmhome.chat.zoom.providers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageReferenceAdapter;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.markdown.reference.ReferenceListZoomInView;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEnqueueStrategy;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SearchQueryResultBlock;
import com.larus.im.bean.message.block.SearchType;
import com.larus.platform.service.AccountService;
import com.larus.utils.o0;
import gb8.h;
import in8.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jc8.a;
import jn8.l;
import jn8.m;
import jn8.n;
import jn8.o;
import jn8.p;
import jn8.r;
import jn8.s;
import kn8.d;
import kn8.e;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import so8.c;
import so8.w;
import v19.c7;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/zoom/providers/SearchCotZoomInAnimationImpl;", "Lcom/larus/bmhome/chat/zoom/IZoomInAnimationProvider;", "<init>", "()V", "blockBizModelClassName", "", "isSupport", "", "blockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "supportContext", "Lcom/larus/bmhome/chat/zoom/SupportContext;", "getAnimationID", "getAnimationView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindAnimationView", "", "view", "providerBindContext", "Lcom/larus/bmhome/chat/zoom/ProviderBindContext;", "getAnimationAction", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationAction;", "getAnimationConfig", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCotZoomInAnimationImpl implements IZoomInAnimationProvider {
    public SearchCotZoomInAnimationImpl() {
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final String h() {
        return h.class.getName();
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final String a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        return r2.h();
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final c b(a r8) {
        Intrinsics.checkNotNullParameter(r8, "blockBizModel");
        ZoomInAnimationEnqueueStrategy r9 = ZoomInAnimationEnqueueStrategy.SKIP_IF_BUSY;
        ZoomInAnimationEndStrategy r0 = ZoomInAnimationEndStrategy.TIMER_CONTROL;
        return new c(c7.b(180), r9, r0, new Rect(c7.b(16), c7.b(11), c7.b(16), c7.b(14)));
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final void e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final ZoomInAnimationAction f(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        return ZoomInAnimationAction.SHOW;
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final View c(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "blockBizModel");
        g r4 = new g(r2);
        ReferenceListZoomInView r5 = (ReferenceListZoomInView) ((r) r4.b.getValue()).b.getValue();
        r5.setTag(2131393420, r4);
        return r5;
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final void d(View r25, a r26) {
        Intrinsics.checkNotNullParameter(r25, "view");
        Intrinsics.checkNotNullParameter(r26, "blockBizModel");
        Object r0 = r25.getTag(2131393420);
        if ((r0 instanceof g) == false) goto L5;
        g r1 = (g) r0;
    L7:
        if ((r26 instanceof h) == false) goto L9;
        h r2 = (h) r26;
    L10:
        if (r2 == null) goto L12;
        SearchReferenceData r3 = r2.o();
    L13:
        d r4 = new d(r26.j(), r3);
        if (r1 == null) goto L105;
        Intrinsics.checkNotNullParameter(r4, "vmData");
        e r5 = (e) r1.c.getValue();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "vmData");
        r5.c = r4;
        e r6 = (e) r1.c.getValue();
        d r7 = r6.c;
        if (r7 == null) goto L18;
        SearchReferenceData r8 = r7.d;
    L20:
        if (r8 == null) goto L22;
        List r13 = r8.getReference();
    L23:
        if (r8 == null) goto L25;
        Integer r9 = r8.getIdx();
    L26:
        if (r8 == null) goto L28;
        String r10 = r8.getToolType();
    L29:
        d r11 = r6.c;
        if (r11 == null) goto L34;
        Message r12 = r11.a;
        if (r12 == null) goto L34;
        String r14 = r12.getMessageId();
    L35:
        d r15 = r6.c;
        if (r15 == null) goto L38;
        String r16 = r15.b;
    L39:
        if (r15 == null) goto L43;
        Message r17 = r15.a;
        if (r17 == null) goto L43;
        String r18 = r17.getConversationId();
    L44:
        d r19 = r6.c;
        if (r19 == null) goto L49;
        Message r20 = r19.a;
        if (r20 == null) goto L49;
        String r110 = r20.getSenderId();
    L50:
        final s r111 = new s(r13, r9, r10, r14, r16, r18, r110);
        e.a r21 = ((e) r1.c.getValue()).a;
        final r r22 = (r) r1.b.getValue();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r111, "input");
        Intrinsics.checkNotNullParameter(r21, "output");
        r22.c = r21;
        final ArrayList r23 = new ArrayList();
        if (r13 == null) goto L62;
        Iterator r24 = r13.iterator();
    L54:
        if (r24.hasNext() == false) goto L62;
        Reference r27 = (Reference) r24.next();
        TextCard r28 = r27.getTextCard();
        if (r28 != null) goto L57;
        VideoCard r29 = r27.getVideoCard();
        if (r29 == null) goto L54;
        r23.add(r29);
        goto L54
    L57:
        r23.add(r28);
    L62:
        if (AccountService.a.isEnterpriseAccount() == true) goto L64;
    L86:
        boolean r112 = false;
    L87:
        Function1 r30 = new l(r111, r22);
        Context r31 = r22.a;
        String r32 = r111.e;
        if (r32 != null) goto L90;
        r32 = "";
    L90:
        ((ReferenceListZoomInView) r22.b.getValue()).setReferenceListRecyclerViewAdapter(new MessageReferenceAdapter(r112, r23, r30, r31, false, r32, true, false, new m(r111)));
        RecyclerView r33 = ((ReferenceListZoomInView) r22.b.getValue()).getSearchReferenceList();
        y6.h(r33, r22.d);
        r22.d = y6.e(r33, new n(r111), new o(r23), new p(r22, r111));
        r21.c();
        return;
    L64:
        if (r23.isEmpty() == true) goto L83;
        Iterator r34 = r23.iterator();
    L68:
        if (r34.hasNext() == false) goto L83;
        Object r35 = r34.next();
        boolean r36 = r35 instanceof TextCard;
        if (r36 == false) goto L80;
        if (r36 == false) goto L73;
        TextCard r37 = (TextCard) r35;
    L74:
        if (r37 == null) goto L76;
        String r38 = r37.getIconUrl();
    L78:
        if (o0.d(r38) == false) goto L80;
        boolean r39 = true;
    L81:
        if (r39 == true) goto L68;
        boolean r40 = false;
    L84:
        if (r40 == false) goto L86;
        r112 = true;
        goto L87
    L76:
        r38 = null;
        goto L78
    L73:
        r37 = null;
    L80:
        r39 = false;
    L83:
        r40 = true;
    L49:
        r110 = null;
    L43:
        r18 = null;
        goto L44
    L38:
        r16 = null;
    L34:
        r14 = null;
        goto L35
    L28:
        r10 = null;
        goto L29
    L25:
        r9 = null;
        goto L26
    L22:
        r13 = null;
        goto L23
    L18:
        r8 = null;
        goto L20
    L105:
        return;
    L12:
        r3 = null;
        goto L13
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.zoom.IZoomInAnimationProvider
    public final boolean g(a r8, so8.a r9) {
        Intrinsics.checkNotNullParameter(r8, "blockBizModel");
        DeepThinkFoldStatus r2 = null;
        if ((r8 instanceof h) == false) goto L5;
        h r10 = (h) r8;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        BlockContent r3 = ((a) r10).a.getContent();
        if (r3 == null) goto L16;
        SearchQueryResultBlock r4 = r3.getSearchQueryResultBlock();
        if (r4 == null) goto L16;
        Integer r5 = r4.searchType;
        if (r5 == null) goto L16;
        int r6 = r5.intValue();
    L18:
        if (SetsKt.setOf(new Integer[]{Integer.valueOf(SearchType.WebSearch.getValue()), Integer.valueOf(SearchType.ScholarSearch.getValue())}).contains(Integer.valueOf(r6)) == true) goto L20;
        return false;
    L20:
        SearchReferenceData r7 = r10.o();
        List r11 = r7.getReference();
        if (r11 != null) goto L23;
    L26:
        boolean r12 = true;
    L27:
        if (r12 == false) goto L30;
        return false;
    L30:
        if (com.larus.bmhome.chat.bean.d.f0(r10.j()) == true) goto L33;
        return false;
    L33:
        if (com.larus.bmhome.chat.markdown.reference.r.b(r7) == true) goto L35;
        return false;
    L35:
        boolean r13 = com.larus.im.bean.message.a.j(r10.j());
        if (r9 == null) goto L39;
        r2 = r9.a;
    L39:
        if (r2 != DeepThinkFoldStatus.CompleteFold) goto L41;
        boolean r14 = true;
    L42:
        if (r13 == false) goto L47;
        if (r14 == false) goto L47;
        Set<String> r15 = w.a;
        Intrinsics.checkNotNullParameter(r10, "blockBizModel");
        w.a(((a) r10).g);
        return true;
    L47:
        return false;
    L41:
        r14 = false;
        goto L42
    L23:
        if (r11.isEmpty() == true) goto L26;
        r12 = false;
    L16:
        r6 = SearchType.Default.getValue();
        goto L18
    L5:
        r10 = null;
        goto L7
    }
}
