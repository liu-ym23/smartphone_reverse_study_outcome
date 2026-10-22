package com.ss.android.lark.chat.base.view.vo.message;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PostContentVO extends BaseTextContentVO<PostContent> {
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;

    public final boolean i() {
        return ((Boolean) this.G.getValue()).booleanValue();
    }

    public PostContentVO(final PostContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.E = LazyKt.lazy(new PostContentVO$title$2(r2));
        this.F = LazyKt.lazy(new PostContentVO$isNotified$2(r2));
        this.G = LazyKt.lazy(new PostContentVO$isGroupAnnouncement$2(r2));
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO, com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r4) {
        if (super.d(r4) == true) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        return false;
    L7:
        if ((r4 instanceof PostContentVO) == false) goto L19;
        PostContentVO r5 = (PostContentVO) r4;
        if (i() == r5.i()) goto L11;
        return false;
    L11:
        if (y28.a.a(this.h, r5.h) == true) goto L13;
        return false;
    L13:
        if (y28.a.a(this.i, r5.i) == true) goto L15;
        return false;
    L15:
        if (y28.a.a(this.j, r5.j) == false) goto L23;
        return true;
    L23:
        return false;
    L19:
        return false;
    }

    public final String h(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (TextUtils.isEmpty((String) this.E.getValue()) == false) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        Iterator r5 = ArrayIteratorKt.iterator(UIUtils.getStringArray(r4, 2130903105));
    L7:
        if (r5.hasNext() == false) goto L12;
        if (Intrinsics.areEqual((String) r5.next(), (String) this.E.getValue()) == false) goto L7;
        return BuildConfig.FLAVOR;
    L12:
        return (String) this.E.getValue();
    }
}
