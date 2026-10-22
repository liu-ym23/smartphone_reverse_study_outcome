package com.bytedance.android.live.revlink.impl.intercomment;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r11.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/intercomment/InteractCommentInviteDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractCommentInviteDialog extends CommonBottomDialog {
    public String a;
    public final a b;

    public interface a {
        void a();

        void b(boolean r1);
    }

    public final String getDegradeTag() {
        return "anchor_intercom_panel";
    }

    public final int getLayoutId() {
        return 2131565587;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        s41.b r8 = s41.b.c;
        u r0 = r8.a();
        String r2 = null;
        if (r0 == null) goto L15;
        String r4 = r0.f();
        if (r4 == null) goto L15;
        if (r4.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        ((TextView) findViewById(2131390795)).setText(r4);
        goto L15
    L9:
        r5 = false;
    L15:
        if (r0 == null) goto L27;
        String r6 = r0.e();
        if (r6 == null) goto L27;
        if (r6.length() <= 0) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L25;
        r6 = null;
    L25:
        if (r6 == null) goto L27;
        ((TextView) findViewById(2131390796)).setText(r6);
        goto L27
    L21:
        r9 = false;
    L27:
        if (r0 == null) goto L38;
        String r1 = r0.d();
        if (r1 == null) goto L38;
        if (r1.length() <= 0) goto L33;
        boolean r10 = true;
    L34:
        if (r10 == false) goto L36;
        r2 = r1;
    L36:
        if (r2 == null) goto L38;
        this.a = r2;
        goto L38
    L33:
        r10 = false;
    L38:
        ImageLoader.bindImage(findViewById(2131376319), this.a);
        ((LinearLayout) findViewById(2131378617)).setOnClickListener(x0.a(new AnonymousClass7(this)));
        ((Button) findViewById(2131364600)).setOnClickListener(x0.a(new AnonymousClass8(this)));
        if (r8.a().a() == false) goto L41;
        ((ImageView) findViewById(2131367374)).setVisibility(0);
        ((ImageView) findViewById(2131367374)).setOnClickListener(x0.a(new AnonymousClass9(this)));
    L42:
        setCanceledOnTouchOutside(true);
        return;
    L41:
        ((ImageView) findViewById(2131367374)).setVisibility(8);
        goto L42
    }

    public InteractCommentInviteDialog(Context r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = r3;
        this.a = "https://" + k0.a + "/obj/live-android/ttlive_inter_comment_caption.png";
    }
}
