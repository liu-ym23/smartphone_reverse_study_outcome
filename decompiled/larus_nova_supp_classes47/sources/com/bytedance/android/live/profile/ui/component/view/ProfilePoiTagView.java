package com.bytedance.android.live.profile.ui.component.view;

import am2.x;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import st0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00101\u001a\u000200¢\u0006\u0004\b2\u00103R\"\u0010\u000b\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001b\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\"\u0010#\u001a\u00020\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00064"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfilePoiTagView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/f;", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "setContentView", "(Landroid/view/ViewGroup;)V", "contentView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getLeftImage", "()Landroid/widget/ImageView;", "setLeftImage", "(Landroid/widget/ImageView;)V", "leftImage", "c", "getRightImage", "setRightImage", "rightImage", "d", "getVerifyRightImage", "setVerifyRightImage", "verifyRightImage", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Lcom/bytedance/android/live/core/widget/HSImageView;", "f", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getImageIcon", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setImageIcon", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "imageIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfilePoiTagView extends FrameLayout implements e<f> {
    public ViewGroup a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public TextView e;
    public HSImageView f;

    public ProfilePoiTagView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfilePoiTagView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ViewGroup getContentView() {
        return this.a;
    }

    public final HSImageView getImageIcon() {
        return this.f;
    }

    public final ImageView getLeftImage() {
        return this.b;
    }

    public final ImageView getRightImage() {
        return this.c;
    }

    public final TextView getTextView() {
        return this.e;
    }

    public final ImageView getVerifyRightImage() {
        return this.d;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(f r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
    }

    public final void setContentView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setImageIcon(HSImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setLeftImage(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setRightImage(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setTextView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setVerifyRightImage(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void b(f r7, NewProfileUser r8) {
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r8, "user");
        Integer r9 = r7.c;
        if (r9 == null) goto L7;
        int r10 = r9.intValue();
        UtilityKotlinExtentionsKt.w(this.b);
        if (r10 == (-1)) goto L7;
        this.b.setImageResource(r10);
    L7:
        String r12 = r7.b;
        if (r12 != null) goto L10;
    L15:
        k r13 = r7.d;
        Boolean r2 = null;
        if (r13 == null) goto L22;
        HSImageView r3 = this.f;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L20;
        r4.width = s1.f(9.0f);
        r4.height = s1.f(10.0f);
        Unit r5 = Unit.INSTANCE;
    L21:
        r3.setLayoutParams(r4);
        this.f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        UtilityKotlinExtentionsKt.w(this.f);
        ImageLoader.bindImage(this.f, r13, getWidth(), getHeight());
        goto L22
    L20:
        r4 = null;
    L22:
        UtilityKotlinExtentionsKt.w(this.c);
        o r14 = os0.b.a();
        if (r14 == null) goto L26;
        r2 = r14.isAnchor();
    L26:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L35;
        TextView r15 = this.e;
        if (r15 == null) goto L30;
        r15.setTextColor(s1.h(2131106948));
    L30:
        ViewGroup.LayoutParams r16 = this.c.getLayoutParams();
        if (r16 == null) goto L34;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        r17.setMargins(s1.f(4.0f), 0, 0, 0);
        r17.width = s1.f(10.0f);
        r17.height = s1.f(10.0f);
        this.c.setLayoutParams(r17);
        this.c.setImageResource(2131250135);
        goto L35
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L35:
        HashMap r18 = new HashMap();
        r18.put("tag_type", "poi");
        r18.put("tag_order", DataType.TRUE);
        j0.l().sendLog("livesdk_tag_show", r18, new Object[]{x.class, IRoom.class});
        return;
    L10:
        if (r12.length() <= 0) goto L12;
        boolean r19 = true;
    L13:
        if (r19 != true) goto L15;
        this.e.setText(r7.b);
        goto L15
    L12:
        r19 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(f r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void d(f r3, ProfileSkin r4) {
        f r5 = r3;
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "skin");
        ProfileCustomSkin r6 = r4.skin;
        if (r6 == null) goto L11;
        ProfileCustomSkin.TagUI r7 = r6.tagSkin;
        if (r7 == null) goto L12;
        String r0 = r7.wordColor;
        String r8 = r7.backgroundColor;
        if (3 == r5.getType()) goto L9;
        int r9 = m.a;
        m.e(this.b, r0);
    L9:
        int r10 = m.a;
        m.f(this.a, r8);
        m.e(this.e, r0);
        m.e(this.c, r0);
        return;
    L12:
        return;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(f r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        e.a.update(this, r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(f r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfilePoiTagView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567186, this, true);
        this.a = (ViewGroup) findViewById(2131383269);
        this.b = (ImageView) findViewById(2131383271);
        this.e = (TextView) findViewById(2131383272);
        this.f = findViewById(2131383266);
        this.c = (ImageView) findViewById(2131383270);
        this.d = (ImageView) findViewById(2131383279);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(f r2, NewProfileUser r3, ut0.f r4) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "logUseCase");
        e.a.a(r3, r4);
    }

    public /* synthetic */ ProfilePoiTagView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
