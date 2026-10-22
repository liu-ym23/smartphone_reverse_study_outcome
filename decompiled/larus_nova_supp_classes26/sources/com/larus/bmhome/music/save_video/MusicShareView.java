package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.databinding.LarusLayoutMusicShareBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/music/save_video/MusicShareView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/music/databinding/LarusLayoutMusicShareBinding;", "setMusicData", "", "musicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "(Lcom/larus/im/bean/message/block/MusicCreationContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitThumb", "", "awaitBg", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicShareView extends ConstraintLayout {
    public final LarusLayoutMusicShareBinding a;

    public MusicShareView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MusicShareView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object R5(MusicCreationContent r36, Continuation<? super Unit> r37) {
        MusicCreationContent r1 = r36;
        if ((r37 instanceof MusicShareView$setMusicData$1) == false) goto L7;
        MusicShareView$setMusicData$1 r3 = (MusicShareView$setMusicData$1) r37;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        int r7 = r3.I$0;
        LarusLayoutMusicShareBinding r8 = (LarusLayoutMusicShareBinding) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L108:
        int r9 = r8.f.getLineCount() * r8.f.getLineHeight();
        FLogger.a.d("save_music_video", "Lyrics actualHeightAfter = " + r9 + ", lyrics textView height = " + r7);
        float r10 = (float) r9;
        int r11 = CircleProgressBarView.k;
        if (r10 <= CircleProgressBarView.a.a(getContext(), 380.0f)) goto L112;
        int r12 = getContext().getResources().getColor(2131103298);
        r8.f.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r8.f.getMeasuredHeight(), new int[]{r12, ColorUtils.setAlphaComponent(r12, 15)}, new float[]{0.9f, 1.0f}, Shader.TileMode.CLAMP));
    L112:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r7 = r3.I$0;
        LarusLayoutMusicShareBinding r13 = (LarusLayoutMusicShareBinding) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L101:
        int r14 = r13.f.getLineCount() * r13.f.getLineHeight();
        FLogger.a.d("save_music_video", "Lyrics actualHeight = " + r14 + ", lyrics textView height = " + r7);
        float r15 = (float) r14;
        int r16 = CircleProgressBarView.k;
        if (r15 < CircleProgressBarView.a.a(getContext(), 380.0f)) goto L104;
        r13.f.setTextSize(15.0f);
    L104:
        r13.f.setLineSpacing(0.0f, 1.4f);
        TextView r17 = r13.f;
        r3.L$0 = r13;
        r3.I$0 = r7;
        r3.label = 4;
        if (ViewExtKt.b(r17, r3) != r5) goto L107;
        return r5;
    L107:
        r8 = r13;
        goto L108
    L18:
        LarusLayoutMusicShareBinding r18 = (LarusLayoutMusicShareBinding) r3.L$1;
        MusicCreationContent r19 = (MusicCreationContent) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L76:
        if (o0.d(r19.getCoverMainColor()) == true) goto L113;
    L84:
        boolean r20 = true;
    L85:
        if (r20 == false) goto L87;
        r18.d.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#AAB8C6"), ColorProtector.parseColor("#B6BACD")}));
    L87:
        TextView r21 = r18.f;
        String r22 = r19.getLyrics();
        if (r22 != null) goto L90;
        String r110 = "";
    L91:
        List r23 = StringsKt.split$default(r110, new String[]{"\n"}, false, 0, 6, null);
        ArrayList r24 = new ArrayList();
        Iterator r25 = r23.iterator();
    L93:
        if (r25.hasNext() == false) goto L97;
        Object r26 = r25.next();
        if ((!StringsKt.contains$default((String) r26, "[", false, 2, null)) == false) goto L93;
        r24.add(r26);
        goto L93
    L97:
        r21.setText(CollectionsKt.joinToString$default(r24, "\n", null, null, 0, null, null, 62, null));
        int r27 = r18.f.getMeasuredHeight();
        TextView r28 = r18.f;
        r3.L$0 = r18;
        r3.L$1 = null;
        r3.I$0 = r27;
        r3.label = 3;
        if (ViewExtKt.b(r28, r3) != r5) goto L100;
        return r5;
    L100:
        r13 = r18;
        r7 = r27;
        goto L101
    L90:
        r110 = r22;
        goto L91
    L113:
        int r29 = Color.parseColor(r19.getCoverMainColor());     // Catch: Exception -> L83
        int[] r30 = {ColorUtils.setAlphaComponent(r29, 127), ColorUtils.setAlphaComponent(r29, 239), r29};     // Catch: Exception -> L83
        float[] r111 = {0.0f, 0.7f, 1.0f};     // Catch: Exception -> L83
        if (Build.VERSION.SDK_INT < 29) goto L80;
        GradientDrawable r31 = new GradientDrawable();     // Catch: Exception -> L83
        r31.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);     // Catch: Exception -> L83
        r31.setColors(r30, r111);     // Catch: Exception -> L83
        Drawable r32 = r31;
    L81:
        r18.c.setBackground(r32);     // Catch: Exception -> L83
        r18.a.setBackgroundColor(r29);     // Catch: Exception -> L83
        r20 = false;
        goto L85
    L80:
        ShapeDrawable r33 = new ShapeDrawable(new RectShape());     // Catch: Exception -> L83
        r33.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r18.c.getHeight(), r30, r111, Shader.TileMode.CLAMP));     // Catch: Exception -> L83
        r32 = r33;
    L83:
        FLogger.a.e("save_music_video", "Wrong color string format");
        goto L84
    L19:
        LarusLayoutMusicShareBinding r34 = (LarusLayoutMusicShareBinding) r3.L$1;
        MusicCreationContent r35 = (MusicCreationContent) r3.L$0;
        ResultKt.throwOnFailure(r2);
        LarusLayoutMusicShareBinding r38 = r34;
        r1 = r35;
    L61:
        r3.L$0 = r1;
        r3.L$1 = r38;
        r3.label = 2;
        kotlinx.coroutines.j r39 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r3), 1);
        r39.C();
        Image r40 = r1.getCover();
        if (r40 == null) goto L66;
        ImageObj r41 = r40.imageOri;
        if (r41 == null) goto L66;
        String r42 = r41.url;
    L67:
        if (r42 != null) goto L69;
        r42 = "";
    L69:
        ImageLoaderKt.x(this.a.b, UriProtector.parse(r42), "music_share_bg", null, new g(this, r39), 4);
        Object r43 = r39.B();
        if (r43 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L72;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L72:
        if (r43 != r5) goto L74;
        return r5;
    L74:
        r19 = r1;
        r18 = r38;
    L66:
        r42 = null;
        goto L67
    L20:
        ResultKt.throwOnFailure(r2);
        r38 = this.a;
        TextView r44 = r38.h;
        String r112 = r36.getTitle();
        if (r112 != null) goto L24;
        r112 = "";
    L24:
        if (r112.length() != 0) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L29;
        r112 = getContext().getResources().getString(2131908033);
    L29:
        r44.setText(r112);
        if ((r1 instanceof bq8.a) == false) goto L33;
        r38.g.setText(r36.getCreator());
    L48:
        r3.L$0 = r1;
        r3.L$1 = r38;
        r3.label = 1;
        kotlinx.coroutines.j r45 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r3), 1);
        r45.C();
        Image r46 = r36.getCover();
        if (r46 == null) goto L53;
        ImageObj r47 = r46.imageThumb;
        if (r47 == null) goto L53;
        String r48 = r47.url;
    L54:
        if (r48 != null) goto L56;
        r48 = "";
    L56:
        ImageLoaderKt.x(this.a.e, UriProtector.parse(r48), "music_share_thumb", null, new i(this, r45), 4);
        Object r49 = r45.B();
        if (r49 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L59:
        if (r49 != r5) goto L61;
        return r5;
    L53:
        r48 = null;
        goto L54
    L33:
        if (AppHost.a.isOversea() == false) goto L38;
        Context r50 = getContext();
        if (r50 == null) goto L37;
        String r51 = j5.b(r50, AccountService.a.getNickname());
    L43:
        TextView r52 = r38.g;
        if (r51 != null) goto L47;
        r51 = "";
    L47:
        r52.setText(r51);
        goto L48
    L37:
        r51 = null;
        goto L43
    L38:
        StringBuilder r53 = new StringBuilder();
        r53.append(AccountService.a.getNickname());
        r53.append(" / ");
        Context r54 = getContext();
        if (r54 == null) goto L41;
        String r55 = r54.getString(2131908040);
    L42:
        r53.append(r55);
        r51 = r53.toString();
        goto L43
    L41:
        r55 = null;
        goto L42
    L26:
        r113 = false;
    L7:
        r3 = new MusicShareView$setMusicData$1(this, r37);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MusicShareView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        LayoutInflater.from(r10).inflate(2131562855, this);
        int r13 = 2131364129;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(this, 2131364129);
        if (r2 == null) goto L23;
        r13 = 2131364130;
        View r3 = ViewBindings.findChildViewById(this, 2131364130);
        if (r3 == null) goto L23;
        r13 = 2131364131;
        View r4 = ViewBindings.findChildViewById(this, 2131364131);
        if (r4 == null) goto L23;
        r13 = 2131368133;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(this, 2131368133);
        if (r5 == null) goto L23;
        r13 = 2131368887;
        if (ViewBindings.findChildViewById(this, 2131368887) == null) goto L23;
        r13 = 2131374777;
        if (((ImageView) ViewBindings.findChildViewById(this, 2131374777)) == null) goto L23;
        r13 = 2131379323;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131379323);
        if (r6 == null) goto L23;
        r13 = 2131387625;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131387625);
        if (r7 == null) goto L23;
        r13 = 2131388772;
        TextView r8 = (TextView) ViewBindings.findChildViewById(this, 2131388772);
        if (r8 == null) goto L23;
        this.a = new LarusLayoutMusicShareBinding(this, r2, r3, r4, r5, r6, r7, r8);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r13)));
    }

    public /* synthetic */ MusicShareView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
