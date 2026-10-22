package com.larus.voicecall.impl.utils;

import com.larus.utils.o0;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeMobUtil {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/voicecall/impl/utils/RealtimeMobUtil$Business;", NameKeys.UnloadStrategy_No_Strategy, "businessTag", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBusinessTag", "()Ljava/lang/String;", "realtime", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Business extends Enum<Business> {
        public static final /* synthetic */ Business[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        public static final Business realtime = null;
        private final String businessTag;

        public static EnumEntries<Business> getEntries() {
            return b;
        }

        static {
            Business r0 = new Business();
            realtime = r0;
            Business[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public Business() {
            super("realtime", 0);
            this.businessTag = "realtime_call";
        }

        public static Business[] values() {
            return (Business[]) a.clone();
        }

        public final String getBusinessTag() {
            return this.businessTag;
        }

        public static Business valueOf(String r1) {
            return (Business) r27.a.a(Business.class, r1);
        }
    }

    static {
    }

    public static void b(String r10, String r11, String r12, String r13) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new RealtimeMobUtil$mobRealtimeCallRouterStart$1(r10, r11, r12, r13, null), 2, null);
    }

    public static void a(String r12, String r13, String r14, String r15, boolean r16, String r17) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new RealtimeMobUtil$mobRealtimeCallRouterEnd$1(r12, r13, r14, r15, r16, r17, null), 2, null);
    }

    public static void c(Business r3, long r4, boolean r6, List r7, String r8, Map r9) {
        Intrinsics.checkNotNullParameter(r3, "business");
        Intrinsics.checkNotNullParameter(r7, "picKeyList");
        Intrinsics.checkNotNullParameter(r9, "extra");
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r2 = new JSONObject();
        r2.put("business", r3.getBusinessTag());
        r2.put("duration_ms", r4);
        r2.put("is_success", r6 ? 1 : 0);
        r2.put("pic_key_list", r7);
        r2.put("pic_num", 1);
        if (o0.d(r8) == false) goto L5;
        r2.put("err_msg", r8);
    L5:
        Iterator r5 = r9.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r10 = (Map.Entry) r5.next();
        r2.put((String) r10.getKey(), r10.getValue());
        goto L7
    L9:
        Unit r11 = Unit.INSTANCE;
        r1.reportEvent("upload_photo_result", r2);
    }
}
