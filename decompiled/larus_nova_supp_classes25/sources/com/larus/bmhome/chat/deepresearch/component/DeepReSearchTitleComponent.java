package com.larus.bmhome.chat.deepresearch.component;

import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog;
import com.larus.bmhome.chat.component.share.v0;
import com.larus.bmhome.chat.deepresearch.DeepReSearchParam;
import com.larus.bmhome.chat.deepresearch.network.PreloadDeepResearchShareHelper;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020*H\u0016J\b\u00100\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020*H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/component/DeepReSearchTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchTitleAbility;", "<init>", "()V", "TAG", "", "deepResearchFragmentAbility", "Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchFragmentAbility;", "getDeepResearchFragmentAbility", "()Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchFragmentAbility;", "deepResearchFragmentAbility$delegate", "Lkotlin/Lazy;", "deepResearchContentAbility", "Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchContentAbility;", "getDeepResearchContentAbility", "()Lcom/larus/bmhome/chat/deepresearch/component/IDeepReSearchContentAbility;", "deepResearchContentAbility$delegate", "deepResearchParam", "Lcom/larus/bmhome/chat/deepresearch/DeepReSearchParam;", "getDeepResearchParam", "()Lcom/larus/bmhome/chat/deepresearch/DeepReSearchParam;", "deepResearchParam$delegate", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageDeepResearchBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusPageDeepResearchBinding;", "binding$delegate", "preloadHelper", "Lcom/larus/bmhome/chat/deepresearch/network/PreloadDeepResearchShareHelper;", "getPreloadHelper", "()Lcom/larus/bmhome/chat/deepresearch/network/PreloadDeepResearchShareHelper;", "preloadHelper$delegate", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "shareDialog", "Landroidx/fragment/app/DialogFragment;", "onViewCreated", "", "view", "Landroid/view/View;", "onAttach", "performShare", "performCopy", "getContentTitle", "performExport", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepReSearchTitleComponent extends BaseContentWidget implements l0 {
    public static final /* synthetic */ int u = 0;
    public final String m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public DialogFragment t;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(h0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    @Override // com.larus.bmhome.chat.deepresearch.component.l0
    public final void Cc() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DeepReSearchTitleComponent$performCopy$1(this, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.deepresearch.component.l0
    public final void G6() {
        if (h3().a == null) goto L5;
        boolean r1 = true;
    L6:
        String r4 = null;
        if (r1 == true) goto L17;
        PreloadDeepResearchShareHelper r2 = h3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        DeepReSearchParam r7 = Y2();
        if (r7 == null) goto L11;
        String r8 = r7.l;
    L12:
        DeepReSearchParam r9 = Y2();
        if (r9 == null) goto L15;
        String r10 = r9.a;
    L16:
        r2.a(r5, new com.larus.bmhome.chat.deepresearch.network.b(r8, r10));
        goto L17
    L15:
        r10 = null;
        goto L16
    L11:
        r8 = null;
    L17:
        ShareServiceDelegate r3 = ShareServiceDelegate.b;
        this.t = IShareService.a.g(r3, s1a.a.getActivity(this), ShareScene.UNKNOWN, new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108863), null, new DeepReSearchTitleComponent$performShare$1(this), null, false, 232);
        DeepReSearchParam r6 = Y2();
        if (r6 == null) goto L22;
        BotModel r11 = r6.g;
        if (r11 == null) goto L22;
        String r13 = r11.getBotId();
    L23:
        DeepReSearchParam r12 = Y2();
        if (r12 == null) goto L27;
        String r14 = r12.b;
        if (r14 == null) goto L27;
    L28:
        String r15 = r14;
        if (z2.a.longPressShowMultiSelect() == false) goto L31;
        String r16 = "multiple_choose";
    L32:
        String r17 = r16;
        DeepReSearchParam r18 = Y2();
        if (r18 == null) goto L35;
        r4 = r18.l;
    L35:
        Intrinsics.checkNotNullParameter(this, "<this>");
        by7.e r19 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
        IShareService.a.e(r3, false, "default", "header", r13, r15, r17, 0, r4, r19, null, 2048);
        return;
    L31:
        r16 = "share";
    L27:
        r14 = "";
    L22:
        r13 = null;
        goto L23
    L5:
        r1 = false;
        goto L6
    }

    public final DeepReSearchParam Y2() {
        return (DeepReSearchParam) this.p.getValue();
    }

    public final PreloadDeepResearchShareHelper h3() {
        return (PreloadDeepResearchShareHelper) this.r.getValue();
    }

    /* JADX WARN: Type inference failed for: r10v9, types: [com.larus.bmhome.chat.deepresearch.component.i0] */
    @Override // com.larus.bmhome.chat.deepresearch.component.l0
    public final void nu() {
        if (h3().a == null) goto L5;
        boolean r1 = true;
    L6:
        String r2 = null;
        if (r1 == true) goto L17;
        PreloadDeepResearchShareHelper r3 = h3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleCoroutineScope r4 = LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        DeepReSearchParam r6 = Y2();
        if (r6 == null) goto L11;
        String r7 = r6.l;
    L12:
        DeepReSearchParam r8 = Y2();
        if (r8 == null) goto L15;
        String r9 = r8.a;
    L16:
        r3.a(r4, new com.larus.bmhome.chat.deepresearch.network.b(r7, r9));
        goto L17
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = null;
    L17:
        FLogger r5 = FLogger.a;
        String r10 = this.m;
        StringBuilder r11 = new StringBuilder("export message, deep_research_id = ");
        DeepReSearchParam r12 = Y2();
        if (r12 == null) goto L20;
        String r13 = r12.a;
    L21:
        r11.append(r13);
        r5.d(r10, r11.toString());
        DeepReSearchParam r14 = Y2();
        if (r14 == null) goto L27;
        String r15 = r14.c;
        if (r15 == null) goto L27;
        String r16 = r15;
    L28:
        String r17 = UUID.randomUUID().toString();
        int r18 = FileExportTypeChooseDialog.w;
        DeepReSearchParam r19 = Y2();
        if (r19 == null) goto L31;
        String r20 = r19.b;
    L32:
        DeepReSearchParam r21 = Y2();
        if (r21 == null) goto L37;
        Message r22 = r21.f;
        if (r22 == null) goto L37;
        Integer r23 = Integer.valueOf(r22.getContentType());
    L38:
        List r24 = CollectionsKt.listOf(new v0(r20, r23));
        DeepReSearchParam r25 = Y2();
        if (r25 == null) goto L43;
        BotModel r26 = r25.g;
        if (r26 == null) goto L43;
        String r27 = r26.getName();
    L44:
        if (r27 != null) goto L46;
        String r28 = "";
    L47:
        DeepReSearchParam r29 = Y2();
        if (r29 == null) goto L52;
        BotModel r30 = r29.g;
        if (r30 == null) goto L52;
        String r31 = r30.getBotId();
    L53:
        if (r31 != null) goto L55;
        String r32 = "";
    L56:
        DeepReSearchParam r33 = Y2();
        if (r33 == null) goto L61;
        Long r34 = r33.h;
        if (r34 == null) goto L61;
        long r110 = r34.longValue();
    L62:
        j0 r35 = (j0) this.o.getValue();
        if (r35 == null) goto L66;
        List<Block> r36 = r35.HK();
        if (r36 == null) goto L66;
    L67:
        k0 r111 = (k0) this.n.getValue();
        if (r111 == null) goto L73;
        String r112 = r111.k();
        if (r112 == null) goto L73;
        String r113 = r112;
    L74:
        DeepReSearchParam r114 = Y2();
        if (r114 == null) goto L77;
        String r115 = r114.l;
    L78:
        if (r115 != null) goto L80;
        String r116 = "";
    L81:
        DeepReSearchParam r117 = Y2();
        if (r117 == null) goto L84;
        String r118 = r117.a;
    L85:
        if (r118 != null) goto L87;
        String r119 = "";
    L88:
        FileExportTypeChooseDialog r37 = FileExportTypeChooseDialog.a.b(r16, r24, r36, r28, r32, r17, r110, r113, r116, r119, new i0(this), false, null, null, 14336);
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r38 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();
        Intrinsics.checkNotNull(r38);
        FileExportTypeChooseDialog.a.c(r37, r38);
        LruCache r39 = ko8.a.a;
        k0 r40 = (k0) this.n.getValue();
        if (r40 == null) goto L94;
        String r41 = r40.k();
        if (r41 == null) goto L94;
        String r42 = r41;
    L95:
        DeepReSearchParam r43 = Y2();
        if (r43 == null) goto L98;
        r2 = r43.b;
    L98:
        if (r2 != null) goto L100;
        String r44 = "";
    L101:
        DeepReSearchParam r45 = Y2();
        if (r45 == null) goto L106;
        Long r46 = r45.h;
        if (r46 == null) goto L106;
        long r120 = r46.longValue();
    L107:
        Intrinsics.checkNotNullParameter(r42, "clickFrom");
        Intrinsics.checkNotNullParameter(r44, "messageId");
        Intrinsics.checkNotNullParameter(r17, "exportActionId");
        IAIChatControlTraceService.a.La(r42, r44, r17, r120);
        return;
    L106:
        r120 = 0;
        goto L107
    L100:
        r44 = r2;
    L94:
        r42 = "";
        goto L95
    L87:
        r119 = r118;
        goto L88
    L84:
        r118 = null;
        goto L85
    L80:
        r116 = r115;
        goto L81
    L77:
        r115 = null;
    L73:
        r113 = "";
    L66:
        r36 = CollectionsKt.emptyList();
    L61:
        r110 = 0;
        goto L62
    L55:
        r32 = r31;
    L52:
        r31 = null;
        goto L53
    L46:
        r28 = r27;
    L43:
        r27 = null;
    L37:
        r23 = null;
        goto L38
    L31:
        r20 = null;
    L27:
        r16 = "";
        goto L28
    L20:
        r13 = null;
        goto L21
    L5:
        r1 = false;
        goto L6
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, l0.class);
    }

    public DeepReSearchTitleComponent() {
        this.m = "DeepReSearchTitle";
        this.n = LazyKt.lazy(new b0(this));
        this.o = LazyKt.lazy(new c0(this));
        this.p = LazyKt.lazy(new d0(this));
        this.q = LazyKt.lazy(new e0(this));
        this.r = LazyKt.lazy(new f0());
        this.s = LazyKt.lazy(new g0(this));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.deepresearch.component.h0] */
    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        j0 r5 = (j0) this.o.getValue();
        if (r5 == null) goto L8;
        MutableLiveData r6 = r5.ow();
        if (r6 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r6.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new a(new h0(this)));
        return;
    L9:
        return;
    }
}
