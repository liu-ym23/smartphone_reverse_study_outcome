package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.BannerSettingItemView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.q;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0002JKB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ(\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020.H\u0002J \u00106\u001a\u00020.2\u0006\u00107\u001a\u0002082\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0016J\u0018\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u00192\u0006\u00101\u001a\u00020\bH\u0002J\b\u0010;\u001a\u00020.H\u0002J\u0010\u0010<\u001a\u00020.2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001e\u0010=\u001a\u00020.2\u0006\u0010#\u001a\u00020$2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0002J\b\u0010A\u001a\u00020.H\u0002J\b\u0010B\u001a\u00020.H\u0002J\u0010\u0010C\u001a\u00020.2\u0006\u00100\u001a\u00020\u0012H\u0002J\u001a\u0010D\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010E\u001a\u00020@H\u0002J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020\u0019H\u0016J\b\u0010H\u001a\u00020IH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/BannerSettingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/IUpdateHeightDecoration;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mDependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/BannerSettingItemDecoration$IBannerSettingItemDependency;", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/recyclerview/widget/RecyclerView;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/BannerSettingItemDecoration$IBannerSettingItemDependency;)V", "bannerData", "Lcom/ss/android/lark/chat/chatwindow/chat/BannerData;", "decorView", "Lcom/ss/android/lark/chat/chatwindow/chat/BannerSettingItemView;", "btnView", "Landroid/view/View;", "tvTitleView", "tvDesc", "Landroid/widget/TextView;", "gestureDetector", "Landroid/view/GestureDetector;", "extraHeight", BuildConfig.FLAVOR, "upgradeLeft", BuildConfig.FLAVOR, "upgradeTop", "upgradeWidth", "upgradeHeight", "targetUpgradeArea", "Landroid/graphics/Rect;", "lastClickTime", BuildConfig.FLAVOR, "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "messageContainer", "Landroid/widget/LinearLayout;", "avatarViewList", BuildConfig.FLAVOR, "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "messageViewList", "imageView", "Landroid/widget/ImageView;", "getItemOffsets", BuildConfig.FLAVOR, "outRect", "view", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "measureDecorView", "lastDrawViewWidth", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "calculateUpgradeAbsoluteArea", "decorTranslateY", "calculateRelativePosition", "updateDecoration", "addMessage", "messageList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "checkAvatarReadyToDraw", "drawMessage", "changeChildViewsClipToOutLine", "createMessageView", "messageInfo", "updateHeight", "height", "isEnable", BuildConfig.FLAVOR, "Companion", "IBannerSettingItemDependency", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerSettingItemDecoration extends RecyclerView.ItemDecoration implements z3b.a {
    public final RecyclerView a;
    public final b b;
    public final BannerSettingItemView c;
    public final View d;
    public final View e;
    public float f;
    public int g;
    public int h;
    public int i;
    public int j;
    public Rect k;
    public long l;
    public int m;

    public static final class a {
    }

    public interface b {
        boolean a();
    }

    static {
    }

    public final void h() {
        int r0 = View.MeasureSpec.makeMeasureSpec((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight(), 1073741824);
        int r1 = 0;
        int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.c.measure(r0, r2);
        BannerSettingItemView r3 = this.c;
        r3.layout(0, 0, r3.getMeasuredWidth(), this.c.getMeasuredHeight());
        View r4 = this.d;
        int r5 = 0;
    L3:
        if (r4 == null) goto L10;
        if (Intrinsics.areEqual(r4, this.c) == true) goto L10;
        r1 = r1 + r4.getLeft();
        r5 = r5 + r4.getTop();
        Object r6 = r4.getParent();
        if ((r6 instanceof View) == true) goto L8;
        r4 = null;
        goto L3
    L8:
        r4 = (View) r6;
    L10:
        this.g = r1;
        this.h = r5;
        this.i = this.d.getMeasuredWidth();
        this.j = this.d.getMeasuredHeight();
    }

    @Override // z3b.a
    public final boolean isEnable() {
        return this.b.a();
    }

    @Override // z3b.a
    public final void c(float r1) {
        this.f = r1;
    }

    public final void onDrawOver(Canvas r12, RecyclerView r13, RecyclerView.State r14) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(r14, "state");
        super.onDrawOver(r12, r13, r14);
        if (this.b.a() == true) goto L5;
        return;
    L5:
        int r0 = r13.getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L34;
        h();
        int r3 = this.m;
        if (r3 != 0) goto L10;
    L13:
        this.m = this.c.getMeasuredWidth();
        View r4 = r13.getChildAt(r2);
        if (r13.getChildAdapterPosition(r4) != 0) goto L33;
        int r5 = MathKt.roundToInt(r4.getTranslationY() + 0.5f);
        r12.save();
        Rect r6 = new Rect();
        int r7 = r13.getItemDecorationCount();
        int r8 = 0;
        int r9 = 0;
    L16:
        if (r8 >= r7) goto L20;
        RecyclerView.ItemDecoration r10 = r13.getItemDecorationAt(r8);
        if (Intrinsics.areEqual(r10, this) == true) goto L20;
        r6.set(0, 0, 0, 0);
        r10.getItemOffsets(r6, r4, r13, r14);
        r9 = r9 + r6.top;
        r8 = r8 + 1;
    L20:
        float r11 = r4.getTop();
        ViewGroup.LayoutParams r15 = r4.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
    L24:
        if (r16 == null) goto L26;
        int r17 = r16.topMargin;
    L27:
        float r18 = ((r11 + r5) - this.c.getMeasuredHeight()) - (r9 + r17);
        r12.translate(0.0f, r18);
        int r19 = r12.save();
        this.c.draw(r12);     // Catch: Throwable -> L30
        r12.restoreToCount(r19);
        float r20 = this.g;
        float r21 = r18 + this.h;
        this.k = new Rect(MathKt.roundToInt(r20), MathKt.roundToInt(r21 - r13.getScrollY()), MathKt.roundToInt(this.i + r20), MathKt.roundToInt((this.j + r21) - r13.getScrollY()));
    L30:
        th = move-exception;
        r12.restoreToCount(r19);
        throw th;
    L26:
        r17 = 0;
        goto L27
    L23:
        r16 = null;
    L33:
        r2 = r2 + 1;
        goto L6
    L10:
        if (r3 == this.c.getMeasuredWidth()) goto L13;
        this.m = this.c.getMeasuredWidth();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BannerSettingItemDecoration(Context r4, Fragment r5, SceneCoordinateRecyclerView r6, q r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        Intrinsics.checkNotNullParameter(r7, "mDependency");
        this.a = r6;
        this.b = r7;
        BannerSettingItemView r8 = new BannerSettingItemView(r6.getContext(), null, 6, 0);
        this.c = r8;
        this.d = r8.getBtnView();
        this.e = r8.getTitleView();
        r8.getTvDesc();
        new GestureDetector(r4, new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.a(this, r5));
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (r4.getChildAdapterPosition(r3) == 0) goto L5;
    L7:
        r2.set(0, 0, 0, 0);
        return;
    L5:
        if (this.b.a() == false) goto L7;
        int r6 = ((int) this.f) + 0;
        h();
        r2.set(0, r6 + this.c.getMeasuredHeight(), 0, 0);
    }
}
