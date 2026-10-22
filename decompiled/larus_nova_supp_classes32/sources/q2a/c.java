package q2a;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.audio.bean.VoiceListTabInfo;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final c a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static volatile Map<String, ? extends List<VoiceListTabInfo>> d;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001¨\u0006\u0006"}, d2 = {"com/larus/voice_setting/voice/base/api/GetVoiceTabRepo$loadVoiceListTabInfoFromKeva$data$1$1", "Lcom/google/gson/reflect/TypeToken;", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/audio/bean/VoiceListTabInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends List<? extends VoiceListTabInfo>>> {
        public a() {
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new q2a.a());
        c = LazyKt.lazy(new b());
    }

    public static Map a() {
        Object r0 = NameKeys.UnloadStrategy_No_Strategy;
        Map<String, ? extends List<VoiceListTabInfo>> r1 = d;
        if (r1 == null) goto L40;
        return r1;
    L40:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        a.getClass();     // Catch: Throwable -> L10
        String r3 = ((Keva) b.getValue()).getString("key_voice_list_tab_info", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L16;
        FLogger.a.e("GetVoiceTabRepo", "[loadVoiceListTabInfoFromKeva] read voice tab from keva failed", r5);
    L16:
        if (Result.isFailure-impl(r4) == true) goto L19;
        r0 = r4;
    L19:
        String r6 = (String) r0;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("[loadVoiceListTabInfoFromKeva]: invoke sync dataStr isNotEmpty(");
        boolean r9 = false;
        if (r6.length() <= 0) goto L22;
        boolean r10 = true;
    L23:
        r8.append(r10);
        r8.append(')');
        r7.i("GetVoiceTabRepo", r8.toString());
        if (r6.length() <= 0) goto L26;
        r9 = true;
    L26:
        if (r9 == false) goto L39;
        a.getClass();     // Catch: Throwable -> L29
        Object r11 = Result.constructor-impl((Map) ((Gson) c.getValue()).fromJson(r6, new a().getType()));     // Catch: Throwable -> L29
    L31:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L35;
        FLogger.a.e("GetVoiceTabRepo", "[loadVoiceListTabInfoFromKeva] load voice tab from keva failed", r12);
    L35:
        if (Result.isFailure-impl(r11) == false) goto L37;
        r11 = null;
    L37:
        d = (Map) r11;
    L29:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        return d;
    L22:
        r10 = false;
    L10:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
