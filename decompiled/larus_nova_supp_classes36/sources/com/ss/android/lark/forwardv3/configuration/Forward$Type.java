package com.ss.android.lark.forwardv3.configuration;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/Forward$Type;", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Forward$Type {
    public static final a Companion = null;
    public static final int DOUBAO_FILE = 10;
    public static final int FOR_SHARE = 6;
    public static final int GROUP_CHAT = 2;
    public static final int MESSAGE = 1;
    public static final int NORMAL_IMAGE = 5;
    public static final int NORMAL_TEXT = 3;
    public static final int PROFILE = 4;
    public static final int SHARE_FAV = 8;
    public static final int SHARE_FLAG = 9;
    public static final int SHARE_MESSAGE = 7;
    public static final int UNKNOWN = 0;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static String a(int r0) {
            switch(r0) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                case 9: goto L5;
                case 10: goto L4;
                default: goto L14;
            };
        L4:
            return "DOUBAO_FILE";
        L5:
            return "SHARE_FLAG";
        L6:
            return "SHARE_FAV";
        L7:
            return "SHARE_MESSAGE";
        L8:
            return "FOR_SHARE";
        L9:
            return "NORMAL_IMAGE";
        L10:
            return "PROFILE";
        L11:
            return "NORMAL_TEXT";
        L12:
            return "GROUP_CHAT";
        L13:
            return "MESSAGE";
        L14:
            return "UNKNOWN";
        }
    }

    static {
        Companion = a.a;
    }
}
