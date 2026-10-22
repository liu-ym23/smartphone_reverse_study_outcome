package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LinkSucAnimationView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "Landroid/widget/ImageView;", "guestAvatar", "", "setGuestAvatar", "Landroid/widget/TextView;", "guestName", "setGuestName", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LinkSucAnimationView$a;", "callback", "setCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkSucAnimationView extends HSImageView {
    public static final /* synthetic */ int j = 0;
    public ImageView a;
    public TextView b;
    public IMatchEffect c;
    public String d;
    public py.k e;
    public a f;
    public Function0<Unit> g;
    public boolean h;
    public boolean i;

    public interface a {
        void g();

        void h();
    }

    public static final class b {
    }

    static {
    }

    public LinkSucAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LinkSucAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onDetachedFromWindow() {
        super/*com.facebook.drawee.view.DraweeView*/.onDetachedFromWindow();
        this.h = true;
        this.i = false;
    }

    public static final /* synthetic */ Function0 f(LinkSucAnimationView r1) {
        Function0<Unit> r2 = r1.g;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskEnd");
    L5:
        return r2;
    }

    public final void setCallback(a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        ALogger.i("LinkSucAnimationView", "setCallback, callback=" + r3);
        this.f = r3;
    }

    public final void setGuestAvatar(ImageView r3) {
        Intrinsics.checkNotNullParameter(r3, "guestAvatar");
        ALogger.i("LinkSucAnimationView", "setGuestAvatar, avatar=" + r3);
        this.a = r3;
    }

    public final void setGuestName(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "guestName");
        ALogger.i("LinkSucAnimationView", "setGuestName, guestName=" + r3);
        this.b = r3;
    }

    public LinkSucAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ LinkSucAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
