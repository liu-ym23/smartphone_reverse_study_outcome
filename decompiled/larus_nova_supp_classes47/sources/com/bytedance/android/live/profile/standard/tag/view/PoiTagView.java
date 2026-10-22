package com.bytedance.android.live.profile.standard.tag.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfilePoiInfo;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import jt0.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import os0.b;
import py.k;
import st0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0014\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010$\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\"\u0010,\u001a\u00020%8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u0010;\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006D"}, d2 = {"Lcom/bytedance/android/live/profile/standard/tag/view/PoiTagView;", "Landroid/widget/FrameLayout;", "Ljt0/c;", "Lcom/bytedance/android/live/base/model/user/ProfileTagContent;", "tagContent", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "Lcom/bytedance/android/live/profile/ui/base/h;", "profileContext", "Ljt0/b;", "tagItem", "", "update", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "setContentView", "(Landroid/view/ViewGroup;)V", "contentView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getLeftImage", "()Landroid/widget/ImageView;", "setLeftImage", "(Landroid/widget/ImageView;)V", "leftImage", "c", "getRightImage", "setRightImage", "rightImage", "d", "getVerifyRightImage", "setVerifyRightImage", "verifyRightImage", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Lcom/bytedance/android/live/core/widget/HSImageView;", "f", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getImageIcon", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setImageIcon", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "imageIcon", "Lst0/f;", "<set-?>", "g", "Lst0/f;", "getDataModel", "()Lst0/f;", "dataModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PoiTagView extends FrameLayout implements c {
    public ViewGroup a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public TextView e;
    public HSImageView f;
    public f g;

    public PoiTagView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PoiTagView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ViewGroup getContentView() {
        return this.a;
    }

    public final f getDataModel() {
        return this.g;
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

    public final void a(f r7, NewProfileUser r8) {
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r8, "user");
        this.g = r7;
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
        o r14 = b.a();
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
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L35:
        return;
    L10:
        if (r12.length() <= 0) goto L12;
        boolean r18 = true;
    L13:
        if (r18 != true) goto L15;
        this.e.setText(r7.b);
        this.e.setTextColor(s1.h(2131106948));
        goto L15
    L12:
        r18 = false;
        goto L13
    }

    public PoiTagView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_POI_TAG, r2, LayoutInflater.from(r2), this, true);
    L6:
        this.a = (ViewGroup) findViewById(2131383269);
        this.b = (ImageView) findViewById(2131383271);
        this.e = (TextView) findViewById(2131383272);
        this.f = findViewById(2131383266);
        this.c = (ImageView) findViewById(2131383270);
        this.d = (ImageView) findViewById(2131383279);
        return;
    L5:
        LayoutInflater.from(r2).inflate(2131567186, this, true);
        goto L6
    }

    public /* synthetic */ PoiTagView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // jt0.c
    public final void b(ProfileTagContent r4, NewProfileUser r5, h r6, jt0.b r7) {
        Intrinsics.checkNotNullParameter(r4, "tagContent");
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r6, "profileContext");
        Intrinsics.checkNotNullParameter(r7, "tagItem");
        ProfilePoiInfo r8 = r5.baseProfileInfo.poiInfo;
        if (r8 == null) goto L5;
        long r0 = r8.getPoiId();
    L7:
        if (r0 > 0) goto L9;
        return;
    L9:
        f r9 = new f(7);
        k r10 = null;
        if (r8 == null) goto L12;
        String r1 = r8.getContent();
    L13:
        r9.b = r1;
        if (r8 == null) goto L16;
        r10 = r8.getIcon();
    L16:
        r9.d = r10;
        String r12 = r9.b;
        if (r12 != null) goto L19;
        return;
    L19:
        if (r12.length() <= 0) goto L21;
        boolean r13 = true;
    L22:
        if (r13 != true) goto L35;
        a(r9, r5);
        ProfileSkin r14 = r5.mProfileSkin;
        if (r14 == null) goto L36;
        ProfileCustomSkin r15 = r14.skin;
        if (r15 == null) goto L37;
        ProfileCustomSkin.TagUI r16 = r15.tagSkin;
        if (r16 == null) goto L38;
        String r17 = r16.wordColor;
        String r18 = r16.backgroundColor;
        if (3 == r9.getType()) goto L32;
        int r19 = m.a;
        m.e(this.b, r17);
    L32:
        int r20 = m.a;
        m.f(this.a, r18);
        m.e(this.e, r17);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L21:
        r13 = false;
        goto L22
    L12:
        r1 = null;
        goto L13
    L5:
        r0 = 0;
        goto L7
    }

    @Override // jt0.c
    public void update(ProfileTagContent r2, NewProfileUser r3, h r4, jt0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        Intrinsics.checkNotNullParameter(r5, "tagItem");
        b(r2, r3, r4, r5);
    }
}
