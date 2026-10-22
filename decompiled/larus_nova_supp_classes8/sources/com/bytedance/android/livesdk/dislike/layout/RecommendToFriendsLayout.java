package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.jm0;
import com.bytedance.android.livesdk.config.m70;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.action.RecommendToFriendsAction;
import com.bytedance.android.livesdk.dislike.m;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdk.dislike.y;
import com.bytedance.android.livesdk.widget.CircleImageView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveLongPressPanelItemConfig;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nt1.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/RecommendToFriendsLayout;", "Landroid/widget/FrameLayout;", "", "getRecommendStatus", "status", "", "setRecommendStatus", "Lcom/bytedance/android/livesdk/dislike/y;", "item", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendToFriendsLayout extends FrameLayout {
    public final TextView a;
    public final TextView b;
    public final CircleImageView c;
    public final HSImageView d;
    public OptionAction e;
    public Disposable f;
    public long g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ RecommendToFriendsLayout a;

        public a(RecommendToFriendsLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            OptionAction r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }
    }

    public RecommendToFriendsLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecommendToFriendsLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final boolean getRecommendStatus() {
        int r0 = RecommendLiveHelper.a;
        boolean r1 = RecommendLiveHelper.g(this.g);
        setRecommendStatus(r1);
        return r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r0 = RecommendLiveHelper.a;
        OptionAction r1 = this.e;
        String r2 = null;
        if (r1 == null) goto L5;
        Room r3 = r1.b;
    L6:
        RecommendToFriendsAction r4 = (RecommendToFriendsAction) r1;
        if (r4 != null) goto L9;
    L11:
        String r5 = "not_shared";
    L12:
        if (r4 == null) goto L18;
        ActionsManager r6 = r4.g;
        if (r6 == null) goto L18;
        m r7 = r6.c;
        if (r7 == null) goto L18;
        r2 = r7.a();
    L18:
        RecommendLiveHelper.i(r3, r5, "long_press", r2);
        return;
    L9:
        if (r4.e != true) goto L11;
        r5 = "shared";
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.f;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    private final void setRecommendStatus(boolean r2) {
        RecommendToFriendsAction r0 = (RecommendToFriendsAction) this.e;
        if (r0 == null) goto L6;
        r0.e = r2;
        return;
    }

    public final void b(boolean r6) {
        CircleImageView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        HSImageView r1 = this.d;
        if (r1 == null) goto L8;
        r1.setVisibility(4);
    L8:
        LiveLongPressPanelItemConfig r2 = m70.a.getValue();
        if (r6 == true) goto L19;
        TextView r3 = this.a;
        if (r3 == null) goto L13;
        r3.setText(2131921932);
    L13:
        if (r2 == null) goto L29;
        String r4 = r2.getLiveRecommendToFriendText();
        if (r4 == null) goto L29;
        TextView r5 = this.a;
        if (r5 == null) goto L29;
        r5.setText(r4);
    L29:
        if (jm0.a.getValue().getEnable() == false) goto L33;
        TextView r7 = this.b;
        if (r7 == null) goto L33;
        r7.setVisibility(0);
    L33:
        if (r2 == null) goto L39;
        String r8 = r2.getLiveRecommendToFriendDetailTextInRoom();
        if (r8 == null) goto L39;
        TextView r9 = this.b;
        if (r9 == null) goto L39;
        r9.setText(r8);
    L39:
        CircleImageView r10 = this.c;
        if (r10 == null) goto L45;
        if (r6 == false) goto L43;
        int r11 = 2131233595;
    L44:
        r10.setImageResource(r11);
        goto L45
    L43:
        r11 = 2131233596;
    L45:
        String r12 = null;
        if (r6 == true) goto L49;
        if (r2 == null) goto L51;
        r12 = r2.getLiveRecommendToFriendIcon();
    L51:
        if (r12 == null) goto L60;
        CircleImageView r13 = this.c;
        if (r13 == null) goto L55;
        r13.setVisibility(4);
    L55:
        HSImageView r14 = this.d;
        if (r14 == null) goto L58;
        r14.setVisibility(0);
    L58:
        ImageLoader.bindImage(this.d, r12);
        return;
    L60:
        return;
    L49:
        if (r2 == null) goto L51;
        r12 = r2.getLiveRecommendToFriendRecommendedIcon();
        goto L51
    L19:
        TextView r15 = this.a;
        if (r15 == null) goto L22;
        r15.setText(2131921924);
    L22:
        if (r2 == null) goto L29;
        String r16 = r2.getLiveRecommendToFriendRecommendedText();
        if (r16 == null) goto L29;
        TextView r17 = this.a;
        if (r17 == null) goto L29;
        r17.setText(r16);
        goto L29
    }

    public final void update(y r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        OptionAction r5 = r4.b;
        this.e = r5;
        if (r5 == null) goto L7;
        Room r6 = r5.b;
        if (r6 == null) goto L7;
        long r0 = r6.getRoomId();
    L8:
        this.g = r0;
        b(getRecommendStatus());
        int r7 = RecommendLiveHelper.a;
        this.f = RecommendLiveHelper.c(this.g, new d(this), "RecommendToFriendsLayout");
        return;
    L7:
        r0 = 0;
        goto L8
    }

    public static final /* synthetic */ void a(RecommendToFriendsLayout r0, boolean r1) {
        r0.setRecommendStatus(r1);
    }

    public RecommendToFriendsLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.inflate(r2, 2131565724, this);
        setOnClickListener(new a(this));
        TextView r5 = (TextView) findViewById(2131388772);
        CircleImageView r6 = null;
        if (r5 == null) goto L5;
        r5.setText(2131921932);
        Unit r7 = Unit.INSTANCE;
    L6:
        this.a = r5;
        CircleImageView r8 = (CircleImageView) findViewById(2131374718);
        if (r8 == null) goto L9;
        r8.setImageResource(2131233596);
        Unit r9 = Unit.INSTANCE;
        r6 = r8;
    L9:
        this.c = r6;
        this.b = (TextView) findViewById(2131363031);
        this.d = findViewById(2131367637);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public /* synthetic */ RecommendToFriendsLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
