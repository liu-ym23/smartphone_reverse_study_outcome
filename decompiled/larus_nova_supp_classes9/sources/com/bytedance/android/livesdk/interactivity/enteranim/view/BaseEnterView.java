package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/enteranim/view/BaseEnterView;", "Landroid/widget/LinearLayout;", BuildConfig.FLAVOR, "getLayoutResource", "Lcom/bytedance/android/livesdk/interactivity/enteranim/view/e;", "listener", BuildConfig.FLAVOR, "setDrawingCacheListener", "Lk32/a;", "msg", "setUI", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseEnterView extends LinearLayout {
    public HSImageView a;
    public NoMoreSpaceTextView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public View f;
    public e g;

    public static final class a implements ImageUtil.LoadImageCallback {
        public final /* synthetic */ BaseEnterView a;

        public final void onFailed(Exception r1) {
        }

        public a(BaseEnterView r1) {
            this.a = r1;
        }

        public final void onSuccess(Bitmap r2) {
            if (r2 == null) goto L10;
            HSImageView r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.setImageBitmap(r2);
        L6:
            this.a.invalidate();
            BaseEnterView r3 = this.a;
            e r1 = r3.g;
            if (r1 == null) goto L11;
            ((UserEnterLevelView) r1).e(r3);
            return;
        L11:
            return;
        }
    }

    public BaseEnterView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseEnterView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getLayoutResource() {
        return 2131567622;
    }

    public final void setDrawingCacheListener(e r1) {
        this.g = r1;
    }

    public final void setUI(k32.a r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        int r0 = r6.h;
        String r1 = r6.b;
        TextView r2 = this.c;
        if (r2 == null) goto L6;
        r2.setText(r1);
    L6:
        if (r0 == 2) goto L16;
        TextView r3 = this.d;
        if (r3 == null) goto L10;
        r3.setText(2131916479);
    L10:
        TextView r4 = this.c;
        if (r4 == null) goto L13;
        r4.setTextColor(getResources().getColor(2131108470));
    L13:
        TextView r5 = this.d;
        if (r5 == null) goto L26;
        r5.setTextColor(getResources().getColor(2131108470));
    L26:
        if (r0 == 0) goto L40;
        if (r0 == 2) goto L34;
        View r7 = this.f;
        if (r7 == null) goto L31;
        r7.setBackgroundResource(2131250027);
    L31:
        ImageView r8 = this.e;
        if (r8 == null) goto L46;
        r8.setBackgroundResource(2131251527);
    L46:
        HSImageView r9 = this.a;
        if (r9 == null) goto L49;
        r9.setVisibility(0);
    L49:
        NoMoreSpaceTextView r10 = this.b;
        if (r10 == null) goto L52;
        r10.setVisibility(8);
    L52:
        if (r0 != 0) goto L56;
        HSImageView r11 = this.a;
        if (r11 == null) goto L58;
        r11.setBackgroundResource(2131251604);
        return;
    L58:
        return;
    L56:
        ImageLoader.loadBitmapSynchronized(r6.g, 0, 0, new a(this));
        return;
    L34:
        View r13 = this.f;
        if (r13 == null) goto L37;
        r13.setBackgroundResource(2131250026);
    L37:
        ImageView r14 = this.e;
        if (r14 == null) goto L46;
        r14.setBackgroundResource(2131251526);
        goto L46
    L40:
        View r15 = this.f;
        if (r15 == null) goto L43;
        r15.setBackgroundResource(2131250028);
    L43:
        ImageView r16 = this.e;
        if (r16 == null) goto L46;
        r16.setBackgroundResource(2131251527);
        goto L46
    L16:
        TextView r17 = this.d;
        if (r17 == null) goto L19;
        r17.setText(2131916478);
    L19:
        TextView r18 = this.c;
        if (r18 == null) goto L22;
        r18.setTextColor(getResources().getColor(2131108469));
    L22:
        TextView r19 = this.d;
        if (r19 == null) goto L26;
        r19.setTextColor(getResources().getColor(2131108469));
        goto L26
    }

    public BaseEnterView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(getLayoutResource(), this);
        this.f = findViewById(2131363982);
        this.b = findViewById(2131363840);
        this.a = findViewById(2131374501);
        this.c = (TextView) findViewById(2131392055);
        this.d = (TextView) findViewById(2131368866);
        this.e = (ImageView) findViewById(2131387192);
    }

    public /* synthetic */ BaseEnterView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
