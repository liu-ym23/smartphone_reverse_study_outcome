package com.larus.ugc.feed.impl.viewholder;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.creation.CreationFeedType;
import com.larus.platform.service.z2;
import com.larus.ugc.feed.api.model.AuthorInfoKmp;
import com.larus.ugc.feed.api.model.CreationDynamicInfoKmp;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.ImageKmp;
import com.larus.ugc.feed.api.model.UserCreationContentKmp;
import com.larus.ugc.feed.api.model.UserCreationImageKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.larus.utils.w0;
import com.tencent.open.log.TraceLevel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JJ\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/CreationImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "downloadIcon", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "waterMarkIcon", "Landroid/widget/ImageView;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iconTemplate", "textView", "Landroid/widget/TextView;", "authorInfoLayout", "Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getImageInfo", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "resetTemplateIcon", "", "creationFeedType", "", "bindData", "position", "itemWidth", "creationClickCallBack", "Lcom/larus/ugc/feed/impl/adapter/ICreationClickCallBack;", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "handleIconTemplate", "handleDownLoadIcon", "userCreation", "onViewRecycled", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public class CreationImageViewHolder extends RecyclerView.ViewHolder implements zp9.q {
    public static final /* synthetic */ int h = 0;
    public final CommonDownLoadLayout a;
    public final ImageView b;
    public final SimpleDraweeView c;
    public final View d;
    public final TextView e;
    public final CommonAuthorInfoLayout f;
    public LifecycleCoroutineScope g;

    public static final class a extends BaseControllerListener<Object> {
        public final /* synthetic */ CreationImageViewHolder a;

        public a(CreationImageViewHolder r1) {
            this.a = r1;
        }

        public final void onFailure(String r3, Throwable r4) {
            w0a.a.c("CreationImageViewHolder", "cover image failed");
            super.onFailure(r3, r4);
        }

        public final void onSubmit(String r1, Object r2) {
            super.onSubmit(r1, r2);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, r2, r3);
            boolean r4 = m0.a;
            if (m0.a == false) goto L6;
            e1.x(this.a.b);
            return;
        }
    }

    @Override // zp9.q
    public final void onViewRecycled() {
        this.a.onDestroy();
    }

    public CreationImageViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.a = r4.findViewById(2131370173);
        this.b = (ImageView) r4.findViewById(2131393017);
        this.c = r4.findViewById(2131375775);
        View r0 = r4.findViewById(2131374752);
        ICommunityService.Companion r1 = ICommunityService.a;
        if (r1.f1().e() != 0) goto L5;
        r0.setBackgroundResource(2131239556);
    L6:
        this.d = r0;
        TextView r2 = (TextView) r4.findViewById(2131369264);
        if (r1.f1().e() != 0) goto L9;
        r2.setTextColor(ContextCompat.getColor(r4.getContext(), 2131106521));
    L10:
        this.e = r2;
        this.f = r4.findViewById(2131377437);
        w0.e(r4, i5.Y());
        return;
    L9:
        r2.setTextColor(ContextCompat.getColor(r4.getContext(), 2131103292));
        goto L10
    L5:
        r0.setBackgroundResource(2131239557);
        goto L6
    }

    public ImageInfoKmp U3(UserCreationKmp r2) {
        Intrinsics.checkNotNullParameter(r2, "creation");
        UserCreationContentKmp r3 = r2.getContent();
        if (r3 == null) goto L7;
        UserCreationImageKmp r4 = r3.getImageContent();
        if (r4 == null) goto L7;
        return r4.getImageInfo();
    L7:
        return null;
    }

    public void T3(final int r17, final UserCreationKmp r18, final int r19, final p0a.k r20, LifecycleCoroutineScope r21, @CreationFeedType int r22, zp9.f r23) {
        if (r18 != null) goto L5;
        return;
    L5:
        this.g = r21;
        if (r22 == 1) goto L8;
    L10:
        if (r22 == 1) goto L13;
        if (r22 == 2) goto L13;
        e1.x(this.d);
        e1.o(this.a);
    L15:
        if (this.a.getVisibility() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L36;
        ImageInfoKmp r6 = U3(r18);
        if (r6 == null) goto L36;
        ImageKmp r7 = r6.getImageOrigin();
        if (r7 == null) goto L36;
        String r8 = r7.getUrl();
        if (r8 == null) goto L36;
        if (r8.length() <= 0) goto L29;
        boolean r11 = true;
    L30:
        if (r11 == true) goto L33;
        r8 = null;
    L33:
        if (r8 == null) goto L36;
        this.a.S5(this.g, new com.larus.bmhome.bigimg.download.d.a(r8));
        goto L36
    L29:
        r11 = false;
    L36:
        if (z2.a.getCreationMakeSameConfigV2().b() == false) goto L39;
        e1.o(this.d);
    L71:
        ImageInfoKmp r9 = U3(r18);
        boolean r12 = m0.a;
        if (r12 == false) goto L75;
        if (r9 == null) goto L77;
        ImageKmp r10 = r9.getRawThumbImage();
    L78:
        AuthorInfoKmp r13 = r18.getAuthorInfo();
        if (r10 == null) goto L81;
        Long r14 = Long.valueOf(r10.getHeight());
    L82:
        if (r10 == null) goto L84;
        Long r15 = Long.valueOf(r10.getWidth());
    L85:
        if (r15 == null) goto L87;
        Integer r16 = Integer.valueOf((int) r15.longValue());
    L88:
        if (r14 == null) goto L90;
        Integer r24 = Integer.valueOf((int) r14.longValue());
    L91:
        final int r25 = m0.b(r16, r24, r19, "CreationImageViewHolder" + r17);
        e1.o(this.b);
        SimpleDraweeView r110 = this.c;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        r111.height = r25;
        r110.setLayoutParams(r111);
        if (r12 == false) goto L106;
        float r112 = r19;
        if ((r112 / r25) <= 1.3f) goto L100;
        ImageView r113 = this.b;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L98;
        r114.width = (int) (r112 / 6.0f);
    L99:
        r113.setLayoutParams(r114);
    L105:
        this.b.setImageResource(2131240171);
        e1.q(this.b);
        goto L106
    L98:
        r114 = null;
        goto L99
    L100:
        ImageView r115 = this.b;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L103;
        r116.width = (int) (r112 / 5.0f);
    L104:
        r115.setLayoutParams(r116);
        goto L105
    L103:
        r116 = null;
    L106:
        SimpleDraweeView r117 = this.c;
        Integer r118 = r18.getStatus();
        if (r118 != null) goto L110;
    L112:
        if (r10 == null) goto L114;
        String r26 = r10.getUrl();
    L115:
        ImageLoaderKt.y(r117, r26, "community_creation_photo", new l(this, r18, r19, r25), 4);
        if (r23 == null) goto L135;
        boolean r3 = r23.p;
        Long r27 = r18.getUsageCount();
        if (r27 == null) goto L120;
        long r28 = r27.longValue();
    L121:
        CommonAuthorInfoLayout r29 = this.f;
        if (r3 == false) goto L124;
        int r4 = 0;
    L125:
        r29.setVisibility(r4);
        CommonAuthorInfoLayout r30 = this.f;
        if (r13 == null) goto L128;
        String r31 = r13.getAvatarUrl();
    L129:
        r30.a(r31, m0.a());
        CommonAuthorInfoLayout r32 = this.f;
        if (r13 == null) goto L133;
        String r33 = r13.getName();
        if (r33 == null) goto L133;
    L134:
        r32.setAuthorName(r33);
        this.f.setUseCount(r28);
        e1.d(this.f, new m(r20, r17));
        this.f.setOnLongClickListener(new n(r20, this, r17));
        SimpleDraweeView r34 = this.c;
        StringCompanionObject r35 = StringCompanionObject.INSTANCE;
        int r36 = com.larus.utils.j0.a;
        r34.setContentDescription(String.format(com.larus.utils.j0.d(2131898797), Arrays.copyOf(new Object[]{this.f.getAuthorName(), this.f.getUseCount()}, 2)));
    L136:
        ((RecyclerView.ViewHolder) this).itemView.setClickable(true);
        e1.d(this.c, new o(r20, r17));
        e1.d(this.d, new p(r20, r17));
        e1.d(this.a, new q(r20, r18));
        this.c.setOnLongClickListener(new r(r20, this, r17));
        Integer r1 = r18.getStatus();
        if (r1 != null) goto L140;
        return;
    L140:
        if (r1.intValue() != 5) goto L143;
        this.c.setOnClickListener(null);
        this.f.setOnClickListener(null);
        this.d.setOnClickListener(null);
        this.a.setOnClickListener(null);
        this.c.setOnLongClickListener(null);
        this.f.setOnClickListener(null);
        this.d.setOnClickListener(null);
        this.a.setOnClickListener(null);
        return;
    L143:
        return;
    L133:
        r33 = "";
        goto L134
    L128:
        r31 = null;
        goto L129
    L124:
        r4 = 8;
        goto L125
    L120:
        r28 = 0;
        goto L121
    L135:
        e1.o(this.f);
        goto L136
    L114:
        r26 = null;
        goto L115
    L110:
        if (r118.intValue() != 5) goto L112;
        r26 = UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + "/2131240130").toString();
        goto L115
    L90:
        r24 = null;
        goto L91
    L87:
        r16 = null;
        goto L88
    L84:
        r15 = null;
        goto L85
    L81:
        r14 = null;
    L77:
        r10 = null;
        goto L78
    L75:
        if (r9 == null) goto L77;
        r10 = r9.getImageThumb();
        goto L78
    L39:
        if (this.d.getVisibility() != 0) goto L41;
        boolean r37 = true;
    L42:
        if (r37 == false) goto L71;
        Intrinsics.checkNotNullParameter(r18, "creation");
        CreationDynamicInfoKmp r38 = r18.getDynamicInfo();
        if (r38 == null) goto L56;
        Integer r119 = r38.getPromptStartPos();
        if (r119 == null) goto L56;
        int r120 = r119.intValue();
        Integer r39 = r38.getPromptEndPos();
        if (r39 == null) goto L56;
        int r40 = r39.intValue();
        if (r120 < 0) goto L56;
        if (r40 < 0) goto L56;
        if (r40 < r120) goto L56;
        boolean r41 = true;
    L57:
        if (r41 == false) goto L59;
        this.e.setText(2131901253);
        goto L71
    L59:
        CreationDynamicInfoKmp r42 = r18.getDynamicInfo();
        if (r42 == null) goto L62;
        String r43 = r42.getActionButtonName();
    L64:
        if (o0.d(r43) == false) goto L70;
        TextView r44 = this.e;
        CreationDynamicInfoKmp r121 = r18.getDynamicInfo();
        if (r121 == null) goto L68;
        String r122 = r121.getActionButtonName();
    L69:
        r44.setText(r122);
        goto L71
    L68:
        r122 = null;
        goto L69
    L70:
        this.e.setText(2131901659);
        goto L71
    L62:
        r43 = null;
    L56:
        r41 = false;
        goto L57
    L41:
        r37 = false;
        goto L42
    L17:
        r5 = false;
    L13:
        e1.o(this.a);
        e1.o(this.d);
        goto L15
    L8:
        if (com.larus.bmhome.utils.u.b() == false) goto L10;
        e1.x(this.a);
        this.a.setDownloadIcon(2131240150);
        e1.o(this.d);
        goto L15
    }
}
