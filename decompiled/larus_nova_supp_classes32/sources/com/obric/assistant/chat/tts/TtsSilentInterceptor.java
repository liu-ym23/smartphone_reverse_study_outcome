package com.obric.assistant.chat.tts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.api.ITtsPlayInterceptor;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/chat/tts/TtsSilentInterceptor;", "Lcom/larus/bmhome/chat/api/ITtsPlayInterceptor;", "<init>", "()V", EasyGoDbTable.Server.NAME, NameKeys.UnloadStrategy_No_Strategy, "shouldIntercept", NameKeys.UnloadStrategy_No_Strategy, "context", "Lcom/larus/bmhome/chat/api/ITtsPlayInterceptor$TtsPlayContext;", "isSilentMessage", "msg", "Lcom/larus/im/bean/message/Message;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsSilentInterceptor implements ITtsPlayInterceptor {
    public static final Gson a = null;

    public static final class a {

        /* JADX INFO: renamed from: com.obric.assistant.chat.tts.TtsSilentInterceptor$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/chat/tts/TtsSilentInterceptor$Companion$MessageIntent;", NameKeys.UnloadStrategy_No_Strategy, "isSilent", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/Integer;)V", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/obric/assistant/chat/tts/TtsSilentInterceptor$Companion$MessageIntent;", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0078a {

            @SerializedName("isSilent")
            private final Integer isSilent;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0078a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.isSilent, ((C0078a) r4).isSilent) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                Integer r0 = this.isSilent;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "MessageIntent(isSilent=" + this.isSilent + ')';
            }

            public C0078a() {
                this.isSilent = null;
            }

            public final Integer a() {
                return this.isSilent;
            }
        }

        public static boolean a(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Map r6 = r5.getExt();
            if (r6 == null) goto L5;
            String r7 = (String) r6.get("client_meta");
        L6:
            boolean r1 = true;
            if (r7 != null) goto L9;
        L12:
            boolean r3 = true;
        L13:
            if (r3 == true) goto L31;
            C0078a r4 = (C0078a) TtsSilentInterceptor.a.fromJson(r7, C0078a.class);     // Catch: Exception -> L25
            if (r4 == null) goto L23;
            Integer r8 = r4.a();
            if (r8 == null) goto L23;
            if (r8.intValue() != 1) goto L23;
        L30:
            return r1;
        L23:
            r1 = false;
        L25:
            e = move-exception;
            FLogger.a.e("client_meta", r7, e);
            return false;
        L31:
            return false;
        L9:
            if (r7.length() == 0) goto L12;
            r3 = false;
            goto L13
        L5:
            r7 = null;
            goto L6
        }
    }

    public TtsSilentInterceptor() {
    }

    static {
        a = new GsonBuilder().create();
    }
}
