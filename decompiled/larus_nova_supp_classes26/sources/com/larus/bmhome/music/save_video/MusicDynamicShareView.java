package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.databinding.LarusLayoutMusicShareDynamicBinding;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/music/save_video/MusicDynamicShareView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/music/databinding/LarusLayoutMusicShareDynamicBinding;", "updateLyrics", "", "lyricsContent", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMusicData", "musicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "(Lcom/larus/im/bean/message/block/MusicCreationContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitThumb", "", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicDynamicShareView extends ConstraintLayout {
    public final LarusLayoutMusicShareDynamicBinding a;

    public MusicDynamicShareView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MusicDynamicShareView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object R5(MusicCreationContent r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof MusicDynamicShareView$setMusicData$1) == false) goto L7;
        MusicDynamicShareView$setMusicData$1 r0 = (MusicDynamicShareView$setMusicData$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        LarusLayoutMusicShareDynamicBinding r17 = (LarusLayoutMusicShareDynamicBinding) r0.L$1;
        MusicCreationContent r5 = (MusicCreationContent) r0.L$0;
        ResultKt.throwOnFailure(r16);
        LarusLayoutMusicShareDynamicBinding r18 = r17;
        r14 = r5;
    L56:
        if (o0.d(r14.getCoverMainColor()) == true) goto L65;
    L60:
        r4 = true;
    L61:
        if (r4 == false) goto L64;
        View r19 = r18.a;
        int r110 = j0.a;
        r19.setBackground(j0.c(2131239856));
    L64:
        return Unit.INSTANCE;
    L65:
        r18.a.setBackgroundColor(Color.parseColor(r14.getCoverMainColor()));     // Catch: Exception -> L59
    L59:
        FLogger.a.e("save_music_video", "Wrong color string format");
        goto L60
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r18 = this.a;
        TextView r6 = r18.e;
        String r7 = r14.getTitle();
        String r8 = "";
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        if (r7.length() != 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L23;
        r7 = getContext().getResources().getString(2131908033);
    L23:
        r6.setText(r7);
        String r10 = null;
        if ((r14 instanceof bq8.a) == false) goto L27;
        r18.d.setText(r14.getCreator());
    L42:
        r0.L$0 = r14;
        r0.L$1 = r18;
        r0.label = 1;
        kotlinx.coroutines.j r11 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r11.C();
        Image r12 = r14.getCover();
        if (r12 == null) goto L47;
        ImageObj r13 = r12.imageThumb;
        if (r13 == null) goto L47;
        r10 = r13.url;
    L47:
        if (r10 == null) goto L50;
        r8 = r10;
    L50:
        ImageLoaderKt.x(this.a.b, UriProtector.parse(r8), "music_share_thumb", null, new e(this, r11), 4);
        Object r20 = r11.B();
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L53;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L53:
        if (r20 != r2) goto L56;
        return r2;
    L27:
        if (AppHost.a.isOversea() == false) goto L32;
        Context r21 = getContext();
        if (r21 == null) goto L31;
        String r22 = j5.b(r21, AccountService.a.getNickname());
    L37:
        TextView r23 = r18.d;
        if (r22 != null) goto L41;
        r22 = "";
    L41:
        r23.setText(r22);
        goto L42
    L31:
        r22 = null;
        goto L37
    L32:
        StringBuilder r24 = new StringBuilder();
        r24.append(AccountService.a.getNickname());
        r24.append(" / ");
        Context r25 = getContext();
        if (r25 == null) goto L35;
        String r26 = r25.getString(2131908040);
    L36:
        r24.append(r26);
        r22 = r24.toString();
        goto L37
    L35:
        r26 = null;
        goto L36
    L20:
        r9 = false;
    L7:
        r0 = new MusicDynamicShareView$setMusicData$1(this, r15);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MusicDynamicShareView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        LayoutInflater.from(r7).inflate(2131562856, this);
        int r10 = 2131368133;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(this, 2131368133);
        if (r2 == null) goto L15;
        r10 = 2131368887;
        if (ViewBindings.findChildViewById(this, 2131368887) == null) goto L15;
        r10 = 2131379323;
        TextView r3 = (TextView) ViewBindings.findChildViewById(this, 2131379323);
        if (r3 == null) goto L15;
        r10 = 2131387625;
        TextView r4 = (TextView) ViewBindings.findChildViewById(this, 2131387625);
        if (r4 == null) goto L15;
        r10 = 2131388772;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131388772);
        if (r5 == null) goto L15;
        this.a = new LarusLayoutMusicShareDynamicBinding(this, r2, r3, r4, r5);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }

    public /* synthetic */ MusicDynamicShareView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
