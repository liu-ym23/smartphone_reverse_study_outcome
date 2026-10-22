package com.larus.uaigc.chat.markdown.image;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.creative.messagecard.bean.LoadingInfo;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.f3$a;
import com.larus.platform.service.e2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.chat.markdown.helper.CreationMDCardClickHelper;
import com.larus.uaigc.chat.markdown.helper.j0;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationImageScrollBinding;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ]2\u00020\u0001:\u0001]B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010<\u001a\u00020=H\u0016JR\u0010>\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010C\u001a\u00020\u00132\u0014\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020F\u0018\u00010EH\u0014J\u0010\u0010G\u001a\u00020=2\u0006\u0010#\u001a\u00020$H\u0002J*\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0013H\u0002J\u0010\u0010J\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u0013H\u0002J\u0018\u0010K\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u0013H\u0002J\u000f\u0010M\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010NJ8\u0010O\u001a\u00020=2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010Q2\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0013H\u0002J\u0010\u0010S\u001a\u00020=2\u0006\u0010T\u001a\u00020\u0013H\u0002J\u001e\u0010U\u001a\u00020=2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0082@¢\u0006\u0002\u0010ZJ\u001e\u0010[\u001a\u00020=2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0082@¢\u0006\u0002\u0010ZJ\b\u0010\\\u001a\u00020=H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010,\u001a\u0004\b9\u0010:¨\u0006^"}, d2 = {"Lcom/larus/uaigc/chat/markdown/image/MDImageScrollWidget;", "Lcom/larus/uaigc/chat/markdown/AbsCustomCreationDataWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spanSize", "Landroid/util/Size;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetMarkdownCreationImageScrollBinding;", "message", "Lcom/larus/im/bean/message/Message;", "markDownData", "Lcom/larus/uaigc/chat/markdown/bean/CreationPlaceholderData;", "creationContentData", "Lcom/larus/bmhome/creative/messagecard/bean/CreationMsgContentData;", "lastMaxWidth", "", "Ljava/lang/Integer;", "botId", "", "isCollectMode", "", "Ljava/lang/Boolean;", "currentPage", "previousPage", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "isLongPicShare", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "hostFragment", "Landroidx/fragment/app/Fragment;", "textView", "Landroid/widget/TextView;", "imageListAdapter", "Lcom/larus/uaigc/chat/markdown/image/MDImageScrollAdapter;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "imageSizeOption", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "defaultMaxWidth", "getDefaultMaxWidth", "()I", "imageEditorDependency", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "getImageEditorDependency", "()Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "imageEditorDependency$delegate", "videoEditorDependency", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "getVideoEditorDependency", "()Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "videoEditorDependency$delegate", "onRecycle", "", "bindData", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "maxWidth", "payload", "", "", "initView", "refreshViewState", "Lkotlinx/coroutines/Job;", "maxImageHeight", "maxImageWidth", "imageCount", "bindObservers", "()Ljava/lang/Boolean;", "updateSizeInfo", "taskList", "", "Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "onItemExpose", "pos", "bindImageItemLongClickAction", "itemData", "Lcom/larus/uaigc/chat/markdown/bean/GenImageViewData;", "itemView", "Landroid/view/View;", "(Lcom/larus/uaigc/chat/markdown/bean/GenImageViewData;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClickImageItem", "reloadFailedImages", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MDImageScrollWidget extends AbsCustomCreationDataWidget {
    public static final Lazy<Boolean> w = null;
    public static final Lazy<Boolean> x = null;
    public static final Lazy<Boolean> y = null;
    public Size c;
    public LarusWidgetMarkdownCreationImageScrollBinding d;
    public Message e;
    public fz9.b f;
    public CreationMsgContentData g;
    public Integer h;
    public String i;
    public Boolean j;
    public String k;
    public String l;
    public q0.a m;
    public boolean n;
    public ChatPageContext o;
    public Fragment p;
    public TextView q;
    public MDImageScrollAdapter r;
    public final Lazy s;
    public ResizeOptions t;
    public final Lazy u;
    public final Lazy v;

    public static final class a {
        public static boolean a() {
            return ((Boolean) MDImageScrollWidget.w.getValue()).booleanValue();
        }

        public static boolean b() {
            return ((Boolean) MDImageScrollWidget.x.getValue()).booleanValue();
        }
    }

    public static final class b implements Function0<ChatPageContext> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(ChatPageContext.class));
        }
    }

    static {
        w = LazyKt.lazy(new b0());
        x = LazyKt.lazy(new c0());
        y = LazyKt.lazy(new s());
    }

    private final int getDefaultMaxWidth() {
        if (((Boolean) y.getValue()).booleanValue() == false) goto L8;
        e2 r0 = e2.a;
        if (r0.g() == r0.f()) goto L8;
        return (int) (f3$a.a() / 3.3f);
    L8:
        return i5.a0();
    }

    private final com.larus.uaigc.chat.markdown.image.component.a getImageEditorDependency() {
        return (com.larus.uaigc.chat.markdown.image.component.a) this.u.getValue();
    }

    private final LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.s.getValue();
    }

    private final com.larus.uaigc.chat.markdown.image.component.k getVideoEditorDependency() {
        return (com.larus.uaigc.chat.markdown.image.component.k) this.v.getValue();
    }

    @Override // com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget
    public final void c() {
        super.c();
        removeAllViews();
        this.d = null;
    }

    public static final /* synthetic */ LinearLayoutManager f(MDImageScrollWidget r0) {
        return r0.getLayoutManager();
    }

    public MDImageScrollWidget(final Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.c = new Size(0, 0);
        this.j = Boolean.FALSE;
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.s = LazyKt.lazy(r5, new r(r3));
        this.t = new ResizeOptions(i5.B(), i5.B());
        this.u = LazyKt.lazy(r5, new u(this));
        this.v = LazyKt.lazy(r5, new v(this));
    }

    public static final Object e(MDImageScrollWidget r34, fz9.c r35, View r36, Continuation r37) {
        r34.getClass();
        if ((r37 instanceof MDImageScrollWidget$bindImageItemLongClickAction$1) == false) goto L7;
        MDImageScrollWidget$bindImageItemLongClickAction$1 r2 = (MDImageScrollWidget$bindImageItemLongClickAction$1) r37;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MDImageScrollWidget$bindImageItemLongClickAction$1 r11 = r2;
        Object r1 = r11.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r11.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        int r6 = r11.I$1;
        int r7 = r11.I$0;
        ImageItem r8 = (ImageItem) r11.L$4;
        IAIChatUgcAIGCService.Companion r9 = (IAIChatUgcAIGCService.Companion) r11.L$3;
        CreationTask r10 = (CreationTask) r11.L$2;
        Message r12 = (Message) r11.L$1;
        View r13 = (View) r11.L$0;
        ResultKt.throwOnFailure(r1);
    L92:
        ViewGroup r14 = null;
        df8.a r15 = new df8.a(r6, r8, null, (Map) r1);
        q0.a r16 = r34.m;
        LarusWidgetMarkdownCreationImageScrollBinding r0 = r34.d;
        if (r0 == null) goto L95;
        r14 = r0.b;
    L95:
        JSONObject r17 = new JSONObject();
        r17.putOpt("position", Boxing.boxInt(r7 + 1));
        r17.putOpt("creation_task_id", r10.id);
        IAIChatUgcAIGCService.a.a(r9, r13, r12, r16, r15, r14, r17);
    L102:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        View r18 = (View) r11.L$1;
        fz9.c r19 = (fz9.c) r11.L$0;
        ResultKt.throwOnFailure(r1);
        Object r20 = r1;
        View r21 = r18;
    L26:
        Message r110 = (Message) r20;
        if (r110 == null) goto L102;
        CreationMsgContentData r22 = dp8.e.c(r110);
        Map<String, CreationTask> r23 = j0.c(r22);
        boolean r24 = false;
        if (r23 == null) goto L44;
        Set<String> r25 = r23.keySet();
        if (r25 == null) goto L44;
        Iterator<T> r26 = r25.iterator();
        int r27 = 0;
    L34:
        if (r26.hasNext() == false) goto L42;
        Object r111 = r26.next();
        if (r27 >= 0) goto L39;
        CollectionsKt.throwIndexOverflow();
    L39:
        if (Intrinsics.areEqual(r19.getTaskId(), (String) r111) == true) goto L43;
        r27 = r27 + 1;
    L43:
        int r112 = r27;
    L45:
        if (r22 == null) goto L51;
        CreationInfo r28 = r22.creationInfo;
        if (r28 == null) goto L51;
        Map r29 = r28.taskInfo;
        if (r29 == null) goto L51;
        CreationTask r113 = (CreationTask) r29.get(r19.getTaskId());
    L52:
        if (r112 == (-1)) goto L96;
        if (r113 == null) goto L60;
        Integer r30 = r113.status;
        if (r30 == null) goto L60;
        if (r30.intValue() != 4) goto L60;
        r24 = true;
    L60:
        if (r24 == false) goto L96;
        CreationAsset r31 = r113.asset;
        if (r31 == null) goto L102;
        UserCreationImage r32 = r31.imageContent;
        if (r32 == null) goto L102;
        ImageInfo r33 = r32.a;
        if (r33 == null) goto L102;
        ImageItem r114 = j0.g(r33);
        IAIChatUgcAIGCService.Companion r38 = IAIChatUgcAIGCService.a;
        ImageItem r39 = ImageItem.copy$default(r114, null, null, null, null, null, null, null, null, null, null, null, false, null, r113.taskType, 8191, null);
        CreationChatItemClickHelper r40 = CreationChatItemClickHelper.a;
        String r41 = r34.k;
        String r42 = r34.l;
        Boolean r43 = r34.j;
        q0.a r115 = r34.m;
        if (r115 == null) goto L73;
        com.larus.bmhome.chat.component.cvs.y r116 = r115.u0();
        if (r116 == null) goto L73;
        BotModel r117 = r116.j0();
    L74:
        q0.a r118 = r34.m;
        if (r118 == null) goto L79;
        com.larus.bmhome.chat.component.cvs.y r119 = r118.u0();
        if (r119 == null) goto L79;
        wc9.e r120 = r119.h();
    L80:
        q0.a r44 = r34.m;
        if (r44 == null) goto L87;
        u7 r45 = r44.u3();
        if (r45 == null) goto L87;
        MessageAdapter r46 = r45.MF();
        if (r46 == null) goto L87;
        List r121 = r46.getCurrentList();
    L88:
        r11.L$0 = r21;
        r11.L$1 = r110;
        r11.L$2 = r113;
        r11.L$3 = r38;
        r11.L$4 = r39;
        r11.I$0 = r112;
        r11.I$1 = r112;
        r11.label = 2;
        wc9.e r47 = r120;
        CreationTask r122 = r113;
        Object r48 = CreationChatItemClickHelper.l(r40, r110, r41, r42, r43, r117, r47, r121, r11);
        if (r48 == r4) goto L107;
        r13 = r21;
        r1 = r48;
        r9 = r38;
        r10 = r122;
        r12 = r110;
        r6 = r112;
        r7 = r6;
        r8 = r39;
        goto L92
    L107:
        return r4;
    L87:
        r121 = null;
    L79:
        r120 = null;
    L73:
        r117 = null;
    L96:
        CreationTask r123 = r113;
        FLogger r49 = FLogger.a;
        StringBuilder r50 = new StringBuilder("onLongClickImageItem, taskStatus: ");
        if (r123 == null) goto L99;
        Integer r124 = r123.status;
    L100:
        r50.append(r124);
        r49.e("MDImageScrollWidget", r50.toString());
        return Unit.INSTANCE;
    L99:
        r124 = null;
    L51:
        r113 = null;
        goto L52
    L42:
        r27 = -1;
    L44:
        r112 = 0;
        goto L45
    L16:
        ResultKt.throwOnFailure(r1);
        CreationChatItemClickHelper r51 = CreationChatItemClickHelper.a;
        Message r52 = r34.e;
        if (r52 == null) goto L19;
        String r53 = r52.getMessageId();
    L20:
        if (r53 != null) goto L22;
        r53 = "";
    L22:
        r19 = r35;
        r11.L$0 = r19;
        r11.L$1 = r36;
        r11.label = 1;
        r51.getClass();
        Object r54 = CreationChatItemClickHelper.m(r53, r11);
        if (r54 == r4) goto L106;
        r20 = r54;
        r21 = r36;
        goto L26
    L106:
        return r4;
    L19:
        r53 = null;
    L7:
        r2 = new MDImageScrollWidget$bindImageItemLongClickAction$1(r34, r37);
        goto L8
    }

    public static final Object g(MDImageScrollWidget r19, fz9.c r20, View r21, Continuation r22) {
        r19.getClass();
        if ((r22 instanceof MDImageScrollWidget$onClickImageItem$1) == false) goto L7;
        MDImageScrollWidget$onClickImageItem$1 r2 = (MDImageScrollWidget$onClickImageItem$1) r22;
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
    L36:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r19), Dispatchers.getIO(), null, new MDImageScrollWidget$reloadFailedImages$1(r19, null), 2, null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if ((r20 instanceof fz9.e) == true) goto L38;
        CreationMDCardClickHelper r5 = CreationMDCardClickHelper.a;
        View r6 = r19.q;
        if (r6 != null) goto L21;
        r6 = r19;
    L21:
        String r7 = r19.k;
        String r8 = r19.l;
        Boolean r9 = r19.j;
        q0.a r10 = r19.m;
        Message r11 = r19.e;
        if (r11 == null) goto L24;
        String r12 = r11.getMessageId();
    L25:
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        String r13 = r12;
        String r14 = r20.getTaskId();
        d0 r16 = new d0(r19);
        LifecycleCoroutineScope r17 = LifecycleOwnerKt.getLifecycleScope(r19);
        com.larus.uaigc.chat.markdown.image.component.a r18 = r19.getImageEditorDependency();
        com.larus.uaigc.chat.markdown.image.component.k r110 = r19.getVideoEditorDependency();
        CreationChatItemClickHelper r23 = CreationChatItemClickHelper.a;
        q0.a r24 = r19.m;
        if (r24 == null) goto L32;
        qd8.b r25 = r24.H9();
        if (r25 == null) goto L32;
        e0 r111 = new e0(r25);
    L33:
        r23.getClass();
        iy9.b r112 = CreationChatItemClickHelper.i(r111, null, null);
        r2.label = 1;
        if (r5.a("MDImageScrollWidget", r6, r21, r7, r8, r9, r10, r13, r14, r16, r17, r18, r110, r112, r2) != r15) goto L36;
        return r15;
    L32:
        r111 = null;
        goto L33
    L24:
        r12 = null;
        goto L25
    L38:
        return Unit.INSTANCE;
    L7:
        r2 = new MDImageScrollWidget$onClickImageItem$1(r19, r22);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r12v11, types: [com.larus.uaigc.chat.markdown.image.x] */
    /* JADX WARN: Type inference failed for: r7v42, types: [com.larus.uaigc.chat.markdown.image.a0] */
    /* JADX WARN: Type inference failed for: r8v29, types: [com.larus.uaigc.chat.markdown.image.z] */
    /* JADX WARN: Type inference failed for: r9v24, types: [com.larus.uaigc.chat.markdown.image.y] */
    @Override // com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget
    public final Size b(final TextView r25, Spanned r26, usc.e r27, Message r28, fz9.b r29, int r30, Map<String, ? extends Object> r31) {
        String r5 = "<this>";
        Intrinsics.checkNotNullParameter(r25, "textView");
        Intrinsics.checkNotNullParameter(r26, "text");
        Intrinsics.checkNotNullParameter(r27, "span");
        if (r31 == null) goto L5;
        fh8.f r8 = fh8.h.b(r31);
    L6:
        if (r8 == null) goto L8;
        Message r0 = r8.b;
    L9:
        this.e = r0;
        this.f = r29;
        if (r28 == null) goto L12;
        CreationMsgContentData r1 = dp8.e.c(r28);
    L13:
        this.g = r1;
        if (r8 == null) goto L16;
        String r2 = r8.d;
    L17:
        this.i = r2;
        if (r8 == null) goto L20;
        String r3 = r8.e;
    L21:
        this.k = r3;
        if (r8 == null) goto L24;
        String r4 = r8.f;
    L25:
        this.l = r4;
        if (r8 == null) goto L28;
        Boolean r6 = r8.h;
    L29:
        this.j = r6;
        if (r8 == null) goto L32;
        q0.a r7 = r8.n;
    L33:
        this.m = r7;
        if (r8 == null) goto L40;
        AttachReceiver r9 = r8.o;
        if (r9 == null) goto L40;
        Lazy r10 = LazyKt.lazy(new b(r9));
        if (r10 == null) goto L40;
        ChatPageContext r11 = (ChatPageContext) r10.getValue();
    L41:
        this.o = r11;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L44
        Intrinsics.checkNotNullParameter(r25, "<this>");     // Catch: Throwable -> L44
        Object r13 = Result.constructor-impl(FragmentManager.findFragment(r25));     // Catch: Throwable -> L44
    L47:
        if (Result.isFailure-impl(r13) == false) goto L49;
        r13 = null;
    L49:
        this.p = (Fragment) r13;
        if (r8 == null) goto L52;
        RecyclerView.Adapter r14 = r8.p;
    L54:
        if ((r14 instanceof ry8.d) == false) goto L56;
        ry8.d r15 = (ry8.d) r14;
    L58:
        if (r15 == null) goto L60;
        boolean r16 = true;
    L61:
        this.n = r16;
        this.q = r25;
        if (this.d != null) goto L77;
        View r17 = LayoutInflater.from(getContext()).inflate(2131563256, this, false);
        addView(r17);
        int r18 = 2131375049;
        RecyclerView r19 = ViewBindings.findChildViewById(r17, 2131375049);
        if (r19 == null) goto L74;
        r18 = 2131375050;
        ImageCardNestedScrollableHost r110 = ViewBindings.findChildViewById(r17, 2131375050);
        if (r110 == null) goto L74;
        ConstraintLayout r20 = (ConstraintLayout) r17;
        this.d = new LarusWidgetMarkdownCreationImageScrollBinding(r20, r19, r110);
        r20.setOnLongClickListener(new w(r25));
        r19.setLayoutManager(getLayoutManager());
        MDImageScrollAdapter r111 = new MDImageScrollAdapter(LifecycleOwnerKt.getLifecycleScope(this), getImageEditorDependency(), getVideoEditorDependency(), new x(this), new y(this), new z(this), new a0(this), new MDImageScrollWidget$initView$1$6(this, null), new MDImageScrollWidget$initView$1$7(this, null));
        this.r = r111;
        r19.setAdapter(r111);
        r19.setItemAnimator(null);
        r19.addItemDecoration(new MDImageScrollWidget$initView$1$8());
        removeAllViews();
        addView(r20);
        LarusWidgetMarkdownCreationImageScrollBinding r21 = this.d;
        if (r21 == null) goto L72;
        ConstraintLayout r22 = r21.a;
        if (r22 == null) goto L72;
        r22.post(new t(this));
    L72:
        Unit r23 = Unit.INSTANCE;
    L74:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r18)));
    L77:
        if (this.d == null) goto L280;
        List<CreationTask> r24 = j0.e(this.f, this.g);
        int r32 = 4;
        if (r24 == null) goto L98;
        ArrayList r33 = new ArrayList();
        Iterator<T> r34 = r24.iterator();
    L82:
        if (r34.hasNext() == false) goto L99;
        Object r35 = r34.next();
        CreationTask r36 = (CreationTask) r35;
        Integer r37 = r36.status;
        if (r37 != null) goto L87;
    L88:
        Integer r38 = r36.status;
        if (r38 != null) goto L92;
    L94:
        boolean r39 = false;
    L96:
        if (r39 == false) goto L82;
        r33.add(r35);
        goto L82
    L92:
        if (r38.intValue() != 1) goto L94;
    L95:
        r39 = true;
        goto L96
    L87:
        if (r37.intValue() == 4) goto L95;
    L99:
        if (r33 != null) goto L101;
    L104:
        boolean r40 = true;
    L105:
        if (r40 == false) goto L107;
        this.c = new Size(0, 0);
    L202:
        if (r33 == null) goto L277;
        ArrayList r41 = new ArrayList();
        Iterator r42 = r33.iterator();
    L205:
        if (r42.hasNext() == false) goto L276;
        CreationTask r43 = (CreationTask) r42.next();
        Integer r44 = r43.status;
        if (r44 != null) goto L210;
    L212:
        if (r44 != null) goto L215;
    L272:
        r42 = r42;
        String r45 = r5;
        Object r46 = null;
    L273:
        if (r46 == null) goto L275;
        r41.add(r46);
    L275:
        r5 = r45;
        r42 = r42;
        r32 = 4;
        goto L205
    L215:
        if (r44.intValue() != r32) goto L272;
        String r112 = r43.id;
        ResizeOptions r47 = this.t;
        int r113 = r47.width;
        int r114 = r47.height;
        Message r115 = this.e;
        Integer r116 = r43.index;
        CreationAsset r48 = r43.asset;
        if (r48 == null) goto L242;
        UserCreationImage r49 = r48.imageContent;
        if (r49 == null) goto L242;
        ImageInfo r50 = r49.a;
        if (r50 == null) goto L242;
        String r117 = r5;
        Intrinsics.checkNotNullParameter(r50, r117);
        String r51 = j0.b(r50);
        if (r51 != null) goto L225;
        r42 = r42;
        ImageInfo r52 = r50;
    L243:
        IAIChatUgcAIGCService.Companion r53 = IAIChatUgcAIGCService.a;
        if (r53.E0() == true) goto L246;
    L248:
        boolean r118 = false;
    L250:
        if (r53.l0() == true) goto L252;
    L254:
        boolean r119 = false;
    L256:
        if (a.a() == true) goto L258;
    L262:
        boolean r120 = false;
    L264:
        if (a.b() == true) goto L266;
    L270:
        boolean r121 = false;
    L271:
        Integer r54 = r43.taskType;
        r45 = r117;
        r46 = new fz9.d(r112, r113, r114, r115, r116, r52, r118, r119, r120, r121, r54);
        goto L273
    L266:
        if (getVideoEditorDependency() == null) goto L270;
        if (this.n == true) goto L270;
        r121 = true;
        goto L271
    L258:
        if (getImageEditorDependency() == null) goto L262;
        if (this.n == true) goto L262;
        r120 = true;
        goto L264
    L252:
        if (this.n == true) goto L254;
        r119 = true;
        goto L256
    L246:
        if (this.n == true) goto L248;
        r118 = true;
        goto L250
    L225:
        Image r55 = r50.a;
        if (r55 == null) goto L228;
        Image r56 = j0.h(r55, r51);
    L229:
        Image r57 = r50.c;
        if (r57 == null) goto L232;
        Image r58 = j0.h(r57, r51);
    L233:
        Image r59 = r50.b;
        if (r59 == null) goto L236;
        Image r60 = j0.h(r59, r51);
    L237:
        Image r61 = r50.i;
        if (r61 == null) goto L240;
        Image r62 = j0.h(r61, r51);
    L241:
        r52 = ImageInfo.a(r50, r56, r60, r58, r62, null, 760);
        goto L243
    L240:
        r62 = null;
        goto L241
    L236:
        r60 = null;
        goto L237
    L232:
        r58 = null;
        goto L233
    L228:
        r56 = null;
    L242:
        r42 = r42;
        r117 = r5;
        r52 = null;
        goto L243
    L210:
        if (r44.intValue() != 1) goto L212;
        String r63 = r43.id;
        ResizeOptions r64 = this.t;
        r46 = new fz9.e(r63, r64.width, r64.height, this.e, r43.index);
        r42 = r42;
        r45 = r5;
        goto L273
    L276:
        ArrayList r65 = r41;
    L278:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new MDImageScrollWidget$refreshViewState$1$1(this, r65, null), 2, null);
        goto L280
    L277:
        r65 = null;
        goto L278
    L107:
        Integer r66 = this.h;
        if (r66 != null) goto L111;
    L117:
        this.h = Integer.valueOf(r30);
        int r67 = gw8.e.a(r26, r26.getSpanStart(r27)) + r25.getPaddingStart();
        int r68 = r25.getPaddingEnd();
        int r69 = (r30 - r67) - r68;
        CreationTask r70 = (CreationTask) CollectionsKt.getOrNull(r33, 0);
        if (r70 == null) goto L120;
        LoadingInfo r71 = r70.loadingInfo;
    L122:
        if (r71 == null) goto L126;
        Long r122 = r71.width;
        if (r122 == null) goto L126;
        long r123 = r122.longValue();
    L127:
        if (r71 == null) goto L131;
        Long r72 = r71.height;
        if (r72 == null) goto L131;
        long r124 = r72.longValue();
    L133:
        if (r123 > 0) goto L135;
    L136:
        CreationTask r125 = (CreationTask) CollectionsKt.getOrNull(r33, 0);
        if (r125 == null) goto L145;
        CreationAsset r73 = r125.asset;
        if (r73 == null) goto L145;
        UserCreationImage r74 = r73.imageContent;
        if (r74 == null) goto L145;
        ImageInfo r75 = r74.a;
        if (r75 == null) goto L145;
        Image r76 = r75.a;
    L146:
        if (r76 == null) goto L148;
        r123 = r76.c;
    L149:
        if (r76 == null) goto L151;
        r124 = r76.d;
    L153:
        if (r124 > 0) goto L155;
    L201:
        this.c = new Size(0, 0);
        goto L202
    L155:
        if (r123 <= 0) goto L201;
        float r77 = r124 / r123;
        if (r77 <= 1.7777778f) goto L160;
        r77 = 1.7777778f;
    L160:
        if (r77 >= 0.5625f) goto L163;
        r77 = 0.5625f;
    L163:
        if (r33.size() <= 1) goto L165;
        int r78 = RangesKt.coerceAtMost((int) (((double) r69) * 0.8d), getDefaultMaxWidth());
    L166:
        int r79 = RangesKt.coerceAtMost(r69, getDefaultMaxWidth());
        if (r77 <= 1.0f) goto L171;
        int r80 = (int) (r79 / r77);
        if (r80 >= r78) goto L171;
        r78 = r80;
    L173:
        if (r33.size() != 1) goto L175;
        int r81 = (r78 + r67) + r68;
    L176:
        LarusWidgetMarkdownCreationImageScrollBinding r82 = this.d;
        if (r82 == null) goto L185;
        ImageCardNestedScrollableHost r83 = r82.c;
        if (r83 == null) goto L185;
        ViewGroup.LayoutParams r126 = r83.getLayoutParams();
        if (r126 == null) goto L184;
        r126.height = r79;
        r126.width = r81;
        r83.setLayoutParams(r126);
        goto L185
    L184:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L185:
        LarusWidgetMarkdownCreationImageScrollBinding r84 = this.d;
        if (r84 == null) goto L194;
        RecyclerView r85 = r84.b;
        if (r85 == null) goto L194;
        ViewGroup.LayoutParams r127 = r85.getLayoutParams();
        if (r127 == null) goto L193;
        r127.height = r79;
        r127.width = r81;
        r85.setLayoutParams(r127);
        goto L194
    L193:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L194:
        LarusWidgetMarkdownCreationImageScrollBinding r86 = this.d;
        if (r86 == null) goto L199;
        RecyclerView r87 = r86.b;
        if (r87 == null) goto L199;
        int r88 = r87.getPaddingTop();
        int r128 = r87.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r87.getClass().getSimpleName() + ",source:,start:" + r67 + ",top:" + r88 + ",end:" + r68 + ",bottom:" + r128);
        r87.setPaddingRelative(r67, r88, r68, r128);
    L199:
        this.c = new Size(r30, i5.q() + r79);
        this.t = new ResizeOptions(r78, r79);
        goto L202
    L175:
        r81 = -1;
    L171:
        r79 = (int) (r78 * r77);
        goto L173
    L165:
        r78 = RangesKt.coerceAtMost(r69, getDefaultMaxWidth());
        goto L166
    L151:
        r124 = 0;
        goto L153
    L148:
        r123 = 0;
    L145:
        r76 = null;
        goto L146
    L135:
        if (r124 > 0) goto L153;
    L131:
        r124 = 0;
    L126:
        r123 = 0;
        goto L127
    L120:
        r71 = null;
        goto L122
    L111:
        if (r66.intValue() != r30) goto L117;
        if (this.c.getWidth() <= 0) goto L117;
        if (this.c.getHeight() <= 0) goto L117;
    L101:
        if (r33.isEmpty() == true) goto L104;
        r40 = false;
        goto L105
    L98:
        r33 = null;
    L280:
        return this.c;
    L60:
        r16 = false;
        goto L61
    L56:
        r15 = null;
        goto L58
    L52:
        r14 = null;
    L44:
        th = move-exception;
        Result.Companion r89 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        r11 = null;
        goto L41
    L32:
        r7 = null;
        goto L33
    L28:
        r6 = null;
        goto L29
    L24:
        r4 = null;
        goto L25
    L20:
        r3 = null;
        goto L21
    L16:
        r2 = null;
        goto L17
    L12:
        r1 = null;
        goto L13
    L8:
        r0 = null;
        goto L9
    L5:
        r8 = null;
        goto L6
    }
}
