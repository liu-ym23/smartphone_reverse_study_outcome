package ccb;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final List<a> a;

    public static final class a {
        public final String a;
        public final Message.Type b;

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final Message.Type getType() {
            return this.b;
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if (r4 == null) goto L8;
            Class<?> r2 = r4.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.dto.chat.GetMessageIdsByPositionResponse.MessageTypeInfo");
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L15;
            return false;
        L15:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public a(String r2, Message.Type r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
            this.a = r2;
            this.b = r3;
        }
    }

    public c(List<a> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        this.a = r2;
    }
}
