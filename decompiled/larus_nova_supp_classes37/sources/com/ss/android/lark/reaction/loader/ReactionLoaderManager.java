package com.ss.android.lark.reaction.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.loader.EmojiImageResource;
import com.ss.android.lark.reaction.widget.flowlayout.reaction.ClickableDrawableSpan$2;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReactionLoaderManager {

    public interface IReactionCallback<Data> extends IGetDataCallback<Data> {
        void onLoading();
    }

    public class a extends SimpleTarget<Drawable> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ImageView c;

        public final void onLoadFailed(Drawable r2) {
            super.onLoadFailed(r2);
            Log.e("ReactionLoaderManager", "loadReaction, load image failed, reactionKey: " + this.a + ", imageKey: " + this.b);
        }

        public final void onResourceReady(Object r3) {
            Drawable r4 = (Drawable) r3;
            Log.i("ReactionLoaderManager", "loadReaction, load image success, reactionKey: " + this.a + ", imageKey: " + this.b + ", resource: " + r4);
            if (r4 == null) goto L6;
            this.c.setImageDrawable(r4);
            return;
        }

        public a(String r1, String r2, ImageView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static class b {
        public static final ReactionLoaderManager a = null;

        static {
            a = new ReactionLoaderManager();
        }
    }

    public ReactionLoaderManager() {
    }

    public static xsb.a a(Context r2, String r3) {
        int r0 = UIUtils.dp2px(r2, k2c.b.b(r3));
        int r4 = UIUtils.dp2px(r2, k2c.b.a(r3));
        if (r0 <= 134) goto L7;
        return new xsb.a(r2, r0, r4);
    L7:
        return new xsb.a(r2, r4, r4);
    }

    public static Bitmap b(String r3, ClickableDrawableSpan$2 r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        Bitmap r0 = qsb.b.a().v1(r3);
        if (r0 == null) goto L8;
        return r0;
    L8:
        qsb.b.a().ge(r3, false, null, r4);
        return null;
    }

    public static void e(ImageView r4, String r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        r4.setImageDrawable(a(r4.getContext(), r5));
        return;
    L8:
        Map<String, Integer> r0 = k2c.b.a;
        Bitmap r1 = qsb.b.a().v1(r5);
        String r2 = qsb.b.a().ub(r5);
        if (r1 == null) goto L12;
        r4.setImageBitmap(r1);
        return;
    L12:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        Log.i("ReactionLoaderManager", "loadReaction, load image start, reactionKey: " + r5 + ", imageKey: " + r2);
        r4.setImageDrawable(a(r4.getContext(), r5));
        ImageLoader.with(r4.getContext()).load(new EmojiImageResource(r2)).diskCacheStrategy(DiskCacheStrategy.RESULT).into(new a(r5, r2, r4));
        return;
    L14:
        Log.i("ReactionLoaderManager", "loadReaction, set default drawable, reactionKey: " + r5);
        r4.setImageDrawable(a(r4.getContext(), r5));
    }

    public final void c(final ImageView r4, final String r5) {
        Map<String, Integer> r0 = k2c.b.a;
        if (r5 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L13;
        e(r4, r5);
        return;
    L13:
        r4.setImageDrawable(a(r4.getContext(), r5));
        final Runnable r2 = new com.ss.android.lark.reaction.loader.a(this, r4, r5);
        IGetDataCallback<Boolean> r6 = new AnonymousClass2(this, r5, r2);
        qsb.b.a().ge(r5, false, r6, null);
        return;
    L5:
        if (qsb.b.a().l4(r5) == false) goto L7;
    L8:
        r1 = true;
        goto L10
    L7:
        if (qsb.b.a().if(r5) == false) goto L9;
        goto L8
    }

    public static void d(AppCompatImageView r2, String r3, IGetDataCallback r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        Bitmap r0 = qsb.b.a().v1(r3);
        if (r0 == null) goto L8;
        r2.setImageBitmap(r0);
        return;
    L8:
        r2.setImageDrawable(a(r2.getContext(), r3));
        qsb.b.a().ge(r3, false, null, r4);
    }
}
