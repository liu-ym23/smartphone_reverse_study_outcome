package com.ss.android.lark.chat.chatwindow.chat.model.push;

import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PersonalSignGetUrlPreviewBuffer implements AndroidThrottle.d<UserStatusParseUrlPreViewUtils.b> {
    public final Lazy a;

    public final void clear() {
    }

    public final Collection<UserStatusParseUrlPreViewUtils.b> a() {
        ArrayList r0 = new ArrayList(((HashMap) this.a.getValue()).values());
        ((HashMap) this.a.getValue()).clear();
        return r0;
    }

    public final int size() {
        return ((HashMap) this.a.getValue()).size();
    }

    public PersonalSignGetUrlPreviewBuffer() {
        this.a = LazyKt.lazy(PersonalSignGetUrlPreviewBuffer$requestMap$2.INSTANCE);
    }

    public final void put(Object r5) {
        UserStatusParseUrlPreViewUtils.b r6 = (UserStatusParseUrlPreViewUtils.b) r5;
        if (r6 == null) goto L6;
        ((HashMap) this.a.getValue()).put(r6.b + '_' + r6.c + '_' + r6.d, r6);
        return;
    }
}
