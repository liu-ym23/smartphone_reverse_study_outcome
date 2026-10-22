package com.larus.bmhome.view.resourcebar.viewholder;

import android.content.Context;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.d5;
import com.larus.bmhome.utils.q1;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.chat.common.databinding.LarusFileResourceInspectFailedLayoutBinding;
import com.larus.chat.common.databinding.LarusFileResourceItemViewBinding;
import com.larus.chat.common.databinding.LarusFileResourceParseFailedLayoutBinding;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/VideoResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/viewholder/EntityResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "viewBinding", "Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;)V", "curImgLoadResult", "Lcom/larus/bmhome/chat/SendImgLoadResult;", "imageSize", "Lkotlin/Pair;", "", "curBindData", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "setContentBackground", "", "data", "setContentInfo", "onClickOpen", "formattedDuration", "", "Lcom/larus/bmhome/view/resourcebar/bean/VideoMeta;", "formatVideoDuration", "duration", "setupImageView", "realLoadImg", "isReload", "", "frescoLoad", "uriStr", "isLocalFile", "tryReloadFailedImg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoResourceViewHolder extends EntityResourceViewHolder {
    public static final /* synthetic */ int j = 0;
    public volatile d5 g;
    public Pair<Integer, Integer> h;
    public ResourceItemBean i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.EntityResourceViewHolder
    public final void Y3(ResourceItemBean r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        if (this.a.getMode() == Mode.SHOW) goto L5;
        return;
    L5:
        if (r3.getStatus() != ItemStatus.PARSE_FAILED) goto L7;
        return;
    L7:
        if (r3.getStatus() == ItemStatus.INSPECT_FAILED) goto L19;
        d5 r4 = this.g;
        if (r4 == null) goto L12;
        boolean r5 = Intrinsics.areEqual(r4.d, Boolean.FALSE);
    L13:
        if (r5 == false) goto L18;
        c4(true);
        return;
    L18:
        return;
    L12:
        r5 = false;
        goto L13
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.EntityResourceViewHolder
    public final void Z3(ResourceItemBean r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        super.Z3(r4);
        LarusFileResourceParseFailedLayoutBinding r5 = (LarusFileResourceParseFailedLayoutBinding) W3().c;
        if (r5 == null) goto L14;
        LinearLayout r6 = r5.b;
        if (r6 == null) goto L15;
        LarusFileResourceParseFailedLayoutBinding r0 = (LarusFileResourceParseFailedLayoutBinding) W3().c;
        if (r0 == null) goto L11;
        LinearLayout r1 = r0.b;
        if (r1 == null) goto L11;
        Context r2 = r1.getContext();
    L12:
        r6.setBackgroundResource(v19.c.b(2130970781, r2, 2131239510));
        return;
    L11:
        r2 = null;
        goto L12
    L15:
        return;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.EntityResourceViewHolder
    public final void a4(ResourceItemBean r23) {
        Intrinsics.checkNotNullParameter(r23, "data");
        super.a4(r23);
        this.i = r23;
        e1.x(this.b.r);
        e1.o(this.b.l);
        e1.o(this.b.s);
        if (r23.getStatus() != ItemStatus.INSPECT_FAILED) goto L10;
        V3().b();
        LarusFileResourceInspectFailedLayoutBinding r1 = (LarusFileResourceInspectFailedLayoutBinding) V3().c;
        if (r1 == null) goto L9;
        AppCompatTextView r2 = r1.c;
        if (r2 == null) goto L9;
        r2.setText(2131905684);
    L9:
        e1.o(this.b.b);
        return;
    L10:
        mt8.b r3 = r23.getVideo();
        String r4 = null;
        if (r3 == null) goto L13;
        Image r5 = r3.a;
    L14:
        FLogger r6 = FLogger.a;
        r6.i("VideoResourceViewHolder", "[setupImageView] imageData:" + r5);
        if (r5 == null) goto L109;
        q1 r8 = q1.a;
        Context r9 = getContext();
        ResourceItemBean r10 = this.i;
        if (r10 == null) goto L20;
        boolean r11 = r10.getImmersiveStyle();
    L21:
        this.h = q1.b(r8, r9, r5, r11);
        String r12 = r5.localResPath;
        String r13 = "";
        if (r12 != null) goto L31;
        mr9.e r14 = com.larus.bmhome.upload.h.a.query(r23.getKey());
        if (r14 == null) goto L28;
        Image r15 = r14.a;
        if (r15 == null) goto L28;
        r12 = r15.localResPath;
    L29:
        if (r12 != null) goto L31;
        r12 = "";
    L28:
        r12 = null;
    L31:
        String r16 = r5.key;
        if (r16 == null) goto L36;
        r13 = r16;
    L36:
        if (r12.length() <= 0) goto L38;
        boolean r17 = true;
    L39:
        if (r17 == false) goto L44;
        if (new PolarisFileWrapper(r12).exists() == false) goto L44;
        d5 r7 = new d5(r5.key, Uri.fromFile(new PolarisFileWrapper(r12)), true, false, 48);
    L108:
        this.g = r7;
        r6.i("VideoResourceViewHolder", "[setupImageView] imageSize:" + this.h + ", curImgLoadResult:" + this.g);
        c4(false);
    L44:
        if (r13.length() <= 0) goto L46;
        boolean r18 = true;
    L47:
        if (r18 == false) goto L82;
        ImageObj r19 = r5.imageOri;
        if (r19 == null) goto L51;
        String r20 = r19.url;
    L52:
        if (r20 != null) goto L54;
    L57:
        boolean r21 = true;
    L58:
        if (r21 == false) goto L82;
        ImageObj r22 = r5.imageThumb;
        if (r22 == null) goto L62;
        String r24 = r22.url;
    L63:
        if (r24 != null) goto L65;
    L68:
        boolean r25 = true;
    L69:
        if (r25 == false) goto L82;
        ImageObj r26 = r5.previewImage;
        if (r26 == null) goto L73;
        String r27 = r26.url;
    L74:
        if (r27 != null) goto L76;
    L79:
        boolean r28 = true;
    L80:
        if (r28 == false) goto L82;
        r7 = new d5(r5.key, UriProtector.parse(r13), true, false, 48);
        goto L108
    L76:
        if (r27.length() == 0) goto L79;
        r28 = false;
        goto L80
    L73:
        r27 = null;
        goto L74
    L65:
        if (r24.length() == 0) goto L68;
        r25 = false;
        goto L69
    L62:
        r24 = null;
        goto L63
    L54:
        if (r20.length() == 0) goto L57;
        r21 = false;
        goto L58
    L51:
        r20 = null;
    L82:
        String r29 = r5.key;
        ImageObj r110 = r5.imageThumb;
        if (r110 == null) goto L85;
        String r111 = r110.url;
    L87:
        if (o0.d(r111) == false) goto L93;
        ImageObj r30 = r5.imageThumb;
        if (r30 == null) goto L91;
        r4 = r30.url;
    L91:
        Uri r31 = y0.h(r4);
    L107:
        r7 = new d5(r29, r31, false, false, 48);
        goto L108
    L93:
        ImageObj r112 = r5.previewImage;
        if (r112 == null) goto L96;
        String r113 = r112.url;
    L98:
        if (o0.d(r113) == false) goto L103;
        ImageObj r32 = r5.previewImage;
        if (r32 == null) goto L102;
        r4 = r32.url;
    L102:
        r31 = y0.h(r4);
        goto L107
    L103:
        ImageObj r33 = r5.imageOri;
        if (r33 == null) goto L106;
        r4 = r33.url;
    L106:
        r31 = y0.h(r4);
        goto L107
    L96:
        r113 = null;
        goto L98
    L85:
        r111 = null;
        goto L87
    L46:
        r18 = false;
        goto L47
    L38:
        r17 = false;
        goto L39
    L20:
        r11 = false;
    L109:
        mt8.b r34 = r23.getVideo();
        if (r34 == null) goto L122;
        int r35 = MathKt.roundToInt(r34.b);
        int r36 = r35 % 60;
        int r37 = r35 / 60;
        int r38 = r37 / 60;
        int r39 = r37 % 60;
        if (r35 != 0) goto L115;
        String r40 = "00:01";
    L118:
        if (r40 == null) goto L123;
        r6.i("VideoResourceViewHolder", "[setContentInfo] formattedDuration:".concat(r40));
        this.b.c.setText(r40);
        e1.x(this.b.b);
        return;
    L123:
        return;
    L115:
        if (r38 != 0) goto L117;
        StringCompanionObject r41 = StringCompanionObject.INSTANCE;
        r40 = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r39), Integer.valueOf(r36)}, 2));
        goto L118
    L117:
        StringCompanionObject r42 = StringCompanionObject.INSTANCE;
        r40 = String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r38), Integer.valueOf(r39), Integer.valueOf(r36)}, 3));
        goto L118
    L122:
        return;
    L13:
        r5 = null;
        goto L14
    }

    public final void c4(final boolean r11) {
        d5 r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        final String r1 = String.valueOf(r0.b);
        final boolean r5 = r0.c;
        Pair<Integer, Integer> r2 = this.h;
        if (r2 != null) goto L8;
        q1 r3 = q1.a;
        Context r4 = getContext();
        r3.getClass();
        r2 = q1.e(r4);
    L8:
        final Pair<Integer, Integer> r6 = r2;
        final d5 r8 = this.g;
        ImageLoaderKt.y(this.b.r, r1, "chat.send_multi_video", new o(this, r6, r5, r1, r11, r8), 4);
    }

    public VideoResourceViewHolder(ResourceBarConfig r2, LarusFileResourceItemViewBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "viewBinding");
        super(r2, r3);
    }
}
