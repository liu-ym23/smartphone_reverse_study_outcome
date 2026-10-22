package com.bytedance.android.live.profile.standard.tag.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jt0.b;
import jt0.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profile/standard/tag/view/StandardTagView;", "Landroid/widget/FrameLayout;", "Ljt0/c;", "Lcom/bytedance/android/live/base/model/user/ProfileTagContent;", "tagContent", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "Lcom/bytedance/android/live/profile/ui/base/h;", "profileContext", "Ljt0/b;", "tagItem", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StandardTagView extends FrameLayout implements c {
    public final ViewGroup a;

    public static final class a {
    }

    static {
    }

    public StandardTagView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StandardTagView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public StandardTagView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_TAG, r2, LayoutInflater.from(r2), this, true);
    L6:
        this.a = (ViewGroup) findViewById(2131383258);
        return;
    L5:
        LayoutInflater.from(r2).inflate(2131567191, this, true);
        goto L6
    }

    public /* synthetic */ StandardTagView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // jt0.c
    public final void b(ProfileTagContent r22, NewProfileUser r23, h r24, b r25) {
        Intrinsics.checkNotNullParameter(r22, "tagContent");
        Intrinsics.checkNotNullParameter(r23, "user");
        Intrinsics.checkNotNullParameter(r24, "profileContext");
        Intrinsics.checkNotNullParameter(r25, "tagItem");
        a5 r6 = r22.tagContent;
        boolean r3 = r25.e(r22, r23, r24);
        Drawable r9 = null;
        if (r6 == null) goto L95;
        ViewGroup r12 = this.a;
        if (r12 == null) goto L95;
        Intrinsics.checkNotNullParameter(r12, "container");
        Intrinsics.checkNotNullParameter(r6, "tagContent");
        ArrayList r13 = new ArrayList();
        List r0 = r6.getPieces();
        if (r0 == null) goto L87;
        Iterator r5 = r0.iterator();
    L11:
        if (r5.hasNext() == false) goto L87;
        c5 r1 = (c5) r5.next();
        if (r1 == null) goto L11;
        int r7 = r1.getType();
        if (r7 == PieceType.STRING.getPieceType()) goto L17;
        if (r7 != PieceType.IMAGE.getPieceType()) goto L11;
        ITextPieceImage r2 = r1.getImageValue();
        if (r2 == null) goto L58;
        k r8 = r2.getImageModel();
    L59:
        if (r8 == null) goto L83;
        HSImageView r14 = new HSImageView(getContext());
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r8.getWidth()), UtilityKotlinExtentionsKt.i(r8.getHeight()));
        r4.gravity = 16;
        Unit r15 = Unit.INSTANCE;
        r12.addView(r14, r4);
        k.b r10 = r8.getImageContent();
        if (r10 == null) goto L64;
        String r16 = r10.getFontColor();
    L65:
        if (r16 != null) goto L67;
    L70:
        boolean r17 = true;
    L71:
        if (r17 == false) goto L125;
    L80:
        ImageLoader.bindImage(r14, r8);
        r14.setImportantForAccessibility(2);
        k.b r18 = r8.getImageContent();
        if (r18 == null) goto L83;
        String r19 = r18.getAccessibilityText();
    L84:
        if (r19 == null) goto L11;
        r13.add(r19);
        goto L11
    L125:
        k.b r20 = r8.getImageContent();     // Catch: Exception -> L78
        if (r20 == null) goto L75;
        String r26 = r20.getFontColor();     // Catch: Exception -> L78
    L76:
        r14.setColorFilter(Color.parseColor(r26));     // Catch: Exception -> L78
        goto L80
    L75:
        r26 = null;
    L78:
        e = move-exception;
        ALogger.e("StandardTagView", "parse image color error: " + e.getMessage());
        goto L80
    L67:
        if (r16.length() == 0) goto L70;
        r17 = false;
        goto L71
    L64:
        r16 = null;
    L83:
        r19 = null;
        goto L84
    L58:
        r8 = null;
        goto L59
    L17:
        String r27 = r1.getStringValue();
        b5 r28 = r1.getFormat();
        if (r27 != null) goto L20;
        r27 = null;
    L51:
        if (r27 == null) goto L11;
        r13.add(r27);
        goto L11
    L20:
        TextView r110 = new TextView(getContext());
        r110.setText(r27);
        r110.setTextColor(ColorProtector.parseColor("#7F161823"));
        r110.setTextSize(1, 10.0f);
        r110.setGravity(17);
        if (r28 != null) goto L121;
        int r111 = 0;
    L26:
        if (r111 <= 0) goto L28;
        r110.setTextSize(1, r111);     // Catch: Exception -> L23
    L28:
        if (r28 == null) goto L30;
        int r112 = r28.getWeight();     // Catch: Exception -> L23
    L32:
        if (r112 < 700) goto L34;
        r110.setTypeface(Typeface.defaultFromStyle(1));     // Catch: Exception -> L23
    L34:
        if (r28 == null) goto L36;
        String r113 = r28.getColor();     // Catch: Exception -> L23
    L37:
        if (r113 != null) goto L39;
    L42:
        boolean r114 = true;
    L43:
        if (r114 == true) goto L50;
        if (r28 == null) goto L46;
        String r29 = r28.getColor();     // Catch: Exception -> L23
    L47:
        r110.setTextColor(Color.parseColor(r29));     // Catch: Exception -> L23
        goto L50
    L46:
        r29 = null;
    L50:
        r110.setImportantForAccessibility(2);
        r12.addView(r110, new ViewGroup.LayoutParams(-2, -2));
        goto L51
    L39:
        if (r113.length() == 0) goto L42;
        r114 = false;
        goto L43
    L36:
        r113 = null;
        goto L37
    L30:
        r112 = 0;
        goto L32
    L121:
        r111 = r28.getFontSize();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        ALogger.e("StandardTagView", "parse String piece error: " + e.getMessage());
    L87:
        if (r13.isEmpty() == false) goto L89;
        String r30 = null;
    L90:
        if (r30 == null) goto L95;
        if (r3 == false) goto L93;
        r30 = r30 + s1.B(2131921721);
    L93:
        setContentDescription(r30);
        goto L95
    L89:
        r30 = CollectionsKt.joinToString$default(r13, ",", null, null, 0, null, null, 62, null);
    L95:
        if (r22.isBgPicture == false) goto L102;
        ViewGroup r32 = this.a;
        if (r32 == null) goto L99;
        r32.setPadding(0, 0, 0, 0);
    L99:
        ViewGroup r33 = this.a;
        if (r33 == null) goto L141;
        r33.setBackgroundColor(0);
        return;
    L141:
        return;
    L102:
        ProfileTagContent.BgColor r34 = r22.bgColor;
        if (r34 == null) goto L105;
        String r35 = r34.bgColorStart;
    L106:
        if (r34 == null) goto L108;
        String r36 = r34.bgColorEnd;
    L123:
        int r37 = Color.parseColor(r35);     // Catch: Exception -> L118
        int r38 = Color.parseColor(r36);     // Catch: Exception -> L118
        ViewGroup r39 = this.a;     // Catch: Exception -> L118
        if (r39 == null) goto L113;
        r9 = r39.getBackground();     // Catch: Exception -> L118
    L113:
        if ((r9 instanceof GradientDrawable) == false) goto L143;
        r9.mutate();     // Catch: Exception -> L118
        ((GradientDrawable) r9).setShape(0);     // Catch: Exception -> L118
        ((GradientDrawable) r9).setGradientType(0);     // Catch: Exception -> L118
        ((GradientDrawable) r9).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L118
        ((GradientDrawable) r9).setColors(new int[]{r37, r38});     // Catch: Exception -> L118
        ViewGroup r40 = this.a;     // Catch: Exception -> L118
        if (r40 == null) goto L144;
        r40.setBackground(r9);     // Catch: Exception -> L118
        return;
    L144:
        return;
    L143:
        return;
    L118:
        e = move-exception;
        ALogger.e("StandardTagView", "paint background error: " + e.getMessage());
        return;
    L108:
        r36 = null;
        goto L123
    L105:
        r35 = null;
        goto L106
    }

    @Override // jt0.c
    public void update(ProfileTagContent r5, NewProfileUser r6, h r7, b r8) {
        Intrinsics.checkNotNullParameter(r5, "tagContent");
        Intrinsics.checkNotNullParameter(r6, "user");
        Intrinsics.checkNotNullParameter(r7, "profileContext");
        Intrinsics.checkNotNullParameter(r8, "tagItem");
        ViewGroup r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.a;
        if (r1 == null) goto L8;
        r1.setPadding(UtilityKotlinExtentionsKt.i(6), 0, UtilityKotlinExtentionsKt.i(6), 0);
    L8:
        ViewGroup r2 = this.a;
        if (r2 == null) goto L11;
        r2.setBackgroundResource(2131249768);
    L11:
        b(r5, r6, r7, r8);
    }
}
