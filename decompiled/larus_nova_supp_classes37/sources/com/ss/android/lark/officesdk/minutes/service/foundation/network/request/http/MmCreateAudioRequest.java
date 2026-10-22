package com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.MmMinutesCreateSource;
import com.ss.android.lark.pb.graph.PullClosestChattersRequest;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.e0;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmCreateAudioRequest implements gvb.a {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;
    public final CreateMinutesStatus f;
    public final DoubaoBizInfo g;
    public final MmRecordingSource h;
    public final String i;
    public final a j;
    public final boolean k;
    public final String l;
    public final MmHttpMethod m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/http/MmCreateAudioRequest$CreateMinutesStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "RealTimeCompleteRecording", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum CreateMinutesStatus extends Enum<CreateMinutesStatus> {
        public static final CreateMinutesStatus RealTimeCompleteRecording = null;
        public static final CreateMinutesStatus Unknown = null;
        public static final /* synthetic */ CreateMinutesStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<CreateMinutesStatus> getEntries() {
            return b;
        }

        static {
            CreateMinutesStatus r0 = new CreateMinutesStatus("Unknown", 0, 0);
            Unknown = r0;
            CreateMinutesStatus r1 = new CreateMinutesStatus("RealTimeCompleteRecording", 1, 1);
            RealTimeCompleteRecording = r1;
            CreateMinutesStatus[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static CreateMinutesStatus[] values() {
            return (CreateMinutesStatus[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CreateMinutesStatus valueOf(String r1) {
            return (CreateMinutesStatus) r27.a.a(CreateMinutesStatus.class, r1);
        }

        public CreateMinutesStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/http/MmCreateAudioRequest$RecordingHardwareType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MEMPOPE", "HEADSET", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum RecordingHardwareType extends Enum<RecordingHardwareType> {
        public static final RecordingHardwareType HEADSET = null;
        public static final RecordingHardwareType MEMPOPE = null;
        public static final RecordingHardwareType UNKNOWN = null;
        public static final /* synthetic */ RecordingHardwareType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<RecordingHardwareType> getEntries() {
            return b;
        }

        static {
            RecordingHardwareType r0 = new RecordingHardwareType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            RecordingHardwareType r1 = new RecordingHardwareType("MEMPOPE", 1, 1);
            MEMPOPE = r1;
            RecordingHardwareType r3 = new RecordingHardwareType("HEADSET", 2, 2);
            HEADSET = r3;
            RecordingHardwareType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static RecordingHardwareType[] values() {
            return (RecordingHardwareType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RecordingHardwareType valueOf(String r1) {
            return (RecordingHardwareType) r27.a.a(RecordingHardwareType.class, r1);
        }

        public RecordingHardwareType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/http/MmCreateAudioRequest$RecordingSourceApp;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "LARK", "DOUBAO", "DOUBAO_RECORDER", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum RecordingSourceApp extends Enum<RecordingSourceApp> {
        public static final RecordingSourceApp DOUBAO = null;
        public static final RecordingSourceApp DOUBAO_RECORDER = null;
        public static final RecordingSourceApp LARK = null;
        public static final RecordingSourceApp UNKNOWN = null;
        public static final /* synthetic */ RecordingSourceApp[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<RecordingSourceApp> getEntries() {
            return b;
        }

        static {
            RecordingSourceApp r0 = new RecordingSourceApp("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            RecordingSourceApp r1 = new RecordingSourceApp("LARK", 1, 1);
            LARK = r1;
            RecordingSourceApp r3 = new RecordingSourceApp("DOUBAO", 2, 2);
            DOUBAO = r3;
            RecordingSourceApp r5 = new RecordingSourceApp("DOUBAO_RECORDER", 3, 3);
            DOUBAO_RECORDER = r5;
            RecordingSourceApp[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static RecordingSourceApp[] values() {
            return (RecordingSourceApp[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RecordingSourceApp valueOf(String r1) {
            return (RecordingSourceApp) r27.a.a(RecordingSourceApp.class, r1);
        }

        public RecordingSourceApp(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/http/MmCreateAudioRequest$RecordingSourceModule;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "LARK_DOUBAO_ENTERPRISE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum RecordingSourceModule extends Enum<RecordingSourceModule> {
        public static final RecordingSourceModule DEFAULT = null;
        public static final RecordingSourceModule LARK_DOUBAO_ENTERPRISE = null;
        public static final /* synthetic */ RecordingSourceModule[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<RecordingSourceModule> getEntries() {
            return b;
        }

        static {
            RecordingSourceModule r0 = new RecordingSourceModule("DEFAULT", 0, 0);
            DEFAULT = r0;
            RecordingSourceModule r1 = new RecordingSourceModule("LARK_DOUBAO_ENTERPRISE", 1, 1);
            LARK_DOUBAO_ENTERPRISE = r1;
            RecordingSourceModule[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static RecordingSourceModule[] values() {
            return (RecordingSourceModule[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RecordingSourceModule valueOf(String r1) {
            return (RecordingSourceModule) r27.a.a(RecordingSourceModule.class, r1);
        }

        public RecordingSourceModule(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public final RecordingSourceApp a;
        public final RecordingHardwareType b;
        public final String c;
        public final RecordingSourceModule d;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r0 = 0 == true ? 1 : 0;
            Object[] r1 = 0 == true ? 1 : 0;
            this(null, r0, r1, 15);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            RecordingSourceApp r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            RecordingHardwareType r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
            RecordingSourceModule r7 = this.d;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "RecordingCreateSource(sourceApp=" + this.a + ", hardwareType=" + this.b + ", hardwareModel=" + this.c + ", sourceModule=" + this.d + ')';
        }

        public /* synthetic */ a(RecordingSourceApp r3, RecordingHardwareType r4, RecordingSourceModule r5, int r6) {
            if ((r6 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 4) == 0) goto L11;
            String r0 = "";
        L13:
            if ((r6 & 8) == 0) goto L15;
            r5 = null;
        L15:
            this(r3, r4, r0, r5);
            return;
        L11:
            r0 = null;
            goto L13
        }

        public a(RecordingSourceApp r2, RecordingHardwareType r3, String r4, RecordingSourceModule r5) {
            Intrinsics.checkNotNullParameter(r4, "hardwareModel");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.FEISHU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[MmRecordingSource.OBRIC_RECORDER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    @Override // gvb.a
    public final ByteString b() {
        return null;
    }

    @Override // gvb.a
    public final String c() {
        return null;
    }

    @Override // gvb.a
    public final boolean d() {
        return false;
    }

    @Override // gvb.a
    public final Map<String, String> a() {
        return new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gvb.a
    public final Map<String, String> f() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("recording_lang", this.a);
        r0.put("topic", this.c);
        if (this.b.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0.put("meeting_id", this.b);
    L8:
        String r3 = null;
        Object[] r4 = 0;
        Object[] r5 = 0;
        Object[] r6 = 0;
        Object[] r7 = 0;
        Object[] r8 = 0;
        Object[] r9 = 0;
        Object[] r10 = 0;
        Object[] r11 = 0;
        Object[] r12 = 0;
        Object[] r13 = 0;
        if (this.k == false) goto L25;
        String r2 = this.i;
        if ((!StringsKt.isBlank(r2)) == true) goto L14;
        r2 = null;
    L14:
        if (r2 != null) goto L23;
        DoubaoBizInfo r14 = this.g;
        if (r14 == null) goto L22;
        r2 = r14.getRecordingId();
        if (r2 == null) goto L22;
        if ((!StringsKt.isBlank(r2)) == true) goto L23;
    L22:
        r2 = null;
    L23:
        if (r2 == null) goto L25;
        r0.put("recording_id", r2);
    L25:
        Object r15 = PullClosestChattersRequest.DEFAULT_LOCALE_IDENTIFIER;
        r0.put("language", PullClosestChattersRequest.DEFAULT_LOCALE_IDENTIFIER);
        r0.put("is_forced", String.valueOf(this.d));
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L28
        Object r17 = Result.constructor-impl(com.ss.android.lark.officesdk.minutes.service.foundation.utils.a.a());     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r17) == true) goto L34;
        r15 = r17;
    L34:
        r0.put("language", r15);
        CreateMinutesStatus r18 = this.f;
        if (r18 == null) goto L37;
        r0.put("create_minutes_status", String.valueOf(r18.getValue()));
    L37:
        r0.put("segment_duration_second", String.valueOf(this.e));
        MmMinutesCreateSource r19 = ivb.a.a(this.h);
        if (r19 == null) goto L40;
        r0.put("create_source", String.valueOf(r19.getValue()));
    L40:
        MmRecordingSource r20 = this.h;
        if (r20 != null) goto L43;
        int r21 = -1;
    L44:
        int r22 = 12;
        int r23 = 14;
        switch(r21) {
            case -1: goto L55;
            case 0: goto L47;
            case 1: goto L54;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L51;
            case 7: goto L50;
            case 8: goto L50;
            case 9: goto L50;
            case 10: goto L50;
            case 11: goto L49;
            case 12: goto L48;
            default: goto L47;
        };
    L48:
        a r24 = new a(RecordingSourceApp.DOUBAO_RECORDER, r13 == true ? 1 : 0, r12 == true ? 1 : 0, r23);
    L56:
        if (r24 == null) goto L75;
        a r25 = this.j;
        if (r25 == null) goto L75;
        Intrinsics.checkNotNullParameter(r25, "explicitSource");
        RecordingSourceApp r26 = r25.a;
        if (r26 != null) goto L62;
        r26 = r24.a;
    L62:
        RecordingHardwareType r27 = r25.b;
        if (r27 != null) goto L65;
        r27 = r24.b;
    L65:
        String r28 = r25.c;
        if ((!StringsKt.isBlank(r28)) == true) goto L69;
        r28 = null;
    L69:
        if (r28 != null) goto L71;
        r28 = r24.c;
    L71:
        RecordingSourceModule r29 = r25.d;
        if (r29 != null) goto L74;
        r29 = r24.d;
    L74:
        r24 = new a(r26, r27, r28, r29);
    L78:
        if (r24 == null) goto L93;
        RecordingSourceApp r30 = r24.a;
        if (r30 == null) goto L82;
        r0.put("source_app", String.valueOf(r30.getValue()));
    L82:
        RecordingHardwareType r31 = r24.b;
        if (r31 == null) goto L85;
        r0.put("hardware_type", String.valueOf(r31.getValue()));
    L85:
        String r32 = r24.c;
        if ((true ^ StringsKt.isBlank(r32)) == false) goto L88;
        r3 = r32;
    L88:
        if (r3 == null) goto L90;
        r0.put("hardware_model", r3);
    L90:
        RecordingSourceModule r33 = r24.d;
        if (r33 == null) goto L93;
        r0.put("source_module", String.valueOf(r33.getValue()));
    L93:
        DoubaoBizInfo r34 = this.g;
        if (r34 == null) goto L99;
        String r35 = e0.c(r34);
        if (r35 != null) goto L98;
        r35 = "";
    L98:
        r0.put("doubao_biz_info", r35);
    L99:
        return r0;
    L75:
        a r36 = this.j;
        if (r36 == null) goto L78;
        r24 = r36;
        goto L78
    L49:
        r24 = new a(RecordingSourceApp.DOUBAO, RecordingHardwareType.HEADSET, r11 == true ? 1 : 0, r22);
        goto L56
    L50:
        r24 = new a(RecordingSourceApp.DOUBAO, r10 == true ? 1 : 0, r9 == true ? 1 : 0, r23);
        goto L56
    L51:
        r24 = new a(RecordingSourceApp.LARK, RecordingHardwareType.MEMPOPE, r8 == true ? 1 : 0, r22);
        goto L56
    L52:
        r24 = new a(RecordingSourceApp.LARK, RecordingHardwareType.MEMPOPE, r7 == true ? 1 : 0, r22);
        goto L56
    L53:
        r24 = new a(RecordingSourceApp.LARK, r6 == true ? 1 : 0, RecordingSourceModule.LARK_DOUBAO_ENTERPRISE, 6);
        goto L56
    L54:
        r24 = new a(RecordingSourceApp.LARK, r5 == true ? 1 : 0, r4 == true ? 1 : 0, r23);
        goto L56
    L55:
        r24 = null;
        goto L56
    L47:
        throw new NoWhenBranchMatchedException();
    L43:
        r21 = b.a[r20.ordinal()];
    L28:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L5:
        r1 = false;
        goto L6
    }

    @Override // gvb.a
    public final Map<String, String> e() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final MmRecordingSource getClientSource() {
        return this.h;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.m;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.l;
    }

    public MmCreateAudioRequest(String r3, String r4, int r5, CreateMinutesStatus r6, DoubaoBizInfo r7, MmRecordingSource r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter("", "recordingLanguage");
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r9, "recordingId");
        this.a = "";
        this.b = r3;
        this.c = r4;
        this.d = true;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = null;
        this.k = r10;
        Lazy r11 = MmNetworkReqPath.a;
        if (r10 == false) goto L5;
        String r12 = MmNetworkReqPath.b(r8) + "create";
    L6:
        this.l = r12;
        this.m = MmHttpMethod.POST;
        return;
    L5:
        r12 = MmNetworkReqPath.a(r8) + "audio/create";
        goto L6
    }
}
