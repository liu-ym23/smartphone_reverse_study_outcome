package com.ss.android.lark.contact.base.contact_focus;

import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SpecialFocusPush {
    public static final Lazy<SpecialFocusPush> b = null;
    public final CopyOnWriteArrayList<IGetDataCallback<PushFocusChatter>> a;

    public static final class a {
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SpecialFocusPush$Companion$INSTANCE$2.INSTANCE);
    }

    public SpecialFocusPush() {
        this.a = new CopyOnWriteArrayList();
    }
}
