package com.ss.android.lark.locationmessage.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LocationContentVO extends v5b.a<LocationContent> {
    public final Message b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public LocationContentVO(final LocationContent r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        super(r2);
        this.b = r3;
        this.c = LazyKt.lazy(new LocationContentVO$locationDescription$2(r2));
        this.d = LazyKt.lazy(new LocationContentVO$longitude$2(r2));
        this.e = LazyKt.lazy(new LocationContentVO$latitude$2(r2));
        this.f = LazyKt.lazy(new LocationContentVO$zoomLevel$2(r2));
        this.g = LazyKt.lazy(new LocationContentVO$image$2(r2));
        this.h = LazyKt.lazy(new LocationContentVO$vendor$2(r2));
        this.i = LazyKt.lazy(new LocationContentVO$isInternal$2(r2));
    }
}
