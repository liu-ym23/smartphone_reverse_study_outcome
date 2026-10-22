package pcb;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.SparseArray;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {

    /* JADX INFO: renamed from: pcb.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0275a {
        public AbstractC0275a() {
        }

        public abstract b a(Activity r1);

        public static a b(Activity r4) {
            SparseArray<AbstractC0275a> r0 = ocb.b.a;
            int r1 = r4.hashCode();
            SparseArray<a> r2 = ocb.b.b;
            a r3 = r2.get(r1);
            if (r3 != null) goto L8;
            AbstractC0275a r5 = ocb.b.a.get(r4.hashCode());
            if (r5 != null) goto L7;
            r5 = new ocb.b();
        L7:
            r3 = r5.a(r4);
            Log.i("InsetsBseKBH#Provider", "cache " + r4.getClass().getName() + r4.hashCode() + " to keyboardHeightProviders");
            r2.put(r4.hashCode(), r3);
        L8:
            r3.restart();
            return r3;
        }
    }

    void a(ocb.a r1);

    void b(ocb.a r1);

    void c(ocb.a r1);

    void d(ocb.a r1);

    int getKeyboardTop();

    int getVisibleKeyboardHeight();

    boolean isKeyboardShowing();

    int keyBoardRawHeight();

    int keyBoardRawHeightWithOrientation(int r1);

    void onConfigurationChanged(Configuration r1, boolean r2);

    void restart();

    void setDelayedDuration(Long r1);
}
