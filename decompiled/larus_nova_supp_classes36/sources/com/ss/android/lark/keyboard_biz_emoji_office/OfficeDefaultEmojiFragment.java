package com.ss.android.lark.keyboard_biz_emoji_office;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/keyboard_biz_emoji_office/OfficeDefaultEmojiFragment;", "Lcom/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2;", "<init>", "()V", "editTextDependency", "Lcom/ss/android/lark/keyboard_biz_emoji_office/IEditTextDependency;", "setEditTextDependency", "", "dependency", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "createDeleteIcon", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getFirstEmojiCenterToParent", "", "getEmojiHeight", "Companion", "keyboard-biz-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OfficeDefaultEmojiFragment extends EmojiPageNewFragment2 {
    public com.ss.android.lark.keyboard_biz_emoji_office.a u;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ OfficeDefaultEmojiFragment a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(OfficeDefaultEmojiFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r5) {
            OfficeDefaultEmojiFragment r0 = this.a;
            int r1 = 0;
            if (r5 == null) goto L5;
            int r6 = r5.length();
        L6:
            if (r6 <= 0) goto L8;
            boolean r7 = true;
        L9:
            r0.V90().putBoolean("DELETE_ICON_VISIBLE", r7);
            View r2 = ((EmojiPageNewFragment2) r0).e;
            if (r2 == null) goto L16;
            if (r7 == true) goto L14;
            r1 = 8;
        L14:
            r2.setVisibility(r1);
            return;
        L16:
            return;
        L8:
            r7 = false;
            goto L9
        L5:
            r6 = 0;
            goto L6
        }
    }

    static {
    }

    public final int W90() {
        return UIHelper.dp2px(28.0f);
    }

    public final int X90() {
        return UIHelper.dp2px(36.0f);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        Log.i("OfficeEmojiFragment", "onPause");
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Log.i("OfficeEmojiFragment", "onResume");
        Y90();
    }

    public OfficeDefaultEmojiFragment() {
    }

    public final View U90(ConstraintLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ImageView r0 = new ImageView(r4.getContext());
        r0.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(UIHelper.dp2px(58.0f), UIHelper.dp2px(56.0f));
        r5.bottomToBottom = 0;
        r5.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) r5).bottomMargin = UIHelper.dp2px(12.0f);
        r5.setMarginEnd(UIHelper.dp2px(12.0f));
        r0.setLayoutParams(r5);
        r0.setImageResource(2131237787);
        r0.setBackgroundResource(2131231938);
        return r0;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        com.ss.android.lark.keyboard_biz_emoji_office.a r6 = this.u;
        if (r6 == null) goto L15;
        int r0 = 0;
        if (r6.a() <= 0) goto L7;
        boolean r7 = true;
    L8:
        V90().putBoolean("DELETE_ICON_VISIBLE", r7);
        View r1 = ((EmojiPageNewFragment2) this).e;
        if (r1 == null) goto L14;
        if (r7 == true) goto L13;
        r0 = 8;
    L13:
        r1.setVisibility(r0);
    L14:
        r6.d(new b(this));
        goto L15
    L7:
        r7 = false;
    L15:
        Y90();
    }
}
