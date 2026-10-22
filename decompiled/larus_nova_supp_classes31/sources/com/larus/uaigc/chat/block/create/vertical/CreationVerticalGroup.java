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
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.block.create.AbsCreationBlockView;
import com.larus.uaigc.chat.block.widget.image.ImageItemViewHolder;
import com.larus.uaigc.chat.block.widget.video.VideoItemViewHolder;
import com.larus.uaigc.chat.markdown.image.MDImageScrollWidget;
import com.larus.uaigc.impl.databinding.LarusItemMarkdownCreationImageScrollBinding;
import com.larus.uaigc.impl.databinding.LarusWidgetCreationBlockVideoItemBinding;
import com.tencent.open.log.TraceLevel;
import cz9.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kc8.a0;
import kc8.q;
import kc8.z;
import kotlin.Lazy;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0083\u0001\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\t2\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0012H\u0002J\u0012\u0010+\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020$0-2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010.\u001a\u0004\u0018\u00010\r*\u00020$H\u0002J\u0018\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0002J\"\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0010H\u0002J\u0016\u00108\u001a\u00020\u00122\f\u00109\u001a\b\u0012\u0004\u0012\u00020$0-H\u0002J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/uaigc/chat/block/create/vertical/CreationVerticalGroup;", "Lcom/larus/uaigc/chat/block/create/AbsCreationBlockView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "containerLayout", "Landroid/widget/LinearLayout;", "isFirstBind", "", "idViewBinderMap", "Ljava/util/HashMap;", "", "Lcom/larus/uaigc/chat/block/widget/IItemViewBinder;", "Lkotlin/collections/HashMap;", "asView", "Landroid/view/View;", "bindData", "", "fragment", "Landroidx/fragment/app/Fragment;", "isLongPicShare", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "message", "Lcom/larus/im/bean/message/Message;", "blockModel", "Lcom/larus/uaigc/chat/block/create/ICreationBizModel;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "maxContentWidth", "", "isLastBlockModel", "disableCreateImagePreview", "onItemLongClick", "Lkotlin/Function2;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "(Landroidx/fragment/app/Fragment;ZLcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/chat/block/create/ICreationBizModel;Lcom/larus/bmhome/chat/ChatParam;IZLjava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;)V", "onRecycle", "reloadFailedImages", "clearViewBinder", "initView", "generateViewDataList", "", "toItemViewBinder", "reportItemExposure", "data", "percentage", "", "onClickItem", "itemData", "videoPlayParams", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "rootView", "replaceAllItem", "viewDataList", "refreshViewState", "provideScreenshotParams", "Lorg/json/JSONObject;", "visibilityCheck", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationVerticalGroup extends AbsCreationBlockView {
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(e()), null, new CreationVerticalGroup$reloadFailedImages$1(this, null), 2, null);
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final View a() {
        return this.r;
    }

    public CreationVerticalGroup(Context r6) {
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
        if ((r14 instanceof cz9.h) == false) goto L6;
        final LarusItemMarkdownCreationImageScrollBinding r4 = LarusItemMarkdownCreationImageScrollBinding.a(LayoutInflater.from(this.r.getContext()), this.r);
        ImageItemViewHolder r0 = new ImageItemViewHolder(r4, LifecycleOwnerKt.getLifecycleScope(this), f(), g(), this.f, new CreationVerticalGroup$toItemViewBinder$1(r14, null), new CreationVerticalGroup$toItemViewBinder$2(this, null), new d(this, r4), new e(this));
        cz9.f.a(((RecyclerView.ViewHolder) r0).itemView, r0, CreationVerticalGroup$toItemViewBinder$5$1.INSTANCE, this, CreationVerticalGroup$toItemViewBinder$5$2.INSTANCE);
        return r0;
    L6:
        if ((r14 instanceof o) == false) goto L10;
        final LarusWidgetCreationBlockVideoItemBinding r2 = LarusWidgetCreationBlockVideoItemBinding.a(LayoutInflater.from(this.r.getContext()), this.r);
        VideoItemViewHolder r15 = new VideoItemViewHolder(r2, LifecycleOwnerKt.getLifecycleScope(this), this.f, new f(this, r2), new g(this));
        cz9.f.a(((RecyclerView.ViewHolder) r15).itemView, r15, CreationVerticalGroup$toItemViewBinder$8$1.INSTANCE, this, CreationVerticalGroup$toItemViewBinder$8$2.INSTANCE);
        return r15;
    L10:
        return null;
    }

    public final void p(cz9.b r10, iy9.b r11, ConstraintLayout r12) {
        CreationItem r0 = r10.a();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (bz9.a.f(r0) != true) goto L7;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        CreationItem r5 = r10.a();
        if (r5 != null) goto L13;
        return;
    L13:
        q r2 = this.f;
        if (r2 == null) goto L16;
        Function1 r3 = r2.m;
    L17:
        if (r3 == null) goto L23;
        if (r2 == null) goto L25;
        Function1 r13 = r2.m;
        if (r13 == null) goto L26;
        r13.invoke(Integer.valueOf(r10.b()));
        return;
    L26:
        return;
    L25:
        return;
    L23:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationVerticalGroup$onClickItem$1(this, r12, r5, r11, null), 3, null);
        return;
    L16:
        r3 = null;
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v1 */
    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void b(Fragment r24, boolean r25, final z r26, Message r27, com.larus.uaigc.chat.block.create.i r28, ChatParam r29, int r30, boolean r31, Boolean r32, com.larus.uaigc.chat.block.create.f r33, q r34) {
        Intrinsics.checkNotNullParameter(r27, "message");
        Intrinsics.checkNotNullParameter(r28, "blockModel");
        super.b(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
        if (this.s == false) goto L6;
        this.s = false;
        this.r.setOnLongClickListener(new c(r26));
        this.r.removeAllViews();
    L6:
        q r1 = this.f;
        if (r1 == null) goto L11;
        a0 r2 = r1.d;
        if (r2 == null) goto L11;
        wc9.e r3 = r2.h();
    L12:
        boolean r4 = true;
        if (r3 == null) goto L20;
        Integer r6 = r3.j;
        if (r6 == null) goto L20;
        if (r6.intValue() != 2) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L23;
    L26:
        boolean r5 = true;
    L27:
        List<CreationItem> r8 = this.m;
        if (r8 == null) goto L146;
        ?? r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L31:
        if (r10.hasNext() == false) goto L147;
        CreationItem r14 = (CreationItem) r10.next();
        Size r11 = bz9.b.b(r14, r30, 1);
        Integer r12 = r14.type;
        if (r12 != null) goto L36;
    L101:
        if (r12 != null) goto L104;
    L142:
        Object r13 = null;
    L143:
        if (r13 == null) goto L31;
        r9.add(r13);
        goto L31
    L104:
        if (r12.intValue() != 2) goto L142;
        int r15 = r11.getWidth();
        int r16 = r11.getHeight();
        Message r17 = this.e;
        if (r17 == null) goto L116;
        com.larus.uaigc.chat.block.create.i r18 = this.j;
        if (r18 == null) goto L112;
        Block r19 = ((jc8.a) r18).a;
        if (r19 == null) goto L112;
        String r20 = r19.getBlockId();
    L113:
        if (r20 != null) goto L115;
        r20 = "";
    L115:
        int r110 = bz9.a.d(r17, r20, r14);
    L117:
        boolean r21 = this.i;
        boolean r111 = !r21;
        if (r21 == true) goto L139;
        if (r5 == true) goto L139;
        Integer r22 = z2.a.attachmentEditConfig().getCreationVideoCoverFollowUp();
        if (r22 == null) goto L139;
        if (r22.intValue() != 1) goto L139;
        if (c().length() != 0) goto L128;
        boolean r23 = true;
    L129:
        if (r23 == true) goto L138;
        String r35 = c();
        e0 r112 = (e0) AuthModelDelegate.b.e().getValue();
        if (r112 == null) goto L135;
        LaunchInfo r113 = r112.a;
        if (r113 == null) goto L135;
        String r114 = r113.W();
    L137:
        if (Intrinsics.areEqual(r35, r114) == false) goto L139;
    L135:
        r114 = null;
    L138:
        boolean r115 = true;
    L140:
        Object r210 = new o(2, r15, r16, r14, r17, r110, r111, r115);
    L141:
        r13 = r210;
        goto L143
    L128:
        r23 = false;
    L139:
        r115 = false;
    L112:
        r20 = null;
        goto L113
    L116:
        r110 = 0;
        goto L117
    L36:
        if (r12.intValue() != 1) goto L101;
        int r116 = r11.getWidth();
        int r117 = r11.getHeight();
        Message r118 = this.e;
        if (r118 == null) goto L48;
        com.larus.uaigc.chat.block.create.i r119 = this.j;
        if (r119 == null) goto L44;
        Block r120 = ((jc8.a) r119).a;
        if (r120 == null) goto L44;
        String r121 = r120.getBlockId();
    L45:
        if (r121 != null) goto L47;
        r121 = "";
    L47:
        int r122 = bz9.a.d(r118, r121, r14);
    L49:
        IAIChatUgcAIGCService.Companion r123 = IAIChatUgcAIGCService.a;
        if (r123.E0() == true) goto L52;
    L54:
        boolean r124 = false;
    L56:
        if (r123.l0() == true) goto L58;
    L60:
        boolean r125 = false;
    L61:
        Lazy<Boolean> r36 = MDImageScrollWidget.w;
        if (MDImageScrollWidget.a.a() == true) goto L64;
    L68:
        boolean r126 = false;
    L70:
        if (MDImageScrollWidget.a.b() == true) goto L72;
    L76:
        boolean r211 = false;
    L78:
        if (this.i == true) goto L99;
        if (r5 == true) goto L99;
        Integer r37 = z2.a.attachmentEditConfig().getCreationCoverFollowUp();
        if (r37 == null) goto L99;
        if (r37.intValue() != 1) goto L99;
        if (c().length() != 0) goto L88;
        boolean r38 = true;
    L89:
        if (r38 == true) goto L98;
        String r39 = c();
        e0 r127 = (e0) AuthModelDelegate.b.e().getValue();
        if (r127 == null) goto L95;
        LaunchInfo r128 = r127.a;
        if (r128 == null) goto L95;
        String r129 = r128.W();
    L97:
        if (Intrinsics.areEqual(r39, r129) == false) goto L99;
    L95:
        r129 = null;
    L98:
        boolean r212 = true;
    L100:
        r210 = new cz9.h(1, r116, r117, r14, r118, r122, r124, r125, r126, r211, r212);
        goto L141
    L88:
        r38 = false;
    L99:
        r212 = false;
        goto L100
    L72:
        if (g() == null) goto L76;
        if (this.i == true) goto L76;
        r211 = true;
        goto L78
    L64:
        if (f() == null) goto L68;
        if (this.i == true) goto L68;
        r126 = true;
        goto L70
    L58:
        if (this.i == true) goto L60;
        r125 = true;
        goto L61
    L52:
        if (this.i == true) goto L54;
        r124 = true;
    L44:
        r121 = null;
        goto L45
    L48:
        r122 = 0;
    L147:
        if (r9 != 0) goto L149;
        r9 = CollectionsKt.emptyList();
    L149:
        List<CreationItem> r40 = this.m;
        if (r40 == null) goto L171;
        List<CreationItem> r41 = r40;
        if ((r41 instanceof Collection) == true) goto L154;
    L156:
        Iterator r42 = r41.iterator();
    L158:
        if (r42.hasNext() == false) goto L168;
        String r43 = ((CreationItem) r42.next()).id;
        if (r43 != null) goto L162;
    L165:
        boolean r44 = true;
    L166:
        if (r44 == false) goto L158;
        boolean r45 = true;
    L169:
        if (r45 != true) goto L171;
        boolean r46 = true;
    L172:
        if (r46 == false) goto L199;
        this.r.removeAllViews();
        o();
        Iterator r47 = ((Iterable) r9).iterator();
        int r48 = 0;
    L175:
        if (r47.hasNext() == false) goto L244;
        Object r49 = r47.next();
        int r50 = r48 + 1;
        if (r48 >= 0) goto L179;
        CollectionsKt.throwIndexOverflow();
    L179:
        cz9.b r51 = (cz9.b) r49;
        cz9.g r52 = r(r51);
        if (r52 == null) goto L182;
        r52.p2(r51);
    L182:
        LinearLayout r53 = this.r;
        if (r52 == null) goto L185;
        View r130 = r52.N0();
    L186:
        r53.addView(r130);
        HashMap<String, cz9.g> r54 = this.t;
        CreationItem r55 = r51.a();
        if (r55 == null) goto L189;
        String r56 = r55.id;
    L190:
        if (r56 != null) goto L193;
        r56 = "";
    L193:
        if (r56.length() != 0) goto L195;
        boolean r131 = true;
    L196:
        if (r131 == false) goto L198;
        r56 = String.valueOf(r48);
    L198:
        r54.put(r56, r52);
        r48 = r50;
        goto L175
    L195:
        r131 = false;
        goto L196
    L189:
        r56 = null;
        goto L190
    L185:
        r130 = null;
    L244:
        int r57 = this.t.size();
        LinearLayout r58 = this.r;
        com.larus.uaigc.chat.block.create.i r59 = this.j;
        if (r59 != null) goto L247;
    L249:
        r4 = false;
    L250:
        if (r4 == false) goto L252;
        int r60 = i5.r0();
    L254:
        if (this.h == false) goto L256;
        int r61 = i5.r0();
    L257:
        r58.setPaddingRelative(r58.getPaddingStart(), r60, r58.getPaddingEnd(), r61);
        Iterator r62 = ViewGroupKt.getChildren(this.r).iterator();
        int r63 = 0;
    L259:
        if (r62.hasNext() == false) goto L276;
        Object r64 = r62.next();
        int r65 = r63 + 1;
        if (r63 >= 0) goto L263;
        CollectionsKt.throwIndexOverflow();
    L263:
        View r66 = (View) r64;
        ViewGroup.LayoutParams r67 = r66.getLayoutParams();
        if (r67 == null) goto L275;
        ViewGroup.MarginLayoutParams r68 = (ViewGroup.MarginLayoutParams) r67;
        if (r63 != 0) goto L268;
        int r69 = i5.Y();
    L269:
        r68.topMargin = r69;
        if (r63 != (r57 - 1)) goto L272;
        int r70 = i5.Y();
    L273:
        r68.bottomMargin = r70;
        r66.setLayoutParams(r68);
        r63 = r65;
        goto L259
    L272:
        r70 = i5.r0();
        goto L273
    L268:
        r69 = i5.r0();
        goto L269
    L275:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L276:
        return;
    L256:
        r61 = 0;
        goto L257
    L252:
        r60 = 0;
        goto L254
    L247:
        if (r59.m() != true) goto L249;
    L199:
        Set<String> r71 = this.t.keySet();
        ArrayList r72 = new ArrayList();
        Iterator r73 = r71.iterator();
    L201:
        if (r73.hasNext() == false) goto L221;
        Object r74 = r73.next();
        String r75 = (String) r74;
        Iterable r76 = (Iterable) r9;
        if ((r76 instanceof Collection) == true) goto L205;
    L207:
        Iterator r77 = r76.iterator();
    L209:
        if (r77.hasNext() == false) goto L217;
        CreationItem r132 = ((cz9.b) r77.next()).a();
        if (r132 == null) goto L213;
        String r133 = r132.id;
    L215:
        if (Intrinsics.areEqual(r133, r75) == false) goto L209;
        boolean r78 = true;
    L219:
        if ((!r78) == false) goto L201;
        r72.add(r74);
        goto L201
    L213:
        r133 = null;
    L217:
        r78 = false;
        goto L219
    L205:
        if (((Collection) r76).isEmpty() == false) goto L207;
    L221:
        Iterator r79 = r72.iterator();
    L223:
        if (r79.hasNext() == false) goto L227;
        String r80 = (String) r79.next();
        cz9.g r81 = this.t.get(r80);
        if (r81 == null) goto L223;
        this.r.removeView(r81.N0());
        r81.f();
        this.t.remove(r80);
        goto L223
    L227:
        Iterator r82 = ((Iterable) r9).iterator();
    L229:
        if (r82.hasNext() == false) goto L244;
        cz9.b r83 = (cz9.b) r82.next();
        CreationItem r84 = r83.a();
        if (r84 == null) goto L233;
        String r85 = r84.id;
    L234:
        if (r85 != null) goto L236;
        r85 = "";
    L236:
        cz9.g r86 = this.t.get(r85);
        if (r86 != null) goto L242;
        r86 = r(r83);
        if (r86 == null) goto L241;
        this.t.put(r85, r86);
        this.r.addView(r86.N0());
        goto L242
    L241:
        r86 = null;
    L242:
        if (r86 == null) goto L229;
        r86.p2(r83);
        goto L229
    L233:
        r85 = null;
        goto L234
    L162:
        if (StringsKt.isBlank(r43) == true) goto L165;
        r44 = false;
    L168:
        r45 = false;
        goto L169
    L154:
        if (r41.isEmpty() == false) goto L156;
    L171:
        r46 = false;
        goto L172
    L146:
        r9 = 0;
        goto L147
    L23:
        if (ic8.n.q(r3) == true) goto L26;
        r5 = false;
    L20:
        r7 = false;
    L11:
        r3 = null;
        goto L12
    }
}
