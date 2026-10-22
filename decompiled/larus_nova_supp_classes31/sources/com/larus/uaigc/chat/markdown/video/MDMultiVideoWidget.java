package com.larus.uaigc.chat.markdown.video;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget;
import com.larus.uaigc.chat.markdown.helper.j0;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010*\u001a\u00020+H\u0016JR\u0010,\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020%2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000200\u0018\u00010/H\u0014J(\u00105\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010-\u001a\u00020%H\u0002J\u0010\u00106\u001a\u00020+2\u0006\u0010-\u001a\u00020%H\u0002J\u0010\u00107\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020+H\u0002J\u0016\u00109\u001a\u00020\u00152\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000203`4X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/uaigc/chat/markdown/video/MDMultiVideoWidget;", "Lcom/larus/uaigc/chat/markdown/AbsCustomCreationDataWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spanSize", "Landroid/util/Size;", "containerLayout", "Landroid/widget/LinearLayout;", "message", "Lcom/larus/im/bean/message/Message;", "markDownData", "Lcom/larus/uaigc/chat/markdown/bean/CreationPlaceholderData;", "creationContentData", "Lcom/larus/bmhome/creative/messagecard/bean/CreationMsgContentData;", "botId", "", "isCollectMode", "", "Ljava/lang/Boolean;", "currentPage", "previousPage", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "isLongPicShare", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "lastMaxWidth", "", "Ljava/lang/Integer;", "observeMessageChangeJob", "Lkotlinx/coroutines/Job;", "hasInit", "onRecycle", "", "bindData", "maxWidth", "payload", "", "", "taskIdViewMap", "Ljava/util/HashMap;", "Lcom/larus/uaigc/chat/markdown/video/MDSingleVideoWidget;", "Lkotlin/collections/HashMap;", "refreshViewState", "updateSizeInfo", "initView", "addMessageChangeObserver", "judgeAnyTaskChanged", "newTasks", "", "Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MDMultiVideoWidget extends AbsCustomCreationDataWidget {
    public static final /* synthetic */ int w = 0;
    public final AttributeSet c;
    public Size d;
    public final LinearLayout e;
    public Message f;
    public fz9.b g;
    public CreationMsgContentData h;
    public String i;
    public Boolean j;
    public String k;
    public String l;
    public q0.a m;
    public ChatPageContext n;
    public boolean o;
    public TextView p;
    public Spanned q;
    public usc.e r;
    public Integer s;
    public Job t;
    public boolean u;
    public final HashMap<String, MDSingleVideoWidget> v;

    public static final class a implements Function0<ChatPageContext> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
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

    @Override // com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget
    public final void c() {
        super.c();
        Job r0 = this.t;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.t = null;
        Iterator<Map.Entry<String, MDSingleVideoWidget>> r1 = this.v.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().getValue().f();
        goto L7
    L9:
        this.v.clear();
    }

    public MDMultiVideoWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.c = r4;
        this.d = new Size(0, 0);
        LinearLayout r0 = new LinearLayout(r3, r4);
        r0.setOrientation(1);
        this.e = r0;
        this.j = Boolean.FALSE;
        this.v = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, com.larus.uaigc.chat.markdown.video.MDSingleVideoWidget] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void e(TextView r22, Spanned r23, usc.e r24, int r25) {
        List<CreationTask> r1 = j0.e(this.g, this.h);
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        Set<String> r2 = this.v.keySet();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L6:
        int r5 = 0;
        if (r4.hasNext() == false) goto L22;
        Object r6 = r4.next();
        String r7 = (String) r6;
        List<CreationTask> r8 = r1;
        if ((r8 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((CreationTask) r9.next()).id, r7) == false) goto L15;
        r5 = 1;
    L20:
        if ((r5 ^ 1) == 0) goto L6;
        r3.add(r6);
        goto L6
    L11:
        if (r8.isEmpty() == false) goto L13;
    L22:
        Iterator r10 = r3.iterator();
    L24:
        if (r10.hasNext() == false) goto L28;
        String r11 = (String) r10.next();
        MDSingleVideoWidget r12 = this.v.get(r11);
        if (r12 == 0) goto L24;
        this.e.removeView(r12);
        r12.f();
        this.v.remove(r11);
        goto L24
    L28:
        Iterator<T> r13 = r1.iterator();
    L30:
        if (r13.hasNext() == false) goto L42;
        Object r14 = r13.next();
        int r15 = r5 + 1;
        if (r5 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        CreationTask r16 = (CreationTask) r14;
        String r17 = r16.id;
        if (r17 != null) goto L37;
        String r18 = "";
    L38:
        ConstraintLayout r19 = (MDSingleVideoWidget) this.v.get(r17);
        if (r19 != null) goto L41;
        r19 = new MDSingleVideoWidget(getContext(), this.c);
        this.v.put(r18, (MDSingleVideoWidget) r19);
        this.e.addView(r19, r5, new LinearLayout.LayoutParams(-1, -2));
    L41:
        r19.R5(LifecycleOwnerKt.getLifecycleScope(this), r16, r22, r23, r24, this.f, r25, this.i, this.k, this.l, this.j, this.m, this.o, this.n);
        r5 = r15;
        goto L30
    L37:
        r18 = r17;
        goto L38
    }

    @Override // com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget
    public final Size b(final TextView r8, Spanned r9, usc.e r10, Message r11, fz9.b r12, int r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r8, "textView");
        Intrinsics.checkNotNullParameter(r9, "text");
        Intrinsics.checkNotNullParameter(r10, "span");
        this.f = r11;
        this.g = r12;
        if (r11 == null) goto L5;
        CreationMsgContentData r15 = dp8.e.c(r11);
    L6:
        this.h = r15;
        if (r14 == null) goto L9;
        fh8.f r16 = fh8.h.b(r14);
    L10:
        if (r16 == null) goto L12;
        String r17 = r16.d;
    L13:
        this.i = r17;
        if (r16 == null) goto L16;
        String r18 = r16.e;
    L17:
        this.k = r18;
        if (r16 == null) goto L20;
        String r19 = r16.f;
    L21:
        this.l = r19;
        if (r16 == null) goto L24;
        Boolean r110 = r16.h;
    L25:
        this.j = r110;
        if (r16 == null) goto L28;
        q0.a r111 = r16.n;
    L29:
        this.m = r111;
        if (r16 == null) goto L36;
        AttachReceiver r112 = r16.o;
        if (r112 == null) goto L36;
        Lazy r113 = LazyKt.lazy(new a(r112));
        if (r113 == null) goto L36;
        ChatPageContext r114 = (ChatPageContext) r113.getValue();
    L37:
        this.n = r114;
        if (r16 == null) goto L40;
        RecyclerView.Adapter r115 = r16.p;
    L42:
        if ((r115 instanceof ry8.d) == false) goto L44;
        ry8.d r116 = (ry8.d) r115;
    L45:
        int r117 = 0;
        if (r116 == null) goto L48;
        boolean r118 = true;
    L49:
        this.o = r118;
        this.p = r8;
        this.q = r9;
        this.r = r10;
        if (this.u == true) goto L56;
        this.u = true;
        this.e.setOnLongClickListener(new com.larus.uaigc.chat.markdown.video.a(r8));
        removeAllViews();
        LinearLayout r119 = this.e;
        r119.removeAllViews();
        addView(r119);
        Job r120 = this.t;
        if (r120 == null) goto L55;
        Job.DefaultImpls.cancel$default(r120, null, 1, null);
    L55:
        this.t = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MDMultiVideoWidget$addMessageChangeObserver$1(this, null), 2, null);
    L56:
        e(r8, r9, r10, r13);
        this.s = Integer.valueOf(r13);
        if (this.v.isEmpty() == false) goto L59;
        this.d = new Size(0, 0);
    L67:
        return this.d;
    L59:
        Iterator<T> r20 = this.v.values().iterator();
    L61:
        if (r20.hasNext() == false) goto L63;
        r117 = r117 + ((MDSingleVideoWidget) r20.next()).a.getHeight();
        goto L61
    L63:
        LinearLayout r21 = this.e;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L69;
        r22.width = r13;
        r22.height = r117;
        r21.setLayoutParams(r22);
        this.d = new Size(r13, r117);
        goto L67
    L69:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L48:
        r118 = false;
        goto L49
    L44:
        r116 = null;
        goto L45
    L40:
        r115 = null;
    L36:
        r114 = null;
        goto L37
    L28:
        r111 = null;
        goto L29
    L24:
        r110 = null;
        goto L25
    L20:
        r19 = null;
        goto L21
    L16:
        r18 = null;
        goto L17
    L12:
        r17 = null;
        goto L13
    L9:
        r16 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
