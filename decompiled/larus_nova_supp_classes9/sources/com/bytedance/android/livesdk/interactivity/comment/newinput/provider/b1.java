package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.comment.mention.MentionSectionController;
import com.bytedance.android.livesdk.interactivity.comment.mention.MentionSectionController$init$1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<MentionSectionController, z62.g> {
    public static final a d = null;
    public final InputSectionType a;
    public MentionSectionController b;
    public final c c;

    public static final class a implements z62.g {
        public a() {
        }

        @Override // z62.g
        public final int B() {
            return 0;
        }

        @Override // z62.g
        public final void p(z1 r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
        }
    }

    public static final class b {
    }

    public static final class c implements z62.g {
        public final /* synthetic */ b1 a;

        @Override // z62.g
        public final int B() {
            MentionSectionController r0 = this.a.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return (int) r0.f;
        }

        public c(b1 r1) {
            this.a = r1;
        }

        @Override // z62.g
        public final void p(z1 r3) {
            Intrinsics.checkNotNullParameter(r3, "listener");
            MentionSectionController r1 = this.a.b;
            if (r1 == null) goto L6;
            Intrinsics.checkNotNullParameter(r3, "listener");
            ((ArrayList) r1.j).add(r3);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        d = new a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
        MentionSectionController r0 = this.b;
        if (r0 == null) goto L6;
        r0.f = 0.0f;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        MentionSectionController r0 = this.b;
        if (r0 == null) goto L6;
        r0.r.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        MentionSectionController r0 = this.b;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public b1() {
        this.a = InputSectionType.MENTION;
        this.c = new c(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r6) {
        Intrinsics.checkNotNullParameter(r6, "panelBridge");
        Activity r0 = r6.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        View r1 = LayoutInflater.from(r0).inflate(2131567714, null);
        if (r1 != null) goto L8;
        return null;
    L8:
        final MentionSectionController r2 = new MentionSectionController(r1, r6);
        r2.h.addItemDecoration(new SpaceItemDecoration(0, UtilityKotlinExtentionsKt.i(12), false));
        LinearLayoutManager r7 = new LinearLayoutManager(r2.s.getContext(), 0, false);
        r2.h.setLayoutManager(r7);
        r2.h.setAdapter(r2.q);
        r2.h.addOnScrollListener(new MentionSectionController$init$1(r2));
        r2.h.setOnTouchListener(new com.bytedance.android.livesdk.interactivity.comment.mention.c(r2));
        r2.b.q0(new com.bytedance.android.livesdk.interactivity.comment.mention.d(r2));
        EditText r8 = r2.b.a;
        if (r8 == null) goto L11;
        r8.addTextChangedListener(r2.p);
    L11:
        RxUtilKt.c(r2.p.distinctUntilChanged(com.bytedance.android.livesdk.interactivity.comment.mention.e.a).filter(com.bytedance.android.livesdk.interactivity.comment.mention.f.a).debounce(r2.n.longValue(), TimeUnit.MILLISECONDS).switchMap(new com.bytedance.android.livesdk.interactivity.comment.mention.h(r2)).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.interactivity.comment.mention.i(r2), com.bytedance.android.livesdk.interactivity.comment.mention.j.a), r2.r);
        Unit r9 = Unit.INSTANCE;
        this.b = r2;
        return r1;
    }
}
