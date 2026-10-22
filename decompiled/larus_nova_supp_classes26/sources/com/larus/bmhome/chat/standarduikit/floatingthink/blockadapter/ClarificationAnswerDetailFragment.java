package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.standarduikit.clarification.view.InteractionAskAttachmentView;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderV2Binding;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.block.AttachmentBlock;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.InteractionAskAnswer;
import com.larus.im.bean.message.block.InteractionAskAnswerCapability;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.im.bean.message.block.InteractionAskContent;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.im.bean.message.block.InteractionAskQuestion;
import com.larus.mainbot.impl.databinding.LarusFragmentClarificationAnswerDetailBinding;
import com.larus.mainbot.impl.databinding.LarusItemClarificationAnswerDetailBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 >2\u00020\u0001:\u0005>?@ABB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J0\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0(2\b\u0010)\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u001a\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u0002002\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0018\u00101\u001a\b\u0012\u0004\u0012\u0002020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0016\u00103\u001a\u0004\u0018\u000102*\u0002042\u0006\u00105\u001a\u00020\rH\u0002J\u0016\u00106\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u00020\"0(H\u0002J&\u00108\u001a\b\u0012\u0004\u0012\u00020\"0(*\b\u0012\u0004\u0012\u00020\"0(2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0(H\u0002J\f\u0010;\u001a\u00020\u0011*\u00020:H\u0002J\f\u0010<\u001a\u00020$*\u00020:H\u0002J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020 0(2\u0006\u0010/\u001a\u0002002\u0006\u0010,\u001a\u00020-H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/ClarificationAnswerDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentClarificationAnswerDetailBinding;", "headerController", "Lcom/larus/common_ui/dialog/BottomSheetHeaderControllerV2;", "interactionAskBlock", "Lcom/larus/im/bean/message/block/InteractionAskBlock;", "globalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "message", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/ClarificationAnswerDetailFragment$ClarificationAnswerDetailAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "setupHeader", "openAttachment", "key", "", "item", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/ClarificationAnswerDetailFragment$QuestionAnswerItem;", "position", "", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "buildItems", "", "block", "hasAnswer", "", "answer", "Lcom/larus/im/bean/message/block/InteractionAskAnswer;", "buildAnswerText", "question", "Lcom/larus/im/bean/message/block/InteractionAskQuestion;", "buildAttachments", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/ClarificationAnswerDetailFragment$AnswerAttachmentItem;", "toDetailAttachmentItem", "Lcom/larus/im/bean/message/block/AttachmentItem;", "originMessage", "hydrateMissingImageUrls", "items", "rebuildWithEntities", "entities", "Lcom/larus/im/bean/message/UplinkFileEntity;", "normalizeForDetail", "detailItemWidth", "resolveSelectedOptionLabels", "Companion", "QuestionAnswerItem", "AnswerAttachmentItem", "ClarificationAnswerDetailAdapter", "ClarificationAnswerDetailViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClarificationAnswerDetailFragment extends Fragment {
    public static InteractionAskBlock j;
    public static kc8.y k;
    public static Message l;
    public LarusFragmentClarificationAnswerDetailBinding d;
    public com.larus.common_ui.dialog.t e;
    public InteractionAskBlock f;
    public kc8.y g;
    public Message h;
    public final ClarificationAnswerDetailAdapter i;

    public static final class ClarificationAnswerDetailAdapter extends ListAdapter<d, b> {
        public static final ClarificationAnswerDetailFragment$ClarificationAnswerDetailAdapter$Companion$DiffCallback$1 b = null;
        public final Function5<String, View, d, Integer, BaseResourceViewHolder.a, Unit> a;

        public static final class a {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.ClarificationAnswerDetailFragment$ClarificationAnswerDetailAdapter$Companion$DiffCallback$1] */
        static {
            b = new ClarificationAnswerDetailFragment$ClarificationAnswerDetailAdapter$Companion$DiffCallback$1();
        }

        public ClarificationAnswerDetailAdapter(com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.c r2) {
            Intrinsics.checkNotNullParameter(r2, "onAttachmentClick");
            super(b);
            this.a = r2;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
            b r15 = (b) r13;
            Intrinsics.checkNotNullParameter(r15, "holder");
            d r0 = (d) getItem(r14);
            boolean r1 = true;
            int r2 = 0;
            if (r14 != 0) goto L5;
            boolean r3 = true;
        L7:
            if (r14 == (getItemCount() - 1)) goto L10;
            r1 = false;
        L10:
            r15.getClass();
            Intrinsics.checkNotNullParameter(r0, "item");
            LinearLayout r16 = r15.a.a;
            if (r3 == false) goto L13;
            int r4 = r15.c;
        L14:
            if (r1 == false) goto L16;
            int r5 = r15.c;
        L17:
            r16.setPadding(0, r4, 0, r5);
            r15.a.d.setText(r0.b);
            r15.a.b.setText(r0.c);
            TextView r17 = r15.a.b;
            if (StringsKt.isBlank(r0.c) == false) goto L20;
            r2 = 8;
        L20:
            r17.setVisibility(r2);
            r15.a.c.a(r0.e, new e(r15, r0), new ResourceBarConfig(Mode.SHOW, false, 0, 0, null, null, 60, null));
            return;
        L16:
            r5 = 0;
            goto L17
        L13:
            r4 = 0;
            goto L14
        L5:
            r3 = false;
            goto L7
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            View r6 = LayoutInflater.from(r4.getContext()).inflate(2131562516, r4, false);
            int r7 = 2131363032;
            TextView r0 = (TextView) ViewBindings.findChildViewById(r6, 2131363032);
            if (r0 == null) goto L11;
            r7 = 2131363335;
            InteractionAskAttachmentView r1 = (InteractionAskAttachmentView) ViewBindings.findChildViewById(r6, 2131363335);
            if (r1 == null) goto L11;
            r7 = 2131383532;
            TextView r2 = (TextView) ViewBindings.findChildViewById(r6, 2131383532);
            if (r2 == null) goto L11;
            return new b(new LarusItemClarificationAnswerDetailBinding((LinearLayout) r6, r0, r1, r2), this.a);
        L11:
            throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
        }
    }

    public static final class a {
        public final UplinkFileEntity a;
        public final ResourceItemBean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "AnswerAttachmentItem(entity=" + this.a + ", resourceItem=" + this.b + ')';
        }

        public a(UplinkFileEntity r2, ResourceItemBean r3) {
            Intrinsics.checkNotNullParameter(r2, "entity");
            Intrinsics.checkNotNullParameter(r3, "resourceItem");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final LarusItemClarificationAnswerDetailBinding a;
        public final Function5<String, View, d, Integer, BaseResourceViewHolder.a, Unit> b;
        public final int c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(LarusItemClarificationAnswerDetailBinding r2, Function5<? super String, ? super View, ? super d, ? super Integer, ? super BaseResourceViewHolder.a, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            Intrinsics.checkNotNullParameter(r3, "onAttachmentClick");
            super(r2.a);
            this.a = r2;
            this.b = r3;
            this.c = r2.a.getResources().getDimensionPixelSize(2131166786);
        }
    }

    public static final class c {
        public static ClarificationAnswerDetailFragment a(InteractionAskBlock r1, kc8.y r2, Message r3) {
            Intrinsics.checkNotNullParameter(r1, "interactionAskBlock");
            ClarificationAnswerDetailFragment.j = r1;
            ClarificationAnswerDetailFragment.k = r2;
            ClarificationAnswerDetailFragment.l = r3;
            return new ClarificationAnswerDetailFragment();
        }
    }

    public static final class d {
        public final String a;
        public final String b;
        public final String c;
        public final List<a> d;
        public final List<ResourceItemBean> e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "QuestionAnswerItem(questionId=" + this.a + ", questionTitle=" + this.b + ", answerText=" + this.c + ", attachments=" + this.d + ')';
        }

        public d(String r2, String r3, String r4, List<a> r5) {
            Intrinsics.checkNotNullParameter(r2, "questionId");
            Intrinsics.checkNotNullParameter(r3, "questionTitle");
            Intrinsics.checkNotNullParameter(r4, "answerText");
            Intrinsics.checkNotNullParameter(r5, "attachments");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            List<a> r6 = r5;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r8 = r6.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            r7.add(((a) r8.next()).b);
            goto L4
        L6:
            this.e = r7;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.c] */
    public ClarificationAnswerDetailFragment() {
        this.i = new ClarificationAnswerDetailAdapter(new com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.c(this));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        LarusFragmentClarificationAnswerDetailBinding r0 = this.d;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L7;
        r1.setAdapter(null);
    L7:
        this.e = null;
        this.d = null;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.f = j;
        this.g = k;
        this.h = l;
        j = null;
        k = null;
        l = null;
    }

    public final void onViewCreated(View r58, Bundle r59) {
        Intrinsics.checkNotNullParameter(r58, "view");
        super.onViewCreated(r58, r59);
        com.larus.common_ui.dialog.t r2 = new com.larus.common_ui.dialog.t(LarusLayoutBottomSheetHeaderV2Binding.a(r58.findViewById(2131364521)));
        this.e = r2;
        InteractionAskBlock r3 = this.f;
        String r4 = null;
        if (r3 == null) goto L7;
        InteractionAskContent r5 = r3.getThinkingContent();
        if (r5 == null) goto L7;
        String r6 = r5.getProcessingStatusText();
    L8:
        r2.a(r6);
        com.larus.common_ui.dialog.t r7 = this.e;
        if (r7 == null) goto L11;
        r7.a.b.setOnClickListener(new com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.a(this));
    L11:
        com.larus.common_ui.dialog.t r8 = this.e;
        if (r8 == null) goto L14;
        r8.a.b.setImageResource(v19.c.b(2130971965, r58.getContext(), 2131242608));
    L14:
        LarusFragmentClarificationAnswerDetailBinding r9 = this.d;
        if (r9 == null) goto L204;
        RecyclerView r10 = r9.b;
        if (r10 == null) goto L205;
        r10.setLayoutManager(new LinearLayoutManager(r58.getContext()));
        r10.setItemAnimator(null);
        r10.setAdapter(this.i);
        InteractionAskBlock r1 = this.f;
        if (r1 == null) goto L22;
        List r11 = r1.getQuestions();
    L23:
        if (r11 != null) goto L25;
        r11 = CollectionsKt.emptyList();
    L25:
        ArrayList r12 = new ArrayList(r11.size());
        Iterator r13 = r11.iterator();
    L27:
        if (r13.hasNext() == false) goto L177;
        InteractionAskQuestion r14 = (InteractionAskQuestion) r13.next();
        InteractionAskAnswer r15 = r14.getAnswer();
        String r16 = r14.getQuestionId();
        String r17 = "";
        if (r16 != null) goto L31;
        r16 = "";
    L31:
        String r18 = r14.getTitle();
        if (r18 != null) goto L35;
        r18 = "";
    L35:
        if (r15 == null) goto L124;
        Integer r19 = r15.getStatus();
        boolean r110 = true;
        if (r19 != null) goto L40;
    L42:
        List r111 = r15.getSelectedOptionIds();
        if (r111 != null) goto L45;
    L48:
        boolean r112 = true;
    L49:
        if (r112 == false) goto L77;
        InteractionAskAnswerCapability r113 = r15.getCapabilityAnswer();
        if (r113 == null) goto L54;
        String r114 = r113.getText();
    L55:
        if (r114 != null) goto L57;
    L60:
        boolean r115 = true;
    L61:
        if (r115 == false) goto L77;
        InteractionAskAnswerCapability r116 = r15.getCapabilityAnswer();
        if (r116 == null) goto L68;
        AttachmentBlock r117 = r116.getAttachments();
        if (r117 == null) goto L68;
        Object r118 = r117.getAttachments();
    L69:
        Collection r119 = (Collection) r118;
        if (r119 != null) goto L72;
    L75:
        boolean r120 = true;
    L76:
        if (r120 == false) goto L77;
    L78:
        boolean r121 = false;
    L79:
        if (r121 == false) goto L124;
        ArrayList r122 = new ArrayList();
        List r20 = r14.getOptions();
        if (r20 != null) goto L84;
        r20 = CollectionsKt.emptyList();
    L84:
        List r21 = r20;
        LinkedHashMap r123 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r21, 10)), 16));
        Iterator r22 = r21.iterator();
    L86:
        if (r22.hasNext() == false) goto L91;
        Object r23 = r22.next();
        String r124 = ((InteractionAskOption) r23).getOptionId();
        if (r124 != null) goto L90;
        r124 = "";
    L90:
        r123.put(r124, r23);
        goto L86
    L91:
        List r24 = r15.getSelectedOptionIds();
        if (r24 != null) goto L94;
        r24 = CollectionsKt.emptyList();
    L94:
        ArrayList r125 = new ArrayList();
        Iterator r25 = r24.iterator();
    L96:
        if (r25.hasNext() == false) goto L108;
        InteractionAskOption r26 = (InteractionAskOption) r123.get((String) r25.next());
        if (r26 == null) goto L104;
        String r27 = r26.getLabel();
        if (r27 == null) goto L104;
        if ((!StringsKt.isBlank(r27)) == false) goto L104;
    L105:
        if (r27 == null) goto L96;
        r125.add(r27);
    L104:
        r27 = r4;
        goto L105
    L108:
        if ((!r125.isEmpty()) == false) goto L110;
        r122.add(CollectionsKt.joinToString$default(r125, "、", null, null, 0, null, null, 62, null));
    L110:
        InteractionAskAnswerCapability r28 = r15.getCapabilityAnswer();
        if (r28 == null) goto L113;
        String r29 = r28.getText();
    L114:
        if (r29 == null) goto L117;
        r17 = r29;
    L117:
        String r30 = StringsKt.trim(r17).toString();
        if (r30.length() > 0) goto L121;
        r110 = false;
    L121:
        if (r110 == false) goto L123;
        r122.add(r30);
    L123:
        String r31 = CollectionsKt.joinToString$default(r122, "\n", null, null, 0, null, null, 62, null);
    L125:
        Message r32 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
        if (r15 == null) goto L132;
        InteractionAskAnswerCapability r33 = r15.getCapabilityAnswer();
        if (r33 == null) goto L132;
        AttachmentBlock r34 = r33.getAttachments();
        if (r34 == null) goto L132;
        Object r35 = r34.getAttachments();
    L133:
        if (r35 != null) goto L135;
        r35 = CollectionsKt.emptyList();
    L135:
        ArrayList r36 = new ArrayList();
        Iterator r37 = ((Iterable) r35).iterator();
    L137:
        if (r37.hasNext() == false) goto L176;
        UplinkFileEntity r126 = ic8.h.f((AttachmentItem) r37.next(), r32);
        if (r126 != null) goto L141;
        Object r127 = r4;
    L173:
        if (r127 == null) goto L175;
        r36.add(r127);
    L175:
        r4 = null;
        goto L137
    L141:
        Integer r128 = r126.getFileReviewStatus();
        int r129 = FileReviewState.DEFAULT.getValue();
        if (r128 != null) goto L145;
    L147:
        Integer r130 = r126.getFileParsedStatus();
        int r131 = FileParseState.DEFAULT.getValue();
        if (r130 != null) goto L151;
    L153:
        Integer r132 = r126.getUpLinkStatus();
        int r133 = UpLinkState.DEFAULT.getValue();
        if (r132 != null) goto L157;
    L159:
        Integer r134 = r126.getUpLinkProcess();
        if (r134 == null) goto L162;
        int r135 = r134.intValue();
    L163:
        if (r135 > 0) goto L165;
        r126.setUpLinkProcess(100);
    L165:
        Mode r136 = Mode.SHOW;
        if (n1.d(r126) == false) goto L168;
    L171:
        int r137 = i5.w0();
    L172:
        r127 = new a(r126, com.larus.bmhome.chat.c.a(r126, r136, r137, 0, 60));
        goto L173
    L168:
        if (n1.e(r126) == true) goto L171;
        r137 = i5.y();
        goto L172
    L162:
        r135 = 0;
        goto L163
    L157:
        if (r132.intValue() != r133) goto L159;
        r126.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        goto L159
    L151:
        if (r130.intValue() != r131) goto L153;
        r126.setFileParsedStatus(Integer.valueOf(FileParseState.SUCCESS.getValue()));
        goto L153
    L145:
        if (r128.intValue() != r129) goto L147;
        r126.setFileReviewStatus(Integer.valueOf(FileReviewState.ACCESS.getValue()));
        goto L147
    L176:
        r12.add(new d(r16, r18, r31, r36));
        r4 = null;
    L132:
        r35 = r4;
        goto L133
    L113:
        r29 = r4;
        goto L114
    L72:
        if (r119.isEmpty() == true) goto L75;
        r120 = false;
    L68:
        r118 = r4;
        goto L69
    L57:
        if (r114.length() == 0) goto L60;
        r115 = false;
        goto L61
    L54:
        r114 = r4;
    L77:
        r121 = true;
        goto L79
    L45:
        if (r111.isEmpty() == true) goto L48;
        r112 = false;
        goto L49
    L40:
        if (r19.intValue() != 1) goto L42;
    L124:
        r31 = getString(2131901033);
        goto L125
    L177:
        this.i.submitList(r12);
        ArrayList r38 = new ArrayList();
        Iterator r39 = r12.iterator();
    L179:
        if (r39.hasNext() == false) goto L186;
        List<a> r40 = ((d) r39.next()).d;
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator<T> r42 = r40.iterator();
    L182:
        if (r42.hasNext() == false) goto L184;
        r41.add(((a) r42.next()).a);
        goto L182
    L184:
        CollectionsKt.addAll(r38, r41);
        goto L179
    L186:
        if (r38.isEmpty() == true) goto L206;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ClarificationAnswerDetailFragment$hydrateMissingImageUrls$1(r38, this, r12, null), 3, null);
        return;
    L206:
        return;
    L22:
        r11 = null;
        goto L23
    L205:
        return;
    L204:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562355, r3, false);
        int r6 = 2131364521;
        View r7 = ViewBindings.findChildViewById(r5, 2131364521);
        if (r7 == null) goto L9;
        LarusLayoutBottomSheetHeaderV2Binding.a(r7);
        r6 = 2131384071;
        RecyclerView r8 = ViewBindings.findChildViewById(r5, 2131384071);
        if (r8 == null) goto L9;
        LinearLayout r9 = (LinearLayout) r5;
        this.d = new LarusFragmentClarificationAnswerDetailBinding(r9, r8);
        return r9;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
