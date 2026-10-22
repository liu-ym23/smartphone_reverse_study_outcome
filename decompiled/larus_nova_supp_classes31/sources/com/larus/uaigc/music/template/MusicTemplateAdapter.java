package com.larus.uaigc.music.template;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.music.widget.LyricsToSongTemplatePlayerView;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.tencent.open.log.TraceLevel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003XYZBa\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015JF\u0010.\u001a\u00020\n2>\u0010/\u001a:\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\n\u0018\u00010\u001fj\u0004\u0018\u0001`$J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&H\u0016J\b\u00104\u001a\u00020&H\u0016J\u001a\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00022\b\b\u0001\u00107\u001a\u00020&H\u0016J:\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020&2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004J \u0010;\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=2\u0006\u0010:\u001a\u00020&H\u0002J$\u0010>\u001a\u00020\n2\u0006\u00109\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010?\u001a\u00020\n2\u0006\u00109\u001a\u00020\u000fH\u0002J\b\u0010@\u001a\u00020\nH\u0002J\b\u0010A\u001a\u00020\nH\u0002J\u0006\u0010B\u001a\u00020\nJ\u001c\u0010C\u001a\u00020\n2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00062\u0006\u0010E\u001a\u00020FH\u0002JL\u0010G\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010I\u001a\u00020J2\b\b\u0002\u0010K\u001a\u00020J2\b\b\u0002\u0010L\u001a\u00020J2\b\b\u0002\u0010M\u001a\u00020J2\u0006\u0010N\u001a\u00020&2\b\b\u0002\u0010O\u001a\u00020&H\u0002J\u0010\u0010P\u001a\u00020&2\u0006\u00107\u001a\u00020&H\u0016J\u0016\u0010Q\u001a\u00020\n2\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010SJ\u000e\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\u001dJ\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u00109\u001a\u00020\u000fH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010\u001e\u001a:\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\n\u0018\u00010\u001fj\u0004\u0018\u0001`$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/larus/uaigc/music/template/MusicTemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "botId", "", "chatType", "dismissListener", "Lkotlin/Function0;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "templateList", "", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "attachedView", "Landroidx/recyclerview/widget/RecyclerView;", "appletArguments", "Landroid/os/Bundle;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineScope;Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView;Landroid/os/Bundle;)V", "getContext", "()Landroid/content/Context;", "getTemplateList", "()Ljava/util/List;", "setTemplateList", "(Ljava/util/List;)V", "hasMore", "", "musicTemplateChoose", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "templateInfo", "enterFrom", "Lcom/larus/uaigc/music/template/TemplateChooseCallback;", "itemWidth", "", "holderGroup", "Ljava/util/HashSet;", "Lcom/larus/uaigc/music/template/MusicTemplateAdapter$MusicViewHolder;", "Lkotlin/collections/HashSet;", "syncScrollJob", "Lkotlinx/coroutines/Job;", "isMusicAppletTemplatePage", "setImageTemplateChoose", "imageTemplateChoose", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "parsePlayListAndGoDetail", "template", "currentPlayProgress", "openTemplateDetailApplet", "playerData", "Lcom/larus/bmhome/music/player/MusicPlayerData;", "sendEnterTemplateDetail", "observeSyncCurrentPlaying", "tagPosition", "tryRebindVHState", "pausePlayingTemplate", "setShapeCornerColorTint", "colorString", "adjustToView", "Landroid/view/View;", "adjustViewBgGradient", "view", "topLeftRadius", "", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "startColor", "endColor", "getItemViewType", "appendDataList", "appendTempInfoList", "", "setHasMore", "isHasMore", "buildMusicAppletMobContext", "Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "Companion", "MusicViewHolder", "LoadingHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicTemplateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int o = 0;
    public final Context a;
    public final String b;
    public final String c;
    public final Function0<Unit> d;
    public final CoroutineScope e;
    public final List<bq8.a> f;
    public final RecyclerView g;
    public final Bundle h;
    public boolean i;
    public Function2<? super bq8.a, ? super String, Unit> j;
    public final int k;
    public final HashSet<MusicViewHolder> l;
    public Job m;
    public final boolean n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/uaigc/music/template/MusicTemplateAdapter$LoadingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class LoadingHolder extends RecyclerView.ViewHolder {
        public LoadingHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/larus/uaigc/music/template/MusicTemplateAdapter$MusicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconTemplate", "getIconTemplate", "()Landroid/view/View;", "titleText", "Landroid/widget/TextView;", "getTitleText", "()Landroid/widget/TextView;", "genreText", "getGenreText", "player", "Lcom/larus/uaigc/music/widget/LyricsToSongTemplatePlayerView;", "getPlayer", "()Lcom/larus/uaigc/music/widget/LyricsToSongTemplatePlayerView;", "shadowLayer", "getShadowLayer", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class MusicViewHolder extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final View b;
        public final TextView c;
        public final TextView d;
        public final LyricsToSongTemplatePlayerView e;
        public final View f;

        public MusicViewHolder(View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            super(r3);
            this.a = r3.findViewById(2131375775);
            this.b = r3.findViewById(2131374803);
            this.c = (TextView) r3.findViewById(2131380526);
            this.d = (TextView) r3.findViewById(2131380492);
            LyricsToSongTemplatePlayerView r0 = (LyricsToSongTemplatePlayerView) r3.findViewById(2131382473);
            this.e = r0;
            this.f = r3.findViewById(2131386037);
            r0.d();
        }
    }

    public static final class a {
    }

    public static final class b extends BaseControllerListener<Object> {
        public final /* synthetic */ RecyclerView.ViewHolder a;

        public b(RecyclerView.ViewHolder r1) {
            this.a = r1;
        }

        public final void onFailure(String r4, Throwable r5) {
            FLogger.a.i("MusicTemplateAdapter", "cover image failed");
            super.onFailure(r4, r5);
        }

        public final void onSubmit(String r4, Object r5) {
            FLogger.a.i("MusicTemplateAdapter", "cover image submit");
            super.onSubmit(r4, r5);
            e1.o(((MusicViewHolder) this.a).b);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, r2, r3);
            FLogger.a.i("MusicTemplateAdapter", "cover image set");
            e1.x(((MusicViewHolder) this.a).b);
        }
    }

    static {
    }

    public final void A2() {
        Iterator<T> r0 = this.f.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((bq8.a) r2).e = r3;
        r1 = r3;
        goto L4
    }

    public final void B2() {
        Iterator<MusicViewHolder> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        LyricsToSongTemplatePlayerView r2 = r0.next().e;
        MusicCreationContent r3 = r2.e;
        if (r3 == null) goto L4;
        LyricsToSongTemplatePlayerView.c(r2, r3, r2.f, r2.l, null, r2.m, 8);
        goto L4
    L8:
        BuildersKt.launch$default(this.e, null, null, new MusicTemplateAdapter$tryRebindVHState$2(this, null), 3, null);
        Job r1 = this.m;
        if (r1 == null) goto L17;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
        return;
    }

    public final int getItemCount() {
        return this.f.size() + 1;
    }

    public final Context getContext() {
        return this.a;
    }

    public final int getItemViewType(int r2) {
        if (r2 == this.f.size()) goto L5;
        return 0;
    L5:
        if (this.i == false) goto L7;
        return 1;
    L7:
        return 2;
    }

    public final void onBindViewHolder(final RecyclerView.ViewHolder r19, final int r20) {
        Intrinsics.checkNotNullParameter(r19, "holder");
        boolean r2 = true;
        if ((r19 instanceof MusicViewHolder) == false) goto L42;
        MusicViewHolder r9 = (MusicViewHolder) r19;
        SimpleDraweeView r1 = r9.a;
        Image r3 = ((bq8.a) ListProtector.get(this.f, r20)).getCover();
        if (r3 == null) goto L9;
        ImageObj r4 = r3.imageThumb;
        if (r4 == null) goto L9;
        String r5 = r4.url;
    L10:
        ImageLoaderKt.y(r1, r5, "template_item_photo", new com.larus.uaigc.music.template.a(r19), 4);
        r9.e.setUseFragmentLifecycleOwner(this.n);
        r9.a.setOnClickListener(new com.larus.uaigc.music.template.b(this, r20, r19));
        r9.b.setOnClickListener(new c(this, r20));
        r9.c.setText(((bq8.a) ListProtector.get(this.f, r20)).getTitle());
        bq8.e r0 = ((bq8.a) ListProtector.get(this.f, r20)).b().c;
        if (r0 == null) goto L13;
        String r6 = r0.b;
    L15:
        if (r6 != null) goto L17;
    L20:
        if (r2 == false) goto L22;
        e1.o(r9.d);
    L27:
        LyricsToSongTemplatePlayerView r7 = r9.e;
        MusicCreationContent r8 = (MusicCreationContent) ListProtector.get(this.f, r20);
        bq8.a r13 = (bq8.a) ListProtector.get(this.f, r20);
        if (this.n == false) goto L30;
        kr8.n r10 = kr8.n.a;
        kr8.o r11 = kr8.n.a(this.h, null, r13, null, null, null, 58);
    L31:
        LyricsToSongTemplatePlayerView.c(r7, r8, r20, "template_list", null, r11, 8);
        String r12 = ((bq8.a) ListProtector.get(this.f, r20)).getCoverMainColor();
        View r14 = r9.f;
    L40:
        e = move-exception;
        FLogger.a.e("LyricsToSongBox", "error parsing tint color ", e);
        return;
    L33:
        if (TextUtils.isEmpty(r12) == false) goto L37;
        if (r12 != null) goto L36;
        int r15 = Color.argb(0, 0, 0, 0);     // Catch: IllegalArgumentException -> L40
    L38:
        int r16 = r15;
        int r17 = Color.argb(0, 0, 0, 0);     // Catch: IllegalArgumentException -> L40
        int r18 = CircleProgressBarView.k;     // Catch: IllegalArgumentException -> L40
        float r21 = CircleProgressBarView.a.a(r14.getContext(), 8.0f);     // Catch: IllegalArgumentException -> L40
        y2(this, r14, r21, r21, r16, r17);     // Catch: IllegalArgumentException -> L40
        return;
    L36:
        r15 = Color.parseColor("#B6BACD");     // Catch: IllegalArgumentException -> L40
        goto L38
    L37:
        r15 = Color.parseColor(r12);     // Catch: IllegalArgumentException -> L40
        goto L38
    L30:
        r11 = null;
        goto L31
    L22:
        e1.x(r9.d);
        TextView r22 = r9.d;
        bq8.e r23 = ((bq8.a) ListProtector.get(this.f, r20)).b().c;
        if (r23 == null) goto L25;
        String r24 = r23.b;
    L26:
        r22.setText(r24);
        goto L27
    L25:
        r24 = null;
        goto L26
    L17:
        if (r6.length() == 0) goto L20;
        r2 = false;
        goto L20
    L13:
        r6 = null;
    L9:
        r5 = null;
        goto L10
    L42:
        StaggeredGridLayoutManager.LayoutParams r25 = r19.itemView.getLayoutParams();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        r25.setFullSpan(true);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 0) goto L5;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131562691, r4, false);
        w0.e(r6, j19.c.c(8));
        Intrinsics.checkNotNull(r6);
        MusicViewHolder r7 = new MusicViewHolder(r6);
        this.l.add(r7);
        return r7;
    L5:
        if (r5 != 1) goto L7;
        View r8 = LayoutInflater.from(r4.getContext()).inflate(2131562690, r4, false);
        Intrinsics.checkNotNull(r8);
        return new LoadingHolder(r8);
    L7:
        if (r5 == 2) goto L10;
        View r9 = LayoutInflater.from(r4.getContext()).inflate(2131562688, r4, false);
        Intrinsics.checkNotNull(r9);
        return new LoadingHolder(r9);
    L10:
        View r10 = LayoutInflater.from(r4.getContext()).inflate(2131562688, r4, false);
        Intrinsics.checkNotNull(r10);
        return new LoadingHolder(r10);
    }

    public final void z2(bq8.a r10, String r11, String r12) {
        kr8.j r8 = new kr8.j("click_template_list", String.valueOf(r10.a), Integer.valueOf(r10.e), "music", r11, r12, 1);
        if (this.n == false) goto L5;
        kr8.n r13 = kr8.n.a;
        kr8.o r14 = kr8.n.a(this.h, null, r10, null, null, null, 58);
        String r15 = String.valueOf(r10.e);
        JSONObject r16 = kr8.n.c(r14, "template_page", false);
        kr8.n.f(r16, "position", r15);
    L6:
        kr8.l.a.b(r8, r16, 1);
        return;
    L5:
        r16 = null;
        goto L6
    }

    public static void y2(MusicTemplateAdapter r3, View r4, float r5, float r6, int r7, int r8) {
        r3.getClass();
        GradientDrawable r9 = new GradientDrawable();
        r9.setColors(new int[]{r7, r8});
        r9.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r9.setShape(0);
        r9.setCornerRadii(new float[]{r5, r5, r6, r6, 0.0f, 0.0f, 0.0f, 0.0f});
        r4.setBackground(r9);
    }

    public MusicTemplateAdapter(Context r2, String r3, String r4, n r5, LifecycleCoroutineScope r6, List r7, RecyclerView r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "dismissListener");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "templateList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.k = -1;
        this.l = new HashSet();
        boolean r10 = false;
        if (r9 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.n = r11;
        float r12 = c7.d(Integer.valueOf(com.larus.utils.i.d(r2)));
        if (r12 <= 500.0f) goto L11;
        int r13 = 3;
    L13:
        if (r12 != (-1.0f)) goto L15;
        r10 = true;
    L15:
        if (r10 == true) goto L17;
        this.k = ((c7.b(Float.valueOf(r12)) - c7.b(24)) - ((r13 - 1) * c7.b(6))) / r13;
    L17:
        A2();
        FLogger.a.i("MusicTemplateAdapter", "screenWidth is " + c7.b(Float.valueOf(r12)) + " itemWidth is " + this.k);
        return;
    L11:
        r13 = 2;
        goto L13
    L5:
        if (r9.getBoolean("argument_is_music_applet_template") != true) goto L7;
        r11 = true;
        goto L8
    }
}
