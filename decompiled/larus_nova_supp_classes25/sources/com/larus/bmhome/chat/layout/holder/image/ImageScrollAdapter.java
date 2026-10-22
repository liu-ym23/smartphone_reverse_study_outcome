package com.larus.bmhome.chat.layout.holder.image;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.progressloading.SketchLoadingController;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.bmhome.chat.view.share.ConversationShareMessageListAdapter;
import com.larus.bmhome.databinding.LarusImageScrollItemBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.kmp.chat.TemplateInfo;
import com.larus.platform.service.m3;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000267Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012 \u0010\u0007\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020.H\u0016J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020.H\u0016J\u0014\u00104\u001a\u0002012\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u001ej\b\u0012\u0004\u0012\u00020\u001a`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/ImageScrollAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/chat/layout/holder/image/ScrollImageViewHolder;", "loadImageAction", "Lcom/larus/bmhome/chat/layout/holder/image/ILoadImageAction;", "progressGetter", "Lcom/larus/bmhome/chat/layout/holder/image/IProgressGetter;", "eventParamsGetter", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "", "", "", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "coroutineScopeGetter", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "conversationShareMessageListAdapterGetter", "Lcom/larus/bmhome/chat/view/share/ConversationShareMessageListAdapter;", "<init>", "(Lcom/larus/bmhome/chat/layout/holder/image/ILoadImageAction;Lcom/larus/bmhome/chat/layout/holder/image/IProgressGetter;Lkotlin/jvm/functions/Function1;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/chat/api/MessageAdapter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "currentList", "", "Lcom/larus/bmhome/chat/layout/holder/image/ImageItemDataWithTemplate;", "getCurrentList", "()Ljava/util/List;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isReload", "", "()Z", "setReload", "(Z)V", "message", "getMessage", "()Lcom/larus/im/bean/message/Message;", "setMessage", "(Lcom/larus/im/bean/message/Message;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "refreshList", "newList", "DiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ImageScrollAdapter extends RecyclerView.Adapter<ScrollImageViewHolder> {
    public final g0 a;
    public final h0 b;
    public final Function1<Message, Map<String, Object>> c;
    public final BotModel d;
    public final com.larus.bmhome.chat.api.q0 e;
    public final Function0<CoroutineScope> f;
    public final Function0<ConversationShareMessageListAdapter> g;
    public final ArrayList<m0> h;
    public boolean i;
    public Message j;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/ImageScrollAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/chat/layout/holder/image/ImageItemDataWithTemplate;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<m0> a;
        public final List<m0> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public DiffCallback(List<m0> r2, List<m0> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r3, int r4) {
            m0 r5 = (m0) ListProtector.get(this.a, r3);
            m0 r6 = (m0) ListProtector.get(this.b, r4);
            if (r5.d == false) goto L7;
            return r6.d;
        L7:
            if (Intrinsics.areEqual(r5.b.getKey(), r6.b.getKey()) == false) goto L18;
            ImageEntity r7 = r5.b.getImageThumb();
            String r0 = null;
            if (r7 == null) goto L11;
            String r8 = r7.getUrl();
        L12:
            ImageEntity r9 = r6.b.getImageThumb();
            if (r9 == null) goto L16;
            r0 = r9.getUrl();
        L16:
            if (Intrinsics.areEqual(r8, r0) == false) goto L18;
            return true;
        L11:
            r8 = null;
        L18:
            return false;
        }

        public final boolean areItemsTheSame(int r2, int r3) {
            if (r2 == r3) goto L4;
        L6:
            return false;
        L4:
            if (Intrinsics.areEqual(((m0) ListProtector.get(this.a, r2)).e, ((m0) ListProtector.get(this.b, r3)).e) == false) goto L6;
            return true;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.h.size();
    }

    public final void y2(List<m0> r4) {
        Intrinsics.checkNotNullParameter(r4, "newList");
        Message r0 = this.j;
        Message r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getMessageId();
    L6:
        m0 r3 = (m0) CollectionsKt.firstOrNull(r4);
        if (r3 == null) goto L11;
        Message r5 = r3.a;
        if (r5 == null) goto L11;
        String r6 = r5.getMessageId();
    L12:
        boolean r7 = Intrinsics.areEqual(r2, r6);
        m0 r8 = (m0) CollectionsKt.firstOrNull(r4);
        if (r8 == null) goto L15;
        r1 = r8.a;
    L15:
        this.j = r1;
        if (r7 == false) goto L18;
        DiffUtil.DiffResult r9 = DiffUtil.calculateDiff(new DiffCallback(this.h, r4), false);
        this.h.clear();
        this.h.addAll(r4);
        r9.dispatchUpdatesTo(this);
        return;
    L18:
        this.h.clear();
        this.h.addAll(r4);
        notifyDataSetChanged();
        return;
    L11:
        r6 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r19, int r20) {
        final ScrollImageViewHolder r1 = (ScrollImageViewHolder) r19;
        Intrinsics.checkNotNullParameter(r1, "holder");
        final m0 r2 = (m0) ListProtector.get(this.h, r20);
        Function0<ConversationShareMessageListAdapter> r3 = this.g;
        final String r14 = null;
        if (r3 == null) goto L5;
        ConversationShareMessageListAdapter r4 = (ConversationShareMessageListAdapter) r3.invoke();
    L6:
        boolean r5 = true;
        boolean r15 = false;
        int r16 = 0;
        if (r4 == null) goto L9;
        boolean r6 = true;
    L10:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "data");
        Message r7 = r1.k;
        if (r7 == null) goto L13;
        String r8 = r7.getMessageId();
    L15:
        if (Intrinsics.areEqual(r8, r2.a.getMessageId()) == false) goto L30;
        m0 r9 = r1.j;
        if (r9 == null) goto L19;
        String r10 = r9.e;
    L21:
        if (Intrinsics.areEqual(r10, r2.e) == false) goto L30;
        m0 r11 = r1.j;
        if (r11 != null) goto L25;
    L27:
        boolean r12 = false;
    L28:
        if (r12 == false) goto L30;
        boolean r13 = true;
    L31:
        r1.k = r2.a;
        r1.l = Integer.valueOf(r20);
        r1.j = r2;
        r1.m = false;
        r1.n = r6;
        com.larus.utils.e1.o(r1.a.i);
        com.larus.utils.e1.o(r1.a.h);
        com.larus.utils.e1.o(r1.a.e);
        com.larus.utils.e1.o(r1.a.f);
        com.larus.utils.e1.o(r1.a.b);
        com.larus.utils.e1.o(r1.a.c);
        com.larus.utils.e1.o(r1.a.d);
        String r17 = df8.b.a(r2.b);
        if (r17 != null) goto L34;
    L37:
        boolean r18 = true;
    L39:
        if (r18 == false) goto L41;
        FLogger.a.i("ScrollImageViewHolder", " bindData error imageUrl is empty");
    L41:
        FLogger.a.i("ScrollImageViewHolder", " loadImage isReload " + ((Boolean) r1.d.invoke()).booleanValue());
        LarusImageScrollItemBinding r110 = r1.a;
        ResizeOptions r21 = r1.c.getImageSize();
        int r22 = r21.width;
        int r23 = r21.height;
        ConstraintLayout r24 = r1.a.a;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        if (r25 == null) goto L84;
        RecyclerView.LayoutParams r26 = (RecyclerView.LayoutParams) r25;
        ((ViewGroup.MarginLayoutParams) r26).width = r22;
        ((ViewGroup.MarginLayoutParams) r26).height = r23;
        r24.setLayoutParams(r26);
        if (r2.d == true) goto L61;
        com.larus.utils.e1.x(r110.k);
        if (r13 == false) goto L48;
        r110.k.setAlpha(0.0f);
    L49:
        Uri r27 = com.larus.image.loader.b0.a(r17, "chat.image_scroll", false, false, 6);
        r1.c.a(r110.k, com.larus.image.loader.b0.a(df8.b.b(r2.b), "chat.chat.image_scroll_thumb", false, false, 6), r27, r20, ((Boolean) r1.d.invoke()).booleanValue(), r1.o);
        g0 r28 = r1.c;
        SimpleDraweeView r29 = r110.k;
        ImageItem r30 = r2.b;
        TemplateInfo.TemplateInfo r31 = r2.c;
        ImageEntity r32 = r30.getImageOrigin();
        if (r32 == null) goto L53;
        String r33 = r32.getUrl();
        if (r33 == null) goto L53;
    L54:
        r28.e(r29, r30, r31, r17, r33, r20, r1.h, r1.i, (CoroutineScope) r1.g.invoke(), r1.f);
        ImageEntity r34 = r2.b.getImageOrigin();
        if (r34 == null) goto L57;
        r14 = r34.getUrl();
    L57:
        Integer r35 = r1.l;
        if (r35 == null) goto L60;
        r16 = r35.intValue();
    L60:
        final df8.a r36 = new df8.a(r16, r2.b, r2.c, (Map) r1.f.invoke(r1.k));
        LarusImageScrollItemBinding r37 = r1.a;
        r37.h.setOnClickListener(new d1(r1, r14, r36, r2));
        r37.e.setOnClickListener(new e1(r2, r1, r14, r36));
        return;
    L53:
        r33 = "";
        goto L54
    L48:
        r110.k.setAlpha(1.0f);
        ((ly9.a) r1.p.getValue()).a(null, null);
        r1.b.hide();
        goto L49
    L61:
        com.larus.utils.e1.o(r110.k);
        Message r38 = r1.k;
        if (r38 != null) goto L64;
    L66:
        r5 = false;
    L67:
        if (r5 == false) goto L69;
        ((ly9.a) r1.p.getValue()).a(r2.e, r1.k);
    L73:
        if (r2.e == null) goto L86;
        nq9.f r39 = m3.a.o();
        if (r39 == null) goto L87;
        Message r40 = r1.k;
        if (r40 == null) goto L79;
        r15 = com.larus.bmhome.chat.bean.d.a0(r40);
    L79:
        OldUgcGenImgPerfMonitor r41 = r39.a(r15);
        if (r41 == null) goto L88;
        r41.e(r2.a, r2.e);
        return;
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L69:
        ISketchLoadingController.a.b(r1.b, false, null, 0, 7);
        Integer r42 = r1.e.getLoadingProgress();
        if (r42 == null) goto L73;
        r1.b.setProgress(r42.intValue());
        goto L73
    L64:
        if (com.larus.bmhome.chat.bean.d.a0(r38) != true) goto L66;
    L84:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L34:
        if (r17.length() == 0) goto L37;
        r18 = false;
        goto L39
    L25:
        if (r11.d != true) goto L27;
        r12 = true;
        goto L28
    L19:
        r10 = null;
    L30:
        r13 = false;
        goto L31
    L13:
        r8 = null;
        goto L15
    L9:
        r6 = false;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.bmhome.chat.layout.holder.image.q0] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r27, int r28) {
        Intrinsics.checkNotNullParameter(r27, "parent");
        FLogger.a.i("ImageScrollAdapter", "onCreateViewHolder ");
        ConstraintLayout r1 = LayoutInflater.from(r27.getContext()).inflate(2131562457, r27, false);
        int r2 = 2131374943;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131374943);
        if (r6 == null) goto L25;
        r2 = 2131374966;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r1, 2131374966);
        if (r7 == null) goto L25;
        r2 = 2131374974;
        ImageCoverEditView r8 = (ImageCoverEditView) ViewBindings.findChildViewById(r1, 2131374974);
        if (r8 == null) goto L25;
        r2 = 2131374978;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r1, 2131374978);
        if (r9 == null) goto L25;
        r2 = 2131374979;
        ProgressBar r10 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131374979);
        if (r10 == null) goto L25;
        r2 = 2131375019;
        ViewStub r3 = (ViewStub) ViewBindings.findChildViewById(r1, 2131375019);
        if (r3 == null) goto L25;
        r2 = 2131375066;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r1, 2131375066);
        if (r12 == null) goto L25;
        r2 = 2131375086;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131375086);
        if (r13 == null) goto L25;
        r2 = 2131375087;
        AppCompatTextView r14 = ViewBindings.findChildViewById(r1, 2131375087);
        if (r14 == null) goto L25;
        r2 = 2131375091;
        SimpleDraweeView r15 = ViewBindings.findChildViewById(r1, 2131375091);
        if (r15 == null) goto L25;
        LarusImageScrollItemBinding r17 = new LarusImageScrollItemBinding(r1, r6, r7, r8, r9, r10, r3, r12, r13, r14, r15);
        ?? r4 = new q0(this);
        return new ScrollImageViewHolder(r17, new SketchLoadingController(r3), this.a, r4, this.b, this.c, this.f, this.d, this.e);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public ImageScrollAdapter(g0 r2, h0 r3, Function1 r4, BotModel r5, com.larus.bmhome.chat.api.q0 r6, t0 r7, u0 r8) {
        Intrinsics.checkNotNullParameter(r2, "loadImageAction");
        Intrinsics.checkNotNullParameter(r3, "progressGetter");
        Intrinsics.checkNotNullParameter(r4, "eventParamsGetter");
        Intrinsics.checkNotNullParameter(r7, "coroutineScopeGetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = new ArrayList();
    }
}
