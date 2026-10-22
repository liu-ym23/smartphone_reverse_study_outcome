package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.popwindow.EmojiPreviewPopWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class StickerPageAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final List<Sticker> a;
    public final Context b;
    public final EmojiPreviewPopWindow c;
    public final SparseBooleanArray d;
    public final a e;
    public d f;
    public b g;
    public c h;
    public e i;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;

        public ViewHolder(View r2) {
            super(r2);
            this.a = (ImageView) r2.findViewById(2131369153);
            this.b = (TextView) r2.findViewById(2131375689);
        }
    }

    public static class a extends Handler {
        public final WeakReference<StickerPageAdapter> a;

        public a(StickerPageAdapter r2) {
            this.a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r7) {
            StickerPageAdapter r0 = this.a.get();
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
            int r5 = StickerPageFragment.s;
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

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public StickerPageAdapter(Context r2) {
        this.a = new ArrayList();
        this.d = new SparseBooleanArray();
        this.e = new a(this);
        this.b = r2;
        EmojiPreviewPopWindow r0 = new EmojiPreviewPopWindow(r2);
        this.c = r0;
        r0.g = new l(this);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        final ViewHolder r14 = (ViewHolder) r12;
        if (r13 >= ((ArrayList) this.a).size()) goto L7;
        if (r13 < 0) goto L7;
        Sticker r15 = (Sticker) ListProtector.get(this.a, r13);
    L9:
        if (r15 != null) goto L11;
        Log.e("StickerPageAdapter", "onBindViewHolder called. sticker is null.");
        return;
    L11:
        r14.b.setText(r15.getDesc());
        int r6 = UIUtils.dp2px(this.b, 50.0f);
        if (this.h == null) goto L20;
        Log.d("StickerPage", "onBindViewHolder " + r15.getThumbnailImageKey());
        e r0 = this.i;
        if (r0 == null) goto L19;
        String r1 = r15.getThumbnailImageKey();
        StickerPageFragment r2 = ((s) r0).a;
        if (((HashMap) r2.j).containsKey(r1) == true) goto L19;
        ((HashMap) r2.j).put(r1, Long.valueOf(System.currentTimeMillis()));
        r2.n++;
    L19:
        ((t) this.h).a(this.b, r6, r6, r15.getThumbnailImageKey(), r14.a, 2131238360, r15.getStickerSetId());
    L21:
        r14.a.setOnTouchListener(new m(this, r14));
        r14.a.setOnClickListener(new p(this, r15));
        return;
    L20:
        Log.e("StickerPageAdapter", "onBindViewHolder called. GlideStickerLoader is null.");
    L7:
        r15 = null;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r12, int r13) {
        Context r14 = r12.getContext();
        int r15 = UIUtils.dp2px(r14, 50);
        LinearLayout r0 = new LinearLayout(r14);
        ViewGroup.LayoutParams r1 = new ViewGroup.MarginLayoutParams(-1, -2);
        r0.setGravity(17);
        r0.setOrientation(1);
        r0.setPadding(0, UIUtils.dp2px(r14, 12.0f), 0, 0);
        r0.setLayoutParams(r1);
        FrameLayout r2 = new FrameLayout(r14);
        ViewGroup.LayoutParams r7 = new LinearLayout.LayoutParams(r15, r15);
        ImageView r16 = new ImageView(r14);
        r16.setId(2131369153);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, -1);
        r16.setImageDrawable(UIUtils.getDrawable(r14, 2131238360));
        r9.gravity = 17;
        r16.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r16.setAdjustViewBounds(true);
        r2.addView(r16);
        View r17 = new View(r14);
        r17.setBackgroundColor(r14.getResources().getColor(2131101951));
        r2.addView(r17, new FrameLayout.LayoutParams(-1, -1));
        r0.addView(r2, r7);
        TextView r18 = new TextView(r14);
        r18.setId(2131375689);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-1, -2);
        int r4 = UIUtils.dp2px(r14, 10.0f);
        r3.setMargins(r4, UIUtils.dp2px(r14, 4.0f), r4, 0);
        r3.gravity = 17;
        r18.setGravity(17);
        r18.setTextColor(UIUtils.getColor(r14, 2131106607));
        r18.setLines(1);
        r18.setEllipsize(TextUtils.TruncateAt.END);
        r18.setTextSize(12.0f);
        r0.addView(r18, r3);
        return new ViewHolder(r0);
    }
}
