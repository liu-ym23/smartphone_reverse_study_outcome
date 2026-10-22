package com.ss.android.lark.picker.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import b08.a;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.picker.base.view.avataritem.userduty.UserDutyBinder;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w3c.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/DepartmentPersonItemView;", "Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "compositeComponentDelegate", "Lcom/larksuite/component/ui/list/CompositeComponentDelegate;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larksuite/component/ui/list/CompositeComponentDelegate;)V", "userDuty", "Lcom/ss/android/lark/picker/base/view/ShrinkDutyView;", "chatPreviewView", "Landroid/widget/ImageView;", "getChatPreviewView", "()Landroid/widget/ImageView;", "setChatPreviewView", "(Landroid/widget/ImageView;)V", "addChatPreviewView", "", "model", "Lcom/ss/android/lark/search/dto/bindermodel/UserDutyModel;", "addUserDutyLayout", "registerUserDutyModelBinder", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DepartmentPersonItemView extends AvatarItemView {
    private static final int CHAT_PREVIEW_PADDING = 8;
    private static final int CHAT_PREVIEW_SIZE = 20;
    public static final Companion Companion = null;
    private ImageView chatPreviewView;
    private ShrinkDutyView userDuty;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/base/view/DepartmentPersonItemView$Companion;", "", "<init>", "()V", "CHAT_PREVIEW_PADDING", "", "CHAT_PREVIEW_SIZE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DepartmentPersonItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public DepartmentPersonItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public DepartmentPersonItemView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    private final void addChatPreviewView() {
        AvatarItemView.attachRightView$default(this, this.chatPreviewView, false, false, 6, null);
    }

    private final void registerUserDutyModelBinder() {
        ShrinkDutyView r1 = this.userDuty;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("userDuty");
        r1 = null;
    L5:
        registerModelBinder(i.class, r1.getClass(), UserDutyBinder.INSTANCE);
    }

    private final void addUserDutyLayout() {
        LinearLayout r0 = (LinearLayout) findViewById(2131363696);
        ShrinkDutyView r7 = new ShrinkDutyView(getContext(), null, 0, 6, null);
        r7.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r7.setVisibility(8);
        r0.addView(r7);
        this.userDuty = r7;
    }

    public final ImageView getChatPreviewView() {
        return this.chatPreviewView;
    }

    public final void setChatPreviewView(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chatPreviewView = r2;
    }

    public final void userDuty(i r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        a r0 = getCompositeComponentDelegate();
        ShrinkDutyView r2 = this.userDuty;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("userDuty");
        r2 = null;
    L5:
        r0.a(DepartmentPersonItemView.class, r2, r4);
    }

    public DepartmentPersonItemView(Context r2, AttributeSet r3, int r4, a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "compositeComponentDelegate");
        super(r2, r3, r4, r5);
        ImageView r6 = new ImageView(r2);
        r6.setImageDrawable(UDIconUtils.getIconDrawable(r2, 2131254921, UIUtils.getColor(r2, 2131102420)));
        ViewGroup.LayoutParams r7 = new ViewGroup.LayoutParams((int) d.b(r2, 20), (int) d.b(r2, 20));
        setGravity(16);
        r6.setLayoutParams(r7);
        r6.setVisibility(8);
        this.chatPreviewView = r6;
        addUserDutyLayout();
        addChatPreviewView();
        registerUserDutyModelBinder();
    }

    public /* synthetic */ DepartmentPersonItemView(Context r1, AttributeSet r2, int r3, a r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = new a();
    L11:
        this(r1, r2, r3, r4);
    }
}
