package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0007J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0016H\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmSubtitleSpeakerAvatarView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scdAvatarDrawableCache", "Landroid/util/SparseArray;", "Landroid/graphics/drawable/Drawable;", "avatarImageView", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "scdAvatarContainer", "Landroid/view/View;", "scdLabel", "Landroid/widget/TextView;", "userInfoHelper", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/user/IMmUserInfoHelper;", "meetingId", "", "setUserInfoHelper", "", "helper", "bind", "avatar", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmDisplayAvatar;", "sizePx", "bindAvatarKey", "key", "userId", "bindAvatarUrl", "url", "bindPlaceholder", "avatarPlaceholderResId", "bindScdAvatar", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSubtitleSpeakerAvatarView extends FrameLayout {
    public final SparseArray<Drawable> a;
    public final LKUIRoundedImageView b;
    public final View c;
    public final TextView d;
    public com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a e;

    public MmSubtitleSpeakerAvatarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmSubtitleSpeakerAvatarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int a() {
        com.ss.android.lark.officesdk.minutes.ui.style.e r0 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r1 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(getContext());
        r0.getClass();
        return com.ss.android.lark.officesdk.minutes.ui.style.e.b(r1).getDrawable().k();
    }

    public final void b(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "avatar");
        int r2 = 1;
        if ((r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.C0046b) == false) goto L14;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.C0046b r14 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.C0046b) r12;
        String r5 = r14.a;
        String r6 = r14.b;
        this.c.setVisibility(8);
        this.b.setVisibility(0);
        int r10 = a();
        if (r5.length() == 0) goto L8;
        r2 = 0;
    L8:
        if (r2 == 0) goto L10;
        this.b.setImageResource(r10);
        return;
    L10:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a r15 = this.e;
        if (r15 == null) goto L73;
        r15.b(this.b, new com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.b(r5, r6, r13, r13, r10, r10));
        return;
    L73:
        return;
    L14:
        if ((r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.d) == false) goto L26;
        String r7 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.d) r12).a;
        this.c.setVisibility(8);
        this.b.setVisibility(0);
        int r9 = a();
        if (r7.length() == 0) goto L19;
        r2 = 0;
    L19:
        if (r2 == 0) goto L21;
        this.b.setImageResource(r9);
        return;
    L21:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a r16 = this.e;
        if (r16 == null) goto L24;
        r16.a(this.b, new com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.c(r7, r13, r13, r9, r9));
        return;
    L24:
        this.b.setImageResource(r9);
        return;
    L26:
        if ((r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.e) == false) goto L67;
        String r17 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.e) r12).a;
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        if (this.d.getVisibility() == 8) goto L30;
        this.d.setVisibility(8);
    L30:
        int r18 = fwb.a.a;
        Drawable r19 = null;
        if (r17 != null) goto L33;
    L35:
        boolean r0 = false;
    L36:
        if (r0 == true) goto L43;
        if (r17 == null) goto L42;
        Integer r110 = StringsKt.toIntOrNull(r17);
        if (r110 == null) goto L42;
        r2 = r110.intValue();
    L42:
        r2 = 0;
    L43:
        int r3 = r2 % 10;
        if (r3 == 0) goto L55;
        switch(r3) {
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L50;
            case 7: goto L49;
            case 8: goto L48;
            case 9: goto L47;
            default: goto L46;
        };
    L46:
        int r111 = 2131244758;
    L56:
        Drawable r1 = this.a.get(r111);
        if (r1 != null) goto L61;
        r1 = ContextCompat.getDrawable(getContext(), r111);
        if (r1 == null) goto L62;
        this.a.put(r111, r1);
    L62:
        if (r19 != null) goto L64;
        return;
    L64:
        if (this.c.getBackground() == r19) goto L79;
        this.c.setBackground(r19);
        return;
    L79:
        return;
    L61:
        r19 = r1;
        goto L62
    L47:
        r111 = 2131244767;
        goto L56
    L48:
        r111 = 2131244766;
        goto L56
    L49:
        r111 = 2131244765;
        goto L56
    L50:
        r111 = 2131244764;
        goto L56
    L51:
        r111 = 2131244763;
        goto L56
    L52:
        r111 = 2131244762;
        goto L56
    L53:
        r111 = 2131244761;
        goto L56
    L54:
        r111 = 2131244760;
        goto L56
    L55:
        r111 = 2131244759;
        goto L56
    L33:
        if (StringsKt.startsWith$default(r17, "-", false, 2, null) != true) goto L35;
        r0 = true;
        goto L36
    L67:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.c.a) == false) goto L71;
        this.c.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(a());
        return;
    L71:
        throw new NoWhenBranchMatchedException();
    }

    public MmSubtitleSpeakerAvatarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new SparseArray();
        LKUIRoundedImageView r5 = new LKUIRoundedImageView(r2);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r5.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r5.setOval(true);
        this.b = r5;
        addView(r5);
        View r6 = LayoutInflater.from(r2).inflate(2131564100, this, false);
        Intrinsics.checkNotNull(r6);
        this.c = r6;
        this.d = (TextView) r6.findViewById(2131385145);
        r6.setVisibility(8);
        addView(r6);
    }

    public /* synthetic */ MmSubtitleSpeakerAvatarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
