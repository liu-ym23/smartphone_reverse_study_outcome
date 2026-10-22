package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chatbase/view/ChatImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onImageDrawableChangedListener", "Lcom/ss/android/lark/chatbase/view/ChatImageView$OnImageDrawableChangedListener;", "setImageDrawable", BuildConfig.FLAVOR, "drawable", "Landroid/graphics/drawable/Drawable;", "setOnImageDrawableChangedListener", "listener", "OnImageDrawableChangedListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatImageView extends AppCompatImageView {
    public a a;

    public interface a {
    }

    public void setImageDrawable(Drawable r3) {
        super.setImageDrawable(r3);
        a r0 = this.a;
        if (r0 == null) goto L18;
        ChatImageGroup r1 = ((com.ss.android.lark.chatbase.view.a) r0).a;
        int r2 = ChatImageGroup.k;
        r1.getClass();
        if ((r3 instanceof GifDrawable) == false) goto L7;
    L8:
        WeakReference<RecyclerView> r4 = r1.f;
        if (r4 == null) goto L20;
        RecyclerView r5 = r4.get();
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.getScrollState() != 0) goto L15;
        boolean r6 = true;
    L16:
        r1.a(r6);
        return;
    L15:
        r6 = false;
        goto L16
    L20:
        return;
    L7:
        if ((r3 instanceof WebpDrawable) == true) goto L8;
        return;
    }

    public final void setOnImageDrawableChangedListener(a r1) {
        this.a = r1;
    }

    public ChatImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
