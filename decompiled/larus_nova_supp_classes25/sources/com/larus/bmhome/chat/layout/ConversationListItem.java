package com.larus.bmhome.chat.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.helper.e0;
import com.larus.bmhome.chat.helper.j0;
import com.larus.bmhome.chat.helper.k0;
import com.larus.bmhome.chat.helper.l0;
import com.larus.bmhome.databinding.LarusItemConversationBinding;
import com.larus.bmhome.utils.FirstFeedSceneEnum;
import com.larus.bmhome.utils.f2;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.AvatarTagView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.image.loader.g;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 92\u00020\u0001:\u00019B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\u000fJ6\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001bJ\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0018J&\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0018J\u0016\u0010)\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J*\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u00182\b\u0010,\u001a\u0004\u0018\u00010\u00182\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001bJ$\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010\u00182\b\u00101\u001a\u0004\u0018\u00010\u00182\b\u0010,\u001a\u0004\u0018\u00010\u0018J\u0016\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u001bJ\u000e\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u001bJ\u0010\u00106\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u00010%J\b\u00108\u001a\u00020\u000fH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/bmhome/chat/layout/ConversationListItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/databinding/LarusItemConversationBinding;", "onAttachedToWindow", "", "init", "getScreenMenuAnchorView", "Landroid/view/View;", "showLoadMore", "status", "hideLoadMore", "setName", "name", "", "tag", "isImmersiveBot", "", "isReviewFailedBot", "isMainBot", "resetTagStyle", "lastText", "setBrief", "brief", "setupRightAction", "unreadCount", "item", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "fragment", "Landroidx/fragment/app/Fragment;", "position", "setupAvatarTag", "setAvatar", "url", "bizTag", "needResize", "circle", "setMergedAvatar", "frontUrl", "behindUrl", "setAvatarByResId", "resId", "setPinned", "pin", "handleConversationMessage", "conversationData", "updateNameMaxWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationListItem extends ConstraintLayout {
    public static final int b = 0;
    public LarusItemConversationBinding a;

    public static final class a {
    }

    static {
        b = AppHost.a.getApplication().getResources().getDimensionPixelSize(c.b(2130970962, null, 2131166639));
    }

    public final View getScreenMenuAnchorView() {
        LarusItemConversationBinding r0 = this.a;
        LarusItemConversationBinding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        if (r0.i.getVisibility() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L15;
        LarusItemConversationBinding r3 = this.a;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        ConstraintLayout r4 = r1.r;
        Intrinsics.checkNotNull(r4);
        return r4;
    L13:
        r1 = r3;
        goto L14
    L15:
        LarusItemConversationBinding r5 = this.a;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        ConstraintLayout r6 = r1.m;
        Intrinsics.checkNotNull(r6);
        return r6;
    L18:
        r1 = r5;
        goto L19
    L8:
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        StaggeredGridLayoutManager.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L5;
        StaggeredGridLayoutManager.LayoutParams r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.setFullSpan(true);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public ConversationListItem(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        R5(r2, null);
    }

    public final void T5(int r5) {
        LarusItemConversationBinding r0 = this.a;
        LarusItemConversationBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        e1.o(r0.e);
        LarusItemConversationBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        e1.x(r2.b);
        LarusItemConversationBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.b.getHierarchy().setFailureImage(2131240119);
        LarusItemConversationBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        r4.b.setImageResource(r5);
        LarusItemConversationBinding r6 = this.a;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        r1.f.a(true);
        return;
    L17:
        r1 = r6;
        goto L18
    }

    public final void setBrief(String r2) {
        Intrinsics.checkNotNullParameter(r2, "brief");
        LarusItemConversationBinding r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.l.setText(e0.d(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPinned(boolean r9) {
        LarusItemConversationBinding r0 = null;
        if (r9 == false) goto L9;
        e1.u(this, 0.0f, c.b(2130970533, getContext(), 2131102542), c.b(2130972118, getContext(), 2131103188));
        LarusItemConversationBinding r10 = this.a;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L8:
        AvatarTagView r11 = r0.g;
        int r1 = c.b(2130970533, getContext(), 2131102542);
        int r2 = c.b(2130972118, getContext(), 2131103188);
        e1.u(r11.a.c, 0.0f, r1, r2);
        return;
    L7:
        r0 = r10;
        goto L8
    L9:
        e1.u(this, 0.0f, c.b(2130970529, getContext(), 2131102529), c.b(2130972118, getContext(), 2131103188));
        LarusItemConversationBinding r12 = this.a;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        AvatarTagView r13 = r0.g;
        int r3 = c.b(2130970529, getContext(), 2131102529);
        int r4 = c.b(2130972118, getContext(), 2131103188);
        e1.u(r13.a.c, 0.0f, r3, r4);
        return;
    L12:
        r0 = r12;
        goto L13
    }

    public ConversationListItem(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        R5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r3, AttributeSet r4) {
        LayoutInflater.from(r3).inflate(2131562524, this);
        this.a = LarusItemConversationBinding.a(this);
        if (f2.a != FirstFeedSceneEnum.CVS_LIST) goto L5;
        f2.a(this, "ConversationListItem");
    L5:
        e1.u(this, 0.0f, c.b(2130970529, r3, 2131102529), c.b(2130972118, r3, 2131103188));
    }

    public final void V5(wh8.a r8, Fragment r9) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "fragment");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new ConversationListItem$setupAvatarTag$1(r8, this, null), 3, null);
    }

    public ConversationListItem(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        R5(r2, r3);
    }

    public final void S5(String r6, final String r7, boolean r8) {
        LarusItemConversationBinding r0 = this.a;
        LarusItemConversationBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        e1.o(r0.e);
        LarusItemConversationBinding r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        e1.x(r1.b);
        LarusItemConversationBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.b.getHierarchy().setFailureImage(2131240119);
        if (Intrinsics.areEqual(r7, "covn_list.avatar") == false) goto L14;
        g r4 = b0.e(r7);
    L15:
        LarusItemConversationBinding r5 = this.a;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L18:
        ImageLoaderKt.v(r5.b, r6, r7, r4, new i(r7));
        LarusItemConversationBinding r9 = this.a;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r2.f.a(r8);
        return;
    L21:
        r2 = r9;
        goto L22
    L14:
        r4 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void U5(ConversationListItem r9, String r10, final String r11, boolean r12, final boolean r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r11 = "";
    L5:
        int r1 = 0;
        if ((r14 & 8) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 16) == 0) goto L11;
        r13 = false;
    L11:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "tag");
        LarusItemConversationBinding r0 = r9.a;
        LarusItemConversationBinding r2 = null;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L14:
        r0.v.setText(r10);
        LarusItemConversationBinding r15 = r9.a;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L17:
        r15.s.setVisibility(8);
        int r16 = r9.getResources().getDimensionPixelSize(c.b(2130971517, null, 2131167404));
        int r6 = r9.getResources().getDimensionPixelSize(c.b(2130971367, null, 2131167105));
        LarusItemConversationBinding r7 = r9.a;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        r7.y.setMaxWidth(Integer.MAX_VALUE);
        LarusItemConversationBinding r8 = r9.a;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L23:
        r8.y.setPadding(r16, r6, r16, r6);
        int r17 = l0.a;
        LarusItemConversationBinding r18 = r9.a;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L26:
        final TextView r19 = r18.y;
        Intrinsics.checkNotNullParameter(r19, "tagView");
        Intrinsics.checkNotNullParameter(r11, "tag");
        boolean r20 = true;
        if (r11.length() != 0) goto L29;
        boolean r110 = true;
    L30:
        if (r110 == false) goto L33;
        r19.setVisibility(8);
    L41:
        LarusItemConversationBinding r111 = r9.a;
        if (r111 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L46:
        if (r2.y.getVisibility() != 0) goto L48;
        boolean r112 = true;
    L49:
        if (r112 == true) goto L51;
    L56:
        int r113 = 0;
    L57:
        int r114 = (i5.r0() + i5.k0()) + i5.q();
        if (r2.s.getVisibility() == 0) goto L61;
        r20 = false;
    L61:
        if (r20 == false) goto L63;
        r1 = (i5.q() * 2) + i5.v();
    L63:
        FLogger r115 = FLogger.a;
        r115.d("ConversationListItem", "updateNameMaxWidth: called, screenWidth = " + com.larus.utils.i.d(r9.getContext()) + " tag = " + r2.y.getText() + ", tagWidth = " + r113 + ", avatarWidth=" + r114 + ", IconWith=" + r2.s.getWidth());
        int r21 = (((com.larus.utils.i.d(r9.getContext()) - r114) - (i5.r0() * 2)) - r113) - r1;
        StringBuilder r116 = new StringBuilder("updateNameMaxWidth: called, immersiveIconWith=");
        r116.append(r1);
        r116.append("  maxWidth = ");
        r116.append(r21);
        r115.d("ConversationListItem", r116.toString());
        r2.v.setMaxWidth(r21);
        return;
    L51:
        if (r2.y.getText().length() <= 0) goto L53;
        boolean r117 = true;
    L54:
        if (r117 == false) goto L56;
        r113 = Math.min(r2.y.getMaxWidth(), (int) (r2.y.getPaint().measureText(r2.y.getText().toString()) + (i5.j0() * 2)));
        goto L57
    L53:
        r117 = false;
        goto L54
    L48:
        r112 = false;
        goto L49
    L44:
        r2 = r111;
        goto L46
    L33:
        if (n0.a.b() == false) goto L36;
        if (r13 == false) goto L36;
        FLogger.a.d("ConversationListTagHelper", "renderTag: render enterprise main bot tag=".concat(r11));
        r19.setVisibility(0);
        r19.setText(r11);
        r19.setTextColor(ContextCompat.getColor(r19.getContext(), c.b(2130972079, r19.getContext(), 2131103136)));
        r19.setBackground(e1.e(i5.j0(), ContextCompat.getColor(r19.getContext(), c.b(2130972087, r19.getContext(), 2131103162))));
    L36:
        if (r12 == false) goto L38;
        int r118 = r19.getContext().getResources().getDimensionPixelSize(c.b(2130971517, r19.getContext(), 2131167404));
        int r119 = r19.getContext().getResources().getDimensionPixelSize(c.b(2130971501, r19.getContext(), 2131167372));
        r19.setVisibility(0);
        r19.setText(r11);
        r19.setMaxWidth(RangesKt.coerceAtLeast((int) (((double) ((((com.larus.utils.i.d(r19.getContext()) - i5.q()) - i5.k0()) - i5.q()) - i5.q())) * 0.7d), 0));
        r19.setTextColor(ContextCompat.getColor(r19.getContext(), c.b(2130972081, r19.getContext(), 2131103143)));
        r19.setBackgroundResource(2131239122);
        r19.setPadding(r118, r119, r118, r119);
        goto L41
    L38:
        r19.setTextColor(ContextCompat.getColor(r19.getContext(), c.b(2130972123, r19.getContext(), 2131103203)));
        r19.setBackgroundResource(c.b(2130970611, r19.getContext(), 2131238820));
        IFlowChatThemeConfigProvider r120 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r120 == null) goto L41;
        r120.d(new j0(r19, r11), new k0(r13, r19, r11), AdaptThemeFeatureKey.CHAT_CONVERSATION_LIST_MAIN_BOT_TAG);
        goto L41
    L29:
        r110 = false;
        goto L30
    }
}
