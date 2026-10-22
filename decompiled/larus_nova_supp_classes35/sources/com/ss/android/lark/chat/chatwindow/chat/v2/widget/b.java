package com.ss.android.lark.chat.chatwindow.chat.v2.widget;

import com.larksuite.framework.utils.AndroidThrottle;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements AndroidThrottle.e {
    public final /* synthetic */ c<T> a;

    public b(c<T> r1) {
        this.a = r1;
    }

    public final void a(Collection<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "tasks");
        this.a.b(r2);
    }
}
