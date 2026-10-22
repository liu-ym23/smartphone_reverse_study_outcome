package uzb;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static String a(String r7, FragmentActivity r8) {
        Matcher r0 = PatternProtector.compile("<span.*?style=['\"]?(.*?)['\"].*?").matcher(r7);
        String r3 = "";
        if (r0.find() == false) goto L5;
        String r1 = r0.group(1);
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return r7;
    L10:
        if (r1.contains(";") == false) goto L12;
        String r2 = "(?<=color:)(.*?)(?=;)";
    L13:
        Matcher r4 = PatternProtector.compile(r2).matcher(r1);
        if (r4.find() == false) goto L16;
        String r5 = r4.group(1);
    L18:
        if (TextUtils.isEmpty(r5) == false) goto L20;
        return r7;
    L20:
        Matcher r6 = PatternProtector.compile("(?<=[{])(.+?)(?=[}])").matcher(r5);
        if (r6.find() == false) goto L24;
        r3 = r6.group(1);
    L24:
        if (TextUtils.isEmpty(r3) == false) goto L26;
        return r7;
    L26:
        int r9 = UDColorUtils.getColorIdByToken(r8, r3);
        StringBuilder r10 = new StringBuilder("#");
        int r11 = r8.getResources().getColor(r9);     // Catch: Resources.NotFoundException -> L29
    L31:
        r10.append(String.format("%02x", new Object[]{Integer.valueOf(Color.red(r11))}));
        r10.append(String.format("%02x", new Object[]{Integer.valueOf(Color.green(r11))}));
        r10.append(String.format("%02x", new Object[]{Integer.valueOf(Color.blue(r11))}));
        return r7.replace(r5, r10.toString());
    L29:
        e = move-exception;
        PassportLog.c("MatchUtil", "token: " + r3 + " not fount", e);
        r11 = 0;
        goto L31
    L16:
        r5 = "";
        goto L18
    L12:
        r2 = "(?<=color:)(.*)";
        goto L13
    L5:
        r1 = "";
        goto L7
    }
}
