package com.ss.android.lark.forwardv3.forward.imageforward;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/imageforward/ImageSource;", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageSource {
    public static final int CCM_DOC_IMAGE = 3;
    public static final a Companion = null;
    public static final int PHOTO_EDITOR_IMAGE = 1;
    public static final int POST_IMAGE = 2;
    public static final int SECURITY_SCREENSHOT_IMAGE = 6;
    public static final int UD_SHARE_PANEL_IMAGE = 4;
    public static final int UNKNOWN = 0;
    public static final int VC_ROOM_WHITE_BOARD = 5;

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
