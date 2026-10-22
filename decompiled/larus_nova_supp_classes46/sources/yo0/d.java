package yo0;

import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public final int a;
    public final String b;
    public final JSONObject c;

    public static final class a {
        public static final C0297a d = null;
        public String a;
        public JSONObject b;
        public final int c;

        /* JADX INFO: renamed from: yo0.d$a$a, reason: collision with other inner class name */
        public static final class C0297a {
            public C0297a() {
            }

            public static a b(OpenApiErrorInfo r1, JSONObject r2) {
                Intrinsics.checkNotNullParameter(r1, "errorInfo");
                return a(r1.getErrorCode(), r1.getErrorMsg(), r2);
            }

            public static a a(int r2, String r3, JSONObject r4) {
                Intrinsics.checkNotNullParameter(r3, "errMsg");
                switch(r2) {
                    case 408: goto L25;
                    case 10001: goto L24;
                    case 10002: goto L24;
                    case 10003: goto L23;
                    case 10004: goto L22;
                    case 10011: goto L21;
                    case 10013: goto L20;
                    case 20003: goto L19;
                    case 20087: goto L18;
                    case 40023: goto L17;
                    case 40033: goto L16;
                    case 41001: goto L15;
                    case 90203: goto L14;
                    case 90204: goto L14;
                    case 90504: goto L13;
                    case 4001010: goto L24;
                    case 4001011: goto L24;
                    case 4005024: goto L16;
                    case 4008074: goto L12;
                    case 4014016: goto L11;
                    case 4014023: goto L10;
                    case 4014031: goto L22;
                    case 4014034: goto L9;
                    case 4014035: goto L8;
                    case 4014036: goto L7;
                    case 4014038: goto L21;
                    case 4014040: goto L22;
                    case 4014044: goto L6;
                    case 4014045: goto L16;
                    case 4014047: goto L13;
                    case 4014048: goto L13;
                    case 4014052: goto L13;
                    case 4019001: goto L5;
                    default: goto L4;
                };
            L4:
                OpenApiErrorInfo r1 = null;
            L26:
                if (r1 == null) goto L28;
                r2 = r1.getErrorCode();
                r3 = r1.getErrorMsg();
            L28:
                a r5 = new a(r2);
                Intrinsics.checkNotNullParameter(r3, "errMsg");
                r5.a = r3;
                r5.b = r4;
                return r5;
            L5:
                r1 = OpenApiErrorInfo.LOGIN_OUT_DATE;
                goto L26
            L6:
                r1 = OpenApiErrorInfo.PAY_DIAMONDS_REACH_LIMIT;
                goto L26
            L7:
                r1 = OpenApiErrorInfo.INVALID_ACCESS_TOKEN;
                goto L26
            L8:
                r1 = OpenApiErrorInfo.SENSITIVE_WORD_DETECTED;
                goto L26
            L9:
                r1 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;
                goto L26
            L10:
                r1 = OpenApiErrorInfo.USER_NOT_IN_ROOM;
                goto L26
            L11:
                r1 = OpenApiErrorInfo.APP_NOT_LAUNCH;
                goto L26
            L12:
                r1 = OpenApiErrorInfo.REWARD_REACH_LIMIT;
                goto L26
            L13:
                r1 = OpenApiErrorInfo.INCORRECT_PARAMS;
                goto L26
            L14:
                r1 = OpenApiErrorInfo.NET_REQUEST_CONCURRENCY_EXCEED_LIMIT;
                goto L26
            L15:
                r1 = OpenApiErrorInfo.ACCOUNT_EXCEPTION;
                goto L26
            L16:
                r1 = OpenApiErrorInfo.DATA_ALREADY_EXIST;
                goto L26
            L17:
                r1 = OpenApiErrorInfo.NET_REQUEST_RESPONSE_INCOMPATIBLE;
                goto L26
            L18:
                r1 = OpenApiErrorInfo.ILLEGAL_APP_ID;
                goto L26
            L19:
                r1 = OpenApiErrorInfo.NOT_LOGIN;
                goto L26
            L20:
                r1 = OpenApiErrorInfo.INVALID_URL_PARAMS;
                goto L26
            L21:
                r1 = OpenApiErrorInfo.INCORRECT_PARAMS;
                goto L26
            L22:
                r1 = OpenApiErrorInfo.DATA_NOT_EXIST;
                goto L26
            L23:
                r1 = OpenApiErrorInfo.SIGNATURE_ERROR;
                goto L26
            L24:
                r1 = OpenApiErrorInfo.INTERNAL_ERROR;
                goto L26
            L25:
                r1 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
                goto L26
            }
        }

        static {
            d = new C0297a();
        }

        public final d a() {
            return new d(this.c, this.a, this.b);
        }

        public a(int r1) {
            this.c = r1;
            this.a = "";
        }
    }

    public static final class b {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = this.c;
        if (r1 != null) goto L5;
        r1 = new JSONObject();
    L5:
        r1.put("errCode", this.a);
        Unit r2 = Unit.INSTANCE;
        r0.put("data", r1);
        r0.put("resultCode", this.a);
        return r0;
    }

    public d(int r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
