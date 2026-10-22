package com.obric.assistant.card.utils;

import android.os.SystemClock;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AppEntityEx {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/utils/AppEntityEx$QueryEntityKey;", NameKeys.UnloadStrategy_No_Strategy, "packageName", NameKeys.UnloadStrategy_No_Strategy, "type", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getType", "getId", "isValid", NameKeys.UnloadStrategy_No_Strategy, "component1", "component2", "component3", "copy", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("id")
        private final String id;

        @SerializedName("packageName")
        private final String packageName;

        @SerializedName("type")
        private final String type;

        public a() {
            this(null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.packageName;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.type;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.id;
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
            return "QueryEntityKey(packageName=" + this.packageName + ", type=" + this.type + ", id=" + this.id + ')';
        }

        public final boolean c() {
            if (o0.d(this.packageName) == true) goto L5;
        L9:
            return false;
        L5:
            if (o0.d(this.type) == false) goto L9;
            if (o0.d(this.id) == false) goto L9;
            return true;
        }

        public final String a() {
            return this.id;
        }

        public final String b() {
            return this.packageName;
        }

        public final String getType() {
            return this.type;
        }

        public a(String r1, String r2, String r3) {
            this.packageName = r1;
            this.type = r2;
            this.id = r3;
        }
    }

    static {
    }

    public AppEntityEx() {
    }

    public static final List a(Map r6) {
        long r0 = SystemClock.elapsedRealtime();
        IAgentAppIntentIDL r2 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r2 == null) goto L5;
        List r7 = r2.getAppEntityList(r6);
    L6:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("getAppEntityList used time ");
        r4.append(SystemClock.elapsedRealtime() - r0);
        r4.append(" ms, size = ");
        if (r7 == null) goto L9;
        int r1 = r7.size();
    L10:
        r4.append(r1);
        r3.i("AppEntityEx", r4.toString());
        return r7;
    L9:
        r1 = 0;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    public static void c(a r7) {
        Intrinsics.checkNotNullParameter(r7, "key");
        FLogger r0 = FLogger.a;
        r0.i("AppEntityEx", "showEntity: key = " + r7);
        if (r7.c() == true) goto L6;
        r0.w("AppEntityEx", "showEntity: param is invalid");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppEntityEx$showEntity$1(r7, null), 3, null);
    }

    public static Object b(List r6, Continuation r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = r6.iterator();
    L4:
        if (r1.hasNext() == false) goto L23;
        a r2 = (a) r1.next();
        if (r2.c() == true) goto L7;
        FLogger.a.w("AppEntityEx", "getAppEntityList: is not valid " + r2);
        goto L4
    L7:
        StringBuilder r3 = new StringBuilder();
        String r4 = r2.getType();
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
        if (r4 != null) goto L10;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        r3.append(r4);
        r3.append('&');
        String r8 = r2.b();
        if (r8 != null) goto L13;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        r3.append(r8);
        String r9 = r3.toString();
        Object r10 = r0.get(r9);
        if (r10 != null) goto L16;
        r10 = new ArrayList();
        r0.put(r9, r10);
    L16:
        List r11 = (List) r10;
        String r12 = r2.a();
        if (r12 == null) goto L20;
        r5 = r12;
    L20:
        Boxing.boxBoolean(r11.add(r5));
        goto L4
    L23:
        return BuildersKt.withContext(Dispatchers.getIO(), new AppEntityEx$getAppEntityList$3(r6, r0, null), r7);
    }
}
