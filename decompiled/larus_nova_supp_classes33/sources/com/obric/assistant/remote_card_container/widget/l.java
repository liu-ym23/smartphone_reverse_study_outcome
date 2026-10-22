package com.obric.assistant.remote_card_container.widget;

import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l {
    public static final AtomicReference<RemoteCardContainer> a = null;
    public static final CoroutineScope b = null;
    public static Job c;

    static {
        a = new AtomicReference(null);
        b = CoroutineScopeKt.MainScope();
    }
}
