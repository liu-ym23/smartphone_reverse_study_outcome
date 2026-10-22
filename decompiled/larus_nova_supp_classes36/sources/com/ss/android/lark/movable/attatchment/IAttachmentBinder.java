package com.ss.android.lark.movable.attatchment;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IAttachmentBinder {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;
        public static final Lazy<Map<Integer, IAttachmentBinder>> b = null;

        public Companion() {
        }

        static {
            a = new Companion();
            b = LazyKt.lazy(IAttachmentBinder$Companion$binders$2.INSTANCE);
        }
    }

    static {
        a = Companion.a;
    }

    void bind(d r1, b r2);

    int getAttachmentTypeId();
}
