package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/ui/OptionNormalView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "tvTitle", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getIvTitleAbout", "()Landroid/widget/ImageView;", "setIvTitleAbout", "(Landroid/widget/ImageView;)V", "ivTitleAbout", "Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton;", "c", "Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton;", "getSwitchButton", "()Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton;", "setSwitchButton", "(Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton;)V", "switchButton", "d", "getTvDesc", "setTvDesc", "tvDesc", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OptionNormalView extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public TextView a;
    public ImageView b;
    public LiveSwitchButton c;
    public TextView d;
    public final CompositeDisposable e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OptionNormalView a;
        public final /* synthetic */ Context b;

        public a(OptionNormalView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (r3.l(this.b) == false) goto L8;
            LiveSwitchButton r2 = this.a.getSwitchButton();
            if (r2 == null) goto L9;
            r2.performClick();
            return;
        L9:
            return;
        }
    }

    public OptionNormalView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OptionNormalView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.e.clear();
    }

    public final ImageView getIvTitleAbout() {
        return this.b;
    }

    public final LiveSwitchButton getSwitchButton() {
        return this.c;
    }

    public final TextView getTvDesc() {
        return this.d;
    }

    public final TextView getTvTitle() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(boolean r3) {
        r3.n(this.c);
        setImportantForAccessibility(1);
        TextView r0 = this.a;
        if (r0 == null) goto L16;
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L17;
        String r2 = r1.toString();
        if (r2 == null) goto L18;
        StringBuilder r4 = new StringBuilder();
        r4.append(r2);
        r4.append(" ");
        if (r3 == false) goto L11;
        String r5 = "开启";
    L12:
        r4.append(r5);
        String r6 = r4.toString();
        if (r6 == null) goto L19;
        setContentDescription(r6);
        return;
    L19:
        return;
    L11:
        r5 = "关闭";
        goto L12
    L18:
        return;
    L17:
        return;
    }

    public final void setIvTitleAbout(ImageView r1) {
        this.b = r1;
    }

    public final void setSwitchButton(LiveSwitchButton r1) {
        this.c = r1;
    }

    public final void setTvDesc(TextView r1) {
        this.d = r1;
    }

    public final void setTvTitle(TextView r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OptionNormalView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        int r7 = UtilityKotlinExtentionsKt.i(16);
        View r8 = LayoutInflater.from(r4).inflate(2131567929, this);
        r8.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        r8.setPadding(0, 0, 0, r7);
        setImportantForAccessibility(1);
        setFocusable(true);
        setClickable(true);
        setOnClickListener(new a(this, r4));
        this.a = (TextView) findViewById(2131390084);
        this.b = (ImageView) findViewById(2131375949);
        this.c = (LiveSwitchButton) findViewById(2131387832);
        this.d = (TextView) findViewById(2131390015);
        this.e = new CompositeDisposable();
    }

    public /* synthetic */ OptionNormalView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
