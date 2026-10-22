package com.larus.voicecall.impl.subtitle;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.call.subtitle.DisplayType;
import com.larus.av_call.constant.ThemeType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common_ui.widget.CustomCircularProgressBar;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerAsrBinding;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerSubtitleBlockBinding;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerSubtitleTextBinding;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerSubtitleTitleBinding;
import com.larus.voicecall.impl.databinding.LarusSubtitleHolderSingleImageBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxTemplateRender;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0018\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bH\u0016J\u0006\u0010)\u001a\u00020!J\u0006\u0010*\u001a\u00020!J\u000e\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u001bJ\u000e\u0010-\u001a\u00020!2\u0006\u0010,\u001a\u00020\u001bJ\u0010\u0010.\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "list", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "selectCallBack", "Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "imgUploadListener", "Lcom/larus/voicecall/impl/subtitle/ISubtitleImageUploadListener;", "paramsProvider", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;", "actionProvider", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;", "<init>", "(Lcom/larus/av_call/constant/ThemeType;Ljava/util/List;Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;Lcom/larus/voicecall/impl/subtitle/ISubtitleImageUploadListener;Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;)V", "getThemeType", "()Lcom/larus/av_call/constant/ThemeType;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "lastBlockHolder", "Lcom/larus/voicecall/impl/subtitle/SubtitleBlockHolder;", "lastInsertPosition", NameKeys.UnloadStrategy_No_Strategy, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onInterrupt", NameKeys.UnloadStrategy_No_Strategy, "type", NameKeys.UnloadStrategy_No_Strategy, "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "insert", "refresh", "delete", "inDataIndex", LynxTemplateRender.RENDER_PHASE_UPDATE, "onViewDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSubtitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final ThemeType a;
    public final List<c> b;
    public final u1 c;
    public final h d;
    public final f e;
    public final g f;
    public SubtitleBlockHolder g;
    public int h;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size() + 2;
    }

    public final void insert() {
        int r0 = this.b.size();
        this.h = r0;
        notifyItemInserted(r0);
        SubtitleBlockHolder r1 = this.g;
        if (r1 == null) goto L7;
        c r2 = r1.e;
        if (r2 == null) goto L7;
        r1.T3(r2, false);
    L7:
        this.g = null;
    }

    public final void delete(int r4) {
        FLogger.a.i("RealtimeCallSubtitleAdapter", "delete at data list。 pos=" + r4);
        int r5 = r4 + 1;
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (r5 >= getItemCount()) goto L10;
        notifyItemRemoved(r5);
        return;
    }

    public final int getItemViewType(int r4) {
        c r0 = (c) com.larus.audio.call.util.n.a(this.b, r4 - 1);
        if (r0 == null) goto L5;
        DisplayType r1 = r0.c;
    L6:
        if (r4 != 0) goto L9;
        return 101;
    L9:
        if (r4 != (getItemCount() - 1)) goto L12;
        return 102;
    L12:
        if (r1 != DisplayType.SCENE_MODE) goto L15;
        return 104;
    L15:
        if (r1 != DisplayType.QUERY) goto L18;
        return 105;
    L18:
        if (r1 != DisplayType.QUERY_IMAGE) goto L21;
        return 106;
    L21:
        if (r1 == DisplayType.REPLY_BLOCK) goto L23;
    L25:
        return 103;
    L23:
        if (r0.b == null) goto L25;
        return 107;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        String r1 = null;
        if (Intrinsics.areEqual(r4, this.g) == false) goto L6;
        this.g = null;
    L6:
        if ((r4 instanceof RealtimeCallTTSSubtitleHolder) == false) goto L8;
        RealtimeCallTTSSubtitleHolder r0 = (RealtimeCallTTSSubtitleHolder) r4;
    L9:
        if (r0 == null) goto L15;
        ObjectAnimator r2 = r0.d;
        if (r2 == null) goto L13;
        r2.cancel();
    L13:
        r0.d = null;
    L15:
        if ((r4 instanceof SubtitleSingleImageHolder) == false) goto L17;
        SubtitleSingleImageHolder r3 = (SubtitleSingleImageHolder) r4;
    L18:
        if (r3 == null) goto L28;
        com.larus.bmhome.upload.audio.g r5 = com.larus.bmhome.upload.audio.g.a;
        c r6 = r3.d;
        if (r6 == null) goto L24;
        x3a.a r7 = r6.i;
        if (r7 == null) goto L24;
        r1 = r7.e;
    L24:
        if (r1 != null) goto L26;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L26:
        Intrinsics.checkNotNullParameter(r1, "imgKey");
        com.larus.bmhome.upload.audio.g.b.remove(r1);
    L28:
        if ((r4 instanceof SubtitleBlockHolder) == false) goto L31;
        SubtitleBlockHolder r8 = (SubtitleBlockHolder) r4;
        return;
    L31:
        return;
    L17:
        r3 = null;
        goto L18
    L8:
        r0 = null;
        goto L9
    }

    public final void update(int r4) {
        int r5 = r4 + 1;
        if (r5 >= 0) goto L5;
    L9:
        FLogger.a.e("RealtimeCallSubtitleAdapter", "index " + r5 + " is out of range");
        return;
    L5:
        if (r5 >= getItemCount()) goto L9;
        notifyItemChanged(r5, 0);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        Drawable r1 = null;
        Object r2 = null;
        boolean r3 = false;
        boolean r4 = true;
        if ((r10 instanceof SubtitleSingleImageHolder) == false) goto L52;
        c r12 = (c) ListProtector.get(this.b, r11 - 1);
        SubtitleSingleImageHolder r13 = (SubtitleSingleImageHolder) r10;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.DATA_KEY);
        if (r12.h == true) goto L8;
        return;
    L8:
        if (r12.a.length() != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        com.larus.utils.e1.q(r13.a.b);
        return;
    L13:
        x3a.a r5 = r12.i;
        if (r5 == null) goto L34;
        SimpleDraweeView r6 = r13.a.b;
        Lazy r7 = com.larus.voicecall.impl.util.v0.a;
        Intrinsics.checkNotNullParameter(r5, "photoInfo");
        Intrinsics.checkNotNullParameter(r6, "imgView");
        Pair<Integer, Integer> r8 = r5.h;
        if (r8 != null) goto L18;
        r8 = com.larus.voicecall.impl.util.v0.a(r5);
    L18:
        int r9 = ((Number) r8.getFirst()).intValue();
        int r14 = ((Number) r8.getSecond()).intValue();
        ViewGroup.LayoutParams r15 = r6.getLayoutParams();
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L21;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
    L22:
        if (r16 == null) goto L34;
        if (((ViewGroup.MarginLayoutParams) r16).width == r9) goto L26;
        ((ViewGroup.MarginLayoutParams) r16).width = r9;
        boolean r17 = true;
    L28:
        if (((ViewGroup.MarginLayoutParams) r16).height == r14) goto L30;
        ((ViewGroup.MarginLayoutParams) r16).height = r14;
    L31:
        if (r17 == true) goto L33;
        if (r4 == false) goto L34;
    L33:
        FLogger.a.d("RealtimeSubtitleImageHelper", "setWHDimension height=" + r14 + " width=" + r9);
        r6.setLayoutParams(r16);
        goto L34
    L30:
        r4 = false;
        goto L31
    L26:
        r17 = false;
        goto L28
    L21:
        r16 = null;
    L34:
        com.larus.bmhome.upload.audio.g r18 = com.larus.bmhome.upload.audio.g.a;
        c r19 = r13.d;
        if (r19 == null) goto L39;
        x3a.a r20 = r19.i;
        if (r20 == null) goto L39;
        String r21 = r20.e;
    L40:
        if (r21 != null) goto L42;
        r21 = NameKeys.UnloadStrategy_No_Strategy;
    L42:
        Intrinsics.checkNotNullParameter(r21, "imgKey");
        Map r22 = com.larus.bmhome.upload.audio.g.b;
        r22.remove(r21);
        x3a.a r23 = r12.i;
        if (r23 == null) goto L47;
        String r24 = r23.e;
        if (r24 == null) goto L47;
        t1 r25 = new t1(r12, r13);
        Intrinsics.checkNotNullParameter(r24, "imgKey");
        Intrinsics.checkNotNullParameter(r25, "listener");
        r22.put(r24, r25);
    L47:
        r13.d = r12;
        x3a.a r26 = r12.i;
        if (r26 == null) goto L50;
        r3 = Intrinsics.areEqual(r26.i, Boolean.TRUE);
    L50:
        r13.U3(r3);
        com.larus.utils.e1.x(r13.a.b);
        ImageLoaderKt.s(r13.a.b, Uri.fromFile(new PolarisFileWrapper(r12.a)), null);
        r13.T3();
        return;
    L39:
        r21 = null;
        goto L40
    L10:
        r0 = false;
        goto L11
    L52:
        if ((r10 instanceof v1) == false) goto L82;
        c r27 = (c) ListProtector.get(this.b, r11 - 1);
        if (r11 == this.h) goto L56;
    L58:
        ((v1) r10).K3(r27);
        if ((r10 instanceof TitleViewHolder) == false) goto L62;
        Application r110 = c4a.f.a;
        c4a.f.b(((TitleViewHolder) r10).a.b, this.a, true);
    L62:
        if ((r10 instanceof RealtimeCallASRSubtitleHolder) == false) goto L65;
        Application r111 = c4a.f.a;
        c4a.f.b(((RealtimeCallASRSubtitleHolder) r10).a.b, this.a, true);
    L65:
        if ((r10 instanceof RealtimeCallTTSSubtitleHolder) == false) goto L97;
        Application r112 = c4a.f.a;
        RealtimeCallTTSSubtitleHolder r113 = (RealtimeCallTTSSubtitleHolder) r10;
        c4a.f.b(r113.a.b, this.a, false);
        ImageView r114 = r113.a.c;
        ThemeType r115 = this.a;
        Intrinsics.checkNotNullParameter(r114, "<this>");
        Intrinsics.checkNotNullParameter(r115, "themeType");
        if (i88.e.o(r115) == false) goto L69;
        r114.setImageResource(2131243425);
        return;
    L69:
        int r116 = ColorProtector.parseColor("#80000000");
        Drawable r28 = ContextCompat.getDrawable(c4a.f.a, 2131243425);
        if (r28 != null) goto L93;
    L80:
        r114.setImageDrawable(r1);
        return;
    L93:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L73
        Drawable r30 = DrawableCompat.wrap(r28);     // Catch: Throwable -> L73
        DrawableCompat.setTint(r30, r116);     // Catch: Throwable -> L73
        Object r117 = Result.constructor-impl(r30);     // Catch: Throwable -> L73
    L75:
        Throwable r31 = Result.exceptionOrNull-impl(r117);
        if (r31 != null) goto L78;
        r2 = r117;
    L79:
        r1 = (Drawable) r2;
        goto L80
    L78:
        FLogger.a.e("RealtimeCallDarkModeExt", "getTintDrawable failed:" + r31);
    L73:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r117 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L97:
        return;
    L56:
        if (r27.c == DisplayType.TTS_WAITING) goto L58;
        com.larus.voicecall.impl.utils.c.d(r10.itemView, true);
        this.h = -1;
        goto L58
    L82:
        if ((r10 instanceof SubtitleBlockHolder) == false) goto L100;
        c r33 = (c) ListProtector.get(this.b, r11 - 1);
        if (r11 == this.h) goto L86;
    L88:
        SubtitleBlockHolder r118 = (SubtitleBlockHolder) r10;
        this.g = r118;
        if (r11 != this.b.size()) goto L91;
        r3 = true;
    L91:
        r118.T3(r33, r3);
        return;
    L86:
        if (r33.c == DisplayType.TTS_WAITING) goto L88;
        com.larus.voicecall.impl.utils.c.d(r10.itemView, true);
        this.h = -1;
        goto L88
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r0 = 2131367794;
        switch(r11) {
            case 101: goto L38;
            case 102: goto L33;
            case 103: goto L43;
            case 104: goto L28;
            case 105: goto L21;
            case 106: goto L10;
            case 107: goto L5;
            default: goto L43;
        };
    L5:
        View r12 = LayoutInflater.from(r10.getContext()).inflate(2131562628, r10, false);
        FrameLayout r1 = (FrameLayout) r12;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r12, 2131390229);
        if (r3 == null) goto L9;
        return new SubtitleBlockHolder(new LarusItemRecyclerSubtitleBlockBinding(r1, r1, r3), this.e, this.c, this.f);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(2131390229)));
    L10:
        ConstraintLayout r13 = LayoutInflater.from(r10.getContext()).inflate(2131563148, r10, false);
        ConstraintLayout r4 = r13;
        int r14 = 2131376464;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r13, 2131376464);
        if (r5 == null) goto L20;
        r14 = 2131383297;
        CustomCircularProgressBar r6 = ViewBindings.findChildViewById(r13, 2131383297);
        if (r6 == null) goto L20;
        r14 = 2131384460;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r13, 2131384460);
        if (r7 == null) goto L20;
        r14 = 2131392612;
        View r8 = ViewBindings.findChildViewById(r13, 2131392612);
        if (r8 == null) goto L20;
        return new SubtitleSingleImageHolder(new LarusSubtitleHolderSingleImageBinding(r4, r5, r6, r7, r8), this.d, this.e);
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    L21:
        View r15 = LayoutInflater.from(r10.getContext()).inflate(2131562627, r10, false);
        CustomMarkdownTextView r2 = ViewBindings.findChildViewById(r15, 2131367794);
        if (r2 == null) goto L27;
        r0 = 2131388398;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r15, 2131388398);
        if (r9 == null) goto L27;
        return new RealtimeCallASRSubtitleHolder(new LarusItemRecyclerAsrBinding((FrameLayout) r15, r2, r9), this.c);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    L28:
        View r16 = LayoutInflater.from(r10.getContext()).inflate(2131562631, r10, false);
        TextView r17 = (TextView) ViewBindings.findChildViewById(r16, 2131388772);
        if (r17 == null) goto L32;
        return new TitleViewHolder(new LarusItemRecyclerSubtitleTitleBinding((FrameLayout) r16, r17));
    L32:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(2131388772)));
    L33:
        View r18 = LayoutInflater.from(r10.getContext()).inflate(2131562629, r10, false);
        if (r18 == null) goto L37;
        return new SpaceViewHolder((Space) r18);
    L37:
        throw new NullPointerException("rootView");
    L38:
        View r19 = LayoutInflater.from(r10.getContext()).inflate(2131562632, r10, false);
        if (r19 == null) goto L42;
        return new SpaceViewHolder((Space) r19);
    L42:
        throw new NullPointerException("rootView");
    L43:
        View r110 = LayoutInflater.from(r10.getContext()).inflate(2131562630, r10, false);
        CustomMarkdownTextView r20 = ViewBindings.findChildViewById(r110, 2131367794);
        if (r20 == null) goto L52;
        r0 = 2131370082;
        ImageView r21 = (ImageView) ViewBindings.findChildViewById(r110, 2131370082);
        if (r21 == null) goto L52;
        r0 = 2131384361;
        AppCompatTextView r22 = ViewBindings.findChildViewById(r110, 2131384361);
        if (r22 == null) goto L52;
        return new RealtimeCallTTSSubtitleHolder(new LarusItemRecyclerSubtitleTextBinding((FrameLayout) r110, r20, r21, r22), this.c);
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r0)));
    }

    public RealtimeCallSubtitleAdapter(ThemeType r2, List r3, t r4, u r5, v r6, g r7) {
        Intrinsics.checkNotNullParameter(r2, "themeType");
        Intrinsics.checkNotNullParameter(r3, "list");
        Intrinsics.checkNotNullParameter(r4, "selectCallBack");
        Intrinsics.checkNotNullParameter(r5, "imgUploadListener");
        Intrinsics.checkNotNullParameter(r6, "paramsProvider");
        Intrinsics.checkNotNullParameter(r7, "actionProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.h = -1;
    }
}
