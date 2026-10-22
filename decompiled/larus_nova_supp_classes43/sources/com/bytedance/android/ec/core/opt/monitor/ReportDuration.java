package com.bytedance.android.ec.core.opt.monitor;

import com.bytedance.android.ec.monitor.duration.g;
import com.bytedance.android.ec.monitor.duration.i;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/opt/monitor/ReportDuration;", "Lcom/bytedance/android/ec/monitor/duration/g;", "", "business", "Lorg/json/JSONObject;", "data", "", "onReport", "<init>", "()V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReportDuration implements g {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private ReportDuration() {
    }

    @JvmStatic
    public static final void register() {
        Companion.getClass();
        i.a.a(new ReportDuration(null));
    }

    public /* synthetic */ ReportDuration(DefaultConstructorMarker r1) {
        this();
    }

    public void onReport(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "business");
        Intrinsics.checkNotNullParameter(r11, "data");
        com.bytedance.android.ec.sdk.helper.g.a.logV3(r10, r11);
    }
}
