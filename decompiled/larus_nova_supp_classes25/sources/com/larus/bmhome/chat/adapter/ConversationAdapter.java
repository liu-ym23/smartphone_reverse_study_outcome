package com.larus.bmhome.chat.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.ConversationListItem;
import com.larus.bmhome.chat.layout.widget.CvsItemRightAction;
import com.larus.bmhome.chat.model.i1;
import com.larus.bmhome.chat.trace.appreciable.ConversationPageTrace;
import com.larus.bmhome.databinding.LarusItemConversationBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.home.impl.sdk.h1;
import com.larus.home.impl.sdk.o2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.showcase.Case;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.utils.y0;
import com.larus.voicecall.api.IVoiceCallService;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o1;
import v19.c6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002(K\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003STUB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\"\u001a\u00020\u00142+\u0010#\u001a'\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000eJ\"\u0010$\u001a\u00020\u00142\u001a\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140\u000eJ(\u0010%\u001a\u00020\u00142 \u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u0018J \u0010&\u001a\u00020\u00142\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u000eJ\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001aH\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u0010H\u0002J\u0018\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001aH\u0016J\u0010\u00103\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001aH\u0016J&\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001a2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0016J\u0018\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010;\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010<\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010=\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u000f2\b\b\u0002\u0010>\u001a\u00020?J\u0018\u0010@\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010A\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0002J\u000e\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0010J\u0016\u0010D\u001a\u00020\u00142\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010FJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u0010H\u0002J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000f0FJ\u000e\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u001aJ\u0010\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020\u00142\u0006\u0010P\u001a\u00020QH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR5\u0010\r\u001a)\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010I\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0004\n\u0002\u0010L¨\u0006V"}, d2 = {"Lcom/larus/bmhome/chat/adapter/ConversationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", "config", "Lcom/larus/common_ui/paging/FPagingAdapter$Config;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/larus/common_ui/paging/FPagingAdapter$Config;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getConfig", "()Lcom/larus/common_ui/paging/FPagingAdapter$Config;", "selectListener", "Lkotlin/Function2;", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "", "Lkotlin/ParameterName;", "name", "clickEnterFrom", "", "longClickListener", "Landroid/view/View;", "longClickCaseListener", "Lkotlin/Function3;", "Lcom/larus/platform/model/showcase/Case;", "", "clickCaseListener", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "getMDiffer", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer$delegate", "Lkotlin/Lazy;", "setOnSelectListener", "listener", "setOnLongClickListener", "setLongClickCaseListener", "setClickCaseListener", "onClickListener", "com/larus/bmhome/chat/adapter/ConversationAdapter$onClickListener$1", "Lcom/larus/bmhome/chat/adapter/ConversationAdapter$onClickListener$1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "botTag", "onBindViewHolder", "holder", "position", "getItemViewType", "payloads", "", "", "onUpdateAvatar", "item", "view", "Lcom/larus/bmhome/chat/layout/ConversationListItem;", "onUpdateName", "onUpdateBrief", "getUnreadCount", "isFromOuter", "", "onUpdateRightAction", "onUpdateAvatarTag", "notifyItemChanged", "conversationId", "submitData", "dataList", "", "toMessageTextContent", "getCurrentList", "lastItemCount", "scrollListener", "com/larus/bmhome/chat/adapter/ConversationAdapter$scrollListener$1", "Lcom/larus/bmhome/chat/adapter/ConversationAdapter$scrollListener$1;", "updateLoadMoreStatus", "status", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "Companion", "ItemHolder", "ViewType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Lazy<Boolean> k = null;
    public static final ConversationAdapter$Companion$diff$1 l = null;
    public final Fragment a;
    public final FPagingAdapter.a b;
    public Function2<? super wh8.a, ? super String, Unit> c;
    public Function2<? super View, ? super wh8.a, Unit> d;
    public Function3<? super View, ? super Case, ? super Integer, Unit> e;
    public Function2<? super Case, ? super Integer, Unit> f;
    public final Lazy g;
    public final b h;
    public int i;
    public final ConversationAdapter$scrollListener$1 j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/adapter/ConversationAdapter$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/larus/bmhome/chat/layout/ConversationListItem;", "<init>", "(Lcom/larus/bmhome/chat/layout/ConversationListItem;)V", "getView", "()Lcom/larus/bmhome/chat/layout/ConversationListItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class ItemHolder extends RecyclerView.ViewHolder {
        public final ConversationListItem a;

        /* JADX WARN: Multi-variable type inference failed */
        public ItemHolder(ConversationListItem r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/adapter/ConversationAdapter$ViewType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "CONVERSATION", "CASE", "DIVIDER", "LOADING_FOOTER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum ViewType extends Enum<ViewType> {
        public static final ViewType CASE = null;
        public static final ViewType CONVERSATION = null;
        public static final ViewType DIVIDER = null;
        public static final ViewType LOADING_FOOTER = null;
        public static final /* synthetic */ ViewType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int type;

        public static EnumEntries<ViewType> getEntries() {
            return b;
        }

        static {
            ViewType r0 = new ViewType("CONVERSATION", 0, 0);
            CONVERSATION = r0;
            ViewType r1 = new ViewType("CASE", 1, 1);
            CASE = r1;
            ViewType r3 = new ViewType("DIVIDER", 2, 2);
            DIVIDER = r3;
            ViewType r5 = new ViewType("LOADING_FOOTER", 3, 4);
            LOADING_FOOTER = r5;
            ViewType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static ViewType[] values() {
            return (ViewType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static ViewType valueOf(String r1) {
            return (ViewType) r27.a.a(ViewType.class, r1);
        }

        public ViewType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static final class a {
        public a() {
        }

        public static final boolean a(BotModel r3, BotModel r4) {
            Lazy<Boolean> r0 = ConversationAdapter.k;
            if (r4 == null) goto L13;
            if (r3 == null) goto L11;
            boolean r1 = Intrinsics.areEqual(r3.getBotId(), r4.getBotId());
            boolean r5 = !uc9.b0.a(r3.getTagList(), r4.getTagList());
            if (r1 == false) goto L11;
            if (r5 == false) goto L11;
            return true;
        L11:
            return false;
        L13:
            return true;
        }

        public static final boolean b(BotModel r2, BotModel r3) {
            Lazy<Boolean> r0 = ConversationAdapter.k;
            if (r3 == null) goto L10;
            if (r2 == null) goto L11;
            boolean r1 = Intrinsics.areEqual(r2.getBotStatus(), r3.getBotStatus());
            boolean r4 = Intrinsics.areEqual(r2.getBotRecommendStatus(), r3.getBotRecommendStatus());
            if (r1 == false) goto L11;
            if (r4 == true) goto L10;
        L11:
            return false;
        L10:
            return true;
        }

        public static final boolean c(wh8.a r3, wh8.a r4) {
            Lazy<Boolean> r0 = ConversationAdapter.k;
            wc9.e r1 = r3.a;
            BotOnBoarding r2 = null;
            if (r1 == null) goto L5;
            String r5 = r1.n;
        L6:
            wc9.e r6 = r4.a;
            if (r6 == null) goto L9;
            String r7 = r6.n;
        L11:
            if (Intrinsics.areEqual(r5, r7) == false) goto L46;
            wc9.e r8 = r3.a;
            if (r8 == null) goto L15;
            Integer r9 = r8.t;
        L16:
            wc9.e r10 = r4.a;
            if (r10 == null) goto L19;
            Integer r11 = r10.t;
        L21:
            if (Intrinsics.areEqual(r9, r11) == false) goto L46;
            if (Intrinsics.areEqual(r3.d, r4.d) == false) goto L46;
            BotModel r12 = r3.b;
            if (r12 == null) goto L27;
            Integer r13 = r12.getBotType();
        L28:
            BotModel r14 = r4.b;
            if (r14 == null) goto L31;
            Integer r15 = r14.getBotType();
        L33:
            if (Intrinsics.areEqual(r13, r15) == false) goto L46;
            BotModel r16 = r3.b;
            if (r16 == null) goto L37;
            BotOnBoarding r17 = r16.getOnBoarding();
        L38:
            BotModel r18 = r4.b;
            if (r18 == null) goto L42;
            r2 = r18.getOnBoarding();
        L42:
            if (Intrinsics.areEqual(r17, r2) == false) goto L46;
            if (Intrinsics.areEqual(r3.c, r4.c) == false) goto L46;
            return true;
        L37:
            r17 = null;
            goto L38
        L31:
            r15 = null;
            goto L33
        L27:
            r13 = null;
            goto L28
        L19:
            r11 = null;
            goto L21
        L15:
            r9 = null;
        L46:
            return false;
        L9:
            r7 = null;
            goto L11
        L5:
            r5 = null;
            goto L6
        }

        public static final boolean d(IconImage r4, IconImage r5) {
            Lazy<Boolean> r0 = ConversationAdapter.k;
            if (r4 != null) goto L6;
            if (r5 != null) goto L6;
        L35:
            return true;
        L6:
            if (r4 == null) goto L56;
            if (r5 == null) goto L56;
            ImageObj r1 = r4.imageThumb;
            String r2 = null;
            if (r1 == null) goto L12;
            String r3 = r1.url;
        L13:
            ImageObj r6 = r5.imageThumb;
            if (r6 == null) goto L16;
            String r7 = r6.url;
        L18:
            if (com.larus.utils.o0.d(r7) == false) goto L20;
        L46:
            if (r7 == null) goto L50;
            Uri r8 = y0.j(r7);
            if (r8 == null) goto L50;
            String r9 = r8.getPath();
        L51:
            if (r3 == null) goto L60;
            Uri r10 = y0.j(r3);
            if (r10 == null) goto L60;
            r2 = r10.getPath();
        L60:
            return Intrinsics.areEqual(r9, r2);
        L50:
            r9 = null;
            goto L51
        L20:
            if (com.larus.utils.o0.d(r3) == true) goto L46;
            ImageObj r11 = r5.imageOri;
            if (r11 == null) goto L25;
            String r12 = r11.url;
        L26:
            ImageObj r13 = r4.imageOri;
            if (r13 == null) goto L29;
            String r14 = r13.url;
        L31:
            if (com.larus.utils.o0.d(r12) == false) goto L33;
        L36:
            if (r12 == null) goto L40;
            Uri r15 = y0.j(r12);
            if (r15 == null) goto L40;
            String r16 = r15.getPath();
        L41:
            if (r14 == null) goto L59;
            Uri r17 = y0.j(r14);
            if (r17 == null) goto L59;
            r2 = r17.getPath();
        L59:
            return Intrinsics.areEqual(r16, r2);
        L40:
            r16 = null;
            goto L41
        L33:
            if (com.larus.utils.o0.d(r14) == false) goto L35;
        L29:
            r14 = null;
            goto L31
        L25:
            r12 = null;
            goto L26
        L16:
            r7 = null;
            goto L18
        L12:
            r3 = null;
        L56:
            return false;
        }

        public static final boolean e(wc9.e r3, wc9.e r4) {
            Lazy<Boolean> r0 = ConversationAdapter.k;
            Integer r1 = null;
            if (r3 == null) goto L5;
            Integer r2 = r3.m;
        L6:
            if (r4 == null) goto L8;
            Integer r5 = r4.m;
        L10:
            if (Intrinsics.areEqual(r2, r5) == false) goto L19;
            if (r3 == null) goto L13;
            Integer r6 = r3.l;
        L14:
            if (r4 == null) goto L17;
            r1 = r4.l;
        L17:
            if (Intrinsics.areEqual(r6, r1) == false) goto L19;
            return true;
        L13:
            r6 = null;
        L19:
            return false;
        L8:
            r5 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b extends c6 {
        public final /* synthetic */ ConversationAdapter c;

        public b(ConversationAdapter r1) {
            this.c = r1;
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            Object r4 = r3.getTag();
            if ((r4 instanceof wh8.a) == false) goto L5;
            wh8.a r5 = (wh8.a) r4;
        L6:
            if (r5 == null) goto L11;
            Function2<? super wh8.a, ? super String, Unit> r0 = this.c.c;
            if (r0 == null) goto L12;
            r0.invoke(r5, "");
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.bmhome.chat.adapter.ConversationAdapter$Companion$diff$1] */
    static {
        new a();
        k = LazyKt.lazy(new f());
        l = new ConversationAdapter$Companion$diff$1();
    }

    public final AsyncListDiffer<wh8.a> y2() {
        return (AsyncListDiffer) this.g.getValue();
    }

    public final List<wh8.a> getCurrentList() {
        AsyncListDiffer<wh8.a> r0 = y2();
        if (r0 == null) goto L7;
        List<wh8.a> r1 = r0.getCurrentList();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final int getItemCount() {
        AsyncListDiffer<wh8.a> r0 = y2();
        if (r0 == null) goto L7;
        List r1 = r0.getCurrentList();
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    public final void E2(final List<wh8.a> r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("submitDataInner: ");
        if (r6 == null) goto L10;
        List r2 = CollectionsKt.take(r6, 10);
        if (r2 == null) goto L10;
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        r4.add(((wh8.a) r5.next()).d());
    L11:
        r1.append(r4);
        r0.d("ConversationAdapter", r1.toString());
        t0.e(new e(this, r6));
        return;
    L10:
        r4 = null;
        goto L11
    }

    public final int getItemViewType(int r2) {
        wh8.a r3 = (wh8.a) ListProtector.get(getCurrentList(), r2);
        if (r3.l == false) goto L7;
        return ViewType.LOADING_FOOTER.getType();
    L7:
        if (r3.k != null) goto L13;
        if (r3.a != null) goto L13;
        return ViewType.DIVIDER.getType();
    L13:
        if (r3.a == null) goto L17;
        return ViewType.CONVERSATION.getType();
    L17:
        return ViewType.CASE.getType();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        r2.addOnScrollListener(this.j);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
        r2.removeOnScrollListener(this.j);
    }

    public final void z2(String r6) {
        Intrinsics.checkNotNullParameter(r6, "conversationId");
        AsyncListDiffer<wh8.a> r0 = y2();
        Integer r2 = null;
        if (r0 == null) goto L19;
        List r1 = r0.getCurrentList();
        if (r1 == null) goto L19;
        Iterator r3 = r1.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L17;
        wc9.e r5 = ((wh8.a) r3.next()).a;
        if (r5 == null) goto L12;
        String r7 = r5.a;
    L14:
        if (Intrinsics.areEqual(r7, r6) == true) goto L18;
        r4 = r4 + 1;
    L18:
        r2 = Integer.valueOf(r4);
        goto L19
    L12:
        r7 = null;
        goto L14
    L17:
        r4 = -1;
    L19:
        if (r2 != null) goto L21;
        return;
    L21:
        if (RangesKt.until(0, getItemCount()).contains(r2.intValue()) == false) goto L27;
        notifyItemChanged(r2.intValue());
        return;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.bmhome.chat.adapter.ConversationAdapter$scrollListener$1] */
    public ConversationAdapter(Fragment r2, FPagingAdapter.a r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r2;
        this.b = r3;
        this.g = LazyKt.lazy(new g(this));
        this.h = new b(this);
        this.j = new ConversationAdapter$scrollListener$1(this);
    }

    public static void A2(wh8.a r9, ConversationListItem r10) {
        wc9.e r0 = r9.a;
        if (r0 == null) goto L10;
        Integer r1 = r0.j;
        if (r1 == null) goto L10;
        if (r1.intValue() != 2) goto L10;
        boolean r2 = true;
    L11:
        wc9.e r3 = r9.a;
        LarusItemConversationBinding r4 = null;
        if (r3 == null) goto L18;
        IconImage r5 = r3.b;
        if (r5 == null) goto L18;
        ImageObj r6 = r5.imageThumb;
        if (r6 == null) goto L18;
        String r7 = r6.url;
    L20:
        if (com.larus.utils.o0.d(r7) == false) goto L28;
        wc9.e r8 = r9.a;
        if (r8 == null) goto L35;
        IconImage r11 = r8.b;
        if (r11 == null) goto L35;
        ImageObj r12 = r11.imageThumb;
        if (r12 == null) goto L35;
        String r13 = r12.url;
    L37:
        if (ic8.n.m(r9.a) == false) goto L56;
        IconImage r14 = r9.i;
        if (r14 == null) goto L43;
        ImageObj r15 = r14.imageThumb;
        if (r15 == null) goto L43;
        String r16 = r15.url;
    L45:
        if (com.larus.utils.o0.d(r16) == false) goto L51;
        IconImage r17 = r9.i;
        if (r17 == null) goto L56;
        ImageObj r18 = r17.imageThumb;
        if (r18 == null) goto L56;
        String r19 = r18.url;
    L58:
        if (ic8.n.n(r9.a) == false) goto L61;
        r10.T5(2131242081);
        return;
    L61:
        if (ic8.n.t(r9.a) == false) goto L64;
        r10.T5(2131242089);
        return;
    L64:
        if (com.larus.utils.o0.d(r19) == false) goto L93;
        LarusItemConversationBinding r20 = r10.a;
        if (r20 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L68:
        e1.x(r20.e);
        LarusItemConversationBinding r21 = r10.a;
        if (r21 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L71:
        e1.o(r21.b);
        LarusItemConversationBinding r22 = r10.a;
        if (r22 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L74:
        r22.c.getHierarchy().setFailureImage(2131240119);
        if (Intrinsics.areEqual("covn_list.avatar", "covn_list.avatar") == false) goto L77;
        com.larus.image.loader.g r23 = com.larus.image.loader.b0.e("covn_list.avatar");
    L78:
        LarusItemConversationBinding r24 = r10.a;
        if (r24 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L81:
        ImageLoaderKt.v(r24.c, r19, "covn_list.avatar", r23, new com.larus.bmhome.chat.layout.j());
        LarusItemConversationBinding r25 = r10.a;
        if (r25 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L84:
        r25.d.getHierarchy().setFailureImage(2131240119);
        LarusItemConversationBinding r26 = r10.a;
        if (r26 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L87:
        ImageLoaderKt.v(r26.d, r13, "covn_list.avatar", r23, new com.larus.bmhome.chat.layout.k());
        LarusItemConversationBinding r27 = r10.a;
        if (r27 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L91:
        r4.f.a(false);
        return;
    L90:
        r4 = r27;
        goto L91
    L77:
        r23 = null;
        goto L78
    L93:
        if (com.larus.utils.o0.d(r13) == false) goto L95;
        r10.S5(r13, "covn_list.avatar", !r2);
        return;
    L95:
        wc9.e r28 = r9.a;
        if (r28 == null) goto L98;
        String r29 = r28.a;
    L99:
        JSONObject r30 = new JSONObject();
        Intrinsics.checkNotNullParameter(r30, "params");
        if (r29 != null) goto L110;
    L105:
        TrackParams r31 = new TrackParams().merge(r30);
        by7.a r32 = new by7.a("dev_chat_list_avatar_url_empty_monitor");
        r32.a.merge(r31);
        r32.b();
        if (ic8.n.w(r9.a) == false) goto L108;
        r10.T5(2131241230);
        return;
    L108:
        r10.S5(y0.k(new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build()), null, !r2);
        return;
    L110:
        r30.put("conversation_id", r29);     // Catch: JSONException -> L103
    L103:
        e = move-exception;
        FLogger.a.e("L0Part1ChatBotEventHelper", "error in L0Part1ChatBotEventHelper inputStateException " + e.getLocalizedMessage());
        goto L105
    L98:
        r29 = null;
        goto L99
    L51:
        IconImage r33 = r9.i;
        if (r33 == null) goto L56;
        ImageObj r34 = r33.imageOri;
        if (r34 == null) goto L56;
        r19 = r34.url;
    L43:
        r16 = null;
    L56:
        r19 = null;
    L35:
        r13 = null;
        goto L37
    L28:
        wc9.e r35 = r9.a;
        if (r35 == null) goto L35;
        IconImage r36 = r35.b;
        if (r36 == null) goto L35;
        ImageObj r37 = r36.imageOri;
        if (r37 == null) goto L35;
        r13 = r37.url;
    L18:
        r7 = null;
    L10:
        r2 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void B2(wh8.a r2, ConversationListItem r3) {
        Set<Integer> r0 = com.larus.bmhome.chat.helper.e0.a;
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "view");
        String r1 = com.larus.bmhome.chat.helper.e0.c(r2);
        if (r1 == null) goto L5;
        r3.setBrief(r1);
        return;
    L5:
        r3.setBrief(com.larus.bmhome.chat.helper.e0.a(r3.getContext(), r2, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C2(wh8.a r14, ConversationListItem r15) {
        boolean r4 = vb8.a.b(r14.b);
        String r0 = "";
        if (r4 == false) goto L5;
        String r1 = r15.getContext().getString(2131910375);
    L6:
        Intrinsics.checkNotNull(r1);
        boolean r3 = true;
        String r6 = null;
        if (ic8.n.u(r14.a) == false) goto L33;
        wc9.e r2 = r14.a;
        if (r2 == null) goto L11;
        String r5 = r2.c;
    L12:
        if (r5 != null) goto L14;
        String r8 = "";
    L16:
        if (com.larus.platform.service.n0.a.b() == false) goto L18;
        String r7 = this.a.getString(2131905541);
    L31:
        String r9 = r7;
    L32:
        ConversationListItem.U5(r15, r8, r9, false, ic8.n.u(r14.a), 12);
        return;
    L18:
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L23;
        o2 r11 = r10.x0();
        if (r11 == null) goto L23;
        r6 = r11.g4();
    L23:
        if (r6 != null) goto L25;
    L28:
        if (r3 == true) goto L30;
        r9 = r6;
        goto L32
    L30:
        r7 = AppHost.a.e();
        goto L31
    L25:
        if (StringsKt.isBlank(r6) == true) goto L28;
        r3 = false;
        goto L28
    L14:
        r8 = r5;
        goto L16
    L11:
        r5 = null;
        goto L12
    L33:
        wc9.e r12 = r14.a;
        if (r12 == null) goto L36;
        String r13 = r12.c;
    L38:
        if (com.larus.utils.o0.d(r13) == false) goto L44;
        wc9.e r16 = r14.a;
        if (r16 == null) goto L42;
        r6 = r16.c;
    L42:
        if (r6 == null) goto L48;
    L49:
        String r17 = r6;
    L51:
        if (r1.length() == 0) goto L54;
        r3 = false;
    L54:
        if (r3 == true) goto L56;
        String r18 = r1;
    L60:
        ConversationListItem.U5(r15, r17, r18, r4, ic8.n.u(r14.a), 4);
        return;
    L56:
        if (i1.b(r14) == false) goto L58;
        r0 = r15.getContext().getString(2131900776);
    L58:
        Intrinsics.checkNotNull(r0);
        r18 = r0;
    L48:
        r17 = "";
        goto L51
    L44:
        BotModel r19 = r14.b;
        if (r19 == null) goto L47;
        r6 = r19.getName();
    L47:
        if (r6 != null) goto L49;
    L36:
        r13 = null;
        goto L38
    L5:
        r1 = "";
        goto L6
    }

    public final void D2(wh8.a r18, ConversationListItem r19) {
        Iterator<wh8.a> r2 = getCurrentList().iterator();
        int r4 = 0;
    L3:
        LarusItemConversationBinding r6 = null;
        if (r2.hasNext() == false) goto L17;
        wc9.e r5 = r2.next().a;
        if (r5 == null) goto L8;
        String r7 = r5.a;
    L9:
        wc9.e r8 = r18.a;
        if (r8 == null) goto L12;
        String r9 = r8.a;
    L14:
        if (Intrinsics.areEqual(r7, r9) == true) goto L18;
        r4 = r4 + 1;
    L18:
        String r15 = String.valueOf(r4 + 1);
        Intrinsics.checkNotNullParameter(r18, "item");
        wc9.e r10 = r18.a;
        if (r10 == null) goto L23;
        Integer r11 = r10.l;
        if (r11 == null) goto L23;
        int r12 = r11.intValue();
    L24:
        wc9.e r13 = r18.a;
        if (r13 == null) goto L29;
        Integer r14 = r13.m;
        if (r14 == null) goto L29;
        int r16 = r14.intValue();
    L31:
        if (ic8.n.r(r18.a) == true) goto L40;
        if (r12 == 0) goto L34;
        if (r12 >= r16) goto L40;
    L34:
        wc9.e r17 = r18.a;
        if (r17 == null) goto L37;
        String r20 = r17.a;
    L38:
        o1.a(r20, Long.valueOf(r12), Long.valueOf(r16));
        goto L40
    L37:
        r20 = null;
    L40:
        if (((Boolean) k.getValue()).booleanValue() == false) goto L42;
    L46:
        int r21 = r12 - r16;
    L47:
        Fragment r110 = this.a;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "item");
        Intrinsics.checkNotNullParameter(r110, "fragment");
        Intrinsics.checkNotNullParameter(r15, "position");
        VoiceCallServiceDelegate r3 = VoiceCallServiceDelegate.a;
        BotModel r22 = r18.b;
        wc9.e r23 = r18.a;
        String r24 = "";
        if (r23 == null) goto L51;
        String r25 = r23.a;
        if (r25 == null) goto L51;
    L52:
        boolean r111 = IVoiceCallService.a.a(r3, r22, r25, false, 12);
        Message r26 = r18.c;
        if (r26 == null) goto L58;
        String r27 = r26.getMessageId();
        if (r27 == null) goto L58;
        r24 = r27;
    L58:
        wc9.e r112 = r18.a;
        BotModel r113 = r18.b;
        LarusItemConversationBinding r28 = r19.a;
        if (r28 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L61:
        CvsItemRightAction.b r0 = new CvsItemRightAction.b(r24, r21, r113, r112, r110, r28.x, r18.f, r15, r111);
        LarusItemConversationBinding r1 = r19.a;
        if (r1 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L65:
        r6.w.setup(r0);
        return;
    L64:
        r6 = r1;
    L51:
        r25 = "";
        goto L52
    L42:
        if (r18.c != null) goto L46;
        if (ic8.n.q(r18.a) == true) goto L46;
        r21 = 0;
    L29:
        r16 = 0;
    L23:
        r12 = 0;
        goto L24
    L12:
        r9 = null;
        goto L14
    L8:
        r7 = null;
        goto L9
    L17:
        r4 = -1;
        goto L18
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.ViewGroup, com.larus.bmhome.chat.layout.ConversationListItem] */
    /* JADX WARN: Type inference failed for: r7v11, types: [android.view.ViewGroup, com.larus.bmhome.chat.layout.ConversationListItem] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (r7 != ViewType.CASE.getType()) goto L21;
        ConstraintLayout r8 = LayoutInflater.from(r6.getContext()).inflate(2131562525, r6, false);
        int r9 = 2131368849;
        if (ViewBindings.findChildViewById(r8, 2131368849) == null) goto L19;
        r9 = 2131369197;
        if (ViewBindings.findChildViewById(r8, 2131369197) == null) goto L19;
        r9 = 2131375138;
        if (ViewBindings.findChildViewById(r8, 2131375138) == null) goto L19;
        r9 = 2131375139;
        if (ViewBindings.findChildViewById(r8, 2131375139) == null) goto L19;
        r9 = 2131388084;
        if (((TextView) ViewBindings.findChildViewById(r8, 2131388084)) == null) goto L19;
        r9 = 2131388772;
        if (ViewBindings.findChildViewById(r8, 2131388772) == null) goto L19;
        return new ItemCaseHolder(r8);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    L21:
        if (r7 != ViewType.CONVERSATION.getType()) goto L25;
        ?? r10 = new ConversationListItem(r6.getContext());
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new ItemHolder(r10);
    L25:
        if (r7 != ViewType.DIVIDER.getType()) goto L29;
        View r11 = LayoutInflater.from(r6.getContext()).inflate(2131562548, r6, false);
        Intrinsics.checkNotNull(r11);
        return new ItemDividerHolder(r11);
    L29:
        if (r7 != ViewType.LOADING_FOOTER.getType()) goto L36;
        View r12 = LayoutInflater.from(r6.getContext()).inflate(2131562527, r6, false);
        if (((ProgressBar) ViewBindings.findChildViewById(r12, 2131379033)) == null) goto L35;
        return new ItemLoadingFooterHolder((FrameLayout) r12);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(2131379033)));
    L36:
        ?? r13 = new ConversationListItem(r6.getContext());
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new ItemHolder(r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v28, types: [android.view.ViewGroup, com.larus.bmhome.chat.layout.ConversationListItem] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.adapter.c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onBindViewHolder(final RecyclerView.ViewHolder r13, final int r14, List<Object> r15) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r15, "payloads");
        AsyncListDiffer<wh8.a> r0 = y2();
        if (r0 == null) goto L187;
        List r1 = r0.getCurrentList();
        if (r1 == null) goto L188;
        final wh8.a r2 = (wh8.a) CollectionsKt.getOrNull(r1, r14);
        if (r2 == null) goto L192;
        ConversationPageTrace.f();
        boolean r3 = true;
        Context r4 = null;
        if ((r13 instanceof ItemHolder) == false) goto L118;
        if (r2.a == null) goto L118;
        ?? r5 = ((ItemHolder) r13).a;
        List r6 = CollectionsKt.distinct(r15);
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L24;
        Object r9 = r8.next();
        if ((r9 instanceof Integer) == false) goto L19;
        Integer r10 = (Integer) r9;
    L20:
        if (r10 == null) goto L22;
        int r11 = r10.intValue();
    L23:
        r7.add(Integer.valueOf(r11));
        goto L15
    L22:
        r11 = 0;
        goto L23
    L19:
        r10 = null;
        goto L20
    L24:
        Iterator r12 = r7.iterator();
        int r16 = 0;
    L26:
        if (r12.hasNext() == false) goto L28;
        r16 = r16 | ((Number) r12.next()).intValue();
        goto L26
    L28:
        FLogger.a.i("ConversationAdapter", "onBindViewHolder position: " + r14 + ", data: " + r2.d() + ", payloads: " + r15 + ", value: " + r16);
        if (r16 > 0) goto L43;
        A2(r2, r5);
        C2(r2, r5);
        B2(r2, r5);
        D2(r2, r5);
        r5.V5(r2, this.a);
        if (ic8.n.z(r2.a) == false) goto L40;
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L37;
        r17.h0();
        if (h1.a.d() != true) goto L37;
        boolean r18 = true;
    L38:
        if (r18 == false) goto L40;
        boolean r19 = true;
    L41:
        r5.setPinned(r19);
    L70:
        Integer r110 = r2.j;
        if (r110 != null) goto L74;
    L75:
        Integer r111 = r2.j;
        if (r111 != null) goto L79;
    L81:
        LarusItemConversationBinding r112 = r5.a;
        if (r112 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L84:
        r112.m.setVisibility(0);
        LarusItemConversationBinding r113 = r5.a;
        if (r113 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L87:
        r113.t.setVisibility(8);
        r5.setOnClickListener(this.h);
        r5.setTag(r2);
        r5.setOnLongClickListener(new com.larus.bmhome.chat.adapter.b(this, r2));
        goto L118
    L79:
        if (r111.intValue() != (-1)) goto L81;
    L88:
        Integer r114 = r2.j;
        if (r114 == null) goto L91;
        int r115 = r114.intValue();
    L92:
        LarusItemConversationBinding r20 = r5.a;
        if (r20 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L95:
        r20.m.setVisibility(8);
        LarusItemConversationBinding r21 = r5.a;
        if (r21 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L98:
        r21.t.setVisibility(0);
        if (r115 == (-1)) goto L109;
        if (r115 != 1) goto L116;
        LarusItemConversationBinding r116 = r5.a;
        if (r116 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L105:
        r116.u.setVisibility(0);
        LarusItemConversationBinding r117 = r5.a;
        if (r117 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L108:
        r117.o.setVisibility(8);
    L116:
        r5.setOnClickListener(new com.larus.bmhome.chat.adapter.a(this));
        goto L118
    L109:
        LarusItemConversationBinding r118 = r5.a;
        if (r118 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L112:
        r118.u.setVisibility(8);
        LarusItemConversationBinding r119 = r5.a;
        if (r119 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L115:
        r119.o.setVisibility(0);
        goto L116
    L91:
        r115 = 0;
        goto L92
    L74:
        if (r110.intValue() == 1) goto L88;
    L37:
        r18 = false;
    L40:
        r19 = false;
        goto L41
    L43:
        if ((r16 & 1) == 0) goto L46;
        A2(r2, r5);
    L46:
        if ((r16 & 2) == 0) goto L49;
        C2(r2, r5);
    L49:
        if ((r16 & 4) == 0) goto L52;
        B2(r2, r5);
    L52:
        if ((r16 & 8) == 0) goto L54;
    L55:
        D2(r2, r5);
        r5.V5(r2, this.a);
    L57:
        if ((r16 & 16) == 0) goto L70;
        if (ic8.n.z(r2.a) == false) goto L68;
        IFlowSdkDepend r120 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r120 == null) goto L65;
        r120.h0();
        if (h1.a.d() != true) goto L65;
        boolean r121 = true;
    L66:
        if (r121 == false) goto L68;
        boolean r122 = true;
    L69:
        r5.setPinned(r122);
    L65:
        r121 = false;
    L68:
        r122 = false;
        goto L69
    L54:
        if ((r16 & 32) == 0) goto L57;
    L118:
        if ((r13 instanceof ItemCaseHolder) == false) goto L189;
        final Case r123 = r2.k;
        if (r123 == null) goto L190;
        AsyncListDiffer<wh8.a> r22 = y2();
        if (r22 == null) goto L137;
        List r23 = r22.getCurrentList();
        if (r23 == null) goto L137;
        wh8.a r24 = (wh8.a) CollectionsKt.getOrNull(r23, r14 + 1);
        if (r24 == null) goto L137;
        if (r24.k != null) goto L137;
        IFlowSdkDepend r25 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r25 == null) goto L134;
        r25.h0();
        if (h1.a.d() != true) goto L134;
        boolean r26 = true;
    L135:
        if (r26 == true) goto L137;
        boolean r27 = false;
    L138:
        ItemCaseHolder r28 = (ItemCaseHolder) r13;
        final ?? r29 = new c(this, r123, r14);
        r28.getClass();
        Intrinsics.checkNotNullParameter(r123, "item");
        FLogger.a.i("ItemCaseHolder", "bindData, item=" + r123 + ", adapterPosition = " + r28.getAdapterPosition());
        ImageLoaderKt.y(r28.b, r123.getIconUrl(), "collection_list_item_cover", new l(), 4);
        SimpleDraweeView r30 = r28.b;
        if (r30 == null) goto L141;
        r30.setColorFilter(ContextCompat.getColor(r28.a.getContext(), v19.c.b(2130972123, r28.a.getContext(), 2131103203)));
    L141:
        e1.d(r28.a, new k(r29));
        TextView r31 = r28.d;
        if (r31 == null) goto L144;
        r31.setText(r123.getTitle());
    L144:
        TextView r32 = r28.e;
        if (r32 == null) goto L147;
        r32.setText(r123.getBrief());
    L147:
        if (r27 == true) goto L151;
        View r124 = r28.f;
        if (r124 == null) goto L151;
        e1.o(r124);
    L151:
        IFlowSdkDepend r125 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r125 == null) goto L156;
        r125.h0();
        if (h1.a.d() != true) goto L156;
    L158:
        if (r3 == false) goto L169;
        View r33 = r28.a;
        View r34 = r28.f;
        if (r34 == null) goto L162;
        Context r35 = r34.getContext();
    L163:
        int r36 = v19.c.b(2130970533, r35, 2131102542);
        View r37 = r28.f;
        if (r37 == null) goto L166;
        r4 = r37.getContext();
    L166:
        e1.u(r33, 0.0f, r36, v19.c.b(2130972118, r4, 2131103188));
        ViewGroup r126 = r28.c;
        if (r126 == null) goto L179;
        r126.setBackgroundResource(v19.c.b(2130971924, r126.getContext(), 2131242465));
    L179:
        View r127 = r13.itemView;
        if (r127 == null) goto L191;
        r127.setOnLongClickListener(new d(this, r13, r2, r14));
        return;
    L191:
        return;
    L162:
        r35 = null;
        goto L163
    L169:
        View r38 = r28.a;
        View r39 = r28.f;
        if (r39 == null) goto L172;
        Context r40 = r39.getContext();
    L173:
        int r41 = v19.c.b(2130970529, r40, 2131102529);
        View r42 = r28.f;
        if (r42 == null) goto L176;
        r4 = r42.getContext();
    L176:
        e1.u(r38, 0.0f, r41, v19.c.b(2130972118, r4, 2131103188));
        ViewGroup r128 = r28.c;
        if (r128 == null) goto L179;
        r128.setBackgroundResource(v19.c.b(2130971923, r128.getContext(), 2131242463));
        goto L179
    L172:
        r40 = null;
    L156:
        r3 = false;
    L134:
        r26 = false;
    L137:
        r27 = true;
        goto L138
    L190:
        return;
    L189:
        return;
    L192:
        return;
    L188:
        return;
    }
}
