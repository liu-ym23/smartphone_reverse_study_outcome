package pab;

import com.bytedance.lark.pb.calendar.v1.GetParsedRruleTextResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements SdkSender.IParser {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object parse(byte[] r4) {
        GetParsedRruleTextResponse r5 = (GetParsedRruleTextResponse) GetParsedRruleTextResponse.ADAPTER.decode(r4);
        return new String[]{r5.parsed_rrule, r5.freq_part, r5.until_part};
    }
}
