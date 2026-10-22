package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.e;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import com.ss.android.lark.utils.UIHelper;
import eub.d;
import eub.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static f a(String r22, String r23, String r24, long r25, long r27, long r29) {
        String r0 = r23;
        Intrinsics.checkNotNullParameter(r22, "sessionKey");
        Intrinsics.checkNotNullParameter(r0, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r24, "audioPath");
        String r3 = StringsKt.replace$default(StringsKt.replace$default("d1204-offline-upload-" + r22, ":", "", false, 4, null), "_", "-", false, 4, null);
        MmRecordingSource r16 = MmRecordingSource.FEISHU_HARDWARE_D1204;
        String r5 = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(new Date(r27));
        int r8 = e.a;
        List r6 = CollectionsKt.listOf(new d(r24, null, UIHelper.getString(2131893781) + '_' + r5 + ".ogg", r25, RangesKt.coerceAtLeast(r29 - r27, 1000), 1, 2));
        String r7 = String.valueOf(r27);
        String r9 = String.valueOf(r29);
        String r10 = String.valueOf(TimeZone.getDefault().getOffset(r27) / 3600000);
        Pair[] r1 = new Pair[8];
        r1[0] = TuplesKt.to("hardware_file_ids", r22);
        if (StringsKt.isBlank(r23) == false) goto L5;
    L8:
        r1[1] = TuplesKt.to("hardware_device_ids", r0);
        r1[2] = TuplesKt.to("file_unique_id_list", r22);
        r1[3] = TuplesKt.to("offline_line_index", UserInfo.NONE_NAME_CARD_ID);
        r1[4] = TuplesKt.to("record_index", UserInfo.NONE_NAME_CARD_ID);
        r1[5] = TuplesKt.to("is_last_record", "true");
        r1[6] = TuplesKt.to("offline_local_recording", "true");
        r1[7] = TuplesKt.to("transfer_type", "offline");
        return new f(r3, r16, r6, r22, r7, r9, r10, MapsKt.mapOf(r1), null, 256);
    L5:
        if (StringsKt.startsWith$default(r0, "anker_d1204_", false, 2, null) == true) goto L8;
        r0 = "anker_d1204_" + r0;
        goto L8
    }
}
