package com.larus.bmhome.view.title;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.larus.bmhome.chat.ChatDoubleTabFragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.n;
import com.larus.bmhome.chat.o;
import com.larus.home.impl.sdk.k1;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.kmp.chat.TemplateInfo;
import com.larus.platform.model.RecommendFrom;
import com.larus.uaigc.bean.chat.template.TemplateViewModel;
import com.larus.uaigc.service.ICreationInstructionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import te8.b;
import wt8.a0;
import wt8.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Bê\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012M\u0010\u001b\u001aI\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$\u0018\u00010\u001c\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&¢\u0006\u0004\b'\u0010(J\b\u0010A\u001a\u00020!H\u0016J\u000e\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020!J\u0006\u0010D\u001a\u00020$J\u0010\u0010E\u001a\u00020@2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010F\u001a\u00020@2\u0006\u0010G\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b8\u00109RX\u0010\u001b\u001aI\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/bmhome/view/title/ChatTitleTwoTabAdapt;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "doubleTabFragment", "Lcom/larus/bmhome/chat/ChatDoubleTabFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "cvsId", "", "botId", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatDoubleTabBinding;", "onAddBotChangedListener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "previousPageName", "enterMethod", "adapterArguments", "Landroid/os/Bundle;", "templateVM", "Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "titleView", "Landroid/view/View;", "showTmplInputBox", "", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templatePrompt", "", "position", "enterFrom", "", "musicTemplateChoose", "Lkotlin/Function0;", "<init>", "(Lcom/larus/bmhome/chat/ChatDoubleTabFragment;Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/RecommendFrom;Lcom/larus/bmhome/databinding/LarusPageChatDoubleTabBinding;Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;Landroid/view/View;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "getCvsId", "()Ljava/lang/String;", "getBotId", "getBinding", "()Lcom/larus/bmhome/databinding/LarusPageChatDoubleTabBinding;", "getOnAddBotChangedListener", "()Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "getPreviousPageName", "getEnterMethod", "getAdapterArguments", "()Landroid/os/Bundle;", "getTemplateVM", "()Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "getTitleView", "()Landroid/view/View;", "getShowTmplInputBox", "()Z", "getImageTemplateChoose", "()Lkotlin/jvm/functions/Function3;", "getMusicTemplateChoose", "()Lkotlin/jvm/functions/Function0;", "fragments", "Landroid/util/SparseArray;", "Landroidx/fragment/app/Fragment;", "getItemCount", "getFragment", "index", "scrollTemplateListToTop", "createFragment", "getTemplateCreationFragment", "bundle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTitleTwoTabAdapt extends FragmentStateAdapter {
    public final ChatDoubleTabFragment a;
    public final String b;
    public final String c;
    public final RecommendFrom d;
    public final b e;
    public final String f;
    public final String g;
    public final Bundle h;
    public final TemplateViewModel i;
    public final View j;
    public final boolean k;
    public final Function3<TemplateInfo.TemplateInfo, Integer, String, Unit> l;
    public final Function0<Unit> m;
    public final SparseArray<Fragment> n;

    public final int getItemCount() {
        return 2;
    }

    /* JADX WARN: Type inference failed for: r5v15, types: [wt8.z] */
    public final Fragment createFragment(int r20) {
        Bundle r2 = new Bundle();
        r2.putAll(this.h);
        int r6 = 0;
        Boolean r5 = Boolean.FALSE;
        Boolean r9 = Boolean.TRUE;
        r2.putAll(BundleKt.bundleOf(new Pair[]{TuplesKt.to("out_keyboard", Boolean.valueOf(this.k)), TuplesKt.to("argConversationId", this.b), TuplesKt.to("argBotRecommendFrom", this.d), TuplesKt.to("is_create_sub_conversation", r5), TuplesKt.to("show_two_tab", r9), TuplesKt.to("enter_method", this.g), TuplesKt.to("argPreviousPage", this.f), TuplesKt.to("argBotId", this.c), TuplesKt.to("arg_chat_type", "other_default")}));
        if (r20 != 0) goto L5;
        ChatFragment r3 = new ChatFragment();
        r3.xC(this.e);
        ChatDoubleTabFragment r4 = this.a;
        Intrinsics.checkNotNullParameter(r4, "fragment");
        r3.M = r4;
    L34:
        this.n.put(r20, r3);
        r3.setArguments(r2);
        return r3;
    L5:
        r2.putBoolean("adapt_nav_bar_padding", !this.k);
        Bundle r7 = this.h;
        ChatFragment r13 = null;
        if (r7 == null) goto L8;
        Serializable r8 = r7.getSerializable("conversation_page");
    L10:
        if ((r8 instanceof ConversationPage) == false) goto L12;
        ConversationPage r10 = (ConversationPage) r8;
    L13:
        if (r10 == null) goto L17;
        List r11 = r10.getPageList();
        if (r11 == null) goto L17;
        Integer r12 = (Integer) CollectionsKt.getOrNull(r11, 1);
    L18:
        int r14 = PageType.MUSIC_TEMPLATE.getType();
        if (r12 != null) goto L22;
    L24:
        IFlowSdkDepend r15 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r15 == null) goto L27;
        r15.w();
        r13 = k1.a.m(new a0(this), null);
    L27:
        Pair[] r16 = new Pair[9];
        r16[0] = TuplesKt.to("argBotId", this.c);
        r16[1] = TuplesKt.to("key_is_multi_tab", r5);
        r16[2] = TuplesKt.to("key_creation_recommend_type", 2);
        View r17 = this.j;
        if (r17 == null) goto L30;
        r6 = r17.getMeasuredHeight();
    L30:
        r16[3] = TuplesKt.to("key_template_list_top_padding", Integer.valueOf(r6));
        r16[4] = TuplesKt.to("recommend_from", "bot_template_list");
        r16[5] = TuplesKt.to("arg_chat_type", "other_default");
        r16[6] = TuplesKt.to("action_bar_template_id", 4);
        r16[7] = TuplesKt.to("ai_creation_recommend_from", "chat_action_bar");
        r16[8] = TuplesKt.to("key_is_chat_double_page", r9);
        r2.putAll(BundleKt.bundleOf(r16));
        if (r13 != null) goto L33;
        r3 = new Fragment();
        goto L34
    L33:
        r3 = r13;
        goto L34
    L22:
        if (r12.intValue() != r14) goto L24;
        r3 = ICreationInstructionService.a.A(this.i, new z(this));
    L17:
        r12 = null;
        goto L18
    L12:
        r10 = null;
        goto L13
    L8:
        r8 = null;
        goto L10
    }

    public ChatTitleTwoTabAdapt(ChatDoubleTabFragment r10, FragmentManager r11, Lifecycle r12, String r13, String r14, RecommendFrom r15, b r16, String r17, String r18, Bundle r19, TemplateViewModel r20, View r21, boolean r22, n r23, o r24) {
        Intrinsics.checkNotNullParameter(r10, "doubleTabFragment");
        Intrinsics.checkNotNullParameter(r11, "fragmentManager");
        Intrinsics.checkNotNullParameter(r12, "lifecycle");
        Intrinsics.checkNotNullParameter(r13, "cvsId");
        Intrinsics.checkNotNullParameter(r17, "previousPageName");
        Intrinsics.checkNotNullParameter(r18, "enterMethod");
        Intrinsics.checkNotNullParameter(r24, "musicTemplateChoose");
        super(r11, r12);
        this.a = r10;
        this.b = r13;
        this.c = r14;
        this.d = r15;
        this.e = r16;
        this.f = r17;
        this.g = r18;
        this.h = r19;
        this.i = r20;
        this.j = r21;
        this.k = r22;
        this.l = r23;
        this.m = r24;
        this.n = new SparseArray();
    }
}
