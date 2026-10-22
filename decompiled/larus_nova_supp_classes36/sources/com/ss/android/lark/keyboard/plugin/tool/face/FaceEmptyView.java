package com.ss.android.lark.keyboard.plugin.tool.face;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/FaceEmptyView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "init", "", "createView", "Landroid/view/View;", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FaceEmptyView extends LinearLayout {
    public FaceEmptyView(Context r2) {
        this(r2, null);
    }

    public FaceEmptyView(Context r2, AttributeSet r3) {
        this(r2, r3, -1);
    }

    public FaceEmptyView(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7, -1);
        Context r8 = getContext();
        LinearLayout r9 = new LinearLayout(r8);
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.gravity = 17;
        r9.setGravity(17);
        r9.setOrientation(1);
        addView(r9, r10);
        ImageView r11 = new ImageView(r8);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(UIUtils.dp2px(r8, 74.0f), UIUtils.dp2px(r8, 74.0f));
        r11.setImageDrawable(y9c.d.e(r8, 2131235933));
        r9.addView(r11, r1);
        TextView r12 = new TextView(r8);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.topMargin = UIUtils.dp2px(r8, 10.0f);
        r12.setText(UIUtils.getString(r8, 2131891603));
        r12.setTextColor(UIUtils.getColor(r8, 2131103456));
        r12.setTextSize(2, 12.0f);
        r9.addView(r12, r2);
    }
}
