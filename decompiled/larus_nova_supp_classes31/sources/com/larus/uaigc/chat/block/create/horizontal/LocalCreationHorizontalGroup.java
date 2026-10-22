package com.larus.uaigc.chat.block.create.horizontal;

import android.content.Context;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.chat.ChatParam;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.uaigc.chat.block.create.AbsCreationBlockView;
import com.larus.uaigc.chat.block.widget.container.LocalCreationItemListAdapter;
import com.larus.uaigc.chat.markdown.helper.LocalCreationChatItemClickHelper;
import com.larus.uaigc.chat.markdown.helper.f1;
import com.larus.uaigc.chat.markdown.helper.g1;
import com.larus.uaigc.chat.markdown.helper.h1;
import com.larus.uaigc.impl.databinding.LarusLayoutCreationHorizontalScrollViewBinding;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0083\u0001\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\t2\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!\u0018\u0001012\b\u00103\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0002\u00105J\b\u00106\u001a\u00020!H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0017H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020209H\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0017H\u0002J\u0012\u0010;\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010<\u001a\u00020!H\u0002J\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020!0>2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020EH\u0002J(\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u0002022\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010KJ\b\u0010L\u001a\u00020!H\u0016J\b\u0010M\u001a\u00020!H\u0002J\b\u0010N\u001a\u00020!H\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006R"}, d2 = {"Lcom/larus/uaigc/chat/block/create/horizontal/LocalCreationHorizontalGroup;", "Lcom/larus/uaigc/chat/block/create/AbsCreationBlockView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutCreationHorizontalScrollViewBinding;", "isFirstBind", "", "scrollAdapter", "Lcom/larus/uaigc/chat/block/widget/container/LocalCreationItemListAdapter;", "getScrollAdapter", "()Lcom/larus/uaigc/chat/block/widget/container/LocalCreationItemListAdapter;", "setScrollAdapter", "(Lcom/larus/uaigc/chat/block/widget/container/LocalCreationItemListAdapter;)V", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "curMaxWidth", "", "itemSize", "Landroid/util/Size;", "getItemSize", "()Landroid/util/Size;", "setItemSize", "(Landroid/util/Size;)V", "asView", "Landroid/view/View;", "bindData", "", "fragment", "Landroidx/fragment/app/Fragment;", "isLongPicShare", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "message", "Lcom/larus/im/bean/message/Message;", "blockModel", "Lcom/larus/uaigc/chat/block/create/ICreationBizModel;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "maxContentWidth", "isLastBlockModel", "disableCreateImagePreview", "onItemLongClick", "Lkotlin/Function2;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "(Landroidx/fragment/app/Fragment;ZLcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/chat/block/create/ICreationBizModel;Lcom/larus/bmhome/chat/ChatParam;IZLjava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;)V", "onRecycle", "refreshViewState", "generateViewDataList", "", "updateSize", "initView", "binObservers", "handleCanvasAnchorEvent", "Lkotlin/Result;", "event", "Lcom/larus/canvas/service/bean/CanvasAnchorEvent;", "handleCanvasAnchorEvent-IoAF18A", "(Lcom/larus/canvas/service/bean/CanvasAnchorEvent;)Ljava/lang/Object;", "findPositionForSelectedData", "data", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "onClickItem", "itemData", "videoPlayParams", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "root", "(Lcom/larus/uaigc/chat/block/widget/CreationItemData;Lcom/larus/uaigc/bean/chat/VideoPlayParams;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reloadFailedImages", "preGenerateLocalImagePreviewCaches", "recycleResource", "provideScreenshotParams", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LocalCreationHorizontalGroup extends AbsCreationBlockView {
    public static final /* synthetic */ int w = 0;
    public final LarusLayoutCreationHorizontalScrollViewBinding r;
    public boolean s;
    public LocalCreationItemListAdapter t;
    public final Lazy u;
    public Size v;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final View a() {
        return this.r.a;
    }

    public final LinearLayoutManager p() {
        return (LinearLayoutManager) this.u.getValue();
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void j() {
        super.j();
        int r0 = p().getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = p().getChildAt(r1);
        if (r2 == null) goto L12;
        cz9.g r3 = this.r.b.getChildViewHolder(r2);
        if ((r3 instanceof cz9.g) == false) goto L9;
        cz9.g r4 = r3;
    L10:
        if (r4 == null) goto L12;
        r4.f();
        goto L12
    L9:
        r4 = null;
    L12:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void k() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(e()), null, new LocalCreationHorizontalGroup$reloadFailedImages$1(this, null), 2, null);
    }

    public LocalCreationHorizontalGroup(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.r = LarusLayoutCreationHorizontalScrollViewBinding.a(LayoutInflater.from(r3));
        this.s = true;
        this.u = LazyKt.lazy(LazyThreadSafetyMode.NONE, new q(r3));
        this.v = new Size(0, 0);
    }

    public final JSONObject m(Message r21) {
        Intrinsics.checkNotNullParameter(r21, "message");
        JSONObject r0 = new JSONObject();
        List r2 = com.larus.im.bean.message.a.l(r21);
        ArrayList r12 = new ArrayList();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        String r4 = ((CreationItem) r3.next()).id;
        if (r4 == null) goto L4;
        r12.add(r4);
        goto L4
    L8:
        r0.put("ai_creation_message_id", r21.getMessageId());
        Integer r6 = null;
        String r1 = CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null);
        r0.put("creation_task_id", r1);
        LinearLayoutManager r5 = this.r.b.getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == false) goto L11;
        LinearLayoutManager r7 = r5;
    L12:
        if (r7 != null) goto L14;
        return r0;
    L14:
        Integer r8 = Integer.valueOf(r7.findFirstCompletelyVisibleItemPosition());
        if (r8.intValue() == (-1)) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == true) goto L21;
        r8 = null;
    L21:
        if (r8 == null) goto L23;
        int r10 = r8.intValue();
    L24:
        Integer r11 = Integer.valueOf(r7.findLastCompletelyVisibleItemPosition());
        if (r11.intValue() == (-1)) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L30;
        r6 = r11;
    L30:
        if (r6 == null) goto L32;
        int r14 = r6.intValue();
    L33:
        if (r10 == (-1)) goto L47;
        if (r14 == (-1)) goto L47;
        int r15 = RangesKt.coerceAtLeast(r10, 0);
        int r16 = RangesKt.coerceAtMost(r14, r12.size() - 1);
        if (r15 > r16) goto L47;
        List r17 = r12.subList(r15, r16 + 1);
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L39:
        if (r19.hasNext() == false) goto L46;
        Object r20 = r19.next();
        if (((String) r20).length() <= 0) goto L43;
        boolean r22 = true;
    L44:
        if (r22 == false) goto L39;
        r18.add(r20);
        goto L39
    L43:
        r22 = false;
        goto L44
    L46:
        r1 = CollectionsKt.joinToString$default(r18, ",", null, null, 0, null, null, 62, null);
    L47:
        r0.put("creation_task_id", r1);
        return r0;
    L32:
        r14 = r7.findLastVisibleItemPosition();
        goto L33
    L27:
        r13 = false;
        goto L28
    L23:
        r10 = r7.findFirstVisibleItemPosition();
        goto L24
    L17:
        r9 = false;
        goto L18
    L11:
        r7 = null;
        goto L12
    }

    public static final Object o(LocalCreationHorizontalGroup r24, cz9.b r25, iy9.b r26, View r27, Continuation r28) {
        r24.getClass();
        if ((r28 instanceof LocalCreationHorizontalGroup$onClickItem$1) == false) goto L7;
        LocalCreationHorizontalGroup$onClickItem$1 r2 = (LocalCreationHorizontalGroup$onClickItem$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L57:
        r24.k();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        CreationItem r5 = r25.a();
        if (r5 != null) goto L18;
        return Unit.INSTANCE;
    L18:
        if (bz9.c.e(r5) != true) goto L60;
        kc8.q r6 = r24.f;
        if (r6 == null) goto L23;
        Function1 r7 = r6.m;
    L24:
        if (r7 == null) goto L30;
        if (r6 == null) goto L61;
        Function1 r0 = r6.m;
        if (r0 == null) goto L61;
        r0.invoke(Boxing.boxInt(r25.b()));
    L61:
        return Unit.INSTANCE;
    L30:
        LocalCreationChatItemClickHelper r8 = LocalCreationChatItemClickHelper.a;
        ImageCardNestedScrollableHost r9 = r24.r.a;
        ChatParam r10 = r24.g;
        if (r10 == null) goto L33;
        String r12 = r10.d;
    L34:
        if (r10 == null) goto L36;
        String r13 = r10.c;
    L37:
        boolean r14 = r24.h();
        kc8.q r11 = r24.f;
        Message r16 = r24.e;
        if (r16 == null) goto L40;
        String r17 = r16.getMessageId();
    L41:
        if (r17 != null) goto L43;
        r17 = "";
    L43:
        String r18 = r17;
        Message r19 = r24.e;
        CreationItem r110 = r25.a();
        if (r110 == null) goto L62;
        r r20 = new r(r24);
        LifecycleCoroutineScope r111 = LifecycleOwnerKt.getLifecycleScope(r24);
        com.larus.uaigc.chat.markdown.image.component.a r112 = r24.f();
        com.larus.uaigc.chat.markdown.image.component.k r21 = r24.g();
        if (r26 != null) goto L53;
        kc8.q r22 = r24.f;
        if (r22 == null) goto L51;
        rd8.b r23 = r22.g;
    L52:
        iy9.b r29 = new iy9.b(new f1(r23), new g1(r23), new h1(r23), null, null);
    L54:
        Boolean r30 = Boxing.boxBoolean(r14);
        r2.label = 1;
        if (r8.i("LocalCreationHorizontalGroup", r9, r27, r12, r13, r30, r11, r18, r110, r20, r111, r112, r21, r29, r19, r2) != r15) goto L57;
        return r15;
    L51:
        r23 = null;
        goto L52
    L53:
        r29 = r26;
        goto L54
    L62:
        return Unit.INSTANCE;
    L40:
        r17 = null;
        goto L41
    L36:
        r13 = null;
        goto L37
    L33:
        r12 = null;
        goto L34
    L23:
        r7 = null;
        goto L24
    L60:
        return Unit.INSTANCE;
    L7:
        r2 = new LocalCreationHorizontalGroup$onClickItem$1(r24, r28);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.uaigc.chat.block.create.horizontal.n] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.larus.uaigc.chat.block.create.horizontal.o] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.uaigc.chat.block.create.horizontal.p] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.ArrayList] */
    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void b(Fragment r16, boolean r17, final z r18, Message r19, com.larus.uaigc.chat.block.create.i r20, ChatParam r21, int r22, boolean r23, Boolean r24, com.larus.uaigc.chat.block.create.f r25, kc8.q r26) {
        Intrinsics.checkNotNullParameter(r19, "message");
        Intrinsics.checkNotNullParameter(r20, "blockModel");
        super.b(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        this.m = bz9.c.b(r20);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(e()), null, new LocalCreationHorizontalGroup$preGenerateLocalImagePreviewCaches$1(this, null), 2, null);
        LarusLayoutCreationHorizontalScrollViewBinding r2 = this.r;
        int r4 = 0;
        if (this.s == false) goto L6;
        this.s = false;
        r2.a.setOnLongClickListener(new m(r18));
        r2.b.setLayoutManager(p());
        ExposureTrackerExtKt.b(r2.b);
        LocalCreationItemListAdapter r3 = new LocalCreationItemListAdapter(LifecycleOwnerKt.getLifecycleScope(this), f(), g(), this.f, new n(this), new o(this), new p(this), new LocalCreationHorizontalGroup$initView$1$5(this, null), new LocalCreationHorizontalGroup$initView$1$6(this, null));
        this.t = r3;
        r2.b.setAdapter(r3);
        r2.b.setItemAnimator(null);
        r2.b.addItemDecoration(new LocalCreationHorizontalGroup$initView$1$7());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LocalCreationHorizontalGroup$binObservers$1(this, null), 3, null);
    L6:
        LarusLayoutCreationHorizontalScrollViewBinding r5 = this.r;
        List<CreationItem> r6 = this.m;
        if (r6 == null) goto L9;
        CreationItem r7 = (CreationItem) CollectionsKt.firstOrNull(r6);
    L10:
        if (r7 == null) goto L16;
        List<CreationItem> r8 = this.m;
        if (r8 == null) goto L14;
        int r9 = r8.size();
    L15:
        Size r10 = bz9.c.a(r7, r22, r9);
    L17:
        this.v = r10;
        ImageCardNestedScrollableHost r11 = r5.a;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L50;
        r12.height = (this.v.getHeight() + r5.a.getPaddingTop()) + r5.a.getPaddingBottom();
        r11.setLayoutParams(r12);
        List<CreationItem> r13 = this.m;
        if (r13 == null) goto L35;
        List r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L23:
        if (r15.hasNext() == false) goto L36;
        CreationItem r27 = (CreationItem) r15.next();
        Message r28 = this.e;
        com.larus.uaigc.chat.block.create.i r29 = this.j;
        if (r29 == null) goto L29;
        Block r30 = ((jc8.a) r29).a;
        if (r30 == null) goto L29;
        String r31 = r30.getBlockId();
    L30:
        if (r31 != null) goto L32;
        r31 = "";
    L32:
        cz9.b r32 = bz9.c.n(r27, r28, r31, this.v.getWidth(), this.v.getHeight(), this.i);
        if (r32 == null) goto L23;
        r14.add(r32);
    L29:
        r31 = null;
    L36:
        if (r14 != 0) goto L38;
        r14 = CollectionsKt.emptyList();
    L38:
        ImageCardNestedScrollableHost r33 = this.r.a;
        if (this.v.getHeight() > 0) goto L41;
    L43:
        boolean r34 = false;
    L44:
        if (r34 == true) goto L47;
        r4 = 8;
    L47:
        r33.setVisibility(r4);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new LocalCreationHorizontalGroup$refreshViewState$1(this, r14, null), 2, null);
        return;
    L41:
        if (this.v.getWidth() <= 0) goto L43;
        r34 = true;
        goto L44
    L35:
        r14 = 0;
        goto L36
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        r9 = 0;
        goto L15
    L16:
        r10 = new Size(0, 0);
        goto L17
    L9:
        r7 = null;
        goto L10
    }
}
