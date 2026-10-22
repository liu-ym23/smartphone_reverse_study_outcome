package com.obric.memorydata.utils;

import android.telephony.PhoneNumberUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tJ,\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/utils/FormatPhoneNumberUtil;", "", "<init>", "()V", "BLANK_REGEX", "", "format", "originNumber", "parseTelephoneStandardMap", "", "Lcom/obric/memorydata/utils/TelephoneStandardValue;", "telephoneStandardMapString", "telephoneStandardMapToString", "telephoneStandardMap", "formatForUI", LocationMonitorConst.TAG, "formatForStorage", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f13260a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001¨\u0006\u0005"}, d2 = {"com/obric/memorydata/utils/FormatPhoneNumberUtil$parseTelephoneStandardMap$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/obric/memorydata/utils/TelephoneStandardValue;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends au>> {
        a() {
        }
    }

    static {
        f13260a = new t();
    }

    private t() {
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "originNumber");
        if (r2.length() > 1) goto L5;
        return r2;
    L5:
        String r1 = PhoneNumberUtils.formatNumber(r2, Locale.getDefault().getCountry());
        if (r1 != null) goto L9;
        return r2;
    L9:
        return r1;
    }

    public final String a(String r7, String r8, Map<String, au> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "originNumber");
        Intrinsics.checkNotNullParameter(r10, "telephoneStandardMap");
        Iterator r11 = r10.entrySet().iterator();
    L3:
        boolean r2 = true;
        if (r11.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(((au) ZeusTransformUtils.preCheckCast(r0.getValue(), au.class, "com.obric.memorydata.plugin")).a(), r7) == false) goto L3;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0.getKey(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L11;
        r2 = false;
    L11:
        if (r2 == false) goto L3;
        if (Intrinsics.areEqual(((au) ZeusTransformUtils.preCheckCast(r0.getValue(), au.class, "com.obric.memorydata.plugin")).b(), r8) == false) goto L3;
        return (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
    L16:
        String r6 = a(r7);
        if (StringsKt.startsWith$default(r6, "+86", false, 2, null) == true) goto L19;
        return r6;
    L19:
        if (r6.length() > 3) goto L21;
        return r6;
    L21:
        if (StringsKt.equals("CN", Locale.getDefault().getCountry(), true) == false) goto L34;
        String r12 = r6.substring(3);
        Intrinsics.checkNotNullExpressionValue(r12, "substring(...)");
        return r12;
    L34:
        return r6;
    }

    public final String a(Map<String, au> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "telephoneStandardMap");
        if (r1.isEmpty() == false) goto L7;
        return "";
    L7:
        return u.a(r1);
    }

    public final Map<String, au> b(String r8) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == true) goto L11;
        Object r10 = GsonUtil.INSTANCE.getGSON().fromJson(r8, new a().getType());     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r10, "fromJson(...)");     // Catch: Exception -> L14
        return (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");
    L14:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "parseTelephoneStandardMap " + r8 + " error :" + e, null, 4, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L18;
        throw e;
    L18:
        return MapsKt.emptyMap();
    L11:
        return MapsKt.emptyMap();
    L5:
        if (r7.length() == 0) goto L8;
        r9 = false;
        goto L9
    }

    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "originNumber");
        String r1 = PhoneNumberUtils.formatNumberToE164(r2, Locale.getDefault().getCountry());
        if (r1 == null) goto L6;
        r2 = r1;
    L6:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return new Regex("\\s").replace(r3, "");
    }
}
