package qab;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.bytedance.lark.pb.calendar.v1.GetParsedRruleTextRequest;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static String a(String r8, LanguageType r9) {
        String r0 = Long.toString(new Date().getTime());
        String[] r2 = new String[0];
        int r3 = a.a;
        Intrinsics.checkNotNullParameter(r0, "contextId");
        Intrinsics.checkNotNullParameter("GetParsedRruleTextRequest", "apiName");
        Intrinsics.checkNotNullParameter(r2, "messages");
        Log.i("RepeatModeUtils", a.a(r0, "req", (String[]) Arrays.copyOf(r2, 0)));
        int r4 = pab.b.a;
        Intrinsics.checkNotNullParameter(r9, "languageType");
        GetParsedRruleTextRequest.Builder r10 = new GetParsedRruleTextRequest.Builder().rrule(r8).language_type(r9);
        String[] r11 = (String[]) SdkSender.syncSend(Command.GET_PARSED_RRULE_TEXT, r10, pab.a.a);
        if (r11 != null) goto L5;
        Log.e("CustomRepeatService", "syncParsedRRuleTextRequest - get rules error");
        r11 = new String[]{BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR};
    L5:
        String[] r5 = new String[0];
        Intrinsics.checkNotNullParameter(r0, "contextId");
        Intrinsics.checkNotNullParameter("GetParsedRruleTextRequest", "apiName");
        Intrinsics.checkNotNullParameter(r5, "messages");
        Log.i("RepeatModeUtils", a.a(r0, "suc", (String[]) Arrays.copyOf(r5, 0)));
        String r12 = r11[1];
        if (TextUtils.isEmpty(r12) == true) goto L8;
        return r12;
    L8:
        return BuildConfig.FLAVOR;
    }
}
