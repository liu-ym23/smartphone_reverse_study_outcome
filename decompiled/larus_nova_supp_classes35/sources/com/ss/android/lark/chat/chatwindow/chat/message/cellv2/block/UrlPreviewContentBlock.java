package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import android.widget.LinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chatwindow.view.preview.UrlPreviewBinder;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UrlPreviewContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;

    public static final class a implements UrlPreviewBinder.c {
        public final /* synthetic */ mya.f a;
        public final /* synthetic */ y6b.a<?> b;

        public a(mya.f r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.chatwindow.view.preview.UrlPreviewBinder.c
        public final boolean a(LKUIRoundableLayout r3, PreviewHangPoint r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "previewHangPoint");
            return this.a.h(r3, r4, this.b.getId());
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> a;
        public final /* synthetic */ UrlPreviewContentBlock b;
        public final /* synthetic */ y6b.a<?> c;

        public b(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, UrlPreviewContentBlock r2, y6b.a<?> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, this.c);
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c implements b3b.t {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // b3b.t
        public final void E(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public UrlPreviewContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.URL_PREVIEW_CONTENT;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r9, com.ss.android.lark.blueprint.q<y6b.a<?>> r10, y6b.a<?> r11) {
        Intrinsics.checkNotNullParameter(r9, "cell");
        Intrinsics.checkNotNullParameter(r10, "layout");
        Intrinsics.checkNotNullParameter(r11, Keys.API_RETURN_KEY_DATA);
        Object r0 = r11.b();
        if ((r0 instanceof BaseTextContentVO) == false) goto L5;
        BaseTextContentVO r1 = (BaseTextContentVO) r0;
    L6:
        if (r1 != null) goto L9;
        r10.o(this.g, IMMessageKeys$Slots.CONTENT);
        return;
    L9:
        LinearLayout r12 = (LinearLayout) r10.c(IMMessageKeys$Blocks.URL_PREVIEW_CONTENT, IMMessageKeys$Slots.CONTENT, new UrlPreviewContentBlock$update$rootLayout$1(this)).getView();
        com.ss.android.lark.chatwindow.view.preview.i.b(r1.C);
        UrlPreviewBinder r2 = new UrlPreviewBinder(getContext(), new b(r9, this, r11), new f3b.d(r11, this.c.getChat(), this.c.x8()), this.c, c.a);
        Map<String, PreviewHangPoint> r3 = r1.C;
        Map<String, xcb.b> r4 = r1.B;
        RichText r5 = r1.g();
        if (r5 == null) goto L12;
        List<String> r6 = j6b.k.a(r5, r1.C);
    L13:
        h2b.c r13 = new h2b.c(r3, r4, r6, false);
        List r7 = this.c.j5().c(mya.f.class);
        if ((!r7.isEmpty()) == false) goto L16;
        r2.h = new a((mya.f) CollectionsKt.first(r7), r11);
    L16:
        Intrinsics.checkNotNullParameter(r12, "parent");
        r2.c(r13, new UrlPreviewBinder.b(r12));
        return;
    L12:
        r6 = CollectionsKt.emptyList();
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
