package com.ss.android.lark.chatwindow.view.preview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.PreviewVideo;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements c<b, h2b.d> {
    public final Context a;
    public final View.OnLongClickListener b;
    public final a c;
    public final com.ss.android.lark.chatwindow.view.preview.b d;
    public final BrowserDependency e;
    public final w4b.a f;

    public interface a {
        boolean a();

        String b();

        boolean isGroup();
    }

    public static final class b extends c.a {
        public final LinearLayout b;
        public final View c;
        public final TextView d;
        public final TextView e;
        public final ImageView f;
        public final ImageView g;
        public final ImageView h;

        public b(ViewGroup r5, com.ss.android.lark.chatwindow.view.preview.b r6) {
            Intrinsics.checkNotNullParameter(r5, "itemView");
            Intrinsics.checkNotNullParameter(r6, "extraProvider");
            super(r5);
            this.b = (LinearLayout) r5.findViewById(2131391960);
            this.c = r5.findViewById(2131369241);
            TextView r0 = (TextView) r5.findViewById(2131391963);
            this.d = r0;
            TextView r1 = (TextView) r5.findViewById(2131391952);
            this.e = r1;
            ImageView r2 = (ImageView) r5.findViewById(2131391957);
            this.f = r2;
            this.g = (ImageView) r5.findViewById(2131392351);
            this.h = (ImageView) r5.findViewById(2131382453);
            zz7.a.a(r2, r6.b());
            zz7.a.d(r0, r6.c());
            zz7.a.d(r1, r6.a());
        }
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final int getPreviewType() {
        return 1;
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final void a(h2b.a r20, c.a r21) {
        h2b.d r0 = (h2b.d) r20;
        b r7 = (b) r21;
        ImageView r1 = null;
        if (r0 == null) goto L5;
        MessageUrlPreview r2 = r0.a;
    L6:
        boolean r8 = true;
        if (r2 == null) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L99;
        if (r0 == null) goto L96;
        MessageUrlPreview r10 = r0.a;
        if (r10 == null) goto L97;
        ImageSet r4 = r10.getIcon();
        if (CollectionUtils.isNotEmpty(r4.getOrigin().getUrls()) == false) goto L18;
        String r5 = (String) ListProtector.get(r4.getOrigin().getUrls(), 0);
        int r6 = 2131256437;
    L19:
        String r9 = r10.getTitle();
        String r11 = r10.getDescription();
        Context r12 = this.a;
        if ((r12 instanceof Activity) == true) goto L22;
    L23:
        IRequestCreator r13 = ImageLoader.with(this.a).load(r5).error(r6);
        if (r7 == null) goto L26;
        ImageView r14 = r7.f;
    L27:
        r13.into(r14);
    L28:
        if (r7 == null) goto L32;
        TextView r15 = r7.d;
        if (r15 == null) goto L32;
        r15.setText(r9);
    L32:
        int r16 = 8;
        if (r7 == null) goto L41;
        TextView r17 = r7.d;
        if (r17 == null) goto L41;
        if (TextUtils.isEmpty(r9) == true) goto L39;
        int r18 = 0;
    L40:
        r17.setVisibility(r18);
        goto L41
    L39:
        r18 = 8;
    L41:
        if (r7 == null) goto L45;
        TextView r19 = r7.e;
        if (r19 == null) goto L45;
        r19.setText(r11);
    L45:
        if (r7 == null) goto L53;
        TextView r22 = r7.e;
        if (r22 == null) goto L53;
        if (TextUtils.isEmpty(r11) == true) goto L51;
        int r23 = 0;
    L52:
        r22.setVisibility(r23);
        goto L53
    L51:
        r23 = 8;
    L53:
        if (r7 == null) goto L61;
        TextView r24 = r7.e;
        if (r24 == null) goto L61;
        boolean r25 = this.c.a();
        int r26 = p3b.a.W;
        if (r25 == false) goto L59;
        int r27 = v4b.a.u;
    L60:
        r24.setTextColor(r27);
        goto L61
    L59:
        r27 = v4b.a.R;
    L61:
        ImageSet r28 = r10.getCoverImage();
        String r110 = r10.getUrl();
        View.OnLongClickListener r29 = this.b;
        if (r28 != null) goto L64;
    L77:
        r8 = false;
    L78:
        if (r7 == null) goto L82;
        LinearLayout r30 = r7.b;
        if (r30 == null) goto L82;
        r30.setOnClickListener(new e(this, r10, r8, r110));
    L82:
        if (r7 == null) goto L98;
        LinearLayout r31 = r7.b;
        r31.setVisibility(0);
        ImageView r32 = r7.g;
        if (r8 == false) goto L86;
        int r33 = 0;
    L87:
        r32.setVisibility(r33);
        ImageView r34 = r7.h;
        if (r8 == false) goto L90;
        r16 = 0;
    L90:
        r34.setVisibility(r16);
        View r35 = r7.c;
        boolean r36 = this.c.a();
        int r37 = p3b.a.W;
        if (r36 == false) goto L93;
        int r38 = v4b.a.h;
    L94:
        r35.setBackgroundColor(r38);
        r31.setPadding(0, UIHelper.dp2px(7.5f), 0, 0);
        return;
    L93:
        r38 = v4b.a.G;
        goto L94
    L86:
        r33 = 8;
        goto L87
    L98:
        return;
    L64:
        if (CollectionUtils.isNotEmpty(r28.getOrigin().getUrls()) == false) goto L77;
        Drawable r39 = UIHelper.getDrawable(2131233569);
        LoadParams r40 = new LoadParams();
        r40.c = r39;
        r40.d = r39;
        r40.e = ImageView.ScaleType.FIT_CENTER;
        r40.h = DiskCacheStrategy.ALL;
        ListenerParams.a r41 = new ListenerParams.a();
        r41.a(Biz.Messenger);
        r41.d(Scene.Chat);
        r41.c(ListenerParams.FromType.URL_PREVIEW);
        r40.l = r41.b();
        Context r111 = this.a;
        if (r7 == null) goto L68;
        r1 = r7.g;
    L68:
        com.ss.android.lark.chat.utils.g.g(r111, r1, r28.getOrigin(), r40, null, null);
        PreviewVideo r42 = r10.getPreviewVideo();
        if (r7 == null) goto L73;
        ImageView r43 = r7.g;
        if (r43 == null) goto L73;
        r43.setOnLongClickListener(r29);
    L73:
        if (r7 == null) goto L78;
        ImageView r112 = r7.g;
        if (r112 == null) goto L78;
        r112.setOnClickListener(new f(this, r110, r42, r28, r7));
        goto L78
    L26:
        r14 = null;
        goto L27
    L22:
        if (((Activity) r12).isFinishing() == true) goto L28;
    L18:
        r5 = null;
        r6 = 0;
        goto L19
    L97:
        return;
    L96:
        return;
    L99:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final c.a b(h2b.a r2, ViewGroup r3) {
        h2b.d r4 = (h2b.d) r2;
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == null) goto L5;
        MessageUrlPreview r5 = r4.a;
    L6:
        if (r5 == null) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        return null;
    L12:
        return new b(r3, this.d);
    L8:
        r6 = false;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public d(FragmentActivity r2, View.OnLongClickListener r3, m7b.d r4, m7b.e r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "dataProvider");
        Intrinsics.checkNotNullParameter(r5, "extraProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = ChatCoreModule.a().getBrowserDependency();
        this.f = ChatCoreModule.a().getAuditDependency();
    }
}
