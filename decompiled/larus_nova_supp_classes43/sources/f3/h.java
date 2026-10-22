package f3;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface h<Result extends ResultModel> {

    public static final class a {
        public static /* synthetic */ void b(h r1, ResultModel r10) {
            r1.b(r10, "");
        }

        public static /* synthetic */ void a(h r10, String r11, f3.a r12, JsonObject r13, int r14) {
            if ((r14 & 1) == 0) goto L6;
            r11 = "";
        L6:
            if ((r14 & 4) == 0) goto L9;
            r12 = null;
        L9:
            if ((r14 & 8) == 0) goto L11;
            r13 = null;
        L11:
            r10.c(r11, 0, r12, r13);
        }
    }

    void a(String r1, Object r10);

    void b(Result r1, String r10);

    void c(String r1, int r10, f3.a r11, JsonObject r12);
}
