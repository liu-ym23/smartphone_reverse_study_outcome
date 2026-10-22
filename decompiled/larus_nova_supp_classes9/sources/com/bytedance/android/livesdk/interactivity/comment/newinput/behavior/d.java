package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import am2.x;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends c {
    public TextView i;
    public ImageView j;
    public Map<Integer, com.bytedance.android.livesdk.interactivity.api.comment.data.f> k;
    public com.bytedance.android.livesdk.interactivity.api.comment.data.f l;

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c
    public final int c() {
        return 2131567040;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final View getView() {
        if (this.a != null) goto L15;
        ImageView r2 = null;
        View r0 = LayoutInflater.from(getContext()).inflate(2131567040, null);
        this.a = r0;
        if (r0 == null) goto L7;
        TextView r1 = (TextView) r0.findViewById(2131367920);
    L8:
        this.i = r1;
        View r3 = this.a;
        if (r3 == null) goto L11;
        r2 = (ImageView) r3.findViewById(2131367921);
    L11:
        this.j = r2;
        View r4 = this.a;
        if (r4 == null) goto L15;
        r4.setTag(this.f);
        goto L15
    L7:
        r1 = null;
    L15:
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void k(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r8) {
        Intrinsics.checkNotNullParameter(r8, "bridges");
        super.k(r8);
        Map<Integer, com.bytedance.android.livesdk.interactivity.api.comment.data.f> r9 = this.k;
        if (r9 != null) goto L6;
        return;
    L6:
        if (r9.keySet().size() <= 0) goto L39;
        Iterator<com.bytedance.android.livesdk.interactivity.api.comment.data.f> r10 = r9.values().iterator();
    L9:
        if (r10.hasNext() == false) goto L49;
        com.bytedance.android.livesdk.interactivity.api.comment.data.f r0 = r10.next();
        if (r0 == null) goto L9;
        if (r0.type != 1) goto L9;
        if (r0.status != 1) goto L9;
        this.l = r0;
        if (r0.a == null) goto L32;
        ImageView r1 = this.j;
        if (r1 == null) goto L26;
        ImageView r4 = this.j;
        if (r4 == null) goto L24;
        Resources r5 = r4.getResources();
    L25:
        r1.setBackgroundDrawable(new BitmapDrawable(r5, r0.a));
        goto L26
    L24:
        r5 = null;
    L26:
        ImageView r2 = this.j;
        if (r2 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r2);
    L29:
        TextView r3 = this.i;
        if (r3 == null) goto L32;
        UtilityKotlinExtentionsKt.u(r3);
    L32:
        View r6 = this.a;
        if (r6 == null) goto L35;
        r6.setVisibility(0);
    L35:
        String r7 = r0.text;
        if (r7 != null) goto L38;
        r7 = s1.B(2131915935);
    L38:
        HashMap r11 = new HashMap();
        r11.put("is_red_point", "0");
        r11.put("content", r7);
        j0.l().sendLog("livesdk_customer_service_entrance_show", r11, new Object[]{IRoom.class, x.class});
        goto L9
    L49:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void r(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r3 = r2.V();
        if (r3 == null) goto L5;
        Map<Integer, com.bytedance.android.livesdk.interactivity.api.comment.data.f> r4 = r3.d;
    L6:
        this.k = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public d(InputFunctionEnum r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r11, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r13) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r13, "bridges");
        super.t(r11, r13);
        com.bytedance.android.livesdk.interactivity.api.comment.data.f r14 = this.l;
        if (r14 == null) goto L44;
        String r0 = r14.schema;
        if (r0 == null) goto L45;
        String r15 = r14.text;
        if (r15 != null) goto L10;
        r15 = s1.B(2131915935);
    L10:
        Uri r1 = UriProtector.parse(r0);
        String r3 = UriProtector.getQueryParameter(r1, "url");
        if (r3 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L30;
        Uri.Builder r4 = UriProtector.parse(r3).buildUpon();
        IBaseUser r7 = r13.b0();
        if (r7 == null) goto L22;
        String r8 = r7.getIdString();
        if (r8 == null) goto L22;
    L23:
        String r5 = r4.appendQueryParameter("selfId", r8).build().toString();
        Uri.Builder r9 = r1.buildUpon().clearQuery();
        Iterator r10 = UriProtector.getQueryParameterNames(r1).iterator();
    L25:
        if (r10.hasNext() == false) goto L29;
        String r16 = (String) r10.next();
        if ((!Intrinsics.areEqual(r16, "url")) == false) goto L25;
        r9.appendQueryParameter(r16, UriProtector.getQueryParameter(r1, r16));
        goto L25
    L29:
        r9.appendQueryParameter("url", r5);
        r1 = r9.build();
    L22:
        r8 = BuildConfig.FLAVOR;
    L30:
        IBaseLiveActionHandler r2 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r2 == null) goto L33;
        boolean r17 = r2.handle(getContext(), r1);
    L35:
        if (r17 == true) goto L37;
        f2.c(s1.B(2131915934), 0);
        SafetyGuard.a(null, null, "customerServiceBtn uri error");
        ALogger.e("customerServiceBtn", "handle uri error, uri is ".concat(r0));
    L37:
        r13.J();
        HashMap r18 = new HashMap();
        r18.put("is_red_point", "0");
        r18.put("content", r15);
        j0.l().sendLog("livesdk_customer_service_entrance_click", r18, new Object[]{IRoom.class, x.class});
        ALogger.i("customerServiceBtn", "handle uri success, uri is ".concat(r0));
        return;
    L33:
        r17 = false;
        goto L35
    L13:
        if (r3.length() == 0) goto L16;
        r6 = false;
        goto L17
    L45:
        return;
    }
}
