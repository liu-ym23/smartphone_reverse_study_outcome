package com.bytedance.android.live.effect.soundeffect;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.popup.LiveRepelPopupRegion;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/LiveSoundAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/soundeffect/LiveSoundAdapter$ViewHolder;", "Lcom/bytedance/android/live/effect/soundeffect/LiveSoundEffectHelper$b;", "Lcom/bytedance/android/livesdkapi/depend/handler/WeakHandler$IHandler;", "a", "ViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSoundAdapter extends RecyclerView.Adapter<ViewHolder> implements LiveSoundEffectHelper.b, WeakHandler.IHandler {
    public Context a;
    public final LiveSoundEffectHelper b;
    public List<Sticker> c;
    public final int d;
    public final WeakHandler e;
    public int f;
    public yo2.f g;
    public final LiveEffectContextFactoryDelegate$Type h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/LiveSoundAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final View b;
        public final View c;
        public final View d;
        public final View e;
        public final HollowCircleProgressView f;
        public final TextView g;
        public final View h;
        public final View i;
        public boolean j;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131376297);
            this.b = r2.findViewById(2131374726);
            this.c = r2.findViewById(2131364149);
            this.d = r2.findViewById(2131376387);
            this.e = r2.findViewById(2131376189);
            this.f = (HollowCircleProgressView) r2.findViewById(2131378977);
            this.g = (TextView) r2.findViewById(2131391493);
            this.h = r2.findViewById(2131384112);
            this.i = r2.findViewById(2131375835);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void onError() {
        f2.b(2131916385, 0);
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        return this.c.size();
    }

    public final Sticker z2() {
        int r0 = this.c.size();
        int r1 = this.f;
        if (r1 < 0) goto L8;
        if (r0 <= r1) goto L8;
        return (Sticker) ListProtector.get(this.c, r1);
    L8:
        ALogger.e("ttlive_anchor_effect_LiveSoundAdapter", "selectIndex illegal, index:" + this.f + ",length = " + this.c.size());
        return null;
    }

    public LiveSoundAdapter(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.h = r2;
        this.b = null;
        this.c = new ArrayList();
        this.d = 2131565908;
        this.e = new WeakHandler(this);
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void a(Sticker r5) {
        Intrinsics.checkNotNullParameter(r5, "sticker");
        Sticker.Companion.equals(r5, null);
        int r0 = this.c.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (Sticker.Companion.equals(r5, (Sticker) ListProtector.get(this.c, r1)) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        ListProtector.set(this.c, r1, r5);
    L9:
        if (r1 < 0) goto L15;
        notifyItemChanged(r1);
        Sticker r6 = (Sticker) ListProtector.get(this.c, r1);
        LiveSoundEffectHelper r2 = this.b;
        if (r2 == null) goto L13;
        int r3 = LiveSoundEffectHelper.h;
        r2.b(r6, true, true);
    L13:
        notifyDataSetChanged();
        return;
    L15:
        ALogger.e("ttlive_anchor_effect_LiveSoundAdapter", "soundItemList:ArrayIndexOutOfBounds,length = " + this.c.size() + ", index = " + r1 + ", stickerId = " + r5.getId());
        return;
    L8:
        r1 = -1;
        goto L9
    }

    public final void handleMsg(Message r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.what != 0) goto L12;
        yo2.f r2 = this.g;
        if (r2 == null) goto L9;
        r2.d();
    L9:
        this.g = null;
        return;
    }

    public static final void y2(LiveSoundAdapter r11, ViewHolder r12) {
        r11.e.removeMessages(0);
        yo2.f r0 = r11.g;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        r11.g = null;
        int r2 = yo2.f.x;
        Context r3 = r11.a;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L8:
        LiveRepelPopupRegion r4 = LiveRepelPopupRegion.ROOM_BOTTOM;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "region");
        yo2.f r5 = new yo2.f(r3);
        ((yo2.d) r5).d = null;
        ((yo2.d) r5).e = 2131565924;
        ((yo2.d) r5).l = true;
        r5.a();
        r11.g = r5;
        r5.i(r12.i, 1, 3, s1.f(55.0f) * (-1), 0);
        Message r13 = new Message();
        r13.what = 0;
        r11.e.sendMessageDelayed(r13, 3000);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        ViewHolder r8 = (ViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "viewholer");
        Sticker r9 = (Sticker) ListProtector.get(this.c, r7);
        UrlModel r0 = r9.getIcon();
        if (r0 == null) goto L5;
        ImageUtil.loadImage(r8.a, r0.toImgModel(), 0);
    L5:
        LiveEffectContextFactoryDelegate$Type r1 = this.h;
        Map<String, Long> r2 = h.a;
        Intrinsics.checkNotNullParameter(r9, "sticker");
        Intrinsics.checkNotNullParameter(r1, "type");
        h.c(r9, "live_take_voice_show", r1);
        r8.g.setText(r9.getName());
        if (r9.isDownloaded() == false) goto L8;
        r8.e.setVisibility(8);
        r8.f.setVisibility(8);
    L10:
        if (this.b != null) goto L12;
    L14:
        boolean r3 = Sticker.Companion.equals(z2(), r9);
        TextView r4 = r8.g;
        if (r3 == false) goto L17;
        int r5 = 2131108348;
    L18:
        r4.setTextColor(s1.h(r5));
        View r11 = r8.c;
        if (r3 == false) goto L21;
        int r12 = 0;
    L22:
        r11.setVisibility(r12);
        if (Lists.isEmpty(r9.getTags()) == true) goto L26;
        List r13 = r9.getTags();
        Intrinsics.checkNotNull(r13);
        if (r13.contains("new") == false) goto L26;
    L27:
        r8.b.setOnClickListener(new com.bytedance.android.live.effect.soundeffect.a(this, r8));
        r8.b.setOnLongClickListener(new b(this, r8));
        r8.b.setOnTouchListener(new c(this, r8));
        r8.setIsRecyclable(false);
        return;
    L26:
        r8.h.setVisibility(8);
        goto L27
    L21:
        r12 = 8;
        goto L22
    L17:
        r5 = 2131108399;
        goto L18
    L12:
        if (LiveSoundEffectHelper.a(r9) != true) goto L14;
        r8.e.setVisibility(8);
        r8.f.setVisibility(8);
        goto L14
    L8:
        r8.e.setVisibility(0);
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        this.a = r4.getContext();
        return new ViewHolder(LayoutInflater.from(r4.getContext()).inflate(this.d, r4, false));
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void x1(int r1, ViewHolder r2) {
        if (r2 == null) goto L7;
        HollowCircleProgressView r3 = r2.f;
        if (r3 == null) goto L8;
        r3.setProgress(r1);
        return;
    L8:
        return;
    }
}
