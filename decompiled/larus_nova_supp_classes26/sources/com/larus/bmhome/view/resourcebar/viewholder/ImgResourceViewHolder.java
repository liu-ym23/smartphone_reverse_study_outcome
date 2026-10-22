package com.larus.bmhome.view.resourcebar.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.d5;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.bmhome.chat.layout.widget.n0;
import com.larus.bmhome.utils.q1;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.chat.common.databinding.LarusFileResourceInspectFailedLayoutBinding;
import com.larus.chat.common.databinding.LarusFileResourceItemViewBinding;
import com.larus.chat.common.databinding.LarusFileResourceParseFailedLayoutBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IFlowDriveSdkService;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0006\u0010\u001b\u001a\u00020\u0018J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\rH\u0002J \u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u001a\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\rH\u0002J\u0012\u0010'\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/ImgResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/viewholder/EntityResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "viewBinding", "Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;)V", "curImgLoadResult", "Lcom/larus/bmhome/chat/SendImgLoadResult;", "lastLoadedUriStr", "", "lastLoadSucceeded", "", "imageSize", "Lkotlin/Pair;", "", "lowResUriForPreview", "Landroid/net/Uri;", "curBindData", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "viewHolderScope", "Lkotlinx/coroutines/CoroutineScope;", "setContentBackground", "", "data", "setContentInfo", "showExpiredImage", "onClickOpen", "setupImageView", "realLoadImg", "isReload", "frescoLoad", "uriStr", "isLocalFile", "refreshEditAndSubscriptUI", "message", "Lcom/larus/im/bean/message/Message;", "imageLoaded", "checkShowSubscript", "tryReloadFailedImg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImgResourceViewHolder extends EntityResourceViewHolder {
    public static final /* synthetic */ int n = 0;
    public volatile d5 g;
    public String h;
    public boolean i;
    public Pair<Integer, Integer> j;
    public Uri k;
    public ResourceItemBean l;
    public CoroutineScope m;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ ImgResourceViewHolder a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public a(ImgResourceViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            CoroutineScope r4 = this.a.m;
            if (r4 == null) goto L5;
            CoroutineScopeKt.cancel$default(r4, null, 1, null);
        L5:
            this.a.m = null;
        }
    }

    public static final class b {
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
        d4(true);
        return;
    L18:
        return;
    L12:
        r5 = false;
        goto L13
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.EntityResourceViewHolder
    public final void Z3(ResourceItemBean r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super.Z3(r2);
        LarusFileResourceParseFailedLayoutBinding r3 = (LarusFileResourceParseFailedLayoutBinding) W3().c;
        if (r3 == null) goto L8;
        LinearLayout r4 = r3.b;
        if (r4 == null) goto L9;
        r4.setBackgroundResource(2131239510);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.EntityResourceViewHolder
    public final void a4(ResourceItemBean r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        super.a4(r15);
        this.l = r15;
        e1.x(this.b.r);
        e1.o(this.b.l);
        e1.o(this.b.s);
        e1.o(this.b.t);
        if (r15.getStatus() != ItemStatus.INSPECT_FAILED) goto L9;
        V3().b();
        LarusFileResourceInspectFailedLayoutBinding r16 = (LarusFileResourceInspectFailedLayoutBinding) V3().c;
        if (r16 == null) goto L136;
        AppCompatTextView r17 = r16.c;
        if (r17 == null) goto L137;
        r17.setText(2131906528);
        return;
    L137:
        return;
    L136:
        return;
    L9:
        Uri r1 = null;
        if (r15.isExpire() == false) goto L12;
        this.b.p.setVisibility(8);
        this.b.d.setBackgroundResource(2131239525);
        ImageLoaderKt.y(this.b.r, "res://" + AppHost.a.getApplication().getPackageName() + "/2131242958", null, new j(), 6);
        return;
    L12:
        Image r0 = r15.getImage();
        FLogger.a.i("ImgResourceViewHolder", "[setupImageView] imageData:" + r0);
        if (r0 == null) goto L140;
        Object r18 = r15.getExt().get("ext_img_show_path");
        boolean r2 = true;
        if (r18 != null) goto L18;
    L27:
        boolean r4 = false;
    L28:
        if (r4 == false) goto L30;
        String r19 = (String) r18;
    L31:
        ImageObj r5 = r0.previewImage;
        if (r5 == null) goto L41;
        String r6 = r5.url;
        if (r6 == null) goto L41;
        if (r6.length() <= 0) goto L38;
        boolean r7 = true;
    L39:
        if (r7 == false) goto L41;
    L42:
        ImageObj r8 = r0.imageThumb;
        if (r8 == null) goto L52;
        String r9 = r8.url;
        if (r9 == null) goto L52;
        if (r9.length() <= 0) goto L49;
        boolean r10 = true;
    L50:
        if (r10 == false) goto L52;
    L53:
        ImageObj r11 = r0.imageOri;
        if (r11 == null) goto L63;
        String r12 = r11.url;
        if (r12 == null) goto L63;
        if (r12.length() <= 0) goto L60;
        boolean r13 = true;
    L61:
        if (r13 == false) goto L63;
    L64:
        Object r14 = this.a.getExt().get(ResourceBarConfig.EXT_KEY_MESSAGE);
        if ((r14 instanceof Message) == false) goto L67;
        Message r20 = (Message) r14;
    L68:
        if (r20 == null) goto L72;
        Map r21 = r20.getExt();
        if (r21 == null) goto L72;
        String r22 = (String) r21.get("ref_img_paint_mark");
    L73:
        boolean r23 = Intrinsics.areEqual(r22, "1");
        if (this.a.getMode() == Mode.SHOW) goto L76;
    L81:
        boolean r24 = false;
    L82:
        q1 r25 = q1.a;
        Context r26 = getContext();
        ResourceItemBean r110 = this.l;
        if (r110 == null) goto L85;
        boolean r111 = r110.getImmersiveStyle();
    L86:
        this.j = q1.b(r25, r26, r0, r111);
        if (r24 == true) goto L89;
    L108:
        this.k = r1;
        if (r24 == false) goto L116;
        String r27 = r0.key;
        Uri r112 = y0.h(r6);
        Map r3 = r0.ext;
        if (r3 == null) goto L113;
        boolean r113 = r3.containsKey("ext_is_from_drive");
    L114:
        d5 r114 = new d5(r27, r112, false, r113, 16);
    L134:
        this.g = r114;
        d4(false);
        return;
    L113:
        r113 = false;
        goto L114
    L116:
        if (o0.d(r19) == true) goto L118;
    L124:
        if (r9 != null) goto L128;
        if (r12 == null) goto L129;
        r6 = r12;
    L129:
        Uri r28 = y0.h(r6);
        String r29 = r0.key;
        Map r30 = r0.ext;
        if (r30 == null) goto L132;
        boolean r31 = r30.containsKey("ext_is_from_drive");
    L133:
        r114 = new d5(r29, r28, false, r31, 16);
        goto L134
    L132:
        r31 = false;
        goto L133
    L128:
        r6 = r9;
        goto L129
    L118:
        if (new PolarisFileWrapper(r19).exists() == false) goto L124;
        String r32 = r0.key;
        Uri r33 = Uri.fromFile(new PolarisFileWrapper(r19));
        Map r115 = r0.ext;
        if (r115 == null) goto L122;
        boolean r116 = r115.containsKey("ext_is_from_drive");
    L123:
        r114 = new d5(r32, r33, true, r116, 16);
        goto L134
    L122:
        r116 = false;
        goto L123
    L89:
        if (o0.d(r19) == true) goto L91;
    L93:
        if (r9 == null) goto L108;
        if (r9.length() <= 0) goto L97;
        boolean r34 = true;
    L98:
        if (r34 == true) goto L100;
    L102:
        r2 = false;
    L103:
        if (r2 == false) goto L105;
        String r35 = r9;
    L106:
        if (r35 == null) goto L108;
        r1 = y0.h(r35);
        goto L108
    L105:
        r35 = null;
        goto L106
    L100:
        if (Intrinsics.areEqual(r9, r6) == true) goto L102;
    L97:
        r34 = false;
        goto L98
    L91:
        if (new PolarisFileWrapper(r19).exists() == false) goto L93;
        r1 = Uri.fromFile(new PolarisFileWrapper(r19));
        goto L108
    L85:
        r111 = false;
        goto L86
    L76:
        if (o0.d(r6) == false) goto L81;
        if (Intrinsics.areEqual(r0.aiCreationImage, Boolean.TRUE) == false) goto L81;
        if (r23 == false) goto L81;
        r24 = true;
    L72:
        r22 = null;
        goto L73
    L67:
        r20 = null;
        goto L68
    L60:
        r13 = false;
    L63:
        r12 = null;
        goto L64
    L49:
        r10 = false;
    L52:
        r9 = null;
        goto L53
    L38:
        r7 = false;
    L41:
        r6 = null;
        goto L42
    L30:
        r19 = r0.localResPath;
        goto L31
    L18:
        if ((r18 instanceof String) == false) goto L27;
        if (((CharSequence) r18).length() <= 0) goto L22;
        boolean r36 = true;
    L23:
        if (r36 == false) goto L27;
        if (new PolarisFileWrapper((String) r18).exists() == false) goto L27;
        r4 = true;
        goto L28
    L22:
        r36 = false;
        goto L23
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.view.resourcebar.viewholder.k] */
    public final void d4(final boolean r10) {
        d5 r0 = this.g;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.f == false) goto L12;
        String r4 = r0.a;
        if (r4 != null) goto L10;
        return;
    L10:
        IFlowDriveSdkService.a.a(FlowDriveSdkService.a, this.m, r4, 360, 360, new k(this, r10), 32);
        return;
    L12:
        c4(String.valueOf(r0.b), r0.c, r10);
    }

    public ImgResourceViewHolder(ResourceBarConfig r2, LarusFileResourceItemViewBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "viewBinding");
        super(r2, r3);
        this.m = CoroutineScopeKt.CoroutineScope(JobKt.Job$default(null, 1, null).plus(Dispatchers.getMain()));
        ((RecyclerView.ViewHolder) this).itemView.addOnAttachStateChangeListener(new a(this));
    }

    public final void e4(Message r6, boolean r7) {
        boolean r0 = Intrinsics.areEqual(PollingConfigService.a.f("cre_sc_dg"), "1");
        ResourceItemBean r1 = this.l;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L17;
        if (r6 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L17;
        if (r0 == true) goto L17;
        boolean r5 = true;
    L18:
        ResourceItemBean r8 = this.l;
        if (r8 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == false) goto L33;
        if (r6 != null) goto L27;
    L29:
        boolean r10 = false;
    L30:
        if (r10 == true) goto L33;
        if (r0 == true) goto L33;
        boolean r11 = true;
    L34:
        ImageCoverEditView r12 = this.b.s;
        if (r7 == false) goto L39;
        if (r5 == true) goto L38;
        if (r11 == false) goto L39;
    L38:
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        int r14 = 0;
    L44:
        r12.setVisibility(r14);
        ImageCoverEditView r15 = this.b.s;
        n0 r16 = new n0(Boolean.valueOf(r11), Boolean.valueOf(r5));
        int r17 = ImageCoverEditView.b;
        r15.a(r16, null);
        ResourceItemBean r18 = this.l;
        if (r18 == null) goto L72;
        FrameLayout r19 = this.b.t;
        if (r18.getShowSubscriptView() != true) goto L50;
        boolean r20 = true;
    L51:
        if (r20 == false) goto L53;
        int r21 = 0;
    L54:
        r19.setVisibility(r21);
        FLogger.a.i("ImgResourceViewHolder", "checkShowSubscript:" + r18.getShowSubscriptView());
        Object r22 = r18.getExt().get("ext_avatar_subscript_desc");
        if (r22 != null) goto L57;
    L64:
        r2 = false;
    L66:
        if (ResourceType.AVATAR != r18.getResourceType()) goto L69;
        if (r2 == false) goto L69;
        this.b.u.setText(((String) r22).toString());
        return;
    L69:
        this.b.u.setText("");
        this.b.t.setVisibility(8);
        return;
    L57:
        if ((r22 instanceof String) == false) goto L64;
        if (((CharSequence) r22).length() <= 0) goto L61;
        boolean r23 = true;
    L62:
        if (r23 == false) goto L64;
    L61:
        r23 = false;
        goto L62
    L53:
        r21 = 8;
        goto L54
    L50:
        r20 = false;
        goto L51
    L72:
        return;
    L43:
        r14 = 8;
    L39:
        r13 = false;
        goto L41
    L27:
        if (com.larus.im.bean.message.a.e0(r6) != true) goto L29;
        r10 = true;
    L33:
        r11 = false;
        goto L34
    L21:
        if (r8.getShowEditVideoBtn() != true) goto L23;
        r9 = true;
        goto L24
    L11:
        if (com.larus.im.bean.message.a.e0(r6) != true) goto L13;
        r4 = true;
    L17:
        r5 = false;
        goto L18
    L5:
        if (r1.getShowEditImageBtn() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void c4(final String r11, final boolean r12, final boolean r13) {
        Object r0 = this.a.getExt().get(ResourceBarConfig.EXT_KEY_MESSAGE);
        if ((r0 instanceof Message) == false) goto L5;
        Message r1 = (Message) r0;
    L6:
        final Message r6 = r1;
        final d5 r8 = this.g;
        if (r13 == false) goto L9;
    L12:
        this.h = r11;
        this.i = false;
        Pair<Integer, Integer> r2 = this.j;
        if (r2 != null) goto L15;
        q1 r3 = q1.a;
        Context r4 = getContext();
        r3.getClass();
        r2 = q1.e(r4);
    L15:
        final Pair<Integer, Integer> r5 = r2;
        ImageLoaderKt.y(this.b.r, r11, "chat.send_multi_img", new l(this, r12, r5, r11, r6, r13, r8), 4);
        return;
    L9:
        if (Intrinsics.areEqual(r11, this.h) == false) goto L12;
        FLogger.a.i("ImgResourceViewHolder", "[frescoLoad] uriUnchanged=true, isLocal=" + r12);
        e4(r6, this.i);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
