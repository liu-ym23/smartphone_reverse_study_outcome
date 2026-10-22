package com.ss.android.lark.locationmessage.message;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.message.params.k;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.chat.utils.f0;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.impl.LarkImageUtil;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LocationMessageCell implements r5b.d<LocationContentVO>, u5b.a<LocationContentVO> {
    public static final int h = 0;
    public static final int i = 0;
    public static final Token j = null;
    public final r5b.a a;
    public final r5b.b<LocationContentVO> b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final mqb.a.InterfaceC0298a g;

    public static class LocationMessageViewHolder {
        public final View a;

        @BindView(9425)
        public ImageView mImageView;

        @BindView(9433)
        public View mLoadingProgress;

        @BindView(9717)
        public LKUIRoundableLayout mRoundLayout;

        @BindView(9858)
        public TextView mSubTitleTv;

        @BindView(9943)
        public TextView mTitleTv;

        public LocationMessageViewHolder(View r2) {
            this.a = r2;
            ButterKnife.bind(this, r2);
            zz7.a.d(this.mTitleTv, LarkFont.HEADLINE);
            zz7.a.d(this.mSubTitleTv, LarkFont.CAPTION0);
        }
    }

    public class LocationMessageViewHolder_ViewBinding implements Unbinder {
        public LocationMessageViewHolder a;

        public final void unbind() {
            LocationMessageViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.mRoundLayout = null;
            r0.mTitleTv = null;
            r0.mSubTitleTv = null;
            r0.mImageView = null;
            r0.mLoadingProgress = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public LocationMessageViewHolder_ViewBinding(LocationMessageViewHolder r4, View r5) {
            this.a = r4;
            r4.mRoundLayout = (LKUIRoundableLayout) Utils.findRequiredViewAsType(r5, 2131384849, "field 'mRoundLayout'", LKUIRoundableLayout.class);
            r4.mTitleTv = (TextView) Utils.findRequiredViewAsType(r5, 2131388920, "field 'mTitleTv'", TextView.class);
            r4.mSubTitleTv = (TextView) Utils.findRequiredViewAsType(r5, 2131387558, "field 'mSubTitleTv'", TextView.class);
            r4.mImageView = (ImageView) Utils.findRequiredViewAsType(r5, 2131379141, "field 'mImageView'", ImageView.class);
            r4.mLoadingProgress = Utils.findRequiredView(r5, 2131379149, "field 'mLoadingProgress'");
        }
    }

    public final void f(View r1) {
    }

    static {
        h = UIHelper.dp2px(12.0f);
        i = UIHelper.dp2px(8.0f);
        j = new Token("LARK-PSDA-location_message_cell");
    }

    public final Class<LocationContentVO> c() {
        return LocationContentVO.class;
    }

    public static BubbleStyle b(v5b.c<LocationContentVO> r6) {
        int r4 = 0;
        if (TextUtils.isEmpty(r6.i()) == true) goto L10;
        int[] r0 = new int[4];
        r0[0] = 0;
        r0[1] = i;
        r0[2] = 0;
        if (r6.l() == false) goto L7;
        r4 = h;
    L7:
        r0[3] = r4;
        BubbleStyle.a(12, null, r0);
        return BubbleStyle.h;
    L10:
        if (r6.j() == false) goto L12;
    L17:
        BubbleStyle r7 = BubbleStyle.h;
        r7.b = null;
        r7.e = 0;
        r7.f = 0;
        r7.b();
        r7.c = -1;
        r7.d = -1;
        r7.g = false;
        r7.e = 12;
        r7.b = new WeakReference(null);
        r7.b();
        return r7;
    L12:
        if (r6.m() == true) goto L17;
        if (r6.l() == false) goto L17;
        BubbleStyle.a(12, null, new int[]{0, 0, 0, 0});
        return BubbleStyle.h;
    }

    public final u5b.c i(v5b.c<LocationContentVO> r8) {
        if (r8.h() == false) goto L5;
        int r0 = v4b.a.i;
    L7:
        if (r8.h() == false) goto L9;
        int r1 = v4b.a.i;
    L11:
        if (r8.h() == false) goto L13;
        int r9 = v4b.a.x;
    L14:
        Drawable r10 = UIHelper.getDrawable(r9);
        int r3 = h;
        int[] r2 = {r3, i, r3, 0};
        u5b.c r4 = u5b.c.e;
        return u5b.c.a.a(r0, r1, r10, r2);
    L13:
        r9 = v4b.a.T;
        goto L14
    L9:
        r1 = v4b.a.H;
        goto L11
    L5:
        r0 = v4b.a.H;
        goto L7
    }

    public LocationMessageCell(r5b.a r3, p2b.b r4) {
        this.g = lqb.b.a.getImageDependency();
        this.a = r3;
        this.b = r4;
        int r5 = UIHelper.getWindowWidth(r3.getContext());
        this.c = UIUtils.dp2px(r3.getContext(), 50.0f);
        double r6 = r5;
        this.d = (int) (0.52d * r6);
        int r7 = (int) (r6 * 0.2d);
        this.e = r7;
        this.f = r7;
    }

    public final View a(LayoutInflater r3, ViewGroup r4) {
        return r3.inflate(2131563581, r4, false);
    }

    public final BubbleStyle d(v5b.c<LocationContentVO> r1, View r2) {
        return b(r1);
    }

    public final void e(View r21, int r22, v5b.c<LocationContentVO> r23) {
        LocationMessageViewHolder r1 = (LocationMessageViewHolder) r21.getTag();
        if (r1 != null) goto L5;
        r1 = new LocationMessageViewHolder(r21);
        r21.setTag(r1);
    L5:
        LocationMessageViewHolder r9 = r1;
        LocationContent r3 = ((v5b.a) ((LocationContentVO) r23.b())).a;
        if (r3 == null) goto L94;
        FragmentActivity r6 = this.a.getContext();
        if (TextUtils.isEmpty(r3.getName()) == false) goto L11;
        String r0 = UIHelper.mustacheFormat(2131890400, "title", "");
    L12:
        String r4 = r0;
        String r5 = r3.getDescription();
        r9.mTitleTv.setText(r4);
        if (TextUtils.isEmpty(r5) == false) goto L15;
        r9.mSubTitleTv.setVisibility(8);
    L16:
        ImageSet r2 = r3.getImage();
        if (r2 != null) goto L19;
        Image r11 = null;
    L29:
        if (r11 != null) goto L31;
        ImageView r7 = r9.mImageView;
        LruCache r8 = ImageUtils.a;
        int r10 = UIUtils.dp2px(r6, 100.0f);
        ImageLoader.with(r6).load(2131232625).override(r10, r10).centerCrop().into(r7);
    L76:
        if (TextUtils.isEmpty(r23.i()) == true) goto L78;
    L87:
        r9.mRoundLayout.setRadius(0.0f);
        r9.mRoundLayout.setBorderWidth(0.0f);
        r9.mRoundLayout.setBackground(null);
    L88:
        r9.a.setOnClickListener(new d(this, r23, r3, r4, r5, r6));
        r9.a.setOnLongClickListener(new e(this, r9, r23));
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r9.mTitleTv.getLayoutParams();
        if (TextUtils.isEmpty(r23.i()) == false) goto L91;
        int r13 = UIUtils.dp2px(this.a.getContext(), 10.0f);
    L92:
        int r14 = h;
        r12.setMargins(r14, r13, r14, 0);
        return;
    L91:
        r13 = 0;
        goto L92
    L78:
        if (r23.l() == true) goto L80;
    L82:
        int r15 = f0.a;
        Intrinsics.checkNotNullParameter(r23, "messageVO");
        float[] r16 = f0.a(r23, 10.0f, 2.0f);
        r9.mRoundLayout.setRadius(r16[0], r16[1], r16[2], r16[3]);
        r9.mRoundLayout.setBorderWidth(1.0f);
        LKUIRoundableLayout r17 = r9.mRoundLayout;
        Integer r18 = Integer.valueOf(b(r23).e);
        k r19 = this.a.d0(k.class);
        if (r18.intValue() != 19) goto L85;
        Integer r20 = Integer.valueOf(UIUtils.getColor(r6, 2131103351));
    L86:
        r17.setBorderColor(r20.intValue());
        r9.mRoundLayout.setBackgroundColor(UIUtils.getColor(this.a.getContext(), 2131100557));
        goto L88
    L85:
        r20 = Integer.valueOf(UIUtils.getColor(r6, 2131102450));
        goto L86
    L80:
        if (this.a.m() == true) goto L82;
    L31:
        if (CollectionUtils.isNotEmpty(r11.getUrls()) == false) goto L33;
        String r110 = (String) ListProtector.get(r11.getUrls(), 0);
    L33:
        Image r111 = r3.getImage().getOrigin();
        int r112 = r111.getWidth();
        int r113 = r111.getHeight();
        int r114 = this.c;
        int r24 = this.d;
        if (r114 <= r24) goto L36;
        int r115 = this.e;
    L37:
        if (r114 <= r24) goto L39;
        int r116 = this.f;
    L40:
        int[] r25 = ImageUtils.g(r112, r113, r24, r24, r115, r116);
        int r26 = r25[0];
        int r27 = r25[1];
        if (r23.getcId().equals(r9.mImageView.getTag(2131365616)) == true) goto L43;
    L45:
        boolean r117 = false;
    L46:
        if (r117 == false) goto L48;
        Drawable r118 = r9.mImageView.getDrawable();
    L49:
        if (r118 == null) goto L51;
        Drawable r119 = r118;
    L52:
        if (r118 != null) goto L55;
        r118 = new ColorDrawable(ContextCompat.getColor(this.a.getContext(), 2131100556));
    L55:
        View r28 = r9.mLoadingProgress;
        if (r117 == true) goto L58;
        int r120 = 0;
    L59:
        r28.setVisibility(r120);
        boolean r29 = this.a.isSecretChat();
        if (r29 == false) goto L63;
        Scene r121 = Scene.SecretChat;
    L69:
        mqb.a.InterfaceC0298a r122 = this.g;
        ImageView r30 = r9.mImageView;
        LoadParams r31 = new LoadParams();
        r31.a = r26;
        r31.b = r27;
        r31.c = r119;
        r31.d = r118;
        if (r29 == false) goto L72;
        DiskCacheStrategy r32 = DiskCacheStrategy.NONE;
    L73:
        r31.h = r32;
        r31.i = r29;
        ListenerParams.a r33 = new ListenerParams.a();
        r33.b = true;
        r33.a = true;
        r33.h = new c(r9);
        r33.o = r11.getKey();
        r33.p = TextUtils.equals(r11.getKey(), r111.getKey());
        r33.d(r121);
        r31.l = r33.b();
        ((com.ss.android.lark.integrator.im.message.a) r122).getClass();
        EncryptImage r34 = new EncryptImage(r11.getKey(), r11.getFsUnit(), r11.getCrypto());
        r34.setStoreToPrivatePath(r31.i);
        LarkImageUtil.loadImage(r6, r30, r34, r31);
        r9.mImageView.setTag(2131365616, r23.getcId());
        goto L76
    L72:
        r32 = DiskCacheStrategy.ALL;
        goto L73
    L63:
        if (this.a.r() == false) goto L65;
    L68:
        r121 = Scene.Thread;
        goto L69
    L65:
        if (this.a.q() == true) goto L68;
        r121 = Scene.Chat;
        goto L69
    L58:
        r120 = 8;
        goto L59
    L51:
        r119 = new ColorDrawable(ContextCompat.getColor(this.a.getContext(), 2131100549));
        goto L52
    L48:
        r118 = null;
        goto L49
    L43:
        if (r9.mImageView.getDrawable() == null) goto L45;
        r117 = true;
        goto L46
    L39:
        r116 = r114;
        goto L40
    L36:
        r115 = r114;
        goto L37
    L19:
        r11 = r2.getOrigin();
        if (r11 == null) goto L29;
        if (CollectionUtils.isEmpty(r11.getUrls()) == true) goto L29;
        if (URLUtil.isNetworkUrl((String) ListProtector.get(r11.getUrls(), 0)) == false) goto L29;
        r11 = r2.getThumbnail();
        goto L29
    L15:
        r9.mSubTitleTv.setVisibility(0);
        r9.mSubTitleTv.setText(r5);
        goto L16
    L11:
        r0 = r3.getName();
        goto L12
    }
}
