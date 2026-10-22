package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UrlInlinePreviewConfig {
    public static final /* synthetic */ int b = 0;
    public final Source a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/urlinline/UrlInlinePreviewConfig$Source;", "", "<init>", "(Ljava/lang/String;I)V", "URL_INLINE", "TEMP_PREVIEW", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Source extends Enum<Source> {
        public static final Source TEMP_PREVIEW = null;
        public static final Source URL_INLINE = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("URL_INLINE", 0);
            URL_INLINE = r0;
            Source r1 = new Source("TEMP_PREVIEW", 1);
            TEMP_PREVIEW = r1;
            Source[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static UrlInlinePreviewConfig a() {
            return new UrlInlinePreviewConfig(Source.URL_INLINE);
        }
    }

    static {
    }

    public UrlInlinePreviewConfig(Source r1) {
        this.a = r1;
    }
}
