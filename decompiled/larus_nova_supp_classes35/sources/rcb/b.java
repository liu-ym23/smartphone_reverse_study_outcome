package rcb;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.i0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Configuration r5 = r4.getResources().getConfiguration();
        StringBuilder r1 = new StringBuilder(" hardKeyboardHidden=");
        Integer r2 = null;
        if (r5 == null) goto L8;
        Integer r3 = Integer.valueOf(r5.hardKeyboardHidden);
    L9:
        r1.append(r3);
        r1.append(" keyboard=");
        if (r5 == null) goto L12;
        r2 = Integer.valueOf(r5.keyboard);
    L12:
        r1.append(r2);
        Log.i("HardKeyboardUtils", r1.toString());
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L25;
        int r7 = r5.keyboard;
        if (r7 != 2) goto L22;
    L23:
        return true;
    L22:
        if (r7 == 3) goto L23;
        return false;
    L25:
        return false;
    L15:
        if (r5.hardKeyboardHidden != 1) goto L17;
        r6 = true;
        goto L18
    L8:
        r3 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean b(FragmentActivity r6) {
        if (r6 == null) goto L28;
        int r1 = a.a;
        int r2 = Build.VERSION.SDK_INT;
        boolean r3 = true;
        if (r2 < 30) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L10;
    L12:
        boolean r5 = false;
    L14:
        if (r6.getResources().getConfiguration().orientation != 2) goto L21;
        if (r5 == true) goto L17;
    L19:
        r5 = false;
        goto L21
    L17:
        if (com.ss.android.lark.base.embedded.b.b(r6) == false) goto L19;
        r5 = true;
    L21:
        if (r2 >= 24) goto L24;
        r3 = false;
    L24:
        if (r3 == false) goto L29;
        if (r5 == false) goto L27;
        return false;
    L27:
        return r6.isInMultiWindowMode();
    L29:
        return false;
    L10:
        if (i0.b() == false) goto L12;
        r5 = true;
        goto L14
    L7:
        r4 = false;
        goto L8
    L28:
        return false;
    }
}
