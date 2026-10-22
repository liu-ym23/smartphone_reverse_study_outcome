package com.ss.android.lark.flow.chat.message.profile;

import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowProfileContentVO extends v5b.a<ProfileContent> {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public FlowProfileContentVO(final ProfileContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.b = LazyKt.lazy(new FlowProfileContentVO$id$2(r2));
        this.c = LazyKt.lazy(new FlowProfileContentVO$displayName$2(r2));
        this.d = LazyKt.lazy(new FlowProfileContentVO$chatterType$2(r2));
        this.e = LazyKt.lazy(new FlowProfileContentVO$avatarKey$2(r2));
        this.f = LazyKt.lazy(new FlowProfileContentVO$description$2(r2));
        this.g = LazyKt.lazy(new FlowProfileContentVO$isProfileEnable$2(r2));
        this.h = LazyKt.lazy(new FlowProfileContentVO$tenantId$2(r2));
    }
}
