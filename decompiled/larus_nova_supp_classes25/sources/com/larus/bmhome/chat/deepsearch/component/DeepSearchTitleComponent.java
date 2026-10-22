package com.larus.bmhome.chat.deepsearch.component;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepsearch.DeepSearchParam;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusPageDeepSearchBinding;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import ic8.v;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0014H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/deepsearch/component/DeepSearchTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchTitleAbility;", "<init>", "()V", "TAG", "", "deepSearchFragmentAbility", "Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchFragmentAbility;", "getDeepSearchFragmentAbility", "()Lcom/larus/bmhome/chat/deepsearch/component/IDeepSearchFragmentAbility;", "deepSearchFragmentAbility$delegate", "Lkotlin/Lazy;", "deepSearchParam", "Lcom/larus/bmhome/chat/deepsearch/DeepSearchParam;", "getDeepSearchParam", "()Lcom/larus/bmhome/chat/deepsearch/DeepSearchParam;", "deepSearchParam$delegate", "deepSearchCollectionMessage", "Lcom/larus/im/bean/message/Message;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageDeepSearchBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusPageDeepSearchBinding;", "binding$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "onAttach", "performShare", "performFavorite", "collectDeepSearchMessage", "message", "initFavoriteIcon", "initCollectMessage", "updateFavIconStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepSearchTitleComponent extends BaseContentWidget implements q {
    public static final /* synthetic */ int r = 0;
    public final String m;
    public final Lazy n;
    public final Lazy o;
    public Message p;
    public final Lazy q;

    public final LarusPageDeepSearchBinding h3() {
        return (LarusPageDeepSearchBinding) this.q.getValue();
    }

    public final DeepSearchParam m3() {
        return (DeepSearchParam) this.o.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, q.class);
    }

    public DeepSearchTitleComponent() {
        this.m = "DeepSearchTitle";
        this.n = LazyKt.lazy(new l(this));
        this.o = LazyKt.lazy(new m(this));
        this.q = LazyKt.lazy(new n(this));
    }

    @Override // com.larus.bmhome.chat.deepsearch.component.q
    public final void G6() {
        LarusPageDeepSearchBinding r0 = h3();
        String r1 = null;
        if (r0 == null) goto L9;
        ChatConstraintLayout r2 = r0.a;
        if (r2 == null) goto L9;
        RecyclerView r3 = r2.findViewById(2131379992);
        if (r3 == null) goto L9;
        RecyclerView.Adapter r4 = r3.getAdapter();
    L11:
        if ((r4 instanceof com.larus.bmhome.chat.adapter.i) == false) goto L13;
        com.larus.bmhome.chat.adapter.i r5 = (com.larus.bmhome.chat.adapter.i) r4;
    L15:
        if (r5 == null) goto L21;
        List r6 = r5.getMessageList();
        if (r6 == null) goto L21;
        v r7 = (v) CollectionsKt.getOrNull(r6, 0);
        if (r7 == null) goto L21;
        Message r8 = r7.a();
    L22:
        if (r8 != null) goto L24;
        return;
    L24:
        if (com.larus.bmhome.chat.bean.d.j0(r8) == false) goto L53;
        Map r9 = r8.getExt();
        if (r9 == null) goto L28;
        String r10 = (String) r9.get("deep_search_share_link");
    L29:
        FLogger.a.d(this.m, "[biz_deep_search] performShareLink -> " + r10 + ' ');
        ShareServiceDelegate r11 = ShareServiceDelegate.b;
        Context r12 = getContext();
        Map r13 = r8.getExt();
        if (r13 == null) goto L32;
        String r14 = (String) r13.get("deep_search_title");
    L33:
        Map r15 = r8.getExt();
        if (r15 == null) goto L36;
        String r16 = (String) r15.get("deep_search_description");
    L37:
        IShareService.a.c(r11, r12, r10, r14, r16, ShareScene.WEBVIEW, null, null, null, 480);
        com.larus.platform.service.o r17 = com.larus.platform.service.o.a;
        JSONObject r18 = new JSONObject();
        r18.put("current_page", "deep_search_page");
        r18.put("previous_page", "chat");
        DeepSearchParam r19 = m3();
        if (r19 == null) goto L40;
        String r20 = r19.c;
    L41:
        r18.put("conversation_id", r20);
        DeepSearchParam r21 = m3();
        if (r21 == null) goto L44;
        String r22 = r21.d;
    L45:
        r18.put("bot_id", r22);
        DeepSearchParam r23 = m3();
        if (r23 == null) goto L48;
        String r24 = r23.e;
    L49:
        r18.put("enter_method", r24);
        DeepSearchParam r25 = m3();
        if (r25 == null) goto L52;
        r1 = r25.b;
    L52:
        r18.put("message_id", r1);
        Unit r26 = Unit.INSTANCE;
        r17.reportEvent("deep_search_share_message", r18);
        return;
    L48:
        r24 = null;
        goto L49
    L44:
        r22 = null;
        goto L45
    L40:
        r20 = null;
        goto L41
    L36:
        r16 = null;
        goto L37
    L32:
        r14 = null;
        goto L33
    L28:
        r10 = null;
        goto L29
    L53:
        s.a.g(getContext(), 2131909115, false);
        return;
    L21:
        r8 = null;
        goto L22
    L13:
        r5 = null;
    L9:
        r4 = null;
        goto L11
    }

    @Override // com.larus.bmhome.chat.deepsearch.component.q
    public final void zt() {
        DeepSearchParam r0 = m3();
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.f, Boolean.TRUE);
    L7:
        if (r1 == false) goto L11;
        Message r2 = this.p;
        if (r2 == null) goto L11;
    L30:
        if (r2 != null) goto L32;
        return;
    L32:
        if (com.larus.bmhome.chat.bean.d.j0(r2) == false) goto L49;
        LarusPageDeepSearchBinding r3 = h3();
        if (r3 == null) goto L40;
        ChatConstraintLayout r4 = r3.a;
        if (r4 == null) goto L40;
        RecyclerView r5 = r4.findViewById(2131379992);
        if (r5 == null) goto L40;
        RecyclerView.Adapter r6 = r5.getAdapter();
    L42:
        if ((r6 instanceof q0) == false) goto L44;
        q0 r7 = (q0) r6;
    L45:
        if (r7 == null) goto L47;
        q0.a r8 = r7.getProvider();
    L48:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new DeepSearchTitleComponent$collectDeepSearchMessage$1(this, r2, r8, null), 2, null);
        return;
    L47:
        r8 = null;
        goto L48
    L44:
        r7 = null;
    L40:
        r6 = null;
        goto L42
    L49:
        s.a.g(getContext(), 2131909115, false);
        return;
    L11:
        LarusPageDeepSearchBinding r9 = h3();
        if (r9 == null) goto L18;
        ChatConstraintLayout r10 = r9.a;
        if (r10 == null) goto L18;
        RecyclerView r11 = r10.findViewById(2131379992);
        if (r11 == null) goto L18;
        RecyclerView.Adapter r12 = r11.getAdapter();
    L20:
        if ((r12 instanceof com.larus.bmhome.chat.adapter.i) == false) goto L22;
        com.larus.bmhome.chat.adapter.i r13 = (com.larus.bmhome.chat.adapter.i) r12;
    L23:
        if (r13 == null) goto L29;
        List r14 = r13.getMessageList();
        if (r14 == null) goto L29;
        v r15 = (v) CollectionsKt.getOrNull(r14, 0);
        if (r15 == null) goto L29;
        r2 = r15.a();
    L29:
        r2 = null;
        goto L30
    L22:
        r13 = null;
    L18:
        r12 = null;
        goto L20
    L5:
        r1 = false;
        goto L7
    }

    public final void onViewCreated(View r49) {
        Intrinsics.checkNotNullParameter(r49, "view");
        DeepSearchParam r1 = m3();
        if (r1 == null) goto L5;
        boolean r2 = Intrinsics.areEqual(r1.f, Boolean.TRUE);
    L7:
        if (r2 == false) goto L15;
        DeepSearchParam r3 = m3();
        if (r3 == null) goto L13;
        Message r4 = r3.g;
        if (r4 == null) goto L13;
        Message r5 = Message.copy$default(r4, null, null, null, 0, 21, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -17, 31, null);
    L14:
        this.p = r5;
    L13:
        r5 = null;
    L15:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new DeepSearchTitleComponent$initFavoriteIcon$1(this, null), 2, null);
        return;
    L5:
        r2 = false;
        goto L7
    }

    public static final void Y2(DeepSearchTitleComponent r2, Message r3) {
        r2.getClass();
        Regex r0 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r3).isCollected() == false) goto L9;
        LarusPageDeepSearchBinding r4 = r2.h3();
        if (r4 == null) goto L21;
        AppCompatImageView r5 = r4.c;
        if (r5 == null) goto L22;
        r5.setImageResource(2131242684);
        return;
    L22:
        return;
    L21:
        return;
    L9:
        LarusPageDeepSearchBinding r6 = r2.h3();
        if (r6 == null) goto L24;
        AppCompatImageView r7 = r6.c;
        if (r7 == null) goto L25;
        LarusPageDeepSearchBinding r8 = r2.h3();
        if (r8 == null) goto L18;
        AppCompatImageView r9 = r8.c;
        if (r9 == null) goto L18;
        Context r10 = r9.getContext();
    L19:
        r7.setImageResource(v19.c.b(2130971977, r10, 2131242682));
        return;
    L18:
        r10 = null;
        goto L19
    L25:
        return;
    }
}
