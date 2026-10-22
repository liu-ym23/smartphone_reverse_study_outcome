package com.larus.bmhome.chat.deepresearch.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.mainbot.impl.databinding.LarusBlockItemFoldTextBinding;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u0001002\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000202\u0018\u00010\u0017H\u0016J\u001a\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000fH\u0002J\b\u00106\u001a\u00020\u000fH\u0016J\u0010\u00107\u001a\u00020-2\u0006\u00104\u001a\u00020\u000fH\u0002J\u0012\u00108\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\n\u00109\u001a\u0004\u0018\u00010:H&R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010)\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015¨\u0006;"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/view/AbsFoldableBlockView;", "Lcom/larus/bmhome/chat/deepresearch/view/AbsBlockView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemFoldTextBinding;", "isProgressContent", "", "currentPage", "", "getCurrentPage", "()Ljava/lang/String;", "setCurrentPage", "(Ljava/lang/String;)V", "foldState", "", "animator", "Landroid/animation/ValueAnimator;", "mobMessage", "Lcom/larus/im/bean/message/Message;", "getMobMessage", "()Lcom/larus/im/bean/message/Message;", "setMobMessage", "(Lcom/larus/im/bean/message/Message;)V", "mobBotModel", "Lcom/larus/im/bean/bot/BotModel;", "getMobBotModel", "()Lcom/larus/im/bean/bot/BotModel;", "setMobBotModel", "(Lcom/larus/im/bean/bot/BotModel;)V", "mobResearchId", "getMobResearchId", "setMobResearchId", "mobPreviousPage", "getMobPreviousPage", "setMobPreviousPage", "init", "", "bindData", "data", "Lcom/larus/im/bean/message/block/Block;", "extra", "", "refreshImageViewFoldStatus", "foldStatus", "withAnim", "enableFold", "showTitleFoldStatus", "getDataListIdentifier", "getContentBlockView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class AbsFoldableBlockView extends AbsBlockView {
    public static final /* synthetic */ int j = 0;
    public LarusBlockItemFoldTextBinding b;
    public String c;
    public Map<String, Boolean> d;
    public ValueAnimator e;
    public Message f;
    public BotModel g;
    public String h;
    public String i;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            View r4 = this.a;
            boolean r0 = this.b;
            ViewGroup.LayoutParams r1 = r4.getLayoutParams();
            if (r1 == null) goto L10;
            if (r0 == false) goto L6;
            int r2 = 0;
        L7:
            r1.height = r2;
            r4.setLayoutParams(r1);
            return;
        L6:
            r2 = -2;
            goto L7
        L10:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }

        public a(View r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public abstract View getContentBlockView();

    public final String getCurrentPage() {
        return this.c;
    }

    public final BotModel getMobBotModel() {
        return this.g;
    }

    public final Message getMobMessage() {
        return this.f;
    }

    public final String getMobPreviousPage() {
        return this.i;
    }

    public final String getMobResearchId() {
        return this.h;
    }

    public AbsFoldableBlockView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void e(boolean r2) {
        if (r2 == false) goto L8;
        LarusBlockItemFoldTextBinding r3 = this.b;
        if (r3 == null) goto L14;
        AppCompatImageView r4 = r3.b;
        if (r4 == null) goto L15;
        r4.setRotation(270.0f);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        LarusBlockItemFoldTextBinding r5 = this.b;
        if (r5 == null) goto L17;
        AppCompatImageView r6 = r5.b;
        if (r6 == null) goto L18;
        r6.setRotation(0.0f);
        return;
    L18:
        return;
    }

    public final void setCurrentPage(String r1) {
        this.c = r1;
    }

    public final void setMobBotModel(BotModel r1) {
        this.g = r1;
    }

    public final void setMobMessage(Message r1) {
        this.f = r1;
    }

    public final void setMobPreviousPage(String r1) {
        this.i = r1;
    }

    public final void setMobResearchId(String r1) {
        this.h = r1;
    }

    public AbsFoldableBlockView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public void a(final Block r13, final Map<String, Object> r14) {
        LinearLayout r0 = null;
        if (r14 == null) goto L5;
        Object r1 = r14.get("block_view_extra_current_page");
    L7:
        if ((r1 instanceof String) == false) goto L9;
        String r2 = (String) r1;
    L10:
        this.c = r2;
        if (r14 == null) goto L13;
        Object r3 = r14.get("block_view_extra_fold_states");
    L15:
        if (TypeIntrinsics.isMutableMap(r3) == false) goto L17;
        Map<String, Boolean> r4 = (Map) r3;
    L18:
        this.d = r4;
        if (r14 == null) goto L21;
        Object r5 = r14.get("block_view_extra_message");
    L23:
        if ((r5 instanceof Message) == false) goto L25;
        Message r6 = (Message) r5;
    L26:
        this.f = r6;
        if (r14 == null) goto L29;
        Object r7 = r14.get("block_view_extra_previous_page");
    L31:
        if ((r7 instanceof String) == false) goto L33;
        String r8 = (String) r7;
    L34:
        this.i = r8;
        if (r14 == null) goto L37;
        Object r9 = r14.get("block_view_extra_bot_model");
    L39:
        if ((r9 instanceof BotModel) == false) goto L41;
        BotModel r10 = (BotModel) r9;
    L42:
        this.g = r10;
        if (r14 == null) goto L45;
        Object r11 = r14.get("block_view_extra_mob_research_id");
    L47:
        if ((r11 instanceof String) == false) goto L49;
        String r12 = (String) r11;
    L50:
        this.h = r12;
        String r15 = AbsBlockView.a.f(r13, Intrinsics.areEqual(this.c, "dr_process_detail"), false);
        boolean r16 = true;
        if (r15 != null) goto L53;
    L56:
        boolean r17 = true;
    L58:
        if (r17 == false) goto L65;
        LarusBlockItemFoldTextBinding r18 = this.b;
        if (r18 == null) goto L139;
        LinearLayout r19 = r18.a;
        if (r19 == null) goto L140;
        r19.setVisibility(8);
        return;
    L140:
        return;
    L139:
        return;
    L65:
        LarusBlockItemFoldTextBinding r20 = this.b;
        if (r20 == null) goto L70;
        LinearLayout r21 = r20.a;
        if (r21 == null) goto L70;
        r21.setVisibility(0);
    L70:
        LarusBlockItemFoldTextBinding r22 = this.b;
        if (r22 == null) goto L75;
        AppCompatTextView r23 = r22.e;
        if (r23 == null) goto L75;
        we8.a.b(r23, i5.t(), false, null, null, 12);
    L75:
        LarusBlockItemFoldTextBinding r24 = this.b;
        if (r24 == null) goto L80;
        AppCompatTextView r25 = r24.e;
        if (r25 == null) goto L80;
        r25.setText(r15);
    L80:
        if (r13 != null) goto L82;
    L84:
        boolean r26 = false;
    L85:
        if (r26 == false) goto L94;
        LarusBlockItemFoldTextBinding r27 = this.b;
        if (r27 == null) goto L91;
        ShimmerTextView r28 = r27.e;
        if (r28 == null) goto L91;
        r28.x();
    L91:
        View r29 = getContentBlockView();
        if (r29 == null) goto L102;
        r29.setVisibility(0);
    L102:
        LarusBlockItemFoldTextBinding r30 = this.b;
        if (r30 == null) goto L105;
        SimpleDraweeView r31 = r30.d;
    L106:
        AbsBlockView.a.e(r31, r13);
        if ((!(this instanceof d0)) == false) goto L122;
        if (r13 != null) goto L110;
    L112:
        r16 = false;
    L113:
        if (r16 == false) goto L122;
        LarusBlockItemFoldTextBinding r32 = this.b;
        if (r32 == null) goto L117;
        r0 = r32.c;
    L117:
        com.larus.utils.e1.d(r0, new b(this, r13, r14));
        LarusBlockItemFoldTextBinding r110 = this.b;
        if (r110 == null) goto L127;
        AppCompatImageView r111 = r110.b;
        if (r111 == null) goto L127;
        r111.setVisibility(0);
    L127:
        Map<String, Boolean> r112 = this.d;
        if (r112 == null) goto L136;
        if (r13 == null) goto L132;
        String r113 = r13.getBlockId();
        if (r113 == null) goto L132;
    L133:
        Boolean r114 = r112.get(r113);
        if (r114 == null) goto L136;
        boolean r115 = r114.booleanValue();
    L137:
        e(r115);
        d(r115, false);
        return;
    L132:
        r113 = "";
    L136:
        r115 = false;
        goto L137
    L110:
        if (r13.isFinish() != true) goto L112;
    L122:
        LarusBlockItemFoldTextBinding r116 = this.b;
        if (r116 == null) goto L127;
        AppCompatImageView r117 = r116.b;
        if (r117 == null) goto L127;
        r117.setVisibility(8);
        goto L127
    L105:
        r31 = null;
        goto L106
    L94:
        LarusBlockItemFoldTextBinding r33 = this.b;
        if (r33 == null) goto L99;
        ShimmerTextView r34 = r33.e;
        if (r34 == null) goto L99;
        int r35 = ShimmerTextView.h;
        r34.z(false);
    L99:
        View r36 = getContentBlockView();
        if (r36 == null) goto L102;
        r36.setVisibility(8);
        goto L102
    L82:
        if (r13.isFinish() != true) goto L84;
        r26 = true;
        goto L85
    L53:
        if (r15.length() == 0) goto L56;
        r17 = false;
        goto L58
    L49:
        r12 = null;
        goto L50
    L45:
        r11 = null;
        goto L47
    L41:
        r10 = null;
        goto L42
    L37:
        r9 = null;
        goto L39
    L33:
        r8 = null;
        goto L34
    L29:
        r7 = null;
        goto L31
    L25:
        r6 = null;
        goto L26
    L21:
        r5 = null;
        goto L23
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L15
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public void b(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        setOrientation(1);
        View r10 = LayoutInflater.from(r8).inflate(2131561831, this, false);
        addView(r10);
        int r11 = 2131368653;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r10, 2131368653);
        if (r3 == null) goto L13;
        r11 = 2131368654;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131368654);
        if (r4 == null) goto L13;
        r11 = 2131368711;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r10, 2131368711);
        if (r5 == null) goto L13;
        r11 = 2131368659;
        ShimmerTextView r6 = (ShimmerTextView) ViewBindings.findChildViewById(r10, 2131368659);
        if (r6 == null) goto L13;
        this.b = new LarusBlockItemFoldTextBinding((LinearLayout) r10, r3, r4, r5, r6);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public final void d(boolean r6, boolean r7) {
        final View r0 = getContentBlockView();
        if (r0 == null) goto L30;
        int r1 = 0;
        if (r7 == false) goto L22;
        r0.measure(0, 0);
        int r8 = r0.getMeasuredHeight();
        ValueAnimator r2 = this.e;
        if (r2 == null) goto L10;
        r2.cancel();
    L10:
        if (r6 == false) goto L12;
        ValueAnimator r9 = ObjectAnimator.ofInt(new int[]{Math.min(r8, r0.getHeight()), 0});
    L13:
        this.e = r9;
        if (r9 == null) goto L16;
        r9.addListener(new a(r0, r6));
    L16:
        ValueAnimator r10 = this.e;
        if (r10 == null) goto L19;
        r10.addUpdateListener(new c(r0));
    L19:
        ValueAnimator r11 = this.e;
        if (r11 == null) goto L31;
        r11.start();
        return;
    L31:
        return;
    L12:
        r9 = ObjectAnimator.ofInt(new int[]{0, r8});
        goto L13
    L22:
        ViewGroup.LayoutParams r12 = r0.getLayoutParams();
        if (r12 == null) goto L29;
        if (r6 == true) goto L27;
        r1 = -2;
    L27:
        r12.height = r1;
        r0.setLayoutParams(r12);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public AbsFoldableBlockView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
    }
}
