package com.larus.uaigc.chat.block.create.vertical;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.uaigc.chat.block.create.AbsCreationBlockView;
import com.larus.uaigc.chat.block.widget.image.LocalImageItemViewHolder;
import com.larus.uaigc.chat.block.widget.video.LocalVideoItemViewHolder;
import com.larus.uaigc.impl.databinding.LarusItemMarkdownCreationImageScrollBinding;
import com.larus.uaigc.impl.databinding.LarusWidgetCreationBlockVideoItemBinding;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kc8.q;
import kc8.z;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0083\u0001\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u000b2\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020\u0014H\u0002J\u0012\u0010.\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020&002\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u00101\u001a\u0004\u0018\u00010\u000f*\u00020&H\u0002J\u0018\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020&2\u0006\u00104\u001a\u000205H\u0002J\"\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020&2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u0012H\u0002J\u0016\u0010;\u001a\u00020\u00142\f\u0010<\u001a\b\u0012\u0004\u0012\u00020&00H\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u0012H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/uaigc/chat/block/create/vertical/LocalCreationVerticalGroup;", "Lcom/larus/uaigc/chat/block/create/AbsCreationBlockView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "containerLayout", "Landroid/widget/LinearLayout;", "getContainerLayout", "()Landroid/widget/LinearLayout;", "isFirstBind", "", "idViewBinderMap", "Ljava/util/HashMap;", "", "Lcom/larus/uaigc/chat/block/widget/IItemViewBinder;", "Lkotlin/collections/HashMap;", "asView", "Landroid/view/View;", "bindData", "", "fragment", "Landroidx/fragment/app/Fragment;", "isLongPicShare", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "message", "Lcom/larus/im/bean/message/Message;", "blockModel", "Lcom/larus/uaigc/chat/block/create/ICreationBizModel;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "maxContentWidth", "", "isLastBlockModel", "disableCreateImagePreview", "onItemLongClick", "Lkotlin/Function2;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "(Landroidx/fragment/app/Fragment;ZLcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/chat/block/create/ICreationBizModel;Lcom/larus/bmhome/chat/ChatParam;IZLjava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;)V", "onRecycle", "reloadFailedImages", "clearViewBinder", "preGenerateLocalImagePreviewCaches", "initView", "generateViewDataList", "", "toItemViewBinder", "reportItemExposure", "data", "percentage", "", "onClickItem", "itemData", "videoPlayParams", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "rootView", "replaceAllItem", "viewDataList", "refreshViewState", "provideScreenshotParams", "Lorg/json/JSONObject;", "visibilityCheck", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LocalCreationVerticalGroup extends AbsCreationBlockView {
    public static final /* synthetic */ int u = 0;
    public final LinearLayout r;
    public boolean s;
    public final HashMap<String, cz9.g> t;

    public static final class a {
    }

    static {
    }

    public final void o() {
        Iterator<Map.Entry<String, cz9.g>> r0 = this.t.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        cz9.g r1 = r0.next().getValue();
        if (r1 == null) goto L4;
        r1.f();
        goto L4
    L8:
        this.t.clear();
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void j() {
        super.j();
        o();
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void k() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(e()), null, new LocalCreationVerticalGroup$reloadFailedImages$1(this, null), 2, null);
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final View a() {
        return this.r;
    }

    public LocalCreationVerticalGroup(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        LinearLayout r0 = new LinearLayout(r6);
        r0.setOrientation(1);
        int r1 = i5.q();
        int r2 = i5.q();
        r0.setPaddingRelative(r1, r0.getPaddingTop(), r2, r0.getPaddingBottom());
        this.r = r0;
        this.s = true;
        this.t = new HashMap();
    }

    public final JSONObject m(Message r13) {
        Intrinsics.checkNotNullParameter(r13, "message");
        JSONObject r0 = new JSONObject();
        List r1 = com.larus.im.bean.message.a.l(r13);
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        String r4 = ((CreationItem) r3.next()).id;
        if (r4 == null) goto L4;
        r2.add(r4);
        goto L4
    L8:
        r0.put("ai_creation_message_id", r13.getMessageId());
        ArrayList r5 = new ArrayList();
        Iterator r14 = SequencesKt.withIndex(ViewGroupKt.getChildren(this.r)).iterator();
    L10:
        if (r14.hasNext() == false) goto L43;
        IndexedValue r6 = (IndexedValue) r14.next();
        View r7 = (View) r6.getValue();
        boolean r8 = true;
        boolean r9 = false;
        if (r7.isAttachedToWindow() == true) goto L14;
    L17:
        boolean r10 = true;
    L18:
        if (r10 == false) goto L21;
    L39:
        if (r9 == false) goto L10;
        String r11 = (String) CollectionsKt.getOrNull(r2, r6.getIndex());
        if (r11 == null) goto L10;
        r5.add(r11);
        goto L10
    L21:
        if (r7.getWidth() > 0) goto L23;
    L28:
        boolean r12 = true;
    L29:
        if (r12 == true) goto L39;
        Rect r15 = new Rect();
        if (r7.getGlobalVisibleRect(r15) == false) goto L39;
        int r16 = r7.getMeasuredWidth();
        int r17 = r7.getMeasuredHeight();
        if ((r15.height() * r15.width()) >= (r16 * r17)) goto L38;
        r8 = false;
    L38:
        r9 = r8;
        goto L39
    L23:
        if (r7.getHeight() <= 0) goto L28;
        if (r7.getAlpha() <= 0.0f) goto L28;
        r12 = false;
        goto L29
    L14:
        if (r7.isShown() == false) goto L17;
        r10 = false;
        goto L18
    L43:
        r0.put("creation_task_id", CollectionsKt.joinToString$default(r5, ",", null, null, 0, null, null, 62, null));
        return r0;
    }

    public final cz9.g r(cz9.b r14) {
        if ((r14 instanceof cz9.m) == false) goto L6;
        final LarusItemMarkdownCreationImageScrollBinding r4 = LarusItemMarkdownCreationImageScrollBinding.a(LayoutInflater.from(this.r.getContext()), this.r);
        LocalImageItemViewHolder r0 = new LocalImageItemViewHolder(r4, LifecycleOwnerKt.getLifecycleScope(this), f(), g(), this.f, new LocalCreationVerticalGroup$toItemViewBinder$1(r14, null), new LocalCreationVerticalGroup$toItemViewBinder$2(this, null), new j(this, r4), new k(this));
        cz9.l.a(((RecyclerView.ViewHolder) r0).itemView, r0, LocalCreationVerticalGroup$toItemViewBinder$5$1.INSTANCE, this, LocalCreationVerticalGroup$toItemViewBinder$5$2.INSTANCE);
        return r0;
    L6:
        if ((r14 instanceof cz9.n) == false) goto L10;
        final LarusWidgetCreationBlockVideoItemBinding r2 = LarusWidgetCreationBlockVideoItemBinding.a(LayoutInflater.from(this.r.getContext()), this.r);
        LocalVideoItemViewHolder r15 = new LocalVideoItemViewHolder(r2, LifecycleOwnerKt.getLifecycleScope(this), this.f, new l(this, r2), new m(this));
        cz9.l.a(((RecyclerView.ViewHolder) r15).itemView, r15, LocalCreationVerticalGroup$toItemViewBinder$8$1.INSTANCE, this, LocalCreationVerticalGroup$toItemViewBinder$8$2.INSTANCE);
        return r15;
    L10:
        return null;
    }

    public final void p(cz9.b r11, iy9.b r12, ConstraintLayout r13) {
        CreationItem r3 = r11.a();
        if (r3 != null) goto L6;
        return;
    L6:
        if (bz9.c.e(r3) == true) goto L8;
        return;
    L8:
        q r0 = this.f;
        if (r0 == null) goto L11;
        Function1 r1 = r0.m;
    L12:
        if (r1 == null) goto L18;
        if (r0 == null) goto L20;
        Function1 r14 = r0.m;
        if (r14 == null) goto L21;
        r14.invoke(Integer.valueOf(r11.b()));
        return;
    L21:
        return;
    L20:
        return;
    L18:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LocalCreationVerticalGroup$onClickItem$1(this, r13, r3, r12, null), 3, null);
        return;
    L11:
        r1 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void b(Fragment r15, boolean r16, final z r17, Message r18, com.larus.uaigc.chat.block.create.i r19, ChatParam r20, int r21, boolean r22, Boolean r23, com.larus.uaigc.chat.block.create.f r24, q r25) {
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r19, "blockModel");
        super.b(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        this.m = bz9.c.b(r19);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(e()), null, new LocalCreationVerticalGroup$preGenerateLocalImagePreviewCaches$1(this, null), 2, null);
        int r3 = 0;
        if (this.s == false) goto L6;
        this.s = false;
        this.r.setOnLongClickListener(new n(r17));
        this.r.removeAllViews();
    L6:
        List<CreationItem> r2 = this.m;
        boolean r4 = true;
        if (r2 == null) goto L22;
        ?? r6 = new ArrayList();
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L23;
        CreationItem r7 = (CreationItem) r5.next();
        Size r9 = bz9.c.a(r7, r21, 1);
        Message r10 = this.e;
        com.larus.uaigc.chat.block.create.i r11 = this.j;
        if (r11 == null) goto L16;
        Block r12 = ((jc8.a) r11).a;
        if (r12 == null) goto L16;
        String r13 = r12.getBlockId();
    L17:
        if (r13 != null) goto L19;
        r13 = "";
    L19:
        cz9.b r8 = bz9.c.n(r7, r10, r13, r9.getWidth(), r9.getHeight(), this.i);
        if (r8 == null) goto L10;
        r6.add(r8);
    L16:
        r13 = null;
    L23:
        if (r6 != 0) goto L25;
        r6 = CollectionsKt.emptyList();
    L25:
        List<CreationItem> r14 = this.m;
        if (r14 == null) goto L47;
        List<CreationItem> r26 = r14;
        if ((r26 instanceof Collection) == true) goto L30;
    L32:
        Iterator r27 = r26.iterator();
    L34:
        if (r27.hasNext() == false) goto L44;
        String r28 = ((CreationItem) r27.next()).id;
        if (r28 != null) goto L38;
    L41:
        boolean r29 = true;
    L42:
        if (r29 == false) goto L34;
        boolean r30 = true;
    L45:
        if (r30 != true) goto L47;
        boolean r31 = true;
    L48:
        if (r31 == false) goto L75;
        this.r.removeAllViews();
        o();
        Iterator r32 = ((Iterable) r6).iterator();
        int r33 = 0;
    L51:
        if (r32.hasNext() == false) goto L120;
        Object r34 = r32.next();
        int r35 = r33 + 1;
        if (r33 >= 0) goto L55;
        CollectionsKt.throwIndexOverflow();
    L55:
        cz9.b r36 = (cz9.b) r34;
        cz9.g r37 = r(r36);
        if (r37 == null) goto L58;
        r37.p2(r36);
    L58:
        LinearLayout r110 = this.r;
        if (r37 == null) goto L61;
        View r111 = r37.N0();
    L62:
        r110.addView(r111);
        HashMap<String, cz9.g> r112 = this.t;
        CreationItem r38 = r36.a();
        if (r38 == null) goto L65;
        String r39 = r38.id;
    L66:
        if (r39 != null) goto L69;
        r39 = "";
    L69:
        if (r39.length() != 0) goto L71;
        boolean r113 = true;
    L72:
        if (r113 == false) goto L74;
        r39 = String.valueOf(r33);
    L74:
        r112.put(r39, r37);
        r33 = r35;
        goto L51
    L71:
        r113 = false;
        goto L72
    L65:
        r39 = null;
        goto L66
    L61:
        r111 = null;
    L120:
        int r1 = this.t.size();
        LinearLayout r40 = this.r;
        com.larus.uaigc.chat.block.create.i r41 = this.j;
        if (r41 != null) goto L123;
    L125:
        r4 = false;
    L126:
        if (r4 == false) goto L128;
        int r42 = i5.r0();
    L130:
        if (this.h == false) goto L132;
        int r43 = i5.r0();
    L133:
        r40.setPaddingRelative(r40.getPaddingStart(), r42, r40.getPaddingEnd(), r43);
        Iterator r44 = ViewGroupKt.getChildren(this.r).iterator();
    L135:
        if (r44.hasNext() == false) goto L152;
        Object r45 = r44.next();
        int r46 = r3 + 1;
        if (r3 >= 0) goto L139;
        CollectionsKt.throwIndexOverflow();
    L139:
        View r47 = (View) r45;
        ViewGroup.LayoutParams r48 = r47.getLayoutParams();
        if (r48 == null) goto L151;
        ViewGroup.MarginLayoutParams r49 = (ViewGroup.MarginLayoutParams) r48;
        if (r3 != 0) goto L144;
        int r50 = i5.Y();
    L145:
        r49.topMargin = r50;
        if (r3 != (r1 - 1)) goto L148;
        int r51 = i5.Y();
    L149:
        r49.bottomMargin = r51;
        r47.setLayoutParams(r49);
        r3 = r46;
        goto L135
    L148:
        r51 = i5.r0();
        goto L149
    L144:
        r50 = i5.r0();
        goto L145
    L151:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L152:
        return;
    L132:
        r43 = 0;
        goto L133
    L128:
        r42 = 0;
        goto L130
    L123:
        if (r41.m() != true) goto L125;
    L75:
        Set<String> r52 = this.t.keySet();
        ArrayList r53 = new ArrayList();
        Iterator r54 = r52.iterator();
    L77:
        if (r54.hasNext() == false) goto L97;
        Object r55 = r54.next();
        String r56 = (String) r55;
        Iterable r114 = (Iterable) r6;
        if ((r114 instanceof Collection) == true) goto L81;
    L83:
        Iterator r115 = r114.iterator();
    L85:
        if (r115.hasNext() == false) goto L93;
        CreationItem r116 = ((cz9.b) r115.next()).a();
        if (r116 == null) goto L89;
        String r117 = r116.id;
    L91:
        if (Intrinsics.areEqual(r117, r56) == false) goto L85;
        boolean r57 = true;
    L95:
        if ((!r57) == false) goto L77;
        r53.add(r55);
        goto L77
    L89:
        r117 = null;
    L93:
        r57 = false;
        goto L95
    L81:
        if (((Collection) r114).isEmpty() == false) goto L83;
    L97:
        Iterator r58 = r53.iterator();
    L99:
        if (r58.hasNext() == false) goto L103;
        String r59 = (String) r58.next();
        cz9.g r60 = this.t.get(r59);
        if (r60 == null) goto L99;
        this.r.removeView(r60.N0());
        r60.f();
        this.t.remove(r59);
        goto L99
    L103:
        Iterator r61 = ((Iterable) r6).iterator();
    L105:
        if (r61.hasNext() == false) goto L120;
        cz9.b r62 = (cz9.b) r61.next();
        CreationItem r63 = r62.a();
        if (r63 == null) goto L109;
        String r64 = r63.id;
    L110:
        if (r64 != null) goto L112;
        r64 = "";
    L112:
        cz9.g r65 = this.t.get(r64);
        if (r65 != null) goto L118;
        r65 = r(r62);
        if (r65 == null) goto L117;
        this.t.put(r64, r65);
        this.r.addView(r65.N0());
        goto L118
    L117:
        r65 = null;
    L118:
        if (r65 == null) goto L105;
        r65.p2(r62);
        goto L105
    L109:
        r64 = null;
        goto L110
    L38:
        if (StringsKt.isBlank(r28) == true) goto L41;
        r29 = false;
    L44:
        r30 = false;
        goto L45
    L30:
        if (r26.isEmpty() == false) goto L32;
    L47:
        r31 = false;
        goto L48
    L22:
        r6 = 0;
        goto L23
    }
}
