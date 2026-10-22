package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatImageErrDetector {
    public static final ConcurrentMap<b, Boolean> a = null;
    public static final ConcurrentHashMap<b, String> b = null;
    public static WeakReference<RecyclerView> c;
    public static WeakReference<com.ss.android.lark.chat.chatwindow.chat.a> d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/ChatImageErrDetector$ErrorType;", BuildConfig.FLAVOR, "code", BuildConfig.FLAVOR, ChameleonOpenTracker.ParamKey.ERRORMSG, BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "TYPE_EXIT_CHAT", "TYPE_SUCCESS", "TYPE_DATA_LIST_EMPTY", "TYPE_MESSAGE_RECALL", "TYPE_MESSAGE_NOT_IMAGE", "TYPE_IMAGE_SET_EMPTY", "TYPE_IMAGE_EMPTY", "TYPE_IMAGE_KEY_NOT_EQUAL", "TYPE_MESSAGE_NOT_EXIST", "TYPE_IMAGE_LOAD_REAL_FAILED", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorType extends Enum<ErrorType> {
        public static final ErrorType TYPE_DATA_LIST_EMPTY = null;
        public static final ErrorType TYPE_EXIT_CHAT = null;
        public static final ErrorType TYPE_IMAGE_EMPTY = null;
        public static final ErrorType TYPE_IMAGE_KEY_NOT_EQUAL = null;
        public static final ErrorType TYPE_IMAGE_LOAD_REAL_FAILED = null;
        public static final ErrorType TYPE_IMAGE_SET_EMPTY = null;
        public static final ErrorType TYPE_MESSAGE_NOT_EXIST = null;
        public static final ErrorType TYPE_MESSAGE_NOT_IMAGE = null;
        public static final ErrorType TYPE_MESSAGE_RECALL = null;
        public static final ErrorType TYPE_SUCCESS = null;
        public static final /* synthetic */ ErrorType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int code;
        private final String errorMsg;

        public static EnumEntries<ErrorType> getEntries() {
            return b;
        }

        static {
            ErrorType r0 = new ErrorType("TYPE_EXIT_CHAT", 0, 100, "user exit chat");
            TYPE_EXIT_CHAT = r0;
            ErrorType r1 = new ErrorType("TYPE_SUCCESS", 1, 101, "load success");
            TYPE_SUCCESS = r1;
            ErrorType r2 = new ErrorType("TYPE_DATA_LIST_EMPTY", 2, 102, "data list empty");
            TYPE_DATA_LIST_EMPTY = r2;
            ErrorType r3 = new ErrorType("TYPE_MESSAGE_RECALL", 3, 103, "message recall");
            TYPE_MESSAGE_RECALL = r3;
            ErrorType r5 = new ErrorType("TYPE_MESSAGE_NOT_IMAGE", 4, 104, "message not image");
            TYPE_MESSAGE_NOT_IMAGE = r5;
            ErrorType r7 = new ErrorType("TYPE_IMAGE_SET_EMPTY", 5, 105, "imageSet is empty");
            TYPE_IMAGE_SET_EMPTY = r7;
            ErrorType r9 = new ErrorType("TYPE_IMAGE_EMPTY", 6, 106, "image is empty");
            TYPE_IMAGE_EMPTY = r9;
            ErrorType r11 = new ErrorType("TYPE_IMAGE_KEY_NOT_EQUAL", 7, 107, "image key is not equal");
            TYPE_IMAGE_KEY_NOT_EQUAL = r11;
            ErrorType r13 = new ErrorType("TYPE_MESSAGE_NOT_EXIST", 8, 108, "message not exist");
            TYPE_MESSAGE_NOT_EXIST = r13;
            ErrorType r12 = new ErrorType("TYPE_IMAGE_LOAD_REAL_FAILED", 9, -1, "image load real failed");
            TYPE_IMAGE_LOAD_REAL_FAILED = r12;
            ErrorType[] r10 = {r0, r1, r2, r3, r5, r7, r9, r11, r13, r12};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public static ErrorType valueOf(String r1) {
            return (ErrorType) r27.a.a(ErrorType.class, r1);
        }

        public ErrorType(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.code = r3;
            this.errorMsg = r4;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.a, this.b});
        }

        public final String toString() {
            return "DetectData(msgId=" + this.a + ", imageKey=" + this.b + ')';
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "msgId");
            Intrinsics.checkNotNullParameter(r3, "imageKey");
            this.a = r2;
            this.b = r3;
        }
    }

    public ChatImageErrDetector() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static void a(String r21, String r22, ErrorType r23, ErrorResult r24) {
        ConcurrentHashMap<b, String> r2 = b;
        if (r2.get(new b(r21, r22)) != null) goto L7;
        Log.i("ChatImageDetector", "report key is empty, msgId:" + r21 + ", imageKey:" + r22 + ", errorType:" + r23);
        return;
    L7:
        if (r24 == null) goto L9;
        int r4 = r24.getErrorCode();
    L10:
        int r11 = r4;
        AppreciableKit r5 = AppreciableKit.Companion.getInstance();
        Biz r6 = Biz.Messenger;
        Scene r7 = Scene.Chat;
        Event r8 = Event.image_load_real_failed;
        com.ss.android.lark.appreciablelib.ErrorType r9 = com.ss.android.lark.appreciablelib.ErrorType.Unknown;
        ErrorLevel r10 = ErrorLevel.Fatal;
        String r14 = r23.getErrorMsg();
        Boolean r3 = Boolean.TRUE;
        HashMap r12 = new HashMap();
        r12.put("message_id", r21);
        r12.put("image_key", r22);
        r5.error(new ErrorParams(r6, r7, r8, r9, r10, r11, null, "ChatWindow", r14, r3, null, r12, null));
        r2.remove(new b(r21, r22));
        ((ConcurrentHashMap) a).remove(new b(r21, r22));
        return;
    L9:
        r4 = r23.getCode();
        goto L10
    }
}
