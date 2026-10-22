package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.common.util.ExceptionWithNoStacktrace;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/ParseFinishException;", "Lcom/facebook/common/util/ExceptionWithNoStacktrace;", "<init>", "()V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
final class ParseFinishException extends ExceptionWithNoStacktrace {
    public static final a Companion = null;
    public static final Lazy a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        a = LazyKt.lazy(ParseFinishException$Companion$finish$2.INSTANCE);
    }

    public ParseFinishException() {
        super("parse finish");
    }

    public static final /* synthetic */ Lazy access$getFinish$cp() {
        return a;
    }
}
