package com.larus.doc.impl.operation.download;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/doc/impl/operation/download/DownloadType;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface DownloadType {
    public static final a Companion = null;
    public static final int MARKDOWN = 3;
    public static final int PDF = 2;
    public static final int UNKNOWN = 0;
    public static final int WORD = 1;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
