package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.popwindow.EmojiPreviewPopWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class FaceNewAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final List<Sticker> a;
    public final Context b;
    public EmojiPreviewPopWindow c;
    public final SparseBooleanArray d;
    public final b e;
    public e f;
    public c g;
    public d h;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final View b;
        public final ImageView c;

        public ViewHolder(View r2) {
            super(r2);
            this.a = (ImageView) r2.findViewById(2131369153);
            this.b = r2.findViewById(2131375021);
            this.c = (ImageView) r2.findViewById(2131379041);
        }
    }

    public class a extends DiffUtil.Callback {
        public final /* synthetic */ List a;
        public final /* synthetic */ FaceNewAdapter b;

        public final int getNewListSize() {
            return this.a.size();
        }

        public final int getOldListSize() {
            return ((ArrayList) this.b.a).size();
        }

        public a(FaceNewAdapter r1, List r2) {
            this.b = r1;
            this.a = r2;
        }

        public final boolean areContentsTheSame(int r2, int r3) {
            return ((Sticker) ListProtector.get(this.b.a, r2)).isContentSame((Sticker) ListProtector.get(this.a, r3));
        }

        public final boolean areItemsTheSame(int r2, int r3) {
            return ((Sticker) ListProtector.get(this.b.a, r2)).isItemSame((Sticker) ListProtector.get(this.a, r3));
        }
    }

    public static class b extends Handler {
        public final WeakReference<FaceNewAdapter> a;

        public b(FaceNewAdapter r2) {
            this.a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r7) {
            FaceNewAdapter r0 = this.a.get();
            if (r0 == null) goto L20;
            View r1 = (View) r7.obj;
            int r8 = r7.getData().getInt("key_sticker_index");
            int r3 = 1;
            r0.d.put(r8, true);
            if (r8 >= ((ArrayList) r0.a).size()) goto L9;
            if (r8 < 0) goto L9;
            Sticker r2 = (Sticker) ListProtector.get(r0.a, r8);
        L10:
            if (r2 == null) goto L21;
            EmojiPreviewPopWindow.b r4 = new EmojiPreviewPopWindow.b(r1, r2.getOriginImageKey());
            r4.e = r2.getDesc();
            int r5 = FacePageNewFragment2.n;
            int r9 = r8 % 4;
            if (r9 != 0) goto L16;
            r3 = 0;
        L18:
            r4.d = r3;
            r4.c = r2.getStickerSetId();
            r0.c.b(r4);
            return;
        L16:
            if (r9 != 3) goto L18;
            r3 = 2;
            goto L18
        L21:
            return;
        L9:
            r2 = null;
            goto L10
        }
    }

    public interface c {
        void a();

        void b(com.ss.android.lark.keyboard.plugin.tool.face.d r1);
    }

    public interface d {
        void a(Context r1, int r2, int r3, String r4, ImageView r5, int r6);
    }

    public interface e {
        com.ss.android.lark.keyboard.plugin.tool.face.d a(String r1, int r2, int r3);
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public FaceNewAdapter(Context r2) {
        this.a = new ArrayList();
        this.d = new SparseBooleanArray();
        this.e = new b(this);
        this.b = r2;
    }

    public final void setData(List<Sticker> r3) {
        if (CollectionUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (this.c == null) goto L8;
        Log.i("FaceNewAdapter", "newEmojiPreviewPopWindow called. destroy");
        EmojiPreviewPopWindow r0 = this.c;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
        EmojiPreviewPopWindow r1 = this.c;
        r1.b = null;
        r1.c = null;
        r1.e = null;
        r1.g = null;
        this.c = null;
    L8:
        EmojiPreviewPopWindow r2 = new EmojiPreviewPopWindow(this.b);
        this.c = r2;
        r2.g = new com.ss.android.lark.keyboard.plugin.tool.face.sticker.a(this);
        DiffUtil.calculateDiff(new a(this, r3)).dispatchUpdatesTo(this);
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r3);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        final ViewHolder r13 = (ViewHolder) r11;
        if (r12 >= ((ArrayList) this.a).size()) goto L7;
        if (r12 < 0) goto L7;
        Sticker r14 = (Sticker) ListProtector.get(this.a, r12);
    L9:
        if (r14 != null) goto L11;
        Log.e("FaceNewAdapter", "onBindViewHolder called. sticker is null.");
        return;
    L11:
        r13.c.setVisibility(8);
        if (r14.getImageSet() == null) goto L14;
        int r6 = UIUtils.dp2px(this.b, 74);
        d r3 = this.h;
        if (r3 == null) goto L20;
        r3.a(this.b, r6, r6, r14.getImageKey(), r13.a, 2131238356);
    L21:
        r13.a.setOnTouchListener(new com.ss.android.lark.keyboard.plugin.tool.face.sticker.b(this, r13));
        r13.a.setOnClickListener(new f(this, r14));
        return;
    L20:
        Log.e("FaceNewAdapter", "onBindViewHolder called. GlideStickerLoader is null.");
        goto L21
    L14:
        if ("-1".equals(r14.getStickerId()) == false) goto L16;
        r13.a.setImageDrawable(null);
        r13.c.setVisibility(0);
        return;
    L16:
        ImageLoader.clear(r13.a);
        r13.a.setImageDrawable(UIHelper.getDrawable(2131235933));
        r13.c.setVisibility(8);
        r13.a.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.face.sticker.c(this));
        return;
    L7:
        r14 = null;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Context r9 = this.b;
        RelativeLayout r10 = new RelativeLayout(r9);
        ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(-2, -2);
        int r1 = UIUtils.dp2px(r9, 15.0f);
        r0.setMargins(r1, r1, r1, r1);
        int r2 = UIUtils.dp2px(r9, 74);
        r10.setGravity(17);
        r10.setLayoutParams(r0);
        ImageView r3 = new ImageView(r9);
        r3.setId(2131369153);
        RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(r2, r2);
        r4.addRule(13, -1);
        r3.setContentDescription(null);
        r3.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r10.addView(r3, r4);
        View r5 = new View(r9);
        r5.setId(2131375021);
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(r2, r2);
        r6.addRule(13, -1);
        r10.addView(r5, r6);
        ImageView r11 = new ImageView(r9);
        r11.setId(2131379041);
        RelativeLayout.LayoutParams r12 = new RelativeLayout.LayoutParams(r2, r2);
        r12.addRule(13, -1);
        r11.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r11.setImageDrawable(UIUtils.getDrawable(r9, 2131238357));
        r11.setVisibility(8);
        r10.addView(r11, r12);
        return new ViewHolder(r10);
    }
}
