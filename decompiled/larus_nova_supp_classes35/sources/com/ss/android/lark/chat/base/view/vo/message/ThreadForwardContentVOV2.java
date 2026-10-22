package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadForwardContentVOV2 extends f<MergeForwardContent> {
    public Message h;
    public ChatterInfo i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public int n;
    public List<y6b.f> o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;

    public final boolean f() {
        return ((Boolean) this.q.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) this.p.getValue()).booleanValue();
    }

    public ThreadForwardContentVOV2(final MergeForwardContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.h = new Message();
        this.i = new ChatterInfo();
        this.j = BuildConfig.FLAVOR;
        this.k = BuildConfig.FLAVOR;
        this.l = BuildConfig.FLAVOR;
        this.m = true;
        this.p = LazyKt.lazy(new ThreadForwardContentVOV2$isReplyInThread$2(r2));
        this.q = LazyKt.lazy(new ThreadForwardContentVOV2$isInChat$2(r2));
        this.r = LazyKt.lazy(new ThreadForwardContentVOV2$isPublic$2(r2));
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r4) {
        if (r4 != null) goto L5;
    L31:
        return false;
    L5:
        if ((r4 instanceof ThreadForwardContentVOV2) == false) goto L31;
        ThreadForwardContentVOV2 r5 = (ThreadForwardContentVOV2) r4;
        if (this.h.isContentSame(r5.h) == true) goto L11;
        return false;
    L11:
        if (this.i.isContentSame(r5.i) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.j, r5.j) == false) goto L31;
        if (Intrinsics.areEqual(this.k, r5.k) == false) goto L31;
        if (Intrinsics.areEqual(this.l, r5.l) == false) goto L31;
        if (this.n != r5.n) goto L31;
        if (g() != r5.g()) goto L31;
        if (f() != r5.f()) goto L31;
        if (((Boolean) this.r.getValue()).booleanValue() != ((Boolean) r5.r.getValue()).booleanValue()) goto L31;
        return y28.a.b(this.o, r5.o);
    }
}
