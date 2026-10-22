package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J*\u0010\t\u001a\u00020\u00042\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0007R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/LiveOnlineAvatarView;", "Landroid/widget/FrameLayout;", "", "roomId", "", "setRoomId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "setEnterParamMap", "Lcom/bytedance/android/live/core/widget/HSImageView;", "a", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getAvatarView", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "avatarView", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "getOnClickAvatarCb", "()Lkotlin/jvm/functions/Function0;", "setOnClickAvatarCb", "(Lkotlin/jvm/functions/Function0;)V", "onClickAvatarCb", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveOnlineAvatarView extends FrameLayout {
    public final HSImageView a;
    public Function0<Unit> b;
    public final Paint c;
    public HashMap<String, String> d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HSImageView a;
        public final /* synthetic */ LiveOnlineAvatarView b;
        public final /* synthetic */ String c;

        public a(HSImageView r1, LiveOnlineAvatarView r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Function0<Unit> r4 = this.b.getOnClickAvatarCb();
            if (r4 == null) goto L5;
            Unit r5 = (Unit) r4.invoke();
        L5:
            String r6 = "sslocal://webcast_room?room_id=" + this.c + "&enter_from_merge=chat&enter_method=ktv_friend_live_link";
            IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
            if (r0 == null) goto L9;
            r0.handleSchema(this.a.getContext(), UriProtector.parse(r6));
            return;
        }
    }

    public final HSImageView getAvatarView() {
        return this.a;
    }

    public final Function0<Unit> getOnClickAvatarCb() {
        return this.b;
    }

    public final Paint getPaint() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        float r0 = getMeasuredWidth() / 2;
        r4.drawCircle(r0, getMeasuredHeight() / 2, r0, this.c);
    }

    public final void setEnterParamMap(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.d = r2;
    }

    public final void setOnClickAvatarCb(Function0<Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.ImageView, com.bytedance.android.live.core.widget.HSImageView] */
    public final void setRoomId(String r3) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        ?? r0 = this.a;
        r0.setOnClickListener(new a(r0, this, r3));
    }

    public LiveOnlineAvatarView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        Paint r4 = new Paint();
        r4.setColor(ColorProtector.parseColor("#FF358D"));
        r4.setStyle(Paint.Style.STROKE);
        r4.setTextSize(s1.f(6.0f));
        r4.setStrokeWidth(s1.f(2.0f));
        Unit r0 = Unit.INSTANCE;
        this.c = r4;
        this.a = (HSImageView) View.inflate(r2, 2131567061, this).findViewById(2131363668);
    }
}
