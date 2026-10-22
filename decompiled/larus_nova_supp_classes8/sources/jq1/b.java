package jq1;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    /* JADX INFO: renamed from: jq1.b$b, reason: collision with other inner class name */
    public static final class C0394b {
        public static String a(b r1) {
            List<String> r2 = r1.b();
            if (r2 != null) goto L5;
        L8:
            return null;
        L5:
            if (r2.isEmpty() == true) goto L8;
            return r2.toString();
        }

        public static String b(b r1) {
            if (r1.a() == false) goto L6;
            return "official";
        L6:
            if (r1.getMedal() == null) goto L8;
            return "medal";
        L8:
            o1 r2 = r1.getLandscapeAreaCommon();
            if (r2 != null) goto L11;
        L13:
            return "normal";
        L11:
            if (r2.isStarMessage() != true) goto L13;
            return "star";
        }

        public static boolean c(b r5) {
            if (r5.getAgreeMsgId() != 0) goto L5;
        L7:
            return false;
        L5:
            if (r5.getAgreeMsgId() == r5.getMessageId()) goto L7;
            return true;
        }

        public static boolean d(b r1) {
            if (r1.isSelfSendFake() == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.a() == true) goto L8;
            return false;
        }
    }

    static {
        a = a.a;
    }

    boolean a();

    List<String> b();

    String c();

    String d();

    String e();

    boolean f();

    boolean g();

    long getAgreeMsgId();

    CharSequence getChatContent();

    o1 getLandscapeAreaCommon();

    j0 getMedal();

    long getMessageId();

    IBaseUser getUserInfo();

    String h();

    k i();

    boolean isSelfSendFake();
}
