package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.ss.android.lark.chat.preview.components.view.SpinButton;
import com.ss.android.lark.chat.preview.components.view.UDListDialogAdapter;
import com.ss.android.lark.chat.preview.entity.component.property.SpinButtonProperty;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Item;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q extends q6c.e<SpinButtonProperty, SpinButton, r6c.a> {
    public final Style f;
    public final Map<String, UrlPreviewAction> g;
    public final String h;
    public final URLPreviewParams i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ q a;
        public final /* synthetic */ SpinButton b;

        public b(q r1, SpinButton r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            q r14 = this.a;
            Long r0 = ((SpinButtonProperty) ((q6c.e) r14).e).getSelectedIndex();
            List<Item> r1 = ((SpinButtonProperty) ((q6c.e) this.a).e).getItems();
            q r2 = this.a;
            Map<String, UrlPreviewAction> r3 = r2.g;
            SpinButton r4 = this.b;
            SpinButtonProperty r5 = (SpinButtonProperty) ((q6c.e) r2).e;
            String r6 = null;
            if (r1 == null) goto L8;
            List<Item> r7 = r1;
            ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r9 = r7.iterator();
        L6:
            if (r9.hasNext() == false) goto L9;
            r8.add(((Item) r9.next()).getText());
        L9:
            ArrayList r10 = new ArrayList();
            if (r8 == null) goto L22;
            Iterator r11 = r8.iterator();
        L13:
            if (r11.hasNext() == false) goto L17;
            String r12 = (String) r11.next();
            if (r12 == null) goto L13;
            r10.add(r12);
            goto L13
        L17:
            UDActionPanelBuilder r15 = new UDActionPanelBuilder(r4.getContext()).items(r10);
            Context r16 = r4.getContext();
            if (r0 == null) goto L20;
            int r17 = (int) r0.longValue();
        L21:
            r15.adapter(new UDListDialogAdapter(r16, r17, 2131105548)).itemClickListener(new r(r1, r14, r4, r3)).addActionButton(2131391775, r4.getContext().getString(2131891541), null).onDismissListener(new s(r4)).show();
            goto L22
        L20:
            r17 = 0;
        L22:
            g6b.a.InterfaceC0223a r18 = g6b.a.a;
            if (r18 == null) goto L34;
            com.ss.android.lark.officesdk.integrator.im.a r19 = r18.a();
            if (r19 == null) goto L34;
            q r110 = this.a;
            URLPreviewParams r20 = r110.i;
            String r21 = r20.c;
            String r22 = r20.a;
            String r23 = r110.h;
            Long r111 = r20.h;
            if (r111 == null) goto L29;
            String r24 = r111.toString();
        L30:
            Long r112 = this.a.i.i;
            if (r112 == null) goto L33;
            r6 = r112.toString();
        L33:
            r19.c(r21, r22, "page_click", r23, null, r24, r6, this.a.i.e);
            goto L34
        L29:
            r24 = null;
        L34:
            this.b.d();
            return;
        L8:
            r8 = null;
            goto L9
        }
    }

    static {
    }

    public final String i() {
        return "om.ss.android.lark.chat.preview.components.view.SpinButton";
    }

    public final boolean j() {
        return true;
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    L5:
        return new SpinButton(r1.getContext());
    }

    public final s6c.b.a d(s6c.b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 == null) goto L6;
        SpinButton r0 = new SpinButton(r1.getContext());
        k(r0);
        s6c.b.a r5 = r0.b(r4);
        return new s6c.b.a((r5.a + 4.0f) + (zz7.b.d().getMultiplier() * 10.0f), r5.b);
    L6:
        Intrinsics.checkNotNullParameter(r4, "size");
        return r4;
    }

    public final void k(SpinButton r11) {
        Long r0 = ((SpinButtonProperty) ((q6c.e) this).e).getSelectedIndex();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = (int) r0.longValue();
    L6:
        List<Item> r3 = ((SpinButtonProperty) ((q6c.e) this).e).getItems();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        if (r2 < r1) goto L11;
        return;
    L11:
        List<Item> r4 = ((SpinButtonProperty) ((q6c.e) this).e).getItems();
        if (r4 == null) goto L29;
        Item r5 = (Item) ListProtector.get(r4, r2);
        int r9 = (int) (UIHelper.dp2px(10.0f) * zz7.b.d().getMultiplier());
        String r6 = r5.getText();
        Style r7 = this.f;
        if (r7 == null) goto L16;
        ThemeColor r8 = r7.getTextColorV2();
    L17:
        Style r10 = this.f;
        if (r10 == null) goto L20;
        FontLevel r12 = r10.getFontLevel();
    L21:
        ImageSet r13 = ((SpinButtonProperty) ((q6c.e) this).e).getIcon();
        if (r13 == null) goto L26;
        Image r14 = r13.getThumbnail();
        if (r14 == null) goto L26;
        String r15 = r14.getKey();
    L27:
        r11.c(r6, r8, r12, r15, null, r9, r9);
        return;
    L26:
        r15 = null;
        goto L27
    L20:
        r12 = null;
        goto L21
    L16:
        r8 = null;
        goto L17
    L29:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void update(SpinButton r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.update(r4);
        Style r0 = this.f;
        if (r0 == null) goto L5;
        Style.applyBackground$default(r0, r4, null, 2, null);
    L5:
        r4.setOnClickListener(new b(this, r4));
        k(r4);
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((SpinButton) r1);
    }

    public q(SpinButtonProperty r2, Style r3, vcb.d r4, Map<String, UrlPreviewAction> r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
        this.g = r5;
        this.h = r6;
        this.i = r4.d;
    }
}
