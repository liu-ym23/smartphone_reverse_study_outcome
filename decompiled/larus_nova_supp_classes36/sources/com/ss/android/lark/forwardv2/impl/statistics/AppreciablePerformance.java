package com.ss.android.lark.forwardv2.impl.statistics;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AppreciablePerformance {
    public static String a;
    public static int b;

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/forwardv2/impl/statistics/AppreciablePerformance$ForwardType;", "", "Companion", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ForwardType {
        public static final int BATCH_TRANSMIT = 2;
        public static final a Companion = null;
        public static final int MERGE_FORWARD = 1;
        public static final int SINGLE = 0;

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

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/forwardv2/impl/statistics/AppreciablePerformance$FromType;", "", "Companion", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FromType {
        public static final a Companion = null;
        public static final int GROUP_CARD = 2;
        public static final int H5_APP = 5;
        public static final int TOPIC = 3;
        public static final int USER_CARD = 1;
        public static final int WEB = 4;

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

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/forwardv2/impl/statistics/AppreciablePerformance$TransmitType;", "", "Companion", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface TransmitType {
        public static final a Companion = null;
        public static final int FAVORITE = 2;
        public static final int MESSAGE = 1;
        public static final int UNKNOWN = 0;

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

    public static final class a {
        public static void a(int r19, String r20, int r21, int r22, int r23, String r24) {
            AppreciableKit r2 = AppreciableKit.Companion.getInstance();
            Biz r4 = Biz.Messenger;
            Scene r5 = Scene.Chat;
            int r3 = AppreciablePerformance.b;
            if (r3 != 1) goto L7;
            Event r6 = Event.merge_forward_message;
        L5:
            Event r7 = r6;
            ErrorType r8 = ErrorType.SDK;
            ErrorLevel r9 = ErrorLevel.Fatal;
            Boolean r13 = Boolean.TRUE;
            HashMap r12 = new HashMap();
            r12.put("chat_count", Integer.valueOf(r23));
            if (AppreciablePerformance.b != 0) goto L24;
            if (r24 == null) goto L15;
            r12.put("origin_id", r24);
        L15:
            if (r21 != Message.Type.IMAGE.getNumber()) goto L17;
        L22:
            boolean r1 = true;
        L23:
            r12.put("include_static_resource", Boolean.valueOf(r1));
            goto L24
        L17:
            if (r21 == Message.Type.MEDIA.getNumber()) goto L22;
            if (r21 == Message.Type.AUDIO.getNumber()) goto L22;
            r1 = false;
        L24:
            HashMap r10 = new HashMap();
            r10.put("chat_type", Integer.valueOf(r22));
            if (AppreciablePerformance.b != 0) goto L27;
            r10.put("message_type", Integer.valueOf(r21));
            r10.put("transmit_type", 1);
        L27:
            r2.error(new ErrorParams(r4, r5, r7, r8, r9, r19, null, null, r20, r13, null, r12, r10));
            AppreciablePerformance.a = null;
            AppreciablePerformance.b = 0;
            return;
        L7:
            if (r3 != 2) goto L9;
            r6 = Event.batch_transmit_message;
            goto L5
        L9:
            r6 = Event.forward_message;
            goto L5
        }
    }

    static {
    }
}
