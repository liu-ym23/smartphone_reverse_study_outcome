package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.comment.input.OGCFixedCommentAdapter;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.OGCFixedInputSectionBoard;
import com.bytedance.android.livesdk.interactivity.comment.view.ScaleAlphaLinearLayoutManager;
import com.bytedance.android.livesdk.model.ExpressionSection;
import com.bytedance.android.livesdk.widget.board.ExpressionContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class OGCFixedCommentSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<OGCFixedCommentSectionController, Object> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public OGCFixedCommentSectionController c;
    public View d;
    public final DataCenter e;

    public final class FixedCommentPageProvider implements com.bytedance.android.livesdk.interactivity.api.input.viewpager.b {
        public final d0 a;
        public final /* synthetic */ OGCFixedCommentSectionProvider b;

        public static final class a extends com.bytedance.android.livesdk.interactivity.api.input.viewpager.c {
            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.c
            public final CharSequence a() {
                return "评论";
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.c
            public final void c() {
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.c
            public final void b() {
                com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_shortcut_message_panel_show", MapsKt.mapOf(TuplesKt.to("tab_type", "message")), new Object[]{new am2.x(), IRoom.class});
            }

            public a() {
            }
        }

        public static final class b implements com.bytedance.android.livesdk.interactivity.api.input.viewpager.a {
            public final /* synthetic */ View a;

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.a
            public final void a() {
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.a
            public final void unbind() {
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.a
            public final View getRootView() {
                return this.a;
            }

            public b(View r1) {
                this.a = r1;
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.b
        public final com.bytedance.android.livesdk.interactivity.api.input.viewpager.c b() {
            return new a();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.b
        public final View c(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            RecyclerView r0 = new RecyclerView(r5);
            r0.setAdapter(new OGCFixedCommentAdapter(this.a, this.b.e));
            ScaleAlphaLinearLayoutManager r1 = new ScaleAlphaLinearLayoutManager(r5);
            r1.c = 1.0f;
            r1.b = 0.8f;
            r1.d = 0.8f;
            Unit r6 = Unit.INSTANCE;
            r0.setLayoutManager(r1);
            r0.addItemDecoration(new OGCFixedCommentSectionProvider$FixedCommentPageProvider$provideSectionView$1());
            return r0;
        }

        public FixedCommentPageProvider(OGCFixedCommentSectionProvider r2, OGCFixedCommentSectionController.a r3) {
            Intrinsics.checkNotNullParameter(r3, "actionHandler");
            this.b = r2;
            this.a = r3;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.b
        public final com.bytedance.android.livesdk.interactivity.api.input.viewpager.a a(Context r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "view");
            return new b(r3);
        }
    }

    public final class OGCFixedCommentSectionController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public final Lazy c;
        public final a d;
        public final /* synthetic */ OGCFixedCommentSectionProvider e;

        public static final class a implements d0 {
            public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g a;

            public a(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.provider.d0
            public final void a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "fixedString");
                EditText r0 = this.a.a;
                if (r0 == null) goto L5;
                r0.setText(r2);
            L5:
                this.a.p0();
            }
        }

        public OGCFixedCommentSectionController(OGCFixedCommentSectionProvider r2, final View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.e = r2;
            super(r3, r4);
            this.c = LazyKt.lazy(new OGCFixedCommentSectionProvider$OGCFixedCommentSectionController$sectionBoard$2(this, r3));
            this.d = new a(r4);
        }
    }

    public final class a implements com.bytedance.android.livesdk.interactivity.api.input.viewpager.b {
        public final ExpressionContext a;
        public final com.bytedance.android.livesdk.widget.ui.ogc.b b;
        public final /* synthetic */ OGCFixedCommentSectionProvider c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.provider.OGCFixedCommentSectionProvider$a$a, reason: collision with other inner class name */
        public static final class C0122a extends com.bytedance.android.livesdk.interactivity.api.input.viewpager.c {
            public final /* synthetic */ a a;

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.c
            public final CharSequence a() {
                return "表情";
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.c
            public final void b() {
                com.bytedance.android.livesdk.widget.ui.ogc.b r0 = this.a.b;
                if (r0 == null) goto L7;
                com.bytedance.android.livesdk.widget.ui.ogc.c r1 = r0.a;
                if (r1 == null) goto L7;
                r1.e(ExpressionSection.EnterType.CLICK);
            L7:
                com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_shortcut_message_panel_show", MapsKt.mapOf(TuplesKt.to("tab_type", "emoji")), new Object[]{new am2.x(), IRoom.class});
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.c
            public final void c() {
                com.bytedance.android.livesdk.widget.ui.ogc.b r0 = this.a.b;
            }

            public C0122a(a r1) {
                this.a = r1;
            }
        }

        public static final class b implements com.bytedance.android.livesdk.interactivity.api.input.viewpager.a {
            public final /* synthetic */ a a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ View c;

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.a
            public final void a() {
                com.bytedance.android.livesdk.widget.ui.ogc.b r0 = this.a.b;
                if (r0 == null) goto L6;
                com.bytedance.android.livesdk.widget.ui.ogc.a r1 = r0.c(this.b, this.c);
                com.bytedance.android.livesdk.widget.ui.ogc.a r2 = r1;
                r2.b(this.a.a);
                return;
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.a
            public final View getRootView() {
                com.bytedance.android.livesdk.widget.ui.ogc.b r0 = this.a.b;
                if (r0 == null) goto L7;
                View r1 = r0.c(this.b, this.c).a;
                if (r1 == null) goto L7;
                return r1;
            L7:
                return this.c;
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.a
            public final void unbind() {
                com.bytedance.android.livesdk.widget.ui.ogc.b r0 = this.a.b;
                if (r0 == null) goto L6;
                r0.c(this.b, this.c).unbind();
                return;
            }

            public b(a r1, Context r2, View r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.b
        public final com.bytedance.android.livesdk.interactivity.api.input.viewpager.c b() {
            return new C0122a(this);
        }

        public a(OGCFixedCommentSectionProvider r4) {
            this.c = r4;
            ExpressionContext r0 = new ExpressionContext();
            this.a = r0;
            g1 r1 = new g1(this);
            com.bytedance.android.livesdk.interactivity.api.h r5 = com.bytedance.android.livesdk.interactivity.api.i.b(r4.e, 1);
            if (r5 == null) goto L9;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r6 = r5.getQuickCommentManager();
            if (r6 == null) goto L9;
            com.bytedance.android.livesdk.interactivity.api.quickcomment.f r7 = (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) r6.getValue();
            if (r7 == null) goto L9;
            com.bytedance.android.livesdk.interactivity.api.quickcomment.c r8 = r7.getOGCFixedChatInfo();
        L10:
            this.b = new com.bytedance.android.livesdk.widget.ui.ogc.b(r8);
            r0.getOnCommentSendDelegate().setValue(r1);
            return;
        L9:
            r8 = null;
            goto L10
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.b
        public final View c(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            com.bytedance.android.livesdk.widget.ui.ogc.b r0 = this.b;
            if (r0 == null) goto L6;
            return r0.a(r2);
        L6:
            return new FrameLayout(r2);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.b
        public final com.bytedance.android.livesdk.interactivity.api.input.viewpager.a a(Context r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "view");
            return new b(this, r2, r3);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    public OGCFixedCommentSectionProvider(DataCenter r1) {
        this.e = r1;
        this.a = InputSectionType.OGC_FIXED_INPUT;
        new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r8) {
        Intrinsics.checkNotNullParameter(r8, "panelBridge");
        Activity r0 = r8.getActivity();
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r8;
        View r2 = LayoutInflater.from(r0).inflate(2131567716, null);
        this.d = r2;
        OGCFixedCommentSectionController r3 = new OGCFixedCommentSectionController(this, r2, r8);
        List<com.bytedance.android.livesdk.interactivity.api.input.viewpager.b> r4 = CollectionsKt.mutableListOf(new com.bytedance.android.livesdk.interactivity.api.input.viewpager.b[]{new FixedCommentPageProvider(r3.e, r3.d)});
        com.bytedance.android.livesdk.interactivity.api.h r5 = com.bytedance.android.livesdk.interactivity.api.i.b(r3.e.e, 1);
        if (r5 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r6 = r5.getQuickCommentManager();
        if (r6 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r7 = (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) r6.getValue();
        if (r7 == null) goto L12;
        r1 = r7.getOGCFixedChatInfo();
    L12:
        if (r1 == null) goto L21;
        List<com.bytedance.android.livesdk.interactivity.api.quickcomment.a> r9 = r1.fixedEmojiList;
        if (r9 == null) goto L21;
        if ((!r9.isEmpty()) != true) goto L21;
        OGCFixedCommentSectionProvider r10 = r3.e;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r11 = r10.b;
        if (r11 == null) goto L20;
        r11.getContext();
    L20:
        r4.add(new a(r10));
    L21:
        OGCFixedInputSectionBoard r13 = (OGCFixedInputSectionBoard) r3.c.getValue();
        if (r13 == null) goto L24;
        r13.a(r4);
    L24:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_shortcut_message_panel_show", MapsKt.mapOf(TuplesKt.to("tab_type", "message")), new Object[]{new am2.x(), IRoom.class});
        Unit r14 = Unit.INSTANCE;
        this.c = r3;
        return r2;
    }
}
