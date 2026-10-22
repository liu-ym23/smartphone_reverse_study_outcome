package com.larus.disk.impl.handler;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class MessageCacheHandler$2 extends FunctionReferenceImpl implements Function0<Long> {
    public static final MessageCacheHandler$2 INSTANCE = null;

    static {
        INSTANCE = new MessageCacheHandler$2();
    }

    public MessageCacheHandler$2() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m35invoke() {
        return invoke();
    }
}
