package com.larus.bmhome.share.panel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/share/panel/ShareType;", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ShareType {
    public static final a Companion = null;
    public static final String FILE = "file";
    public static final String FILE_URL = "file_url";
    public static final String IMAGE = "image";
    public static final String MINI_APP = "mini_app";
    public static final String REPORT = "report";
    public static final String TEXT = "text";
    public static final String URL = "url";
    public static final String VIDEO = "video";

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
