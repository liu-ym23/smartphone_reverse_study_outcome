package zz9;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface a extends t1a.a {

    /* JADX INFO: renamed from: zz9.a$a, reason: collision with other inner class name */
    public static final class C0088a {
        public static /* synthetic */ void a(a r2, ICoreInputAbility.OnSendParams r3, String r4, String r5, boolean r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = "";
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = "";
        L12:
            if ((r7 & 8) == 0) goto L14;
            r6 = false;
        L14:
            r2.C7(r3, r4, r5, r6);
        }
    }

    void C7(ICoreInputAbility.OnSendParams r1, String r2, String r3, boolean r4);

    int K7();

    void T9(boolean r1);

    void WR();

    void h6();

    void u9();
}
