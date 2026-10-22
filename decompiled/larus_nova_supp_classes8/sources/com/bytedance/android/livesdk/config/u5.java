package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.crash.SourceType;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/u5;", "", "", "", "needChangeUiLayout", "Ljava/util/List;", "a", "()Ljava/util/List;", "setNeedChangeUiLayout", "(Ljava/util/List;)V", "", "", "targetFunctionType", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setTargetFunctionType", "(Ljava/util/Map;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u5 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("need_change_uilayout")
    private List<Integer> needChangeUiLayout;

    @SerializedName("target_function_type")
    private Map<String, String> targetFunctionType;

    public static final class a {
        public static u5 a() {
            ArrayList r0 = CollectionsKt.arrayListOf(new Integer[]{0, 1, 2, 5, 7, 21, 22});
            u5 r1 = new u5();
            List<Integer> r2 = r1.a();
            if (r2 == null) goto L5;
            r2.addAll(r0);
        L5:
            Map<String, String> r3 = r1.b();
            if (r3 == null) goto L8;
            r3.put("8_*", "radio");
        L8:
            Map<String, String> r4 = r1.b();
            if (r4 == null) goto L11;
            r4.put("12_*", "party");
        L11:
            Map<String, String> r5 = r1.b();
            if (r5 == null) goto L14;
            r5.put("13_*", "ktv");
        L14:
            Map<String, String> r6 = r1.b();
            if (r6 == null) goto L17;
            r6.put("5_21", "radio");
        L17:
            Map<String, String> r7 = r1.b();
            if (r7 == null) goto L20;
            r7.put("5_22", "party");
        L20:
            Map<String, String> r8 = r1.b();
            if (r8 == null) goto L23;
            r8.put("9_*", "ktv");
        L23:
            Map<String, String> r9 = r1.b();
            if (r9 == null) goto L26;
            r9.put("4_*", SourceType.DEFAULT);
        L26:
            return r1;
        }
    }

    static {
    }

    public u5() {
        this.needChangeUiLayout = new ArrayList();
        this.targetFunctionType = new HashMap();
    }

    public final List<Integer> a() {
        return this.needChangeUiLayout;
    }

    public final Map<String, String> b() {
        return this.targetFunctionType;
    }
}
