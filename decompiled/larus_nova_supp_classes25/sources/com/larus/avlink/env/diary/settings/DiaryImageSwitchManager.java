package com.larus.avlink.env.diary.settings;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DiaryImageSwitchManager {
    public static final DiaryImageSwitchManager a = null;
    public static volatile Boolean b;
    public static volatile boolean c;
    public static final List<Function1<Boolean, Unit>> d = null;
    public static final Lazy e = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/larus/avlink/env/diary/settings/DiaryImageSwitchManager$DiaryDeviceInfoResponse;", "", "info", "", "", "<init>", "(Ljava/util/Map;)V", "getInfo", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a {

        @SerializedName("info")
        private final Map<String, Object> info;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.info, ((a) r4).info) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Map<String, Object> r0 = this.info;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "DiaryDeviceInfoResponse(info=" + this.info + ')';
        }

        public a() {
            this.info = null;
        }

        public final Map<String, Object> a() {
            return this.info;
        }
    }

    public DiaryImageSwitchManager() {
    }

    static {
        a = new DiaryImageSwitchManager();
        d = new ArrayList();
        e = LazyKt.lazy(new com.larus.avlink.env.diary.settings.a());
    }

    public static void d(boolean r9) {
        b = Boolean.valueOf(r9);
        FLogger.a.i("DiaryImageSwitch", "setInsertPhotoEnabled: " + r9);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DiaryImageSwitchManager$setInsertPhotoEnabled$1(r9, null), 2, null);
    }

    public final void c(Function1<? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        Boolean r0 = b;
        if (r0 == null) goto L6;
        r7.invoke(Boolean.valueOf(r0.booleanValue()));
        return;
    L6:
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (c == false) goto L13;
        ((ArrayList) d).add(r7);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        c = true;     // Catch: Throwable -> L17
        ((ArrayList) d).add(r7);     // Catch: Throwable -> L17
        monitor-exit(this);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DiaryImageSwitchManager$getInsertPhotoEnabled$3(null), 3, null);
    }

    public static final Object a(DiaryImageSwitchManager r14, Continuation r15) {
        r14.getClass();
        if ((r15 instanceof DiaryImageSwitchManager$fetchFromNetwork$1) == false) goto L7;
        DiaryImageSwitchManager$fetchFromNetwork$1 r2 = (DiaryImageSwitchManager$fetchFromNetwork$1) r15;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r16 = r2.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        boolean r5 = false;
        boolean r6 = true;
        String r7 = null;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L59
    L34:
        y r18 = (com.larus.network.http.a) r16;     // Catch: Exception -> L59
        if ((r18 instanceof y) == false) goto L57;
        Long r19 = r18.g;     // Catch: Exception -> L59
        if (r19 == null) goto L57;
        if (r19.longValue() != 0) goto L57;
        a r110 = (a) ((com.larus.network.http.a) r18).b;     // Catch: Exception -> L59
        if (r110 == null) goto L44;
        Map<String, Object> r111 = r110.a();     // Catch: Exception -> L59
    L45:
        if (r111 == null) goto L50;
        Object r112 = r111.get("diary_image_switch");     // Catch: Exception -> L59
        if (r112 == null) goto L50;
        r7 = r112.toString();     // Catch: Exception -> L59
    L50:
        if (Intrinsics.areEqual(r7, "0") == true) goto L52;
        boolean r113 = true;
    L53:
        FLogger r114 = FLogger.a;     // Catch: Exception -> L59
        StringBuilder r1 = new StringBuilder("fetchFromNetwork success, value=");     // Catch: Exception -> L59
        r1.append(r7);     // Catch: Exception -> L59
        r1.append(", enabled=");     // Catch: Exception -> L59
        if (r113 == false) goto L56;
        r5 = true;
    L56:
        r1.append(r5);     // Catch: Exception -> L59
        r114.i("DiaryImageSwitch", r1.toString());     // Catch: Exception -> L59
        r6 = r113;
    L62:
        return Boxing.boxBoolean(r6);
    L52:
        r113 = false;
        goto L53
    L44:
        r111 = null;
    L57:
        FLogger.a.e("DiaryImageSwitch", "fetchFromNetwork failed, response=" + r18);     // Catch: Exception -> L59
        goto L62
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        IDoraService r115 = (IDoraService) e.getValue();     // Catch: Exception -> L59
        if (r115 == null) goto L19;
        DeviceService r116 = r115.device();     // Catch: Exception -> L59
    L20:
        if (r116 == null) goto L22;
        String r8 = r116.m();     // Catch: Exception -> L59
    L23:
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == false) goto L31;
        FLogger.a.w("DiaryImageSwitch", "fetchFromNetwork: device sn is empty, use default value");     // Catch: Exception -> L59
        return Boxing.boxBoolean(true);
    L31:
        int r117 = r116.y();     // Catch: Exception -> L59
        com.larus.dora.api.network.a r10 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L59
        Map r118 = MapsKt.mapOf(new Pair[]{TuplesKt.to("w_did", r8), TuplesKt.to("product_id", String.valueOf(r117)), TuplesKt.to("keys", "diary_image_switch")});     // Catch: Exception -> L59
        r2.label = 1;     // Catch: Exception -> L59
        r16 = com.larus.dora.api.network.a.b(r10, a.class, "/alice/w/device/info", r118, r2);     // Catch: Exception -> L59
        if (r16 != r17) goto L34;
        return r17;
    L25:
        if (r8.length() == 0) goto L28;
        r9 = false;
        goto L29
    L22:
        r8 = null;
        goto L23
    L19:
        r116 = null;
    L59:
        e = move-exception;
        FLogger.a.e("DiaryImageSwitch", "fetchFromNetwork error", e);
    L7:
        r2 = new DiaryImageSwitchManager$fetchFromNetwork$1(r14, r15);
        goto L8
    }

    public static final Object b(DiaryImageSwitchManager r13, boolean r14, Continuation r15) {
        r13.getClass();
        if ((r15 instanceof DiaryImageSwitchManager$syncToNetwork$1) == false) goto L7;
        DiaryImageSwitchManager$syncToNetwork$1 r2 = (DiaryImageSwitchManager$syncToNetwork$1) r15;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DiaryImageSwitchManager$syncToNetwork$1 r8 = r2;
        Object r16 = r8.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r8.label;
        boolean r10 = false;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        r14 = r8.Z$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L51
    L38:
        y r18 = (com.larus.network.http.a) r16;     // Catch: Exception -> L51
        if ((r18 instanceof y) == false) goto L49;
        Long r19 = r18.g;     // Catch: Exception -> L51
        if (r19 == null) goto L49;
        if (r19.longValue() != 0) goto L49;
        FLogger r110 = FLogger.a;     // Catch: Exception -> L51
        StringBuilder r111 = new StringBuilder("syncToNetwork success, enabled=");     // Catch: Exception -> L51
        if (r14 == false) goto L48;
        r10 = true;
    L48:
        r111.append(r10);     // Catch: Exception -> L51
        r110.i("DiaryImageSwitch", r111.toString());     // Catch: Exception -> L51
    L54:
        return Unit.INSTANCE;
    L49:
        FLogger.a.e("DiaryImageSwitch", "syncToNetwork failed, response=" + r18);     // Catch: Exception -> L51
        goto L54
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        IDoraService r112 = (IDoraService) e.getValue();     // Catch: Exception -> L51
        String r5 = null;
        if (r112 == null) goto L20;
        DeviceService r113 = r112.device();     // Catch: Exception -> L51
    L21:
        if (r113 == null) goto L23;
        r5 = r113.m();     // Catch: Exception -> L51
    L23:
        if (r5 != null) goto L25;
    L28:
        boolean r6 = true;
    L29:
        if (r6 == false) goto L31;
        FLogger.a.w("DiaryImageSwitch", "syncToNetwork: device sn is empty, skip sync");     // Catch: Exception -> L51
        return Unit.INSTANCE;
    L31:
        int r114 = r113.y();     // Catch: Exception -> L51
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L51
        r7.put("w_did", r5);     // Catch: Exception -> L51
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L51
        if (r14 == false) goto L34;
        String r11 = "1";
    L35:
        r9.put("diary_image_switch", r11);     // Catch: Exception -> L51
        Unit r12 = Unit.INSTANCE;     // Catch: Exception -> L51
        r7.put("info", r9);     // Catch: Exception -> L51
        r7.put("product_id", String.valueOf(r114));     // Catch: Exception -> L51
        r7.put("uid", AccountService.a.getUserId());     // Catch: Exception -> L51
        com.larus.dora.api.network.a r20 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L51
        r8.Z$0 = r14;     // Catch: Exception -> L51
        r8.label = 1;     // Catch: Exception -> L51
        r16 = com.larus.dora.api.network.a.c(r20, Object.class, "/alice/w/device/sync_info", r7, null, r8, 248);     // Catch: Exception -> L51
        if (r16 != r17) goto L38;
        return r17;
    L34:
        r11 = "0";
        goto L35
    L25:
        if (r5.length() == 0) goto L28;
        r6 = false;
        goto L29
    L20:
        r113 = null;
    L51:
        e = move-exception;
        FLogger.a.e("DiaryImageSwitch", "syncToNetwork error", e);
    L7:
        r2 = new DiaryImageSwitchManager$syncToNetwork$1(r13, r15);
        goto L8
    }
}
