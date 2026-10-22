package com.larus.bmhome.chat.deepsearch.component;

import android.view.View;
import android.view.ViewStub;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepsearch.DeepSearchParam;
import com.larus.im.bean.message.Message;
import com.larus.list.arch.FlowListAdapter;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\u0012\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010)\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/deepsearch/component/DeepSearchContentComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchContentAbility;", "<init>", "()V", "TAG", "", "deepSearchParam", "Lcom/larus/bmhome/chat/deepsearch/DeepSearchParam;", "getDeepSearchParam", "()Lcom/larus/bmhome/chat/deepsearch/DeepSearchParam;", "deepSearchParam$delegate", "Lkotlin/Lazy;", "deepSearchFragmentAbility", "Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchFragmentAbility;", "getDeepSearchFragmentAbility", "()Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchFragmentAbility;", "deepSearchFragmentAbility$delegate", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageDeepSearchBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusPageDeepSearchBinding;", "binding$delegate", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "Lcom/larus/bmhome/chat/deepsearch/DeepSearchMessageAdapter;", "messageListView", "Landroidx/recyclerview/widget/RecyclerView;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "setupDeepSearchMessageList", "showDeepSearchMessageByMsgId", "msgId", "setUpRecycleView", "createAdapter", "sendInvisibleDeepSearchMessageIfNeeded", "fromMsgId", "setupConversationMessageObserver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepSearchContentComponent extends BaseContentWidget implements o {
    public static final /* synthetic */ int s = 0;
    public final String m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public q0 q;
    public RecyclerView r;

    public final DeepSearchParam Y2() {
        return (DeepSearchParam) this.n.getValue();
    }

    public final void h3() {
        DeepSearchParam r1 = Y2();
        if (r1 == null) goto L5;
        boolean r2 = Intrinsics.areEqual(r1.f, Boolean.TRUE);
    L6:
        String r3 = null;
        q0 r4 = null;
        String r5 = null;
        if (r2 == false) goto L58;
        DeepSearchParam r6 = Y2();
        if (r6 == null) goto L11;
        Message r7 = r6.g;
    L12:
        if (r7 == null) goto L58;
        DeepSearchParam r8 = Y2();
        if (r8 == null) goto L18;
        Message r9 = r8.g;
        if (r9 == null) goto L18;
        Message r10 = Message.copy$default(r9, null, null, null, 0, 21, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -17, 31, null);
    L19:
        if (r10 == null) goto L84;
        List r11 = CollectionsKt.listOf(r10);
        RecyclerView r12 = this.r;
        if (r12 == null) goto L23;
        RecyclerView.Adapter r13 = r12.getAdapter();
    L25:
        if ((r13 instanceof q0) == false) goto L27;
        q0 r14 = (q0) r13;
    L28:
        if (r14 == null) goto L30;
        com.larus.bmhome.chat.deepsearch.j.a(r14, r11, true);
    L30:
        RecyclerView r15 = this.r;
        if (r15 == null) goto L33;
        RecyclerView.Adapter r16 = r15.getAdapter();
    L35:
        if ((r16 instanceof q0) == false) goto L37;
        q0 r17 = (q0) r16;
    L38:
        String r18 = "";
        if (r17 == null) goto L44;
        String r19 = r10.getMessageId();
        if (r19 != null) goto L43;
        r19 = "";
    L43:
        r17.x7(r19, 800);
    L44:
        RecyclerView r20 = this.r;
        if (r20 == null) goto L47;
        RecyclerView.Adapter r21 = r20.getAdapter();
    L49:
        if ((r21 instanceof q0) == false) goto L51;
        r4 = (q0) r21;
    L51:
        if (r4 == null) goto L57;
        String r22 = r10.getMessageId();
        if (r22 == null) goto L56;
        r18 = r22;
    L56:
        r4.x7(r18, 2);
    L57:
        FLogger.a.d(this.m, "[biz_deep_search]DeepSearchMessageAdapter notifyItemChanged " + r10.getMessageId());
        return;
    L47:
        r21 = null;
        goto L49
    L37:
        r17 = null;
        goto L38
    L33:
        r16 = null;
        goto L35
    L27:
        r14 = null;
        goto L28
    L23:
        r13 = null;
        goto L25
    L84:
        return;
    L18:
        r10 = null;
        goto L19
    L11:
        r7 = null;
    L58:
        DeepSearchParam r23 = Y2();
        if (r23 == null) goto L61;
        String r24 = r23.a;
    L63:
        if (o0.d(r24) == false) goto L75;
        DeepSearchParam r25 = Y2();
        if (r25 == null) goto L67;
        String r26 = r25.a;
    L68:
        String r27 = String.valueOf(r26);
        if (o0.d(r27) == false) goto L71;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new DeepSearchContentComponent$showDeepSearchMessageByMsgId$1(r27, this, null), 2, null);
    L71:
        FLogger r28 = FLogger.a;
        String r29 = this.m;
        StringBuilder r30 = new StringBuilder("[biz_deep_search]showDeepSearchMessageByMsgId ");
        DeepSearchParam r31 = Y2();
        if (r31 == null) goto L74;
        r5 = r31.a;
    L74:
        r30.append(r5);
        r28.d(r29, r30.toString());
        return;
    L67:
        r26 = null;
        goto L68
    L75:
        DeepSearchParam r32 = Y2();
        if (r32 == null) goto L78;
        String r33 = r32.b;
    L79:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1(r33, this, null), 2, null);
        FLogger r34 = FLogger.a;
        String r35 = this.m;
        StringBuilder r36 = new StringBuilder("[biz_deep_search]sendInvisibleDeepSearchMessageIfNeeded ");
        DeepSearchParam r37 = Y2();
        if (r37 == null) goto L82;
        r3 = r37.b;
    L82:
        r36.append(r3);
        r34.d(r35, r36.toString());
        return;
    L78:
        r33 = null;
        goto L79
    L61:
        r24 = null;
        goto L63
    L5:
        r2 = false;
        goto L6
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, o.class);
    }

    public DeepSearchContentComponent() {
        this.m = "DeepSearchContent";
        this.n = LazyKt.lazy(new a(this));
        this.o = LazyKt.lazy(new b(this));
        this.p = LazyKt.lazy(new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.bmhome.chat.deepsearch.component.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.bmhome.chat.deepsearch.component.e, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r11) {
        Intrinsics.checkNotNullParameter(r11, "view");
        int r0 = com.larus.bmhome.chat.deepsearch.i.a;
        f r2 = new f();
        ChatParam r1 = new ChatParam(null, null, null, null, null, 255);
        ?? r4 = new d();
        ?? r5 = new e(this);
        g r7 = new g(this);
        Intrinsics.checkNotNullParameter(r2, "loader");
        Intrinsics.checkNotNullParameter(r1, "chatParam");
        Intrinsics.checkNotNullParameter(r4, "msgActionCallback");
        Intrinsics.checkNotNullParameter(r5, "hostFragment");
        Intrinsics.checkNotNullParameter(this, "componentFeature");
        Intrinsics.checkNotNullParameter(r7, "provider");
        ILegacyChatUiServiceDelegate r8 = ILegacyChatUiServiceDelegate.b;
        FlowListAdapter r3 = r8.P8(r2, r1, r4, r5, this, r7);
        CopyOnWriteArraySet r6 = xc8.f.a;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.list.arch.FlowListAdapter<*>");
        xc8.f.d(r3);
        this.q = r3;
        RecyclerView r9 = this.r;
        String r10 = null;
        if (r9 == null) goto L9;
        r9.setLayoutManager(new LinearLayoutManager(r9.getContext()));
        r9.addItemDecoration(new ConversationMessageListItemDecoration(0));
        RecyclerView.Adapter r12 = this.q;
        if ((r12 instanceof RecyclerView.Adapter) == false) goto L7;
        RecyclerView.Adapter r13 = r12;
    L8:
        r9.setAdapter(r13);
        goto L9
    L7:
        r13 = null;
    L9:
        DeepSearchParam r14 = Y2();
        if (r14 == null) goto L19;
        String r15 = r14.c;
        if (r15 == null) goto L19;
        com.larus.im.d.e().registerOnMessageChangedObserver(r15, new j(this, r15));
        DeepSearchParam r16 = Y2();
        if (r16 == null) goto L16;
        r10 = r16.c;
    L16:
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        k r17 = new k(this, r15);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        com.larus.im.internal.stream.b.a.b(r10, r17);
    L19:
        h3();
        ViewStub r18 = (ViewStub) r11.findViewById(2131379994);
        if (r18 == null) goto L22;
        r8.Q8(r18);
    L22:
        this.r = r11.findViewById(2131379992);
    }
}
