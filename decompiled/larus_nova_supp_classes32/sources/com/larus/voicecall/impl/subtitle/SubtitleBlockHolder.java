package com.larus.voicecall.impl.subtitle;

import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerSubtitleBlockBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010)\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0016\u0010.\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0006\u0012\u0004\u0018\u0001010/H\u0002J\u0006\u00102\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u00064"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/SubtitleBlockHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleBlockBinding;", "paramProvider", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;", "selectCallBack", "Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "actionProvider", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;", "<init>", "(Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleBlockBinding;Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;)V", "getBinding", "()Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleBlockBinding;", "getParamProvider", "()Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;", "getSelectCallBack", "()Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "getActionProvider", "()Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;", LynxResourceModule.DATA_KEY, "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "mainHandler", "Landroid/os/Handler;", "containerView", "Lcom/larus/mainbot/api/block/ui/AbsBlockContainerView;", "getContainerView", "()Lcom/larus/mainbot/api/block/ui/AbsBlockContainerView;", "onMsgInterrupt", NameKeys.UnloadStrategy_No_Strategy, "updateIsLastMsg", "isLastMessage", NameKeys.UnloadStrategy_No_Strategy, "markdownClickProcessor", "Lcom/larus/bmhome/chat/service/MarkdownClickProcessorApi;", "getMarkdownClickProcessor", "()Lcom/larus/bmhome/chat/service/MarkdownClickProcessorApi;", "markdownClickProcessor$delegate", "Lkotlin/Lazy;", "generateBlockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "bindText", "filterBlocks", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/im/bean/message/block/Block;", "blocks", "generateMobParam", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "onViewDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubtitleBlockHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int i = 0;
    public final LarusItemRecyclerSubtitleBlockBinding a;
    public final f b;
    public final u1 c;
    public final g d;
    public c e;
    public final Handler f;
    public hk9.a g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final hk9.a U3() {
        if (this.g != null) goto L6;
        int r0 = ra8.a.a;
        View r1 = ra8.a.a(this.a.a.getContext());
        this.a.b.addView(r1, new FrameLayout.LayoutParams(-1, -2));
        this.g = r1;
    L6:
        return this.g;
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [com.larus.voicecall.impl.subtitle.a1] */
    public final void T3(final c r61, final boolean r62) {
        Intrinsics.checkNotNullParameter(r61, LynxResourceModule.DATA_KEY);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.f.post(new z0(this, r61, r62));
        return;
    L6:
        final List<Block> r2 = r61.b;
        if (r2 != null) goto L10;
        FLogger.a.e("SubtitleBlockHolder", "blockData is null");
        return;
    L10:
        this.e = r61;
        Block r1 = (Block) CollectionsKt.lastOrNull(r2);
        if (r1 == null) goto L13;
        boolean r3 = r1.isFinish();
    L15:
        if (r3 == true) goto L21;
        if (r62 == false) goto L21;
        if (this.b.c() == false) goto L21;
        boolean r8 = false;
    L22:
        final ArrayList r9 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L24:
        if (r4.hasNext() == false) goto L33;
        Object r5 = r4.next();
        Block r10 = (Block) r5;
        if (r10.getBlockType() == com.larus.bmhome.chat.deepresearch.view.j.e) goto L28;
    L30:
        boolean r11 = false;
    L31:
        if (r11 == false) goto L24;
        r9.add(r5);
        goto L24
    L28:
        if (r10.getParentId() != null) goto L30;
        r11 = true;
        goto L31
    L33:
        kc8.f r12 = new kc8.f(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null), Boolean.valueOf(r8), true, false, null, null, 504);
        ra8.b r6 = new ra8.b(null, null, null, false, Boolean.valueOf(r8), null, SpeechEvent.SERVER_UPLINK_EVENT_UPDATE_UI_CONTEXT);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r12.h = r6;
        hk9.a r7 = U3();
        if (r7 == null) goto L36;
        int r13 = kc8.y.J;
        kc8.y.a r14 = new kc8.y.a();
        r14.p = new d1();
        r14.q = Boolean.FALSE;
        r14.v = new e1(this);
        r14.i = new f1();
        kc8.y r15 = r14.a();
        int r16 = kc8.v0.p;
        kc8.v0.a r17 = new kc8.v0.a();
        int r18 = com.larus.utils.m0.a;
        r17.b = Integer.valueOf(com.larus.utils.m0.b(this.a.a.getContext()) - i5.p0());
        r17.a = Boolean.TRUE;
        r17.j = new g1(this);
        r17.c = true;
        r17.d = true;
        r17.g = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        r17.i = new i1(this);
        r17.h = new h1(this, r61);
        kc8.v0 r0 = r17.a();
        int r19 = kc8.b.y;
        kc8.b.a r20 = new kc8.b.a();
        r20.a = r0;
        r20.b = r15;
        r7.b(kc8.b.class, r20.a());
    L36:
        final boolean r21 = r8;
        final ?? r110 = new a1(r21, r2, r62, this, r9);
        final Ref.BooleanRef r22 = new Ref.BooleanRef();
        if (AppHost.a.isTestChannel() == false) goto L39;
        long r23 = 50;
    L40:
        com.larus.voicecall.impl.utils.t.a("SubtitleBlockHolder_render", r23, new b1(r22, r110));
        if (r8 == false) goto L46;
        if (r22.element == true) goto L46;
        r110.invoke();
    L46:
        if (c78.a.g.getBoolean("key_realtime_subtitle_holder_debug_flag", false) == false) goto L48;
        com.larus.utils.e1.x(this.a.c);
    L49:
        hk9.a r24 = U3();
        if (r24 == null) goto L58;
        ra8.a.d(r24, r9, r12, false);
        return;
    L58:
        return;
    L48:
        com.larus.utils.e1.o(this.a.c);
        goto L49
    L39:
        r23 = 300;
    L21:
        r8 = true;
        goto L22
    L13:
        r3 = false;
        goto L15
    }

    public SubtitleBlockHolder(LarusItemRecyclerSubtitleBlockBinding r2, f r3, u1 r4, g r5) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "paramProvider");
        Intrinsics.checkNotNullParameter(r4, "selectCallBack");
        Intrinsics.checkNotNullParameter(r5, "actionProvider");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = new Handler(Looper.getMainLooper());
        this.h = LazyKt.lazy(new c1());
    }
}
