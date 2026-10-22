package com.ss.android.lark.forwardv3.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/forwardv3/utils/Constants$ForwardTargetType;", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Constants$ForwardTargetType {
    public static final int CHATTER = 2;
    public static final a Companion = null;
    public static final int GROUP_CHAT = 1;
    public static final int SHIELD_P2P_CHAT = 4;
    public static final int THREAD = 3;
    public static final int UNKNOWN = 0;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static String a(int r1) {
            if (r1 != 0) goto L4;
        L16:
            return "UNKNOWN";
        L4:
            if (r1 != 1) goto L6;
            return "GROUP_CHAT";
        L6:
            if (r1 != 2) goto L8;
            return "CHATTER";
        L8:
            if (r1 != 3) goto L10;
            return "THREAD";
        L10:
            if (r1 != 4) goto L16;
            return "SHIELD_P2P_CHAT";
        }
    }

    static {
        Companion = a.a;
    }
}
