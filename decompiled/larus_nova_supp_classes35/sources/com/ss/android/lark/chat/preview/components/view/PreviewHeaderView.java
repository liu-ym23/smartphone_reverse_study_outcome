package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreviewHeaderView extends RelativeLayout {
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public TailDrawableTextView a;
    public FrameLayout b;
    public ImageView c;
    public ImageView d;
    public Type e;
    public boolean f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/PreviewHeaderView$Type;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "ONELINE", "NEXLINE", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type NEXLINE = null;
        public static final Type ONELINE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("ONELINE", 0);
            ONELINE = r0;
            Type r1 = new Type("NEXLINE", 1);
            NEXLINE = r1;
            Type[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
        UIHelper.dp2px(12.0f);
        g = UIHelper.dp2px(12.0f);
        UIHelper.dp2px(12.0f);
        h = UIHelper.dp2px(78.0f);
        UIHelper.dp2px(12.0f);
        UIHelper.dp2px(12.0f);
        UIHelper.dp2px(150.0f);
        i = UIHelper.dp2px(8.0f);
        j = UIHelper.dp2px(8.0f);
        k = 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.TextView] */
    public final void a() {
        ImageView r0 = this.d;
        ?? r1 = 0;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r0 = null;
    L6:
        r0.setTranslationY(0.0f);
    L7:
        TailDrawableTextView r2 = this.a;
        if (r2 == null) goto L14;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
    L12:
        r1.setTranslationY(0.0f);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public final ImageView getCopyBtn() {
        Intrinsics.throwUninitializedPropertyAccessException("mCopyBtn");
        return null;
    }

    public final FrameLayout getCustomContainer() {
        FrameLayout r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomContainer");
        return null;
    L6:
        return r0;
    }

    public final ImageView getMoreBtn() {
        ImageView r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
        return null;
    L6:
        return r0;
    }

    public final ImageView getTitleIconView() {
        ImageView r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        return null;
    L6:
        return r0;
    }

    public final TailDrawableTextView getTitleView() {
        TailDrawableTextView r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        return null;
    L6:
        return r0;
    }

    public final Type getType() {
        return this.e;
    }

    public PreviewHeaderView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        View.inflate(r2, 2131559899, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [android.widget.TextView] */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        super.onLayout(r8, r9, r10, r11, r12);
        AppCompatTextView r13 = this.a;
        if (r13 != null) goto L5;
    L56:
        a();
        return;
    L5:
        if (this.d == null) goto L56;
        if (this.f == false) goto L56;
        Layout r14 = r13.getLayout();
        if (r14 == null) goto L55;
        AppCompatTextView r15 = this.a;
        ?? r16 = 0;
        if (r15 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r15 = null;
    L15:
        if (r15.getLineCount() == 0) goto L55;
        ImageView r17 = this.d;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r17 = null;
    L20:
        if (r17.getHeight() == 0) goto L55;
        int r0 = r14.getLineBottom(0) - r14.getLineTop(0);
        int r18 = c.a;
        AppCompatTextView r19 = this.a;
        if (r19 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r19 = null;
    L25:
        int r20 = r19.getLineCount();
        AppCompatTextView r21 = this.a;
        if (r21 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r21 = null;
    L28:
        int r22 = r21.getTop();
        AppCompatTextView r1 = this.a;
        if (r1 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r1 = null;
    L31:
        int r2 = r1.getHeight();
        ImageView r3 = this.d;
        if (r3 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r3 = null;
    L34:
        int r4 = r3.getTop();
        ImageView r5 = this.d;
        if (r5 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r5 = null;
    L37:
        int r6 = r5.getHeight();
        if (r20 <= 1) goto L42;
        if (r6 <= r0) goto L41;
        c.a r23 = new c.a(r22 - r4, 0.0f);
    L47:
        ImageView r24 = this.d;
        if (r24 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r24 = null;
    L50:
        r24.setTranslationY(r23.a);
        TailDrawableTextView r25 = this.a;
        if (r25 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
    L54:
        r16.setTranslationY(r23.b);
        return;
    L53:
        r16 = r25;
        goto L54
    L41:
        c.a r7 = new c.a((r22 + (r0 / 2.0f)) - (r4 + (r6 / 2.0f)), 0.0f);
    L46:
        r23 = r7;
        goto L47
    L42:
        float r26 = r22 + (r2 / 2.0f);
        float r27 = r4 + (r6 / 2.0f);
        if (r6 < r2) goto L45;
        r7 = new c.a(0.0f, r27 - r26);
        goto L46
    L45:
        r7 = new c.a(r26 - r27, 0.0f);
    L55:
        a();
    }
}
