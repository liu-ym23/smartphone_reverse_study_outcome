package com.ss.android.lark.forwardv3.forward.textforward;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/textforward/TextSource;", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TextSource {
    public static final int APP_CENTER_CUSTOM_TEXT = 2;
    public static final int APP_LINK = 11;
    public static final int CCM_DOC_URL_TEXT = 3;
    public static final a Companion = null;
    public static final int DOUBAO_TEXT = 13;
    public static final int ENTRY_DICTIONARY_TEXT = 9;
    public static final int INVITATION_LARK_TEXT = 4;
    public static final int LABS_JSB = 12;
    public static final int MEEGO_URL_TEXT = 6;
    public static final int MINUTE_LIVE_TEXT = 7;
    public static final int OCR_TEXT = 1;
    public static final int OLD_MOMENT_TEXT = 8;
    public static final int UD_SHARE_PANEL_TEXT = 5;
    public static final int UNKNOWN = 0;
    public static final int VC_LINK_TEXT = 10;

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
