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
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.block.create.AbsCreationBlockView;
import com.larus.uaigc.chat.block.widget.container.CreationItemListAdapter;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.chat.markdown.image.MDImageScrollWidget;
import com.larus.uaigc.impl.databinding.LarusLayoutCreationHorizontalScrollViewBinding;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kc8.a0;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 D2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0083\u0001\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\t2\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0019\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u0019H\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0013H\u0002J\u0012\u00101\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u00102\u001a\u00020\u0019H\u0002J\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u0019042\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J(\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010>J(\u0010?\u001a\u00020\u00192\u0006\u0010:\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010>J\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0019H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/larus/uaigc/chat/block/create/horizontal/CreationHorizontalGroup;", "Lcom/larus/uaigc/chat/block/create/AbsCreationBlockView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutCreationHorizontalScrollViewBinding;", "isFirstBind", "", "scrollAdapter", "Lcom/larus/uaigc/chat/block/widget/container/CreationItemListAdapter;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "curMaxWidth", "", "itemSize", "Landroid/util/Size;", "asView", "Landroid/view/View;", "bindData", "", "fragment", "Landroidx/fragment/app/Fragment;", "isLongPicShare", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "message", "Lcom/larus/im/bean/message/Message;", "blockModel", "Lcom/larus/uaigc/chat/block/create/ICreationBizModel;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "maxContentWidth", "isLastBlockModel", "disableCreateImagePreview", "onItemLongClick", "Lkotlin/Function2;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "(Landroidx/fragment/app/Fragment;ZLcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/chat/block/create/ICreationBizModel;Lcom/larus/bmhome/chat/ChatParam;IZLjava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;)V", "onRecycle", "refreshViewState", "updateSize", "initView", "binObservers", "handleCanvasAnchorEvent", "Lkotlin/Result;", "event", "Lcom/larus/canvas/service/bean/CanvasAnchorEvent;", "handleCanvasAnchorEvent-IoAF18A", "(Lcom/larus/canvas/service/bean/CanvasAnchorEvent;)Ljava/lang/Object;", "openBigImage", "itemData", "videoPlayParams", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "root", "(Lcom/larus/uaigc/chat/block/widget/CreationItemData;Lcom/larus/uaigc/bean/chat/VideoPlayParams;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClickItem", "reloadFailedImages", "recycleResource", "provideScreenshotParams", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationHorizontalGroup extends AbsCreationBlockView {
    public static final /* synthetic */ int w = 0;
    public final LarusLayoutCreationHorizontalScrollViewBinding r;
    public boolean s;
    public CreationItemListAdapter t;
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(e()), null, new CreationHorizontalGroup$reloadFailedImages$1(this, null), 2, null);
    }

    public CreationHorizontalGroup(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.r = LarusLayoutCreationHorizontalScrollViewBinding.a(LayoutInflater.from(r3));
        this.s = true;
        this.u = LazyKt.lazy(LazyThreadSafetyMode.NONE, new i(r3));
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

    public static final Object o(final CreationHorizontalGroup r28, cz9.b r29, iy9.b r30, View r31, Continuation r32) {
        r28.getClass();
        if ((r32 instanceof CreationHorizontalGroup$onClickItem$1) == false) goto L7;
        CreationHorizontalGroup$onClickItem$1 r2 = (CreationHorizontalGroup$onClickItem$1) r32;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        int r5 = 2;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L227:
        r28.k();
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
    L244:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r1);
        CreationItem r6 = r29.a();
        if (r6 != null) goto L19;
    L21:
        boolean r7 = false;
    L22:
        if (r7 == false) goto L242;
        kc8.q r8 = r28.f;
        if (r8 == null) goto L27;
        Function1 r9 = r8.m;
    L28:
        if (r9 == null) goto L35;
        if (r8 == null) goto L243;
        Function1 r0 = r8.m;
        if (r0 == null) goto L243;
        r0.invoke(Boxing.boxInt(r29.b()));
    L243:
        return Unit.INSTANCE;
    L35:
        if (Intrinsics.areEqual(r28.k, Boxing.boxBoolean(true)) == false) goto L199;
        r2.label = 1;
        CreationItem r10 = r29.a();
        if (r10 != null) goto L39;
    L41:
        boolean r11 = false;
    L42:
        if (r11 == true) goto L44;
        Unit r12 = Unit.INSTANCE;
    L196:
        if (r12 != r15) goto L244;
        Object r13 = r15;
    L246:
        return r13;
    L44:
        List<CreationItem> r14 = r28.m;
        if (r14 != null) goto L47;
        r14 = CollectionsKt.emptyList();
    L47:
        final ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r14.iterator();
    L49:
        if (r17.hasNext() == false) goto L60;
        Object r18 = r17.next();
        Integer r19 = ((CreationItem) r18).type;
        if (r19 != null) goto L54;
    L56:
        boolean r20 = false;
    L57:
        if (r20 == false) goto L49;
        r16.add(r18);
        goto L49
    L54:
        if (r19.intValue() != 1) goto L56;
        r20 = true;
        goto L57
    L60:
        if (r16.isEmpty() == false) goto L62;
        r12 = Unit.INSTANCE;
        goto L196
    L62:
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r22 = r16.iterator();
    L64:
        if (r22.hasNext() == false) goto L101;
        CreationItem r110 = (CreationItem) r22.next();
        ImageData r111 = r110.image;
        String r112 = r110.id;
        if (r111 == null) goto L70;
        ImageObj r113 = r111.imageOrigin;
        if (r113 == null) goto L70;
        String r114 = r113.url;
    L71:
        if (r114 != null) goto L73;
        String r115 = "";
    L74:
        if (r111 == null) goto L76;
        String r116 = r111.imageUri;
    L77:
        if (r116 != null) goto L79;
        String r117 = "";
    L80:
        if (r111 == null) goto L85;
        ImageObj r118 = r111.imageThumbRaw;
        if (r118 == null) goto L85;
        String r119 = r118.url;
        if (r119 == null) goto L85;
    L96:
        String r120 = r119;
    L97:
        if (r120 != null) goto L99;
        String r23 = "";
    L100:
        r21.add(new com.larus.bmhome.bigimg.l(r112, r115, r117, r23, null, null, null, null, null, null, 1024));
        goto L64
    L99:
        r23 = r120;
    L85:
        if (r111 == null) goto L89;
        ImageObj r121 = r111.imageThumb;
        if (r121 == null) goto L89;
        r119 = r121.url;
    L90:
        if (r119 != null) goto L96;
        if (r111 == null) goto L95;
        ImageObj r122 = r111.imagePreview;
        if (r122 == null) goto L95;
        r120 = r122.url;
    L95:
        r120 = null;
    L89:
        r119 = null;
        goto L90
    L79:
        r117 = r116;
        goto L80
    L76:
        r116 = null;
        goto L77
    L73:
        r115 = r114;
    L70:
        r114 = null;
        goto L71
    L101:
        Iterator r24 = r16.iterator();
        int r123 = 0;
    L103:
        if (r24.hasNext() == false) goto L134;
        CreationItem r124 = (CreationItem) r24.next();
        CreationItem r125 = r29.a();
        if (r125 == null) goto L107;
        String r126 = r125.id;
    L108:
        if (r126 != null) goto L110;
    L113:
        boolean r127 = true;
    L114:
        if (r127 == true) goto L116;
        boolean r128 = Intrinsics.areEqual(r124.id, r126);
    L131:
        if (r128 == true) goto L135;
        r123 = r123 + 1;
    L135:
        if (r123 >= 0) goto L137;
        r123 = 0;
    L137:
        List r25 = CollectionsKt.listOf(TuplesKt.to(Boxing.boxInt(r123), r31));
        Pair[] r129 = new Pair[4];
        r129[0] = TuplesKt.to("user_type", "bot");
        r129[1] = TuplesKt.to("enter_picture_method", "chat");
        ChatParam r130 = r28.g;
        if (r130 == null) goto L140;
        String r131 = r130.d;
    L141:
        if (r131 != null) goto L143;
        r131 = "";
    L143:
        r129[2] = TuplesKt.to("current_page", r131);
        ChatParam r132 = r28.g;
        if (r132 == null) goto L146;
        String r133 = r132.c;
    L147:
        if (r133 != null) goto L149;
        r133 = "";
    L149:
        r129[3] = TuplesKt.to("previous_page", r133);
        Map r134 = MapsKt.mutableMapOf(r129);
        Message r135 = r28.e;
        if (r135 == null) goto L152;
        String r136 = com.larus.im.bean.message.a.r(r135);
    L154:
        if (o0.d(r136) == false) goto L162;
        Message r137 = r28.e;
        if (r137 == null) goto L158;
        String r138 = com.larus.im.bean.message.a.r(r137);
    L159:
        if (r138 != null) goto L161;
        r138 = "";
    L161:
        r134.put("is_general_agent", r138);
        goto L162
    L158:
        r138 = null;
    L162:
        Message r139 = r28.e;
        if (r139 == null) goto L165;
        String r140 = com.larus.im.bean.message.a.s(r139);
    L167:
        if (o0.d(r140) == false) goto L175;
        Message r141 = r28.e;
        if (r141 == null) goto L171;
        String r142 = com.larus.im.bean.message.a.s(r141);
    L172:
        if (r142 != null) goto L174;
        r142 = "";
    L174:
        r134.put("chat_id", r142);
        goto L175
    L171:
        r142 = null;
    L175:
        ArrayList r143 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r26 = r21.iterator();
        int r144 = 0;
    L177:
        if (r26.hasNext() == false) goto L185;
        Object r145 = r26.next();
        int r146 = r144 + 1;
        if (r144 >= 0) goto L181;
        CollectionsKt.throwIndexOverflow();
    L181:
        Pair[] r147 = new Pair[r5];
        r147[0] = TuplesKt.to("position", Boxing.boxInt(r146));
        String r27 = ((com.larus.bmhome.bigimg.l) r145).a;
        if (r27 != null) goto L184;
        r27 = "";
    L184:
        r147[1] = TuplesKt.to("card_id", r27);
        r143.add(MapsKt.mutableMapOf(r147));
        r144 = r146;
        r5 = 2;
        goto L177
    L185:
        uo8.k r33 = new uo8.k(r134, r143);
        Context r34 = r28.r.a.getContext();
        Message r35 = r28.e;
        if (r35 == null) goto L188;
        String r148 = r35.getMessageId();
    L189:
        kc8.q r36 = r28.f;
        if (r36 == null) goto L194;
        Boolean r37 = r36.c;
        if (r37 == null) goto L194;
        boolean r149 = r37.booleanValue();
    L195:
        int r38 = r123;
        String r39 = r148;
        boolean r40 = r149;
        com.larus.bmhome.bigimg.k.c(r34, r25, r21, r38, r33, true, null, r39, r40, null, new c(r28, r16), new d(r16, r28), null, 8192);
        r28.k();
        r12 = Unit.INSTANCE;
    L194:
        r149 = true;
        goto L195
    L188:
        r148 = null;
        goto L189
    L165:
        r140 = null;
        goto L167
    L152:
        r136 = null;
        goto L154
    L146:
        r133 = null;
        goto L147
    L140:
        r131 = null;
        goto L141
    L116:
        CreationItem r150 = r29.a();
        if (r150 == null) goto L123;
        ImageData r151 = r150.image;
        if (r151 == null) goto L123;
        ImageObj r152 = r151.imageOrigin;
        if (r152 == null) goto L123;
        String r153 = r152.url;
    L124:
        ImageData r154 = r124.image;
        if (r154 == null) goto L129;
        ImageObj r155 = r154.imageOrigin;
        if (r155 == null) goto L129;
        String r156 = r155.url;
    L130:
        r128 = Intrinsics.areEqual(r156, r153);
    L129:
        r156 = null;
    L123:
        r153 = null;
        goto L124
    L110:
        if (r126.length() == 0) goto L113;
        r127 = false;
        goto L114
    L107:
        r126 = null;
        goto L108
    L134:
        r123 = -1;
        goto L135
    L39:
        if (bz9.a.f(r10) != true) goto L41;
        r11 = true;
        goto L42
    L199:
        CreationChatItemClickHelper r41 = CreationChatItemClickHelper.a;
        ImageCardNestedScrollableHost r42 = r28.r.a;
        ChatParam r43 = r28.g;
        if (r43 == null) goto L202;
        String r44 = r43.d;
    L203:
        if (r43 == null) goto L205;
        String r45 = r43.c;
    L206:
        boolean r46 = r28.h();
        kc8.q r157 = r28.f;
        Message r47 = r28.e;
        if (r47 == null) goto L209;
        String r48 = r47.getMessageId();
    L210:
        if (r48 != null) goto L212;
        String r158 = "";
    L213:
        Message r159 = r28.e;
        CreationItem r160 = r29.a();
        if (r160 == null) goto L245;
        j r49 = new j(r28);
        LifecycleCoroutineScope r161 = LifecycleOwnerKt.getLifecycleScope(r28);
        com.larus.uaigc.chat.markdown.image.component.a r162 = r28.f();
        com.larus.uaigc.chat.markdown.image.component.k r210 = r28.g();
        if (r30 != null) goto L223;
        kc8.q r50 = r28.f;
        if (r50 == null) goto L221;
        rd8.b r51 = r50.g;
    L222:
        r41.getClass();
        iy9.b r163 = CreationChatItemClickHelper.i(r51, null, null);
    L224:
        Boolean r52 = Boxing.boxBoolean(r46);
        r2.label = 2;
        r13 = r15;
        if (CreationChatItemClickHelper.q(r41, "CreationHorizontalGroup", r42, r31, r44, r45, r52, r157, r158, r160, r49, r161, r162, r210, r163, r159, null, false, r2, 229376) != r13) goto L227;
    L221:
        r51 = null;
        goto L222
    L223:
        r163 = r30;
        goto L224
    L245:
        return Unit.INSTANCE;
    L212:
        r158 = r48;
        goto L213
    L209:
        r48 = null;
        goto L210
    L205:
        r45 = null;
        goto L206
    L202:
        r44 = null;
        goto L203
    L27:
        r9 = null;
        goto L28
    L242:
        return Unit.INSTANCE;
    L19:
        if (bz9.a.f(r6) != true) goto L21;
        r7 = true;
    L7:
        r2 = new CreationHorizontalGroup$onClickItem$1(r28, r32);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v19, types: [com.larus.uaigc.chat.block.create.horizontal.f] */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.larus.uaigc.chat.block.create.horizontal.g] */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.larus.uaigc.chat.block.create.horizontal.h] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.ArrayList] */
    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void b(Fragment r23, boolean r24, final z r25, Message r26, com.larus.uaigc.chat.block.create.i r27, ChatParam r28, int r29, boolean r30, Boolean r31, com.larus.uaigc.chat.block.create.f r32, kc8.q r33) {
        Intrinsics.checkNotNullParameter(r26, "message");
        Intrinsics.checkNotNullParameter(r27, "blockModel");
        super.b(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);
        LarusLayoutCreationHorizontalScrollViewBinding r1 = this.r;
        int r4 = 0;
        if (this.s == false) goto L6;
        this.s = false;
        r1.a.setOnLongClickListener(new e(r25));
        r1.b.setLayoutManager(p());
        ExposureTrackerExtKt.b(r1.b);
        CreationItemListAdapter r2 = new CreationItemListAdapter(LifecycleOwnerKt.getLifecycleScope(this), f(), g(), this.f, new f(this), new g(this), new h(this), new CreationHorizontalGroup$initView$1$5(this, null), new CreationHorizontalGroup$initView$1$6(this, null));
        this.t = r2;
        r1.b.setAdapter(r2);
        r1.b.setItemAnimator(null);
        r1.b.addItemDecoration(new CreationHorizontalGroup$initView$1$7());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationHorizontalGroup$binObservers$1(this, null), 3, null);
    L6:
        LarusLayoutCreationHorizontalScrollViewBinding r3 = this.r;
        List<CreationItem> r5 = this.m;
        if (r5 == null) goto L9;
        CreationItem r6 = (CreationItem) CollectionsKt.firstOrNull(r5);
    L10:
        if (r6 == null) goto L16;
        int r7 = bz9.b.a;
        List<CreationItem> r8 = this.m;
        if (r8 == null) goto L14;
        int r9 = r8.size();
    L15:
        Size r10 = bz9.b.b(r6, r29, r9);
    L17:
        this.v = r10;
        ImageCardNestedScrollableHost r11 = r3.a;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L176;
        r12.height = (this.v.getHeight() + r3.a.getPaddingTop()) + r3.a.getPaddingBottom();
        r11.setLayoutParams(r12);
        kc8.q r13 = this.f;
        if (r13 == null) goto L24;
        a0 r14 = r13.d;
        if (r14 == null) goto L24;
        wc9.e r15 = r14.h();
    L25:
        int r16 = 1;
        if (r15 == null) goto L33;
        Integer r17 = r15.j;
        if (r17 == null) goto L33;
        if (r17.intValue() != 2) goto L33;
        boolean r18 = true;
    L34:
        if (r18 == false) goto L36;
    L39:
        boolean r19 = true;
    L40:
        List<CreationItem> r20 = this.m;
        if (r20 == null) goto L161;
        List r21 = new ArrayList();
        Iterator<T> r22 = r20.iterator();
    L44:
        if (r22.hasNext() == false) goto L162;
        CreationItem r34 = (CreationItem) r22.next();
        Integer r35 = r34.type;
        String r110 = "";
        if (r35 != null) goto L49;
    L115:
        if (r35 != null) goto L118;
    L157:
        Object r36 = null;
    L158:
        if (r36 == null) goto L160;
        r21.add(r36);
    L160:
        r16 = 1;
        goto L44
    L118:
        if (r35.intValue() != 2) goto L157;
        int r111 = this.v.getWidth();
        int r112 = this.v.getHeight();
        Message r113 = this.e;
        if (r113 == null) goto L131;
        com.larus.uaigc.chat.block.create.i r114 = this.j;
        if (r114 == null) goto L126;
        Block r115 = ((jc8.a) r114).a;
        if (r115 == null) goto L126;
        String r116 = r115.getBlockId();
    L127:
        if (r116 == null) goto L130;
        r110 = r116;
    L130:
        int r117 = bz9.a.d(r113, r110, r34);
    L132:
        boolean r118 = this.i;
        boolean r119 = !r118;
        if (r118 == true) goto L154;
        if (r19 == true) goto L154;
        Integer r120 = z2.a.attachmentEditConfig().getCreationVideoCoverFollowUp();
        if (r120 == null) goto L154;
        if (r120.intValue() != r16) goto L154;
        if (c().length() != 0) goto L143;
        boolean r121 = true;
    L144:
        if (r121 == true) goto L153;
        String r122 = c();
        e0 r37 = (e0) AuthModelDelegate.b.e().getValue();
        if (r37 == null) goto L150;
        LaunchInfo r38 = r37.a;
        if (r38 == null) goto L150;
        String r39 = r38.W();
    L152:
        if (Intrinsics.areEqual(r122, r39) == false) goto L154;
    L150:
        r39 = null;
    L153:
        boolean r40 = true;
    L155:
        Object r210 = new cz9.o(2, r111, r112, r34, r113, r117, r119, r40);
    L156:
        r36 = r210;
        goto L158
    L143:
        r121 = false;
    L154:
        r40 = false;
    L126:
        r116 = null;
        goto L127
    L131:
        r117 = 0;
        goto L132
    L49:
        if (r35.intValue() != r16) goto L115;
        int r123 = this.v.getWidth();
        int r124 = this.v.getHeight();
        Message r125 = this.e;
        if (r125 == null) goto L62;
        com.larus.uaigc.chat.block.create.i r41 = this.j;
        if (r41 == null) goto L57;
        Block r42 = ((jc8.a) r41).a;
        if (r42 == null) goto L57;
        String r43 = r42.getBlockId();
    L58:
        if (r43 == null) goto L61;
        r110 = r43;
    L61:
        int r126 = bz9.a.d(r125, r110, r34);
    L63:
        IAIChatUgcAIGCService.Companion r44 = IAIChatUgcAIGCService.a;
        if (r44.E0() == true) goto L66;
    L68:
        boolean r127 = false;
    L70:
        if (r44.l0() == true) goto L72;
    L74:
        boolean r128 = false;
    L75:
        Lazy<Boolean> r45 = MDImageScrollWidget.w;
        if (MDImageScrollWidget.a.a() == true) goto L78;
    L82:
        boolean r129 = false;
    L84:
        if (MDImageScrollWidget.a.b() == true) goto L86;
    L90:
        boolean r130 = false;
    L92:
        if (this.i == true) goto L113;
        if (r19 == true) goto L113;
        Integer r46 = z2.a.attachmentEditConfig().getCreationCoverFollowUp();
        if (r46 == null) goto L113;
        if (r46.intValue() != r16) goto L113;
        if (c().length() != 0) goto L102;
        boolean r47 = true;
    L103:
        if (r47 == true) goto L112;
        String r48 = c();
        e0 r131 = (e0) AuthModelDelegate.b.e().getValue();
        if (r131 == null) goto L109;
        LaunchInfo r132 = r131.a;
        if (r132 == null) goto L109;
        String r133 = r132.W();
    L111:
        if (Intrinsics.areEqual(r48, r133) == false) goto L113;
    L109:
        r133 = null;
    L112:
        boolean r211 = true;
    L114:
        r210 = new cz9.h(1, r123, r124, r34, r125, r126, r127, r128, r129, r130, r211);
        goto L156
    L102:
        r47 = false;
    L113:
        r211 = false;
        goto L114
    L86:
        if (g() == null) goto L90;
        if (this.i == true) goto L90;
        r130 = true;
        goto L92
    L78:
        if (f() == null) goto L82;
        if (this.i == true) goto L82;
        r129 = true;
        goto L84
    L72:
        if (this.i == true) goto L74;
        r128 = true;
        goto L75
    L66:
        if (this.i == true) goto L68;
        r127 = true;
    L57:
        r43 = null;
        goto L58
    L62:
        r126 = 0;
    L162:
        if (r21 != 0) goto L164;
        r21 = CollectionsKt.emptyList();
    L164:
        ImageCardNestedScrollableHost r49 = this.r.a;
        if (this.v.getHeight() > 0) goto L167;
    L169:
        boolean r50 = false;
    L170:
        if (r50 == true) goto L173;
        r4 = 8;
    L173:
        r49.setVisibility(r4);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new CreationHorizontalGroup$refreshViewState$1(this, r21, null), 2, null);
        return;
    L167:
        if (this.v.getWidth() <= 0) goto L169;
        r50 = true;
        goto L170
    L161:
        r21 = 0;
        goto L162
    L36:
        if (ic8.n.q(r15) == true) goto L39;
        r19 = false;
    L33:
        r18 = false;
    L24:
        r15 = null;
        goto L25
    L176:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        r9 = 0;
        goto L15
    L16:
        r10 = new Size(0, 0);
        goto L17
    L9:
        r6 = null;
        goto L10
    }
}
