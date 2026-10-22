package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.text.Layout;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.preview.components.view.TimingView;
import com.ss.android.lark.chat.preview.entity.component.property.TimeProperty;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TimingComponent extends q6c.e<TimeProperty, TimingView, r6c.a> {
    public static final int l = 0;
    public final Style f;
    public final com.ss.android.lark.chat.preview.actions.b g;
    public final String h;
    public final boolean i;
    public final URLPreviewParams j;
    public TimingView k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TimingComponent a;

        public b(TimingComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            com.ss.android.lark.chat.preview.actions.b r12 = this.a.g;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r12.a(1);
            UrlPreviewAction r13 = this.a.g.a;
            g6b.a.InterfaceC0223a r1 = g6b.a.a;
            if (r1 == null) goto L19;
            com.ss.android.lark.officesdk.integrator.im.a r2 = r1.a();
            if (r2 == null) goto L20;
            String r3 = null;
            if (r13 == null) goto L9;
            String r4 = r13.getUrl();
        L10:
            TimingComponent r14 = this.a;
            URLPreviewParams r5 = r14.j;
            String r6 = r5.a;
            String r7 = r14.h;
            String r15 = r14.g.b;
            Long r8 = r5.h;
            if (r8 == null) goto L13;
            String r9 = r8.toString();
        L14:
            Long r10 = this.a.j.i;
            if (r10 == null) goto L17;
            r3 = r10.toString();
        L17:
            r2.c(r4, r6, "page_click", r7, r15, r9, r3, this.a.j.e);
            return;
        L13:
            r9 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L20:
            return;
        }
    }

    public final String i() {
        return "com.ss.android.lark.chat.preview.components.view.TimingView";
    }

    public final boolean j() {
        return true;
    }

    static {
        l = UIHelper.dp2px(2.0f);
    }

    public final void b() {
        TimingView r0 = this.k;
        if (r0 == null) goto L6;
        r0.y();
        return;
    }

    public final View a(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "size");
        r6c.a r3 = ((q6c.a) this).a;
        if (r3 == null) goto L9;
        Context r4 = r3.getContext();
        if (r4 != null) goto L8;
        return null;
    L8:
        return new TimingView(r4);
    L9:
        return null;
    }

    public final s6c.b.a d(s6c.b.a r6) {
        Intrinsics.checkNotNullParameter(r6, "size");
        int r7 = UIHelper.dp2px(r6.a);
        r6c.a r0 = ((q6c.a) this).a;
        float r1 = 0.0f;
        if (r0 == null) goto L25;
        Context r2 = r0.getContext();
        if (r2 == null) goto L25;
        int r3 = h6b.a.a;
        Style r4 = this.f;
        if (r4 == null) goto L10;
        FontLevel r5 = r4.getFontLevel();
    L11:
        int r8 = (int) h6b.a.c(r2, r5);
        int r9 = k(r2);
        TextLayoutBuilder r10 = new TextLayoutBuilder();
        r10.h("999:59:59");
        r10.j(r8);
        r10.i(r9);
        int r11 = l;
        r10.f(r7 - r11);
        Layout r12 = r10.a();
        if (r12 == null) goto L14;
        Style r13 = this.f;
        if (r13 == null) goto L18;
        r1 = r13.getWidth();
    L18:
        int r14 = UIHelper.dp2px(r1);
        if (r14 > 0) goto L23;
        r14 = r12.getWidth() + r11;
    L23:
        return new s6c.b.a(UIHelper.px2dp(r14 + 20), UIHelper.px2dp(com.ss.android.lark.widget.light.layout.e.a(r12)));
    L14:
        return new s6c.b.a(0.0f, 0.0f);
    L10:
        r5 = null;
    L25:
        return new s6c.b.a(0.0f, 0.0f);
    }

    public final int k(Context r3) {
        Style r0 = this.f;
        if (r0 == null) goto L8;
        ThemeColor r1 = r0.getTextColorV2();
        if (r1 == null) goto L8;
        return com.ss.android.lark.export.entity.preview.a.a(r1, r3, null);
    L8:
        r6c.a r4 = ((q6c.a) this).a;
        if (r4 == null) goto L15;
        Context r5 = r4.getContext();
        if (r5 == null) goto L15;
        Resources r6 = r5.getResources();
        if (r6 == null) goto L15;
        int r7 = r6.getColor(2131103449);
    L17:
        return j08.b.b(r7, 0.5f);
    L15:
        r7 = 0;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void update(TimingView r11) {
        Intrinsics.checkNotNullParameter(r11, "view");
        this.k = r11;
        if (this.i == false) goto L5;
        r11.setGravity(21);
    L6:
        r11.setTextColor(k(r11.getContext()));
        if (Intrinsics.areEqual(((TimeProperty) ((q6c.e) this).e).isEnd(), Boolean.FALSE) == false) goto L11;
        TimeProperty r0 = (TimeProperty) ((q6c.e) this).e;
        if (r11.a != null) goto L11;
        com.ss.android.lark.chat.preview.components.view.i r3 = new com.ss.android.lark.chat.preview.components.view.i(r11, r0);
        long r1 = System.currentTimeMillis();
        r11.a = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(r3, (((r1 / 1000) + 1) * 1000) - r1, 1000, TimeUnit.MILLISECONDS);
    L11:
        r11.z((TimeProperty) ((q6c.e) this).e, true);
        vcb.d r2 = null;
        if (this.g != null) goto L14;
        r11.setOnClickListener(null);
        r11.setClickable(false);
    L15:
        int r4 = h6b.a.a;
        Context r5 = r11.getContext();
        Style r6 = this.f;
        if (r6 == null) goto L18;
        FontLevel r7 = r6.getFontLevel();
    L19:
        r11.setTextSize(0, h6b.a.c(r5, r7));
        r6c.a r12 = ((q6c.a) this).a;
        if ((r12 instanceof vcb.d) == false) goto L22;
        r2 = (vcb.d) r12;
    L22:
        if (r2 == null) goto L29;
        LifecycleOwner r13 = r2.b;
        if (r13 == null) goto L30;
        Lifecycle r14 = r13.getLifecycle();
        if (r14 == null) goto L31;
        r14.addObserver(new AnonymousClass2(this));
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L18:
        r7 = null;
        goto L19
    L14:
        r11.setOnClickListener(new b(this));
        goto L15
    L5:
        r11.setGravity(19);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ void update(View r1) {
        update((TimingView) r1);
    }

    public TimingComponent(TimeProperty r2, Style r3, vcb.d r4, com.ss.android.lark.chat.preview.actions.b r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r4.d;
    }
}
